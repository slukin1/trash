package fi;

import android.view.View;
import android.widget.EditText;
import com.huobi.asset2.index.tabfragment.spot.AssetCollateralTabChildFragment;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public final /* synthetic */ class i implements View.OnFocusChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AtomicLong f54522b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f54523c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ EditText f54524d;

    public /* synthetic */ i(AtomicLong atomicLong, AtomicBoolean atomicBoolean, EditText editText) {
        this.f54522b = atomicLong;
        this.f54523c = atomicBoolean;
        this.f54524d = editText;
    }

    public final void onFocusChange(View view, boolean z11) {
        AssetCollateralTabChildFragment.li(this.f54522b, this.f54523c, this.f54524d, view, z11);
    }
}
