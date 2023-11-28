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
    boolean pokemon1 = true;

    public DatosPokemonViewModel(@NonNull Application application) {
        super(application);

        executor = Executors.newSingleThreadExecutor();
        simulador = new SimuladorCombate();

    }

    public void recibirAtaque(int ataque, int hp, int defensa, int ataqueEspecial, int defensaEspecial, int ataque2,
                              int hp2, int defensa2, int ataqueEspecial2, int defensaEspecial2) {

        final SimuladorCombate.Pokemon p1 = new SimuladorCombate.Pokemon(ataque, hp, defensa, ataqueEspecial, defensaEspecial);
        final SimuladorCombate.Pokemon p2 = new SimuladorCombate.Pokemon(ataque2,  hp2,  defensa2,  ataqueEspecial2, defensaEspecial2);

        // Actualizar las MutableLiveData con la nueva salud
        executor.execute(() -> {
            vistaHp1.postValue(p1.getHp());
            vistaHp2.postValue(p2.getHp());
        });
        executor.execute(new Runnable() {
            @Override
            public void run() {
                if (pokemon1 == true) {
                    simulador.recibirAtaque(p1, p2, new SimuladorCombate.Callback() {
                        @Override
                        public void cuandoSeAtaca(int salud) {
                            vistaHp2.postValue(salud);
                        }
                    });
                }

                else {
                    simulador.recibirAtaque(p2, p1, new SimuladorCombate.Callback() {
                        @Override
                        public void cuandoSeAtaca(int salud) {
                            vistaHp1.postValue(salud);
                        }
                    });
                }
            }
        });
    }
}