package qk;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.huobi.feature.util.FutureTpSlHelper;
import rx.functions.Action1;

public final /* synthetic */ class a0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FutureTpSlHelper f59947b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f59948c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ FragmentManager f59949d;

    public /* synthetic */ a0(FutureTpSlHelper futureTpSlHelper, View view, FragmentManager fragmentManager) {
        this.f59947b = futureTpSlHelper;
        this.f59948c = view;
        this.f59949d = fragmentManager;
    }

    public final void call(Object obj) {
        this.f59947b.Z0(this.f59948c, this.f59949d, (Void) obj);
    }
}
