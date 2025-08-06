package lc;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.module.content.BR;
import com.hbg.module.content.R$id;
import com.hbg.module.libkt.utils.event.bean.GiftBean;

public class j4 extends i4 {
    public static final f.i S = null;
    public static final SparseIntArray T;
    public final RelativeLayout Q;
    public long R;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        T = sparseIntArray;
        sparseIntArray.put(R$id.rlBase, 4);
        sparseIntArray.put(R$id.rlItem, 5);
        sparseIntArray.put(R$id.tvPrice, 6);
        sparseIntArray.put(R$id.tvGiftTitle, 7);
        sparseIntArray.put(R$id.tvSend, 8);
        sparseIntArray.put(R$id.tvTips, 9);
        sparseIntArray.put(R$id.tvFreeNum, 10);
        sparseIntArray.put(R$id.lavGift, 11);
        sparseIntArray.put(R$id.llComboNum, 12);
        sparseIntArray.put(R$id.ivComboOne, 13);
        sparseIntArray.put(R$id.ivComboTwo, 14);
    }

    public j4(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 15, S, T));
    }

    public void M(GiftBean giftBean) {
        this.P = giftBean;
        synchronized (this) {
            this.R |= 1;
        }
        notifyPropertyChanged(BR.f17725b);
        super.B();
    }

    public void i() {
        long j11;
        String str;
        synchronized (this) {
            j11 = this.R;
            this.R = 0;
        }
        GiftBean giftBean = this.P;
        int i11 = ((j11 & 3) > 0 ? 1 : ((j11 & 3) == 0 ? 0 : -1));
        String str2 = null;
        if (i11 == 0 || giftBean == null) {
            str = null;
        } else {
            str = giftBean.getGiftName();
            str2 = giftBean.getUrlPng();
        }
        if (i11 != 0) {
            he.b.h(this.D, str2);
            he.b.h(this.E, str2);
            TextViewBindingAdapter.c(this.K, str);
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.R != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.R = 2;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public j4(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[13], objArr[14], objArr[1], objArr[3], objArr[11], objArr[12], objArr[4], objArr[5], objArr[10], objArr[2], objArr[7], objArr[6], objArr[8], objArr[9]);
        this.R = -1;
        this.D.setTag((Object) null);
        this.E.setTag((Object) null);
        RelativeLayout relativeLayout = objArr[0];
        this.Q = relativeLayout;
        relativeLayout.setTag((Object) null);
        this.K.setTag((Object) null);
        G(view);
        t();
    }
}
