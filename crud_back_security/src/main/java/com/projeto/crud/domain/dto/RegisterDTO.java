package com.projeto.crud.domain.dto;

import com.projeto.crud.domain.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
