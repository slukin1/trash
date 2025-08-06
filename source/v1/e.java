package v1;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;
import java.lang.reflect.Field;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f16645a = true;

    /* renamed from: b  reason: collision with root package name */
    public static Field f16646b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f16647c;

    public static void a(ImageView imageView, Matrix matrix) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 29) {
            imageView.animateTransform(matrix);
        } else if (matrix == null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable != null) {
                drawable.setBounds(0, 0, (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight(), (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom());
                imageView.invalidate();
            }
        } else if (i11 >= 21) {
            c(imageView, matrix);
        } else {
            Drawable drawable2 = imageView.getDrawable();
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
                Matrix matrix2 = null;
                b();
                Field field = f16646b;
                if (field != null) {
                    try {
                        Matrix matrix3 = (Matrix) field.get(imageView);
                        if (matrix3 == null) {
                            try {
                                matrix2 = new Matrix();
                                f16646b.set(imageView, matrix2);
                            } catch (IllegalAccessException unused) {
                            }
                        }
                        matrix2 = matrix3;
                    } catch (IllegalAccessException unused2) {
                    }
                }
                if (matrix2 != null) {
                    matrix2.set(matrix);
                }
                imageView.invalidate();
            }
        }
    }

    public static void b() {
        if (!f16647c) {
            try {
                Field declaredField = ImageView.class.getDeclaredField("mDrawMatrix");
                f16646b = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f16647c = true;
        }
    }

    @SuppressLint({"NewApi"})
    public static void c(ImageView imageView, Matrix matrix) {
        if (f16645a) {
            try {
                imageView.animateTransform(matrix);
            } catch (NoSuchMethodError unused) {
                f16645a = false;
            }
        }
    }
}
