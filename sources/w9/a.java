package w9;

import android.view.View;
import com.hbg.lib.widgets.adapter.bean.CommonEmptyItem;
import com.hbg.lib.widgets.adapter.viewhandler.CommonEmptyItemHandler;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CommonEmptyItem f61231b;

    public /* synthetic */ a(CommonEmptyItem commonEmptyItem) {
        this.f61231b = commonEmptyItem;
    }

    public final void onClick(View view) {
        CommonEmptyItemHandler.d(this.f61231b, view);
    }
}
