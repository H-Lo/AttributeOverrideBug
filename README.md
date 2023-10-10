# How to run

Create database `bugs` in MySQL with credentials: username `root`; password `root`
or update `persistence.xml` and `hibernate.properties`


# Desired result

When `Hibernate ORM 6.2.7.Final` is used,
once the unit test finishes the table `manufacturer` will be created having 2 columns:

* `name`         VARCHAR(255)
* `social_media` TEXT           -- as a result of well working `@AttributeOverride` annotation


# What happens when Hibernate ORM is upgraded

When `Hibernate ORM 6.3.1.Final` is used,
once the unit test finishes the table `manufacturer` will be created having 2 columns:

* `name`           VARCHAR(255)
* `socialMediaMap` VARCHAR(255) -- `@AttributeOverride` not working anymore
