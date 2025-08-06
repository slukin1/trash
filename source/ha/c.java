package ha;

import android.view.MotionEvent;
import android.view.View;
import com.hbg.lib.widgets.notice.TopScrollNoticeView2;

public final /* synthetic */ class c implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TopScrollNoticeView2 f54911b;

    public /* synthetic */ c(TopScrollNoticeView2 topScrollNoticeView2) {
        this.f54911b = topScrollNoticeView2;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f54911b.f(view, motionEvent);
    }
}
