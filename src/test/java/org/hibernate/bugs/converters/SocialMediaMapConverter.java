/*
 * TheVegCat - The Vegan Catalog.
 * Copyright (C) H.Lo
 * mailto:horvoje@gmail.com
 */
package org.hibernate.bugs.converters;

import java.io.Serial;
import java.io.Serializable;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import org.hibernate.bugs.enums.SocialMedia;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * @author H.Lo
 */
@Converter
public class SocialMediaMapConverter implements AttributeConverter<Map<SocialMedia, List<String>>, String>, Serializable {

	@Serial private static final long serialVersionUID = -1453072457712812365L;

	@Override
	public String convertToDatabaseColumn(final Map<SocialMedia, List<String>> attribute) {
		if (attribute == null) {
			return null;
		}
		try {
			if (attribute.isEmpty()) {
				return null;
			}
			final String toString = new ObjectMapper().writeValueAsString(attribute);
            return toString;
        }
        catch (final JsonProcessingException e) {
            return null;
        }
	}

	@Override
	public EnumMap<SocialMedia, List<String>> convertToEntityAttribute(final String dbData) {
		if (dbData == null) {
			return new EnumMap<>(SocialMedia.class);
		}
		try {
			return new ObjectMapper().readValue(dbData, typeReference());
        }
        catch (final JsonProcessingException e) {
            return new EnumMap<>(SocialMedia.class);
        }
	}

	private static final TypeReference<EnumMap<SocialMedia, List<String>>> typeReference() {
		return new TypeReference<>() {
            //
        };
	}

}
