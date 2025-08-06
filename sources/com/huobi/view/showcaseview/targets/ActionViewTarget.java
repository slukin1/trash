package com.huobi.view.showcaseview.targets;

import android.app.Activity;
import android.graphics.Point;

public class ActionViewTarget implements Target {
    public ActionBarViewWrapper mActionBarWrapper;
    private final Activity mActivity;
    public Reflector mReflector;
    private final Type mType;

    /* renamed from: com.huobi.view.showcaseview.targets.ActionViewTarget$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$huobi$view$showcaseview$targets$ActionViewTarget$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.huobi.view.showcaseview.targets.ActionViewTarget$Type[] r0 = com.huobi.view.showcaseview.targets.ActionViewTarget.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$huobi$view$showcaseview$targets$ActionViewTarget$Type = r0
                com.huobi.view.showcaseview.targets.ActionViewTarget$Type r1 = com.huobi.view.showcaseview.targets.ActionViewTarget.Type.SPINNER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$huobi$view$showcaseview$targets$ActionViewTarget$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huobi.view.showcaseview.targets.ActionViewTarget$Type r1 = com.huobi.view.showcaseview.targets.ActionViewTarget.Type.HOME     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$huobi$view$showcaseview$targets$ActionViewTarget$Type     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.huobi.view.showcaseview.targets.ActionViewTarget$Type r1 = com.huobi.view.showcaseview.targets.ActionViewTarget.Type.OVERFLOW     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$huobi$view$showcaseview$targets$ActionViewTarget$Type     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.huobi.view.showcaseview.targets.ActionViewTarget$Type r1 = com.huobi.view.showcaseview.targets.ActionViewTarget.Type.TITLE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$huobi$view$showcaseview$targets$ActionViewTarget$Type     // Catch:{ NoSuchFieldError -> 0x003e }
                com.huobi.view.showcaseview.targets.ActionViewTarget$Type r1 = com.huobi.view.showcaseview.targets.ActionViewTarget.Type.MEDIA_ROUTE_BUTTON     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.view.showcaseview.targets.ActionViewTarget.AnonymousClass1.<clinit>():void");
        }
    }

    public enum Type {
        SPINNER,
        HOME,
        TITLE,
        OVERFLOW,
        MEDIA_ROUTE_BUTTON
    }

    public ActionViewTarget(Activity activity, Type type) {
        this.mActivity = activity;
        this.mType = type;
    }

    public Point getPoint() {
        ViewTarget viewTarget;
        setUp();
        int i11 = AnonymousClass1.$SwitchMap$com$huobi$view$showcaseview$targets$ActionViewTarget$Type[this.mType.ordinal()];
        if (i11 == 1) {
            viewTarget = new ViewTarget(this.mActionBarWrapper.getSpinnerView());
        } else if (i11 == 2) {
            viewTarget = new ViewTarget(this.mReflector.getHomeButton());
        } else if (i11 == 3) {
            viewTarget = new ViewTarget(this.mActionBarWrapper.getOverflowView());
        } else if (i11 == 4) {
            viewTarget = new ViewTarget(this.mActionBarWrapper.getTitleView());
        } else if (i11 != 5) {
            viewTarget = null;
        } else {
            viewTarget = new ViewTarget(this.mActionBarWrapper.getMediaRouterButtonView());
        }
        return viewTarget.getPoint();
    }

    public void setUp() {
        Reflector reflectorForActivity = ReflectorFactory.getReflectorForActivity(this.mActivity);
        this.mReflector = reflectorForActivity;
        this.mActionBarWrapper = new ActionBarViewWrapper(reflectorForActivity.getActionBarView());
    }
}
