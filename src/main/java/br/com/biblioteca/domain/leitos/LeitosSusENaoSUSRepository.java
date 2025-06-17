package br.com.biblioteca.domain.leitos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeitosSusENaoSUSRepository extends JpaRepository<LeitosSusENaoSUS, Long> { }