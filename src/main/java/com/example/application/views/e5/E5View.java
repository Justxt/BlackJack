package com.example.application.views.e5;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("CIENCIAS NATURALES")
@Route(value = "e5", layout = MainLayout.class)
public class E5View extends VerticalLayout {

    private final Label preguntaLabel;
    private final Button rButtonA;
    private final Button rButtonB;
    private final Button rButtonC;

    private final String[] preguntas = {
            "¿Cuál es la capa más externa de la Tierra?",
            "¿Cuál es la función principal del corazón?",
            "¿Cuál de los siguientes animales es ovíparo?",
            "¿Cuál es el proceso por el cual las plantas obtienen energía del sol?",
            "¿Cuál es el planeta más cercano al Sol?",
            "¿Cuál es el componente principal del aire que respiramos?",
            "¿Cuál es la función principal de los riñones en el cuerpo humano?",
            "¿Cuál es el órgano encargado de la digestión de los alimentos?",
            "¿Cuál es el gas más abundante en la atmósfera terrestre?",
            "¿Cuál es el proceso de transformación de un insecto desde su estado larval hasta su forma adulta?",
            "¿Cuál es la función principal de la clorofila en las plantas?",
            "¿Cuál es el proceso por el cual las plantas liberan oxígeno al ambiente?",
            "¿Cuál es el órgano encargado de la visión en el cuerpo humano?"
    };

    private final String[][] respuestas = {
            {"a) Núcleo", "b) Manto", "c) Corteza"},
            {"a) Bombea sangre a los pulmones", "b) Bombea sangre a todo el cuerpo", "c) Almacena la sangre"},
            {"a) Perro", "b) Vaca", "c) Gallina"},
            {"a) Fotosíntesis", "b) Respiración", "c) Transpiración"},
            {"a) Venus", "b) Mercurio", "c) Marte"},
            {"a) Oxígeno", "b) Nitrógeno", "c) Dióxido de carbono"},
            {"a) Filtrar la sangre y eliminar desechos", "b) Producir hormonas", "c) Controlar la respiración"},
            {"a) Estómago", "b) Hígado", "c) Pulmones"},
            {"a) Oxígeno", "b) Nitrógeno", "c) Dióxido de carbono"},
            {"a) Metamorfosis", "b) Germinación", "c) Fertilización"},
            {"a) Capturar la luz del sol para la fotosíntesis", "b) Transportar nutrientes a través de la planta", "c) Regular la respiración de la planta"},
            {"a) Respiración", "b) Fotosíntesis", "c) Evaporación"},
            {"a) Oído", "b) Nariz", "c) Ojo"}
    };

    private final String[] respuestasCorrectas = {
            "c) Corteza",
            "b) Bombea sangre a todo el cuerpo",
            "c) Gallina",
            "a) Fotosíntesis",
            "b) Mercurio",
            "a) Oxígeno",
            "a) Filtrar la sangre y eliminar desechos",
            "a) Estómago",
            "b) Nitrógeno",
            "a) Metamorfosis",
            "a) Capturar la luz del sol para la fotosíntesis",
            "b) Fotosíntesis",
            "c) Ojo"
    };

    private int preguntaActual = 0;
    private int puntajeTotal = 0;

    public E5View() {
        setSpacing(false);
        setMargin(false);
        setPadding(false);

        Image margTre = new Image("images/margen_trebol.jpg", "margen trebol");
        margTre.setWidth("350px");
        add(margTre);

        H2 header = new H2("Categoría: Ciencias Naturales");
        add(header);

        preguntaLabel = new Label(preguntas[preguntaActual]);
        rButtonA = new Button(respuestas[preguntaActual][0]);
        rButtonB = new Button(respuestas[preguntaActual][1]);
        rButtonC = new Button(respuestas[preguntaActual][2]);

        rButtonA.addClickListener(e -> evRes(rButtonA.getText()));
        rButtonB.addClickListener(e -> evRes(rButtonB.getText()));
        rButtonC.addClickListener(e -> evRes(rButtonC.getText()));

        add(preguntaLabel, rButtonA, rButtonB, rButtonC);

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        Image demargTre = new Image("images/desmargen_trebol.jpg", "desmargen_trebol");
        demargTre.setWidth("350px");
        add(demargTre);
    }

    private void evRes(String respuesta) {
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
        siguienteButton.addClickListener(e -> sigPreg(dialog));
        contentLayout.add(siguienteButton);

        dialog.add(contentLayout);
        dialog.open();
    }

    private void sigPreg(Dialog dialog) {
        dialog.close();

        preguntaActual++;

        if (preguntaActual < preguntas.length) {
            preguntaLabel.setText(preguntas[preguntaActual]);
            rButtonA.setText(respuestas[preguntaActual][0]);
            rButtonB.setText(respuestas[preguntaActual][1]);
            rButtonC.setText(respuestas[preguntaActual][2]);
        } else {
            removeAll();
            H3 completadoLabel = new H3("¡CATEGORIA: CIENCIAS NATURALES TERMINADA ;)!");
            Label puntajeLabel = new Label("Puntaje total: " + puntajeTotal);
            add(completadoLabel, puntajeLabel);

            // Categorías restantes
            H4 categoriasRestantesLabel = new H4("Categorías faltantes:");
            add(categoriasRestantesLabel);

            HorizontalLayout canCon = new HorizontalLayout();
            canCon.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
            canCon.setWidthFull();

            Button cienciasSocialesButton = new Button("Ciencias Sociales");
            cienciasSocialesButton.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("e6")));

            canCon.add(cienciasSocialesButton);
            add(canCon);
        }
    }
}
