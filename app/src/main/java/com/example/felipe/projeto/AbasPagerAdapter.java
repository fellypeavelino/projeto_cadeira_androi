package com.example.felipe.projeto;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.Locale;

/**
 * Created by mria do carmo on 25/10/2015.
 */
public class AbasPagerAdapter extends FragmentPagerAdapter {
    String[] titulosAbas;
    TypedArray bgColor;
    TypedArray textColor;

    public AbasPagerAdapter(Context ctx, FragmentManager fm){
        super(fm);
        titulosAbas = ctx.getResources().getStringArray(R.array.secoes);
        bgColor = ctx.getResources().obtainTypedArray(R.array.cores_bg);
        textColor = ctx.getResources().obtainTypedArray(R.array.cores_texto);
    }
    @Override
    public Fragment getItem(int position) {
        SegundoNivelFragmant fragment =
                SegundoNivelFragmant.novaInstancia(
                        titulosAbas[position],
                        bgColor.getColor(position,0),
                        textColor.getColor(position,0)
                );

        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position){
        Locale l = Locale.getDefault();
        return titulosAbas[position].toUpperCase(l);
    }
}
