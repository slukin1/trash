package fd;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.c;
import androidx.databinding.f;
import com.hbg.lib.network.hbg.core.bean.CustomerInfo;
import com.hbg.module.huobi.im.R$layout;
import com.hbg.module.huobi.im.c2c.ui.CustomerInfoActivity;

public abstract class a extends f {
    public final ImageView B;
    public final LinearLayout C;
    public final LinearLayout D;
    public final RelativeLayout E;
    public final TextView F;
    public final TextView G;
    public final TextView H;
    public final View I;
    public CustomerInfoActivity J;
    public CustomerInfo K;

    public a(Object obj, View view, int i11, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3, View view2) {
        super(obj, view, i11);
        this.B = imageView;
        this.C = linearLayout;
        this.D = linearLayout2;
        this.E = relativeLayout;
        this.F = textView;
        this.G = textView2;
        this.H = textView3;
        this.I = view2;
    }

    public static a K(LayoutInflater layoutInflater) {
        return L(layoutInflater, c.d());
    }

    @Deprecated
    public static a L(LayoutInflater layoutInflater, Object obj) {
        return (a) f.s(layoutInflater, R$layout.activity_customer_info, (ViewGroup) null, false, obj);
    }

    public abstract void M(CustomerInfo customerInfo);

    public abstract void N(CustomerInfoActivity customerInfoActivity);
}
