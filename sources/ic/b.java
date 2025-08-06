package ic;

import android.webkit.WebViewClient;
import com.hbg.module.community.widgets.rich.RichEditor;
import org.aspectj.runtime.internal.AroundClosure;

public class b extends AroundClosure {
    public b(Object[] objArr) {
        super(objArr);
    }

    public Object run(Object[] objArr) {
        Object[] objArr2 = this.state;
        ((RichEditor) objArr2[1]).setWebViewClient((WebViewClient) objArr2[2]);
        return null;
    }
}
