package com.pliffdax.RESTService.dto;

public record LoginRequest(
        String username,
        String password
) {
}
