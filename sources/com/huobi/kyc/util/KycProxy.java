package com.huobi.kyc.util;

import com.facebook.internal.ServerProtocol;
import com.hbg.lib.network.inst.bean.InstStateInfo;
import com.hbg.lib.network.newkyc.bean.UnifyKycInfo;
import com.hbg.lib.network.newkyc.bean.UserKycInfoNew;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.huobi.kyc.bean.CountryKyc;
import com.huobi.kyc.service.KycService;
import i6.k;
import java.util.HashMap;
import java.util.List;
import rx.Observable;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import tq.p;
import vm.c;
import vm.d;
import vm.e;
import yl.g;

public class KycProxy {

    /* renamed from: a  reason: collision with root package name */
    public UserKycInfoNew f74915a;

    /* renamed from: b  reason: collision with root package name */
    public List<CountryKyc> f74916b;

    /* renamed from: c  reason: collision with root package name */
    public UnifyKycInfo f74917c;

    /* renamed from: d  reason: collision with root package name */
    public volatile Boolean f74918d = Boolean.FALSE;

    /* renamed from: e  reason: collision with root package name */
    public volatile InstStateInfo f74919e;

    public class a implements Action1<UnifyKycInfo> {
        public a() {
        }

        /* renamed from: a */
        public void call(UnifyKycInfo unifyKycInfo) {
            UnifyKycInfo unused = KycProxy.this.f74917c = unifyKycInfo;
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final KycProxy f74921a = new KycProxy();
    }

    public static KycProxy l() {
        return b.f74921a;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void s(UserKycInfoNew userKycInfoNew) {
        this.f74915a = userKycInfoNew;
        g.h().r(userKycInfoNew);
    }

    public static /* synthetic */ Boolean t(UserKycInfoNew userKycInfoNew) {
        return Boolean.valueOf(userKycInfoNew != null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List u(List list) {
        this.f74916b = list;
        return list;
    }

    public static /* synthetic */ Object v(Object obj) {
        return Boolean.valueOf(obj != null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable w(InstStateInfo instStateInfo) {
        if (instStateInfo == null || instStateInfo.getState() == null || !(instStateInfo.getState().intValue() == 1 || instStateInfo.getState().intValue() == 3 || instStateInfo.getState().intValue() == 4)) {
            this.f74918d = Boolean.FALSE;
            k.o("kycjudge", "not inst");
        } else {
            this.f74918d = Boolean.TRUE;
            k.o("kycjudge", "Inst info:" + instStateInfo.getState() + " " + instStateInfo.getLanguage());
        }
        this.f74919e = instStateInfo;
        return Observable.just(this.f74918d);
    }

    public Observable<String> g(String str, String str2) {
        return ((KycService) p.V(KycService.class)).chineseAuth(MapParamsBuilder.c().a("method", "do_auth_pro_china").a("countries_id", 37).a("name", str).a("card_no", str2).b()).compose(p.a0());
    }

    public void h() {
        this.f74915a = null;
        this.f74917c = null;
        g.h().e();
        this.f74918d = Boolean.FALSE;
        this.f74919e = null;
    }

    public Observable<UserKycInfoNew> i(boolean z11) {
        Observable<UserKycInfoNew> doOnNext = n8.a.a().getAuthInfo().b().subscribeOn(Schedulers.io()).doOnNext(new vm.a(this));
        return z11 ? Observable.concat(Observable.just(this.f74915a), doOnNext).takeFirst(d.f61090b) : doOnNext;
    }

    public Observable<List<CountryKyc>> j() {
        HashMap hashMap = new HashMap();
        hashMap.put("method", "get_country_list");
        hashMap.put(ServerProtocol.DIALOG_PARAM_AUTH_TYPE, "9");
        return Observable.concat(Observable.just(this.f74916b), ((KycService) p.V(KycService.class)).getCountryList(hashMap).compose(p.a0()).map(new c(this))).takeFirst(e.f61091b);
    }

    public InstStateInfo k() {
        return this.f74919e;
    }

    public UnifyKycInfo m() {
        return this.f74917c;
    }

    public Observable<UnifyKycInfo> n(boolean z11) {
        UnifyKycInfo unifyKycInfo;
        if (!z11 || (unifyKycInfo = this.f74917c) == null) {
            return n8.a.a().getUnifyKycInfoV2().b().doOnNext(new a());
        }
        return Observable.just(unifyKycInfo);
    }

    public synchronized UserKycInfoNew o() {
        return this.f74915a;
    }

    public int p() {
        UserKycInfoNew userKycInfoNew = this.f74915a;
        if (userKycInfoNew == null || userKycInfoNew.getAuth_info() == null) {
            return 0;
        }
        return this.f74915a.getAuth_info().getPro_status();
    }

    public Observable<Boolean> q(boolean z11) {
        if (z11) {
            return Observable.just(this.f74918d);
        }
        return f8.a.a().getInstStateInfo().b().flatMap(new vm.b(this));
    }

    public boolean r() {
        if (this.f74918d == null) {
            return false;
        }
        return this.f74918d.booleanValue();
    }
}
