package com.example.application.views.e2;

import com.example.application.views.MainLayout;
import com.example.application.views.e3.E3View;
import com.example.application.views.e4.E4View;
import com.example.application.views.e5.E5View;
import com.example.application.views.e6.E6View;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@PageTitle("CATEGORIAS!")
@Route(value = "e2", layout = MainLayout.class)
public class E2View extends VerticalLayout {

    public E2View() {
        setSpacing(false);
        setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);

        H2 header = new H2("CATEGORIAS");
        add(header);

        Image lenguajeImg = new Image("images/lenguaje.jpg", "Lenguaje");
        lenguajeImg.setWidth("200px");
        RouterLink lenguajeLink = new RouterLink("Lenguaje", E3View.class);

        Image matematicasImg = new Image("images/matematicas.jpg", "Matemáticas");
        matematicasImg.setWidth("200px");
        RouterLink matematicasLink = new RouterLink("Matemáticas", E4View.class);

        Image cienciasNaturalesImg = new Image("images/ciencias_naturales.jpg", "Ciencias Naturales");
        cienciasNaturalesImg.setWidth("200px");
        RouterLink cienciasNaturalesLink = new RouterLink("Ciencias Naturales", E5View.class);

        Image cienciasSocialesImg = new Image("images/ciencias_sociales.jpg", "Ciencias Sociales");
        cienciasSocialesImg.setWidth("200px");
        RouterLink cienciasSocialesLink = new RouterLink("Ciencias Sociales", E6View.class);

        VerticalLayout lenguajeLayout = new VerticalLayout(lenguajeImg, lenguajeLink);
        VerticalLayout matematicasLayout = new VerticalLayout(matematicasImg, matematicasLink);
        VerticalLayout cienciasNaturalesLayout = new VerticalLayout(cienciasNaturalesImg, cienciasNaturalesLink);
        VerticalLayout cienciasSocialesLayout = new VerticalLayout(cienciasSocialesImg, cienciasSocialesLink);

        lenguajeLayout.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);
        matematicasLayout.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);
        cienciasNaturalesLayout.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);
        cienciasSocialesLayout.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);

        HorizontalLayout categoriesLayout = new HorizontalLayout(lenguajeLayout, matematicasLayout, cienciasNaturalesLayout, cienciasSocialesLayout);
        categoriesLayout.setSpacing(true);
        categoriesLayout.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);

        add(categoriesLayout);

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
    }
}