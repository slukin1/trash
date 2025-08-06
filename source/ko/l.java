package ko;

import android.widget.CompoundButton;
import com.huobi.message.ui.MessageConfigActivity;
import java.util.Map;

public final /* synthetic */ class l implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MessageConfigActivity f56609b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Map f56610c;

    public /* synthetic */ l(MessageConfigActivity messageConfigActivity, Map map) {
        this.f56609b = messageConfigActivity;
        this.f56610c = map;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
        this.f56609b.sh(this.f56610c, compoundButton, z11);
    }
}
