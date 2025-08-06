package ns;

import android.view.View;
import com.huobi.finance.bean.TransferOrderHistory;
import com.huobi.supermargin.viewhandler.LoanNotPayOffViewHandler;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransferOrderHistory f58705b;

    public /* synthetic */ a(TransferOrderHistory transferOrderHistory) {
        this.f58705b = transferOrderHistory;
    }

    public final void onClick(View view) {
        LoanNotPayOffViewHandler.d(this.f58705b, view);
    }
}
