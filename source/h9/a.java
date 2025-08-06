package h9;

import com.hbg.lib.network.retrofit.response.IResponse;
import com.hbg.lib.network.retrofit.websocket.callback.BaseResponseMarketListener;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BaseResponseMarketListener f54906b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ IResponse f54907c;

    public /* synthetic */ a(BaseResponseMarketListener baseResponseMarketListener, IResponse iResponse) {
        this.f54906b = baseResponseMarketListener;
        this.f54907c = iResponse;
    }

    public final void run() {
        this.f54906b.d(this.f54907c);
    }
}
