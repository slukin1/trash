package as;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import com.huobi.staring.adapter.StareConfigListViewHandler;

public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EditText f12197b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ImageView f12198c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ImageView f12199d;

    public /* synthetic */ d(EditText editText, ImageView imageView, ImageView imageView2) {
        this.f12197b = editText;
        this.f12198c = imageView;
        this.f12199d = imageView2;
    }

    public final void onClick(View view) {
        StareConfigListViewHandler.k(this.f12197b, this.f12198c, this.f12199d, view);
    }
}
