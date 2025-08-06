package lc;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.lib.network.hbg.core.bean.ContentUGCModel;
import com.hbg.module.content.BR;
import com.hbg.module.content.R$id;

public class b6 extends a6 {
    public static final f.i O = null;
    public static final SparseIntArray P;
    public final ConstraintLayout M;
    public long N;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        P = sparseIntArray;
        sparseIntArray.put(R$id.vSpaceLeft, 4);
        sparseIntArray.put(R$id.llItem, 5);
        sparseIntArray.put(R$id.tvStatus, 6);
        sparseIntArray.put(R$id.rlBtn, 7);
        sparseIntArray.put(R$id.tvBtn, 8);
        sparseIntArray.put(R$id.ivTaskGift, 9);
        sparseIntArray.put(R$id.vSpaceRight, 10);
    }

    public b6(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 11, O, P));
    }

    public void M(ContentUGCModel.UGCTaskModel uGCTaskModel) {
        this.L = uGCTaskModel;
        synchronized (this) {
            this.N |= 1;
        }
        notifyPropertyChanged(BR.f17725b);
        super.B();
    }

    public void i() {
        long j11;
        String str;
        String str2;
        String str3;
        synchronized (this) {
            j11 = this.N;
            this.N = 0;
        }
        double d11 = 0.0d;
        ContentUGCModel.UGCTaskModel uGCTaskModel = this.L;
        int i11 = ((j11 & 3) > 0 ? 1 : ((j11 & 3) == 0 ? 0 : -1));
        String str4 = null;
        if (i11 != 0) {
            if (uGCTaskModel != null) {
                str4 = uGCTaskModel.showTitle;
                d11 = uGCTaskModel.bonusAmount;
                str3 = uGCTaskModel.icon;
            } else {
                str3 = null;
            }
            str = "+" + d11;
            String str5 = str3;
            str2 = str4;
            str4 = str5;
        } else {
            str2 = null;
            str = null;
        }
        if (i11 != 0) {
            he.b.h(this.B, str4);
            TextViewBindingAdapter.c(this.H, str);
            TextViewBindingAdapter.c(this.I, str2);
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.N != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.N = 2;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b6(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[1], objArr[9], objArr[5], objArr[7], objArr[8], objArr[6], objArr[3], objArr[2], objArr[4], objArr[10]);
        this.N = -1;
        this.B.setTag((Object) null);
        ConstraintLayout constraintLayout = objArr[0];
        this.M = constraintLayout;
        constraintLayout.setTag((Object) null);
        this.H.setTag((Object) null);
        this.I.setTag((Object) null);
        G(view);
        t();
    }
}
