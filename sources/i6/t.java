package i6;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.SoftReference;

public class t extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public SoftReference<a> f68195a;

    public interface a {
        void handleMessage(Message message);
    }

    public t(a aVar) {
        this.f68195a = new SoftReference<>(aVar);
    }

    public void handleMessage(Message message) {
        a aVar;
        SoftReference<a> softReference = this.f68195a;
        if (softReference != null && (aVar = softReference.get()) != null) {
            aVar.handleMessage(message);
        }
    }
}
