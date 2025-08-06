package vh;

import android.view.KeyEvent;
import android.widget.TextView;
import com.huobi.asset.widget.FilterBar;

public final /* synthetic */ class k0 implements TextView.OnEditorActionListener {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ k0 f61042b = new k0();

    public final boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
        return FilterBar.l(textView, i11, keyEvent);
    }
}
