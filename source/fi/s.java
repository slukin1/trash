package fi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.asset.widget.AssetLoadingView;
import com.huobi.edgeengine.template.widget.Widget;
import com.jumio.sdk.reject.JumioRejectReason;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import hk.a;
import rj.n;
import wh.q1;
import wh.r1;

public class s extends q1 {

    /* renamed from: n  reason: collision with root package name */
    public a f47518n;

    /* renamed from: o  reason: collision with root package name */
    public r1 f47519o;

    /* renamed from: p  reason: collision with root package name */
    public JSONArray f47520p;

    /* renamed from: q  reason: collision with root package name */
    public JSONArray f47521q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f47522r = false;

    /* renamed from: s  reason: collision with root package name */
    public int f47523s = -1;

    /* renamed from: t  reason: collision with root package name */
    public int f47524t = -1;

    /* renamed from: u  reason: collision with root package name */
    public boolean f47525u = false;

    public s(a aVar, r1 r1Var) {
        super(aVar, r1Var);
        this.f47518n = aVar;
        this.f47519o = r1Var;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void u(View view) {
        if (this.f48034l) {
            this.f47518n.a().I("refreshData()");
        }
        View.OnClickListener onClickListener = this.f48035m;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void v(View view) {
        this.f47522r = true;
        this.f47525u = false;
        notifyDataSetChanged();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public View f(Context context) {
        return this.f47519o.ve(context);
    }

    public int getItemCount() {
        if (!h()) {
            return 2;
        }
        JSONArray jSONArray = this.f47520p;
        int i11 = 1;
        if (jSONArray != null && jSONArray.size() > 0) {
            this.f47523s = 1;
            if (this.f47520p.size() <= 5) {
                i11 = 2 + this.f47520p.size();
                this.f47525u = false;
            } else if (this.f47522r) {
                i11 = 2 + this.f47520p.size();
            } else {
                this.f47525u = true;
                i11 = 8;
            }
        }
        JSONArray jSONArray2 = this.f47521q;
        if (jSONArray2 == null || jSONArray2.size() <= 0) {
            return i11;
        }
        this.f47524t = i11;
        return i11 + 1 + this.f47521q.size();
    }

    public int getItemViewType(int i11) {
        if (i11 == 0) {
            return 1;
        }
        if (!h()) {
            return 5;
        }
        if (this.f47525u && i11 == 7) {
            return 3;
        }
        if (i11 == this.f47524t) {
            return 4;
        }
        return i11 == this.f47523s ? 6 : 2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r1.f47521q;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean h() {
        /*
            r1 = this;
            com.alibaba.fastjson.JSONArray r0 = r1.f47520p
            if (r0 == 0) goto L_0x000a
            int r0 = r0.size()
            if (r0 > 0) goto L_0x0014
        L_0x000a:
            com.alibaba.fastjson.JSONArray r0 = r1.f47521q
            if (r0 == 0) goto L_0x0016
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0016
        L_0x0014:
            r0 = 1
            goto L_0x0017
        L_0x0016:
            r0 = 0
        L_0x0017:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fi.s.h():boolean");
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i11) {
        if (!h()) {
            if (viewHolder instanceof u) {
                View view = viewHolder.itemView;
                if (view instanceof AssetLoadingView) {
                    AssetLoadingView assetLoadingView = (AssetLoadingView) view;
                    o(assetLoadingView);
                    assetLoadingView.setRetryListener(new q(this));
                }
            }
        } else if (i11 != 0 && (viewHolder instanceof t)) {
            t tVar = (t) viewHolder;
            JSONObject s11 = s(i11);
            if (s11 != null) {
                tVar.f47526a.I(s11);
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
        if (i11 == 5) {
            return new u(new AssetLoadingView(context));
        }
        if (i11 == 4) {
            return new v(t(context));
        }
        if (i11 == 6) {
            return new v(r(context));
        }
        if (i11 == 3) {
            View inflate = LayoutInflater.from(context).inflate(R$layout.item_collateral_expand, viewGroup, false);
            inflate.setOnClickListener(new r(this));
            return new v(inflate);
        }
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        Widget F = this.f47518n.a().F(this.f47519o.e9(), context, true, (JSONObject) null);
        linearLayout.addView(F.P(context));
        return new t(linearLayout, F.s(), (n) null, (View) null);
    }

    public View r(Context context) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("listTitleLeft", (Object) context.getResources().getString(R$string.n_balance_pledge_loan_coin));
        jSONObject.put("listTitleCenter", (Object) context.getResources().getString(R$string.n_balance_loan_amount_title));
        jSONObject.put("listTitleRight", (Object) context.getResources().getString(R$string.n_balance_equivalent));
        jSONObject.put("showSelect", (Object) "0");
        return this.f47518n.a().E("asset_tab_list_header_title_layout.xml", context, true, jSONObject);
    }

    public final JSONObject s(int i11) {
        int i12;
        int i13;
        boolean z11 = !this.f47522r && this.f47525u;
        if (i11 == 0) {
            return null;
        }
        if ((z11 && i11 == 7) || i11 == (i12 = this.f47524t) || i11 == (i13 = this.f47523s)) {
            return null;
        }
        if (i11 > i12) {
            int i14 = (i11 - i12) - 1;
            JSONObject jSONObject = this.f47521q.getJSONObject(i14);
            jSONObject.put("index", (Object) Integer.valueOf(i14));
            return jSONObject;
        }
        int i15 = (i11 - i13) - 1;
        JSONObject jSONObject2 = this.f47520p.getJSONObject(i15);
        jSONObject2.put("index", (Object) Integer.valueOf(i15));
        return jSONObject2;
    }

    public View t(Context context) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("listTitleLeft", (Object) context.getResources().getString(R$string.n_balance_pledge_coin));
        jSONObject.put("listTitleCenter", (Object) context.getResources().getString(R$string.n_balance_pledge_amount_title));
        jSONObject.put("listTitleRight", (Object) context.getResources().getString(R$string.n_balance_equivalent));
        jSONObject.put("showSelect", (Object) "0");
        return this.f47518n.a().E("asset_tab_list_header_title_layout.xml", context, true, jSONObject);
    }

    public void w(JSONArray jSONArray, JSONArray jSONArray2) {
        this.f47521q = jSONArray2;
        this.f47520p = jSONArray;
        if (h()) {
            l(JumioRejectReason.NOT_READABLE, true);
        }
        notifyItemRangeChanged(1, getItemCount());
    }
}
