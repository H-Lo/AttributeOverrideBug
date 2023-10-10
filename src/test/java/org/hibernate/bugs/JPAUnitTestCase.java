package org.hibernate.bugs;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * This template demonstrates how to develop a test case for Hibernate ORM, using the Java Persistence API.
 */
public class JPAUnitTestCase {

	private EntityManagerFactory entityManagerFactory;

	@Before
	public void init() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory("templatePU");
	}

	@After
	public void destroy() {
		this.entityManagerFactory.close();
	}

	/**
	 * NOTE: No need to create the instance of Entity Manager because the bug mentioned is in schema creation phase.
	 */
	@Test
	public void attributeOverrideAnnotationTest() {
		assertNotNull("");
	}

}
