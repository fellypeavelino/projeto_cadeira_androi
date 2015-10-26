package com.example.felipe.projeto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.example.felipe.projeto.model.Moto;


public class MotoActivity extends ActionBarActivity implements MotoFragment.AoClicarNaMoto{

    @Override
    public void clicouNaMoto(Moto m) {
        if (getResources().getBoolean(R.bool.fone)) {
            Intent it = new Intent(this, MotoDetalheActivity.class);
            it.putExtra("moto", m);
            //Toast.makeText(this,m.marca,Toast.LENGTH_SHORT).show();
            startActivity(it);
        } else {
            MotoDetalheFragment mdf = MotoDetalheFragment.novaInstancia(m);

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.detalhe, mdf)
                    .commit();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moto);
    }



}
