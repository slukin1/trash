package com.huawei.hms.common.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.core.aidl.IAIDLInvoke;
import com.huawei.hms.support.log.HMSLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class RequestManager implements Handler.Callback {
    public static final int NOTIFY_CONNECT_FAILED = 10012;
    public static final int NOTIFY_CONNECT_SUCCESS = 10011;
    public static final int NOTIFY_CONNECT_SUSPENDED = 10013;

    /* renamed from: a  reason: collision with root package name */
    private static final Object f37935a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static volatile RequestManager f37936b;

    /* renamed from: c  reason: collision with root package name */
    private static Handler f37937c;

    /* renamed from: d  reason: collision with root package name */
    private static Queue<HuaweiApi.RequestHandler> f37938d = new ConcurrentLinkedQueue();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static Map<String, HuaweiApi.RequestHandler> f37939e = new LinkedHashMap();

    private RequestManager(Looper looper) {
        f37937c = new Handler(looper, this);
    }

    public static void addRequestToQueue(HuaweiApi.RequestHandler requestHandler) {
        f37938d.add(requestHandler);
    }

    public static void addToConnectedReqMap(final String str, final HuaweiApi.RequestHandler requestHandler) {
        if (f37937c != null) {
            HMSLog.i("RequestManager", "addToConnectedReqMap");
            f37937c.post(new Runnable() {
                public void run() {
                    RequestManager.f37939e.put(str, requestHandler);
                }
            });
        }
    }

    private void b() {
        while (!f37938d.isEmpty()) {
            HuaweiApi.RequestHandler poll = f37938d.poll();
            if (poll != null) {
                AnyClient client = poll.getClient();
                if (client instanceof BaseHmsClient) {
                    BaseHmsClient baseHmsClient = (BaseHmsClient) client;
                    baseHmsClient.setService(IAIDLInvoke.Stub.asInterface(baseHmsClient.getAdapter().getServiceBinder()));
                    poll.onConnected();
                }
            }
        }
    }

    private void c() {
        HMSLog.i("RequestManager", "NOTIFY_CONNECT_SUSPENDED.");
        while (!f37938d.isEmpty()) {
            f37938d.poll().onConnectionSuspended(1);
        }
        d();
    }

    private void d() {
        HMSLog.i("RequestManager", "notifyRunningRequestConnectSuspend, connectedReqMap.size(): " + f37939e.size());
        Iterator<Map.Entry<String, HuaweiApi.RequestHandler>> it2 = f37939e.entrySet().iterator();
        while (it2.hasNext()) {
            try {
                ((HuaweiApi.RequestHandler) it2.next().getValue()).onConnectionSuspended(1);
            } catch (RuntimeException e11) {
                HMSLog.e("RequestManager", "NOTIFY_CONNECT_SUSPENDED Exception: " + e11.getMessage());
            }
            it2.remove();
        }
    }

    public static Handler getHandler() {
        return f37937c;
    }

    public static RequestManager getInstance() {
        synchronized (f37935a) {
            if (f37936b == null) {
                HandlerThread handlerThread = new HandlerThread("RequestManager");
                handlerThread.start();
                f37936b = new RequestManager(handlerThread.getLooper());
            }
        }
        return f37936b;
    }

    public static void removeReqByTransId(final String str) {
        if (f37937c != null) {
            HMSLog.i("RequestManager", "removeReqByTransId");
            f37937c.post(new Runnable() {
                public void run() {
                    RequestManager.f37939e.remove(str);
                }
            });
        }
    }

    public boolean handleMessage(Message message) {
        if (message == null) {
            return false;
        }
        HMSLog.i("RequestManager", "RequestManager handleMessage.");
        switch (message.what) {
            case 10011:
                b();
                return true;
            case 10012:
                a(message);
                return true;
            case 10013:
                c();
                return true;
            default:
                HMSLog.i("RequestManager", "handleMessage unknown msg:" + message.what);
                return false;
        }
    }

    private void a(Message message) {
        HMSLog.i("RequestManager", "NOTIFY_CONNECT_FAILED.");
        try {
            BaseHmsClient.ConnectionResultWrapper connectionResultWrapper = (BaseHmsClient.ConnectionResultWrapper) message.obj;
            HuaweiApi.RequestHandler request = connectionResultWrapper.getRequest();
            f37938d.remove(request);
            request.onConnectionFailed(connectionResultWrapper.getConnectionResult());
        } catch (RuntimeException e11) {
            HMSLog.e("RequestManager", "<handleConnectFailed> handle Failed" + e11.getMessage());
        }
    }
}
