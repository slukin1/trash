package lc;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.module.content.R$id;
import com.huobi.view.roundview.RoundLinearLayout;

public class j3 extends i3 {
    public static final f.i P = null;
    public static final SparseIntArray Q;
    public final RoundLinearLayout N;
    public long O;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        Q = sparseIntArray;
        sparseIntArray.put(R$id.llDefaultContent, 1);
        sparseIntArray.put(R$id.ivShareAvatar, 2);
        sparseIntArray.put(R$id.atvSource, 3);
        sparseIntArray.put(R$id.atvShareTitle, 4);
        sparseIntArray.put(R$id.atvShareContent, 5);
        sparseIntArray.put(R$id.clPic, 6);
        sparseIntArray.put(R$id.ivPic, 7);
        sparseIntArray.put(R$id.llLiveStatus, 8);
        sparseIntArray.put(R$id.slvLivePlaying, 9);
        sparseIntArray.put(R$id.ivLivePlaying, 10);
        sparseIntArray.put(R$id.tvLiveType, 11);
        sparseIntArray.put(R$id.llEngineContent, 12);
    }

    public j3(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 13, P, Q));
    }

    public void i() {
        synchronized (this) {
            this.O = 0;
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.O != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.O = 1;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public j3(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[5], objArr[4], objArr[3], objArr[6], objArr[10], objArr[7], objArr[2], objArr[1], objArr[12], objArr[8], objArr[9], objArr[11]);
        this.O = -1;
        RoundLinearLayout roundLinearLayout = objArr[0];
        this.N = roundLinearLayout;
        roundLinearLayout.setTag((Object) null);
        G(view);
        t();
    }
}
