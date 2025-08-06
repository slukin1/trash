package com.huobi.edgeengine.widget;

import android.content.Context;
import android.view.View;
import com.huobi.edgeengine.template.widget.Widget;
import com.huobi.supermargin.view.AssetMarginRateSector;
import fk.e;
import java.util.Map;
import kotlin.jvm.internal.r;
import rj.n;

public final class MarginRateSectorWidget extends Widget {

    /* renamed from: j0  reason: collision with root package name */
    public static final a f44391j0 = new a((r) null);

    /* renamed from: h0  reason: collision with root package name */
    public String f44392h0;

    /* renamed from: i0  reason: collision with root package name */
    public String f44393i0;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public static final void Y(AssetMarginRateSector assetMarginRateSector, String str) {
        boolean z11 = false;
        assetMarginRateSector.setEmpty(str == null || str.length() == 0);
        if (str == null || str.length() == 0) {
            z11 = true;
        }
        if (!z11) {
            Float k11 = StringsKt__StringNumberConversionsJVMKt.k(str);
            assetMarginRateSector.setRate(String.valueOf(k11 != null ? k11.floatValue() : 0.0f));
        }
    }

    public void C(Context context, Map<String, String> map) {
        super.C(context, map);
        this.f44392h0 = map.get("accountType");
        this.f44393i0 = map.get("rate");
    }

    public View Q(Context context, n nVar) {
        AssetMarginRateSector assetMarginRateSector = (AssetMarginRateSector) super.Q(context, nVar);
        assetMarginRateSector.c(500, 100);
        w(context, this.f44393i0, new e(assetMarginRateSector), nVar);
        return assetMarginRateSector;
    }

    public View q(Context context) {
        return new AssetMarginRateSector(context);
    }
}
