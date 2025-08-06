package com.huobi.dynamiclangs.db;

import android.content.Context;
import com.hbg.lib.network.retrofit.util.RetrofitLogger;
import com.huobi.dynamiclangs.data.DynamicStringsBean;
import com.huobi.dynamiclangs.db.DynamicStringsBeanDao;
import com.huobi.dynamiclangs.db.a;
import java.util.List;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;
import pj.a;

public class DynamicStringsDbHelper {

    /* renamed from: a  reason: collision with root package name */
    public static a f43871a;

    public static void a(Context context) {
        f43871a = new a(new a.C0568a(context, "dynamic_langs.db").getWritableDatabase()).newSession();
        QueryBuilder.LOG_SQL = true;
        QueryBuilder.LOG_VALUES = true;
    }

    public static List<DynamicStringsBean> b() {
        QueryBuilder<DynamicStringsBean> c11 = c(DynamicStringsBean.class);
        if (c11 == null) {
            return null;
        }
        c11.where(DynamicStringsBeanDao.Properties.Source.eq(1), new WhereCondition[0]);
        return c11.list();
    }

    public static <T> QueryBuilder<T> c(Class<T> cls) {
        pj.a aVar = f43871a;
        if (aVar == null) {
            return null;
        }
        try {
            return aVar.queryBuilder(cls);
        } catch (Exception e11) {
            e11.printStackTrace();
            RetrofitLogger.c("DynamicLangsDbHelper-->queryRaw-->", e11);
            return null;
        }
    }
}
