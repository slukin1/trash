package am;

import android.view.View;
import com.huobi.index.ui.widget.HomeSearchCarouseView;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f3605b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ HomeSearchCarouseView f3606c;

    public /* synthetic */ c(String str, HomeSearchCarouseView homeSearchCarouseView) {
        this.f3605b = str;
        this.f3606c = homeSearchCarouseView;
    }

    public final void onClick(View view) {
        HomeSearchCarouseView.o(this.f3605b, this.f3606c, view);
    }
}
