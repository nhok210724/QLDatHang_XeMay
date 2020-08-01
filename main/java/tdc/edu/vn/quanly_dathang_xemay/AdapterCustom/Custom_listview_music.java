package tdc.edu.vn.quanly_dathang_xemay.AdapterCustom;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.media.MediaPlayer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import tdc.edu.vn.quanly_dathang_xemay.Music;
import tdc.edu.vn.quanly_dathang_xemay.R;


public class Custom_listview_music extends BaseAdapter {


    //get database

    public static class DBmusic extends SQLiteOpenHelper {
        public DBmusic(@Nullable Context context) {
            super(context, "musicdata", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE music(vitri int)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }

        public void them(int posion) {
            SQLiteDatabase database = getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("vitri", posion);


            database.insert("music", null, values);
        }

        public void Xoa() {
            SQLiteDatabase database = getWritableDatabase();
            String sql = "Delete from music ";
            database.execSQL(sql);
        }

        public int getvitri() {
            int pi = -1;
            String sql = "SELECT * FROM music";
            SQLiteDatabase database = getReadableDatabase();
            Cursor cursor = database.rawQuery(sql, null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                pi = cursor.getInt(0);
                break;

            }

            cursor.close();
            return pi;
        }
    }

    ArrayList<String> data_song;
    Context context;
    MediaPlayer mediaPlayer;
    int posion = -1;
    boolean isplaying = false;

    public Custom_listview_music(ArrayList<String> data_song, Context context) {
        this.data_song = data_song;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data_song.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

   /* private class hoder {
        TextView textView;
        ImageButton imageButton;
    }*/

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_listview_music, parent, false);
//        hoder hoder = new hoder();

        final TextView textView = convertView.findViewById(R.id.tv_name_song);

        ImageButton imageButton = convertView.findViewById(R.id.ib_play);
//        hoder.textView = convertView.findViewById(R.id.tv_name_song);
//        hoder.imageButton = convertView.findViewById(R.id.ib_play);

        String song = data_song.get(position);
        textView.setText(song);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mediaPlayer != null && mediaPlayer.isPlaying()) {


                }
                new Handler().postDelayed(this, 500);
            }
        }, 500);


        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                posion = position;
                DBmusic dBmusic = new DBmusic(context);
                dBmusic.them(position);

                if (mediaPlayer != null) {
                    if (mediaPlayer.isPlaying()) {
                        isplaying = mediaPlayer.isPlaying();
                        dBmusic.Xoa();
                        mediaPlayer.stop();
                        mediaPlayer = MediaPlayer.create(context, Music.raw_song[position]);
                        dBmusic.them(position);
                        mediaPlayer.start();

                    } else {
                        mediaPlayer = MediaPlayer.create(context, Music.raw_song[position]);
                        mediaPlayer.start();
                        isplaying = mediaPlayer.isPlaying();
                    }
                } else {
                    mediaPlayer = MediaPlayer.create(context, Music.raw_song[position]);
                    mediaPlayer.start();
                    dBmusic.them(position);
                    isplaying = mediaPlayer.isPlaying();
                }


            }


        });

//        convertView.setTag(hoder);

        return convertView;


    }

    public MediaPlayer getmedia(Context context) {
        MediaPlayer player = null;
        if (posion != -1) {
            player = MediaPlayer.create(context, Music.raw_song[posion]);
            return player;
        }

        return player;
    }

    public int getvitri() {
        int a = posion;
        return a;
    }

    public boolean isPlaying() {
        return isplaying;
    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public void pause() {
        mediaPlayer.pause();
    }

    public void start() {
        mediaPlayer.start();
    }

    public void setIsplaying(boolean set) {
        isplaying = set;
    }
}
