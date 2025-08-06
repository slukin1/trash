package da;

import android.view.View;
import com.hbg.lib.widgets.dialog.bean.CommonPopListItem;
import com.hbg.lib.widgets.dialog.viewhander.CommonPopListItemHandler;

public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CommonPopListItem f53553b;

    public /* synthetic */ d(CommonPopListItem commonPopListItem) {
        this.f53553b = commonPopListItem;
    }

    public final void onClick(View view) {
        CommonPopListItemHandler.d(this.f53553b, view);
    }
}
