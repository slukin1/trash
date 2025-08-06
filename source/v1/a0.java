package v1;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import androidx.transition.R$id;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class a0 {

    /* renamed from: b  reason: collision with root package name */
    public static Method f16630b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f16631c;

    /* renamed from: d  reason: collision with root package name */
    public static Field f16632d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f16633e;

    /* renamed from: a  reason: collision with root package name */
    public float[] f16634a;

    public void a(View view) {
        if (view.getVisibility() == 0) {
            view.setTag(R$id.save_non_transition_alpha, (Object) null);
        }
    }

    @SuppressLint({"PrivateApi"})
    public final void b() {
        if (!f16631c) {
            Class<View> cls = View.class;
            try {
                Class cls2 = Integer.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("setFrame", new Class[]{cls2, cls2, cls2, cls2});
                f16630b = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e11) {
                Log.i("ViewUtilsBase", "Failed to retrieve setFrame method", e11);
            }
            f16631c = true;
        }
    }

    public float c(View view) {
        Float f11 = (Float) view.getTag(R$id.save_non_transition_alpha);
        if (f11 != null) {
            return view.getAlpha() / f11.floatValue();
        }
        return view.getAlpha();
    }

    public void d(View view) {
        int i11 = R$id.save_non_transition_alpha;
        if (view.getTag(i11) == null) {
            view.setTag(i11, Float.valueOf(view.getAlpha()));
        }
    }

    public void e(View view, Matrix matrix) {
        if (matrix == null || matrix.isIdentity()) {
            view.setPivotX((float) (view.getWidth() / 2));
            view.setPivotY((float) (view.getHeight() / 2));
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            view.setRotation(0.0f);
            return;
        }
        float[] fArr = this.f16634a;
        if (fArr == null) {
            fArr = new float[9];
            this.f16634a = fArr;
        }
        matrix.getValues(fArr);
        float f11 = fArr[3];
        float sqrt = ((float) Math.sqrt((double) (1.0f - (f11 * f11)))) * ((float) (fArr[0] < 0.0f ? -1 : 1));
        float degrees = (float) Math.toDegrees(Math.atan2((double) f11, (double) sqrt));
        float f12 = fArr[0] / sqrt;
        float f13 = fArr[4] / sqrt;
        float f14 = fArr[2];
        float f15 = fArr[5];
        view.setPivotX(0.0f);
        view.setPivotY(0.0f);
        view.setTranslationX(f14);
        view.setTranslationY(f15);
        view.setRotation(degrees);
        view.setScaleX(f12);
        view.setScaleY(f13);
    }

    public void f(View view, int i11, int i12, int i13, int i14) {
        b();
        Method method = f16630b;
        if (method != null) {
            try {
                method.invoke(view, new Object[]{Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14)});
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e11) {
                throw new RuntimeException(e11.getCause());
            }
        }
    }

    public void g(View view, float f11) {
        Float f12 = (Float) view.getTag(R$id.save_non_transition_alpha);
        if (f12 != null) {
            view.setAlpha(f12.floatValue() * f11);
        } else {
            view.setAlpha(f11);
        }
    }

    public void h(View view, int i11) {
        if (!f16633e) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                f16632d = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewUtilsBase", "fetchViewFlagsField: ");
            }
            f16633e = true;
        }
        Field field = f16632d;
        if (field != null) {
            try {
                f16632d.setInt(view, i11 | (field.getInt(view) & -13));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public void i(View view, Matrix matrix) {
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            i(view2, matrix);
            matrix.preTranslate((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
        }
        matrix.preTranslate((float) view.getLeft(), (float) view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (!matrix2.isIdentity()) {
            matrix.preConcat(matrix2);
        }
    }

    public void j(View view, Matrix matrix) {
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            j(view2, matrix);
            matrix.postTranslate((float) view2.getScrollX(), (float) view2.getScrollY());
        }
        matrix.postTranslate((float) (-view.getLeft()), (float) (-view.getTop()));
        Matrix matrix2 = view.getMatrix();
        if (!matrix2.isIdentity()) {
            Matrix matrix3 = new Matrix();
            if (matrix2.invert(matrix3)) {
                matrix.postConcat(matrix3);
            }
        }
    }
}
