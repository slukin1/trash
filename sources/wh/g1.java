package wh;

import android.view.KeyEvent;
import android.widget.TextView;
import com.huobi.asset2.index.BaseAssetChildTabFragment;

public final /* synthetic */ class g1 implements TextView.OnEditorActionListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BaseAssetChildTabFragment f61302b;

    public /* synthetic */ g1(BaseAssetChildTabFragment baseAssetChildTabFragment) {
        this.f61302b = baseAssetChildTabFragment;
    }

    public final boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
        return this.f61302b.Lh(textView, i11, keyEvent);
    }
}
