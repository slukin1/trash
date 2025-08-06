package com.blankj.utilcode.util;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import androidx.core.app.NotificationCompat;
import com.blankj.utilcode.util.NotificationUtils;
import com.blankj.utilcode.util.Utils;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MessengerUtils {

    /* renamed from: a  reason: collision with root package name */
    public static ConcurrentHashMap<String, a> f63346a = new ConcurrentHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, Object> f63347b = new HashMap();

    public static class ServerService extends Service {

        /* renamed from: b  reason: collision with root package name */
        public final ConcurrentHashMap<Integer, Messenger> f63348b = new ConcurrentHashMap<>();
        @SuppressLint({"HandlerLeak"})

        /* renamed from: c  reason: collision with root package name */
        public final Handler f63349c;

        /* renamed from: d  reason: collision with root package name */
        public final Messenger f63350d;

        public class a extends Handler {
            public a() {
            }

            public void handleMessage(Message message) {
                int i11 = message.what;
                if (i11 == 0) {
                    ServerService.this.f63348b.put(Integer.valueOf(message.arg1), message.replyTo);
                } else if (i11 == 1) {
                    ServerService.this.f63348b.remove(Integer.valueOf(message.arg1));
                } else if (i11 != 2) {
                    super.handleMessage(message);
                } else {
                    ServerService.this.e(message);
                    ServerService.this.d(message);
                }
            }
        }

        public ServerService() {
            a aVar = new a();
            this.f63349c = aVar;
            this.f63350d = new Messenger(aVar);
        }

        public final void d(Message message) {
            String string;
            a aVar;
            Bundle data = message.getData();
            if (data != null && (string = data.getString("MESSENGER_UTILS")) != null && (aVar = (a) MessengerUtils.f63346a.get(string)) != null) {
                aVar.a(data);
            }
        }

        public final void e(Message message) {
            for (Messenger next : this.f63348b.values()) {
                if (next != null) {
                    try {
                        next.send(message);
                    } catch (RemoteException e11) {
                        e11.printStackTrace();
                    }
                }
            }
        }

        public IBinder onBind(Intent intent) {
            return this.f63350d.getBinder();
        }

        public int onStartCommand(Intent intent, int i11, int i12) {
            Bundle extras;
            PushAutoTrackHelper.onServiceStartCommand(this, intent, i11, i12);
            if (Build.VERSION.SDK_INT >= 26) {
                startForeground(1, a0.p(NotificationUtils.a.f63358b, (Utils.a<NotificationCompat.e>) null));
            }
            if (!(intent == null || (extras = intent.getExtras()) == null)) {
                Message obtain = Message.obtain(this.f63349c, 2);
                obtain.replyTo = this.f63350d;
                obtain.setData(extras);
                e(obtain);
                d(obtain);
            }
            return 2;
        }
    }

    public interface a {
        void a(Bundle bundle);
    }
}
