package bl;

import android.view.View;
import com.huobi.finance.bean.ManageAddressListItem;
import com.huobi.finance.viewhandler.ManageAddressListItemHandler;

public final /* synthetic */ class s2 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ManageAddressListItem f12733b;

    public /* synthetic */ s2(ManageAddressListItem manageAddressListItem) {
        this.f12733b = manageAddressListItem;
    }

    public final void onClick(View view) {
        ManageAddressListItemHandler.i(this.f12733b, view);
    }
}
