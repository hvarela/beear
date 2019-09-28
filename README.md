
Para correr el la api se deben seguir los siguientes pasos

1) ./gradlew build buildDocker
2)  docker-compose  up



para correr los test de mutacion y ver la covertura se debe ejecutar

./gradlew pitest

  los reportes quedan en ./build/reports/mutation-tests-results/index.html
