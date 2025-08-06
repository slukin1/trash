package ic;

import android.webkit.WebViewClient;
import com.hbg.module.community.widgets.rich.RichWebView;
import org.aspectj.runtime.internal.AroundClosure;

public class d extends AroundClosure {
    public d(Object[] objArr) {
        super(objArr);
    }

    public Object run(Object[] objArr) {
        Object[] objArr2 = this.state;
        ((RichWebView) objArr2[1]).setWebViewClient((WebViewClient) objArr2[2]);
        return null;
    }
}
