package wb;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.c;
import androidx.databinding.f;
import com.hbg.module.account.R$layout;
import com.hbg.module.account.index.ui.AccountActivity;

public abstract class a extends f {
    public final ImageView B;
    public final LinearLayout C;
    public final LinearLayout D;
    public final LinearLayout E;
    public final ImageView F;
    public final ImageView G;
    public final View H;
    public AccountActivity I;

    public a(Object obj, View view, int i11, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, ImageView imageView2, ImageView imageView3, View view2) {
        super(obj, view, i11);
        this.B = imageView;
        this.C = linearLayout;
        this.D = linearLayout2;
        this.E = linearLayout3;
        this.F = imageView2;
        this.G = imageView3;
        this.H = view2;
    }

    public static a K(LayoutInflater layoutInflater) {
        return L(layoutInflater, c.d());
    }

    @Deprecated
    public static a L(LayoutInflater layoutInflater, Object obj) {
        return (a) f.s(layoutInflater, R$layout.activity_account, (ViewGroup) null, false, obj);
    }

    public abstract void M(AccountActivity accountActivity);
}
