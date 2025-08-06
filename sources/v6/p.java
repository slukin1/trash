package v6;

import android.view.View;
import com.hbg.lib.core.webview.HBBaseWebActivity;

public final /* synthetic */ class p implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HBBaseWebActivity f60999b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f61000c;

    public /* synthetic */ p(HBBaseWebActivity hBBaseWebActivity, String str) {
        this.f60999b = hBBaseWebActivity;
        this.f61000c = str;
    }

    public final void onClick(View view) {
        this.f60999b.lambda$showTopIcon$7(this.f61000c, view);
    }
}
