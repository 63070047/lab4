package com.example.lab4;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;
import org.springframework.web.reactive.function.client.WebClient;

@Route(value = "index2")
public class CashierView extends VerticalLayout {
    private TextArea t1, t2, t3, t4, t5, t6, t7, t8;
    private Button b1;

    public CashierView() {
        t1 = new TextArea("เงินทอน");
        t1.setPlaceholder("$ ");

        b1 = new Button("คำนวณเงินทอน");

        t2 = new TextArea();
        t2.setPlaceholder("$1000: ");
        t3 = new TextArea();
        t3.setPlaceholder("$500: ");
        t4 = new TextArea();
        t4.setPlaceholder("$100: ");
        t5 = new TextArea();
        t5.setPlaceholder("$20: ");
        t6 = new TextArea();
        t6.setPlaceholder("$10: ");
        t7 = new TextArea();
        t7.setPlaceholder("$5: ");
        t8 = new TextArea();
        t8.setPlaceholder("$1: ");

        add(t1, b1, t2, t3, t4, t5, t6, t7, t8);

        b1.addClickListener(event -> {
            int money = Integer.parseInt(t1.getValue());
            Change out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/getChange/"+ money)
                    .retrieve()
                    .bodyToMono(Change.class)
                    .block();

            t2.setValue("$1000: " + out.getB1000()+"");
            t3.setValue("$500: " + out.getB500()+"");
            t4.setValue("$100: " + out.getB100()+"");
            t5.setValue("$20: " + out.getB20()+"");
            t6.setValue("$10: " + out.getB10()+"");
            t7.setValue("$5: " + out.getB5()+"");
            t8.setValue("$1: " + out.getB1()+"");
        });
    }
}
