package br.com.biblioteca.domain.bookartefact;

import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-07T18:30:05-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class BookArtifactMapperImpl implements BookArtifactMapper {

    @Override
    public BookArtifactDTO toDto(BookArtifact entity) {
        if ( entity == null ) {
            return null;
        }

        Long id = null;
        Long bookId = null;
        String description = null;
        Boolean enabled = null;
        LocalDateTime createdDate = null;
        LocalDateTime lastModifiedDate = null;

        id = entity.getId();
        bookId = map( entity.getBookId() );
        description = entity.getDescription();
        enabled = entity.getEnabled();
        createdDate = entity.getCreatedDate();
        lastModifiedDate = entity.getLastModifiedDate();

        BookArtifactDTO bookArtifactDTO = new BookArtifactDTO( id, bookId, description, enabled, createdDate, lastModifiedDate );

        return bookArtifactDTO;
    }

    @Override
    public void mergeNonNull(BookArtifactDTO dto, BookArtifact entity) {
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
        if ( dto.bookId() != null ) {
            entity.setBookId( map( dto.bookId() ) );
        }
        if ( dto.description() != null ) {
            entity.setDescription( dto.description() );
        }
    }

    @Override
    public BookArtifactDTO toDTO(BookArtifact bookArtifact) {
        if ( bookArtifact == null ) {
            return null;
        }

        Long bookId = null;
        Long id = null;
        String description = null;
        Boolean enabled = null;
        LocalDateTime createdDate = null;
        LocalDateTime lastModifiedDate = null;

        bookId = map( bookArtifact.getBookId() );
        id = bookArtifact.getId();
        description = bookArtifact.getDescription();
        enabled = bookArtifact.getEnabled();
        createdDate = bookArtifact.getCreatedDate();
        lastModifiedDate = bookArtifact.getLastModifiedDate();

        BookArtifactDTO bookArtifactDTO = new BookArtifactDTO( id, bookId, description, enabled, createdDate, lastModifiedDate );

        return bookArtifactDTO;
    }

    @Override
    public BookArtifact toEntity(BookArtifactDTO bookArtifactDTO) {
        if ( bookArtifactDTO == null ) {
            return null;
        }

        BookArtifact bookArtifact = new BookArtifact();

        bookArtifact.setBookId( map( bookArtifactDTO.bookId() ) );
        bookArtifact.setId( bookArtifactDTO.id() );
        bookArtifact.setEnabled( bookArtifactDTO.enabled() );
        bookArtifact.setCreatedDate( bookArtifactDTO.createdDate() );
        bookArtifact.setLastModifiedDate( bookArtifactDTO.lastModifiedDate() );
        bookArtifact.setDescription( bookArtifactDTO.description() );

        return bookArtifact;
    }
}
