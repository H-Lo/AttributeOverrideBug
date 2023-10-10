/*
 * TheVegCat - The Vegan Catalog.
 * Copyright (C) H.Lo
 * mailto:horvoje@gmail.com
 */
package org.hibernate.bugs.entities.embeds;

import java.io.Serializable;

import org.hibernate.annotations.Immutable;
import org.hibernate.bugs.converters.SocialMediaMapConverter;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author H.Lo
 */
@Embeddable @Immutable @NoArgsConstructor @Getter @ToString
public class Contact implements Serializable {

	private static final long serialVersionUID = 8683097445322631165L;

	@Convert(converter = SocialMediaMapConverter.class, attributeName = "data")
	@AttributeOverride(name = "data", column = @Column(name = "social_media", columnDefinition = "TEXT"))
	private SocialMediaMap socialMediaMap;

}
