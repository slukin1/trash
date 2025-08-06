package com.mob.commons.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.mob.commons.b;
import com.mob.commons.c;
import com.mob.commons.v;
import com.mob.commons.z;
import com.mob.tools.MobHandlerThread;
import com.mob.tools.MobLog;
import com.tencent.imsdk.BaseConstants;

public class l implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    private static l f26966a = new l();

    /* renamed from: b  reason: collision with root package name */
    private Handler f26967b;

    private l() {
        String str;
        if (!TextUtils.isEmpty("M-")) {
            str = z.f27382a + a("004?gdidilig");
        } else {
            str = null;
        }
        this.f26967b = MobHandlerThread.newHandler(str, (Handler.Callback) this);
    }

    public static l a() {
        return f26966a;
    }

    public Handler b() {
        return this.f26967b;
    }

    public Looper c() {
        Handler handler = this.f26967b;
        if (handler != null) {
            return handler.getLooper();
        }
        return null;
    }

    public boolean d(long j11, Runnable runnable) {
        return b(1005, j11, runnable);
    }

    public void e(long j11, Runnable runnable) {
        if (!this.f26967b.hasMessages(1007)) {
            b(1007, j11, runnable);
        }
    }

    public boolean handleMessage(Message message) {
        c cVar;
        try {
            if (!b.d()) {
                Message obtain = Message.obtain();
                obtain.copyFrom(message);
                this.f26967b.sendMessageDelayed(obtain, 60000);
                return false;
            }
            int i11 = message.what;
            if (!(i11 == 1003 || i11 == 1004)) {
                if (i11 != 1006) {
                    if (i11 == 1002) {
                        c.b bVar = (c.b) message.obj;
                        if (bVar != null) {
                            if (!bVar.f27120a) {
                                bVar.f27120a = true;
                            }
                            z.f27385d.execute(bVar);
                            int i12 = message.arg1;
                            Message obtain2 = Message.obtain();
                            obtain2.what = 1002;
                            obtain2.obj = bVar;
                            obtain2.arg1 = i12;
                            a(obtain2, (long) (i12 * 1000));
                        }
                    } else {
                        if (i11 != 1005) {
                            if (i11 != 1007) {
                                if ((i11 >= 10000 || i11 < -10000) && (cVar = (c) message.obj) != null) {
                                    cVar.h();
                                }
                            }
                        }
                        Runnable runnable = (Runnable) message.obj;
                        if (runnable != null) {
                            z.f27384c.execute(runnable);
                        }
                    }
                    return false;
                }
            }
            Runnable runnable2 = (Runnable) message.obj;
            if (runnable2 != null) {
                z.f27385d.execute(runnable2);
            }
            return false;
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
        }
    }

    public <T extends c> void a(long j11, T t11, int i11) {
        int a11 = a(t11);
        if (i11 == 1) {
            this.f26967b.removeMessages(a11);
        } else if (i11 == 2 && this.f26967b.hasMessages(a11)) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = a11;
        obtain.obj = t11;
        a(obtain, j11 * 1000);
    }

    public boolean b(long j11, Runnable runnable) {
        return a(1004, j11 * 1000, runnable);
    }

    public void d() {
        this.f26967b.removeMessages(1002);
    }

    private boolean b(int i11, long j11, Runnable runnable) {
        Message obtain = Message.obtain();
        obtain.what = i11;
        obtain.obj = runnable;
        a(obtain, j11);
        return true;
    }

    public boolean c(long j11, Runnable runnable) {
        return a(1006, j11 * 1000, runnable);
    }

    public boolean a(long j11, Runnable runnable) {
        return a(1003, j11 * 1000, runnable);
    }

    public void a(long j11, int i11, c.b bVar) {
        Message obtain = Message.obtain();
        obtain.what = 1002;
        obtain.arg1 = i11;
        obtain.obj = bVar;
        a(obtain, j11 * 1000);
    }

    private boolean a(int i11, long j11, Runnable runnable) {
        if (this.f26967b.hasMessages(i11)) {
            return false;
        }
        b(i11, j11, runnable);
        return true;
    }

    private <T extends c> int a(T t11) {
        int k11 = t11.k();
        return k11 > 0 ? k11 + 10000 : k11 + BaseConstants.ERR_SVR_SSO_VCODE;
    }

    private void a(Message message, long j11) {
        if (j11 > 0) {
            this.f26967b.sendMessageDelayed(message, j11);
        } else {
            this.f26967b.sendMessage(message);
        }
    }

    public static String a(String str) {
        return v.a(str, 100);
    }
}
