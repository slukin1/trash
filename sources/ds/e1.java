package ds;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.staring.ui.StaringRemindActivity;
import rx.functions.Action1;

public final /* synthetic */ class e1 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ StaringRemindActivity f53919b;

    public /* synthetic */ e1(StaringRemindActivity staringRemindActivity) {
        this.f53919b = staringRemindActivity;
    }

    public final void call(Object obj) {
        this.f53919b.bj((APIStatusErrorException) obj);
    }
}
