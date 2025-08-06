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
import com.hbg.module.content.R$drawable;
import com.hbg.module.content.R$id;

public class l1 extends k1 {
    public static final f.i L = null;
    public static final SparseIntArray M;
    public final TextView H;
    public final ImageView I;
    public final TextView J;
    public long K;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        M = sparseIntArray;
        sparseIntArray.put(R$id.rvContent, 4);
        sparseIntArray.put(R$id.llSelfParent, 5);
        sparseIntArray.put(R$id.llSelf, 6);
        sparseIntArray.put(R$id.tvOpenGiftPanel, 7);
    }

    public l1(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 8, L, M));
    }

    public void M(GiftUser giftUser) {
        this.G = giftUser;
        synchronized (this) {
            this.K |= 1;
        }
        notifyPropertyChanged(BR.f17740q);
        super.B();
    }

    public void i() {
        long j11;
        boolean z11;
        int i11;
        int i12;
        String str;
        String str2;
        String str3;
        synchronized (this) {
            j11 = this.K;
            this.K = 0;
        }
        GiftUser giftUser = this.G;
        int i13 = ((j11 & 3) > 0 ? 1 : ((j11 & 3) == 0 ? 0 : -1));
        String str4 = null;
        boolean z12 = false;
        if (i13 != 0) {
            i12 = R$drawable.icon_default_avatar;
            if (giftUser != null) {
                i11 = giftUser.rank;
                str = giftUser.avatar;
                str2 = giftUser.amount;
            } else {
                str2 = null;
                str = null;
                i11 = 0;
            }
            z11 = i11 == 0;
            if (i13 != 0) {
                j11 = z11 ? j11 | 8 : j11 | 4;
            }
        } else {
            str2 = null;
            str = null;
            i12 = 0;
            i11 = 0;
            z11 = false;
        }
        boolean z13 = (j11 & 4) != 0 && i11 > 99;
        int i14 = ((j11 & 3) > 0 ? 1 : ((j11 & 3) == 0 ? 0 : -1));
        if (i14 != 0) {
            boolean z14 = z11 ? true : z13;
            if (i14 != 0) {
                j11 = z14 ? j11 | 32 : j11 | 16;
            }
            z12 = z14;
        }
        if ((j11 & 16) != 0) {
            str3 = i11 + "";
        } else {
            str3 = null;
        }
        int i15 = ((j11 & 3) > 0 ? 1 : ((j11 & 3) == 0 ? 0 : -1));
        if (i15 != 0) {
            str4 = z12 ? "99+" : str3;
        }
        if (i15 != 0) {
            TextViewBindingAdapter.c(this.H, str4);
            he.b.p(this.I, str, i12);
            TextViewBindingAdapter.c(this.J, str2);
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.K != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.K = 2;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public l1(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[6], objArr[5], objArr[0], objArr[4], objArr[7]);
        this.K = -1;
        this.D.setTag((Object) null);
        TextView textView = objArr[1];
        this.H = textView;
        textView.setTag((Object) null);
        ImageView imageView = objArr[2];
        this.I = imageView;
        imageView.setTag((Object) null);
        TextView textView2 = objArr[3];
        this.J = textView2;
        textView2.setTag((Object) null);
        G(view);
        t();
    }
}
