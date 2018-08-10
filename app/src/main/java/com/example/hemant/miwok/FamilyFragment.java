package com.example.hemant.miwok;


import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import static android.content.Context.AUDIO_SERVICE;


/**
 * A simple {@link Fragment} subclass.
 */
public class FamilyFragment extends Fragment {
    MediaPlayer mp;
    private AudioManager am;
    private AudioManager.OnAudioFocusChangeListener afChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                        // Permanent loss of audio focus
                        // Pause playback immediately
                        releaseMediaPlayer();
                    }
                    else if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT||focusChange==AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                        mp.pause();
                        mp.seekTo(0);
                        // Lower the volume, keep playing
                    } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                        mp.start();
                        // Your app has been granted audio focus again
                        // Raise volume to normal, restart playback if necessary
                    }
                }
            };
    private MediaPlayer.OnCompletionListener mon = new MediaPlayer.OnCompletionListener(){

        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vv= inflater.inflate(R.layout.word_list, container, false);
        am = (AudioManager) getActivity().getSystemService(AUDIO_SERVICE);
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("mother", "әpә",R.drawable.family_mother,R.raw.family_mother));
        words.add(new Word("father", "әṭa",R.drawable.family_father,R.raw.family_father));
        words.add(new Word("son", "angsi",R.drawable.family_son,R.raw.family_son));
        words.add(new Word("daughter", "tune",R.drawable.family_daughter,R.raw.family_daughter));
        words.add(new Word("older brother", "taachi",R.drawable.family_older_brother,R.raw.family_older_brother));
        words.add(new Word("younger brother", "chalitti",R.drawable.family_younger_brother,R.raw.family_younger_brother));
        words.add(new Word("older sister", "teṭe",R.drawable.family_older_sister,R.raw.family_older_sister));
        words.add(new Word("younger sister", "kolliti",R.drawable.family_younger_sister,R.raw.family_younger_sister));
        words.add(new Word("grandfather", "paapa",R.drawable.family_grandfather,R.raw.family_grandfather));
        words.add(new Word("grandmother", "ama",R.drawable.family_grandmother,R.raw.family_grandmother));
        ListView list = (ListView) vv.findViewById(R.id.list);
        WordAdapter adapter = new WordAdapter(getActivity(),words,R.color.category_family);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word = words.get(i);
                releaseMediaPlayer();
                int result = am.requestAudioFocus(afChangeListener,
                        // Use the music stream.
                        AudioManager.STREAM_MUSIC,
                        // Request permanent focus.
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // Start playback
                    mp = MediaPlayer.create(getActivity(),word.getmMusicresource());
                    mp.start();
                    mp.setOnCompletionListener(mon);
                }
            }
        });
        // Inflate the layout for this fragment
        return vv;
    }
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mp != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mp.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mp = null;
            am.abandonAudioFocus(afChangeListener);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}
