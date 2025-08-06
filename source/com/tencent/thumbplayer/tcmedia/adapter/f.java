package com.tencent.thumbplayer.tcmedia.adapter;

import com.tencent.thumbplayer.tcmedia.adapter.a.c;
import com.tencent.thumbplayer.tcmedia.api.TPCommonEnum;
import com.tencent.thumbplayer.tcmedia.api.TPDrmInfo;
import com.tencent.thumbplayer.tcmedia.core.player.TPDynamicStatisticParams;
import com.tencent.thumbplayer.tcmedia.core.player.TPGeneralPlayFlowParams;
import com.tencent.thumbplayer.tcmedia.d.b;
import com.tencent.thumbplayer.tcmedia.utils.TPLogUtil;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class f implements InvocationHandler {

    /* renamed from: f  reason: collision with root package name */
    private static final Map<String, Class> f48928f;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public d f48929a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public com.tencent.thumbplayer.tcmedia.tplayer.a f48930b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public g f48931c = new g("TPPlayerAdapterProxy");

    /* renamed from: d  reason: collision with root package name */
    private a f48932d;

    /* renamed from: e  reason: collision with root package name */
    private Object f48933e;

    public class a implements c.f, c.g, c.h, c.i, c.j {
        private a() {
        }

        private void a(long j11, long j12, Object obj) {
            f.this.f48930b.b().a((b.a) new b.c());
        }

        private void b(long j11, long j12, Object obj) {
            f.this.f48930b.b().a((b.a) new b.C0619b());
        }

        private void c(long j11, long j12, Object obj) {
            b.s sVar = new b.s();
            sVar.a(((Long) obj).longValue());
            sVar.b((int) j12);
            f.this.f48930b.b().a((b.a) sVar);
        }

        public void a() {
            b.o oVar = new b.o();
            oVar.b(f.this.f48929a.d());
            oVar.a(f.this.f48929a.n());
            f.this.f48930b.b().a((b.a) oVar);
            f.this.f48931c.a();
        }

        public void a(@TPCommonEnum.TPErrorType int i11, int i12, long j11, long j12) {
            b.i iVar = new b.i();
            iVar.c(i12);
            iVar.b(i11);
            TPGeneralPlayFlowParams v11 = f.this.f48929a.v();
            if (v11 == null) {
                v11 = new TPGeneralPlayFlowParams();
            }
            iVar.a(v11);
            TPDynamicStatisticParams c11 = f.this.f48929a.c(false);
            if (c11 == null) {
                c11 = new TPDynamicStatisticParams();
            }
            iVar.a(c11);
            f.this.f48930b.b().a((b.a) iVar);
            f.this.f48931c.a(i11, i12, j11, j12);
        }

        public void a(int i11, long j11, long j12, Object obj) {
            if (i11 == 4) {
                c(j11, j12, obj);
            } else if (i11 == 200) {
                a(j11, j12, obj);
            } else if (i11 == 201) {
                b(j11, j12, obj);
            }
            f.this.f48931c.a(i11, j11, j12, obj);
        }

        public void a(TPDrmInfo tPDrmInfo) {
            b.h hVar = new b.h();
            hVar.a(tPDrmInfo);
            f.this.f48930b.b().a((b.a) hVar);
            f.this.f48931c.a(tPDrmInfo);
        }

        public void c() {
            f.this.f48930b.b().a((b.a) new b.q());
            f.this.f48931c.c();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f48928f = hashMap;
        hashMap.put("setOnPreparedListener", c.i.class);
        hashMap.put("setOnInfoListener", c.h.class);
        hashMap.put("setOnErrorListener", c.f.class);
        hashMap.put("setOnSeekCompleteListener", c.j.class);
    }

    public f(d dVar, com.tencent.thumbplayer.tcmedia.tplayer.a aVar) {
        a aVar2 = new a();
        this.f48932d = aVar2;
        this.f48929a = dVar;
        this.f48930b = aVar;
        dVar.a((c.g) aVar2);
    }

    private static Object a(Method method) {
        String name = method.getReturnType().getName();
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

    private void a(Method method, Object[] objArr) {
        String name = method.getName();
        name.hashCode();
        char c11 = 65535;
        switch (name.hashCode()) {
            case -2055859787:
                if (name.equals("prepareAsync")) {
                    c11 = 0;
                    break;
                }
                break;
            case -906224877:
                if (name.equals("seekTo")) {
                    c11 = 1;
                    break;
                }
                break;
            case 3540994:
                if (name.equals("stop")) {
                    c11 = 2;
                    break;
                }
                break;
            case 106440182:
                if (name.equals("pause")) {
                    c11 = 3;
                    break;
                }
                break;
            case 108404047:
                if (name.equals("reset")) {
                    c11 = 4;
                    break;
                }
                break;
            case 109757538:
                if (name.equals("start")) {
                    c11 = 5;
                    break;
                }
                break;
            case 205228463:
                if (name.equals("selectTrack")) {
                    c11 = 6;
                    break;
                }
                break;
            case 218603354:
                if (name.equals("setPlaySpeedRatio")) {
                    c11 = 7;
                    break;
                }
                break;
            case 1090594823:
                if (name.equals("release")) {
                    c11 = 8;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                a(objArr);
                return;
            case 1:
                g(objArr);
                return;
            case 2:
                d(objArr);
                return;
            case 3:
                c(objArr);
                return;
            case 4:
                e(objArr);
                return;
            case 5:
                b(objArr);
                return;
            case 6:
                i(objArr);
                return;
            case 7:
                h(objArr);
                return;
            case 8:
                f(objArr);
                return;
            default:
                return;
        }
    }

    private void a(Object[] objArr) {
    }

    private void b(Method method, Object[] objArr) {
        Map<String, Class> map = f48928f;
        if (map.containsKey(method.getName())) {
            try {
                this.f48931c.getClass().getMethod(method.getName(), new Class[]{map.get(method.getName())}).invoke(this.f48931c, new Object[]{objArr[0]});
                objArr[0] = this.f48932d;
            } catch (IllegalAccessException e11) {
                e11.printStackTrace();
            } catch (InvocationTargetException e12) {
                e12.printStackTrace();
            } catch (NoSuchMethodException e13) {
                e13.printStackTrace();
            }
        }
    }

    private void b(Object[] objArr) {
        this.f48930b.b().a((b.a) new b.m());
    }

    private void c(Object[] objArr) {
        this.f48930b.b().a((b.a) new b.j());
    }

    private void d(Object[] objArr) {
        b.n nVar = new b.n();
        TPGeneralPlayFlowParams v11 = this.f48929a.v();
        if (v11 == null) {
            v11 = new TPGeneralPlayFlowParams();
        }
        nVar.a(v11);
        TPDynamicStatisticParams c11 = this.f48929a.c(false);
        if (c11 == null) {
            c11 = new TPDynamicStatisticParams();
        }
        nVar.a(c11);
        this.f48930b.b().a((b.a) nVar);
    }

    private void e(Object[] objArr) {
        b.l lVar = new b.l();
        TPGeneralPlayFlowParams v11 = this.f48929a.v();
        if (v11 == null) {
            v11 = new TPGeneralPlayFlowParams();
        }
        lVar.a(v11);
        TPDynamicStatisticParams c11 = this.f48929a.c(false);
        if (c11 == null) {
            c11 = new TPDynamicStatisticParams();
        }
        lVar.a(c11);
        this.f48930b.b().a((b.a) lVar);
    }

    private void f(Object[] objArr) {
        this.f48930b.b().a((b.a) new b.k());
    }

    private void g(Object[] objArr) {
        this.f48930b.b().a((b.a) new b.r());
    }

    private void h(Object[] objArr) {
        b.v vVar = new b.v();
        vVar.a(objArr[0].floatValue());
        this.f48930b.b().a((b.a) vVar);
    }

    private void i(Object[] objArr) {
        b.t tVar = new b.t();
        tVar.b(objArr[0].intValue());
        tVar.a(objArr[1].longValue());
        tVar.a(this.f48929a.s()[objArr[0].intValue()]);
        this.f48930b.b().a((b.a) tVar);
    }

    public synchronized Object a() {
        if (this.f48933e == null) {
            this.f48933e = Proxy.newProxyInstance(this.f48929a.getClass().getClassLoader(), this.f48929a.getClass().getInterfaces(), this);
        }
        return this.f48933e;
    }

    public Object invoke(Object obj, Method method, Object[] objArr) {
        StringBuilder sb2;
        String invocationTargetException;
        try {
            a(method, objArr);
            b(method, objArr);
            return method.invoke(this.f48929a, objArr);
        } catch (InvocationTargetException e11) {
            if (e11.getTargetException() == null) {
                sb2 = new StringBuilder("invokeMethod ");
                sb2.append(method.getName());
                sb2.append(" has excecption: ");
                invocationTargetException = e11.toString();
                sb2.append(invocationTargetException);
                TPLogUtil.e("TPPlayerAdapterProxy", sb2.toString());
                return a(method);
            }
            throw e11.getTargetException();
        } catch (Throwable th2) {
            sb2 = new StringBuilder("invokeMethod ");
            sb2.append(method.getName());
            sb2.append(" has excecption: ");
            invocationTargetException = th2.toString();
            sb2.append(invocationTargetException);
            TPLogUtil.e("TPPlayerAdapterProxy", sb2.toString());
            return a(method);
        }
    }
}
