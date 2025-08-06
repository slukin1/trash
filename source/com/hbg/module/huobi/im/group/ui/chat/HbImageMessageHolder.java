package com.hbg.module.huobi.im.group.ui.chat;

import android.content.Intent;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import c4.g;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.e;
import com.hbg.module.huobi.im.R$id;
import com.hbg.module.huobi.im.R$layout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.component.impl.GlideEngine;
import com.tencent.qcloud.tuikit.timcommon.util.ImageUtil;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean;
import com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanActivity;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HbImageMessageHolder extends HbMessageContentHolder {
    private static final int DEFAULT_MAX_SIZE = 540;
    private static final int DEFAULT_RADIUS = 10;
    /* access modifiers changed from: private */
    public ImageView contentImage;
    /* access modifiers changed from: private */
    public final List<String> downloadEles = new ArrayList();
    /* access modifiers changed from: private */
    public String mImagePath = null;
    private TextView videoDurationText;
    private ImageView videoPlayBtn;

    public HbImageMessageHolder(View view) {
        super(view);
        this.contentImage = (ImageView) view.findViewById(R$id.content_image_iv);
        this.videoPlayBtn = (ImageView) view.findViewById(R$id.video_play_btn);
        this.videoDurationText = (TextView) view.findViewById(R$id.video_duration_tv);
    }

    private ViewGroup.LayoutParams getImageParams(ViewGroup.LayoutParams layoutParams, ImageMessageBean imageMessageBean) {
        if (!(imageMessageBean.getImgWidth() == 0 || imageMessageBean.getImgHeight() == 0)) {
            if (imageMessageBean.getImgWidth() > imageMessageBean.getImgHeight()) {
                layoutParams.width = 540;
                layoutParams.height = (imageMessageBean.getImgHeight() * 540) / imageMessageBean.getImgWidth();
            } else {
                layoutParams.width = (imageMessageBean.getImgWidth() * 540) / imageMessageBean.getImgHeight();
                layoutParams.height = 540;
            }
        }
        return layoutParams;
    }

    private void performImage(final ImageMessageBean imageMessageBean, final int i11) {
        ImageView imageView = this.contentImage;
        imageView.setLayoutParams(getImageParams(imageView.getLayoutParams(), imageMessageBean));
        resetParentLayout();
        this.videoPlayBtn.setVisibility(8);
        this.videoDurationText.setVisibility(8);
        List<ImageMessageBean.ImageBean> imageBeanList = imageMessageBean.getImageBeanList();
        String dataPath = imageMessageBean.getDataPath();
        String originImagePath = TUIChatUtils.getOriginImagePath(imageMessageBean);
        if (!TextUtils.isEmpty(originImagePath)) {
            dataPath = originImagePath;
        }
        if (TextUtils.isEmpty(dataPath)) {
            GlideEngine.clear(this.contentImage);
            int i12 = 0;
            while (true) {
                if (i12 >= imageBeanList.size()) {
                    break;
                }
                final ImageMessageBean.ImageBean imageBean = imageBeanList.get(i12);
                if (imageBean.getType() == 1) {
                    synchronized (this.downloadEles) {
                        if (!this.downloadEles.contains(imageBean.getUUID())) {
                            this.downloadEles.add(imageBean.getUUID());
                            final String generateImagePath = ImageUtil.generateImagePath(imageBean.getUUID(), 1);
                            if (!generateImagePath.equals(this.mImagePath)) {
                                GlideEngine.clear(this.contentImage);
                            }
                            imageBean.downloadImage(generateImagePath, new ImageMessageBean.ImageBean.ImageDownloadCallback() {
                                public void onError(int i11, String str) {
                                    HbImageMessageHolder.this.downloadEles.remove(imageBean.getUUID());
                                    TUIChatLog.e("MessageAdapter img getImage", i11 + ":" + str);
                                }

                                public void onProgress(long j11, long j12) {
                                    TUIChatLog.i("downloadImage progress current:", j11 + ", total:" + j12);
                                }

                                public void onSuccess() {
                                    HbImageMessageHolder.this.downloadEles.remove(imageBean.getUUID());
                                    imageMessageBean.setDataPath(generateImagePath);
                                    GlideEngine.loadCornerImageWithoutPlaceHolder(HbImageMessageHolder.this.contentImage, imageMessageBean.getDataPath(), new e() {
                                        public boolean onLoadFailed(GlideException glideException, Object obj, g gVar, boolean z11) {
                                            String unused = HbImageMessageHolder.this.mImagePath = null;
                                            return false;
                                        }

                                        public boolean onResourceReady(Object obj, Object obj2, g gVar, DataSource dataSource, boolean z11) {
                                            AnonymousClass1 r12 = AnonymousClass1.this;
                                            String unused = HbImageMessageHolder.this.mImagePath = generateImagePath;
                                            return false;
                                        }
                                    }, 10.0f);
                                }
                            });
                        }
                    }
                } else {
                    i12++;
                }
            }
        } else {
            GlideEngine.loadCornerImageWithoutPlaceHolder(this.contentImage, dataPath, (e) null, 10.0f);
        }
        if (this.isMultiSelectMode) {
            this.contentImage.setOnClickListener(new View.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    if (HbImageMessageHolder.this.onItemClickListener != null) {
                        HbImageMessageHolder.this.onItemClickListener.onMessageClick(view, i11, imageMessageBean);
                    }
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            });
            return;
        }
        this.contentImage.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                Intent intent = new Intent(ServiceInitializer.getAppContext(), ImageVideoScanActivity.class);
                intent.addFlags(268435456);
                HbImageMessageHolder hbImageMessageHolder = HbImageMessageHolder.this;
                if (hbImageMessageHolder.isForwardMode && hbImageMessageHolder.getDataSource() != null && !HbImageMessageHolder.this.getDataSource().isEmpty()) {
                    intent.putExtra(TUIChatConstants.OPEN_MESSAGES_SCAN_FORWARD, (Serializable) HbImageMessageHolder.this.getDataSource());
                }
                intent.putExtra(TUIChatConstants.OPEN_MESSAGE_SCAN, imageMessageBean);
                intent.putExtra(TUIChatConstants.FORWARD_MODE, HbImageMessageHolder.this.isForwardMode);
                ServiceInitializer.getAppContext().startActivity(intent);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.contentImage.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                if (HbImageMessageHolder.this.onItemClickListener == null) {
                    return true;
                }
                HbImageMessageHolder.this.onItemClickListener.onMessageLongClick(view, i11, imageMessageBean);
                return true;
            }
        });
    }

    private void resetParentLayout() {
        ((FrameLayout) this.contentImage.getParent().getParent()).setPadding(17, 0, 13, 0);
    }

    public void clearHighLightBackground() {
        Drawable drawable = this.contentImage.getDrawable();
        if (drawable != null) {
            drawable.setColorFilter((ColorFilter) null);
        }
    }

    public int getVariableLayout() {
        return R$layout.message_adapter_content_image;
    }

    public void layoutVariableViews(TUIMessageBean tUIMessageBean, int i11) {
        this.msgContentFrame.setBackground((Drawable) null);
        performImage((ImageMessageBean) tUIMessageBean, i11);
    }

    public void setHighLightBackground(int i11) {
        Drawable drawable = this.contentImage.getDrawable();
        if (drawable != null) {
            drawable.setColorFilter(i11, PorterDuff.Mode.SRC_ATOP);
        }
    }
}
