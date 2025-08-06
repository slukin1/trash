package zq;

import com.hbg.lib.network.hbg.core.bean.MiningSwitch;
import rx.functions.Func1;

public final /* synthetic */ class d implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ d f63111b = new d();

    public final Object call(Object obj) {
        return Boolean.valueOf(((MiningSwitch) obj).isMiningSwitchOn());
    }
}
