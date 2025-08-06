package fi;

import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import com.huobi.asset2.index.tabfragment.spot.AssetCollateralTabChildFragment;

public final /* synthetic */ class j implements TextView.OnEditorActionListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetCollateralTabChildFragment f54590b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ EditText f54591c;

    public /* synthetic */ j(AssetCollateralTabChildFragment assetCollateralTabChildFragment, EditText editText) {
        this.f54590b = assetCollateralTabChildFragment;
        this.f54591c = editText;
    }

    public final boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
        return this.f54590b.ni(this.f54591c, textView, i11, keyEvent);
    }
}
