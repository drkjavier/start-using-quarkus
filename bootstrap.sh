#!/bin/bash

# Verifica si Maven está instalado
if ! command -v mvn &> /dev/null
then
    echo "Error: Maven no está instalado o no está en el PATH"
    exit 1
fi

# Ejecuta el comando de Maven
mvn -U io.quarkus:quarkus-maven-plugin:create \
    -DprojectGroupId=org.agoncal.quarkus.starting \
    -DprojectArtifactId=rest-book \
    -DclassName="org.agoncal.quarkus.starting.BookResource" \
    -Dpath="/api/books" \
    -Dextensions="resteasy-jsonb"
