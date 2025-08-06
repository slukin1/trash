package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TypeEvaluator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import v1.u;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f11892a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f11893b;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f11894c;

    public static class a implements TypeEvaluator<Matrix> {

        /* renamed from: a  reason: collision with root package name */
        public final float[] f11895a = new float[9];

        /* renamed from: b  reason: collision with root package name */
        public final float[] f11896b = new float[9];

        /* renamed from: c  reason: collision with root package name */
        public final Matrix f11897c = new Matrix();

        /* renamed from: a */
        public Matrix evaluate(float f11, Matrix matrix, Matrix matrix2) {
            matrix.getValues(this.f11895a);
            matrix2.getValues(this.f11896b);
            for (int i11 = 0; i11 < 9; i11++) {
                float[] fArr = this.f11896b;
                float f12 = fArr[i11];
                float[] fArr2 = this.f11895a;
                fArr[i11] = fArr2[i11] + ((f12 - fArr2[i11]) * f11);
            }
            this.f11897c.setValues(this.f11896b);
            return this.f11897c;
        }
    }

    static {
        int i11 = Build.VERSION.SDK_INT;
        boolean z11 = true;
        f11892a = i11 >= 19;
        f11893b = i11 >= 18;
        if (i11 < 28) {
            z11 = false;
        }
        f11894c = z11;
    }

    public static View a(ViewGroup viewGroup, View view, View view2) {
        Matrix matrix = new Matrix();
        matrix.setTranslate((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
        u.j(view, matrix);
        u.k(viewGroup, matrix);
        RectF rectF = new RectF(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
        matrix.mapRect(rectF);
        int round = Math.round(rectF.left);
        int round2 = Math.round(rectF.top);
        int round3 = Math.round(rectF.right);
        int round4 = Math.round(rectF.bottom);
        ImageView imageView = new ImageView(view.getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Bitmap b11 = b(view, matrix, rectF, viewGroup);
        if (b11 != null) {
            imageView.setImageBitmap(b11);
        }
        imageView.measure(View.MeasureSpec.makeMeasureSpec(round3 - round, 1073741824), View.MeasureSpec.makeMeasureSpec(round4 - round2, 1073741824));
        imageView.layout(round, round2, round3, round4);
        return imageView;
    }

    public static Bitmap b(View view, Matrix matrix, RectF rectF, ViewGroup viewGroup) {
        boolean z11;
        boolean z12;
        int i11;
        ViewGroup viewGroup2;
        if (f11892a) {
            z12 = !view.isAttachedToWindow();
            z11 = viewGroup == null ? false : viewGroup.isAttachedToWindow();
        } else {
            z12 = false;
            z11 = false;
        }
        boolean z13 = f11893b;
        Bitmap bitmap = null;
        if (!z13 || !z12) {
            i11 = 0;
            viewGroup2 = null;
        } else if (!z11) {
            return null;
        } else {
            viewGroup2 = (ViewGroup) view.getParent();
            i11 = viewGroup2.indexOfChild(view);
            viewGroup.getOverlay().add(view);
        }
        int round = Math.round(rectF.width());
        int round2 = Math.round(rectF.height());
        if (round > 0 && round2 > 0) {
            float min = Math.min(1.0f, 1048576.0f / ((float) (round * round2)));
            int round3 = Math.round(((float) round) * min);
            int round4 = Math.round(((float) round2) * min);
            matrix.postTranslate(-rectF.left, -rectF.top);
            matrix.postScale(min, min);
            if (f11894c) {
                Picture picture = new Picture();
                Canvas beginRecording = picture.beginRecording(round3, round4);
                beginRecording.concat(matrix);
                view.draw(beginRecording);
                picture.endRecording();
                bitmap = Bitmap.createBitmap(picture);
            } else {
                bitmap = Bitmap.createBitmap(round3, round4, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                canvas.concat(matrix);
                view.draw(canvas);
            }
        }
        if (z13 && z12) {
            viewGroup.getOverlay().remove(view);
            viewGroup2.addView(view, i11);
        }
        return bitmap;
    }

    public static Animator c(Animator animator, Animator animator2) {
        if (animator == null) {
            return animator2;
        }
        if (animator2 == null) {
            return animator;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{animator, animator2});
        return animatorSet;
    }
}
