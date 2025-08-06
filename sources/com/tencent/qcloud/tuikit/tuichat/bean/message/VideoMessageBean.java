package com.tencent.qcloud.tuikit.tuichat.bean.message;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.imsdk.BaseConstants;
import com.tencent.imsdk.v2.V2TIMDownloadCallback;
import com.tencent.imsdk.v2.V2TIMElem;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.imsdk.v2.V2TIMValueCallback;
import com.tencent.imsdk.v2.V2TIMVideoElem;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIReplyQuoteBean;
import com.tencent.qcloud.tuikit.timcommon.util.FileUtil;
import com.tencent.qcloud.tuikit.timcommon.util.ImageUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.VideoReplyQuoteBean;
import java.io.File;

public class VideoMessageBean extends TUIMessageBean {
    private String dataPath;
    private String dataUri;
    private int imgHeight;
    private int imgWidth;
    private V2TIMVideoElem videoElem;

    public interface VideoDownloadCallback {
        void onError(int i11, String str);

        void onProgress(long j11, long j12);

        void onSuccess();
    }

    public void downloadSnapshot(String str, final VideoDownloadCallback videoDownloadCallback) {
        V2TIMVideoElem v2TIMVideoElem = this.videoElem;
        if (v2TIMVideoElem != null) {
            v2TIMVideoElem.downloadSnapshot(str, new V2TIMDownloadCallback() {
                public void onError(int i11, String str) {
                    VideoDownloadCallback videoDownloadCallback = videoDownloadCallback;
                    if (videoDownloadCallback != null) {
                        videoDownloadCallback.onError(i11, str);
                    }
                }

                public void onProgress(V2TIMElem.V2ProgressInfo v2ProgressInfo) {
                    VideoDownloadCallback videoDownloadCallback = videoDownloadCallback;
                    if (videoDownloadCallback != null) {
                        videoDownloadCallback.onProgress(v2ProgressInfo.getCurrentSize(), v2ProgressInfo.getTotalSize());
                    }
                }

                public void onSuccess() {
                    VideoDownloadCallback videoDownloadCallback = videoDownloadCallback;
                    if (videoDownloadCallback != null) {
                        videoDownloadCallback.onSuccess();
                    }
                }
            });
        }
    }

    public void downloadVideo(String str, final VideoDownloadCallback videoDownloadCallback) {
        V2TIMVideoElem v2TIMVideoElem = this.videoElem;
        if (v2TIMVideoElem != null) {
            v2TIMVideoElem.downloadVideo(str, new V2TIMDownloadCallback() {
                public void onError(int i11, String str) {
                    VideoDownloadCallback videoDownloadCallback = videoDownloadCallback;
                    if (videoDownloadCallback != null) {
                        videoDownloadCallback.onError(i11, str);
                    }
                }

                public void onProgress(V2TIMElem.V2ProgressInfo v2ProgressInfo) {
                    VideoDownloadCallback videoDownloadCallback = videoDownloadCallback;
                    if (videoDownloadCallback != null) {
                        videoDownloadCallback.onProgress(v2ProgressInfo.getCurrentSize(), v2ProgressInfo.getTotalSize());
                    }
                }

                public void onSuccess() {
                    VideoDownloadCallback videoDownloadCallback = videoDownloadCallback;
                    if (videoDownloadCallback != null) {
                        videoDownloadCallback.onSuccess();
                    }
                }
            });
        }
    }

    public String getDataPath() {
        return this.dataPath;
    }

    public Uri getDataUriObj() {
        if (!TextUtils.isEmpty(this.dataUri)) {
            return Uri.parse(this.dataUri);
        }
        return null;
    }

    public int getDuration() {
        V2TIMVideoElem v2TIMVideoElem = this.videoElem;
        if (v2TIMVideoElem != null) {
            return v2TIMVideoElem.getDuration();
        }
        return 0;
    }

    public int getImgHeight() {
        return this.imgHeight;
    }

    public int getImgWidth() {
        return this.imgWidth;
    }

    public Class<? extends TUIReplyQuoteBean> getReplyQuoteBeanClass() {
        return VideoReplyQuoteBean.class;
    }

    public String getSnapshotUUID() {
        V2TIMVideoElem v2TIMVideoElem = this.videoElem;
        return v2TIMVideoElem != null ? v2TIMVideoElem.getSnapshotUUID() : "";
    }

    public int getVideoSize() {
        V2TIMVideoElem v2TIMVideoElem = this.videoElem;
        if (v2TIMVideoElem != null) {
            return v2TIMVideoElem.getVideoSize();
        }
        return 0;
    }

    public String getVideoUUID() {
        V2TIMVideoElem v2TIMVideoElem = this.videoElem;
        return v2TIMVideoElem != null ? v2TIMVideoElem.getVideoUUID() : "";
    }

    public void getVideoUrl(V2TIMValueCallback<String> v2TIMValueCallback) {
        if (v2TIMValueCallback != null) {
            V2TIMVideoElem v2TIMVideoElem = this.videoElem;
            if (v2TIMVideoElem == null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "elem is null");
            } else {
                v2TIMVideoElem.getVideoUrl(v2TIMValueCallback);
            }
        }
    }

    public String onGetDisplayString() {
        return getExtra();
    }

    public void onProcessMessage(V2TIMMessage v2TIMMessage) {
        V2TIMVideoElem videoElem2 = v2TIMMessage.getVideoElem();
        if (!isSelf() || TextUtils.isEmpty(videoElem2.getSnapshotPath())) {
            setDataUri(Uri.parse(TUIConfig.getVideoDownloadDir() + videoElem2.getVideoUUID()));
            this.imgWidth = videoElem2.getSnapshotWidth();
            this.imgHeight = videoElem2.getSnapshotHeight();
            String str = TUIConfig.getImageDownloadDir() + videoElem2.getSnapshotUUID();
            if (new File(str).exists()) {
                this.dataPath = str;
            }
        } else {
            int[] imageSize = ImageUtil.getImageSize(videoElem2.getSnapshotPath());
            this.imgWidth = imageSize[0];
            this.imgHeight = imageSize[1];
            this.dataPath = videoElem2.getSnapshotPath();
            setDataUri(FileUtil.getUriFromPath(videoElem2.getVideoPath()));
        }
        if (v2TIMMessage.getElemType() == 5) {
            this.videoElem = v2TIMMessage.getVideoElem();
        }
        setExtra(ServiceInitializer.getAppContext().getString(R.string.video_extra));
    }

    public void setDataPath(String str) {
        this.dataPath = str;
    }

    public void setDataUri(Uri uri) {
        if (uri != null) {
            this.dataUri = uri.toString();
        }
    }

    public void setImgHeight(int i11) {
        this.imgHeight = i11;
    }

    public void setImgWidth(int i11) {
        this.imgWidth = i11;
    }

    public void setVideoElem(V2TIMVideoElem v2TIMVideoElem) {
        this.videoElem = v2TIMVideoElem;
    }
}
