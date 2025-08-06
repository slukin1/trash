package tq;

import com.hbg.lib.core.network.response.UcIntCodeResponse;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class f implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ f f37344b = new f();

    public final Object call(Object obj) {
        return Observable.create(new j((UcIntCodeResponse) obj));
    }
}
