package v6;

import android.view.View;
import com.hbg.lib.core.webview.HBBaseWebActivity;

public final /* synthetic */ class q implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HBBaseWebActivity f61001b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f61002c;

    public /* synthetic */ q(HBBaseWebActivity hBBaseWebActivity, String str) {
        this.f61001b = hBBaseWebActivity;
        this.f61002c = str;
    }

    public final void onClick(View view) {
        this.f61001b.lambda$showTopIcon$5(this.f61002c, view);
    }
}
