package da;

import android.text.SpannableString;
import android.widget.TextView;
import com.hbg.lib.widgets.dialog.viewhander.OrderConfirmListItemHandler;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TextView f53557b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SpannableString f53558c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ SpannableString f53559d;

    public /* synthetic */ f(TextView textView, SpannableString spannableString, SpannableString spannableString2) {
        this.f53557b = textView;
        this.f53558c = spannableString;
        this.f53559d = spannableString2;
    }

    public final void run() {
        OrderConfirmListItemHandler.f(this.f53557b, this.f53558c, this.f53559d);
    }
}
