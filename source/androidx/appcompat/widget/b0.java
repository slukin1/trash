package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class b0 extends ContextWrapper {

    /* renamed from: c  reason: collision with root package name */
    public static final Object f4538c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public static ArrayList<WeakReference<b0>> f4539d;

    /* renamed from: a  reason: collision with root package name */
    public final Resources f4540a;

    /* renamed from: b  reason: collision with root package name */
    public final Resources.Theme f4541b;

    public b0(Context context) {
        super(context);
        if (n0.d()) {
            n0 n0Var = new n0(this, context.getResources());
            this.f4540a = n0Var;
            Resources.Theme newTheme = n0Var.newTheme();
            this.f4541b = newTheme;
            newTheme.setTo(context.getTheme());
            return;
        }
        this.f4540a = new c0(this, context.getResources());
        this.f4541b = null;
    }

    public static boolean a(Context context) {
        if ((context instanceof b0) || (context.getResources() instanceof c0) || (context.getResources() instanceof n0)) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 21 || n0.d()) {
            return true;
        }
        return false;
    }

    public static Context b(Context context) {
        if (!a(context)) {
            return context;
        }
        synchronized (f4538c) {
            ArrayList<WeakReference<b0>> arrayList = f4539d;
            if (arrayList == null) {
                f4539d = new ArrayList<>();
            } else {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    WeakReference weakReference = f4539d.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        f4539d.remove(size);
                    }
                }
                for (int size2 = f4539d.size() - 1; size2 >= 0; size2--) {
                    WeakReference weakReference2 = f4539d.get(size2);
                    b0 b0Var = weakReference2 != null ? (b0) weakReference2.get() : null;
                    if (b0Var != null && b0Var.getBaseContext() == context) {
                        return b0Var;
                    }
                }
            }
            b0 b0Var2 = new b0(context);
            f4539d.add(new WeakReference(b0Var2));
            return b0Var2;
        }
    }

    public AssetManager getAssets() {
        return this.f4540a.getAssets();
    }

    public Resources getResources() {
        return this.f4540a;
    }

    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f4541b;
        return theme == null ? super.getTheme() : theme;
    }

    public void setTheme(int i11) {
        Resources.Theme theme = this.f4541b;
        if (theme == null) {
            super.setTheme(i11);
        } else {
            theme.applyStyle(i11, true);
        }
    }
}
