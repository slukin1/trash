package com.tencent.qcloud.tuikit.tuichat.bean.message;

import android.text.TextUtils;
import com.tencent.imsdk.v2.V2TIMDownloadCallback;
import com.tencent.imsdk.v2.V2TIMElem;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.imsdk.v2.V2TIMSoundElem;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.SoundReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import java.io.File;

public class SoundMessageBean extends TUIMessageBean {
    /* access modifiers changed from: private */
    public String dataPath;
    private V2TIMSoundElem soundElem;

    public interface SoundDownloadCallback {
        void onError(int i11, String str);

        void onProgress(long j11, long j12);

        void onSuccess();
    }

    public void downloadSound(String str, final SoundDownloadCallback soundDownloadCallback) {
        V2TIMSoundElem v2TIMSoundElem = this.soundElem;
        if (v2TIMSoundElem != null) {
            v2TIMSoundElem.downloadSound(str, new V2TIMDownloadCallback() {
                public void onError(int i11, String str) {
                    SoundDownloadCallback soundDownloadCallback = soundDownloadCallback;
                    if (soundDownloadCallback != null) {
                        soundDownloadCallback.onError(i11, str);
                    }
                }

                public void onProgress(V2TIMElem.V2ProgressInfo v2ProgressInfo) {
                    SoundDownloadCallback soundDownloadCallback = soundDownloadCallback;
                    if (soundDownloadCallback != null) {
                        soundDownloadCallback.onProgress(v2ProgressInfo.getCurrentSize(), v2ProgressInfo.getTotalSize());
                    }
                }

                public void onSuccess() {
                    SoundDownloadCallback soundDownloadCallback = soundDownloadCallback;
                    if (soundDownloadCallback != null) {
                        soundDownloadCallback.onSuccess();
                    }
                }
            });
        }
    }

    public int getCustomInt() {
        if (getV2TIMMessage() != null) {
            return getV2TIMMessage().getLocalCustomInt();
        }
        return 0;
    }

    public String getDataPath() {
        return this.dataPath;
    }

    public int getDuration() {
        V2TIMSoundElem v2TIMSoundElem = this.soundElem;
        if (v2TIMSoundElem != null) {
            return v2TIMSoundElem.getDuration();
        }
        return 0;
    }

    public Class<? extends TUIReplyQuoteBean> getReplyQuoteBeanClass() {
        return SoundReplyQuoteBean.class;
    }

    public String getUUID() {
        V2TIMSoundElem v2TIMSoundElem = this.soundElem;
        return v2TIMSoundElem != null ? v2TIMSoundElem.getUUID() : "";
    }

    public String onGetDisplayString() {
        return getExtra();
    }

    public void onProcessMessage(V2TIMMessage v2TIMMessage) {
        this.soundElem = v2TIMMessage.getSoundElem();
        if (!isSelf() || TextUtils.isEmpty(this.soundElem.getPath())) {
            final String str = TUIConfig.getRecordDownloadDir() + this.soundElem.getUUID();
            if (!new File(str).exists()) {
                this.soundElem.downloadSound(str, new V2TIMDownloadCallback() {
                    public void onError(int i11, String str) {
                        TUIChatLog.e("ChatMessageInfoUtil getSoundToFile", i11 + ":" + str);
                    }

                    public void onProgress(V2TIMElem.V2ProgressInfo v2ProgressInfo) {
                        long currentSize = v2ProgressInfo.getCurrentSize();
                        long totalSize = v2ProgressInfo.getTotalSize();
                        int i11 = totalSize > 0 ? (int) ((currentSize * 100) / totalSize) : 0;
                        if (i11 > 100) {
                            i11 = 100;
                        }
                        TUIChatLog.i("ChatMessageInfoUtil getSoundToFile", "progress:" + i11);
                    }

                    public void onSuccess() {
                        String unused = SoundMessageBean.this.dataPath = str;
                    }
                });
            } else {
                this.dataPath = str;
            }
        } else {
            this.dataPath = this.soundElem.getPath();
        }
        setExtra(ServiceInitializer.getAppContext().getString(R.string.audio_extra));
    }

    public void setCustomInt(int i11) {
        if (getV2TIMMessage() != null) {
            getV2TIMMessage().setLocalCustomInt(i11);
        }
    }

    public void setDataPath(String str) {
        this.dataPath = str;
    }

    public void setSoundElem(V2TIMSoundElem v2TIMSoundElem) {
        this.soundElem = v2TIMSoundElem;
    }
}
