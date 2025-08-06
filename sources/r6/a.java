package r6;

import android.view.View;
import com.hbg.lib.core.page.SmartRefreshPageSplitter;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SmartRefreshPageSplitter f70505b;

    public /* synthetic */ a(SmartRefreshPageSplitter smartRefreshPageSplitter) {
        this.f70505b = smartRefreshPageSplitter;
    }

    public final void onClick(View view) {
        this.f70505b.y(view);
    }
}
