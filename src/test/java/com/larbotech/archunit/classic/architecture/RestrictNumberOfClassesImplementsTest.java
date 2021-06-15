package com.larbotech.archunit.classic.architecture;



import com.larbotech.archunit.classic.service.ClientService;
import com.larbotech.archunit.classic.service.impl.ClientServiceImpl;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.base.DescribedPredicate.lessThanOrEqualTo;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = ArchitectureConstants.DEFAULT_PACKAGE)
public class RestrictNumberOfClassesImplementsTest {

    @ArchTest
    static final ArchRule no_new_classes_should_implement_SendMoneyUseCase =
            classes().that().implement(ClientService.class)
                    .should().containNumberOfElements(lessThanOrEqualTo(1))
                    .because("from now on new classes should implement " + ClientServiceImpl.class.getName());

}
