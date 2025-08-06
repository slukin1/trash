package wg;

import android.widget.CompoundButton;
import com.huobi.account.widget.SettingItemView;

public final /* synthetic */ class b0 implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SettingItemView f61240b;

    public /* synthetic */ b0(SettingItemView settingItemView) {
        this.f61240b = settingItemView;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
        this.f61240b.o(compoundButton, z11);
    }
}
