package q8;

import com.hbg.lib.network.option.core.bean.OptionUserInfo;
import q7.a;
import rx.functions.Func1;

public final /* synthetic */ class g implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ g f53310b = new g();

    public final Object call(Object obj) {
        return a.a().fetchUserInfoActive().b().map(new f((OptionUserInfo) obj));
    }
}
