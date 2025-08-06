package com.huobi.otc.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hbg.lib.core.ui.BaseFragment;
import com.hbg.lib.network.otc.core.bean.OtcFAQBean;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$string;
import com.huobi.otc.bean.OtcFAQDataType;
import com.huobi.otc.persenter.OtcFAQFragmentPresenter;
import dp.p;
import java.util.ArrayList;
import java.util.HashMap;
import s9.a;
import uf.c;

public class OtcFAQFragment extends BaseFragment<OtcFAQFragmentPresenter, OtcFAQFragmentPresenter.a> implements OtcFAQFragmentPresenter.a, p.h {

    /* renamed from: l  reason: collision with root package name */
    public EasyRecyclerView f79449l;

    /* renamed from: m  reason: collision with root package name */
    public p f79450m;

    public void Ah() {
    }

    /* renamed from: Ch */
    public OtcFAQFragmentPresenter xh() {
        return new OtcFAQFragmentPresenter();
    }

    /* renamed from: Dh */
    public OtcFAQFragmentPresenter.a zh() {
        return this;
    }

    public void Gg() {
        HuobiToastUtil.i(getResources().getString(R$string.server_error));
    }

    public void P3(OtcFAQBean otcFAQBean, boolean z11) {
        ((OtcFAQFragmentPresenter) yh()).b0(otcFAQBean.getCode(), z11 ? 1 : 2);
    }

    public void U3(ArrayList<a> arrayList) {
        this.f79449l.setData(arrayList);
    }

    public void initViews() {
        this.f79449l = (EasyRecyclerView) this.f67460i.b(R$id.rv_otc_faq);
    }

    public void onClick(OtcFAQDataType otcFAQDataType) {
        p pVar = new p(getActivity());
        this.f79450m = pVar;
        pVar.w(getActivity(), this);
        this.f79450m.x(otcFAQDataType.getDataBean());
        this.f79450m.show();
        HashMap hashMap = new HashMap();
        hashMap.put("faq_code", otcFAQDataType.getDataBean().getCode());
        c.b().i("click_faq", hashMap);
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R$layout.fragment_faq_otc, viewGroup, false);
    }
}
