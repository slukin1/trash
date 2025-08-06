package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.c;
import androidx.databinding.f;
import com.hbg.module.community.ui.PostDynamicActivity;
import com.hbg.module.community.widgets.rich.RichEditor;
import com.hbg.module.content.R$layout;
import com.huobi.view.roundview.RoundTextView;

public abstract class u extends f {
    public final EditText B;
    public final ImageView C;
    public final LinearLayout D;
    public final RichEditor E;
    public final RelativeLayout F;
    public final TextView G;
    public final RoundTextView H;
    public final TextView I;
    public final View J;
    public final View K;
    public PostDynamicActivity L;

    public u(Object obj, View view, int i11, EditText editText, ImageView imageView, LinearLayout linearLayout, RichEditor richEditor, RelativeLayout relativeLayout, TextView textView, RoundTextView roundTextView, TextView textView2, View view2, View view3) {
        super(obj, view, i11);
        this.B = editText;
        this.C = imageView;
        this.D = linearLayout;
        this.E = richEditor;
        this.F = relativeLayout;
        this.G = textView;
        this.H = roundTextView;
        this.I = textView2;
        this.J = view2;
        this.K = view3;
    }

    public static u K(LayoutInflater layoutInflater) {
        return L(layoutInflater, c.d());
    }

    @Deprecated
    public static u L(LayoutInflater layoutInflater, Object obj) {
        return (u) f.s(layoutInflater, R$layout.activity_post_dynamic, (ViewGroup) null, false, obj);
    }

    public abstract void M(PostDynamicActivity postDynamicActivity);
}
