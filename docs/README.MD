# Fleet Management API



Este proyecto consiste en la construcción de una API REST para el software de gestión de flotas, que permite consultar las ubicaciones de los vehículos de una empresa de taxis en Beijing, China. La API proporciona acceso a las ubicaciones de casi 10 mil taxis y se espera que como desarrollador explores nuevas alternativas y técnicas para almacenar y consultar esta información, garantizando así la mejor experiencia de usuario posible.

## Stack de Tecnologías

- **Spring Boot:** Utilizado para crear aplicaciones Java de forma rápida y sencilla.
- **Spring Boot Test:** Framework para realizar pruebas de integración en aplicaciones Spring Boot.
- **JUnit:** Framework para realizar pruebas unitarias en Java.
- **Mockito:** Biblioteca para crear mocks en pruebas unitarias y de integración.
- **MockMvc, WebTestClient, TestRestTemplate:** Utilizados para realizar pruebas en la capa web de la aplicación.
- **Hibernate:** Framework de mapeo objeto-relacional (ORM) utilizado para facilitar las consultas a la base de datos.
- **PostgreSQL:** Base de datos relacional utilizada para almacenar los datos de ubicaciones de los taxis.

## Instalación y Uso

1. Clona el repositorio en tu máquina local.
2. Configura la base de datos PostgreSQL y asegúrate de tener acceso a los datos de ubicaciones de taxis.
3. Ejecuta la aplicación utilizando Maven o tu IDE favorito.
4. Accede a la documentación de la API en [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html).
5. Utiliza las distintas rutas proporcionadas por la API para consultar las ubicaciones de los taxis según tus necesidades.

## Estructura del Proyecto

El proyecto sigue una estructura típica de una aplicación Spring Boot, con las siguientes carpetas principales:

1. **Controllers (Controladores):**
    - Esta carpeta contiene clases que actúan como controladores en la aplicación. Los controladores manejan las solicitudes HTTP entrantes, interactúan con los servicios para procesar los datos y devuelven las respuestas HTTP adecuadas.

2. **Model (Modelo):**
    - Aquí se encuentran las clases que representan el modelo de datos de la aplicación. Estas clases son objetos de Java simples que representan entidades de negocio y, a menudo, están anotadas con `@Entity` para ser utilizadas con JPA/Hibernate.

3. **Repositories (Repositorios):**
    - Esta carpeta contiene interfaces que actúan como repositorios de datos para interactuar con la base de datos. Los repositorios proporcionan métodos para realizar operaciones CRUD en las entidades de la base de datos sin necesidad de escribir consultas SQL manualmente.

4. **Services (Servicios):**
    - Aquí se encuentran las clases que implementan la lógica de negocio de la aplicación. Los servicios encapsulan la lógica de procesamiento de datos y actúan como una capa intermedia entre los controladores y los repositorios.
## Contribución

¡Las contribuciones son bienvenidas! Si tienes ideas para mejorar la API, por favor crea una solicitud de extracción o abre un problema para discutir los cambios propuestos.

## Licencia

Este proyecto está bajo la licencia [MIT](https://opensource.org/licenses/MIT).