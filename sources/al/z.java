package al;

import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.network.hbg.core.bean.MineAccountItem;
import d7.q0;
import java.util.Comparator;

public final /* synthetic */ class z implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ z f3604b = new z();

    public final int compare(Object obj, Object obj2) {
        return Integer.compare(q0.i(StringUtils.g(((MineAccountItem) obj2).getCurrency())), q0.i(StringUtils.g(((MineAccountItem) obj).getCurrency())));
    }
}
