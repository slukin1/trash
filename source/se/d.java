package se;

import android.annotation.SuppressLint;
import android.graphics.Outline;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.libkt.R$drawable;
import com.hbg.module.libkt.R$string;
import com.hbg.module.libkt.utils.r;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.rtmp.ITXVodPlayListener;
import com.tencent.rtmp.TXVodPlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import te.g;

@SuppressLint({"StaticFieldLeak"})
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f25974a = new d();

    /* renamed from: b  reason: collision with root package name */
    public static TXVodPlayer f25975b;

    /* renamed from: c  reason: collision with root package name */
    public static g f25976c;

    /* renamed from: d  reason: collision with root package name */
    public static String f25977d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f25978e;

    /* renamed from: f  reason: collision with root package name */
    public static Handler f25979f;

    /* renamed from: g  reason: collision with root package name */
    public static AlphaAnimation f25980g;

    /* renamed from: h  reason: collision with root package name */
    public static AlphaAnimation f25981h;

    /* renamed from: i  reason: collision with root package name */
    public static Runnable f25982i;

    /* renamed from: j  reason: collision with root package name */
    public static boolean f25983j;

    /* renamed from: k  reason: collision with root package name */
    public static e f25984k;

    public static final class a implements Animation.AnimationListener {
        public void onAnimationEnd(Animation animation) {
            g e11 = d.f25976c;
            ImageView imageView = null;
            LinearLayout linearLayout = e11 != null ? e11.E : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            g e12 = d.f25976c;
            RelativeLayout relativeLayout = e12 != null ? e12.G : null;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            g e13 = d.f25976c;
            if (e13 != null) {
                imageView = e13.D;
            }
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f25985b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f25986c;

        public b(View view, long j11) {
            this.f25985b = view;
            this.f25986c = j11;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            ImageView imageView;
            ImageView imageView2;
            long currentTimeMillis = System.currentTimeMillis();
            r rVar = r.f24939a;
            if (currentTimeMillis - rVar.b(this.f25985b) > this.f25986c || (this.f25985b instanceof Checkable)) {
                rVar.e(this.f25985b, currentTimeMillis);
                ImageView imageView3 = (ImageView) this.f25985b;
                TXVodPlayer g11 = d.f25975b;
                boolean z11 = true;
                if (g11 == null || !g11.isPlaying()) {
                    z11 = false;
                }
                if (z11) {
                    g e11 = d.f25976c;
                    if (!(e11 == null || (imageView2 = e11.D) == null)) {
                        imageView2.setImageResource(R$drawable.icon_video_play);
                    }
                    TXVodPlayer g12 = d.f25975b;
                    if (g12 != null) {
                        g12.pause();
                    }
                } else {
                    g e12 = d.f25976c;
                    if (!(e12 == null || (imageView = e12.D) == null)) {
                        imageView.setImageResource(R$drawable.icon_video_pause);
                    }
                    TXVodPlayer g13 = d.f25975b;
                    if (g13 != null) {
                        g13.resume();
                    }
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class c implements SeekBar.OnSeekBarChangeListener {
        public void onProgressChanged(SeekBar seekBar, int i11, boolean z11) {
            ImageView imageView;
            te.c cVar;
            te.e eVar;
            if (z11) {
                TXVodPlayer g11 = d.f25975b;
                if (g11 != null && !g11.isPlaying()) {
                    g e11 = d.f25976c;
                    View view = null;
                    View root = (e11 == null || (eVar = e11.K) == null) ? null : eVar.getRoot();
                    if (root != null) {
                        root.setVisibility(0);
                    }
                    g e12 = d.f25976c;
                    if (!(e12 == null || (cVar = e12.L) == null)) {
                        view = cVar.getRoot();
                    }
                    if (view != null) {
                        view.setVisibility(8);
                    }
                    TXVodPlayer g12 = d.f25975b;
                    if (g12 != null) {
                        g12.setStartTime((float) i11);
                    }
                    TXVodPlayer g13 = d.f25975b;
                    if (g13 != null) {
                        g13.startVodPlay(d.f25977d);
                    }
                    g e13 = d.f25976c;
                    if (!(e13 == null || (imageView = e13.D) == null)) {
                        imageView.setImageResource(R$drawable.icon_video_pause);
                    }
                }
                TXVodPlayer g14 = d.f25975b;
                if (g14 != null) {
                    g14.seek(i11);
                }
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            Handler f11;
            d dVar = d.f25974a;
            d.f25978e = true;
            g e11 = d.f25976c;
            LinearLayout linearLayout = e11 != null ? e11.E : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            Runnable d11 = d.f25982i;
            if (d11 != null && (f11 = d.f25979f) != null) {
                f11.removeCallbacks(d11);
            }
        }

        @SensorsDataInstrumented
        public void onStopTrackingTouch(SeekBar seekBar) {
            Handler f11;
            d dVar = d.f25974a;
            d.f25978e = false;
            Runnable d11 = d.f25982i;
            if (!(d11 == null || (f11 = d.f25979f) == null)) {
                f11.postDelayed(d11, 3000);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(seekBar);
        }
    }

    /* renamed from: se.d$d  reason: collision with other inner class name */
    public static final class C0227d implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f25987b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f25988c;

        public C0227d(View view, long j11) {
            this.f25987b = view;
            this.f25988c = j11;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0034, code lost:
            r0 = r0.K;
         */
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r8) {
            /*
                r7 = this;
                long r0 = java.lang.System.currentTimeMillis()
                com.hbg.module.libkt.utils.r r2 = com.hbg.module.libkt.utils.r.f24939a
                android.view.View r3 = r7.f25987b
                long r3 = r2.b(r3)
                long r3 = r0 - r3
                long r5 = r7.f25988c
                int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r3 > 0) goto L_0x001a
                android.view.View r3 = r7.f25987b
                boolean r3 = r3 instanceof android.widget.Checkable
                if (r3 == 0) goto L_0x0077
            L_0x001a:
                android.view.View r3 = r7.f25987b
                r2.e(r3, r0)
                android.view.View r0 = r7.f25987b
                android.widget.TextView r0 = (android.widget.TextView) r0
                com.tencent.rtmp.TXVodPlayer r0 = se.d.f25975b
                if (r0 == 0) goto L_0x002d
                r1 = 1
                r0.stopPlay(r1)
            L_0x002d:
                te.g r0 = se.d.f25976c
                r1 = 0
                if (r0 == 0) goto L_0x003d
                te.e r0 = r0.K
                if (r0 == 0) goto L_0x003d
                android.view.View r0 = r0.getRoot()
                goto L_0x003e
            L_0x003d:
                r0 = r1
            L_0x003e:
                if (r0 != 0) goto L_0x0041
                goto L_0x0045
            L_0x0041:
                r2 = 0
                r0.setVisibility(r2)
            L_0x0045:
                te.g r0 = se.d.f25976c
                if (r0 == 0) goto L_0x0053
                te.c r0 = r0.L
                if (r0 == 0) goto L_0x0053
                android.view.View r1 = r0.getRoot()
            L_0x0053:
                if (r1 != 0) goto L_0x0056
                goto L_0x005b
            L_0x0056:
                r0 = 8
                r1.setVisibility(r0)
            L_0x005b:
                com.tencent.rtmp.TXVodPlayer r0 = se.d.f25975b
                if (r0 == 0) goto L_0x0068
                java.lang.String r1 = se.d.f25977d
                r0.startVodPlay((java.lang.String) r1)
            L_0x0068:
                te.g r0 = se.d.f25976c
                if (r0 == 0) goto L_0x0077
                android.widget.ImageView r0 = r0.D
                if (r0 == 0) goto L_0x0077
                int r1 = com.hbg.module.libkt.R$drawable.icon_video_pause
                r0.setImageResource(r1)
            L_0x0077:
                com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper.trackViewOnClick(r8)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: se.d.C0227d.onClick(android.view.View):void");
        }
    }

    public static final class e implements ITXVodPlayListener {
        public void onNetStatus(TXVodPlayer tXVodPlayer, Bundle bundle) {
        }

        /* JADX WARNING: type inference failed for: r1v4, types: [android.view.View] */
        /* JADX WARNING: type inference failed for: r1v6, types: [android.view.View] */
        /* JADX WARNING: type inference failed for: r1v8, types: [android.view.View] */
        /* JADX WARNING: Code restructure failed: missing block: B:93:0x0125, code lost:
            r5 = r5.K;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onPlayEvent(com.tencent.rtmp.TXVodPlayer r4, int r5, android.os.Bundle r6) {
            /*
                r3 = this;
                r4 = 0
                r0 = 8
                r1 = 0
                switch(r5) {
                    case -2307: goto L_0x0116;
                    case -2306: goto L_0x0116;
                    case -2305: goto L_0x0116;
                    case -2304: goto L_0x0116;
                    case -2303: goto L_0x0116;
                    case -2302: goto L_0x0116;
                    case -2301: goto L_0x0116;
                    default: goto L_0x0007;
                }
            L_0x0007:
                switch(r5) {
                    case 2004: goto L_0x00e0;
                    case 2005: goto L_0x004c;
                    case 2006: goto L_0x0032;
                    case 2007: goto L_0x000c;
                    default: goto L_0x000a;
                }
            L_0x000a:
                goto L_0x01b1
            L_0x000c:
                se.e r5 = se.d.f25984k
                if (r5 == 0) goto L_0x0015
                r5.b()
            L_0x0015:
                boolean r5 = se.d.f25978e
                if (r5 != 0) goto L_0x01b1
                te.g r5 = se.d.f25976c
                if (r5 == 0) goto L_0x0029
                te.e r5 = r5.K
                if (r5 == 0) goto L_0x0029
                android.view.View r1 = r5.getRoot()
            L_0x0029:
                if (r1 != 0) goto L_0x002d
                goto L_0x01b1
            L_0x002d:
                r1.setVisibility(r4)
                goto L_0x01b1
            L_0x0032:
                se.e r4 = se.d.f25984k
                if (r4 == 0) goto L_0x003b
                r4.a()
            L_0x003b:
                te.g r4 = se.d.f25976c
                if (r4 == 0) goto L_0x01b1
                android.widget.ImageView r4 = r4.D
                if (r4 == 0) goto L_0x01b1
                int r5 = com.hbg.module.libkt.R$drawable.icon_video_play
                r4.setImageResource(r5)
                goto L_0x01b1
            L_0x004c:
                if (r6 == 0) goto L_0x0055
                java.lang.String r5 = "EVT_PLAY_DURATION"
                int r5 = r6.getInt(r5)
                goto L_0x0056
            L_0x0055:
                r5 = r4
            L_0x0056:
                if (r6 == 0) goto L_0x005e
                java.lang.String r4 = "EVT_PLAY_PROGRESS"
                int r4 = r6.getInt(r4)
            L_0x005e:
                se.e r6 = se.d.f25984k
                if (r6 == 0) goto L_0x0067
                r6.d(r5, r4)
            L_0x0067:
                te.g r6 = se.d.f25976c
                if (r6 == 0) goto L_0x0070
                android.widget.SeekBar r6 = r6.F
                goto L_0x0071
            L_0x0070:
                r6 = r1
            L_0x0071:
                if (r6 != 0) goto L_0x0074
                goto L_0x0077
            L_0x0074:
                r6.setMax(r5)
            L_0x0077:
                te.g r6 = se.d.f25976c
                if (r6 == 0) goto L_0x0080
                android.widget.TextView r6 = r6.H
                goto L_0x0081
            L_0x0080:
                r6 = r1
            L_0x0081:
                if (r6 != 0) goto L_0x0084
                goto L_0x008d
            L_0x0084:
                se.d r2 = se.d.f25974a
                java.lang.String r5 = r2.p(r5)
                r6.setText(r5)
            L_0x008d:
                te.g r5 = se.d.f25976c
                if (r5 == 0) goto L_0x0096
                android.widget.SeekBar r5 = r5.F
                goto L_0x0097
            L_0x0096:
                r5 = r1
            L_0x0097:
                if (r5 != 0) goto L_0x009a
                goto L_0x009d
            L_0x009a:
                r5.setProgress(r4)
            L_0x009d:
                te.g r5 = se.d.f25976c
                if (r5 == 0) goto L_0x00a6
                android.widget.TextView r5 = r5.I
                goto L_0x00a7
            L_0x00a6:
                r5 = r1
            L_0x00a7:
                if (r5 != 0) goto L_0x00aa
                goto L_0x00b3
            L_0x00aa:
                se.d r6 = se.d.f25974a
                java.lang.String r4 = r6.p(r4)
                r5.setText(r4)
            L_0x00b3:
                te.g r4 = se.d.f25976c
                if (r4 == 0) goto L_0x00c2
                te.e r4 = r4.K
                if (r4 == 0) goto L_0x00c2
                android.view.View r4 = r4.getRoot()
                goto L_0x00c3
            L_0x00c2:
                r4 = r1
            L_0x00c3:
                if (r4 != 0) goto L_0x00c6
                goto L_0x00c9
            L_0x00c6:
                r4.setVisibility(r0)
            L_0x00c9:
                te.g r4 = se.d.f25976c
                if (r4 == 0) goto L_0x00d7
                te.c r4 = r4.L
                if (r4 == 0) goto L_0x00d7
                android.view.View r1 = r4.getRoot()
            L_0x00d7:
                if (r1 != 0) goto L_0x00db
                goto L_0x01b1
            L_0x00db:
                r1.setVisibility(r0)
                goto L_0x01b1
            L_0x00e0:
                se.e r4 = se.d.f25984k
                if (r4 == 0) goto L_0x00e9
                r4.e()
            L_0x00e9:
                te.g r4 = se.d.f25976c
                if (r4 == 0) goto L_0x00f8
                te.e r4 = r4.K
                if (r4 == 0) goto L_0x00f8
                android.view.View r4 = r4.getRoot()
                goto L_0x00f9
            L_0x00f8:
                r4 = r1
            L_0x00f9:
                if (r4 != 0) goto L_0x00fc
                goto L_0x00ff
            L_0x00fc:
                r4.setVisibility(r0)
            L_0x00ff:
                te.g r4 = se.d.f25976c
                if (r4 == 0) goto L_0x010d
                te.c r4 = r4.L
                if (r4 == 0) goto L_0x010d
                android.view.View r1 = r4.getRoot()
            L_0x010d:
                if (r1 != 0) goto L_0x0111
                goto L_0x01b1
            L_0x0111:
                r1.setVisibility(r0)
                goto L_0x01b1
            L_0x0116:
                se.e r5 = se.d.f25984k
                if (r5 == 0) goto L_0x011f
                r5.onError()
            L_0x011f:
                te.g r5 = se.d.f25976c
                if (r5 == 0) goto L_0x012e
                te.e r5 = r5.K
                if (r5 == 0) goto L_0x012e
                android.view.View r5 = r5.getRoot()
                goto L_0x012f
            L_0x012e:
                r5 = r1
            L_0x012f:
                if (r5 != 0) goto L_0x0132
                goto L_0x0135
            L_0x0132:
                r5.setVisibility(r0)
            L_0x0135:
                te.g r5 = se.d.f25976c
                if (r5 == 0) goto L_0x0144
                te.c r5 = r5.L
                if (r5 == 0) goto L_0x0144
                android.view.View r5 = r5.getRoot()
                goto L_0x0145
            L_0x0144:
                r5 = r1
            L_0x0145:
                if (r5 != 0) goto L_0x0148
                goto L_0x014b
            L_0x0148:
                r5.setVisibility(r4)
            L_0x014b:
                te.g r4 = se.d.f25976c
                if (r4 == 0) goto L_0x0158
                android.widget.LinearLayout r4 = r4.E
                if (r4 == 0) goto L_0x0158
                r4.clearAnimation()
            L_0x0158:
                te.g r4 = se.d.f25976c
                if (r4 == 0) goto L_0x0161
                android.widget.LinearLayout r4 = r4.E
                goto L_0x0162
            L_0x0161:
                r4 = r1
            L_0x0162:
                if (r4 != 0) goto L_0x0165
                goto L_0x0168
            L_0x0165:
                r4.setVisibility(r0)
            L_0x0168:
                te.g r4 = se.d.f25976c
                if (r4 == 0) goto L_0x0175
                android.widget.RelativeLayout r4 = r4.G
                if (r4 == 0) goto L_0x0175
                r4.clearAnimation()
            L_0x0175:
                te.g r4 = se.d.f25976c
                if (r4 == 0) goto L_0x017e
                android.widget.RelativeLayout r4 = r4.G
                goto L_0x017f
            L_0x017e:
                r4 = r1
            L_0x017f:
                if (r4 != 0) goto L_0x0182
                goto L_0x0185
            L_0x0182:
                r4.setVisibility(r0)
            L_0x0185:
                te.g r4 = se.d.f25976c
                if (r4 == 0) goto L_0x0192
                android.widget.ImageView r4 = r4.D
                if (r4 == 0) goto L_0x0192
                r4.clearAnimation()
            L_0x0192:
                te.g r4 = se.d.f25976c
                if (r4 == 0) goto L_0x019a
                android.widget.ImageView r1 = r4.D
            L_0x019a:
                if (r1 != 0) goto L_0x019d
                goto L_0x01a0
            L_0x019d:
                r1.setVisibility(r0)
            L_0x01a0:
                java.lang.Runnable r4 = se.d.f25982i
                if (r4 == 0) goto L_0x01b1
                android.os.Handler r5 = se.d.f25979f
                if (r5 == 0) goto L_0x01b1
                r0 = 3000(0xbb8, double:1.482E-320)
                r5.postDelayed(r4, r0)
            L_0x01b1:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: se.d.e.onPlayEvent(com.tencent.rtmp.TXVodPlayer, int, android.os.Bundle):void");
        }
    }

    public static final class f extends ViewOutlineProvider {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ float f25989a;

        public f(float f11) {
            this.f25989a = f11;
        }

        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.f25989a);
        }
    }

    public static final void m(ViewGroup viewGroup, String str, int i11, boolean z11, e eVar, int i12, int i13) {
        ImageView imageView;
        te.c cVar;
        te.e eVar2;
        TXCloudVideoView tXCloudVideoView;
        ImageView imageView2;
        View root;
        View root2;
        View root3;
        e eVar3 = f25984k;
        if (eVar3 != null) {
            eVar3.c();
        }
        d dVar = f25974a;
        f25977d = str;
        g gVar = f25976c;
        View view = null;
        if (gVar == null) {
            g K = g.K(LayoutInflater.from(viewGroup.getContext()));
            f25976c = K;
            x(K != null ? K.J : null, (float) com.hbg.module.libkt.base.ext.c.d(Float.valueOf(8.0f)));
            TXVodPlayer tXVodPlayer = new TXVodPlayer(viewGroup.getContext());
            f25975b = tXVodPlayer;
            g gVar2 = f25976c;
            tXVodPlayer.setPlayerView(gVar2 != null ? gVar2.J : null);
            TXVodPlayer tXVodPlayer2 = f25975b;
            if (tXVodPlayer2 != null) {
                tXVodPlayer2.setRenderMode(1);
            }
            f25983j = false;
            TXVodPlayer tXVodPlayer3 = f25975b;
            if (tXVodPlayer3 != null) {
                tXVodPlayer3.setMute(false);
            }
            f25982i = c.f53441b;
            f25979f = new Handler(Looper.getMainLooper());
            dVar.r();
            dVar.v();
            dVar.u();
        } else {
            if (((gVar == null || (root3 = gVar.getRoot()) == null) ? null : root3.getParent()) != null) {
                g gVar3 = f25976c;
                if (((gVar3 == null || (root2 = gVar3.getRoot()) == null) ? null : root2.getParent()) instanceof ViewGroup) {
                    g gVar4 = f25976c;
                    ViewGroup viewGroup2 = (ViewGroup) ((gVar4 == null || (root = gVar4.getRoot()) == null) ? null : root.getParent());
                    g gVar5 = f25976c;
                    viewGroup2.removeView(gVar5 != null ? gVar5.getRoot() : null);
                }
            }
            TXVodPlayer tXVodPlayer4 = f25975b;
            if (tXVodPlayer4 != null) {
                tXVodPlayer4.stopPlay(true);
            }
            g gVar6 = f25976c;
            if (!(gVar6 == null || (imageView2 = gVar6.D) == null)) {
                imageView2.setImageResource(R$drawable.icon_video_play);
            }
        }
        if (i12 > 0 && i13 > 0) {
            g gVar7 = f25976c;
            ViewGroup.LayoutParams layoutParams = (gVar7 == null || (tXCloudVideoView = gVar7.J) == null) ? null : tXCloudVideoView.getLayoutParams();
            ConstraintLayout.LayoutParams layoutParams2 = layoutParams instanceof ConstraintLayout.LayoutParams ? (ConstraintLayout.LayoutParams) layoutParams : null;
            if (layoutParams2 != null) {
                layoutParams2.H = i12 > i13 ? "W,343:220" : "W,343:430";
            }
        }
        f25984k = eVar;
        if (com.hbg.module.libkt.base.ext.b.x(str)) {
            HuobiToastUtil.m(viewGroup.getContext().getResources().getString(R$string.n_live_load_failed));
            return;
        }
        if (z11) {
            g gVar8 = f25976c;
            View root4 = (gVar8 == null || (eVar2 = gVar8.K) == null) ? null : eVar2.getRoot();
            if (root4 != null) {
                root4.setVisibility(0);
            }
            g gVar9 = f25976c;
            View root5 = (gVar9 == null || (cVar = gVar9.L) == null) ? null : cVar.getRoot();
            if (root5 != null) {
                root5.setVisibility(8);
            }
            TXVodPlayer tXVodPlayer5 = f25975b;
            if (tXVodPlayer5 != null) {
                tXVodPlayer5.setStartTime((float) i11);
            }
            TXVodPlayer tXVodPlayer6 = f25975b;
            if (tXVodPlayer6 != null) {
                tXVodPlayer6.startVodPlay(str);
            }
            g gVar10 = f25976c;
            if (!(gVar10 == null || (imageView = gVar10.D) == null)) {
                imageView.setImageResource(R$drawable.icon_video_pause);
            }
        }
        g gVar11 = f25976c;
        if (gVar11 != null) {
            view = gVar11.getRoot();
        }
        viewGroup.addView(view);
    }

    public static /* synthetic */ void n(ViewGroup viewGroup, String str, int i11, boolean z11, e eVar, int i12, int i13, int i14, Object obj) {
        boolean z12 = false;
        int i15 = (i14 & 4) != 0 ? 0 : i11;
        if ((i14 & 8) == 0) {
            z12 = z11;
        }
        e eVar2 = (i14 & 16) != 0 ? null : eVar;
        int i16 = -1;
        int i17 = (i14 & 32) != 0 ? -1 : i12;
        if ((i14 & 64) == 0) {
            i16 = i13;
        }
        m(viewGroup, str, i15, z12, eVar2, i17, i16);
    }

    public static final void o() {
        f25974a.q();
    }

    @SensorsDataInstrumented
    public static final void s(View view) {
        f25974a.y();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static final void t(View view) {
        ImageView imageView;
        int i11;
        boolean z11 = !f25983j;
        f25983j = z11;
        TXVodPlayer tXVodPlayer = f25975b;
        if (tXVodPlayer != null) {
            tXVodPlayer.setMute(z11);
        }
        g gVar = f25976c;
        if (!(gVar == null || (imageView = gVar.C) == null)) {
            if (f25983j) {
                i11 = R$drawable.icon_video_mute;
            } else {
                i11 = R$drawable.icon_video_unmute;
            }
            imageView.setImageResource(i11);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static final void w() {
        ImageView imageView;
        TXVodPlayer tXVodPlayer = f25975b;
        if (tXVodPlayer != null) {
            tXVodPlayer.pause();
        }
        g gVar = f25976c;
        if (gVar != null && (imageView = gVar.D) != null) {
            imageView.setImageResource(R$drawable.icon_video_play);
        }
    }

    public static final void x(View view, float f11) {
        if (view != null && f11 > 0.0f) {
            view.setOutlineProvider(new f(f11));
            view.setClipToOutline(true);
        }
    }

    public final String p(int i11) {
        int i12 = i11 / 3600;
        String valueOf = String.valueOf(i12);
        if (valueOf.length() < 2) {
            valueOf = '0' + valueOf;
        }
        int i13 = i11 - (i12 * 3600);
        int i14 = i13 / 60;
        String valueOf2 = String.valueOf(i14);
        if (valueOf2.length() < 2) {
            valueOf2 = '0' + valueOf2;
        }
        String valueOf3 = String.valueOf(i13 - (i14 * 60));
        if (valueOf3.length() < 2) {
            valueOf3 = '0' + valueOf3;
        }
        return valueOf + ':' + valueOf2 + ':' + valueOf3;
    }

    public final void q() {
        ImageView imageView;
        ImageView imageView2;
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        g gVar = f25976c;
        boolean z11 = false;
        if (!(gVar == null || (linearLayout3 = gVar.E) == null || linearLayout3.getVisibility() != 0)) {
            z11 = true;
        }
        if (z11) {
            if (f25981h == null) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.1f);
                f25981h = alphaAnimation;
                alphaAnimation.setDuration(300);
                AlphaAnimation alphaAnimation2 = f25981h;
                if (alphaAnimation2 != null) {
                    alphaAnimation2.setAnimationListener(new a());
                }
            }
            g gVar2 = f25976c;
            if (!(gVar2 == null || (linearLayout2 = gVar2.E) == null)) {
                linearLayout2.clearAnimation();
            }
            g gVar3 = f25976c;
            if (!(gVar3 == null || (linearLayout = gVar3.E) == null)) {
                linearLayout.startAnimation(f25981h);
            }
            g gVar4 = f25976c;
            if (!(gVar4 == null || (relativeLayout2 = gVar4.G) == null)) {
                relativeLayout2.clearAnimation();
            }
            g gVar5 = f25976c;
            if (!(gVar5 == null || (relativeLayout = gVar5.G) == null)) {
                relativeLayout.startAnimation(f25981h);
            }
            g gVar6 = f25976c;
            if (!(gVar6 == null || (imageView2 = gVar6.D) == null)) {
                imageView2.clearAnimation();
            }
            g gVar7 = f25976c;
            if (gVar7 != null && (imageView = gVar7.D) != null) {
                imageView.startAnimation(f25981h);
            }
        }
    }

    public final void r() {
        ImageView imageView;
        TXCloudVideoView tXCloudVideoView;
        SeekBar seekBar;
        ImageView imageView2;
        g gVar = f25976c;
        if (!(gVar == null || (imageView2 = gVar.D) == null)) {
            r rVar = r.f24939a;
            imageView2.setOnClickListener(new b(imageView2, 800));
        }
        g gVar2 = f25976c;
        if (!(gVar2 == null || (seekBar = gVar2.F) == null)) {
            seekBar.setOnSeekBarChangeListener(new c());
        }
        g gVar3 = f25976c;
        if (!(gVar3 == null || (tXCloudVideoView = gVar3.J) == null)) {
            tXCloudVideoView.setOnClickListener(a.f53439b);
        }
        g gVar4 = f25976c;
        if (gVar4 != null && (imageView = gVar4.C) != null) {
            imageView.setOnClickListener(b.f53440b);
        }
    }

    public final void u() {
        te.c cVar;
        TextView textView;
        g gVar = f25976c;
        if (gVar != null && (cVar = gVar.L) != null && (textView = cVar.B) != null) {
            r rVar = r.f24939a;
            textView.setOnClickListener(new C0227d(textView, 800));
        }
    }

    public final void v() {
        TXVodPlayer tXVodPlayer = f25975b;
        if (tXVodPlayer != null) {
            tXVodPlayer.setVodListener(new e());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0010, code lost:
        r0 = r0.E;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void y() {
        /*
            r5 = this;
            java.lang.Runnable r0 = f25982i
            if (r0 == 0) goto L_0x000b
            android.os.Handler r1 = f25979f
            if (r1 == 0) goto L_0x000b
            r1.removeCallbacks(r0)
        L_0x000b:
            te.g r0 = f25976c
            r1 = 0
            if (r0 == 0) goto L_0x001c
            android.widget.LinearLayout r0 = r0.E
            if (r0 == 0) goto L_0x001c
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x001c
            r0 = 1
            goto L_0x001d
        L_0x001c:
            r0 = r1
        L_0x001d:
            r2 = 0
            if (r0 == 0) goto L_0x006c
            te.g r0 = f25976c
            if (r0 == 0) goto L_0x002b
            android.widget.LinearLayout r0 = r0.E
            if (r0 == 0) goto L_0x002b
            r0.clearAnimation()
        L_0x002b:
            te.g r0 = f25976c
            if (r0 == 0) goto L_0x0036
            android.widget.RelativeLayout r0 = r0.G
            if (r0 == 0) goto L_0x0036
            r0.clearAnimation()
        L_0x0036:
            te.g r0 = f25976c
            if (r0 == 0) goto L_0x0041
            android.widget.ImageView r0 = r0.D
            if (r0 == 0) goto L_0x0041
            r0.clearAnimation()
        L_0x0041:
            te.g r0 = f25976c
            if (r0 == 0) goto L_0x0048
            android.widget.LinearLayout r0 = r0.E
            goto L_0x0049
        L_0x0048:
            r0 = r2
        L_0x0049:
            if (r0 != 0) goto L_0x004c
            goto L_0x004f
        L_0x004c:
            r0.setVisibility(r1)
        L_0x004f:
            te.g r0 = f25976c
            if (r0 == 0) goto L_0x0056
            android.widget.RelativeLayout r0 = r0.G
            goto L_0x0057
        L_0x0056:
            r0 = r2
        L_0x0057:
            if (r0 != 0) goto L_0x005a
            goto L_0x005d
        L_0x005a:
            r0.setVisibility(r1)
        L_0x005d:
            te.g r0 = f25976c
            if (r0 == 0) goto L_0x0063
            android.widget.ImageView r2 = r0.D
        L_0x0063:
            if (r2 != 0) goto L_0x0067
            goto L_0x00f1
        L_0x0067:
            r2.setVisibility(r1)
            goto L_0x00f1
        L_0x006c:
            android.view.animation.AlphaAnimation r0 = f25980g
            if (r0 != 0) goto L_0x0081
            android.view.animation.AlphaAnimation r0 = new android.view.animation.AlphaAnimation
            r3 = 1036831949(0x3dcccccd, float:0.1)
            r4 = 1065353216(0x3f800000, float:1.0)
            r0.<init>(r3, r4)
            f25980g = r0
            r3 = 300(0x12c, double:1.48E-321)
            r0.setDuration(r3)
        L_0x0081:
            te.g r0 = f25976c
            if (r0 == 0) goto L_0x008c
            android.widget.LinearLayout r0 = r0.E
            if (r0 == 0) goto L_0x008c
            r0.clearAnimation()
        L_0x008c:
            te.g r0 = f25976c
            if (r0 == 0) goto L_0x0097
            android.widget.RelativeLayout r0 = r0.G
            if (r0 == 0) goto L_0x0097
            r0.clearAnimation()
        L_0x0097:
            te.g r0 = f25976c
            if (r0 == 0) goto L_0x00a2
            android.widget.ImageView r0 = r0.D
            if (r0 == 0) goto L_0x00a2
            r0.clearAnimation()
        L_0x00a2:
            te.g r0 = f25976c
            if (r0 == 0) goto L_0x00a9
            android.widget.LinearLayout r0 = r0.E
            goto L_0x00aa
        L_0x00a9:
            r0 = r2
        L_0x00aa:
            if (r0 != 0) goto L_0x00ad
            goto L_0x00b0
        L_0x00ad:
            r0.setVisibility(r1)
        L_0x00b0:
            te.g r0 = f25976c
            if (r0 == 0) goto L_0x00b7
            android.widget.RelativeLayout r0 = r0.G
            goto L_0x00b8
        L_0x00b7:
            r0 = r2
        L_0x00b8:
            if (r0 != 0) goto L_0x00bb
            goto L_0x00be
        L_0x00bb:
            r0.setVisibility(r1)
        L_0x00be:
            te.g r0 = f25976c
            if (r0 == 0) goto L_0x00c4
            android.widget.ImageView r2 = r0.D
        L_0x00c4:
            if (r2 != 0) goto L_0x00c7
            goto L_0x00ca
        L_0x00c7:
            r2.setVisibility(r1)
        L_0x00ca:
            te.g r0 = f25976c
            if (r0 == 0) goto L_0x00d7
            android.widget.LinearLayout r0 = r0.E
            if (r0 == 0) goto L_0x00d7
            android.view.animation.AlphaAnimation r1 = f25980g
            r0.startAnimation(r1)
        L_0x00d7:
            te.g r0 = f25976c
            if (r0 == 0) goto L_0x00e4
            android.widget.RelativeLayout r0 = r0.G
            if (r0 == 0) goto L_0x00e4
            android.view.animation.AlphaAnimation r1 = f25980g
            r0.startAnimation(r1)
        L_0x00e4:
            te.g r0 = f25976c
            if (r0 == 0) goto L_0x00f1
            android.widget.ImageView r0 = r0.D
            if (r0 == 0) goto L_0x00f1
            android.view.animation.AlphaAnimation r1 = f25980g
            r0.startAnimation(r1)
        L_0x00f1:
            java.lang.Runnable r0 = f25982i
            if (r0 == 0) goto L_0x00fe
            android.os.Handler r1 = f25979f
            if (r1 == 0) goto L_0x00fe
            r2 = 3000(0xbb8, double:1.482E-320)
            r1.postDelayed(r0, r2)
        L_0x00fe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: se.d.y():void");
    }
}
