package vr;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import bh.j;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.whatsapp.WhatsApp;
import com.hbg.lib.common.utils.PackageManagerUtil;
import com.huobi.social.share.util.ShareActiveLifecycleCallbacks;
import com.luck.picture.lib.config.SelectMimeType;
import java.io.File;
import java.util.HashMap;

public class n extends a {

    public class a implements PlatformActionListener {
        public a() {
        }

        public void onCancel(Platform platform, int i11) {
        }

        public void onComplete(Platform platform, int i11, HashMap<String, Object> hashMap) {
            we.b.l("share_event_back", String.class).g("success");
        }

        public void onError(Platform platform, int i11, Throwable th2) {
            we.b.l("share_event_back", String.class).g("fail");
        }
    }

    public class b extends ShareActiveLifecycleCallbacks {
        public b() {
        }

        public void onActivityResumed(Activity activity) {
            super.onActivityResumed(activity);
            we.b.l("share_event_back", String.class).g("success");
        }
    }

    public class c extends ShareActiveLifecycleCallbacks {
        public c() {
        }

        public void onActivityResumed(Activity activity) {
            super.onActivityResumed(activity);
            we.b.l("share_event_back", String.class).g("success");
        }
    }

    public n(Context context) {
        super(context);
        String[] strArr = {"com.whatsapp"};
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

    public void c(String str, String str2, String str3) {
        Uri uri;
        File file = new File(str2);
        if (file.exists()) {
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 24) {
                uri = FileProvider.getUriForFile(j.c(), "pro.huobi.fileprovider", file);
            } else {
                uri = Uri.fromFile(new File(str2));
            }
            Intent intent = new Intent("android.intent.action.SEND");
            if (!TextUtils.isEmpty(str2)) {
                intent.setPackage("com.whatsapp");
                intent.setType(SelectMimeType.SYSTEM_IMAGE);
                intent.putExtra("android.intent.extra.STREAM", uri);
            }
            Context context = this.f85014b;
            if (context instanceof Activity) {
                ((Activity) context).startActivityForResult(intent, 10002);
                if (i11 >= 29) {
                    ((Activity) this.f85014b).registerActivityLifecycleCallbacks(new b());
                    return;
                }
                return;
            }
            Fragment fragment = this.f85015c;
            if (fragment != null) {
                fragment.startActivityForResult(intent, 10002);
                if (i11 >= 29) {
                    this.f85015c.requireActivity().registerActivityLifecycleCallbacks(new c());
                }
            }
        }
    }

    public void e(String str, String str2, String str3) {
        Platform platform = ShareSDK.getPlatform(WhatsApp.NAME);
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setText(str2);
        platform.setPlatformActionListener(new a());
        platform.share(shareParams);
    }
}
