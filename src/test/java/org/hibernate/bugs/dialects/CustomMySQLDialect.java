/*
 * TheVegCat - The Vegan Catalog.
 * Copyright (C) H.Lo
 * mailto:horvoje@gmail.com
 */
package org.hibernate.bugs.dialects;

import org.hibernate.dialect.DatabaseVersion;
import org.hibernate.dialect.MySQLDialect;

/**
 * @author H.Lo
 */
public class CustomMySQLDialect extends MySQLDialect {

	private static final int MAJOR = 8;
	private static final int MINOR = 0;

	public CustomMySQLDialect() {
		super(DatabaseVersion.make(Integer.valueOf(MAJOR), Integer.valueOf(MINOR)));
	}

	@Override
	public String getTableTypeString() {
		return "engine=innodb default charset=utf8mb4 collate utf8mb4_unicode_ci";
	}

}
