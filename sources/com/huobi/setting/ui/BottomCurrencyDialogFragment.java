package com.huobi.setting.ui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.network.hbg.core.bean.PricingMethodBean;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.litere.helper.LiteReHelper;
import com.huobi.view.BaseBottomCurrencyDialogFragment;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.i;
import i6.m;
import i6.r;
import ir.a;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jr.b;
import pro.huobi.R;

public class BottomCurrencyDialogFragment extends BaseBottomCurrencyDialogFragment implements a.C0869a {

    /* renamed from: b  reason: collision with root package name */
    public List<a> f80803b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f80804c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f80805d;

    /* renamed from: e  reason: collision with root package name */
    public String f80806e;

    /* renamed from: f  reason: collision with root package name */
    public String f80807f;

    /* renamed from: g  reason: collision with root package name */
    public EasyRecyclerView<a> f80808g;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initListener$0(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void rh() {
        if (this.mCurrencyMethodChangedCallback != null && !TextUtils.equals(this.f80807f, this.f80806e)) {
            this.mCurrencyMethodChangedCallback.onCurrencyMethodChanged(this.f80806e);
        }
        this.f80805d = true;
        dismiss();
    }

    public Object G9(String str) {
        return LegalCurrencyConfigUtil.q(getContext(), str);
    }

    public boolean Vg(String str) {
        return TextUtils.equals(str, this.f80806e);
    }

    public int getPeekHeight() {
        return PixelUtils.a(606.0f);
    }

    public final void init() {
        this.f80808g.setData(this.f80803b);
    }

    public final void initListener(r rVar) {
        rVar.b(R.id.tv_close).setOnClickListener(new jr.a(this));
    }

    public final void initView(r rVar) {
        this.f80808g = (EasyRecyclerView) rVar.b(R.id.id_base_list_dialog_recyclerView);
    }

    public void j(String str) {
        this.f80806e = str;
        LegalCurrencyConfigUtil.c0(str);
        LegalCurrencyConfigUtil.f0(false);
        i.b().f(new b(this));
    }

    public String nc(String str) {
        if (getActivity() == null) {
            return "";
        }
        return LegalCurrencyConfigUtil.r(str, false) + " " + LegalCurrencyConfigUtil.t(getActivity().getApplicationContext(), str);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String y11 = LegalCurrencyConfigUtil.y();
        this.f80806e = y11;
        this.f80807f = y11;
        List<a> list = this.f80803b;
        if (list == null || list.isEmpty()) {
            this.f80803b = new ArrayList(LegalCurrencyConfigUtil.f43758b.size());
            for (PricingMethodBean next : LegalCurrencyConfigUtil.f43758b) {
                if (!"krw".equals(next.getAbbr()) || !LiteReHelper.a().b()) {
                    this.f80803b.add(new a(next.getAbbr(), this));
                }
            }
        }
        List<a> list2 = this.f80803b;
        if (list2 != null && !list2.isEmpty()) {
            this.f80804c = new HashMap(this.f80803b.size());
            for (a aVar : this.f80803b) {
                Map<String, String> map = this.f80804c;
                String str = aVar.f84297c;
                map.put(str, sh(str));
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.dialog_fragment_select_currency_layout, viewGroup, false);
        r rVar = new r(inflate);
        initView(rVar);
        initListener(rVar);
        init();
        return inflate;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (!this.f80805d) {
            gi.a.o();
        }
        this.f80805d = false;
    }

    public final String sh(String str) {
        if (Vg(str)) {
            return getActivity().getApplicationContext().getString(R.string.n_current_currency);
        }
        String v11 = LegalCurrencyConfigUtil.v();
        String s11 = LegalCurrencyConfigUtil.s(LegalCurrencyConfigUtil.O(str));
        StringBuilder sb2 = new StringBuilder();
        sb2.append("1");
        sb2.append(this.f80806e);
        sb2.append("≈");
        if (!m.a0(s11) || !m.a0(v11)) {
            sb2.append("--");
        } else {
            sb2.append(new BigDecimal(s11).divide(new BigDecimal(v11), 4, 5).stripTrailingZeros().toString());
        }
        sb2.append(str);
        return sb2.toString();
    }
}
