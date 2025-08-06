package com.huobi.provider;

import android.content.Context;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.UserOtherInfoData;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.module.libkt.provider.HbgImProvider;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import tg.r;
import tq.p;

@Route(path = "/provider/im_userinfo")
public class ImProvider implements HbgImProvider {

    public class a extends BaseSubscriber<UserOtherInfoData> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ve.a f80513b;

        public a(ve.a aVar) {
            this.f80513b = aVar;
        }

        /* renamed from: a */
        public void onNext(UserOtherInfoData userOtherInfoData) {
            super.onNext(userOtherInfoData);
            r.x().j0(userOtherInfoData.getHead_image());
            r.x().z0(userOtherInfoData.getNick_name());
            this.f80513b.a(userOtherInfoData);
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            this.f80513b.a((UserOtherInfoData) null);
        }
    }

    public void a(ve.a aVar) {
        UserCenterRemoteDataSource.A().S().compose(p.c0()).compose(RxJavaHelper.s()).subscribe(new a(aVar));
    }

    public void init(Context context) {
    }
}
