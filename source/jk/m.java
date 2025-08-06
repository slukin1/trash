package jk;

import android.view.View;
import com.huobi.engineutils.bean.AssetBannerCardData;
import com.huobi.engineutils.widget.AssetBannerCardsWidget;

public final /* synthetic */ class m implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetBannerCardData f55976b;

    public /* synthetic */ m(AssetBannerCardData assetBannerCardData) {
        this.f55976b = assetBannerCardData;
    }

    public final void onClick(View view) {
        AssetBannerCardsWidget.a.e(this.f55976b, view);
    }
}
