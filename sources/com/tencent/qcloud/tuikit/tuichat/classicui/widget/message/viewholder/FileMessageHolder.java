package com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.huawei.hms.framework.common.ContainerUtils;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.ChatFlowReactView;
import com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.MessageContentHolder;
import com.tencent.qcloud.tuikit.timcommon.util.FileUtil;
import com.tencent.qcloud.tuikit.timcommon.util.ScreenUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;
import com.tencent.qcloud.tuikit.tuichat.bean.message.FileMessageBean;
import com.tencent.qcloud.tuikit.tuichat.component.progress.ProgressPresenter;
import com.tencent.qcloud.tuikit.tuichat.interfaces.NetworkConnectionListener;

public class FileMessageHolder extends MessageContentHolder {
    private TextView fileNameText;
    private TextView fileSizeText;
    /* access modifiers changed from: private */
    public TextView fileStatusText;
    private String msgId;
    private NetworkConnectionListener networkConnectionListener;
    private Drawable normalBackground;
    private ProgressDrawable progressDrawable;
    private ProgressPresenter.ProgressListener progressListener;

    public static class ProgressDrawable extends Drawable {
        private Drawable backgroundDrawable;
        private final Paint borderPaint;
        private final float borderWidth;
        private final Paint highLightPaint;
        private final Path highLightPath = new Path();
        private boolean isSelf;
        private final Paint paint;
        private int progress;
        private final Path rectPath = new Path();
        private final Path solidPath = new Path();

        public ProgressDrawable() {
            float dip2px = (float) ScreenUtil.dip2px(0.96f);
            this.borderWidth = dip2px;
            Paint paint2 = new Paint();
            this.paint = paint2;
            Paint paint3 = new Paint();
            this.borderPaint = paint3;
            paint2.setStyle(Paint.Style.FILL);
            paint3.setStyle(Paint.Style.STROKE);
            paint3.setStrokeWidth(dip2px);
            paint2.setAntiAlias(true);
            paint3.setAntiAlias(true);
            Paint paint4 = new Paint();
            this.highLightPaint = paint4;
            paint4.setAntiAlias(true);
            paint4.setStyle(Paint.Style.FILL);
            paint4.setColor(0);
        }

        public void clearHighLightColor() {
            this.highLightPaint.setColor(0);
        }

        public void draw(Canvas canvas) {
            Canvas canvas2 = canvas;
            if (this.progress != 0) {
                Rect bounds = this.backgroundDrawable.getBounds();
                int i11 = bounds.right;
                int i12 = bounds.bottom;
                int i13 = (this.progress * i11) / 100;
                float dip2px = (float) ScreenUtil.dip2px(10.96f);
                float dip2px2 = (float) ScreenUtil.dip2px(2.19f);
                float[] fArr = this.isSelf ? new float[]{dip2px, dip2px, dip2px2, dip2px2, dip2px, dip2px, dip2px, dip2px} : new float[]{dip2px2, dip2px2, dip2px, dip2px, dip2px, dip2px, dip2px, dip2px};
                this.rectPath.reset();
                this.solidPath.reset();
                this.highLightPath.reset();
                Path path = this.rectPath;
                float f11 = this.borderWidth;
                float f12 = (float) i12;
                path.addRoundRect(new RectF(f11 / 2.0f, f11 / 2.0f, ((float) i11) - (f11 / 2.0f), f12 - (f11 / 2.0f)), fArr, Path.Direction.CW);
                this.highLightPath.set(this.rectPath);
                canvas2.drawPath(this.rectPath, this.borderPaint);
                Path path2 = this.solidPath;
                float f13 = this.borderWidth;
                path2.addRect(new RectF(f13 / 2.0f, f13 / 2.0f, ((float) i13) - (f13 / 2.0f), f12 - (f13 / 2.0f)), Path.Direction.CW);
                this.rectPath.op(this.solidPath, Path.Op.INTERSECT);
                canvas2.drawPath(this.rectPath, this.paint);
                canvas2.drawPath(this.highLightPath, this.highLightPaint);
            }
        }

        public int getOpacity() {
            return 0;
        }

        public void setAlpha(int i11) {
        }

        public void setBackgroundDrawable(Drawable drawable) {
            this.backgroundDrawable = drawable;
        }

        public void setBorderColor(int i11) {
            this.borderPaint.setColor(i11);
        }

        public void setColorFilter(ColorFilter colorFilter) {
        }

        public void setHighLightColor(int i11) {
            this.highLightPaint.setColor(i11);
        }

        public void setPaintColor(int i11) {
            this.paint.setColor(i11);
        }

        public void setProgress(int i11) {
            this.progress = i11;
        }

        public void setSelf(boolean z11) {
            this.isSelf = z11;
        }
    }

    public FileMessageHolder(View view) {
        super(view);
        this.fileNameText = (TextView) view.findViewById(R.id.file_name_tv);
        this.fileSizeText = (TextView) view.findViewById(R.id.file_size_tv);
        this.fileStatusText = (TextView) view.findViewById(R.id.file_status_tv);
    }

    /* access modifiers changed from: private */
    public void downloadFile(final FileMessageBean fileMessageBean, final String str, final String str2, boolean z11) {
        if (fileMessageBean.getDownloadStatus() != 6) {
            if (fileMessageBean.getDownloadStatus() != 4 || !z11) {
                fileMessageBean.setDownloadStatus(4);
                this.fileStatusText.setText(R.string.downloading);
                fileMessageBean.downloadFile(str, new FileMessageBean.FileDownloadCallback() {
                    public void onError(int i11, String str) {
                        ToastUtil.toastLongMessage("getToFile fail:" + i11 + ContainerUtils.KEY_VALUE_DELIMITER + str);
                        FileMessageHolder.this.fileStatusText.setText(R.string.un_download);
                    }

                    public void onProgress(long j11, long j12) {
                        ProgressPresenter.getInstance().updateProgress(fileMessageBean.getId(), (int) ((j11 * 100) / j12));
                    }

                    public void onSuccess() {
                        fileMessageBean.setDataPath(str);
                        if (!fileMessageBean.isSelf()) {
                            FileMessageHolder.this.fileStatusText.setText(R.string.downloaded);
                        } else {
                            FileMessageHolder.this.fileStatusText.setText(R.string.sended);
                        }
                        fileMessageBean.setDownloadStatus(6);
                        FileMessageHolder.this.msgContentFrame.setOnClickListener(new View.OnClickListener() {
                            @SensorsDataInstrumented
                            public void onClick(View view) {
                                if (fileMessageBean.getDownloadStatus() == 6) {
                                    AnonymousClass6 r02 = AnonymousClass6.this;
                                    FileUtil.openFile(str, str2);
                                }
                                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                            }
                        });
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public void updateProgress(int i11, TUIMessageBean tUIMessageBean) {
        if (TextUtils.equals(tUIMessageBean.getId(), this.msgId)) {
            if (!tUIMessageBean.isSelf()) {
                this.fileStatusText.setText(R.string.downloading);
            } else {
                this.fileStatusText.setText(R.string.sending);
            }
            tUIMessageBean.setDownloadStatus(4);
            if (i11 == 0 || i11 == 100) {
                this.msgArea.setBackground(this.normalBackground);
                ProgressDrawable progressDrawable2 = this.progressDrawable;
                if (progressDrawable2 != null) {
                    progressDrawable2.setProgress(0);
                }
                if (i11 == 100) {
                    if (!tUIMessageBean.isSelf()) {
                        this.fileStatusText.setText(R.string.downloaded);
                    } else {
                        this.fileStatusText.setText(R.string.sended);
                    }
                    tUIMessageBean.setDownloadStatus(6);
                    return;
                }
                return;
            }
            Drawable background = this.msgArea.getBackground();
            if (background != null) {
                ProgressDrawable progressDrawable3 = this.progressDrawable;
                if (progressDrawable3 == null) {
                    ProgressDrawable progressDrawable4 = new ProgressDrawable();
                    this.progressDrawable = progressDrawable4;
                    progressDrawable4.setProgress(i11);
                    Context context = this.itemView.getContext();
                    this.progressDrawable.setPaintColor(context.getResources().getColor(TUIThemeManager.getAttrResId(context, com.tencent.qcloud.tuicore.R.attr.core_bubble_bg_color)));
                    this.progressDrawable.setBorderColor(context.getResources().getColor(R.color.chat_message_bubble_bg_stoke_color));
                    this.progressDrawable.setSelf(tUIMessageBean.isSelf());
                    this.progressDrawable.setBackgroundDrawable(background);
                    this.msgArea.setBackground(this.progressDrawable);
                    return;
                }
                progressDrawable3.setProgress(i11);
                this.msgArea.setBackground(this.progressDrawable);
                this.msgArea.getBackground().invalidateSelf();
            }
        }
    }

    public void clearHighLightBackground() {
        Drawable drawable = this.normalBackground;
        if (drawable != null) {
            drawable.setColorFilter((ColorFilter) null);
        }
        ProgressDrawable progressDrawable2 = this.progressDrawable;
        if (progressDrawable2 != null) {
            progressDrawable2.clearHighLightColor();
            this.progressDrawable.invalidateSelf();
        }
    }

    public int getVariableLayout() {
        return R.layout.message_adapter_content_file;
    }

    public void layoutVariableViews(final TUIMessageBean tUIMessageBean, final int i11) {
        this.msgArea.setPadding(0, 0, 0, 0);
        this.msgId = tUIMessageBean.getId();
        ChatFlowReactView chatFlowReactView = this.reactView;
        chatFlowReactView.setThemeColorId(TUIThemeManager.getAttrResId(chatFlowReactView.getContext(), com.tencent.qcloud.tuikit.timcommon.R.attr.chat_react_other_text_color));
        if (this.isForwardMode || this.isReplyDetailMode) {
            this.msgArea.setBackgroundResource(R.drawable.chat_bubble_other_cavity_bg);
            this.statusImage.setVisibility(8);
        } else if (tUIMessageBean.isSelf()) {
            if (this.properties.getRightBubble() == null || this.properties.getRightBubble().getConstantState() == null) {
                this.msgArea.setBackgroundResource(R.drawable.chat_bubble_self_cavity_bg);
            } else {
                this.msgArea.setBackground(this.properties.getRightBubble().getConstantState().newDrawable());
            }
        } else if (this.properties.getLeftBubble() == null || this.properties.getLeftBubble().getConstantState() == null) {
            this.msgArea.setBackgroundResource(R.drawable.chat_bubble_other_cavity_bg);
        } else {
            this.msgArea.setBackground(this.properties.getLeftBubble().getConstantState().newDrawable());
        }
        this.normalBackground = this.msgArea.getBackground();
        this.progressListener = new ProgressPresenter.ProgressListener() {
            public void onProgress(int i11) {
                FileMessageHolder.this.updateProgress(i11, tUIMessageBean);
            }
        };
        this.sendingProgress.setVisibility(8);
        final FileMessageBean fileMessageBean = (FileMessageBean) tUIMessageBean;
        final String dataPath = fileMessageBean.getDataPath();
        this.fileNameText.setText(fileMessageBean.getFileName());
        String formatFileSize = FileUtil.formatFileSize((long) fileMessageBean.getFileSize());
        final String fileName = fileMessageBean.getFileName();
        this.fileSizeText.setText(formatFileSize);
        if (!this.isMultiSelectMode) {
            this.msgContentFrame.setOnClickListener(new View.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    if (fileMessageBean.getDownloadStatus() == 6) {
                        FileUtil.openFile(dataPath, fileName);
                    }
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            });
        } else {
            this.msgContentFrame.setOnClickListener(new View.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    if (FileMessageHolder.this.onItemClickListener != null) {
                        FileMessageHolder.this.onItemClickListener.onMessageClick(view, i11, tUIMessageBean);
                    }
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            });
        }
        if (fileMessageBean.getStatus() == 2 && fileMessageBean.getDownloadStatus() == 6) {
            this.fileStatusText.setText(R.string.sended);
        } else if (fileMessageBean.getStatus() == 1) {
            this.fileStatusText.setText(R.string.sending);
        } else if (fileMessageBean.getStatus() == 3) {
            this.fileStatusText.setText(R.string.send_failed);
        } else if (fileMessageBean.getDownloadStatus() == 4) {
            this.fileStatusText.setText(R.string.downloading);
        } else if (fileMessageBean.getDownloadStatus() == 6) {
            if (!fileMessageBean.isSelf()) {
                this.fileStatusText.setText(R.string.downloaded);
            } else {
                this.fileStatusText.setText(R.string.sended);
            }
        } else if (fileMessageBean.getDownloadStatus() == 5) {
            this.fileStatusText.setText(R.string.un_download);
        }
        if (fileMessageBean.getDownloadStatus() == 5) {
            if (!this.isMultiSelectMode) {
                this.msgContentFrame.setOnClickListener(new View.OnClickListener() {
                    @SensorsDataInstrumented
                    public void onClick(View view) {
                        FileMessageHolder.this.downloadFile(fileMessageBean, dataPath, fileName, true);
                        SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    }
                });
            } else {
                return;
            }
        }
        this.networkConnectionListener = new NetworkConnectionListener() {
            public void onConnected() {
                if (fileMessageBean.getDownloadStatus() == 4) {
                    FileMessageHolder.this.downloadFile(fileMessageBean, dataPath, fileName, false);
                }
            }
        };
        TUIChatService.getInstance().registerNetworkListener(this.networkConnectionListener);
        ProgressPresenter.getInstance().registerProgressListener(tUIMessageBean.getId(), this.progressListener);
    }

    public void onRecycled() {
        super.onRecycled();
        this.progressListener = null;
        ProgressPresenter.getInstance().unregisterProgressListener(this.msgId, this.progressListener);
    }

    public void setHighLightBackground(int i11) {
        Drawable drawable = this.normalBackground;
        if (drawable != null) {
            drawable.setColorFilter(i11, PorterDuff.Mode.SRC_IN);
        }
        ProgressDrawable progressDrawable2 = this.progressDrawable;
        if (progressDrawable2 != null) {
            progressDrawable2.setHighLightColor(i11);
            this.progressDrawable.invalidateSelf();
        }
    }
}
