package com.example.application.views.e3;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("LENGUAJE")
@Route(value = "e3", layout = MainLayout.class)
public class E3View extends VerticalLayout {

    private final Label preguntaLabel;
    private final Button respuestaButtonA;
    private final Button respuestaButtonB;
    private final Button respuestaButtonC;

    private final String[] preguntas = {
            "¿Cuál es el sinónimo de \"alegría\"?",
            "¿Cuál es el verbo en la oración \"Ella canta una canción\"?",
            "¿Qué son las consonantes?",
            "¿Cuál es el antónimo de \"bueno\"?",
            "¿Qué es un adverbio?",
            "¿Cuál es el plural de \"libro\"?",
            "¿Qué es un sinónimo?",
            "¿Cuál es la función del punto y coma (;) en una oración?",
            "¿Qué es un sustantivo propio?",
            "¿Qué es un adjetivo calificativo?",
            "¿Cuál es el complemento directo en la oración \"Ella compró un libro\"?",
            "¿Cuál es el antónimo de \"alto\"?",
            "¿Cuál es la función del pronombre personal?"
    };

    private final String[][] respuestas = {
            {"a) Tristeza", "b) Felicidad", "c) Enfado"},
            {"a) Ella", "b) Canta", "c) Canción"},
            {"a) Sonidos vocálicos", "b) Sonidos silenciosos", "c) Sonidos no vocálicos"},
            {"a) Malo", "b) Grande", "c) Rápido"},
            {"a) Una persona, lugar o cosa", "b) Una acción o estado", "c) Una palabra que describe un verbo, adjetivo o adverbio"},
            {"a) Libres", "b) Libras", "c) Libros"},
            {"a) Una palabra que tiene el mismo significado que otra", "b) Una palabra que tiene el significado opuesto a otra", "c) Una palabra que no tiene ningún significado"},
            {"a) Indicar una pausa breve", "b) Separar dos ideas relacionadas", "c) Finalizar una oración"},
            {"a) Un sustantivo común que se refiere a una idea", "b) Un sustantivo que se utiliza para nombrar a una persona, lugar o cosa específica", "c) Un sustantivo que indica una acción o estado"},
            {"a) Una palabra que describe un verbo", "b) Una palabra que describe un sustantivo", "c) Una palabra que describe una acción"},
            {"a) Ella", "b) Compró", "c) Un libro"},
            {"a) Bajo", "b) Pequeño", "c) Largo"},
            {"a) Sustituir a un sustantivo en una oración", "b) Indicar una acción o estado", "c) Describir un verbo"}
    };

    private final String[] respuestasCorrectas = {
            "b) Felicidad",
            "b) Canta",
            "c) Sonidos no vocálicos",
            "a) Malo",
            "c) Una palabra que describe un verbo, adjetivo o adverbio",
            "c) Libros",
            "a) Una palabra que tiene el mismo significado que otra",
            "b) Separar dos ideas relacionadas",
            "b) Un sustantivo que se utiliza para nombrar a una persona, lugar o cosa específica",
            "b) Una palabra que describe un sustantivo",
            "c) Un libro",
            "a) Bajo",
            "a) Sustituir a un sustantivo en una oración"
    };

    private int preguntaActual = 0;
    private int puntajeTotal = 0;

    public E3View() {
        setSpacing(false);
        setMargin(false);
        setPadding(false);

        Image margPic = new Image("images/margen_pica.jpg", "margen pica");
        margPic.setWidth("350px");
        add(margPic);

        H2 header = new H2("Categoría: Lenguaje");
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

        Image demargPic = new Image("images/desmargen_trebol.jpg", "desmargen pica");
        demargPic.setWidth("350px");
        add(demargPic);
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
            H3 completadoLabel = new H3("¡CATEGORIA: LENGUAJE TERMINADA ;)!");
            Label puntajeLabel = new Label("Puntaje total: " + puntajeTotal);
            add(completadoLabel, puntajeLabel);

            H4 categoriasRestantesLabel = new H4("Categorías restantes:");
            add(categoriasRestantesLabel);

            HorizontalLayout categoriasLayout = new HorizontalLayout();
            categoriasLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
            categoriasLayout.setWidthFull();

            // Botones de categorías restantes
            Button matematicasButton = new Button("Matemáticas");
            matematicasButton.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("e4")));
            Button cienciasNaturalesButton = new Button("Ciencias Naturales");
            cienciasNaturalesButton.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("e5")));
            Button cienciasSocialesButton = new Button("Ciencias Sociales");
            cienciasSocialesButton.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("e6")));

            categoriasLayout.add(matematicasButton, cienciasNaturalesButton, cienciasSocialesButton);
            add(categoriasLayout);
        }
    }
}