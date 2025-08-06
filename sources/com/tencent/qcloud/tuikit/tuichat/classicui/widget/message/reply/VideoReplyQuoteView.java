package com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.reply;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.bumptech.glide.request.e;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIReplyQuoteBean;
import com.tencent.qcloud.tuikit.timcommon.component.impl.GlideEngine;
import com.tencent.qcloud.tuikit.tuichat.bean.message.VideoMessageBean;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;

public class VideoReplyQuoteView extends ImageReplyQuoteView {
    public VideoReplyQuoteView(Context context) {
        super(context);
    }

    public void onDrawReplyQuote(TUIReplyQuoteBean tUIReplyQuoteBean) {
        final VideoMessageBean videoMessageBean = (VideoMessageBean) tUIReplyQuoteBean.getMessageBean();
        ViewGroup.LayoutParams imageParams = getImageParams(this.imageMsgIv.getLayoutParams(), videoMessageBean.getImgWidth(), videoMessageBean.getImgHeight());
        this.imageMsgIv.setLayoutParams(imageParams);
        this.videoPlayIv.setLayoutParams(imageParams);
        this.imageMsgLayout.setVisibility(0);
        this.videoPlayIv.setVisibility(0);
        if (!TextUtils.isEmpty(videoMessageBean.getDataPath())) {
            GlideEngine.loadCornerImageWithoutPlaceHolder(this.imageMsgIv, videoMessageBean.getDataPath(), (e) null, 2.0f);
            return;
        }
        GlideEngine.clear(this.imageMsgIv);
        synchronized (this.downloadEles) {
            if (!this.downloadEles.contains(videoMessageBean.getSnapshotUUID())) {
                this.downloadEles.add(videoMessageBean.getSnapshotUUID());
            }
        }
        final String str = TUIConfig.getImageDownloadDir() + videoMessageBean.getSnapshotUUID();
        videoMessageBean.downloadSnapshot(str, new VideoMessageBean.VideoDownloadCallback() {
            public void onError(int i11, String str) {
                VideoReplyQuoteView.this.downloadEles.remove(videoMessageBean.getSnapshotUUID());
                TUIChatLog.e("MessageAdapter video getImage", i11 + ":" + str);
            }

            public void onProgress(long j11, long j12) {
                TUIChatLog.i("downloadSnapshot progress current:", j11 + ", total:" + j12);
            }

            public void onSuccess() {
                VideoReplyQuoteView.this.downloadEles.remove(videoMessageBean.getSnapshotUUID());
                videoMessageBean.setDataPath(str);
                GlideEngine.loadCornerImageWithoutPlaceHolder(VideoReplyQuoteView.this.imageMsgIv, videoMessageBean.getDataPath(), (e) null, 2.0f);
            }
        });
    }
}
