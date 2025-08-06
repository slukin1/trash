package lj;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.f;

public abstract class m0 extends f {
    public final AppCompatTextView B;
    public final TextView C;

    public m0(Object obj, View view, int i11, AppCompatTextView appCompatTextView, TextView textView) {
        super(obj, view, i11);
        this.B = appCompatTextView;
        this.C = textView;
    }
}
