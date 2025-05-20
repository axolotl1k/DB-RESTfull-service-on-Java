package com.pliffdax.RESTService.exeption;

import com.pliffdax.RESTService.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.MethodNotAllowedException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({
            InvalidPasswordException.class,
            InvalidUsernameException.class,
            InvalidBanException.class,
            NullEmailException.class,
            NullPasswordException.class,
            NullUsernameException.class,
            WeakPasswordException.class,
            WrongEmailFormatException.class
    })
    public ResponseEntity<ApiResponse> handleBadRequest(RuntimeException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("400", ex.getMessage()));
    }

    @ExceptionHandler({
            InsufficientPermissionsException.class,
            UserBannedException.class
    })
    public ResponseEntity<ApiResponse> handleForbidden(RuntimeException ex){
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ApiResponse("403", ex.getMessage()));
    }

    @ExceptionHandler({
            UserNotFoundException.class,
            MethodNotAllowedException.class,
            RoleNotFoundException.class
    })
    public ResponseEntity<ApiResponse> handleNotFound(RuntimeException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("404", ex.getMessage()));
    }

    @ExceptionHandler({
            UserAlreadyExistsException.class
    })
    public ResponseEntity<ApiResponse> handleConflict(RuntimeException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponse("409", ex.getMessage()));
    }
}
