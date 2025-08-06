package sp;

import android.view.View;
import com.huobi.otc.ui.AddNewAddressActivity;

public final /* synthetic */ class b implements View.OnFocusChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddNewAddressActivity f25995b;

    public /* synthetic */ b(AddNewAddressActivity addNewAddressActivity) {
        this.f25995b = addNewAddressActivity;
    }

    public final void onFocusChange(View view, boolean z11) {
        this.f25995b.th(view, z11);
    }
}
