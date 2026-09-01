package com.dv.pokedex.features.type.application.services;

import com.dv.pokedex.core.exceptions.exceptions.ResourceNotFoundException;
import com.dv.pokedex.features.type.application.commands.CreateTypeCommand;
import com.dv.pokedex.features.type.application.commands.UpdateTypeCommand;
import com.dv.pokedex.features.type.application.ports.TypeRepositoryPort;
import com.dv.pokedex.features.type.domain.exceptions.TypeAlreadyExists;
import com.dv.pokedex.features.type.domain.model.Type;
import com.dv.pokedex.features.type.domain.vo.TypeName;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TypeService {

    private final TypeRepositoryPort typeRepositoryPort;

    public Type getById(Integer typeId) {
        return typeRepositoryPort
                .getTypeById(typeId)
                .orElseThrow(() -> new ResourceNotFoundException("Type not found"));
    }

    public List<Type> getTypes() {
        return typeRepositoryPort.getTypes();
    }

    public Type createType(CreateTypeCommand command) {
        verifyNameIsAvailable(command.name());
        return typeRepositoryPort.saveType(Type.create(TypeName.create(command.name())));
    }

    public Type updateType(Integer typeId, UpdateTypeCommand command) {
        Type type = getById(typeId);
        if (!type.getName().getValue().equalsIgnoreCase(command.name().strip())
                && typeRepositoryPort.existsByName(command.name().strip())) {
            throw new TypeAlreadyExists();
        }
        type.updateInformation(TypeName.create(command.name()));
        return typeRepositoryPort.saveType(type);
    }

    public void deleteType(Integer typeId) {
        Type type = getById(typeId);
        typeRepositoryPort.deleteType(type.getId());
    }

    private void verifyNameIsAvailable(String name) {
        if (typeRepositoryPort.existsByName(name.strip())) {
            throw new TypeAlreadyExists();
        }
    }
}
