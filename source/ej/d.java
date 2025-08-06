package ej;

import com.hbg.lib.network.hbg.core.util.MgtConfigNumber;
import com.huobi.store.AppConfig;
import com.huobi.store.BusinessLine;
import java.util.HashMap;
import java.util.List;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f47504a = new d();

    /* renamed from: b  reason: collision with root package name */
    public static final HashMap<Integer, BusinessLine> f47505b = new HashMap<>();

    public static d a() {
        return f47504a;
    }

    public void b(List<AppConfig> list) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            AppConfig appConfig = list.get(i11);
            int i12 = MgtConfigNumber.ZERO_SWAP.number;
            int i13 = appConfig.number;
            if (i12 == i13) {
                f47505b.put(Integer.valueOf(i12), appConfig.getLine());
            } else {
                int i14 = MgtConfigNumber.REVIEW_SWAP.number;
                if (i14 == i13) {
                    f47505b.put(Integer.valueOf(i14), appConfig.getLine());
                }
            }
        }
    }

    public boolean c(int i11) {
        BusinessLine businessLine = f47505b.get(Integer.valueOf(i11));
        if (businessLine != null && businessLine.isSwitch() && businessLine.isOpen()) {
            return true;
        }
        return false;
    }
}
