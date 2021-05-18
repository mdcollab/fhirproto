# fhirproto
scala case classes generated from github.com/google/fhir

# Publishing new versions of this library
## Locally
Simply run
```bash
JAVA_OPTS="-Xmx4g" sbt "publishLocal"
```

## Public
First, create a PR and have it reviewed. Once the PR is accepted, 
open the `build.sbt` file, and update the `Sonatype username` and `Sonatype password` with 
credentials from `password`, named `issues.sonatype.org` and then run 

```bash
JAVA_OPTS="-Xmx4g" sbt "publish"
```

## Sonatype OSS info
[This ticket](https://issues.sonatype.org/browse/OSSRH-39900) has the history of how the sonatype account was created.
