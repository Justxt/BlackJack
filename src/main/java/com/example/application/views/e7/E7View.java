package com.example.application.views.e7;

import com.example.application.views.MainLayout;
import com.example.application.views.e2.E2View;
import com.example.application.views.e8.E8View;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;

@PageTitle("E7")
@Route(value = "e7", layout = MainLayout.class)
public class E7View extends VerticalLayout {

    public E7View() {
        setSpacing(false);

        H1 header = new H1("GUIA");
        add(header);

        Image img = new Image("images/referencia.jpg", "referencia");
        img.setWidth("700px");
        add(img);

        Button comenzarButton = new Button("CONTINUAR");
        comenzarButton.addClickListener(e -> navigateToNextView());

        add(comenzarButton);

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
    }

    private void navigateToNextView() {
        getUI().ifPresent(ui -> ui.navigate(E8View.class));
    }
}
