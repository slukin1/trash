package tr;

import androidx.fragment.app.FragmentActivity;
import com.huobi.sharev2.bean.ShareInfo;
import com.huobi.sharev2.helper.NewShareHelper;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f37358b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ShareInfo f37359c;

    public /* synthetic */ b(FragmentActivity fragmentActivity, ShareInfo shareInfo) {
        this.f37358b = fragmentActivity;
        this.f37359c = shareInfo;
    }

    public final void run() {
        NewShareHelper.j().t(this.f37358b, this.f37359c);
    }
}
