package com.tencent.ugc;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.f;
import com.tencent.ugc.TXVideoEditConstants;
import com.tencent.ugc.common.MediaExtractorBuilder;
import com.tencent.ugc.common.MediaRetrieverBuilder;
import com.tencent.ugc.retriver.FFmpegMediaRetriever;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicInteger;

public class TXVideoInfoReader {
    private static final int RETRY_MAX_COUNT = 3;
    private static TXVideoInfoReader sInstance;
    private final String TAG;
    private Context mContext;
    /* access modifiers changed from: private */
    public int mCount;
    private a mGenerateImageThread;
    /* access modifiers changed from: private */
    public volatile WeakReference<OnSampleProgrocess> mListener;
    /* access modifiers changed from: private */
    public final Handler mMainHandler;
    /* access modifiers changed from: private */
    public final AtomicInteger mRetryTimes;

    public interface OnSampleProgrocess {
        void sampleProcess(int i11, Bitmap bitmap);
    }

    public class a extends Thread {

        /* renamed from: b  reason: collision with root package name */
        private final String f50081b;

        /* renamed from: c  reason: collision with root package name */
        private volatile Bitmap f50082c;

        /* renamed from: d  reason: collision with root package name */
        private final int f50083d;

        public a(String str) {
            this.f50083d = TXVideoInfoReader.this.mListener.hashCode();
            this.f50081b = str;
        }

        public final void run() {
            OnSampleProgrocess onSampleProgrocess;
            MediaMetadataRetriever build = new MediaRetrieverBuilder().setPath(this.f50081b).build();
            long videoDurationMs = new FFmpegMediaRetriever().getVideoDurationMs() * 1000;
            long access$100 = videoDurationMs / ((long) TXVideoInfoReader.this.mCount);
            LiteavLog.i("TXVideoInfoReader", "run duration = " + videoDurationMs + " count = " + TXVideoInfoReader.this.mCount);
            int i11 = 0;
            while (true) {
                Bitmap bitmap = null;
                if (i11 >= TXVideoInfoReader.this.mCount || Thread.currentThread().isInterrupted()) {
                    break;
                }
                long j11 = ((long) i11) * access$100;
                if (j11 > videoDurationMs) {
                    j11 = videoDurationMs;
                }
                Bitmap frameAtTime = build.getFrameAtTime(j11);
                if (frameAtTime == null) {
                    LiteavLog.w("TXVideoInfoReader", "getSampleImages failed!");
                    if (i11 == 0) {
                        String str = this.f50081b;
                        if (TXVideoInfoReader.this.mRetryTimes.get() < 3) {
                            LiteavLog.i("TXVideoInfoReader", "retry to get sample images");
                            TXVideoInfoReader.this.mMainHandler.post(new ch(this, str));
                        }
                    } else {
                        if (this.f50082c != null && !this.f50082c.isRecycled()) {
                            LiteavLog.i("TXVideoInfoReader", "copy last image");
                            bitmap = this.f50082c.copy(this.f50082c.getConfig(), true);
                        }
                        frameAtTime = bitmap;
                    }
                }
                this.f50082c = frameAtTime;
                TXVideoInfoReader.this.mRetryTimes.set(0);
                if (TXVideoInfoReader.this.mListener != null && TXVideoInfoReader.this.mCount > 0 && TXVideoInfoReader.this.mListener.hashCode() == this.f50083d && (onSampleProgrocess = (OnSampleProgrocess) TXVideoInfoReader.this.mListener.get()) != null) {
                    TXVideoInfoReader.this.mMainHandler.post(new cg(onSampleProgrocess, i11, frameAtTime));
                }
                i11++;
            }
            this.f50082c = null;
            build.release();
        }

        public static /* synthetic */ void a(a aVar, String str) {
            TXVideoInfoReader tXVideoInfoReader = TXVideoInfoReader.this;
            tXVideoInfoReader.getSampleImages(tXVideoInfoReader.mCount, str, (OnSampleProgrocess) TXVideoInfoReader.this.mListener.get());
            TXVideoInfoReader.this.mRetryTimes.getAndIncrement();
        }
    }

    private TXVideoInfoReader(Context context) {
        this.TAG = "TXVideoInfoReader";
        this.mContext = context.getApplicationContext();
        this.mRetryTimes = new AtomicInteger(0);
        this.mMainHandler = new Handler(Looper.getMainLooper());
    }

    private void cancelThread() {
        a aVar = this.mGenerateImageThread;
        if (aVar != null && aVar.isAlive() && !this.mGenerateImageThread.isInterrupted()) {
            LiteavLog.i("TXVideoInfoReader", "cancelThread: thread cancel");
            this.mGenerateImageThread.interrupt();
            this.mGenerateImageThread = null;
        }
    }

    private long getContentUrlFileSize(String str) {
        FileInputStream fileInputStream;
        Uri parse = Uri.parse(str);
        ParcelFileDescriptor parcelFileDescriptor = null;
        try {
            Context context = this.mContext;
            if (context != null) {
                ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(parse, "r");
                try {
                    fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
                    try {
                        long available = (long) fileInputStream.available();
                        f.a((Closeable) openFileDescriptor);
                        f.a((Closeable) fileInputStream);
                        return available;
                    } catch (Exception unused) {
                        parcelFileDescriptor = openFileDescriptor;
                        try {
                            LiteavLog.e("TXVideoInfoReader", "getVideoFileInfo  not found , uri = ".concat(String.valueOf(parse)));
                            f.a((Closeable) parcelFileDescriptor);
                            f.a((Closeable) fileInputStream);
                            return 0;
                        } catch (Throwable th2) {
                            th = th2;
                            f.a((Closeable) parcelFileDescriptor);
                            f.a((Closeable) fileInputStream);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        parcelFileDescriptor = openFileDescriptor;
                        f.a((Closeable) parcelFileDescriptor);
                        f.a((Closeable) fileInputStream);
                        throw th;
                    }
                } catch (Exception unused2) {
                    fileInputStream = null;
                    parcelFileDescriptor = openFileDescriptor;
                    LiteavLog.e("TXVideoInfoReader", "getVideoFileInfo  not found , uri = ".concat(String.valueOf(parse)));
                    f.a((Closeable) parcelFileDescriptor);
                    f.a((Closeable) fileInputStream);
                    return 0;
                } catch (Throwable th4) {
                    th = th4;
                    fileInputStream = null;
                    parcelFileDescriptor = openFileDescriptor;
                    f.a((Closeable) parcelFileDescriptor);
                    f.a((Closeable) fileInputStream);
                    throw th;
                }
            } else {
                f.a((Closeable) null);
                f.a((Closeable) null);
                return 0;
            }
        } catch (Exception unused3) {
            fileInputStream = null;
            LiteavLog.e("TXVideoInfoReader", "getVideoFileInfo  not found , uri = ".concat(String.valueOf(parse)));
            f.a((Closeable) parcelFileDescriptor);
            f.a((Closeable) fileInputStream);
            return 0;
        } catch (Throwable th5) {
            th = th5;
            fileInputStream = null;
            f.a((Closeable) parcelFileDescriptor);
            f.a((Closeable) fileInputStream);
            throw th;
        }
    }

    @Deprecated
    public static TXVideoInfoReader getInstance() {
        if (sInstance == null) {
            sInstance = new TXVideoInfoReader();
        }
        return sInstance;
    }

    public void cancel() {
        LiteavLog.i("TXVideoInfoReader", "cancel");
        cancelThread();
        this.mMainHandler.removeCallbacksAndMessages((Object) null);
        if (this.mListener != null) {
            this.mListener.clear();
            this.mListener = null;
        }
    }

    public Bitmap getSampleImage(long j11, String str) {
        if (TextUtils.isEmpty(str)) {
            LiteavLog.w("TXVideoInfoReader", "videoPath is null");
            return null;
        } else if (!new File(str).exists()) {
            LiteavLog.w("TXVideoInfoReader", "videoPath is not exist");
            return null;
        } else {
            FFmpegMediaRetriever fFmpegMediaRetriever = new FFmpegMediaRetriever();
            fFmpegMediaRetriever.setDataSource(str);
            long videoDurationMs = fFmpegMediaRetriever.getVideoDurationMs() * 1000;
            long j12 = j11 * 1000;
            if (j12 > videoDurationMs) {
                j12 = videoDurationMs;
            }
            if (videoDurationMs <= 0) {
                LiteavLog.w("TXVideoInfoReader", "video duration is 0");
                return null;
            }
            Bitmap frameAtTime = new MediaRetrieverBuilder().setPath(str).build().getFrameAtTime(j12);
            if (frameAtTime == null) {
                LiteavLog.e("TXVideoInfoReader", "getSampleImages failed!");
                return frameAtTime;
            }
            LiteavLog.i("TXVideoInfoReader", "getSampleImages bmp= " + frameAtTime + ",time= " + j12 + ",duration= " + videoDurationMs);
            return frameAtTime;
        }
    }

    public void getSampleImages(int i11, String str, OnSampleProgrocess onSampleProgrocess) {
        this.mCount = i11;
        this.mListener = new WeakReference<>(onSampleProgrocess);
        if (TextUtils.isEmpty(str)) {
            LiteavLog.w("TXVideoInfoReader", "getSampleImages: videoPath is empty.");
        } else if (!f.a(str)) {
            LiteavLog.w("TXVideoInfoReader", "getSampleImages: file is not exist.");
        } else {
            cancelThread();
            a aVar = new a(str);
            this.mGenerateImageThread = aVar;
            aVar.start();
            LiteavLog.i("TXVideoInfoReader", "getSampleImages: thread start");
        }
    }

    public TXVideoEditConstants.TXVideoInfo getVideoFileInfo(String str) {
        LiteavLog.i("TXVideoInfoReader", "videoSource:".concat(String.valueOf(str)));
        if (LiteavSystemInfo.getSystemOSVersionInt() < 18) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            LiteavLog.e("TXVideoInfoReader", "videoSource is empty!!");
            return null;
        }
        if (!MediaExtractorBuilder.isContentUri(str)) {
            File file = new File(str);
            if (!file.exists() || !file.canRead()) {
                LiteavLog.e("TXVideoInfoReader", "getVideoFileInfo  file exist = " + file.exists() + " can read = " + file.canRead());
                return null;
            }
        }
        TXVideoEditConstants.TXVideoInfo tXVideoInfo = new TXVideoEditConstants.TXVideoInfo();
        FFmpegMediaRetriever fFmpegMediaRetriever = new FFmpegMediaRetriever();
        fFmpegMediaRetriever.setDataSource(str);
        tXVideoInfo.duration = fFmpegMediaRetriever.getVideoDurationMs();
        LiteavLog.i("TXVideoInfoReader", "getVideoFileInfo: duration = " + tXVideoInfo.duration);
        tXVideoInfo.coverImage = new MediaRetrieverBuilder().setPath(str).build().getFrameAtTime();
        tXVideoInfo.fps = fFmpegMediaRetriever.getFPS();
        tXVideoInfo.bitrate = (int) (fFmpegMediaRetriever.getVideoBitrate() / 1024);
        tXVideoInfo.audioSampleRate = fFmpegMediaRetriever.getSampleRate();
        int rotation = fFmpegMediaRetriever.getRotation();
        LiteavLog.i("TXVideoInfoReader", "rotation: ".concat(String.valueOf(rotation)));
        if (rotation == 90 || rotation == 270) {
            tXVideoInfo.width = fFmpegMediaRetriever.getVideoHeight();
            tXVideoInfo.height = fFmpegMediaRetriever.getVideoWidth();
        } else {
            tXVideoInfo.width = fFmpegMediaRetriever.getVideoWidth();
            tXVideoInfo.height = fFmpegMediaRetriever.getVideoHeight();
        }
        if (MediaExtractorBuilder.isContentUri(str)) {
            tXVideoInfo.fileSize = getContentUrlFileSize(str);
        } else {
            tXVideoInfo.fileSize = new File(str).length();
        }
        return tXVideoInfo;
    }

    public static TXVideoInfoReader getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new TXVideoInfoReader(context);
        }
        return sInstance;
    }

    private TXVideoInfoReader() {
        this.TAG = "TXVideoInfoReader";
        this.mRetryTimes = new AtomicInteger(0);
        this.mMainHandler = new Handler(Looper.getMainLooper());
    }
}
