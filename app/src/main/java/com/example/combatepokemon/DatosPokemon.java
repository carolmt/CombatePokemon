package com.example.combatepokemon;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.combatepokemon.databinding.FragmentDatosPokemonBinding;


public class DatosPokemon extends Fragment {
    private FragmentDatosPokemonBinding binding;
    boolean pokemon1 = true;

    public DatosPokemon() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentDatosPokemonBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.botonCombate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int ataque1 = Integer.parseInt(binding.ataque1.getText().toString());
                int ataque2 = Integer.parseInt(binding.ataque2.getText().toString());
                int hp1 = Integer.parseInt(binding.HP1.getText().toString());
                int hp2 = Integer.parseInt(binding.HP2.getText().toString());
                int ataqueEspecial1 = Integer.parseInt(binding.ataqueEspecial1.getText().toString());
                int ataqueEspecial2 = Integer.parseInt(binding.ataqueEspecial2.getText().toString());
                int defensa1 = Integer.parseInt(binding.defensa1.getText().toString());
                int defensa2 = Integer.parseInt(binding.defensa2.getText().toString());
                int defensaEspecial1 = Integer.parseInt(binding.defensaEspecial1.getText().toString());
                int defensaEspecial2 = Integer.parseInt(binding.defensaEspecial2.getText().toString());
                int vistaHp2 ;
                int vistaHp1;

                SimuladorCombate.Pokemon p1 = new SimuladorCombate.Pokemon(ataque1, hp1, defensa1, ataqueEspecial1, defensaEspecial1 );
                SimuladorCombate.Pokemon p2 = new SimuladorCombate.Pokemon(ataque2, hp2, defensa2, ataqueEspecial2, defensaEspecial2 );
                SimuladorCombate simuladorCombate = new SimuladorCombate();

                if (pokemon1 == true) {
                    vistaHp2 = simuladorCombate.recibirAtaque(p1, p2);
                    binding.vistaHP2.setText("HP: " + String.valueOf(vistaHp2));
                    pokemon1 = false;
                    }
                  else {
                    vistaHp1 = simuladorCombate.recibirAtaque(p2, p1);
                    binding.vistaHP1.setText("HP: " + String.valueOf(vistaHp1));
                    pokemon1 = true;
                  }
            }
        });
    }
}