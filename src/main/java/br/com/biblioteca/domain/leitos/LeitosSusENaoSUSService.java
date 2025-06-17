package br.com.biblioteca.domain.leitos;

import br.com.biblioteca.domain.exceptions.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LeitosSusENaoSUSService {

    private final LeitosSusENaoSUSRepository leitosSusENaoSUSRepository;

    public LeitosSusENaoSUSService(LeitosSusENaoSUSRepository leitosSusENaoSUSRepository) {
        this.leitosSusENaoSUSRepository = leitosSusENaoSUSRepository;
    }

    @Transactional(readOnly = true)
    public LeitosSusENaoSUS findLeitoById(Long id) {
        return leitosSusENaoSUSRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Leito data not found"));
    }

    @Transactional(readOnly = true)
    public Page<LeitosSusENaoSUS> searchLeitos(Pageable pageable) {
        return leitosSusENaoSUSRepository.findAll(pageable);
    }
}