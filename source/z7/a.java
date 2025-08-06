package z7;

import com.hbg.lib.network.hbg.core.bean.BizTipRecord;
import com.hbg.lib.network.hbg.record.BizRecordProvider;
import rx.functions.Func1;

public final /* synthetic */ class a implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f62016b;

    public /* synthetic */ a(int i11) {
        this.f62016b = i11;
    }

    public final Object call(Object obj) {
        return BizRecordProvider.f(this.f62016b, (BizTipRecord) obj);
    }
}
