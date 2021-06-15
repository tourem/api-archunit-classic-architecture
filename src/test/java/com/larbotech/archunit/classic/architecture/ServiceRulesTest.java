package com.larbotech.archunit.classic.architecture;

import static com.larbotech.archunit.classic.architecture.ArchitectureConstants.*;
import static com.larbotech.archunit.classic.architecture.CommonRules.beanMethodsAreNotAllowedRule;
import static com.larbotech.archunit.classic.architecture.CommonRules.componentAnnotationIsNotAllowedRule;
import static com.larbotech.archunit.classic.architecture.CommonRules.fieldsShouldNotBePublic;
import static com.larbotech.archunit.classic.architecture.CommonRules.privateMethodsAreNotAllowedRule;
import static com.larbotech.archunit.classic.architecture.CommonRules.publicConstructorsRule;
import static com.larbotech.archunit.classic.architecture.CommonRules.staticMethodsAreNotAllowedRule;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import org.springframework.stereotype.Service;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

@AnalyzeClasses(packages = DEFAULT_PACKAGE, importOptions = ImportOption.DoNotIncludeTests.class)
class ServiceRulesTest {

	// Classes
	@ArchTest
	static final ArchRule component_annotation_is_not_allowed = componentAnnotationIsNotAllowedRule(SERVICE_PACKAGE);
	
	@ArchTest
	static final ArchRule classes_should_be_annotated = classes()
			.that().resideInAPackage(SERVICE_IMPL_PACKAGE).should()
			.beAnnotatedWith(Service.class)
			.because(String.format(ANNOTATED_EXPLANATION, SERVICE_SUFFIX, "@Service"));

	// Fields
	@ArchTest
	static final ArchRule fields_should_not_be_public = fieldsShouldNotBePublic(SERVICE_PACKAGE);

	// Constructors
	@ArchTest
	static final ArchRule constructors_should_not_be_private = publicConstructorsRule(SERVICE_PACKAGE);

	// Methods
	@ArchTest
	static final ArchRule bean_methods_are_not_allowed = beanMethodsAreNotAllowedRule(SERVICE_PACKAGE);

	@ArchTest
	static final ArchRule private_methods_are_not_allowed = privateMethodsAreNotAllowedRule(SERVICE_PACKAGE);

	@ArchTest
	static final ArchRule static_methods_are_not_allowed = staticMethodsAreNotAllowedRule(SERVICE_PACKAGE);

}