package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.transition.c;
import java.util.Map;
import v1.e;
import v1.f;

public class ChangeImageTransform extends Transition {

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f11754b = {"android:changeImageTransform:matrix", "android:changeImageTransform:bounds"};

    /* renamed from: c  reason: collision with root package name */
    public static final TypeEvaluator<Matrix> f11755c = new a();

    /* renamed from: d  reason: collision with root package name */
    public static final Property<ImageView, Matrix> f11756d = new b(Matrix.class, "animatedTransform");

    public static class a implements TypeEvaluator<Matrix> {
        /* renamed from: a */
        public Matrix evaluate(float f11, Matrix matrix, Matrix matrix2) {
            return null;
        }
    }

    public static class b extends Property<ImageView, Matrix> {
        public b(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public Matrix get(ImageView imageView) {
            return null;
        }

        /* renamed from: b */
        public void set(ImageView imageView, Matrix matrix) {
            e.a(imageView, matrix);
        }
    }

    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f11757a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                android.widget.ImageView$ScaleType[] r0 = android.widget.ImageView.ScaleType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f11757a = r0
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_XY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f11757a     // Catch:{ NoSuchFieldError -> 0x001d }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.transition.ChangeImageTransform.c.<clinit>():void");
        }
    }

    public ChangeImageTransform() {
    }

    public static Matrix b(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        float width = (float) imageView.getWidth();
        float f11 = (float) intrinsicWidth;
        int intrinsicHeight = drawable.getIntrinsicHeight();
        float height = (float) imageView.getHeight();
        float f12 = (float) intrinsicHeight;
        float max = Math.max(width / f11, height / f12);
        int round = Math.round((width - (f11 * max)) / 2.0f);
        int round2 = Math.round((height - (f12 * max)) / 2.0f);
        Matrix matrix = new Matrix();
        matrix.postScale(max, max);
        matrix.postTranslate((float) round, (float) round2);
        return matrix;
    }

    public static Matrix c(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        if (drawable.getIntrinsicWidth() > 0 && drawable.getIntrinsicHeight() > 0) {
            int i11 = c.f11757a[imageView.getScaleType().ordinal()];
            if (i11 == 1) {
                return f(imageView);
            }
            if (i11 == 2) {
                return b(imageView);
            }
        }
        return new Matrix(imageView.getImageMatrix());
    }

    public static Matrix f(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        Matrix matrix = new Matrix();
        matrix.postScale(((float) imageView.getWidth()) / ((float) drawable.getIntrinsicWidth()), ((float) imageView.getHeight()) / ((float) drawable.getIntrinsicHeight()));
        return matrix;
    }

    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public final void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.f11866b;
        if ((view instanceof ImageView) && view.getVisibility() == 0) {
            ImageView imageView = (ImageView) view;
            if (imageView.getDrawable() != null) {
                Map<String, Object> map = transitionValues.f11865a;
                map.put("android:changeImageTransform:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
                map.put("android:changeImageTransform:matrix", c(imageView));
            }
        }
    }

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null || transitionValues2 == null) {
            return null;
        }
        Rect rect = (Rect) transitionValues.f11865a.get("android:changeImageTransform:bounds");
        Rect rect2 = (Rect) transitionValues2.f11865a.get("android:changeImageTransform:bounds");
        if (rect == null || rect2 == null) {
            return null;
        }
        Matrix matrix = (Matrix) transitionValues.f11865a.get("android:changeImageTransform:matrix");
        Matrix matrix2 = (Matrix) transitionValues2.f11865a.get("android:changeImageTransform:matrix");
        boolean z11 = (matrix == null && matrix2 == null) || (matrix != null && matrix.equals(matrix2));
        if (rect.equals(rect2) && z11) {
            return null;
        }
        ImageView imageView = (ImageView) transitionValues2.f11866b;
        Drawable drawable = imageView.getDrawable();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            return e(imageView);
        }
        if (matrix == null) {
            matrix = f.f16648a;
        }
        if (matrix2 == null) {
            matrix2 = f.f16648a;
        }
        f11756d.set(imageView, matrix);
        return d(imageView, matrix, matrix2);
    }

    public final ObjectAnimator d(ImageView imageView, Matrix matrix, Matrix matrix2) {
        return ObjectAnimator.ofObject(imageView, f11756d, new c.a(), new Matrix[]{matrix, matrix2});
    }

    public final ObjectAnimator e(ImageView imageView) {
        Property<ImageView, Matrix> property = f11756d;
        TypeEvaluator<Matrix> typeEvaluator = f11755c;
        Matrix matrix = f.f16648a;
        return ObjectAnimator.ofObject(imageView, property, typeEvaluator, new Matrix[]{matrix, matrix});
    }

    public String[] getTransitionProperties() {
        return f11754b;
    }

    public ChangeImageTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
