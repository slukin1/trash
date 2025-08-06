package wh;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.core.BaseModuleConfig;
import com.huobi.asset.widget.AssetLoadingView;
import com.huobi.edgeengine.template.widget.Widget;
import com.jumio.sdk.reject.JumioRejectReason;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import fi.t;
import fi.u;
import fi.v;
import hk.a;
import java.util.HashMap;
import rj.b;

public class q1 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public a f48023a;

    /* renamed from: b  reason: collision with root package name */
    public r1 f48024b;

    /* renamed from: c  reason: collision with root package name */
    public JSONArray f48025c;

    /* renamed from: d  reason: collision with root package name */
    public int f48026d = -1;

    /* renamed from: e  reason: collision with root package name */
    public String f48027e = JumioRejectReason.NOT_READABLE;

    /* renamed from: f  reason: collision with root package name */
    public boolean f48028f = true;

    /* renamed from: g  reason: collision with root package name */
    public String f48029g = "";

    /* renamed from: h  reason: collision with root package name */
    public String f48030h;

    /* renamed from: i  reason: collision with root package name */
    public String f48031i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f48032j;

    /* renamed from: k  reason: collision with root package name */
    public int f48033k = 3;

    /* renamed from: l  reason: collision with root package name */
    public boolean f48034l = true;

    /* renamed from: m  reason: collision with root package name */
    public View.OnClickListener f48035m;

    public q1(a aVar, r1 r1Var) {
        this.f48023a = aVar;
        this.f48024b = r1Var;
        setHasStableIds(true);
    }

    private boolean h() {
        JSONArray jSONArray = this.f48025c;
        return jSONArray != null && jSONArray.size() > 0;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void i(View view) {
        if (this.f48034l) {
            this.f48023a.a().I("refreshData()");
        }
        View.OnClickListener onClickListener = this.f48035m;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void j(t tVar, int i11, JSONObject jSONObject, View view) {
        r1 r1Var = this.f48024b;
        if (r1Var != null) {
            r1Var.Bf();
        }
        notifyItemChanged(this.f48026d + 1);
        if (tVar.f47528c.getVisibility() == 8) {
            this.f48026d = i11;
            tVar.f47528c.setVisibility(0);
            this.f48029g = jSONObject.getString("itemId");
            b a11 = this.f48023a.a();
            a11.I("clickSpotItem(" + i11 + ")");
            d(jSONObject, this.f48024b.Se(), true);
        } else {
            tVar.f47528c.setVisibility(8);
            this.f48029g = "";
            this.f48026d = -1;
            d(jSONObject, this.f48024b.Se(), false);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void d(JSONObject jSONObject, String str, boolean z11) {
        HashMap hashMap = new HashMap();
        String str2 = "unfold";
        hashMap.put("status", z11 ? str2 : "fold");
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case 49:
                if (str.equals("1")) {
                    c11 = 0;
                    break;
                }
                break;
            case 1572:
                if (str.equals("15")) {
                    c11 = 1;
                    break;
                }
                break;
            case 1574:
                if (str.equals("17")) {
                    c11 = 2;
                    break;
                }
                break;
            case 1575:
                if (str.equals("18")) {
                    c11 = 3;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                BaseModuleConfig.a().w("app_assets_spot_tokens_click", hashMap);
                return;
            case 1:
                BaseModuleConfig.a().w("app_assets_tradingbot_tokens_click", hashMap);
                return;
            case 2:
                hashMap.put("tabName", "flexible");
                hashMap.put(FirebaseAnalytics.Param.CURRENCY, jSONObject.getString("symbolName"));
                if (!z11) {
                    str2 = "fold";
                }
                hashMap.put("click", str2);
                BaseModuleConfig.a().w("app_assets_Earn_currency_click", hashMap);
                return;
            case 3:
                hashMap.put("tabName", "fixed");
                hashMap.put(FirebaseAnalytics.Param.CURRENCY, jSONObject.getString("symbolName"));
                if (!z11) {
                    str2 = "fold";
                }
                hashMap.put("click", str2);
                BaseModuleConfig.a().w("app_assets_Earn_currency_click", hashMap);
                return;
            default:
                return;
        }
    }

    public JSONArray e() {
        return this.f48025c;
    }

    public View f(Context context) {
        return this.f48024b.ve(context);
    }

    public int g() {
        return this.f48033k;
    }

    public int getItemCount() {
        if (!h()) {
            return 2;
        }
        JSONArray jSONArray = this.f48025c;
        if (jSONArray == null) {
            return 1;
        }
        return 1 + jSONArray.size();
    }

    public long getItemId(int i11) {
        return (long) i11;
    }

    public int getItemViewType(int i11) {
        if (i11 == 0) {
            return 1;
        }
        return !h() ? 3 : 2;
    }

    public void k(JSONArray jSONArray) {
        JSONArray jSONArray2 = this.f48025c;
        boolean z11 = (jSONArray2 == null || jSONArray2.size() == 0) ? false : true;
        this.f48025c = jSONArray;
        if (z11) {
            l(JumioRejectReason.NOT_READABLE, true);
            notifyItemRangeChanged(1, getItemCount());
            return;
        }
        notifyItemRangeInserted(1, jSONArray.size());
    }

    public void l(String str, boolean z11) {
        this.f48027e = str;
        this.f48028f = z11;
    }

    public void m(String str, String str2, View.OnClickListener onClickListener) {
        this.f48030h = str;
        this.f48031i = str2;
        this.f48032j = onClickListener;
    }

    public void n(int i11) {
        this.f48033k = i11;
    }

    public void o(AssetLoadingView assetLoadingView) {
        if (!JumioRejectReason.NOT_READABLE.equals(this.f48027e) || !this.f48028f) {
            n(2);
        } else {
            assetLoadingView.g(this.f48030h, this.f48031i, this.f48032j);
            n(3);
        }
        assetLoadingView.setState(g());
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i11) {
        if (!h()) {
            if (viewHolder instanceof u) {
                View view = viewHolder.itemView;
                if (view instanceof AssetLoadingView) {
                    AssetLoadingView assetLoadingView = (AssetLoadingView) view;
                    o(assetLoadingView);
                    assetLoadingView.setRetryListener(new o1(this));
                }
            }
        } else if (i11 != 0 && (viewHolder instanceof t)) {
            t tVar = (t) viewHolder;
            int i12 = i11 - 1;
            JSONObject jSONObject = this.f48025c.getJSONObject(i12);
            if (jSONObject != null) {
                jSONObject.put("index", (Object) Integer.valueOf(i12));
                jSONObject.put("type", (Object) this.f48024b.Se());
                jSONObject.put("itemId", (Object) jSONObject.getString("symbolName") + i12);
                tVar.f47526a.I(jSONObject);
                tVar.f47527b.I(jSONObject);
                if (jSONObject.getString("itemId") == null || !jSONObject.getString("itemId").equalsIgnoreCase(this.f48029g)) {
                    tVar.f47528c.setVisibility(8);
                } else {
                    tVar.f47528c.setVisibility(0);
                }
                tVar.itemView.setOnClickListener(new p1(this, tVar, i12, jSONObject));
            }
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        Context context = viewGroup.getContext();
        if (context == null) {
            return null;
        }
        if (i11 == 1) {
            return new v(f(context));
        }
        if (i11 == 3) {
            return new u(new AssetLoadingView(context));
        }
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        Widget F = this.f48023a.a().F(this.f48024b.e9(), context, true, (JSONObject) null);
        Widget F2 = this.f48023a.a().F(this.f48024b.wa(), context, true, (JSONObject) null);
        View P = F2.P(context);
        P.setVisibility(8);
        linearLayout.addView(F.P(context));
        linearLayout.addView(P);
        return new t(linearLayout, F.s(), F2.s(), P);
    }
}
