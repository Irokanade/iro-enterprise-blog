package com.iro.service;

import com.iro.model.UserDto;
import com.iro.domain.entity.UserEntity;
import com.iro.domain.repository.UserRepository;
import com.iro.model.UserLoginFormDto;
import com.iro.model.UserSignupFormDto;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserService(PasswordEncoder passwordEncoder,
                       UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Transactional
    public void addUser(UserSignupFormDto userSignupFormDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userSignupFormDto.getUsername());
        userEntity.setEmail(userSignupFormDto.getEmail());
        userEntity.setPasswordHash(passwordEncoder.encode(userSignupFormDto.getPassword()));

        userRepository.save(userEntity);
    }

    public UserDto getUserByUsername(String username) {
        return userRepository.findByUsername(username)
            .map(user -> new UserDto(user.getId(), user.getUsername(), user.getEmail()))
            .orElseThrow(() -> new UsernameNotFoundException(username));
    }

    public UserDto authenticateUser(UserLoginFormDto loginDto) {
        return userRepository.findByUsername(loginDto.getUsername())
            .filter(user -> passwordEncoder.matches(loginDto.getPassword(), user.getPasswordHash()))
            .map(user -> new UserDto(user.getId(), user.getUsername(), user.getEmail()))
            .orElse(null);
    }
}
