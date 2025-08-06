package com.huobi.webcache;

import android.webkit.WebViewClient;
import org.aspectj.runtime.internal.AroundClosure;

public class d extends AroundClosure {
    public d(Object[] objArr) {
        super(objArr);
    }

    public Object run(Object[] objArr) {
        Object[] objArr2 = this.state;
        ((OnlyCacheWebView) objArr2[1]).setWebViewClient((WebViewClient) objArr2[2]);
        return null;
    }
}
