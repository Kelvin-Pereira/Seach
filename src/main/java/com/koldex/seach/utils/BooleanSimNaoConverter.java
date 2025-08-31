package com.koldex.seach.utils;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class BooleanSimNaoConverter implements AttributeConverter<Boolean, Character> {

    @Override
    public Character convertToDatabaseColumn(Boolean attribute) {
        if (attribute == null) return null;
        return attribute ? 'S' : 'N';
    }

    @Override
    public Boolean convertToEntityAttribute(Character dbData) {
        if (dbData == null) return null;

        return switch (Character.toUpperCase(dbData)) {
            case 'S' -> true;
            case 'N' -> false;
            default -> null;
        };
    }
}
