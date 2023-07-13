package com.example.application.views;

import com.example.application.views.e1.E1View;
import com.example.application.views.e10.E10View;
import com.example.application.views.e2.E2View;
import com.example.application.views.e3.E3View;
import com.example.application.views.e4.E4View;
import com.example.application.views.e5.E5View;
import com.example.application.views.e6.E6View;
import com.example.application.views.e7.E7View;
import com.example.application.views.e8.E8View;
import com.example.application.views.e9.E9View;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.vaadin.lineawesome.LineAwesomeIcon;

/**
 * The main view is a top-level placeholder for other views.
 */
public class MainLayout extends AppLayout {

    private H2 viewTitle;

    public MainLayout() {
        setPrimarySection(Section.DRAWER);
        addDrawerContent();
        addHeaderContent();
    }

    private void addHeaderContent() {
        DrawerToggle toggle = new DrawerToggle();
        toggle.getElement().setAttribute("aria-label", "Menu toggle");

        viewTitle = new H2();
        viewTitle.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);

        addToNavbar(true, toggle, viewTitle);
    }

    private void addDrawerContent() {
        H1 appName = new H1("BlackJack");
        appName.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);
        Header header = new Header(appName);

        Scroller scroller = new Scroller(createNavigation());

        addToDrawer(header, scroller, createFooter());
    }

    private SideNav createNavigation() {
        SideNav nav = new SideNav();

        nav.addItem(new SideNavItem("E1", E1View.class, LineAwesomeIcon.FILE.create()));
        nav.addItem(new SideNavItem("E2", E2View.class, LineAwesomeIcon.FILE.create()));
        nav.addItem(new SideNavItem("E3", E3View.class, LineAwesomeIcon.FILE.create()));
        nav.addItem(new SideNavItem("E4", E4View.class, LineAwesomeIcon.FILE.create()));
        nav.addItem(new SideNavItem("E5", E5View.class, LineAwesomeIcon.FILE.create()));
        nav.addItem(new SideNavItem("E6", E6View.class, LineAwesomeIcon.FILE.create()));
        nav.addItem(new SideNavItem("E7", E7View.class, LineAwesomeIcon.FILE.create()));
        nav.addItem(new SideNavItem("E8", E8View.class, LineAwesomeIcon.FILE.create()));
        nav.addItem(new SideNavItem("E9", E9View.class, LineAwesomeIcon.FILE.create()));
        nav.addItem(new SideNavItem("E10", E10View.class, LineAwesomeIcon.FILE.create()));

        return nav;
    }

    private Footer createFooter() {
        Footer layout = new Footer();

        return layout;
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        viewTitle.setText(getCurrentPageTitle());
    }

    private String getCurrentPageTitle() {
        PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
        return title == null ? "" : title.value();
    }
}
