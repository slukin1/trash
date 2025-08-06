package com.hbg.module.content.custom;

import android.webkit.WebViewClient;
import com.hbg.lib.core.webview.HBWebView;
import org.aspectj.runtime.internal.AroundClosure;

public class f extends AroundClosure {
    public f(Object[] objArr) {
        super(objArr);
    }

    public Object run(Object[] objArr) {
        Object[] objArr2 = this.state;
        ((HBWebView) objArr2[1]).setWebViewClient((WebViewClient) objArr2[2]);
        return null;
    }
}
