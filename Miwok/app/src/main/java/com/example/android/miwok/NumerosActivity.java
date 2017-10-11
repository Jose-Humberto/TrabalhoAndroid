package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.os.Build.VERSION_CODES.N;

public class NumerosActivity extends AppCompatActivity {

    ArrayList<Palavra> palavras = new ArrayList<>();
    Palavra palavraClicada;
    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;

    private MediaPlayer.OnCompletionListener mOnCompletionListener
            = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };


    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener()
    {
        @Override
        public void onAudioFocusChange(int focusChange)
        {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK)
            {
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            }

            else if (focusChange == AudioManager.AUDIOFOCUS_GAIN)
            {

                mMediaPlayer.start();
            }

            else if (focusChange == AudioManager.AUDIOFOCUS_LOSS)
            {
                releaseMediaPlayer();
            }
        }
    };

                    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_palavras);

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        palavras.add(new Palavra("um" , "lutti", R.drawable.number_one, R.raw.number_one));
        palavras.add(new Palavra("dois" , "otiiko", R.drawable.number_two, R.raw.number_two));
        palavras.add(new Palavra("tres" , "tolookosu", R.drawable.number_three, R.raw.number_three));
        palavras.add(new Palavra("quatro" , "oyyisa", R.drawable.number_four, R.raw.number_four));
        palavras.add(new Palavra("cinco" , "massokka", R.drawable.number_five, R.raw.number_five));
        palavras.add(new Palavra("seis" , "temmokka", R.drawable.number_six, R.raw.number_six));
        palavras.add(new Palavra("sete" , "kenekaku", R.drawable.number_seven, R.raw.number_seven));
        palavras.add(new Palavra("oito" , "kawinta", R.drawable.number_eight, R.raw.number_eight));
        palavras.add(new Palavra("nove" , "wo’e", R.drawable.number_nine, R.raw.number_nine));
        palavras.add(new Palavra("dez" , "na’aacha", R.drawable.number_ten, R.raw.number_ten));

        PalavraAdapter itensAdapter = new PalavraAdapter(this, palavras, R.color.categoria_numeros);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itensAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Palavra palavraClicada = palavras.get(position);

                releaseMediaPlayer();

                int resultado = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC,
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (resultado == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mMediaPlayer = MediaPlayer
                            .create(NumerosActivity.this, palavraClicada.getReferenciaAudio());
                    mMediaPlayer.start();

                    mMediaPlayer.setOnCompletionListener(mOnCompletionListener);
                }
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer()
    {
        if(mMediaPlayer != null)
        {
            mMediaPlayer.release();
            mMediaPlayer = null;

            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }
}
