package com.hbg.lib.network.retrofit.websocketnew;

import com.google.protobuf.InvalidProtocolBufferException;
import com.hbg.lib.network.retrofit.util.RetrofitLogger;
import com.huobi.websocket.protobuf.source.Message$Proto;
import java.util.HashSet;
import java.util.Set;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

public class PSocketListenerDispatcher extends WebSocketListener {

    /* renamed from: a  reason: collision with root package name */
    public final Set<PWebSocketListener> f70675a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    public String f70676b;

    public static abstract class PWebSocketListener extends WebSocketListener {
        public abstract boolean a();

        public abstract void b(Message$Proto message$Proto);
    }

    public PSocketListenerDispatcher(String str) {
        this.f70676b = str;
    }

    public void a(PWebSocketListener pWebSocketListener) {
        this.f70675a.add(pWebSocketListener);
    }

    public void onClosed(WebSocket webSocket, int i11, String str) {
        super.onClosed(webSocket, i11, str);
        RetrofitLogger.g(this.f70676b + "-->Socket-->onClosed " + str);
        for (PWebSocketListener onClosed : this.f70675a) {
            onClosed.onClosed(webSocket, i11, str);
        }
    }

    public void onClosing(WebSocket webSocket, int i11, String str) {
        super.onClosing(webSocket, i11, str);
        RetrofitLogger.g(this.f70676b + "-->Socket-->onClosing " + str);
        for (PWebSocketListener onClosing : this.f70675a) {
            onClosing.onClosing(webSocket, i11, str);
        }
    }

    public void onFailure(WebSocket webSocket, Throwable th2, Response response) {
        super.onFailure(webSocket, th2, response);
        RetrofitLogger.b(this.f70676b + "-->onFailure-->" + th2);
        RetrofitLogger.g(this.f70676b + "-->Socket-->onFailure " + th2.toString() + " url:" + webSocket.request().url().toString());
        for (PWebSocketListener onFailure : this.f70675a) {
            onFailure.onFailure(webSocket, th2, response);
        }
    }

    public void onMessage(WebSocket webSocket, String str) {
        super.onMessage(webSocket, str);
        RetrofitLogger.a(this.f70676b + "-->onMessage1-->" + str);
        for (PWebSocketListener onMessage : this.f70675a) {
            onMessage.onMessage(webSocket, str);
        }
    }

    public void onOpen(WebSocket webSocket, Response response) {
        super.onOpen(webSocket, response);
        RetrofitLogger.g(this.f70676b + "-->Socket-->onOpen " + response.toString());
        for (PWebSocketListener onOpen : this.f70675a) {
            onOpen.onOpen(webSocket, response);
        }
    }

    public void onMessage(WebSocket webSocket, ByteString byteString) {
        Message$Proto parseFrom;
        super.onMessage(webSocket, byteString);
        RetrofitLogger.a(this.f70676b + "-->onMessage2-->" + byteString.toString());
        try {
            if (byteString.size() != 0 && (parseFrom = Message$Proto.parseFrom(byteString.toByteArray())) != null) {
                for (PWebSocketListener b11 : this.f70675a) {
                    b11.b(parseFrom);
                }
            }
        } catch (InvalidProtocolBufferException e11) {
            e11.printStackTrace();
        }
    }
}
