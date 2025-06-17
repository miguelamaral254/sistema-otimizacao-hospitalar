package br.com.biblioteca.domain.book;

import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-07T18:30:05-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public BookDTO toDto(Book book) {
        if ( book == null ) {
            return null;
        }

        Long userId = null;
        Long id = null;
        String urlImage = null;
        String title = null;
        String description = null;
        Gender gender = null;
        Boolean available = null;
        Boolean enabled = null;
        LocalDateTime createdDate = null;
        LocalDateTime lastModifiedDate = null;

        userId = map( book.getUserId() );
        id = book.getId();
        urlImage = book.getUrlImage();
        title = book.getTitle();
        description = book.getDescription();
        gender = book.getGender();
        available = book.getAvailable();
        enabled = book.getEnabled();
        createdDate = book.getCreatedDate();
        lastModifiedDate = book.getLastModifiedDate();

        BookDTO bookDTO = new BookDTO( id, urlImage, title, userId, description, gender, available, enabled, createdDate, lastModifiedDate );

        return bookDTO;
    }

    @Override
    public Book toEntity(BookDTO bookDTO) {
        if ( bookDTO == null ) {
            return null;
        }

        Book book = new Book();

        book.setUserId( map( bookDTO.userId() ) );
        book.setId( bookDTO.id() );
        book.setEnabled( bookDTO.enabled() );
        book.setCreatedDate( bookDTO.createdDate() );
        book.setLastModifiedDate( bookDTO.lastModifiedDate() );
        book.setUrlImage( bookDTO.urlImage() );
        book.setTitle( bookDTO.title() );
        book.setDescription( bookDTO.description() );
        book.setGender( bookDTO.gender() );
        book.setAvailable( bookDTO.available() );

        return book;
    }

    @Override
    public void mergeNonNull(BookDTO dto, Book entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.userId() != null ) {
            entity.setUserId( map( dto.userId() ) );
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
        if ( dto.urlImage() != null ) {
            entity.setUrlImage( dto.urlImage() );
        }
        if ( dto.title() != null ) {
            entity.setTitle( dto.title() );
        }
        if ( dto.description() != null ) {
            entity.setDescription( dto.description() );
        }
        if ( dto.gender() != null ) {
            entity.setGender( dto.gender() );
        }
        if ( dto.available() != null ) {
            entity.setAvailable( dto.available() );
        }
    }
}
