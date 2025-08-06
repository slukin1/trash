package com.tencent.thumbplayer.tcmedia.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class q {

    /* renamed from: a  reason: collision with root package name */
    private String f49731a;

    /* renamed from: b  reason: collision with root package name */
    private a f49732b = new a(this.f49733c);

    /* renamed from: c  reason: collision with root package name */
    private Looper f49733c;

    /* renamed from: d  reason: collision with root package name */
    private m f49734d = new m();

    /* renamed from: e  reason: collision with root package name */
    private Object f49735e;

    /* renamed from: f  reason: collision with root package name */
    private Class<?> f49736f;

    public class a extends Handler {
        private a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            q.this.a(message);
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Object f49738a;

        /* renamed from: b  reason: collision with root package name */
        public e f49739b;

        private b() {
        }
    }

    public q(String str, Looper looper, Object obj) {
        this.f49731a = str;
        this.f49733c = looper;
        this.f49735e = obj;
        Class<?> cls = obj.getClass();
        this.f49736f = cls;
        if (!n.a(cls, 0)) {
            String str2 = this.f49731a;
            TPLogUtil.e(str2, "Register " + this.f49736f.getName() + " @ThreadSwitch method failed, version: 2.32.0.338");
            throw new RuntimeException("register @ThreadSwitch method failed, player can not work");
        }
    }

    private Object a(int i11, int i12, int i13, Object obj, boolean z11, boolean z12, long j11) {
        e eVar = new e();
        b bVar = new b();
        bVar.f49738a = obj;
        bVar.f49739b = eVar;
        b(i11, i12, i13, bVar, z11, z12, j11);
        return eVar.a(500);
    }

    private Object a(String str, Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        String name = n.a(this.f49736f, str, a(obj2)).getReturnType().getName();
        if (name.equals("boolean")) {
            return Boolean.FALSE;
        }
        if (name.equals("int")) {
            return 0;
        }
        if (name.equals("long")) {
            return 0L;
        }
        if (name.equals("float")) {
            return Float.valueOf(0.0f);
        }
        return null;
    }

    private String a(int i11) {
        String b11 = n.b(this.f49736f, i11);
        if (!TextUtils.isEmpty(b11) && !b11.equals("unknown")) {
            return b11;
        }
        return i11 + " not find";
    }

    private void a(int i11, Object obj) {
        e eVar = obj instanceof b ? ((b) obj).f49739b : null;
        Method f11 = n.f(this.f49736f, i11);
        if (f11 == null) {
            TPLogUtil.e(this.f49731a, "invokeMethod, handle method name is empty, msg:".concat(String.valueOf(i11)));
            if (eVar != null) {
                eVar.a((Throwable) new RuntimeException("invokeMethod, handle method name is empty"));
                return;
            }
            return;
        }
        try {
            Object invoke = f11.getParameterTypes().length == 0 ? f11.invoke(this.f49735e, new Object[0]) : f11.invoke(this.f49735e, a(obj));
            if (eVar != null) {
                eVar.a(invoke);
            }
        } catch (InvocationTargetException e11) {
            String str = this.f49731a;
            TPLogUtil.e(str, "invokeMethod " + f11.getName() + " has excecption: " + e11.getTargetException().toString());
            if (eVar != null) {
                if (e11.getTargetException() instanceof IllegalArgumentException) {
                    eVar.a((Throwable) new IllegalArgumentException("invokeMethod " + f11.getName() + " failed, params invalid", e11.getCause()));
                } else if (e11.getTargetException() instanceof IllegalStateException) {
                    eVar.a((Throwable) new IllegalStateException("invokeMethod " + f11.getName() + " failed, state invalid", e11.getCause()));
                } else {
                    eVar.a(e11.getTargetException());
                }
            }
        } catch (Exception e12) {
            String str2 = this.f49731a;
            TPLogUtil.e(str2, "invokeMethod " + f11.getName() + " has excecption: " + e12.toString());
            if (eVar != null) {
                eVar.a((Throwable) e12);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(Message message) {
        if (this.f49735e == null) {
            TPLogUtil.e(this.f49731a, "handle listener is null, return");
        } else {
            a(message.what, message.obj);
        }
    }

    private boolean a() {
        return Looper.myLooper() == this.f49733c;
    }

    private Object[] a(Object obj) {
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof b)) {
            return (Object[]) obj;
        }
        Object obj2 = ((b) obj).f49738a;
        if (obj2 == null) {
            return null;
        }
        return (Object[]) obj2;
    }

    private boolean b(int i11, int i12, int i13, Object obj, boolean z11, boolean z12, long j11) {
        String str;
        StringBuilder sb2;
        String str2;
        if (this.f49732b == null) {
            str = this.f49731a;
            sb2 = new StringBuilder();
            sb2.append(a(i11));
            str2 = " , send failed , handler null";
        } else if (z11 && obj == null) {
            str = this.f49731a;
            sb2 = new StringBuilder();
            sb2.append(a(i11));
            str2 = ", send failed , params null";
        } else if (!this.f49733c.getThread().isAlive()) {
            str = this.f49731a;
            sb2 = new StringBuilder();
            sb2.append(a(i11));
            str2 = ", send failed , thread had dead";
        } else {
            if (!a()) {
                this.f49734d.readLock().lock();
            }
            if (z12) {
                this.f49732b.removeMessages(i11);
            }
            Message obtainMessage = this.f49732b.obtainMessage();
            obtainMessage.what = i11;
            obtainMessage.arg1 = i12;
            obtainMessage.arg2 = i13;
            obtainMessage.obj = obj;
            if (a()) {
                a(obtainMessage);
                return true;
            }
            this.f49732b.sendMessageDelayed(obtainMessage, j11);
            this.f49734d.readLock().unlock();
            return true;
        }
        sb2.append(str2);
        TPLogUtil.e(str, sb2.toString());
        return false;
    }

    public Object a(String str, Object obj) {
        return a(str, b(str, obj), obj);
    }

    public Object b(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            int b11 = n.b(this.f49736f, str, a(obj));
            if (b11 >= 0) {
                boolean d11 = n.d(this.f49736f, b11);
                boolean e11 = n.e(this.f49736f, b11);
                Object obj2 = obj;
                if (n.c(this.f49736f, b11)) {
                    return a(b11, 0, 0, obj2, e11, d11, 0);
                }
                b(b11, 0, 0, obj2, e11, d11, 0);
                return null;
            }
            TPLogUtil.e(this.f49731a, "dealThreadSwitch failed , not match method:".concat(String.valueOf(str)));
            throw new RuntimeException("dealThreadSwitch failed , not match method:".concat(String.valueOf(str)));
        }
        TPLogUtil.e(this.f49731a, "dealThreadSwitch failed , methodName is null");
        throw new RuntimeException("dealThreadSwitch failed , methodName is null");
    }
}
