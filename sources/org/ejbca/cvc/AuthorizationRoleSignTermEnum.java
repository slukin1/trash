package org.ejbca.cvc;

public enum AuthorizationRoleSignTermEnum implements AuthorizationRole {
    CVCA(192),
    DV_AB(128),
    DV_CSP(64),
    SIGNTERM(0);
    
    private byte value;

    /* renamed from: org.ejbca.cvc.AuthorizationRoleSignTermEnum$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$ejbca$cvc$AuthorizationRoleSignTermEnum = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                org.ejbca.cvc.AuthorizationRoleSignTermEnum[] r0 = org.ejbca.cvc.AuthorizationRoleSignTermEnum.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$ejbca$cvc$AuthorizationRoleSignTermEnum = r0
                org.ejbca.cvc.AuthorizationRoleSignTermEnum r1 = org.ejbca.cvc.AuthorizationRoleSignTermEnum.CVCA     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$ejbca$cvc$AuthorizationRoleSignTermEnum     // Catch:{ NoSuchFieldError -> 0x001d }
                org.ejbca.cvc.AuthorizationRoleSignTermEnum r1 = org.ejbca.cvc.AuthorizationRoleSignTermEnum.DV_AB     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$org$ejbca$cvc$AuthorizationRoleSignTermEnum     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.ejbca.cvc.AuthorizationRoleSignTermEnum r1 = org.ejbca.cvc.AuthorizationRoleSignTermEnum.DV_CSP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$org$ejbca$cvc$AuthorizationRoleSignTermEnum     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.ejbca.cvc.AuthorizationRoleSignTermEnum r1 = org.ejbca.cvc.AuthorizationRoleSignTermEnum.SIGNTERM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.ejbca.cvc.AuthorizationRoleSignTermEnum.AnonymousClass1.<clinit>():void");
        }
    }

    private AuthorizationRoleSignTermEnum(int i11) {
        this.value = (byte) i11;
    }

    public byte getValue() {
        return this.value;
    }

    public boolean isAccreditationBodyDV() {
        return this == DV_AB;
    }

    public boolean isAuthenticationTerminal() {
        return false;
    }

    public boolean isCVCA() {
        return this == CVCA;
    }

    public boolean isCertificationServiceProviderDV() {
        return this == DV_CSP;
    }

    public boolean isDV() {
        return this == DV_AB || this == DV_CSP;
    }

    public boolean isDomesticDV() {
        return false;
    }

    public boolean isForeignDV() {
        return false;
    }

    public boolean isIS() {
        return false;
    }

    public boolean isSignatureTerminal() {
        return this == SIGNTERM;
    }

    public String toString() {
        int i11 = AnonymousClass1.$SwitchMap$org$ejbca$cvc$AuthorizationRoleSignTermEnum[ordinal()];
        if (i11 == 1) {
            return "CVCA";
        }
        if (i11 == 2) {
            return "DV-Accreditation-Body";
        }
        if (i11 == 3) {
            return "DV-Certification-Service-Provider";
        }
        if (i11 == 4) {
            return "Signature-Terminal";
        }
        throw new IllegalStateException("Enum case not handled");
    }
}
