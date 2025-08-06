package lj;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.network.hbg.core.bean.DeepNews;
import pro.huobi.R;

public class j0 extends i0 {
    public static final f.i O = null;
    public static final SparseIntArray P;
    public final ConstraintLayout M;
    public long N;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        P = sparseIntArray;
        sparseIntArray.put(R.id.imageLayout, 4);
        sparseIntArray.put(R.id.icon, 5);
        sparseIntArray.put(R.id.line, 6);
        sparseIntArray.put(R.id.tvRead, 7);
        sparseIntArray.put(R.id.tvTitle, 8);
        sparseIntArray.put(R.id.tvDsc, 9);
        sparseIntArray.put(R.id.llHotComment, 10);
    }

    public j0(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 11, O, P));
    }

    public void i() {
        long j11;
        long j12;
        String str;
        synchronized (this) {
            j11 = this.N;
            j12 = 0;
            this.N = 0;
        }
        DeepNews deepNews = this.L;
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
            TextViewBindingAdapter.c(this.I, str2);
            TextViewBindingAdapter.c(this.J, str);
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
    public j0(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[5], objArr[4], objArr[6], objArr[0], objArr[10], objArr[9], objArr[7], objArr[2], objArr[3], objArr[8]);
        this.N = -1;
        this.E.setTag((Object) null);
        ConstraintLayout constraintLayout = objArr[1];
        this.M = constraintLayout;
        constraintLayout.setTag((Object) null);
        this.I.setTag((Object) null);
        this.J.setTag((Object) null);
        G(view);
        t();
    }
}
