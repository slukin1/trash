package com.tencent.thumbplayer.tcmedia.tplayer.a;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.thumbplayer.tcmedia.api.reportv2.ITPExtendReportController;
import com.tencent.thumbplayer.tcmedia.api.reportv2.ITPReportChannelListener;
import com.tencent.thumbplayer.tcmedia.api.reportv2.ITPReportInfoGetter;
import com.tencent.thumbplayer.tcmedia.d.b;
import com.tencent.thumbplayer.tcmedia.utils.TPLogUtil;
import com.tencent.thumbplayer.tcmedia.utils.o;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class g implements ITPExtendReportController, com.tencent.thumbplayer.tcmedia.d.a {

    /* renamed from: k  reason: collision with root package name */
    private static final Map<Integer, Integer> f49518k;

    /* renamed from: a  reason: collision with root package name */
    private ITPReportInfoGetter f49519a = null;

    /* renamed from: b  reason: collision with root package name */
    private HandlerThread f49520b = null;

    /* renamed from: c  reason: collision with root package name */
    private a f49521c = null;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public a f49522d = null;

    /* renamed from: e  reason: collision with root package name */
    private l f49523e = new l();

    /* renamed from: f  reason: collision with root package name */
    private CopyOnWriteArrayList<WeakReference<ITPReportChannelListener>> f49524f;

    /* renamed from: g  reason: collision with root package name */
    private Context f49525g = null;

    /* renamed from: h  reason: collision with root package name */
    private com.tencent.thumbplayer.tcmedia.tplayer.a.a.a f49526h = null;

    /* renamed from: i  reason: collision with root package name */
    private h f49527i = new h();

    /* renamed from: j  reason: collision with root package name */
    private Object f49528j = new Object();

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            int i11 = message.what;
            b.a aVar = (b.a) message.obj;
            g.this.a(i11, aVar);
            if (g.this.f49522d != null) {
                g.this.f49522d.a(i11, aVar);
            }
            g.this.b(i11, aVar);
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f49518k = hashMap;
        hashMap.put(117, 0);
        hashMap.put(204, 103);
        hashMap.put(101, 1);
        hashMap.put(102, 2);
        hashMap.put(103, 3);
        hashMap.put(104, 4);
        hashMap.put(105, 5);
        hashMap.put(107, 5);
        hashMap.put(108, 5);
        hashMap.put(106, 6);
        hashMap.put(109, 7);
        hashMap.put(110, 8);
        hashMap.put(111, 9);
        hashMap.put(112, 10);
        hashMap.put(114, 11);
        hashMap.put(115, 12);
        hashMap.put(201, 100);
        hashMap.put(202, 101);
        hashMap.put(203, 102);
        hashMap.put(116, 14);
        hashMap.put(113, 13);
        hashMap.put(118, 15);
    }

    public g(Context context) {
        this.f49525g = context.getApplicationContext();
        this.f49524f = new CopyOnWriteArrayList<>();
    }

    private void a(int i11) {
        String str;
        if (this.f49522d != null) {
            str = "mITPReporter has been create, do not create again.";
        } else {
            a a11 = k.a(i11);
            this.f49522d = a11;
            if (a11 == null) {
                str = "initReporter(" + i11 + ") fail, mITPReporter is null.";
            } else {
                a11.a(this.f49525g, this.f49523e);
                this.f49522d.a(this.f49519a);
                this.f49522d.a(this.f49526h);
                Iterator<WeakReference<ITPReportChannelListener>> it2 = this.f49524f.iterator();
                while (it2.hasNext()) {
                    ITPReportChannelListener iTPReportChannelListener = (ITPReportChannelListener) it2.next().get();
                    if (iTPReportChannelListener != null) {
                        this.f49522d.a(iTPReportChannelListener);
                    }
                }
                return;
            }
        }
        TPLogUtil.w("TPReportController", str);
    }

    /* access modifiers changed from: private */
    public void a(int i11, b.a aVar) {
        if (i11 == 0) {
            c(aVar);
        } else if (i11 == 1) {
            d(aVar);
        } else if (i11 == 2) {
            e(aVar);
        } else if (i11 == 6) {
            f(aVar);
        } else if (i11 == 103) {
            b(aVar);
        }
    }

    /* access modifiers changed from: private */
    public void b(int i11, b.a aVar) {
        if (i11 == 5) {
            g(aVar);
        } else if (i11 == 1000) {
            h(aVar);
        }
    }

    private void b(b.a aVar) {
        if (aVar instanceof b.g) {
            this.f49523e.f49537b = ((b.g) aVar).b();
            TPLogUtil.i("TPReportController", "onGetConvertedDataSource time:" + this.f49523e.f49537b);
        }
    }

    private void c(b.a aVar) {
        if (aVar instanceof b.u) {
            b.u uVar = (b.u) aVar;
            this.f49523e.f49536a = uVar.b();
            this.f49523e.f49540e = uVar.d();
            this.f49523e.f49543h = uVar.e() ? 1 : 0;
            this.f49523e.f49541f = uVar.f();
            TPLogUtil.i("TPReportController", "onSetDataSource url:" + this.f49523e.f49540e + " isUseProxy:" + this.f49523e.f49543h + " urlProtocol:" + this.f49523e.f49541f);
        }
    }

    private void d(b.a aVar) {
        this.f49527i.a(2);
        if (aVar instanceof b.p) {
            b.p pVar = (b.p) aVar;
            this.f49523e.f49538c = pVar.b();
            this.f49523e.f49539d = pVar.c();
            this.f49523e.f49544i = pVar.d();
        }
    }

    private void e(b.a aVar) {
        if (!this.f49527i.b(2)) {
            TPLogUtil.e("TPReportController", "onPrepareEnd Current state is not match:" + this.f49527i.toString());
            return;
        }
        this.f49527i.a(3);
        if (aVar instanceof b.o) {
            b.o oVar = (b.o) aVar;
            this.f49523e.f49542g = j.b(oVar.e());
            TPLogUtil.i("TPReportController", "onPrepareEnd durationMs:" + oVar.d() + " playType:" + this.f49523e.f49542g);
            if (oVar.d() == 0) {
                a(1);
            } else {
                a(0);
            }
        }
    }

    private void f(b.a aVar) {
        if (this.f49527i.b(2)) {
            a(2);
        }
        this.f49527i.a(1);
    }

    private void g(b.a aVar) {
        this.f49527i.a(1);
        a aVar2 = this.f49522d;
        if (aVar2 != null) {
            aVar2.a();
            this.f49522d = null;
        }
        this.f49523e = new l();
    }

    private void h(b.a aVar) {
        TPLogUtil.i("TPReportController", "onControllerRelease");
        synchronized (this.f49528j) {
            if (this.f49520b != null) {
                o.a().a(this.f49520b, (Handler) this.f49521c);
                this.f49520b = null;
                this.f49521c = null;
            }
            this.f49524f.clear();
            this.f49528j.notifyAll();
            this.f49528j = null;
        }
    }

    public void a() {
        this.f49520b = o.a().a("TPReportController_Thread");
        this.f49521c = new a(this.f49520b.getLooper());
    }

    public void a(b.a aVar) {
        Map<Integer, Integer> map = f49518k;
        if (!map.containsKey(Integer.valueOf(aVar.a()))) {
            TPLogUtil.w("TPReportController", "EventId:" + aVar.a() + " is not need process");
            return;
        }
        this.f49521c.obtainMessage(map.get(Integer.valueOf(aVar.a())).intValue(), aVar).sendToTarget();
    }

    public void a(com.tencent.thumbplayer.tcmedia.tplayer.a.a.a aVar) {
        this.f49526h = aVar;
    }

    public void a(boolean z11) {
        TPLogUtil.i("TPReportController", "reporting is needed:".concat(String.valueOf(z11)));
        this.f49523e.f49545j = Boolean.valueOf(z11);
    }

    public void addReportChannelListener(ITPReportChannelListener iTPReportChannelListener) {
        CopyOnWriteArrayList<WeakReference<ITPReportChannelListener>> copyOnWriteArrayList = this.f49524f;
        if (copyOnWriteArrayList == null) {
            TPLogUtil.w("TPReportController", "mReportChannelListenerList is null");
            return;
        }
        Iterator<WeakReference<ITPReportChannelListener>> it2 = copyOnWriteArrayList.iterator();
        while (it2.hasNext()) {
            if (((ITPReportChannelListener) it2.next().get()) == iTPReportChannelListener) {
                TPLogUtil.w("TPReportController", "mReportChannelListenerList has contain reportChannelListener");
                return;
            }
        }
        this.f49524f.add(new WeakReference(iTPReportChannelListener));
    }

    public void b() {
        TPLogUtil.i("TPReportController", "release");
        synchronized (this.f49528j) {
            a aVar = this.f49521c;
            if (aVar != null) {
                aVar.sendEmptyMessage(1000);
            }
            try {
                this.f49528j.wait(500);
            } catch (InterruptedException e11) {
                TPLogUtil.e("TPReportController", (Throwable) e11);
            }
        }
    }

    public void setReportInfoGetter(ITPReportInfoGetter iTPReportInfoGetter) {
        this.f49519a = iTPReportInfoGetter;
    }
}
