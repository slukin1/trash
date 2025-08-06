package com.huobi.pandoraBox.crashKiller.core.cleaner;

import android.app.ActivityManager;
import android.app.servertransaction.ClientTransaction;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import java.lang.reflect.Method;
import java.util.Objects;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002¨\u0006\u000e"}, d2 = {"Lcom/huobi/pandoraBox/crashKiller/core/cleaner/PageCleaner28;", "Lcom/huobi/pandoraBox/crashKiller/core/cleaner/b;", "Landroid/os/Message;", "message", "", "a", "f", "h", "g", "Landroid/os/IBinder;", "binder", "e", "<init>", "()V", "hb_framework_client_release"}, k = 1, mv = {1, 6, 0})
public final class PageCleaner28 implements b {
    public void a(Message message) {
        try {
            f(message);
        } catch (Throwable th2) {
            th2.printStackTrace();
            try {
                h(message);
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
        }
    }

    public /* synthetic */ void b(Message message) {
        a.b(this, message);
    }

    public /* synthetic */ void c(Message message) {
        a.c(this, message);
    }

    public /* synthetic */ void d(Message message) {
        a.a(this, message);
    }

    public final void e(IBinder iBinder) throws Exception {
        Object invoke = ActivityManager.class.getDeclaredMethod("getService", new Class[0]).invoke((Object) null, new Object[0]);
        Class<?> cls = invoke.getClass();
        Class cls2 = Integer.TYPE;
        Method declaredMethod = cls.getDeclaredMethod("finishActivity", new Class[]{IBinder.class, cls2, Intent.class, cls2});
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(invoke, new Object[]{iBinder, 0, null, 0});
    }

    public final void f(Message message) throws Throwable {
        Object obj = message.obj;
        Objects.requireNonNull(obj, "null cannot be cast to non-null type android.app.servertransaction.ClientTransaction");
        e(((ClientTransaction) obj).getActivityToken());
    }

    public final void g(Message message) throws Throwable {
        Object obj = message.obj;
        Object invoke = obj.getClass().getDeclaredMethod("getActivityToken", new Class[0]).invoke(obj, new Object[0]);
        Objects.requireNonNull(invoke, "null cannot be cast to non-null type android.os.IBinder");
        e((IBinder) invoke);
    }

    public final void h(Message message) throws Throwable {
        Object obj = message.obj;
        Object obj2 = obj.getClass().getDeclaredField("mActivityToken").get(obj);
        Objects.requireNonNull(obj2, "null cannot be cast to non-null type android.os.IBinder");
        e((IBinder) obj2);
    }
}
