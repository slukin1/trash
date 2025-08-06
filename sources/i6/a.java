package i6;

import android.os.Handler;
import android.os.Message;
import com.hbg.lib.common.utils.HandlerThreadUtil;

public class a extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public C0739a f68160a;

    /* renamed from: i6.a$a  reason: collision with other inner class name */
    public interface C0739a {
        void handleMessage(Message message);
    }

    public a(String str, C0739a aVar) {
        super(HandlerThreadUtil.a(str));
        this.f68160a = aVar;
    }

    public void handleMessage(Message message) {
        C0739a aVar = this.f68160a;
        if (aVar != null) {
            aVar.handleMessage(message);
        }
    }
}
