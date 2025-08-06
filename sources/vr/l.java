package vr;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.hbg.lib.core.GlobalAppConfig;
import com.iproov.sdk.bridge.OptionsBridge;
import com.luck.picture.lib.config.SelectMimeType;
import gs.g;
import java.io.File;
import java.util.HashMap;
import we.b;

public class l extends a {

    /* renamed from: d  reason: collision with root package name */
    public String f85022d = "";

    public l(Context context) {
        super(context);
        this.f85013a = true;
    }

    public void a() {
        super.a();
    }

    public void c(String str, String str2, String str3) {
        Uri uri;
        File file = new File(str2);
        if (file.exists()) {
            if (k()) {
                uri = FileProvider.getUriForFile(this.f85014b, GlobalAppConfig.a() + ".fileprovider", new File(str2));
            } else {
                uri = Uri.fromFile(file);
            }
            if (str != null) {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType(SelectMimeType.SYSTEM_IMAGE);
                intent.putExtra("android.intent.extra.STREAM", uri);
                this.f85014b.startActivity(Intent.createChooser(intent, "share"));
                b.l("share_event_back", String.class).g(OptionsBridge.NULL_VALUE);
            }
            g.i("App_bussiness_detail_share_pop_expose", (HashMap) null);
        }
    }

    public void d(String str) {
        if (!TextUtils.isEmpty(str)) {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", str);
            this.f85014b.startActivity(Intent.createChooser(intent, "share"));
            g.i("App_bussiness_detail_share_pop_expose", (HashMap) null);
            b.l("share_event_back", String.class).g(OptionsBridge.NULL_VALUE);
        }
    }

    public void e(String str, String str2, String str3) {
        this.f85022d = str;
        l(str3, str2);
    }

    public boolean k() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public void l(String str, String str2) {
        Uri uri;
        if (!TextUtils.isEmpty(str)) {
            Intent intent = new Intent("android.intent.action.SEND");
            if (str2 == null || TextUtils.isEmpty(str2)) {
                uri = null;
            } else if (k()) {
                uri = FileProvider.getUriForFile(this.f85014b, GlobalAppConfig.a() + ".fileprovider", new File(str2));
            } else {
                uri = Uri.fromFile(new File(str2));
            }
            if (uri != null) {
                intent.putExtra("android.intent.extra.STREAM", uri);
                intent.setType(SelectMimeType.SYSTEM_IMAGE);
                intent.putExtra("sms_body", str);
            } else {
                intent.setType("text/plain");
            }
            intent.putExtra("android.intent.extra.TEXT", str);
            this.f85014b.startActivity(Intent.createChooser(intent, "share"));
            g.i("App_bussiness_detail_share_pop_expose", (HashMap) null);
            b.l("share_event_back", String.class).g(OptionsBridge.NULL_VALUE);
        }
    }
}
