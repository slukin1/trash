package rb;

import android.view.View;
import com.hbg.lite.view.BigKeyboardView;

public final /* synthetic */ class b implements View.OnLongClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BigKeyboardView f70525b;

    public /* synthetic */ b(BigKeyboardView bigKeyboardView) {
        this.f70525b = bigKeyboardView;
    }

    public final boolean onLongClick(View view) {
        return this.f70525b.e(view);
    }
}
