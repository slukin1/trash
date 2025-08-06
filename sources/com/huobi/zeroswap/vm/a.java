package com.huobi.zeroswap.vm;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.j;
import com.alibaba.fastjson.JSONObject;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.p;
import com.hbg.lib.core.util.w;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.libkt.base.ext.c;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.edgeengine.ability.AbstractAbility;
import com.huobi.edgeengine.node.trace.TraceMap;
import com.huobi.edgeengine.template.widget.Widget;
import com.huochat.community.network.domain.DomainTool;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Unit;
import rj.b;

public abstract class a extends androidx.lifecycle.a implements DefaultLifecycleObserver {

    /* renamed from: b  reason: collision with root package name */
    public final Application f21233b;

    /* renamed from: c  reason: collision with root package name */
    public final String f21234c = "EdgeEngineViewModel";

    /* renamed from: d  reason: collision with root package name */
    public final List<String> f21235d = CollectionsKt__CollectionsKt.k();

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<String, HashMap<String, Class<? extends Widget>>> f21236e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public final HashMap<String, HashMap<String, Class<? extends AbstractAbility>>> f21237f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public final MutableLiveData<Boolean> f21238g;

    /* renamed from: h  reason: collision with root package name */
    public final LiveData<Boolean> f21239h;

    /* renamed from: i  reason: collision with root package name */
    public final List<Lifecycle.Event> f21240i;

    /* renamed from: j  reason: collision with root package name */
    public final List<TraceMap.a> f21241j;

    /* renamed from: k  reason: collision with root package name */
    public final LinkedHashMap<String, b> f21242k;

    /* renamed from: com.huobi.zeroswap.vm.a$a  reason: collision with other inner class name */
    public /* synthetic */ class C0163a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f21243a;

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|17) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                androidx.lifecycle.Lifecycle$Event[] r0 = androidx.lifecycle.Lifecycle.Event.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_CREATE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_START     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_RESUME     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_PAUSE     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_STOP     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_DESTROY     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_ANY     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                f21243a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.zeroswap.vm.a.C0163a.<clinit>():void");
        }
    }

    public a(Application application) {
        super(application);
        this.f21233b = application;
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>(Boolean.FALSE);
        this.f21238g = mutableLiveData;
        this.f21239h = mutableLiveData;
        this.f21240i = CollectionsKt__CollectionsKt.k();
        this.f21241j = new ArrayList();
        this.f21242k = new LinkedHashMap<>();
    }

    public static /* synthetic */ void c(a aVar, String str, String str2, String str3, JSONObject jSONObject, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 8) != 0) {
                jSONObject = new JSONObject();
            }
            aVar.b(str, str2, str3, jSONObject);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: callChildJS");
    }

    private final void clear() {
        for (TraceMap.a aVar : this.f21241j) {
            if (aVar != null) {
                aVar.destroy();
            }
        }
        this.f21241j.clear();
        LinkedHashMap<String, b> linkedHashMap = this.f21242k;
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        for (Map.Entry next : linkedHashMap.entrySet()) {
            b bVar = (b) next.getValue();
            h(((String) next.getKey()) + " : onCleared");
            bVar.B();
            bVar.C();
            arrayList.add(Unit.f56620a);
        }
        this.f21242k.clear();
    }

    public static /* synthetic */ void f(a aVar, String str, String str2, JSONObject jSONObject, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 4) != 0) {
                jSONObject = new JSONObject();
            }
            aVar.e(str, str2, jSONObject);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: callModuleJS");
    }

    public static /* synthetic */ View r0(a aVar, String str, String str2, ViewGroup viewGroup, JSONObject jSONObject, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 4) != 0) {
                viewGroup = null;
            }
            if ((i11 & 8) != 0) {
                jSONObject = null;
            }
            return aVar.q0(str, str2, viewGroup, jSONObject);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: renderView");
    }

    public void b(String str, String str2, String str3, JSONObject jSONObject) {
        String str4;
        if (jSONObject.isEmpty()) {
            str4 = str2 + '.' + str3 + "()";
        } else {
            str4 = str2 + '.' + str3 + '(' + jSONObject.toJSONString() + ')';
        }
        d(str, str4);
    }

    public void d(String str, String str2) {
        b bVar = this.f21242k.get(str);
        if (bVar == null) {
            h("callJS " + str + "尚未初始化");
            return;
        }
        h("callJS " + str2);
        bVar.I(str2);
    }

    public void e(String str, String str2, JSONObject jSONObject) {
        String str3;
        if (jSONObject.isEmpty()) {
            str3 = str2 + "()";
        } else {
            str3 = str2 + '(' + jSONObject.toJSONString() + ')';
        }
        d(str, str3);
    }

    public void h(String str) {
        String str2 = "端侧引擎:" + m0();
        if (str == null) {
            str = "数据为NULL";
        }
        Log.d(str2, str);
    }

    public abstract WeakReference<Context> h0();

    public final void i(Lifecycle.Event event) {
        if (j0().contains(event)) {
            LinkedHashMap<String, b> linkedHashMap = this.f21242k;
            ArrayList arrayList = new ArrayList(linkedHashMap.size());
            for (Map.Entry next : linkedHashMap.entrySet()) {
                b bVar = (b) next.getValue();
                h("Lifecycle -> " + ((String) next.getKey()) + " : " + event);
                switch (C0163a.f21243a[event.ordinal()]) {
                    case 1:
                        bVar.I("onCreate()");
                        break;
                    case 2:
                        bVar.I("onStart()");
                        break;
                    case 3:
                        bVar.I("onResume()");
                        break;
                    case 4:
                        bVar.I("onPause()");
                        break;
                    case 5:
                        bVar.I("onStop()");
                        break;
                    case 6:
                        bVar.I("onDestroy()");
                        break;
                    case 7:
                        bVar.I("onAny()");
                        break;
                }
                arrayList.add(Unit.f56620a);
            }
        }
    }

    public List<String> i0() {
        return this.f21235d;
    }

    public b j(String str, Context context) {
        b bVar = this.f21242k.get(str);
        if (bVar == null) {
            bVar = new b(context, str);
        }
        bVar.H();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("h5Url", BaseModuleConfig.a().j());
        String y11 = LegalCurrencyConfigUtil.y();
        Locale locale = Locale.ROOT;
        jSONObject.put("currencyCharacter", y11.toUpperCase(locale));
        jSONObject.put("currencyRate", LegalCurrencyConfigUtil.v());
        jSONObject.put("priceColorType", Integer.valueOf(w.l() ^ true ? 1 : 0));
        jSONObject.put("colorMode", Integer.valueOf(NightHelper.e().g() ? 1 : 0));
        String j11 = AssetModuleConfig.a().j();
        jSONObject.put("iconURLHost", j11 != null ? StringsKt__StringsJVMKt.G(j11, DomainTool.DOMAIN_PREFIX, "", false, 4, (Object) null) : null);
        jSONObject.put("iconPlaceholder", "");
        jSONObject.put("OS", 1);
        jSONObject.put("bottomSafeAreaHeight", 0);
        jSONObject.put("language", p.a(this.f21233b).toLowerCase(locale));
        jSONObject.put("webUrl", BaseModuleConfig.a().j());
        jSONObject.put("statusHeight", Integer.valueOf(c.h((float) com.hbg.module.libkt.base.ext.b.T(this.f21233b))));
        bVar.I("sendCommonConfig(" + jSONObject + ')');
        return bVar;
    }

    public List<Lifecycle.Event> j0() {
        return this.f21240i;
    }

    public HashMap<String, HashMap<String, Class<? extends AbstractAbility>>> k0() {
        return this.f21237f;
    }

    public HashMap<String, HashMap<String, Class<? extends Widget>>> l0() {
        return this.f21236e;
    }

    public String m0() {
        return this.f21234c;
    }

    public final void n0() {
        WeakReference<Context> h02 = h0();
        Context context = h02 != null ? (Context) h02.get() : null;
        if (context != null) {
            for (String next : i0()) {
                b j11 = j(next, context);
                Map y11 = MapsKt__MapsKt.y(MapsKt__MapsKt.s(rj.c.f47785a.b()));
                HashMap hashMap = k0().get(next);
                if (hashMap == null) {
                    hashMap = new HashMap();
                }
                y11.putAll(hashMap);
                if (!y11.isEmpty()) {
                    for (Map.Entry entry : y11.entrySet()) {
                        j11.t((String) entry.getKey(), (Class) entry.getValue());
                    }
                }
                Map y12 = MapsKt__MapsKt.y(MapsKt__MapsKt.s(rj.c.f47785a.c()));
                HashMap hashMap2 = l0().get(next);
                if (hashMap2 == null) {
                    hashMap2 = new HashMap();
                }
                y12.putAll(hashMap2);
                if (!y12.isEmpty()) {
                    for (Map.Entry entry2 : y12.entrySet()) {
                        j11.A((String) entry2.getKey(), (Class) entry2.getValue());
                    }
                }
                this.f21242k.put(next, j11);
            }
            this.f21238g.setValue(Boolean.TRUE);
            return;
        }
        h("Context is Null");
    }

    public final LiveData<Boolean> o0() {
        return this.f21239h;
    }

    public void onCleared() {
        super.onCleared();
        clear();
        WeakReference<Context> h02 = h0();
        if (h02 != null) {
            h02.clear();
        }
    }

    public void onCreate(LifecycleOwner lifecycleOwner) {
        j.a(this, lifecycleOwner);
        n0();
        i(Lifecycle.Event.ON_CREATE);
    }

    public void onDestroy(LifecycleOwner lifecycleOwner) {
        j.b(this, lifecycleOwner);
        i(Lifecycle.Event.ON_DESTROY);
        lifecycleOwner.getLifecycle().d(this);
    }

    public void onPause(LifecycleOwner lifecycleOwner) {
        j.c(this, lifecycleOwner);
        i(Lifecycle.Event.ON_PAUSE);
    }

    public void onResume(LifecycleOwner lifecycleOwner) {
        j.d(this, lifecycleOwner);
        i(Lifecycle.Event.ON_RESUME);
    }

    public void onStart(LifecycleOwner lifecycleOwner) {
        j.e(this, lifecycleOwner);
        i(Lifecycle.Event.ON_START);
    }

    public void onStop(LifecycleOwner lifecycleOwner) {
        j.f(this, lifecycleOwner);
        i(Lifecycle.Event.ON_STOP);
    }

    public final void p0(String str, String str2, vj.a aVar) {
        b bVar = this.f21242k.get(str);
        if (bVar == null) {
            h("renderWidget " + str + "尚未初始化");
            return;
        }
        TraceMap.a u11 = bVar.u(str2, aVar);
        if (u11 == null) {
            u11 = null;
        }
        this.f21241j.add(u11);
    }

    public View q0(String str, String str2, ViewGroup viewGroup, JSONObject jSONObject) {
        b bVar = this.f21242k.get(str);
        if (bVar == null) {
            h("renderView " + str + '/' + str2 + " 引擎尚未初始化");
            return null;
        }
        View E = bVar.E(str2, bVar.d(), jSONObject != null, jSONObject);
        if (viewGroup != null) {
            viewGroup.addView(E);
        }
        return E;
    }
}
