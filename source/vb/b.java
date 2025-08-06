package vb;

import android.content.Context;
import com.hbg.lite.record.ui.SingleCurrencyRecordActivity;
import com.hbg.lite.wallet.bean.LegalDetailInfo;
import rx.functions.Action1;

public final /* synthetic */ class b implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f61006b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LegalDetailInfo f61007c;

    public /* synthetic */ b(Context context, LegalDetailInfo legalDetailInfo) {
        this.f61006b = context;
        this.f61007c = legalDetailInfo;
    }

    public final void call(Object obj) {
        SingleCurrencyRecordActivity.Dh(this.f61006b, this.f61007c);
    }
}
