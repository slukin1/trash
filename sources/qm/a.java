package qm;

import android.content.Context;
import android.view.View;
import com.hbg.lib.network.newkyc.bean.KycCountryInfo;
import com.huobi.kyc.binder.KycCountryBinder;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ KycCountryInfo f60056b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f60057c;

    public /* synthetic */ a(KycCountryInfo kycCountryInfo, Context context) {
        this.f60056b = kycCountryInfo;
        this.f60057c = context;
    }

    public final void onClick(View view) {
        KycCountryBinder.r(this.f60056b, this.f60057c, view);
    }
}
