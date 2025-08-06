package com.hbg.lib.network.pro.db;

import android.content.Context;
import com.hbg.lib.network.pro.db.a;
import com.hbg.lib.network.retrofit.util.RetrofitLogger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import z8.a;
import z8.b;

public class ProDbHelper {

    /* renamed from: a  reason: collision with root package name */
    public static a f70621a;

    public static <T> void b(Class<T> cls) {
        a aVar = f70621a;
        if (aVar != null) {
            try {
                aVar.deleteAll(cls);
            } catch (Exception e11) {
                e11.printStackTrace();
                RetrofitLogger.c("HbgDbHelper-->chain-->deleteAll-->", e11);
            }
        }
    }

    public static void c(Context context) {
        f70621a = new a(new a.C0773a(context, "network_db.db").getWritableDatabase()).newSession();
    }

    public static <T> void d(List<T> list) {
        if (f70621a != null && list != null && !list.isEmpty()) {
            try {
                f70621a.runInTx(new b(new ArrayList(list)));
            } catch (Exception e11) {
                e11.printStackTrace();
                RetrofitLogger.c("HbgDbHelper-->insertAll-->", e11);
            }
        }
    }

    public static /* synthetic */ void e(List list) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            Object obj = list.get(i11);
            if (obj != null) {
                f70621a.insertOrReplace(obj);
            }
        }
    }

    public static <T> List<T> f(Class<T> cls) {
        z8.a aVar = f70621a;
        if (aVar != null) {
            try {
                return aVar.loadAll(cls);
            } catch (Exception e11) {
                e11.printStackTrace();
                RetrofitLogger.c("HbgDbHelper-->loadAll-->", e11);
            }
        }
        return Collections.emptyList();
    }
}
