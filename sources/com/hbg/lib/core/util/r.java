package com.hbg.lib.core.util;

import android.app.Dialog;
import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class r extends Dialog {

    /* renamed from: c  reason: collision with root package name */
    public static List<WeakReference<Dialog>> f68749c = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<Dialog> f68750b;

    public r(Context context, int i11) {
        super(context, i11);
    }

    public static void a(Dialog dialog) {
        f68749c.add(new WeakReference(dialog));
    }

    public static Dialog h() {
        if (f68749c.isEmpty()) {
            return null;
        }
        List<WeakReference<Dialog>> list = f68749c;
        WeakReference weakReference = list.get(list.size() - 1);
        if (weakReference != null) {
            return (Dialog) weakReference.get();
        }
        return null;
    }

    public static void i(Dialog dialog) {
        Iterator<WeakReference<Dialog>> it2 = f68749c.iterator();
        while (it2.hasNext()) {
            WeakReference next = it2.next();
            if (!(next == null || next.get() == null || next.get() != dialog)) {
                it2.remove();
            }
        }
    }

    public void dismiss() {
        super.dismiss();
        WeakReference<Dialog> weakReference = this.f68750b;
        if (weakReference != null) {
            f68749c.remove(weakReference);
        }
    }

    public void show() {
        super.show();
        WeakReference<Dialog> weakReference = new WeakReference<>(this);
        this.f68750b = weakReference;
        f68749c.add(weakReference);
    }
}
