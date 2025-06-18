package br.com.biblioteca.domain.influenzanordeste;


import br.com.biblioteca.core.ApplicationResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
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

    @GetMapping()
    @Operation(summary = "Search influenza data with filters or all data")
    public ResponseEntity<ApplicationResponse<Page<InfluenzaNordesteDTO>>> searchInfluenza(
            @RequestParam(value = "uf", required = false) String uf,
            @RequestParam(value = "ano", required = false) Integer ano,
            @RequestParam(value = "jan", required = false) Integer jan,
            @RequestParam(value = "feb", required = false) Integer feb,
            @RequestParam(value = "mar", required = false) Integer mar,
            @RequestParam(value = "apr", required = false) Integer apr,
            @RequestParam(value = "may", required = false) Integer may,
            @RequestParam(value = "jun", required = false) Integer jun,
            @RequestParam(value = "jul", required = false) Integer jul,
            @RequestParam(value = "aug", required = false) Integer aug,
            @RequestParam(value = "sep", required = false) Integer sep,
            @RequestParam(value = "oct", required = false) Integer oct,
            @RequestParam(value = "nov", required = false) Integer nov,
            @RequestParam(value = "dec", required = false) Integer dec,
            Pageable pageable) {

        Specification<InfluenzaNordeste> specification = Specification.where(null);

        if (uf != null) {
            specification = specification.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("uf")), "%" + uf.toLowerCase() + "%"));
        }
        if (ano != null) {
            specification = specification.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("ano"), ano));
        }
        if (jan != null) {
            specification = specification.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("jan"), jan));
        }
        if (feb != null) {
            specification = specification.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("feb"), feb));
        }
        if (mar != null) {
            specification = specification.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("mar"), mar));
        }
        if (apr != null) {
            specification = specification.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("apr"), apr));
        }
        if (may != null) {
            specification = specification.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("may"), may));
        }
        if (jun != null) {
            specification = specification.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("jun"), jun));
        }
        if (jul != null) {
            specification = specification.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("jul"), jul));
        }
        if (aug != null) {
            specification = specification.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("aug"), aug));
        }
        if (sep != null) {
            specification = specification.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("sep"), sep));
        }
        if (oct != null) {
            specification = specification.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("oct"), oct));
        }
        if (nov != null) {
            specification = specification.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("nov"), nov));
        }
        if (dec != null) {
            specification = specification.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("dec"), dec));
        }

        Page<InfluenzaNordeste> influenzaPage = influenzaNordesteService.searchInfluenza(pageable, specification);
        Page<InfluenzaNordesteDTO> influenzaDTOPage = influenzaNordesteMapper.toDto(influenzaPage);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApplicationResponse.ofSuccess(influenzaDTOPage));
    }
}
