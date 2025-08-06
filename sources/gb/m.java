package gb;

import android.view.View;
import com.hbg.lib.network.hbg.core.bean.TeachConfigItem;
import com.hbg.lite.market.LiteMarketInfoActivity;

public final /* synthetic */ class m implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LiteMarketInfoActivity f54816b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TeachConfigItem f54817c;

    public /* synthetic */ m(LiteMarketInfoActivity liteMarketInfoActivity, TeachConfigItem teachConfigItem) {
        this.f54816b = liteMarketInfoActivity;
        this.f54817c = teachConfigItem;
    }

    public final void onClick(View view) {
        this.f54816b.Ph(this.f54817c, view);
    }
}
