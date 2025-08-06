package org.ejbca.cvc;

public enum AccessRightSignTermEnum implements AccessRights {
    ACCESS_NONE(0),
    ACCESS_SIGN(1),
    ACCESS_QUALSIGN(2),
    ACCESS_SIGN_AND_QUALSIGN(3);
    
    private byte value;

    /* renamed from: org.ejbca.cvc.AccessRightSignTermEnum$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$ejbca$cvc$AccessRightSignTermEnum = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                org.ejbca.cvc.AccessRightSignTermEnum[] r0 = org.ejbca.cvc.AccessRightSignTermEnum.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$ejbca$cvc$AccessRightSignTermEnum = r0
                org.ejbca.cvc.AccessRightSignTermEnum r1 = org.ejbca.cvc.AccessRightSignTermEnum.ACCESS_SIGN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$ejbca$cvc$AccessRightSignTermEnum     // Catch:{ NoSuchFieldError -> 0x001d }
                org.ejbca.cvc.AccessRightSignTermEnum r1 = org.ejbca.cvc.AccessRightSignTermEnum.ACCESS_QUALSIGN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$org$ejbca$cvc$AccessRightSignTermEnum     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.ejbca.cvc.AccessRightSignTermEnum r1 = org.ejbca.cvc.AccessRightSignTermEnum.ACCESS_SIGN_AND_QUALSIGN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$org$ejbca$cvc$AccessRightSignTermEnum     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.ejbca.cvc.AccessRightSignTermEnum r1 = org.ejbca.cvc.AccessRightSignTermEnum.ACCESS_NONE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.ejbca.cvc.AccessRightSignTermEnum.AnonymousClass1.<clinit>():void");
        }
    }

    private AccessRightSignTermEnum(int i11) {
        this.value = (byte) i11;
    }

    public boolean allowsQualifiedSignature() {
        return (this.value & ACCESS_QUALSIGN.value) != 0;
    }

    public boolean allowsSignature() {
        return (this.value & ACCESS_SIGN.value) != 0;
    }

    public byte[] getEncoded() {
        return new byte[]{this.value};
    }

    public byte getValue() {
        return this.value;
    }

    public String toString() {
        int i11 = AnonymousClass1.$SwitchMap$org$ejbca$cvc$AccessRightSignTermEnum[ordinal()];
        if (i11 == 1) {
            return "Signature";
        }
        if (i11 == 2) {
            return "Qualified_Signature";
        }
        if (i11 == 3) {
            return "Signature_and_Qualified_Signature";
        }
        if (i11 == 4) {
            return "none";
        }
        throw new IllegalStateException("Enum case not handled");
    }
}
