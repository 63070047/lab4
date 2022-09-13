package com.example.lab4;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Route(value = "index1")
public class MathView extends VerticalLayout {
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private TextField txt1;
    private TextField txt2;
    private TextField txt3;
    private double n1, n2;

    private Label lbl1;
    public MathView(){
        btn1 = new Button("+");
        btn2 = new Button("-");
        btn3 = new Button("x");
        btn4 = new Button("/");
        btn5 = new Button("Mod");
        btn6 = new Button("Max");
        txt1 = new TextField("Number 1");
        txt2 = new TextField("Number 2");
        txt3 = new TextField("Result");
        lbl1 = new Label("Operators");

        HorizontalLayout hrz = new HorizontalLayout();
        hrz.add(btn1, btn2, btn3, btn4, btn5, btn6);

        //Add Elements
        add(txt1, txt2, lbl1);
        add(hrz);
        add(txt3);
        btn1.addClickListener(event ->{
            Double num1 = Double.parseDouble(txt1.getValue());
            Double num2 = Double.parseDouble(txt2.getValue());

            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/plus/"+ num1 + "/" + num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            txt3.setValue(out);
        });
        btn2.addClickListener(event ->{
            Double num1 = Double.parseDouble(txt1.getValue());
            Double num2 = Double.parseDouble(txt2.getValue());

            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/minus/"+ num1 + "/" + num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            txt3.setValue(out);
        });
        btn3.addClickListener(event ->{
            Double num1 = Double.parseDouble(txt1.getValue());
            Double num2 = Double.parseDouble(txt2.getValue());

            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/multi/"+ num1 + "/" + num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            txt3.setValue(out);
        });
        btn4.addClickListener(event ->{
            Double num1 = Double.parseDouble(txt1.getValue());
            Double num2 = Double.parseDouble(txt2.getValue());

            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/divide/"+ num1 + "/" + num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            txt3.setValue(out);
        });
        btn5.addClickListener(event ->{
            Double num1 = Double.parseDouble(txt1.getValue());
            Double num2 = Double.parseDouble(txt2.getValue());

            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/mod/"+ num1 + "/" + num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            txt3.setValue(out);
        });
        btn6.addClickListener(event ->{
            MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
            formData.add("num1", txt1.getValue());
            formData.add("num2", txt2.getValue());

            String out = WebClient.create()
                    .post()
                    .uri("http://localhost:8080/max")
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .body(BodyInserters.fromFormData(formData))
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            txt3.setValue(out);
        });
    }
}

