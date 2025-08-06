package com.huobi.otc.edgeengine.p2p.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.hbg.lib.common.utils.ThreadUtils;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.network.otc.core.bean.MktRulePageBean;
import com.huobi.edgeengine.template.widget.Widget;
import com.huobi.otc.bean.OtcBannerBean;
import com.huobi.otc.persenter.OtcTradePresenter;
import com.huobi.otc.widget.OtcTradeBannerView;
import fp.b;
import i6.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import rj.n;

public class OtcBannerWidget extends Widget {

    /* renamed from: h0  reason: collision with root package name */
    public ArrayList<OtcBannerBean> f78390h0 = new ArrayList<>();

    /* renamed from: i0  reason: collision with root package name */
    public String f78391i0;

    /* renamed from: j0  reason: collision with root package name */
    public String f78392j0;

    public class a extends TypeToken<List<MktRulePageBean>> {
        public a() {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a0(String str) {
        try {
            d.j("refreshBanner", "datas-->" + this.f78391i0 + " value->" + str);
            List list = (List) new Gson().fromJson(str, new a().getType());
            if (!CollectionsUtils.b(list)) {
                ArrayList<OtcBannerBean> arrayList = new ArrayList<>();
                for (int i11 = 0; i11 < list.size(); i11++) {
                    if (((MktRulePageBean) list.get(i11)).getContent() != null) {
                        List<Map<String, Object>> content = ((MktRulePageBean) list.get(i11)).getContent();
                        OtcBannerBean otcBannerBean = new OtcBannerBean();
                        for (int i12 = 0; i12 < content.size(); i12++) {
                            Map map = content.get(i12);
                            double doubleValue = ((Double) map.get("type")).doubleValue();
                            Object obj = map.get("value");
                            if (doubleValue == 4.0d) {
                                if (obj instanceof String) {
                                    otcBannerBean.setImageUrl((String) obj);
                                }
                                arrayList.add(otcBannerBean);
                            } else if (doubleValue == 8.0d && (obj instanceof LinkedTreeMap)) {
                                otcBannerBean.setJumpUrl(((LinkedTreeMap) obj).get("link").toString());
                            }
                        }
                    }
                }
                this.f78390h0 = arrayList;
                return;
            }
            this.f78390h0.clear();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b0(Context context, OtcTradeBannerView otcTradeBannerView, String str) {
        try {
            int A = A(context, Float.valueOf(str).floatValue());
            if (!(otcTradeBannerView.getHeight() == A && otcTradeBannerView.getMeasuredHeight() == A)) {
                ViewGroup.LayoutParams layoutParams = otcTradeBannerView.getLayoutParams();
                layoutParams.height = A;
                otcTradeBannerView.setLayoutParams(layoutParams);
            }
            d.j("refreshBanner", "height-->" + this.f78392j0 + " " + A + " mOtcBannerBeans->" + CollectionsUtils.b(this.f78390h0) + " main->" + ThreadUtils.a());
            if (A != 0) {
                if (!CollectionsUtils.b(this.f78390h0)) {
                    otcTradeBannerView.g(this.f78390h0, (OtcTradePresenter.i) null, false);
                    return;
                }
            }
            otcTradeBannerView.g((List<OtcBannerBean>) null, (OtcTradePresenter.i) null, false);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void C(Context context, Map<String, String> map) {
        super.C(context, map);
        this.f78391i0 = map.get("datas");
        this.f78392j0 = map.get("height");
    }

    public View Q(Context context, n nVar) {
        OtcTradeBannerView otcTradeBannerView = (OtcTradeBannerView) super.Q(context, nVar);
        w(context, this.f78391i0, new fp.a(this), nVar);
        w(context, this.f78392j0, new b(this, context, otcTradeBannerView), nVar);
        return otcTradeBannerView;
    }

    /* renamed from: Z */
    public OtcTradeBannerView q(Context context) {
        return new OtcTradeBannerView(context);
    }
}
