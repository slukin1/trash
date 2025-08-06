package com.huobi.main.helper;

import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import java.util.HashMap;
import java.util.List;
import u6.g;

public class k {

    public class a extends EasySubscriber<List<String>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f77735b;

        public a(d dVar) {
            this.f77735b = dVar;
        }

        public void onNext(List<String> list) {
            super.onNext(list);
            this.f77735b.b(list);
        }
    }

    public class b extends EasySubscriber<Object> {
        public b() {
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            th2.printStackTrace();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            aPIStatusErrorException.printStackTrace();
        }

        public void onNext(Object obj) {
            super.onNext(obj);
        }
    }

    public class c extends EasySubscriber<Boolean> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f77738b;

        public c(d dVar) {
            this.f77738b = dVar;
        }

        /* renamed from: a */
        public void onNext(Boolean bool) {
            super.onNext(bool);
            this.f77738b.onSuccess();
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            th2.printStackTrace();
            this.f77738b.a();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            aPIStatusErrorException.printStackTrace();
            this.f77738b.a();
        }
    }

    public interface d {
        void a();

        void b(List<String> list);

        void onSuccess();
    }

    public static k b() {
        return new k();
    }

    public void a(String str, d dVar) {
        x8.a.a().clearSearchHistoryData(str).b().compose(RxJavaHelper.t((g) null)).subscribe(new c(dVar));
    }

    public void c(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", str);
        hashMap.put("symbol", str2);
        x8.a.a().insertSearchHistoryData(hashMap).b().compose(RxJavaHelper.t((g) null)).subscribe(new b());
    }

    public void d(String str, d dVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", str);
        hashMap.put("size", 20);
        x8.a.a().getSearchHistoryData(hashMap).b().compose(RxJavaHelper.t((g) null)).subscribe(new a(dVar));
    }
}
