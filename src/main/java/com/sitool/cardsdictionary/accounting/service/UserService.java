package com.sitool.cardsdictionary.accounting.service;

import com.sitool.cardsdictionary.accounting.dto.AddUserDto;
import com.sitool.cardsdictionary.accounting.dto.RoleDto;
import com.sitool.cardsdictionary.accounting.dto.UpdateUserDto;
import com.sitool.cardsdictionary.accounting.dto.UserDto;

public interface UserService {
    UserDto registerNewUser(AddUserDto addUserDto);

    UserDto deleteUser(String login);

    UserDto updateUser(String login, UpdateUserDto updateUserDto);

    RoleDto changeRollList(String login, String role, boolean isAddRole);

    UserDto getUserByLogin(String login);

    void changePassword(String login, String newPassword);
}
