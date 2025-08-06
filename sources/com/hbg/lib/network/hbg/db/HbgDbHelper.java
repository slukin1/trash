package com.hbg.lib.network.hbg.db;

import android.content.Context;
import com.hbg.lib.network.hbg.db.a;
import com.hbg.lib.network.retrofit.util.RetrofitLogger;
import y7.a;

public class HbgDbHelper {

    /* renamed from: a  reason: collision with root package name */
    public static a f70280a;

    public static void a(Context context) {
        f70280a = new a(new a.C0766a(context, "hbg_network_db.db").getWritableDatabase()).newSession();
    }

    public static <T> long b(T t11) {
        y7.a aVar = f70280a;
        if (aVar == null) {
            return 0;
        }
        try {
            return aVar.insertOrReplace(t11);
        } catch (Exception e11) {
            e11.printStackTrace();
            RetrofitLogger.c("HbgDbHelper-->insert-->", e11);
            return 0;
        }
    }
}
