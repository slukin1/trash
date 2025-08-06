package com.hbg.lib.widgets;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.LottieTask;
import i6.d;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class SafeLottieView extends LottieAnimationView {

    public static class b implements LottieListener<Throwable> {
        public b() {
        }

        /* renamed from: a */
        public void onResult(Throwable th2) {
            d.b("lottie error");
        }
    }

    public SafeLottieView(Context context) {
        super(context);
        f(this);
    }

    public static void f(SafeLottieView safeLottieView) {
        if (g()) {
            try {
                Field declaredField = LottieAnimationView.class.getDeclaredField("failureListener");
                if (declaredField != null) {
                    Field declaredField2 = declaredField.getClass().getDeclaredField("accessFlags");
                    declaredField2.setAccessible(true);
                    declaredField2.setInt(declaredField, declaredField.getModifiers() & -17);
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(safeLottieView);
                    if (obj != null) {
                        Field declaredField3 = LottieAnimationView.class.getDeclaredField("compositionTask");
                        declaredField3.setAccessible(true);
                        Object obj2 = declaredField3.get(safeLottieView);
                        if (obj2 != null) {
                            LottieTask lottieTask = (LottieTask) obj2;
                            Method declaredMethod = lottieTask.getClass().getDeclaredMethod("removeFailureListener", new Class[]{LottieListener.class});
                            declaredMethod.setAccessible(true);
                            declaredMethod.invoke(lottieTask, new Object[]{obj});
                        }
                    }
                    declaredField.set(safeLottieView, new b());
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public static boolean g() {
        int i11 = Build.VERSION.SDK_INT;
        return i11 >= 26 && i11 <= 27;
    }

    public SafeLottieView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f(this);
    }

    public SafeLottieView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        f(this);
    }
}
