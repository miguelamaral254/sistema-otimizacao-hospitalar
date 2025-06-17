package br.com.biblioteca.domain.leitos;

import br.com.biblioteca.core.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LeitosSusENaoSUSMapper extends BaseMapper<LeitosSusENaoSUS, LeitosSusENaoSUSDTO> { }
