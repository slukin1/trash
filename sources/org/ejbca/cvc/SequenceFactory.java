package org.ejbca.cvc;

public class SequenceFactory {

    /* renamed from: org.ejbca.cvc.SequenceFactory$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$ejbca$cvc$CVCTagEnum;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                org.ejbca.cvc.CVCTagEnum[] r0 = org.ejbca.cvc.CVCTagEnum.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$ejbca$cvc$CVCTagEnum = r0
                org.ejbca.cvc.CVCTagEnum r1 = org.ejbca.cvc.CVCTagEnum.CV_CERTIFICATE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$ejbca$cvc$CVCTagEnum     // Catch:{ NoSuchFieldError -> 0x001d }
                org.ejbca.cvc.CVCTagEnum r1 = org.ejbca.cvc.CVCTagEnum.CERTIFICATE_BODY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$org$ejbca$cvc$CVCTagEnum     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.ejbca.cvc.CVCTagEnum r1 = org.ejbca.cvc.CVCTagEnum.PUBLIC_KEY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$org$ejbca$cvc$CVCTagEnum     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.ejbca.cvc.CVCTagEnum r1 = org.ejbca.cvc.CVCTagEnum.HOLDER_AUTH_TEMPLATE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$org$ejbca$cvc$CVCTagEnum     // Catch:{ NoSuchFieldError -> 0x003e }
                org.ejbca.cvc.CVCTagEnum r1 = org.ejbca.cvc.CVCTagEnum.REQ_AUTHENTICATION     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$org$ejbca$cvc$CVCTagEnum     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.ejbca.cvc.CVCTagEnum r1 = org.ejbca.cvc.CVCTagEnum.CERTIFICATE_EXTENSIONS     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$org$ejbca$cvc$CVCTagEnum     // Catch:{ NoSuchFieldError -> 0x0054 }
                org.ejbca.cvc.CVCTagEnum r1 = org.ejbca.cvc.CVCTagEnum.DISCRETIONARY_DATA_TEMPLATE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.ejbca.cvc.SequenceFactory.AnonymousClass1.<clinit>():void");
        }
    }

    public static AbstractSequence createSequence(CVCTagEnum cVCTagEnum) {
        if (cVCTagEnum.isSequence()) {
            switch (AnonymousClass1.$SwitchMap$org$ejbca$cvc$CVCTagEnum[cVCTagEnum.ordinal()]) {
                case 1:
                    return new CVCertificate();
                case 2:
                    return new CVCertificateBody();
                case 3:
                    return new GenericPublicKeyField();
                case 4:
                    return new CVCAuthorizationTemplate();
                case 5:
                    return new CVCAuthenticatedRequest();
                case 6:
                    return new CVCertificateExtensions();
                case 7:
                    return new CVCDiscretionaryDataTemplate();
                default:
                    throw new IllegalArgumentException("Unsupported type " + cVCTagEnum);
            }
        } else {
            throw new IllegalArgumentException("Tag " + cVCTagEnum + " is not a sequence");
        }
    }
}
