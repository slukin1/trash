package g9;

import com.hbg.lib.network.retrofit.util.RetrofitLogger;
import java.util.HashSet;
import java.util.Set;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

public class b extends WebSocketListener {

    /* renamed from: a  reason: collision with root package name */
    public final Set<WebSocketListener> f70871a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    public String f70872b;

    public b(String str) {
        this.f70872b = str;
    }

    public void a(WebSocketListener webSocketListener) {
        this.f70871a.add(webSocketListener);
    }

    public void onClosed(WebSocket webSocket, int i11, String str) {
        super.onClosed(webSocket, i11, str);
        RetrofitLogger.g(this.f70872b + "-->Socket-->onClosed " + str);
        for (WebSocketListener onClosed : this.f70871a) {
            onClosed.onClosed(webSocket, i11, str);
        }
    }

    public void onClosing(WebSocket webSocket, int i11, String str) {
        super.onClosing(webSocket, i11, str);
        RetrofitLogger.g(this.f70872b + "-->Socket-->onClosing " + str);
        for (WebSocketListener onClosing : this.f70871a) {
            onClosing.onClosing(webSocket, i11, str);
        }
    }

    public void onFailure(WebSocket webSocket, Throwable th2, Response response) {
        super.onFailure(webSocket, th2, response);
        RetrofitLogger.b(this.f70872b + ", caoxianjin-->onFailure-->" + th2);
        RetrofitLogger.g(this.f70872b + "-->Socket-->onFailure " + th2.toString() + " url:" + webSocket.request().url().toString());
        for (WebSocketListener onFailure : this.f70871a) {
            onFailure.onFailure(webSocket, th2, response);
        }
    }

    public void onMessage(WebSocket webSocket, String str) {
        super.onMessage(webSocket, str);
        RetrofitLogger.a(this.f70872b + "-->onMessage1-->" + str);
        for (WebSocketListener onMessage : this.f70871a) {
            onMessage.onMessage(webSocket, str);
        }
    }

    public void onOpen(WebSocket webSocket, Response response) {
        super.onOpen(webSocket, response);
        RetrofitLogger.g(this.f70872b + "caoxianjin, -->Socket-->onOpen " + response.toString());
        for (WebSocketListener onOpen : this.f70871a) {
            onOpen.onOpen(webSocket, response);
        }
    }

    public void onMessage(WebSocket webSocket, ByteString byteString) {
        super.onMessage(webSocket, byteString);
        RetrofitLogger.a(this.f70872b + "-->onMessage2-->" + byteString.toString());
        for (WebSocketListener onMessage : this.f70871a) {
            onMessage.onMessage(webSocket, byteString);
        }
    }
}
