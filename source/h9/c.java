package h9;

import com.hbg.lib.network.retrofit.websocket.bean.ISocketSend;

public interface c<T> {
    void a(ISocketSend iSocketSend, String str, String str2, T t11);

    T b(String str);

    void onFailed(Throwable th2);
}
