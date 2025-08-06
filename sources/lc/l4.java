package lc;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.lib.network.hbg.core.bean.GiftUser;
import com.hbg.module.content.BR;
import com.hbg.module.content.R$color;
import com.hbg.module.content.R$drawable;

public class l4 extends k4 {
    public static final f.i J = null;
    public static final SparseIntArray K = null;
    public final TextView E;
    public final ImageView F;
    public final TextView G;
    public final TextView H;
    public long I;

    public l4(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 5, J, K));
    }

    public void M(GiftUser giftUser) {
        this.D = giftUser;
        synchronized (this) {
            this.I |= 2;
        }
        notifyPropertyChanged(BR.f17736m);
        super.B();
    }

    public void N(Integer num) {
        this.C = num;
    }

    public void i() {
        long j11;
        boolean z11;
        boolean z12;
        String str;
        int i11;
        String str2;
        String str3;
        int i12;
        boolean z13;
        boolean z14;
        String str4;
        int i13;
        String str5;
        long j12;
        synchronized (this) {
            j11 = this.I;
            this.I = 0;
        }
        GiftUser giftUser = this.D;
        int i14 = ((j11 & 6) > 0 ? 1 : ((j11 & 6) == 0 ? 0 : -1));
        if (i14 != 0) {
            int i15 = R$drawable.icon_default_avatar;
            if (giftUser != null) {
                i11 = giftUser.rank;
                str = giftUser.amount;
                str3 = giftUser.nickname;
                str2 = giftUser.avatar;
            } else {
                str3 = null;
                str2 = null;
                i11 = 0;
                str = null;
            }
            z12 = i11 == 0;
            z11 = i11 == 1;
            if (i14 != 0) {
                j11 = z12 ? j11 | 64 : j11 | 32;
            }
            if ((j11 & 6) != 0) {
                j11 = z11 ? j11 | 256 : j11 | 128;
            }
            i12 = i15;
        } else {
            i12 = 0;
            str3 = null;
            str2 = null;
            i11 = 0;
            str = null;
            z12 = false;
            z11 = false;
        }
        if ((j11 & 160) != 0) {
            if (giftUser != null) {
                i11 = giftUser.rank;
            }
            int i16 = ((j11 & 128) > 0 ? 1 : ((j11 & 128) == 0 ? 0 : -1));
            if (i16 != 0) {
                z13 = i11 == 2;
                if (i16 != 0) {
                    j11 = z13 ? j11 | 4096 : j11 | 2048;
                }
            } else {
                z13 = false;
            }
            z14 = (32 & j11) != 0 && i11 > 99;
        } else {
            z14 = false;
            z13 = false;
        }
        int i17 = ((j11 & 6) > 0 ? 1 : ((j11 & 6) == 0 ? 0 : -1));
        if (i17 != 0) {
            if (z12) {
                z14 = true;
            }
            if (i17 != 0) {
                j11 = z14 ? j11 | 1024 : j11 | 512;
            }
        } else {
            z14 = false;
        }
        if ((j11 & 512) != 0) {
            str4 = i11 + "";
        } else {
            str4 = null;
        }
        int i18 = ((j11 & 2048) > 0 ? 1 : ((j11 & 2048) == 0 ? 0 : -1));
        if (i18 != 0) {
            boolean z15 = i11 == 3;
            if (i18 != 0) {
                j11 |= z15 ? 16 : 8;
            }
            i13 = f.p(this.E, z15 ? R$color.live_rank_num_3 : R$color.live_gift_border);
        } else {
            i13 = 0;
        }
        int i19 = ((j11 & 6) > 0 ? 1 : ((j11 & 6) == 0 ? 0 : -1));
        if (i19 != 0) {
            str5 = z14 ? "99+" : str4;
            j12 = 128;
        } else {
            j12 = 128;
            str5 = null;
        }
        if ((j11 & j12) == 0) {
            i13 = 0;
        } else if (z13) {
            i13 = f.p(this.E, R$color.live_rank_num_2);
        }
        int p11 = i19 != 0 ? z11 ? f.p(this.E, R$color.live_rank_num_1) : i13 : 0;
        if (i19 != 0) {
            TextViewBindingAdapter.c(this.E, str5);
            this.E.setTextColor(p11);
            he.b.p(this.F, str2, i12);
            TextViewBindingAdapter.c(this.G, str3);
            TextViewBindingAdapter.c(this.H, str);
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.I != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.I = 4;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public l4(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[0]);
        this.I = -1;
        this.B.setTag((Object) null);
        TextView textView = objArr[1];
        this.E = textView;
        textView.setTag((Object) null);
        ImageView imageView = objArr[2];
        this.F = imageView;
        imageView.setTag((Object) null);
        TextView textView2 = objArr[3];
        this.G = textView2;
        textView2.setTag((Object) null);
        TextView textView3 = objArr[4];
        this.H = textView3;
        textView3.setTag((Object) null);
        G(view);
        t();
    }
}
