package com.example.application.views.e1;

import com.example.application.views.MainLayout;
import com.example.application.views.e2.E2View;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("BLACKJACK")
@Route(value = "e1", layout = MainLayout.class)
public class E1View extends VerticalLayout {

    public E1View() {
        setSpacing(false);

        Image img = new Image("images/inicio.jpg", "placeholder inicio");
        img.setWidth("500px");
        add(img);

        Button comenzarButton = new Button("COMENZAR");
        comenzarButton.addClickListener(e -> navegarA());
        add(comenzarButton);

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
    }

    private void navegarA() {
        getUI().ifPresent(ui -> ui.navigate(E2View.class));
    }
}