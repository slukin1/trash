package ko;

import android.widget.CompoundButton;
import com.huobi.message.ui.MessageConfigActivity;
import java.util.Map;

public final /* synthetic */ class n implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MessageConfigActivity f56613b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Map f56614c;

    public /* synthetic */ n(MessageConfigActivity messageConfigActivity, Map map) {
        this.f56613b = messageConfigActivity;
        this.f56614c = map;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
        this.f56613b.th(this.f56614c, compoundButton, z11);
    }
}
