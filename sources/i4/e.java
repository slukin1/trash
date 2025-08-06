package i4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.c;
import androidx.databinding.f;
import com.business.common.R$layout;

public abstract class e extends f {
    public final ConstraintLayout B;
    public final Guideline C;
    public final Guideline D;
    public final Guideline E;
    public final AppCompatImageView F;
    public final AppCompatImageView G;
    public final AppCompatTextView H;
    public final AppCompatTextView I;
    public final AppCompatTextView J;

    public e(Object obj, View view, int i11, ConstraintLayout constraintLayout, Guideline guideline, Guideline guideline2, Guideline guideline3, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3) {
        super(obj, view, i11);
        this.B = constraintLayout;
        this.C = guideline;
        this.D = guideline2;
        this.E = guideline3;
        this.F = appCompatImageView;
        this.G = appCompatImageView2;
        this.H = appCompatTextView;
        this.I = appCompatTextView2;
        this.J = appCompatTextView3;
    }

    public static e K(LayoutInflater layoutInflater) {
        return L(layoutInflater, c.d());
    }

    @Deprecated
    public static e L(LayoutInflater layoutInflater, Object obj) {
        return (e) f.s(layoutInflater, R$layout.dialog_fragment_red_packet_tips, (ViewGroup) null, false, obj);
    }
}
