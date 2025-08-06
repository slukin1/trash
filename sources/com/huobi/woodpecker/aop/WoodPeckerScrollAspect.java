package com.huobi.woodpecker.aop;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.huobi.woodpecker.core.ActionType;
import com.huobi.woodpecker.model.AppActionRecord;
import com.huobi.woodpecker.model.AppNewBehaviorRecord;
import com.huobi.woodpecker.utils.ContextUtil;
import com.huobi.woodpecker.utils.RecordUtil;
import java.util.Map;
import java.util.WeakHashMap;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.NoAspectBoundException;
import vu.g;
import wu.c;

public class WoodPeckerScrollAspect {

    /* renamed from: b  reason: collision with root package name */
    public static /* synthetic */ Throwable f20981b;

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ WoodPeckerScrollAspect f20982c = null;

    /* renamed from: a  reason: collision with root package name */
    public final Map<View, AppActionRecord> f20983a = new WeakHashMap();

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AppActionRecord f20984b;

        public a(AppActionRecord appActionRecord) {
            this.f20984b = appActionRecord;
        }

        public void run() {
            ((AppActionRecord.AppActionRecordData) this.f20984b.getData()).setStartCpuRate(iv.a.e().d());
            ((AppActionRecord.AppActionRecordData) this.f20984b.getData()).setStartMemory(iv.a.e().f());
        }
    }

    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AppActionRecord f20986b;

        public b(AppActionRecord appActionRecord) {
            this.f20986b = appActionRecord;
        }

        public void run() {
            ((AppActionRecord.AppActionRecordData) this.f20986b.getData()).setEndCpuRate(iv.a.e().d());
            ((AppActionRecord.AppActionRecordData) this.f20986b.getData()).setEndMemory(iv.a.e().f());
            RecordUtil.a(this.f20986b);
            c.b(this.f20986b);
        }
    }

    static {
        try {
            f20982c = new WoodPeckerScrollAspect();
        } catch (Throwable th2) {
            f20981b = th2;
        }
    }

    public static WoodPeckerScrollAspect b() {
        WoodPeckerScrollAspect woodPeckerScrollAspect = f20982c;
        if (woodPeckerScrollAspect != null) {
            return woodPeckerScrollAspect;
        }
        throw new NoAspectBoundException("com.huobi.woodpecker.aop.WoodPeckerScrollAspect", f20981b);
    }

    public void c(JoinPoint joinPoint) {
        d(joinPoint);
    }

    public final void d(JoinPoint joinPoint) {
        if (ActionType.APP_ACTION_PERF.isEnable() && joinPoint.c() != null && joinPoint.c()[0] != null && (joinPoint.b() instanceof View)) {
            int intValue = ((Integer) joinPoint.c()[0]).intValue();
            View view = (View) joinPoint.b();
            if (intValue == 0) {
                AppActionRecord appActionRecord = this.f20983a.get(view);
                if (appActionRecord != null) {
                    ((AppActionRecord.AppActionRecordData) appActionRecord.getData()).setEndTime(System.currentTimeMillis());
                    c.b(new AppNewBehaviorRecord.ScrollExitBehavior(((AppActionRecord.AppActionRecordData) appActionRecord.getData()).getName()).create());
                    this.f20983a.remove(view);
                    g.d().i(new b(appActionRecord));
                }
            } else if (intValue == 1) {
                try {
                    AppActionRecord appActionRecord2 = new AppActionRecord();
                    ((AppActionRecord.AppActionRecordData) appActionRecord2.getData()).setId(ContextUtil.h(view));
                    ((AppActionRecord.AppActionRecordData) appActionRecord2.getData()).setActionType("scroll");
                    String str = view.getContext().getClass().getSimpleName() + "->" + view.getClass().getSimpleName();
                    String h11 = ContextUtil.h(view);
                    if (!TextUtils.isEmpty(h11)) {
                        str = str + "(R.id." + h11 + ")";
                    } else if (view instanceof TextView) {
                        str = str + "->" + ((TextView) view).getText().toString();
                    }
                    ((AppActionRecord.AppActionRecordData) appActionRecord2.getData()).setName(str);
                    ((AppActionRecord.AppActionRecordData) appActionRecord2.getData()).setStartTime(System.currentTimeMillis());
                    this.f20983a.put(view, appActionRecord2);
                    c.b(new AppNewBehaviorRecord.ScrollEnterBehavior(str).create());
                    g.d().i(new a(appActionRecord2));
                } catch (Exception e11) {
                    this.f20983a.remove(view);
                    e11.printStackTrace();
                }
            }
        }
    }

    public void e(JoinPoint joinPoint) {
        d(joinPoint);
    }
}
