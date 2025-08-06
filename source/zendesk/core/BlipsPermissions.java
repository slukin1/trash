package zendesk.core;

class BlipsPermissions {
    private boolean behavioural;
    private boolean pathfinder;
    private boolean required;

    /* renamed from: zendesk.core.BlipsPermissions$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$zendesk$core$BlipsGroup;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                zendesk.core.BlipsGroup[] r0 = zendesk.core.BlipsGroup.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$zendesk$core$BlipsGroup = r0
                zendesk.core.BlipsGroup r1 = zendesk.core.BlipsGroup.REQUIRED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$zendesk$core$BlipsGroup     // Catch:{ NoSuchFieldError -> 0x001d }
                zendesk.core.BlipsGroup r1 = zendesk.core.BlipsGroup.BEHAVIOURAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$zendesk$core$BlipsGroup     // Catch:{ NoSuchFieldError -> 0x0028 }
                zendesk.core.BlipsGroup r1 = zendesk.core.BlipsGroup.PATHFINDER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: zendesk.core.BlipsPermissions.AnonymousClass1.<clinit>():void");
        }
    }

    public BlipsPermissions(boolean z11, boolean z12, boolean z13) {
        this.required = z11;
        this.behavioural = z12;
        this.pathfinder = z13;
    }

    public boolean isEnabled(BlipsGroup blipsGroup) {
        int i11 = AnonymousClass1.$SwitchMap$zendesk$core$BlipsGroup[blipsGroup.ordinal()];
        if (i11 == 1) {
            return this.required;
        }
        if (i11 == 2) {
            return this.behavioural;
        }
        if (i11 != 3) {
            return false;
        }
        return this.pathfinder;
    }

    public BlipsPermissions() {
        this(false, false, false);
    }
}
