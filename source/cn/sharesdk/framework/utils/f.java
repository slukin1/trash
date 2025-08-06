package cn.sharesdk.framework.utils;

import android.os.Handler;
import android.os.Message;
import com.mob.tools.MobHandlerThread;

public abstract class f implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final Handler f13521a = MobHandlerThread.newHandler(this);

    public void a(int i11, int i12, Object obj) {
        Message message = new Message();
        message.what = -1;
        message.arg1 = i11;
        message.arg2 = i12;
        message.obj = obj;
        this.f13521a.sendMessage(message);
    }

    public void a(Message message) {
    }

    public abstract void b(Message message);

    public void c() {
        a(0, 0, (Object) null);
    }

    public void c(Message message) {
    }

    public final boolean handleMessage(Message message) {
        int i11 = message.what;
        if (i11 == -2) {
            c(message);
            return false;
        } else if (i11 != -1) {
            b(message);
            return false;
        } else {
            a(message);
            return false;
        }
    }
}
