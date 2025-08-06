package com.hbg.lib.network.hbg.db;

import com.hbg.lib.network.hbg.db.GridSymbolsConfigDao;
import com.hbg.lib.network.hbg.grid.bean.GridSymbolsConfig;
import com.hbg.lib.network.retrofit.util.RetrofitLogger;
import java.util.List;
import org.greenrobot.greendao.query.WhereCondition;

public class GridSymbolDbHelper extends HbgDbHelper {
    public static GridSymbolsConfig c(String str) {
        if (HbgDbHelper.f70280a != null) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                List list = HbgDbHelper.f70280a.a().queryBuilder().where(GridSymbolsConfigDao.Properties.Key.eq(str), new WhereCondition[0]).list();
                if (list == null || list.isEmpty()) {
                    return null;
                }
                RetrofitLogger.a("GridSymbolDbHelper-->loadAll--> key: " + str + " 本地有: " + list.size() + " 个 耗时:" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                return (GridSymbolsConfig) list.get(0);
            } catch (Exception e11) {
                e11.printStackTrace();
                RetrofitLogger.c("GridSymbolDbHelper-->loadAll-->", e11);
            }
        }
        return null;
    }
}
