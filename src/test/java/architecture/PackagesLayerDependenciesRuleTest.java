package architecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import com.tngtech.archunit.library.dependencies.SlicesRuleDefinition;
import org.junit.runner.RunWith;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "com.latam.api.bla.beers")
public class PackagesLayerDependenciesRuleTest {

    @ArchTest
    public static final ArchRule entitiesShouldNotDependOnOtherPackages =
            ArchRuleDefinition.classes().that().resideInAPackage("..entities..")
                    .should().dependOnClassesThat().resideInAnyPackage("..entities..", "java..");

    @ArchTest
    public static final ArchRule domainShouldNotDependOnOtherPackages =
            ArchRuleDefinition.classes().that().resideInAPackage("..domain..")
                    .should().dependOnClassesThat().resideInAnyPackage("..domain..", "java..");


    @ArchTest
    public static final ArchRule usecaseShouldResideInDomainPackage =
            ArchRuleDefinition.classes().that().resideInAPackage("..usecases")
                    .should().resideInAPackage("..domain..");

    @ArchTest
    public static final ArchRule useCasehouldOnlyBeAccessedByEntrypointsOrOtherUsecaseOrSpringConfigure =
            ArchRuleDefinition.classes().that().resideInAPackage("..usecases..")
                    .should().onlyBeAccessed().byAnyPackage( "..usecases..", "..entrypoints..","..infrastructure.configuration..");


    @ArchTest
    static final ArchRule controllersMustBePlacedInEntrypointsPackage =
            ArchRuleDefinition.classes().that().areAnnotatedWith(RestController.class)
                    .or().areAnnotatedWith(ControllerAdvice.class)
                    .should().resideInAPackage("..entrypoints.rest..");

    @ArchTest
    static final ArchRule infrastructureClassesShouldNotBeAccessedOutsideInfrastructure =
            ArchRuleDefinition.classes().that().resideInAPackage("..infrastructure..")
                    .should().onlyBeAccessed().byAnyPackage("..infrastructure..");

    @ArchTest public static final ArchRule verifyNoCycles = SlicesRuleDefinition.slices().matching("..error..")
            .should().notDependOnEachOther();

    @ArchTest
    static final ArchRule interfacesMustNotBePlacedInImplementationPackagesRule =
            ArchRuleDefinition.classes().that().resideInAPackage("..ports..").should().beInterfaces();

}