package up;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.network.retrofit.websocketnew.PSocketListenerDispatcher;
import com.hbg.lib.network.retrofit.websocketnew.enums.OtcWsHeader;
import com.hbg.lib.network.retrofit.websocketnew.enums.POtcWsChannel;
import com.hbg.module.otc.OtcModuleConfig;
import com.huobi.otc.bean.OtcChatContentList;
import com.huobi.otc.enums.OtcWsChannel;
import com.huobi.otc.utils.OtcCountryConfigUtil;
import com.huobi.utils.GsonHelper;
import com.huobi.websocket.protobuf.source.Message$Proto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Response;
import okhttp3.WebSocket;

public final class x extends PSocketListenerDispatcher.PWebSocketListener {

    /* renamed from: f  reason: collision with root package name */
    public static volatile x f84936f;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<String, List<f>> f84937a = new ConcurrentHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<String, List<f>> f84938b = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public ConcurrentHashMap<String, g> f84939c = new ConcurrentHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public h f84940d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f84941e = new Handler(Looper.getMainLooper());

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            for (Map.Entry value : x.this.f84939c.entrySet()) {
                g gVar = (g) value.getValue();
                if (gVar != null) {
                    gVar.a();
                }
            }
            if (x.this.f84940d != null) {
                x.this.f84940d.b();
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            x.this.o();
            if (x.this.f84940d != null) {
                x.this.f84940d.a();
            }
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            x.this.o();
        }
    }

    public class d implements Runnable {
        public d() {
        }

        public void run() {
            x.this.o();
        }
    }

    public class e implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Message$Proto f84946b;

        public e(Message$Proto message$Proto) {
            this.f84946b = message$Proto;
        }

        public void run() {
            Message$Proto message$Proto = this.f84946b;
            if (message$Proto != null) {
                if (message$Proto.getChannel() == Integer.parseInt(POtcWsChannel.chat.getValue())) {
                    x xVar = x.this;
                    xVar.n(this.f84946b, xVar.f84937a);
                } else if (this.f84946b.getChannel() == Integer.parseInt(POtcWsChannel.order.getValue()) && x.this.f84940d != null) {
                    x.this.f84940d.c(this.f84946b);
                }
            }
        }
    }

    public interface f {
        void a(boolean z11, String str, Message$Proto message$Proto);
    }

    public interface g {
        void a();

        void b();
    }

    public interface h {
        void a();

        void b();

        void c(Message$Proto message$Proto);
    }

    public static x j() {
        if (f84936f == null) {
            synchronized (x.class) {
                if (f84936f == null) {
                    f84936f = new x();
                }
            }
        }
        return f84936f;
    }

    public boolean a() {
        if (!k(this.f84937a) && !k(this.f84938b) && this.f84940d == null) {
            return false;
        }
        return true;
    }

    public void b(Message$Proto message$Proto) {
        f9.b.a().b(new e(message$Proto));
    }

    public void h() {
        String str;
        if (!s8.a.a().e()) {
            HashMap hashMap = new HashMap();
            hashMap.put(OtcWsHeader.role.name(), "1");
            String name = OtcWsHeader.token.name();
            if (OtcModuleConfig.a().c() == null) {
                str = "";
            } else {
                str = OtcModuleConfig.a().c();
            }
            hashMap.put(name, str);
            hashMap.put(OtcWsHeader.channel.name(), OtcWsChannel.wps.getValue());
            hashMap.put(OtcWsHeader.terminalId.name(), "1");
            hashMap.put(OtcWsHeader.language.name(), OtcCountryConfigUtil.b());
            hashMap.put(OtcWsHeader.appVersion.name(), String.valueOf(BaseApplication.d()));
            String name2 = OtcWsHeader.timestamp.name();
            hashMap.put(name2, System.currentTimeMillis() + "");
            String c02 = OtcModuleConfig.a().c0();
            if (!TextUtils.isEmpty(c02)) {
                hashMap.put(OtcWsHeader.fingerprint.name(), c02);
            }
            s8.a.a().i(hashMap, this);
        }
    }

    public void i() {
        if (s8.a.a().e()) {
            s8.a.a().b();
        }
    }

    public final boolean k(Map<String, List<f>> map) {
        Set<Map.Entry<String, List<f>>> entrySet = map.entrySet();
        if (entrySet == null || entrySet.size() <= 0) {
            return false;
        }
        for (Map.Entry<String, List<f>> value : entrySet) {
            List list = (List) value.getValue();
            if (list != null && list.size() > 0) {
                return true;
            }
        }
        return false;
    }

    public boolean l() {
        return s8.a.a().e();
    }

    public final void m(boolean z11, Message$Proto message$Proto, Map<String, List<f>> map, String str) {
        for (Map.Entry next : map.entrySet()) {
            String str2 = (String) next.getKey();
            if (TextUtils.equals(str, str2)) {
                List<f> list = (List) next.getValue();
                if (list != null && !list.isEmpty()) {
                    for (f a11 : list) {
                        a11.a(z11, str2, message$Proto);
                    }
                    return;
                }
                return;
            }
        }
    }

    public final void n(Message$Proto message$Proto, Map<String, List<f>> map) {
        if (message$Proto.getAction() == 1 || message$Proto.getAction() == 4 || message$Proto.getAction() == 0 || message$Proto.getAction() == 2 || message$Proto.getAction() == 5) {
            try {
                OtcChatContentList.OtcChatDetailContent otcChatDetailContent = (OtcChatContentList.OtcChatDetailContent) GsonHelper.a().fromJson(message$Proto.getExtra(), OtcChatContentList.OtcChatDetailContent.class);
                if (otcChatDetailContent != null) {
                    m(true, message$Proto, map, String.valueOf(otcChatDetailContent.getOrderId()));
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        } else if (message$Proto.getAction() == 100) {
            try {
                String str = (String) GsonHelper.a().fromJson(message$Proto.getExtra(), String.class);
                if (!TextUtils.isEmpty(str)) {
                    m(false, message$Proto, map, str);
                }
            } catch (Exception e12) {
                e12.printStackTrace();
            }
        }
    }

    public final void o() {
        for (Map.Entry<String, g> value : this.f84939c.entrySet()) {
            g gVar = (g) value.getValue();
            if (gVar != null) {
                gVar.b();
            }
        }
    }

    public void onClosed(WebSocket webSocket, int i11, String str) {
        super.onClosed(webSocket, i11, str);
        f9.b.a().b(new b());
    }

    public void onClosing(WebSocket webSocket, int i11, String str) {
        super.onClosing(webSocket, i11, str);
        f9.b.a().b(new c());
        h hVar = this.f84940d;
        if (hVar != null) {
            hVar.a();
        }
    }

    public void onFailure(WebSocket webSocket, Throwable th2, Response response) {
        super.onFailure(webSocket, th2, response);
        f9.b.a().b(new d());
        h hVar = this.f84940d;
        if (hVar != null) {
            hVar.a();
        }
    }

    public void onOpen(WebSocket webSocket, Response response) {
        super.onOpen(webSocket, response);
        f9.b.a().b(new a());
    }

    public void p(String str, f fVar, g gVar) {
        if (str != null) {
            List list = this.f84937a.get(str);
            if (list == null) {
                list = new ArrayList();
                this.f84937a.put(str, list);
            }
            h();
            if (!list.contains(fVar)) {
                list.add(fVar);
            }
            s8.a.a().f(str);
            ConcurrentHashMap<String, g> concurrentHashMap = this.f84939c;
            concurrentHashMap.put(str + fVar.toString(), gVar);
            i6.d.j("asdffsfsd", "PSocketKeeper messageCallBackMap subscribeChatMessage..." + Thread.currentThread() + " " + this.f84937a.size());
        }
    }

    public void q(h hVar) {
        if (this.f84940d == null) {
            this.f84940d = hVar;
        }
        h();
        s8.a.a().n();
        s8.a.a().c();
    }

    public void r(String str, f fVar) {
        if (str != null && fVar != null && this.f84937a.get(str) != null) {
            List list = this.f84937a.get(str);
            if (list != null && list.contains(fVar)) {
                list.remove(fVar);
            }
            if (list == null || list.isEmpty()) {
                this.f84937a.remove(str);
                if (s8.a.a().e()) {
                    s8.a.a().k(str);
                }
            }
            ConcurrentHashMap<String, g> concurrentHashMap = this.f84939c;
            if (concurrentHashMap.get(str + fVar.toString()) != null) {
                ConcurrentHashMap<String, g> concurrentHashMap2 = this.f84939c;
                concurrentHashMap2.remove(str + fVar.toString());
            }
            i6.d.j("asdffsfsd", "PSocketKeeper messageCallBackMap unSubscribeChatMessage..." + Thread.currentThread() + " " + this.f84937a.size());
        }
    }

    public void s(h hVar) {
        if (hVar != null) {
            if (s8.a.a().e()) {
                s8.a.a().j();
            }
            this.f84940d = null;
        }
    }
}
