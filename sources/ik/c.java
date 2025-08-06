package ik;

import android.graphics.Bitmap;
import com.hbg.lib.network.hbg.grid.bean.GridStrategyInfo;
import com.huobi.share.AssetShareHelper;
import com.huobi.share.TradingBotShareView;
import java.util.ArrayList;

public final /* synthetic */ class c implements TradingBotShareView.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GridStrategyInfo f55107a;

    public /* synthetic */ c(GridStrategyInfo gridStrategyInfo) {
        this.f55107a = gridStrategyInfo;
    }

    public final void a(ArrayList arrayList) {
        AssetShareHelper.newShareWithImages((Bitmap) arrayList.get(0), "holigeit://open/v1?url=ihuobiglobal://m.hbg.com/trade/bot?source=app_share_qrcode&tabIndex=4&markCode=" + this.f55107a.getMarkCode(), "asset");
    }
}
