package com.pliffdax.RESTService.dto;

public record RegisterRequest(
        String username,
        String email,
        String password
) {
}
