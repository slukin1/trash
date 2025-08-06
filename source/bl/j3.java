package bl;

import android.view.View;
import com.huobi.finance.bean.WithdrawTypeItem;
import com.huobi.finance.viewhandler.WithdrawTypeViewHandler;

public final /* synthetic */ class j3 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f12634b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ WithdrawTypeItem f12635c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f12636d;

    public /* synthetic */ j3(boolean z11, WithdrawTypeItem withdrawTypeItem, int i11) {
        this.f12634b = z11;
        this.f12635c = withdrawTypeItem;
        this.f12636d = i11;
    }

    public final void onClick(View view) {
        WithdrawTypeViewHandler.d(this.f12634b, this.f12635c, this.f12636d, view);
    }
}
