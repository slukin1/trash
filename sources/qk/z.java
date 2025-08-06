package qk;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.huobi.feature.util.FutureTpSlHelper;
import rx.functions.Action1;

public final /* synthetic */ class z implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FutureTpSlHelper f60009b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f60010c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ FragmentManager f60011d;

    public /* synthetic */ z(FutureTpSlHelper futureTpSlHelper, View view, FragmentManager fragmentManager) {
        this.f60009b = futureTpSlHelper;
        this.f60010c = view;
        this.f60011d = fragmentManager;
    }

    public final void call(Object obj) {
        this.f60009b.m1(this.f60010c, this.f60011d, (Void) obj);
    }
}
