package com.xiaomi.push;

import android.content.Context;
import android.database.Cursor;
import com.xiaomi.push.bx;
import java.util.ArrayList;
import java.util.List;

public class bs extends bx.b<Long> {

    /* renamed from: a  reason: collision with root package name */
    private long f51459a = 0;

    /* renamed from: a  reason: collision with other field name */
    private String f2572a;

    public bs(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i11, String str6) {
        super(str, list, str2, strArr, str3, str4, str5, i11);
        this.f2572a = str6;
    }

    public static bs a(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("count(*)");
        return new bs(str, arrayList, (String) null, (String[]) null, (String) null, (String) null, (String) null, 0, "job to get count of all message");
    }

    public Long a(Context context, Cursor cursor) {
        return Long.valueOf(cursor.getLong(0));
    }

    public void a(Context context, List<Long> list) {
        if (context != null && list != null && list.size() > 0) {
            this.f51459a = list.get(0).longValue();
        }
    }

    public Object a() {
        return Long.valueOf(this.f51459a);
    }
}
