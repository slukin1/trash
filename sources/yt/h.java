package yt;

import com.huobi.tradingbot.engine.TradingBotNativeAbility;
import java.util.List;
import rj.b;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f61985b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f61986c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f61987d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ b f61988e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f61989f;

    public /* synthetic */ h(String str, List list, String str2, b bVar, String str3) {
        this.f61985b = str;
        this.f61986c = list;
        this.f61987d = str2;
        this.f61988e = bVar;
        this.f61989f = str3;
    }

    public final void run() {
        TradingBotNativeAbility.U(this.f61985b, this.f61986c, this.f61987d, this.f61988e, this.f61989f);
    }
}
