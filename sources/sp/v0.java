package sp;

import android.view.View;
import com.huobi.otc.ui.OtcFAQActivity;

public final /* synthetic */ class v0 implements View.OnScrollChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OtcFAQActivity f26100a;

    public /* synthetic */ v0(OtcFAQActivity otcFAQActivity) {
        this.f26100a = otcFAQActivity;
    }

    public final void onScrollChange(View view, int i11, int i12, int i13, int i14) {
        this.f26100a.xh(view, i11, i12, i13, i14);
    }
}
