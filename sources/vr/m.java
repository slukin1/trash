package vr;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.hbg.lib.core.GlobalAppConfig;
import com.iproov.sdk.bridge.OptionsBridge;
import com.twitter.sdk.android.tweetcomposer.TweetComposer;
import java.io.File;
import java.net.URL;
import we.b;

public class m extends a {

    /* renamed from: d  reason: collision with root package name */
    public String f85023d = "";

    public m(Context context) {
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
            TweetComposer.Builder image = new TweetComposer.Builder(this.f85014b).image(uri);
            if (str != null) {
                image.text(str);
            }
            Intent createIntent = image.createIntent();
            createIntent.setFlags(268435456);
            createIntent.setComponent(new ComponentName(SSOAuthHandler.TWITTER_PACKAGE_NAME, "com.twitter.composer.ComposerActivity"));
            this.f85014b.startActivity(createIntent);
            b.l("share_event_back", String.class).g(OptionsBridge.NULL_VALUE);
        }
    }

    public void d(String str) {
    }

    public void e(String str, String str2, String str3) {
        Class<String> cls = String.class;
        this.f85023d = str;
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            try {
                Intent createIntent = new TweetComposer.Builder(this.f85014b).url(new URL(str3)).text(str2).createIntent();
                createIntent.setFlags(268435456);
                createIntent.setComponent(new ComponentName(SSOAuthHandler.TWITTER_PACKAGE_NAME, "com.twitter.composer.ComposerActivity"));
                this.f85014b.startActivity(createIntent);
                b.l("share_event_back", cls).g("success");
            } catch (Exception e11) {
                e11.printStackTrace();
                b.l("share_event_back", cls).g("fail");
            }
        }
    }

    public boolean k() {
        return Build.VERSION.SDK_INT >= 24;
    }
}
