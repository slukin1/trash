package v1;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.View;

public class w extends v {

    /* renamed from: g  reason: collision with root package name */
    public static boolean f16694g = true;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f16695h = true;

    /* renamed from: i  reason: collision with root package name */
    public static boolean f16696i = true;

    @SuppressLint({"NewApi"})
    public void e(View view, Matrix matrix) {
        if (f16694g) {
            try {
                view.setAnimationMatrix(matrix);
            } catch (NoSuchMethodError unused) {
                f16694g = false;
            }
        }
    }

    @SuppressLint({"NewApi"})
    public void i(View view, Matrix matrix) {
        if (f16695h) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                f16695h = false;
            }
        }
    }

    @SuppressLint({"NewApi"})
    public void j(View view, Matrix matrix) {
        if (f16696i) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                f16696i = false;
            }
        }
    }
}
