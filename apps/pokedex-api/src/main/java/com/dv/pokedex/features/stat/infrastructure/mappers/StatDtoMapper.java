package com.dv.pokedex.features.stat.infrastructure.mappers;

import com.dv.pokedex.features.stat.application.commands.StatCreateCommand;
import com.dv.pokedex.features.stat.application.commands.StatUpdateCommand;
import com.dv.pokedex.features.stat.infrastructure.dto.request.StatCreateRequestDTO;
import com.dv.pokedex.features.stat.infrastructure.dto.request.StatUpdateRequestDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StatDtoMapper {
    StatCreateCommand createDtoToCommand(StatCreateRequestDTO dto);

    StatUpdateCommand updateDtoToCommand(StatUpdateRequestDTO dto);
}
