package fi;

import android.view.View;
import android.widget.EditText;
import com.huobi.asset2.index.tabfragment.spot.AssetCollateralTabChildFragment;

public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EditText f54516b;

    public /* synthetic */ d(EditText editText) {
        this.f54516b = editText;
    }

    public final void onClick(View view) {
        AssetCollateralTabChildFragment.ji(this.f54516b, view);
    }
}
