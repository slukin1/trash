package bl;

import android.view.View;
import com.huobi.finance.bean.ManageAddressListItem;
import com.huobi.finance.viewhandler.ManageAddressListItemHandler;

public final /* synthetic */ class u2 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ManageAddressListItem f12758b;

    public /* synthetic */ u2(ManageAddressListItem manageAddressListItem) {
        this.f12758b = manageAddressListItem;
    }

    public final void onClick(View view) {
        ManageAddressListItemHandler.j(this.f12758b, view);
    }
}
