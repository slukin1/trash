package lc;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.module.content.R$id;

public class z2 extends y2 {

    /* renamed from: h0  reason: collision with root package name */
    public static final f.i f19340h0 = null;

    /* renamed from: i0  reason: collision with root package name */
    public static final SparseIntArray f19341i0;

    /* renamed from: g0  reason: collision with root package name */
    public long f19342g0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f19341i0 = sparseIntArray;
        sparseIntArray.put(R$id.atvRecommendStr, 1);
        sparseIntArray.put(R$id.flAvatar, 2);
        sparseIntArray.put(R$id.imageHeader, 3);
        sparseIntArray.put(R$id.tvNickName, 4);
        sparseIntArray.put(R$id.hierarchyImage, 5);
        sparseIntArray.put(R$id.imageMore, 6);
        sparseIntArray.put(R$id.tvDateTime, 7);
        sparseIntArray.put(R$id.line, 8);
        sparseIntArray.put(R$id.tvRead, 9);
        sparseIntArray.put(R$id.sSpace, 10);
        sparseIntArray.put(R$id.tvTitle, 11);
        sparseIntArray.put(R$id.rlContent, 12);
        sparseIntArray.put(R$id.tvContent, 13);
        sparseIntArray.put(R$id.llNewRich, 14);
        sparseIntArray.put(R$id.attachmentContainer, 15);
        sparseIntArray.put(R$id.llLiveStatus, 16);
        sparseIntArray.put(R$id.slvLivePlaying, 17);
        sparseIntArray.put(R$id.ivLivePlaying, 18);
        sparseIntArray.put(R$id.tvLiveType, 19);
        sparseIntArray.put(R$id.container, 20);
        sparseIntArray.put(R$id.llHotComment, 21);
        sparseIntArray.put(R$id.rlCommon, 22);
        sparseIntArray.put(R$id.imageCommon, 23);
        sparseIntArray.put(R$id.tvCommon, 24);
        sparseIntArray.put(R$id.rlLike, 25);
        sparseIntArray.put(R$id.imageLike, 26);
        sparseIntArray.put(R$id.tvLike, 27);
        sparseIntArray.put(R$id.rlShare, 28);
        sparseIntArray.put(R$id.imageShare, 29);
        sparseIntArray.put(R$id.tvShare, 30);
    }

    public z2(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 31, f19340h0, f19341i0));
    }

    public void i() {
        synchronized (this) {
            this.f19342g0 = 0;
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.f19342g0 != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.f19342g0 = 1;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public z2(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[15], objArr[1], objArr[0], objArr[20], objArr[2], objArr[5], objArr[23], objArr[3], objArr[26], objArr[6], objArr[29], objArr[18], objArr[8], objArr[21], objArr[16], objArr[14], objArr[22], objArr[12], objArr[25], objArr[28], objArr[10], objArr[17], objArr[24], objArr[13], objArr[7], objArr[27], objArr[19], objArr[4], objArr[9], objArr[30], objArr[11]);
        this.f19342g0 = -1;
        this.D.setTag((Object) null);
        G(view);
        t();
    }
}
