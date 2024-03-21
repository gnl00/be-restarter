package com.rstr.cus;

public class CusRestarter {

    public static volatile Boolean INITIALIZED = false;

    private String[] args;

    private CusRestarter(String[] args) {
        this.args = args;
    }

    public static void initialize(String[] args) {
        if (!INITIALIZED) {
            synchronized (CusRestarter.class) {
                if (!INITIALIZED) {
                    CusRestarter restarter = new CusRestarter(args);
                    restarter.initialize();
                    INITIALIZED = true;
                }
            }
        }
    }

    private void initialize() {}
}
