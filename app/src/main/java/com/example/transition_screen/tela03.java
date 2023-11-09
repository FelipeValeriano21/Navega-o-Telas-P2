package com.example.transition_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.LinearLayout;

import java.util.Random;

public class tela03 extends AppCompatActivity {

    private static final String COR_PREF_KEY_Tela03 = "cor_pref_tela03";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela03);
        int corSalva3 = obterCorSalva();
        configurarCorTela(corSalva3);
    }

    private void configurarCorTela(int cor) {
        LinearLayout tela03 = findViewById(R.id.tela03);
        tela03.setBackgroundColor(cor);
    }

    public void T3voltar(View view) {
        Intent intent = new Intent(tela03.this, tela02.class);
        startActivity(intent);
    }

    public void T3seguir(View view) {
        Intent intent = new Intent(tela03.this, tela04.class);
        startActivity(intent);
    }

    private void salvarCorPreferencias(int cor) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(COR_PREF_KEY_Tela03, cor);
        editor.apply();
    }

    private int obterCorSalva() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        return preferences.getInt(COR_PREF_KEY_Tela03, Color.WHITE);
    }

    public void mudarT3red(View view) {
        configurarCorTela(getResources().getColor(R.color.red));
        salvarCorPreferencias(getResources().getColor(R.color.red));
    }

    public void mudarT3blue(View view) {
        configurarCorTela(getResources().getColor(R.color.blue));
        salvarCorPreferencias(getResources().getColor(R.color.blue));
    }

    public void mudarT3green(View view) {
        configurarCorTela(getResources().getColor(R.color.green));
        salvarCorPreferencias(getResources().getColor(R.color.green));
    }

    public void mudarT3random(View view) {
        LinearLayout tela03 = findViewById(R.id.tela03);
        Random random = new Random();
        int corred = random.nextInt(256);
        int corgreen = random.nextInt(256);
        int corblue = random.nextInt(256);
        int corAleatoria = Color.rgb(corred, corgreen, corblue);
        tela03.setBackgroundColor(corAleatoria);
        salvarCorPreferencias(corAleatoria);

    }
}