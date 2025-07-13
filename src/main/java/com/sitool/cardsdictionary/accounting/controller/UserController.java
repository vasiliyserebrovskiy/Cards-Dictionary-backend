package com.sitool.cardsdictionary.accounting.controller;

import com.sitool.cardsdictionary.accounting.dto.AddUserDto;
import com.sitool.cardsdictionary.accounting.dto.RoleDto;
import com.sitool.cardsdictionary.accounting.dto.UpdateUserDto;
import com.sitool.cardsdictionary.accounting.dto.UserDto;
import com.sitool.cardsdictionary.accounting.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public UserDto registerNewUser(@RequestBody AddUserDto addUserDto) {
        return userService.registerNewUser(addUserDto);
    }

    @PostMapping("/login")
    public UserDto login(Principal principal) {

        return userService.getUserByLogin(principal.getName()) ;
    }

    @DeleteMapping("/user/{login}")
    public UserDto deleteUser(@PathVariable String login) {
        return userService.deleteUser(login);
    }

    @PatchMapping("/user/{login}")
    public UserDto updateUser(@PathVariable String login, @RequestBody UpdateUserDto updateUserDto) {
        return userService.updateUser(login, updateUserDto);
    }

    @PatchMapping("/user/{login}/role/{role}")
    public RoleDto addRoll(@PathVariable String login, @PathVariable String role) {
        return userService.changeRollList(login, role, true);
    }

    @DeleteMapping("/user/{login}/role/{role}")
    public RoleDto deleteRoll(@PathVariable String login, @PathVariable String role) {
        return userService.changeRollList(login, role, false);
    }

    @GetMapping("/user/{login}")
    public UserDto getUserByLogin(@PathVariable String login) {
        return userService.getUserByLogin(login);
    }

    @PatchMapping("/password")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void changePassword(Principal principal, @RequestHeader("X-Password") String newPassword) {
        userService.changePassword(principal.getName(), newPassword);
    }


}
