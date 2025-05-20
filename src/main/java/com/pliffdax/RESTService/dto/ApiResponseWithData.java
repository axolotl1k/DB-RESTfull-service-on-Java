package com.pliffdax.RESTService.dto;

public record ApiResponseWithData(
        String status,
        String message,
        Object data
) {
}
