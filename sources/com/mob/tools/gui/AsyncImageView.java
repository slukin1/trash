package com.mob.tools.gui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.huawei.hms.utils.FileUtil;
import com.huobi.view.roundimg.RoundedDrawable;
import com.mob.tools.MobLog;
import com.mob.tools.gui.BitmapProcessor;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.UIHandler;
import java.lang.ref.WeakReference;
import java.security.SecureRandom;

public class AsyncImageView extends ImageView implements Handler.Callback, BitmapProcessor.BitmapCallback {
    private static final int MSG_IMG_GOT = 1;
    private static final SecureRandom RND = new SecureRandom();
    private Bitmap defaultBm;
    private int defaultRes;
    private int desiredHeight = 0;
    private int desiredWidth = 0;
    private long diskCacheTime = 0;
    private Bitmap errorBm = null;
    private int errorRes = 0;
    private boolean lastReqIsOk;
    private long maxBytes = 0;
    private Path path;
    private int quality = 0;
    private float[] rect;
    private WeakReference<AsyncImageView> refAiv = null;
    private Bitmap result;
    private boolean scaleToCrop;
    private String url;
    private boolean useDiskCache = true;
    private boolean useRamCache = true;

    public AsyncImageView(Context context) {
        super(context);
        init(context);
    }

    private BitmapProcessor.BitmapDesiredOptions getBitmapDesiredOptions() {
        if ((this.desiredWidth <= 1 || this.desiredHeight <= 1) && this.maxBytes < FileUtil.LOCAL_REPORT_FILE_MAX_SIZE && this.quality <= 0) {
            return null;
        }
        BitmapProcessor.BitmapDesiredOptions bitmapDesiredOptions = new BitmapProcessor.BitmapDesiredOptions();
        bitmapDesiredOptions.desiredWidth = this.desiredWidth;
        bitmapDesiredOptions.desiredHeight = this.desiredHeight;
        bitmapDesiredOptions.maxBytes = this.maxBytes;
        bitmapDesiredOptions.quality = this.quality;
        return bitmapDesiredOptions;
    }

    private int[] getSize() {
        ViewGroup.LayoutParams layoutParams;
        int width = getWidth();
        int height = getHeight();
        if ((width == 0 || height == 0) && (layoutParams = getLayoutParams()) != null) {
            width = layoutParams.width;
            height = layoutParams.height;
        }
        if (width == 0 || height == 0) {
            measure(0, 0);
            width = getMeasuredWidth();
            height = getMeasuredHeight();
        }
        return new int[]{width, height};
    }

    private Bitmap goCrop(Bitmap bitmap) {
        float width = (float) bitmap.getWidth();
        float height = (float) bitmap.getHeight();
        if (width == 0.0f || height == 0.0f) {
            return bitmap;
        }
        int[] size = getSize();
        if (size[0] == 0 || size[1] == 0) {
            return bitmap;
        }
        float f11 = (((float) size[1]) * width) / ((float) size[0]);
        if (f11 == height) {
            return bitmap;
        }
        int[] iArr = new int[4];
        if (f11 < height) {
            iArr[1] = (int) ((height - f11) / 2.0f);
            iArr[3] = iArr[1];
        } else {
            iArr[0] = (int) ((width - ((((float) size[0]) * height) / ((float) size[1]))) / 2.0f);
            iArr[2] = iArr[0];
        }
        try {
            return BitmapHelper.cropBitmap(bitmap, iArr[0], iArr[1], iArr[2], iArr[3]);
        } catch (Throwable th2) {
            MobLog.getInstance().w(th2);
            return bitmap;
        }
    }

    private void init(Context context) {
        if (isInEditMode()) {
            setBackgroundColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
        } else {
            BitmapProcessor.prepare(context);
        }
    }

    private void myClip(Canvas canvas) {
        if (this.rect != null) {
            if (this.path == null) {
                int width = getWidth();
                int height = getHeight();
                this.path = new Path();
                this.path.addRoundRect(new RectF(0.0f, 0.0f, (float) width, (float) height), this.rect, Path.Direction.CW);
            }
            canvas.clipPath(this.path);
        }
    }

    public void deleteCachedFile(String str) {
        BitmapProcessor.deleteCachedFile(str, getBitmapDesiredOptions());
    }

    public void execute(String str, int i11) {
        execute(str, i11, 0);
    }

    public boolean handleMessage(Message message) {
        WeakReference<AsyncImageView> weakReference;
        if (!(message.what != 1 || (weakReference = this.refAiv) == null || weakReference.get() == null)) {
            try {
                Object obj = message.obj;
                Object obj2 = ((Object[]) obj)[0];
                Object obj3 = ((Object[]) obj)[1];
                if (obj3 != null && obj2 != null && obj2.equals(this.url)) {
                    this.result = (Bitmap) obj3;
                    ((AsyncImageView) this.refAiv.get()).setImageBitmap(this.result);
                    this.lastReqIsOk = true;
                } else if (this.errorRes > 0) {
                    ((AsyncImageView) this.refAiv.get()).setImageResource(this.errorRes);
                } else {
                    Bitmap bitmap = this.errorBm;
                    if (bitmap == null || bitmap.isRecycled()) {
                        Bitmap bitmap2 = this.defaultBm;
                        if (bitmap2 == null || bitmap2.isRecycled()) {
                            ((AsyncImageView) this.refAiv.get()).setImageResource(this.defaultRes);
                        } else {
                            ((AsyncImageView) this.refAiv.get()).setImageBitmap(this.defaultBm);
                        }
                    } else {
                        ((AsyncImageView) this.refAiv.get()).setImageBitmap(this.errorBm);
                    }
                }
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
            }
        }
        return false;
    }

    public void onDraw(Canvas canvas) {
        if (getDrawable() != null && getDrawable().getIntrinsicWidth() != 0 && getDrawable().getIntrinsicHeight() != 0) {
            Matrix imageMatrix = getImageMatrix();
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int saveCount = canvas.getSaveCount();
            canvas.save();
            if (this.result != null) {
                myClip(canvas);
                canvas.drawBitmap(this.result, imageMatrix, new Paint(6));
            } else {
                if (!(imageMatrix == null && paddingLeft == 0 && paddingTop == 0)) {
                    if (Build.VERSION.SDK_INT >= 16 && getCropToPadding()) {
                        int scrollX = getScrollX();
                        int scrollY = getScrollY();
                        canvas.clipRect(scrollX + paddingLeft, scrollY + paddingTop, ((scrollX + getRight()) - getLeft()) - getPaddingRight(), ((scrollY + getBottom()) - getTop()) - getPaddingBottom());
                    }
                    canvas.translate((float) paddingLeft, (float) paddingTop);
                    if (imageMatrix != null) {
                        canvas.concat(imageMatrix);
                    }
                }
                getDrawable().draw(canvas);
            }
            canvas.restoreToCount(saveCount);
        }
    }

    public void onImageGot(String str, Bitmap bitmap) {
        WeakReference<AsyncImageView> weakReference = this.refAiv;
        if (weakReference != null && weakReference.get() != null) {
            if (str == null || str.trim().length() <= 0 || !str.equals(this.url)) {
                bitmap = null;
            }
            if (bitmap != null && this.scaleToCrop) {
                bitmap = goCrop(bitmap);
            }
            Message message = new Message();
            message.what = 1;
            message.obj = new Object[]{str, bitmap};
            UIHandler.sendMessageDelayed(message, (long) RND.nextInt(300), this);
        }
    }

    public void removeRamCache(String str) {
        if (this.useRamCache) {
            BitmapProcessor.removeBitmapFromRamCache(str, getBitmapDesiredOptions());
        }
    }

    public void setBitmap(Bitmap bitmap) {
        if (this.scaleToCrop) {
            bitmap = goCrop(bitmap);
        }
        setImageBitmap(bitmap);
        this.result = bitmap;
    }

    public void setCompressOptions(int i11, int i12, int i13, long j11) {
        this.desiredWidth = i11;
        this.desiredHeight = i12;
        this.quality = i13;
        this.maxBytes = j11;
    }

    public void setPadding(int i11, int i12, int i13, int i14) {
        MobLog.getInstance().w((Throwable) new RuntimeException("Not Support"));
    }

    public void setRound(float f11) {
        setRound(f11, f11, f11, f11);
    }

    public void setScaleToCropCenter(boolean z11) {
        this.scaleToCrop = z11;
    }

    public void setUseCacheOption(boolean z11, boolean z12) {
        setUseCacheOption(z11, z12, 0);
    }

    public void execute(String str, int i11, int i12) {
        Bitmap bitmapFromCache;
        if ((!this.useRamCache && !this.useDiskCache) || !this.lastReqIsOk || TextUtils.isEmpty(str) || !str.equals(this.url)) {
            this.lastReqIsOk = false;
            this.url = str;
            this.result = null;
            this.defaultRes = i11;
            this.errorRes = i12;
            if (TextUtils.isEmpty(str)) {
                if (i12 != 0) {
                    i11 = i12;
                }
                setImageResource(i11);
                return;
            }
            BitmapProcessor.BitmapDesiredOptions bitmapDesiredOptions = getBitmapDesiredOptions();
            if (!this.useRamCache || (bitmapFromCache = BitmapProcessor.getBitmapFromCache(str, bitmapDesiredOptions)) == null || bitmapFromCache.isRecycled()) {
                if (i11 > 0) {
                    setImageResource(i11);
                }
                WeakReference<AsyncImageView> weakReference = this.refAiv;
                if (weakReference == null || weakReference.get() == null) {
                    this.refAiv = new WeakReference<>(this);
                }
                BitmapProcessor.process(str, bitmapDesiredOptions, this.useRamCache, this.useDiskCache, this.diskCacheTime, this);
                return;
            }
            setBitmap(bitmapFromCache);
            this.lastReqIsOk = true;
        }
    }

    public void setRound(float f11, float f12, float f13, float f14) {
        this.rect = new float[]{f11, f11, f12, f12, f13, f13, f14, f14};
    }

    public void setUseCacheOption(boolean z11, boolean z12, long j11) {
        this.useRamCache = z11;
        this.useDiskCache = z12;
        if (z12) {
            this.diskCacheTime = j11;
        }
    }

    public AsyncImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public void execute(String str, Bitmap bitmap) {
        execute(str, bitmap, (Bitmap) null);
    }

    public void execute(String str, Bitmap bitmap, Bitmap bitmap2) {
        Bitmap bitmapFromCache;
        if ((!this.useRamCache && !this.useDiskCache) || !this.lastReqIsOk || TextUtils.isEmpty(str) || !str.equals(this.url)) {
            this.lastReqIsOk = false;
            this.url = str;
            this.result = null;
            this.defaultBm = bitmap;
            this.errorBm = bitmap2;
            if (TextUtils.isEmpty(str)) {
                if (bitmap2 != null) {
                    bitmap = bitmap2;
                }
                setImageBitmap(bitmap);
                return;
            }
            BitmapProcessor.BitmapDesiredOptions bitmapDesiredOptions = getBitmapDesiredOptions();
            if (!this.useRamCache || (bitmapFromCache = BitmapProcessor.getBitmapFromCache(str, bitmapDesiredOptions)) == null || bitmapFromCache.isRecycled()) {
                if (bitmap != null && !bitmap.isRecycled()) {
                    setImageBitmap(bitmap);
                }
                WeakReference<AsyncImageView> weakReference = this.refAiv;
                if (weakReference == null || weakReference.get() == null) {
                    this.refAiv = new WeakReference<>(this);
                }
                BitmapProcessor.process(str, bitmapDesiredOptions, this.useRamCache, this.useDiskCache, this.diskCacheTime, this);
                return;
            }
            setBitmap(bitmapFromCache);
            this.lastReqIsOk = true;
        }
    }

    public AsyncImageView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(context);
    }
}
