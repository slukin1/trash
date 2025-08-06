package androidx.camera.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import android.view.Display;
import android.view.TextureView;
import android.view.View;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.utils.CameraOrientationUtil;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.view.PreviewView;
import androidx.core.util.h;

public final class b {

    /* renamed from: i  reason: collision with root package name */
    public static final PreviewView.ScaleType f6441i = PreviewView.ScaleType.FILL_CENTER;

    /* renamed from: a  reason: collision with root package name */
    public Size f6442a;

    /* renamed from: b  reason: collision with root package name */
    public Rect f6443b;

    /* renamed from: c  reason: collision with root package name */
    public int f6444c;

    /* renamed from: d  reason: collision with root package name */
    public Matrix f6445d;

    /* renamed from: e  reason: collision with root package name */
    public int f6446e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6447f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6448g;

    /* renamed from: h  reason: collision with root package name */
    public PreviewView.ScaleType f6449h = f6441i;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f6450a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.camera.view.PreviewView$ScaleType[] r0 = androidx.camera.view.PreviewView.ScaleType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f6450a = r0
                androidx.camera.view.PreviewView$ScaleType r1 = androidx.camera.view.PreviewView.ScaleType.FIT_CENTER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f6450a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.camera.view.PreviewView$ScaleType r1 = androidx.camera.view.PreviewView.ScaleType.FILL_CENTER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f6450a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.camera.view.PreviewView$ScaleType r1 = androidx.camera.view.PreviewView.ScaleType.FIT_END     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f6450a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.camera.view.PreviewView$ScaleType r1 = androidx.camera.view.PreviewView.ScaleType.FILL_END     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f6450a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.camera.view.PreviewView$ScaleType r1 = androidx.camera.view.PreviewView.ScaleType.FIT_START     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f6450a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.camera.view.PreviewView$ScaleType r1 = androidx.camera.view.PreviewView.ScaleType.FILL_START     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.view.b.a.<clinit>():void");
        }
    }

    public static RectF b(RectF rectF, float f11) {
        float f12 = f11 + f11;
        return new RectF(f12 - rectF.right, rectF.top, f12 - rectF.left, rectF.bottom);
    }

    public static void p(Matrix matrix, RectF rectF, RectF rectF2, PreviewView.ScaleType scaleType) {
        Matrix.ScaleToFit scaleToFit;
        switch (a.f6450a[scaleType.ordinal()]) {
            case 1:
            case 2:
                scaleToFit = Matrix.ScaleToFit.CENTER;
                break;
            case 3:
            case 4:
                scaleToFit = Matrix.ScaleToFit.END;
                break;
            case 5:
            case 6:
                scaleToFit = Matrix.ScaleToFit.START;
                break;
            default:
                Logger.e("PreviewTransform", "Unexpected crop rect: " + scaleType);
                scaleToFit = Matrix.ScaleToFit.FILL;
                break;
        }
        if (scaleType == PreviewView.ScaleType.FIT_CENTER || scaleType == PreviewView.ScaleType.FIT_START || scaleType == PreviewView.ScaleType.FIT_END) {
            matrix.setRectToRect(rectF, rectF2, scaleToFit);
            return;
        }
        matrix.setRectToRect(rectF2, rectF, scaleToFit);
        matrix.invert(matrix);
    }

    public Bitmap a(Bitmap bitmap, Size size, int i11) {
        if (!m()) {
            return bitmap;
        }
        Matrix k11 = k();
        RectF l11 = l(size, i11);
        Bitmap createBitmap = Bitmap.createBitmap(size.getWidth(), size.getHeight(), bitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap);
        Matrix matrix = new Matrix();
        matrix.postConcat(k11);
        matrix.postScale(l11.width() / ((float) this.f6442a.getWidth()), l11.height() / ((float) this.f6442a.getHeight()));
        matrix.postTranslate(l11.left, l11.top);
        canvas.drawBitmap(bitmap, matrix, new Paint(7));
        return createBitmap;
    }

    public Matrix c(Size size, int i11) {
        if (!m()) {
            return null;
        }
        Matrix matrix = new Matrix();
        j(size, i11).invert(matrix);
        Matrix matrix2 = new Matrix();
        matrix2.setRectToRect(new RectF(0.0f, 0.0f, (float) this.f6442a.getWidth(), (float) this.f6442a.getHeight()), new RectF(0.0f, 0.0f, 1.0f, 1.0f), Matrix.ScaleToFit.FILL);
        matrix.postConcat(matrix2);
        return matrix;
    }

    public RectF d(Size size, int i11) {
        RectF rectF = new RectF(0.0f, 0.0f, (float) size.getWidth(), (float) size.getHeight());
        Size f11 = f();
        RectF rectF2 = new RectF(0.0f, 0.0f, (float) f11.getWidth(), (float) f11.getHeight());
        Matrix matrix = new Matrix();
        p(matrix, rectF2, rectF, this.f6449h);
        matrix.mapRect(rectF2);
        return i11 == 1 ? b(rectF2, ((float) size.getWidth()) / 2.0f) : rectF2;
    }

    public final int e() {
        if (!this.f6448g) {
            return this.f6444c;
        }
        return -CameraOrientationUtil.surfaceRotationToDegrees(this.f6446e);
    }

    public final Size f() {
        if (TransformUtils.is90or270(this.f6444c)) {
            return new Size(this.f6443b.height(), this.f6443b.width());
        }
        return new Size(this.f6443b.width(), this.f6443b.height());
    }

    public PreviewView.ScaleType g() {
        return this.f6449h;
    }

    public Matrix h(Size size, int i11) {
        if (!m()) {
            return null;
        }
        Matrix matrix = new Matrix(this.f6445d);
        matrix.postConcat(j(size, i11));
        return matrix;
    }

    public Rect i() {
        return this.f6443b;
    }

    public Matrix j(Size size, int i11) {
        RectF rectF;
        h.i(m());
        if (n(size)) {
            rectF = new RectF(0.0f, 0.0f, (float) size.getWidth(), (float) size.getHeight());
        } else {
            rectF = d(size, i11);
        }
        Matrix rectToRect = TransformUtils.getRectToRect(new RectF(this.f6443b), rectF, this.f6444c);
        if (this.f6447f && this.f6448g) {
            if (TransformUtils.is90or270(this.f6444c)) {
                rectToRect.preScale(1.0f, -1.0f, (float) this.f6443b.centerX(), (float) this.f6443b.centerY());
            } else {
                rectToRect.preScale(-1.0f, 1.0f, (float) this.f6443b.centerX(), (float) this.f6443b.centerY());
            }
        }
        return rectToRect;
    }

    public Matrix k() {
        h.i(m());
        RectF rectF = new RectF(0.0f, 0.0f, (float) this.f6442a.getWidth(), (float) this.f6442a.getHeight());
        return TransformUtils.getRectToRect(rectF, rectF, e());
    }

    public final RectF l(Size size, int i11) {
        h.i(m());
        Matrix j11 = j(size, i11);
        RectF rectF = new RectF(0.0f, 0.0f, (float) this.f6442a.getWidth(), (float) this.f6442a.getHeight());
        j11.mapRect(rectF);
        return rectF;
    }

    public final boolean m() {
        boolean z11 = !this.f6448g || this.f6446e != -1;
        if (this.f6443b == null || this.f6442a == null || !z11) {
            return false;
        }
        return true;
    }

    public boolean n(Size size) {
        return TransformUtils.isAspectRatioMatchingWithRoundingError(size, true, f(), false);
    }

    public void o(int i11, int i12) {
        if (this.f6448g) {
            this.f6444c = i11;
            this.f6446e = i12;
        }
    }

    public void q(PreviewView.ScaleType scaleType) {
        this.f6449h = scaleType;
    }

    public void r(SurfaceRequest.TransformationInfo transformationInfo, Size size, boolean z11) {
        Logger.d("PreviewTransform", "Transformation info set: " + transformationInfo + " " + size + " " + z11);
        this.f6443b = transformationInfo.getCropRect();
        this.f6444c = transformationInfo.getRotationDegrees();
        this.f6446e = transformationInfo.getTargetRotation();
        this.f6442a = size;
        this.f6447f = z11;
        this.f6448g = transformationInfo.hasCameraTransform();
        this.f6445d = transformationInfo.getSensorToBufferTransform();
    }

    public void s(Size size, int i11, View view) {
        if (size.getHeight() == 0 || size.getWidth() == 0) {
            Logger.w("PreviewTransform", "Transform not applied due to PreviewView size: " + size);
        } else if (m()) {
            if (view instanceof TextureView) {
                ((TextureView) view).setTransform(k());
            } else {
                Display display = view.getDisplay();
                boolean z11 = true;
                boolean z12 = (!this.f6448g || display == null || display.getRotation() == this.f6446e) ? false : true;
                if (this.f6448g || e() == 0) {
                    z11 = false;
                }
                if (z12 || z11) {
                    Logger.e("PreviewTransform", "Custom rotation not supported with SurfaceView/PERFORMANCE mode.");
                }
            }
            RectF l11 = l(size, i11);
            view.setPivotX(0.0f);
            view.setPivotY(0.0f);
            view.setScaleX(l11.width() / ((float) this.f6442a.getWidth()));
            view.setScaleY(l11.height() / ((float) this.f6442a.getHeight()));
            view.setTranslationX(l11.left - ((float) view.getLeft()));
            view.setTranslationY(l11.top - ((float) view.getTop()));
        }
    }
}
