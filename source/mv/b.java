package mv;

import android.view.View;
import com.huobi.zeroswap.component.ZeroSwapOpenPositionAdapter;
import com.huobi.zeroswap.vm.ZeroSwapViewModel;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ZeroSwapOpenPositionAdapter f58276b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ZeroSwapViewModel f58277c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f58278d;

    public /* synthetic */ b(ZeroSwapOpenPositionAdapter zeroSwapOpenPositionAdapter, ZeroSwapViewModel zeroSwapViewModel, int i11) {
        this.f58276b = zeroSwapOpenPositionAdapter;
        this.f58277c = zeroSwapViewModel;
        this.f58278d = i11;
    }

    public final void onClick(View view) {
        ZeroSwapOpenPositionAdapter.f(this.f58276b, this.f58277c, this.f58278d, view);
    }
}
