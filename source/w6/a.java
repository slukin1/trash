package w6;

import android.net.Uri;
import android.webkit.ValueCallback;

public final /* synthetic */ class a implements ValueCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ValueCallback f61222a;

    public /* synthetic */ a(ValueCallback valueCallback) {
        this.f61222a = valueCallback;
    }

    public final void onReceiveValue(Object obj) {
        b.c(this.f61222a, (Uri) obj);
    }
}
