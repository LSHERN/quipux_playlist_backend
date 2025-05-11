# Proyecto Spring Boot Dockerizado

Este proyecto es una aplicación backend construida con Spring Boot y lista para desplegarse utilizando Docker.

## 🧰 Requisitos previos

Antes de comenzar, asegúrate de tener instalados:

- [Git](https://git-scm.com/)
- Java JDK 17+ (Para ejecutar la aplicación el local)
- [Maven](https://maven.apache.org/) (si deseas compilar manualmente)
- [Docker](https://www.docker.com/)

## 📥 Clonar el repositorio

```bash
git clone https://github.com/LSHERN/quipux_playlist_backend.git

## Construir y ejecutar el contenedor docker

Para construir la imagen de docker debes ejecutar el siguiente comando en la raiz del proyecto:
docker build -t angular-playlist-back .

Para levantar el contenedor:
docker run -p 7001:8080 angular-playlist-back

puedes ejecutar peticiones al backend utilizando herramientas como postman, puedes utilizar esta url:
http://localhost:7001/