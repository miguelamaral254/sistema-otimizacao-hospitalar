package br.com.biblioteca.domain.leitos;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-17T17:22:36-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class LeitosSusENaoSUSMapperImpl implements LeitosSusENaoSUSMapper {

    @Override
    public LeitosSusENaoSUSDTO toDto(LeitosSusENaoSUS entity) {
        if ( entity == null ) {
            return null;
        }

        Long id = null;
        String uf = null;
        int quantidadeSus = 0;
        int quantidadeNaoSus = 0;
        int ano = 0;

        id = entity.getId();
        uf = entity.getUf();
        quantidadeSus = entity.getQuantidadeSus();
        quantidadeNaoSus = entity.getQuantidadeNaoSus();
        ano = entity.getAno();

        LeitosSusENaoSUSDTO leitosSusENaoSUSDTO = new LeitosSusENaoSUSDTO( id, uf, quantidadeSus, quantidadeNaoSus, ano );

        return leitosSusENaoSUSDTO;
    }

    @Override
    public LeitosSusENaoSUS toEntity(LeitosSusENaoSUSDTO dto) {
        if ( dto == null ) {
            return null;
        }

        LeitosSusENaoSUS leitosSusENaoSUS = new LeitosSusENaoSUS();

        leitosSusENaoSUS.setId( dto.id() );
        leitosSusENaoSUS.setUf( dto.uf() );
        leitosSusENaoSUS.setQuantidadeSus( dto.quantidadeSus() );
        leitosSusENaoSUS.setQuantidadeNaoSus( dto.quantidadeNaoSus() );
        leitosSusENaoSUS.setAno( dto.ano() );

        return leitosSusENaoSUS;
    }

    @Override
    public void mergeNonNull(LeitosSusENaoSUSDTO dto, LeitosSusENaoSUS entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.id() != null ) {
            entity.setId( dto.id() );
        }
        if ( dto.uf() != null ) {
            entity.setUf( dto.uf() );
        }
        entity.setQuantidadeSus( dto.quantidadeSus() );
        entity.setQuantidadeNaoSus( dto.quantidadeNaoSus() );
        entity.setAno( dto.ano() );
    }
}
