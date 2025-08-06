package jp;

import android.widget.CompoundButton;
import com.huobi.otc.helper.OtcDialogUtils;

public final /* synthetic */ class u implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcDialogUtils.b f56063b;

    public /* synthetic */ u(OtcDialogUtils.b bVar) {
        this.f56063b = bVar;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
        this.f56063b.o(compoundButton, z11);
    }
}
