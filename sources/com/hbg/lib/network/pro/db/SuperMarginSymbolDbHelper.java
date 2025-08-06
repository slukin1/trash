package com.hbg.lib.network.pro.db;

import com.hbg.lib.network.pro.core.bean.SuperMarginSymbol;
import com.hbg.lib.network.pro.db.SuperMarginSymbolDao;
import com.hbg.lib.network.retrofit.util.RetrofitLogger;
import java.util.Collections;
import java.util.List;
import org.greenrobot.greendao.query.WhereCondition;
import z8.a;

public class SuperMarginSymbolDbHelper extends ProDbHelper {
    public static void g() {
        ProDbHelper.b(SuperMarginSymbol.class);
    }

    public static List<SuperMarginSymbol> h(String str) {
        a aVar = ProDbHelper.f70621a;
        if (aVar != null) {
            try {
                return aVar.c().queryBuilder().where(SuperMarginSymbolDao.Properties.Key.eq(str), new WhereCondition[0]).list();
            } catch (Exception e11) {
                e11.printStackTrace();
                RetrofitLogger.c("HbgDbHelper-->loadAll-->", e11);
            }
        }
        return Collections.emptyList();
    }
}
