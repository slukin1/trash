package mg;

import android.webkit.WebViewClient;
import com.huawei.secure.android.common.webview.SafeWebView;
import org.aspectj.runtime.internal.AroundClosure;

public class a extends AroundClosure {
    public a(Object[] objArr) {
        super(objArr);
    }

    public Object run(Object[] objArr) {
        Object[] objArr2 = this.state;
        ((SafeWebView) objArr2[1]).setWebViewClient((WebViewClient) objArr2[2]);
        return null;
    }
}
