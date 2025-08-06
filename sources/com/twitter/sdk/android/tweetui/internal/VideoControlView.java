package com.twitter.sdk.android.tweetui.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.twitter.sdk.android.tweetui.R;

public class VideoControlView extends FrameLayout {
    public static final int FADE_DURATION_MS = 150;
    public static final long PROGRESS_BAR_TICKS = 1000;
    private static final int SHOW_PROGRESS_MSG = 1001;
    public TextView currentTime;
    public TextView duration;
    /* access modifiers changed from: private */
    @SuppressLint({"HandlerLeak"})
    public final Handler handler = new Handler() {
        public void handleMessage(Message message) {
            if (message.what == 1001) {
                VideoControlView videoControlView = VideoControlView.this;
                if (videoControlView.player != null) {
                    videoControlView.updateProgress();
                    VideoControlView.this.updateStateControl();
                    if (VideoControlView.this.isShowing() && VideoControlView.this.player.isPlaying()) {
                        sendMessageDelayed(obtainMessage(1001), 500);
                    }
                }
            }
        }
    };
    public MediaPlayerControl player;
    public SeekBar seekBar;
    public ImageButton stateControl;

    public interface MediaPlayerControl {
        int getBufferPercentage();

        int getCurrentPosition();

        int getDuration();

        boolean isPlaying();

        void pause();

        void seekTo(int i11);

        void start();
    }

    public VideoControlView(Context context) {
        super(context);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$createStateControlClickListener$0(View view) {
        if (this.player.isPlaying()) {
            this.player.pause();
        } else {
            this.player.start();
        }
        show();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public SeekBar.OnSeekBarChangeListener createProgressChangeListener() {
        return new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int i11, boolean z11) {
                if (z11) {
                    int duration = (int) (((long) (VideoControlView.this.player.getDuration() * i11)) / 1000);
                    VideoControlView.this.player.seekTo(duration);
                    VideoControlView.this.setCurrentTime(duration);
                }
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControlView.this.handler.removeMessages(1001);
            }

            @SensorsDataInstrumented
            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControlView.this.handler.sendEmptyMessage(1001);
                SensorsDataAutoTrackHelper.trackViewOnClick(seekBar);
            }
        };
    }

    public View.OnClickListener createStateControlClickListener() {
        return new d(this);
    }

    public void hide() {
        this.handler.removeMessages(1001);
        AnimationUtils.fadeOut(this, 150);
    }

    public void initSubviews() {
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.tw__video_control, this);
        this.stateControl = (ImageButton) findViewById(R.id.tw__state_control);
        this.currentTime = (TextView) findViewById(R.id.tw__current_time);
        this.duration = (TextView) findViewById(R.id.tw__duration);
        SeekBar seekBar2 = (SeekBar) findViewById(R.id.tw__progress);
        this.seekBar = seekBar2;
        seekBar2.setMax(1000);
        this.seekBar.setOnSeekBarChangeListener(createProgressChangeListener());
        this.stateControl.setOnClickListener(createStateControlClickListener());
        setDuration(0);
        setCurrentTime(0);
        setProgress(0, 0, 0);
    }

    public boolean isShowing() {
        return getVisibility() == 0;
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        initSubviews();
    }

    public void setCurrentTime(int i11) {
        this.currentTime.setText(MediaTimeUtils.getPlaybackTime((long) i11));
    }

    public void setDuration(int i11) {
        this.duration.setText(MediaTimeUtils.getPlaybackTime((long) i11));
    }

    public void setMediaPlayer(MediaPlayerControl mediaPlayerControl) {
        this.player = mediaPlayerControl;
    }

    public void setPauseDrawable() {
        this.stateControl.setImageResource(R.drawable.tw__video_pause_btn);
        this.stateControl.setContentDescription(getContext().getString(R.string.tw__pause));
    }

    public void setPlayDrawable() {
        this.stateControl.setImageResource(R.drawable.tw__video_play_btn);
        this.stateControl.setContentDescription(getContext().getString(R.string.tw__play));
    }

    public void setProgress(int i11, int i12, int i13) {
        this.seekBar.setProgress((int) (i12 > 0 ? (((long) i11) * 1000) / ((long) i12) : 0));
        this.seekBar.setSecondaryProgress(i13 * 10);
    }

    public void setReplayDrawable() {
        this.stateControl.setImageResource(R.drawable.tw__video_replay_btn);
        this.stateControl.setContentDescription(getContext().getString(R.string.tw__replay));
    }

    public void show() {
        this.handler.sendEmptyMessage(1001);
        AnimationUtils.fadeIn(this, 150);
    }

    public void update() {
        this.handler.sendEmptyMessage(1001);
    }

    public void updateProgress() {
        int duration2 = this.player.getDuration();
        int currentPosition = this.player.getCurrentPosition();
        int bufferPercentage = this.player.getBufferPercentage();
        setDuration(duration2);
        setCurrentTime(currentPosition);
        setProgress(currentPosition, duration2, bufferPercentage);
    }

    public void updateStateControl() {
        if (this.player.isPlaying()) {
            setPauseDrawable();
        } else if (this.player.getCurrentPosition() > Math.max(this.player.getDuration() - 500, 0)) {
            setReplayDrawable();
        } else {
            setPlayDrawable();
        }
    }

    public VideoControlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VideoControlView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
