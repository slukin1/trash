package fd;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.c;
import androidx.databinding.f;
import com.hbg.lib.network.hbg.core.bean.ApplyListBean;
import com.hbg.module.huobi.im.R$layout;

public abstract class e extends f {
    public final ImageView B;
    public final TextView C;
    public final TextView D;
    public final TextView E;
    public final TextView F;
    public final TextView G;
    public final TextView H;
    public ApplyListBean.ApplyUser I;

    public e(Object obj, View view, int i11, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        super(obj, view, i11);
        this.B = imageView;
        this.C = textView;
        this.D = textView2;
        this.E = textView3;
        this.F = textView4;
        this.G = textView5;
        this.H = textView6;
    }

    public static e K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static e L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (e) f.s(layoutInflater, R$layout.item_apply_user, viewGroup, z11, obj);
    }

    public abstract void M(ApplyListBean.ApplyUser applyUser);
}
