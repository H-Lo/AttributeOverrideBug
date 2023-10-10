/*
 * TheVegCat - The Vegan Catalog.
 * Copyright (C) H.Lo
 * mailto:horvoje@gmail.com
 */
package org.hibernate.bugs.entities.embeds;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.hibernate.annotations.Immutable;
import org.hibernate.bugs.enums.SocialMedia;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author H.Lo
 */
@Embeddable @Immutable @NoArgsConstructor @ToString
public class SocialMediaMap {

	@Getter
	public static class SocialMediaElement {
		private SocialMedia  socialMedia;
		private List<String> elements;

		public SocialMediaElement(final SocialMedia socialMedia, final String... elements) {
			this.socialMedia = socialMedia;
			this.elements = Arrays.asList(elements);
		}
	}

	@Getter
	private Map<SocialMedia, List<String>> data;

	public SocialMediaMap(final SocialMediaElement[] elements) {
		this(Arrays.asList(elements));
	}

	public SocialMediaMap(final Collection<SocialMediaElement> elements) {
		this.data =
			elements.stream()
				.collect(
					Collectors.collectingAndThen(
						Collectors.toMap(el -> el.getSocialMedia(), el -> el.getElements()),
						Collections::unmodifiableMap
					)
				);
	}

	public SocialMediaMap(final SocialMediaMap src) {
		if (src == null) {
			return;
		}
		this.data =
			src.getData().entrySet().stream().collect(
				Collectors.collectingAndThen(
					Collectors.toMap(el -> el.getKey(), el -> el.getValue()),
					Collections::unmodifiableMap
				)
		);
	}

	public List<String> get(final SocialMedia key) {
		return this.data.get(key);
	}

	public List<SocialMedia> getKeyset() {
		return new LinkedList<>(this.data.keySet());
	}

	public boolean isEmpty() {
		return this.data.isEmpty();
	}

}
