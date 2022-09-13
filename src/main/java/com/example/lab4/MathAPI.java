package com.example.lab4;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class MathAPI {
    @RequestMapping(value = "/helloWorld", method = RequestMethod.GET)
    public String helloWorld() {
        return "Hello Test";
    }

    @RequestMapping (value = "/plus/{num1}/{num2}", method = RequestMethod.GET)
    public String myPlus(@PathVariable("num1") double num1, @PathVariable("num2") double num2){
        return String.valueOf(num1 + num2);
    }

    @RequestMapping (value = "/minus/{num1}/{num2}", method = RequestMethod.GET)
    public String myMinus(@PathVariable("num1") double num1, @PathVariable("num2") double num2){
        return String.valueOf(num1 - num2);
    }

    @RequestMapping (value = "/divide/{num1}/{num2}", method = RequestMethod.GET)
    public String myDivide(@PathVariable("num1") double num1, @PathVariable("num2") double num2){
        return String.valueOf(num1 / num2);
    }

    @RequestMapping (value = "/multi/{num1}/{num2}", method = RequestMethod.GET)
    public String myMulti(@PathVariable("num1") double num1, @PathVariable("num2") double num2){
        return String.valueOf(num1 * num2);
    }

    @RequestMapping (value = "/mod/{num1}/{num2}", method = RequestMethod.GET)
    public String myMod(@PathVariable("num1") double num1, @PathVariable("num2") double num2){
        return String.valueOf(num1 % num2);
    }

    @RequestMapping (value = "/max", method = RequestMethod.POST)
    public String myMax(@RequestBody MultiValueMap<String, String> num){
        Map<String, String> d = num.toSingleValueMap();
        Double n1 = (Double.parseDouble(d.get("num1")));
        Double n2 = (Double.parseDouble(d.get("num2")));
        if(n1 > n2){
            return n1+"";
        }
        else{
            return n2+"";
        }
    }
}

