package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamiliaActivity extends AppCompatActivity {

    ArrayList<Palavra> palavras = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_palavras);

        palavras.add(new Palavra("Pai" , "әpә", R.drawable.family_father, R.raw.family_father));
        palavras.add(new Palavra("Mãe" , "әṭa", R.drawable.family_mother, R.raw.family_mother));
        palavras.add(new Palavra("Filho" , "angsi", R.drawable.family_son, R.raw.family_son));
        palavras.add(new Palavra("Filha" , "tune", R.drawable.family_daughter, R.raw.family_daughter));
        palavras.add(new Palavra("Irmão mais velho" , "taachi", R.drawable.family_older_brother, R.raw.family_older_brother));
        palavras.add(new Palavra("Irmão mais novo" , "chalitti", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        palavras.add(new Palavra("Irmã mais velha" , "teṭe", R.drawable.family_older_sister, R.raw.family_older_sister));
        palavras.add(new Palavra("Irmã mais nova" , "kolliti", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        palavras.add(new Palavra("Avó" , "ama", R.drawable.family_grandmother, R.raw.family_grandfather));
        palavras.add(new Palavra("Avô" , "paapa", R.drawable.family_grandfather, R.raw.family_grandmother));

        PalavraAdapter itensAdapter = new PalavraAdapter(this, palavras, R.color.categoria_familia);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itensAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
            {
                Palavra palavraClicada = palavras.get(position);
                MediaPlayer mediaPlayer = MediaPlayer.create(FamiliaActivity.this, palavraClicada.getReferenciaImagem());
                mediaPlayer.start();
            }
        });
    }
}
