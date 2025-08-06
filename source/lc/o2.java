package lc;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.f;

public abstract class o2 extends f {
    public final ImageView B;
    public final LinearLayout C;
    public final TextView D;

    public o2(Object obj, View view, int i11, ImageView imageView, LinearLayout linearLayout, TextView textView) {
        super(obj, view, i11);
        this.B = imageView;
        this.C = linearLayout;
        this.D = textView;
    }
}
