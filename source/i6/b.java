package i6;

import android.os.Handler;
import android.os.Message;
import com.hbg.lib.common.utils.HandlerThreadUtil;
import java.lang.ref.SoftReference;

public class b extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public SoftReference<a> f68161a;

    public interface a {
        void handleMessage(Message message);
    }

    public b(a aVar) {
        this("nonUi", aVar);
    }

    public void handleMessage(Message message) {
        a aVar;
        SoftReference<a> softReference = this.f68161a;
        if (softReference != null && (aVar = softReference.get()) != null) {
            aVar.handleMessage(message);
        }
    }

    public b(String str, a aVar) {
        super(HandlerThreadUtil.a(str));
        this.f68161a = new SoftReference<>(aVar);
    }
}
