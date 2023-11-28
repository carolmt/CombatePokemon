package com.example.combatepokemon;

import android.util.Log;

import java.util.Random;

public class SimuladorCombate {

    public SimuladorCombate() {

    }
    public static class Pokemon {
        private String nombre;
        private int ataque;
        private int hp;
        private int defensa;
        private int ataqueEspecial;
        private int defensaEspecial;
        int danyoRecibido = 0;

        public Pokemon(String nombre, int ataque, int hp, int defensa, int ataqueEspecial, int defensaEspecial) {
            this.nombre = nombre;
            this.ataque = ataque;
            this.hp = hp;
            this.defensa = defensa;
            this.ataqueEspecial = ataqueEspecial;
            this.defensaEspecial = defensaEspecial;
            danyoRecibido = 0;
        }

        public Pokemon(int ataque, int hp, int defensa, int ataqueEspecial, int defensaEspecial) {
            this.ataque = ataque;
            this.hp = hp;
            this.defensa = defensa;
            this.ataqueEspecial = ataqueEspecial;
            this.defensaEspecial = defensaEspecial;
            danyoRecibido = 0;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getAtaque() {
            return ataque;
        }

        public void setAtaque(int ataque) {
            this.ataque = ataque;
        }

        public int getHp() {
            return hp;
        }

        public void setHp(int hp) {
            this.hp = hp;
        }

        public int getDefensa() {
            return defensa;
        }

        public void setDefensa(int defensa) {
            this.defensa = defensa;
        }

        public int getAtaqueEspecial() {
            return ataqueEspecial;
        }

        public void setAtaqueEspecial(int ataqueEspecial) {
            this.ataqueEspecial = ataqueEspecial;
        }

        public int getDefensaEspecial() {
            return defensaEspecial;
        }

        public void setDefensaEspecial(int defensaEspecial) {
            this.defensaEspecial = defensaEspecial;
        }

        public int getDanyoRecibido() {
            return danyoRecibido;
        }

        public void setDanyoRecibido(int danyoRecibido) {
            this.danyoRecibido = danyoRecibido;
        }

        public int generarAleatorio() {
            Random rnd = new Random();
            return rnd.nextInt(100);
        }
    }

    interface Callback {
        void cuandoSeAtaca(int salud);
    }

    public int recibirAtaque(Pokemon atacante, Pokemon defensor, Callback callback) {

        int aleatorio = atacante.generarAleatorio();
        int danyo;

        if (aleatorio % 5 == 0) { //saco un aleatorio del 0 a 100 y si es divisble entre 5 lanzará un ataque especial.
            danyo = atacante.getAtaqueEspecial();
        }
        else {
            danyo = atacante.getAtaque();
        }

        defensor.setDanyoRecibido(danyo); // al p2 le sumaremos al daño el taqeue especial del p1.
        defensor.setHp(defensor.getHp() - defensor.getDanyoRecibido() + (aleatorio % 5 == 0 ? defensor.getDefensaEspecial() : defensor.getDefensa()));

        callback.cuandoSeAtaca(defensor.getHp());
        return defensor.getHp(); // devolvemos la salud modificada.

    }

}
