package da;

import android.view.View;
import com.hbg.lib.widgets.dialog.bean.HomeCommonPopListItem;
import com.hbg.lib.widgets.dialog.viewhander.CommonHomePopListItemHandler;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HomeCommonPopListItem f53551b;

    public /* synthetic */ b(HomeCommonPopListItem homeCommonPopListItem) {
        this.f53551b = homeCommonPopListItem;
    }

    public final void onClick(View view) {
        CommonHomePopListItemHandler.d(this.f53551b, view);
    }
}
