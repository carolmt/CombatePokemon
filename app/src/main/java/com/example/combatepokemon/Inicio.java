package com.example.combatepokemon;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.combatepokemon.databinding.FragmentInicioBinding;


public class Inicio extends Fragment {

    private FragmentInicioBinding binding;

    public Inicio() {}

    public static Inicio newInstance() {
        Inicio fragment = new Inicio();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentInicioBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.crearPokemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// Obtén el NavController desde el host (actividad)
                NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);

                // Navega al fragmento DatosPokemon
                navController.navigate(R.id.action_inicio_to_datosPokemon);
            }
        });

    }

    }