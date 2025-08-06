package lc;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import androidx.databinding.b;
import androidx.databinding.f;
import c.a;
import com.hbg.lib.network.hbg.core.bean.NewFlashInformation;
import com.hbg.module.content.R$color;
import com.hbg.module.content.R$drawable;
import com.hbg.module.content.R$id;

public class h4 extends g4 {

    /* renamed from: d0  reason: collision with root package name */
    public static final f.i f19169d0 = null;

    /* renamed from: e0  reason: collision with root package name */
    public static final SparseIntArray f19170e0;

    /* renamed from: b0  reason: collision with root package name */
    public final ImageView f19171b0;

    /* renamed from: c0  reason: collision with root package name */
    public long f19172c0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f19170e0 = sparseIntArray;
        sparseIntArray.put(R$id.tvDate, 8);
        sparseIntArray.put(R$id.llNewsTop, 9);
        sparseIntArray.put(R$id.vHideView, 10);
        sparseIntArray.put(R$id.tvTime, 11);
        sparseIntArray.put(R$id.tvContent, 12);
        sparseIntArray.put(R$id.clPic, 13);
        sparseIntArray.put(R$id.ivPic, 14);
        sparseIntArray.put(R$id.consRise, 15);
        sparseIntArray.put(R$id.imageRise, 16);
        sparseIntArray.put(R$id.lottieRise, 17);
        sparseIntArray.put(R$id.consPut, 18);
        sparseIntArray.put(R$id.imagePut, 19);
        sparseIntArray.put(R$id.lottiePut, 20);
        sparseIntArray.put(R$id.consComment, 21);
        sparseIntArray.put(R$id.imageComment, 22);
        sparseIntArray.put(R$id.consShare, 23);
        sparseIntArray.put(R$id.imageShare, 24);
        sparseIntArray.put(R$id.vLine, 25);
    }

    public h4(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 26, f19169d0, f19170e0));
    }

    public void i() {
        long j11;
        String str;
        String str2;
        Drawable drawable;
        String str3;
        int i11;
        String str4;
        String str5;
        String str6;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        long j12;
        long j13;
        synchronized (this) {
            j11 = this.f19172c0;
            this.f19172c0 = 0;
        }
        NewFlashInformation newFlashInformation = this.f19168a0;
        int i17 = ((j11 & 3) > 0 ? 1 : ((j11 & 3) == 0 ? 0 : -1));
        Drawable drawable2 = null;
        if (i17 != 0) {
            if (newFlashInformation != null) {
                i15 = newFlashInformation.getComments();
                i14 = newFlashInformation.getBadVote();
                i13 = newFlashInformation.getRank();
                str2 = newFlashInformation.getTitle();
                str = newFlashInformation.getLinkTitle();
                i12 = newFlashInformation.getShared();
                i16 = newFlashInformation.getBullVote();
            } else {
                str2 = null;
                str = null;
                i16 = 0;
                i15 = 0;
                i14 = 0;
                i13 = 0;
                i12 = 0;
            }
            String str7 = i15 + "";
            String str8 = i14 + "";
            boolean z11 = i13 == 0;
            str3 = i12 + "";
            String str9 = i16 + "";
            if (i17 != 0) {
                if (z11) {
                    j13 = j11 | 8 | 32;
                    j12 = 128;
                } else {
                    j13 = j11 | 4 | 16;
                    j12 = 64;
                }
                j11 = j13 | j12;
            }
            Drawable b11 = a.b(this.L.getContext(), z11 ? R$drawable.bg_fastnews : R$drawable.bg_fastnews_hightlight);
            drawable = a.b(this.f19171b0.getContext(), z11 ? R$drawable.rectangle_news_point : R$drawable.rectangle_news_point_hightlight);
            str4 = str9;
            str6 = str7;
            drawable2 = b11;
            String str10 = str8;
            i11 = z11 ? f.p(this.X, R$color.baseColorPrimaryText) : f.p(this.X, R$color.color_news_light_title);
            str5 = str10;
        } else {
            str6 = null;
            str5 = null;
            str4 = null;
            str3 = null;
            drawable = null;
            str2 = null;
            str = null;
            i11 = 0;
        }
        if ((j11 & 3) != 0) {
            ViewBindingAdapter.a(this.L, drawable2);
            ViewBindingAdapter.a(this.f19171b0, drawable);
            he.b.l(this.P, str6);
            TextViewBindingAdapter.c(this.S, str);
            he.b.l(this.T, str5);
            he.b.l(this.U, str4);
            he.b.l(this.V, str3);
            TextViewBindingAdapter.c(this.X, str2);
            this.X.setTextColor(i11);
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.f19172c0 != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.f19172c0 = 2;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public h4(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[13], objArr[21], objArr[18], objArr[15], objArr[23], objArr[22], objArr[19], objArr[16], objArr[24], objArr[14], objArr[0], objArr[9], objArr[20], objArr[17], objArr[6], objArr[12], objArr[8], objArr[3], objArr[5], objArr[4], objArr[7], objArr[11], objArr[2], objArr[10], objArr[25]);
        this.f19172c0 = -1;
        this.L.setTag((Object) null);
        ImageView imageView = objArr[1];
        this.f19171b0 = imageView;
        imageView.setTag((Object) null);
        this.P.setTag((Object) null);
        this.S.setTag((Object) null);
        this.T.setTag((Object) null);
        this.U.setTag((Object) null);
        this.V.setTag((Object) null);
        this.X.setTag((Object) null);
        G(view);
        t();
    }
}
