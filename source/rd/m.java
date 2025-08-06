package rd;

import android.util.Log;
import com.hbg.lib.common.utils.ThreadUtils;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.module.huobi.im.gift.LiveGiftLandscapeManager;
import com.hbg.module.huobi.im.gift.d;
import com.hbg.module.huobi.im.gift.ui.LiveGiftShowView;
import com.hbg.module.huobi.im.group.ui.active.RewardsAnim;
import com.hbg.module.huobi.im.utils.MainHandler;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Subscriber;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static final m f23375a = new m();

    /* renamed from: b  reason: collision with root package name */
    public static Subscriber<Long> f23376b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f23377c;

    /* renamed from: d  reason: collision with root package name */
    public static LinkedList<RewardsAnim> f23378d = new LinkedList<>();

    /* renamed from: e  reason: collision with root package name */
    public static boolean f23379e;

    public static final class a extends BaseSubscriber<Long> {
        public static final void c() {
            m.f23375a.b();
        }

        public void b(long j11) {
            super.onNext(Long.valueOf(j11));
            Log.d("LiveGiftShowUtil", "isMainThread：" + ThreadUtils.a());
            MainHandler.f20547a.post(l.f70541b);
        }

        public /* bridge */ /* synthetic */ void onNext(Object obj) {
            b(((Number) obj).longValue());
        }
    }

    public final LinkedList<RewardsAnim> a() {
        return f23378d;
    }

    public final void b() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("giftCacheList--size:");
        LinkedList<RewardsAnim> linkedList = f23378d;
        RewardsAnim rewardsAnim = null;
        sb2.append(linkedList != null ? Integer.valueOf(linkedList.size()) : null);
        Log.d("LiveGiftShowUtil", sb2.toString());
        boolean z11 = true;
        if (!f23377c) {
            LinkedList<RewardsAnim> linkedList2 = f23378d;
            if ((linkedList2 != null ? Integer.valueOf(linkedList2.size()) : null).intValue() >= 2) {
                d dVar = d.f19724a;
                LiveGiftShowView o11 = dVar.o();
                if (o11 != null && !o11.k()) {
                    Log.d("LiveGiftShowUtil", "view-up-show");
                    Log.d("LiveGiftShowUtil", "view-up-time-begin:" + System.currentTimeMillis());
                    LiveGiftShowView o12 = dVar.o();
                    if (o12 != null) {
                        LinkedList<RewardsAnim> linkedList3 = f23378d;
                        o12.l(linkedList3 != null ? linkedList3.get(0) : null);
                    }
                    Log.d("LiveGiftShowUtil", "view-up-time-end:" + System.currentTimeMillis());
                    LinkedList<RewardsAnim> linkedList4 = f23378d;
                    if (linkedList4 != null) {
                        RewardsAnim remove = linkedList4.remove(0);
                    }
                }
                LiveGiftShowView n11 = dVar.n();
                if (n11 == null || n11.k()) {
                    z11 = false;
                }
                if (z11) {
                    Log.d("LiveGiftShowUtil", "view-down-show");
                    Log.d("LiveGiftShowUtil", "view-down-time-begin:" + System.currentTimeMillis());
                    LiveGiftShowView n12 = dVar.n();
                    if (n12 != null) {
                        LinkedList<RewardsAnim> linkedList5 = f23378d;
                        if (linkedList5 != null) {
                            rewardsAnim = linkedList5.get(0);
                        }
                        n12.m(rewardsAnim, 300);
                    }
                    Log.d("LiveGiftShowUtil", "view-down-time-end:" + System.currentTimeMillis());
                    LinkedList<RewardsAnim> linkedList6 = f23378d;
                    if (linkedList6 != null) {
                        RewardsAnim remove2 = linkedList6.remove(0);
                        return;
                    }
                    return;
                }
                return;
            }
            LinkedList<RewardsAnim> linkedList7 = f23378d;
            if ((linkedList7 != null ? Integer.valueOf(linkedList7.size()) : null).intValue() == 1) {
                d dVar2 = d.f19724a;
                LiveGiftShowView o13 = dVar2.o();
                if (o13 != null && !o13.k()) {
                    LiveGiftShowView o14 = dVar2.o();
                    if (o14 != null) {
                        LinkedList<RewardsAnim> linkedList8 = f23378d;
                        if (linkedList8 != null) {
                            rewardsAnim = linkedList8.get(0);
                        }
                        o14.l(rewardsAnim);
                    }
                    LinkedList<RewardsAnim> linkedList9 = f23378d;
                    if (linkedList9 != null) {
                        RewardsAnim remove3 = linkedList9.remove(0);
                        return;
                    }
                    return;
                }
                LiveGiftShowView n13 = dVar2.n();
                if (n13 == null || n13.k()) {
                    z11 = false;
                }
                if (z11) {
                    LiveGiftShowView n14 = dVar2.n();
                    if (n14 != null) {
                        LinkedList<RewardsAnim> linkedList10 = f23378d;
                        if (linkedList10 != null) {
                            rewardsAnim = linkedList10.get(0);
                        }
                        n14.m(rewardsAnim, 0);
                    }
                    LinkedList<RewardsAnim> linkedList11 = f23378d;
                    if (linkedList11 != null) {
                        RewardsAnim remove4 = linkedList11.remove(0);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        LinkedList<RewardsAnim> linkedList12 = f23378d;
        if ((linkedList12 != null ? Integer.valueOf(linkedList12.size()) : null).intValue() >= 2) {
            LiveGiftLandscapeManager liveGiftLandscapeManager = LiveGiftLandscapeManager.f19698a;
            LiveGiftShowView g11 = liveGiftLandscapeManager.g();
            if (g11 != null && !g11.k()) {
                LiveGiftShowView g12 = liveGiftLandscapeManager.g();
                if (g12 != null) {
                    LinkedList<RewardsAnim> linkedList13 = f23378d;
                    g12.l(linkedList13 != null ? linkedList13.get(0) : null);
                }
                LinkedList<RewardsAnim> linkedList14 = f23378d;
                if (linkedList14 != null) {
                    RewardsAnim remove5 = linkedList14.remove(0);
                }
            }
            LiveGiftShowView f11 = liveGiftLandscapeManager.f();
            if (f11 == null || f11.k()) {
                z11 = false;
            }
            if (z11) {
                LiveGiftShowView f12 = liveGiftLandscapeManager.f();
                if (f12 != null) {
                    LinkedList<RewardsAnim> linkedList15 = f23378d;
                    if (linkedList15 != null) {
                        rewardsAnim = linkedList15.get(0);
                    }
                    f12.m(rewardsAnim, 300);
                }
                LinkedList<RewardsAnim> linkedList16 = f23378d;
                if (linkedList16 != null) {
                    RewardsAnim remove6 = linkedList16.remove(0);
                    return;
                }
                return;
            }
            return;
        }
        LinkedList<RewardsAnim> linkedList17 = f23378d;
        if ((linkedList17 != null ? Integer.valueOf(linkedList17.size()) : null).intValue() == 1) {
            LiveGiftLandscapeManager liveGiftLandscapeManager2 = LiveGiftLandscapeManager.f19698a;
            LiveGiftShowView g13 = liveGiftLandscapeManager2.g();
            if (g13 != null && !g13.k()) {
                LiveGiftShowView g14 = liveGiftLandscapeManager2.g();
                if (g14 != null) {
                    LinkedList<RewardsAnim> linkedList18 = f23378d;
                    if (linkedList18 != null) {
                        rewardsAnim = linkedList18.get(0);
                    }
                    g14.l(rewardsAnim);
                }
                LinkedList<RewardsAnim> linkedList19 = f23378d;
                if (linkedList19 != null) {
                    RewardsAnim remove7 = linkedList19.remove(0);
                    return;
                }
                return;
            }
            LiveGiftShowView f13 = liveGiftLandscapeManager2.f();
            if (f13 == null || f13.k()) {
                z11 = false;
            }
            if (z11) {
                LiveGiftShowView f14 = liveGiftLandscapeManager2.f();
                if (f14 != null) {
                    LinkedList<RewardsAnim> linkedList20 = f23378d;
                    if (linkedList20 != null) {
                        rewardsAnim = linkedList20.get(0);
                    }
                    f14.m(rewardsAnim, 0);
                }
                LinkedList<RewardsAnim> linkedList21 = f23378d;
                if (linkedList21 != null) {
                    RewardsAnim remove8 = linkedList21.remove(0);
                }
            }
        }
    }

    public final void c(boolean z11) {
        f23377c = z11;
    }

    public final void d() {
        Log.d("LiveGiftShowUtil", "hasStarted:" + f23379e);
        if (!f23379e) {
            Subscriber<Long> subscriber = f23376b;
            if (subscriber != null) {
                subscriber.unsubscribe();
            }
            f23376b = new a();
            Observable.interval(0, 2000, TimeUnit.MILLISECONDS).subscribe(f23376b);
            f23379e = true;
            Log.d("LiveGiftShowUtil", "startInterval");
        }
    }

    public final void e() {
        Subscriber<Long> subscriber = f23376b;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
        f23379e = false;
        LinkedList<RewardsAnim> linkedList = f23378d;
        if (linkedList != null) {
            linkedList.clear();
        }
        Log.d("LiveGiftShowUtil", "stopInterval");
    }
}
