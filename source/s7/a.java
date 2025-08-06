package s7;

import android.content.Context;
import android.text.TextUtils;
import c9.b;
import com.hbg.lib.network.contract.retrofit.ContractRetrofit;
import com.hbg.lib.network.pro.socket.listener.ContractAuthenticationListener;
import com.hbg.lib.network.pro.socket.subscribe.ContractAuthenticationSub;
import com.hbg.lib.network.pro.socket.subscribe.ContractPositionEventSub;
import com.hbg.lib.network.pro.socket.subscribe.ContractPositionV5Sub;
import com.hbg.lib.network.retrofit.util.RetrofitLogger;
import com.hbg.lib.network.retrofit.websocket.callback.BaseResponseMarketListener;
import g9.a;
import g9.i;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public i f70150a;

    /* renamed from: b  reason: collision with root package name */
    public b f70151b;

    /* renamed from: c  reason: collision with root package name */
    public String f70152c;

    /* renamed from: d  reason: collision with root package name */
    public ContractRetrofit f70153d = new ContractRetrofit();

    public a(String str) {
        this.f70152c = str;
    }

    public void a(a.d dVar) {
        RetrofitLogger.a(this.f70152c + "-->addReconnectListener-->" + dVar);
        i iVar = this.f70150a;
        if (iVar != null) {
            iVar.h(dVar);
        }
    }

    public void b(String str, String str2, ContractAuthenticationListener contractAuthenticationListener) {
        RetrofitLogger.a(this.f70152c + "-->authentication--> uid=" + str + " token=" + str2 + " listener=" + contractAuthenticationListener);
        if (!f()) {
            c();
        }
        i iVar = this.f70150a;
        if (iVar != null) {
            iVar.u(new ContractAuthenticationSub(str, str2), contractAuthenticationListener);
        }
    }

    public void c() {
        RetrofitLogger.a(this.f70152c + "-->connectWebSocket");
        i iVar = this.f70150a;
        if (iVar != null) {
            iVar.n();
        }
        b bVar = this.f70151b;
        if (bVar != null) {
            String webSocketHost = bVar.getWebSocketHost();
            if (!TextUtils.isEmpty(webSocketHost)) {
                if (this.f70150a == null) {
                    this.f70150a = new i(this.f70152c, this.f70153d.createSocketOkHttpClientBuilder().build(), this.f70151b);
                }
                this.f70150a.m(webSocketHost);
            }
        }
    }

    public void d() {
        RetrofitLogger.a(this.f70152c + "-->disconnectWebSocket");
        i iVar = this.f70150a;
        if (iVar != null) {
            iVar.n();
        }
    }

    public void e(Context context, b bVar) {
        RetrofitLogger.a(this.f70152c + "-->init");
        this.f70151b = bVar;
        this.f70153d.init(this.f70152c, context, bVar);
    }

    public final boolean f() {
        i iVar = this.f70150a;
        return iVar != null && iVar.q();
    }

    public void g(a.d dVar) {
        RetrofitLogger.a(this.f70152c + "-->removeReconnectListener-->" + dVar);
        i iVar = this.f70150a;
        if (iVar != null) {
            iVar.r(dVar);
        }
    }

    public void h(boolean z11, String str, BaseResponseMarketListener baseResponseMarketListener) {
        RetrofitLogger.a(this.f70152c + "-->subscribeContractPositionTpsl--> isSubscribe=" + z11 + " topic=" + str + " listener=" + baseResponseMarketListener);
        if (z11 && !f()) {
            c();
        }
        i iVar = this.f70150a;
        if (iVar != null) {
            iVar.u(new ContractPositionEventSub(z11, str), baseResponseMarketListener);
        }
    }

    public void i(boolean z11, String str, BaseResponseMarketListener baseResponseMarketListener) {
        RetrofitLogger.a(this.f70152c + "-->subscribeContractPositionEventV5--> isSubscribe=" + z11 + " topic=" + str + " listener=" + baseResponseMarketListener);
        if (z11 && !f()) {
            c();
        }
        i iVar = this.f70150a;
        if (iVar != null) {
            iVar.u(new ContractPositionV5Sub(z11, str), baseResponseMarketListener);
        }
    }
}
