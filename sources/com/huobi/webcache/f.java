package com.huobi.webcache;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import org.aspectj.runtime.internal.AroundClosure;

public class f extends AroundClosure {
    public f(Object[] objArr) {
        super(objArr);
    }

    public Object run(Object[] objArr) {
        Object[] objArr2 = this.state;
        ((WebView) objArr2[1]).setWebViewClient((WebViewClient) objArr2[2]);
        return null;
    }
}
