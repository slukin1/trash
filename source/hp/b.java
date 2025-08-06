package hp;

import android.view.View;
import com.huobi.otc.bean.Ads;
import com.huobi.otc.handler.AdsViewHandler;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Ads f54948b;

    public /* synthetic */ b(Ads ads) {
        this.f54948b = ads;
    }

    public final void onClick(View view) {
        AdsViewHandler.l(this.f54948b, view);
    }
}
