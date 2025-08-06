package sg;

import com.huobi.account.bean.KnapsackItem;
import com.huobi.account.handler.KnapsackHandler;
import rx.functions.Action1;

public final /* synthetic */ class a implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ KnapsackItem.BagItem f66611b;

    public /* synthetic */ a(KnapsackItem.BagItem bagItem) {
        this.f66611b = bagItem;
    }

    public final void call(Object obj) {
        KnapsackHandler.d(this.f66611b, (Void) obj);
    }
}
