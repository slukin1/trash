package be;

import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.huobi.coupon.bean.CouponReturn;
import com.huobi.login.usercenter.data.source.bean.KvStore;
import java.util.ArrayList;
import java.util.List;

public class j {

    /* renamed from: a  reason: collision with root package name */
    public List<i> f23475a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences f23476b;

    /* renamed from: c  reason: collision with root package name */
    public Gson f23477c;

    /* renamed from: d  reason: collision with root package name */
    public String f23478d;

    public class a extends TypeToken<List<i>> {
        public a() {
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static j f23480a = new j((a) null);
    }

    public /* synthetic */ j(a aVar) {
        this();
    }

    public static j c() {
        return b.f23480a;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:7|8|9|10|11|(2:13|(1:15)(4:16|(1:18)(2:19|(1:21))|23|(1:25)))|22|23|(0)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0028 */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0080  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<be.i> a() {
        /*
            r6 = this;
            java.util.List<be.i> r0 = r6.f23475a
            if (r0 != 0) goto L_0x008f
            java.lang.Class<be.j> r0 = be.j.class
            monitor-enter(r0)
            java.util.List<be.i> r1 = r6.f23475a     // Catch:{ all -> 0x008c }
            if (r1 != 0) goto L_0x008a
            android.content.SharedPreferences r1 = r6.f23476b     // Catch:{ all -> 0x008c }
            java.lang.String r2 = r6.f23478d     // Catch:{ all -> 0x008c }
            java.lang.String r3 = "{}"
            java.lang.String r1 = r1.getString(r2, r3)     // Catch:{ all -> 0x008c }
            com.google.gson.Gson r2 = r6.f23477c     // Catch:{ Exception -> 0x0028 }
            be.j$a r3 = new be.j$a     // Catch:{ Exception -> 0x0028 }
            r3.<init>()     // Catch:{ Exception -> 0x0028 }
            java.lang.reflect.Type r3 = r3.getType()     // Catch:{ Exception -> 0x0028 }
            java.lang.Object r1 = r2.fromJson((java.lang.String) r1, (java.lang.reflect.Type) r3)     // Catch:{ Exception -> 0x0028 }
            java.util.List r1 = (java.util.List) r1     // Catch:{ Exception -> 0x0028 }
            r6.f23475a = r1     // Catch:{ Exception -> 0x0028 }
        L_0x0028:
            java.util.List<be.i> r1 = r6.f23475a     // Catch:{ all -> 0x008c }
            if (r1 == 0) goto L_0x0070
            int r1 = r1.size()     // Catch:{ all -> 0x008c }
            if (r1 != 0) goto L_0x0033
            goto L_0x0070
        L_0x0033:
            r1 = 20
            java.util.List<be.i> r2 = r6.f23475a     // Catch:{ all -> 0x008c }
            int r2 = r2.size()     // Catch:{ all -> 0x008c }
            if (r1 != r2) goto L_0x0060
            java.util.List<be.i> r1 = r6.f23475a     // Catch:{ all -> 0x008c }
            be.i r2 = new be.i     // Catch:{ all -> 0x008c }
            java.lang.String r3 = "Ma"
            java.lang.String r4 = ""
            r5 = 0
            r2.<init>(r3, r4, r5)     // Catch:{ all -> 0x008c }
            r1.add(r2)     // Catch:{ all -> 0x008c }
            java.util.List<be.i> r1 = r6.f23475a     // Catch:{ all -> 0x008c }
            be.i r2 = new be.i     // Catch:{ all -> 0x008c }
            java.lang.String r3 = "Ma"
            java.lang.String r4 = ""
            r2.<init>(r3, r4, r5)     // Catch:{ all -> 0x008c }
            r1.add(r2)     // Catch:{ all -> 0x008c }
            java.util.List<be.i> r1 = r6.f23475a     // Catch:{ all -> 0x008c }
            r6.d(r1)     // Catch:{ all -> 0x008c }
            goto L_0x0076
        L_0x0060:
            r1 = 22
            java.util.List<be.i> r2 = r6.f23475a     // Catch:{ all -> 0x008c }
            int r2 = r2.size()     // Catch:{ all -> 0x008c }
            if (r1 != r2) goto L_0x0076
            java.util.List<be.i> r1 = r6.f23475a     // Catch:{ all -> 0x008c }
            r6.d(r1)     // Catch:{ all -> 0x008c }
            goto L_0x0076
        L_0x0070:
            java.util.List r1 = r6.b()     // Catch:{ all -> 0x008c }
            r6.f23475a = r1     // Catch:{ all -> 0x008c }
        L_0x0076:
            r1 = 30
            java.util.List<be.i> r2 = r6.f23475a     // Catch:{ all -> 0x008c }
            int r2 = r2.size()     // Catch:{ all -> 0x008c }
            if (r1 == r2) goto L_0x008a
            r1 = 0
            r6.e(r1)     // Catch:{ all -> 0x008c }
            java.util.List r1 = r6.b()     // Catch:{ all -> 0x008c }
            r6.f23475a = r1     // Catch:{ all -> 0x008c }
        L_0x008a:
            monitor-exit(r0)     // Catch:{ all -> 0x008c }
            goto L_0x008f
        L_0x008c:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x008c }
            throw r1
        L_0x008f:
            java.util.List<be.i> r0 = r6.f23475a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: be.j.a():java.util.List");
    }

    public final List<i> b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new i("Ma", BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_OTC, true));
        arrayList.add(new i("Ma", CouponReturn.TYPE_EXPERIENCE, true));
        arrayList.add(new i("Ma", "30", true));
        arrayList.add(new i("Ma", "", false));
        arrayList.add(new i("Ma", "", false));
        arrayList.add(new i("Ma", "", false));
        arrayList.add(new i(KvStore.N, "20", true));
        arrayList.add(new i("P", "2", true));
        arrayList.add(new i("S", "12", true));
        arrayList.add(new i("L", "26", true));
        arrayList.add(new i("M", "9", true));
        arrayList.add(new i(KvStore.N, "14", true));
        arrayList.add(new i("M1", "1", true));
        arrayList.add(new i("M2", "3", true));
        arrayList.add(new i("RSI1", "14", true));
        arrayList.add(new i("RSI2", "", false));
        arrayList.add(new i("RSI3", "", false));
        arrayList.add(new i("WR1", "14", true));
        arrayList.add(new i("WR2", "", false));
        arrayList.add(new i("WR3", "", false));
        arrayList.add(new i("Ma", "", false));
        arrayList.add(new i("Ma", "", false));
        d(arrayList);
        return arrayList;
    }

    public final void d(List<i> list) {
        list.add(new i("EMa", BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_OTC, true));
        list.add(new i("EMa", CouponReturn.TYPE_EXPERIENCE, true));
        list.add(new i("EMa", "30", true));
        list.add(new i("EMa", "", false));
        list.add(new i("EMa", "", false));
        list.add(new i("EMa", "", false));
        list.add(new i("EMa", "", false));
        list.add(new i("EMa", "", false));
    }

    public void e(List<i> list) {
        synchronized (j.class) {
            this.f23475a = list;
            SharedPreferences.Editor edit = this.f23476b.edit();
            if (list == null) {
                edit.putString(this.f23478d, "{}");
            } else {
                edit.putString(this.f23478d, this.f23477c.toJson((Object) list));
            }
            edit.apply();
        }
    }

    public j() {
        this.f23478d = "index_setting_data";
        this.f23476b = BaseApplication.b().getSharedPreferences("index_setting_data", 0);
        this.f23477c = new Gson();
    }
}
