package lc;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.b;
import androidx.databinding.f;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.common.math.DoubleMath;
import com.google.zxing.oned.Code39Reader;
import com.hbg.lib.network.hbg.core.bean.LiveDetailBean;
import com.hbg.lib.network.hbg.core.bean.LiveGroup;
import com.hbg.lib.network.hbg.core.bean.LiveSpeaker;
import com.hbg.lib.widgets.SafeLottieView;
import com.hbg.module.content.BR;
import com.hbg.module.content.R$id;
import com.hbg.module.content.R$layout;
import com.hbg.module.content.ui.activity.live.LiveDetailActivity;
import com.hbg.module.libkt.utils.event.bean.LiveRedpacketBean;
import com.tencent.thumbplayer.tcmedia.api.TPOptionalID;
import com.tencent.thumbplayer.tcmedia.core.common.TPPixelFormat;
import mc.a;
import org.jmrtd.cbeff.ISO781611;

public class n extends m implements a.C0130a {
    public static final f.i O3;
    public static final SparseIntArray P3;
    public final View.OnClickListener A3;
    public final View.OnClickListener B3;
    public final View.OnClickListener C3;
    public final View.OnClickListener D3;
    public final View.OnClickListener E3;
    public final View.OnClickListener F3;
    public final View.OnClickListener G3;
    public final View.OnClickListener H3;
    public final View.OnClickListener I3;
    public final View.OnClickListener J3;
    public final View.OnClickListener K3;
    public final View.OnClickListener L3;
    public final View.OnClickListener M3;
    public long N3;
    public final FrameLayout Z2;

    /* renamed from: a3  reason: collision with root package name */
    public final RelativeLayout f19270a3;

    /* renamed from: b3  reason: collision with root package name */
    public final RelativeLayout f19271b3;

    /* renamed from: c3  reason: collision with root package name */
    public final SafeLottieView f19272c3;

    /* renamed from: d3  reason: collision with root package name */
    public final TextView f19273d3;

    /* renamed from: e3  reason: collision with root package name */
    public final TextView f19274e3;

    /* renamed from: f3  reason: collision with root package name */
    public final TextView f19275f3;

    /* renamed from: g3  reason: collision with root package name */
    public final ImageView f19276g3;

    /* renamed from: h3  reason: collision with root package name */
    public final TextView f19277h3;

    /* renamed from: i3  reason: collision with root package name */
    public final TextView f19278i3;

    /* renamed from: j3  reason: collision with root package name */
    public final RelativeLayout f19279j3;

    /* renamed from: k3  reason: collision with root package name */
    public final ImageView f19280k3;

    /* renamed from: l3  reason: collision with root package name */
    public final AppCompatImageView f19281l3;

    /* renamed from: m3  reason: collision with root package name */
    public final TextView f19282m3;

    /* renamed from: n3  reason: collision with root package name */
    public final TextView f19283n3;

    /* renamed from: o3  reason: collision with root package name */
    public final ImageView f19284o3;

    /* renamed from: p3  reason: collision with root package name */
    public final TextView f19285p3;

    /* renamed from: q3  reason: collision with root package name */
    public final ImageView f19286q3;

    /* renamed from: r3  reason: collision with root package name */
    public final TextView f19287r3;

    /* renamed from: s3  reason: collision with root package name */
    public final TextView f19288s3;

    /* renamed from: t3  reason: collision with root package name */
    public final View.OnClickListener f19289t3;

    /* renamed from: u3  reason: collision with root package name */
    public final View.OnClickListener f19290u3;

    /* renamed from: v3  reason: collision with root package name */
    public final View.OnClickListener f19291v3;

    /* renamed from: w3  reason: collision with root package name */
    public final View.OnClickListener f19292w3;

    /* renamed from: x3  reason: collision with root package name */
    public final View.OnClickListener f19293x3;

    /* renamed from: y3  reason: collision with root package name */
    public final View.OnClickListener f19294y3;

    /* renamed from: z3  reason: collision with root package name */
    public final View.OnClickListener f19295z3;

    static {
        f.i iVar = new f.i(187);
        O3 = iVar;
        iVar.a(1, new String[]{"error_live"}, new int[]{70}, new int[]{R$layout.error_live});
        int i11 = R$layout.lay_chart_group;
        iVar.a(2, new String[]{"lay_chart_group"}, new int[]{63}, new int[]{i11});
        int i12 = R$layout.view_countdown;
        iVar.a(3, new String[]{"view_countdown", "view_countdown"}, new int[]{61, 62}, new int[]{i12, i12});
        iVar.a(32, new String[]{"lay_vod_loading", "lay_live_load_error", "lay_live_tips", "lay_live_toggle", "layout_live_finish_recommend"}, new int[]{64, 65, 66, 67, 68}, new int[]{R$layout.lay_vod_loading, R$layout.lay_live_load_error, R$layout.lay_live_tips, R$layout.lay_live_toggle, R$layout.layout_live_finish_recommend});
        iVar.a(37, new String[]{"lay_chart_group"}, new int[]{69}, new int[]{i11});
        SparseIntArray sparseIntArray = new SparseIntArray();
        P3 = sparseIntArray;
        sparseIntArray.put(R$id.rlZoomBg, 71);
        sparseIntArray.put(R$id.ivAppointmentBg, 72);
        sparseIntArray.put(R$id.vAppointmentFg, 73);
        sparseIntArray.put(R$id.hzSv, 74);
        sparseIntArray.put(R$id.rlAppointTop, 75);
        sparseIntArray.put(R$id.ivAppointmentAvatar, 76);
        sparseIntArray.put(R$id.tvAuthorTitle, 77);
        sparseIntArray.put(R$id.rvDesc, 78);
        sparseIntArray.put(R$id.llAppointmentBar, 79);
        sparseIntArray.put(R$id.vTopBarAppointment, 80);
        sparseIntArray.put(R$id.ivAppointAvatar, 81);
        sparseIntArray.put(R$id.slvAttention, 82);
        sparseIntArray.put(R$id.txAppointment, 83);
        sparseIntArray.put(R$id.ivAppointmentVideoPlay, 84);
        sparseIntArray.put(R$id.llLiving, 85);
        sparseIntArray.put(R$id.vTopBar, 86);
        sparseIntArray.put(R$id.ivAvatar, 87);
        sparseIntArray.put(R$id.llNick, 88);
        sparseIntArray.put(R$id.rlGiftTop, 89);
        sparseIntArray.put(R$id.rvGiftTop, 90);
        sparseIntArray.put(R$id.llLiveNotice, 91);
        sparseIntArray.put(R$id.tvLiveNotice, 92);
        sparseIntArray.put(R$id.vBottomShape, 93);
        sparseIntArray.put(R$id.llSeek, 94);
        sparseIntArray.put(R$id.ivPlayControl, 95);
        sparseIntArray.put(R$id.tvPlayTime, 96);
        sparseIntArray.put(R$id.mSeekBar, 97);
        sparseIntArray.put(R$id.tvAllTime, 98);
        sparseIntArray.put(R$id.llFullControl, 99);
        sparseIntArray.put(R$id.liveGiftShowContainer, 100);
        sparseIntArray.put(R$id.liveGiftShowContainerUp, 101);
        sparseIntArray.put(R$id.liveGiftShowContainerDown, 102);
        sparseIntArray.put(R$id.vLocationView, 103);
        sparseIntArray.put(R$id.flReplayRoot, 104);
        sparseIntArray.put(R$id.ivReplay, 105);
        sparseIntArray.put(R$id.tvReplay, 106);
        sparseIntArray.put(R$id.ivPos, 107);
        sparseIntArray.put(R$id.vChart, 108);
        sparseIntArray.put(R$id.clNewlistingPop, 109);
        sparseIntArray.put(R$id.ivCoin, 110);
        sparseIntArray.put(R$id.tvCoinName, 111);
        sparseIntArray.put(R$id.tvKoiTitle, 112);
        sparseIntArray.put(R$id.tvKoiAward, 113);
        sparseIntArray.put(R$id.tvJoinNow, 114);
        sparseIntArray.put(R$id.ksgLike, 115);
        sparseIntArray.put(R$id.llActiveFloat, 116);
        sparseIntArray.put(R$id.ivActivePic, 117);
        sparseIntArray.put(R$id.tvActiveTitle, 118);
        sparseIntArray.put(R$id.layLiveGiftFloat, 119);
        sparseIntArray.put(R$id.ivCopyTrader, 120);
        sparseIntArray.put(R$id.lavPrimeBox, 121);
        sparseIntArray.put(R$id.tvHint, 122);
        sparseIntArray.put(R$id.llBottomControl, 123);
        sparseIntArray.put(R$id.ivPraise, 124);
        sparseIntArray.put(R$id.tvTips, 125);
        sparseIntArray.put(R$id.tvRedpacketTipsAvatar, 126);
        sparseIntArray.put(R$id.tvRedpacketTipsText, 127);
        sparseIntArray.put(R$id.tvRedpacketArrowDown, 128);
        sparseIntArray.put(R$id.llRecommendTrader, 129);
        sparseIntArray.put(R$id.ivTraderAvatar, 130);
        sparseIntArray.put(R$id.tvTraderName, 131);
        sparseIntArray.put(R$id.tvWinRate, 132);
        sparseIntArray.put(R$id.tvTotalProfit, 133);
        sparseIntArray.put(R$id.tvCopyUserNum, 134);
        sparseIntArray.put(R$id.rlCopy, 135);
        sparseIntArray.put(R$id.live_notice_view, 136);
        sparseIntArray.put(R$id.iv_live_playing, 137);
        sparseIntArray.put(R$id.tv_notice_content, 138);
        sparseIntArray.put(R$id.tv_jump, 139);
        sparseIntArray.put(R$id.iv_close, 140);
        sparseIntArray.put(R$id.iv_icon, TPOptionalID.OPTION_ID_BEFORE_QUEUE_INT_SPECIAL_SEI_TYPES_CALLBACK);
        sparseIntArray.put(R$id.rlCombo, 142);
        sparseIntArray.put(R$id.lavCombo, TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_ORIGINAL_VIDEO_INFO_CALLBACK_FROM_SURFACE_LISTENER);
        sparseIntArray.put(R$id.ivGiftPng, 144);
        sparseIntArray.put(R$id.llComboNum, 145);
        sparseIntArray.put(R$id.ivComboOne, TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_IGNORE_VIDEO_STREAM_IN_COMMON_AUDIO_FORMATS);
        sparseIntArray.put(R$id.ivComboTwo, 147);
        sparseIntArray.put(R$id.layMoreLive, Code39Reader.ASTERISK_ENCODING);
        sparseIntArray.put(R$id.vMoreLiveBg, 149);
        sparseIntArray.put(R$id.ivMoreLiveIcon, 150);
        sparseIntArray.put(R$id.tvMoreLiveTips, 151);
        sparseIntArray.put(R$id.tvJumpMoreLive, 152);
        sparseIntArray.put(R$id.clGiftPanel, 153);
        sparseIntArray.put(R$id.vTopEmpty, 154);
        sparseIntArray.put(R$id.clSisterGroup, 155);
        sparseIntArray.put(R$id.tvSisterTips, 156);
        sparseIntArray.put(R$id.rvSisters, 157);
        sparseIntArray.put(R$id.llSisterSlideBtn, ISO781611.SMT_DO_DS);
        sparseIntArray.put(R$id.vLeftSpace, 159);
        sparseIntArray.put(R$id.tvSelAll, 160);
        sparseIntArray.put(R$id.vRightSpace, 161);
        sparseIntArray.put(R$id.llIntegral, 162);
        sparseIntArray.put(R$id.ivIntegralIcon, 163);
        sparseIntArray.put(R$id.tvIntegralGiftName, 164);
        sparseIntArray.put(R$id.tvIntegralGiftDesc, 165);
        sparseIntArray.put(R$id.cProgress, 166);
        sparseIntArray.put(R$id.llIntegralCoinNum, TPPixelFormat.TP_PIX_FMT_MEDIACODEC);
        sparseIntArray.put(R$id.tvIntegralCoinNum, HashUtils.SECURE_HASH_ALGORITHM_KECCAK_128_RATE);
        sparseIntArray.put(R$id.ivLockStatus, 169);
        sparseIntArray.put(R$id.llNormalGift, DoubleMath.MAX_FACTORIAL);
        sparseIntArray.put(R$id.ivNormalGift, 171);
        sparseIntArray.put(R$id.tvNormalGiftName, 172);
        sparseIntArray.put(R$id.tvNormalGiftDesc, 173);
        sparseIntArray.put(R$id.tvGetGift, 174);
        sparseIntArray.put(R$id.ivGetGift, HideBottomViewOnScrollBehavior.EXIT_ANIMATION_DURATION);
        sparseIntArray.put(R$id.vLine, 176);
        sparseIntArray.put(R$id.coIndicator, 177);
        sparseIntArray.put(R$id.vpGift, 178);
        sparseIntArray.put(R$id.bottomGradient, 179);
        sparseIntArray.put(R$id.rlUserAssets, 180);
        sparseIntArray.put(R$id.tvSisterPop, 181);
        sparseIntArray.put(R$id.ivGiftAnim, 182);
        sparseIntArray.put(R$id.llLoadingEmptyBack, 183);
        sparseIntArray.put(R$id.vLoadingTopBar, 184);
        sparseIntArray.put(R$id.groupUserView, 185);
        sparseIntArray.put(R$id.tvRedpacketSendContent, 186);
    }

    public n(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 187, O3, P3));
    }

    public void M(LiveDetailBean liveDetailBean) {
        this.S2 = liveDetailBean;
        synchronized (this) {
            this.N3 |= 4096;
        }
        notifyPropertyChanged(BR.f17729f);
        super.B();
    }

    public void N(LiveGroup liveGroup) {
        this.U2 = liveGroup;
        synchronized (this) {
            this.N3 |= 65536;
        }
        notifyPropertyChanged(BR.f17730g);
        super.B();
    }

    public void O(Integer num) {
        this.V2 = num;
        synchronized (this) {
            this.N3 |= 8192;
        }
        notifyPropertyChanged(BR.f17731h);
        super.B();
    }

    public void P(LiveDetailActivity liveDetailActivity) {
        this.R2 = liveDetailActivity;
        synchronized (this) {
            this.N3 |= 2048;
        }
        notifyPropertyChanged(BR.f17732i);
        super.B();
    }

    public void Q(LiveRedpacketBean liveRedpacketBean) {
        this.X2 = liveRedpacketBean;
        synchronized (this) {
            this.N3 |= 16384;
        }
        notifyPropertyChanged(BR.f17737n);
        super.B();
    }

    public void R(Integer num) {
        this.W2 = num;
        synchronized (this) {
            this.N3 |= 1024;
        }
        notifyPropertyChanged(BR.f17738o);
        super.B();
    }

    public void S(Integer num) {
        this.Y2 = num;
        synchronized (this) {
            this.N3 |= 131072;
        }
        notifyPropertyChanged(BR.f17739p);
        super.B();
    }

    public void T(LiveSpeaker liveSpeaker) {
        this.T2 = liveSpeaker;
        synchronized (this) {
            this.N3 |= 32768;
        }
        notifyPropertyChanged(BR.f17741r);
        super.B();
    }

    public final boolean U(a7 a7Var, int i11) {
        if (i11 != BR.f17724a) {
            return false;
        }
        synchronized (this) {
            this.N3 |= 512;
        }
        return true;
    }

    public final boolean V(a7 a7Var, int i11) {
        if (i11 != BR.f17724a) {
            return false;
        }
        synchronized (this) {
            this.N3 |= 4;
        }
        return true;
    }

    public final boolean W(e6 e6Var, int i11) {
        if (i11 != BR.f17724a) {
            return false;
        }
        synchronized (this) {
            this.N3 |= 128;
        }
        return true;
    }

    public final boolean X(u0 u0Var, int i11) {
        if (i11 != BR.f17724a) {
            return false;
        }
        synchronized (this) {
            this.N3 |= 16;
        }
        return true;
    }

    public final boolean Y(e6 e6Var, int i11) {
        if (i11 != BR.f17724a) {
            return false;
        }
        synchronized (this) {
            this.N3 |= 256;
        }
        return true;
    }

    public final boolean Z(o6 o6Var, int i11) {
        if (i11 != BR.f17724a) {
            return false;
        }
        synchronized (this) {
            this.N3 |= 32;
        }
        return true;
    }

    public final void a(int i11, View view) {
        boolean z11 = true;
        switch (i11) {
            case 1:
                LiveDetailActivity liveDetailActivity = this.R2;
                if (liveDetailActivity == null) {
                    z11 = false;
                }
                if (z11) {
                    liveDetailActivity.finish();
                    return;
                }
                return;
            case 2:
                LiveDetailActivity liveDetailActivity2 = this.R2;
                if (liveDetailActivity2 == null) {
                    z11 = false;
                }
                if (z11) {
                    liveDetailActivity2.Dl();
                    return;
                }
                return;
            case 3:
                LiveDetailActivity liveDetailActivity3 = this.R2;
                if (liveDetailActivity3 == null) {
                    z11 = false;
                }
                if (z11) {
                    liveDetailActivity3.Lj();
                    return;
                }
                return;
            case 4:
                LiveDetailActivity liveDetailActivity4 = this.R2;
                if (liveDetailActivity4 == null) {
                    z11 = false;
                }
                if (z11) {
                    liveDetailActivity4.Rl();
                    return;
                }
                return;
            case 5:
                LiveDetailActivity liveDetailActivity5 = this.R2;
                if (liveDetailActivity5 == null) {
                    z11 = false;
                }
                if (z11) {
                    liveDetailActivity5.Aj();
                    return;
                }
                return;
            case 6:
                LiveDetailActivity liveDetailActivity6 = this.R2;
                if (liveDetailActivity6 == null) {
                    z11 = false;
                }
                if (z11) {
                    liveDetailActivity6.Vl();
                    return;
                }
                return;
            case 7:
                LiveDetailActivity liveDetailActivity7 = this.R2;
                if (liveDetailActivity7 == null) {
                    z11 = false;
                }
                if (z11) {
                    liveDetailActivity7.Zl();
                    return;
                }
                return;
            case 8:
                LiveDetailActivity liveDetailActivity8 = this.R2;
                if (liveDetailActivity8 == null) {
                    z11 = false;
                }
                if (z11) {
                    liveDetailActivity8.ak();
                    return;
                }
                return;
            case 9:
                LiveDetailActivity liveDetailActivity9 = this.R2;
                if (liveDetailActivity9 == null) {
                    z11 = false;
                }
                if (z11) {
                    liveDetailActivity9.sl();
                    return;
                }
                return;
            case 10:
                LiveDetailActivity liveDetailActivity10 = this.R2;
                if (liveDetailActivity10 == null) {
                    z11 = false;
                }
                if (z11) {
                    liveDetailActivity10.Dl();
                    return;
                }
                return;
            case 11:
                LiveDetailActivity liveDetailActivity11 = this.R2;
                if (liveDetailActivity11 == null) {
                    z11 = false;
                }
                if (z11) {
                    liveDetailActivity11.Dl();
                    return;
                }
                return;
            case 12:
                LiveDetailActivity liveDetailActivity12 = this.R2;
                if (liveDetailActivity12 == null) {
                    z11 = false;
                }
                if (z11) {
                    liveDetailActivity12.Al();
                    return;
                }
                return;
            case 13:
                LiveDetailActivity liveDetailActivity13 = this.R2;
                if (liveDetailActivity13 == null) {
                    z11 = false;
                }
                if (z11) {
                    liveDetailActivity13.Ll();
                    return;
                }
                return;
            case 14:
                LiveDetailActivity liveDetailActivity14 = this.R2;
                if (liveDetailActivity14 == null) {
                    z11 = false;
                }
                if (z11) {
                    liveDetailActivity14.Ll();
                    return;
                }
                return;
            case 15:
                LiveDetailActivity liveDetailActivity15 = this.R2;
                if (liveDetailActivity15 == null) {
                    z11 = false;
                }
                if (z11) {
                    liveDetailActivity15.Ll();
                    return;
                }
                return;
            case 16:
                LiveDetailActivity liveDetailActivity16 = this.R2;
                if (liveDetailActivity16 == null) {
                    z11 = false;
                }
                if (z11) {
                    liveDetailActivity16.Al();
                    return;
                }
                return;
            case 17:
                LiveDetailActivity liveDetailActivity17 = this.R2;
                if (liveDetailActivity17 == null) {
                    z11 = false;
                }
                if (z11) {
                    liveDetailActivity17.Cj();
                    return;
                }
                return;
            case 18:
                LiveDetailActivity liveDetailActivity18 = this.R2;
                if (liveDetailActivity18 == null) {
                    z11 = false;
                }
                if (z11) {
                    liveDetailActivity18.jl();
                    return;
                }
                return;
            case 19:
                LiveDetailActivity liveDetailActivity19 = this.R2;
                if (liveDetailActivity19 == null) {
                    z11 = false;
                }
                if (z11) {
                    liveDetailActivity19.finish();
                    return;
                }
                return;
            case 20:
                LiveDetailActivity liveDetailActivity20 = this.R2;
                if (liveDetailActivity20 == null) {
                    z11 = false;
                }
                if (z11) {
                    liveDetailActivity20.Dj();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final boolean a0(g6 g6Var, int i11) {
        if (i11 != BR.f17724a) {
            return false;
        }
        synchronized (this) {
            this.N3 |= 8;
        }
        return true;
    }

    public final boolean b0(k6 k6Var, int i11) {
        if (i11 != BR.f17724a) {
            return false;
        }
        synchronized (this) {
            this.N3 |= 1;
        }
        return true;
    }

    public final boolean c0(m6 m6Var, int i11) {
        if (i11 != BR.f17724a) {
            return false;
        }
        synchronized (this) {
            this.N3 |= 64;
        }
        return true;
    }

    public final boolean d0(u6 u6Var, int i11) {
        if (i11 != BR.f17724a) {
            return false;
        }
        synchronized (this) {
            this.N3 |= 2;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x02ca  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x032d  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0364  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x039e  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x03b2  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x03cf  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x03da  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x03dd  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x03e5  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x03f7  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x0402  */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x0427  */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x0431  */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x0447  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x0450  */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x04f4  */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x0500  */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x05db  */
    /* JADX WARNING: Removed duplicated region for block: B:231:0x05e8  */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x05fc  */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x0609  */
    /* JADX WARNING: Removed duplicated region for block: B:240:0x0620  */
    /* JADX WARNING: Removed duplicated region for block: B:243:0x0651  */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x066c  */
    /* JADX WARNING: Removed duplicated region for block: B:249:0x067c  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0291  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void i() {
        /*
            r61 = this;
            r1 = r61
            monitor-enter(r61)
            long r2 = r1.N3     // Catch:{ all -> 0x06b6 }
            r4 = 0
            r1.N3 = r4     // Catch:{ all -> 0x06b6 }
            monitor-exit(r61)     // Catch:{ all -> 0x06b6 }
            java.lang.Integer r0 = r1.W2
            com.hbg.module.content.ui.activity.live.LiveDetailActivity r6 = r1.R2
            com.hbg.lib.network.hbg.core.bean.LiveDetailBean r7 = r1.S2
            java.lang.Integer r8 = r1.V2
            com.hbg.module.libkt.utils.event.bean.LiveRedpacketBean r9 = r1.X2
            com.hbg.lib.network.hbg.core.bean.LiveSpeaker r10 = r1.T2
            com.hbg.lib.network.hbg.core.bean.LiveGroup r11 = r1.U2
            java.lang.Integer r12 = r1.Y2
            r13 = 263168(0x40400, double:1.300223E-318)
            long r15 = r2 & r13
            int r15 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            r16 = 8
            r13 = 1
            if (r15 == 0) goto L_0x003e
            int r0 = androidx.databinding.f.C(r0)
            if (r0 != r13) goto L_0x002e
            r0 = r13
            goto L_0x002f
        L_0x002e:
            r0 = 0
        L_0x002f:
            if (r15 == 0) goto L_0x003c
            if (r0 == 0) goto L_0x0037
            r17 = 4194304(0x400000, double:2.0722615E-317)
            goto L_0x003a
        L_0x0037:
            r17 = 2097152(0x200000, double:1.0361308E-317)
        L_0x003a:
            long r2 = r2 | r17
        L_0x003c:
            if (r0 == 0) goto L_0x0040
        L_0x003e:
            r0 = 0
            goto L_0x0042
        L_0x0040:
            r0 = r16
        L_0x0042:
            r17 = 266240(0x41000, double:1.3154E-318)
            long r19 = r2 & r17
            int r15 = (r19 > r4 ? 1 : (r19 == r4 ? 0 : -1))
            r20 = 35184372088832(0x200000000000, double:1.73833895195875E-310)
            r22 = 0
            if (r15 == 0) goto L_0x0291
            if (r7 == 0) goto L_0x008a
            java.lang.String r4 = r7.coverImageUrl
            int r5 = r7.appointedNum
            java.lang.String r14 = r7.backgroundUrl
            java.lang.String r13 = r7.coverVideoUrl
            r26 = r4
            java.lang.String r4 = r7.onlineNum
            r27 = r4
            int r4 = r7.praiseNum
            r28 = r4
            int r4 = r7.fansNum
            r29 = r4
            int r4 = r7.redpacketStatus
            r30 = r4
            java.lang.String r4 = r7.title
            r31 = r4
            int r4 = r7.appointed
            r32 = r4
            int r4 = r7.status
            r33 = r7
            r60 = r28
            r28 = r0
            r0 = r29
            r29 = r6
            r6 = r30
            r30 = r11
            r11 = r4
            r4 = r60
            goto L_0x00a2
        L_0x008a:
            r28 = r0
            r29 = r6
            r33 = r7
            r30 = r11
            r13 = r22
            r14 = r13
            r26 = r14
            r27 = r26
            r31 = r27
            r0 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r11 = 0
            r32 = 0
        L_0x00a2:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r5)
            java.lang.String r5 = ""
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            boolean r7 = com.hbg.module.libkt.base.ext.b.x(r14)
            boolean r13 = com.hbg.module.libkt.base.ext.b.x(r13)
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r14.append(r4)
            java.lang.String r4 = ""
            r14.append(r4)
            java.lang.String r4 = r14.toString()
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r14.append(r0)
            java.lang.String r0 = ""
            r14.append(r0)
            java.lang.String r0 = r14.toString()
            r14 = 1
            if (r6 != r14) goto L_0x00e2
            r6 = 1
            goto L_0x00e3
        L_0x00e2:
            r6 = 0
        L_0x00e3:
            if (r32 != 0) goto L_0x00ea
            r32 = r4
            r4 = 3
            r14 = 1
            goto L_0x00ee
        L_0x00ea:
            r32 = r4
            r4 = 3
            r14 = 0
        L_0x00ee:
            if (r11 != r4) goto L_0x00f2
            r4 = 1
            goto L_0x00f3
        L_0x00f2:
            r4 = 0
        L_0x00f3:
            if (r15 == 0) goto L_0x00fe
            if (r13 == 0) goto L_0x00fa
            r34 = 18014398509481984(0x40000000000000, double:1.7800590868057611E-307)
            goto L_0x00fc
        L_0x00fa:
            r34 = 9007199254740992(0x20000000000000, double:4.450147717014403E-308)
        L_0x00fc:
            long r2 = r2 | r34
        L_0x00fe:
            long r34 = r2 & r17
            r23 = 0
            int r11 = (r34 > r23 ? 1 : (r34 == r23 ? 0 : -1))
            if (r11 == 0) goto L_0x0112
            if (r6 == 0) goto L_0x010b
            r34 = 281474976710656(0x1000000000000, double:1.390671161567E-309)
            goto L_0x0110
        L_0x010b:
            r34 = 140737488355328(0x800000000000, double:6.953355807835E-310)
        L_0x0110:
            long r2 = r2 | r34
        L_0x0112:
            long r34 = r2 & r17
            int r11 = (r34 > r23 ? 1 : (r34 == r23 ? 0 : -1))
            if (r11 == 0) goto L_0x0173
            if (r14 == 0) goto L_0x0146
            r34 = 1048576(0x100000, double:5.180654E-318)
            long r2 = r2 | r34
            r34 = 16777216(0x1000000, double:8.289046E-317)
            long r2 = r2 | r34
            r34 = 4294967296(0x100000000, double:2.121995791E-314)
            long r2 = r2 | r34
            r34 = 68719476736(0x1000000000, double:3.39519326554E-313)
            long r2 = r2 | r34
            r34 = 274877906944(0x4000000000, double:1.358077306218E-312)
            long r2 = r2 | r34
            r34 = 4398046511104(0x40000000000, double:2.1729236899484E-311)
            long r2 = r2 | r34
            r34 = 17592186044416(0x100000000000, double:8.6916947597938E-311)
            goto L_0x0171
        L_0x0146:
            r34 = 524288(0x80000, double:2.590327E-318)
            long r2 = r2 | r34
            r34 = 8388608(0x800000, double:4.144523E-317)
            long r2 = r2 | r34
            r34 = 2147483648(0x80000000, double:1.0609978955E-314)
            long r2 = r2 | r34
            r34 = 34359738368(0x800000000, double:1.69759663277E-313)
            long r2 = r2 | r34
            r34 = 137438953472(0x2000000000, double:6.7903865311E-313)
            long r2 = r2 | r34
            r34 = 2199023255552(0x20000000000, double:1.0864618449742E-311)
            long r2 = r2 | r34
            r34 = 8796093022208(0x80000000000, double:4.345847379897E-311)
        L_0x0171:
            long r2 = r2 | r34
        L_0x0173:
            long r34 = r2 & r17
            r23 = 0
            int r11 = (r34 > r23 ? 1 : (r34 == r23 ? 0 : -1))
            if (r11 == 0) goto L_0x0186
            if (r4 == 0) goto L_0x0181
            r34 = 268435456(0x10000000, double:1.32624737E-315)
            goto L_0x0184
        L_0x0181:
            r34 = 134217728(0x8000000, double:6.63123685E-316)
        L_0x0184:
            long r2 = r2 | r34
        L_0x0186:
            android.widget.TextView r11 = r1.J1
            android.content.res.Resources r11 = r11.getResources()
            int r15 = com.hbg.module.content.R$string.n_live_appointment_num
            r35 = r10
            r34 = r12
            r12 = 1
            java.lang.Object[] r10 = new java.lang.Object[r12]
            r19 = 0
            r10[r19] = r5
            java.lang.String r10 = r11.getString(r15, r10)
            android.widget.TextView r11 = r1.f19273d3
            android.content.res.Resources r11 = r11.getResources()
            r36 = r10
            java.lang.Object[] r10 = new java.lang.Object[r12]
            r10[r19] = r5
            java.lang.String r5 = r11.getString(r15, r10)
            r7 = r7 ^ r12
            if (r13 == 0) goto L_0x01b3
            r10 = r16
            goto L_0x01b4
        L_0x01b3:
            r10 = 0
        L_0x01b4:
            android.widget.TextView r11 = r1.f19277h3
            android.content.res.Resources r11 = r11.getResources()
            int r15 = com.hbg.module.content.R$string.n_live_anchor_fans_num
            r37 = r5
            java.lang.Object[] r5 = new java.lang.Object[r12]
            r12 = 0
            r5[r12] = r0
            java.lang.String r0 = r11.getString(r15, r5)
            if (r6 == 0) goto L_0x01cb
            r5 = 0
            goto L_0x01cd
        L_0x01cb:
            r5 = r16
        L_0x01cd:
            android.widget.TextView r6 = r1.K1
            android.content.res.Resources r6 = r6.getResources()
            if (r14 == 0) goto L_0x01d8
            int r11 = com.hbg.module.content.R$string.n_live_appointment_now
            goto L_0x01da
        L_0x01d8:
            int r11 = com.hbg.module.content.R$string.n_live_already_appointment
        L_0x01da:
            java.lang.String r6 = r6.getString(r11)
            android.widget.TextView r11 = r1.L1
            android.content.res.Resources r11 = r11.getResources()
            if (r14 == 0) goto L_0x01e9
            int r12 = com.hbg.module.content.R$string.n_live_appointment_now
            goto L_0x01eb
        L_0x01e9:
            int r12 = com.hbg.module.content.R$string.n_live_already_appointment
        L_0x01eb:
            java.lang.String r11 = r11.getString(r12)
            android.widget.TextView r12 = r1.L1
            android.content.Context r12 = r12.getContext()
            if (r14 == 0) goto L_0x01fa
            int r15 = com.hbg.module.content.R$drawable.live_btn_trans
            goto L_0x01fc
        L_0x01fa:
            int r15 = com.hbg.module.content.R$drawable.live_btn_bg_unuse
        L_0x01fc:
            android.graphics.drawable.Drawable r12 = c.a.b(r12, r15)
            if (r14 == 0) goto L_0x020d
            android.widget.TextView r15 = r1.L1
            r38 = r0
            int r0 = com.hbg.module.content.R$color.white
            int r0 = androidx.databinding.f.p(r15, r0)
            goto L_0x0217
        L_0x020d:
            r38 = r0
            android.widget.TextView r0 = r1.L1
            int r15 = com.hbg.module.content.R$color.color_12B298
            int r0 = androidx.databinding.f.p(r0, r15)
        L_0x0217:
            if (r14 == 0) goto L_0x0228
            android.widget.TextView r15 = r1.K1
            android.content.Context r15 = r15.getContext()
            r39 = r0
            int r0 = com.hbg.module.content.R$drawable.live_btn_trans
            android.graphics.drawable.Drawable r0 = c.a.b(r15, r0)
            goto L_0x0236
        L_0x0228:
            r39 = r0
            android.widget.TextView r0 = r1.K1
            android.content.Context r0 = r0.getContext()
            int r15 = com.hbg.module.content.R$drawable.live_btn_bg_unuse
            android.graphics.drawable.Drawable r0 = c.a.b(r0, r15)
        L_0x0236:
            if (r14 == 0) goto L_0x0243
            android.widget.TextView r15 = r1.K1
            r40 = r0
            int r0 = com.hbg.module.content.R$color.white
            int r0 = androidx.databinding.f.p(r15, r0)
            goto L_0x024d
        L_0x0243:
            r40 = r0
            android.widget.TextView r0 = r1.K1
            int r15 = com.hbg.module.content.R$color.color_12B298
            int r0 = androidx.databinding.f.p(r0, r15)
        L_0x024d:
            if (r14 == 0) goto L_0x0251
            r14 = 0
            goto L_0x0253
        L_0x0251:
            r14 = r16
        L_0x0253:
            if (r4 == 0) goto L_0x0257
            r4 = 0
            goto L_0x0259
        L_0x0257:
            r4 = r16
        L_0x0259:
            long r41 = r2 & r17
            r23 = 0
            int r15 = (r41 > r23 ? 1 : (r41 == r23 ? 0 : -1))
            if (r15 == 0) goto L_0x026d
            if (r7 == 0) goto L_0x026b
            r41 = 70368744177664(0x400000000000, double:3.4766779039175E-310)
            long r2 = r2 | r41
            goto L_0x026d
        L_0x026b:
            long r2 = r2 | r20
        L_0x026d:
            r15 = r7
            r44 = r27
            r7 = r37
            r43 = r39
            r37 = r40
            r27 = r11
            r11 = r36
            r36 = r6
            r6 = r26
            r26 = r32
            r32 = r0
            r0 = r31
            r31 = r12
            r12 = r5
            r5 = r4
            r3 = r2
            r2 = r38
            r60 = r14
            r14 = r13
            r13 = r60
            goto L_0x02ba
        L_0x0291:
            r28 = r0
            r29 = r6
            r33 = r7
            r35 = r10
            r30 = r11
            r34 = r12
            r3 = r2
            r0 = r22
            r2 = r0
            r6 = r2
            r7 = r6
            r11 = r7
            r26 = r11
            r27 = r26
            r31 = r27
            r36 = r31
            r37 = r36
            r44 = r37
            r5 = 0
            r10 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r32 = 0
            r43 = 0
        L_0x02ba:
            r38 = 274432(0x43000, double:1.355874E-318)
            long r40 = r3 & r38
            r23 = 0
            int r40 = (r40 > r23 ? 1 : (r40 == r23 ? 0 : -1))
            r41 = 288230376151711744(0x400000000000000, double:2.0522684006491881E-289)
            r45 = 270336(0x42000, double:1.335637E-318)
            if (r40 == 0) goto L_0x032d
            int r8 = androidx.databinding.f.C(r8)
            r40 = r11
            r11 = 2
            if (r8 != r11) goto L_0x02d5
            r11 = 1
            goto L_0x02d6
        L_0x02d5:
            r11 = 0
        L_0x02d6:
            long r47 = r3 & r45
            int r47 = (r47 > r23 ? 1 : (r47 == r23 ? 0 : -1))
            if (r47 == 0) goto L_0x02e7
            if (r11 == 0) goto L_0x02e2
            r47 = 1073741824(0x40000000, double:5.304989477E-315)
            goto L_0x02e5
        L_0x02e2:
            r47 = 536870912(0x20000000, double:2.652494739E-315)
        L_0x02e5:
            long r3 = r3 | r47
        L_0x02e7:
            long r47 = r3 & r38
            int r47 = (r47 > r23 ? 1 : (r47 == r23 ? 0 : -1))
            if (r47 == 0) goto L_0x02f6
            if (r11 == 0) goto L_0x02f2
            long r3 = r3 | r41
            goto L_0x02f6
        L_0x02f2:
            r47 = 144115188075855872(0x200000000000000, double:4.7783097267364807E-299)
            long r3 = r3 | r47
        L_0x02f6:
            long r47 = r3 & r45
            int r47 = (r47 > r23 ? 1 : (r47 == r23 ? 0 : -1))
            if (r47 == 0) goto L_0x0302
            if (r11 == 0) goto L_0x02ff
            goto L_0x0302
        L_0x02ff:
            r48 = r16
            goto L_0x0304
        L_0x0302:
            r48 = 0
        L_0x0304:
            r49 = r11
            if (r47 == 0) goto L_0x0329
            r11 = 3
            if (r8 != r11) goto L_0x030d
            r8 = 1
            goto L_0x030e
        L_0x030d:
            r8 = 0
        L_0x030e:
            if (r47 == 0) goto L_0x031f
            if (r8 == 0) goto L_0x0318
            r50 = 1099511627776(0x10000000000, double:5.43230922487E-312)
            goto L_0x031d
        L_0x0318:
            r50 = 549755813888(0x8000000000, double:2.716154612436E-312)
        L_0x031d:
            long r3 = r3 | r50
        L_0x031f:
            if (r8 == 0) goto L_0x0323
            r8 = 0
            goto L_0x0325
        L_0x0323:
            r8 = r16
        L_0x0325:
            r11 = r8
            r8 = r48
            goto L_0x0333
        L_0x0329:
            r8 = r48
            r11 = 0
            goto L_0x0333
        L_0x032d:
            r40 = r11
            r8 = 0
            r11 = 0
            r49 = 0
        L_0x0333:
            r47 = 278528(0x44000, double:1.37611E-318)
            long r50 = r3 & r47
            r23 = 0
            int r25 = (r50 > r23 ? 1 : (r50 == r23 ? 0 : -1))
            if (r25 == 0) goto L_0x0351
            if (r9 == 0) goto L_0x0351
            java.lang.String r25 = r9.getAmountStr()
            java.lang.String r50 = r9.getCountdown()
            java.lang.String r9 = r9.getCurrency()
            r52 = r25
            r53 = r50
            goto L_0x0357
        L_0x0351:
            r9 = r22
            r52 = r9
            r53 = r52
        L_0x0357:
            r50 = 294912(0x48000, double:1.45706E-318)
            long r54 = r3 & r50
            r23 = 0
            int r25 = (r54 > r23 ? 1 : (r54 == r23 ? 0 : -1))
            r54 = r9
            if (r25 == 0) goto L_0x039e
            if (r35 == 0) goto L_0x0373
            r9 = r35
            r35 = r11
            int r11 = r9.focusStatus
            r22 = r11
            java.lang.String r11 = r9.nickname
            java.lang.String r9 = r9.introduction
            goto L_0x037a
        L_0x0373:
            r35 = r11
            r9 = r22
            r11 = r9
            r22 = 0
        L_0x037a:
            if (r22 != 0) goto L_0x037f
            r22 = 1
            goto L_0x0381
        L_0x037f:
            r22 = 0
        L_0x0381:
            if (r25 == 0) goto L_0x0392
            if (r22 == 0) goto L_0x038b
            r55 = 17179869184(0x400000000, double:8.4879831639E-314)
            goto L_0x0390
        L_0x038b:
            r55 = 8589934592(0x200000000, double:4.243991582E-314)
        L_0x0390:
            long r3 = r3 | r55
        L_0x0392:
            if (r22 == 0) goto L_0x0397
            r22 = 0
            goto L_0x0399
        L_0x0397:
            r22 = r16
        L_0x0399:
            r57 = r9
            r9 = r22
            goto L_0x03a5
        L_0x039e:
            r35 = r11
            r11 = r22
            r57 = r11
            r9 = 0
        L_0x03a5:
            r55 = 393216(0x60000, double:1.942745E-318)
            long r58 = r3 & r55
            r22 = 0
            int r25 = (r58 > r22 ? 1 : (r58 == r22 ? 0 : -1))
            r22 = r9
            if (r25 == 0) goto L_0x03cf
            int r9 = androidx.databinding.f.C(r34)
            r34 = r11
            r11 = 1
            if (r9 != r11) goto L_0x03bd
            r9 = 1
            goto L_0x03be
        L_0x03bd:
            r9 = 0
        L_0x03be:
            if (r25 == 0) goto L_0x03c9
            if (r9 == 0) goto L_0x03c5
            r58 = 1125899906842624(0x4000000000000, double:5.562684646268003E-309)
            goto L_0x03c7
        L_0x03c5:
            r58 = 562949953421312(0x2000000000000, double:2.781342323134002E-309)
        L_0x03c7:
            long r3 = r3 | r58
        L_0x03c9:
            if (r9 == 0) goto L_0x03cc
            goto L_0x03d1
        L_0x03cc:
            r9 = r16
            goto L_0x03d2
        L_0x03cf:
            r34 = r11
        L_0x03d1:
            r9 = 0
        L_0x03d2:
            long r20 = r3 & r20
            r23 = 0
            int r11 = (r20 > r23 ? 1 : (r20 == r23 ? 0 : -1))
            if (r11 == 0) goto L_0x03dd
            r11 = 1
            r14 = r14 ^ r11
            goto L_0x03df
        L_0x03dd:
            r11 = 1
            r14 = 0
        L_0x03df:
            long r20 = r3 & r41
            int r20 = (r20 > r23 ? 1 : (r20 == r23 ? 0 : -1))
            if (r20 == 0) goto L_0x03f7
            if (r33 == 0) goto L_0x03ef
            r11 = r33
            int r11 = r11.hasGift
            r20 = r14
            r14 = 1
            goto L_0x03f3
        L_0x03ef:
            r20 = r14
            r14 = r11
            r11 = 0
        L_0x03f3:
            if (r11 != r14) goto L_0x03f9
            r14 = 1
            goto L_0x03fa
        L_0x03f7:
            r20 = r14
        L_0x03f9:
            r14 = 0
        L_0x03fa:
            long r41 = r3 & r17
            r23 = 0
            int r11 = (r41 > r23 ? 1 : (r41 == r23 ? 0 : -1))
            if (r11 == 0) goto L_0x0427
            if (r15 == 0) goto L_0x0406
            r20 = 1
        L_0x0406:
            if (r11 == 0) goto L_0x041b
            if (r20 == 0) goto L_0x0412
            r41 = 67108864(0x4000000, double:3.31561842E-316)
            long r3 = r3 | r41
            r41 = 4503599627370496(0x10000000000000, double:2.2250738585072014E-308)
            goto L_0x0419
        L_0x0412:
            r41 = 33554432(0x2000000, double:1.6578092E-316)
            long r3 = r3 | r41
            r41 = 2251799813685248(0x8000000000000, double:1.1125369292536007E-308)
        L_0x0419:
            long r3 = r3 | r41
        L_0x041b:
            if (r20 == 0) goto L_0x0420
            r11 = r16
            goto L_0x0421
        L_0x0420:
            r11 = 0
        L_0x0421:
            if (r20 == 0) goto L_0x0424
            goto L_0x0428
        L_0x0424:
            r15 = r16
            goto L_0x0429
        L_0x0427:
            r11 = 0
        L_0x0428:
            r15 = 0
        L_0x0429:
            long r20 = r3 & r38
            r23 = 0
            int r20 = (r20 > r23 ? 1 : (r20 == r23 ? 0 : -1))
            if (r20 == 0) goto L_0x0447
            if (r49 == 0) goto L_0x0434
            goto L_0x0435
        L_0x0434:
            r14 = 0
        L_0x0435:
            if (r20 == 0) goto L_0x0440
            if (r14 == 0) goto L_0x043c
            r20 = 72057594037927936(0x100000000000000, double:7.2911220195563975E-304)
            goto L_0x043e
        L_0x043c:
            r20 = 36028797018963968(0x80000000000000, double:2.8480945388892178E-306)
        L_0x043e:
            long r3 = r3 | r20
        L_0x0440:
            if (r14 == 0) goto L_0x0444
            r16 = 0
        L_0x0444:
            r14 = r16
            goto L_0x0448
        L_0x0447:
            r14 = 0
        L_0x0448:
            long r17 = r3 & r17
            r20 = 0
            int r16 = (r17 > r20 ? 1 : (r17 == r20 ? 0 : -1))
            if (r16 == 0) goto L_0x04f4
            r16 = r9
            lc.a7 r9 = r1.B
            android.view.View r9 = r9.getRoot()
            r9.setVisibility(r15)
            lc.a7 r9 = r1.E
            android.view.View r9 = r9.getRoot()
            r9.setVisibility(r11)
            androidx.constraintlayout.widget.ConstraintLayout r9 = r1.F
            r9.setVisibility(r10)
            android.widget.ImageView r9 = r1.W
            r9.setVisibility(r12)
            android.widget.ImageView r9 = r1.f19230l0
            he.b.f(r9, r6)
            android.widget.RelativeLayout r9 = r1.f19271b3
            r9.setVisibility(r11)
            com.hbg.lib.widgets.SafeLottieView r9 = r1.f19272c3
            r9.setVisibility(r13)
            android.widget.TextView r9 = r1.f19273d3
            androidx.databinding.adapters.TextViewBindingAdapter.c(r9, r7)
            android.widget.TextView r7 = r1.f19273d3
            r7.setVisibility(r11)
            android.widget.TextView r7 = r1.f19274e3
            androidx.databinding.adapters.TextViewBindingAdapter.c(r7, r0)
            android.widget.TextView r7 = r1.f19277h3
            androidx.databinding.adapters.TextViewBindingAdapter.c(r7, r2)
            android.widget.TextView r2 = r1.f19278i3
            r2.setVisibility(r5)
            androidx.appcompat.widget.AppCompatImageView r2 = r1.f19281l3
            he.b.f(r2, r6)
            android.widget.TextView r2 = r1.f19287r3
            androidx.databinding.adapters.TextViewBindingAdapter.c(r2, r0)
            android.widget.RelativeLayout r2 = r1.f19239o1
            r2.setVisibility(r15)
            com.hbg.lib.widgets.SafeLottieView r2 = r1.C1
            r2.setVisibility(r13)
            android.widget.TextView r2 = r1.J1
            r5 = r40
            androidx.databinding.adapters.TextViewBindingAdapter.c(r2, r5)
            android.widget.TextView r2 = r1.J1
            r2.setVisibility(r15)
            android.widget.TextView r2 = r1.K1
            r5 = r37
            androidx.databinding.adapters.ViewBindingAdapter.a(r2, r5)
            android.widget.TextView r2 = r1.K1
            r6 = r36
            androidx.databinding.adapters.TextViewBindingAdapter.c(r2, r6)
            android.widget.TextView r2 = r1.K1
            r5 = r32
            r2.setTextColor(r5)
            android.widget.TextView r2 = r1.L1
            r12 = r31
            androidx.databinding.adapters.ViewBindingAdapter.a(r2, r12)
            android.widget.TextView r2 = r1.L1
            r11 = r27
            androidx.databinding.adapters.TextViewBindingAdapter.c(r2, r11)
            android.widget.TextView r2 = r1.L1
            r5 = r43
            r2.setTextColor(r5)
            com.hbg.module.content.widgets.AutoMarqueeTextView r2 = r1.f19205c2
            androidx.databinding.adapters.TextViewBindingAdapter.c(r2, r0)
            android.widget.TextView r0 = r1.f19226j2
            r2 = r26
            he.b.m(r0, r2)
            android.widget.TextView r0 = r1.A2
            r2 = r44
            he.b.m(r0, r2)
            goto L_0x04f6
        L_0x04f4:
            r16 = r9
        L_0x04f6:
            r5 = 262144(0x40000, double:1.295163E-318)
            long r5 = r5 & r3
            r9 = 0
            int r0 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r0 == 0) goto L_0x05d3
            lc.a7 r0 = r1.B
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            r0.K(r2)
            lc.a7 r0 = r1.E
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            r0.K(r2)
            android.widget.ImageView r0 = r1.U
            android.view.View$OnClickListener r2 = r1.C3
            r0.setOnClickListener(r2)
            android.widget.ImageView r0 = r1.V
            android.view.View$OnClickListener r2 = r1.J3
            r0.setOnClickListener(r2)
            android.widget.ImageView r0 = r1.W
            android.view.View$OnClickListener r2 = r1.H3
            r0.setOnClickListener(r2)
            android.widget.ImageView r0 = r1.X
            android.view.View$OnClickListener r2 = r1.f19294y3
            r0.setOnClickListener(r2)
            android.widget.ImageView r0 = r1.f19206d0
            android.view.View$OnClickListener r2 = r1.K3
            r0.setOnClickListener(r2)
            android.widget.ImageView r0 = r1.f19212f0
            android.view.View$OnClickListener r2 = r1.f19293x3
            r0.setOnClickListener(r2)
            android.widget.ImageView r0 = r1.f19236n0
            android.view.View$OnClickListener r2 = r1.F3
            r0.setOnClickListener(r2)
            android.widget.ImageView r0 = r1.f19267z0
            android.view.View$OnClickListener r2 = r1.G3
            r0.setOnClickListener(r2)
            com.airbnb.lottie.LottieAnimationView r0 = r1.D0
            android.view.View$OnClickListener r2 = r1.E3
            r0.setOnClickListener(r2)
            android.widget.LinearLayout r0 = r1.f19201b1
            android.view.View$OnClickListener r2 = r1.f19292w3
            r0.setOnClickListener(r2)
            android.widget.LinearLayout r0 = r1.f19204c1
            android.view.View$OnClickListener r2 = r1.f19295z3
            r0.setOnClickListener(r2)
            android.widget.ImageView r0 = r1.f19276g3
            android.view.View$OnClickListener r2 = r1.D3
            r0.setOnClickListener(r2)
            android.widget.ImageView r0 = r1.f19280k3
            android.view.View$OnClickListener r2 = r1.f19290u3
            r0.setOnClickListener(r2)
            android.widget.TextView r0 = r1.f19283n3
            android.view.View$OnClickListener r2 = r1.A3
            r0.setOnClickListener(r2)
            android.widget.ImageView r0 = r1.f19284o3
            android.view.View$OnClickListener r2 = r1.f19289t3
            r0.setOnClickListener(r2)
            android.widget.TextView r0 = r1.f19285p3
            android.content.res.Resources r2 = r0.getResources()
            int r5 = com.hbg.module.content.R$string.n_grid_strategy_profit
            r6 = 1
            java.lang.Object[] r6 = new java.lang.Object[r6]
            java.lang.String r7 = "USDT"
            r9 = 0
            r6[r9] = r7
            java.lang.String r2 = r2.getString(r5, r6)
            androidx.databinding.adapters.TextViewBindingAdapter.c(r0, r2)
            android.widget.ImageView r0 = r1.f19286q3
            android.view.View$OnClickListener r2 = r1.L3
            r0.setOnClickListener(r2)
            android.widget.RelativeLayout r0 = r1.f19247s1
            android.view.View$OnClickListener r2 = r1.B3
            r0.setOnClickListener(r2)
            android.widget.TextView r0 = r1.M1
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "+"
            r2.append(r5)
            android.widget.TextView r5 = r1.M1
            android.content.res.Resources r5 = r5.getResources()
            int r6 = com.hbg.module.content.R$string.n_content_communityList_attention
            java.lang.String r5 = r5.getString(r6)
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            androidx.databinding.adapters.TextViewBindingAdapter.c(r0, r2)
            android.widget.RelativeLayout r0 = r1.f19232l2
            android.view.View$OnClickListener r2 = r1.I3
            r0.setOnClickListener(r2)
            android.widget.LinearLayout r0 = r1.f19254u2
            android.view.View$OnClickListener r2 = r1.M3
            r0.setOnClickListener(r2)
            android.widget.TextView r0 = r1.f19263x2
            android.view.View$OnClickListener r2 = r1.f19291v3
            r0.setOnClickListener(r2)
        L_0x05d3:
            long r5 = r3 & r38
            r9 = 0
            int r0 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r0 == 0) goto L_0x05e0
            android.widget.ImageView r0 = r1.V
            r0.setVisibility(r14)
        L_0x05e0:
            r5 = 327680(0x50000, double:1.618954E-318)
            long r5 = r5 & r3
            int r0 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r0 == 0) goto L_0x05f4
            lc.e6 r0 = r1.F0
            r2 = r30
            r0.K(r2)
            lc.e6 r0 = r1.I0
            r0.K(r2)
        L_0x05f4:
            r5 = 264192(0x40800, double:1.30528E-318)
            long r5 = r5 & r3
            int r0 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r0 == 0) goto L_0x0603
            lc.u0 r0 = r1.G0
            r2 = r29
            r0.K(r2)
        L_0x0603:
            long r5 = r3 & r45
            int r0 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r0 == 0) goto L_0x061a
            android.widget.LinearLayout r0 = r1.X0
            r0.setVisibility(r8)
            android.widget.RelativeLayout r0 = r1.f19256v1
            r0.setVisibility(r8)
            android.view.View r0 = r1.M2
            r8 = r35
            r0.setVisibility(r8)
        L_0x061a:
            long r5 = r3 & r50
            int r0 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r0 == 0) goto L_0x0649
            android.widget.TextView r0 = r1.f19275f3
            r11 = r34
            androidx.databinding.adapters.TextViewBindingAdapter.c(r0, r11)
            android.widget.TextView r0 = r1.f19288s3
            androidx.databinding.adapters.TextViewBindingAdapter.c(r0, r11)
            android.widget.RelativeLayout r0 = r1.f19241p1
            r2 = r22
            r0.setVisibility(r2)
            com.hbg.lib.widgets.SafeLottieView r0 = r1.E1
            r0.setVisibility(r2)
            android.widget.TextView r0 = r1.N1
            r9 = r57
            androidx.databinding.adapters.TextViewBindingAdapter.c(r0, r9)
            android.widget.TextView r0 = r1.f19220h2
            r0.setVisibility(r2)
            android.widget.TextView r0 = r1.f19257v2
            androidx.databinding.adapters.TextViewBindingAdapter.c(r0, r11)
        L_0x0649:
            long r5 = r3 & r47
            r7 = 0
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 == 0) goto L_0x0666
            android.widget.TextView r0 = r1.f19282m3
            r9 = r54
            androidx.databinding.adapters.TextViewBindingAdapter.c(r0, r9)
            android.widget.TextView r0 = r1.F1
            r2 = r52
            androidx.databinding.adapters.TextViewBindingAdapter.c(r0, r2)
            android.widget.TextView r0 = r1.G1
            r2 = r53
            androidx.databinding.adapters.TextViewBindingAdapter.c(r0, r2)
        L_0x0666:
            long r5 = r3 & r55
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 == 0) goto L_0x0673
            android.widget.TextView r0 = r1.G1
            r9 = r16
            r0.setVisibility(r9)
        L_0x0673:
            r5 = 263168(0x40400, double:1.300223E-318)
            long r2 = r3 & r5
            int r0 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r0 == 0) goto L_0x0683
            android.widget.LinearLayout r0 = r1.f19238n2
            r14 = r28
            r0.setVisibility(r14)
        L_0x0683:
            lc.a7 r0 = r1.E
            androidx.databinding.f.k(r0)
            lc.a7 r0 = r1.B
            androidx.databinding.f.k(r0)
            lc.e6 r0 = r1.F0
            androidx.databinding.f.k(r0)
            lc.o6 r0 = r1.J0
            androidx.databinding.f.k(r0)
            lc.g6 r0 = r1.L0
            androidx.databinding.f.k(r0)
            lc.k6 r0 = r1.M0
            androidx.databinding.f.k(r0)
            lc.m6 r0 = r1.N0
            androidx.databinding.f.k(r0)
            lc.u6 r0 = r1.O0
            androidx.databinding.f.k(r0)
            lc.e6 r0 = r1.I0
            androidx.databinding.f.k(r0)
            lc.u0 r0 = r1.G0
            androidx.databinding.f.k(r0)
            return
        L_0x06b6:
            r0 = move-exception
            monitor-exit(r61)     // Catch:{ all -> 0x06b6 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: lc.n.i():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r4.B.r() == false) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
        if (r4.F0.r() == false) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002e, code lost:
        if (r4.J0.r() == false) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0030, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0037, code lost:
        if (r4.L0.r() == false) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0039, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0040, code lost:
        if (r4.M0.r() == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0042, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0049, code lost:
        if (r4.N0.r() == false) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004b, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0052, code lost:
        if (r4.O0.r() == false) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0054, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x005b, code lost:
        if (r4.I0.r() == false) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x005d, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0064, code lost:
        if (r4.G0.r() == false) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0066, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0067, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r4.E.r() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean r() {
        /*
            r4 = this;
            monitor-enter(r4)
            long r0 = r4.N3     // Catch:{ all -> 0x0069 }
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 1
            if (r0 == 0) goto L_0x000c
            monitor-exit(r4)     // Catch:{ all -> 0x0069 }
            return r1
        L_0x000c:
            monitor-exit(r4)     // Catch:{ all -> 0x0069 }
            lc.a7 r0 = r4.E
            boolean r0 = r0.r()
            if (r0 == 0) goto L_0x0016
            return r1
        L_0x0016:
            lc.a7 r0 = r4.B
            boolean r0 = r0.r()
            if (r0 == 0) goto L_0x001f
            return r1
        L_0x001f:
            lc.e6 r0 = r4.F0
            boolean r0 = r0.r()
            if (r0 == 0) goto L_0x0028
            return r1
        L_0x0028:
            lc.o6 r0 = r4.J0
            boolean r0 = r0.r()
            if (r0 == 0) goto L_0x0031
            return r1
        L_0x0031:
            lc.g6 r0 = r4.L0
            boolean r0 = r0.r()
            if (r0 == 0) goto L_0x003a
            return r1
        L_0x003a:
            lc.k6 r0 = r4.M0
            boolean r0 = r0.r()
            if (r0 == 0) goto L_0x0043
            return r1
        L_0x0043:
            lc.m6 r0 = r4.N0
            boolean r0 = r0.r()
            if (r0 == 0) goto L_0x004c
            return r1
        L_0x004c:
            lc.u6 r0 = r4.O0
            boolean r0 = r0.r()
            if (r0 == 0) goto L_0x0055
            return r1
        L_0x0055:
            lc.e6 r0 = r4.I0
            boolean r0 = r0.r()
            if (r0 == 0) goto L_0x005e
            return r1
        L_0x005e:
            lc.u0 r0 = r4.G0
            boolean r0 = r0.r()
            if (r0 == 0) goto L_0x0067
            return r1
        L_0x0067:
            r0 = 0
            return r0
        L_0x0069:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0069 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: lc.n.r():boolean");
    }

    public void t() {
        synchronized (this) {
            this.N3 = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
        }
        this.E.t();
        this.B.t();
        this.F0.t();
        this.J0.t();
        this.L0.t();
        this.M0.t();
        this.N0.t();
        this.O0.t();
        this.I0.t();
        this.G0.t();
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        switch (i11) {
            case 0:
                return b0((k6) obj, i12);
            case 1:
                return d0((u6) obj, i12);
            case 2:
                return V((a7) obj, i12);
            case 3:
                return a0((g6) obj, i12);
            case 4:
                return X((u0) obj, i12);
            case 5:
                return Z((o6) obj, i12);
            case 6:
                return c0((m6) obj, i12);
            case 7:
                return W((e6) obj, i12);
            case 8:
                return Y((e6) obj, i12);
            case 9:
                return U((a7) obj, i12);
            default:
                return false;
        }
    }

    public n(b bVar, View view, Object[] objArr) {
        super(bVar, view, 10, objArr[62], objArr[179], objArr[166], objArr[61], objArr[21], objArr[153], objArr[109], objArr[155], objArr[177], objArr[59], objArr[104], objArr[185], objArr[74], objArr[117], objArr[81], objArr[76], objArr[72], objArr[84], objArr[87], objArr[16], objArr[43], objArr[46], objArr[27], objArr[140], objArr[110], objArr[146], objArr[147], objArr[120], objArr[35], objArr[175], objArr[49], objArr[182], objArr[144], objArr[141], objArr[163], objArr[137], objArr[33], objArr[169], objArr[45], objArr[150], objArr[171], objArr[95], objArr[107], objArr[124], objArr[105], objArr[44], objArr[130], objArr[115], objArr[143], objArr[48], objArr[121], objArr[63], objArr[70], objArr[119], objArr[69], objArr[64], objArr[148], objArr[65], objArr[66], objArr[67], objArr[68], objArr[100], objArr[102], objArr[101], objArr[136], objArr[116], objArr[79], objArr[123], objArr[145], objArr[42], objArr[99], objArr[162], objArr[167], objArr[57], objArr[28], objArr[91], objArr[85], objArr[183], objArr[88], objArr[170], objArr[129], objArr[94], objArr[158], objArr[97], objArr[75], objArr[2], objArr[4], objArr[18], objArr[142], objArr[135], objArr[47], objArr[89], objArr[37], objArr[51], objArr[180], objArr[32], objArr[71], objArr[78], objArr[90], objArr[157], objArr[5], objArr[82], objArr[25], objArr[39], objArr[41], objArr[118], objArr[98], objArr[7], objArr[12], objArr[6], objArr[19], objArr[14], objArr[77], objArr[111], objArr[134], objArr[174], objArr[122], objArr[168], objArr[165], objArr[164], objArr[114], objArr[139], objArr[152], objArr[113], objArr[112], objArr[92], objArr[30], objArr[151], objArr[173], objArr[172], objArr[138], objArr[24], objArr[96], objArr[52], objArr[128], objArr[60], objArr[186], objArr[53], objArr[126], objArr[127], objArr[106], objArr[160], objArr[181], objArr[156], objArr[38], objArr[22], objArr[125], objArr[34], objArr[133], objArr[131], objArr[26], objArr[132], objArr[83], objArr[73], objArr[93], objArr[108], objArr[159], objArr[176], objArr[184], objArr[103], objArr[149], objArr[161], objArr[50], objArr[86], objArr[80], objArr[154], objArr[178]);
        this.N3 = -1;
        E(this.B);
        E(this.E);
        this.F.setTag((Object) null);
        this.K.setTag((Object) null);
        this.U.setTag((Object) null);
        this.V.setTag((Object) null);
        this.W.setTag((Object) null);
        this.X.setTag((Object) null);
        this.f19206d0.setTag((Object) null);
        this.f19212f0.setTag((Object) null);
        this.f19230l0.setTag((Object) null);
        this.f19236n0.setTag((Object) null);
        this.f19267z0.setTag((Object) null);
        this.D0.setTag((Object) null);
        E(this.F0);
        E(this.G0);
        E(this.I0);
        E(this.J0);
        E(this.L0);
        E(this.M0);
        E(this.N0);
        E(this.O0);
        this.X0.setTag((Object) null);
        this.f19201b1.setTag((Object) null);
        this.f19204c1.setTag((Object) null);
        FrameLayout frameLayout = objArr[0];
        this.Z2 = frameLayout;
        frameLayout.setTag((Object) null);
        RelativeLayout relativeLayout = objArr[1];
        this.f19270a3 = relativeLayout;
        relativeLayout.setTag((Object) null);
        RelativeLayout relativeLayout2 = objArr[10];
        this.f19271b3 = relativeLayout2;
        relativeLayout2.setTag((Object) null);
        SafeLottieView safeLottieView = objArr[11];
        this.f19272c3 = safeLottieView;
        safeLottieView.setTag((Object) null);
        TextView textView = objArr[13];
        this.f19273d3 = textView;
        textView.setTag((Object) null);
        TextView textView2 = objArr[15];
        this.f19274e3 = textView2;
        textView2.setTag((Object) null);
        TextView textView3 = objArr[17];
        this.f19275f3 = textView3;
        textView3.setTag((Object) null);
        ImageView imageView = objArr[20];
        this.f19276g3 = imageView;
        imageView.setTag((Object) null);
        TextView textView4 = objArr[23];
        this.f19277h3 = textView4;
        textView4.setTag((Object) null);
        TextView textView5 = objArr[29];
        this.f19278i3 = textView5;
        textView5.setTag((Object) null);
        RelativeLayout relativeLayout3 = objArr[3];
        this.f19279j3 = relativeLayout3;
        relativeLayout3.setTag((Object) null);
        ImageView imageView2 = objArr[31];
        this.f19280k3 = imageView2;
        imageView2.setTag((Object) null);
        AppCompatImageView appCompatImageView = objArr[36];
        this.f19281l3 = appCompatImageView;
        appCompatImageView.setTag((Object) null);
        TextView textView6 = objArr[40];
        this.f19282m3 = textView6;
        textView6.setTag((Object) null);
        TextView textView7 = objArr[54];
        this.f19283n3 = textView7;
        textView7.setTag((Object) null);
        ImageView imageView3 = objArr[55];
        this.f19284o3 = imageView3;
        imageView3.setTag((Object) null);
        TextView textView8 = objArr[56];
        this.f19285p3 = textView8;
        textView8.setTag((Object) null);
        ImageView imageView4 = objArr[58];
        this.f19286q3 = imageView4;
        imageView4.setTag((Object) null);
        TextView textView9 = objArr[8];
        this.f19287r3 = textView9;
        textView9.setTag((Object) null);
        TextView textView10 = objArr[9];
        this.f19288s3 = textView10;
        textView10.setTag((Object) null);
        this.f19237n1.setTag((Object) null);
        this.f19239o1.setTag((Object) null);
        this.f19241p1.setTag((Object) null);
        this.f19247s1.setTag((Object) null);
        this.f19253u1.setTag((Object) null);
        this.f19256v1.setTag((Object) null);
        this.f19262x1.setTag((Object) null);
        this.C1.setTag((Object) null);
        this.E1.setTag((Object) null);
        this.F1.setTag((Object) null);
        this.G1.setTag((Object) null);
        this.J1.setTag((Object) null);
        this.K1.setTag((Object) null);
        this.L1.setTag((Object) null);
        this.M1.setTag((Object) null);
        this.N1.setTag((Object) null);
        this.f19205c2.setTag((Object) null);
        this.f19220h2.setTag((Object) null);
        this.f19226j2.setTag((Object) null);
        this.f19232l2.setTag((Object) null);
        this.f19238n2.setTag((Object) null);
        this.f19254u2.setTag((Object) null);
        this.f19257v2.setTag((Object) null);
        this.f19263x2.setTag((Object) null);
        this.A2.setTag((Object) null);
        this.M2.setTag((Object) null);
        G(view);
        this.f19289t3 = new a(this, 17);
        this.f19290u3 = new a(this, 5);
        this.f19291v3 = new a(this, 6);
        this.f19292w3 = new a(this, 18);
        this.f19293x3 = new a(this, 15);
        this.f19294y3 = new a(this, 3);
        this.f19295z3 = new a(this, 4);
        this.A3 = new a(this, 16);
        this.B3 = new a(this, 13);
        this.C3 = new a(this, 1);
        this.D3 = new a(this, 2);
        this.E3 = new a(this, 14);
        this.F3 = new a(this, 11);
        this.G3 = new a(this, 10);
        this.H3 = new a(this, 12);
        this.I3 = new a(this, 20);
        this.J3 = new a(this, 9);
        this.K3 = new a(this, 7);
        this.L3 = new a(this, 19);
        this.M3 = new a(this, 8);
        t();
    }
}
