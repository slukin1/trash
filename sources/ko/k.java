package ko;

import android.widget.CompoundButton;
import com.huobi.message.ui.MessageConfigActivity;
import java.util.Map;

public final /* synthetic */ class k implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MessageConfigActivity f56607b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Map f56608c;

    public /* synthetic */ k(MessageConfigActivity messageConfigActivity, Map map) {
        this.f56607b = messageConfigActivity;
        this.f56608c = map;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
        this.f56607b.qh(this.f56608c, compoundButton, z11);
    }
}
