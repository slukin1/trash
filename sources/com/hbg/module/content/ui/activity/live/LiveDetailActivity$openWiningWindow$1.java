package com.hbg.module.content.ui.activity.live;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.network.hbg.core.bean.LiveDetailBean;
import com.hbg.lib.network.hbg.core.bean.LiveSpeaker;
import com.hbg.lib.network.hbg.core.bean.LiveWiningInfo;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.module.content.R$string;
import com.hbg.module.huobi.im.gift.bean.CusMsgGiftSend;
import com.hbg.module.huobi.im.gift.d;
import com.hbg.module.huobi.im.gift.ui.LiveGiftRuleDialog;
import com.hbg.module.huobi.im.gift.ui.LiveGiftShowDialog;
import com.hbg.module.livesquare.dialog.LiveSelfAwardDialog;
import com.twitter.sdk.android.core.internal.VineCardUtils;
import d10.a;
import d10.l;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import nc.c;

public final class LiveDetailActivity$openWiningWindow$1 extends Lambda implements l<LiveWiningInfo, Unit> {
    public final /* synthetic */ LiveDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveDetailActivity$openWiningWindow$1(LiveDetailActivity liveDetailActivity) {
        super(1);
        this.this$0 = liveDetailActivity;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(LiveDetailActivity liveDetailActivity) {
        LiveSelfAwardDialog Tj = liveDetailActivity.Tj();
        if (Tj != null) {
            Tj.show(liveDetailActivity.getSupportFragmentManager(), "liveSelfAwardDialog");
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LiveWiningInfo) obj);
        return Unit.f56620a;
    }

    public final void invoke(LiveWiningInfo liveWiningInfo) {
        Dialog dialog;
        this.this$0.Df();
        d dVar = d.f19724a;
        if (dVar.m() != null) {
            LiveGiftShowDialog m11 = dVar.m();
            Boolean bool = null;
            if ((m11 != null ? m11.getDialog() : null) != null) {
                LiveGiftShowDialog m12 = dVar.m();
                if (((m12 == null || (dialog = m12.getDialog()) == null) ? null : Boolean.valueOf(dialog.isShowing())).booleanValue()) {
                    LiveGiftShowDialog m13 = dVar.m();
                    if (m13 != null) {
                        bool = Boolean.valueOf(m13.isRemoving());
                    }
                    if (!bool.booleanValue()) {
                        return;
                    }
                }
            }
        }
        this.this$0.Cl(new LiveSelfAwardDialog());
        LiveSelfAwardDialog Tj = this.this$0.Tj();
        if (Tj != null) {
            Tj.Ah(liveWiningInfo);
        }
        LiveSelfAwardDialog Tj2 = this.this$0.Tj();
        if (Tj2 != null) {
            final LiveDetailActivity liveDetailActivity = this.this$0;
            Tj2.Ch(new a<Unit>() {
                /* access modifiers changed from: private */
                public static final void invoke$lambda$0(LiveDetailActivity liveDetailActivity, HBDialogFragment hBDialogFragment) {
                    if (hBDialogFragment != null) {
                        hBDialogFragment.dismiss();
                    }
                    b2.a.d().a("/webView/index").withString("url", BaseModuleConfig.a().k("topic/welfare/h5/package")).navigation(liveDetailActivity);
                }

                /* access modifiers changed from: private */
                public static final void invoke$lambda$1(LiveDetailActivity liveDetailActivity, HBDialogFragment hBDialogFragment) {
                    liveDetailActivity.startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + liveDetailActivity.getPackageName())), 201);
                    if (hBDialogFragment != null) {
                        hBDialogFragment.dismiss();
                    }
                }

                /* access modifiers changed from: private */
                public static final void invoke$lambda$2(LiveDetailActivity liveDetailActivity) {
                    liveDetailActivity.I = true;
                    liveDetailActivity.Fl();
                }

                /* access modifiers changed from: private */
                public static final boolean invoke$lambda$3(LiveDetailActivity liveDetailActivity) {
                    LiveDetailBean Hi = liveDetailActivity.f18466m;
                    if ((Hi != null && Hi.hasGift == 1) && liveDetailActivity.f18460j == 1) {
                        Pair[] pairArr = new Pair[7];
                        pairArr[0] = kotlin.l.a("state", Integer.valueOf(liveDetailActivity.f18460j));
                        pairArr[1] = kotlin.l.a("liveid", liveDetailActivity.Sj());
                        pairArr[2] = kotlin.l.a(VineCardUtils.PLAYER_CARD, 2);
                        LiveDetailBean Hi2 = liveDetailActivity.f18466m;
                        Integer num = null;
                        pairArr[3] = kotlin.l.a("title", Hi2 != null ? Hi2.title : null);
                        LiveSpeaker Ri = liveDetailActivity.f18455f0;
                        pairArr[4] = kotlin.l.a("upid", Ri != null ? Ri.showId : null);
                        pairArr[5] = kotlin.l.a("roundid", "");
                        CusMsgGiftSend j11 = d.f19724a.j();
                        if (j11 != null) {
                            num = j11.getRule();
                        }
                        pairArr[6] = kotlin.l.a("lotterytype", num);
                        c.a("APP_LIVE_notice_welfare", MapsKt__MapsKt.j(pairArr));
                    }
                    return false;
                }

                public final void invoke() {
                    Handler Li;
                    LiveSelfAwardDialog Tj = liveDetailActivity.Tj();
                    if (Tj != null) {
                        Tj.dismissAllowingStateLoss();
                    }
                    if (Build.VERSION.SDK_INT < 23 || Settings.canDrawOverlays(liveDetailActivity) || liveDetailActivity.f18460j == 1) {
                        b2.a.d().a("/webView/index").withString("url", BaseModuleConfig.a().k("topic/welfare/h5/package")).navigation(liveDetailActivity);
                        if (liveDetailActivity.J && (Li = liveDetailActivity.Zf()) != null) {
                            Li.postDelayed(new b2(liveDetailActivity), 1000);
                        }
                    } else {
                        LiveDetailActivity liveDetailActivity = liveDetailActivity;
                        DialogUtils.c0(liveDetailActivity, liveDetailActivity.getResources().getString(R$string.n_live_perm_title), liveDetailActivity.getResources().getString(R$string.n_live_perm_tips), liveDetailActivity.getResources().getString(R$string.n_cancel), liveDetailActivity.getResources().getString(R$string.n_otc_confirm_open), new z1(liveDetailActivity), new a2(liveDetailActivity));
                    }
                    Looper.myQueue().addIdleHandler(new y1(liveDetailActivity));
                }
            });
        }
        LiveSelfAwardDialog Tj3 = this.this$0.Tj();
        if (Tj3 != null) {
            final LiveDetailActivity liveDetailActivity2 = this.this$0;
            Tj3.Bh(new l<String, Unit>() {

                /* renamed from: com.hbg.module.content.ui.activity.live.LiveDetailActivity$openWiningWindow$1$2$a */
                public static final class a implements LiveGiftRuleDialog.a {

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ LiveGiftRuleDialog f18573a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ LiveDetailActivity f18574b;

                    public a(LiveGiftRuleDialog liveGiftRuleDialog, LiveDetailActivity liveDetailActivity) {
                        this.f18573a = liveGiftRuleDialog;
                        this.f18574b = liveDetailActivity;
                    }

                    public void a() {
                        this.f18573a.dismissAllowingStateLoss();
                        this.f18574b.sl();
                    }

                    public void c() {
                    }
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((String) obj);
                    return Unit.f56620a;
                }

                public final void invoke(String str) {
                    LiveGiftRuleDialog liveGiftRuleDialog = new LiveGiftRuleDialog();
                    Bundle bundle = new Bundle();
                    bundle.putString("live_gift_rule_text", str);
                    liveGiftRuleDialog.setArguments(bundle);
                    liveGiftRuleDialog.wh(new a(liveGiftRuleDialog, liveDetailActivity2));
                    LiveSelfAwardDialog Tj = liveDetailActivity2.Tj();
                    if (Tj != null) {
                        Tj.dismissAllowingStateLoss();
                    }
                    liveGiftRuleDialog.show(liveDetailActivity2.getSupportFragmentManager(), "liveGiftRuleDialog");
                }
            });
        }
        LiveSelfAwardDialog Tj4 = this.this$0.Tj();
        if (Tj4 != null) {
            final LiveDetailActivity liveDetailActivity3 = this.this$0;
            Tj4.Dh(new a<Unit>() {
                /* access modifiers changed from: private */
                public static final boolean invoke$lambda$0(LiveDetailActivity liveDetailActivity) {
                    LiveDetailBean Hi = liveDetailActivity.f18466m;
                    if ((Hi != null && Hi.hasGift == 1) && liveDetailActivity.f18460j == 1) {
                        Pair[] pairArr = new Pair[7];
                        pairArr[0] = kotlin.l.a("state", Integer.valueOf(liveDetailActivity.f18460j));
                        pairArr[1] = kotlin.l.a("liveid", liveDetailActivity.Sj());
                        pairArr[2] = kotlin.l.a(VineCardUtils.PLAYER_CARD, 2);
                        LiveDetailBean Hi2 = liveDetailActivity.f18466m;
                        Integer num = null;
                        pairArr[3] = kotlin.l.a("title", Hi2 != null ? Hi2.title : null);
                        LiveSpeaker Ri = liveDetailActivity.f18455f0;
                        pairArr[4] = kotlin.l.a("upid", Ri != null ? Ri.showId : null);
                        pairArr[5] = kotlin.l.a("roundid", "");
                        CusMsgGiftSend j11 = d.f19724a.j();
                        if (j11 != null) {
                            num = j11.getRule();
                        }
                        pairArr[6] = kotlin.l.a("lotterytype", num);
                        c.a("APP_LIVE_notice_myprizeshow", MapsKt__MapsKt.j(pairArr));
                    }
                    return false;
                }

                public final void invoke() {
                    Looper.myQueue().addIdleHandler(new c2(liveDetailActivity3));
                }
            });
        }
        Handler Li = this.this$0.Zf();
        if (Li != null) {
            Li.post(new x1(this.this$0));
        }
        final LiveDetailActivity liveDetailActivity4 = this.this$0;
        dVar.V(new a<Unit>() {
            public final void invoke() {
                LiveSelfAwardDialog Tj;
                Dialog dialog;
                if (liveDetailActivity4.Tj() != null) {
                    LiveSelfAwardDialog Tj2 = liveDetailActivity4.Tj();
                    Boolean bool = null;
                    if ((Tj2 != null ? Tj2.getDialog() : null) != null) {
                        LiveSelfAwardDialog Tj3 = liveDetailActivity4.Tj();
                        if (((Tj3 == null || (dialog = Tj3.getDialog()) == null) ? null : Boolean.valueOf(dialog.isShowing())).booleanValue()) {
                            LiveSelfAwardDialog Tj4 = liveDetailActivity4.Tj();
                            if (Tj4 != null) {
                                bool = Boolean.valueOf(Tj4.isRemoving());
                            }
                            if (!bool.booleanValue() && (Tj = liveDetailActivity4.Tj()) != null) {
                                Tj.dismissAllowingStateLoss();
                            }
                        }
                    }
                }
            }
        });
    }
}
