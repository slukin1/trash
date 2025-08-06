package mv;

import android.view.View;
import com.huobi.zeroswap.component.ZeroSwapOpenPositionAdapter;
import com.huobi.zeroswap.vm.ZeroSwapViewModel;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ZeroSwapOpenPositionAdapter f58279b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ZeroSwapViewModel f58280c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f58281d;

    public /* synthetic */ c(ZeroSwapOpenPositionAdapter zeroSwapOpenPositionAdapter, ZeroSwapViewModel zeroSwapViewModel, int i11) {
        this.f58279b = zeroSwapOpenPositionAdapter;
        this.f58280c = zeroSwapViewModel;
        this.f58281d = i11;
    }

    public final void onClick(View view) {
        ZeroSwapOpenPositionAdapter.e(this.f58279b, this.f58280c, this.f58281d, view);
    }
}
