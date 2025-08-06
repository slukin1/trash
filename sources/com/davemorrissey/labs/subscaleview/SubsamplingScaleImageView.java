package com.davemorrissey.labs.subscaleview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.davemorrissey.labs.subscaleview.decoder.CompatDecoderFactory;
import com.davemorrissey.labs.subscaleview.decoder.DecoderFactory;
import com.davemorrissey.labs.subscaleview.decoder.ImageDecoder;
import com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder;
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageDecoder;
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageRegionDecoder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SubsamplingScaleImageView extends View {
    public static final int EASE_IN_OUT_QUAD = 2;
    public static final int EASE_OUT_QUAD = 1;
    private static final int MESSAGE_LONG_CLICK = 1;
    public static final int ORIENTATION_0 = 0;
    public static final int ORIENTATION_180 = 180;
    public static final int ORIENTATION_270 = 270;
    public static final int ORIENTATION_90 = 90;
    public static final int ORIENTATION_USE_EXIF = -1;
    public static final int ORIGIN_ANIM = 1;
    public static final int ORIGIN_DOUBLE_TAP_ZOOM = 4;
    public static final int ORIGIN_FLING = 3;
    public static final int ORIGIN_TOUCH = 2;
    public static final int PAN_LIMIT_CENTER = 3;
    public static final int PAN_LIMIT_INSIDE = 1;
    public static final int PAN_LIMIT_OUTSIDE = 2;
    public static final int SCALE_TYPE_CENTER_CROP = 2;
    public static final int SCALE_TYPE_CENTER_INSIDE = 1;
    public static final int SCALE_TYPE_CUSTOM = 3;
    public static final int SCALE_TYPE_START = 4;
    /* access modifiers changed from: private */
    public static final String TAG = SubsamplingScaleImageView.class.getSimpleName();
    public static final int TILE_SIZE_AUTO = Integer.MAX_VALUE;
    /* access modifiers changed from: private */
    public static final List<Integer> VALID_EASING_STYLES = Arrays.asList(new Integer[]{2, 1});
    private static final List<Integer> VALID_ORIENTATIONS = Arrays.asList(new Integer[]{0, 90, 180, 270, -1});
    private static final List<Integer> VALID_PAN_LIMITS = Arrays.asList(new Integer[]{1, 2, 3});
    private static final List<Integer> VALID_SCALE_TYPES = Arrays.asList(new Integer[]{2, 1, 3, 4});
    private static final List<Integer> VALID_ZOOM_STYLES = Arrays.asList(new Integer[]{1, 2, 3});
    public static final int ZOOM_FOCUS_CENTER = 2;
    public static final int ZOOM_FOCUS_CENTER_IMMEDIATE = 3;
    public static final int ZOOM_FOCUS_FIXED = 1;
    private static Bitmap.Config preferredBitmapConfig;
    /* access modifiers changed from: private */
    public Anim anim;
    private Bitmap bitmap;
    private DecoderFactory<? extends ImageDecoder> bitmapDecoderFactory;
    private boolean bitmapIsCached;
    private boolean bitmapIsPreview;
    private Paint bitmapPaint;
    private boolean debug;
    private Paint debugLinePaint;
    private Paint debugTextPaint;
    private ImageRegionDecoder decoder;
    /* access modifiers changed from: private */
    public final ReadWriteLock decoderLock;
    private final float density;
    private GestureDetector detector;
    private int doubleTapZoomDuration;
    private float doubleTapZoomScale;
    private int doubleTapZoomStyle;
    private final float[] dstArray;
    private boolean eagerLoadingEnabled;
    private Executor executor;
    private int fullImageSampleSize;
    private final Handler handler;
    private boolean imageLoadedSent;
    private boolean isPanning;
    /* access modifiers changed from: private */
    public boolean isQuickScaling;
    /* access modifiers changed from: private */
    public boolean isZooming;
    private Matrix matrix;
    private float maxScale;
    private int maxTileHeight;
    private int maxTileWidth;
    /* access modifiers changed from: private */
    public int maxTouchCount;
    private float minScale;
    private int minimumScaleType;
    private int minimumTileDpi;
    /* access modifiers changed from: private */
    public OnImageEventListener onImageEventListener;
    /* access modifiers changed from: private */
    public View.OnLongClickListener onLongClickListener;
    private OnStateChangedListener onStateChangedListener;
    private int orientation;
    private Rect pRegion;
    /* access modifiers changed from: private */
    public boolean panEnabled;
    private int panLimit;
    private Float pendingScale;
    /* access modifiers changed from: private */
    public boolean quickScaleEnabled;
    /* access modifiers changed from: private */
    public float quickScaleLastDistance;
    /* access modifiers changed from: private */
    public boolean quickScaleMoved;
    /* access modifiers changed from: private */
    public PointF quickScaleSCenter;
    private final float quickScaleThreshold;
    /* access modifiers changed from: private */
    public PointF quickScaleVLastPoint;
    /* access modifiers changed from: private */
    public PointF quickScaleVStart;
    /* access modifiers changed from: private */
    public boolean readySent;
    private DecoderFactory<? extends ImageRegionDecoder> regionDecoderFactory;
    private int sHeight;
    private int sOrientation;
    private PointF sPendingCenter;
    private RectF sRect;
    /* access modifiers changed from: private */
    public Rect sRegion;
    private PointF sRequestedCenter;
    private int sWidth;
    private ScaleAndTranslate satTemp;
    /* access modifiers changed from: private */
    public float scale;
    /* access modifiers changed from: private */
    public float scaleStart;
    private GestureDetector singleDetector;
    private final float[] srcArray;
    private Paint tileBgPaint;
    private Map<Integer, List<Tile>> tileMap;
    private Uri uri;
    /* access modifiers changed from: private */
    public PointF vCenterStart;
    private float vDistStart;
    /* access modifiers changed from: private */
    public PointF vTranslate;
    private PointF vTranslateBefore;
    /* access modifiers changed from: private */
    public PointF vTranslateStart;
    /* access modifiers changed from: private */
    public boolean zoomEnabled;

    public static class Anim {
        /* access modifiers changed from: private */
        public long duration;
        /* access modifiers changed from: private */
        public int easing;
        /* access modifiers changed from: private */
        public boolean interruptible;
        /* access modifiers changed from: private */
        public OnAnimationEventListener listener;
        /* access modifiers changed from: private */
        public int origin;
        /* access modifiers changed from: private */
        public PointF sCenterEnd;
        /* access modifiers changed from: private */
        public PointF sCenterEndRequested;
        /* access modifiers changed from: private */
        public PointF sCenterStart;
        /* access modifiers changed from: private */
        public float scaleEnd;
        /* access modifiers changed from: private */
        public float scaleStart;
        /* access modifiers changed from: private */
        public long time;
        /* access modifiers changed from: private */
        public PointF vFocusEnd;
        /* access modifiers changed from: private */
        public PointF vFocusStart;

        private Anim() {
            this.duration = 500;
            this.interruptible = true;
            this.easing = 2;
            this.origin = 1;
            this.time = System.currentTimeMillis();
        }
    }

    public static class BitmapLoadTask extends AsyncTask<Void, Void, Integer> {
        private Bitmap bitmap;
        private final WeakReference<Context> contextRef;
        private final WeakReference<DecoderFactory<? extends ImageDecoder>> decoderFactoryRef;
        private Exception exception;
        private final boolean preview;
        private final Uri source;
        private final WeakReference<SubsamplingScaleImageView> viewRef;

        public BitmapLoadTask(SubsamplingScaleImageView subsamplingScaleImageView, Context context, DecoderFactory<? extends ImageDecoder> decoderFactory, Uri uri, boolean z11) {
            this.viewRef = new WeakReference<>(subsamplingScaleImageView);
            this.contextRef = new WeakReference<>(context);
            this.decoderFactoryRef = new WeakReference<>(decoderFactory);
            this.source = uri;
            this.preview = z11;
        }

        public Integer doInBackground(Void... voidArr) {
            try {
                String uri = this.source.toString();
                Context context = (Context) this.contextRef.get();
                DecoderFactory decoderFactory = (DecoderFactory) this.decoderFactoryRef.get();
                SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.viewRef.get();
                if (context == null || decoderFactory == null || subsamplingScaleImageView == null) {
                    return null;
                }
                subsamplingScaleImageView.debug("BitmapLoadTask.doInBackground", new Object[0]);
                this.bitmap = ((ImageDecoder) decoderFactory.make()).decode(context, this.source);
                return Integer.valueOf(subsamplingScaleImageView.getExifOrientation(context, uri));
            } catch (Exception e11) {
                Log.e(SubsamplingScaleImageView.TAG, "Failed to load bitmap", e11);
                this.exception = e11;
                return null;
            } catch (OutOfMemoryError e12) {
                Log.e(SubsamplingScaleImageView.TAG, "Failed to load bitmap - OutOfMemoryError", e12);
                this.exception = new RuntimeException(e12);
                return null;
            }
        }

        public void onPostExecute(Integer num) {
            SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.viewRef.get();
            if (subsamplingScaleImageView != null) {
                Bitmap bitmap2 = this.bitmap;
                if (bitmap2 == null || num == null) {
                    if (this.exception != null && subsamplingScaleImageView.onImageEventListener != null) {
                        if (this.preview) {
                            subsamplingScaleImageView.onImageEventListener.onPreviewLoadError(this.exception);
                        } else {
                            subsamplingScaleImageView.onImageEventListener.onImageLoadError(this.exception);
                        }
                    }
                } else if (this.preview) {
                    subsamplingScaleImageView.onPreviewLoaded(bitmap2);
                } else {
                    subsamplingScaleImageView.onImageLoaded(bitmap2, num.intValue(), false);
                }
            }
        }
    }

    public static class DefaultOnAnimationEventListener implements OnAnimationEventListener {
        public void onComplete() {
        }

        public void onInterruptedByNewAnim() {
        }

        public void onInterruptedByUser() {
        }
    }

    public static class DefaultOnImageEventListener implements OnImageEventListener {
        public void onImageLoadError(Exception exc) {
        }

        public void onImageLoaded() {
        }

        public void onPreviewLoadError(Exception exc) {
        }

        public void onPreviewReleased() {
        }

        public void onReady() {
        }

        public void onTileLoadError(Exception exc) {
        }
    }

    public static class DefaultOnStateChangedListener implements OnStateChangedListener {
        public void onCenterChanged(PointF pointF, int i11) {
        }

        public void onScaleChanged(float f11, int i11) {
        }
    }

    public interface OnAnimationEventListener {
        void onComplete();

        void onInterruptedByNewAnim();

        void onInterruptedByUser();
    }

    public interface OnImageEventListener {
        void onImageLoadError(Exception exc);

        void onImageLoaded();

        void onPreviewLoadError(Exception exc);

        void onPreviewReleased();

        void onReady();

        void onTileLoadError(Exception exc);
    }

    public interface OnStateChangedListener {
        void onCenterChanged(PointF pointF, int i11);

        void onScaleChanged(float f11, int i11);
    }

    public static class ScaleAndTranslate {
        /* access modifiers changed from: private */
        public float scale;
        /* access modifiers changed from: private */
        public final PointF vTranslate;

        private ScaleAndTranslate(float f11, PointF pointF) {
            this.scale = f11;
            this.vTranslate = pointF;
        }
    }

    public static class Tile {
        /* access modifiers changed from: private */
        public Bitmap bitmap;
        /* access modifiers changed from: private */
        public Rect fileSRect;
        /* access modifiers changed from: private */
        public boolean loading;
        /* access modifiers changed from: private */
        public Rect sRect;
        /* access modifiers changed from: private */
        public int sampleSize;
        /* access modifiers changed from: private */
        public Rect vRect;
        /* access modifiers changed from: private */
        public boolean visible;

        private Tile() {
        }
    }

    public static class TileLoadTask extends AsyncTask<Void, Void, Bitmap> {
        private final WeakReference<ImageRegionDecoder> decoderRef;
        private Exception exception;
        private final WeakReference<Tile> tileRef;
        private final WeakReference<SubsamplingScaleImageView> viewRef;

        public TileLoadTask(SubsamplingScaleImageView subsamplingScaleImageView, ImageRegionDecoder imageRegionDecoder, Tile tile) {
            this.viewRef = new WeakReference<>(subsamplingScaleImageView);
            this.decoderRef = new WeakReference<>(imageRegionDecoder);
            this.tileRef = new WeakReference<>(tile);
            boolean unused = tile.loading = true;
        }

        public Bitmap doInBackground(Void... voidArr) {
            SubsamplingScaleImageView subsamplingScaleImageView;
            try {
                subsamplingScaleImageView = (SubsamplingScaleImageView) this.viewRef.get();
                ImageRegionDecoder imageRegionDecoder = (ImageRegionDecoder) this.decoderRef.get();
                Tile tile = (Tile) this.tileRef.get();
                if (imageRegionDecoder != null && tile != null && subsamplingScaleImageView != null && imageRegionDecoder.isReady() && tile.visible) {
                    subsamplingScaleImageView.debug("TileLoadTask.doInBackground, tile.sRect=%s, tile.sampleSize=%d", tile.sRect, Integer.valueOf(tile.sampleSize));
                    subsamplingScaleImageView.decoderLock.readLock().lock();
                    if (imageRegionDecoder.isReady()) {
                        subsamplingScaleImageView.fileSRect(tile.sRect, tile.fileSRect);
                        if (subsamplingScaleImageView.sRegion != null) {
                            tile.fileSRect.offset(subsamplingScaleImageView.sRegion.left, subsamplingScaleImageView.sRegion.top);
                        }
                        Bitmap decodeRegion = imageRegionDecoder.decodeRegion(tile.fileSRect, tile.sampleSize);
                        subsamplingScaleImageView.decoderLock.readLock().unlock();
                        return decodeRegion;
                    }
                    boolean unused = tile.loading = false;
                    subsamplingScaleImageView.decoderLock.readLock().unlock();
                    return null;
                } else if (tile == null) {
                    return null;
                } else {
                    boolean unused2 = tile.loading = false;
                    return null;
                }
            } catch (Exception e11) {
                Log.e(SubsamplingScaleImageView.TAG, "Failed to decode tile", e11);
                this.exception = e11;
                return null;
            } catch (OutOfMemoryError e12) {
                Log.e(SubsamplingScaleImageView.TAG, "Failed to decode tile - OutOfMemoryError", e12);
                this.exception = new RuntimeException(e12);
                return null;
            } catch (Throwable th2) {
                subsamplingScaleImageView.decoderLock.readLock().unlock();
                throw th2;
            }
        }

        public void onPostExecute(Bitmap bitmap) {
            SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.viewRef.get();
            Tile tile = (Tile) this.tileRef.get();
            if (subsamplingScaleImageView != null && tile != null) {
                if (bitmap != null) {
                    Bitmap unused = tile.bitmap = bitmap;
                    boolean unused2 = tile.loading = false;
                    subsamplingScaleImageView.onTileLoaded();
                } else if (this.exception != null && subsamplingScaleImageView.onImageEventListener != null) {
                    subsamplingScaleImageView.onImageEventListener.onTileLoadError(this.exception);
                }
            }
        }
    }

    public static class TilesInitTask extends AsyncTask<Void, Void, int[]> {
        private final WeakReference<Context> contextRef;
        private ImageRegionDecoder decoder;
        private final WeakReference<DecoderFactory<? extends ImageRegionDecoder>> decoderFactoryRef;
        private Exception exception;
        private final Uri source;
        private final WeakReference<SubsamplingScaleImageView> viewRef;

        public TilesInitTask(SubsamplingScaleImageView subsamplingScaleImageView, Context context, DecoderFactory<? extends ImageRegionDecoder> decoderFactory, Uri uri) {
            this.viewRef = new WeakReference<>(subsamplingScaleImageView);
            this.contextRef = new WeakReference<>(context);
            this.decoderFactoryRef = new WeakReference<>(decoderFactory);
            this.source = uri;
        }

        public int[] doInBackground(Void... voidArr) {
            try {
                String uri = this.source.toString();
                Context context = (Context) this.contextRef.get();
                DecoderFactory decoderFactory = (DecoderFactory) this.decoderFactoryRef.get();
                SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.viewRef.get();
                if (context == null || decoderFactory == null || subsamplingScaleImageView == null) {
                    return null;
                }
                subsamplingScaleImageView.debug("TilesInitTask.doInBackground", new Object[0]);
                ImageRegionDecoder imageRegionDecoder = (ImageRegionDecoder) decoderFactory.make();
                this.decoder = imageRegionDecoder;
                Point init = imageRegionDecoder.init(context, this.source);
                int i11 = init.x;
                int i12 = init.y;
                int access$5200 = subsamplingScaleImageView.getExifOrientation(context, uri);
                if (subsamplingScaleImageView.sRegion != null) {
                    subsamplingScaleImageView.sRegion.left = Math.max(0, subsamplingScaleImageView.sRegion.left);
                    subsamplingScaleImageView.sRegion.top = Math.max(0, subsamplingScaleImageView.sRegion.top);
                    subsamplingScaleImageView.sRegion.right = Math.min(i11, subsamplingScaleImageView.sRegion.right);
                    subsamplingScaleImageView.sRegion.bottom = Math.min(i12, subsamplingScaleImageView.sRegion.bottom);
                    i11 = subsamplingScaleImageView.sRegion.width();
                    i12 = subsamplingScaleImageView.sRegion.height();
                }
                return new int[]{i11, i12, access$5200};
            } catch (Exception e11) {
                Log.e(SubsamplingScaleImageView.TAG, "Failed to initialise bitmap decoder", e11);
                this.exception = e11;
                return null;
            }
        }

        public void onPostExecute(int[] iArr) {
            SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.viewRef.get();
            if (subsamplingScaleImageView != null) {
                ImageRegionDecoder imageRegionDecoder = this.decoder;
                if (imageRegionDecoder != null && iArr != null && iArr.length == 3) {
                    subsamplingScaleImageView.onTilesInited(imageRegionDecoder, iArr[0], iArr[1], iArr[2]);
                } else if (this.exception != null && subsamplingScaleImageView.onImageEventListener != null) {
                    subsamplingScaleImageView.onImageEventListener.onImageLoadError(this.exception);
                }
            }
        }
    }

    public SubsamplingScaleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int resourceId;
        String string;
        this.orientation = 0;
        this.maxScale = 2.0f;
        this.minScale = minScale();
        this.minimumTileDpi = -1;
        this.panLimit = 1;
        this.minimumScaleType = 1;
        this.maxTileWidth = Integer.MAX_VALUE;
        this.maxTileHeight = Integer.MAX_VALUE;
        this.executor = AsyncTask.THREAD_POOL_EXECUTOR;
        this.eagerLoadingEnabled = true;
        this.panEnabled = true;
        this.zoomEnabled = true;
        this.quickScaleEnabled = true;
        this.doubleTapZoomScale = 1.0f;
        this.doubleTapZoomStyle = 1;
        this.doubleTapZoomDuration = 500;
        this.decoderLock = new ReentrantReadWriteLock(true);
        this.bitmapDecoderFactory = new CompatDecoderFactory(SkiaImageDecoder.class);
        this.regionDecoderFactory = new CompatDecoderFactory(SkiaImageRegionDecoder.class);
        this.srcArray = new float[8];
        this.dstArray = new float[8];
        this.density = getResources().getDisplayMetrics().density;
        setMinimumDpi(160);
        setDoubleTapZoomDpi(160);
        setMinimumTileDpi(320);
        setGestureDetector(context);
        this.handler = new Handler(new Handler.Callback() {
            public boolean handleMessage(Message message) {
                if (message.what == 1 && SubsamplingScaleImageView.this.onLongClickListener != null) {
                    int unused = SubsamplingScaleImageView.this.maxTouchCount = 0;
                    SubsamplingScaleImageView subsamplingScaleImageView = SubsamplingScaleImageView.this;
                    SubsamplingScaleImageView.super.setOnLongClickListener(subsamplingScaleImageView.onLongClickListener);
                    SubsamplingScaleImageView.this.performLongClick();
                    SubsamplingScaleImageView.super.setOnLongClickListener((View.OnLongClickListener) null);
                }
                return true;
            }
        });
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.SubsamplingScaleImageView);
            int i11 = R.styleable.SubsamplingScaleImageView_assetName;
            if (obtainStyledAttributes.hasValue(i11) && (string = obtainStyledAttributes.getString(i11)) != null && string.length() > 0) {
                setImage(ImageSource.asset(string).tilingEnabled());
            }
            int i12 = R.styleable.SubsamplingScaleImageView_src;
            if (obtainStyledAttributes.hasValue(i12) && (resourceId = obtainStyledAttributes.getResourceId(i12, 0)) > 0) {
                setImage(ImageSource.resource(resourceId).tilingEnabled());
            }
            int i13 = R.styleable.SubsamplingScaleImageView_panEnabled;
            if (obtainStyledAttributes.hasValue(i13)) {
                setPanEnabled(obtainStyledAttributes.getBoolean(i13, true));
            }
            int i14 = R.styleable.SubsamplingScaleImageView_zoomEnabled;
            if (obtainStyledAttributes.hasValue(i14)) {
                setZoomEnabled(obtainStyledAttributes.getBoolean(i14, true));
            }
            int i15 = R.styleable.SubsamplingScaleImageView_quickScaleEnabled;
            if (obtainStyledAttributes.hasValue(i15)) {
                setQuickScaleEnabled(obtainStyledAttributes.getBoolean(i15, true));
            }
            int i16 = R.styleable.SubsamplingScaleImageView_tileBackgroundColor;
            if (obtainStyledAttributes.hasValue(i16)) {
                setTileBackgroundColor(obtainStyledAttributes.getColor(i16, Color.argb(0, 0, 0, 0)));
            }
            obtainStyledAttributes.recycle();
        }
        this.quickScaleThreshold = TypedValue.applyDimension(1, 20.0f, context.getResources().getDisplayMetrics());
    }

    private int calculateInSampleSize(float f11) {
        int i11;
        if (this.minimumTileDpi > 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            f11 *= ((float) this.minimumTileDpi) / ((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f);
        }
        int sWidth2 = (int) (((float) sWidth()) * f11);
        int sHeight2 = (int) (((float) sHeight()) * f11);
        if (sWidth2 == 0 || sHeight2 == 0) {
            return 32;
        }
        int i12 = 1;
        if (sHeight() > sHeight2 || sWidth() > sWidth2) {
            i11 = Math.round(((float) sHeight()) / ((float) sHeight2));
            int round = Math.round(((float) sWidth()) / ((float) sWidth2));
            if (i11 >= round) {
                i11 = round;
            }
        } else {
            i11 = 1;
        }
        while (true) {
            int i13 = i12 * 2;
            if (i13 >= i11) {
                return i12;
            }
            i12 = i13;
        }
    }

    private boolean checkImageLoaded() {
        boolean isBaseLayerReady = isBaseLayerReady();
        if (!this.imageLoadedSent && isBaseLayerReady) {
            preDraw();
            this.imageLoadedSent = true;
            onImageLoaded();
            OnImageEventListener onImageEventListener2 = this.onImageEventListener;
            if (onImageEventListener2 != null) {
                onImageEventListener2.onImageLoaded();
            }
        }
        return isBaseLayerReady;
    }

    private boolean checkReady() {
        boolean z11 = getWidth() > 0 && getHeight() > 0 && this.sWidth > 0 && this.sHeight > 0 && (this.bitmap != null || isBaseLayerReady());
        if (!this.readySent && z11) {
            preDraw();
            this.readySent = true;
            onReady();
            OnImageEventListener onImageEventListener2 = this.onImageEventListener;
            if (onImageEventListener2 != null) {
                onImageEventListener2.onReady();
            }
        }
        return z11;
    }

    private void createPaints() {
        if (this.bitmapPaint == null) {
            Paint paint = new Paint();
            this.bitmapPaint = paint;
            paint.setAntiAlias(true);
            this.bitmapPaint.setFilterBitmap(true);
            this.bitmapPaint.setDither(true);
        }
        if ((this.debugTextPaint == null || this.debugLinePaint == null) && this.debug) {
            Paint paint2 = new Paint();
            this.debugTextPaint = paint2;
            paint2.setTextSize((float) px(12));
            this.debugTextPaint.setColor(-65281);
            this.debugTextPaint.setStyle(Paint.Style.FILL);
            Paint paint3 = new Paint();
            this.debugLinePaint = paint3;
            paint3.setColor(-65281);
            this.debugLinePaint.setStyle(Paint.Style.STROKE);
            this.debugLinePaint.setStrokeWidth((float) px(1));
        }
    }

    /* access modifiers changed from: private */
    public void debug(String str, Object... objArr) {
        if (this.debug) {
            Log.d(TAG, String.format(str, objArr));
        }
    }

    private float distance(float f11, float f12, float f13, float f14) {
        float f15 = f11 - f12;
        float f16 = f13 - f14;
        return (float) Math.sqrt((double) ((f15 * f15) + (f16 * f16)));
    }

    /* access modifiers changed from: private */
    public void doubleTapZoom(PointF pointF, PointF pointF2) {
        if (!this.panEnabled) {
            PointF pointF3 = this.sRequestedCenter;
            if (pointF3 != null) {
                pointF.x = pointF3.x;
                pointF.y = pointF3.y;
            } else {
                pointF.x = (float) (sWidth() / 2);
                pointF.y = (float) (sHeight() / 2);
            }
        }
        float min = Math.min(this.maxScale, this.doubleTapZoomScale);
        float f11 = this.scale;
        boolean z11 = ((double) f11) <= ((double) min) * 0.9d || f11 == this.minScale;
        if (!z11) {
            min = minScale();
        }
        float f12 = min;
        int i11 = this.doubleTapZoomStyle;
        if (i11 == 3) {
            setScaleAndCenter(f12, pointF);
        } else if (i11 == 2 || !z11 || !this.panEnabled) {
            new AnimationBuilder(f12, pointF).withInterruptible(false).withDuration((long) this.doubleTapZoomDuration).withOrigin(4).start();
        } else if (i11 == 1) {
            new AnimationBuilder(f12, pointF, pointF2).withInterruptible(false).withDuration((long) this.doubleTapZoomDuration).withOrigin(4).start();
        }
        invalidate();
    }

    private float ease(int i11, long j11, float f11, float f12, long j12) {
        if (i11 == 1) {
            return easeOutQuad(j11, f11, f12, j12);
        }
        if (i11 == 2) {
            return easeInOutQuad(j11, f11, f12, j12);
        }
        throw new IllegalStateException("Unexpected easing type: " + i11);
    }

    private float easeInOutQuad(long j11, float f11, float f12, long j12) {
        float f13;
        float f14 = ((float) j11) / (((float) j12) / 2.0f);
        if (f14 < 1.0f) {
            f13 = (f12 / 2.0f) * f14;
        } else {
            float f15 = f14 - 1.0f;
            f13 = (-f12) / 2.0f;
            f14 = (f15 * (f15 - 2.0f)) - 1.0f;
        }
        return (f13 * f14) + f11;
    }

    private float easeOutQuad(long j11, float f11, float f12, long j12) {
        float f13 = ((float) j11) / ((float) j12);
        return ((-f12) * f13 * (f13 - 2.0f)) + f11;
    }

    private void execute(AsyncTask<Void, Void, ?> asyncTask) {
        asyncTask.executeOnExecutor(this.executor, new Void[0]);
    }

    /* access modifiers changed from: private */
    public void fileSRect(Rect rect, Rect rect2) {
        if (getRequiredRotation() == 0) {
            rect2.set(rect);
        } else if (getRequiredRotation() == 90) {
            int i11 = rect.top;
            int i12 = this.sHeight;
            rect2.set(i11, i12 - rect.right, rect.bottom, i12 - rect.left);
        } else if (getRequiredRotation() == 180) {
            int i13 = this.sWidth;
            int i14 = this.sHeight;
            rect2.set(i13 - rect.right, i14 - rect.bottom, i13 - rect.left, i14 - rect.top);
        } else {
            int i15 = this.sWidth;
            rect2.set(i15 - rect.bottom, rect.left, i15 - rect.top, rect.right);
        }
    }

    /* access modifiers changed from: private */
    public void fitToBounds(boolean z11, ScaleAndTranslate scaleAndTranslate) {
        float f11;
        float f12;
        int i11;
        if (this.panLimit == 2 && isReady()) {
            z11 = false;
        }
        PointF access$4800 = scaleAndTranslate.vTranslate;
        float limitedScale = limitedScale(scaleAndTranslate.scale);
        float sWidth2 = ((float) sWidth()) * limitedScale;
        float sHeight2 = ((float) sHeight()) * limitedScale;
        if (this.panLimit == 3 && isReady()) {
            access$4800.x = Math.max(access$4800.x, ((float) (getWidth() / 2)) - sWidth2);
            access$4800.y = Math.max(access$4800.y, ((float) (getHeight() / 2)) - sHeight2);
        } else if (z11) {
            access$4800.x = Math.max(access$4800.x, ((float) getWidth()) - sWidth2);
            access$4800.y = Math.max(access$4800.y, ((float) getHeight()) - sHeight2);
        } else {
            access$4800.x = Math.max(access$4800.x, -sWidth2);
            access$4800.y = Math.max(access$4800.y, -sHeight2);
        }
        float f13 = 0.5f;
        float paddingLeft = (getPaddingLeft() > 0 || getPaddingRight() > 0) ? ((float) getPaddingLeft()) / ((float) (getPaddingLeft() + getPaddingRight())) : 0.5f;
        if (getPaddingTop() > 0 || getPaddingBottom() > 0) {
            f13 = ((float) getPaddingTop()) / ((float) (getPaddingTop() + getPaddingBottom()));
        }
        if (this.panLimit == 3 && isReady()) {
            f11 = (float) Math.max(0, getWidth() / 2);
            i11 = Math.max(0, getHeight() / 2);
        } else if (z11) {
            f11 = Math.max(0.0f, (((float) getWidth()) - sWidth2) * paddingLeft);
            f12 = Math.max(0.0f, (((float) getHeight()) - sHeight2) * f13);
            access$4800.x = Math.min(access$4800.x, f11);
            access$4800.y = Math.min(access$4800.y, f12);
            float unused = scaleAndTranslate.scale = limitedScale;
        } else {
            f11 = (float) Math.max(0, getWidth());
            i11 = Math.max(0, getHeight());
        }
        f12 = (float) i11;
        access$4800.x = Math.min(access$4800.x, f11);
        access$4800.y = Math.min(access$4800.y, f12);
        float unused2 = scaleAndTranslate.scale = limitedScale;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0059, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        android.util.Log.w(TAG, "Could not get orientation of image from media store");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0065, code lost:
        if (r0 != null) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0067, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006a, code lost:
        throw r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        return 0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x005b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getExifOrientation(android.content.Context r10, java.lang.String r11) {
        /*
            r9 = this;
            java.lang.String r0 = "content"
            boolean r0 = r11.startsWith(r0)
            r1 = 0
            if (r0 == 0) goto L_0x006b
            r0 = 0
            java.lang.String r2 = "orientation"
            java.lang.String[] r5 = new java.lang.String[]{r2}     // Catch:{ Exception -> 0x005b }
            android.content.ContentResolver r3 = r10.getContentResolver()     // Catch:{ Exception -> 0x005b }
            android.net.Uri r4 = android.net.Uri.parse(r11)     // Catch:{ Exception -> 0x005b }
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r0 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x005b }
            if (r0 == 0) goto L_0x0052
            boolean r10 = r0.moveToFirst()     // Catch:{ Exception -> 0x005b }
            if (r10 == 0) goto L_0x0052
            int r10 = r0.getInt(r1)     // Catch:{ Exception -> 0x005b }
            java.util.List<java.lang.Integer> r11 = VALID_ORIENTATIONS     // Catch:{ Exception -> 0x005b }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r10)     // Catch:{ Exception -> 0x005b }
            boolean r11 = r11.contains(r2)     // Catch:{ Exception -> 0x005b }
            if (r11 == 0) goto L_0x003c
            r11 = -1
            if (r10 == r11) goto L_0x003c
            r1 = r10
            goto L_0x0052
        L_0x003c:
            java.lang.String r11 = TAG     // Catch:{ Exception -> 0x005b }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x005b }
            r2.<init>()     // Catch:{ Exception -> 0x005b }
            java.lang.String r3 = "Unsupported orientation: "
            r2.append(r3)     // Catch:{ Exception -> 0x005b }
            r2.append(r10)     // Catch:{ Exception -> 0x005b }
            java.lang.String r10 = r2.toString()     // Catch:{ Exception -> 0x005b }
            android.util.Log.w(r11, r10)     // Catch:{ Exception -> 0x005b }
        L_0x0052:
            if (r0 == 0) goto L_0x00c3
        L_0x0054:
            r0.close()
            goto L_0x00c3
        L_0x0059:
            r10 = move-exception
            goto L_0x0065
        L_0x005b:
            java.lang.String r10 = TAG     // Catch:{ all -> 0x0059 }
            java.lang.String r11 = "Could not get orientation of image from media store"
            android.util.Log.w(r10, r11)     // Catch:{ all -> 0x0059 }
            if (r0 == 0) goto L_0x00c3
            goto L_0x0054
        L_0x0065:
            if (r0 == 0) goto L_0x006a
            r0.close()
        L_0x006a:
            throw r10
        L_0x006b:
            java.lang.String r10 = "file:///"
            boolean r10 = r11.startsWith(r10)
            if (r10 == 0) goto L_0x00c3
            java.lang.String r10 = "file:///android_asset/"
            boolean r10 = r11.startsWith(r10)
            if (r10 != 0) goto L_0x00c3
            m1.a r10 = new m1.a     // Catch:{ Exception -> 0x00bc }
            r0 = 7
            java.lang.String r11 = r11.substring(r0)     // Catch:{ Exception -> 0x00bc }
            r10.<init>((java.lang.String) r11)     // Catch:{ Exception -> 0x00bc }
            java.lang.String r11 = "Orientation"
            r0 = 1
            int r10 = r10.i(r11, r0)     // Catch:{ Exception -> 0x00bc }
            if (r10 == r0) goto L_0x00c3
            if (r10 != 0) goto L_0x0091
            goto L_0x00c3
        L_0x0091:
            r11 = 6
            if (r10 != r11) goto L_0x0098
            r10 = 90
        L_0x0096:
            r1 = r10
            goto L_0x00c3
        L_0x0098:
            r11 = 3
            if (r10 != r11) goto L_0x009e
            r10 = 180(0xb4, float:2.52E-43)
            goto L_0x0096
        L_0x009e:
            r11 = 8
            if (r10 != r11) goto L_0x00a5
            r10 = 270(0x10e, float:3.78E-43)
            goto L_0x0096
        L_0x00a5:
            java.lang.String r11 = TAG     // Catch:{ Exception -> 0x00bc }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00bc }
            r0.<init>()     // Catch:{ Exception -> 0x00bc }
            java.lang.String r2 = "Unsupported EXIF orientation: "
            r0.append(r2)     // Catch:{ Exception -> 0x00bc }
            r0.append(r10)     // Catch:{ Exception -> 0x00bc }
            java.lang.String r10 = r0.toString()     // Catch:{ Exception -> 0x00bc }
            android.util.Log.w(r11, r10)     // Catch:{ Exception -> 0x00bc }
            goto L_0x00c3
        L_0x00bc:
            java.lang.String r10 = TAG
            java.lang.String r11 = "Could not get EXIF orientation of image"
            android.util.Log.w(r10, r11)
        L_0x00c3:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.getExifOrientation(android.content.Context, java.lang.String):int");
    }

    private Point getMaxBitmapDimensions(Canvas canvas) {
        return new Point(Math.min(canvas.getMaximumBitmapWidth(), this.maxTileWidth), Math.min(canvas.getMaximumBitmapHeight(), this.maxTileHeight));
    }

    public static Bitmap.Config getPreferredBitmapConfig() {
        return preferredBitmapConfig;
    }

    private int getRequiredRotation() {
        int i11 = this.orientation;
        return i11 == -1 ? this.sOrientation : i11;
    }

    private synchronized void initialiseBaseLayer(Point point) {
        debug("initialiseBaseLayer maxTileDimensions=%dx%d", Integer.valueOf(point.x), Integer.valueOf(point.y));
        ScaleAndTranslate scaleAndTranslate = new ScaleAndTranslate(0.0f, new PointF(0.0f, 0.0f));
        this.satTemp = scaleAndTranslate;
        fitToBounds(true, scaleAndTranslate);
        int calculateInSampleSize = calculateInSampleSize(this.satTemp.scale);
        this.fullImageSampleSize = calculateInSampleSize;
        if (calculateInSampleSize > 1) {
            this.fullImageSampleSize = calculateInSampleSize / 2;
        }
        if (this.fullImageSampleSize != 1 || this.sRegion != null || sWidth() >= point.x || sHeight() >= point.y) {
            initialiseTileMap(point);
            for (Tile tileLoadTask : this.tileMap.get(Integer.valueOf(this.fullImageSampleSize))) {
                execute(new TileLoadTask(this, this.decoder, tileLoadTask));
            }
            refreshRequiredTiles(true);
        } else {
            this.decoder.recycle();
            this.decoder = null;
            execute(new BitmapLoadTask(this, getContext(), this.bitmapDecoderFactory, this.uri, false));
        }
    }

    private void initialiseTileMap(Point point) {
        Point point2 = point;
        boolean z11 = false;
        boolean z12 = true;
        debug("initialiseTileMap maxTileDimensions=%dx%d", Integer.valueOf(point2.x), Integer.valueOf(point2.y));
        this.tileMap = new LinkedHashMap();
        int i11 = this.fullImageSampleSize;
        int i12 = 1;
        int i13 = 1;
        while (true) {
            int sWidth2 = sWidth() / i12;
            int sHeight2 = sHeight() / i13;
            int i14 = sWidth2 / i11;
            int i15 = sHeight2 / i11;
            while (true) {
                if (i14 + i12 + (z12 ? 1 : 0) > point2.x || (((double) i14) > ((double) getWidth()) * 1.25d && i11 < this.fullImageSampleSize)) {
                    boolean z13 = z12;
                    boolean z14 = z11;
                    boolean z15 = z13;
                    i12++;
                    sWidth2 = sWidth() / i12;
                    i14 = sWidth2 / i11;
                    boolean z16 = z14;
                    z12 = z15;
                    z11 = z16;
                }
            }
            while (true) {
                if (i15 + i13 + (z12 ? 1 : 0) > point2.y || (((double) i15) > ((double) getHeight()) * 1.25d && i11 < this.fullImageSampleSize)) {
                    boolean z17 = z12;
                    boolean z18 = z11;
                    boolean z19 = z17;
                    i13++;
                    sHeight2 = sHeight() / i13;
                    i15 = sHeight2 / i11;
                    boolean z21 = z18;
                    z12 = z19;
                    z11 = z21;
                }
            }
            ArrayList arrayList = new ArrayList(i12 * i13);
            int i16 = z11;
            while (i16 < i12) {
                int i17 = z11;
                while (i17 < i13) {
                    Tile tile = new Tile();
                    int unused = tile.sampleSize = i11;
                    boolean unused2 = tile.visible = i11 == this.fullImageSampleSize ? z12 : z11;
                    Rect unused3 = tile.sRect = new Rect(i16 * sWidth2, i17 * sHeight2, i16 == i12 + -1 ? sWidth() : (i16 + 1) * sWidth2, i17 == i13 + -1 ? sHeight() : (i17 + 1) * sHeight2);
                    Rect unused4 = tile.vRect = new Rect(0, 0, 0, 0);
                    Rect unused5 = tile.fileSRect = new Rect(tile.sRect);
                    arrayList.add(tile);
                    i17++;
                    z11 = false;
                    z12 = true;
                }
                boolean z22 = z11;
                i16++;
                z12 = true;
            }
            boolean z23 = z11;
            this.tileMap.put(Integer.valueOf(i11), arrayList);
            if (i11 != 1) {
                i11 /= 2;
                boolean z24 = z23;
                z12 = true;
                z11 = z24;
            } else {
                return;
            }
        }
    }

    private boolean isBaseLayerReady() {
        boolean z11 = true;
        if (this.bitmap != null && !this.bitmapIsPreview) {
            return true;
        }
        Map<Integer, List<Tile>> map = this.tileMap;
        if (map == null) {
            return false;
        }
        for (Map.Entry next : map.entrySet()) {
            if (((Integer) next.getKey()).intValue() == this.fullImageSampleSize) {
                for (Tile tile : (List) next.getValue()) {
                    if (tile.loading || tile.bitmap == null) {
                        z11 = false;
                    }
                }
            }
        }
        return z11;
    }

    /* access modifiers changed from: private */
    public PointF limitedSCenter(float f11, float f12, float f13, PointF pointF) {
        PointF vTranslateForSCenter = vTranslateForSCenter(f11, f12, f13);
        pointF.set((((float) (getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2))) - vTranslateForSCenter.x) / f13, (((float) (getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2))) - vTranslateForSCenter.y) / f13);
        return pointF;
    }

    /* access modifiers changed from: private */
    public float limitedScale(float f11) {
        return Math.min(this.maxScale, Math.max(minScale(), f11));
    }

    private float minScale() {
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int i11 = this.minimumScaleType;
        if (i11 == 2 || i11 == 4) {
            return Math.max(((float) (getWidth() - paddingLeft)) / ((float) sWidth()), ((float) (getHeight() - paddingBottom)) / ((float) sHeight()));
        }
        if (i11 == 3) {
            float f11 = this.minScale;
            if (f11 > 0.0f) {
                return f11;
            }
        }
        return Math.min(((float) (getWidth() - paddingLeft)) / ((float) sWidth()), ((float) (getHeight() - paddingBottom)) / ((float) sHeight()));
    }

    /* access modifiers changed from: private */
    public synchronized void onImageLoaded(Bitmap bitmap2, int i11, boolean z11) {
        OnImageEventListener onImageEventListener2;
        debug("onImageLoaded", new Object[0]);
        int i12 = this.sWidth;
        if (i12 > 0 && this.sHeight > 0 && !(i12 == bitmap2.getWidth() && this.sHeight == bitmap2.getHeight())) {
            reset(false);
        }
        Bitmap bitmap3 = this.bitmap;
        if (bitmap3 != null && !this.bitmapIsCached) {
            bitmap3.recycle();
        }
        if (!(this.bitmap == null || !this.bitmapIsCached || (onImageEventListener2 = this.onImageEventListener) == null)) {
            onImageEventListener2.onPreviewReleased();
        }
        this.bitmapIsPreview = false;
        this.bitmapIsCached = z11;
        this.bitmap = bitmap2;
        this.sWidth = bitmap2.getWidth();
        this.sHeight = bitmap2.getHeight();
        this.sOrientation = i11;
        boolean checkReady = checkReady();
        boolean checkImageLoaded = checkImageLoaded();
        if (checkReady || checkImageLoaded) {
            invalidate();
            requestLayout();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onPreviewLoaded(android.graphics.Bitmap r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.String r0 = "onPreviewLoaded"
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0043 }
            r4.debug(r0, r1)     // Catch:{ all -> 0x0043 }
            android.graphics.Bitmap r0 = r4.bitmap     // Catch:{ all -> 0x0043 }
            if (r0 != 0) goto L_0x003e
            boolean r0 = r4.imageLoadedSent     // Catch:{ all -> 0x0043 }
            if (r0 == 0) goto L_0x0012
            goto L_0x003e
        L_0x0012:
            android.graphics.Rect r0 = r4.pRegion     // Catch:{ all -> 0x0043 }
            if (r0 == 0) goto L_0x002b
            int r1 = r0.left     // Catch:{ all -> 0x0043 }
            int r2 = r0.top     // Catch:{ all -> 0x0043 }
            int r0 = r0.width()     // Catch:{ all -> 0x0043 }
            android.graphics.Rect r3 = r4.pRegion     // Catch:{ all -> 0x0043 }
            int r3 = r3.height()     // Catch:{ all -> 0x0043 }
            android.graphics.Bitmap r5 = android.graphics.Bitmap.createBitmap(r5, r1, r2, r0, r3)     // Catch:{ all -> 0x0043 }
            r4.bitmap = r5     // Catch:{ all -> 0x0043 }
            goto L_0x002d
        L_0x002b:
            r4.bitmap = r5     // Catch:{ all -> 0x0043 }
        L_0x002d:
            r5 = 1
            r4.bitmapIsPreview = r5     // Catch:{ all -> 0x0043 }
            boolean r5 = r4.checkReady()     // Catch:{ all -> 0x0043 }
            if (r5 == 0) goto L_0x003c
            r4.invalidate()     // Catch:{ all -> 0x0043 }
            r4.requestLayout()     // Catch:{ all -> 0x0043 }
        L_0x003c:
            monitor-exit(r4)
            return
        L_0x003e:
            r5.recycle()     // Catch:{ all -> 0x0043 }
            monitor-exit(r4)
            return
        L_0x0043:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.onPreviewLoaded(android.graphics.Bitmap):void");
    }

    /* access modifiers changed from: private */
    public synchronized void onTileLoaded() {
        Bitmap bitmap2;
        debug("onTileLoaded", new Object[0]);
        checkReady();
        checkImageLoaded();
        if (isBaseLayerReady() && (bitmap2 = this.bitmap) != null) {
            if (!this.bitmapIsCached) {
                bitmap2.recycle();
            }
            this.bitmap = null;
            OnImageEventListener onImageEventListener2 = this.onImageEventListener;
            if (onImageEventListener2 != null && this.bitmapIsCached) {
                onImageEventListener2.onPreviewReleased();
            }
            this.bitmapIsPreview = false;
            this.bitmapIsCached = false;
        }
        invalidate();
    }

    /* access modifiers changed from: private */
    public synchronized void onTilesInited(ImageRegionDecoder imageRegionDecoder, int i11, int i12, int i13) {
        int i14;
        int i15;
        int i16;
        debug("onTilesInited sWidth=%d, sHeight=%d, sOrientation=%d", Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(this.orientation));
        int i17 = this.sWidth;
        if (i17 > 0 && (i16 = this.sHeight) > 0 && !(i17 == i11 && i16 == i12)) {
            reset(false);
            Bitmap bitmap2 = this.bitmap;
            if (bitmap2 != null) {
                if (!this.bitmapIsCached) {
                    bitmap2.recycle();
                }
                this.bitmap = null;
                OnImageEventListener onImageEventListener2 = this.onImageEventListener;
                if (onImageEventListener2 != null && this.bitmapIsCached) {
                    onImageEventListener2.onPreviewReleased();
                }
                this.bitmapIsPreview = false;
                this.bitmapIsCached = false;
            }
        }
        this.decoder = imageRegionDecoder;
        this.sWidth = i11;
        this.sHeight = i12;
        this.sOrientation = i13;
        checkReady();
        if (!checkImageLoaded() && (i14 = this.maxTileWidth) > 0 && i14 != Integer.MAX_VALUE && (i15 = this.maxTileHeight) > 0 && i15 != Integer.MAX_VALUE && getWidth() > 0 && getHeight() > 0) {
            initialiseBaseLayer(new Point(this.maxTileWidth, this.maxTileHeight));
        }
        invalidate();
        requestLayout();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        if (r1 != 262) goto L_0x03ac;
     */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x03a3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean onTouchEventInternal(android.view.MotionEvent r13) {
        /*
            r12 = this;
            int r0 = r13.getPointerCount()
            int r1 = r13.getAction()
            r2 = 1073741824(0x40000000, float:2.0)
            r3 = 2
            r4 = 0
            r5 = 1
            if (r1 == 0) goto L_0x0419
            if (r1 == r5) goto L_0x03ad
            if (r1 == r3) goto L_0x0023
            r6 = 5
            if (r1 == r6) goto L_0x0419
            r6 = 6
            if (r1 == r6) goto L_0x03ad
            r6 = 261(0x105, float:3.66E-43)
            if (r1 == r6) goto L_0x0419
            r2 = 262(0x106, float:3.67E-43)
            if (r1 == r2) goto L_0x03ad
            goto L_0x03ac
        L_0x0023:
            int r1 = r12.maxTouchCount
            if (r1 <= 0) goto L_0x03a0
            r1 = 1084227584(0x40a00000, float:5.0)
            if (r0 < r3) goto L_0x017f
            float r0 = r13.getX(r4)
            float r6 = r13.getX(r5)
            float r7 = r13.getY(r4)
            float r8 = r13.getY(r5)
            float r0 = r12.distance(r0, r6, r7, r8)
            float r6 = r13.getX(r4)
            float r7 = r13.getX(r5)
            float r6 = r6 + r7
            float r6 = r6 / r2
            float r7 = r13.getY(r4)
            float r13 = r13.getY(r5)
            float r7 = r7 + r13
            float r7 = r7 / r2
            boolean r13 = r12.zoomEnabled
            if (r13 == 0) goto L_0x03a0
            android.graphics.PointF r13 = r12.vCenterStart
            float r2 = r13.x
            float r13 = r13.y
            float r13 = r12.distance(r2, r6, r13, r7)
            int r13 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r13 > 0) goto L_0x0075
            float r13 = r12.vDistStart
            float r13 = r0 - r13
            float r13 = java.lang.Math.abs(r13)
            int r13 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r13 > 0) goto L_0x0075
            boolean r13 = r12.isPanning
            if (r13 == 0) goto L_0x03a0
        L_0x0075:
            r12.isZooming = r5
            r12.isPanning = r5
            float r13 = r12.scale
            double r1 = (double) r13
            float r13 = r12.maxScale
            float r8 = r12.vDistStart
            float r8 = r0 / r8
            float r9 = r12.scaleStart
            float r8 = r8 * r9
            float r13 = java.lang.Math.min(r13, r8)
            r12.scale = r13
            float r8 = r12.minScale()
            int r13 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            if (r13 > 0) goto L_0x00a9
            r12.vDistStart = r0
            float r13 = r12.minScale()
            r12.scaleStart = r13
            android.graphics.PointF r13 = r12.vCenterStart
            r13.set(r6, r7)
            android.graphics.PointF r13 = r12.vTranslateStart
            android.graphics.PointF r0 = r12.vTranslate
            r13.set(r0)
            goto L_0x0175
        L_0x00a9:
            boolean r13 = r12.panEnabled
            if (r13 == 0) goto L_0x0124
            android.graphics.PointF r13 = r12.vCenterStart
            float r3 = r13.x
            android.graphics.PointF r8 = r12.vTranslateStart
            float r9 = r8.x
            float r3 = r3 - r9
            float r13 = r13.y
            float r8 = r8.y
            float r13 = r13 - r8
            float r8 = r12.scale
            float r9 = r12.scaleStart
            float r10 = r8 / r9
            float r3 = r3 * r10
            float r8 = r8 / r9
            float r13 = r13 * r8
            android.graphics.PointF r8 = r12.vTranslate
            float r3 = r6 - r3
            r8.x = r3
            float r13 = r7 - r13
            r8.y = r13
            int r13 = r12.sHeight()
            double r8 = (double) r13
            double r8 = r8 * r1
            int r13 = r12.getHeight()
            double r10 = (double) r13
            int r13 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r13 >= 0) goto L_0x00ee
            float r13 = r12.scale
            int r3 = r12.sHeight()
            float r3 = (float) r3
            float r13 = r13 * r3
            int r3 = r12.getHeight()
            float r3 = (float) r3
            int r13 = (r13 > r3 ? 1 : (r13 == r3 ? 0 : -1))
            if (r13 >= 0) goto L_0x010e
        L_0x00ee:
            int r13 = r12.sWidth()
            double r8 = (double) r13
            double r1 = r1 * r8
            int r13 = r12.getWidth()
            double r8 = (double) r13
            int r13 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r13 >= 0) goto L_0x0175
            float r13 = r12.scale
            int r1 = r12.sWidth()
            float r1 = (float) r1
            float r13 = r13 * r1
            int r1 = r12.getWidth()
            float r1 = (float) r1
            int r13 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r13 < 0) goto L_0x0175
        L_0x010e:
            r12.fitToBounds(r5)
            android.graphics.PointF r13 = r12.vCenterStart
            r13.set(r6, r7)
            android.graphics.PointF r13 = r12.vTranslateStart
            android.graphics.PointF r1 = r12.vTranslate
            r13.set(r1)
            float r13 = r12.scale
            r12.scaleStart = r13
            r12.vDistStart = r0
            goto L_0x0175
        L_0x0124:
            android.graphics.PointF r13 = r12.sRequestedCenter
            if (r13 == 0) goto L_0x014d
            android.graphics.PointF r13 = r12.vTranslate
            int r0 = r12.getWidth()
            int r0 = r0 / r3
            float r0 = (float) r0
            float r1 = r12.scale
            android.graphics.PointF r2 = r12.sRequestedCenter
            float r2 = r2.x
            float r1 = r1 * r2
            float r0 = r0 - r1
            r13.x = r0
            android.graphics.PointF r13 = r12.vTranslate
            int r0 = r12.getHeight()
            int r0 = r0 / r3
            float r0 = (float) r0
            float r1 = r12.scale
            android.graphics.PointF r2 = r12.sRequestedCenter
            float r2 = r2.y
            float r1 = r1 * r2
            float r0 = r0 - r1
            r13.y = r0
            goto L_0x0175
        L_0x014d:
            android.graphics.PointF r13 = r12.vTranslate
            int r0 = r12.getWidth()
            int r0 = r0 / r3
            float r0 = (float) r0
            float r1 = r12.scale
            int r2 = r12.sWidth()
            int r2 = r2 / r3
            float r2 = (float) r2
            float r1 = r1 * r2
            float r0 = r0 - r1
            r13.x = r0
            android.graphics.PointF r13 = r12.vTranslate
            int r0 = r12.getHeight()
            int r0 = r0 / r3
            float r0 = (float) r0
            float r1 = r12.scale
            int r2 = r12.sHeight()
            int r2 = r2 / r3
            float r2 = (float) r2
            float r1 = r1 * r2
            float r0 = r0 - r1
            r13.y = r0
        L_0x0175:
            r12.fitToBounds(r5)
            boolean r13 = r12.eagerLoadingEnabled
            r12.refreshRequiredTiles(r13)
            goto L_0x02cc
        L_0x017f:
            boolean r0 = r12.isQuickScaling
            if (r0 == 0) goto L_0x02cf
            android.graphics.PointF r0 = r12.quickScaleVStart
            float r0 = r0.y
            float r1 = r13.getY()
            float r0 = r0 - r1
            float r0 = java.lang.Math.abs(r0)
            float r0 = r0 * r2
            float r1 = r12.quickScaleThreshold
            float r0 = r0 + r1
            float r1 = r12.quickScaleLastDistance
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 != 0) goto L_0x019e
            r12.quickScaleLastDistance = r0
        L_0x019e:
            float r1 = r13.getY()
            android.graphics.PointF r2 = r12.quickScaleVLastPoint
            float r6 = r2.y
            int r1 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r1 <= 0) goto L_0x01ac
            r1 = r5
            goto L_0x01ad
        L_0x01ac:
            r1 = r4
        L_0x01ad:
            float r13 = r13.getY()
            r6 = 0
            r2.set(r6, r13)
            float r13 = r12.quickScaleLastDistance
            float r13 = r0 / r13
            r2 = 1065353216(0x3f800000, float:1.0)
            float r13 = r2 - r13
            float r13 = java.lang.Math.abs(r13)
            r7 = 1056964608(0x3f000000, float:0.5)
            float r13 = r13 * r7
            r7 = 1022739087(0x3cf5c28f, float:0.03)
            int r7 = (r13 > r7 ? 1 : (r13 == r7 ? 0 : -1))
            if (r7 > 0) goto L_0x01cf
            boolean r7 = r12.quickScaleMoved
            if (r7 == 0) goto L_0x02c2
        L_0x01cf:
            r12.quickScaleMoved = r5
            float r7 = r12.quickScaleLastDistance
            int r7 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1))
            if (r7 <= 0) goto L_0x01dd
            if (r1 == 0) goto L_0x01dc
            float r13 = r13 + r2
            r2 = r13
            goto L_0x01dd
        L_0x01dc:
            float r2 = r2 - r13
        L_0x01dd:
            float r13 = r12.scale
            double r7 = (double) r13
            float r13 = r12.minScale()
            float r1 = r12.maxScale
            float r9 = r12.scale
            float r9 = r9 * r2
            float r1 = java.lang.Math.min(r1, r9)
            float r13 = java.lang.Math.max(r13, r1)
            r12.scale = r13
            boolean r1 = r12.panEnabled
            if (r1 == 0) goto L_0x0271
            android.graphics.PointF r1 = r12.vCenterStart
            float r2 = r1.x
            android.graphics.PointF r3 = r12.vTranslateStart
            float r9 = r3.x
            float r9 = r2 - r9
            float r1 = r1.y
            float r3 = r3.y
            float r3 = r1 - r3
            float r10 = r12.scaleStart
            float r11 = r13 / r10
            float r9 = r9 * r11
            float r13 = r13 / r10
            float r3 = r3 * r13
            android.graphics.PointF r13 = r12.vTranslate
            float r2 = r2 - r9
            r13.x = r2
            float r1 = r1 - r3
            r13.y = r1
            int r13 = r12.sHeight()
            double r1 = (double) r13
            double r1 = r1 * r7
            int r13 = r12.getHeight()
            double r9 = (double) r13
            int r13 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r13 >= 0) goto L_0x0236
            float r13 = r12.scale
            int r1 = r12.sHeight()
            float r1 = (float) r1
            float r13 = r13 * r1
            int r1 = r12.getHeight()
            float r1 = (float) r1
            int r13 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r13 >= 0) goto L_0x0256
        L_0x0236:
            int r13 = r12.sWidth()
            double r1 = (double) r13
            double r7 = r7 * r1
            int r13 = r12.getWidth()
            double r1 = (double) r13
            int r13 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r13 >= 0) goto L_0x02c2
            float r13 = r12.scale
            int r1 = r12.sWidth()
            float r1 = (float) r1
            float r13 = r13 * r1
            int r1 = r12.getWidth()
            float r1 = (float) r1
            int r13 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r13 < 0) goto L_0x02c2
        L_0x0256:
            r12.fitToBounds(r5)
            android.graphics.PointF r13 = r12.vCenterStart
            android.graphics.PointF r0 = r12.quickScaleSCenter
            android.graphics.PointF r0 = r12.sourceToViewCoord(r0)
            r13.set(r0)
            android.graphics.PointF r13 = r12.vTranslateStart
            android.graphics.PointF r0 = r12.vTranslate
            r13.set(r0)
            float r13 = r12.scale
            r12.scaleStart = r13
            r0 = r6
            goto L_0x02c2
        L_0x0271:
            android.graphics.PointF r13 = r12.sRequestedCenter
            if (r13 == 0) goto L_0x029a
            android.graphics.PointF r13 = r12.vTranslate
            int r1 = r12.getWidth()
            int r1 = r1 / r3
            float r1 = (float) r1
            float r2 = r12.scale
            android.graphics.PointF r6 = r12.sRequestedCenter
            float r6 = r6.x
            float r2 = r2 * r6
            float r1 = r1 - r2
            r13.x = r1
            android.graphics.PointF r13 = r12.vTranslate
            int r1 = r12.getHeight()
            int r1 = r1 / r3
            float r1 = (float) r1
            float r2 = r12.scale
            android.graphics.PointF r3 = r12.sRequestedCenter
            float r3 = r3.y
            float r2 = r2 * r3
            float r1 = r1 - r2
            r13.y = r1
            goto L_0x02c2
        L_0x029a:
            android.graphics.PointF r13 = r12.vTranslate
            int r1 = r12.getWidth()
            int r1 = r1 / r3
            float r1 = (float) r1
            float r2 = r12.scale
            int r6 = r12.sWidth()
            int r6 = r6 / r3
            float r6 = (float) r6
            float r2 = r2 * r6
            float r1 = r1 - r2
            r13.x = r1
            android.graphics.PointF r13 = r12.vTranslate
            int r1 = r12.getHeight()
            int r1 = r1 / r3
            float r1 = (float) r1
            float r2 = r12.scale
            int r6 = r12.sHeight()
            int r6 = r6 / r3
            float r3 = (float) r6
            float r2 = r2 * r3
            float r1 = r1 - r2
            r13.y = r1
        L_0x02c2:
            r12.quickScaleLastDistance = r0
            r12.fitToBounds(r5)
            boolean r13 = r12.eagerLoadingEnabled
            r12.refreshRequiredTiles(r13)
        L_0x02cc:
            r13 = r5
            goto L_0x03a1
        L_0x02cf:
            boolean r0 = r12.isZooming
            if (r0 != 0) goto L_0x03a0
            float r0 = r13.getX()
            android.graphics.PointF r2 = r12.vCenterStart
            float r2 = r2.x
            float r0 = r0 - r2
            float r0 = java.lang.Math.abs(r0)
            float r2 = r13.getY()
            android.graphics.PointF r3 = r12.vCenterStart
            float r3 = r3.y
            float r2 = r2 - r3
            float r2 = java.lang.Math.abs(r2)
            float r3 = r12.density
            float r3 = r3 * r1
            int r1 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x02fc
            int r6 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r6 > 0) goto L_0x02fc
            boolean r6 = r12.isPanning
            if (r6 == 0) goto L_0x03a0
        L_0x02fc:
            android.graphics.PointF r6 = r12.vTranslate
            android.graphics.PointF r7 = r12.vTranslateStart
            float r7 = r7.x
            float r8 = r13.getX()
            android.graphics.PointF r9 = r12.vCenterStart
            float r9 = r9.x
            float r8 = r8 - r9
            float r7 = r7 + r8
            r6.x = r7
            android.graphics.PointF r6 = r12.vTranslate
            android.graphics.PointF r7 = r12.vTranslateStart
            float r7 = r7.y
            float r13 = r13.getY()
            android.graphics.PointF r8 = r12.vCenterStart
            float r8 = r8.y
            float r13 = r13 - r8
            float r7 = r7 + r13
            r6.y = r7
            android.graphics.PointF r13 = r12.vTranslate
            float r6 = r13.x
            float r13 = r13.y
            r12.fitToBounds(r5)
            android.graphics.PointF r7 = r12.vTranslate
            float r8 = r7.x
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 == 0) goto L_0x0333
            r6 = r5
            goto L_0x0334
        L_0x0333:
            r6 = r4
        L_0x0334:
            float r7 = r7.y
            int r8 = (r13 > r7 ? 1 : (r13 == r7 ? 0 : -1))
            if (r8 == 0) goto L_0x033c
            r8 = r5
            goto L_0x033d
        L_0x033c:
            r8 = r4
        L_0x033d:
            if (r6 == 0) goto L_0x0349
            int r9 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r9 <= 0) goto L_0x0349
            boolean r9 = r12.isPanning
            if (r9 != 0) goto L_0x0349
            r9 = r5
            goto L_0x034a
        L_0x0349:
            r9 = r4
        L_0x034a:
            if (r8 == 0) goto L_0x0356
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0356
            boolean r0 = r12.isPanning
            if (r0 != 0) goto L_0x0356
            r0 = r5
            goto L_0x0357
        L_0x0356:
            r0 = r4
        L_0x0357:
            int r13 = (r13 > r7 ? 1 : (r13 == r7 ? 0 : -1))
            if (r13 != 0) goto L_0x0364
            r13 = 1077936128(0x40400000, float:3.0)
            float r13 = r13 * r3
            int r13 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r13 <= 0) goto L_0x0364
            r13 = r5
            goto L_0x0365
        L_0x0364:
            r13 = r4
        L_0x0365:
            if (r9 != 0) goto L_0x0376
            if (r0 != 0) goto L_0x0376
            if (r6 == 0) goto L_0x0373
            if (r8 == 0) goto L_0x0373
            if (r13 != 0) goto L_0x0373
            boolean r13 = r12.isPanning
            if (r13 == 0) goto L_0x0376
        L_0x0373:
            r12.isPanning = r5
            goto L_0x0386
        L_0x0376:
            if (r1 > 0) goto L_0x037c
            int r13 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r13 <= 0) goto L_0x0386
        L_0x037c:
            r12.maxTouchCount = r4
            android.os.Handler r13 = r12.handler
            r13.removeMessages(r5)
            r12.requestDisallowInterceptTouchEvent(r4)
        L_0x0386:
            boolean r13 = r12.panEnabled
            if (r13 != 0) goto L_0x0399
            android.graphics.PointF r13 = r12.vTranslate
            android.graphics.PointF r0 = r12.vTranslateStart
            float r1 = r0.x
            r13.x = r1
            float r0 = r0.y
            r13.y = r0
            r12.requestDisallowInterceptTouchEvent(r4)
        L_0x0399:
            boolean r13 = r12.eagerLoadingEnabled
            r12.refreshRequiredTiles(r13)
            goto L_0x02cc
        L_0x03a0:
            r13 = r4
        L_0x03a1:
            if (r13 == 0) goto L_0x03ac
            android.os.Handler r13 = r12.handler
            r13.removeMessages(r5)
            r12.invalidate()
            return r5
        L_0x03ac:
            return r4
        L_0x03ad:
            android.os.Handler r1 = r12.handler
            r1.removeMessages(r5)
            boolean r1 = r12.isQuickScaling
            if (r1 == 0) goto L_0x03c3
            r12.isQuickScaling = r4
            boolean r1 = r12.quickScaleMoved
            if (r1 != 0) goto L_0x03c3
            android.graphics.PointF r1 = r12.quickScaleSCenter
            android.graphics.PointF r2 = r12.vCenterStart
            r12.doubleTapZoom(r1, r2)
        L_0x03c3:
            int r1 = r12.maxTouchCount
            if (r1 <= 0) goto L_0x0410
            boolean r1 = r12.isZooming
            if (r1 != 0) goto L_0x03cf
            boolean r2 = r12.isPanning
            if (r2 == 0) goto L_0x0410
        L_0x03cf:
            if (r1 == 0) goto L_0x0401
            if (r0 != r3) goto L_0x0401
            r12.isPanning = r5
            android.graphics.PointF r1 = r12.vTranslateStart
            android.graphics.PointF r2 = r12.vTranslate
            float r6 = r2.x
            float r2 = r2.y
            r1.set(r6, r2)
            int r1 = r13.getActionIndex()
            if (r1 != r5) goto L_0x03f4
            android.graphics.PointF r1 = r12.vCenterStart
            float r2 = r13.getX(r4)
            float r13 = r13.getY(r4)
            r1.set(r2, r13)
            goto L_0x0401
        L_0x03f4:
            android.graphics.PointF r1 = r12.vCenterStart
            float r2 = r13.getX(r5)
            float r13 = r13.getY(r5)
            r1.set(r2, r13)
        L_0x0401:
            r13 = 3
            if (r0 >= r13) goto L_0x0406
            r12.isZooming = r4
        L_0x0406:
            if (r0 >= r3) goto L_0x040c
            r12.isPanning = r4
            r12.maxTouchCount = r4
        L_0x040c:
            r12.refreshRequiredTiles(r5)
            return r5
        L_0x0410:
            if (r0 != r5) goto L_0x0418
            r12.isZooming = r4
            r12.isPanning = r4
            r12.maxTouchCount = r4
        L_0x0418:
            return r5
        L_0x0419:
            r1 = 0
            r12.anim = r1
            r12.requestDisallowInterceptTouchEvent(r5)
            int r1 = r12.maxTouchCount
            int r1 = java.lang.Math.max(r1, r0)
            r12.maxTouchCount = r1
            if (r0 < r3) goto L_0x0474
            boolean r0 = r12.zoomEnabled
            if (r0 == 0) goto L_0x046c
            float r0 = r13.getX(r4)
            float r1 = r13.getX(r5)
            float r3 = r13.getY(r4)
            float r6 = r13.getY(r5)
            float r0 = r12.distance(r0, r1, r3, r6)
            float r1 = r12.scale
            r12.scaleStart = r1
            r12.vDistStart = r0
            android.graphics.PointF r0 = r12.vTranslateStart
            android.graphics.PointF r1 = r12.vTranslate
            float r3 = r1.x
            float r1 = r1.y
            r0.set(r3, r1)
            android.graphics.PointF r0 = r12.vCenterStart
            float r1 = r13.getX(r4)
            float r3 = r13.getX(r5)
            float r1 = r1 + r3
            float r1 = r1 / r2
            float r3 = r13.getY(r4)
            float r13 = r13.getY(r5)
            float r3 = r3 + r13
            float r3 = r3 / r2
            r0.set(r1, r3)
            goto L_0x046e
        L_0x046c:
            r12.maxTouchCount = r4
        L_0x046e:
            android.os.Handler r13 = r12.handler
            r13.removeMessages(r5)
            goto L_0x0497
        L_0x0474:
            boolean r0 = r12.isQuickScaling
            if (r0 != 0) goto L_0x0497
            android.graphics.PointF r0 = r12.vTranslateStart
            android.graphics.PointF r1 = r12.vTranslate
            float r2 = r1.x
            float r1 = r1.y
            r0.set(r2, r1)
            android.graphics.PointF r0 = r12.vCenterStart
            float r1 = r13.getX()
            float r13 = r13.getY()
            r0.set(r1, r13)
            android.os.Handler r13 = r12.handler
            r0 = 600(0x258, double:2.964E-321)
            r13.sendEmptyMessageDelayed(r5, r0)
        L_0x0497:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.onTouchEventInternal(android.view.MotionEvent):boolean");
    }

    private void preDraw() {
        Float f11;
        if (getWidth() != 0 && getHeight() != 0 && this.sWidth > 0 && this.sHeight > 0) {
            if (!(this.sPendingCenter == null || (f11 = this.pendingScale) == null)) {
                this.scale = f11.floatValue();
                if (this.vTranslate == null) {
                    this.vTranslate = new PointF();
                }
                this.vTranslate.x = ((float) (getWidth() / 2)) - (this.scale * this.sPendingCenter.x);
                this.vTranslate.y = ((float) (getHeight() / 2)) - (this.scale * this.sPendingCenter.y);
                this.sPendingCenter = null;
                this.pendingScale = null;
                fitToBounds(true);
                refreshRequiredTiles(true);
            }
            fitToBounds(false);
        }
    }

    private int px(int i11) {
        return (int) (this.density * ((float) i11));
    }

    private void refreshRequiredTiles(boolean z11) {
        if (this.decoder != null && this.tileMap != null) {
            int min = Math.min(this.fullImageSampleSize, calculateInSampleSize(this.scale));
            for (Map.Entry<Integer, List<Tile>> value : this.tileMap.entrySet()) {
                for (Tile tile : (List) value.getValue()) {
                    if (tile.sampleSize < min || (tile.sampleSize > min && tile.sampleSize != this.fullImageSampleSize)) {
                        boolean unused = tile.visible = false;
                        if (tile.bitmap != null) {
                            tile.bitmap.recycle();
                            Bitmap unused2 = tile.bitmap = null;
                        }
                    }
                    if (tile.sampleSize == min) {
                        if (tileVisible(tile)) {
                            boolean unused3 = tile.visible = true;
                            if (!tile.loading && tile.bitmap == null && z11) {
                                execute(new TileLoadTask(this, this.decoder, tile));
                            }
                        } else if (tile.sampleSize != this.fullImageSampleSize) {
                            boolean unused4 = tile.visible = false;
                            if (tile.bitmap != null) {
                                tile.bitmap.recycle();
                                Bitmap unused5 = tile.bitmap = null;
                            }
                        }
                    } else if (tile.sampleSize == this.fullImageSampleSize) {
                        boolean unused6 = tile.visible = true;
                    }
                }
            }
        }
    }

    private void requestDisallowInterceptTouchEvent(boolean z11) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z11);
        }
    }

    /* JADX INFO: finally extract failed */
    private void reset(boolean z11) {
        OnImageEventListener onImageEventListener2;
        debug("reset newImage=" + z11, new Object[0]);
        this.scale = 0.0f;
        this.scaleStart = 0.0f;
        this.vTranslate = null;
        this.vTranslateStart = null;
        this.vTranslateBefore = null;
        this.pendingScale = Float.valueOf(0.0f);
        this.sPendingCenter = null;
        this.sRequestedCenter = null;
        this.isZooming = false;
        this.isPanning = false;
        this.isQuickScaling = false;
        this.maxTouchCount = 0;
        this.fullImageSampleSize = 0;
        this.vCenterStart = null;
        this.vDistStart = 0.0f;
        this.quickScaleLastDistance = 0.0f;
        this.quickScaleMoved = false;
        this.quickScaleSCenter = null;
        this.quickScaleVLastPoint = null;
        this.quickScaleVStart = null;
        this.anim = null;
        this.satTemp = null;
        this.matrix = null;
        this.sRect = null;
        if (z11) {
            this.uri = null;
            this.decoderLock.writeLock().lock();
            try {
                ImageRegionDecoder imageRegionDecoder = this.decoder;
                if (imageRegionDecoder != null) {
                    imageRegionDecoder.recycle();
                    this.decoder = null;
                }
                this.decoderLock.writeLock().unlock();
                Bitmap bitmap2 = this.bitmap;
                if (bitmap2 != null && !this.bitmapIsCached) {
                    bitmap2.recycle();
                }
                if (!(this.bitmap == null || !this.bitmapIsCached || (onImageEventListener2 = this.onImageEventListener) == null)) {
                    onImageEventListener2.onPreviewReleased();
                }
                this.sWidth = 0;
                this.sHeight = 0;
                this.sOrientation = 0;
                this.sRegion = null;
                this.pRegion = null;
                this.readySent = false;
                this.imageLoadedSent = false;
                this.bitmap = null;
                this.bitmapIsPreview = false;
                this.bitmapIsCached = false;
            } catch (Throwable th2) {
                this.decoderLock.writeLock().unlock();
                throw th2;
            }
        }
        Map<Integer, List<Tile>> map = this.tileMap;
        if (map != null) {
            for (Map.Entry<Integer, List<Tile>> value : map.entrySet()) {
                for (Tile tile : (List) value.getValue()) {
                    boolean unused = tile.visible = false;
                    if (tile.bitmap != null) {
                        tile.bitmap.recycle();
                        Bitmap unused2 = tile.bitmap = null;
                    }
                }
            }
            this.tileMap = null;
        }
        setGestureDetector(getContext());
    }

    private void restoreState(ImageViewState imageViewState) {
        if (imageViewState != null && VALID_ORIENTATIONS.contains(Integer.valueOf(imageViewState.getOrientation()))) {
            this.orientation = imageViewState.getOrientation();
            this.pendingScale = Float.valueOf(imageViewState.getScale());
            this.sPendingCenter = imageViewState.getCenter();
            invalidate();
        }
    }

    private int sHeight() {
        int requiredRotation = getRequiredRotation();
        if (requiredRotation == 90 || requiredRotation == 270) {
            return this.sWidth;
        }
        return this.sHeight;
    }

    private int sWidth() {
        int requiredRotation = getRequiredRotation();
        if (requiredRotation == 90 || requiredRotation == 270) {
            return this.sHeight;
        }
        return this.sWidth;
    }

    private void sendStateChanged(float f11, PointF pointF, int i11) {
        OnStateChangedListener onStateChangedListener2 = this.onStateChangedListener;
        if (onStateChangedListener2 != null) {
            float f12 = this.scale;
            if (f12 != f11) {
                onStateChangedListener2.onScaleChanged(f12, i11);
            }
        }
        if (this.onStateChangedListener != null && !this.vTranslate.equals(pointF)) {
            this.onStateChangedListener.onCenterChanged(getCenter(), i11);
        }
    }

    /* access modifiers changed from: private */
    public void setGestureDetector(final Context context) {
        this.detector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (!SubsamplingScaleImageView.this.zoomEnabled || !SubsamplingScaleImageView.this.readySent || SubsamplingScaleImageView.this.vTranslate == null) {
                    return super.onDoubleTapEvent(motionEvent);
                }
                SubsamplingScaleImageView.this.setGestureDetector(context);
                if (SubsamplingScaleImageView.this.quickScaleEnabled) {
                    PointF unused = SubsamplingScaleImageView.this.vCenterStart = new PointF(motionEvent.getX(), motionEvent.getY());
                    PointF unused2 = SubsamplingScaleImageView.this.vTranslateStart = new PointF(SubsamplingScaleImageView.this.vTranslate.x, SubsamplingScaleImageView.this.vTranslate.y);
                    SubsamplingScaleImageView subsamplingScaleImageView = SubsamplingScaleImageView.this;
                    float unused3 = subsamplingScaleImageView.scaleStart = subsamplingScaleImageView.scale;
                    boolean unused4 = SubsamplingScaleImageView.this.isQuickScaling = true;
                    boolean unused5 = SubsamplingScaleImageView.this.isZooming = true;
                    float unused6 = SubsamplingScaleImageView.this.quickScaleLastDistance = -1.0f;
                    SubsamplingScaleImageView subsamplingScaleImageView2 = SubsamplingScaleImageView.this;
                    PointF unused7 = subsamplingScaleImageView2.quickScaleSCenter = subsamplingScaleImageView2.viewToSourceCoord(subsamplingScaleImageView2.vCenterStart);
                    PointF unused8 = SubsamplingScaleImageView.this.quickScaleVStart = new PointF(motionEvent.getX(), motionEvent.getY());
                    PointF unused9 = SubsamplingScaleImageView.this.quickScaleVLastPoint = new PointF(SubsamplingScaleImageView.this.quickScaleSCenter.x, SubsamplingScaleImageView.this.quickScaleSCenter.y);
                    boolean unused10 = SubsamplingScaleImageView.this.quickScaleMoved = false;
                    return false;
                }
                SubsamplingScaleImageView subsamplingScaleImageView3 = SubsamplingScaleImageView.this;
                subsamplingScaleImageView3.doubleTapZoom(subsamplingScaleImageView3.viewToSourceCoord(new PointF(motionEvent.getX(), motionEvent.getY())), new PointF(motionEvent.getX(), motionEvent.getY()));
                return true;
            }

            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f11, float f12) {
                if (!SubsamplingScaleImageView.this.panEnabled || !SubsamplingScaleImageView.this.readySent || SubsamplingScaleImageView.this.vTranslate == null || motionEvent == null || motionEvent2 == null || ((Math.abs(motionEvent.getX() - motionEvent2.getX()) <= 50.0f && Math.abs(motionEvent.getY() - motionEvent2.getY()) <= 50.0f) || ((Math.abs(f11) <= 500.0f && Math.abs(f12) <= 500.0f) || SubsamplingScaleImageView.this.isZooming))) {
                    return super.onFling(motionEvent, motionEvent2, f11, f12);
                }
                PointF pointF = new PointF(SubsamplingScaleImageView.this.vTranslate.x + (f11 * 0.25f), SubsamplingScaleImageView.this.vTranslate.y + (f12 * 0.25f));
                new AnimationBuilder(new PointF((((float) (SubsamplingScaleImageView.this.getWidth() / 2)) - pointF.x) / SubsamplingScaleImageView.this.scale, (((float) (SubsamplingScaleImageView.this.getHeight() / 2)) - pointF.y) / SubsamplingScaleImageView.this.scale)).withEasing(1).withPanLimited(false).withOrigin(3).start();
                return true;
            }

            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                SubsamplingScaleImageView.this.performClick();
                return true;
            }
        });
        this.singleDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                SubsamplingScaleImageView.this.performClick();
                return true;
            }
        });
    }

    private void setMatrixArray(float[] fArr, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18) {
        fArr[0] = f11;
        fArr[1] = f12;
        fArr[2] = f13;
        fArr[3] = f14;
        fArr[4] = f15;
        fArr[5] = f16;
        fArr[6] = f17;
        fArr[7] = f18;
    }

    public static void setPreferredBitmapConfig(Bitmap.Config config) {
        preferredBitmapConfig = config;
    }

    private void sourceToViewRect(Rect rect, Rect rect2) {
        rect2.set((int) sourceToViewX((float) rect.left), (int) sourceToViewY((float) rect.top), (int) sourceToViewX((float) rect.right), (int) sourceToViewY((float) rect.bottom));
    }

    private float sourceToViewX(float f11) {
        PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f11 * this.scale) + pointF.x;
    }

    private float sourceToViewY(float f11) {
        PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f11 * this.scale) + pointF.y;
    }

    private boolean tileVisible(Tile tile) {
        return viewToSourceX(0.0f) <= ((float) tile.sRect.right) && ((float) tile.sRect.left) <= viewToSourceX((float) getWidth()) && viewToSourceY(0.0f) <= ((float) tile.sRect.bottom) && ((float) tile.sRect.top) <= viewToSourceY((float) getHeight());
    }

    private PointF vTranslateForSCenter(float f11, float f12, float f13) {
        int paddingLeft = getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2);
        int paddingTop = getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2);
        if (this.satTemp == null) {
            this.satTemp = new ScaleAndTranslate(0.0f, new PointF(0.0f, 0.0f));
        }
        float unused = this.satTemp.scale = f13;
        this.satTemp.vTranslate.set(((float) paddingLeft) - (f11 * f13), ((float) paddingTop) - (f12 * f13));
        fitToBounds(true, this.satTemp);
        return this.satTemp.vTranslate;
    }

    private float viewToSourceX(float f11) {
        PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f11 - pointF.x) / this.scale;
    }

    private float viewToSourceY(float f11) {
        PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f11 - pointF.y) / this.scale;
    }

    public AnimationBuilder animateCenter(PointF pointF) {
        if (!isReady()) {
            return null;
        }
        return new AnimationBuilder(pointF);
    }

    public AnimationBuilder animateScale(float f11) {
        if (!isReady()) {
            return null;
        }
        return new AnimationBuilder(f11);
    }

    public AnimationBuilder animateScaleAndCenter(float f11, PointF pointF) {
        if (!isReady()) {
            return null;
        }
        return new AnimationBuilder(f11, pointF);
    }

    public final int getAppliedOrientation() {
        return getRequiredRotation();
    }

    public final PointF getCenter() {
        return viewToSourceCoord((float) (getWidth() / 2), (float) (getHeight() / 2));
    }

    public float getMaxScale() {
        return this.maxScale;
    }

    public final float getMinScale() {
        return minScale();
    }

    public final int getOrientation() {
        return this.orientation;
    }

    public final void getPanRemaining(RectF rectF) {
        if (isReady()) {
            float sWidth2 = this.scale * ((float) sWidth());
            float sHeight2 = this.scale * ((float) sHeight());
            int i11 = this.panLimit;
            if (i11 == 3) {
                rectF.top = Math.max(0.0f, -(this.vTranslate.y - ((float) (getHeight() / 2))));
                rectF.left = Math.max(0.0f, -(this.vTranslate.x - ((float) (getWidth() / 2))));
                rectF.bottom = Math.max(0.0f, this.vTranslate.y - (((float) (getHeight() / 2)) - sHeight2));
                rectF.right = Math.max(0.0f, this.vTranslate.x - (((float) (getWidth() / 2)) - sWidth2));
            } else if (i11 == 2) {
                rectF.top = Math.max(0.0f, -(this.vTranslate.y - ((float) getHeight())));
                rectF.left = Math.max(0.0f, -(this.vTranslate.x - ((float) getWidth())));
                rectF.bottom = Math.max(0.0f, this.vTranslate.y + sHeight2);
                rectF.right = Math.max(0.0f, this.vTranslate.x + sWidth2);
            } else {
                rectF.top = Math.max(0.0f, -this.vTranslate.y);
                rectF.left = Math.max(0.0f, -this.vTranslate.x);
                rectF.bottom = Math.max(0.0f, (sHeight2 + this.vTranslate.y) - ((float) getHeight()));
                rectF.right = Math.max(0.0f, (sWidth2 + this.vTranslate.x) - ((float) getWidth()));
            }
        }
    }

    public final int getSHeight() {
        return this.sHeight;
    }

    public final int getSWidth() {
        return this.sWidth;
    }

    public final float getScale() {
        return this.scale;
    }

    public final ImageViewState getState() {
        if (this.vTranslate == null || this.sWidth <= 0 || this.sHeight <= 0) {
            return null;
        }
        return new ImageViewState(getScale(), getCenter(), getOrientation());
    }

    public boolean hasImage() {
        return (this.uri == null && this.bitmap == null) ? false : true;
    }

    public final boolean isImageLoaded() {
        return this.imageLoadedSent;
    }

    public final boolean isPanEnabled() {
        return this.panEnabled;
    }

    public final boolean isQuickScaleEnabled() {
        return this.quickScaleEnabled;
    }

    public final boolean isReady() {
        return this.readySent;
    }

    public final boolean isZoomEnabled() {
        return this.zoomEnabled;
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x041d  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0487  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r32) {
        /*
            r31 = this;
            r11 = r31
            r12 = r32
            super.onDraw(r32)
            r31.createPaints()
            int r0 = r11.sWidth
            if (r0 == 0) goto L_0x074f
            int r0 = r11.sHeight
            if (r0 == 0) goto L_0x074f
            int r0 = r31.getWidth()
            if (r0 == 0) goto L_0x074f
            int r0 = r31.getHeight()
            if (r0 != 0) goto L_0x0020
            goto L_0x074f
        L_0x0020:
            java.util.Map<java.lang.Integer, java.util.List<com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Tile>> r0 = r11.tileMap
            if (r0 != 0) goto L_0x002f
            com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder r0 = r11.decoder
            if (r0 == 0) goto L_0x002f
            android.graphics.Point r0 = r31.getMaxBitmapDimensions(r32)
            r11.initialiseBaseLayer(r0)
        L_0x002f:
            boolean r0 = r31.checkReady()
            if (r0 != 0) goto L_0x0036
            return
        L_0x0036:
            r31.preDraw()
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r0 = r11.anim
            r9 = 0
            if (r0 == 0) goto L_0x016f
            android.graphics.PointF r0 = r0.vFocusStart
            if (r0 == 0) goto L_0x016f
            float r0 = r11.scale
            android.graphics.PointF r1 = r11.vTranslateBefore
            if (r1 != 0) goto L_0x0051
            android.graphics.PointF r1 = new android.graphics.PointF
            r1.<init>(r9, r9)
            r11.vTranslateBefore = r1
        L_0x0051:
            android.graphics.PointF r1 = r11.vTranslateBefore
            android.graphics.PointF r2 = r11.vTranslate
            r1.set(r2)
            long r1 = java.lang.System.currentTimeMillis()
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r3 = r11.anim
            long r3 = r3.time
            long r1 = r1 - r3
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r3 = r11.anim
            long r3 = r3.duration
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x006f
            r10 = 1
            goto L_0x0070
        L_0x006f:
            r10 = 0
        L_0x0070:
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r3 = r11.anim
            long r3 = r3.duration
            long r15 = java.lang.Math.min(r1, r3)
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r1 = r11.anim
            int r2 = r1.easing
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r1 = r11.anim
            float r5 = r1.scaleStart
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r1 = r11.anim
            float r1 = r1.scaleEnd
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r3 = r11.anim
            float r3 = r3.scaleStart
            float r6 = r1 - r3
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r1 = r11.anim
            long r7 = r1.duration
            r1 = r31
            r3 = r15
            float r1 = r1.ease(r2, r3, r5, r6, r7)
            r11.scale = r1
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r1 = r11.anim
            int r2 = r1.easing
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r1 = r11.anim
            android.graphics.PointF r1 = r1.vFocusStart
            float r5 = r1.x
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r1 = r11.anim
            android.graphics.PointF r1 = r1.vFocusEnd
            float r1 = r1.x
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r3 = r11.anim
            android.graphics.PointF r3 = r3.vFocusStart
            float r3 = r3.x
            float r6 = r1 - r3
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r1 = r11.anim
            long r7 = r1.duration
            r1 = r31
            r3 = r15
            float r17 = r1.ease(r2, r3, r5, r6, r7)
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r1 = r11.anim
            int r2 = r1.easing
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r1 = r11.anim
            android.graphics.PointF r1 = r1.vFocusStart
            float r5 = r1.y
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r1 = r11.anim
            android.graphics.PointF r1 = r1.vFocusEnd
            float r1 = r1.y
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r3 = r11.anim
            android.graphics.PointF r3 = r3.vFocusStart
            float r3 = r3.y
            float r6 = r1 - r3
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r1 = r11.anim
            long r7 = r1.duration
            r1 = r31
            r3 = r15
            float r1 = r1.ease(r2, r3, r5, r6, r7)
            android.graphics.PointF r2 = r11.vTranslate
            float r3 = r2.x
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r4 = r11.anim
            android.graphics.PointF r4 = r4.sCenterEnd
            float r4 = r4.x
            float r4 = r11.sourceToViewX(r4)
            float r4 = r4 - r17
            float r3 = r3 - r4
            r2.x = r3
            android.graphics.PointF r2 = r11.vTranslate
            float r3 = r2.y
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r4 = r11.anim
            android.graphics.PointF r4 = r4.sCenterEnd
            float r4 = r4.y
            float r4 = r11.sourceToViewY(r4)
            float r4 = r4 - r1
            float r3 = r3 - r4
            r2.y = r3
            if (r10 != 0) goto L_0x013b
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r1 = r11.anim
            float r1 = r1.scaleStart
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r2 = r11.anim
            float r2 = r2.scaleEnd
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 != 0) goto L_0x0139
            goto L_0x013b
        L_0x0139:
            r1 = 0
            goto L_0x013c
        L_0x013b:
            r1 = 1
        L_0x013c:
            r11.fitToBounds(r1)
            android.graphics.PointF r1 = r11.vTranslateBefore
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r2 = r11.anim
            int r2 = r2.origin
            r11.sendStateChanged(r0, r1, r2)
            r11.refreshRequiredTiles(r10)
            if (r10 == 0) goto L_0x016c
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r0 = r11.anim
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$OnAnimationEventListener r0 = r0.listener
            if (r0 == 0) goto L_0x0169
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r0 = r11.anim     // Catch:{ Exception -> 0x0161 }
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$OnAnimationEventListener r0 = r0.listener     // Catch:{ Exception -> 0x0161 }
            r0.onComplete()     // Catch:{ Exception -> 0x0161 }
            goto L_0x0169
        L_0x0161:
            r0 = move-exception
            java.lang.String r1 = TAG
            java.lang.String r2 = "Error thrown by animation listener"
            android.util.Log.w(r1, r2, r0)
        L_0x0169:
            r0 = 0
            r11.anim = r0
        L_0x016c:
            r31.invalidate()
        L_0x016f:
            java.util.Map<java.lang.Integer, java.util.List<com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Tile>> r0 = r11.tileMap
            r15 = 270(0x10e, float:3.78E-43)
            r10 = 35
            r8 = 90
            r7 = 180(0xb4, float:2.52E-43)
            if (r0 == 0) goto L_0x0498
            boolean r0 = r31.isBaseLayerReady()
            if (r0 == 0) goto L_0x0498
            int r0 = r11.fullImageSampleSize
            float r1 = r11.scale
            int r1 = r11.calculateInSampleSize(r1)
            int r0 = java.lang.Math.min(r0, r1)
            java.util.Map<java.lang.Integer, java.util.List<com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Tile>> r1 = r11.tileMap
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
            r16 = 0
        L_0x0199:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x01dc
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            if (r3 != r0) goto L_0x0199
            java.lang.Object r2 = r2.getValue()
            java.util.List r2 = (java.util.List) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x01bb:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0199
            java.lang.Object r3 = r2.next()
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Tile r3 = (com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.Tile) r3
            boolean r4 = r3.visible
            if (r4 == 0) goto L_0x01bb
            boolean r4 = r3.loading
            if (r4 != 0) goto L_0x01d9
            android.graphics.Bitmap r3 = r3.bitmap
            if (r3 != 0) goto L_0x01bb
        L_0x01d9:
            r16 = 1
            goto L_0x01bb
        L_0x01dc:
            java.util.Map<java.lang.Integer, java.util.List<com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Tile>> r1 = r11.tileMap
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r17 = r1.iterator()
        L_0x01e6:
            boolean r1 = r17.hasNext()
            if (r1 == 0) goto L_0x0493
            java.lang.Object r1 = r17.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            if (r2 == r0) goto L_0x0208
            if (r16 == 0) goto L_0x0201
            goto L_0x0208
        L_0x0201:
            r13 = r7
            r14 = r8
            r3 = r10
            r5 = 15
            goto L_0x048e
        L_0x0208:
            java.lang.Object r1 = r1.getValue()
            java.util.List r1 = (java.util.List) r1
            java.util.Iterator r18 = r1.iterator()
        L_0x0212:
            boolean r1 = r18.hasNext()
            if (r1 == 0) goto L_0x0201
            java.lang.Object r1 = r18.next()
            r19 = r1
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Tile r19 = (com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.Tile) r19
            android.graphics.Rect r1 = r19.sRect
            android.graphics.Rect r2 = r19.vRect
            r11.sourceToViewRect(r1, r2)
            boolean r1 = r19.loading
            if (r1 != 0) goto L_0x03e2
            android.graphics.Bitmap r1 = r19.bitmap
            if (r1 == 0) goto L_0x03e2
            android.graphics.Paint r1 = r11.tileBgPaint
            if (r1 == 0) goto L_0x0244
            android.graphics.Rect r1 = r19.vRect
            android.graphics.Paint r2 = r11.tileBgPaint
            r12.drawRect(r1, r2)
        L_0x0244:
            android.graphics.Matrix r1 = r11.matrix
            if (r1 != 0) goto L_0x024f
            android.graphics.Matrix r1 = new android.graphics.Matrix
            r1.<init>()
            r11.matrix = r1
        L_0x024f:
            android.graphics.Matrix r1 = r11.matrix
            r1.reset()
            float[] r2 = r11.srcArray
            r3 = 0
            r4 = 0
            android.graphics.Bitmap r1 = r19.bitmap
            int r1 = r1.getWidth()
            float r9 = (float) r1
            r20 = 0
            android.graphics.Bitmap r1 = r19.bitmap
            int r1 = r1.getWidth()
            float r1 = (float) r1
            android.graphics.Bitmap r21 = r19.bitmap
            int r5 = r21.getHeight()
            float r5 = (float) r5
            r21 = 0
            android.graphics.Bitmap r23 = r19.bitmap
            int r6 = r23.getHeight()
            float r6 = (float) r6
            r23 = r1
            r1 = r31
            r22 = r5
            r14 = 5
            r5 = r9
            r24 = r6
            r9 = 15
            r6 = r20
            r13 = r7
            r7 = r23
            r14 = r8
            r8 = r22
            r9 = r21
            r10 = r24
            r1.setMatrixArray(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            int r1 = r31.getRequiredRotation()
            if (r1 != 0) goto L_0x02e2
            float[] r2 = r11.dstArray
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.left
            float r3 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.top
            float r4 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.right
            float r5 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.top
            float r6 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.right
            float r7 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.bottom
            float r8 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.left
            float r9 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.bottom
            float r10 = (float) r1
            r1 = r31
            r1.setMatrixArray(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            goto L_0x03b4
        L_0x02e2:
            int r1 = r31.getRequiredRotation()
            if (r1 != r14) goto L_0x0329
            float[] r2 = r11.dstArray
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.right
            float r3 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.top
            float r4 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.right
            float r5 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.bottom
            float r6 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.left
            float r7 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.bottom
            float r8 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.left
            float r9 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.top
            float r10 = (float) r1
            r1 = r31
            r1.setMatrixArray(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            goto L_0x03b4
        L_0x0329:
            int r1 = r31.getRequiredRotation()
            if (r1 != r13) goto L_0x036f
            float[] r2 = r11.dstArray
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.right
            float r3 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.bottom
            float r4 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.left
            float r5 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.bottom
            float r6 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.left
            float r7 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.top
            float r8 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.right
            float r9 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.top
            float r10 = (float) r1
            r1 = r31
            r1.setMatrixArray(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            goto L_0x03b4
        L_0x036f:
            int r1 = r31.getRequiredRotation()
            if (r1 != r15) goto L_0x03b4
            float[] r2 = r11.dstArray
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.left
            float r3 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.bottom
            float r4 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.left
            float r5 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.top
            float r6 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.right
            float r7 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.top
            float r8 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.right
            float r9 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.bottom
            float r10 = (float) r1
            r1 = r31
            r1.setMatrixArray(r2, r3, r4, r5, r6, r7, r8, r9, r10)
        L_0x03b4:
            android.graphics.Matrix r1 = r11.matrix
            float[] r2 = r11.srcArray
            r27 = 0
            float[] r3 = r11.dstArray
            r29 = 0
            r30 = 4
            r25 = r1
            r26 = r2
            r28 = r3
            r25.setPolyToPoly(r26, r27, r28, r29, r30)
            android.graphics.Bitmap r1 = r19.bitmap
            android.graphics.Matrix r2 = r11.matrix
            android.graphics.Paint r3 = r11.bitmapPaint
            r12.drawBitmap(r1, r2, r3)
            boolean r1 = r11.debug
            if (r1 == 0) goto L_0x0411
            android.graphics.Rect r1 = r19.vRect
            android.graphics.Paint r2 = r11.debugLinePaint
            r12.drawRect(r1, r2)
            goto L_0x0411
        L_0x03e2:
            r13 = r7
            r14 = r8
            boolean r1 = r19.loading
            if (r1 == 0) goto L_0x0411
            boolean r1 = r11.debug
            if (r1 == 0) goto L_0x0411
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.left
            r2 = 5
            int r3 = r11.px(r2)
            int r1 = r1 + r3
            float r1 = (float) r1
            android.graphics.Rect r2 = r19.vRect
            int r2 = r2.top
            r3 = 35
            int r4 = r11.px(r3)
            int r2 = r2 + r4
            float r2 = (float) r2
            android.graphics.Paint r4 = r11.debugTextPaint
            java.lang.String r5 = "LOADING"
            r12.drawText(r5, r1, r2, r4)
            goto L_0x0413
        L_0x0411:
            r3 = 35
        L_0x0413:
            boolean r1 = r19.visible
            if (r1 == 0) goto L_0x0487
            boolean r1 = r11.debug
            if (r1 == 0) goto L_0x0487
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "ISS "
            r1.append(r2)
            int r2 = r19.sampleSize
            r1.append(r2)
            java.lang.String r2 = " RECT "
            r1.append(r2)
            android.graphics.Rect r2 = r19.sRect
            int r2 = r2.top
            r1.append(r2)
            java.lang.String r2 = ","
            r1.append(r2)
            android.graphics.Rect r4 = r19.sRect
            int r4 = r4.left
            r1.append(r4)
            r1.append(r2)
            android.graphics.Rect r4 = r19.sRect
            int r4 = r4.bottom
            r1.append(r4)
            r1.append(r2)
            android.graphics.Rect r2 = r19.sRect
            int r2 = r2.right
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.graphics.Rect r2 = r19.vRect
            int r2 = r2.left
            r4 = 5
            int r5 = r11.px(r4)
            int r2 = r2 + r5
            float r2 = (float) r2
            android.graphics.Rect r4 = r19.vRect
            int r4 = r4.top
            r5 = 15
            int r6 = r11.px(r5)
            int r4 = r4 + r6
            float r4 = (float) r4
            android.graphics.Paint r6 = r11.debugTextPaint
            r12.drawText(r1, r2, r4, r6)
            goto L_0x0489
        L_0x0487:
            r5 = 15
        L_0x0489:
            r10 = r3
            r7 = r13
            r8 = r14
            goto L_0x0212
        L_0x048e:
            r10 = r3
            r7 = r13
            r8 = r14
            goto L_0x01e6
        L_0x0493:
            r3 = r10
            r5 = 15
            goto L_0x056b
        L_0x0498:
            r13 = r7
            r14 = r8
            r3 = r10
            r5 = 15
            android.graphics.Bitmap r0 = r11.bitmap
            if (r0 == 0) goto L_0x056b
            float r1 = r11.scale
            boolean r2 = r11.bitmapIsPreview
            if (r2 == 0) goto L_0x04c0
            int r2 = r11.sWidth
            float r2 = (float) r2
            int r0 = r0.getWidth()
            float r0 = (float) r0
            float r2 = r2 / r0
            float r1 = r1 * r2
            float r0 = r11.scale
            int r2 = r11.sHeight
            float r2 = (float) r2
            android.graphics.Bitmap r4 = r11.bitmap
            int r4 = r4.getHeight()
            float r4 = (float) r4
            float r2 = r2 / r4
            float r0 = r0 * r2
            goto L_0x04c1
        L_0x04c0:
            r0 = r1
        L_0x04c1:
            android.graphics.Matrix r2 = r11.matrix
            if (r2 != 0) goto L_0x04cc
            android.graphics.Matrix r2 = new android.graphics.Matrix
            r2.<init>()
            r11.matrix = r2
        L_0x04cc:
            android.graphics.Matrix r2 = r11.matrix
            r2.reset()
            android.graphics.Matrix r2 = r11.matrix
            r2.postScale(r1, r0)
            android.graphics.Matrix r0 = r11.matrix
            int r1 = r31.getRequiredRotation()
            float r1 = (float) r1
            r0.postRotate(r1)
            android.graphics.Matrix r0 = r11.matrix
            android.graphics.PointF r1 = r11.vTranslate
            float r2 = r1.x
            float r1 = r1.y
            r0.postTranslate(r2, r1)
            int r0 = r31.getRequiredRotation()
            if (r0 != r13) goto L_0x0501
            android.graphics.Matrix r0 = r11.matrix
            float r1 = r11.scale
            int r2 = r11.sWidth
            float r2 = (float) r2
            float r2 = r2 * r1
            int r4 = r11.sHeight
            float r4 = (float) r4
            float r1 = r1 * r4
            r0.postTranslate(r2, r1)
            goto L_0x0524
        L_0x0501:
            int r0 = r31.getRequiredRotation()
            if (r0 != r14) goto L_0x0513
            android.graphics.Matrix r0 = r11.matrix
            float r1 = r11.scale
            int r2 = r11.sHeight
            float r2 = (float) r2
            float r1 = r1 * r2
            r0.postTranslate(r1, r9)
            goto L_0x0524
        L_0x0513:
            int r0 = r31.getRequiredRotation()
            if (r0 != r15) goto L_0x0524
            android.graphics.Matrix r0 = r11.matrix
            float r1 = r11.scale
            int r2 = r11.sWidth
            float r2 = (float) r2
            float r1 = r1 * r2
            r0.postTranslate(r9, r1)
        L_0x0524:
            android.graphics.Paint r0 = r11.tileBgPaint
            if (r0 == 0) goto L_0x0562
            android.graphics.RectF r0 = r11.sRect
            if (r0 != 0) goto L_0x0533
            android.graphics.RectF r0 = new android.graphics.RectF
            r0.<init>()
            r11.sRect = r0
        L_0x0533:
            android.graphics.RectF r0 = r11.sRect
            boolean r1 = r11.bitmapIsPreview
            if (r1 == 0) goto L_0x0540
            android.graphics.Bitmap r1 = r11.bitmap
            int r1 = r1.getWidth()
            goto L_0x0542
        L_0x0540:
            int r1 = r11.sWidth
        L_0x0542:
            float r1 = (float) r1
            boolean r2 = r11.bitmapIsPreview
            if (r2 == 0) goto L_0x054e
            android.graphics.Bitmap r2 = r11.bitmap
            int r2 = r2.getHeight()
            goto L_0x0550
        L_0x054e:
            int r2 = r11.sHeight
        L_0x0550:
            float r2 = (float) r2
            r0.set(r9, r9, r1, r2)
            android.graphics.Matrix r0 = r11.matrix
            android.graphics.RectF r1 = r11.sRect
            r0.mapRect(r1)
            android.graphics.RectF r0 = r11.sRect
            android.graphics.Paint r1 = r11.tileBgPaint
            r12.drawRect(r0, r1)
        L_0x0562:
            android.graphics.Bitmap r0 = r11.bitmap
            android.graphics.Matrix r1 = r11.matrix
            android.graphics.Paint r2 = r11.bitmapPaint
            r12.drawBitmap(r0, r1, r2)
        L_0x056b:
            boolean r0 = r11.debug
            if (r0 == 0) goto L_0x074f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Scale: "
            r0.append(r1)
            java.util.Locale r1 = java.util.Locale.ENGLISH
            r2 = 1
            java.lang.Object[] r4 = new java.lang.Object[r2]
            float r6 = r11.scale
            java.lang.Float r6 = java.lang.Float.valueOf(r6)
            r7 = 0
            r4[r7] = r6
            java.lang.String r6 = "%.2f"
            java.lang.String r4 = java.lang.String.format(r1, r6, r4)
            r0.append(r4)
            java.lang.String r4 = " ("
            r0.append(r4)
            java.lang.Object[] r4 = new java.lang.Object[r2]
            float r8 = r31.minScale()
            java.lang.Float r8 = java.lang.Float.valueOf(r8)
            r4[r7] = r8
            java.lang.String r4 = java.lang.String.format(r1, r6, r4)
            r0.append(r4)
            java.lang.String r4 = " - "
            r0.append(r4)
            java.lang.Object[] r4 = new java.lang.Object[r2]
            float r2 = r11.maxScale
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r4[r7] = r2
            java.lang.String r2 = java.lang.String.format(r1, r6, r4)
            r0.append(r2)
            java.lang.String r2 = ")"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r2 = 5
            int r4 = r11.px(r2)
            float r2 = (float) r4
            int r4 = r11.px(r5)
            float r4 = (float) r4
            android.graphics.Paint r5 = r11.debugTextPaint
            r12.drawText(r0, r2, r4, r5)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Translate: "
            r0.append(r2)
            r2 = 1
            java.lang.Object[] r4 = new java.lang.Object[r2]
            android.graphics.PointF r5 = r11.vTranslate
            float r5 = r5.x
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            r7 = 0
            r4[r7] = r5
            java.lang.String r4 = java.lang.String.format(r1, r6, r4)
            r0.append(r4)
            java.lang.String r4 = ":"
            r0.append(r4)
            java.lang.Object[] r5 = new java.lang.Object[r2]
            android.graphics.PointF r2 = r11.vTranslate
            float r2 = r2.y
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r5[r7] = r2
            java.lang.String r2 = java.lang.String.format(r1, r6, r5)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r2 = 5
            int r5 = r11.px(r2)
            float r2 = (float) r5
            r5 = 30
            int r7 = r11.px(r5)
            float r7 = (float) r7
            android.graphics.Paint r8 = r11.debugTextPaint
            r12.drawText(r0, r2, r7, r8)
            android.graphics.PointF r0 = r31.getCenter()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r7 = "Source center: "
            r2.append(r7)
            r7 = 1
            java.lang.Object[] r8 = new java.lang.Object[r7]
            float r9 = r0.x
            java.lang.Float r9 = java.lang.Float.valueOf(r9)
            r10 = 0
            r8[r10] = r9
            java.lang.String r8 = java.lang.String.format(r1, r6, r8)
            r2.append(r8)
            r2.append(r4)
            java.lang.Object[] r4 = new java.lang.Object[r7]
            float r0 = r0.y
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            r4[r10] = r0
            java.lang.String r0 = java.lang.String.format(r1, r6, r4)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1 = 5
            int r1 = r11.px(r1)
            float r1 = (float) r1
            r2 = 45
            int r2 = r11.px(r2)
            float r2 = (float) r2
            android.graphics.Paint r4 = r11.debugTextPaint
            r12.drawText(r0, r1, r2, r4)
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r0 = r11.anim
            r1 = -16711681(0xffffffffff00ffff, float:-1.714704E38)
            r2 = -16776961(0xffffffffff0000ff, float:-1.7014636E38)
            r4 = 20
            r6 = -65536(0xffffffffffff0000, float:NaN)
            if (r0 == 0) goto L_0x06ee
            android.graphics.PointF r0 = r0.sCenterStart
            android.graphics.PointF r0 = r11.sourceToViewCoord(r0)
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r7 = r11.anim
            android.graphics.PointF r7 = r7.sCenterEndRequested
            android.graphics.PointF r7 = r11.sourceToViewCoord(r7)
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r8 = r11.anim
            android.graphics.PointF r8 = r8.sCenterEnd
            android.graphics.PointF r8 = r11.sourceToViewCoord(r8)
            float r9 = r0.x
            float r0 = r0.y
            r10 = 10
            int r10 = r11.px(r10)
            float r10 = (float) r10
            android.graphics.Paint r13 = r11.debugLinePaint
            r12.drawCircle(r9, r0, r10, r13)
            android.graphics.Paint r0 = r11.debugLinePaint
            r0.setColor(r6)
            float r0 = r7.x
            float r7 = r7.y
            int r9 = r11.px(r4)
            float r9 = (float) r9
            android.graphics.Paint r10 = r11.debugLinePaint
            r12.drawCircle(r0, r7, r9, r10)
            android.graphics.Paint r0 = r11.debugLinePaint
            r0.setColor(r2)
            float r0 = r8.x
            float r7 = r8.y
            r8 = 25
            int r8 = r11.px(r8)
            float r8 = (float) r8
            android.graphics.Paint r9 = r11.debugLinePaint
            r12.drawCircle(r0, r7, r8, r9)
            android.graphics.Paint r0 = r11.debugLinePaint
            r0.setColor(r1)
            int r0 = r31.getWidth()
            int r0 = r0 / 2
            float r0 = (float) r0
            int r7 = r31.getHeight()
            int r7 = r7 / 2
            float r7 = (float) r7
            int r8 = r11.px(r5)
            float r8 = (float) r8
            android.graphics.Paint r9 = r11.debugLinePaint
            r12.drawCircle(r0, r7, r8, r9)
        L_0x06ee:
            android.graphics.PointF r0 = r11.vCenterStart
            if (r0 == 0) goto L_0x0707
            android.graphics.Paint r0 = r11.debugLinePaint
            r0.setColor(r6)
            android.graphics.PointF r0 = r11.vCenterStart
            float r6 = r0.x
            float r0 = r0.y
            int r4 = r11.px(r4)
            float r4 = (float) r4
            android.graphics.Paint r7 = r11.debugLinePaint
            r12.drawCircle(r6, r0, r4, r7)
        L_0x0707:
            android.graphics.PointF r0 = r11.quickScaleSCenter
            if (r0 == 0) goto L_0x072a
            android.graphics.Paint r0 = r11.debugLinePaint
            r0.setColor(r2)
            android.graphics.PointF r0 = r11.quickScaleSCenter
            float r0 = r0.x
            float r0 = r11.sourceToViewX(r0)
            android.graphics.PointF r2 = r11.quickScaleSCenter
            float r2 = r2.y
            float r2 = r11.sourceToViewY(r2)
            int r3 = r11.px(r3)
            float r3 = (float) r3
            android.graphics.Paint r4 = r11.debugLinePaint
            r12.drawCircle(r0, r2, r3, r4)
        L_0x072a:
            android.graphics.PointF r0 = r11.quickScaleVStart
            if (r0 == 0) goto L_0x0747
            boolean r0 = r11.isQuickScaling
            if (r0 == 0) goto L_0x0747
            android.graphics.Paint r0 = r11.debugLinePaint
            r0.setColor(r1)
            android.graphics.PointF r0 = r11.quickScaleVStart
            float r1 = r0.x
            float r0 = r0.y
            int r2 = r11.px(r5)
            float r2 = (float) r2
            android.graphics.Paint r3 = r11.debugLinePaint
            r12.drawCircle(r1, r0, r2, r3)
        L_0x0747:
            android.graphics.Paint r0 = r11.debugLinePaint
            r1 = -65281(0xffffffffffff00ff, float:NaN)
            r0.setColor(r1)
        L_0x074f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.onDraw(android.graphics.Canvas):void");
    }

    public void onImageLoaded() {
    }

    public void onMeasure(int i11, int i12) {
        int mode = View.MeasureSpec.getMode(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        int size = View.MeasureSpec.getSize(i11);
        int size2 = View.MeasureSpec.getSize(i12);
        boolean z11 = true;
        boolean z12 = mode != 1073741824;
        if (mode2 == 1073741824) {
            z11 = false;
        }
        if (this.sWidth > 0 && this.sHeight > 0) {
            if (z12 && z11) {
                size = sWidth();
                size2 = sHeight();
            } else if (z11) {
                size2 = (int) ((((double) sHeight()) / ((double) sWidth())) * ((double) size));
            } else if (z12) {
                size = (int) ((((double) sWidth()) / ((double) sHeight())) * ((double) size2));
            }
        }
        setMeasuredDimension(Math.max(size, getSuggestedMinimumWidth()), Math.max(size2, getSuggestedMinimumHeight()));
    }

    public void onReady() {
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        debug("onSizeChanged %dx%d -> %dx%d", Integer.valueOf(i13), Integer.valueOf(i14), Integer.valueOf(i11), Integer.valueOf(i12));
        PointF center = getCenter();
        if (this.readySent && center != null) {
            this.anim = null;
            this.pendingScale = Float.valueOf(this.scale);
            this.sPendingCenter = center;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        GestureDetector gestureDetector;
        Anim anim2 = this.anim;
        if (anim2 == null || anim2.interruptible) {
            Anim anim3 = this.anim;
            if (!(anim3 == null || anim3.listener == null)) {
                try {
                    this.anim.listener.onInterruptedByUser();
                } catch (Exception e11) {
                    Log.w(TAG, "Error thrown by animation listener", e11);
                }
            }
            this.anim = null;
            if (this.vTranslate == null) {
                GestureDetector gestureDetector2 = this.singleDetector;
                if (gestureDetector2 != null) {
                    gestureDetector2.onTouchEvent(motionEvent);
                }
                return true;
            } else if (this.isQuickScaling || ((gestureDetector = this.detector) != null && !gestureDetector.onTouchEvent(motionEvent))) {
                if (this.vTranslateStart == null) {
                    this.vTranslateStart = new PointF(0.0f, 0.0f);
                }
                if (this.vTranslateBefore == null) {
                    this.vTranslateBefore = new PointF(0.0f, 0.0f);
                }
                if (this.vCenterStart == null) {
                    this.vCenterStart = new PointF(0.0f, 0.0f);
                }
                float f11 = this.scale;
                this.vTranslateBefore.set(this.vTranslate);
                boolean onTouchEventInternal = onTouchEventInternal(motionEvent);
                sendStateChanged(f11, this.vTranslateBefore, 2);
                if (onTouchEventInternal || super.onTouchEvent(motionEvent)) {
                    return true;
                }
                return false;
            } else {
                this.isZooming = false;
                this.isPanning = false;
                this.maxTouchCount = 0;
                return true;
            }
        } else {
            requestDisallowInterceptTouchEvent(true);
            return true;
        }
    }

    public void recycle() {
        reset(true);
        this.bitmapPaint = null;
        this.debugTextPaint = null;
        this.debugLinePaint = null;
        this.tileBgPaint = null;
    }

    public final void resetScaleAndCenter() {
        this.anim = null;
        this.pendingScale = Float.valueOf(limitedScale(0.0f));
        if (isReady()) {
            this.sPendingCenter = new PointF((float) (sWidth() / 2), (float) (sHeight() / 2));
        } else {
            this.sPendingCenter = new PointF(0.0f, 0.0f);
        }
        invalidate();
    }

    public final void setBitmapDecoderClass(Class<? extends ImageDecoder> cls) {
        if (cls != null) {
            this.bitmapDecoderFactory = new CompatDecoderFactory(cls);
            return;
        }
        throw new IllegalArgumentException("Decoder class cannot be set to null");
    }

    public final void setBitmapDecoderFactory(DecoderFactory<? extends ImageDecoder> decoderFactory) {
        if (decoderFactory != null) {
            this.bitmapDecoderFactory = decoderFactory;
            return;
        }
        throw new IllegalArgumentException("Decoder factory cannot be set to null");
    }

    public final void setDebug(boolean z11) {
        this.debug = z11;
    }

    public final void setDoubleTapZoomDpi(int i11) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setDoubleTapZoomScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / ((float) i11));
    }

    public final void setDoubleTapZoomDuration(int i11) {
        this.doubleTapZoomDuration = Math.max(0, i11);
    }

    public final void setDoubleTapZoomScale(float f11) {
        this.doubleTapZoomScale = f11;
    }

    public final void setDoubleTapZoomStyle(int i11) {
        if (VALID_ZOOM_STYLES.contains(Integer.valueOf(i11))) {
            this.doubleTapZoomStyle = i11;
            return;
        }
        throw new IllegalArgumentException("Invalid zoom style: " + i11);
    }

    public void setEagerLoadingEnabled(boolean z11) {
        this.eagerLoadingEnabled = z11;
    }

    public void setExecutor(Executor executor2) {
        Objects.requireNonNull(executor2, "Executor must not be null");
        this.executor = executor2;
    }

    public final void setImage(ImageSource imageSource) {
        setImage(imageSource, (ImageSource) null, (ImageViewState) null);
    }

    public final void setMaxScale(float f11) {
        this.maxScale = f11;
    }

    public void setMaxTileSize(int i11) {
        this.maxTileWidth = i11;
        this.maxTileHeight = i11;
    }

    public final void setMaximumDpi(int i11) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMinScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / ((float) i11));
    }

    public final void setMinScale(float f11) {
        this.minScale = f11;
    }

    public final void setMinimumDpi(int i11) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMaxScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / ((float) i11));
    }

    public final void setMinimumScaleType(int i11) {
        if (VALID_SCALE_TYPES.contains(Integer.valueOf(i11))) {
            this.minimumScaleType = i11;
            if (isReady()) {
                fitToBounds(true);
                invalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid scale type: " + i11);
    }

    public void setMinimumTileDpi(int i11) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.minimumTileDpi = (int) Math.min((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f, (float) i11);
        if (isReady()) {
            reset(false);
            invalidate();
        }
    }

    public void setOnImageEventListener(OnImageEventListener onImageEventListener2) {
        this.onImageEventListener = onImageEventListener2;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener2) {
        this.onLongClickListener = onLongClickListener2;
    }

    public void setOnStateChangedListener(OnStateChangedListener onStateChangedListener2) {
        this.onStateChangedListener = onStateChangedListener2;
    }

    public final void setOrientation(int i11) {
        if (VALID_ORIENTATIONS.contains(Integer.valueOf(i11))) {
            this.orientation = i11;
            reset(false);
            invalidate();
            requestLayout();
            return;
        }
        throw new IllegalArgumentException("Invalid orientation: " + i11);
    }

    public final void setPanEnabled(boolean z11) {
        PointF pointF;
        this.panEnabled = z11;
        if (!z11 && (pointF = this.vTranslate) != null) {
            pointF.x = ((float) (getWidth() / 2)) - (this.scale * ((float) (sWidth() / 2)));
            this.vTranslate.y = ((float) (getHeight() / 2)) - (this.scale * ((float) (sHeight() / 2)));
            if (isReady()) {
                refreshRequiredTiles(true);
                invalidate();
            }
        }
    }

    public final void setPanLimit(int i11) {
        if (VALID_PAN_LIMITS.contains(Integer.valueOf(i11))) {
            this.panLimit = i11;
            if (isReady()) {
                fitToBounds(true);
                invalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid pan limit: " + i11);
    }

    public final void setQuickScaleEnabled(boolean z11) {
        this.quickScaleEnabled = z11;
    }

    public final void setRegionDecoderClass(Class<? extends ImageRegionDecoder> cls) {
        if (cls != null) {
            this.regionDecoderFactory = new CompatDecoderFactory(cls);
            return;
        }
        throw new IllegalArgumentException("Decoder class cannot be set to null");
    }

    public final void setRegionDecoderFactory(DecoderFactory<? extends ImageRegionDecoder> decoderFactory) {
        if (decoderFactory != null) {
            this.regionDecoderFactory = decoderFactory;
            return;
        }
        throw new IllegalArgumentException("Decoder factory cannot be set to null");
    }

    public final void setScaleAndCenter(float f11, PointF pointF) {
        this.anim = null;
        this.pendingScale = Float.valueOf(f11);
        this.sPendingCenter = pointF;
        this.sRequestedCenter = pointF;
        invalidate();
    }

    public final void setTileBackgroundColor(int i11) {
        if (Color.alpha(i11) == 0) {
            this.tileBgPaint = null;
        } else {
            Paint paint = new Paint();
            this.tileBgPaint = paint;
            paint.setStyle(Paint.Style.FILL);
            this.tileBgPaint.setColor(i11);
        }
        invalidate();
    }

    public final void setZoomEnabled(boolean z11) {
        this.zoomEnabled = z11;
    }

    public final PointF sourceToViewCoord(PointF pointF) {
        return sourceToViewCoord(pointF.x, pointF.y, new PointF());
    }

    public void viewToFileRect(Rect rect, Rect rect2) {
        if (this.vTranslate != null && this.readySent) {
            rect2.set((int) viewToSourceX((float) rect.left), (int) viewToSourceY((float) rect.top), (int) viewToSourceX((float) rect.right), (int) viewToSourceY((float) rect.bottom));
            fileSRect(rect2, rect2);
            rect2.set(Math.max(0, rect2.left), Math.max(0, rect2.top), Math.min(this.sWidth, rect2.right), Math.min(this.sHeight, rect2.bottom));
            Rect rect3 = this.sRegion;
            if (rect3 != null) {
                rect2.offset(rect3.left, rect3.top);
            }
        }
    }

    public final PointF viewToSourceCoord(PointF pointF) {
        return viewToSourceCoord(pointF.x, pointF.y, new PointF());
    }

    public void visibleFileRect(Rect rect) {
        if (this.vTranslate != null && this.readySent) {
            rect.set(0, 0, getWidth(), getHeight());
            viewToFileRect(rect, rect);
        }
    }

    public final void setImage(ImageSource imageSource, ImageViewState imageViewState) {
        setImage(imageSource, (ImageSource) null, imageViewState);
    }

    public final PointF sourceToViewCoord(float f11, float f12) {
        return sourceToViewCoord(f11, f12, new PointF());
    }

    public final PointF viewToSourceCoord(float f11, float f12) {
        return viewToSourceCoord(f11, f12, new PointF());
    }

    public final void setImage(ImageSource imageSource, ImageSource imageSource2) {
        setImage(imageSource, imageSource2, (ImageViewState) null);
    }

    public void setMaxTileSize(int i11, int i12) {
        this.maxTileWidth = i11;
        this.maxTileHeight = i12;
    }

    public final PointF sourceToViewCoord(PointF pointF, PointF pointF2) {
        return sourceToViewCoord(pointF.x, pointF.y, pointF2);
    }

    public final PointF viewToSourceCoord(PointF pointF, PointF pointF2) {
        return viewToSourceCoord(pointF.x, pointF.y, pointF2);
    }

    public final class AnimationBuilder {
        private long duration;
        private int easing;
        private boolean interruptible;
        private OnAnimationEventListener listener;
        private int origin;
        private boolean panLimited;
        private final PointF targetSCenter;
        private final float targetScale;
        private final PointF vFocus;

        /* access modifiers changed from: private */
        public AnimationBuilder withOrigin(int i11) {
            this.origin = i11;
            return this;
        }

        /* access modifiers changed from: private */
        public AnimationBuilder withPanLimited(boolean z11) {
            this.panLimited = z11;
            return this;
        }

        public void start() {
            PointF pointF;
            if (!(SubsamplingScaleImageView.this.anim == null || SubsamplingScaleImageView.this.anim.listener == null)) {
                try {
                    SubsamplingScaleImageView.this.anim.listener.onInterruptedByNewAnim();
                } catch (Exception e11) {
                    Log.w(SubsamplingScaleImageView.TAG, "Error thrown by animation listener", e11);
                }
            }
            int paddingLeft = SubsamplingScaleImageView.this.getPaddingLeft() + (((SubsamplingScaleImageView.this.getWidth() - SubsamplingScaleImageView.this.getPaddingRight()) - SubsamplingScaleImageView.this.getPaddingLeft()) / 2);
            int paddingTop = SubsamplingScaleImageView.this.getPaddingTop() + (((SubsamplingScaleImageView.this.getHeight() - SubsamplingScaleImageView.this.getPaddingBottom()) - SubsamplingScaleImageView.this.getPaddingTop()) / 2);
            float access$6500 = SubsamplingScaleImageView.this.limitedScale(this.targetScale);
            if (this.panLimited) {
                SubsamplingScaleImageView subsamplingScaleImageView = SubsamplingScaleImageView.this;
                PointF pointF2 = this.targetSCenter;
                pointF = subsamplingScaleImageView.limitedSCenter(pointF2.x, pointF2.y, access$6500, new PointF());
            } else {
                pointF = this.targetSCenter;
            }
            Anim unused = SubsamplingScaleImageView.this.anim = new Anim();
            float unused2 = SubsamplingScaleImageView.this.anim.scaleStart = SubsamplingScaleImageView.this.scale;
            float unused3 = SubsamplingScaleImageView.this.anim.scaleEnd = access$6500;
            long unused4 = SubsamplingScaleImageView.this.anim.time = System.currentTimeMillis();
            PointF unused5 = SubsamplingScaleImageView.this.anim.sCenterEndRequested = pointF;
            PointF unused6 = SubsamplingScaleImageView.this.anim.sCenterStart = SubsamplingScaleImageView.this.getCenter();
            PointF unused7 = SubsamplingScaleImageView.this.anim.sCenterEnd = pointF;
            PointF unused8 = SubsamplingScaleImageView.this.anim.vFocusStart = SubsamplingScaleImageView.this.sourceToViewCoord(pointF);
            PointF unused9 = SubsamplingScaleImageView.this.anim.vFocusEnd = new PointF((float) paddingLeft, (float) paddingTop);
            long unused10 = SubsamplingScaleImageView.this.anim.duration = this.duration;
            boolean unused11 = SubsamplingScaleImageView.this.anim.interruptible = this.interruptible;
            int unused12 = SubsamplingScaleImageView.this.anim.easing = this.easing;
            int unused13 = SubsamplingScaleImageView.this.anim.origin = this.origin;
            long unused14 = SubsamplingScaleImageView.this.anim.time = System.currentTimeMillis();
            OnAnimationEventListener unused15 = SubsamplingScaleImageView.this.anim.listener = this.listener;
            PointF pointF3 = this.vFocus;
            if (pointF3 != null) {
                float f11 = pointF3.x - (SubsamplingScaleImageView.this.anim.sCenterStart.x * access$6500);
                float f12 = this.vFocus.y - (SubsamplingScaleImageView.this.anim.sCenterStart.y * access$6500);
                ScaleAndTranslate scaleAndTranslate = new ScaleAndTranslate(access$6500, new PointF(f11, f12));
                SubsamplingScaleImageView.this.fitToBounds(true, scaleAndTranslate);
                PointF unused16 = SubsamplingScaleImageView.this.anim.vFocusEnd = new PointF(this.vFocus.x + (scaleAndTranslate.vTranslate.x - f11), this.vFocus.y + (scaleAndTranslate.vTranslate.y - f12));
            }
            SubsamplingScaleImageView.this.invalidate();
        }

        public AnimationBuilder withDuration(long j11) {
            this.duration = j11;
            return this;
        }

        public AnimationBuilder withEasing(int i11) {
            if (SubsamplingScaleImageView.VALID_EASING_STYLES.contains(Integer.valueOf(i11))) {
                this.easing = i11;
                return this;
            }
            throw new IllegalArgumentException("Unknown easing type: " + i11);
        }

        public AnimationBuilder withInterruptible(boolean z11) {
            this.interruptible = z11;
            return this;
        }

        public AnimationBuilder withOnAnimationEventListener(OnAnimationEventListener onAnimationEventListener) {
            this.listener = onAnimationEventListener;
            return this;
        }

        private AnimationBuilder(PointF pointF) {
            this.duration = 500;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = SubsamplingScaleImageView.this.scale;
            this.targetSCenter = pointF;
            this.vFocus = null;
        }

        private AnimationBuilder(float f11) {
            this.duration = 500;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = f11;
            this.targetSCenter = SubsamplingScaleImageView.this.getCenter();
            this.vFocus = null;
        }

        private AnimationBuilder(float f11, PointF pointF) {
            this.duration = 500;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = f11;
            this.targetSCenter = pointF;
            this.vFocus = null;
        }

        private AnimationBuilder(float f11, PointF pointF, PointF pointF2) {
            this.duration = 500;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = f11;
            this.targetSCenter = pointF;
            this.vFocus = pointF2;
        }
    }

    public final void setImage(ImageSource imageSource, ImageSource imageSource2, ImageViewState imageViewState) {
        Objects.requireNonNull(imageSource, "imageSource must not be null");
        reset(true);
        if (imageViewState != null) {
            restoreState(imageViewState);
        }
        if (imageSource2 != null) {
            if (imageSource.getBitmap() != null) {
                throw new IllegalArgumentException("Preview image cannot be used when a bitmap is provided for the main image");
            } else if (imageSource.getSWidth() <= 0 || imageSource.getSHeight() <= 0) {
                throw new IllegalArgumentException("Preview image cannot be used unless dimensions are provided for the main image");
            } else {
                this.sWidth = imageSource.getSWidth();
                this.sHeight = imageSource.getSHeight();
                this.pRegion = imageSource2.getSRegion();
                if (imageSource2.getBitmap() != null) {
                    this.bitmapIsCached = imageSource2.isCached();
                    onPreviewLoaded(imageSource2.getBitmap());
                } else {
                    Uri uri2 = imageSource2.getUri();
                    if (uri2 == null && imageSource2.getResource() != null) {
                        uri2 = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + imageSource2.getResource());
                    }
                    execute(new BitmapLoadTask(this, getContext(), this.bitmapDecoderFactory, uri2, true));
                }
            }
        }
        if (imageSource.getBitmap() != null && imageSource.getSRegion() != null) {
            onImageLoaded(Bitmap.createBitmap(imageSource.getBitmap(), imageSource.getSRegion().left, imageSource.getSRegion().top, imageSource.getSRegion().width(), imageSource.getSRegion().height()), 0, false);
        } else if (imageSource.getBitmap() != null) {
            onImageLoaded(imageSource.getBitmap(), 0, imageSource.isCached());
        } else {
            this.sRegion = imageSource.getSRegion();
            Uri uri3 = imageSource.getUri();
            this.uri = uri3;
            if (uri3 == null && imageSource.getResource() != null) {
                this.uri = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + imageSource.getResource());
            }
            if (imageSource.getTile() || this.sRegion != null) {
                execute(new TilesInitTask(this, getContext(), this.regionDecoderFactory, this.uri));
                return;
            }
            execute(new BitmapLoadTask(this, getContext(), this.bitmapDecoderFactory, this.uri, false));
        }
    }

    public final PointF sourceToViewCoord(float f11, float f12, PointF pointF) {
        if (this.vTranslate == null) {
            return null;
        }
        pointF.set(sourceToViewX(f11), sourceToViewY(f12));
        return pointF;
    }

    public final PointF viewToSourceCoord(float f11, float f12, PointF pointF) {
        if (this.vTranslate == null) {
            return null;
        }
        pointF.set(viewToSourceX(f11), viewToSourceY(f12));
        return pointF;
    }

    private void fitToBounds(boolean z11) {
        boolean z12;
        if (this.vTranslate == null) {
            z12 = true;
            this.vTranslate = new PointF(0.0f, 0.0f);
        } else {
            z12 = false;
        }
        if (this.satTemp == null) {
            this.satTemp = new ScaleAndTranslate(0.0f, new PointF(0.0f, 0.0f));
        }
        float unused = this.satTemp.scale = this.scale;
        this.satTemp.vTranslate.set(this.vTranslate);
        fitToBounds(z11, this.satTemp);
        this.scale = this.satTemp.scale;
        this.vTranslate.set(this.satTemp.vTranslate);
        if (z12 && this.minimumScaleType != 4) {
            this.vTranslate.set(vTranslateForSCenter((float) (sWidth() / 2), (float) (sHeight() / 2), this.scale));
        }
    }

    public SubsamplingScaleImageView(Context context) {
        this(context, (AttributeSet) null);
    }
}
