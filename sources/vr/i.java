package vr;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.content.FileProvider;
import com.hbg.lib.common.utils.PackageManagerUtil;
import com.hbg.lib.core.GlobalAppConfig;
import com.luck.picture.lib.config.SelectMimeType;
import java.io.File;
import we.b;

public class i extends a {

    /* renamed from: d  reason: collision with root package name */
    public String f85019d = "";

    public i(Context context) {
        super(context);
        String[] strArr = {"com.instagram.android"};
        int i11 = 0;
        while (i11 < 1) {
            boolean b11 = PackageManagerUtil.b(new String[]{strArr[i11]});
            this.f85013a = b11;
            if (!b11) {
                i11++;
            } else {
                return;
            }
        }
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
                intent.setPackage("com.instagram.android");
                this.f85014b.startActivity(Intent.createChooser(intent, "share"));
            }
        }
    }

    public void d(String str) {
        Class<String> cls = String.class;
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", str);
            intent.setPackage("com.instagram.android");
            this.f85014b.startActivity(intent);
            b.l("share_event_back", cls).g("success");
        } catch (Exception e11) {
            e11.printStackTrace();
            b.l("share_event_back", cls).g("fail");
        }
    }

    public void e(String str, String str2, String str3) {
        this.f85019d = str;
        d(str2 + " " + str3);
    }

    public boolean k() {
        return Build.VERSION.SDK_INT >= 24;
    }
}
