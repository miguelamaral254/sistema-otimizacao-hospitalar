package br.com.biblioteca.domain.LeitosSusENaoSUS;

import br.com.biblioteca.domain.exceptions.NotFoundException;
import br.com.biblioteca.domain.leitos.LeitosSusENaoSUS;
import br.com.biblioteca.domain.leitos.LeitosSusENaoSUSRepository;
import br.com.biblioteca.domain.leitos.LeitosSusENaoSUSService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LeitosSusENaoSUSServiceTest {

    @InjectMocks
    private LeitosSusENaoSUSService leitosSusENaoSUSService;

    @Mock
    private LeitosSusENaoSUSRepository leitosSusENaoSUSRepository;


    @Test
    @DisplayName("Should throw NotFoundException when Leito data does not exist")
    void findLeitoById_whenDataNotExists_thenThrowNotFoundException() {
        Long leitoId = 999L;

        when(leitosSusENaoSUSRepository.findById(leitoId)).thenReturn(Optional.empty());

        NotFoundException exception = assertThrows(NotFoundException.class,
                () -> leitosSusENaoSUSService.findLeitoById(leitoId));

        assertEquals("Leito data not found", exception.getMessage());
    }

    @Test
    @DisplayName("Should search Leitos successfully")
    void searchLeitos_whenCalled_thenReturnLeitosPage() {
        Pageable pageable = Pageable.ofSize(10);
        LeitosSusENaoSUS leito = new LeitosSusENaoSUS();
        Page<LeitosSusENaoSUS> expectedPage = new PageImpl<>(List.of(leito));

        when(leitosSusENaoSUSRepository.findAll(pageable)).thenReturn(expectedPage);

        Page<LeitosSusENaoSUS> resultPage = leitosSusENaoSUSService.searchLeitos(pageable);

        verify(leitosSusENaoSUSRepository, times(1)).findAll(pageable);
        assertEquals(1, resultPage.getTotalElements());
    }
}