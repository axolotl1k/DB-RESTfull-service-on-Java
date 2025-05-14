package com.pliffdax.RESTService.dto;

public record LoginResponse(
        Integer id,
        String username,
        String email,
        String avatar,
        String status
) {
}
