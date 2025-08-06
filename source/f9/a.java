package f9;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.util.HashMap;
import java.util.Map;

public class a extends Handler {

    /* renamed from: b  reason: collision with root package name */
    public static final a f70847b = new a((C0777a) null);

    /* renamed from: a  reason: collision with root package name */
    public C0777a f70848a;

    /* renamed from: f9.a$a  reason: collision with other inner class name */
    public interface C0777a {
        void handleMessage(Message message);
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static Map<String, HandlerThread> f70849a;

        public static synchronized Looper a(String str) {
            Looper looper;
            synchronized (b.class) {
                if (f70849a == null) {
                    f70849a = new HashMap();
                }
                HandlerThread handlerThread = f70849a.get(str);
                if (handlerThread == null) {
                    handlerThread = new HandlerThread(str);
                    handlerThread.start();
                    f70849a.put(str, handlerThread);
                }
                looper = handlerThread.getLooper();
            }
            return looper;
        }
    }

    public a(C0777a aVar) {
        this("network_nonUi", aVar);
    }

    public void handleMessage(Message message) {
        C0777a aVar = this.f70848a;
        if (aVar != null) {
            aVar.handleMessage(message);
        }
    }

    public a(String str, C0777a aVar) {
        super(b.a(str));
        this.f70848a = aVar;
    }
}
