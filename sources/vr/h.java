package vr;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.hbg.lib.core.GlobalAppConfig;
import i6.d;
import java.io.File;
import we.b;
import wf.a;

public class h extends a {

    /* renamed from: d  reason: collision with root package name */
    public String f85018d = "";

    public h(Context context) {
        super(context);
        this.f85013a = true;
    }

    public static /* synthetic */ void o(int i11, String str) {
        Class<String> cls = String.class;
        if (i11 == 0) {
            b.l("share_event_back", cls).g("success");
        } else {
            b.l("share_event_back", cls).g("fail");
        }
    }

    public static /* synthetic */ void p(int i11, String str) {
        Class<String> cls = String.class;
        d.c("ray13", "error code " + i11 + " error msg " + str);
        if (i11 == 0) {
            b.l("share_event_back", cls).g("success");
        } else {
            b.l("share_event_back", cls).g("fail");
        }
    }

    public static /* synthetic */ void q(int i11, String str) {
        Class<String> cls = String.class;
        d.c("ray13", "error code " + i11 + " error msg " + str);
        if (i11 == 0) {
            b.l("share_event_back", cls).g("success");
        } else {
            b.l("share_event_back", cls).g("fail");
        }
    }

    public void a() {
        super.a();
    }

    public void c(String str, String str2, String str3) {
        Uri uri;
        File file = new File(str2);
        if (file.exists()) {
            if (n()) {
                uri = FileProvider.getUriForFile(this.f85014b, GlobalAppConfig.a() + ".fileprovider", new File(str2));
            } else {
                uri = Uri.fromFile(file);
            }
            Uri uri2 = uri;
            if (str != null) {
                a.n(this.f85014b, uri2, str, (String) null, str3, f.f61200a);
            }
        }
    }

    public void d(String str) {
    }

    public void e(String str, String str2, String str3) {
        this.f85018d = str;
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            a.m(this.f85014b, (Bitmap) null, str2, str3, "", g.f61201a);
        }
    }

    public void f(String str, String str2, String str3, String str4) {
        this.f85018d = str;
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            a.m(this.f85014b, (Bitmap) null, str2, str3, str4, e.f61199a);
        }
    }

    public boolean n() {
        return Build.VERSION.SDK_INT >= 24;
    }
}
