package fr;

import com.alibaba.android.arouter.utils.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.util.PhoneUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huobi.search.bean.HotSearchInfo;
import com.huobi.search.service.HotSearchService;
import i6.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tq.p;
import u6.g;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static HotSearchInfo f84122a;

    /* renamed from: b  reason: collision with root package name */
    public static List<String> f84123b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public static List<String> f84124c = new ArrayList();

    /* renamed from: fr.a$a  reason: collision with other inner class name */
    public class C0862a extends BaseSubscriber<HotSearchInfo> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f84125b;

        public C0862a(b bVar) {
            this.f84125b = bVar;
        }

        /* renamed from: a */
        public void onNext(HotSearchInfo hotSearchInfo) {
            super.onNext(hotSearchInfo);
            a.f84123b.clear();
            a.f84124c.clear();
            HotSearchInfo unused = a.f84122a = hotSearchInfo;
            if (hotSearchInfo != null) {
                if (!com.hbg.module.libkt.base.ext.b.w(hotSearchInfo.currencyList)) {
                    a.f84123b.addAll(hotSearchInfo.currencyList);
                }
                if (!com.hbg.module.libkt.base.ext.b.w(hotSearchInfo.hotWords)) {
                    a.f84124c.addAll(hotSearchInfo.hotWords);
                }
            }
            d.c("hotWord", "loadHotSearchData:" + hotSearchInfo.hotWords);
            b bVar = this.f84125b;
            if (bVar != null) {
                bVar.a(hotSearchInfo);
            }
        }
    }

    public interface b {
        void a(HotSearchInfo hotSearchInfo);
    }

    public static void d(String str) {
        String str2;
        if (!TextUtils.c(str)) {
            try {
                str2 = StringUtils.i(str);
            } catch (Exception e11) {
                e11.printStackTrace();
                str2 = null;
            }
            if (!TextUtils.c(str2)) {
                HashMap hashMap = new HashMap();
                hashMap.put(FirebaseAnalytics.Param.CURRENCY, str2);
                hashMap.put(ZendeskIdentityStorage.UUID_KEY, PhoneUtils.r());
                ((HotSearchService) p.C(HotSearchService.class)).collectHotSearch(hashMap).compose(RxJavaHelper.t((g) null)).compose(p.D()).subscribe(new BaseSubscriber());
            }
        }
    }

    public static List<String> e() {
        return f84123b;
    }

    public static void f() {
        g((b) null);
    }

    public static void g(b bVar) {
        ((HotSearchService) p.C(HotSearchService.class)).getHotSearchList().compose(RxJavaHelper.t((g) null)).compose(p.D()).subscribe(new C0862a(bVar));
    }
}
