package com.sitool.cardsdictionary.accounting.service;

import com.sitool.cardsdictionary.accounting.dao.RoleRepository;
import com.sitool.cardsdictionary.accounting.dao.UserRepository;
import com.sitool.cardsdictionary.accounting.dto.AddUserDto;
import com.sitool.cardsdictionary.accounting.dto.RolesDto;
import com.sitool.cardsdictionary.accounting.dto.UpdateUserDto;
import com.sitool.cardsdictionary.accounting.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserDto registerNewUser(AddUserDto addUserDto) {
        return null;
    }

    @Override
    public UserDto deleteUser(String login) {
        return null;
    }

    @Override
    public UserDto updateUser(String login, UpdateUserDto updateUserDto) {
        return null;
    }

    @Override
    public RolesDto changeRollList(String login, String role, boolean isAddRole) {
        return null;
    }

    @Override
    public UserDto getUserByLogin(String login) {
        return null;
    }

    @Override
    public void changePassword(String login, String newPassword) {

    }
}
