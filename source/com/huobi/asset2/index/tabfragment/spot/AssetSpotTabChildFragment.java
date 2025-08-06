package com.huobi.asset2.index.tabfragment.spot;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$string;
import com.huobi.asset2.index.AssetIndexFragmentNew1;
import com.huobi.asset2.index.BaseAssetChildTabFragment;
import com.huobi.asset2.index.util.d;
import fi.m;
import fi.n;
import fi.o;
import fi.p;
import hk.a;
import java.util.HashMap;
import kotlin.Unit;

public class AssetSpotTabChildFragment extends BaseAssetChildTabFragment {

    /* renamed from: o  reason: collision with root package name */
    public View f42763o;

    /* renamed from: p  reason: collision with root package name */
    public Boolean f42764p;

    /* renamed from: q  reason: collision with root package name */
    public Boolean f42765q;

    public AssetSpotTabChildFragment() {
        Boolean bool = Boolean.FALSE;
        this.f42764p = bool;
        this.f42765q = bool;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ph(Object obj) {
        this.f42573d.k(JSON.parseArray(obj.toString()));
        this.f42764p = Boolean.TRUE;
        di();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Zh(Object obj) {
        if (obj != null) {
            try {
                JSONObject parseObject = JSON.parseObject(obj.toString());
                int intValue = parseObject.containsKey("position") ? parseObject.getInteger("position").intValue() : -1;
                Object obj2 = parseObject.containsKey("data") ? parseObject.get("data") : null;
                if (this.f42573d.e() != null) {
                    this.f42573d.e().set(intValue, obj2);
                    this.f42573d.notifyItemRangeChanged(intValue, 2);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ai(Object obj) {
        this.f42765q = Boolean.TRUE;
        di();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit bi() {
        Log.d("guideShowDate", "showEarnGuide1");
        this.f42574e.a().I("assetSpotAutoEarnOpenGuide()");
        return null;
    }

    public String Ah() {
        return "exchangeListError";
    }

    public String Se() {
        return "1";
    }

    public boolean Yh() {
        if (!isAdded()) {
            return false;
        }
        for (Fragment next : requireActivity().getSupportFragmentManager().B0()) {
            if (next.getClass() == AssetIndexFragmentNew1.class) {
                if (!next.isVisible() || getLifecycle().b() != Lifecycle.State.RESUMED) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public void ci() {
        if (this.f42763o != null && this.f42764p.booleanValue() && this.f42765q.booleanValue()) {
            View findViewWithTag = this.f42763o.findViewWithTag("-987");
            if (findViewWithTag != null && findViewWithTag.getVisibility() == 0 && isAdded() && Yh()) {
                BaseModuleConfig.a().w("app_assets_spot_autoEarnEntrance_show", (HashMap) null);
                d.f42776a.d(requireActivity(), findViewWithTag, new m(this));
            }
            if (findViewWithTag == null || findViewWithTag.getVisibility() == 8) {
                Log.d("guideShowDate", "showEarnGuide2");
                this.f42574e.a().I("assetSpotAutoEarnOpenGuide()");
            }
        }
    }

    public void di() {
        ci();
        if (d.f42776a.b()) {
            Log.d("guideShowDate", "showGuideDialog");
            this.f42574e.a().I("assetSpotAutoEarnOpenGuide()");
        }
    }

    public String e9() {
        return "asset_tab_spot_item.xml";
    }

    public void initViews() {
        super.initViews();
        a aVar = this.f42574e;
        if (aVar == null || aVar.a() == null) {
            Log.e("Console", "engine null!");
            return;
        }
        this.f42574e.a().v("exchangeList", new p(this));
        this.f42574e.a().u("spotIndexPriceData", new n(this));
        this.f42574e.a().v("assetBannerInfoFinished", new o(this));
    }

    public void onResume() {
        super.onResume();
        BaseModuleConfig.a().w("app_assets_spot_exposure", (HashMap) null);
    }

    public View ve(Context context) {
        a aVar = this.f42574e;
        if (aVar == null || aVar.a() == null) {
            return new View(context);
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        View E = this.f42574e.a().E("asset_tab_spot_header_layout_new.xml", getContext(), false, (JSONObject) null);
        this.f42763o = E;
        linearLayout.addView(E);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
        marginLayoutParams.topMargin = 20;
        View Bh = Bh();
        Bh.findViewById(R$id.tv_small_coin_to_htx).setVisibility(0);
        Bh.findViewById(R$id.v_line).setVisibility(0);
        linearLayout.addView(Bh, marginLayoutParams);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("listTitleLeft", (Object) getResources().getString(R$string.n_market_collecation_tab_name));
        jSONObject.put("listTitleCenter", (Object) getResources().getString(R$string.asset_spot_table_top_balance_new));
        jSONObject.put("listTitleRight", (Object) getResources().getString(R$string.asset_spot_table_top_income));
        jSONObject.put("showSelect", (Object) "1");
        linearLayout.addView(this.f42574e.a().E("asset_tab_list_header_title_layout.xml", getContext(), true, jSONObject));
        return linearLayout;
    }

    public String wa() {
        return "asset_tab_spot_expand_item.xml";
    }
}
