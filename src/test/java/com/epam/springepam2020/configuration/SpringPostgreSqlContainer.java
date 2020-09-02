package com.epam.springepam2020.configuration;

import org.testcontainers.containers.PostgreSQLContainer;

public class SpringPostgreSqlContainer extends PostgreSQLContainer<SpringPostgreSqlContainer> {

    private static final String IMAGE_VERSION = "postgres:11.1";
    private static SpringPostgreSqlContainer container = new SpringPostgreSqlContainer();

    private SpringPostgreSqlContainer() {
        super(IMAGE_VERSION);
    }

    public static SpringPostgreSqlContainer getInstance() {
        if (!container.isRunning()) {
            container.start();
        }
        return container;
    }

}
