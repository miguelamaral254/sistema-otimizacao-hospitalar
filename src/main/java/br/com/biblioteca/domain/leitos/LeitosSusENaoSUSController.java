package br.com.biblioteca.domain.leitos;

import br.com.biblioteca.core.ApplicationResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Leitos SUS e Não SUS")
@RestController
@RequestMapping("/leitos-sus-nao-sus")
@RequiredArgsConstructor
public class LeitosSusENaoSUSController {

    private final LeitosSusENaoSUSService leitosSusENaoSUSService;
    private final LeitosSusENaoSUSMapper leitosSusENaoSUSMapper;

    @GetMapping("/{id}")
    @Operation(summary = "Search Leitos SUS and Não SUS data by ID")
    public ResponseEntity<ApplicationResponse<LeitosSusENaoSUSDTO>> findById(
            @PathVariable Long id) {
        LeitosSusENaoSUS leitosSusENaoSUS = leitosSusENaoSUSService.findLeitoById(id);
        LeitosSusENaoSUSDTO leitosSusENaoSUSDTO = leitosSusENaoSUSMapper.toDto(leitosSusENaoSUS);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApplicationResponse.ofSuccess(leitosSusENaoSUSDTO));
    }

    @GetMapping
    @Operation(summary = "Search all Leitos SUS and Não SUS data")
    public ResponseEntity<ApplicationResponse<Page<LeitosSusENaoSUSDTO>>> searchAll(Pageable pageable) {

        Page<LeitosSusENaoSUS> leitosPage = leitosSusENaoSUSService.searchLeitos(pageable);
        Page<LeitosSusENaoSUSDTO> leitosDTOPage = leitosSusENaoSUSMapper.toDto(leitosPage);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApplicationResponse.ofSuccess(leitosDTOPage));
    }
}