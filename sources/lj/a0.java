package lj;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.f;
import com.huobi.copytrading.ui.CopyTradingNewHomeFragment;
import com.huobi.copytrading.vm.CopyTradingViewModel;

public abstract class a0 extends f {
    public final ImageView B;
    public final ImageView C;
    public final LinearLayout D;
    public final LinearLayout E;
    public final LinearLayout F;
    public final RelativeLayout G;
    public final TextView H;
    public CopyTradingViewModel I;
    public CopyTradingNewHomeFragment J;

    public a0(Object obj, View view, int i11, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, RelativeLayout relativeLayout, TextView textView) {
        super(obj, view, i11);
        this.B = imageView;
        this.C = imageView2;
        this.D = linearLayout;
        this.E = linearLayout2;
        this.F = linearLayout3;
        this.G = relativeLayout;
        this.H = textView;
    }

    public abstract void K(CopyTradingNewHomeFragment copyTradingNewHomeFragment);

    public abstract void L(CopyTradingViewModel copyTradingViewModel);
}
