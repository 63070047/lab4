package com.example.lab4;
import org.springframework.boot.env.ConfigTreePropertySource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
@RestController
public class Cashier {
    @RequestMapping(value = "/getChange/{money}", method = RequestMethod.GET)
    public Change getChange(@PathVariable("money") int money){
        Change c = new Change();
        c.setB1000(money/1000);
        c.setB500(money%1000/500);
        c.setB100(money%1000%500/100);
        c.setB20(money%1000%500%100/20);
        c.setB10(money%1000%500%100%20/10);
        c.setB5(money%1000%500%100%20%10/5);
        c.setB1(money%1000%500%100%20%10%5/1);
        return c;
    }
}
