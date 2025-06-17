package br.com.biblioteca.domain.user;

import br.com.biblioteca.core.BaseDTO;
import br.com.biblioteca.validations.groups.CreateValidation;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

public record UserDTO(

        @Null
        Long id,

        @NotBlank(groups = {CreateValidation.class})
        String imageUrl,

        @NotBlank(groups = CreateValidation.class)
        String name,

        @NotNull(groups = CreateValidation.class)
        @Enumerated(EnumType.STRING)
        Role role,

        @NotBlank(groups = CreateValidation.class)
        String number,

        @NotBlank(groups = CreateValidation.class)
        String countryCode,

        @Email
        @NotBlank(groups = CreateValidation.class)
        String email,

        @NotBlank(groups = CreateValidation.class)
        String password,

        @Pattern(regexp = "\\d{11}", message = "CPF deve ter 11 dígitos")
        @NotNull(groups = CreateValidation.class)
        String cpf,

        @Null
        Boolean enabled,

        @Null
        LocalDateTime createdDate,

        @Null
        LocalDateTime lastModifiedDate

) implements BaseDTO {}