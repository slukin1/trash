package tq;

import android.text.TextUtils;
import com.hbg.lib.common.network.exception.NullResponseException;
import com.hbg.lib.common.utils.SystemUtils;
import com.hbg.lib.core.network.response.EtfCodeResponse;
import com.hbg.lib.core.network.response.IntStatusResponse;
import com.hbg.lib.core.network.response.RiskIntCodeResponse;
import com.hbg.lib.core.network.response.StringStatusResponse;
import com.hbg.lib.core.network.response.UcIntCodeResponse;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.bugsdk.FirebaseHelper;
import com.huobi.domain.DomainSwitcher;
import com.huobi.network.HttpConfig;
import com.huobi.network.utils.HRetrofitNullPointerException;
import com.huobi.utils.GsonHelper;
import i6.d;
import i6.k;
import java.util.HashMap;
import java.util.Map;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import wi.b;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, Retrofit> f84888a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, String> f84889b = new HashMap();

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f84890a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.hbg.lib.data.symbol.TradeType[] r0 = com.hbg.lib.data.symbol.TradeType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f84890a = r0
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.PRO     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f84890a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.MARGIN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f84890a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.SUPERMARGIN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: tq.p.a.<clinit>():void");
        }
    }

    public static <T> T A(Class<T> cls) {
        T t11;
        Map<String, Retrofit> map = f84888a;
        synchronized (map) {
            if (map.get("etf") == null) {
                map.put("etf", s());
            } else {
                String str = f84889b.get("etf");
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(DomainSwitcher.v()) && !str.equals(DomainSwitcher.v())) {
                    map.put("etf", s());
                }
            }
            try {
                t11 = map.get("etf").create(cls);
            } catch (Exception e11) {
                FirebaseHelper.e(new HRetrofitNullPointerException(Thread.currentThread().getName(), e11));
                Map<String, Retrofit> map2 = f84888a;
                Retrofit retrofit = map2.get("etf");
                map2.put("etf", retrofit);
                t11 = retrofit.create(cls);
            }
        }
        return t11;
    }

    public static <T> Observable.Transformer<EtfCodeResponse<T>, T> B() {
        return l.f37350b;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:17|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r1 = f84888a;
        r2 = r1.get("hbg");
        r1.put("hbg", r2);
        r4 = r2.create(r4);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> T C(java.lang.Class<T> r4) {
        /*
            java.util.Map<java.lang.String, retrofit2.Retrofit> r0 = f84888a
            monitor-enter(r0)
            java.lang.String r1 = "hbg"
            java.lang.Object r1 = r0.get(r1)     // Catch:{ all -> 0x0064 }
            if (r1 != 0) goto L_0x0015
            retrofit2.Retrofit r1 = t()     // Catch:{ all -> 0x0064 }
            java.lang.String r2 = "hbg"
            r0.put(r2, r1)     // Catch:{ all -> 0x0064 }
            goto L_0x0042
        L_0x0015:
            java.util.Map<java.lang.String, java.lang.String> r1 = f84889b     // Catch:{ all -> 0x0064 }
            java.lang.String r2 = "hbg"
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x0064 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x0064 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0064 }
            if (r2 != 0) goto L_0x0042
            java.lang.String r2 = com.huobi.domain.DomainSwitcher.y()     // Catch:{ all -> 0x0064 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0064 }
            if (r2 != 0) goto L_0x0042
            java.lang.String r2 = com.huobi.domain.DomainSwitcher.y()     // Catch:{ all -> 0x0064 }
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0064 }
            if (r1 != 0) goto L_0x0042
            retrofit2.Retrofit r1 = t()     // Catch:{ all -> 0x0064 }
            java.lang.String r2 = "hbg"
            r0.put(r2, r1)     // Catch:{ all -> 0x0064 }
        L_0x0042:
            java.lang.String r1 = "hbg"
            java.lang.Object r1 = r0.get(r1)     // Catch:{ Exception -> 0x004f }
            retrofit2.Retrofit r1 = (retrofit2.Retrofit) r1     // Catch:{ Exception -> 0x004f }
            java.lang.Object r4 = r1.create(r4)     // Catch:{ Exception -> 0x004f }
            goto L_0x0062
        L_0x004f:
            java.util.Map<java.lang.String, retrofit2.Retrofit> r1 = f84888a     // Catch:{ all -> 0x0064 }
            java.lang.String r2 = "hbg"
            java.lang.Object r2 = r1.get(r2)     // Catch:{ all -> 0x0064 }
            retrofit2.Retrofit r2 = (retrofit2.Retrofit) r2     // Catch:{ all -> 0x0064 }
            java.lang.String r3 = "hbg"
            r1.put(r3, r2)     // Catch:{ all -> 0x0064 }
            java.lang.Object r4 = r2.create(r4)     // Catch:{ all -> 0x0064 }
        L_0x0062:
            monitor-exit(r0)     // Catch:{ all -> 0x0064 }
            return r4
        L_0x0064:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0064 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: tq.p.C(java.lang.Class):java.lang.Object");
    }

    public static <T> Observable.Transformer<UcIntCodeResponse<T>, T> D() {
        return c0();
    }

    public static <T> Observable.Transformer<IntStatusResponse<T>, T> E() {
        return o.f37353b;
    }

    public static /* synthetic */ void F(EtfCodeResponse etfCodeResponse, Subscriber subscriber) {
        subscriber.onStart();
        if (etfCodeResponse == null) {
            subscriber.onError(new NullResponseException());
        } else if (etfCodeResponse.isSuccess()) {
            subscriber.onNext(etfCodeResponse.getData());
            subscriber.onCompleted();
        } else {
            subscriber.onError(new APIStatusErrorException(etfCodeResponse.getCode() + "", etfCodeResponse.getMessage()));
        }
    }

    public static /* synthetic */ void I(IntStatusResponse intStatusResponse, Subscriber subscriber) {
        subscriber.onStart();
        if (intStatusResponse == null) {
            subscriber.onError(new NullResponseException());
        } else if (intStatusResponse.isSuccess()) {
            subscriber.onNext(intStatusResponse.getData());
            subscriber.onCompleted();
        } else {
            subscriber.onError(new APIStatusErrorException(intStatusResponse.getStatus() + "", intStatusResponse.getMessage()));
        }
    }

    public static /* synthetic */ void N(RiskIntCodeResponse riskIntCodeResponse, Subscriber subscriber) {
        subscriber.onStart();
        if (riskIntCodeResponse == null) {
            subscriber.onError(new NullResponseException());
        } else if (riskIntCodeResponse.isSuccess()) {
            subscriber.onNext(riskIntCodeResponse.getData());
            subscriber.onCompleted();
        } else {
            subscriber.onError(new APIStatusErrorException(riskIntCodeResponse.getCode() + "", riskIntCodeResponse.getMessage()));
        }
    }

    public static /* synthetic */ void O(StringStatusResponse stringStatusResponse, Subscriber subscriber) {
        subscriber.onStart();
        if (stringStatusResponse == null) {
            subscriber.onError(new NullResponseException());
        } else if (stringStatusResponse.isSuccess()) {
            subscriber.onNext(stringStatusResponse.getData());
            subscriber.onCompleted();
        } else {
            subscriber.onError(new APIStatusErrorException(stringStatusResponse.getErrCode(), stringStatusResponse.getErrMsg()));
        }
    }

    public static /* synthetic */ void R(UcIntCodeResponse ucIntCodeResponse, Subscriber subscriber) {
        subscriber.onStart();
        if (ucIntCodeResponse == null) {
            subscriber.onError(new NullResponseException());
        } else if (ucIntCodeResponse.isSuccess()) {
            subscriber.onNext(ucIntCodeResponse.getData());
            subscriber.onCompleted();
        } else {
            subscriber.onError(new APIStatusErrorException(String.valueOf(ucIntCodeResponse.getCode()), ucIntCodeResponse.getMessage(), ucIntCodeResponse.getData()));
        }
    }

    public static <T> T U(Class<T> cls) {
        T t11;
        Map<String, Retrofit> map = f84888a;
        synchronized (map) {
            if (map.get("otc") == null) {
                map.put("otc", u());
            } else {
                String str = f84889b.get("otc");
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(DomainSwitcher.M()) && !str.equals(DomainSwitcher.M())) {
                    map.put("otc", u());
                }
            }
            try {
                t11 = map.get("otc").create(cls);
            } catch (Exception e11) {
                FirebaseHelper.e(new HRetrofitNullPointerException(Thread.currentThread().getName(), e11));
                Map<String, Retrofit> map2 = f84888a;
                Retrofit retrofit = map2.get("otc");
                map2.put("otc", retrofit);
                t11 = retrofit.create(cls);
            }
        }
        return t11;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:17|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r1 = f84888a;
        r2 = r1.get("php");
        r1.put("php", r2);
        r4 = r2.create(r4);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> T V(java.lang.Class<T> r4) {
        /*
            java.util.Map<java.lang.String, retrofit2.Retrofit> r0 = f84888a
            monitor-enter(r0)
            java.lang.String r1 = "php"
            java.lang.Object r1 = r0.get(r1)     // Catch:{ all -> 0x0064 }
            if (r1 != 0) goto L_0x0015
            retrofit2.Retrofit r1 = v()     // Catch:{ all -> 0x0064 }
            java.lang.String r2 = "php"
            r0.put(r2, r1)     // Catch:{ all -> 0x0064 }
            goto L_0x0042
        L_0x0015:
            java.util.Map<java.lang.String, java.lang.String> r1 = f84889b     // Catch:{ all -> 0x0064 }
            java.lang.String r2 = "php"
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x0064 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x0064 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0064 }
            if (r2 != 0) goto L_0x0042
            java.lang.String r2 = com.huobi.domain.DomainSwitcher.N()     // Catch:{ all -> 0x0064 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0064 }
            if (r2 != 0) goto L_0x0042
            java.lang.String r2 = com.huobi.domain.DomainSwitcher.N()     // Catch:{ all -> 0x0064 }
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0064 }
            if (r1 != 0) goto L_0x0042
            retrofit2.Retrofit r1 = v()     // Catch:{ all -> 0x0064 }
            java.lang.String r2 = "php"
            r0.put(r2, r1)     // Catch:{ all -> 0x0064 }
        L_0x0042:
            java.lang.String r1 = "php"
            java.lang.Object r1 = r0.get(r1)     // Catch:{ Exception -> 0x004f }
            retrofit2.Retrofit r1 = (retrofit2.Retrofit) r1     // Catch:{ Exception -> 0x004f }
            java.lang.Object r4 = r1.create(r4)     // Catch:{ Exception -> 0x004f }
            goto L_0x0062
        L_0x004f:
            java.util.Map<java.lang.String, retrofit2.Retrofit> r1 = f84888a     // Catch:{ all -> 0x0064 }
            java.lang.String r2 = "php"
            java.lang.Object r2 = r1.get(r2)     // Catch:{ all -> 0x0064 }
            retrofit2.Retrofit r2 = (retrofit2.Retrofit) r2     // Catch:{ all -> 0x0064 }
            java.lang.String r3 = "php"
            r1.put(r3, r2)     // Catch:{ all -> 0x0064 }
            java.lang.Object r4 = r2.create(r4)     // Catch:{ all -> 0x0064 }
        L_0x0062:
            monitor-exit(r0)     // Catch:{ all -> 0x0064 }
            return r4
        L_0x0064:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0064 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: tq.p.V(java.lang.Class):java.lang.Object");
    }

    public static <T> T W(Class<T> cls) {
        T t11;
        String name = Thread.currentThread().getName();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(" method = pro ");
        sb2.append(", t = " + name);
        Map<String, Retrofit> map = f84888a;
        synchronized (map) {
            sb2.append(", retrofitMap1 = " + map);
            sb2.append(", key = pro");
            if (map.get("pro") == null) {
                sb2.append(", retrofitMap.get(pro) == null ");
                Retrofit w11 = w();
                map.put("pro", w11);
                sb2.append(", retrofitMap put1 = " + w11);
                sb2.append(", retrofitMap2 = " + map);
            } else {
                String str = f84889b.get("pro");
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(DomainSwitcher.O()) && !str.equals(DomainSwitcher.O())) {
                    sb2.append(" url has change ");
                    Retrofit w12 = w();
                    map.put("pro", w12);
                    sb2.append(", retrofitMap put2 = " + w12);
                    sb2.append(", retrofitMap3 =  " + map);
                }
            }
            try {
                Retrofit retrofit = map.get("pro");
                sb2.append(", retrofitMap get key = pro value = " + retrofit);
                sb2.append(", retrofitMap4 = " + map);
                t11 = retrofit.create(cls);
                sb2.append(", pro method normal ");
            } catch (Exception e11) {
                e11.printStackTrace();
                Map<String, Retrofit> map2 = f84888a;
                Retrofit retrofit3 = map2.get("pro");
                map2.put("pro", retrofit3);
                sb2.append(", retrofitMap put3 " + retrofit3);
                sb2.append(", retrofitMap5 =  " + map2);
                sb2.append(", pro method has exception ");
                FirebaseHelper.e(new HRetrofitNullPointerException(sb2.toString(), e11));
                k.f("RETROFIT", sb2.toString());
                t11 = retrofit3.create(cls);
            }
        }
        return t11;
    }

    public static <T> T X(TradeType tradeType, Class<T> cls) {
        int i11 = a.f84890a[tradeType.ordinal()];
        if (i11 == 1) {
            return W(cls);
        }
        if (i11 == 2) {
            return W(cls);
        }
        if (i11 != 3) {
            return W(cls);
        }
        return W(cls);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:17|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r1 = f84888a;
        r2 = r1.get("risk");
        r1.put("risk", r2);
        r4 = r2.create(r4);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> T Y(java.lang.Class<T> r4) {
        /*
            java.util.Map<java.lang.String, retrofit2.Retrofit> r0 = f84888a
            monitor-enter(r0)
            java.lang.String r1 = "risk"
            java.lang.Object r1 = r0.get(r1)     // Catch:{ all -> 0x0064 }
            if (r1 != 0) goto L_0x0015
            retrofit2.Retrofit r1 = x()     // Catch:{ all -> 0x0064 }
            java.lang.String r2 = "risk"
            r0.put(r2, r1)     // Catch:{ all -> 0x0064 }
            goto L_0x0042
        L_0x0015:
            java.util.Map<java.lang.String, java.lang.String> r1 = f84889b     // Catch:{ all -> 0x0064 }
            java.lang.String r2 = "risk"
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x0064 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x0064 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0064 }
            if (r2 != 0) goto L_0x0042
            java.lang.String r2 = com.huobi.domain.DomainSwitcher.Q()     // Catch:{ all -> 0x0064 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0064 }
            if (r2 != 0) goto L_0x0042
            java.lang.String r2 = com.huobi.domain.DomainSwitcher.Q()     // Catch:{ all -> 0x0064 }
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0064 }
            if (r1 != 0) goto L_0x0042
            retrofit2.Retrofit r1 = x()     // Catch:{ all -> 0x0064 }
            java.lang.String r2 = "risk"
            r0.put(r2, r1)     // Catch:{ all -> 0x0064 }
        L_0x0042:
            java.lang.String r1 = "risk"
            java.lang.Object r1 = r0.get(r1)     // Catch:{ Exception -> 0x004f }
            retrofit2.Retrofit r1 = (retrofit2.Retrofit) r1     // Catch:{ Exception -> 0x004f }
            java.lang.Object r4 = r1.create(r4)     // Catch:{ Exception -> 0x004f }
            goto L_0x0062
        L_0x004f:
            java.util.Map<java.lang.String, retrofit2.Retrofit> r1 = f84888a     // Catch:{ all -> 0x0064 }
            java.lang.String r2 = "risk"
            java.lang.Object r2 = r1.get(r2)     // Catch:{ all -> 0x0064 }
            retrofit2.Retrofit r2 = (retrofit2.Retrofit) r2     // Catch:{ all -> 0x0064 }
            java.lang.String r3 = "risk"
            r1.put(r3, r2)     // Catch:{ all -> 0x0064 }
            java.lang.Object r4 = r2.create(r4)     // Catch:{ all -> 0x0064 }
        L_0x0062:
            monitor-exit(r0)     // Catch:{ all -> 0x0064 }
            return r4
        L_0x0064:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0064 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: tq.p.Y(java.lang.Class):java.lang.Object");
    }

    public static <T> Observable.Transformer<RiskIntCodeResponse<T>, T> Z() {
        return n.f37352b;
    }

    public static <T> Observable.Transformer<StringStatusResponse<T>, T> a0() {
        return m.f37351b;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:17|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r1 = f84888a;
        r2 = r1.get("user_center");
        r1.put("user_center", r2);
        r4 = r2.create(r4);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> T b0(java.lang.Class<T> r4) {
        /*
            java.util.Map<java.lang.String, retrofit2.Retrofit> r0 = f84888a
            monitor-enter(r0)
            java.lang.String r1 = "user_center"
            java.lang.Object r1 = r0.get(r1)     // Catch:{ all -> 0x0064 }
            if (r1 != 0) goto L_0x0015
            retrofit2.Retrofit r1 = y()     // Catch:{ all -> 0x0064 }
            java.lang.String r2 = "user_center"
            r0.put(r2, r1)     // Catch:{ all -> 0x0064 }
            goto L_0x0042
        L_0x0015:
            java.util.Map<java.lang.String, java.lang.String> r1 = f84889b     // Catch:{ all -> 0x0064 }
            java.lang.String r2 = "user_center"
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x0064 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x0064 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0064 }
            if (r2 != 0) goto L_0x0042
            java.lang.String r2 = com.huobi.domain.DomainSwitcher.Z()     // Catch:{ all -> 0x0064 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0064 }
            if (r2 != 0) goto L_0x0042
            java.lang.String r2 = com.huobi.domain.DomainSwitcher.Z()     // Catch:{ all -> 0x0064 }
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0064 }
            if (r1 != 0) goto L_0x0042
            retrofit2.Retrofit r1 = y()     // Catch:{ all -> 0x0064 }
            java.lang.String r2 = "user_center"
            r0.put(r2, r1)     // Catch:{ all -> 0x0064 }
        L_0x0042:
            java.lang.String r1 = "user_center"
            java.lang.Object r1 = r0.get(r1)     // Catch:{ Exception -> 0x004f }
            retrofit2.Retrofit r1 = (retrofit2.Retrofit) r1     // Catch:{ Exception -> 0x004f }
            java.lang.Object r4 = r1.create(r4)     // Catch:{ Exception -> 0x004f }
            goto L_0x0062
        L_0x004f:
            java.util.Map<java.lang.String, retrofit2.Retrofit> r1 = f84888a     // Catch:{ all -> 0x0064 }
            java.lang.String r2 = "user_center"
            java.lang.Object r2 = r1.get(r2)     // Catch:{ all -> 0x0064 }
            retrofit2.Retrofit r2 = (retrofit2.Retrofit) r2     // Catch:{ all -> 0x0064 }
            java.lang.String r3 = "user_center"
            r1.put(r3, r2)     // Catch:{ all -> 0x0064 }
            java.lang.Object r4 = r2.create(r4)     // Catch:{ all -> 0x0064 }
        L_0x0062:
            monitor-exit(r0)     // Catch:{ all -> 0x0064 }
            return r4
        L_0x0064:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0064 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: tq.p.b0(java.lang.Class):java.lang.Object");
    }

    public static <T> Observable.Transformer<UcIntCodeResponse<T>, T> c0() {
        return k.f37349b;
    }

    public static <T> T p(Class<T> cls) {
        T t11;
        Map<String, Retrofit> map = f84888a;
        synchronized (map) {
            if (map.get("contract") == null) {
                map.put("contract", q());
            } else {
                String str = f84889b.get("contract");
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(DomainSwitcher.x()) && !str.equals(DomainSwitcher.x())) {
                    map.put("contract", q());
                }
            }
            try {
                t11 = map.get("contract").create(cls);
            } catch (Exception e11) {
                e11.printStackTrace();
                Retrofit q11 = q();
                f84888a.put("contract", q11);
                t11 = q11.create(cls);
            }
        }
        return t11;
    }

    public static Retrofit q() {
        String str = b.f48044h;
        if (SystemUtils.c()) {
            String x11 = DomainSwitcher.x();
            f84889b.put("contract", x11);
            if (!TextUtils.isEmpty(x11)) {
                str = str.replace("l10n-dm.huobi.cn", x11);
            }
        }
        return new Retrofit.Builder().client(HttpConfig.b()).baseUrl(str).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).addConverterFactory(lo.a.a()).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static Retrofit r() {
        return new Retrofit.Builder().client(HttpConfig.c()).baseUrl(b.f48040d).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static Retrofit s() {
        String str = b.f48041e;
        if (SystemUtils.c()) {
            String v11 = DomainSwitcher.v();
            f84889b.put("etf", v11);
            if (!TextUtils.isEmpty(v11)) {
                str = str.replace("l10n-api.huobi.cn/", v11);
            }
        }
        return new Retrofit.Builder().client(HttpConfig.d()).baseUrl(str).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).addConverterFactory(lo.a.a()).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static Retrofit t() {
        String str = b.f48040d;
        if (SystemUtils.c()) {
            String y11 = DomainSwitcher.y();
            f84889b.put("hbg", y11);
            if (!TextUtils.isEmpty(y11)) {
                str = str.replace("l10n-api.huobi.cn/", y11);
            }
        }
        return new Retrofit.Builder().client(HttpConfig.e()).baseUrl(str).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).addConverterFactory(lo.a.a()).addConverterFactory(GsonConverterFactory.create(GsonHelper.a())).build();
    }

    public static Retrofit u() {
        String M = DomainSwitcher.M();
        f84889b.put("otc", M);
        return new Retrofit.Builder().client(HttpConfig.f()).baseUrl(M).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).addConverterFactory(lo.a.a()).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static Retrofit v() {
        String str = b.f48037a;
        if (SystemUtils.c()) {
            String N = DomainSwitcher.N();
            f84889b.put("php", N);
            if (!TextUtils.isEmpty(N)) {
                str = str.replace("l10n-www.huobi.cn/", N);
            }
        }
        return new Retrofit.Builder().client(HttpConfig.g()).baseUrl(str).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static Retrofit w() {
        String str = b.f48040d;
        if (SystemUtils.c()) {
            String O = DomainSwitcher.O();
            f84889b.put("pro", O);
            if (!TextUtils.isEmpty(O)) {
                str = str.replace("l10n-api.huobi.cn/", O);
            }
        }
        d.e("HRetrofit", "这是什么奇葩玩意儿 --- createProRetrofit url：" + str);
        return new Retrofit.Builder().client(HttpConfig.h()).baseUrl(str).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).addConverterFactory(lo.a.a()).addConverterFactory(GsonConverterFactory.create(GsonHelper.a())).build();
    }

    public static Retrofit x() {
        String str = b.f48060x;
        if (SystemUtils.c()) {
            String Q = DomainSwitcher.Q();
            f84889b.put("risk", Q);
            if (!TextUtils.isEmpty(Q)) {
                str = str.replace("l10n-api.huobi.cn/", Q);
            }
        }
        return new Retrofit.Builder().client(HttpConfig.i()).baseUrl(str).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).addConverterFactory(lo.a.a()).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static Retrofit y() {
        String str = b.f48039c;
        if (SystemUtils.c()) {
            String Z = DomainSwitcher.Z();
            f84889b.put("user_center", Z);
            if (!TextUtils.isEmpty(Z)) {
                str = str.replace("l10n-uc.huobi.cn/", Z);
            }
        }
        return new Retrofit.Builder().client(HttpConfig.j()).baseUrl(str).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).build();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:10|11) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r1 = f84888a;
        r2 = r1.get("domain");
        r1.put("domain", r2);
        r4 = r2.create(r4);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0021 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> T z(java.lang.Class<T> r4) {
        /*
            java.util.Map<java.lang.String, retrofit2.Retrofit> r0 = f84888a
            monitor-enter(r0)
            java.lang.String r1 = "domain"
            java.lang.Object r1 = r0.get(r1)     // Catch:{ all -> 0x0036 }
            if (r1 != 0) goto L_0x0014
            retrofit2.Retrofit r1 = r()     // Catch:{ all -> 0x0036 }
            java.lang.String r2 = "domain"
            r0.put(r2, r1)     // Catch:{ all -> 0x0036 }
        L_0x0014:
            java.lang.String r1 = "domain"
            java.lang.Object r1 = r0.get(r1)     // Catch:{ Exception -> 0x0021 }
            retrofit2.Retrofit r1 = (retrofit2.Retrofit) r1     // Catch:{ Exception -> 0x0021 }
            java.lang.Object r4 = r1.create(r4)     // Catch:{ Exception -> 0x0021 }
            goto L_0x0034
        L_0x0021:
            java.util.Map<java.lang.String, retrofit2.Retrofit> r1 = f84888a     // Catch:{ all -> 0x0036 }
            java.lang.String r2 = "domain"
            java.lang.Object r2 = r1.get(r2)     // Catch:{ all -> 0x0036 }
            retrofit2.Retrofit r2 = (retrofit2.Retrofit) r2     // Catch:{ all -> 0x0036 }
            java.lang.String r3 = "domain"
            r1.put(r3, r2)     // Catch:{ all -> 0x0036 }
            java.lang.Object r4 = r2.create(r4)     // Catch:{ all -> 0x0036 }
        L_0x0034:
            monitor-exit(r0)     // Catch:{ all -> 0x0036 }
            return r4
        L_0x0036:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0036 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: tq.p.z(java.lang.Class):java.lang.Object");
    }
}
