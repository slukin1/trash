package wr;

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
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.telegram.Telegram;
import com.hbg.lib.common.utils.PackageManagerUtil;
import com.huobi.social.share.HBShareHelper;
import com.huobi.social.share.event.ShareBusEvent;
import com.huobi.social.share.util.ShareActiveLifecycleCallbacks;
import com.iproov.sdk.bridge.OptionsBridge;
import com.luck.picture.lib.config.SelectMimeType;
import java.io.File;
import org.greenrobot.eventbus.EventBus;

public class a extends vr.a {

    /* renamed from: d  reason: collision with root package name */
    public String f85030d;

    /* renamed from: wr.a$a  reason: collision with other inner class name */
    public class C0888a extends ShareActiveLifecycleCallbacks {
        public C0888a() {
        }

        public void onActivityResumed(Activity activity) {
            super.onActivityResumed(activity);
            we.b.l("share_event_back", String.class).g("success");
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

    public a(Context context) {
        super(context);
        String[] strArr = {"org.telegram.messenger", "org.telegramkr.messenger", "org.telegram.messenger.web"};
        for (int i11 = 0; i11 < 3; i11++) {
            String str = strArr[i11];
            boolean b11 = PackageManagerUtil.b(new String[]{str});
            this.f85013a = b11;
            if (b11) {
                this.f85030d = str;
                return;
            }
        }
    }

    public void a() {
        super.a();
        EventBus.d().k(new ShareBusEvent(HBShareHelper.HbPlatform.TYPE_TELEGRAM, ShareBusEvent.Type.COMPLETED));
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
                intent.setPackage(this.f85030d);
                intent.setType(SelectMimeType.SYSTEM_IMAGE);
                intent.putExtra("android.intent.extra.STREAM", uri);
            }
            Context context = this.f85014b;
            if (context instanceof Activity) {
                ((Activity) context).startActivityForResult(intent, 10002);
                if (i11 >= 29) {
                    ((Activity) this.f85014b).registerActivityLifecycleCallbacks(new C0888a());
                }
            } else {
                Fragment fragment = this.f85015c;
                if (fragment != null) {
                    fragment.startActivityForResult(intent, 10002);
                    if (i11 >= 29) {
                        this.f85015c.requireActivity().registerActivityLifecycleCallbacks(new b());
                    }
                }
            }
            we.b.l("share_event_back", String.class).g(OptionsBridge.NULL_VALUE);
        }
    }

    public void e(String str, String str2, String str3) {
        Platform platform = ShareSDK.getPlatform(Telegram.NAME);
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setText(str2);
        shareParams.setTitle(str);
        shareParams.setUrl(str3);
        platform.share(shareParams);
    }
}
