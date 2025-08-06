package lc;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.module.content.R$id;

public class h1 extends g1 {
    public static final f.i K = null;
    public static final SparseIntArray L;
    public final RelativeLayout I;
    public long J;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        L = sparseIntArray;
        sparseIntArray.put(R$id.llcTabContainer, 1);
        sparseIntArray.put(R$id.ciCommunityKlineTab, 2);
        sparseIntArray.put(R$id.atvJoinNum, 3);
        sparseIntArray.put(R$id.vpCommunityFeed, 4);
        sparseIntArray.put(R$id.clPublished, 5);
        sparseIntArray.put(R$id.airdropView, 6);
        sparseIntArray.put(R$id.btnPublished, 7);
    }

    public h1(b bVar, View view) {
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

    public h1(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[6], objArr[3], objArr[7], objArr[2], objArr[5], objArr[1], objArr[4]);
        this.J = -1;
        RelativeLayout relativeLayout = objArr[0];
        this.I = relativeLayout;
        relativeLayout.setTag((Object) null);
        G(view);
        t();
    }
}
