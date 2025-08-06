package rb;

import android.view.View;
import com.hbg.lite.view.BigKeyboardView;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BigKeyboardView f70523b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f70524c;

    public /* synthetic */ a(BigKeyboardView bigKeyboardView, String str) {
        this.f70523b = bigKeyboardView;
        this.f70524c = str;
    }

    public final void onClick(View view) {
        this.f70523b.d(this.f70524c, view);
    }
}
