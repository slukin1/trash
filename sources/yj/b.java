package yj;

import android.view.KeyEvent;
import android.view.View;
import com.huobi.edgeengine.template.widget.EditTextWidget;
import rj.n;

public final /* synthetic */ class b implements View.OnKeyListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EditTextWidget f61736b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ n f61737c;

    public /* synthetic */ b(EditTextWidget editTextWidget, n nVar) {
        this.f61736b = editTextWidget;
        this.f61737c = nVar;
    }

    public final boolean onKey(View view, int i11, KeyEvent keyEvent) {
        return this.f61736b.n0(this.f61737c, view, i11, keyEvent);
    }
}
