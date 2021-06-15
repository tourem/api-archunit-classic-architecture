package com.larbotech.archunit.classic.architecture;

public class ArchitectureConstants {

    // Suffixes
    public static final String CONTROLLER_SUFFIX = "Controller";
    public static final String REPOSITORY_SUFFIX = "Repository";
    public static final String SERVICE_SUFFIX = "Service";

    // Packages
    public static final String CONTROLLER_PACKAGE = "..controller..";
    public static final String MODEL_PACKAGE = "..model..";
    public static final String DTO_PACKAGE = "..dto..";
    public static final String REPOSITORY_PACKAGE = "..repository..";
    public static final String SERVICE_PACKAGE = "..service..";
    public static final String SERVICE_IMPL_PACKAGE = "..service.impl..";


    // Package to scan
    public static final String DEFAULT_PACKAGE = "com.larbotech.archunit.classic";

    // Explanations
    public static final String ANNOTATED_EXPLANATION = "Classes in %s package should be annotated with %s";

    private ArchitectureConstants() {

    }

}
