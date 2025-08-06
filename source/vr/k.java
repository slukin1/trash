package vr;

import android.content.Context;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.line.Line;
import com.hbg.lib.common.utils.PackageManagerUtil;
import java.util.HashMap;

public class k extends a {

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

    public class b implements PlatformActionListener {
        public b() {
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

    public k(Context context) {
        super(context);
        String[] strArr = {"jp.naver.line.android"};
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
        Platform platform = ShareSDK.getPlatform(Line.NAME);
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setImagePath(str2);
        platform.setPlatformActionListener(new b());
        platform.share(shareParams);
    }

    public void e(String str, String str2, String str3) {
        Platform platform = ShareSDK.getPlatform(Line.NAME);
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setText(str2);
        platform.setPlatformActionListener(new a());
        platform.share(shareParams);
    }
}
