package tdc.edu.vn.quanly_dathang_xemay;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import tdc.edu.vn.quanly_dathang_xemay.AdapterCustom.Custom_listview_music;

public class Music extends AppCompatActivity {
    TextView tv_name_song, tv_timeGoing, tv_timeTotal;
    SeekBar seekBar;
    ImageView img_cd;
    ImageButton play_pause;

    public static final int[] raw_song = {R.raw.faded_violong, R.raw.faded_dannguyet, R.raw.just_a_dream, R.raw.the_chainsmokers_paris, R.raw.sakura_anata_ni_deaete_yokatta};
    Animation animation;


    ArrayList<String> name_song = new ArrayList<>();
    ListView lv;
    MediaPlayer mediaPlayer;
    Custom_listview_music custom_listview_music;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music);
        setControl();
        setEvent();

    }

    private void ChangeMusic() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                tv_name_song.setText(name_song.get(custom_listview_music.getvitri()));

                new Handler().postDelayed(this, 500);
            }
        }, 500);
    }

    private void khoitaoMediaplayer() {
        mediaPlayer = custom_listview_music.getMediaPlayer();
    }

    //   animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
    ////                    img_cd.startAnimation(animation);

    private void UpdateTimeSong() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat dinhDangGio = new SimpleDateFormat("mm:ss");
                tv_timeGoing.setText(dinhDangGio.format(mediaPlayer.getCurrentPosition()));
                //update skSong
                seekBar.setProgress(mediaPlayer.getCurrentPosition());
                //kiem tra thoi gian bai hat ->if ket thuc - > next
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {

                        if (mediaPlayer.isPlaying()) {
                            mediaPlayer.pause();
                        }
                        khoitaoMediaplayer();
                        mediaPlayer.start();
                        play_pause.setImageResource(R.drawable.ic_pause_black_24dp);
                        SetTimeTotal();
                        UpdateTimeSong();
                    }
                });
                handler.postDelayed(this, 500);
            }
        }, 100);
    }

    private void SetTimeTotal() {
        SimpleDateFormat dinhDangGio = new SimpleDateFormat("mm:ss");
        tv_timeTotal.setText(dinhDangGio.format(mediaPlayer.getDuration()));
        //gan' max cua skSong cho mediaPlayer cho no cung time voi nhau
        seekBar.setMax(mediaPlayer.getDuration());
    }


    private void setEvent() {
        animation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        name_song.add("Faded Violong");
        name_song.add("Faded Đàn Nguyệt");
        name_song.add("Just A Dream");
        name_song.add("Paris");
        name_song.add("Sakura Anata Ni Deaete Yokatta");

        custom_listview_music = new Custom_listview_music(name_song, getApplicationContext());

        lv.setAdapter(custom_listview_music);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (custom_listview_music.getMediaPlayer() != null) {
                    khoitaoMediaplayer();

                    if (mediaPlayer.isPlaying()) {
                        img_cd.startAnimation(animation);
                        tv_name_song.setText(name_song.get(custom_listview_music.getvitri()));
                        SetTimeTotal();
                        UpdateTimeSong();

                        ChangeMusic();
                    }


                } else {

                    new Handler().postDelayed(this, 500);
                }
            }
        }, 500);


        play_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                khoitaoMediaplayer();
                //isPlaying kiem tra co dang dc phat hay khong
                if (custom_listview_music.isPlaying() == true) {
                    //neu dang phat thi -> pause -> doi hinh play
                    custom_listview_music.pause();
                    play_pause.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                    custom_listview_music.setIsplaying(false);
                } else {
                    //dang ngung -> phat -> doi hinh pause

                    custom_listview_music.start();
                    play_pause.setImageResource(R.drawable.ic_pause_black_24dp);
                    custom_listview_music.setIsplaying(true);
                }
//                SetTimeTotal();
//                UpdateTimeSong();
                img_cd.startAnimation(animation);


            }
        });


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(seekBar.getProgress());
            }
        });


    }

    private void setControl() {
        img_cd = findViewById(R.id.animation_music);
        play_pause = findViewById(R.id.ib_play_pause);
        lv = findViewById(R.id.lv_music);
        tv_name_song = findViewById(R.id.tv_name_music);
        tv_timeGoing = findViewById(R.id.tv_time_going_Song);
        tv_timeTotal = findViewById(R.id.tv_timeTotal);
        seekBar = findViewById(R.id.sb_time);
    }

}
