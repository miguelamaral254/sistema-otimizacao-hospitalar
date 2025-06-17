package br.com.biblioteca.domain.influenzanordeste;

import br.com.biblioteca.core.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InfluenzaNordesteMapper extends BaseMapper<InfluenzaNordeste, InfluenzaNordesteDTO> { }
