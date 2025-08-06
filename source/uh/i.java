package uh;

import com.hbg.lib.common.utils.SP;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.util.m0;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.asset.event.ChangeVerticalSpotFromWhiteListEvent;
import i6.k;
import org.greenrobot.eventbus.EventBus;
import u6.g;

public final class i {

    /* renamed from: c  reason: collision with root package name */
    public static final i f47924c = new i();

    /* renamed from: a  reason: collision with root package name */
    public boolean f47925a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f47926b = true;

    public class a extends EasySubscriber<Boolean> {
        public a() {
        }

        /* renamed from: a */
        public void onNext(Boolean bool) {
            super.onNext(bool);
            if (bool != null) {
                SP.y("spot-leverage", bool.booleanValue());
                EventBus.d().k(new ChangeVerticalSpotFromWhiteListEvent());
            }
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
        }
    }

    public class b extends EasySubscriber<Boolean> {
        public b() {
        }

        /* renamed from: a */
        public void onNext(Boolean bool) {
            super.onNext(bool);
            if (bool != null) {
                boolean unused = i.this.f47926b = bool.booleanValue();
            }
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            boolean unused = i.this.f47926b = true;
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            boolean unused = i.this.f47926b = true;
        }
    }

    public static i d() {
        return f47924c;
    }

    public static /* synthetic */ void i(Boolean bool) {
        if (bool != null) {
            SP.y("asset_gray_ybb", bool.booleanValue());
        }
        k.o("AssetGary_Ybb", "network flag:" + bool);
    }

    public static /* synthetic */ void j(Boolean bool) {
        if (bool != null) {
            SP.y("asset_gray_flag_new_1", bool.booleanValue());
        }
        k.o("AssetGary_new_Asset", "network flag:" + bool);
    }

    public boolean e() {
        return this.f47926b;
    }

    public boolean f() {
        return this.f47925a;
    }

    public boolean g() {
        return SP.l("spot-leverage", false);
    }

    public boolean h() {
        if (BaseModuleConfig.a().c()) {
            return false;
        }
        boolean l11 = SP.l("asset_gray_ybb", false);
        k.o("AssetGary_Ybb", "cache flag:" + l11);
        return l11;
    }

    public final void k() {
        v7.b.a().getAssetContractConfig().b().compose(RxJavaHelper.t((g) null)).subscribe(new b());
    }

    public void l() {
        v7.b.a().getAssetPageGary(m0.a(), "flexible").b().compose(RxJavaHelper.t((g) null)).subscribe(EasySubscriber.create(h.f60676b));
        if (BaseModuleConfig.a() != null && BaseModuleConfig.a().a()) {
            v7.b.a().getAssetUserGray().b().compose(RxJavaHelper.t((g) null)).subscribe(EasySubscriber.create(g.f60674b));
            k();
        }
    }

    public void m() {
        v7.b.a().getAssetPageGary(m0.a(), "spot-leverage").b().compose(RxJavaHelper.t((g) null)).subscribe(new a());
    }

    public void n(boolean z11) {
        this.f47925a = z11;
    }
}
