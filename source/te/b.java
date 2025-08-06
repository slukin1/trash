package te;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.adapters.ViewBindingAdapter;
import androidx.databinding.f;
import c.a;
import com.hbg.module.libkt.BR;
import com.hbg.module.libkt.R$color;
import com.hbg.module.libkt.R$drawable;

public class b extends a {
    public static final f.i H = null;
    public static final SparseIntArray I = null;
    public final ConstraintLayout F;
    public long G;

    public b(androidx.databinding.b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 4, H, I));
    }

    public void M(Boolean bool) {
        this.E = bool;
        synchronized (this) {
            this.G |= 1;
        }
        notifyPropertyChanged(BR.f24496b);
        super.B();
    }

    public void i() {
        long j11;
        Drawable drawable;
        Drawable drawable2;
        int i11;
        int i12;
        Context context;
        long j12;
        long j13;
        synchronized (this) {
            j11 = this.G;
            this.G = 0;
        }
        Boolean bool = this.E;
        int i13 = ((j11 & 3) > 0 ? 1 : ((j11 & 3) == 0 ? 0 : -1));
        int i14 = 0;
        Drawable drawable3 = null;
        if (i13 != 0) {
            boolean D = f.D(bool);
            if (i13 != 0) {
                if (D) {
                    j13 = j11 | 8 | 32 | 128 | 512;
                    j12 = 2048;
                } else {
                    j13 = j11 | 4 | 16 | 64 | 256;
                    j12 = 1024;
                }
                j11 = j13 | j12;
            }
            Drawable b11 = a.b(this.B.getContext(), D ? R$drawable.bg_dialog_left_btn_night : R$drawable.bg_dialog_left_btn_light);
            Drawable b12 = a.b(this.C.getContext(), D ? R$drawable.bg_dialog_right_btn_night : R$drawable.bg_dialog_right_btn_light);
            int p11 = f.p(this.D, D ? R$color.night_text_color : R$color.light_text_color);
            int p12 = f.p(this.B, D ? R$color.night_text_color : R$color.light_text_color);
            if (D) {
                context = this.F.getContext();
                i12 = R$drawable.bg_dialog_night;
            } else {
                context = this.F.getContext();
                i12 = R$drawable.bg_dialog_light;
            }
            Drawable drawable4 = b11;
            drawable3 = a.b(context, i12);
            i11 = p11;
            i14 = p12;
            drawable = b12;
            drawable2 = drawable4;
        } else {
            i11 = 0;
            drawable2 = null;
            drawable = null;
        }
        if ((j11 & 3) != 0) {
            ViewBindingAdapter.a(this.F, drawable3);
            ViewBindingAdapter.a(this.B, drawable2);
            this.B.setTextColor(i14);
            ViewBindingAdapter.a(this.C, drawable);
            this.D.setTextColor(i11);
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.G != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.G = 2;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public b(androidx.databinding.b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[2], objArr[3], objArr[1]);
        this.G = -1;
        ConstraintLayout constraintLayout = objArr[0];
        this.F = constraintLayout;
        constraintLayout.setTag((Object) null);
        this.B.setTag((Object) null);
        this.C.setTag((Object) null);
        this.D.setTag((Object) null);
        G(view);
        t();
    }
}
