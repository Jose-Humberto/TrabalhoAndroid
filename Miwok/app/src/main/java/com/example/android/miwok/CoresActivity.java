package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class CoresActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    ArrayList<Palavra> palavras = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_palavras);

        palavras.add(new Palavra("Vermelho" , "weṭeṭṭi", R.drawable.color_red, R.raw.color_red));
        palavras.add(new Palavra("Verde" , "chokokki", R.drawable.color_green, R.raw.color_green));
        palavras.add(new Palavra("Marrom" , "ṭakaakki", R.drawable.color_brown, R.raw.color_brown));
        palavras.add(new Palavra("Cinza" , "ṭopoppi", R.drawable.color_gray, R.raw.color_gray));
        palavras.add(new Palavra("Preto" , "kululli", R.drawable.color_black, R.raw.color_black));
        palavras.add(new Palavra("Branco" , "kelelli", R.drawable.color_white, R.raw.color_white));
        palavras.add(new Palavra("Amarelo Empoeirado" , "ṭopiisә", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        palavras.add(new Palavra("Amarelo Mostada" , "chiwiiṭә", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));

        PalavraAdapter itensAdapter = new PalavraAdapter(this, palavras, R.color.categoria_cores);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itensAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
            {
                Palavra palavraClicada = palavras.get(position);
                MediaPlayer mediaPlayer = MediaPlayer.create(CoresActivity.this, palavraClicada.getReferenciaAudio());
                mediaPlayer.start();
            }
        });
    }
}
