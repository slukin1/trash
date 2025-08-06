package z9;

import android.widget.Button;
import android.widget.CompoundButton;
import com.hbg.lib.widgets.dialog.DialogUtils;

public final /* synthetic */ class m0 implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Button f62071b;

    public /* synthetic */ m0(Button button) {
        this.f62071b = button;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
        DialogUtils.b.M0(this.f62071b, compoundButton, z11);
    }
}
