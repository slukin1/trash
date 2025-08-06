package bl;

import android.view.View;
import com.huobi.finance.bean.ManageAddressListItem;
import com.huobi.finance.viewhandler.ManageAddressListItemHandler;

public final /* synthetic */ class t2 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ManageAddressListItem f12745b;

    public /* synthetic */ t2(ManageAddressListItem manageAddressListItem) {
        this.f12745b = manageAddressListItem;
    }

    public final void onClick(View view) {
        ManageAddressListItemHandler.h(this.f12745b, view);
    }
}
