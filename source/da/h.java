package da;

import android.view.View;
import com.hbg.lib.widgets.dialog.bean.TitleDialogMenuItemBean;
import com.hbg.lib.widgets.dialog.viewhander.TitleDialogBottomMenuHandler;

public final /* synthetic */ class h implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TitleDialogMenuItemBean.a f53563b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TitleDialogMenuItemBean f53564c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f53565d;

    public /* synthetic */ h(TitleDialogMenuItemBean.a aVar, TitleDialogMenuItemBean titleDialogMenuItemBean, int i11) {
        this.f53563b = aVar;
        this.f53564c = titleDialogMenuItemBean;
        this.f53565d = i11;
    }

    public final void onClick(View view) {
        TitleDialogBottomMenuHandler.d(this.f53563b, this.f53564c, this.f53565d, view);
    }
}
