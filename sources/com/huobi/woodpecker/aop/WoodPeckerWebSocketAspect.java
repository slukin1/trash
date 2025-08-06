package com.huobi.woodpecker.aop;

import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huobi.woodpecker.core.ActionType;
import com.huobi.woodpecker.model.WebSocketRecord;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.zip.GZIPInputStream;
import kv.e;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal.ws.RealWebSocket;
import okio.ByteString;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.NoAspectBoundException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.json.JSONObject;
import wu.c;

public class WoodPeckerWebSocketAspect {

    /* renamed from: b  reason: collision with root package name */
    public static final String f20988b = "com.huobi.woodpecker.aop.WoodPeckerWebSocketAspect";

    /* renamed from: c  reason: collision with root package name */
    public static /* synthetic */ Throwable f20989c;

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ WoodPeckerWebSocketAspect f20990d = null;

    /* renamed from: a  reason: collision with root package name */
    public Map<WebSocket, Long> f20991a = new WeakHashMap();

    static {
        try {
            f20990d = new WoodPeckerWebSocketAspect();
        } catch (Throwable th2) {
            f20989c = th2;
        }
    }

    public static WoodPeckerWebSocketAspect e() {
        WoodPeckerWebSocketAspect woodPeckerWebSocketAspect = f20990d;
        if (woodPeckerWebSocketAspect != null) {
            return woodPeckerWebSocketAspect;
        }
        throw new NoAspectBoundException(f20988b, f20989c);
    }

    public void f(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        ActionType actionType = ActionType.APP_SOCKET;
        if (actionType.isDisable()) {
            proceedingJoinPoint.a();
            return;
        }
        String c11 = f20988b;
        e.m(c11, "newWebSocket enable:" + actionType.isEnable() + " > joinPoint.this=" + proceedingJoinPoint.b());
        Object[] c12 = proceedingJoinPoint.c();
        if (c12 == null || c12.length <= 2 || !(c12[1] instanceof WebSocketListener)) {
            proceedingJoinPoint.a();
            return;
        }
        c12[1] = new a((WebSocketListener) c12[1]);
        proceedingJoinPoint.e(c12);
    }

    public void g(JoinPoint joinPoint) {
        String str;
        Request request;
        String str2 = "sub";
        if (!vu.e.g().j()) {
            try {
                Object obj = joinPoint.c()[0];
                if (obj instanceof ByteString) {
                    str = ((ByteString) obj).utf8();
                } else {
                    str = obj instanceof String ? (String) obj : null;
                }
                if (!TextUtils.isEmpty(str)) {
                    JSONObject jSONObject = new JSONObject(str);
                    String optString = jSONObject.optString(str2);
                    if (TextUtils.isEmpty(optString)) {
                        optString = jSONObject.optString(HiAnalyticsConstant.Direction.REQUEST);
                        if (!TextUtils.isEmpty(optString)) {
                            str2 = HiAnalyticsConstant.Direction.REQUEST;
                        } else {
                            optString = jSONObject.optString("unsub");
                            if (!TextUtils.isEmpty(optString)) {
                                str2 = "unsub";
                            } else {
                                str2 = null;
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        Object target = joinPoint.getTarget();
                        if ((target instanceof RealWebSocket) && (request = ((RealWebSocket) target).request()) != null && request.url() != null) {
                            String httpUrl = request.url().toString();
                            String host = request.url().host();
                            if (!TextUtils.isEmpty(host)) {
                                vu.e.g().m(httpUrl, host, str2, optString);
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public class a extends WebSocketListener {

        /* renamed from: a  reason: collision with root package name */
        public WebSocketListener f20992a;

        public a(WebSocketListener webSocketListener) {
            this.f20992a = webSocketListener;
        }

        public void onClosed(WebSocket webSocket, int i11, String str) {
            WebSocketListener webSocketListener = this.f20992a;
            if (webSocketListener != null) {
                webSocketListener.onClosed(webSocket, i11, str);
            }
        }

        public void onClosing(WebSocket webSocket, int i11, String str) {
            WebSocketListener webSocketListener = this.f20992a;
            if (webSocketListener != null) {
                webSocketListener.onClosing(webSocket, i11, str);
            }
        }

        public void onFailure(WebSocket webSocket, Throwable th2, Response response) {
            Request request = webSocket.request();
            if (request != null) {
                String httpUrl = request.url().toString();
                if (!TextUtils.isEmpty(httpUrl) && WoodPeckerWebSocketAspect.this.f20991a.containsKey(webSocket)) {
                    Long l11 = (Long) WoodPeckerWebSocketAspect.this.f20991a.get(webSocket);
                    if (l11 != null) {
                        long elapsedRealtime = SystemClock.elapsedRealtime() - l11.longValue();
                        WebSocketRecord webSocketRecord = new WebSocketRecord();
                        ((WebSocketRecord.WebSocketRecordData) webSocketRecord.getData()).setUrl(httpUrl);
                        ((WebSocketRecord.WebSocketRecordData) webSocketRecord.getData()).setStatus(3);
                        ((WebSocketRecord.WebSocketRecordData) webSocketRecord.getData()).setCostTime(elapsedRealtime);
                        String b11 = WoodPeckerWebSocketAspect.f20988b;
                        e.m(b11, "InnerWebSocketListener.onFailure webSocketRecord=>" + webSocketRecord.toJsonString());
                        c.b(webSocketRecord);
                    }
                    WoodPeckerWebSocketAspect.this.f20991a.remove(webSocket);
                }
            }
            WebSocketListener webSocketListener = this.f20992a;
            if (webSocketListener != null) {
                webSocketListener.onFailure(webSocket, th2, response);
            }
        }

        public void onMessage(WebSocket webSocket, String str) {
            WebSocketListener webSocketListener = this.f20992a;
            if (webSocketListener != null) {
                webSocketListener.onMessage(webSocket, str);
            }
        }

        public void onOpen(WebSocket webSocket, Response response) {
            Request request = webSocket.request();
            if (request != null) {
                String httpUrl = request.url().toString();
                if (!TextUtils.isEmpty(httpUrl) && WoodPeckerWebSocketAspect.this.f20991a.containsKey(webSocket)) {
                    Long l11 = (Long) WoodPeckerWebSocketAspect.this.f20991a.get(webSocket);
                    if (l11 != null) {
                        long elapsedRealtime = SystemClock.elapsedRealtime() - l11.longValue();
                        WebSocketRecord webSocketRecord = new WebSocketRecord();
                        ((WebSocketRecord.WebSocketRecordData) webSocketRecord.getData()).setUrl(httpUrl);
                        ((WebSocketRecord.WebSocketRecordData) webSocketRecord.getData()).setStatus(1);
                        ((WebSocketRecord.WebSocketRecordData) webSocketRecord.getData()).setCostTime(elapsedRealtime);
                        String b11 = WoodPeckerWebSocketAspect.f20988b;
                        e.m(b11, "InnerWebSocketListener.onOpen webSocketRecord=>" + webSocketRecord.toJsonString());
                        c.b(webSocketRecord);
                    }
                    WoodPeckerWebSocketAspect.this.f20991a.remove(webSocket);
                }
            }
            WebSocketListener webSocketListener = this.f20992a;
            if (webSocketListener != null) {
                webSocketListener.onOpen(webSocket, response);
            }
        }

        public void onMessage(WebSocket webSocket, ByteString byteString) {
            Request request;
            WebSocketListener webSocketListener = this.f20992a;
            if (webSocketListener != null) {
                webSocketListener.onMessage(webSocket, byteString);
            }
            try {
                if (!vu.e.g().j() && vu.e.g().h() && (request = webSocket.request()) != null && request.url() != null) {
                    String httpUrl = request.url().toString();
                    String host = request.url().host();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new GZIPInputStream(new ByteArrayInputStream(byteString.toByteArray())), "UTF-8"));
                    StringBuilder sb2 = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb2.append(readLine);
                    }
                    JSONObject jSONObject = new JSONObject(sb2.toString());
                    String optString = jSONObject.optString("ch");
                    if (!TextUtils.isEmpty(optString)) {
                        vu.e.g().k(httpUrl, host, "ch", optString);
                        return;
                    }
                    String optString2 = jSONObject.optString("subbed");
                    if (!TextUtils.isEmpty(optString2)) {
                        vu.e.g().k(httpUrl, host, "subbed", optString2);
                        return;
                    }
                    String optString3 = jSONObject.optString("rep");
                    if (!TextUtils.isEmpty(optString3)) {
                        vu.e.g().k(httpUrl, host, "rep", optString3);
                        return;
                    }
                    String optString4 = jSONObject.optString("unsubbed");
                    if (!TextUtils.isEmpty(optString4)) {
                        vu.e.g().k(httpUrl, host, "unsubbed", optString4);
                    }
                }
            } catch (Throwable th2) {
                String b11 = WoodPeckerWebSocketAspect.f20988b;
                e.g(b11, ContainerUtils.KEY_VALUE_DELIMITER + th2.getMessage(), th2);
            }
        }
    }
}
