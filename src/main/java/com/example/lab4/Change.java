package com.example.lab4;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Change implements Serializable {
    private int b1000, b500, b100, b20, b10, b5, b1;
    public void setB1000(int n){
        b1000 = n;
    }
    public void setB500(int n){
        b500 = n;
    }
    public void setB100(int n){
        b100 = n;
    }
    public void setB20(int n){
        b20 = n;
    }
    public void setB10(int n){
        b10 = n;
    }
    public void setB5(int n){
        b5 = n;
    }
    public void setB1(int n){
        b1 = n;
    }

    public int getB1000() {
        return b1000;
    }

    public int getB500() {
        return b500;
    }

    public int getB100() {
        return b100;
    }

    public int getB20() {
        return b20;
    }

    public int getB10() {
        return b10;
    }

    public int getB5() {
        return b5;
    }

    public int getB1() {
        return b1;
    }
}

