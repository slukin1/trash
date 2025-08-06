package qk;

import android.app.Activity;
import android.text.TextUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.controller.FutureContractInfoController;
import java.util.Iterator;
import java.util.List;
import rx.Observable;
import u6.g;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static FutureContractInfo f47760a;

    public static boolean c(FutureContractInfo futureContractInfo) {
        return futureContractInfo != null && !TextUtils.isEmpty(futureContractInfo.getSymbol()) && !TextUtils.isEmpty(futureContractInfo.getContractCode()) && !TextUtils.isEmpty(futureContractInfo.getContractType()) && !TextUtils.isEmpty(futureContractInfo.getDeliveryDate());
    }

    public static Observable<FutureContractInfo> d(boolean z11, String str) {
        if (TextUtils.isEmpty(str)) {
            return Observable.empty();
        }
        return FutureContractInfoController.n().s(z11).flatMap(new j(str));
    }

    public static FutureContractInfo e(List<FutureContractInfo> list) {
        for (FutureContractInfo next : list) {
            if (next != null && next.getContractShortType().equals("BTC-USDT")) {
                return next;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.hbg.lib.data.future.bean.FutureContractInfo f(java.util.List<com.hbg.lib.data.future.bean.FutureContractInfo> r7) {
        /*
            com.hbg.lib.data.future.bean.FutureContractInfo r0 = f47760a
            boolean r0 = c(r0)
            r1 = 0
            if (r0 == 0) goto L_0x000c
            com.hbg.lib.data.future.bean.FutureContractInfo r0 = f47760a
            goto L_0x000d
        L_0x000c:
            r0 = r1
        L_0x000d:
            r2 = 0
            if (r7 == 0) goto L_0x0018
            boolean r3 = r7.isEmpty()
            if (r3 != 0) goto L_0x0018
            r3 = 1
            goto L_0x0019
        L_0x0018:
            r3 = r2
        L_0x0019:
            if (r3 == 0) goto L_0x00a0
            if (r0 == 0) goto L_0x0055
            java.util.Iterator r3 = r7.iterator()
        L_0x0021:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0045
            java.lang.Object r4 = r3.next()
            com.hbg.lib.data.future.bean.FutureContractInfo r4 = (com.hbg.lib.data.future.bean.FutureContractInfo) r4
            if (r4 != 0) goto L_0x0030
            goto L_0x0021
        L_0x0030:
            java.lang.String r5 = r0.getContractCode()
            if (r5 == 0) goto L_0x0021
            java.lang.String r5 = r4.getContractCode()
            java.lang.String r6 = r0.getContractCode()
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x0021
            r1 = r4
        L_0x0045:
            if (r1 != 0) goto L_0x0090
            com.hbg.lib.data.future.bean.FutureContractInfo r0 = e(r7)
            if (r0 == 0) goto L_0x004e
            goto L_0x0070
        L_0x004e:
            java.lang.Object r0 = r7.get(r2)
            com.hbg.lib.data.future.bean.FutureContractInfo r0 = (com.hbg.lib.data.future.bean.FutureContractInfo) r0
            goto L_0x0070
        L_0x0055:
            java.lang.String r0 = "user_config"
            java.lang.String r3 = "config_linear_swap_currency_info"
            java.lang.String r0 = com.hbg.lib.core.util.ConfigPreferences.d(r0, r3)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto L_0x0072
            com.hbg.lib.data.future.bean.FutureContractInfo r0 = e(r7)
            if (r0 == 0) goto L_0x006a
            goto L_0x0070
        L_0x006a:
            java.lang.Object r0 = r7.get(r2)
            com.hbg.lib.data.future.bean.FutureContractInfo r0 = (com.hbg.lib.data.future.bean.FutureContractInfo) r0
        L_0x0070:
            r1 = r0
            goto L_0x0090
        L_0x0072:
            java.util.Iterator r3 = r7.iterator()
        L_0x0076:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0090
            java.lang.Object r4 = r3.next()
            com.hbg.lib.data.future.bean.FutureContractInfo r4 = (com.hbg.lib.data.future.bean.FutureContractInfo) r4
            if (r4 != 0) goto L_0x0085
            goto L_0x0076
        L_0x0085:
            java.lang.String r5 = r4.getContractCode()
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0076
            r1 = r4
        L_0x0090:
            if (r1 != 0) goto L_0x00a0
            com.hbg.lib.data.future.bean.FutureContractInfo r1 = e(r7)
            if (r1 == 0) goto L_0x0099
            goto L_0x00a0
        L_0x0099:
            java.lang.Object r7 = r7.get(r2)
            r1 = r7
            com.hbg.lib.data.future.bean.FutureContractInfo r1 = (com.hbg.lib.data.future.bean.FutureContractInfo) r1
        L_0x00a0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: qk.k.f(java.util.List):com.hbg.lib.data.future.bean.FutureContractInfo");
    }

    public static void g(Activity activity, String str) {
        if (activity != null && !TextUtils.isEmpty(str)) {
            g gVar = null;
            if (activity instanceof g) {
                gVar = (g) activity;
            }
            d(true, str).compose(RxJavaHelper.t(gVar)).subscribe(EasySubscriber.create(new i(activity)));
        }
    }

    public static /* synthetic */ Observable h(String str, List list) {
        if (list == null || list.isEmpty()) {
            return Observable.empty();
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            FutureContractInfo futureContractInfo = (FutureContractInfo) it2.next();
            if (str.equalsIgnoreCase(futureContractInfo.getSymbol()) && "quarter".equals(futureContractInfo.getContractType())) {
                return Observable.just(futureContractInfo);
            }
        }
        Iterator it3 = list.iterator();
        while (it3.hasNext()) {
            FutureContractInfo futureContractInfo2 = (FutureContractInfo) it3.next();
            if (str.equalsIgnoreCase(futureContractInfo2.getSymbol())) {
                return Observable.just(futureContractInfo2);
            }
        }
        return Observable.just((FutureContractInfo) list.get(0));
    }

    public static void j(FutureContractInfo futureContractInfo) {
        f47760a = futureContractInfo;
        if (futureContractInfo != null) {
            ConfigPreferences.m("user_config", "config_linear_swap_currency_info", futureContractInfo.getContractCode());
        }
    }
}
