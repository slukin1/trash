package d7;

import com.hbg.lib.network.pro.core.bean.SymbolBean;
import java.util.Comparator;

public final /* synthetic */ class v0 implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ v0 f53537b = new v0();

    public final int compare(Object obj, Object obj2) {
        return Integer.compare(((SymbolBean) obj2).getWeight(), ((SymbolBean) obj).getWeight());
    }
}
