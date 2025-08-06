package lc;

import android.util.SparseIntArray;
import android.view.View;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.module.content.R$id;

public class x2 extends w2 {
    public static final f.i K = null;
    public static final SparseIntArray L;
    public final LinearLayoutCompat I;
    public long J;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        L = sparseIntArray;
        sparseIntArray.put(R$id.atvRecommendStr, 1);
        sparseIntArray.put(R$id.imageHeader, 2);
        sparseIntArray.put(R$id.tvARNickName, 3);
        sparseIntArray.put(R$id.atvProfile, 4);
        sparseIntArray.put(R$id.btnAttention, 5);
        sparseIntArray.put(R$id.imageAttentionPlus, 6);
        sparseIntArray.put(R$id.tvARAction, 7);
    }

    public x2(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 8, K, L));
    }

    public void i() {
        synchronized (this) {
            this.J = 0;
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.J != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.J = 1;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public x2(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[4], objArr[1], objArr[5], objArr[6], objArr[2], objArr[7], objArr[3]);
        this.J = -1;
        LinearLayoutCompat linearLayoutCompat = objArr[0];
        this.I = linearLayoutCompat;
        linearLayoutCompat.setTag((Object) null);
        G(view);
        t();
    }
}
