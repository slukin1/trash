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
import wf.b;

public class c extends a {

    /* renamed from: d  reason: collision with root package name */
    public String f85016d = "";

    public class a implements b {
        public a() {
        }

        public void a(int i11, String str) {
            Class<String> cls = String.class;
            d.c("ray13", "error code " + i11 + " error msg " + str);
            if (i11 == 0) {
                we.b.l("share_event_back", cls).g("success");
            } else {
                we.b.l("share_event_back", cls).g("fail");
            }
        }
    }

    public c(Context context) {
        super(context);
        this.f85013a = true;
    }

    public static /* synthetic */ void m(int i11, String str) {
        Class<String> cls = String.class;
        d.c("ray13", "error code " + i11 + " error msg " + str);
        if (i11 == 0) {
            we.b.l("share_event_back", cls).g("success");
        } else {
            we.b.l("share_event_back", cls).g("fail");
        }
    }

    public void a() {
        super.a();
    }

    public void c(String str, String str2, String str3) {
        Uri uri;
        File file = new File(str2);
        if (file.exists()) {
            if (l()) {
                uri = FileProvider.getUriForFile(this.f85014b, GlobalAppConfig.a() + ".fileprovider", new File(str2));
            } else {
                uri = Uri.fromFile(file);
            }
            Uri uri2 = uri;
            if (str != null) {
                wf.a.p(this.f85014b, uri2, str, (String) null, str3, new a());
            }
        }
    }

    public void d(String str) {
    }

    public void e(String str, String str2, String str3) {
        f(str, str2, str3, (String) null);
    }

    public void f(String str, String str2, String str3, String str4) {
        this.f85016d = str;
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            wf.a.o(this.f85014b, (Bitmap) null, str2, str3, str4, b.f61198a);
        }
    }

    public boolean l() {
        return Build.VERSION.SDK_INT >= 24;
    }
}
