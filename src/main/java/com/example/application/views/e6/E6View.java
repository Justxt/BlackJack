package com.example.application.views.e6;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("CIENCIAS SOCIALES")
@Route(value = "e6", layout = MainLayout.class)
public class E6View extends VerticalLayout {

    private final Label preguntaLabel;
    private final Button respuestaButtonA;
    private final Button respuestaButtonB;
    private final Button respuestaButtonC;

    private final String[] preguntas = {
            "¿Cuál es la capital de Estados Unidos?",
            "¿Cuál es el sistema económico en el que los recursos son propiedad del Estado?",
            "¿Cuál es el océano más grande del mundo?",
            "¿Cuál es la moneda de Japón?",
            "¿Cuál es el continente más poblado del mundo?",
            "¿Cuál es el sistema de gobierno en el que el poder recae en un monarca?",
            "¿Cuál es el país más grande del mundo por área territorial?",
            "¿Cuál es el idioma más hablado del mundo?",
            "¿Cuál es el país más poblado del mundo?",
            "¿Cuál es el río más largo del mundo?",
            "¿Cuál es la religión predominante en India?",
            "¿Cuál es la ciudad conocida como 'La Ciudad Eterna'?",
            "¿Cuál es el continente más pequeño del mundo por área territorial?"
    };

    private final String[][] respuestas = {
            {"a) Washington D.C.", "b) Nueva York", "c) Los Ángeles"},
            {"a) Capitalismo", "b) Socialismo", "c) Comunismo"},
            {"a) Atlántico", "b) Pacífico", "c) Índico"},
            {"a) Euro", "b) Dólar", "c) Yen"},
            {"a) Asia", "b) África", "c) Europa"},
            {"a) Democracia", "b) Monarquía", "c) República"},
            {"a) Rusia", "b) Estados Unidos", "c) China"},
            {"a) Inglés", "b) Español", "c) Mandarín"},
            {"a) India", "b) China", "c) Estados Unidos"},
            {"a) Amazonas", "b) Nilo", "c) Yangtsé"},
            {"a) Islam", "b) Hinduismo", "c) Cristianismo"},
            {"a) París", "b) Roma", "c) Atenas"},
            {"a) Europa", "b) Australia", "c) Oceanía"}
    };

    private final String[] respuestasCorrectas = {
            "a) Washington D.C.",
            "c) Comunismo",
            "b) Pacífico",
            "c) Yen",
            "a) Asia",
            "b) Monarquía",
            "a) Rusia",
            "c) Mandarín",
            "b) China",
            "b) Nilo",
            "b) Hinduismo",
            "b) Roma",
            "c) Oceanía"
    };

    private int preguntaActual = 0;
    private int puntajeTotal = 0;

    public E6View() {
        setSpacing(false);
        setMargin(false);
        setPadding(false);

        Image margDia = new Image("images/margen_diamante.jpg", "margen diamante");
        margDia.setWidth("350px");
        add(margDia);

        H2 header = new H2("Categoría: Ciencias Sociales");
        add(header);

        preguntaLabel = new Label(preguntas[preguntaActual]);
        respuestaButtonA = new Button(respuestas[preguntaActual][0]);
        respuestaButtonB = new Button(respuestas[preguntaActual][1]);
        respuestaButtonC = new Button(respuestas[preguntaActual][2]);

        respuestaButtonA.addClickListener(e -> evaluarRespuesta(respuestaButtonA.getText()));
        respuestaButtonB.addClickListener(e -> evaluarRespuesta(respuestaButtonB.getText()));
        respuestaButtonC.addClickListener(e -> evaluarRespuesta(respuestaButtonC.getText()));

        add(preguntaLabel, respuestaButtonA, respuestaButtonB, respuestaButtonC);

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        Image demargImg = new Image("images/desmargen.jpg", "desmargen");
        demargImg.setWidth("350px");
        add(demargImg);
    }

    private void evaluarRespuesta(String respuesta) {
        Dialog dialog = new Dialog();
        dialog.setCloseOnOutsideClick(false);

        VerticalLayout contentLayout = new VerticalLayout();
        contentLayout.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);

        if (respuesta.equals(respuestasCorrectas[preguntaActual])) {
            dialog.add(new Label("¡Respuesta Correcta!"));
            int puntos = preguntaActual + 1;
            puntajeTotal += puntos;
        } else {
            dialog.add(new Label("Respuesta Incorrecta"));
        }

        Button siguienteButton = new Button("Siguiente");
        siguienteButton.addClickListener(e -> mostrarSiguientePregunta(dialog));
        contentLayout.add(siguienteButton);

        dialog.add(contentLayout);
        dialog.open();
    }

    private void mostrarSiguientePregunta(Dialog dialog) {
        dialog.close();

        preguntaActual++;

        if (preguntaActual < preguntas.length) {
            preguntaLabel.setText(preguntas[preguntaActual]);
            respuestaButtonA.setText(respuestas[preguntaActual][0]);
            respuestaButtonB.setText(respuestas[preguntaActual][1]);
            respuestaButtonC.setText(respuestas[preguntaActual][2]);
        } else {
            removeAll();

            H2 completadoLabel = new H2("¡Has completado todas las preguntas!");
            H3 completadoLabel1 = new H3("¡CATEGORIA: LENGUAJE TERMINADA ;)!");
            Label puntajeLabel = new Label("Puntaje total: " + puntajeTotal);
            add(completadoLabel, puntajeLabel);

            // Botón Continuar
            Button continuarButton = new Button("Continuar");
            continuarButton.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("e7")));
            add(continuarButton);
        }
    }
}
