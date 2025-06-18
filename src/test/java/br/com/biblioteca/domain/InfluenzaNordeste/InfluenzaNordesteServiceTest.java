package br.com.biblioteca.domain.InfluenzaNordeste;

import br.com.biblioteca.domain.exceptions.NotFoundException;
import br.com.biblioteca.domain.influenzanordeste.InfluenzaNordeste;
import br.com.biblioteca.domain.influenzanordeste.InfluenzaNordesteRepository;
import br.com.biblioteca.domain.influenzanordeste.InfluenzaNordesteService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class InfluenzaNordesteServiceTest {

    @InjectMocks
    private InfluenzaNordesteService influenzaNordesteService;

    @Mock
    private InfluenzaNordesteRepository influenzaNordesteRepository;


    @Test
    @DisplayName("Should throw NotFoundException when Influenza data does not exist")
    void findInfluenzaById_whenDataNotExists_thenThrowNotFoundException() {
        Long influenzaId = 999L;

        when(influenzaNordesteRepository.findById(influenzaId)).thenReturn(Optional.empty());

        NotFoundException exception = assertThrows(NotFoundException.class,
                () -> influenzaNordesteService.findInfluenzaById(influenzaId));

        assertEquals("Influenza data not found", exception.getMessage());
    }

    @Test
    @DisplayName("Should search Influenza data successfully with specification")
    void searchInfluenza_whenCalled_thenReturnInfluenzaPage() {
        Pageable pageable = Pageable.ofSize(10);
        Specification<InfluenzaNordeste> spec = Specification.where(null);
        Page<InfluenzaNordeste> expectedPage = new PageImpl<>(List.of(new InfluenzaNordeste()));

        when(influenzaNordesteRepository.findAll(spec, pageable)).thenReturn(expectedPage);

        Page<InfluenzaNordeste> resultPage = influenzaNordesteService.searchInfluenza(pageable, spec);

        verify(influenzaNordesteRepository, times(1)).findAll(spec, pageable);
        assertEquals(1, resultPage.getTotalElements());
    }
}