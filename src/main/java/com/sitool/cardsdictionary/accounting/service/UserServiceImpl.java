package com.sitool.cardsdictionary.accounting.service;

import com.sitool.cardsdictionary.accounting.dao.RoleRepository;
import com.sitool.cardsdictionary.accounting.dao.UserRepository;
import com.sitool.cardsdictionary.accounting.dto.AddUserDto;
import com.sitool.cardsdictionary.accounting.dto.RoleDto;
import com.sitool.cardsdictionary.accounting.dto.UpdateUserDto;
import com.sitool.cardsdictionary.accounting.dto.UserDto;
import com.sitool.cardsdictionary.accounting.dto.exceptions.InvalidDataException;
import com.sitool.cardsdictionary.accounting.dto.exceptions.RoleNotFoundException;
import com.sitool.cardsdictionary.accounting.dto.exceptions.UserExistsException;
import com.sitool.cardsdictionary.accounting.dto.exceptions.UserNotFoundException;
import com.sitool.cardsdictionary.accounting.model.Role;
import com.sitool.cardsdictionary.accounting.model.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserDto registerNewUser(AddUserDto addUserDto) {
        if (userRepository.existsByLogin(addUserDto.getLogin())) {
            throw new UserExistsException();
        }
        User newUser = modelMapper.map(addUserDto, User.class);
        if (!roleRepository.existsByRoleName("user")) {
            Role adminRole = new Role("user");
            roleRepository.save(adminRole);
        }
        Role userRole = roleRepository.findByRoleName("user").orElseThrow(RoleNotFoundException::new);
        newUser.addRole(userRole);
        String encodedPassword = passwordEncoder.encode(addUserDto.getPassword());
        newUser.setPassword(encodedPassword);
        userRepository.save(newUser);
        return modelMapper.map(newUser, UserDto.class);

    }

    @Override
    public UserDto deleteUser(String login) {
        User user = userRepository.findByLogin(login).orElseThrow(UserNotFoundException::new);
        userRepository.delete(user);
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    @Transactional
    public UserDto updateUser(String login, UpdateUserDto updateUserDto) {
        User user = userRepository.findByLogin(login).orElseThrow(UserNotFoundException::new);
        if (updateUserDto.getFirstName() != null) {
            user.setFirstName(updateUserDto.getFirstName());
        }

        if (updateUserDto.getLastName() != null) {
            user.setLastName(updateUserDto.getLastName());
        }
        userRepository.save(user);
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    @Transactional
    public RoleDto changeRollList(String login, String role, boolean isAddRole) {
        User user = userRepository.findByLogin(login).orElseThrow(UserNotFoundException::new);

        Role userRole = roleRepository.findByRoleName(role).orElseThrow(RoleNotFoundException::new);
        try {
            if (isAddRole) {
                user.addRole(userRole);
            } else {
                user.removeRole(userRole);
            }
        } catch (Exception e) {
            throw new InvalidDataException();
        }
        userRepository.save(user);
        return modelMapper.map(user, RoleDto.class);
    }

    @Override
    public UserDto getUserByLogin(String login) {
        User user = userRepository.findByLogin(login).orElseThrow(UserNotFoundException::new);
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public void changePassword(String login, String newPassword) {
        User user = userRepository.findByLogin(login).orElseThrow(UserNotFoundException::new);
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if (!roleRepository.existsByRoleName("admin")) {
            Role adminRole = new Role("admin");
            roleRepository.save(adminRole);
        }
        if (!userRepository.existsByLogin("admin@admin.com")) {
            Role userRole = roleRepository.findByRoleName("admin")
                    .orElseThrow(RoleNotFoundException::new);
            User admin = User.builder()
                    .login("admin@admin.com")
                    .password(passwordEncoder.encode("admin"))
                    .firstName("Admin")
                    .lastName("Admin")
                    .build();

            admin.addRole(userRole);
            userRepository.save(admin);
        }
    }
}
