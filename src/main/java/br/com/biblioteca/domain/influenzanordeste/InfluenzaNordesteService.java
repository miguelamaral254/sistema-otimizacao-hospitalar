package br.com.biblioteca.domain.influenzanordeste;

import br.com.biblioteca.domain.exceptions.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InfluenzaNordesteService {

    private final InfluenzaNordesteRepository influenzaNordesteRepository;

    public InfluenzaNordesteService(InfluenzaNordesteRepository influenzaNordesteRepository) {
        this.influenzaNordesteRepository = influenzaNordesteRepository;
    }

    @Transactional(readOnly = true)
    public InfluenzaNordeste findInfluenzaById(Long id) {
        return influenzaNordesteRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Influenza data not found"));
    }
    @Transactional(readOnly = true)
    public Page<InfluenzaNordeste> searchInfluenza(Pageable pageable, Specification<InfluenzaNordeste> spec) {
        return influenzaNordesteRepository.findAll(spec, pageable);
    }
}