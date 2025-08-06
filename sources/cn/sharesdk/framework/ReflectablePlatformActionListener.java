package cn.sharesdk.framework;

import android.os.Handler;
import android.os.Message;
import com.mob.tools.utils.UIHandler;
import java.util.HashMap;

public class ReflectablePlatformActionListener implements PlatformActionListener {

    /* renamed from: a  reason: collision with root package name */
    private int f13231a;

    /* renamed from: b  reason: collision with root package name */
    private Handler.Callback f13232b;

    /* renamed from: c  reason: collision with root package name */
    private int f13233c;

    /* renamed from: d  reason: collision with root package name */
    private Handler.Callback f13234d;

    /* renamed from: e  reason: collision with root package name */
    private int f13235e;

    /* renamed from: f  reason: collision with root package name */
    private Handler.Callback f13236f;

    public void onCancel(Platform platform, int i11) {
        if (this.f13236f != null) {
            Message message = new Message();
            message.what = this.f13235e;
            message.obj = new Object[]{platform, Integer.valueOf(i11)};
            UIHandler.sendMessage(message, this.f13236f);
        }
    }

    public void onComplete(Platform platform, int i11, HashMap<String, Object> hashMap) {
        if (this.f13232b != null) {
            Message message = new Message();
            message.what = this.f13231a;
            message.obj = new Object[]{platform, Integer.valueOf(i11), hashMap};
            UIHandler.sendMessage(message, this.f13232b);
        }
    }

    public void onError(Platform platform, int i11, Throwable th2) {
        if (this.f13234d != null) {
            Message message = new Message();
            message.what = this.f13233c;
            message.obj = new Object[]{platform, Integer.valueOf(i11), th2};
            UIHandler.sendMessage(message, this.f13234d);
        }
    }

    public void setOnCancelCallback(int i11, Handler.Callback callback) {
        this.f13235e = i11;
        this.f13236f = callback;
    }

    public void setOnCompleteCallback(int i11, Handler.Callback callback) {
        this.f13231a = i11;
        this.f13232b = callback;
    }

    public void setOnErrorCallback(int i11, Handler.Callback callback) {
        this.f13233c = i11;
        this.f13234d = callback;
    }
}
