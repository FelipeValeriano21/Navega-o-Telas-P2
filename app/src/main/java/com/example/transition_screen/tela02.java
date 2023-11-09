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

public class tela02 extends AppCompatActivity {

    private static final String COR_PREF_KEY_Tela02 = "cor_pref_tela02";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela02);
        int corSalva2 = obterCorSalva();
        configurarCorTela(corSalva2);
    }


    public void T2voltar(View view) {
        Intent intent = new Intent(tela02.this, MainActivity.class);
        startActivity(intent);
    }

    public void T2seguir(View view) {
        Intent intent = new Intent(tela02.this, tela03.class);
        startActivity(intent);
    }

    private void configurarCorTela(int cor) {
        LinearLayout tela02 = findViewById(R.id.tela02);
        tela02.setBackgroundColor(cor);
    }

    private void salvarCorPreferencias(int cor) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(COR_PREF_KEY_Tela02, cor);
        editor.apply();
    }

    private int obterCorSalva() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        return preferences.getInt(COR_PREF_KEY_Tela02, Color.WHITE);
    }

    public void mudarT2red(View view) {
        configurarCorTela(getResources().getColor(R.color.red));
        salvarCorPreferencias(getResources().getColor(R.color.red));
    }

    public void mudarT2blue(View view) {
        configurarCorTela(getResources().getColor(R.color.blue));
        salvarCorPreferencias(getResources().getColor(R.color.blue));
    }

    public void mudarT2green(View view) {
        configurarCorTela(getResources().getColor(R.color.green));
        salvarCorPreferencias(getResources().getColor(R.color.green));
    }

    public void mudarT2random(View view) {
        LinearLayout tela02 = findViewById(R.id.tela02);
        Random random = new Random();
        int corred = random.nextInt(256);
        int corgreen = random.nextInt(256);
        int corblue = random.nextInt(256);
        int corAleatoria = Color.rgb(corred, corgreen, corblue);
        tela02.setBackgroundColor(corAleatoria);
        salvarCorPreferencias(corAleatoria);

    }

}
