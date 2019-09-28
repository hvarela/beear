
Para correr el la api se deben seguir los siguientes pasos

1) ./gradlew build buildDocker
2)  docker-compose  up



para correr los test de mutacion y ver la covertura se debe ejecutar

./gradlew pitest

  los reportes quedan en ./build/reports/mutation-tests-results/index.html


ejemplo de curl 

 1)  get all

      curl  GET   http://localhost:8080/beers/


 2) add  beer

     curl -X POST \
  http://localhost:8080/beers \
  -H 'Accept: */*' \
  -H 'Accept-Encoding: gzip, deflate' \
  -H 'Content-Type: application/json' \
  -d '{
	"id":22,
	"name": "tito 4",
	"brewery": "casa de beeer 4",
	"country": "CL",
	"currency" : "USD",
	"price": 750
}'


