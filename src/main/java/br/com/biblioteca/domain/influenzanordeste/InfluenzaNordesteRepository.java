package br.com.biblioteca.domain.influenzanordeste;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface InfluenzaNordesteRepository extends JpaRepository<InfluenzaNordeste, Long>, JpaSpecificationExecutor<InfluenzaNordeste> {

    @Query("SELECT i FROM InfluenzaNordeste i ORDER BY i.id")
    Page<InfluenzaNordeste> findWithPagination(Pageable pageable);
}