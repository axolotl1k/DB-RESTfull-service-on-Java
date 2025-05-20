package com.pliffdax.RESTService.dto;

public record UserInfo(
        Integer id,
        String username,
        String email,
        String avatar,
        String status
) {
}
