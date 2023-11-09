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

public class tela04 extends AppCompatActivity {

    private static final String COR_PREF_KEY_Tela04= "cor_pref_tela04";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela04);
        int corSalva4 = obterCorSalva();
        configurarCorTela(corSalva4);
    }

    private void configurarCorTela(int cor) {
        LinearLayout tela04 = findViewById(R.id.tela04);
        tela04.setBackgroundColor(cor);
    }

    public void T4voltar(View view) {
        Intent intent = new Intent(tela04.this, tela03.class);
        startActivity(intent);
    }


    private void salvarCorPreferencias(int cor) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(COR_PREF_KEY_Tela04, cor);
        editor.apply();
    }

    private int obterCorSalva() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        return preferences.getInt(COR_PREF_KEY_Tela04, Color.WHITE);
    }

    public void mudarT4red(View view) {
        configurarCorTela(getResources().getColor(R.color.red));
        salvarCorPreferencias(getResources().getColor(R.color.red));
    }

    public void mudarT4blue(View view) {
        configurarCorTela(getResources().getColor(R.color.blue));
        salvarCorPreferencias(getResources().getColor(R.color.blue));
    }

    public void mudarT4green(View view) {
        configurarCorTela(getResources().getColor(R.color.green));
        salvarCorPreferencias(getResources().getColor(R.color.green));
    }

    public void mudarT4random(View view) {
        LinearLayout tela04 = findViewById(R.id.tela04);
        Random random = new Random();
        int corred = random.nextInt(256);
        int corgreen = random.nextInt(256);
        int corblue = random.nextInt(256);
        int corAleatoria = Color.rgb(corred, corgreen, corblue);
        tela04.setBackgroundColor(corAleatoria);
        salvarCorPreferencias(corAleatoria);

    }
}