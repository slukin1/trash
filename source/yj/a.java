package yj;

import android.view.View;
import android.widget.EditText;
import com.huobi.edgeengine.template.widget.EditTextWidget;
import rj.n;

public final /* synthetic */ class a implements View.OnFocusChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EditTextWidget f61733b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ n f61734c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ EditText f61735d;

    public /* synthetic */ a(EditTextWidget editTextWidget, n nVar, EditText editText) {
        this.f61733b = editTextWidget;
        this.f61734c = nVar;
        this.f61735d = editText;
    }

    public final void onFocusChange(View view, boolean z11) {
        this.f61733b.m0(this.f61734c, this.f61735d, view, z11);
    }
}
