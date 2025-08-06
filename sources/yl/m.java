package yl;

import android.text.TextUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.network.hbg.core.util.MgtConfigNumber;
import com.huobi.store.AppConfigManager;
import java.util.ArrayList;
import java.util.List;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static final List<String> f76851a = new ArrayList();

    public static boolean a(String str) {
        String i11 = StringUtils.i(str);
        return !TextUtils.isEmpty(i11) && f76851a.contains(i11);
    }

    public static void b() {
        List<String> k11 = AppConfigManager.k(MgtConfigNumber.INCREASE_BLACK_LIST.number, String.class);
        if (k11 != null) {
            List<String> list = f76851a;
            synchronized (list) {
                list.clear();
                for (String i11 : k11) {
                    f76851a.add(StringUtils.i(i11));
                }
            }
        }
    }
}
