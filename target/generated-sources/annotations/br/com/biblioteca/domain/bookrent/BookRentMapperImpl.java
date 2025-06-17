package br.com.biblioteca.domain.bookrent;

import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-09T15:14:34-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class BookRentMapperImpl implements BookRentMapper {

    @Override
    public void mergeNonNull(BookRentDTO dto, BookRent entity) {
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
        if ( dto.userId() != null ) {
            entity.setUserId( mapUser( dto.userId() ) );
        }
        if ( dto.returnDate() != null ) {
            entity.setReturnDate( dto.returnDate() );
        }
        if ( dto.late() != null ) {
            entity.setLate( dto.late() );
        }
    }

    @Override
    public BookRentDTO toDto(BookRent bookRent) {
        if ( bookRent == null ) {
            return null;
        }

        Long bookId = null;
        Long userId = null;
        Long id = null;
        LocalDateTime returnDate = null;
        Boolean late = null;
        Boolean enabled = null;
        LocalDateTime createdDate = null;
        LocalDateTime lastModifiedDate = null;

        bookId = map( bookRent.getBookId() );
        userId = map( bookRent.getUserId() );
        id = bookRent.getId();
        returnDate = bookRent.getReturnDate();
        late = bookRent.isLate();
        enabled = bookRent.getEnabled();
        createdDate = bookRent.getCreatedDate();
        lastModifiedDate = bookRent.getLastModifiedDate();

        BookRentDTO bookRentDTO = new BookRentDTO( id, bookId, userId, returnDate, late, enabled, createdDate, lastModifiedDate );

        return bookRentDTO;
    }

    @Override
    public BookRent toEntity(BookRentDTO bookRentDto) {
        if ( bookRentDto == null ) {
            return null;
        }

        BookRent bookRent = new BookRent();

        bookRent.setBookId( map( bookRentDto.bookId() ) );
        bookRent.setUserId( mapUser( bookRentDto.userId() ) );
        bookRent.setId( bookRentDto.id() );
        bookRent.setEnabled( bookRentDto.enabled() );
        bookRent.setCreatedDate( bookRentDto.createdDate() );
        bookRent.setLastModifiedDate( bookRentDto.lastModifiedDate() );
        bookRent.setReturnDate( bookRentDto.returnDate() );
        if ( bookRentDto.late() != null ) {
            bookRent.setLate( bookRentDto.late() );
        }

        return bookRent;
    }
}
