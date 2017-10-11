package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static android.os.Build.VERSION_CODES.N;

/**
 * Created by jose on 07/10/17.
 */

public class PalavraAdapter extends ArrayAdapter<Palavra>
{
    private int mCorFundo;

    public PalavraAdapter(Activity context, ArrayList<Palavra> palavras, int corFundo)
    {
        super(context, 0, palavras);
        mCorFundo = corFundo;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View itemListaView = convertView;

        if(itemListaView == null) {
            itemListaView = LayoutInflater.from(getContext()).inflate(R.layout.item_lista, parent, false);
        }

        Palavra palavraAtual = getItem(position);

        TextView miwok = (TextView) itemListaView.findViewById(R.id.miwok);
        miwok.setText(palavraAtual.getTraducaoMiwok());

        TextView padrao = (TextView) itemListaView.findViewById(R.id.padrao);
        padrao.setText(palavraAtual.getTraducaoPadrao());

        ImageView imagem = (ImageView) itemListaView.findViewById(R.id.container_imagem);
        if (palavraAtual.hasImagem())
        {
            imagem.setImageResource(palavraAtual.getReferenciaImagem());
            imagem.setVisibility(View.VISIBLE);
        }

        else
        {
            imagem.setVisibility(View.GONE);
        }

        LinearLayout layout = (LinearLayout) itemListaView.findViewById(R.id.container_global);
        layout.setBackgroundResource(mCorFundo);

        return itemListaView;
    }

}
