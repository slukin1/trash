package org.jmrtd.cert;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;
import java.util.Date;
import org.ejbca.cvc.AccessRightEnum;
import org.ejbca.cvc.AuthorizationRoleEnum;
import org.ejbca.cvc.CAReferenceField;
import org.ejbca.cvc.CertificateGenerator;
import org.ejbca.cvc.HolderReferenceField;
import org.ejbca.cvc.exception.ConstructionException;
import org.jmrtd.cert.CVCAuthorizationTemplate;

public class CVCertificateBuilder {

    /* renamed from: org.jmrtd.cert.CVCertificateBuilder$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$jmrtd$cert$CVCAuthorizationTemplate$Permission;
        public static final /* synthetic */ int[] $SwitchMap$org$jmrtd$cert$CVCAuthorizationTemplate$Role;

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|(3:23|24|26)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0058 */
        static {
            /*
                org.jmrtd.cert.CVCAuthorizationTemplate$Permission[] r0 = org.jmrtd.cert.CVCAuthorizationTemplate.Permission.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jmrtd$cert$CVCAuthorizationTemplate$Permission = r0
                r1 = 1
                org.jmrtd.cert.CVCAuthorizationTemplate$Permission r2 = org.jmrtd.cert.CVCAuthorizationTemplate.Permission.READ_ACCESS_NONE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$org$jmrtd$cert$CVCAuthorizationTemplate$Permission     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jmrtd.cert.CVCAuthorizationTemplate$Permission r3 = org.jmrtd.cert.CVCAuthorizationTemplate.Permission.READ_ACCESS_DG3     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$org$jmrtd$cert$CVCAuthorizationTemplate$Permission     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.jmrtd.cert.CVCAuthorizationTemplate$Permission r4 = org.jmrtd.cert.CVCAuthorizationTemplate.Permission.READ_ACCESS_DG4     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = $SwitchMap$org$jmrtd$cert$CVCAuthorizationTemplate$Permission     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.jmrtd.cert.CVCAuthorizationTemplate$Permission r5 = org.jmrtd.cert.CVCAuthorizationTemplate.Permission.READ_ACCESS_DG3_AND_DG4     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                org.jmrtd.cert.CVCAuthorizationTemplate$Role[] r4 = org.jmrtd.cert.CVCAuthorizationTemplate.Role.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                $SwitchMap$org$jmrtd$cert$CVCAuthorizationTemplate$Role = r4
                org.jmrtd.cert.CVCAuthorizationTemplate$Role r5 = org.jmrtd.cert.CVCAuthorizationTemplate.Role.CVCA     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r1 = $SwitchMap$org$jmrtd$cert$CVCAuthorizationTemplate$Role     // Catch:{ NoSuchFieldError -> 0x004e }
                org.jmrtd.cert.CVCAuthorizationTemplate$Role r4 = org.jmrtd.cert.CVCAuthorizationTemplate.Role.DV_D     // Catch:{ NoSuchFieldError -> 0x004e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = $SwitchMap$org$jmrtd$cert$CVCAuthorizationTemplate$Role     // Catch:{ NoSuchFieldError -> 0x0058 }
                org.jmrtd.cert.CVCAuthorizationTemplate$Role r1 = org.jmrtd.cert.CVCAuthorizationTemplate.Role.DV_F     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r0 = $SwitchMap$org$jmrtd$cert$CVCAuthorizationTemplate$Role     // Catch:{ NoSuchFieldError -> 0x0062 }
                org.jmrtd.cert.CVCAuthorizationTemplate$Role r1 = org.jmrtd.cert.CVCAuthorizationTemplate.Role.IS     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jmrtd.cert.CVCertificateBuilder.AnonymousClass1.<clinit>():void");
        }
    }

    private CVCertificateBuilder() {
    }

    public static CardVerifiableCertificate createCertificate(PublicKey publicKey, PrivateKey privateKey, String str, CVCPrincipal cVCPrincipal, CVCPrincipal cVCPrincipal2, CVCAuthorizationTemplate cVCAuthorizationTemplate, Date date, Date date2, String str2) throws IOException, NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, SignatureException, ConstructionException {
        return new CardVerifiableCertificate(CertificateGenerator.createCertificate(publicKey, privateKey, str, new CAReferenceField(cVCPrincipal.getCountry().toAlpha2Code(), cVCPrincipal.getMnemonic(), cVCPrincipal.getSeqNumber()), new HolderReferenceField(cVCPrincipal2.getCountry().toAlpha2Code(), cVCPrincipal2.getMnemonic(), cVCPrincipal2.getSeqNumber()), getRole(cVCAuthorizationTemplate.getRole()), getAccessRight(cVCAuthorizationTemplate.getAccessRight()), date, date2, str2));
    }

    private static AccessRightEnum getAccessRight(CVCAuthorizationTemplate.Permission permission) {
        int i11 = AnonymousClass1.$SwitchMap$org$jmrtd$cert$CVCAuthorizationTemplate$Permission[permission.ordinal()];
        if (i11 == 1) {
            return AccessRightEnum.READ_ACCESS_NONE;
        }
        if (i11 == 2) {
            return AccessRightEnum.READ_ACCESS_DG3;
        }
        if (i11 == 3) {
            return AccessRightEnum.READ_ACCESS_DG4;
        }
        if (i11 == 4) {
            return AccessRightEnum.READ_ACCESS_DG3_AND_DG4;
        }
        throw new NumberFormatException("Cannot decode access right " + permission);
    }

    private static AuthorizationRoleEnum getRole(CVCAuthorizationTemplate.Role role) {
        int i11 = AnonymousClass1.$SwitchMap$org$jmrtd$cert$CVCAuthorizationTemplate$Role[role.ordinal()];
        if (i11 == 1) {
            return AuthorizationRoleEnum.CVCA;
        }
        if (i11 == 2) {
            return AuthorizationRoleEnum.DV_D;
        }
        if (i11 == 3) {
            return AuthorizationRoleEnum.DV_F;
        }
        if (i11 == 4) {
            return AuthorizationRoleEnum.IS;
        }
        throw new NumberFormatException("Cannot decode role " + role);
    }
}
