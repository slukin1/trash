package org.ejbca.cvc;

import org.ejbca.cvc.exception.ConstructionException;

public class CVCDiscretionaryDataTemplate extends AbstractSequence {
    private static CVCTagEnum[] allowedFields = {CVCTagEnum.OID, CVCTagEnum.ARBITRARY_DATA};
    private static final long serialVersionUID = 1;

    public CVCDiscretionaryDataTemplate() {
        super(CVCTagEnum.DISCRETIONARY_DATA_TEMPLATE);
    }

    public CVCTagEnum[] getAllowedFields() {
        return allowedFields;
    }

    public byte[] getExtensionData() throws NoSuchFieldException {
        return ((ByteField) getSubfield(CVCTagEnum.ARBITRARY_DATA)).getData();
    }

    public String getObjectIdentifier() throws NoSuchFieldException {
        return ((OIDField) getSubfield(CVCTagEnum.OID)).getValue();
    }

    public CVCDiscretionaryDataTemplate(OIDField oIDField, ByteField byteField) throws ConstructionException {
        this();
        addSubfield(oIDField);
        addSubfield(byteField);
    }

    public CVCDiscretionaryDataTemplate(String str, byte[] bArr) throws ConstructionException {
        this(new OIDField(str), new ByteField(CVCTagEnum.ARBITRARY_DATA, bArr));
    }
}
