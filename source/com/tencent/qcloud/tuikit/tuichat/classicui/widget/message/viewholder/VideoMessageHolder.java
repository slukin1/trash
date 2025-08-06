package com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder;

import android.content.Intent;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.request.e;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.MessageContentHolder;
import com.tencent.qcloud.tuikit.timcommon.component.impl.GlideEngine;
import com.tencent.qcloud.tuikit.timcommon.util.DateTimeUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.message.VideoMessageBean;
import com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanActivity;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class VideoMessageHolder extends MessageContentHolder {
    private static final int DEFAULT_MAX_SIZE = 540;
    private static final int DEFAULT_RADIUS = 10;
    /* access modifiers changed from: private */
    public ImageView contentImage;
    /* access modifiers changed from: private */
    public final List<String> downloadEles = new ArrayList();
    private TextView videoDurationText;
    private ImageView videoPlayBtn;

    public VideoMessageHolder(View view) {
        super(view);
        this.contentImage = (ImageView) view.findViewById(R.id.content_image_iv);
        this.videoPlayBtn = (ImageView) view.findViewById(R.id.video_play_btn);
        this.videoDurationText = (TextView) view.findViewById(R.id.video_duration_tv);
    }

    private ViewGroup.LayoutParams getImageParams(ViewGroup.LayoutParams layoutParams, VideoMessageBean videoMessageBean) {
        if (videoMessageBean.getImgWidth() == 0 || videoMessageBean.getImgHeight() == 0) {
            layoutParams.width = 540;
            layoutParams.height = 540;
            return layoutParams;
        }
        if (videoMessageBean.getImgWidth() > videoMessageBean.getImgHeight()) {
            layoutParams.width = 540;
            layoutParams.height = (videoMessageBean.getImgHeight() * 540) / videoMessageBean.getImgWidth();
        } else {
            layoutParams.width = (videoMessageBean.getImgWidth() * 540) / videoMessageBean.getImgHeight();
            layoutParams.height = 540;
        }
        return layoutParams;
    }

    private void performVideo(final VideoMessageBean videoMessageBean, final int i11) {
        ImageView imageView = this.contentImage;
        imageView.setLayoutParams(getImageParams(imageView.getLayoutParams(), videoMessageBean));
        this.videoPlayBtn.setVisibility(0);
        this.videoDurationText.setVisibility(0);
        if (!TextUtils.isEmpty(videoMessageBean.getDataPath())) {
            GlideEngine.loadCornerImageWithoutPlaceHolder(this.contentImage, videoMessageBean.getDataPath(), (e) null, 10.0f);
        } else {
            GlideEngine.clear(this.contentImage);
            synchronized (this.downloadEles) {
                if (!this.downloadEles.contains(videoMessageBean.getSnapshotUUID())) {
                    this.downloadEles.add(videoMessageBean.getSnapshotUUID());
                }
            }
            final String str = TUIConfig.getImageDownloadDir() + videoMessageBean.getSnapshotUUID();
            videoMessageBean.downloadSnapshot(str, new VideoMessageBean.VideoDownloadCallback() {
                public void onError(int i11, String str) {
                    VideoMessageHolder.this.downloadEles.remove(videoMessageBean.getSnapshotUUID());
                    TUIChatLog.e("MessageAdapter video getImage", i11 + ":" + str);
                }

                public void onProgress(long j11, long j12) {
                    TUIChatLog.i("downloadSnapshot progress current:", j11 + ", total:" + j12);
                }

                public void onSuccess() {
                    VideoMessageHolder.this.downloadEles.remove(videoMessageBean.getSnapshotUUID());
                    videoMessageBean.setDataPath(str);
                    GlideEngine.loadCornerImageWithoutPlaceHolder(VideoMessageHolder.this.contentImage, videoMessageBean.getDataPath(), (e) null, 10.0f);
                }
            });
        }
        this.videoDurationText.setText(DateTimeUtil.formatSecondsTo00(videoMessageBean.getDuration()));
        File file = new File(TUIConfig.getVideoDownloadDir() + videoMessageBean.getVideoUUID());
        if (videoMessageBean.getStatus() == 2) {
            this.statusImage.setVisibility(8);
            this.sendingProgress.setVisibility(8);
        } else if (file.exists() && videoMessageBean.getStatus() == 1) {
            this.statusImage.setVisibility(8);
            this.sendingProgress.setVisibility(0);
        } else if (videoMessageBean.getStatus() == 3) {
            this.statusImage.setVisibility(0);
            this.sendingProgress.setVisibility(8);
        }
        if (this.isMultiSelectMode) {
            this.msgContentFrame.setOnClickListener(new View.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    if (VideoMessageHolder.this.onItemClickListener != null) {
                        VideoMessageHolder.this.onItemClickListener.onMessageClick(view, i11, videoMessageBean);
                    }
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            });
            return;
        }
        this.msgContentFrame.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                Intent intent = new Intent(ServiceInitializer.getAppContext(), ImageVideoScanActivity.class);
                intent.addFlags(268435456);
                VideoMessageHolder videoMessageHolder = VideoMessageHolder.this;
                if (videoMessageHolder.isForwardMode && videoMessageHolder.getDataSource() != null && !VideoMessageHolder.this.getDataSource().isEmpty()) {
                    intent.putExtra(TUIChatConstants.OPEN_MESSAGES_SCAN_FORWARD, (Serializable) VideoMessageHolder.this.getDataSource());
                }
                intent.putExtra(TUIChatConstants.OPEN_MESSAGE_SCAN, videoMessageBean);
                intent.putExtra(TUIChatConstants.FORWARD_MODE, VideoMessageHolder.this.isForwardMode);
                ServiceInitializer.getAppContext().startActivity(intent);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        if (videoMessageBean.getMessageReactBean() == null || videoMessageBean.getMessageReactBean().getReactSize() <= 0) {
            this.msgArea.setBackground((Drawable) null);
            this.msgArea.setPadding(0, 0, 0, 0);
        }
    }

    public void clearHighLightBackground() {
        Drawable drawable = this.contentImage.getDrawable();
        if (drawable != null) {
            drawable.setColorFilter((ColorFilter) null);
        }
    }

    public int getVariableLayout() {
        return R.layout.message_adapter_content_image;
    }

    public void layoutVariableViews(TUIMessageBean tUIMessageBean, int i11) {
        performVideo((VideoMessageBean) tUIMessageBean, i11);
    }

    public void setHighLightBackground(int i11) {
        Drawable drawable = this.contentImage.getDrawable();
        if (drawable != null) {
            drawable.setColorFilter(i11, PorterDuff.Mode.SRC_ATOP);
        }
    }
}
