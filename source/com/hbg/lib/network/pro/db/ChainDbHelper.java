package com.hbg.lib.network.pro.db;

import com.hbg.lib.network.pro.core.bean.ChainInfo;
import com.hbg.lib.network.pro.db.ChainInfoDao;
import com.hbg.lib.network.retrofit.util.RetrofitLogger;
import java.util.List;
import org.greenrobot.greendao.query.WhereCondition;

public class ChainDbHelper extends ProDbHelper {
    public static void g() {
        ProDbHelper.b(ChainInfo.class);
    }

    public static void h(String str) {
        try {
            ChainInfoDao a11 = ProDbHelper.f70621a.a();
            List list = a11.queryBuilder().where(ChainInfoDao.Properties.Currency.eq(str), new WhereCondition[0]).list();
            a11.deleteInTx(list);
            RetrofitLogger.a("ChainDbHelper-->chain-->deleteAllChainsByCurrency-->删除了 " + list.size() + " 个 " + list);
        } catch (Exception e11) {
            e11.printStackTrace();
            RetrofitLogger.c("ChainDbHelper-->chain-->deleteAllChainsByCurrency-->", e11);
        }
    }

    public static List<ChainInfo> i() {
        return ProDbHelper.f(ChainInfo.class);
    }

    public static ChainInfo j(String str) {
        try {
            return (ChainInfo) ProDbHelper.f70621a.load(ChainInfo.class, str);
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }
}
