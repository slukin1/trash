package v6;

import android.view.View;
import com.hbg.lib.core.webview.HBBaseWebActivity;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HBBaseWebActivity f60982b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f60983c;

    public /* synthetic */ b(HBBaseWebActivity hBBaseWebActivity, String str) {
        this.f60982b = hBBaseWebActivity;
        this.f60983c = str;
    }

    public final void onClick(View view) {
        this.f60982b.lambda$showTopIcon$6(this.f60983c, view);
    }
}
