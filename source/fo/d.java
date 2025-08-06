package fo;

import android.view.View;
import com.huobi.main.ui.HuobiMainActivity;
import com.huobi.view.radiogroup.RadioGroupContainer;

public final /* synthetic */ class d implements RadioGroupContainer.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HuobiMainActivity f54714a;

    public /* synthetic */ d(HuobiMainActivity huobiMainActivity) {
        this.f54714a = huobiMainActivity;
    }

    public final void onCheckedChanged(RadioGroupContainer radioGroupContainer, View view, int i11, int i12) {
        this.f54714a.Zh(radioGroupContainer, view, i11, i12);
    }
}
