package ko;

import android.widget.CompoundButton;
import com.huobi.message.ui.MessageConfigActivity;
import java.util.Map;

public final /* synthetic */ class m implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MessageConfigActivity f56611b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Map f56612c;

    public /* synthetic */ m(MessageConfigActivity messageConfigActivity, Map map) {
        this.f56611b = messageConfigActivity;
        this.f56612c = map;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
        this.f56611b.uh(this.f56612c, compoundButton, z11);
    }
}
