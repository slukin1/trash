package da;

import android.text.SpannableString;
import android.widget.TextView;
import com.hbg.lib.widgets.dialog.viewhander.FutureInsideConfirmItemHandler;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TextView f53554b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SpannableString f53555c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ SpannableString f53556d;

    public /* synthetic */ e(TextView textView, SpannableString spannableString, SpannableString spannableString2) {
        this.f53554b = textView;
        this.f53555c = spannableString;
        this.f53556d = spannableString2;
    }

    public final void run() {
        FutureInsideConfirmItemHandler.f(this.f53554b, this.f53555c, this.f53556d);
    }
}
