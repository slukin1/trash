package org.ejbca.cvc;

import java.math.BigInteger;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECField;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import java.util.Arrays;
import org.bouncycastle.jce.ECPointUtil;
import org.ejbca.cvc.exception.ConstructionException;

public class PublicKeyEC extends CVCPublicKey implements ECPublicKey {
    public static final byte UNCOMPRESSED_POINT_TAG = 4;
    private static CVCTagEnum[] allowedFields = {CVCTagEnum.OID, CVCTagEnum.MODULUS, CVCTagEnum.COEFFICIENT_A, CVCTagEnum.COEFFICIENT_B, CVCTagEnum.BASE_POINT_G, CVCTagEnum.BASE_POINT_R_ORDER, CVCTagEnum.PUBLIC_POINT_Y, CVCTagEnum.COFACTOR_F};
    public static final long serialVersionUID = 1;

    public PublicKeyEC(GenericPublicKeyField genericPublicKeyField) throws ConstructionException, NoSuchFieldException {
        addSubfield(genericPublicKeyField.getSubfield(CVCTagEnum.OID));
        addSubfield(genericPublicKeyField.getOptionalSubfield(CVCTagEnum.MODULUS));
        addSubfield(genericPublicKeyField.getOptionalSubfield(CVCTagEnum.COEFFICIENT_A));
        addSubfield(genericPublicKeyField.getOptionalSubfield(CVCTagEnum.COEFFICIENT_B));
        addSubfield(genericPublicKeyField.getOptionalSubfield(CVCTagEnum.BASE_POINT_G));
        addSubfield(genericPublicKeyField.getOptionalSubfield(CVCTagEnum.BASE_POINT_R_ORDER));
        addSubfield(genericPublicKeyField.getSubfield(CVCTagEnum.PUBLIC_POINT_Y));
        addSubfield(genericPublicKeyField.getOptionalSubfield(CVCTagEnum.COFACTOR_F));
    }

    public static ECPoint decodePoint(byte[] bArr) {
        if (bArr[0] == 4) {
            int length = (bArr.length - 1) / 2;
            byte[] bArr2 = new byte[length];
            int length2 = (bArr.length - 1) / 2;
            byte[] bArr3 = new byte[length2];
            System.arraycopy(bArr, 1, bArr2, 0, length);
            System.arraycopy(bArr, length + 1, bArr3, 0, length2);
            return new ECPoint(new BigInteger(1, bArr2), new BigInteger(1, bArr3));
        }
        throw new IllegalArgumentException("First byte must be 0x4");
    }

    public static byte[] encodePoint(ECPoint eCPoint, EllipticCurve ellipticCurve) {
        int i11;
        byte[] trimByteArray = CVCObject.trimByteArray(eCPoint.getAffineX().toByteArray());
        byte[] trimByteArray2 = CVCObject.trimByteArray(eCPoint.getAffineY().toByteArray());
        if (ellipticCurve != null) {
            i11 = (ellipticCurve.getField().getFieldSize() + 7) >> 3;
        } else {
            i11 = trimByteArray.length > trimByteArray2.length ? trimByteArray.length : trimByteArray2.length;
        }
        int length = trimByteArray.length < i11 ? i11 - trimByteArray.length : 0;
        int length2 = trimByteArray2.length < i11 ? i11 - trimByteArray2.length : 0;
        byte[] bArr = new byte[((i11 << 1) + 1)];
        Arrays.fill(bArr, (byte) 0);
        bArr[0] = 4;
        System.arraycopy(trimByteArray, 0, bArr, length + 1, i11 - length);
        System.arraycopy(trimByteArray2, 0, bArr, i11 + 1 + length2, i11 - length2);
        return bArr;
    }

    public String getAlgorithm() {
        return "ECDSA";
    }

    public CVCTagEnum[] getAllowedFields() {
        return allowedFields;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003f, code lost:
        if (r4.getAuthRole().isCVCA() != false) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0042, code lost:
        if (r4 == null) goto L_0x0044;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<org.ejbca.cvc.CVCObject> getEncodableFields() {
        /*
            r7 = this;
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ NoSuchFieldException -> 0x0095 }
            r0.<init>()     // Catch:{ NoSuchFieldException -> 0x0095 }
            org.ejbca.cvc.CVCTagEnum r1 = org.ejbca.cvc.CVCTagEnum.OID     // Catch:{ NoSuchFieldException -> 0x0095 }
            org.ejbca.cvc.CVCObject r1 = r7.getSubfield(r1)     // Catch:{ NoSuchFieldException -> 0x0095 }
            r0.add(r1)     // Catch:{ NoSuchFieldException -> 0x0095 }
            java.security.spec.ECParameterSpec r1 = r7.getParams()     // Catch:{ NoSuchFieldException -> 0x0095 }
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0045
            org.ejbca.cvc.AbstractSequence r4 = r7.getParent()     // Catch:{ NoSuchFieldException -> 0x0095 }
            if (r4 == 0) goto L_0x0042
            org.ejbca.cvc.CVCTagEnum r5 = r4.getTag()     // Catch:{ NoSuchFieldException -> 0x0095 }
            org.ejbca.cvc.CVCTagEnum r6 = org.ejbca.cvc.CVCTagEnum.CERTIFICATE_BODY     // Catch:{ NoSuchFieldException -> 0x0095 }
            if (r5 != r6) goto L_0x0042
            org.ejbca.cvc.CVCertificateBody r4 = (org.ejbca.cvc.CVCertificateBody) r4     // Catch:{ NoSuchFieldException -> 0x0045 }
            org.ejbca.cvc.CVCTagEnum r5 = org.ejbca.cvc.CVCTagEnum.HOLDER_AUTH_TEMPLATE     // Catch:{ NoSuchFieldException -> 0x0045 }
            org.ejbca.cvc.CVCObject r4 = r4.getOptionalSubfield(r5)     // Catch:{ NoSuchFieldException -> 0x0045 }
            if (r4 != 0) goto L_0x002f
            goto L_0x0044
        L_0x002f:
            org.ejbca.cvc.CVCAuthorizationTemplate r4 = (org.ejbca.cvc.CVCAuthorizationTemplate) r4     // Catch:{ NoSuchFieldException -> 0x0045 }
            org.ejbca.cvc.AuthorizationField r4 = r4.getAuthorizationField()     // Catch:{ NoSuchFieldException -> 0x0045 }
            if (r4 == 0) goto L_0x0045
            org.ejbca.cvc.AuthorizationRole r4 = r4.getAuthRole()     // Catch:{ NoSuchFieldException -> 0x0045 }
            boolean r4 = r4.isCVCA()     // Catch:{ NoSuchFieldException -> 0x0045 }
            if (r4 == 0) goto L_0x0045
            goto L_0x0044
        L_0x0042:
            if (r4 != 0) goto L_0x0045
        L_0x0044:
            r2 = r3
        L_0x0045:
            if (r2 == 0) goto L_0x0080
            java.security.spec.EllipticCurve r1 = r1.getCurve()     // Catch:{ NoSuchFieldException -> 0x0095 }
            java.security.spec.ECField r1 = r1.getField()     // Catch:{ NoSuchFieldException -> 0x0095 }
            boolean r1 = r1 instanceof java.security.spec.ECFieldFp     // Catch:{ NoSuchFieldException -> 0x0095 }
            if (r1 == 0) goto L_0x005c
            org.ejbca.cvc.CVCTagEnum r1 = org.ejbca.cvc.CVCTagEnum.MODULUS     // Catch:{ NoSuchFieldException -> 0x0095 }
            org.ejbca.cvc.CVCObject r1 = r7.getSubfield(r1)     // Catch:{ NoSuchFieldException -> 0x0095 }
            r0.add(r1)     // Catch:{ NoSuchFieldException -> 0x0095 }
        L_0x005c:
            org.ejbca.cvc.CVCTagEnum r1 = org.ejbca.cvc.CVCTagEnum.COEFFICIENT_A     // Catch:{ NoSuchFieldException -> 0x0095 }
            org.ejbca.cvc.CVCObject r1 = r7.getSubfield(r1)     // Catch:{ NoSuchFieldException -> 0x0095 }
            r0.add(r1)     // Catch:{ NoSuchFieldException -> 0x0095 }
            org.ejbca.cvc.CVCTagEnum r1 = org.ejbca.cvc.CVCTagEnum.COEFFICIENT_B     // Catch:{ NoSuchFieldException -> 0x0095 }
            org.ejbca.cvc.CVCObject r1 = r7.getSubfield(r1)     // Catch:{ NoSuchFieldException -> 0x0095 }
            r0.add(r1)     // Catch:{ NoSuchFieldException -> 0x0095 }
            org.ejbca.cvc.CVCTagEnum r1 = org.ejbca.cvc.CVCTagEnum.BASE_POINT_G     // Catch:{ NoSuchFieldException -> 0x0095 }
            org.ejbca.cvc.CVCObject r1 = r7.getSubfield(r1)     // Catch:{ NoSuchFieldException -> 0x0095 }
            r0.add(r1)     // Catch:{ NoSuchFieldException -> 0x0095 }
            org.ejbca.cvc.CVCTagEnum r1 = org.ejbca.cvc.CVCTagEnum.BASE_POINT_R_ORDER     // Catch:{ NoSuchFieldException -> 0x0095 }
            org.ejbca.cvc.CVCObject r1 = r7.getSubfield(r1)     // Catch:{ NoSuchFieldException -> 0x0095 }
            r0.add(r1)     // Catch:{ NoSuchFieldException -> 0x0095 }
        L_0x0080:
            org.ejbca.cvc.CVCTagEnum r1 = org.ejbca.cvc.CVCTagEnum.PUBLIC_POINT_Y     // Catch:{ NoSuchFieldException -> 0x0095 }
            org.ejbca.cvc.CVCObject r1 = r7.getSubfield(r1)     // Catch:{ NoSuchFieldException -> 0x0095 }
            r0.add(r1)     // Catch:{ NoSuchFieldException -> 0x0095 }
            if (r2 == 0) goto L_0x0094
            org.ejbca.cvc.CVCTagEnum r1 = org.ejbca.cvc.CVCTagEnum.COFACTOR_F     // Catch:{ NoSuchFieldException -> 0x0095 }
            org.ejbca.cvc.CVCObject r1 = r7.getSubfield(r1)     // Catch:{ NoSuchFieldException -> 0x0095 }
            r0.add(r1)     // Catch:{ NoSuchFieldException -> 0x0095 }
        L_0x0094:
            return r0
        L_0x0095:
            r0 = move-exception
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.ejbca.cvc.PublicKeyEC.getEncodableFields():java.util.List");
    }

    public String getFormat() {
        return "CVC";
    }

    public ECParameterSpec getParams() {
        ByteField byteField = (ByteField) getOptionalSubfield(CVCTagEnum.MODULUS);
        ByteField byteField2 = (ByteField) getOptionalSubfield(CVCTagEnum.COEFFICIENT_A);
        ByteField byteField3 = (ByteField) getOptionalSubfield(CVCTagEnum.COEFFICIENT_B);
        ByteField byteField4 = (ByteField) getOptionalSubfield(CVCTagEnum.BASE_POINT_G);
        ByteField byteField5 = (ByteField) getOptionalSubfield(CVCTagEnum.BASE_POINT_R_ORDER);
        IntegerField integerField = (IntegerField) getOptionalSubfield(CVCTagEnum.COFACTOR_F);
        if (byteField == null) {
            return null;
        }
        EllipticCurve ellipticCurve = new EllipticCurve(new ECFieldFp(new BigInteger(1, byteField.getData())), new BigInteger(1, byteField2.getData()), new BigInteger(1, byteField3.getData()));
        return new ECParameterSpec(ellipticCurve, ECPointUtil.decodePoint(ellipticCurve, byteField4.getData()), new BigInteger(1, byteField5.getData()), integerField.getValue());
    }

    public ECPoint getW() {
        try {
            return decodePoint(((ByteField) getSubfield(CVCTagEnum.PUBLIC_POINT_Y)).getData());
        } catch (NoSuchFieldException e11) {
            throw new IllegalStateException(e11);
        }
    }

    public PublicKeyEC(OIDField oIDField, ECPublicKey eCPublicKey, AuthorizationRole authorizationRole) throws ConstructionException {
        addSubfield(oIDField);
        ECParameterSpec params = eCPublicKey.getParams();
        boolean z11 = authorizationRole == null || authorizationRole.isCVCA();
        if (z11) {
            ECField field = params.getCurve().getField();
            if (field instanceof ECFieldFp) {
                addSubfield(new ByteField(CVCTagEnum.MODULUS, CVCObject.trimByteArray(((ECFieldFp) field).getP().toByteArray())));
            }
            addSubfield(new ByteField(CVCTagEnum.COEFFICIENT_A, CVCObject.trimByteArray(params.getCurve().getA().toByteArray())));
            addSubfield(new ByteField(CVCTagEnum.COEFFICIENT_B, CVCObject.trimByteArray(params.getCurve().getB().toByteArray())));
            addSubfield(new ByteField(CVCTagEnum.BASE_POINT_G, encodePoint(params.getGenerator(), params.getCurve())));
            addSubfield(new ByteField(CVCTagEnum.BASE_POINT_R_ORDER, CVCObject.trimByteArray(params.getOrder().toByteArray())));
        }
        addSubfield(new ByteField(CVCTagEnum.PUBLIC_POINT_Y, encodePoint(eCPublicKey.getW(), params.getCurve())));
        if (z11) {
            addSubfield(new IntegerField(CVCTagEnum.COFACTOR_F, params.getCofactor()));
        }
    }

    public PublicKeyEC(OIDField oIDField, ECPublicKey eCPublicKey, AuthorizationRoleEnum authorizationRoleEnum) throws ConstructionException {
        this(oIDField, eCPublicKey, (AuthorizationRole) authorizationRoleEnum);
    }
}
