package com.example.transition_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import java.util.Random;
import android.graphics.Color;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.LinearLayout;




public class MainActivity extends AppCompatActivity {

    private static final String COR_PREF_KEY = "cor_pref";


    public void T1seguir(View view) {
        Intent intent = new Intent(MainActivity.this, tela02.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int corSalva = obterCorSalva();
        configurarCorTela(corSalva);
    }

    public void mudarT1red(View view) {
        configurarCorTela(getResources().getColor(R.color.red));
        salvarCorPreferencias(getResources().getColor(R.color.red));
    }

    private void configurarCorTela(int cor) {
        LinearLayout tela01 = findViewById(R.id.tela01);
        tela01.setBackgroundColor(cor);
    }

    private void salvarCorPreferencias(int cor) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(COR_PREF_KEY, cor);
        editor.apply();
    }

    private int obterCorSalva() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        return preferences.getInt(COR_PREF_KEY, Color.WHITE);
    }


    public void mudarT1blue(View view) {
        configurarCorTela(getResources().getColor(R.color.blue));
        salvarCorPreferencias(getResources().getColor(R.color.blue));
    }

    public void mudarT1green(View view) {
        configurarCorTela(getResources().getColor(R.color.green));
        salvarCorPreferencias(getResources().getColor(R.color.green));
    }

    public void mudarT1random(View view) {
        LinearLayout tela01 = findViewById(R.id.tela01);


        Random random = new Random();
        int corred = random.nextInt(256);
        int corgreen = random.nextInt(256);
        int corblue = random.nextInt(256);
        int corAleatoria = Color.rgb(corred, corgreen, corblue);

        tela01.setBackgroundColor(corAleatoria);
        salvarCorPreferencias(corAleatoria);



    }



}