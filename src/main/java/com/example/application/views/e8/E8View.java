package com.example.application.views.e8;

import com.example.application.views.MainLayout;
import com.example.application.views.e1.E1View;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;

import java.util.Random;

@PageTitle("E8")
@Route(value = "e8", layout = MainLayout.class)
public class E8View extends VerticalLayout {

    public E8View() {
        setSpacing(false);

        H2 header = new H2("¡Resultados Finales!");
        header.addClassNames(Margin.Top.XLARGE, Margin.Bottom.MEDIUM);
        add(header);

        Image demargImg = new Image("images/desmargen.jpg", "desmargen");
        demargImg.setWidth("350px");
        add(demargImg);

        int punLengua = punAlea();
        int punMatematicas = punAlea();
        int punCienciasNaturales = punAlea();
        int punCienciasSociales = punAlea();

        int totalPuntaje = punLengua + punMatematicas + punCienciasNaturales + punCienciasSociales;

        Paragraph resultado = new Paragraph();
        resultado.setText("El puntaje total es: " + totalPuntaje);
        add(resultado);

        String mensaje;

        if (totalPuntaje == 21) {
            mensaje = "¡Blackjack! Se te duplican los puntos";
            totalPuntaje *= 2;
        } else if (totalPuntaje == 30) {
            mensaje = "¡Trio! Se te suman 15 puntos";
            totalPuntaje += 15;
        } else if (totalPuntaje == 52) {
            mensaje = "¡POKER! ¡GANASTE!";
        } else if (totalPuntaje == 40) {
            mensaje = "¡Cuarenta! Se te suman 10 puntos";
            totalPuntaje += 10;
        } else if (totalPuntaje == 4) {
            mensaje = "¡Rey del As! Se te suman 40 puntos";
            totalPuntaje += 40;
        } else if (totalPuntaje == 20) {
            mensaje = "¡Pareja! Se te suman 20 puntos";
            totalPuntaje += 20;
        } else if (totalPuntaje == 13) {
            mensaje = "¡Rey de Reyes! Se te suman 15 puntos";
            totalPuntaje += 15;
        } else {
            Image sadMan = new Image("images/sadman.jpg", "SadSpider");
            sadMan.setWidth("350px");
            add(sadMan);
            mensaje = "OHHHH, PERDISTE JASLDJ";
        }

        Paragraph mensajeResultado = new Paragraph();
        mensajeResultado.setText(mensaje);
        add(mensajeResultado);

        Button reiniciarButton = new Button("REINICIAR");
        reiniciarButton.addClickListener(e -> restart());
        add(reiniciarButton);

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }

    private int punAlea() {
        Random random = new Random();
        return random.nextInt(11) + 1;
    }

    private void restart() {
        getUI().ifPresent(ui -> ui.navigate(E1View.class));
    }
}
