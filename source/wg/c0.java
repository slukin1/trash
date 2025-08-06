package wg;

import android.view.View;
import com.huobi.account.widget.SettingItemView;
import rx.functions.Action1;

public final /* synthetic */ class c0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SettingItemView f61242b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f61243c;

    public /* synthetic */ c0(SettingItemView settingItemView, View view) {
        this.f61242b = settingItemView;
        this.f61243c = view;
    }

    public final void call(Object obj) {
        this.f61242b.p(this.f61243c, (Void) obj);
    }
}
