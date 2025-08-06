package nr;

import android.widget.RadioGroup;
import com.huobi.share.ui.ContentShareActivity;

public final /* synthetic */ class d implements RadioGroup.OnCheckedChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContentShareActivity f58701b;

    public /* synthetic */ d(ContentShareActivity contentShareActivity) {
        this.f58701b = contentShareActivity;
    }

    public final void onCheckedChanged(RadioGroup radioGroup, int i11) {
        this.f58701b.yh(radioGroup, i11);
    }
}
