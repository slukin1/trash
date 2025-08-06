package bl;

import android.view.View;
import com.huobi.finance.bean.AddAddrListItem;
import com.huobi.finance.viewhandler.AddAddrListItemHandler;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddAddrListItem f12551b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f12552c;

    public /* synthetic */ c(AddAddrListItem addAddrListItem, int i11) {
        this.f12551b = addAddrListItem;
        this.f12552c = i11;
    }

    public final void onClick(View view) {
        AddAddrListItemHandler.d(this.f12551b, this.f12552c, view);
    }
}
