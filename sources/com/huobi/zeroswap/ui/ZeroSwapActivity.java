package com.huobi.zeroswap.ui;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.n0;
import androidx.lifecycle.z;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.fastjson.JSONObject;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.gson.Gson;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.module.libkt.base.ui.BaseActivity;
import com.huobi.zeroswap.model.TabItemModel;
import com.huobi.zeroswap.model.ZeroSwapTabModel;
import com.huobi.zeroswap.vm.ZeroSwapViewModel;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d10.l;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.f;
import kotlin.i;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.u;
import kotlin.jvm.internal.x;
import lj.g;

@Route(path = "/contract/activityZero")
public final class ZeroSwapActivity extends BaseActivity<g> {

    /* renamed from: i  reason: collision with root package name */
    public final i f21219i = new n0(Reflection.b(ZeroSwapViewModel.class), new ZeroSwapActivity$special$$inlined$viewModels$default$2(this), new ZeroSwapActivity$viewModel$2(this), new ZeroSwapActivity$special$$inlined$viewModels$default$3((d10.a) null, this));

    public static final class a implements TabLayout.OnTabSelectedListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ZeroSwapTabModel f21220b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ZeroSwapActivity f21221c;

        public a(ZeroSwapTabModel zeroSwapTabModel, ZeroSwapActivity zeroSwapActivity) {
            this.f21220b = zeroSwapTabModel;
            this.f21221c = zeroSwapActivity;
        }

        public void onTabReselected(TabLayout.Tab tab) {
        }

        @SensorsDataInstrumented
        public void onTabSelected(TabLayout.Tab tab) {
            String str;
            boolean z11 = false;
            int position = tab != null ? tab.getPosition() : 0;
            TabItemModel tabItemModel = (TabItemModel) CollectionsKt___CollectionsKt.d0(this.f21220b.getTabs(), position);
            if (tabItemModel == null || (str = tabItemModel.getOnAppear()) == null) {
                str = "";
            }
            if (str.length() > 0) {
                z11 = true;
            }
            if (z11) {
                ZeroSwapViewModel Dh = this.f21221c.Hh();
                String w02 = this.f21221c.Hh().w0();
                Dh.d(w02, str + "()");
            }
            this.f21221c.Nh(position);
            SensorsDataAutoTrackHelper.trackTabLayoutSelected(this, tab);
        }

        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    public static final class b implements z, u {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f21222b;

        public b(l lVar) {
            this.f21222b = lVar;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof z) || !(obj instanceof u)) {
                return false;
            }
            return x.b(getFunctionDelegate(), ((u) obj).getFunctionDelegate());
        }

        public final f<?> getFunctionDelegate() {
            return this.f21222b;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f21222b.invoke(obj);
        }
    }

    public static final /* synthetic */ g Ch(ZeroSwapActivity zeroSwapActivity) {
        return (g) zeroSwapActivity.Yf();
    }

    @SensorsDataInstrumented
    public static final void Ih(ZeroSwapActivity zeroSwapActivity, View view) {
        zeroSwapActivity.finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static final void Jh(ZeroSwapActivity zeroSwapActivity, View view) {
        zeroSwapActivity.Hh().y0();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static final void Lh(ZeroSwapActivity zeroSwapActivity, g gVar, Object obj) {
        if (obj instanceof String) {
            if (((CharSequence) obj).length() > 0) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ZeroSwapTabModel zeroSwapTabModel = (ZeroSwapTabModel) new Gson().fromJson((String) obj, ZeroSwapTabModel.class);
                for (TabItemModel next : zeroSwapTabModel.getTabs()) {
                    ZeroSwapViewModel Hh = zeroSwapActivity.Hh();
                    String w02 = zeroSwapActivity.Hh().w0();
                    View r02 = com.huobi.zeroswap.vm.a.r0(Hh, w02, next.getTemplate() + ".xml", (ViewGroup) null, (JSONObject) null, 12, (Object) null);
                    if (r02 != null) {
                        arrayList.add(next.getTitle());
                        arrayList2.add(r02);
                    }
                }
                if (true ^ arrayList.isEmpty()) {
                    gVar.H.setUserInputEnabled(false);
                    gVar.H.setOffscreenPageLimit(arrayList2.size());
                    gVar.H.setAdapter(new mv.a(arrayList2));
                    new TabLayoutMediator(gVar.E, gVar.H, new c(arrayList)).attach();
                    gVar.E.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new a(zeroSwapTabModel, zeroSwapActivity));
                    zeroSwapActivity.Hh().u0();
                    zeroSwapActivity.Nh(0);
                    zeroSwapActivity.Hh().x0();
                }
            }
        }
    }

    public static final void Mh(ArrayList arrayList, TabLayout.Tab tab, int i11) {
        tab.setText((CharSequence) arrayList.get(i11));
    }

    /* renamed from: Gh */
    public g Og() {
        return g.K(getLayoutInflater());
    }

    public final ZeroSwapViewModel Hh() {
        return (ZeroSwapViewModel) this.f21219i.getValue();
    }

    public final void Kh(g gVar) {
        Hh().z0(gVar.B);
        Hh().p0(Hh().w0(), "headerProfit.tabInfo", new d(this, gVar));
    }

    public final void Nh(int i11) {
        HashMap hashMap = new HashMap();
        hashMap.put("business_category", "usdt_0_yuan_buy");
        if (i11 == 0) {
            hashMap.put("button_name", "usdt_my_position_0_yuan");
        } else {
            hashMap.put("button_name", "usdt_history_0_yuan");
        }
        gs.g.i("appclick_contracts", hashMap);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getLifecycle().a(Hh());
        Qg(NightHelper.e().g());
        g gVar = (g) Yf();
        gVar.C.setOnClickListener(new a(this));
        gVar.D.setOnClickListener(new b(this));
        Hh().o0().observe(this, new b(new ZeroSwapActivity$onCreate$2(this)));
        Hh().v0().observe(this, new b(new ZeroSwapActivity$onCreate$3(this)));
        HashMap hashMap = new HashMap();
        hashMap.put("business_category", "usdt_0_yuan_buy");
        gs.g.i("pageview_contracts", hashMap);
    }
}
