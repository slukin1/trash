package wu;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import com.huobi.woodpecker.WoodPeckerSDK;
import com.huobi.woodpecker.database.bean.RequestInfo;
import com.huobi.woodpecker.model.base.BaseRecord;
import com.huobi.woodpecker.model.base.IRecord;
import com.huobi.woodpecker.utils.ContextUtil;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
import kv.e;
import vu.g;

public class c {

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f23435b;

    /* renamed from: a  reason: collision with root package name */
    public a f23436a;

    public c(Context context) {
        j(context);
    }

    public static void b(BaseRecord<? extends IRecord> baseRecord) {
        if (baseRecord == null || !baseRecord.isActionEnabled()) {
            e.c("WPDBM", "asyncSave(threwrec) called with: request = [" + baseRecord + "]");
            return;
        }
        g.d().i(new b(baseRecord));
    }

    public static c e() {
        if (f23435b == null) {
            Context g11 = ContextUtil.g();
            synchronized (c.class) {
                if (f23435b == null) {
                    f23435b = new c(g11);
                }
            }
        }
        return f23435b;
    }

    public static long h() {
        long nanoTime = System.nanoTime();
        return (System.currentTimeMillis() * 1000) + ((nanoTime - ((nanoTime / 1000000) * 1000000)) / 1000);
    }

    public static void k(BaseRecord<? extends IRecord> baseRecord) {
        if (baseRecord == null || !baseRecord.isActionEnabled()) {
            e.c("WPDBM", "save(threwrec) called with: request = [" + baseRecord + "]");
            return;
        }
        baseRecord.setDate(h());
        String jsonString = baseRecord.toJsonString();
        e.c("WPDBM", "save " + baseRecord.getClass().getSimpleName() + ":" + jsonString);
        ContentValues contentValues = new ContentValues();
        contentValues.put("request_date", Long.valueOf(baseRecord.getDate()));
        contentValues.put("wood_action", baseRecord.getAction().getAction());
        contentValues.put("wood_action_priority", Integer.valueOf(baseRecord.getAction().getPriority()));
        contentValues.put("request_info", jsonString);
        e().f23436a.b(contentValues);
    }

    public boolean c(List<Long> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        StringBuilder sb2 = new StringBuilder("_id in (");
        for (Long longValue : list) {
            sb2.append(longValue.longValue());
            sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        sb2.deleteCharAt(sb2.length() - 1);
        sb2.append(")");
        String sb3 = sb2.toString();
        boolean a11 = this.f23436a.a(sb3, (String[]) null);
        e.c("WPDBM", "clearBy(size:" + list.size() + ")=" + a11 + " => whereClause=" + sb3);
        return a11;
    }

    public void d() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("_id not in(");
        sb2.append("SELECT _id FROM request_data_table order by wood_action_priority asc, request_date desc limit 5000");
        sb2.append(")");
        e.o("WPDBM", "deleteUnnecessaryData 初始化删除sql: " + sb2.toString());
        this.f23436a.a(sb2.toString(), (String[]) null);
    }

    public List<RequestInfo> f() {
        return g((String) null, -1, 500);
    }

    /* JADX WARNING: type inference failed for: r10v6, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.huobi.woodpecker.database.bean.RequestInfo> g(java.lang.String r10, int r11, int r12) {
        /*
            r9 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            boolean r2 = android.text.TextUtils.isEmpty(r10)
            if (r2 != 0) goto L_0x0018
            java.lang.String r2 = "wood_action=?"
            r0.append(r2)
            r1.add(r10)
        L_0x0018:
            if (r11 < 0) goto L_0x0046
            com.huobi.woodpecker.core.ActionType r10 = com.huobi.woodpecker.core.ActionType.DEFAULT
            int r10 = r10.getPriority()
            if (r11 >= r10) goto L_0x0046
            int r10 = r0.length()
            if (r10 <= 0) goto L_0x002d
            java.lang.String r10 = " and "
            r0.append(r10)
        L_0x002d:
            java.lang.String r10 = "wood_action_priority <= ?"
            r0.append(r10)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r11)
            java.lang.String r11 = ""
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            r1.add(r10)
        L_0x0046:
            if (r12 > 0) goto L_0x004a
            r12 = 500(0x1f4, float:7.0E-43)
        L_0x004a:
            int r10 = r0.length()
            r11 = 0
            if (r10 <= 0) goto L_0x0057
            java.lang.String r10 = r0.toString()
            r3 = r10
            goto L_0x0058
        L_0x0057:
            r3 = r11
        L_0x0058:
            boolean r10 = r1.isEmpty()
            if (r10 == 0) goto L_0x005f
            goto L_0x0069
        L_0x005f:
            r10 = 0
            java.lang.String[] r10 = new java.lang.String[r10]
            java.lang.Object[] r10 = r1.toArray(r10)
            r11 = r10
            java.lang.String[] r11 = (java.lang.String[]) r11
        L_0x0069:
            r4 = r11
            java.lang.String r8 = java.lang.String.valueOf(r12)
            wu.a r2 = r9.f23436a
            r5 = 0
            r6 = 0
            java.lang.String r7 = "wood_action_priority asc, request_date desc"
            java.util.List r10 = r2.e(r3, r4, r5, r6, r7, r8)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "getLatestList resultList: "
            r11.append(r12)
            if (r10 == 0) goto L_0x009a
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r0 = "size="
            r12.append(r0)
            int r0 = r10.size()
            r12.append(r0)
            java.lang.String r12 = r12.toString()
            goto L_0x009c
        L_0x009a:
            java.lang.String r12 = "not found any records!!!"
        L_0x009c:
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            java.lang.String r12 = "WPDBM"
            kv.e.c(r12, r11)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: wu.c.g(java.lang.String, int, int):java.util.List");
    }

    public final void j(Context context) {
        if (context == null) {
            this.f23436a = new a(WoodPeckerSDK.f().e());
        } else if (context instanceof Application) {
            this.f23436a = new a(context);
        } else {
            this.f23436a = new a(context.getApplicationContext());
        }
    }
}
