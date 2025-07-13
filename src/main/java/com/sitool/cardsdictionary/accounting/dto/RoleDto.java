package com.sitool.cardsdictionary.accounting.dto;

import lombok.Getter;

import java.util.Set;

@Getter
public class RoleDto {
    private String login;
    private Set<String> roles;

}
