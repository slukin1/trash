package sp;

import android.view.View;
import com.huobi.otc.ui.AddNewAddressActivity;

public final /* synthetic */ class a implements View.OnFocusChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddNewAddressActivity f25990b;

    public /* synthetic */ a(AddNewAddressActivity addNewAddressActivity) {
        this.f25990b = addNewAddressActivity;
    }

    public final void onFocusChange(View view, boolean z11) {
        this.f25990b.sh(view, z11);
    }
}
