package org.ejbca.cvc;

import java.math.BigInteger;
import java.security.interfaces.RSAPublicKey;
import org.ejbca.cvc.exception.ConstructionException;

public class PublicKeyRSA extends CVCPublicKey implements RSAPublicKey {
    private static CVCTagEnum[] allowedFields = {CVCTagEnum.OID, CVCTagEnum.MODULUS, CVCTagEnum.EXPONENT};
    private static final long serialVersionUID = 1;

    public PublicKeyRSA(GenericPublicKeyField genericPublicKeyField) throws ConstructionException, NoSuchFieldException {
        ByteField byteField = (ByteField) genericPublicKeyField.getSubfield(CVCTagEnum.MODULUS);
        byteField.setShowBitLength(true);
        addSubfield(genericPublicKeyField.getSubfield(CVCTagEnum.OID));
        addSubfield(byteField);
        addSubfield(genericPublicKeyField.getSubfield(CVCTagEnum.EXPONENT));
    }

    public String getAlgorithm() {
        return "RSA";
    }

    public CVCTagEnum[] getAllowedFields() {
        return allowedFields;
    }

    public String getFormat() {
        return "CVC";
    }

    public BigInteger getModulus() {
        try {
            return new BigInteger(1, ((ByteField) getSubfield(CVCTagEnum.MODULUS)).getData());
        } catch (NoSuchFieldException e11) {
            throw new IllegalStateException(e11);
        }
    }

    public BigInteger getPublicExponent() {
        try {
            return new BigInteger(1, ((ByteField) getSubfield(CVCTagEnum.EXPONENT)).getData());
        } catch (NoSuchFieldException e11) {
            throw new IllegalStateException(e11);
        }
    }

    public PublicKeyRSA(OIDField oIDField, RSAPublicKey rSAPublicKey) throws ConstructionException {
        addSubfield(oIDField);
        addSubfield(new ByteField(CVCTagEnum.MODULUS, CVCObject.trimByteArray(rSAPublicKey.getModulus().toByteArray()), true));
        addSubfield(new ByteField(CVCTagEnum.EXPONENT, CVCObject.trimByteArray(rSAPublicKey.getPublicExponent().toByteArray())));
    }
}
