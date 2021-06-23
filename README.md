# API Example for Archunit with classic architecture layers: repository-service-controller

## Technologies
Here are some of technologies that I used to developed this example:
- Spring Boot - 2.4.1
- Archunit - 0.15.0


Following are the rules that this library adds:

1. No Get API should return List or Set. This is to enforce pagination
2. Enforce pagination to avoid performance issues
3. Entities should not be directly exposed in the REST controllers
4. REST controllers should return DTOs only
5. REST controllers name should end with `Resource`
6. All `@Entity` classes should have `@Versioned` field
7. Favor Unchecked exception over checked exception
8. Utils class should have private constructor
9. Root package should have `Application` class
10. Slf4j Logger should be `private static final`
11. Repository interfaces should be inside `..repository..` package
12. Util classes should not be injected
13. Util class methods should be static
14. Spring Singleton components should have only final fields
15. Layers should not have cycles
16. Favor constructor injection  over field injection
17. Favor Java 8 Date Time over Joda API
18. Favor Builder over long list constructor


## Limitations of ArchUnit
First of all; ArchUnit works by analysing the compiled byte code produces by the Java (or Kotlin) compiler. Anything not available at runtime won’t be visible to ArchUnit. An example are lombok annotations. Since lombok’s @Data annotation is not runtime available it is not possible to test for it. Instead you get test if data classes only have "get" and "set" methods, or if all fields are final.

Secondly; while ArchUnit works conveniently on sets of classes, it is somewhat more cumbersome to check methods. That’s definitely an area where improvements to the library could be made. This can be circumvented by creating your own set of custom rules as I demonstrated in the last example. It’s not hard to build your own set of reusable test components due to the pluggable nature of the ArchUnit API.

And last; it would be awesome if ArchUnit could support Java 8 syntax better for custom rules!
