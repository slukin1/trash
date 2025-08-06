package jp;

import android.widget.CompoundButton;
import com.huobi.otc.helper.OtcDialogUtils;

public final /* synthetic */ class t implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcDialogUtils.b f56060b;

    public /* synthetic */ t(OtcDialogUtils.b bVar) {
        this.f56060b = bVar;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
        this.f56060b.n(compoundButton, z11);
    }
}
