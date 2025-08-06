package bl;

import android.view.View;
import com.huobi.finance.bean.ManageTabListItem;
import com.huobi.finance.viewhandler.ManageTabListItemHandler;

public final /* synthetic */ class w2 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ManageTabListItem f12779b;

    public /* synthetic */ w2(ManageTabListItem manageTabListItem) {
        this.f12779b = manageTabListItem;
    }

    public final void onClick(View view) {
        ManageTabListItemHandler.d(this.f12779b, view);
    }
}
