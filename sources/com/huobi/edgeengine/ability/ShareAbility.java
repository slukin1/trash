package com.huobi.edgeengine.ability;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import com.eclipsesource.v8.V8Object;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.hbg.lib.core.util.RxJavaHelper;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huobi.edgeengine.ability.AbilityFunction;
import com.huobi.edgeengine.model.ShareMode;
import com.huobi.share.ImageUtil;
import com.huobi.sharev2.manager.ShareManager;
import d10.l;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.r;
import rj.b;
import rx.Observable;
import rx.subscriptions.CompositeSubscription;
import u6.g;
import z9.g1;

public final class ShareAbility extends AbstractAbility {

    /* renamed from: c  reason: collision with root package name */
    public static final a f43899c = new a((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final CompositeSubscription f43900a = new CompositeSubscription();

    /* renamed from: b  reason: collision with root package name */
    public g1 f43901b;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public static final void f(l lVar, Object obj) {
        lVar.invoke(obj);
    }

    public void a(b bVar, Object obj, AbilityFunction.a aVar) {
        Long o11;
        if (aVar == null || obj == null) {
            Log.d("Console", "call ContentAbility error");
            return;
        }
        try {
            g1 g1Var = new g1(com.blankj.utilcode.util.a.c());
            this.f43901b = g1Var;
            boolean z11 = false;
            g1Var.setCanceledOnTouchOutside(false);
            g1 g1Var2 = this.f43901b;
            if (g1Var2 != null) {
                g1Var2.setCancelable(true);
            }
            V8Object v8Object = (V8Object) obj;
            String str = "";
            String string = v8Object.contains("type") ? v8Object.getString("type") : str;
            String string2 = v8Object.contains(MessengerShareContentUtility.ATTACHMENT_TEMPLATE_TYPE) ? v8Object.getString(MessengerShareContentUtility.ATTACHMENT_TEMPLATE_TYPE) : str;
            String valueOf = v8Object.contains(HiAnalyticsConstant.HaKey.BI_KEY_WAITTIME) ? String.valueOf(v8Object.getInteger(HiAnalyticsConstant.HaKey.BI_KEY_WAITTIME)) : str;
            if (v8Object.contains("jumpUrl")) {
                str = v8Object.getString("jumpUrl");
            }
            ShareMode shareMode = new ShareMode(string2, string, valueOf, str);
            Log.d("ShareAbility", String.valueOf(shareMode));
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            String type = shareMode.getType();
            if (type != null) {
                int hashCode = type.hashCode();
                if (hashCode != -1655284090) {
                    if (hashCode != 336615957) {
                        if (hashCode == 1194071377) {
                            if (!type.equals("renderSync")) {
                                return;
                            }
                        } else {
                            return;
                        }
                    } else if (type.equals("loadEnd")) {
                        if (ref$ObjectRef.element != null) {
                            d(bVar.d(), (View) ref$ObjectRef.element, shareMode);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                } else if (!type.equals("renderAsync")) {
                    return;
                }
                String template = shareMode.getTemplate();
                if (template != null) {
                    if (template.length() > 0) {
                        z11 = true;
                    }
                }
                if (z11 && bVar != null) {
                    T D = bVar.D(shareMode.getTemplate() + ".xml", bVar.d());
                    if (D != null) {
                        ref$ObjectRef.element = D;
                        com.blankj.utilcode.util.a.c();
                        g1 g1Var3 = this.f43901b;
                        if (g1Var3 != null) {
                            g1Var3.show();
                        }
                        String waitTime = shareMode.getWaitTime();
                        e((waitTime == null || (o11 = StringsKt__StringNumberConversionsKt.o(waitTime)) == null) ? 2 : o11.longValue(), new ShareAbility$call$1(this, bVar, ref$ObjectRef, shareMode));
                    }
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public boolean b() {
        return false;
    }

    public final void d(Context context, View view, ShareMode shareMode) {
        Bitmap c11 = ImageUtil.c(context, view);
        if (c11 != null) {
            ShareManager.getInstance().newShareWithImages(c11, shareMode.getJumpUrl(), "123");
            this.f43900a.clear();
            g1 g1Var = this.f43901b;
            if (g1Var != null) {
                g1Var.dismiss();
            }
        }
    }

    public final void e(long j11, d10.a<Unit> aVar) {
        this.f43900a.add(Observable.timer(j11, TimeUnit.SECONDS).compose(RxJavaHelper.t((g) null)).subscribe(new f0(new ShareAbility$waitFunction$1(aVar))));
    }
}
