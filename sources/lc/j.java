package lc;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.lib.network.hbg.core.bean.LiveDetailBean;
import com.hbg.lib.network.hbg.core.bean.LiveSpeaker;
import com.hbg.module.content.BR;
import com.hbg.module.content.R$id;
import com.hbg.module.content.R$layout;
import com.hbg.module.content.R$string;
import com.hbg.module.content.ui.activity.live.FullScreenLiveActivity;
import com.hbg.module.libkt.utils.event.bean.LiveRedpacketBean;
import mc.a;

public class j extends i implements a.C0130a {
    public static final f.i U0;
    public static final SparseIntArray V0;
    public final LinearLayout M0;
    public final TextView N0;
    public final TextView O0;
    public final View.OnClickListener P0;
    public final View.OnClickListener Q0;
    public final View.OnClickListener R0;
    public final View.OnClickListener S0;
    public long T0;

    static {
        f.i iVar = new f.i(55);
        U0 = iVar;
        iVar.a(2, new String[]{"lay_vod_loading", "lay_live_load_error", "lay_live_tips", "lay_live_toggle"}, new int[]{19, 20, 21, 22}, new int[]{R$layout.lay_vod_loading, R$layout.lay_live_load_error, R$layout.lay_live_tips, R$layout.lay_live_toggle});
        SparseIntArray sparseIntArray = new SparseIntArray();
        V0 = sparseIntArray;
        sparseIntArray.put(R$id.llSeek, 23);
        sparseIntArray.put(R$id.ivPlayControl, 24);
        sparseIntArray.put(R$id.tvPlayTime, 25);
        sparseIntArray.put(R$id.mSeekBar, 26);
        sparseIntArray.put(R$id.tvAllTime, 27);
        sparseIntArray.put(R$id.layGiftTips, 28);
        sparseIntArray.put(R$id.largeGiftShowContainer, 29);
        sparseIntArray.put(R$id.live_large_gift_lottie, 30);
        sparseIntArray.put(R$id.llViewTop, 31);
        sparseIntArray.put(R$id.ivAvatar, 32);
        sparseIntArray.put(R$id.llNick, 33);
        sparseIntArray.put(R$id.rlGiftTop, 34);
        sparseIntArray.put(R$id.rvGiftTop, 35);
        sparseIntArray.put(R$id.liveGiftShowContainerDown, 36);
        sparseIntArray.put(R$id.liveGiftShowContainerUp, 37);
        sparseIntArray.put(R$id.vBottomShape, 38);
        sparseIntArray.put(R$id.llLiveControl, 39);
        sparseIntArray.put(R$id.lavPrimeBox, 40);
        sparseIntArray.put(R$id.lavGift, 41);
        sparseIntArray.put(R$id.clNewlistingPop, 42);
        sparseIntArray.put(R$id.ivCoin, 43);
        sparseIntArray.put(R$id.tvCoinName, 44);
        sparseIntArray.put(R$id.tvKoiTitle, 45);
        sparseIntArray.put(R$id.tvKoiAward, 46);
        sparseIntArray.put(R$id.tvJoinNow, 47);
        sparseIntArray.put(R$id.ivGroup, 48);
        sparseIntArray.put(R$id.ivShare, 49);
        sparseIntArray.put(R$id.llChart, 50);
        sparseIntArray.put(R$id.vChart, 51);
        sparseIntArray.put(R$id.ksgLike, 52);
        sparseIntArray.put(R$id.tvHint, 53);
        sparseIntArray.put(R$id.ivPraise, 54);
    }

    public j(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 55, U0, V0));
    }

    public void M(LiveDetailBean liveDetailBean) {
        this.H0 = liveDetailBean;
        synchronized (this) {
            this.T0 |= 16;
        }
        notifyPropertyChanged(BR.f17729f);
        super.B();
    }

    public void N(Integer num) {
        this.J0 = num;
        synchronized (this) {
            this.T0 |= 128;
        }
        notifyPropertyChanged(BR.f17731h);
        super.B();
    }

    public void O(FullScreenLiveActivity fullScreenLiveActivity) {
        this.G0 = fullScreenLiveActivity;
        synchronized (this) {
            this.T0 |= 512;
        }
        notifyPropertyChanged(BR.f17732i);
        super.B();
    }

    public void P(LiveRedpacketBean liveRedpacketBean) {
        this.K0 = liveRedpacketBean;
        synchronized (this) {
            this.T0 |= 32;
        }
        notifyPropertyChanged(BR.f17737n);
        super.B();
    }

    public void Q(Integer num) {
        this.L0 = num;
        synchronized (this) {
            this.T0 |= 256;
        }
        notifyPropertyChanged(BR.f17739p);
        super.B();
    }

    public void R(LiveSpeaker liveSpeaker) {
        this.I0 = liveSpeaker;
        synchronized (this) {
            this.T0 |= 64;
        }
        notifyPropertyChanged(BR.f17741r);
        super.B();
    }

    public final boolean S(o6 o6Var, int i11) {
        if (i11 != BR.f17724a) {
            return false;
        }
        synchronized (this) {
            this.T0 |= 1;
        }
        return true;
    }

    public final boolean T(g6 g6Var, int i11) {
        if (i11 != BR.f17724a) {
            return false;
        }
        synchronized (this) {
            this.T0 |= 8;
        }
        return true;
    }

    public final boolean U(k6 k6Var, int i11) {
        if (i11 != BR.f17724a) {
            return false;
        }
        synchronized (this) {
            this.T0 |= 4;
        }
        return true;
    }

    public final boolean V(m6 m6Var, int i11) {
        if (i11 != BR.f17724a) {
            return false;
        }
        synchronized (this) {
            this.T0 |= 2;
        }
        return true;
    }

    public final void a(int i11, View view) {
        boolean z11 = false;
        if (i11 == 1) {
            FullScreenLiveActivity fullScreenLiveActivity = this.G0;
            if (fullScreenLiveActivity != null) {
                z11 = true;
            }
            if (z11) {
                fullScreenLiveActivity.finish();
            }
        } else if (i11 == 2) {
            FullScreenLiveActivity fullScreenLiveActivity2 = this.G0;
            if (fullScreenLiveActivity2 != null) {
                z11 = true;
            }
            if (z11) {
                fullScreenLiveActivity2.Sh();
            }
        } else if (i11 == 3) {
            FullScreenLiveActivity fullScreenLiveActivity3 = this.G0;
            if (fullScreenLiveActivity3 != null) {
                z11 = true;
            }
            if (z11) {
                fullScreenLiveActivity3.ei();
            }
        } else if (i11 == 4) {
            FullScreenLiveActivity fullScreenLiveActivity4 = this.G0;
            if (fullScreenLiveActivity4 != null) {
                z11 = true;
            }
            if (z11) {
                fullScreenLiveActivity4.gi();
            }
        }
    }

    public void i() {
        long j11;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        int i11;
        String str9;
        int i12;
        int i13;
        int i14;
        String str10;
        int i15;
        int i16;
        int i17;
        synchronized (this) {
            j11 = this.T0;
            this.T0 = 0;
        }
        LiveDetailBean liveDetailBean = this.H0;
        LiveRedpacketBean liveRedpacketBean = this.K0;
        LiveSpeaker liveSpeaker = this.I0;
        Integer num = this.J0;
        Integer num2 = this.L0;
        if ((j11 & 1040) != 0) {
            if (liveDetailBean != null) {
                i16 = liveDetailBean.fansNum;
                str = liveDetailBean.coverImageUrl;
                str2 = liveDetailBean.onlineNum;
                i17 = liveDetailBean.praiseNum;
            } else {
                i17 = 0;
                i16 = 0;
                str2 = null;
                str = null;
            }
            str4 = i17 + "";
            str3 = this.O0.getResources().getString(R$string.n_live_anchor_fans_num, new Object[]{i16 + ""});
        } else {
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
        }
        if ((j11 & 1056) == 0 || liveRedpacketBean == null) {
            str7 = null;
            str6 = null;
            str5 = null;
        } else {
            str7 = liveRedpacketBean.getCurrency();
            String amountStr = liveRedpacketBean.getAmountStr();
            str6 = liveRedpacketBean.getCountdown();
            str5 = amountStr;
        }
        int i18 = ((j11 & 1088) > 0 ? 1 : ((j11 & 1088) == 0 ? 0 : -1));
        if (i18 != 0) {
            if (liveSpeaker != null) {
                i15 = liveSpeaker.focusStatus;
                str10 = liveSpeaker.nickname;
            } else {
                i15 = 0;
                str10 = null;
            }
            boolean z11 = i15 == 0;
            if (i18 != 0) {
                j11 |= z11 ? 65536 : 32768;
            }
            i11 = z11 ? 0 : 8;
            str8 = str10;
        } else {
            i11 = 0;
            str8 = null;
        }
        int i19 = ((j11 & 1152) > 0 ? 1 : ((j11 & 1152) == 0 ? 0 : -1));
        if (i19 != 0) {
            int C = f.C(num);
            str9 = str8;
            boolean z12 = C == 3;
            boolean z13 = C == 2;
            if (i19 != 0) {
                j11 |= z12 ? 16384 : 8192;
            }
            if ((j11 & 1152) != 0) {
                j11 |= z13 ? 4096 : 2048;
            }
            i12 = z12 ? 0 : 8;
            i13 = z13 ? 0 : 8;
        } else {
            str9 = str8;
            i13 = 0;
            i12 = 0;
        }
        int i21 = ((j11 & 1280) > 0 ? 1 : ((j11 & 1280) == 0 ? 0 : -1));
        if (i21 != 0) {
            boolean z14 = f.C(num2) == 1;
            if (i21 != 0) {
                j11 |= z14 ? PlaybackStateCompat.ACTION_SET_REPEAT_MODE : 131072;
            }
            i14 = z14 ? 0 : 8;
        } else {
            i14 = 0;
        }
        if ((j11 & 1152) != 0) {
            this.C.setVisibility(i13);
            this.f19178f0.setVisibility(i13);
            this.F0.setVisibility(i12);
        }
        if ((1024 & j11) != 0) {
            this.E.setOnClickListener(this.R0);
            this.L.setOnClickListener(this.Q0);
            this.f19193z0.setOnClickListener(this.S0);
            this.B0.setOnClickListener(this.P0);
        }
        if ((1040 & j11) != 0) {
            he.b.f(this.H, str);
            TextViewBindingAdapter.c(this.O0, str3);
            he.b.m(this.f19192y0, str4);
            he.b.m(this.C0, str2);
        }
        if ((1056 & j11) != 0) {
            TextViewBindingAdapter.c(this.N0, str7);
            TextViewBindingAdapter.c(this.f19182j0, str5);
            TextViewBindingAdapter.c(this.f19183k0, str6);
        }
        if ((j11 & 1088) != 0) {
            this.f19181i0.setVisibility(i11);
            this.f19190w0.setVisibility(i11);
            TextViewBindingAdapter.c(this.A0, str9);
        }
        if ((j11 & 1280) != 0) {
            this.f19183k0.setVisibility(i14);
        }
        f.k(this.R);
        f.k(this.S);
        f.k(this.T);
        f.k(this.U);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r4.S.r() == false) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
        if (r4.T.r() == false) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002e, code lost:
        if (r4.U.r() == false) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0030, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0031, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r4.R.r() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean r() {
        /*
            r4 = this;
            monitor-enter(r4)
            long r0 = r4.T0     // Catch:{ all -> 0x0033 }
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 1
            if (r0 == 0) goto L_0x000c
            monitor-exit(r4)     // Catch:{ all -> 0x0033 }
            return r1
        L_0x000c:
            monitor-exit(r4)     // Catch:{ all -> 0x0033 }
            lc.o6 r0 = r4.R
            boolean r0 = r0.r()
            if (r0 == 0) goto L_0x0016
            return r1
        L_0x0016:
            lc.g6 r0 = r4.S
            boolean r0 = r0.r()
            if (r0 == 0) goto L_0x001f
            return r1
        L_0x001f:
            lc.k6 r0 = r4.T
            boolean r0 = r0.r()
            if (r0 == 0) goto L_0x0028
            return r1
        L_0x0028:
            lc.m6 r0 = r4.U
            boolean r0 = r0.r()
            if (r0 == 0) goto L_0x0031
            return r1
        L_0x0031:
            r0 = 0
            return r0
        L_0x0033:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0033 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: lc.j.r():boolean");
    }

    public void t() {
        synchronized (this) {
            this.T0 = 1024;
        }
        this.R.t();
        this.S.t();
        this.T.t();
        this.U.t();
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        if (i11 == 0) {
            return S((o6) obj, i12);
        }
        if (i11 == 1) {
            return V((m6) obj, i12);
        }
        if (i11 == 2) {
            return U((k6) obj, i12);
        }
        if (i11 != 3) {
            return false;
        }
        return T((g6) obj, i12);
    }

    public j(b bVar, View view, Object[] objArr) {
        super(bVar, view, 4, objArr[42], objArr[15], objArr[32], objArr[3], objArr[43], objArr[48], objArr[1], objArr[24], objArr[54], objArr[49], objArr[13], objArr[52], objArr[29], objArr[41], objArr[40], objArr[28], objArr[19], objArr[20], objArr[21], objArr[22], objArr[36], objArr[37], objArr[30], objArr[50], objArr[39], objArr[33], objArr[23], objArr[31], objArr[26], objArr[34], objArr[17], objArr[2], objArr[35], objArr[7], objArr[10], objArr[12], objArr[27], objArr[44], objArr[53], objArr[47], objArr[46], objArr[45], objArr[6], objArr[25], objArr[18], objArr[9], objArr[4], objArr[14], objArr[8], objArr[38], objArr[51], objArr[16]);
        this.T0 = -1;
        this.C.setTag((Object) null);
        this.E.setTag((Object) null);
        this.H.setTag((Object) null);
        this.L.setTag((Object) null);
        E(this.R);
        E(this.S);
        E(this.T);
        E(this.U);
        LinearLayout linearLayout = objArr[0];
        this.M0 = linearLayout;
        linearLayout.setTag((Object) null);
        TextView textView = objArr[11];
        this.N0 = textView;
        textView.setTag((Object) null);
        TextView textView2 = objArr[5];
        this.O0 = textView2;
        textView2.setTag((Object) null);
        this.f19178f0.setTag((Object) null);
        this.f19179g0.setTag((Object) null);
        this.f19181i0.setTag((Object) null);
        this.f19182j0.setTag((Object) null);
        this.f19183k0.setTag((Object) null);
        this.f19190w0.setTag((Object) null);
        this.f19192y0.setTag((Object) null);
        this.f19193z0.setTag((Object) null);
        this.A0.setTag((Object) null);
        this.B0.setTag((Object) null);
        this.C0.setTag((Object) null);
        this.F0.setTag((Object) null);
        G(view);
        this.P0 = new a(this, 4);
        this.Q0 = new a(this, 3);
        this.R0 = new a(this, 1);
        this.S0 = new a(this, 2);
        t();
    }
}
