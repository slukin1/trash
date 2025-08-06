package lc;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.f;
import com.hbg.lib.network.hbg.core.bean.LiveGroup;
import com.huobi.view.roundview.RoundTextView;

public abstract class e6 extends f {
    public final ImageView B;
    public final LinearLayout C;
    public final RoundTextView D;
    public final View E;
    public LiveGroup F;

    public e6(Object obj, View view, int i11, ImageView imageView, LinearLayout linearLayout, RoundTextView roundTextView, View view2) {
        super(obj, view, i11);
        this.B = imageView;
        this.C = linearLayout;
        this.D = roundTextView;
        this.E = view2;
    }

    public abstract void K(LiveGroup liveGroup);
}
