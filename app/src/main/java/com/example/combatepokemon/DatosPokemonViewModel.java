package com.example.combatepokemon;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.AndroidViewModel;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class DatosPokemonViewModel extends AndroidViewModel {
    Executor executor;

    SimuladorCombate simulador;
    MutableLiveData<Integer> vistaHp1 = new MutableLiveData<>();
    MutableLiveData<Integer> vistaHp2 = new MutableLiveData<>();

    public DatosPokemonViewModel(@NonNull Application application) {
        super(application);

        executor = Executors.newSingleThreadExecutor();
        simulador = new SimuladorCombate();
    }
    public void recibirAtaque(int ataque, int hp, int defensa, int ataqueEspecial, int defensaEspecial,
                                int ataque2, int hp2, int defensa2, int ataqueEspecial2, int defensaEspecial2) {

        SimuladorCombate.Pokemon atacante = new SimuladorCombate.Pokemon(ataque, hp, defensa, ataqueEspecial, defensaEspecial);
        SimuladorCombate.Pokemon defensor = new SimuladorCombate.Pokemon(ataque2,  hp2,  defensa2,  ataqueEspecial2, defensaEspecial2);

        int saludRestante = simulador.recibirAtaque(atacante, defensor);

        // Actualizar las MutableLiveData con la nueva salud
        executor.execute(() -> {
            vistaHp1.postValue(atacante.getHp());
            vistaHp2.postValue(defensor.getHp());
        });
        executor.execute(new Runnable() {
            @Override
            public void run() {
                int saludRestante = simulador.recibirAtaque(atacante, defensor);
                vistaHp2.postValue(saludRestante);
            }
        });
    }
}