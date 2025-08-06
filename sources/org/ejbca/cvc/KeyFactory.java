package org.ejbca.cvc;

import java.security.PublicKey;
import java.security.interfaces.ECPublicKey;
import java.security.interfaces.RSAPublicKey;
import org.ejbca.cvc.exception.ConstructionException;

public class KeyFactory {
    private static void copyField(CVCTagEnum cVCTagEnum, CVCTagEnum cVCTagEnum2, GenericPublicKeyField genericPublicKeyField) throws ConstructionException {
        ByteField byteField;
        if (cVCTagEnum.getValue() != cVCTagEnum2.getValue()) {
            throw new IllegalArgumentException("Tag values are not equal");
        } else if (((ByteField) genericPublicKeyField.getOptionalSubfield(cVCTagEnum2)) == null && (byteField = (ByteField) genericPublicKeyField.getOptionalSubfield(cVCTagEnum)) != null) {
            genericPublicKeyField.addSubfield(new ByteField(cVCTagEnum2, byteField.getData()));
        }
    }

    public static CVCPublicKey createInstance(PublicKey publicKey, String str, AuthorizationRole authorizationRole) throws ConstructionException {
        if (publicKey instanceof CVCPublicKey) {
            return (CVCPublicKey) publicKey;
        }
        OIDField oIDField = AlgorithmUtil.getOIDField(str);
        if (oIDField.getValue().startsWith(CVCObjectIdentifiers.id_TA_RSA)) {
            return new PublicKeyRSA(oIDField, (RSAPublicKey) publicKey);
        }
        if (oIDField.getValue().startsWith(CVCObjectIdentifiers.id_TA_ECDSA)) {
            return new PublicKeyEC(oIDField, (ECPublicKey) publicKey, authorizationRole);
        }
        throw new IllegalArgumentException("Unknown key type: " + oIDField);
    }

    public static CVCPublicKey createInstance(PublicKey publicKey, String str, AuthorizationRoleEnum authorizationRoleEnum) throws ConstructionException {
        return createInstance(publicKey, str, (AuthorizationRole) authorizationRoleEnum);
    }

    public static CVCPublicKey createInstance(GenericPublicKeyField genericPublicKeyField) throws ConstructionException {
        try {
            OIDField oIDField = (OIDField) genericPublicKeyField.getOptionalSubfield(CVCTagEnum.OID);
            if (oIDField.getValue().startsWith(CVCObjectIdentifiers.id_TA_RSA)) {
                copyField(CVCTagEnum.COEFFICIENT_A, CVCTagEnum.EXPONENT, genericPublicKeyField);
                return new PublicKeyRSA(genericPublicKeyField);
            } else if (oIDField.getValue().startsWith(CVCObjectIdentifiers.id_TA_ECDSA)) {
                copyField(CVCTagEnum.EXPONENT, CVCTagEnum.COEFFICIENT_A, genericPublicKeyField);
                return new PublicKeyEC(genericPublicKeyField);
            } else {
                throw new IllegalArgumentException("Unknown public key OID: " + oIDField.getValue());
            }
        } catch (NoSuchFieldException e11) {
            throw new ConstructionException((Throwable) e11);
        }
    }
}
