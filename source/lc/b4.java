package lc;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.network.hbg.core.bean.DeepNews;
import com.hbg.module.content.BR;
import com.hbg.module.content.R$id;

public class b4 extends a4 {
    public static final f.i J = null;
    public static final SparseIntArray K;
    public long I;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        K = sparseIntArray;
        sparseIntArray.put(R$id.tvTitle, 3);
        sparseIntArray.put(R$id.ivPic, 4);
        sparseIntArray.put(R$id.item_deep_bottom_divider, 5);
    }

    public b4(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 6, J, K));
    }

    public void M(DeepNews deepNews) {
        this.H = deepNews;
        synchronized (this) {
            this.I |= 1;
        }
        notifyPropertyChanged(BR.f17735l);
        super.B();
    }

    public void i() {
        long j11;
        long j12;
        String str;
        synchronized (this) {
            j11 = this.I;
            j12 = 0;
            this.I = 0;
        }
        DeepNews deepNews = this.H;
        int i11 = ((j11 & 3) > 0 ? 1 : ((j11 & 3) == 0 ? 0 : -1));
        String str2 = null;
        if (i11 != 0) {
            if (deepNews != null) {
                j12 = deepNews.getIssueTime();
                str2 = deepNews.getSource();
            }
            str = DateTimeUtils.h(j12, "yyyy-MM-dd HH:mm");
        } else {
            str = null;
        }
        if (i11 != 0) {
            TextViewBindingAdapter.c(this.E, str2);
            TextViewBindingAdapter.c(this.F, str);
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
            this.I = 2;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public b4(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[5], objArr[4], objArr[0], objArr[1], objArr[2], objArr[3]);
        this.I = -1;
        this.D.setTag((Object) null);
        this.E.setTag((Object) null);
        this.F.setTag((Object) null);
        G(view);
        t();
    }
}
