package qk;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.hbg.lib.widgets.dialog.CommonListPopupDialog;
import com.huobi.feature.util.FutureTpSlHelper;
import rx.functions.Action1;

public final /* synthetic */ class c0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FutureTpSlHelper f59955b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f59956c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CommonListPopupDialog f59957d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ FragmentManager f59958e;

    public /* synthetic */ c0(FutureTpSlHelper futureTpSlHelper, View view, CommonListPopupDialog commonListPopupDialog, FragmentManager fragmentManager) {
        this.f59955b = futureTpSlHelper;
        this.f59956c = view;
        this.f59957d = commonListPopupDialog;
        this.f59958e = fragmentManager;
    }

    public final void call(Object obj) {
        this.f59955b.k1(this.f59956c, this.f59957d, this.f59958e, (Void) obj);
    }
}
