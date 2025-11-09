package com.example.service.impl;

import com.example.service.Sim;

public class Banglalink implements Sim {
    @Override
    public void calling() {
        System.out.println("Banglalink Calling");
    }

    @Override
    public void data() {
        System.out.println("Banglalink Data");
    }
}
