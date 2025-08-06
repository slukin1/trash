package com.hbg.component.kline.db;

import android.content.Context;
import com.hbg.component.kline.db.KlineDrawLineBeanDao;
import com.hbg.component.kline.db.a;
import com.hbg.component.kline.draw.bean.KlineDrawLineBean;
import com.hbg.lib.network.retrofit.util.RetrofitLogger;
import i6.d;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.greendao.query.QueryBuilder;
import p5.a;

public class KlineDbHelper {

    /* renamed from: a  reason: collision with root package name */
    public static a f67189a;

    public static <T> void a(T t11) {
        a aVar = f67189a;
        if (aVar != null) {
            try {
                aVar.delete(t11);
            } catch (Exception e11) {
                e11.printStackTrace();
                RetrofitLogger.c("KlineDbHelper-->delete-->", e11);
            }
        }
    }

    public static void b(String str, String str2) {
        a aVar = f67189a;
        if (aVar != null) {
            try {
                aVar.queryBuilder(KlineDrawLineBean.class).where(KlineDrawLineBeanDao.Properties.SymbolId.eq(str), KlineDrawLineBeanDao.Properties.Period.eq(str2)).buildDelete().executeDeleteWithoutDetachingEntities();
            } catch (Exception e11) {
                e11.printStackTrace();
                RetrofitLogger.c("KlineDbHelper-->deleteAllLines-->", e11);
            }
        }
    }

    public static void c(Context context) {
        f67189a = new a(new a.C0734a(context, "draw_line_db.db").getWritableDatabase()).newSession();
        QueryBuilder.LOG_SQL = true;
        QueryBuilder.LOG_VALUES = true;
    }

    public static <T> long d(T t11) {
        p5.a aVar = f67189a;
        if (aVar == null) {
            return 0;
        }
        try {
            return aVar.insertOrReplace(t11);
        } catch (Exception e11) {
            e11.printStackTrace();
            RetrofitLogger.c("KlineDbHelper-->insert-->", e11);
            return 0;
        }
    }

    public static List<KlineDrawLineBean> e(String str, String str2, int i11) {
        QueryBuilder<KlineDrawLineBean> f11 = f(KlineDrawLineBean.class);
        if (f11 == null) {
            return new ArrayList();
        }
        f11.where(KlineDrawLineBeanDao.Properties.SymbolId.eq(str), KlineDrawLineBeanDao.Properties.Period.eq(str2));
        f11.orderDesc(KlineDrawLineBeanDao.Properties.UpdateTimestamp);
        f11.limit(i11);
        return f11.list();
    }

    public static <T> QueryBuilder<T> f(Class<T> cls) {
        p5.a aVar = f67189a;
        if (aVar == null) {
            return null;
        }
        try {
            return aVar.queryBuilder(cls);
        } catch (Exception e11) {
            e11.printStackTrace();
            RetrofitLogger.c("KlineDbHelper-->queryRaw-->", e11);
            return null;
        }
    }

    public static void g(KlineDrawLineBean klineDrawLineBean) {
        long d11 = d(klineDrawLineBean);
        String simpleName = KlineDbHelper.class.getSimpleName();
        d.c(simpleName, "klinedatabase----line = " + klineDrawLineBean.toString() + "; id = " + d11);
        klineDrawLineBean.setId(Long.valueOf(d11));
    }

    public static <T> void h(T t11) {
        p5.a aVar = f67189a;
        if (aVar != null) {
            try {
                aVar.update(t11);
            } catch (Exception e11) {
                e11.printStackTrace();
                RetrofitLogger.c("KlineDbHelper-->insert-->", e11);
            }
        }
    }
}
