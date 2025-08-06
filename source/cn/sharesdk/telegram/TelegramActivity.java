package cn.sharesdk.telegram;

import android.os.Handler;
import android.os.Message;
import android.widget.LinearLayout;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.tools.FakeActivity;
import com.mob.tools.utils.UIHandler;
import java.util.HashMap;

public class TelegramActivity extends FakeActivity {
    /* access modifiers changed from: private */
    public ActionListener actionListener;
    /* access modifiers changed from: private */
    public Platform.ShareParams params;
    /* access modifiers changed from: private */
    public Platform platform;

    /* access modifiers changed from: private */
    public void startShare() {
        final a a11 = a.a(this.platform);
        new Thread() {
            public void run() {
                try {
                    a11.a(TelegramActivity.this.params, TelegramActivity.this.platform);
                } catch (Throwable th2) {
                    TelegramActivity.this.actionListener.onError(th2);
                    TelegramActivity.this.finish();
                }
            }
        }.start();
    }

    public void onCreate() {
        try {
            LinearLayout linearLayout = new LinearLayout(this.activity);
            linearLayout.setOrientation(1);
            this.activity.setContentView(linearLayout);
        } catch (Exception e11) {
            SSDKLog.b().a((Throwable) e11);
        }
        UIHandler.sendEmptyMessageDelayed(1, 700, new Handler.Callback() {
            public boolean handleMessage(Message message) {
                try {
                    TelegramActivity.this.startShare();
                    return true;
                } catch (Throwable th2) {
                    if (TelegramActivity.this.actionListener == null) {
                        return true;
                    }
                    TelegramActivity.this.actionListener.onError(new Throwable(th2));
                    TelegramActivity.this.finish();
                    return true;
                }
            }
        });
    }

    public void onRestart() {
        ActionListener actionListener2 = this.actionListener;
        if (actionListener2 != null) {
            actionListener2.onComplete(new HashMap());
        }
        finish();
    }

    public void setAuthListener(ActionListener actionListener2) {
        this.actionListener = actionListener2;
    }

    public void setPlatform(Platform platform2) {
        this.platform = platform2;
    }

    public void setShareParams(Platform.ShareParams shareParams) {
        this.params = shareParams;
    }
}
