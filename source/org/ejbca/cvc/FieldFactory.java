package org.ejbca.cvc;

import java.io.IOException;

public class FieldFactory {

    /* renamed from: org.ejbca.cvc.FieldFactory$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$ejbca$cvc$CVCTagEnum;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
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
                org.ejbca.cvc.CVCTagEnum r1 = org.ejbca.cvc.CVCTagEnum.EFFECTIVE_DATE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$ejbca$cvc$CVCTagEnum     // Catch:{ NoSuchFieldError -> 0x001d }
                org.ejbca.cvc.CVCTagEnum r1 = org.ejbca.cvc.CVCTagEnum.EXPIRATION_DATE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$org$ejbca$cvc$CVCTagEnum     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.ejbca.cvc.CVCTagEnum r1 = org.ejbca.cvc.CVCTagEnum.CA_REFERENCE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$org$ejbca$cvc$CVCTagEnum     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.ejbca.cvc.CVCTagEnum r1 = org.ejbca.cvc.CVCTagEnum.HOLDER_REFERENCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$org$ejbca$cvc$CVCTagEnum     // Catch:{ NoSuchFieldError -> 0x003e }
                org.ejbca.cvc.CVCTagEnum r1 = org.ejbca.cvc.CVCTagEnum.OID     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$org$ejbca$cvc$CVCTagEnum     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.ejbca.cvc.CVCTagEnum r1 = org.ejbca.cvc.CVCTagEnum.ROLE_AND_ACCESS_RIGHTS     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$org$ejbca$cvc$CVCTagEnum     // Catch:{ NoSuchFieldError -> 0x0054 }
                org.ejbca.cvc.CVCTagEnum r1 = org.ejbca.cvc.CVCTagEnum.PROFILE_IDENTIFIER     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$org$ejbca$cvc$CVCTagEnum     // Catch:{ NoSuchFieldError -> 0x0060 }
                org.ejbca.cvc.CVCTagEnum r1 = org.ejbca.cvc.CVCTagEnum.COFACTOR_F     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.ejbca.cvc.FieldFactory.AnonymousClass1.<clinit>():void");
        }
    }

    public static AbstractDataField decodeField(CVCTagEnum cVCTagEnum, byte[] bArr) throws IOException {
        if (!cVCTagEnum.isSequence()) {
            switch (AnonymousClass1.$SwitchMap$org$ejbca$cvc$CVCTagEnum[cVCTagEnum.ordinal()]) {
                case 1:
                    return new DateField(cVCTagEnum, bArr);
                case 2:
                    return new DateField(cVCTagEnum, bArr);
                case 3:
                    return new CAReferenceField(bArr);
                case 4:
                    return new HolderReferenceField(bArr);
                case 5:
                    return new OIDField(bArr);
                case 6:
                    return new AuthorizationField(bArr);
                case 7:
                    return new IntegerField(cVCTagEnum, bArr);
                case 8:
                    return new IntegerField(cVCTagEnum, bArr);
                default:
                    return new ByteField(cVCTagEnum, bArr);
            }
        } else {
            throw new IllegalArgumentException("Tag " + cVCTagEnum + " is a sequence");
        }
    }
}
