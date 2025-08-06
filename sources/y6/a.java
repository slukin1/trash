package y6;

import com.hbg.lib.data.clear.controller.ClearDialogConfigController;
import com.hbg.lib.network.hbg.core.bean.ClearDialogConfig;
import rx.functions.Func1;

public final /* synthetic */ class a implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f61715b;

    public /* synthetic */ a(int i11) {
        this.f61715b = i11;
    }

    public final Object call(Object obj) {
        return ClearDialogConfigController.f68832a.put(Integer.valueOf(this.f61715b), (ClearDialogConfig) obj);
    }
}
