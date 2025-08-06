package com.huobi.pandoraBox.crashKiller.core.cleaner;

import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import java.lang.reflect.Field;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002¨\u0006\u000f"}, d2 = {"Lcom/huobi/pandoraBox/crashKiller/core/cleaner/PageCleaner24To25;", "Lcom/huobi/pandoraBox/crashKiller/core/cleaner/b;", "Landroid/os/Message;", "message", "", "a", "b", "d", "c", "f", "Landroid/os/IBinder;", "binder", "e", "<init>", "()V", "hb_framework_client_release"}, k = 1, mv = {1, 6, 0})
public final class PageCleaner24To25 implements b {
    public void a(Message message) {
        try {
            Object obj = message.obj;
            Field declaredField = obj.getClass().getDeclaredField("token");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            if (obj2 != null) {
                e((IBinder) obj2);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.os.IBinder");
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void b(Message message) {
        f(message);
    }

    public void c(Message message) {
        f(message);
    }

    public void d(Message message) {
        f(message);
    }

    public final void e(IBinder iBinder) throws Exception {
        Object invoke = Class.forName("android.app.ActivityManagerNative").getDeclaredMethod("getDefault", new Class[0]).invoke((Object) null, new Object[0]);
        Class<?> cls = invoke.getClass();
        Class cls2 = Integer.TYPE;
        cls.getDeclaredMethod("finishActivity", new Class[]{IBinder.class, cls2, Intent.class, cls2}).invoke(invoke, new Object[]{iBinder, 0, null, 0});
    }

    public final void f(Message message) {
        try {
            Object obj = message.obj;
            Field declaredField = obj.getClass().getDeclaredField("arg1");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            if (obj2 != null) {
                e((IBinder) obj2);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.os.IBinder");
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
