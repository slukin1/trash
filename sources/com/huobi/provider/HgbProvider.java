package com.huobi.provider;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.UserOtherInfoData;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.module.libkt.provider.HbgBaseProvider;
import com.huobi.login.bean.JumpTarget;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import rn.c;
import tg.r;
import tq.p;

@Route(path = "/provider/content")
public class HgbProvider implements HbgBaseProvider {

    public class a extends BaseSubscriber<UserOtherInfoData> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ve.a f80511b;

        public a(ve.a aVar) {
            this.f80511b = aVar;
        }

        /* renamed from: a */
        public void onNext(UserOtherInfoData userOtherInfoData) {
            super.onNext(userOtherInfoData);
            r.x().j0(userOtherInfoData.getHead_image());
            r.x().z0(userOtherInfoData.getNick_name());
            this.f80511b.a(userOtherInfoData);
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            this.f80511b.a((UserOtherInfoData) null);
        }
    }

    public void a(ve.a aVar) {
        UserCenterRemoteDataSource.A().S().compose(p.c0()).compose(RxJavaHelper.s()).subscribe(new a(aVar));
    }

    public boolean c() {
        return r.x().X();
    }

    public void g(String str) {
        BaseModuleConfig.a().k0(str);
    }

    public void init(Context context) {
    }

    public boolean j(Context context) {
        if (r.x().F0()) {
            return true;
        }
        c.i().d(context, new JumpTarget((Intent) null, (Intent) null));
        return false;
    }

    public boolean n() {
        return r.x().F0();
    }

    public void p(int i11) {
        zn.a d11 = zn.a.d();
        d11.v(Uri.parse("holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/market/content?type=" + i11)).a().c();
    }
}
