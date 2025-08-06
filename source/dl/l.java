package dl;

import android.content.Intent;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import ke.a;

public final /* synthetic */ class l implements a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AbsGlobalFlutterActivity f53815a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Intent f53816b;

    public /* synthetic */ l(AbsGlobalFlutterActivity absGlobalFlutterActivity, Intent intent) {
        this.f53815a = absGlobalFlutterActivity;
        this.f53816b = intent;
    }

    public final void onClick() {
        this.f53815a.fi(this.f53816b);
    }
}
