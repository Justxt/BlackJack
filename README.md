# BlackJack

This project can be used as a starting point to create your own Vaadin application with Spring Boot.
It contains all the necessary configuration and some placeholder files to get you started.

## IMAGENES -

-- INICIO
![image](https://github.com/Justxt/BlackJack/assets/96129728/a5043660-f6bf-4fbb-968b-b19cc3cc88e7)

-- ELECCION CATEGORIAS - PAG 2
![image](https://github.com/Justxt/BlackJack/assets/96129728/e0168cb7-2633-4950-81d7-73b281a6a3a6)

- CATEGORIA 1 - PAG 3
SE MUESTRA LA SECCION DE PREGUNTAS CON UNA OPCION DE RESPUESTAS!
![image](https://github.com/Justxt/BlackJack/assets/96129728/dc377c61-7221-4cc1-bcde-fbe4167c5266)
## SI SE ELIJE UNA RESPUESTA INCORRETA SALTARA UNA VENTANA CON EL AVISO!
![image](https://github.com/Justxt/BlackJack/assets/96129728/edcc60cf-7056-4ede-b733-55fb9dec95e0)
## EN CASO DE HACER UNA ELECCION CORRECTA SALTA UNA VENTANA CON EL AVISO!
![image](https://github.com/Justxt/BlackJack/assets/96129728/d1b83580-3e1c-4921-b717-4671532ca48b)

- CATEGORIA 2
![image](https://github.com/Justxt/BlackJack/assets/96129728/597a9895-c954-487e-bf27-5d0b76d102aa)
- CATEGORIA 3
![image](https://github.com/Justxt/BlackJack/assets/96129728/95f70e3d-fbbf-4a31-876d-7650a3d3c7bc)
- CATEGORIA 4
![image](https://github.com/Justxt/BlackJack/assets/96129728/28f196bf-3a73-4056-96bc-955eca0f2d46)

-- INFORMACION DE COMO FUNCIONA EL JUEGO
##AL TERMINAR LA SERIE DE PREGUNTAS SE MOSTRARA UN PUNTAJE Y CONSECUTIVAMENTE UN AVISO DE COMO FUNCIONA EL JUEGO!
![image](https://github.com/Justxt/BlackJack/assets/96129728/85951031-f99d-4d11-a762-08b717e28fe0)

-- RESULTADOS
## AQUI SE MOSTRARA SI TUVISTE SUERTE!
![image](https://github.com/Justxt/BlackJack/assets/96129728/cd30c002-00bb-4c5a-8e01-fcbda8634a0c)


## Running the application

The project is a standard Maven project. To run it from the command line,
type `mvnw` (Windows), or `./mvnw` (Mac & Linux), then open
http://localhost:8080 in your browser.

You can also import the project to your IDE of choice as you would with any
Maven project. Read more on [how to import Vaadin projects to different IDEs](https://vaadin.com/docs/latest/guide/step-by-step/importing) (Eclipse, IntelliJ IDEA, NetBeans, and VS Code).

## Deploying to Production

To create a production build, call `mvnw clean package -Pproduction` (Windows),
or `./mvnw clean package -Pproduction` (Mac & Linux).
This will build a JAR file with all the dependencies and front-end resources,
ready to be deployed. The file can be found in the `target` folder after the build completes.

Once the JAR file is built, you can run it using
`java -jar target/blackjack-1.0-SNAPSHOT.jar`

## Project structure

- `MainLayout.java` in `src/main/java` contains the navigation setup (i.e., the
  side/top bar and the main menu). This setup uses
  [App Layout](https://vaadin.com/docs/components/app-layout).
- `views` package in `src/main/java` contains the server-side Java views of your application.
- `views` folder in `frontend/` contains the client-side JavaScript views of your application.
- `themes` folder in `frontend/` contains the custom CSS styles.

## Useful links

- Read the documentation at [vaadin.com/docs](https://vaadin.com/docs).
- Follow the tutorial at [vaadin.com/docs/latest/tutorial/overview](https://vaadin.com/docs/latest/tutorial/overview).
- Create new projects at [start.vaadin.com](https://start.vaadin.com/).
- Search UI components and their usage examples at [vaadin.com/docs/latest/components](https://vaadin.com/docs/latest/components).
- View use case applications that demonstrate Vaadin capabilities at [vaadin.com/examples-and-demos](https://vaadin.com/examples-and-demos).
- Build any UI without custom CSS by discovering Vaadin's set of [CSS utility classes](https://vaadin.com/docs/styling/lumo/utility-classes). 
- Find a collection of solutions to common use cases at [cookbook.vaadin.com](https://cookbook.vaadin.com/).
- Find add-ons at [vaadin.com/directory](https://vaadin.com/directory).
- Ask questions on [Stack Overflow](https://stackoverflow.com/questions/tagged/vaadin) or join our [Discord channel](https://discord.gg/MYFq5RTbBn).
- Report issues, create pull requests in [GitHub](https://github.com/vaadin).
