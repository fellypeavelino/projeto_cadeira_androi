package com.example.felipe.projeto;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.felipe.projeto.model.ListaMotos;
import com.example.felipe.projeto.model.Moto;
import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mria do carmo on 24/10/2015.
 */
public class MotoFragment extends ListFragment {
    List<Moto> mMotos = new ArrayList<Moto>() ;
    ArrayAdapter<Moto>  mAdapter;
    @Override
    public void onActivityCreated(Bundle SavedInstanceState){
        super.onActivityCreated(SavedInstanceState);
        MotosTask mMotosTask = new MotosTask();
        mMotosTask.execute("http://10.0.2.2/projeto_android/json.php");
        mAdapter = new ArrayAdapter<Moto>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                mMotos
        );

        setListAdapter(mAdapter);
    }

    /*private List<Moto> carregarMotos(){
        List<Moto> motos = new ArrayList<Moto>();
        motos.add(new Moto("CB 600F HORNET", "HONDA", 2012));
        motos.add(new Moto("NINJA 250R", "KAWASAKI", 2013));
        motos.add(new Moto("MT-07", "YAMAHA", 2014));
        motos.add(new Moto("CITYCOM 300 I", "DAFRA", 2015));
        return motos;
    }*/

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Moto moto = mMotos.get(position);
        if (getActivity() instanceof AoClicarNaMoto){
            ((AoClicarNaMoto)getActivity()).clicouNaMoto(moto);
        }
    }

    interface AoClicarNaMoto {
        void clicouNaMoto(Moto m);
    }


    class MotosTask extends AsyncTask<String,Void,List<Moto>> {

        @Override
        protected List<Moto> doInBackground(String... params) {
            try {
                InputStream is = new URL(params[0]).openStream();
                Gson gson = new Gson();
                ListaMotos motos = gson.fromJson(
                        new InputStreamReader(is) ,
                        ListaMotos.class);
                return motos.getResults();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<Moto> motos){
            super.onPostExecute(motos);
            if(motos != null){
                mMotos.clear();
                mMotos.addAll(motos);
                mAdapter.notifyDataSetChanged();

            }else{
                Moto moto_ = new Moto();
                mMotos.clear();
                mMotos.add(moto_);
                mAdapter.notifyDataSetChanged();
            }
        }
    }
}
