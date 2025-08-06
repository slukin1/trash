package eq;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.huobi.permission.source.Source;

public class a extends Source {

    /* renamed from: a  reason: collision with root package name */
    public Activity f84120a;

    public a(Activity activity) {
        this.f84120a = activity;
    }

    public Context a() {
        return this.f84120a;
    }

    public void b(Intent intent, int i11) {
        this.f84120a.startActivityForResult(intent, i11);
    }
}
