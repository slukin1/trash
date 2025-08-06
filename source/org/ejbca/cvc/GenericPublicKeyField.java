package org.ejbca.cvc;

public class GenericPublicKeyField extends AbstractSequence {
    private static CVCTagEnum[] allowedFields = {CVCTagEnum.OID, CVCTagEnum.MODULUS, CVCTagEnum.EXPONENT, CVCTagEnum.COEFFICIENT_A, CVCTagEnum.COEFFICIENT_B, CVCTagEnum.BASE_POINT_G, CVCTagEnum.BASE_POINT_R_ORDER, CVCTagEnum.PUBLIC_POINT_Y, CVCTagEnum.COFACTOR_F};
    private static final long serialVersionUID = 1;

    public GenericPublicKeyField() {
        super(CVCTagEnum.PUBLIC_KEY);
    }

    public CVCTagEnum[] getAllowedFields() {
        return allowedFields;
    }
}
