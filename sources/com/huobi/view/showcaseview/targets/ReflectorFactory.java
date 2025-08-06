package com.huobi.view.showcaseview.targets;

import android.app.Activity;
import com.huobi.view.showcaseview.targets.Reflector;

class ReflectorFactory {

    /* renamed from: com.huobi.view.showcaseview.targets.ReflectorFactory$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$huobi$view$showcaseview$targets$Reflector$ActionBarType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.huobi.view.showcaseview.targets.Reflector$ActionBarType[] r0 = com.huobi.view.showcaseview.targets.Reflector.ActionBarType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$huobi$view$showcaseview$targets$Reflector$ActionBarType = r0
                com.huobi.view.showcaseview.targets.Reflector$ActionBarType r1 = com.huobi.view.showcaseview.targets.Reflector.ActionBarType.STANDARD     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$huobi$view$showcaseview$targets$Reflector$ActionBarType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huobi.view.showcaseview.targets.Reflector$ActionBarType r1 = com.huobi.view.showcaseview.targets.Reflector.ActionBarType.APP_COMPAT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$huobi$view$showcaseview$targets$Reflector$ActionBarType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.huobi.view.showcaseview.targets.Reflector$ActionBarType r1 = com.huobi.view.showcaseview.targets.Reflector.ActionBarType.ACTIONBAR_SHERLOCK     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.view.showcaseview.targets.ReflectorFactory.AnonymousClass1.<clinit>():void");
        }
    }

    public static Reflector getReflectorForActivity(Activity activity) {
        int i11 = AnonymousClass1.$SwitchMap$com$huobi$view$showcaseview$targets$Reflector$ActionBarType[searchForActivitySuperClass(activity).ordinal()];
        if (i11 == 1) {
            return new ActionBarReflector(activity);
        }
        if (i11 == 2) {
            return new AppCompatReflector(activity);
        }
        if (i11 != 3) {
            return null;
        }
        return new SherlockReflector(activity);
    }

    private static Reflector.ActionBarType searchForActivitySuperClass(Activity activity) {
        for (Class cls = activity.getClass(); cls != Activity.class; cls = cls.getSuperclass()) {
            if (cls.getSimpleName().equals("SherlockActivity") || cls.getSimpleName().equals("SherlockFragmentActivity")) {
                return Reflector.ActionBarType.ACTIONBAR_SHERLOCK;
            }
            if (cls.getSimpleName().equals("ActionBarActivity")) {
                return Reflector.ActionBarType.APP_COMPAT;
            }
        }
        return Reflector.ActionBarType.STANDARD;
    }
}
