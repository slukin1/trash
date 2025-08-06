package e7;

import android.webkit.WebViewClient;
import com.hbg.lib.imsdk.HbgDialogWebView;
import org.aspectj.runtime.internal.AroundClosure;

public class y extends AroundClosure {
    public y(Object[] objArr) {
        super(objArr);
    }

    public Object run(Object[] objArr) {
        Object[] objArr2 = this.state;
        ((HbgDialogWebView) objArr2[1]).setWebViewClient((WebViewClient) objArr2[2]);
        return null;
    }
}
