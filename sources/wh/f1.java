package wh;

import android.view.View;
import com.huobi.asset2.index.BaseAssetChildTabFragment;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public final /* synthetic */ class f1 implements View.OnFocusChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BaseAssetChildTabFragment f61296b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AtomicLong f61297c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f61298d;

    public /* synthetic */ f1(BaseAssetChildTabFragment baseAssetChildTabFragment, AtomicLong atomicLong, AtomicBoolean atomicBoolean) {
        this.f61296b = baseAssetChildTabFragment;
        this.f61297c = atomicLong;
        this.f61298d = atomicBoolean;
    }

    public final void onFocusChange(View view, boolean z11) {
        this.f61296b.Jh(this.f61297c, this.f61298d, view, z11);
    }
}
