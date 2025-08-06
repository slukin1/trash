package com.tencent.qcloud.tuikit.tuicallkit.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qcloud.tuikit.TUIVideoView;
import com.tencent.qcloud.tuikit.tuicallkit.R;
import com.tencent.qcloud.tuikit.tuicallkit.utils.ImageLoader;

public class UserLayout extends RelativeLayout {
    private boolean mDisableAudioImage;
    private ImageView mImgAudioInput;
    private ImageView mImgLoading;
    private ImageView mImgUserAvatar;
    private RelativeLayout mLayoutImageHead;
    private boolean mMoveAble;
    private boolean mMuteAudio;
    private TUIVideoView mTUIVideoView;
    private TextView mTextUserName;

    public UserLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.tuicalling_group_user_layout, this, true);
        this.mLayoutImageHead = (RelativeLayout) findViewById(R.id.rl_image_head);
        this.mTUIVideoView = (TUIVideoView) findViewById(R.id.tx_cloud_view);
        this.mImgUserAvatar = (ImageView) findViewById(R.id.img_head);
        this.mTextUserName = (TextView) findViewById(R.id.tv_name);
        this.mImgAudioInput = (ImageView) findViewById(R.id.iv_audio_input);
        this.mImgLoading = (ImageView) findViewById(R.id.img_loading);
    }

    public void addVideoView(TUIVideoView tUIVideoView) {
        TUIVideoView tUIVideoView2 = this.mTUIVideoView;
        if (tUIVideoView2 != null) {
            removeView(tUIVideoView2);
        }
        this.mTUIVideoView = tUIVideoView;
        addView(tUIVideoView);
    }

    public void disableAudioImage(boolean z11) {
        this.mDisableAudioImage = z11;
    }

    public ImageView getAvatarImage() {
        return this.mImgUserAvatar;
    }

    public TUIVideoView getVideoView() {
        return this.mTUIVideoView;
    }

    public boolean isMoveAble() {
        return this.mMoveAble;
    }

    public void muteMic(boolean z11) {
        this.mMuteAudio = z11;
        if (!this.mDisableAudioImage) {
            this.mImgAudioInput.setVisibility(z11 ? 8 : 0);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setAudioVolume(int i11, boolean z11) {
        if (!this.mMuteAudio && !this.mDisableAudioImage) {
            this.mImgAudioInput.setVisibility((!z11 || i11 <= 10) ? 8 : 0);
        }
    }

    public void setMoveAble(boolean z11) {
        this.mMoveAble = z11;
    }

    public void setUserName(String str) {
        this.mTextUserName.setText(str);
    }

    public void setVideoAvailable(boolean z11) {
        if (z11) {
            this.mTUIVideoView.setVisibility(0);
            this.mLayoutImageHead.setVisibility(8);
            this.mTextUserName.setVisibility(0);
            return;
        }
        this.mTUIVideoView.setVisibility(8);
        this.mLayoutImageHead.setVisibility(0);
        this.mTextUserName.setVisibility(0);
    }

    public void startLoading() {
        this.mImgLoading.setVisibility(0);
        ImageLoader.loadGifImage(getContext(), this.mImgLoading, R.drawable.tuicalling_loading);
    }

    public void stopLoading() {
        this.mImgLoading.setVisibility(8);
    }

    public UserLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMuteAudio = false;
        this.mDisableAudioImage = false;
        initView();
        setClickable(true);
    }
}
