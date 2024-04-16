
package org.example.newalertmessaging.exception.auth.JWT;

/*
not used;

@Component
@RestControllerAdvice
public class JWTExceptionHandler {

    private final ResponseDTOFactory errorResponseDTOFactory;
    @Autowired
    public JWTExceptionHandler(ErrorResponseDTOFactory errorResponseDTOFactory){
        this.errorResponseDTOFactory = errorResponseDTOFactory;
    }
    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<ResponseDTO> handleExpiredJwtException(ExpiredJwtException e) throws JsonProcessingException {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(errorResponseDTOFactory.newResponseDto("Token has Expired"));
    }

    @ExceptionHandler({UnsupportedJwtException.class, MalformedJwtException.class})
    public ResponseEntity<ResponseDTO> handleInvalidJwtException(RuntimeException e) throws JsonProcessingException {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errorResponseDTOFactory.newResponseDto("Invalid JWT token"));
    }

    @ExceptionHandler(SignatureException.class)
    public ResponseEntity<ResponseDTO> handleSignatureException(SignatureException e) throws JsonProcessingException {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errorResponseDTOFactory.newResponseDto("Invalid signature"));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ResponseDTO> handleIllegalArgumentException(IllegalArgumentException e) throws JsonProcessingException {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errorResponseDTOFactory.newResponseDto("Invalid token"));
    }
}
*/