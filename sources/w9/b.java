package w9;

import android.view.View;
import com.hbg.lib.widgets.adapter.bean.CommonNetErrorItem;
import com.hbg.lib.widgets.adapter.viewhandler.CommonNetErrorItemHandler;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CommonNetErrorItem f61232b;

    public /* synthetic */ b(CommonNetErrorItem commonNetErrorItem) {
        this.f61232b = commonNetErrorItem;
    }

    public final void onClick(View view) {
        CommonNetErrorItemHandler.d(this.f61232b, view);
    }
}
