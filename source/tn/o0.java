package tn;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import org.aspectj.runtime.internal.AroundClosure;

public class o0 extends AroundClosure {
    public o0(Object[] objArr) {
        super(objArr);
    }

    public Object run(Object[] objArr) {
        Object[] objArr2 = this.state;
        ((WebView) objArr2[1]).setWebViewClient((WebViewClient) objArr2[2]);
        return null;
    }
}
