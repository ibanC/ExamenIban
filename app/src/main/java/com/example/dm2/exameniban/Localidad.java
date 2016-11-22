package com.example.dm2.exameniban;

/**
 * Created by dm2 on 22/11/2016.
 */
public class Localidad {

    private String pueblo;
    private String habitantes;
    private String superficie;
    private String web;

    public Localidad(String habitantes, String pueblo, String superficie, String web) {
        this.habitantes = habitantes;
        this.pueblo = pueblo;
        this.superficie = superficie;
        this.web = web;
    }

    public String getHabitantes() {
        return habitantes;
    }

    public String getPueblo() {
        return pueblo;
    }

    public String getWeb() {
        return web;
    }

    public String getSuperficie() {
        return superficie;
    }
}
