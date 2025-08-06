package org.ejbca.cvc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.ejbca.cvc.exception.ConstructionException;

public class CVCertificateExtensions extends AbstractArray {
    private static final long serialVersionUID = 1;

    public CVCertificateExtensions() {
        super(CVCTagEnum.CERTIFICATE_EXTENSIONS);
    }

    public CVCTagEnum getAllowedField() {
        return CVCTagEnum.DISCRETIONARY_DATA_TEMPLATE;
    }

    public List<CVCDiscretionaryDataTemplate> getExtensions() {
        ArrayList arrayList = new ArrayList();
        Iterator<CVCObject> it2 = getEncodableFields().iterator();
        while (it2.hasNext()) {
            arrayList.add((CVCDiscretionaryDataTemplate) it2.next());
        }
        return arrayList;
    }

    public CVCertificateExtensions(Collection<CVCDiscretionaryDataTemplate> collection) throws ConstructionException {
        this();
        for (CVCDiscretionaryDataTemplate addSubfield : collection) {
            addSubfield(addSubfield);
        }
    }
}
