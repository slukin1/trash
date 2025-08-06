package as;

import android.view.View;
import androidx.appcompat.widget.SwitchCompat;
import com.huobi.staring.adapter.StareConfigListViewHandler;
import com.huobi.staring.bean.StareInfo;

public final /* synthetic */ class f implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ StareInfo f12203b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f12204c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ SwitchCompat f12205d;

    public /* synthetic */ f(StareInfo stareInfo, int i11, SwitchCompat switchCompat) {
        this.f12203b = stareInfo;
        this.f12204c = i11;
        this.f12205d = switchCompat;
    }

    public final void onClick(View view) {
        StareConfigListViewHandler.j(this.f12203b, this.f12204c, this.f12205d, view);
    }
}
