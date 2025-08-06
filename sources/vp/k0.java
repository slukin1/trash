package vp;

import android.view.View;
import com.huobi.otc.widget.OtcQuickKeyBoardView;

public final /* synthetic */ class k0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcQuickKeyBoardView f61154b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ OtcQuickKeyBoardView.a f61155c;

    public /* synthetic */ k0(OtcQuickKeyBoardView otcQuickKeyBoardView, OtcQuickKeyBoardView.a aVar) {
        this.f61154b = otcQuickKeyBoardView;
        this.f61155c = aVar;
    }

    public final void onClick(View view) {
        this.f61154b.g(this.f61155c, view);
    }
}
