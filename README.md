# API Example for Archunit with classic architecture layers: repository-service-controller

## Technologies
Here are some of technologies that I used to developed this example:
- Spring Boot - 2.4.1
- Archunit - 0.15.0


## Limitations of ArchUnit
First of all; ArchUnit works by analysing the compiled byte code produces by the Java (or Kotlin) compiler. Anything not available at runtime won’t be visible to ArchUnit. An example are lombok annotations. Since lombok’s @Data annotation is not runtime available it is not possible to test for it. Instead you get test if data classes only have "get" and "set" methods, or if all fields are final.

Secondly; while ArchUnit works conveniently on sets of classes, it is somewhat more cumbersome to check methods. That’s definitely an area where improvements to the library could be made. This can be circumvented by creating your own set of custom rules as I demonstrated in the last example. It’s not hard to build your own set of reusable test components due to the pluggable nature of the ArchUnit API.

And last; it would be awesome if ArchUnit could support Java 8 syntax better for custom rules!