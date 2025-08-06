package v6;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import org.aspectj.runtime.internal.AroundClosure;

public class s extends AroundClosure {
    public s(Object[] objArr) {
        super(objArr);
    }

    public Object run(Object[] objArr) {
        Object[] objArr2 = this.state;
        ((WebView) objArr2[1]).setWebViewClient((WebViewClient) objArr2[2]);
        return null;
    }
}
