package com.project.project.auth.dto;

import com.project.project.auth.entity.UserRole;

public record RegisterDTO(String name, String email, String password, UserRole role) {

}