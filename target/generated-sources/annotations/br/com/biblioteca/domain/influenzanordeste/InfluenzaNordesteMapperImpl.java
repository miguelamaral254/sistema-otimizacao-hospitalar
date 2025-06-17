package br.com.biblioteca.domain.influenzanordeste;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-17T16:53:53-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class InfluenzaNordesteMapperImpl implements InfluenzaNordesteMapper {

    @Override
    public InfluenzaNordesteDTO toDto(InfluenzaNordeste entity) {
        if ( entity == null ) {
            return null;
        }

        Long id = null;
        String uf = null;
        int jan = 0;
        int feb = 0;
        int mar = 0;
        int apr = 0;
        int may = 0;
        int jun = 0;
        int jul = 0;
        int aug = 0;
        int sep = 0;
        int oct = 0;
        int nov = 0;
        int dec = 0;
        int ano = 0;

        id = entity.getId();
        uf = entity.getUf();
        jan = entity.getJan();
        feb = entity.getFeb();
        mar = entity.getMar();
        apr = entity.getApr();
        may = entity.getMay();
        jun = entity.getJun();
        jul = entity.getJul();
        aug = entity.getAug();
        sep = entity.getSep();
        oct = entity.getOct();
        nov = entity.getNov();
        dec = entity.getDec();
        ano = entity.getAno();

        InfluenzaNordesteDTO influenzaNordesteDTO = new InfluenzaNordesteDTO( id, uf, jan, feb, mar, apr, may, jun, jul, aug, sep, oct, nov, dec, ano );

        return influenzaNordesteDTO;
    }

    @Override
    public InfluenzaNordeste toEntity(InfluenzaNordesteDTO dto) {
        if ( dto == null ) {
            return null;
        }

        InfluenzaNordeste influenzaNordeste = new InfluenzaNordeste();

        influenzaNordeste.setId( dto.id() );
        influenzaNordeste.setUf( dto.uf() );
        influenzaNordeste.setJan( dto.jan() );
        influenzaNordeste.setFeb( dto.feb() );
        influenzaNordeste.setMar( dto.mar() );
        influenzaNordeste.setApr( dto.apr() );
        influenzaNordeste.setMay( dto.may() );
        influenzaNordeste.setJun( dto.jun() );
        influenzaNordeste.setJul( dto.jul() );
        influenzaNordeste.setAug( dto.aug() );
        influenzaNordeste.setSep( dto.sep() );
        influenzaNordeste.setOct( dto.oct() );
        influenzaNordeste.setNov( dto.nov() );
        influenzaNordeste.setDec( dto.dec() );
        influenzaNordeste.setAno( dto.ano() );

        return influenzaNordeste;
    }

    @Override
    public void mergeNonNull(InfluenzaNordesteDTO dto, InfluenzaNordeste entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.id() != null ) {
            entity.setId( dto.id() );
        }
        if ( dto.uf() != null ) {
            entity.setUf( dto.uf() );
        }
        entity.setJan( dto.jan() );
        entity.setFeb( dto.feb() );
        entity.setMar( dto.mar() );
        entity.setApr( dto.apr() );
        entity.setMay( dto.may() );
        entity.setJun( dto.jun() );
        entity.setJul( dto.jul() );
        entity.setAug( dto.aug() );
        entity.setSep( dto.sep() );
        entity.setOct( dto.oct() );
        entity.setNov( dto.nov() );
        entity.setDec( dto.dec() );
        entity.setAno( dto.ano() );
    }
}
