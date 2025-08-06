package qk;

import android.view.View;
import com.huobi.contract.ui.ContractGearsTradePriceEditText;
import com.huobi.feature.util.FutureTpSlHelper;

public final /* synthetic */ class g0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FutureTpSlHelper f59968b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ContractGearsTradePriceEditText f59969c;

    public /* synthetic */ g0(FutureTpSlHelper futureTpSlHelper, ContractGearsTradePriceEditText contractGearsTradePriceEditText) {
        this.f59968b = futureTpSlHelper;
        this.f59969c = contractGearsTradePriceEditText;
    }

    public final void onClick(View view) {
        this.f59968b.e1(this.f59969c, view);
    }
}
