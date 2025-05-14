package com.pliffdax.RESTService.dto;

import java.time.LocalDateTime;

public record BanUserRequest(
        String username,
        String reason,
        LocalDateTime untilDate
) {
}
