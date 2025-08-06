package jp;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import com.hbg.lib.network.otc.core.OTCStatusExtendResponse;
import jp.f;

public final /* synthetic */ class e implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f f56004b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Dialog f56005c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Context f56006d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ OTCStatusExtendResponse.ExtendBean f56007e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ f.b f56008f;

    public /* synthetic */ e(f fVar, Dialog dialog, Context context, OTCStatusExtendResponse.ExtendBean extendBean, f.b bVar) {
        this.f56004b = fVar;
        this.f56005c = dialog;
        this.f56006d = context;
        this.f56007e = extendBean;
        this.f56008f = bVar;
    }

    public final void onClick(View view) {
        this.f56004b.g(this.f56005c, this.f56006d, this.f56007e, this.f56008f, view);
    }
}
