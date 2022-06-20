# GraphQL Quarkus Talk Demo

Quick and "dirty" demo project for my "GraphQL with Quarkus" talk.

## Running and packaging

### Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell
./gradlew quarkusDev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

### Packaging and running the application

The application can be packaged using:

```shell
./gradlew build
```

It produces the `quarkus-run.jar` file in the `build/quarkus-app/` directory.

Be aware that it’s not an _über-jar_ as the dependencies are copied into the `build/quarkus-app/lib/` directory.

The application is now runnable using `java -jar build/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell
./gradlew build -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar build/*-runner.jar`.

### Creating a native executable

You can create a native executable using:

```shell
./gradlew build -Dquarkus.package.type=native
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell
./gradlew build -Dquarkus.package.type=native -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./build/graphql-talk-quarkus-demo-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/gradle-tooling.

## Discovering the GraphQL API

After startup go to [http://localhost:8080](http://localhost:8080) page that lists handy links: GraphQL
and REST endpoints, GraphQL UI, OpenAPI UI...

### Queries

Fetch single card entity:

```
{
  card(id: 1) {
    alias
    pan
    paymentSystem
  }
}
```

Fetch cards list:

```
{
  cards {
    pan
    paymentSystem
    tokens {
      tokenId
    }
    rewards {
      points
    }
  }
}
```

Fetch card CVV (it's retrieval performs from another datasource):

```
{
  card(id: 1) {
    cvv
  }
}
```

### Mutations

Block card:

```
mutation {
  blockCard(id: 1) {
    status
  }
}
```

Mutate client's profile:

```
mutation updateProfile {
  updateProfile(update: {
    email: "1@example.com"
    firstName: "John"
    lastName: "Doe"
    language: UA
  }) 
  {
    email
    language
  }
}
```

## Related guides

- [Hibernate ORM](https://quarkus.io/guides/hibernate-orm)
- [Hibernate Validator](https://quarkus.io/guides/validation)
- [RESTEasy Classic JSON-B](https://quarkus.io/guides/rest-json)
- [SmallRye OpenAPI](https://quarkus.io/guides/openapi-swaggerui)
- [RESTEasy Classic](https://quarkus.io/guides/resteasy)
- [SmallRye GraphQL](https://quarkus.io/guides/microprofile-graphql)
