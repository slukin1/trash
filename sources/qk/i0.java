package qk;

import android.view.View;
import android.widget.EditText;
import com.huobi.contract.ui.ContractGearsTradePriceEditText;
import com.huobi.feature.util.FutureTpSlHelper;
import dj.k4;

public final /* synthetic */ class i0 implements k4 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractGearsTradePriceEditText f59972b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ EditText f59973c;

    public /* synthetic */ i0(ContractGearsTradePriceEditText contractGearsTradePriceEditText, EditText editText) {
        this.f59972b = contractGearsTradePriceEditText;
        this.f59973c = editText;
    }

    public final void onFocusChange(View view, boolean z11) {
        FutureTpSlHelper.d1(this.f59972b, this.f59973c, view, z11);
    }
}
