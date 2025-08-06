package ec;

import android.view.View;
import com.hbg.lib.widgets.CommonCheckBox;
import com.hbg.module.asset.withdraw.viewhandler.WithdrawReqListItemHandler;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ cc.a f54314b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CommonCheckBox f54315c;

    public /* synthetic */ a(cc.a aVar, CommonCheckBox commonCheckBox) {
        this.f54314b = aVar;
        this.f54315c = commonCheckBox;
    }

    public final void onClick(View view) {
        WithdrawReqListItemHandler.d(this.f54314b, this.f54315c, view);
    }
}
