package br.com.biblioteca.domain.user;

import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-17T16:53:53-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toDto(User entity) {
        if ( entity == null ) {
            return null;
        }

        Long id = null;
        String imageUrl = null;
        String name = null;
        Role role = null;
        String number = null;
        String countryCode = null;
        String email = null;
        String password = null;
        String cpf = null;
        Boolean enabled = null;
        LocalDateTime createdDate = null;
        LocalDateTime lastModifiedDate = null;

        id = entity.getId();
        imageUrl = entity.getImageUrl();
        name = entity.getName();
        role = entity.getRole();
        number = entity.getNumber();
        countryCode = entity.getCountryCode();
        email = entity.getEmail();
        password = entity.getPassword();
        cpf = entity.getCpf();
        enabled = entity.getEnabled();
        createdDate = entity.getCreatedDate();
        lastModifiedDate = entity.getLastModifiedDate();

        UserDTO userDTO = new UserDTO( id, imageUrl, name, role, number, countryCode, email, password, cpf, enabled, createdDate, lastModifiedDate );

        return userDTO;
    }

    @Override
    public User toEntity(UserDTO dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setId( dto.id() );
        user.setEnabled( dto.enabled() );
        user.setCreatedDate( dto.createdDate() );
        user.setLastModifiedDate( dto.lastModifiedDate() );
        user.setName( dto.name() );
        user.setImageUrl( dto.imageUrl() );
        user.setCpf( dto.cpf() );
        user.setEmail( dto.email() );
        user.setRole( dto.role() );
        user.setPassword( dto.password() );
        user.setNumber( dto.number() );
        user.setCountryCode( dto.countryCode() );

        return user;
    }

    @Override
    public void mergeNonNull(UserDTO dto, User entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.id() != null ) {
            entity.setId( dto.id() );
        }
        if ( dto.enabled() != null ) {
            entity.setEnabled( dto.enabled() );
        }
        if ( dto.createdDate() != null ) {
            entity.setCreatedDate( dto.createdDate() );
        }
        if ( dto.lastModifiedDate() != null ) {
            entity.setLastModifiedDate( dto.lastModifiedDate() );
        }
        if ( dto.name() != null ) {
            entity.setName( dto.name() );
        }
        if ( dto.imageUrl() != null ) {
            entity.setImageUrl( dto.imageUrl() );
        }
        if ( dto.cpf() != null ) {
            entity.setCpf( dto.cpf() );
        }
        if ( dto.email() != null ) {
            entity.setEmail( dto.email() );
        }
        if ( dto.role() != null ) {
            entity.setRole( dto.role() );
        }
        if ( dto.password() != null ) {
            entity.setPassword( dto.password() );
        }
        if ( dto.number() != null ) {
            entity.setNumber( dto.number() );
        }
        if ( dto.countryCode() != null ) {
            entity.setCountryCode( dto.countryCode() );
        }
    }
}
