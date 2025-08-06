package com.huobi.login.utils;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hbg.lib.core.util.ConfigPreferences;
import com.huobi.login.bean.AccountHistoryBean;
import java.util.ArrayList;
import java.util.List;

public final class HistoryAccountDataManager {

    /* renamed from: a  reason: collision with root package name */
    public static HistoryAccountDataManager f75713a;

    public class a extends TypeToken<List<AccountHistoryBean>> {
        public a() {
        }
    }

    public static HistoryAccountDataManager a() {
        if (f75713a == null) {
            f75713a = new HistoryAccountDataManager();
        }
        return f75713a;
    }

    public boolean b() {
        List<AccountHistoryBean> g11 = g();
        if (g11 == null || g11.size() <= 1) {
            return false;
        }
        return true;
    }

    public boolean c() {
        List<AccountHistoryBean> h11 = h();
        if (h11 == null || h11.size() <= 1) {
            return false;
        }
        return true;
    }

    public final String d(List<AccountHistoryBean> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        try {
            return new Gson().toJson((Object) list);
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public final List<AccountHistoryBean> e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (List) new Gson().fromJson(str, new a().getType());
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public final void f(String str, List<AccountHistoryBean> list, String str2) {
        if (list.size() >= 20) {
            list.remove(list.size() - 1);
        }
        AccountHistoryBean accountHistoryBean = new AccountHistoryBean(str);
        list.remove(accountHistoryBean);
        list.add(0, accountHistoryBean);
        i(list, str2);
    }

    public List<AccountHistoryBean> g() {
        return e(ConfigPreferences.e("user_config", "HISTORY_MAIN_ACCOUNT_KEY", ""));
    }

    public List<AccountHistoryBean> h() {
        return e(ConfigPreferences.e("user_config", "HISTORY_SUB_ACCOUNT_KEY", ""));
    }

    public final void i(List<AccountHistoryBean> list, String str) {
        ConfigPreferences.m("user_config", str, d(list));
    }

    public void j(String str) {
        List g11 = g();
        if (g11 == null || g11.size() == 0) {
            g11 = new ArrayList();
        }
        f(str, g11, "HISTORY_MAIN_ACCOUNT_KEY");
    }

    public void k(String str) {
        List h11 = h();
        if (h11 == null || h11.size() == 0) {
            h11 = new ArrayList();
        }
        f(str, h11, "HISTORY_SUB_ACCOUNT_KEY");
    }
}
