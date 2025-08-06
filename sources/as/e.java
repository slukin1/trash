package as;

import android.view.View;
import android.widget.EditText;
import com.huobi.staring.adapter.StareConfigListViewHandler;
import com.huobi.staring.bean.StareInfo;

public final /* synthetic */ class e implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EditText f12200b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ StareInfo f12201c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f12202d;

    public /* synthetic */ e(EditText editText, StareInfo stareInfo, int i11) {
        this.f12200b = editText;
        this.f12201c = stareInfo;
        this.f12202d = i11;
    }

    public final void onClick(View view) {
        StareConfigListViewHandler.o(this.f12200b, this.f12201c, this.f12202d, view);
    }
}
