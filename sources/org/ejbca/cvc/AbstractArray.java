package org.ejbca.cvc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.ejbca.cvc.exception.ConstructionException;

public abstract class AbstractArray extends AbstractSequence {
    private static final long serialVersionUID = 1;
    private final CVCTagEnum allowedField = getAllowedField();
    private final List<CVCObject> subfields = new ArrayList();

    public AbstractArray(CVCTagEnum cVCTagEnum) {
        super(cVCTagEnum);
    }

    public void addSubfield(CVCObject cVCObject) throws ConstructionException {
        if (cVCObject == null) {
            return;
        }
        if (this.allowedField == cVCObject.getTag()) {
            cVCObject.setParent(this);
            this.subfields.add(cVCObject);
            return;
        }
        throw new ConstructionException("Field " + cVCObject.getTag() + " not allowed in " + getClass().getName());
    }

    public abstract CVCTagEnum getAllowedField();

    public final CVCTagEnum[] getAllowedFields() {
        return new CVCTagEnum[]{getAllowedField()};
    }

    public final CVCObject getOptionalSubfield(CVCTagEnum cVCTagEnum) {
        throw new IllegalStateException("Not applicable to AbstractArray");
    }

    public List<CVCObject> getOrderedSubfields() {
        return new ArrayList(this.subfields);
    }

    public final CVCObject getSubfield(CVCTagEnum cVCTagEnum) throws NoSuchFieldException {
        throw new IllegalStateException("Not applicable to AbstractArray");
    }

    public Collection<CVCObject> getSubfields() {
        return new ArrayList(this.subfields);
    }
}
