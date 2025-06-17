package br.com.biblioteca.domain.authentication;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-17T16:53:53-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class AuthMapperImpl implements AuthMapper {

    @Override
    public AuthRequest toAuthRequest(AuthRequestDTO authRequestDTO) {
        if ( authRequestDTO == null ) {
            return null;
        }

        AuthRequest authRequest = new AuthRequest();

        authRequest.setEmail( authRequestDTO.getEmail() );
        authRequest.setPassword( authRequestDTO.getPassword() );

        return authRequest;
    }

    @Override
    public AuthResponseDTO toAuthResponseDTO(AuthDTO authDTO) {
        if ( authDTO == null ) {
            return null;
        }

        String token = null;
        String message = null;

        token = authDTO.token();
        message = authDTO.message();

        AuthResponseDTO authResponseDTO = new AuthResponseDTO( token, message );

        return authResponseDTO;
    }
}
