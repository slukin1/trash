package l1;

import android.annotation.SuppressLint;
import android.text.Editable;
import k1.i;

public final class b extends Editable.Factory {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f16053a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static volatile Editable.Factory f16054b;

    /* renamed from: c  reason: collision with root package name */
    public static Class<?> f16055c;

    @SuppressLint({"PrivateApi"})
    public b() {
        try {
            f16055c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, b.class.getClassLoader());
        } catch (Throwable unused) {
        }
    }

    public static Editable.Factory getInstance() {
        if (f16054b == null) {
            synchronized (f16053a) {
                if (f16054b == null) {
                    f16054b = new b();
                }
            }
        }
        return f16054b;
    }

    public Editable newEditable(CharSequence charSequence) {
        Class<?> cls = f16055c;
        if (cls != null) {
            return i.c(cls, charSequence);
        }
        return super.newEditable(charSequence);
    }
}
