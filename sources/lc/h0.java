package lc;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.module.content.R$id;

public class h0 extends g0 {
    public static final f.i N = null;
    public static final SparseIntArray O;
    public final LinearLayout L;
    public long M;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        O = sparseIntArray;
        sparseIntArray.put(R$id.vSpace, 1);
        sparseIntArray.put(R$id.clShare, 2);
        sparseIntArray.put(R$id.ivShareIcon, 3);
        sparseIntArray.put(R$id.vShareView, 4);
        sparseIntArray.put(R$id.tvShareText, 5);
        sparseIntArray.put(R$id.clRecommend, 6);
        sparseIntArray.put(R$id.ivRecommendIcon, 7);
        sparseIntArray.put(R$id.vRecommendView, 8);
        sparseIntArray.put(R$id.tvRecommendText, 9);
        sparseIntArray.put(R$id.tvCancel, 10);
    }

    public h0(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 11, N, O));
    }

    public void i() {
        synchronized (this) {
            this.M = 0;
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.M != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.M = 1;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h0(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[6], objArr[2], objArr[7], objArr[3], objArr[10], objArr[9], objArr[5], objArr[8], objArr[4], objArr[1]);
        this.M = -1;
        LinearLayout linearLayout = objArr[0];
        this.L = linearLayout;
        linearLayout.setTag((Object) null);
        G(view);
        t();
    }
}
