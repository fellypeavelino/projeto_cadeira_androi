package com.example.felipe.projeto;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.felipe.projeto.model.Moto;

/**
 * Created by mria do carmo on 24/10/2015.
 */
public class MotoDetalheFragment extends Fragment {
    public static MotoDetalheFragment novaInstancia(Moto m){
        Bundle args = new Bundle();
        args.putSerializable("moto", m);

        MotoDetalheFragment mdf = new MotoDetalheFragment();
        mdf.setArguments(args);
        return mdf;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Moto moto = (Moto)getArguments().getSerializable("moto");

        View layout = inflater.inflate(R.layout.fragment_detalhe_moto, null);

        TextView txtNome = (TextView)layout.findViewById(R.id.txtNome);
        TextView txtMarca = (TextView)layout.findViewById(R.id.txtMarca);
        TextView txtAno = (TextView)layout.findViewById(R.id.txtAno);

        txtNome.setText(moto.nome);
        txtMarca.setText(moto.marca);
        txtAno.setText(String.valueOf(moto.ano));
        return layout;
    }

    static class ViewHolder{
        public TextView nome;
        public TextView marca;
        public TextView ano;
    }



    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_detalhe, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.acao_favorito){
            Toast.makeText(getActivity(), "Clicou em favorito!",
                    Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }



}
