package org.ejbca.cvc;

import java.io.IOException;
import java.security.PublicKey;
import org.ejbca.cvc.exception.ConstructionException;

public abstract class CVCPublicKey extends AbstractSequence implements PublicKey {
    private static final long serialVersionUID = 5330644668163139836L;

    public CVCPublicKey() {
        super(CVCTagEnum.PUBLIC_KEY);
    }

    public byte[] getEncoded() {
        try {
            return getDEREncoded();
        } catch (IOException e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public OIDField getObjectIdentifier() throws NoSuchFieldException {
        return (OIDField) getSubfield(CVCTagEnum.OID);
    }

    public void setObjectIdentifier(OIDField oIDField) throws ConstructionException {
        addSubfield(oIDField, true);
    }
}
