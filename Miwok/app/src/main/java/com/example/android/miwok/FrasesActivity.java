package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FrasesActivity extends AppCompatActivity {

    ArrayList<Palavra> palavras = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_palavras);

        palavras.add(new Palavra("Onde você vai?" , "minto wuksus", R.mipmap.ic_launcher, R.raw.phrase_what_is_your_name));
        palavras.add(new Palavra("Qual o seu nome?" , "tinnә oyaase'nә", R.mipmap.ic_launcher, R.raw.phrase_what_is_your_name));
        palavras.add(new Palavra("Meu nome é ..." , "oyaaset...", R.mipmap.ic_launcher, R.raw.phrase_my_name_is));
        palavras.add(new Palavra("Como você está se sentindo?" , "michәksәs?", R.mipmap.ic_launcher, R.raw.phrase_are_you_coming));
        palavras.add(new Palavra("Eu estou me sentindo bem." , "kuchi achit", R.mipmap.ic_launcher, R.raw.phrase_what_is_your_name));
        palavras.add(new Palavra("Você está vindo?" , "әәnәs'aa?", R.mipmap.ic_launcher, R.raw.phrase_what_is_your_name));
        palavras.add(new Palavra("Sim, estou chegando." , "hәә’ әәnәm", R.mipmap.ic_launcher, R.raw.phrase_what_is_your_name));
        palavras.add(new Palavra("Estou chegando." , "әәnәm", R.mipmap.ic_launcher, R.raw.phrase_what_is_your_name));
        palavras.add(new Palavra("Vamos." , "yoowutis", R.mipmap.ic_launcher, R.raw.phrase_what_is_your_name));
        palavras.add(new Palavra("Venha aqui." , "әnni'nem", R.mipmap.ic_launcher, R.raw.phrase_what_is_your_name));

        PalavraAdapter itensAdapter = new PalavraAdapter(this, palavras,R.color.categoria_frases);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itensAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
            {
                Palavra palavraClicada = palavras.get(position);
                MediaPlayer mediaPlayer = MediaPlayer.create(FrasesActivity.this, palavraClicada.getReferenciaAudio());
                mediaPlayer.start();
            }
        });
    }
}
