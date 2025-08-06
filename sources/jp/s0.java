package jp;

import com.hbg.lib.core.util.CollectionsUtils;
import com.huobi.store.AppConfig;
import java.util.List;

public class s0 {

    /* renamed from: b  reason: collision with root package name */
    public static s0 f84378b = new s0();

    /* renamed from: a  reason: collision with root package name */
    public List<AppConfig> f84379a;

    public static s0 b() {
        return f84378b;
    }

    public boolean a(int i11, boolean z11) {
        List<AppConfig> list = this.f84379a;
        if (list != null && !CollectionsUtils.b(list)) {
            for (AppConfig next : this.f84379a) {
                if (next.number == i11 && next.getLine().pattern == 1) {
                    if (next.getLine().patternState == 1) {
                        return true;
                    }
                    return false;
                }
            }
        }
        return z11;
    }

    public void c(List<AppConfig> list) {
        this.f84379a = list;
    }
}
