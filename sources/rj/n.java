package rj;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.JSONObject;
import com.huobi.edgeengine.node.trace.ArrayListener;
import com.huobi.edgeengine.node.trace.TraceArray;
import com.huobi.edgeengine.node.trace.TraceMap;
import com.huobi.edgeengine.node.trace.error.TraceValueError;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import wj.o;
import wj.x;

public class n {

    /* renamed from: a  reason: collision with root package name */
    public b f47789a;

    /* renamed from: b  reason: collision with root package name */
    public n f47790b;

    /* renamed from: c  reason: collision with root package name */
    public n f47791c;

    /* renamed from: d  reason: collision with root package name */
    public Context f47792d;

    /* renamed from: e  reason: collision with root package name */
    public String f47793e;

    /* renamed from: f  reason: collision with root package name */
    public TraceMap f47794f;

    /* renamed from: g  reason: collision with root package name */
    public List<TraceMap.a> f47795g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public Map<String, List<vj.a>> f47796h = new HashMap();

    /* renamed from: i  reason: collision with root package name */
    public Map<String, List<ArrayListener.a>> f47797i = new HashMap();

    public class b {

        /* renamed from: a  reason: collision with root package name */
        public Object f47798a;

        public b() {
        }
    }

    public interface c {
        void a(Object obj);
    }

    public n(Context context, b bVar, n nVar, TraceMap traceMap) {
        this.f47792d = context;
        this.f47789a = bVar;
        this.f47794f = traceMap;
        this.f47790b = nVar;
        if (nVar != null) {
            nVar.f47791c = this;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void B(vj.a aVar, Object obj) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            aVar.onCallback(obj);
        } else {
            this.f47789a.r(new i(aVar, obj));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void D(ArrayListener.a aVar, int i11, List list, List list2) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            aVar.a(i11, list, list2);
        } else {
            this.f47789a.r(new g(aVar, i11, list, list2));
        }
    }

    public static /* synthetic */ void u(b bVar, vj.a aVar, Object obj) {
        bVar.f47798a = obj;
        aVar.onCallback(obj);
    }

    public static /* synthetic */ void v(n nVar, b bVar, String str, Object obj) {
        if (nVar != null) {
            if (obj != null || bVar.f47798a != null) {
                if (obj == null || bVar.f47798a == null || !TextUtils.equals(obj.toString(), bVar.f47798a.toString())) {
                    try {
                        bVar.f47798a = obj;
                        nVar.f47794f.n(obj, str);
                    } catch (TraceValueError e11) {
                        Log.e("EngineContext", "bindData reWrite error!", e11);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void x(vj.a aVar, Object obj) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            aVar.onCallback(obj);
        } else {
            this.f47789a.r(new h(aVar, obj));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void z(ArrayListener.a aVar, int i11, List list, List list2) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            aVar.a(i11, list, list2);
        } else {
            this.f47789a.r(new f(aVar, i11, list, list2));
        }
    }

    public TraceMap.a E(String str, vj.a aVar) {
        return F(str, aVar, this.f47793e);
    }

    public TraceMap.a F(String str, vj.a aVar, String str2) {
        TraceMap.a aVar2;
        if (!TextUtils.equals(this.f47793e, str2)) {
            n nVar = this.f47790b;
            aVar2 = nVar != null ? nVar.F(str, aVar, str2) : null;
        } else if (this.f47794f == null) {
            Log.e("EngineContext", "traceMap null when listen!");
            return null;
        } else {
            List list = this.f47796h.get(str);
            if (list == null) {
                list = new ArrayList();
                this.f47796h.put(str, list);
            }
            list.add(aVar);
            aVar2 = this.f47794f.i(str, new l(this, aVar));
        }
        if (aVar2 == null) {
            return null;
        }
        this.f47795g.add(aVar2);
        return aVar2;
    }

    public TraceMap.a G(String str, ArrayListener.a aVar, String str2) {
        TraceMap.a aVar2;
        if (!TextUtils.equals(this.f47793e, str2)) {
            n nVar = this.f47790b;
            aVar2 = nVar != null ? nVar.G(str, aVar, str2) : null;
        } else if (this.f47794f == null) {
            Log.e("EngineContext", "traceMap null when listen!");
            return null;
        } else {
            List list = this.f47797i.get(str);
            if (list == null) {
                list = new ArrayList();
                this.f47797i.put(str, list);
            }
            list.add(aVar);
            aVar2 = this.f47794f.j(str, new e(this, aVar));
        }
        if (aVar2 == null) {
            return null;
        }
        this.f47795g.add(aVar2);
        return aVar2;
    }

    public void H() {
        for (n nVar = this; nVar != null; nVar = nVar.f47791c) {
            nVar.n();
            nVar.l();
            nVar.f47792d = null;
        }
    }

    @Deprecated
    public void I(JSONObject jSONObject) {
        if (jSONObject != null) {
            for (String next : jSONObject.keySet()) {
                try {
                    Object obj = jSONObject.get(next);
                    if (obj != null) {
                        this.f47794f.n(obj, next);
                    }
                } catch (TraceValueError e11) {
                    e11.printStackTrace();
                }
            }
        }
    }

    public void J(TraceMap traceMap) {
        if (this.f47794f != traceMap) {
            if (traceMap == null) {
                Log.e("EngineContext", "jsEngine null when listen!");
                return;
            }
            this.f47794f = traceMap;
            n();
            if (!this.f47796h.isEmpty()) {
                for (String next : this.f47796h.keySet()) {
                    List<vj.a> list = this.f47796h.get(next);
                    if (list != null) {
                        for (vj.a mVar : list) {
                            TraceMap.a i11 = traceMap.i(next, new m(this, mVar));
                            if (i11 != null) {
                                this.f47795g.add(i11);
                            }
                        }
                    }
                }
            }
            if (!this.f47797i.isEmpty()) {
                for (String next2 : this.f47797i.keySet()) {
                    List<ArrayListener.a> list2 = this.f47797i.get(next2);
                    if (list2 != null) {
                        for (ArrayListener.a dVar : list2) {
                            TraceMap.a j11 = traceMap.j(next2, new d(this, dVar));
                            if (j11 != null) {
                                this.f47795g.add(j11);
                            }
                        }
                    }
                }
            }
        }
    }

    public c k(String str, vj.a aVar, List<TraceMap.a> list) {
        int indexOf;
        if (TextUtils.isEmpty(str) || !str.startsWith(TIMMentionEditText.TIM_MENTION_TAG) || (indexOf = str.indexOf(46)) == -1 || indexOf == str.length() - 1) {
            return null;
        }
        String substring = str.substring(1, indexOf);
        String substring2 = str.substring(indexOf + 1);
        b bVar = new b();
        TraceMap.a F = F(substring2, new k(bVar, aVar), substring);
        if (list != null) {
            list.add(F);
        }
        n nVar = this;
        while (nVar != null && !TextUtils.equals(substring, nVar.f47793e)) {
            nVar = nVar.f47790b;
        }
        return new j(nVar, bVar, substring2);
    }

    public void l() {
        this.f47796h.clear();
        this.f47797i.clear();
    }

    public void m() {
        for (n nVar = this; nVar != null; nVar = nVar.f47791c) {
            nVar.n();
            nVar.l();
        }
    }

    public final void n() {
        for (TraceMap.a destroy : this.f47795g) {
            destroy.destroy();
        }
        this.f47795g.clear();
    }

    public Context o() {
        return this.f47792d;
    }

    public n p(String str, String str2, int i11, String str3) {
        n nVar = new n(this.f47792d, this.f47789a, this, r(str2, i11, str3));
        nVar.f47793e = str;
        return nVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int q(java.lang.String r4, java.lang.String r5) {
        /*
            r3 = this;
            java.lang.String r0 = r3.f47793e
            boolean r0 = android.text.TextUtils.equals(r0, r5)
            r1 = 0
            if (r0 != 0) goto L_0x0013
            rj.n r0 = r3.f47790b
            if (r0 == 0) goto L_0x0012
            int r4 = r0.q(r4, r5)
            return r4
        L_0x0012:
            return r1
        L_0x0013:
            com.huobi.edgeengine.node.trace.TraceMap r5 = r3.f47794f
            if (r5 != 0) goto L_0x0018
            return r1
        L_0x0018:
            r0 = 0
            wj.x r5 = r5.f(r4)     // Catch:{ TraceValueError -> 0x0030 }
            boolean r2 = r5 instanceof wj.o     // Catch:{ TraceValueError -> 0x0030 }
            if (r2 == 0) goto L_0x0029
            wj.o r5 = (wj.o) r5     // Catch:{ TraceValueError -> 0x0030 }
            com.huobi.edgeengine.node.trace.TraceArray r5 = r5.o()     // Catch:{ TraceValueError -> 0x0030 }
        L_0x0027:
            r0 = r5
            goto L_0x0034
        L_0x0029:
            boolean r2 = r5 instanceof com.huobi.edgeengine.node.trace.TraceArray     // Catch:{ TraceValueError -> 0x0030 }
            if (r2 == 0) goto L_0x0034
            com.huobi.edgeengine.node.trace.TraceArray r5 = (com.huobi.edgeengine.node.trace.TraceArray) r5     // Catch:{ TraceValueError -> 0x0030 }
            goto L_0x0027
        L_0x0030:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0034:
            if (r0 != 0) goto L_0x004d
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = "找不到对应的数组或者不是数组 key:"
            r5.append(r0)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            java.lang.String r5 = "EngineContext"
            android.util.Log.e(r5, r4)
            return r1
        L_0x004d:
            java.util.List r4 = r0.d()
            if (r4 != 0) goto L_0x0054
            goto L_0x005c
        L_0x0054:
            java.util.List r4 = r0.d()
            int r1 = r4.size()
        L_0x005c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: rj.n.q(java.lang.String, java.lang.String):int");
    }

    public TraceMap r(String str, int i11, String str2) {
        TraceArray traceArray;
        if (!TextUtils.equals(this.f47793e, str2)) {
            n nVar = this.f47790b;
            if (nVar != null) {
                return nVar.r(str, i11, str2);
            }
            Log.e("EngineContext", "getTraceMapForItem: parent traceMap null!");
            return null;
        }
        try {
            TraceMap traceMap = this.f47794f;
            if (traceMap == null) {
                Log.e("EngineContext", "getTraceMapForItem: traceMap null!");
                return null;
            }
            x f11 = traceMap.f(str);
            if (f11 instanceof o) {
                traceArray = ((o) f11).o();
            } else {
                if (f11 instanceof TraceArray) {
                    traceArray = (TraceArray) f11;
                }
                traceArray = null;
            }
            if (traceArray == null) {
                Log.e("EngineContext", "找不到对应的数组或者不是数组 key:" + str);
                return null;
            }
            TraceMap c11 = traceArray.c(i11);
            if (c11 != null) {
                return c11;
            }
            Log.e("EngineContext", "找不到对应的item或者item不是对象 key:" + str);
            return null;
        } catch (TraceValueError e11) {
            e11.printStackTrace();
        }
    }

    public String s(String str) {
        return t(str, this.f47793e);
    }

    public String t(String str, String str2) {
        Object b11;
        try {
            if (!TextUtils.equals(this.f47793e, str2)) {
                n nVar = this.f47790b;
                if (nVar != null) {
                    return nVar.t(str, str2);
                }
                return "";
            }
            x f11 = this.f47794f.f(str);
            if (f11 == null || (b11 = f11.b()) == null) {
                return "";
            }
            return b11.toString();
        } catch (TraceValueError e11) {
            e11.printStackTrace();
            return "";
        }
    }
}
