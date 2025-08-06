package te;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.c;
import androidx.databinding.f;
import com.hbg.module.libkt.R$layout;
import com.tencent.rtmp.ui.TXCloudVideoView;

public abstract class g extends f {
    public final ConstraintLayout B;
    public final ImageView C;
    public final ImageView D;
    public final LinearLayout E;
    public final SeekBar F;
    public final RelativeLayout G;
    public final TextView H;
    public final TextView I;
    public final TXCloudVideoView J;
    public final e K;
    public final c L;

    public g(Object obj, View view, int i11, ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, SeekBar seekBar, RelativeLayout relativeLayout, TextView textView, TextView textView2, TXCloudVideoView tXCloudVideoView, e eVar, c cVar) {
        super(obj, view, i11);
        this.B = constraintLayout;
        this.C = imageView;
        this.D = imageView2;
        this.E = linearLayout;
        this.F = seekBar;
        this.G = relativeLayout;
        this.H = textView;
        this.I = textView2;
        this.J = tXCloudVideoView;
        this.K = eVar;
        this.L = cVar;
    }

    public static g K(LayoutInflater layoutInflater) {
        return L(layoutInflater, c.d());
    }

    @Deprecated
    public static g L(LayoutInflater layoutInflater, Object obj) {
        return (g) f.s(layoutInflater, R$layout.view_video, (ViewGroup) null, false, obj);
    }
}
