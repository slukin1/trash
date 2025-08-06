package com.hbg.lib.network.pro.db;

import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.pro.db.SymbolBeanDao;
import com.hbg.lib.network.retrofit.util.RetrofitLogger;
import java.util.Collections;
import java.util.List;
import org.greenrobot.greendao.query.WhereCondition;
import z8.a;

public class ProSymbolDbHelper extends ProDbHelper {
    public static List<SymbolBean> g(String str) {
        a aVar = ProDbHelper.f70621a;
        if (aVar != null) {
            try {
                return aVar.d().queryBuilder().where(SymbolBeanDao.Properties.Key.eq(str), new WhereCondition[0]).list();
            } catch (Exception e11) {
                e11.printStackTrace();
                RetrofitLogger.c("HbgDbHelper-->loadAll-->", e11);
            }
        }
        return Collections.emptyList();
    }
}
