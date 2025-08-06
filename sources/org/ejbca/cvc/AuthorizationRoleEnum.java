package org.ejbca.cvc;

public enum AuthorizationRoleEnum implements AuthorizationRole {
    CVCA(192),
    DV_D(128),
    DV_F(64),
    IS(0);
    
    private byte value;

    /* renamed from: org.ejbca.cvc.AuthorizationRoleEnum$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$ejbca$cvc$AuthorizationRoleEnum = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                org.ejbca.cvc.AuthorizationRoleEnum[] r0 = org.ejbca.cvc.AuthorizationRoleEnum.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$ejbca$cvc$AuthorizationRoleEnum = r0
                org.ejbca.cvc.AuthorizationRoleEnum r1 = org.ejbca.cvc.AuthorizationRoleEnum.CVCA     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$ejbca$cvc$AuthorizationRoleEnum     // Catch:{ NoSuchFieldError -> 0x001d }
                org.ejbca.cvc.AuthorizationRoleEnum r1 = org.ejbca.cvc.AuthorizationRoleEnum.DV_D     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$org$ejbca$cvc$AuthorizationRoleEnum     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.ejbca.cvc.AuthorizationRoleEnum r1 = org.ejbca.cvc.AuthorizationRoleEnum.DV_F     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$org$ejbca$cvc$AuthorizationRoleEnum     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.ejbca.cvc.AuthorizationRoleEnum r1 = org.ejbca.cvc.AuthorizationRoleEnum.IS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.ejbca.cvc.AuthorizationRoleEnum.AnonymousClass1.<clinit>():void");
        }
    }

    private AuthorizationRoleEnum(int i11) {
        this.value = (byte) i11;
    }

    public byte getValue() {
        return this.value;
    }

    public boolean isAccreditationBodyDV() {
        return false;
    }

    public boolean isAuthenticationTerminal() {
        return false;
    }

    public boolean isCVCA() {
        return this == CVCA;
    }

    public boolean isCertificationServiceProviderDV() {
        return false;
    }

    public boolean isDV() {
        return this == DV_D || this == DV_F;
    }

    public boolean isDomesticDV() {
        return this == DV_D;
    }

    public boolean isForeignDV() {
        return this == DV_F;
    }

    public boolean isIS() {
        return this == IS;
    }

    public boolean isSignatureTerminal() {
        return false;
    }

    public String toString() {
        int i11 = AnonymousClass1.$SwitchMap$org$ejbca$cvc$AuthorizationRoleEnum[ordinal()];
        if (i11 == 1) {
            return "CVCA";
        }
        if (i11 == 2) {
            return "DV-domestic";
        }
        if (i11 == 3) {
            return "DV-foreign";
        }
        if (i11 == 4) {
            return "IS";
        }
        throw new IllegalStateException("Enum case not handled");
    }
}
