package yj;

import android.content.Context;
import android.widget.EditText;
import com.huobi.edgeengine.template.widget.EditTextWidget;
import com.huobi.edgeengine.template.widget.Widget;

public final /* synthetic */ class c implements Widget.u {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EditTextWidget f61738a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EditText f61739b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f61740c;

    public /* synthetic */ c(EditTextWidget editTextWidget, EditText editText, Context context) {
        this.f61738a = editTextWidget;
        this.f61739b = editText;
        this.f61740c = context;
    }

    public final void a(String str) {
        this.f61738a.o0(this.f61739b, this.f61740c, str);
    }
}
