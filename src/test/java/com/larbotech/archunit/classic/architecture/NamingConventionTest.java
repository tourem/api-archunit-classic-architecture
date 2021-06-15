package com.larbotech.archunit.classic.architecture;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = {ArchitectureConstants.DEFAULT_PACKAGE}, importOptions = ImportOption.DoNotIncludeTests.class)
public class NamingConventionTest extends ArchitectureConstants {

    @ArchTest
    static ArchRule services_implementation_should_be_prefixed =
            classes()
                    .that().resideInAPackage("..service.impl..")
                    .and().areAnnotatedWith(Service.class)
                    .should().haveSimpleNameEndingWith("ServiceImpl");

    @ArchTest
    static ArchRule controllers_should_be_suffixed =
            classes()
                    .that().resideInAPackage("..controller..")
                    .or().areAnnotatedWith(Controller.class)
                    .should().haveSimpleNameEndingWith("Controller");

    @ArchTest
    static ArchRule classes_named_controller_should_be_in_a_controller_package =
            classes()
                    .that().haveSimpleNameContaining("Controller")
                    .should().resideInAPackage("..controller..");

    @ArchTest
    private final ArchRule allConfigurationClassesShouldBeInConfigurationPackage = classes()
            .that().areAnnotatedWith(Configuration.class)
            .should().resideInAPackage("..configuration..");
}
