package lc;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.network.hbg.core.bean.NewFlashInformation;
import com.hbg.lib.network.hbg.core.bean.NewFlashInformationImage;
import com.hbg.module.content.BR;
import com.hbg.module.content.R$id;
import com.hbg.module.content.R$string;
import com.hbg.module.content.ui.activity.NewsDetailActivity;
import mc.a;

public class r extends q implements a.C0130a {
    public static final f.i K0 = null;
    public static final SparseIntArray L0;
    public final RelativeLayout A0;
    public final TextView B0;
    public final TextView C0;
    public final LinearLayout D0;
    public final View.OnClickListener E0;
    public final View.OnClickListener F0;
    public final View.OnClickListener G0;
    public final View.OnClickListener H0;
    public final View.OnClickListener I0;
    public long J0;

    /* renamed from: x0  reason: collision with root package name */
    public final LinearLayout f19314x0;

    /* renamed from: y0  reason: collision with root package name */
    public final ImageView f19315y0;

    /* renamed from: z0  reason: collision with root package name */
    public final TextView f19316z0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        L0 = sparseIntArray;
        sparseIntArray.put(R$id.vEmpty, 22);
        sparseIntArray.put(R$id.vError, 23);
        sparseIntArray.put(R$id.vTopBar, 24);
        sparseIntArray.put(R$id.tvToolbarTitle, 25);
        sparseIntArray.put(R$id.loading_layout, 26);
        sparseIntArray.put(R$id.sflNews, 27);
        sparseIntArray.put(R$id.appBarLayout, 28);
        sparseIntArray.put(R$id.llTagLay, 29);
        sparseIntArray.put(R$id.consRise, 30);
        sparseIntArray.put(R$id.imageRise, 31);
        sparseIntArray.put(R$id.lottieRise, 32);
        sparseIntArray.put(R$id.consPut, 33);
        sparseIntArray.put(R$id.imagePut, 34);
        sparseIntArray.put(R$id.lottiePut, 35);
        sparseIntArray.put(R$id.consComment, 36);
        sparseIntArray.put(R$id.imageComment, 37);
        sparseIntArray.put(R$id.consShare, 38);
        sparseIntArray.put(R$id.adItemView, 39);
        sparseIntArray.put(R$id.tvRecommendNewsTitle, 40);
        sparseIntArray.put(R$id.rvRecommendNews, 41);
        sparseIntArray.put(R$id.rvContent, 42);
        sparseIntArray.put(R$id.imageCommon, 43);
        sparseIntArray.put(R$id.imageLike, 44);
        sparseIntArray.put(R$id.lottieLike, 45);
        sparseIntArray.put(R$id.imageShare, 46);
    }

    public r(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 47, K0, L0));
    }

    public void M(NewFlashInformationImage newFlashInformationImage) {
        this.f19313w0 = newFlashInformationImage;
        synchronized (this) {
            this.J0 |= 4;
        }
        notifyPropertyChanged(BR.f17727d);
        super.B();
    }

    public void N(NewsDetailActivity newsDetailActivity) {
        this.f19311u0 = newsDetailActivity;
        synchronized (this) {
            this.J0 |= 2;
        }
        notifyPropertyChanged(BR.f17732i);
        super.B();
    }

    public void O(NewFlashInformation newFlashInformation) {
        this.f19312v0 = newFlashInformation;
        synchronized (this) {
            this.J0 |= 1;
        }
        notifyPropertyChanged(BR.f17735l);
        super.B();
    }

    public final void a(int i11, View view) {
        boolean z11 = false;
        if (i11 == 1) {
            NewsDetailActivity newsDetailActivity = this.f19311u0;
            if (newsDetailActivity != null) {
                z11 = true;
            }
            if (z11) {
                newsDetailActivity.finish();
            }
        } else if (i11 == 2) {
            NewsDetailActivity newsDetailActivity2 = this.f19311u0;
            if (newsDetailActivity2 != null) {
                z11 = true;
            }
            if (z11) {
                newsDetailActivity2.Th();
            }
        } else if (i11 == 3) {
            NewsDetailActivity newsDetailActivity3 = this.f19311u0;
            if (newsDetailActivity3 != null) {
                z11 = true;
            }
            if (z11) {
                newsDetailActivity3.Sh(2);
            }
        } else if (i11 == 4) {
            NewsDetailActivity newsDetailActivity4 = this.f19311u0;
            if (newsDetailActivity4 != null) {
                z11 = true;
            }
            if (z11) {
                newsDetailActivity4.Sh(2);
            }
        } else if (i11 == 5) {
            NewsDetailActivity newsDetailActivity5 = this.f19311u0;
            NewFlashInformation newFlashInformation = this.f19312v0;
            if (newsDetailActivity5 != null) {
                if (newFlashInformation != null) {
                    z11 = true;
                }
                if (z11) {
                    newsDetailActivity5.gi(newFlashInformation.getId());
                }
            }
        }
    }

    public void i() {
        long j11;
        long j12;
        String str;
        int i11;
        String str2;
        String str3;
        String str4;
        int i12;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        int i13;
        String str12;
        String str13;
        boolean z11;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        long j13;
        long j14;
        synchronized (this) {
            j11 = this.J0;
            j12 = 0;
            this.J0 = 0;
        }
        NewFlashInformation newFlashInformation = this.f19312v0;
        NewFlashInformationImage newFlashInformationImage = this.f19313w0;
        int i21 = ((j11 & 9) > 0 ? 1 : ((j11 & 9) == 0 ? 0 : -1));
        if (i21 != 0) {
            if (newFlashInformation != null) {
                i14 = newFlashInformation.getComments();
                z11 = newFlashInformation.getTrans();
                int isTranslateTag = newFlashInformation.getIsTranslateTag();
                int badVote = newFlashInformation.getBadVote();
                long issueTime = newFlashInformation.getIssueTime();
                int visit = newFlashInformation.getVisit();
                String title = newFlashInformation.getTitle();
                str13 = newFlashInformation.getContent();
                str12 = newFlashInformation.getLinkTitle();
                i17 = newFlashInformation.praiseNum;
                i19 = newFlashInformation.getBullVote();
                i16 = isTranslateTag;
                i15 = badVote;
                j12 = issueTime;
                i18 = visit;
                str6 = title;
            } else {
                i19 = 0;
                i18 = 0;
                str6 = null;
                i17 = 0;
                i16 = 0;
                i15 = 0;
                i14 = 0;
                z11 = false;
                str13 = null;
                str12 = null;
            }
            if (i21 != 0) {
                if (z11) {
                    j14 = j11 | 512;
                    j13 = 2048;
                } else {
                    j14 = j11 | 256;
                    j13 = 1024;
                }
                j11 = j14 | j13;
            }
            str5 = i14 + "";
            i11 = z11 ? 0 : 8;
            str4 = z11 ? this.f19307l0.getResources().getString(R$string.n_content_translate_show_originaltext) : this.f19307l0.getResources().getString(R$string.n_content_translate_article);
            boolean z12 = i16 == 1;
            str2 = i15 + "";
            str9 = DateTimeUtils.h(j12, "yyyy-MM-dd HH:mm");
            str8 = i18 + "";
            str7 = i17 + "";
            str10 = i19 + "";
            if ((j11 & 9) != 0) {
                j11 |= z12 ? 128 : 64;
            }
            i12 = z12 ? 0 : 8;
            str3 = str13;
            str = str12;
        } else {
            str10 = null;
            str9 = null;
            str8 = null;
            str7 = null;
            str6 = null;
            str5 = null;
            i12 = 0;
            str4 = null;
            str3 = null;
            str2 = null;
            i11 = 0;
            str = null;
        }
        int i22 = ((j11 & 12) > 0 ? 1 : ((j11 & 12) == 0 ? 0 : -1));
        if (i22 != 0) {
            boolean z13 = newFlashInformationImage == null;
            if (i22 != 0) {
                j11 |= z13 ? 32 : 16;
            }
            str11 = newFlashInformationImage != null ? newFlashInformationImage.getImage() : null;
            i13 = z13 ? 8 : 0;
        } else {
            i13 = 0;
            str11 = null;
        }
        int i23 = i13;
        if ((j11 & 9) != 0) {
            this.N.setVisibility(i11);
            he.b.l(this.f19316z0, str5);
            TextViewBindingAdapter.c(this.C0, str9);
            this.D0.setVisibility(i12);
            he.b.l(this.f19296a0, str8);
            TextViewBindingAdapter.c(this.f19297b0, str5);
            TextViewBindingAdapter.c(this.f19298c0, str3);
            this.f19299d0.setVisibility(i11);
            TextViewBindingAdapter.c(this.f19300e0, str7);
            TextViewBindingAdapter.c(this.f19301f0, str);
            TextViewBindingAdapter.c(this.f19302g0, str2);
            TextViewBindingAdapter.c(this.f19304i0, str10);
            TextViewBindingAdapter.c(this.f19305j0, str6);
            TextViewBindingAdapter.c(this.f19307l0, str4);
        }
        if ((8 & j11) != 0) {
            this.O.setOnClickListener(this.I0);
            this.f19315y0.setOnClickListener(this.F0);
            this.B0.setOnClickListener(this.H0);
            this.V.setOnClickListener(this.G0);
            this.W.setOnClickListener(this.E0);
        }
        if ((j11 & 12) != 0) {
            this.P.setVisibility(i23);
            he.b.i(this.P, str11);
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.J0 != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.J0 = 8;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public r(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[39], objArr[28], objArr[36], objArr[33], objArr[30], objArr[38], objArr[37], objArr[43], objArr[44], objArr[34], objArr[31], objArr[46], objArr[6], objArr[2], objArr[10], objArr[29], objArr[26], objArr[45], objArr[35], objArr[32], objArr[18], objArr[20], objArr[42], objArr[41], objArr[27], objArr[14], objArr[19], objArr[9], objArr[7], objArr[21], objArr[11], objArr[13], objArr[40], objArr[12], objArr[3], objArr[25], objArr[8], objArr[22], objArr[23], objArr[24]);
        this.J0 = -1;
        this.N.setTag((Object) null);
        this.O.setTag((Object) null);
        this.P.setTag((Object) null);
        LinearLayout linearLayout = objArr[0];
        this.f19314x0 = linearLayout;
        linearLayout.setTag((Object) null);
        ImageView imageView = objArr[1];
        this.f19315y0 = imageView;
        imageView.setTag((Object) null);
        TextView textView = objArr[15];
        this.f19316z0 = textView;
        textView.setTag((Object) null);
        RelativeLayout relativeLayout = objArr[16];
        this.A0 = relativeLayout;
        relativeLayout.setTag((Object) null);
        TextView textView2 = objArr[17];
        this.B0 = textView2;
        textView2.setTag((Object) null);
        TextView textView3 = objArr[4];
        this.C0 = textView3;
        textView3.setTag((Object) null);
        LinearLayout linearLayout2 = objArr[5];
        this.D0 = linearLayout2;
        linearLayout2.setTag((Object) null);
        this.V.setTag((Object) null);
        this.W.setTag((Object) null);
        this.f19296a0.setTag((Object) null);
        this.f19297b0.setTag((Object) null);
        this.f19298c0.setTag((Object) null);
        this.f19299d0.setTag((Object) null);
        this.f19300e0.setTag((Object) null);
        this.f19301f0.setTag((Object) null);
        this.f19302g0.setTag((Object) null);
        this.f19304i0.setTag((Object) null);
        this.f19305j0.setTag((Object) null);
        this.f19307l0.setTag((Object) null);
        G(view);
        this.E0 = new a(this, 5);
        this.F0 = new a(this, 1);
        this.G0 = new a(this, 4);
        this.H0 = new a(this, 3);
        this.I0 = new a(this, 2);
        t();
    }
}
