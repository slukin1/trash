package sn;

import android.text.TextUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.huobi.login.usercenter.data.source.bean.CountryInfo;
import com.huobi.login.usercenter.data.source.bean.CountryListData;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.huobi.utils.a0;
import com.luck.picture.lib.config.PictureMimeType;
import i6.k;
import java.util.Iterator;
import java.util.List;
import rx.Observable;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.schedulers.Schedulers;
import tq.p;
import u6.g;

public final class w {

    /* renamed from: f  reason: collision with root package name */
    public static final w f76559f = new w();

    /* renamed from: g  reason: collision with root package name */
    public static CountryListData f76560g;

    /* renamed from: a  reason: collision with root package name */
    public CountryInfo f76561a;

    /* renamed from: b  reason: collision with root package name */
    public List<CountryListData> f76562b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f76563c = true;

    /* renamed from: d  reason: collision with root package name */
    public CountryListData f76564d;

    /* renamed from: e  reason: collision with root package name */
    public CountryListData f76565e;

    public class a implements Func1<Throwable, CountryListData> {
        public a() {
        }

        /* renamed from: a */
        public CountryListData call(Throwable th2) {
            k.g("UserRegister", "getDefaultCountryDataByIp", th2);
            th2.printStackTrace();
            boolean unused = w.this.f76563c = true;
            w.this.m(w.f76560g);
            return w.f76560g;
        }
    }

    public class b implements Func2<CountryInfo, List<CountryListData>, CountryListData> {
        public b() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:13:0x003c  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x005a  */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.huobi.login.usercenter.data.source.bean.CountryListData call(com.huobi.login.usercenter.data.source.bean.CountryInfo r4, java.util.List<com.huobi.login.usercenter.data.source.bean.CountryListData> r5) {
            /*
                r3 = this;
                if (r4 == 0) goto L_0x0037
                java.lang.String r0 = r4.getCountryId()
                boolean r0 = android.text.TextUtils.isEmpty(r0)
                if (r0 != 0) goto L_0x0037
                if (r5 == 0) goto L_0x0037
                java.util.Iterator r5 = r5.iterator()
            L_0x0012:
                boolean r0 = r5.hasNext()
                if (r0 == 0) goto L_0x0037
                java.lang.Object r0 = r5.next()
                com.huobi.login.usercenter.data.source.bean.CountryListData r0 = (com.huobi.login.usercenter.data.source.bean.CountryListData) r0
                java.lang.String r1 = r4.getCountryId()
                int r2 = r0.c()
                java.lang.String r2 = java.lang.String.valueOf(r2)
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x0012
                sn.w r4 = sn.w.this
                r5 = 1
                boolean unused = r4.f76563c = r5
                goto L_0x0038
            L_0x0037:
                r0 = 0
            L_0x0038:
                java.lang.String r4 = "UserRegister"
                if (r0 == 0) goto L_0x005a
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r1 = "getDefaultCountryDataByIp - isFindCountryByIp "
                r5.append(r1)
                int r1 = r0.c()
                r5.append(r1)
                java.lang.String r5 = r5.toString()
                i6.k.f(r4, r5)
                sn.w r4 = sn.w.this
                r4.m(r0)
                return r0
            L_0x005a:
                java.lang.String r5 = "getDefaultCountryDataByIp - isFindCountryByIp false"
                i6.k.f(r4, r5)
                sn.w r4 = sn.w.this
                r5 = 0
                boolean unused = r4.f76563c = r5
                sn.w r4 = sn.w.this
                com.huobi.login.usercenter.data.source.bean.CountryListData r5 = sn.w.f76560g
                r4.m(r5)
                com.huobi.login.usercenter.data.source.bean.CountryListData r4 = sn.w.f76560g
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: sn.w.b.call(com.huobi.login.usercenter.data.source.bean.CountryInfo, java.util.List):com.huobi.login.usercenter.data.source.bean.CountryListData");
        }
    }

    public w() {
        CountryListData countryListData = new CountryListData();
        f76560g = countryListData;
        countryListData.j("阿根廷");
        f76560g.k("Argentina");
        f76560g.h("0054");
        f76560g.i(8);
    }

    public static String e(String str) {
        String j11 = a0.j();
        if (j11 == null) {
            j11 = "";
        }
        return j11 + "/-/x/hb/p/api/contents/country/icon/" + str + PictureMimeType.PNG;
    }

    public static w j() {
        return f76559f;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ CountryListData k(CountryInfo countryInfo, List list) {
        CountryListData countryListData;
        if (countryInfo != null && !TextUtils.isEmpty(countryInfo.getCountryId()) && list != null && !list.isEmpty()) {
            Iterator it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                countryListData = (CountryListData) it2.next();
                if (countryInfo.getCountryId().equals(String.valueOf(countryListData.c()))) {
                    break;
                }
            }
        }
        countryListData = null;
        if (countryListData != null) {
            k.f("UserRegister", "getDefaultCountryByIpAtAll - isFindCountryByIp " + countryListData.c());
            n(countryListData);
            return countryListData;
        }
        k.f("UserRegister", "getDefaultCountryByIpAtAll - isFindCountryByIp false");
        n(f76560g);
        return f76560g;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ CountryListData l(Throwable th2) {
        k.g("UserRegister", "getDefaultCountryByIpAtAll", th2);
        th2.printStackTrace();
        n(f76560g);
        return f76560g;
    }

    public CountryListData d() {
        return this.f76564d;
    }

    public List<CountryListData> f() {
        return this.f76562b;
    }

    public CountryInfo g() {
        return this.f76561a;
    }

    public Observable<CountryListData> h(g gVar) {
        CountryListData countryListData = this.f76564d;
        if (countryListData != null) {
            return Observable.just(countryListData);
        }
        return Observable.zip(UserCenterRemoteDataSource.A().u().compose(p.c0()).subscribeOn(Schedulers.io()), UserCenterRemoteDataSource.A().v().compose(p.c0()).subscribeOn(Schedulers.io()), new b()).onErrorReturn(new a()).compose(RxJavaHelper.t(gVar));
    }

    public Observable<CountryListData> i(g gVar) {
        CountryListData countryListData = this.f76565e;
        if (countryListData != null) {
            return Observable.just(countryListData);
        }
        return Observable.zip(UserCenterRemoteDataSource.A().u().compose(p.c0()).subscribeOn(Schedulers.io()), UserCenterRemoteDataSource.A().t().compose(p.c0()).subscribeOn(Schedulers.io()), new v(this)).onErrorReturn(new u(this)).compose(RxJavaHelper.t(gVar));
    }

    public void m(CountryListData countryListData) {
        this.f76564d = countryListData;
    }

    public void n(CountryListData countryListData) {
        this.f76565e = countryListData;
    }

    public void o(CountryInfo countryInfo) {
        this.f76561a = countryInfo;
    }
}
