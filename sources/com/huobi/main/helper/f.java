package com.huobi.main.helper;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.AccountNftInfoBean;
import com.hbg.lib.network.hbg.core.bean.UserOtherInfoData;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import gs.g;
import java.util.HashMap;
import rx.Observable;
import rx.schedulers.Schedulers;
import tg.r;
import tq.p;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public String f77726a;

    /* renamed from: b  reason: collision with root package name */
    public String f77727b;

    /* renamed from: c  reason: collision with root package name */
    public b f77728c;

    public class a extends BaseSubscriber<UserOtherInfoData> {
        public a() {
        }

        public void onError(Throwable th2) {
        }
    }

    public interface b {
        void a();
    }

    public static class c {
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: a  reason: collision with root package name */
        public static f f77730a = new f((a) null);
    }

    public /* synthetic */ f(a aVar) {
        this();
    }

    public static f c() {
        return c.f77730a;
    }

    public boolean b() {
        if (!TextUtils.isEmpty(this.f77726a) && r.x().F0() && !r.x().X()) {
            String i11 = SP.i("NFT_USER_IMG" + r.x().J(), (String) null);
            if (i11 != null && !TextUtils.equals(i11, "SHOWED") && !TextUtils.equals(i11, this.f77726a)) {
                return true;
            }
        }
        return false;
    }

    public String d() {
        return this.f77726a;
    }

    public String e() {
        return this.f77727b;
    }

    public final String f(UserOtherInfoData userOtherInfoData) {
        if (userOtherInfoData != null && TextUtils.equals(userOtherInfoData.getHead_image_type(), UserOtherInfoData.HEAD_IMAGE_TYPE_NFT)) {
            String head_image = userOtherInfoData.getHead_image();
            if (!TextUtils.isEmpty(head_image)) {
                return head_image;
            }
        }
        return null;
    }

    public Observable<UserOtherInfoData> g() {
        if (!r.x().F0() || r.x().X()) {
            k((UserOtherInfoData) null);
            r.x().s0((AccountNftInfoBean) null);
            return Observable.just(null);
        }
        v7.b.a().getNftInfo().b().compose(RxJavaHelper.s()).doOnNext(e.f77725b).subscribeOn(Schedulers.io());
        return UserCenterRemoteDataSource.A().S().compose(p.c0()).compose(RxJavaHelper.s()).doOnNext(new c(this)).doOnError(new d(this)).subscribeOn(Schedulers.io());
    }

    public void i(Throwable th2) {
        this.f77726a = null;
        this.f77727b = null;
        b bVar = this.f77728c;
        if (bVar != null) {
            bVar.a();
        }
    }

    public void j() {
        SP.s("NFT_USER_IMG" + r.x().J(), "SHOWED");
    }

    public void k(UserOtherInfoData userOtherInfoData) {
        this.f77726a = f(userOtherInfoData);
        if (userOtherInfoData != null) {
            this.f77727b = userOtherInfoData.getFrame_url();
        }
        m(this.f77726a, this.f77727b);
        b bVar = this.f77728c;
        if (bVar != null) {
            bVar.a();
        }
        if (!TextUtils.isEmpty(this.f77726a)) {
            g.i("navibar_nft_expo", (HashMap) null);
        }
    }

    public void l() {
        g().subscribe(new a());
    }

    public final void m(String str, String str2) {
        if (r.x().F0() && !r.x().X()) {
            if (SP.i("NFT_USER_IMG" + r.x().J(), (String) null) == null) {
                if (TextUtils.isEmpty(str)) {
                    str = "NO_NFT_IMG";
                }
                SP.s("NFT_USER_IMG" + r.x().J(), str);
                if (TextUtils.isEmpty(str2)) {
                    str2 = "NO_NFT_IMG";
                }
                SP.s("NFT_USER_IMG_FRAME" + r.x().J(), str2);
            }
        }
    }

    public void n(b bVar) {
        this.f77728c = bVar;
        if (!TextUtils.isEmpty(this.f77726a)) {
            this.f77728c.a();
        }
    }

    public f() {
    }
}
