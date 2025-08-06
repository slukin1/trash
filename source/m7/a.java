package m7;

import android.os.Handler;
import android.os.Message;
import com.hbg.lib.iplayer.common.util.HandlerThreadUtil;
import java.lang.ref.WeakReference;

public class a extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<C0760a> f70119a;

    /* renamed from: m7.a$a  reason: collision with other inner class name */
    public interface C0760a {
        void handleMessage(Message message);
    }

    public a(String str, C0760a aVar) {
        super(HandlerThreadUtil.a(str));
        this.f70119a = new WeakReference<>(aVar);
    }

    public void handleMessage(Message message) {
        C0760a aVar;
        WeakReference<C0760a> weakReference = this.f70119a;
        if (weakReference != null && (aVar = (C0760a) weakReference.get()) != null) {
            aVar.handleMessage(message);
        }
    }
}
