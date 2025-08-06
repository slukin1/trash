package com.huobi.otc.edgeengine.p2p.widget;

import android.content.Context;
import android.view.View;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hbg.lib.core.util.CollectionsUtils;
import com.huobi.edgeengine.template.widget.Widget;
import com.huobi.otc.bean.Ads;
import com.huobi.otc.widget.PaymentGroupView;
import fp.c;
import java.util.List;
import java.util.Map;
import rj.n;

public class OtcPayMethodsEdgeWidget extends Widget {

    /* renamed from: h0  reason: collision with root package name */
    public String f78394h0;

    /* renamed from: i0  reason: collision with root package name */
    public String f78395i0;

    public class a extends TypeToken<List<Ads.PaymentInfo>> {
        public a() {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Z(PaymentGroupView paymentGroupView, String str) {
        try {
            List list = (List) new Gson().fromJson(str, new a().getType());
            if (!CollectionsUtils.b(list)) {
                paymentGroupView.setPaymentInfos(list);
                paymentGroupView.setVisibility(0);
                return;
            }
            paymentGroupView.setVisibility(8);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void C(Context context, Map<String, String> map) {
        super.C(context, map);
        this.f78394h0 = map.get("data");
        this.f78395i0 = map.get("height");
    }

    public View Q(Context context, n nVar) {
        PaymentGroupView paymentGroupView = (PaymentGroupView) super.Q(context, nVar);
        paymentGroupView.setChildGravity(5);
        w(context, this.f78394h0, new c(this, paymentGroupView), nVar);
        return paymentGroupView;
    }

    /* renamed from: Y */
    public PaymentGroupView q(Context context) {
        return new PaymentGroupView(context);
    }
}
