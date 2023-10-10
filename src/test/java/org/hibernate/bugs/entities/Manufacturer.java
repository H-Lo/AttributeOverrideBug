/*
 * TheVegCat - The Vegan Catalog.
 * Copyright (C) H.Lo
 * mailto:horvoje@gmail.com
 */
package org.hibernate.bugs.entities;

import java.io.Serializable;

import org.hibernate.bugs.entities.base.AbstractContactEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author H.Lo
 */
@Entity @NoArgsConstructor @Getter @Setter
public class Manufacturer extends AbstractContactEntity implements Serializable {

	private static final long serialVersionUID = -934617299836260673L;

	@GeneratedValue(
		strategy  = GenerationType.SEQUENCE,
		generator = "sequence-generator"
	)
	@SequenceGenerator(
		name           = "sequence-generator",
		sequenceName   = "hibernate_sequence",
		allocationSize = 50
	)
	@Id
	private Integer id;

	private String name;

}
