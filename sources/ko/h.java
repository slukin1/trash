package ko;

import android.view.View;
import com.huobi.message.ui.MessageActivity;

public final /* synthetic */ class h implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MessageActivity.a f56603b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f56604c;

    public /* synthetic */ h(MessageActivity.a aVar, int i11) {
        this.f56603b = aVar;
        this.f56604c = i11;
    }

    public final void onClick(View view) {
        this.f56603b.i(this.f56604c, view);
    }
}
