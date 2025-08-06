package as;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import com.huobi.staring.adapter.StareConfigListViewHandler;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EditText f12194b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ImageView f12195c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ImageView f12196d;

    public /* synthetic */ c(EditText editText, ImageView imageView, ImageView imageView2) {
        this.f12194b = editText;
        this.f12195c = imageView;
        this.f12196d = imageView2;
    }

    public final void onClick(View view) {
        StareConfigListViewHandler.l(this.f12194b, this.f12195c, this.f12196d, view);
    }
}
