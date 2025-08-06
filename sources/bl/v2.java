package bl;

import android.view.View;
import com.huobi.finance.bean.ManageAddressListItem;
import com.huobi.finance.viewhandler.ManageAddressListItemHandler;

public final /* synthetic */ class v2 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ManageAddressListItem f12770b;

    public /* synthetic */ v2(ManageAddressListItem manageAddressListItem) {
        this.f12770b = manageAddressListItem;
    }

    public final void onClick(View view) {
        ManageAddressListItemHandler.g(this.f12770b, view);
    }
}
