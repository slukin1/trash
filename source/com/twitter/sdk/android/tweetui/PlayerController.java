package com.twitter.sdk.android.tweetui;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.twitter.sdk.android.core.IntentUtils;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.tweetui.PlayerActivity;
import com.twitter.sdk.android.tweetui.internal.SwipeToDismissTouchListener;
import com.twitter.sdk.android.tweetui.internal.VideoControlView;
import com.twitter.sdk.android.tweetui.internal.VideoView;

class PlayerController {
    private static final String TAG = "PlayerController";
    public final TextView callToActionView;
    public final SwipeToDismissTouchListener.Callback callback;
    public boolean isPlaying = true;
    public final View rootView;
    public int seekPosition;
    public final VideoControlView videoControlView;
    public final ProgressBar videoProgressView;
    public final VideoView videoView;

    public PlayerController(View view, SwipeToDismissTouchListener.Callback callback2) {
        this.rootView = view;
        this.videoView = (VideoView) view.findViewById(R.id.video_view);
        this.videoControlView = (VideoControlView) view.findViewById(R.id.video_control_view);
        this.videoProgressView = (ProgressBar) view.findViewById(R.id.video_progress_view);
        this.callToActionView = (TextView) view.findViewById(R.id.call_to_action_view);
        this.callback = callback2;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$prepare$0(MediaPlayer mediaPlayer) {
        this.videoProgressView.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$prepare$1(MediaPlayer mediaPlayer, int i11, int i12) {
        if (i11 == 702) {
            this.videoProgressView.setVisibility(8);
            return true;
        } else if (i11 != 701) {
            return false;
        } else {
            this.videoProgressView.setVisibility(0);
            return true;
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$setUpCallToActionListener$3(String str, View view) {
        IntentUtils.safeStartActivity(this.callToActionView.getContext(), new Intent("android.intent.action.VIEW", Uri.parse(str)));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$setUpLoopControl$2(View view) {
        if (this.videoView.isPlaying()) {
            this.videoView.pause();
        } else {
            this.videoView.start();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$setUpRootViewOnClickListener$4(View view) {
        if (this.callToActionView.getVisibility() == 0) {
            this.callToActionView.setVisibility(8);
        } else {
            this.callToActionView.setVisibility(0);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onDestroy() {
        this.videoView.stopPlayback();
    }

    public void onPause() {
        this.isPlaying = this.videoView.isPlaying();
        this.seekPosition = this.videoView.getCurrentPosition();
        this.videoView.pause();
    }

    public void onResume() {
        int i11 = this.seekPosition;
        if (i11 != 0) {
            this.videoView.seekTo(i11);
        }
        if (this.isPlaying) {
            this.videoView.start();
            this.videoControlView.update();
        }
    }

    public void prepare(PlayerActivity.PlayerItem playerItem) {
        try {
            setUpCallToAction(playerItem);
            setUpMediaControl(playerItem.looping, playerItem.showVideoControls);
            this.videoView.setOnTouchListener(SwipeToDismissTouchListener.createFromView(this.videoView, this.callback));
            this.videoView.setOnPreparedListener(new g(this));
            this.videoView.setOnInfoListener(new f(this));
            this.videoView.setVideoURI(Uri.parse(playerItem.url), playerItem.looping);
            this.videoView.requestFocus();
        } catch (Exception e11) {
            Twitter.getLogger().e(TAG, "Error occurred during video playback", e11);
        }
    }

    public void setUpCallToAction(PlayerActivity.PlayerItem playerItem) {
        if (playerItem.callToActionText != null && playerItem.callToActionUrl != null) {
            this.callToActionView.setVisibility(0);
            this.callToActionView.setText(playerItem.callToActionText);
            setUpCallToActionListener(playerItem.callToActionUrl);
            setUpRootViewOnClickListener();
        }
    }

    public void setUpCallToActionListener(String str) {
        this.callToActionView.setOnClickListener(new j(this, str));
    }

    public void setUpLoopControl() {
        this.videoControlView.setVisibility(4);
        this.videoView.setOnClickListener(new h(this));
    }

    public void setUpMediaControl(boolean z11, boolean z12) {
        if (!z11 || z12) {
            setUpMediaControl();
        } else {
            setUpLoopControl();
        }
    }

    public void setUpRootViewOnClickListener() {
        this.rootView.setOnClickListener(new i(this));
    }

    public void setUpMediaControl() {
        this.videoView.setMediaController(this.videoControlView);
    }

    public PlayerController(View view, VideoView videoView2, VideoControlView videoControlView2, ProgressBar progressBar, TextView textView, SwipeToDismissTouchListener.Callback callback2) {
        this.rootView = view;
        this.videoView = videoView2;
        this.videoControlView = videoControlView2;
        this.videoProgressView = progressBar;
        this.callToActionView = textView;
        this.callback = callback2;
    }
}
