package com.example.combatepokemon;

import java.util.Random;

public class SimuladorCombate {
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

    public int recibirAtaque(Pokemon atacante, Pokemon defensor) {

        int aleatorio = atacante.generarAleatorio();

        if (aleatorio % 5 == 0) { //saco un aleatorio del 0 a 100 y si es divisble entre 5 lanzará un ataque especial.
            defensor.setDanyoRecibido(atacante.getAtaqueEspecial()); // al p2 le sumaremos al daño el taqeue especial del p1.
            defensor.setHp(defensor.getHp()-defensor.getDanyoRecibido()+defensor.getDefensaEspecial()); // entonces modificamos la salud del p2 atacado restando el daño y sumando la defensa correspondiente
        }
        else {
            defensor.setDanyoRecibido(atacante.getAtaque()); // aqui hago lo mismo que arriba pero con ataque normal.
            defensor.setHp(defensor.getHp()-defensor.getDanyoRecibido()+defensor.getDefensa());
        }
        return defensor.getHp(); // devolvemos la salud modificada.

    }

}
