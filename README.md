# Latam API Cloud Template Anti-Corruption layer

Este es el documento explica como usar este microservicio de ejemplo y como hacer el despliegue en la nube.

# Documentación útil
* https://kubernetes.io/docs/tasks/access-application-cluster/connecting-frontend-backend/
* https://kubernetes.io/docs/concepts/services-networking/service/#discovering-services
* https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-external-config.html
* https://spring.io/guides/gs/consuming-rest/

# Ejemplo de Anti-Corruption Layer
Servicio de ejemplo que corresponde a la capa de Anti-Corrupción, el cual contiene un ejemplo para utilizar el host de Sabre, el cual se integra con el micro-servicio Sabre Session Pool, que es el encargado de generar sesiones en Sabre y otro servicio el cual es un cliente de sabre en formato jar, el cual requiere una sesión en sabre y abarca un negocio dentro del Host de sabre.

## Ejecutar el proyecto
Se recomienda utilizar **Intellij IDEA Community Edition** e importar como proyecto **Gradle**

## Compilar y generar el ensamblado
    Gradle : ./gradlew build
    Test   : java -jar build/libs/nombre_jar.jar
    URL    : http://localhost:8080/api/acl/example/{pathVariable}

# Crear imagen Docker
En la raíz del proyecto, ejecutar los siguientes comandos:

## Build de la imagen
    docker build -f Dockerfile -t gcr.io/asdad/beers:latest .

## Test de la imagen:
    docker run --name api --rm -p 8080:8080 beers:latest

URL: http://localhost:8080/api/acl/example/{lang}

## Push de la imagen 
    docker push gcr.io/asdad/beers:latest
    
NOTA : reemplazar REGISTRY_USER por vuestra cuenta de usuario Docker Hub

# Configurar Kubernetes local
En la raíz del proyecto, realizar las siguientes actividades:

## Editar el archivo deployment.yaml
    actualizar la ruta de acceso a la imagen docker (REGISTRY_USER/nombreImagen:ver)

## Iniciar Kubernetes local
    minikube start

## Consola de kubernetes 
    minikube dashboard

NOTA: esto puede tardar un tiempo

## Deploy del servicio 
    kubectl create -f deployment.yaml

## Acceder al endpoint
Servicio expuesto por kubernetes

    minikube service be-cloudskeleton

NOTA1: agregar a la url "/be/example"

# Despliegue en Google Cloud Platform (GCP)

## Requisitos
    Google Project (https://console.cloud.google.com)
    gcloud (https://cloud.google.com/sdk/docs/quickstarts)
    kubectl (https://kubernetes.io/docs/tasks/tools/install-kubectl/#install-kubectl)
    Cloud SQL - MySQL (https://console.cloud.google.com/sql/instances)

## Configurar Cloud SDK y Kubectl

### Obtener variables básicas
En https://console.cloud.google.com/cloud-resource-manager

    PROJECT_ID   : en el listado de proyectos Google

En https://console.cloud.google.com/kubernetes/list

    CLUSTER_NAME : en el listado de clusters de Kubernetes

### Ejecutar en consola
    gcloud components update
    gcloud auth login
    gcloud config set project PROJECT_ID
    gcloud components install kubectl
    gcloud auth application-default login
    gcloud container clusters get-credentials CLUSTER_NAME
    kubectl version

## Crear service account key 
En https://console.cloud.google.com/apis/api/servicecontrol.googleapis.com
Para este caso no es necesario crear cuenta de servicio ya que la capa Backend-for-frontend o Business layer deben tenerla, además esta capa debería exponerse como NodePort y que la capa Business layer debería llamar mediante FQDN.

Seleccionar

    left-navigation bar, click Credentials
    Create credentials, select Service account key
    Service account drop-down, click New service account
    Service account name: API_NAME-api.endpoints.PROJECT_ID.cloud.goog
    Role drop-down, Project > Editor
    Key type, use the default JSON

Se descargara un archivo .json, renombrar a service-account-creds.json y dejarlo en la carpeta del proyecto

NOTA: el **service account name** es utilizado para configurar Google Endpoints.

## Desplegar en GCP
Ejecutar los siguientes comandos:

    kubectl create -f deploy/k8s/service.yaml
    kubectl create -f deploy/k8s/deployment.yaml

En el caso de que exista el despliegue y el service, se deben ejecutar los siguientes comandos:
    
    kubectl delete --ignore-not-found=true -f deploy/k8s/service.yaml
    kubectl delete --ignore-not-found=true -f deploy/k8s/deployment.yaml

# Consideraciones
En el archivo de properties "application.yaml", existe un property llamado "dummy", en el caso que se quiera hacer la prueba con la integración con Sabre, este valor hay que dejarlo como false, sino, se debe dejar como true y el servicio va responder un valor "dummy".

# Generación de clientes a partir de WSDL

Se necesita tener JDK mayor o igual a 1.8

    wsimport.exe -verbose -keep -B-XautoNameResolution -clientjar [Nombredeljar.jar] [path/to/wsdl]

Luego incluirlo en la carpeta "lib" y gradle va incluir la librería generada al momento de hacer el build.

