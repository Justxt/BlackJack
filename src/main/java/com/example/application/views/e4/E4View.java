package com.example.application.views.e4;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("MATEMATICAS")
@Route(value = "e4", layout = MainLayout.class)
public class E4View extends VerticalLayout {

    private final Label preguntaLabel;
    private final Button rButtonA;
    private final Button rButtonB;
    private final Button rButtonC;

    private final String[] preguntas = {
            "¿Cuánto es 5 x 3?",
            "¿Cuál es la fracción equivalente a 3/4?",
            "¿Cuál es el resultado de 10 - 7?",
            "¿Cuál es la forma simplificada de la fracción 8/12?",
            "¿Cuál es la suma de 20 + 5?",
            "¿Cuánto es el doble de 6?",
            "¿Cuál es la raíz cuadrada de 64?",
            "¿Cuánto es 1/2 más 1/4?",
            "¿Cuál es el resultado de 3^2?",
            "¿Cuál es el número siguiente en la serie: 2, 4, 6, 8, ...?",
            "¿Cuál es el número más grande: -5, -10, -2?",
            "¿Cuál es el resultado de 9 ÷ 3?",
            "¿Cuánto es 1/3 de 60?"
    };

    private final String[][] respuestas = {
            {"a) 8", "b) 15", "c) 18"},
            {"a) 1/2", "b) 2/3", "c) 4/5"},
            {"a) 1", "b) 3", "c) 7"},
            {"a) 2/4", "b) 3/6", "c) 2/3"},
            {"a) 15", "b) 20", "c) 25"},
            {"a) 6", "b) 12", "c) 18"},
            {"a) 4", "b) 8", "c) 16"},
            {"a) 1/6", "b) 3/4", "c) 3/8"},
            {"a) 3", "b) 6", "c) 9"},
            {"a) 10", "b) 12", "c) 14"},
            {"a) -5", "b) -10", "c) -2"},
            {"a) 3", "b) 6", "c) 9"},
            {"a) 10", "b) 20", "c) 30"}
    };

    private final String[] respuestasCorrectas = {
            "b) 15",
            "b) 2/3",
            "b) 3",
            "c) 2/3",
            "c) 25",
            "b) 12",
            "b) 8",
            "b) 3/4",
            "c) 9",
            "b) 12",
            "c) -2",
            "a) 3",
            "c) 30"
    };

    private int preguntaActual = 0;
    private int puntajeTotal = 0;

    public E4View() {
        setSpacing(false);
        setMargin(false);
        setPadding(false);

        Image margImg = new Image("images/margen.jpg", "margen");
        margImg.setWidth("350px");
        add(margImg);

        H2 header = new H2("Categoría: Matemáticas");
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

        Image demargImg = new Image("images/desmargen.jpg", "desmargen");
        demargImg.setWidth("350px");
        add(demargImg);
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
            H3 completadoLabel = new H3("¡CATEGORIA: MATEMATICAS TERMINADA ;)!");
            Label puntajeLabel = new Label("Puntaje total: " + puntajeTotal);
            add(completadoLabel, puntajeLabel);

            H4 categoriasRestantesLabel = new H4("Categorías faltantes:");
            add(categoriasRestantesLabel);

            HorizontalLayout cateCon = new HorizontalLayout();
            cateCon.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
            cateCon.setWidthFull();

            Button cienciasNaturalesButton = new Button("Ciencias Naturales");
            cienciasNaturalesButton.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("e5")));
            Button cienciasSocialesButton = new Button("Ciencias Sociales");
            cienciasSocialesButton.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("e6")));

            cateCon.add(cienciasNaturalesButton, cienciasSocialesButton);
            add(cateCon);
        }
    }
}
