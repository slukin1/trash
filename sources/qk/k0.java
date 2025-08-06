package qk;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.hbg.lib.widgets.dialog.CommonListPopupDialog;

public final /* synthetic */ class k0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CommonListPopupDialog f59976b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FragmentManager f59977c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ View f59978d;

    public /* synthetic */ k0(CommonListPopupDialog commonListPopupDialog, FragmentManager fragmentManager, View view) {
        this.f59976b = commonListPopupDialog;
        this.f59977c = fragmentManager;
        this.f59978d = view;
    }

    public final void run() {
        this.f59976b.showAsDropDown(this.f59977c, this.f59978d);
    }
}
