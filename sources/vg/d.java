package vg;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.hbg.lib.widgets.CommonCheckBox;
import com.huobi.account.entity.MultipleAccountData;
import com.huobi.account.viewhandler.MultipleAccountHandler;

public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MultipleAccountData f61012b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ConstraintLayout f61013c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CommonCheckBox f61014d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f61015e;

    public /* synthetic */ d(MultipleAccountData multipleAccountData, ConstraintLayout constraintLayout, CommonCheckBox commonCheckBox, int i11) {
        this.f61012b = multipleAccountData;
        this.f61013c = constraintLayout;
        this.f61014d = commonCheckBox;
        this.f61015e = i11;
    }

    public final void onClick(View view) {
        MultipleAccountHandler.d(this.f61012b, this.f61013c, this.f61014d, this.f61015e, view);
    }
}
