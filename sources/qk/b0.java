package qk;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.huobi.feature.util.FutureTpSlHelper;
import rx.functions.Action1;

public final /* synthetic */ class b0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FutureTpSlHelper f59951b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f59952c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ FragmentManager f59953d;

    public /* synthetic */ b0(FutureTpSlHelper futureTpSlHelper, View view, FragmentManager fragmentManager) {
        this.f59951b = futureTpSlHelper;
        this.f59952c = view;
        this.f59953d = fragmentManager;
    }

    public final void call(Object obj) {
        this.f59951b.o1(this.f59952c, this.f59953d, (Void) obj);
    }
}
