package fv;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.huobi.woodpecker.core.ActionType;
import com.huobi.woodpecker.model.AppActionRecord;
import com.huobi.woodpecker.model.AppNewBehaviorRecord;
import com.huobi.woodpecker.monitor.base.BaseLifecycleMonitor;
import com.huobi.woodpecker.utils.ContextUtil;
import com.huobi.woodpecker.utils.RecordUtil;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;
import vu.g;

public class e extends BaseLifecycleMonitor {

    /* renamed from: f  reason: collision with root package name */
    public static final e f22769f = new e();

    /* renamed from: c  reason: collision with root package name */
    public Method f22770c;

    /* renamed from: d  reason: collision with root package name */
    public Field f22771d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<View, AppActionRecord> f22772e = new WeakHashMap();

    public class a implements d {
        public a() {
        }

        public void a(d.a aVar, View view) {
            e.this.j(view);
        }

        public void b(d.a aVar, View view) {
            e.this.k(view);
        }
    }

    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AppActionRecord f22774b;

        public b(AppActionRecord appActionRecord) {
            this.f22774b = appActionRecord;
        }

        public void run() {
            ((AppActionRecord.AppActionRecordData) this.f22774b.getData()).setStartCpuRate(iv.a.e().d());
            ((AppActionRecord.AppActionRecordData) this.f22774b.getData()).setStartMemory(iv.a.e().f());
        }
    }

    public class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AppActionRecord f22776b;

        public c(AppActionRecord appActionRecord) {
            this.f22776b = appActionRecord;
        }

        public void run() {
            ((AppActionRecord.AppActionRecordData) this.f22776b.getData()).setEndCpuRate(iv.a.e().d());
            ((AppActionRecord.AppActionRecordData) this.f22776b.getData()).setEndMemory(iv.a.e().f());
            float startCpuRate = ((AppActionRecord.AppActionRecordData) this.f22776b.getData()).getStartCpuRate();
            float endCpuRate = ((AppActionRecord.AppActionRecordData) this.f22776b.getData()).getEndCpuRate();
            float startMemory = ((AppActionRecord.AppActionRecordData) this.f22776b.getData()).getStartMemory();
            float endMemory = ((AppActionRecord.AppActionRecordData) this.f22776b.getData()).getEndMemory();
            if (Math.abs(endCpuRate - startCpuRate) <= 100.0f && startMemory > 0.0f && endMemory > 0.0f) {
                RecordUtil.a(this.f22776b);
                wu.c.b(this.f22776b);
            }
        }
    }

    public interface d {

        public static class a implements View.OnClickListener {

            /* renamed from: b  reason: collision with root package name */
            public d f22778b;

            /* renamed from: c  reason: collision with root package name */
            public View.OnClickListener f22779c;

            public a(View.OnClickListener onClickListener, d dVar) {
                this.f22779c = onClickListener;
                this.f22778b = dVar;
            }

            @SensorsDataInstrumented
            public void onClick(View view) {
                if (this.f22778b != null && ActionType.APP_ACTION_PERF.isEnable()) {
                    this.f22778b.b(this, view);
                }
                try {
                    View.OnClickListener onClickListener = this.f22779c;
                    if (onClickListener != null) {
                        onClickListener.onClick(view);
                    }
                } finally {
                    if (this.f22778b != null && ActionType.APP_ACTION_PERF.isEnable()) {
                        this.f22778b.a(this, view);
                    }
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            }
        }

        void a(a aVar, View view);

        void b(a aVar, View view);
    }

    public static e n() {
        return f22769f;
    }

    public final void j(View view) {
        try {
            AppActionRecord appActionRecord = this.f22772e.get(view);
            if (appActionRecord != null) {
                ((AppActionRecord.AppActionRecordData) appActionRecord.getData()).setEndTime(System.currentTimeMillis());
                this.f22772e.remove(view);
                g.d().i(new c(appActionRecord));
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void k(View view) {
        try {
            AppActionRecord appActionRecord = new AppActionRecord();
            ((AppActionRecord.AppActionRecordData) appActionRecord.getData()).setActionType("tap");
            String str = view.getContext().getClass().getSimpleName() + "->" + view.getClass().getSimpleName();
            String h11 = ContextUtil.h(view);
            if (!TextUtils.isEmpty(h11)) {
                str = str + "(R.id." + h11 + ")";
            } else if (view instanceof TextView) {
                str = str + "->" + ((TextView) view).getText().toString();
            }
            ((AppActionRecord.AppActionRecordData) appActionRecord.getData()).setId(h11);
            ((AppActionRecord.AppActionRecordData) appActionRecord.getData()).setName(str);
            ((AppActionRecord.AppActionRecordData) appActionRecord.getData()).setStartTime(System.currentTimeMillis());
            this.f22772e.put(view, appActionRecord);
            wu.c.b(new AppNewBehaviorRecord.ClickBehavior(str).create());
            g.d().i(new b(appActionRecord));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void l(View view) {
        m(view);
        if (view instanceof ViewGroup) {
            int i11 = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i11 < viewGroup.getChildCount()) {
                    l(viewGroup.getChildAt(i11));
                    i11++;
                } else {
                    return;
                }
            }
        }
    }

    public final void m(View view) {
        Method method;
        View.OnClickListener onClickListener;
        if (this.f22770c == null) {
            try {
                Method declaredMethod = Class.forName("android.view.View").getDeclaredMethod("getListenerInfo", new Class[0]);
                this.f22770c = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Exception unused) {
            }
        }
        if (this.f22771d == null) {
            try {
                Field declaredField = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener");
                this.f22771d = declaredField;
                declaredField.setAccessible(true);
            } catch (Exception unused2) {
            }
        }
        if (this.f22771d != null && (method = this.f22770c) != null) {
            try {
                Object invoke = method.invoke(view, new Object[0]);
                if (invoke == null) {
                    onClickListener = null;
                } else {
                    onClickListener = (View.OnClickListener) this.f22771d.get(invoke);
                }
                if (onClickListener != null && !(onClickListener instanceof d.a)) {
                    this.f22771d.set(invoke, new d.a(onClickListener, new a()));
                }
            } catch (Exception unused3) {
            }
        }
    }

    public void onActivityResumed(Activity activity) {
        super.onActivityResumed(activity);
        if (ActionType.APP_ACTION_PERF.isEnable()) {
            l(activity.findViewById(16908290));
        }
    }
}
