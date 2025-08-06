package com.hbg.module.huobi.im.group.ui.chat;

import android.graphics.drawable.AnimationDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.hbg.module.huobi.im.R$color;
import com.hbg.module.huobi.im.R$drawable;
import com.hbg.module.huobi.im.R$id;
import com.hbg.module.huobi.im.R$layout;
import com.hbg.module.huobi.im.R$string;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.SoundMessageBean;
import com.tencent.qcloud.tuikit.tuichat.component.AudioPlayer;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import java.io.File;

public class HbSoundMessageHolder extends HbMessageContentHolder {
    private static final int AUDIO_MAX_WIDTH = ScreenUtil.getPxByDp(250.0f);
    private static final int AUDIO_MIN_WIDTH = ScreenUtil.getPxByDp(60.0f);
    private static final int READ = 1;
    private static final int UNREAD = 0;
    private LinearLayout audioContentView;
    /* access modifiers changed from: private */
    public ImageView audioPlayImage;
    private TextView audioTimeText;

    public HbSoundMessageHolder(View view) {
        super(view);
        this.audioTimeText = (TextView) view.findViewById(R$id.audio_time_tv);
        this.audioPlayImage = (ImageView) view.findViewById(R$id.audio_play_iv);
        this.audioContentView = (LinearLayout) view.findViewById(R$id.audio_content_ll);
    }

    /* access modifiers changed from: private */
    public void getSound(final SoundMessageBean soundMessageBean) {
        final String str = TUIConfig.getRecordDownloadDir() + soundMessageBean.getUUID();
        if (!new File(str).exists()) {
            soundMessageBean.downloadSound(str, new SoundMessageBean.SoundDownloadCallback() {
                public void onError(int i11, String str) {
                    TUIChatLog.e("getSoundToFile failed code = ", i11 + ", info = " + str);
                    ToastUtil.toastLongMessage("getSoundToFile failed code = " + i11 + ", info = " + str);
                }

                public void onProgress(long j11, long j12) {
                    TUIChatLog.i("downloadSound progress current:", j11 + ", total:" + j12);
                }

                public void onSuccess() {
                    soundMessageBean.setDataPath(str);
                }
            });
        } else {
            soundMessageBean.setDataPath(str);
        }
    }

    public int getVariableLayout() {
        return R$layout.message_adapter_content_audio;
    }

    public void layoutVariableViews(TUIMessageBean tUIMessageBean, int i11) {
        final SoundMessageBean soundMessageBean = (SoundMessageBean) tUIMessageBean;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        if (soundMessageBean.isSelf()) {
            this.audioTimeText.setTextColor(this.audioTimeText.getResources().getColor(R$color.white));
            layoutParams.addRule(11);
            layoutParams.rightMargin = 24;
            this.audioPlayImage.setImageResource(R$drawable.voice_msg_playing_white_3);
            this.audioContentView.removeView(this.audioPlayImage);
            this.audioContentView.addView(this.audioPlayImage);
            this.unreadAudioText.setVisibility(8);
        } else {
            this.audioTimeText.setTextColor(this.audioTimeText.getResources().getColor(R$color.new_common_text_color));
            layoutParams.addRule(9);
            layoutParams.leftMargin = 24;
            this.audioPlayImage.setImageResource(R$drawable.voice_msg_playing_3);
            this.audioContentView.removeView(this.audioPlayImage);
            this.audioContentView.addView(this.audioPlayImage, 0);
            if (soundMessageBean.getCustomInt() == 0) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.isReadText.getLayoutParams();
                layoutParams2.gravity = 16;
                layoutParams2.leftMargin = 10;
                this.unreadAudioText.setVisibility(0);
                this.unreadAudioText.setLayoutParams(layoutParams2);
            } else {
                this.unreadAudioText.setVisibility(8);
            }
        }
        this.audioContentView.setLayoutParams(layoutParams);
        int duration = soundMessageBean.getDuration();
        if (duration == 0) {
            duration = 1;
        }
        ViewGroup.LayoutParams layoutParams3 = this.msgContentFrame.getLayoutParams();
        int pxByDp = AUDIO_MIN_WIDTH + ScreenUtil.getPxByDp((float) (duration * 6));
        layoutParams3.width = pxByDp;
        int i12 = AUDIO_MAX_WIDTH;
        if (pxByDp > i12) {
            layoutParams3.width = i12;
        }
        this.msgContentFrame.setLayoutParams(layoutParams3);
        TextView textView = this.audioTimeText;
        textView.setText(duration + "''");
        this.msgContentFrame.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                if (AudioPlayer.getInstance().isPlaying()) {
                    AudioPlayer.getInstance().stopPlay();
                    if (TextUtils.equals(AudioPlayer.getInstance().getPath(), soundMessageBean.getDataPath())) {
                        SensorsDataAutoTrackHelper.trackViewOnClick(view);
                        return;
                    }
                }
                if (TextUtils.isEmpty(soundMessageBean.getDataPath())) {
                    ToastUtil.toastShortMessage(ServiceInitializer.getAppContext().getString(R$string.voice_play_tip));
                    HbSoundMessageHolder.this.getSound(soundMessageBean);
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    return;
                }
                HbSoundMessageHolder.this.audioPlayImage.setImageResource(R$drawable.play_voice_message);
                if (soundMessageBean.isSelf()) {
                    HbSoundMessageHolder.this.audioPlayImage.setImageResource(R$drawable.play_voice_message_self);
                }
                final AnimationDrawable animationDrawable = (AnimationDrawable) HbSoundMessageHolder.this.audioPlayImage.getDrawable();
                animationDrawable.start();
                soundMessageBean.setCustomInt(1);
                HbSoundMessageHolder.this.unreadAudioText.setVisibility(8);
                AudioPlayer.getInstance().startPlay(soundMessageBean.getDataPath(), new AudioPlayer.Callback() {
                    public void onCompletion(Boolean bool) {
                        HbSoundMessageHolder.this.audioPlayImage.post(new Runnable() {
                            public void run() {
                                animationDrawable.stop();
                                HbSoundMessageHolder.this.audioPlayImage.setImageResource(R$drawable.voice_msg_playing_3);
                                if (soundMessageBean.isSelf()) {
                                    HbSoundMessageHolder.this.audioPlayImage.setImageResource(R$drawable.voice_msg_playing_white_3);
                                }
                            }
                        });
                    }
                });
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
    }
}
