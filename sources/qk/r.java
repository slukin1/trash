package qk;

import android.view.View;
import androidx.fragment.app.DialogFragment;
import com.huobi.feature.util.FutureOrderErrorHelper;

public final /* synthetic */ class r implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String[] f59991b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DialogFragment f59992c;

    public /* synthetic */ r(String[] strArr, DialogFragment dialogFragment) {
        this.f59991b = strArr;
        this.f59992c = dialogFragment;
    }

    public final void onClick(View view) {
        FutureOrderErrorHelper.e(this.f59991b, this.f59992c, view);
    }
}
