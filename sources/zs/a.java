package zs;

import android.content.res.Resources;
import androidx.fragment.app.FragmentActivity;
import com.huobi.trade.core.HbTradeFragment;

public abstract class a implements c {

    /* renamed from: a  reason: collision with root package name */
    public HbTradeFragment f85110a;

    /* renamed from: b  reason: collision with root package name */
    public FragmentActivity f85111b;

    /* renamed from: c  reason: collision with root package name */
    public b f85112c;

    public a(HbTradeFragment hbTradeFragment, b bVar) {
        this.f85110a = hbTradeFragment;
        this.f85111b = hbTradeFragment.getActivity();
        this.f85112c = bVar;
    }

    public Resources d() {
        return this.f85111b.getResources();
    }

    public b e() {
        return this.f85112c;
    }
}
