package io.flutter.embedding.android;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.hardware.HardwareBuffer;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;
import io.flutter.Log;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.renderer.RenderSurface;
import java.nio.ByteBuffer;
import java.util.Locale;

@TargetApi(19)
public class FlutterImageView extends View implements RenderSurface {
    private static final String TAG = "FlutterImageView";
    private Bitmap currentBitmap;
    private Image currentImage;
    private FlutterRenderer flutterRenderer;
    private ImageReader imageReader;
    private boolean isAttachedToFlutterRenderer;
    private SurfaceKind kind;

    /* renamed from: io.flutter.embedding.android.FlutterImageView$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$android$FlutterImageView$SurfaceKind;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                io.flutter.embedding.android.FlutterImageView$SurfaceKind[] r0 = io.flutter.embedding.android.FlutterImageView.SurfaceKind.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$flutter$embedding$android$FlutterImageView$SurfaceKind = r0
                io.flutter.embedding.android.FlutterImageView$SurfaceKind r1 = io.flutter.embedding.android.FlutterImageView.SurfaceKind.background     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$flutter$embedding$android$FlutterImageView$SurfaceKind     // Catch:{ NoSuchFieldError -> 0x001d }
                io.flutter.embedding.android.FlutterImageView$SurfaceKind r1 = io.flutter.embedding.android.FlutterImageView.SurfaceKind.overlay     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.android.FlutterImageView.AnonymousClass1.<clinit>():void");
        }
    }

    public enum SurfaceKind {
        background,
        overlay
    }

    public FlutterImageView(Context context, int i11, int i12, SurfaceKind surfaceKind) {
        this(context, createImageReader(i11, i12), surfaceKind);
    }

    private void closeCurrentImage() {
        Image image = this.currentImage;
        if (image != null) {
            image.close();
            this.currentImage = null;
        }
    }

    @SuppressLint({"WrongConstant"})
    @TargetApi(19)
    private static ImageReader createImageReader(int i11, int i12) {
        int i13;
        int i14;
        if (i11 <= 0) {
            logW("ImageReader width must be greater than 0, but given width=%d, set width=1", Integer.valueOf(i11));
            i13 = 1;
        } else {
            i13 = i11;
        }
        if (i12 <= 0) {
            logW("ImageReader height must be greater than 0, but given height=%d, set height=1", Integer.valueOf(i12));
            i14 = 1;
        } else {
            i14 = i12;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return ImageReader.newInstance(i13, i14, 1, 3, 768);
        }
        return ImageReader.newInstance(i13, i14, 1, 3);
    }

    private void init() {
        setAlpha(0.0f);
    }

    private static void logW(String str, Object... objArr) {
        Log.w(TAG, String.format(Locale.US, str, objArr));
    }

    @TargetApi(29)
    private void updateCurrentBitmap() {
        if (Build.VERSION.SDK_INT >= 29) {
            HardwareBuffer hardwareBuffer = this.currentImage.getHardwareBuffer();
            this.currentBitmap = Bitmap.wrapHardwareBuffer(hardwareBuffer, ColorSpace.get(ColorSpace.Named.SRGB));
            hardwareBuffer.close();
            return;
        }
        Image.Plane[] planes = this.currentImage.getPlanes();
        if (planes.length == 1) {
            Image.Plane plane = planes[0];
            int rowStride = plane.getRowStride() / plane.getPixelStride();
            int height = this.currentImage.getHeight();
            Bitmap bitmap = this.currentBitmap;
            if (!(bitmap != null && bitmap.getWidth() == rowStride && this.currentBitmap.getHeight() == height)) {
                this.currentBitmap = Bitmap.createBitmap(rowStride, height, Bitmap.Config.ARGB_8888);
            }
            ByteBuffer buffer = plane.getBuffer();
            buffer.rewind();
            this.currentBitmap.copyPixelsFromBuffer(buffer);
        }
    }

    @TargetApi(19)
    public boolean acquireLatestImage() {
        if (!this.isAttachedToFlutterRenderer) {
            return false;
        }
        Image acquireLatestImage = this.imageReader.acquireLatestImage();
        if (acquireLatestImage != null) {
            closeCurrentImage();
            this.currentImage = acquireLatestImage;
            invalidate();
        }
        if (acquireLatestImage != null) {
            return true;
        }
        return false;
    }

    public void attachToRenderer(FlutterRenderer flutterRenderer2) {
        if (AnonymousClass1.$SwitchMap$io$flutter$embedding$android$FlutterImageView$SurfaceKind[this.kind.ordinal()] == 1) {
            flutterRenderer2.swapSurface(this.imageReader.getSurface());
        }
        setAlpha(1.0f);
        this.flutterRenderer = flutterRenderer2;
        this.isAttachedToFlutterRenderer = true;
    }

    public void closeImageReader() {
        this.imageReader.close();
    }

    public void detachFromRenderer() {
        if (this.isAttachedToFlutterRenderer) {
            setAlpha(0.0f);
            acquireLatestImage();
            this.currentBitmap = null;
            closeCurrentImage();
            invalidate();
            this.isAttachedToFlutterRenderer = false;
        }
    }

    public FlutterRenderer getAttachedRenderer() {
        return this.flutterRenderer;
    }

    public ImageReader getImageReader() {
        return this.imageReader;
    }

    public Surface getSurface() {
        return this.imageReader.getSurface();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.currentImage != null) {
            updateCurrentBitmap();
        }
        Bitmap bitmap = this.currentBitmap;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        if (!(i11 == this.imageReader.getWidth() && i12 == this.imageReader.getHeight()) && this.kind == SurfaceKind.background && this.isAttachedToFlutterRenderer) {
            resizeIfNeeded(i11, i12);
            this.flutterRenderer.swapSurface(this.imageReader.getSurface());
        }
    }

    public void pause() {
    }

    public void resizeIfNeeded(int i11, int i12) {
        if (this.flutterRenderer != null) {
            if (i11 != this.imageReader.getWidth() || i12 != this.imageReader.getHeight()) {
                closeCurrentImage();
                closeImageReader();
                this.imageReader = createImageReader(i11, i12);
            }
        }
    }

    public FlutterImageView(Context context) {
        this(context, 1, 1, SurfaceKind.background);
    }

    public FlutterImageView(Context context, AttributeSet attributeSet) {
        this(context, 1, 1, SurfaceKind.background);
    }

    public FlutterImageView(Context context, ImageReader imageReader2, SurfaceKind surfaceKind) {
        super(context, (AttributeSet) null);
        this.isAttachedToFlutterRenderer = false;
        this.imageReader = imageReader2;
        this.kind = surfaceKind;
        init();
    }
}
