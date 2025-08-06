package fk;

import com.huobi.edgeengine.template.widget.Widget;
import com.huobi.edgeengine.widget.MarginRateSectorWidget;
import com.huobi.supermargin.view.AssetMarginRateSector;

public final /* synthetic */ class e implements Widget.u {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AssetMarginRateSector f54666a;

    public /* synthetic */ e(AssetMarginRateSector assetMarginRateSector) {
        this.f54666a = assetMarginRateSector;
    }

    public final void a(String str) {
        MarginRateSectorWidget.Y(this.f54666a, str);
    }
}
