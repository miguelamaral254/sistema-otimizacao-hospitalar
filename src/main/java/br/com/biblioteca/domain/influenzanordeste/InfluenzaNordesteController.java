package br.com.biblioteca.domain.influenzanordeste;


import br.com.biblioteca.core.ApplicationResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Influenza Nordeste")
@RestController
@RequestMapping("/influenza-nordeste")
@RequiredArgsConstructor
public class InfluenzaNordesteController {

    private final InfluenzaNordesteService influenzaNordesteService;
    private final InfluenzaNordesteMapper influenzaNordesteMapper;


    @GetMapping("/{id}")
    @Operation(summary = "Search Influenza data by ID")
    public ResponseEntity<ApplicationResponse<InfluenzaNordesteDTO>> findById(
            @PathVariable Long id) {
        InfluenzaNordeste influenzaNordeste = influenzaNordesteService.findInfluenzaById(id);
        InfluenzaNordesteDTO influenzaNordesteDTO = influenzaNordesteMapper.toDto(influenzaNordeste);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApplicationResponse.ofSuccess(influenzaNordesteDTO));
    }

    @GetMapping
    @Operation(summary = "Search all Influenza data")
    public ResponseEntity<ApplicationResponse<Page<InfluenzaNordesteDTO>>> searchAll(Pageable pageable) {

        Page<InfluenzaNordeste> influenzaPage = influenzaNordesteService.searchInfluenza(pageable);
        Page<InfluenzaNordesteDTO> influenzaDTOPage = influenzaNordesteMapper.toDto(influenzaPage);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApplicationResponse.ofSuccess(influenzaDTOPage));
    }
}