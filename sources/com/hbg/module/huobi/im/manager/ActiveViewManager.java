package com.hbg.module.huobi.im.manager;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.WindowManager;
import com.google.gson.Gson;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.GlobalAppConfig;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.PhoneUtils;
import com.hbg.lib.core.util.p;
import com.hbg.lib.core.webview.bean.JsMessage;
import com.hbg.module.huobi.im.gift.LiveGiftShowType;
import com.hbg.module.huobi.im.gift.ui.LiveGiftShowView;
import com.hbg.module.huobi.im.group.ui.active.ActiveView;
import com.hbg.module.huobi.im.group.ui.active.H5GiftSendListener;
import com.hbg.module.huobi.im.group.ui.active.LiveRewardsData;
import com.hbg.module.huobi.im.group.ui.active.RewardsAnim;
import com.hbg.module.huobi.im.utils.MainHandler;
import com.huawei.hms.framework.common.ContainerUtils;
import i6.d;
import i6.k;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import rd.j;
import rd.m;

public class ActiveViewManager {

    /* renamed from: f  reason: collision with root package name */
    public static volatile ActiveViewManager f20519f;

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<ActiveView> f20520a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    public boolean f20521b = false;

    /* renamed from: c  reason: collision with root package name */
    public qd.a f20522c;

    /* renamed from: d  reason: collision with root package name */
    public List<ActiveView> f20523d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public H5GiftSendListener f20524e = null;

    public class a implements ActiveView.ActiveEventCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ActiveView f20525a;

        public a(ActiveView activeView) {
            this.f20525a = activeView;
        }

        public void onClose(String str) {
            d.b("ActiveViewManager-->onClose:" + str);
            if (!TextUtils.isEmpty(str)) {
                BaseModuleConfig.a().k0(str);
            }
            ActiveViewManager.this.m(this.f20525a.activeType);
        }
    }

    public class b implements ActiveView.DialogDispatchCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ActiveView f20527a;

        public b(ActiveView activeView) {
            this.f20527a = activeView;
        }

        public boolean onDialogDispatch(MotionEvent motionEvent) {
            return ActiveViewManager.this.o(motionEvent, this.f20527a.activeType);
        }
    }

    public static ActiveViewManager e() {
        if (f20519f == null) {
            synchronized (ActiveViewManager.class) {
                if (f20519f == null) {
                    f20519f = new ActiveViewManager();
                }
            }
        }
        return f20519f;
    }

    public String c(String str) {
        String format = String.format("userAgent=%s&version=%s&deviceId=%s&locale=%s&appversion=%s&isnight=%s", new Object[]{StringUtils.b("M:huobiapp:phone:android"), StringUtils.b(String.valueOf(GlobalAppConfig.c())), StringUtils.b(PhoneUtils.e()), StringUtils.b(p.b()), StringUtils.b(String.valueOf(GlobalAppConfig.c())), StringUtils.b(String.valueOf(NightHelper.e().g() ? 1 : 0))});
        if (str.contains("?")) {
            return str + ContainerUtils.FIELD_DELIMITER + format;
        }
        return str + "?" + format;
    }

    public String d(String str) {
        d.b("ActiveViewManager 拼接后的参数： " + str);
        return c(str);
    }

    public boolean f() {
        return this.f20521b;
    }

    public void h(RewardsAnim rewardsAnim, LiveGiftShowType liveGiftShowType) {
        if (rewardsAnim != null) {
            j.f().h(rewardsAnim.getGifUrl());
        }
    }

    public void i(RewardsAnim rewardsAnim, LiveGiftShowType liveGiftShowType) {
        MainHandler.f20547a.post(new pd.a(this, rewardsAnim, liveGiftShowType));
    }

    /* renamed from: j */
    public void g(RewardsAnim rewardsAnim, LiveGiftShowType liveGiftShowType) {
        if (rewardsAnim != null) {
            try {
                if (com.hbg.module.libkt.base.ext.b.x(rewardsAnim.getAvatar()) && com.hbg.module.libkt.base.ext.b.x(rewardsAnim.getNickname())) {
                    rewardsAnim.setAvatar(BaseModuleConfig.a().getAvatar());
                    rewardsAnim.setNickname(BaseModuleConfig.a().j0());
                }
                Log.d("ActiveViewManager", "RewardsAnim:" + rewardsAnim + " giftType:" + liveGiftShowType);
                m mVar = m.f23375a;
                LinkedList<RewardsAnim> a11 = mVar.a();
                if (liveGiftShowType != LiveGiftShowType.LIVE_GIFT_LANDSCAPE_SCREEN_RECEIVED) {
                    if (liveGiftShowType != LiveGiftShowType.LIVE_GIFT_PORTRAIT_SCREEN_RECEIVED) {
                        String giftId = rewardsAnim.getGiftId();
                        com.hbg.module.huobi.im.gift.d dVar = com.hbg.module.huobi.im.gift.d.f19724a;
                        LiveGiftShowView o11 = dVar.o();
                        LiveGiftShowView n11 = dVar.n();
                        if (o11 != null && o11.j(giftId, rewardsAnim.getAccounts())) {
                            o11.l(rewardsAnim);
                            return;
                        } else if (n11 != null && n11.j(giftId, rewardsAnim.getAccounts())) {
                            n11.l(rewardsAnim);
                            return;
                        } else if (o11 != null && !o11.k()) {
                            o11.l(rewardsAnim);
                            return;
                        } else if (n11 == null || n11.k()) {
                            if (a11 != null) {
                                a11.add(0, rewardsAnim);
                            }
                            mVar.d();
                        } else {
                            n11.l(rewardsAnim);
                            return;
                        }
                    }
                }
                if (a11 != null && a11.size() < 20) {
                    a11.add(rewardsAnim);
                }
                mVar.d();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public void k(JsMessage jsMessage) {
        if (this.f20520a.get(3) != null && "liveRewards".equals(jsMessage.getAction())) {
            LiveRewardsData liveRewardsData = (LiveRewardsData) new Gson().fromJson(new Gson().toJson(jsMessage.getData()), LiveRewardsData.class);
            int eventType = liveRewardsData.getEventType();
            if (eventType == 2) {
                RewardsAnim animArr = liveRewardsData.getAnimArr();
                if (animArr != null && animArr.getType() != null) {
                    if (this.f20524e != null) {
                        animArr.setAvatar(BaseModuleConfig.a().getAvatar());
                        animArr.setNickname(BaseModuleConfig.a().j0());
                        this.f20524e.onSend(animArr);
                    }
                    if (animArr.getType().intValue() == 1) {
                        h(animArr, LiveGiftShowType.LIVE_GIFT_PORTRAIT_SCREEN_RECEIVED);
                    } else {
                        i(animArr, LiveGiftShowType.LIVE_GIFT_USER_SEND);
                    }
                }
            } else if (eventType == 3) {
                Log.d("ActiveViewManager", "panel-height:" + liveRewardsData.getGiftPanelHeight());
                qd.a aVar = this.f20522c;
                if (aVar != null) {
                    aVar.a(liveRewardsData.getGiftPanelHeight());
                }
            }
        }
    }

    public void l(qd.a aVar) {
        this.f20522c = aVar;
    }

    public void m(int i11) {
        ActiveView activeView = this.f20520a.get(i11);
        if (activeView != null) {
            activeView.setVisibility(8);
            Activity activity = null;
            if (activeView.getContext() instanceof Activity) {
                d.b("ActiveViewManager mActiveDialogView.getContext() 是  activity");
                activity = (Activity) activeView.getContext();
            }
            if (activity != null) {
                d.c("ActiveViewManager", "removeDialogView,当前 activity:" + activity);
                WindowManager windowManager = (WindowManager) activity.getSystemService("window");
                try {
                    if (activeView.isAttachedToWindow() && windowManager != null) {
                        this.f20523d.remove(activeView);
                        windowManager.removeView(activeView);
                    }
                    this.f20520a.remove(i11);
                } catch (Exception e11) {
                    k.f("EXCEPTION", "remove center view:" + e11.toString());
                }
            }
            this.f20521b = false;
        }
    }

    public void n(int i11, Activity activity, String str, int i12) {
        if (activity != null) {
            m(i11);
            ActiveView activeView = new ActiveView(i11, (Context) activity);
            this.f20520a.put(i11, activeView);
            activeView.setUrl(d(str));
            activeView.setCallback(new a(activeView));
            activeView.setDialogDispatchCallback(new b(activeView));
            activeView.setAlpha(i12);
            WindowManager windowManager = (WindowManager) activity.getSystemService("window");
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.gravity = 48;
            layoutParams.format = 1;
            layoutParams.flags = 67108872;
            if (windowManager != null && !activeView.isAttachedToWindow()) {
                try {
                    activeView.update();
                    this.f20523d.add(activeView);
                    windowManager.addView(activeView, layoutParams);
                    this.f20521b = true;
                } catch (Exception e11) {
                    k.f("EXCEPTION", "add top view:" + e11.toString());
                }
            }
            d.b("ActiveViewManager-->showWebView--> url:" + str + " tag:" + activeView.getTag());
        }
    }

    public final boolean o(MotionEvent motionEvent, int i11) {
        int[] iArr = new int[2];
        ActiveView activeView = this.f20520a.get(i11);
        if (activeView == null) {
            return false;
        }
        activeView.getLocationOnScreen(iArr);
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setLocation(obtain.getX() - ((float) iArr[0]), obtain.getY() - ((float) iArr[1]));
        activeView.dispatchTouchEvent(obtain);
        return true;
    }
}
