package com.huobi.otc.flutter;

import com.huobi.flutter.base.AbsGlobalFlutterFragment;
import io.flutter.embedding.engine.FlutterEngine;
import jp.v0;

public class OtcOrderDepositFragment extends AbsGlobalFlutterFragment {

    /* renamed from: i  reason: collision with root package name */
    public v0 f78521i;

    public String Bh() {
        return "otc_all_order";
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        this.f78521i = new v0(getActivity());
        if (getArguments() != null) {
            this.f78521i.r(getArguments());
        }
        this.f78521i.g(flutterEngine);
    }

    public String getInitialRoute() {
        return "otc_all_order";
    }

    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        if (!z11) {
            this.f78521i.p(1);
        }
    }
}
