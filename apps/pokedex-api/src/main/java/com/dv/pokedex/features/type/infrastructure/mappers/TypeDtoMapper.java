package com.dv.pokedex.features.type.infrastructure.mappers;

import com.dv.pokedex.features.type.application.commands.CreateTypeCommand;
import com.dv.pokedex.features.type.application.commands.UpdateTypeCommand;
import com.dv.pokedex.features.type.infrastructure.dto.request.CreateTypeRequestDTO;
import com.dv.pokedex.features.type.infrastructure.dto.request.UpdateTypeRequestDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TypeDtoMapper {
    CreateTypeCommand createDtoToCommand(CreateTypeRequestDTO dto);

    UpdateTypeCommand updateDtoToCommand(UpdateTypeRequestDTO dto);
}
