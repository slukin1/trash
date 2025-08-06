package tz;

import android.text.Spannable;
import android.text.Spanned;
import android.widget.TextView;
import java.lang.ref.WeakReference;

public class i {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<TextView> f60195a;

    public i(TextView textView) {
        this.f60195a = new WeakReference<>(textView);
    }

    public static void a(Spannable spannable, TextView textView) {
        i[] iVarArr = (i[]) spannable.getSpans(0, spannable.length(), i.class);
        if (iVarArr != null) {
            for (i removeSpan : iVarArr) {
                spannable.removeSpan(removeSpan);
            }
        }
        spannable.setSpan(new i(textView), 0, spannable.length(), 18);
    }

    public static TextView c(Spanned spanned) {
        i[] iVarArr = (i[]) spanned.getSpans(0, spanned.length(), i.class);
        if (iVarArr == null || iVarArr.length <= 0) {
            return null;
        }
        return iVarArr[0].b();
    }

    public TextView b() {
        return (TextView) this.f60195a.get();
    }
}
