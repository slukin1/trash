package rj;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSONObject;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.huobi.edgeengine.ability.builtin.ToastAbility;
import com.huobi.edgeengine.ability.s;
import com.huobi.edgeengine.dataparser.DataParserManager;
import com.huobi.edgeengine.debugger.l;
import com.huobi.edgeengine.debugger.r;
import com.huobi.edgeengine.manager.DefaultResourceManager;
import com.huobi.edgeengine.node.trace.TraceMap;
import com.huobi.edgeengine.node.trace.TraceValueConverter;
import com.huobi.edgeengine.node.trace.error.TraceValueError;
import com.huobi.edgeengine.template.widget.EditTextWidget;
import com.huobi.edgeengine.template.widget.EmptyWidget;
import com.huobi.edgeengine.template.widget.FooterWidget;
import com.huobi.edgeengine.template.widget.ForWidget;
import com.huobi.edgeengine.template.widget.FrameWidget;
import com.huobi.edgeengine.template.widget.GirdFooterWidget;
import com.huobi.edgeengine.template.widget.GirdHeaderWidget;
import com.huobi.edgeengine.template.widget.HeaderWidget;
import com.huobi.edgeengine.template.widget.ImageWidget;
import com.huobi.edgeengine.template.widget.LinearWidget;
import com.huobi.edgeengine.template.widget.ScrollerWidget;
import com.huobi.edgeengine.template.widget.TextWidget;
import com.huobi.edgeengine.template.widget.ViewWidget;
import com.huobi.edgeengine.template.widget.Widget;
import com.huobi.edgeengine.template.widget.chart.BarChartWidget;
import com.huobi.edgeengine.template.widget.chart.LineChartWidget;
import com.huobi.edgeengine.template.widget.list.CellWidget;
import com.huobi.edgeengine.template.widget.list.GirdCellWidget;
import com.huobi.edgeengine.template.widget.list.GirdViewWidget;
import com.huobi.edgeengine.template.widget.list.RecyclerViewWidget;
import com.huobi.edgeengine.template.widget.list.SectionWidget;
import com.huobi.edgeengine.template.widget.slider.SliderWidget;
import com.huobi.edgeengine.util.Utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import sj.c;
import sj.f;
import uj.a;

public class b {

    /* renamed from: n  reason: collision with root package name */
    public static final String f47766n = (MessengerShareContentUtility.ATTACHMENT_TEMPLATE_TYPE + File.separator);

    /* renamed from: o  reason: collision with root package name */
    public static Map<String, Class<? extends Widget>> f47767o = new ConcurrentHashMap();

    /* renamed from: p  reason: collision with root package name */
    public static Map<String, Class<? extends s>> f47768p = new ConcurrentHashMap();

    /* renamed from: q  reason: collision with root package name */
    public static p f47769q;

    /* renamed from: r  reason: collision with root package name */
    public static o f47770r;

    /* renamed from: s  reason: collision with root package name */
    public static a f47771s = new DefaultResourceManager();

    /* renamed from: a  reason: collision with root package name */
    public Map<String, Class<? extends Widget>> f47772a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    public Map<String, Class<? extends s>> f47773b = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    public xj.a f47774c;

    /* renamed from: d  reason: collision with root package name */
    public x f47775d;

    /* renamed from: e  reason: collision with root package name */
    public TraceMap f47776e;

    /* renamed from: f  reason: collision with root package name */
    public n f47777f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f47778g;

    /* renamed from: h  reason: collision with root package name */
    public Context f47779h;

    /* renamed from: i  reason: collision with root package name */
    public String f47780i;

    /* renamed from: j  reason: collision with root package name */
    public String f47781j;

    /* renamed from: k  reason: collision with root package name */
    public Map<String, Object> f47782k;

    /* renamed from: l  reason: collision with root package name */
    public p f47783l;

    /* renamed from: m  reason: collision with root package name */
    public DataParserManager f47784m;

    static {
        f47767o.put("FrameLayout", FrameWidget.class);
        f47767o.put("LinearLayout", LinearWidget.class);
        f47767o.put("TextView", TextWidget.class);
        f47767o.put("EditText", EditTextWidget.class);
        f47767o.put("ImageView", ImageWidget.class);
        f47767o.put("Scroller", ScrollerWidget.class);
        f47767o.put("View", ViewWidget.class);
        f47767o.put("Cell", CellWidget.class);
        f47767o.put("Header", HeaderWidget.class);
        f47767o.put("Section", SectionWidget.class);
        f47767o.put("Footer", FooterWidget.class);
        f47767o.put(RecyclerView.TAG, RecyclerViewWidget.class);
        f47767o.put("SliderView", SliderWidget.class);
        f47767o.put("For", ForWidget.class);
        f47767o.put("GirdCell", GirdCellWidget.class);
        f47767o.put("GirdHeader", GirdHeaderWidget.class);
        f47767o.put("GirdFooter", GirdFooterWidget.class);
        f47767o.put("GirdView", GirdViewWidget.class);
        f47767o.put("BarChart", BarChartWidget.class);
        f47767o.put("LineChart", LineChartWidget.class);
        f47768p.put("toast", ToastAbility.class);
    }

    public b(Context context, String str) {
        this.f47779h = context;
        Utils.b(context);
        this.f47782k = new HashMap();
        this.f47778g = new Handler();
        this.f47784m = new DataParserManager();
        TraceMap traceMap = new TraceMap();
        this.f47776e = traceMap;
        n nVar = new n(context, this, (n) null, traceMap);
        this.f47777f = nVar;
        nVar.f47793e = "data";
        this.f47774c = new xj.a(this);
        this.f47775d = new x(context, this, this.f47776e);
        this.f47780i = str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("edgeengine");
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append(str);
        sb2.append(str2);
        this.f47781j = sb2.toString();
    }

    public static void K(p pVar) {
        f47769q = pVar;
    }

    public static o i() {
        return f47770r;
    }

    public static p j() {
        return f47769q;
    }

    public static a l() {
        return f47771s;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p() {
        try {
            InputStream a11 = l().a(this, this.f47779h, "main.js");
            if (a11 != null) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(a11));
                StringBuilder sb2 = new StringBuilder();
                for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                    sb2.append(readLine);
                    if (!r.f44050a.h()) {
                        sb2.append("\n");
                    }
                }
                String sb3 = sb2.toString();
                l.f44036a.a(this.f47780i, sb3);
                this.f47775d.w(sb3, this.f47780i);
            }
        } catch (IOException e11) {
            e11.printStackTrace();
        }
    }

    public static void w(String str, Class<? extends s> cls) {
        f47768p.put(str, cls);
    }

    public static void x(String str, Class<? extends Widget> cls) {
        f47767o.put(str, cls);
    }

    public static void y(a aVar) {
        f47771s = aVar;
    }

    public void A(String str, Class<? extends Widget> cls) {
        this.f47772a.put(str, cls);
    }

    public void B() {
        this.f47775d.t();
        this.f47777f.H();
        l.f44036a.d(this.f47780i);
        this.f47779h = null;
    }

    public void C() {
        this.f47777f.m();
    }

    public View D(String str, Context context) {
        return E(str, context, false, (JSONObject) null);
    }

    public View E(String str, Context context, boolean z11, JSONObject jSONObject) {
        try {
            xj.a aVar = this.f47774c;
            a l11 = l();
            return aVar.e(str, l11.a(this, context, f47766n + str), b(z11, jSONObject), z11);
        } catch (Throwable th2) {
            View view = new View(context);
            th2.printStackTrace();
            return view;
        }
    }

    public Widget F(String str, Context context, boolean z11, JSONObject jSONObject) {
        try {
            xj.a aVar = this.f47774c;
            a l11 = l();
            return aVar.f(str, l11.a(this, context, f47766n + str), b(z11, jSONObject), z11);
        } catch (Throwable th2) {
            EmptyWidget emptyWidget = new EmptyWidget();
            emptyWidget.T(b(z11, jSONObject));
            th2.printStackTrace();
            return emptyWidget;
        }
    }

    public Widget G(String str, Context context, boolean z11, n nVar) {
        try {
            xj.a aVar = this.f47774c;
            a l11 = l();
            return aVar.f(str, l11.a(this, context, f47766n + str), nVar, z11);
        } catch (Throwable th2) {
            EmptyWidget emptyWidget = new EmptyWidget();
            emptyWidget.T(nVar);
            th2.printStackTrace();
            return emptyWidget;
        }
    }

    public void H() {
        this.f47775d.r(new a(this));
    }

    public void I(String str) {
        this.f47775d.u(str);
    }

    public void J(p pVar) {
        this.f47783l = pVar;
    }

    public final n b(boolean z11, JSONObject jSONObject) {
        if (!z11) {
            return this.f47777f;
        }
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        if (jSONObject != null) {
            for (String next : jSONObject.keySet()) {
                try {
                    concurrentHashMap.put(next, TraceValueConverter.c(jSONObject.get(next)));
                } catch (TraceValueError e11) {
                    e11.printStackTrace();
                }
            }
        }
        n nVar = new n(this.f47779h, this, (n) null, new TraceMap(concurrentHashMap));
        nVar.f47793e = "initData";
        return nVar;
    }

    public Class<? extends s> c(String str) {
        if (f47768p.containsKey(str)) {
            return f47768p.get(str);
        }
        return this.f47773b.get(str);
    }

    public Context d() {
        return this.f47779h;
    }

    public String e(String str) {
        return this.f47777f.s(str);
    }

    public String f() {
        return this.f47781j;
    }

    public p g() {
        return this.f47783l;
    }

    public Object h(String str) {
        return this.f47782k.get(str);
    }

    public String k() {
        return this.f47780i;
    }

    public n m() {
        return this.f47777f;
    }

    public Class<? extends Widget> n(String str) {
        if (f47767o.containsKey(str)) {
            return f47767o.get(str);
        }
        return this.f47772a.get(str);
    }

    public boolean o(String str, List<String> list, c cVar) {
        DataParserManager dataParserManager = this.f47784m;
        if (dataParserManager != null) {
            return dataParserManager.a(str, list, cVar);
        }
        return false;
    }

    public void q(Runnable runnable) {
        x xVar = this.f47775d;
        if (xVar != null) {
            xVar.r(runnable);
        }
    }

    public void r(Runnable runnable) {
        Handler handler = this.f47778g;
        if (handler != null) {
            handler.post(runnable);
        }
    }

    public void s(String str, Object obj) {
        this.f47782k.put(str, obj);
    }

    public void t(String str, Class<? extends s> cls) {
        this.f47773b.put(str, cls);
    }

    public TraceMap.a u(String str, vj.a aVar) {
        return this.f47777f.E(str, aVar);
    }

    @Deprecated
    public void v(String str, vj.b bVar) {
        this.f47775d.s(str, bVar);
    }

    public void z(String str, Class<? extends f> cls) {
        DataParserManager dataParserManager = this.f47784m;
        if (dataParserManager != null) {
            dataParserManager.b(str, cls);
        }
    }
}
