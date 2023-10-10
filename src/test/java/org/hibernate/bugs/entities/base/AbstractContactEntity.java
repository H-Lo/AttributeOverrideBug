/*
 * TheVegCat - The Vegan Catalog.
 * Copyright (C) H.Lo
 * mailto:horvoje@gmail.com
 */
package org.hibernate.bugs.entities.base;

import java.io.Serializable;

import org.hibernate.bugs.entities.embeds.Contact;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

/**
 * @author H.Lo
 */
@MappedSuperclass @Getter @Setter
public class AbstractContactEntity implements Serializable {

	private static final long serialVersionUID = -3614676875298862566L;

	private Contact contact;

}
