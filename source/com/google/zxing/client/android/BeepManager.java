package com.google.zxing.client.android;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.util.Log;
import java.io.Closeable;
import java.io.IOException;
import pro.huobi.R;

final class BeepManager implements MediaPlayer.OnErrorListener, Closeable {
    private static final float BEEP_VOLUME = 0.1f;
    private static final String TAG = BeepManager.class.getSimpleName();
    private static final long VIBRATE_DURATION = 200;
    private final Activity activity;
    private MediaPlayer mediaPlayer = null;
    private boolean playBeep;
    private boolean vibrate;

    public BeepManager(Activity activity2) {
        this.activity = activity2;
        updatePrefs();
    }

    private MediaPlayer buildMediaPlayer(Context context) {
        AssetFileDescriptor openRawResourceFd;
        MediaPlayer mediaPlayer2 = new MediaPlayer();
        try {
            openRawResourceFd = context.getResources().openRawResourceFd(R.raw.beep);
            mediaPlayer2.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
            mediaPlayer2.setOnErrorListener(this);
            mediaPlayer2.setAudioStreamType(3);
            mediaPlayer2.setLooping(false);
            mediaPlayer2.setVolume(0.1f, 0.1f);
            mediaPlayer2.prepare();
            openRawResourceFd.close();
            return mediaPlayer2;
        } catch (IOException e11) {
            Log.w(TAG, e11);
            mediaPlayer2.release();
            return null;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    private static boolean shouldBeep(SharedPreferences sharedPreferences, Context context) {
        boolean z11 = sharedPreferences.getBoolean(PreferencesActivity.KEY_PLAY_BEEP, true);
        if (!z11 || ((AudioManager) context.getSystemService("audio")).getRingerMode() == 2) {
            return z11;
        }
        return false;
    }

    public synchronized void close() {
        MediaPlayer mediaPlayer2 = this.mediaPlayer;
        if (mediaPlayer2 != null) {
            mediaPlayer2.release();
            this.mediaPlayer = null;
        }
    }

    public synchronized boolean onError(MediaPlayer mediaPlayer2, int i11, int i12) {
        if (i11 == 100) {
            this.activity.finish();
        } else {
            close();
            updatePrefs();
        }
        return true;
    }

    public synchronized void playBeepSoundAndVibrate() {
        MediaPlayer mediaPlayer2;
        if (this.playBeep && (mediaPlayer2 = this.mediaPlayer) != null) {
            mediaPlayer2.start();
        }
        if (this.vibrate) {
            ((Vibrator) this.activity.getSystemService("vibrator")).vibrate(200);
        }
    }

    public synchronized void updatePrefs() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.activity);
        this.playBeep = shouldBeep(defaultSharedPreferences, this.activity);
        this.vibrate = defaultSharedPreferences.getBoolean(PreferencesActivity.KEY_VIBRATE, false);
        if (this.playBeep && this.mediaPlayer == null) {
            this.activity.setVolumeControlStream(3);
            this.mediaPlayer = buildMediaPlayer(this.activity);
        }
    }
}
