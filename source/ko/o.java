package ko;

import android.widget.CompoundButton;
import com.huobi.message.ui.MessageConfigActivity;
import java.util.Map;

public final /* synthetic */ class o implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MessageConfigActivity f56615b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Map f56616c;

    public /* synthetic */ o(MessageConfigActivity messageConfigActivity, Map map) {
        this.f56615b = messageConfigActivity;
        this.f56616c = map;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
        this.f56615b.rh(this.f56616c, compoundButton, z11);
    }
}
