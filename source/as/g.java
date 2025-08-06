package as;

import android.widget.EditText;
import com.huobi.staring.adapter.StareConfigListViewHandler;
import com.huobi.staring.bean.StareInfo;
import d10.l;

public final /* synthetic */ class g implements l {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EditText f12206b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ StareInfo f12207c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f12208d;

    public /* synthetic */ g(EditText editText, StareInfo stareInfo, int i11) {
        this.f12206b = editText;
        this.f12207c = stareInfo;
        this.f12208d = i11;
    }

    public final Object invoke(Object obj) {
        return StareConfigListViewHandler.m(this.f12206b, this.f12207c, this.f12208d, (com.hbg.lib.network.hbg.core.bean.StareInfo) obj);
    }
}
