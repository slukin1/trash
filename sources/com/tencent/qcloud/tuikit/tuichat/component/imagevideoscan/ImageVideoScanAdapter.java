package com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.a;
import com.bumptech.glide.c;
import com.bumptech.glide.request.RequestOptions;
import com.huawei.hms.framework.common.ContainerUtils;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.tencent.imsdk.v2.V2TIMDownloadCallback;
import com.tencent.imsdk.v2.V2TIMElem;
import com.tencent.imsdk.v2.V2TIMImageElem;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.imsdk.v2.V2TIMVideoElem;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.util.DateTimeUtil;
import com.tencent.qcloud.tuikit.timcommon.util.FileUtil;
import com.tencent.qcloud.tuikit.timcommon.util.ImageUtil;
import com.tencent.qcloud.tuikit.timcommon.util.ScreenUtil;
import com.tencent.qcloud.tuikit.timcommon.util.ThreadUtils;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.VideoMessageBean;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.photoview.listener.OnMatrixChangedListener;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.photoview.listener.OnPhotoTapListener;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.photoview.listener.OnSingleFlingListener;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.photoview.view.PhotoView;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.video.UIKitVideoView;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.video.proxy.IPlayer;
import com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanActivity;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ImageVideoScanAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static final String BROADCAST_DOWNLOAD_COMPLETED_ACTION = "PhotoViewActivityDownloadOriginImageCompleted";
    private static final String DOWNLOAD_ORIGIN_IMAGE_PATH = "downloadOriginImagePath";
    /* access modifiers changed from: private */
    public static final String TAG = "ImageVideoScanAdapter";
    private BroadcastReceiver downloadReceiver;
    /* access modifiers changed from: private */
    public Handler durationHandler;
    /* access modifiers changed from: private */
    public String mCacheImagePath;
    /* access modifiers changed from: private */
    public Context mContext;
    private List<TUIMessageBean> mDataSource;
    /* access modifiers changed from: private */
    public boolean mIsVideoPlay;
    private TUIMessageBean mNewLocateMessage;
    private TUIMessageBean mOldLocateMessage;
    /* access modifiers changed from: private */
    public ImageVideoScanActivity.OnItemClickListener onItemClickListener;
    /* access modifiers changed from: private */
    public Runnable updateSeekBarTime;

    public class MatrixChangeListener implements OnMatrixChangedListener {
        private MatrixChangeListener() {
        }

        public void onMatrixChanged(RectF rectF) {
        }
    }

    public class PhotoTapListener implements OnPhotoTapListener {
        private PhotoTapListener() {
        }

        public void onPhotoTap(ImageView imageView, float f11, float f12) {
            if (ImageVideoScanAdapter.this.onItemClickListener != null) {
                ImageVideoScanAdapter.this.onItemClickListener.onClickItem();
            }
        }
    }

    public class SingleFlingListener implements OnSingleFlingListener {
        private SingleFlingListener() {
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f11, float f12) {
            return true;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView closeButton;
        public boolean downloadVideoFailed = false;
        public boolean downloadVideoFinished = false;
        public ProgressBar loadingView;
        public ImageView pauseCenterView;
        public PhotoView photoView;
        public RelativeLayout photoViewLayout;
        public ImageView playButton;
        public LinearLayout playControlLayout;
        public SeekBar playSeekBar;
        public ImageView snapImageView;
        public TextView timeBeginView;
        public TextView timeEndView;
        public UIKitVideoView videoView;
        public FrameLayout videoViewLayout;
        public TextView viewOriginalButton;

        public ViewHolder(View view) {
            super(view);
            this.photoViewLayout = (RelativeLayout) view.findViewById(R.id.photo_view_layout);
            this.photoView = (PhotoView) view.findViewById(R.id.photo_view);
            this.viewOriginalButton = (TextView) view.findViewById(R.id.view_original_btn);
            this.videoView = (UIKitVideoView) view.findViewById(R.id.video_play_view);
            this.closeButton = (ImageView) view.findViewById(R.id.close_button);
            this.playControlLayout = (LinearLayout) view.findViewById(R.id.play_control_layout);
            this.playButton = (ImageView) view.findViewById(R.id.play_button);
            this.playSeekBar = (SeekBar) view.findViewById(R.id.play_seek);
            this.timeEndView = (TextView) view.findViewById(R.id.time_end);
            this.timeBeginView = (TextView) view.findViewById(R.id.time_begin);
            this.pauseCenterView = (ImageView) view.findViewById(R.id.pause_button_center);
            this.snapImageView = (ImageView) view.findViewById(R.id.content_image_iv);
            this.loadingView = (ProgressBar) view.findViewById(R.id.message_sending_pb);
            this.videoViewLayout = (FrameLayout) view.findViewById(R.id.video_view_layout);
        }
    }

    public ImageVideoScanAdapter() {
        this.mDataSource = new ArrayList();
        this.mContext = null;
        this.mIsVideoPlay = false;
        this.mCacheImagePath = null;
        this.mContext = ServiceInitializer.getAppContext();
    }

    /* access modifiers changed from: private */
    public void clickPlayVideo(ViewHolder viewHolder) {
        if (!viewHolder.videoView.isPrepared()) {
            this.mIsVideoPlay = false;
            TUIChatLog.e(TAG, "!holder.videoView.isPrepared()");
        } else if (viewHolder.videoView.isPlaying()) {
            TUIChatLog.d(TAG, "holder.videoView.isPlaying()");
            viewHolder.videoView.pause();
            viewHolder.playButton.setImageResource(R.drawable.ic_play_icon);
            viewHolder.pauseCenterView.setVisibility(0);
            viewHolder.loadingView.setVisibility(8);
            this.mIsVideoPlay = false;
        } else if ((((float) viewHolder.videoView.getDuration()) * 1.0f) / 1000.0f <= 0.0f) {
            TUIChatLog.e(TAG, "onClick, downloading video");
            viewHolder.pauseCenterView.setVisibility(8);
            viewHolder.loadingView.setVisibility(0);
            resetVideo(viewHolder);
        } else {
            int round = Math.round((((float) viewHolder.videoView.getDuration()) * 1.0f) / 1000.0f);
            int round2 = Math.round((((float) viewHolder.videoView.getCurrentPosition()) * 1.0f) / 1000.0f);
            String str = TAG;
            TUIChatLog.d(str, "onClick playSeekBar duration == " + round + " playSeekBar progress = " + round2);
            if (viewHolder.playSeekBar.getProgress() >= round) {
                TUIChatLog.e(str, "getProgress() >= duration");
                resetVideo(viewHolder);
                return;
            }
            viewHolder.videoView.start();
            viewHolder.playButton.setImageResource(R.drawable.ic_pause_icon);
            viewHolder.pauseCenterView.setVisibility(8);
            viewHolder.loadingView.setVisibility(8);
            viewHolder.snapImageView.setVisibility(8);
            this.mIsVideoPlay = true;
            viewHolder.playSeekBar.setMax(round);
            viewHolder.playSeekBar.setProgress(round2);
            viewHolder.timeEndView.setText(DateTimeUtil.formatSecondsTo00(round));
            Handler handler = this.durationHandler;
            if (handler != null) {
                handler.postDelayed(this.updateSeekBarTime, 100);
            }
        }
    }

    private TUIMessageBean getItem(int i11) {
        List<TUIMessageBean> list = this.mDataSource;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return this.mDataSource.get(i11);
    }

    private void getVideo(ViewHolder viewHolder, String str, VideoMessageBean videoMessageBean, boolean z11, int i11) {
        final ViewHolder viewHolder2 = viewHolder;
        final VideoMessageBean videoMessageBean2 = videoMessageBean;
        final int i12 = i11;
        final boolean z12 = z11;
        videoMessageBean.downloadVideo(str, new VideoMessageBean.VideoDownloadCallback() {
            public void onError(int i11, String str) {
                ToastUtil.toastLongMessage(ServiceInitializer.getAppContext().getString(R.string.download_file_error) + i11 + ContainerUtils.KEY_VALUE_DELIMITER + str);
                videoMessageBean2.setStatus(6);
                ImageVideoScanAdapter.this.notifyItemChanged(i12);
                viewHolder2.downloadVideoFailed = true;
            }

            public void onProgress(long j11, long j12) {
                TUIChatLog.i("downloadVideo progress current:", j11 + ", total:" + j12);
                viewHolder2.downloadVideoFinished = false;
            }

            public void onSuccess() {
                viewHolder2.pauseCenterView.setVisibility(0);
                viewHolder2.loadingView.setVisibility(8);
                ImageVideoScanAdapter.this.notifyItemChanged(i12);
                ViewHolder viewHolder = viewHolder2;
                viewHolder.downloadVideoFailed = false;
                viewHolder.downloadVideoFinished = true;
                if (z12) {
                    ImageVideoScanAdapter.this.playVideo(viewHolder, videoMessageBean2);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void loadImageIntoView(ImageView imageView, Object obj) {
        ((c) a.v(ServiceInitializer.getAppContext()).p(obj).e()).b(new RequestOptions().l(17301579)).D0(imageView);
    }

    private void loadPhotoView(final ViewHolder viewHolder, final ImageMessageBean imageMessageBean, int i11) {
        List<ImageMessageBean.ImageBean> imageBeanList = imageMessageBean.getImageBeanList();
        String dataPath = imageMessageBean.getDataPath();
        String originImagePath = TUIChatUtils.getOriginImagePath(imageMessageBean);
        if (!TextUtils.isEmpty(originImagePath)) {
            dataPath = originImagePath;
        }
        boolean z11 = true;
        if (TextUtils.isEmpty(dataPath)) {
            int i12 = 0;
            while (true) {
                if (i12 >= imageBeanList.size()) {
                    break;
                }
                ImageMessageBean.ImageBean imageBean = imageBeanList.get(i12);
                if (imageBean.getType() == 1) {
                    final String generateImagePath = ImageUtil.generateImagePath(imageBean.getUUID(), 1);
                    imageBean.downloadImage(generateImagePath, new ImageMessageBean.ImageBean.ImageDownloadCallback() {
                        public void onError(int i11, String str) {
                            TUIChatLog.e("MessageAdapter img getImage", i11 + ":" + str);
                        }

                        public void onProgress(long j11, long j12) {
                            TUIChatLog.i("downloadImage progress current:", j11 + ", total:" + j12);
                        }

                        public void onSuccess() {
                            viewHolder.loadingView.setVisibility(8);
                            imageMessageBean.setDataPath(generateImagePath);
                            ThreadUtils.runOnUiThread(new Runnable() {
                                public void run() {
                                    ImageVideoScanAdapter.this.notifyDataSetChanged();
                                }
                            });
                        }
                    });
                    break;
                }
                i12++;
            }
        }
        final V2TIMImageElem.V2TIMImage v2TIMImage = null;
        String str = null;
        for (int i13 = 0; i13 < imageBeanList.size(); i13++) {
            ImageMessageBean.ImageBean imageBean2 = imageBeanList.get(i13);
            if (imageBean2.getType() == 0) {
                v2TIMImage = imageBean2.getV2TIMImage();
            }
            if (imageBean2.getType() == 1) {
                str = ImageUtil.generateImagePath(imageBean2.getUUID(), 1);
            }
        }
        String originImagePath2 = TUIChatUtils.getOriginImagePath(imageMessageBean);
        if (originImagePath2 == null || v2TIMImage == null || TextUtils.isEmpty(originImagePath2) || ((long) v2TIMImage.getSize()) != FileUtil.getFileSize(originImagePath2)) {
            z11 = false;
        }
        if (z11) {
            str = originImagePath2;
        }
        if (FileUtil.getUriFromPath(str) != null) {
            viewHolder.loadingView.setVisibility(8);
        }
        viewHolder.photoView.setDisplayMatrix(new Matrix());
        viewHolder.photoView.setOnMatrixChangeListener(new MatrixChangeListener());
        viewHolder.photoView.setOnPhotoTapListener(new PhotoTapListener());
        viewHolder.photoView.setOnSingleFlingListener(new SingleFlingListener());
        loadImageIntoView(viewHolder.photoView, str);
        if (!z11) {
            viewHolder.viewOriginalButton.setOnClickListener(new View.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    V2TIMImageElem.V2TIMImage v2TIMImage = v2TIMImage;
                    if (v2TIMImage == null) {
                        TUIChatLog.e(ImageVideoScanAdapter.TAG, "finalMCurrentOriginalImage is null");
                        SensorsDataAutoTrackHelper.trackViewOnClick(view);
                        return;
                    }
                    final String generateImagePath = ImageUtil.generateImagePath(v2TIMImage.getUUID(), v2TIMImage.getType());
                    v2TIMImage.downloadImage(generateImagePath, new V2TIMDownloadCallback() {
                        public void onError(int i11, String str) {
                            ToastUtil.toastLongMessage("Download origin image failed , errCode = " + i11 + ", " + str);
                        }

                        public void onProgress(V2TIMElem.V2ProgressInfo v2ProgressInfo) {
                            long round = Math.round(((((double) v2ProgressInfo.getCurrentSize()) * 1.0d) * 100.0d) / ((double) v2ProgressInfo.getTotalSize()));
                            if (viewHolder.viewOriginalButton.getVisibility() != 4 && viewHolder.viewOriginalButton.getVisibility() != 8) {
                                TextView textView = viewHolder.viewOriginalButton;
                                textView.setText(round + "%");
                            }
                        }

                        public void onSuccess() {
                            ThreadUtils.runOnUiThread(new Runnable() {
                                public void run() {
                                    AnonymousClass1 r02 = AnonymousClass1.this;
                                    AnonymousClass3 r12 = AnonymousClass3.this;
                                    ImageVideoScanAdapter.this.loadImageIntoView(viewHolder.photoView, generateImagePath);
                                    AnonymousClass3 r03 = AnonymousClass3.this;
                                    viewHolder.viewOriginalButton.setText(ImageVideoScanAdapter.this.mContext.getString(R.string.completed));
                                    viewHolder.viewOriginalButton.setOnClickListener((View.OnClickListener) null);
                                    viewHolder.viewOriginalButton.setVisibility(4);
                                    Intent intent = new Intent();
                                    intent.setAction(ImageVideoScanAdapter.BROADCAST_DOWNLOAD_COMPLETED_ACTION);
                                    intent.putExtra(ImageVideoScanAdapter.DOWNLOAD_ORIGIN_IMAGE_PATH, generateImagePath);
                                    s1.a.b(ImageVideoScanAdapter.this.mContext).d(intent);
                                }
                            });
                        }
                    });
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            });
            if (!TextUtils.isEmpty(originImagePath2)) {
                ToastUtil.toastShortMessage(this.mContext.getString(R.string.downloading));
                this.downloadReceiver = new BroadcastReceiver() {
                    public void onReceive(Context context, Intent intent) {
                        String stringExtra;
                        PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
                        if (ImageVideoScanAdapter.BROADCAST_DOWNLOAD_COMPLETED_ACTION.equals(intent.getAction()) && (stringExtra = intent.getStringExtra(ImageVideoScanAdapter.DOWNLOAD_ORIGIN_IMAGE_PATH)) != null) {
                            ImageVideoScanAdapter.this.loadImageIntoView(viewHolder.photoView, stringExtra);
                        }
                    }
                };
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(BROADCAST_DOWNLOAD_COMPLETED_ACTION);
                s1.a.b(this.mContext).c(this.downloadReceiver, intentFilter);
                return;
            }
            viewHolder.viewOriginalButton.setVisibility(0);
            viewHolder.viewOriginalButton.setText(R.string.view_original_image);
            return;
        }
        viewHolder.viewOriginalButton.setVisibility(4);
    }

    private void loadVideoView(final ViewHolder viewHolder, final VideoMessageBean videoMessageBean, int i11) {
        if (TextUtils.isEmpty(videoMessageBean.getDataPath())) {
            final String str = TUIConfig.getImageDownloadDir() + videoMessageBean.getSnapshotUUID();
            videoMessageBean.downloadSnapshot(str, new VideoMessageBean.VideoDownloadCallback() {
                public void onError(int i11, String str) {
                    TUIChatLog.e("MessageAdapter video getImage", i11 + ":" + str);
                }

                public void onProgress(long j11, long j12) {
                    TUIChatLog.i("downloadSnapshot progress current:", j11 + ", total:" + j12);
                }

                public void onSuccess() {
                    viewHolder.pauseCenterView.setVisibility(0);
                    viewHolder.loadingView.setVisibility(8);
                    videoMessageBean.setDataPath(str);
                    String unused = ImageVideoScanAdapter.this.mCacheImagePath = str;
                    viewHolder.snapImageView.setVisibility(0);
                    ImageVideoScanAdapter.this.loadImageIntoView(viewHolder.snapImageView, str);
                    Bitmap bitmapFormPath = ImageUtil.getBitmapFormPath(str);
                    if (bitmapFormPath != null) {
                        ImageVideoScanAdapter.this.updateVideoView(viewHolder, bitmapFormPath.getWidth(), bitmapFormPath.getHeight());
                    }
                }
            });
        } else {
            String dataPath = videoMessageBean.getDataPath();
            viewHolder.snapImageView.setVisibility(0);
            loadImageIntoView(viewHolder.snapImageView, dataPath);
            updateVideoViewSize(viewHolder, dataPath);
        }
        if (videoMessageBean.getStatus() == 1) {
            ToastUtil.toastShortMessage(this.mContext.getString(R.string.sending));
        } else if (videoMessageBean.getStatus() == 3) {
            ToastUtil.toastShortMessage(this.mContext.getString(R.string.send_failed));
            viewHolder.loadingView.setVisibility(8);
        } else {
            String str2 = TUIConfig.getVideoDownloadDir() + videoMessageBean.getVideoUUID();
            File file = new File(str2);
            if (file.exists() && ((long) videoMessageBean.getVideoSize()) == file.length()) {
                playVideo(viewHolder, videoMessageBean);
            } else if (!viewHolder.downloadVideoFailed && !viewHolder.downloadVideoFinished) {
                getVideo(viewHolder, str2, videoMessageBean, true, i11);
            }
        }
    }

    private void performPhotoView(ViewHolder viewHolder, TUIMessageBean tUIMessageBean, int i11) {
        viewHolder.photoViewLayout.setVisibility(0);
        viewHolder.videoView.setVisibility(8);
        viewHolder.closeButton.setVisibility(8);
        viewHolder.playControlLayout.setVisibility(8);
        viewHolder.pauseCenterView.setVisibility(8);
        viewHolder.loadingView.setVisibility(0);
        viewHolder.videoViewLayout.setVisibility(8);
        if (tUIMessageBean instanceof ImageMessageBean) {
            loadPhotoView(viewHolder, (ImageMessageBean) tUIMessageBean, i11);
        } else {
            TUIChatLog.e(TAG, "is not ImageMessageBean");
        }
    }

    private void performVideoView(ViewHolder viewHolder, TUIMessageBean tUIMessageBean, int i11) {
        viewHolder.photoViewLayout.setVisibility(8);
        viewHolder.videoView.setVisibility(0);
        viewHolder.closeButton.setVisibility(0);
        viewHolder.playControlLayout.setVisibility(0);
        viewHolder.pauseCenterView.setVisibility(8);
        viewHolder.loadingView.setVisibility(0);
        viewHolder.videoViewLayout.setVisibility(0);
        if (tUIMessageBean instanceof VideoMessageBean) {
            this.mIsVideoPlay = false;
            playControlInit(viewHolder);
            loadVideoView(viewHolder, (VideoMessageBean) tUIMessageBean, i11);
            return;
        }
        TUIChatLog.e(TAG, "is not VideoMessageBean");
    }

    private void playControlInit(final ViewHolder viewHolder) {
        viewHolder.closeButton.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                UIKitVideoView uIKitVideoView = viewHolder.videoView;
                if (uIKitVideoView != null) {
                    uIKitVideoView.stop();
                } else {
                    TUIChatLog.e(ImageVideoScanAdapter.TAG, "videoView is null");
                }
                ImageVideoScanAdapter.this.onItemClickListener.onClickItem();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        viewHolder.playButton.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                ImageVideoScanAdapter.this.clickPlayVideo(viewHolder);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        viewHolder.playSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int i11, boolean z11) {
                viewHolder.timeBeginView.setText(DateTimeUtil.formatSecondsTo00(i11));
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                int progress = seekBar.getProgress();
                String access$300 = ImageVideoScanAdapter.TAG;
                TUIChatLog.i(access$300, "onStartTrackingTouch progress == " + progress);
                UIKitVideoView uIKitVideoView = viewHolder.videoView;
                if (uIKitVideoView != null) {
                    uIKitVideoView.seekTo(progress * 1000);
                }
            }

            @SensorsDataInstrumented
            public void onStopTrackingTouch(SeekBar seekBar) {
                int progress = seekBar.getProgress();
                String access$300 = ImageVideoScanAdapter.TAG;
                TUIChatLog.i(access$300, "onStopTrackingTouch progress == " + progress);
                UIKitVideoView uIKitVideoView = viewHolder.videoView;
                if (uIKitVideoView == null || !uIKitVideoView.isPlaying()) {
                    UIKitVideoView uIKitVideoView2 = viewHolder.videoView;
                    if (uIKitVideoView2 != null) {
                        uIKitVideoView2.seekTo(progress * 1000);
                    }
                } else {
                    viewHolder.videoView.seekTo(progress * 1000);
                    viewHolder.videoView.start();
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(seekBar);
            }
        });
        viewHolder.pauseCenterView.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                ImageVideoScanAdapter.this.clickPlayVideo(viewHolder);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public void playVideo(final ViewHolder viewHolder, final VideoMessageBean videoMessageBean) {
        Uri processVideoMessage = processVideoMessage(videoMessageBean);
        viewHolder.pauseCenterView.setVisibility(0);
        viewHolder.loadingView.setVisibility(8);
        if (processVideoMessage == null) {
            TUIChatLog.e(TAG, "playVideo videoUri == null");
            return;
        }
        viewHolder.videoView.setVideoURI(processVideoMessage);
        viewHolder.videoView.setOnPreparedListener(new IPlayer.OnPreparedListener() {
            public void onPrepared(IPlayer iPlayer) {
                TUIChatLog.e(ImageVideoScanAdapter.TAG, "onPrepared()");
                viewHolder.videoView.start();
                viewHolder.videoView.pause();
                viewHolder.playButton.setImageResource(R.drawable.ic_play_icon);
                viewHolder.pauseCenterView.setVisibility(0);
                viewHolder.loadingView.setVisibility(8);
                ImageVideoScanAdapter.this.updateVideoViewSize(viewHolder, videoMessageBean.getDataPath());
                boolean unused = ImageVideoScanAdapter.this.mIsVideoPlay = false;
                if (ImageVideoScanAdapter.this.durationHandler != null) {
                    Handler unused2 = ImageVideoScanAdapter.this.durationHandler = null;
                }
                if (ImageVideoScanAdapter.this.updateSeekBarTime != null) {
                    Runnable unused3 = ImageVideoScanAdapter.this.updateSeekBarTime = null;
                }
                Handler unused4 = ImageVideoScanAdapter.this.durationHandler = new Handler();
                Runnable unused5 = ImageVideoScanAdapter.this.updateSeekBarTime = new Runnable() {
                    public void run() {
                        int currentPosition = viewHolder.videoView.getCurrentPosition();
                        if (viewHolder.playSeekBar.getProgress() >= viewHolder.playSeekBar.getMax()) {
                            TUIChatLog.e(ImageVideoScanAdapter.TAG, "getProgress() >= getMax()");
                            AnonymousClass10 r02 = AnonymousClass10.this;
                            ImageVideoScanAdapter.this.resetVideo(viewHolder);
                            return;
                        }
                        viewHolder.playSeekBar.setProgress(Math.round((((float) currentPosition) * 1.0f) / 1000.0f));
                        viewHolder.timeBeginView.setText(DateTimeUtil.formatSecondsTo00(Math.round((((float) viewHolder.videoView.getCurrentPosition()) * 1.0f) / 1000.0f)));
                        if (ImageVideoScanAdapter.this.mIsVideoPlay) {
                            ImageVideoScanAdapter.this.durationHandler.postDelayed(this, 100);
                        }
                    }
                };
                int round = Math.round((((float) iPlayer.getDuration()) * 1.0f) / 1000.0f);
                int round2 = Math.round((((float) iPlayer.getCurrentPosition()) * 1.0f) / 1000.0f);
                viewHolder.playSeekBar.setMax(round);
                viewHolder.playSeekBar.setProgress(round2);
                viewHolder.timeEndView.setText(DateTimeUtil.formatSecondsTo00(round));
                ImageVideoScanAdapter.this.durationHandler.postDelayed(ImageVideoScanAdapter.this.updateSeekBarTime, 100);
            }
        });
        viewHolder.videoView.setOnSeekCompleteListener(new IPlayer.OnSeekCompleteListener() {
            public void OnSeekComplete(IPlayer iPlayer) {
            }
        });
    }

    private Uri processVideoMessage(VideoMessageBean videoMessageBean) {
        V2TIMMessage v2TIMMessage = videoMessageBean.getV2TIMMessage();
        V2TIMVideoElem videoElem = v2TIMMessage.getVideoElem();
        if (v2TIMMessage.isSelf() && !TextUtils.isEmpty(videoElem.getSnapshotPath())) {
            return FileUtil.getUriFromPath(videoElem.getVideoPath());
        }
        return Uri.parse(TUIConfig.getVideoDownloadDir() + videoElem.getVideoUUID());
    }

    /* access modifiers changed from: private */
    public void updateVideoView(ViewHolder viewHolder, int i11, int i12) {
        int i13;
        int i14;
        String str = TAG;
        TUIChatLog.i(str, "updateVideoView videoWidth: " + i11 + " videoHeight: " + i12);
        if (i11 > 0 || i12 > 0) {
            if (this.mContext.getResources().getConfiguration().orientation != 1) {
                i14 = Math.max(ScreenUtil.getScreenWidth(this.mContext), ScreenUtil.getScreenHeight(this.mContext));
                i13 = Math.min(ScreenUtil.getScreenWidth(this.mContext), ScreenUtil.getScreenHeight(this.mContext));
            } else {
                i14 = Math.min(ScreenUtil.getScreenWidth(this.mContext), ScreenUtil.getScreenHeight(this.mContext));
                i13 = Math.max(ScreenUtil.getScreenWidth(this.mContext), ScreenUtil.getScreenHeight(this.mContext));
            }
            int[] scaledSize = ScreenUtil.scaledSize(i14, i13, i11, i12);
            TUIChatLog.i(str, "scaled width: " + scaledSize[0] + " height: " + scaledSize[1]);
            ViewGroup.LayoutParams layoutParams = viewHolder.videoView.getLayoutParams();
            layoutParams.width = scaledSize[0];
            layoutParams.height = scaledSize[1];
            viewHolder.videoView.setLayoutParams(layoutParams);
            if (viewHolder.snapImageView.getVisibility() == 0) {
                viewHolder.snapImageView.setLayoutParams(layoutParams);
            }
        }
    }

    /* access modifiers changed from: private */
    public void updateVideoViewSize(ViewHolder viewHolder, String str) {
        Bitmap bitmapFormPath;
        String str2 = this.mCacheImagePath;
        if ((str2 == null || !str2.equals(str)) && (bitmapFormPath = ImageUtil.getBitmapFormPath(str)) != null) {
            updateVideoView(viewHolder, bitmapFormPath.getWidth(), bitmapFormPath.getHeight());
        }
    }

    public int addDataToSource(List<TUIMessageBean> list, int i11, int i12) {
        if (list != null && !list.isEmpty()) {
            List<TUIMessageBean> list2 = this.mDataSource;
            if (list2 == null) {
                TUIChatLog.e(TAG, "addDataToSource mDataSource is null");
                return i12;
            }
            TUIMessageBean tUIMessageBean = list2.get(i12);
            if (i11 == 0) {
                this.mOldLocateMessage = list.get(0);
                String str = TAG;
                Log.d(str, "mOldLocateMessage seq:" + this.mOldLocateMessage.getV2TIMMessage().getSeq());
                this.mDataSource.addAll(0, list);
                i12 = list.size();
            } else if (i11 == 1) {
                this.mNewLocateMessage = list.get(list.size() - 1);
                String str2 = TAG;
                Log.d(str2, "mNewLocateMessage seq:" + this.mNewLocateMessage.getV2TIMMessage().getSeq());
                this.mDataSource.addAll(list);
            } else {
                TUIChatLog.e(TAG, "addDataToSource error type");
            }
            for (TUIMessageBean v2TIMMessage : this.mDataSource) {
                String str3 = TAG;
                TUIChatLog.d(str3, "message seq = " + v2TIMMessage.getV2TIMMessage().getSeq());
            }
            if (tUIMessageBean == null) {
                TUIChatLog.e(TAG, "messageBean == null");
            }
        }
        return i12;
    }

    public void destroyView(RecyclerView recyclerView, int i11) {
        View childAt = recyclerView.getChildAt(i11);
        if (childAt != null) {
            UIKitVideoView uIKitVideoView = (UIKitVideoView) childAt.findViewById(R.id.video_play_view);
            SeekBar seekBar = (SeekBar) childAt.findViewById(R.id.play_seek);
            if (uIKitVideoView != null) {
                uIKitVideoView.stop();
            }
            if (seekBar != null) {
                seekBar.setProgress(0);
            }
        }
        if (this.downloadReceiver != null) {
            s1.a.b(this.mContext).e(this.downloadReceiver);
            this.downloadReceiver = null;
        }
    }

    public List<TUIMessageBean> getDataSource() {
        return this.mDataSource;
    }

    public int getItemCount() {
        return this.mDataSource.size();
    }

    public TUIMessageBean getNewLocateMessage() {
        return this.mNewLocateMessage;
    }

    public TUIMessageBean getOldLocateMessage() {
        return this.mOldLocateMessage;
    }

    public void onDataChanged(TUIMessageBean tUIMessageBean) {
        Iterator<TUIMessageBean> it2 = this.mDataSource.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            TUIMessageBean next = it2.next();
            if (TextUtils.equals(tUIMessageBean.getId(), next.getId())) {
                next.update(tUIMessageBean);
                break;
            }
        }
        notifyDataSetChanged();
    }

    public void resetVideo(ViewHolder viewHolder) {
        viewHolder.videoView.stop();
        viewHolder.videoView.resetVideo();
        viewHolder.playButton.setImageResource(R.drawable.ic_play_icon);
        viewHolder.pauseCenterView.setVisibility(0);
        viewHolder.snapImageView.setVisibility(8);
        viewHolder.loadingView.setVisibility(8);
        viewHolder.playSeekBar.setProgress(0);
        this.mIsVideoPlay = false;
        viewHolder.timeBeginView.setText(DateTimeUtil.formatSecondsTo00(0));
    }

    public void setDataSource(List<TUIMessageBean> list) {
        if (list == null || list.isEmpty()) {
            TUIChatLog.d(TAG, "setDataSource dataSource is Empty");
            this.mOldLocateMessage = null;
            this.mNewLocateMessage = null;
        } else {
            this.mOldLocateMessage = list.get(0);
            this.mNewLocateMessage = list.get(list.size() - 1);
        }
        this.mDataSource = list;
        for (TUIMessageBean v2TIMMessage : list) {
            String str = TAG;
            TUIChatLog.d(str, "message seq = " + v2TIMMessage.getV2TIMMessage().getSeq());
        }
        String str2 = TAG;
        Log.d(str2, "mOldLocateMessage seq:" + this.mOldLocateMessage.getV2TIMMessage().getSeq());
        Log.d(str2, "mNewLocateMessage seq:" + this.mNewLocateMessage.getV2TIMMessage().getSeq());
    }

    public void setOnItemClickListener(ImageVideoScanActivity.OnItemClickListener onItemClickListener2) {
        this.onItemClickListener = onItemClickListener2;
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i11) {
        TUIMessageBean item = getItem(i11);
        if (item != null) {
            viewHolder.playSeekBar.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    return false;
                }
            });
            V2TIMMessage v2TIMMessage = item.getV2TIMMessage();
            if (v2TIMMessage.getElemType() == 3) {
                performPhotoView(viewHolder, item, i11);
            } else if (v2TIMMessage.getElemType() == 5) {
                performVideoView(viewHolder, item, i11);
            } else {
                TUIChatLog.d(TAG, "error message type");
            }
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.image_video_scan_item, viewGroup, false));
    }
}
