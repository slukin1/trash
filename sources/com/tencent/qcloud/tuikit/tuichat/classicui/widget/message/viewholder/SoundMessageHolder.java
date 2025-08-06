package com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder;

import android.graphics.drawable.AnimationDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.MessageContentHolder;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.SoundMessageBean;
import com.tencent.qcloud.tuikit.tuichat.component.AudioPlayer;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import java.io.File;

public class SoundMessageHolder extends MessageContentHolder {
    private static final int READ = 1;
    private static final int UNREAD = 0;
    private LinearLayout audioContentView;
    /* access modifiers changed from: private */
    public ImageView audioPlayImage;
    private TextView audioTimeText;

    public SoundMessageHolder(View view) {
        super(view);
        this.audioTimeText = (TextView) view.findViewById(R.id.audio_time_tv);
        this.audioPlayImage = (ImageView) view.findViewById(R.id.audio_play_iv);
        this.audioContentView = (LinearLayout) view.findViewById(R.id.audio_content_ll);
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
        return R.layout.message_adapter_content_audio;
    }

    public void layoutVariableViews(TUIMessageBean tUIMessageBean, int i11) {
        final SoundMessageBean soundMessageBean = (SoundMessageBean) tUIMessageBean;
        if (soundMessageBean.isSelf()) {
            this.audioPlayImage.setImageResource(R.drawable.voice_msg_playing_3);
            this.audioPlayImage.setRotation(180.0f);
            this.audioContentView.removeView(this.audioPlayImage);
            this.audioContentView.addView(this.audioPlayImage);
            this.unreadAudioText.setVisibility(8);
        } else {
            this.audioPlayImage.setImageResource(R.drawable.voice_msg_playing_3);
            this.audioContentView.removeView(this.audioPlayImage);
            this.audioContentView.addView(this.audioPlayImage, 0);
            if (soundMessageBean.getCustomInt() == 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.isReadText.getLayoutParams();
                layoutParams.gravity = 16;
                layoutParams.leftMargin = 10;
                this.unreadAudioText.setVisibility(0);
                this.unreadAudioText.setLayoutParams(layoutParams);
            } else {
                this.unreadAudioText.setVisibility(8);
            }
        }
        int duration = soundMessageBean.getDuration();
        if (duration == 0) {
            duration = 1;
        }
        if (this.isReplyDetailMode || this.isForwardMode || !tUIMessageBean.isSelf()) {
            this.audioTimeText.setTextColor(this.audioTimeText.getResources().getColor(TUIThemeManager.getAttrResId(this.audioTimeText.getContext(), R.attr.chat_other_msg_text_color)));
        } else {
            this.audioTimeText.setTextColor(this.audioTimeText.getResources().getColor(TUIThemeManager.getAttrResId(this.audioTimeText.getContext(), R.attr.chat_self_msg_text_color)));
        }
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
                    ToastUtil.toastShortMessage(ServiceInitializer.getAppContext().getString(R.string.voice_play_tip));
                    SoundMessageHolder.this.getSound(soundMessageBean);
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    return;
                }
                SoundMessageHolder.this.audioPlayImage.setImageResource(R.drawable.play_voice_message);
                if (soundMessageBean.isSelf()) {
                    SoundMessageHolder.this.audioPlayImage.setRotation(180.0f);
                }
                final AnimationDrawable animationDrawable = (AnimationDrawable) SoundMessageHolder.this.audioPlayImage.getDrawable();
                animationDrawable.start();
                soundMessageBean.setCustomInt(1);
                SoundMessageHolder.this.unreadAudioText.setVisibility(8);
                AudioPlayer.getInstance().startPlay(soundMessageBean.getDataPath(), new AudioPlayer.Callback() {
                    public void onCompletion(Boolean bool) {
                        SoundMessageHolder.this.audioPlayImage.post(new Runnable() {
                            public void run() {
                                animationDrawable.stop();
                                SoundMessageHolder.this.audioPlayImage.setImageResource(R.drawable.voice_msg_playing_3);
                                if (soundMessageBean.isSelf()) {
                                    SoundMessageHolder.this.audioPlayImage.setRotation(180.0f);
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
