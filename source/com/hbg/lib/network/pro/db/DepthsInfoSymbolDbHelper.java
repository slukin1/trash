package com.hbg.lib.network.pro.db;

import com.hbg.lib.network.pro.core.bean.DepthsInfoSymbol;
import com.hbg.lib.network.pro.db.DepthsInfoSymbolDao;
import com.hbg.lib.network.retrofit.util.RetrofitLogger;
import java.util.Collections;
import java.util.List;
import org.greenrobot.greendao.query.WhereCondition;
import z8.a;

public class DepthsInfoSymbolDbHelper extends ProDbHelper {
    public static List<DepthsInfoSymbol> g(String str) {
        a aVar = ProDbHelper.f70621a;
        if (aVar != null) {
            try {
                return aVar.b().queryBuilder().where(DepthsInfoSymbolDao.Properties.Key.eq(str), new WhereCondition[0]).list();
            } catch (Exception e11) {
                e11.printStackTrace();
                RetrofitLogger.c("DepthsInfoSymbolDbHelper-->loadAll-->", e11);
            }
        }
        return Collections.emptyList();
    }
}
