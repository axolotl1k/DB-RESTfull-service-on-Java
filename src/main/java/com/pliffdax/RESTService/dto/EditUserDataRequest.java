package com.pliffdax.RESTService.dto;

public record EditUserDataRequest(
        String username,
        String email,
        String password,
        String avatar,
        String status
) {
}
