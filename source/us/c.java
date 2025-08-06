package us;

import android.widget.Button;
import android.widget.CompoundButton;
import us.e;

public final /* synthetic */ class c implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Button f60927b;

    public /* synthetic */ c(Button button) {
        this.f60927b = button;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
        e.a.h(this.f60927b, compoundButton, z11);
    }
}
