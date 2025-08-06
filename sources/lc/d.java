package lc;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo;
import com.hbg.module.community.ui.DynamicDetailActivity;
import com.hbg.module.content.BR;
import com.hbg.module.content.R$id;
import com.hbg.module.content.R$layout;
import com.hbg.module.content.R$string;
import mc.a;

public class d extends c implements a.C0130a {
    public static final f.i Y0;
    public static final SparseIntArray Z0;
    public final RelativeLayout N0;
    public final AppCompatImageView O0;
    public final RelativeLayout P0;
    public final AppCompatTextView Q0;
    public final LinearLayout R0;
    public final LinearLayout S0;
    public final View.OnClickListener T0;
    public final View.OnClickListener U0;
    public final View.OnClickListener V0;
    public final View.OnClickListener W0;
    public long X0;

    static {
        f.i iVar = new f.i(63);
        Y0 = iVar;
        iVar.a(3, new String[]{"item_community_feed_share"}, new int[]{22}, new int[]{R$layout.item_community_feed_share});
        SparseIntArray sparseIntArray = new SparseIntArray();
        Z0 = sparseIntArray;
        sparseIntArray.put(R$id.vEmpty, 20);
        sparseIntArray.put(R$id.vError, 21);
        sparseIntArray.put(R$id.llContent, 23);
        sparseIntArray.put(R$id.vTopBar, 24);
        sparseIntArray.put(R$id.llLoading, 25);
        sparseIntArray.put(R$id.sflDetail, 26);
        sparseIntArray.put(R$id.mAppBarLayout, 27);
        sparseIntArray.put(R$id.wvRichView, 28);
        sparseIntArray.put(R$id.llOldVersion, 29);
        sparseIntArray.put(R$id.llAuthorInfo, 30);
        sparseIntArray.put(R$id.ivAvatar, 31);
        sparseIntArray.put(R$id.tvDate, 32);
        sparseIntArray.put(R$id.ivGroup, 33);
        sparseIntArray.put(R$id.vSeparator, 34);
        sparseIntArray.put(R$id.btnAttention, 35);
        sparseIntArray.put(R$id.imageAttentionPlus, 36);
        sparseIntArray.put(R$id.tvARAction, 37);
        sparseIntArray.put(R$id.llNewRich, 38);
        sparseIntArray.put(R$id.pkCommonView, 39);
        sparseIntArray.put(R$id.rlImage, 40);
        sparseIntArray.put(R$id.imageLayout, 41);
        sparseIntArray.put(R$id.llLiveStatus, 42);
        sparseIntArray.put(R$id.slvLivePlaying, 43);
        sparseIntArray.put(R$id.ivLivePlaying, 44);
        sparseIntArray.put(R$id.tvLiveType, 45);
        sparseIntArray.put(R$id.tvArticleLink, 46);
        sparseIntArray.put(R$id.coinTags, 47);
        sparseIntArray.put(R$id.tvTopic, 48);
        sparseIntArray.put(R$id.tvReviewSuffix, 49);
        sparseIntArray.put(R$id.tvLikeSuffix, 50);
        sparseIntArray.put(R$id.tvShareSuffix, 51);
        sparseIntArray.put(R$id.tvComment, 52);
        sparseIntArray.put(R$id.rbHottest, 53);
        sparseIntArray.put(R$id.rbNewest, 54);
        sparseIntArray.put(R$id.rvContent, 55);
        sparseIntArray.put(R$id.airdropView, 56);
        sparseIntArray.put(R$id.imageCommon, 57);
        sparseIntArray.put(R$id.rlLike, 58);
        sparseIntArray.put(R$id.imageLike, 59);
        sparseIntArray.put(R$id.llShare, 60);
        sparseIntArray.put(R$id.imageShare, 61);
        sparseIntArray.put(R$id.flVideo, 62);
    }

    public d(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 63, Y0, Z0));
    }

    public void M(DynamicDetailInfo dynamicDetailInfo) {
        this.M0 = dynamicDetailInfo;
        synchronized (this) {
            this.X0 |= 2;
        }
        notifyPropertyChanged(BR.f17726c);
        super.B();
    }

    public void N(DynamicDetailActivity dynamicDetailActivity) {
        this.L0 = dynamicDetailActivity;
        synchronized (this) {
            this.X0 |= 4;
        }
        notifyPropertyChanged(BR.f17732i);
        super.B();
    }

    public final boolean O(i3 i3Var, int i11) {
        if (i11 != BR.f17724a) {
            return false;
        }
        synchronized (this) {
            this.X0 |= 1;
        }
        return true;
    }

    public final void a(int i11, View view) {
        boolean z11 = false;
        if (i11 == 1) {
            DynamicDetailActivity dynamicDetailActivity = this.L0;
            if (dynamicDetailActivity != null) {
                z11 = true;
            }
            if (z11) {
                dynamicDetailActivity.finish();
            }
        } else if (i11 == 2) {
            DynamicDetailActivity dynamicDetailActivity2 = this.L0;
            if (dynamicDetailActivity2 != null) {
                z11 = true;
            }
            if (z11) {
                dynamicDetailActivity2.ui();
            }
        } else if (i11 == 3) {
            DynamicDetailActivity dynamicDetailActivity3 = this.L0;
            if (dynamicDetailActivity3 != null) {
                z11 = true;
            }
            if (z11) {
                dynamicDetailActivity3.si();
            }
        } else if (i11 == 4) {
            DynamicDetailActivity dynamicDetailActivity4 = this.L0;
            if (dynamicDetailActivity4 != null) {
                z11 = true;
            }
            if (z11) {
                dynamicDetailActivity4.si();
            }
        }
    }

    public void i() {
        long j11;
        int i11;
        int i12;
        int i13;
        CharSequence charSequence;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        boolean z11;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        boolean z12;
        long j12;
        long j13;
        synchronized (this) {
            j11 = this.X0;
            this.X0 = 0;
        }
        DynamicDetailInfo dynamicDetailInfo = this.M0;
        int i19 = ((j11 & 10) > 0 ? 1 : ((j11 & 10) == 0 ? 0 : -1));
        String str9 = null;
        if (i19 != 0) {
            if (dynamicDetailInfo != null) {
                i18 = dynamicDetailInfo.getShared();
                i16 = dynamicDetailInfo.getVisit();
                str2 = dynamicDetailInfo.getTitle();
                i15 = dynamicDetailInfo.getCommentNum();
                i14 = dynamicDetailInfo.getPraiseNum();
                z11 = dynamicDetailInfo.isTrans();
                int textType = dynamicDetailInfo.getTextType();
                str8 = dynamicDetailInfo.getUserNickname();
                str7 = dynamicDetailInfo.getContent();
                z12 = dynamicDetailInfo.isShowTrans();
                i17 = textType;
            } else {
                str2 = null;
                str8 = null;
                str7 = null;
                z12 = false;
                i18 = 0;
                i17 = 0;
                i16 = 0;
                i15 = 0;
                i14 = 0;
                z11 = false;
            }
            if (i19 != 0) {
                if (z11) {
                    j13 = j11 | 128;
                    j12 = 512;
                } else {
                    j13 = j11 | 64;
                    j12 = 256;
                }
                j11 = j13 | j12;
            }
            if ((j11 & 10) != 0) {
                j11 |= z12 ? 2048 : 1024;
            }
            String a11 = he.b.a(i18);
            String a12 = he.b.a(i16);
            String a13 = he.b.a(i15);
            str = he.b.a(i14);
            int i21 = z11 ? 0 : 8;
            charSequence = z11 ? this.F0.getResources().getString(R$string.n_content_translate_show_originaltext) : this.F0.getResources().getString(R$string.n_community_translate_full_text);
            boolean z13 = true;
            if (i17 != 1) {
                z13 = false;
            }
            int i22 = z12 ? 0 : 8;
            if ((j11 & 10) != 0) {
                j11 |= z13 ? 32 : 16;
            }
            int i23 = z13 ? 0 : 8;
            i13 = i22;
            i12 = i23;
            str6 = str7;
            i11 = i21;
            str4 = a12;
            str5 = str8;
            String str10 = a13;
            str3 = a11;
            str9 = str10;
        } else {
            str6 = null;
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            charSequence = null;
            i13 = 0;
            i12 = 0;
            i11 = 0;
        }
        if ((j11 & 8) != 0) {
            this.N.setOnClickListener(this.W0);
            this.O0.setOnClickListener(this.V0);
            this.Q0.setOnClickListener(this.T0);
            this.f19146a0.setOnClickListener(this.U0);
        }
        if ((j11 & 10) != 0) {
            this.S0.setVisibility(i13);
            this.Z.setVisibility(i12);
            TextViewBindingAdapter.c(this.f19156k0, str9);
            TextViewBindingAdapter.c(this.f19157l0, str6);
            this.f19159n0.setVisibility(i11);
            TextViewBindingAdapter.c(this.f19160t0, str);
            TextViewBindingAdapter.c(this.f19161u0, str);
            TextViewBindingAdapter.c(this.f19164x0, str5);
            TextViewBindingAdapter.c(this.f19165y0, str4);
            TextViewBindingAdapter.c(this.A0, str3);
            TextViewBindingAdapter.c(this.B0, str3);
            he.b.j(this.D0, str2);
            TextViewBindingAdapter.c(this.F0, charSequence);
        }
        f.k(this.f19151f0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r4.f19151f0.r() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean r() {
        /*
            r4 = this;
            monitor-enter(r4)
            long r0 = r4.X0     // Catch:{ all -> 0x0018 }
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 1
            if (r0 == 0) goto L_0x000c
            monitor-exit(r4)     // Catch:{ all -> 0x0018 }
            return r1
        L_0x000c:
            monitor-exit(r4)     // Catch:{ all -> 0x0018 }
            lc.i3 r0 = r4.f19151f0
            boolean r0 = r0.r()
            if (r0 == 0) goto L_0x0016
            return r1
        L_0x0016:
            r0 = 0
            return r0
        L_0x0018:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0018 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: lc.d.r():boolean");
    }

    public void t() {
        synchronized (this) {
            this.X0 = 8;
        }
        this.f19151f0.t();
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        if (i11 != 0) {
            return false;
        }
        return O((i3) obj, i12);
    }

    public d(b bVar, View view, Object[] objArr) {
        super(bVar, view, 1, objArr[56], objArr[35], objArr[47], objArr[62], objArr[36], objArr[57], objArr[41], objArr[59], objArr[61], objArr[31], objArr[33], objArr[44], objArr[2], objArr[30], objArr[23], objArr[42], objArr[25], objArr[38], objArr[29], objArr[60], objArr[27], objArr[39], objArr[53], objArr[54], objArr[9], objArr[16], objArr[40], objArr[58], objArr[55], objArr[26], objArr[22], objArr[43], objArr[37], objArr[46], objArr[52], objArr[17], objArr[10], objArr[32], objArr[7], objArr[18], objArr[12], objArr[50], objArr[45], objArr[4], objArr[11], objArr[49], objArr[19], objArr[13], objArr[51], objArr[5], objArr[48], objArr[8], objArr[20], objArr[21], objArr[34], objArr[24], objArr[28]);
        this.X0 = -1;
        this.N.setTag((Object) null);
        RelativeLayout relativeLayout = objArr[0];
        this.N0 = relativeLayout;
        relativeLayout.setTag((Object) null);
        AppCompatImageView appCompatImageView = objArr[1];
        this.O0 = appCompatImageView;
        appCompatImageView.setTag((Object) null);
        RelativeLayout relativeLayout2 = objArr[14];
        this.P0 = relativeLayout2;
        relativeLayout2.setTag((Object) null);
        AppCompatTextView appCompatTextView = objArr[15];
        this.Q0 = appCompatTextView;
        appCompatTextView.setTag((Object) null);
        LinearLayout linearLayout = objArr[3];
        this.R0 = linearLayout;
        linearLayout.setTag((Object) null);
        LinearLayout linearLayout2 = objArr[6];
        this.S0 = linearLayout2;
        linearLayout2.setTag((Object) null);
        this.Z.setTag((Object) null);
        this.f19146a0.setTag((Object) null);
        E(this.f19151f0);
        this.f19156k0.setTag((Object) null);
        this.f19157l0.setTag((Object) null);
        this.f19159n0.setTag((Object) null);
        this.f19160t0.setTag((Object) null);
        this.f19161u0.setTag((Object) null);
        this.f19164x0.setTag((Object) null);
        this.f19165y0.setTag((Object) null);
        this.A0.setTag((Object) null);
        this.B0.setTag((Object) null);
        this.D0.setTag((Object) null);
        this.F0.setTag((Object) null);
        G(view);
        this.T0 = new a(this, 3);
        this.U0 = new a(this, 4);
        this.V0 = new a(this, 1);
        this.W0 = new a(this, 2);
        t();
    }
}
