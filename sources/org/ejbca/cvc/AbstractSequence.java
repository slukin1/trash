package org.ejbca.cvc;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.ejbca.cvc.exception.ConstructionException;

public abstract class AbstractSequence extends CVCObject {
    private static final long serialVersionUID = 1;
    private final List<CVCTagEnum> allowedFields = Arrays.asList(getAllowedFields());
    private final Map<CVCTagEnum, CVCObject> subfields = new HashMap();

    public AbstractSequence(CVCTagEnum cVCTagEnum) {
        super(cVCTagEnum);
    }

    public void addSubfield(CVCObject cVCObject) throws ConstructionException {
        addSubfield(cVCObject, false);
    }

    public int encode(DataOutputStream dataOutputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream2 = new DataOutputStream(byteArrayOutputStream);
        int i11 = 0;
        for (CVCObject encode : getEncodableFields()) {
            i11 += encode.encode(dataOutputStream2);
        }
        dataOutputStream2.close();
        int value = getTag().getValue();
        int size = dataOutputStream.size();
        dataOutputStream.write(CVCObject.toByteArray(Integer.valueOf(value)));
        dataOutputStream.write(CVCObject.encodeLength(i11));
        dataOutputStream.write(byteArrayOutputStream.toByteArray());
        return dataOutputStream.size() - size;
    }

    public abstract CVCTagEnum[] getAllowedFields();

    public String getAsText(String str) {
        return getAsText(str, true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x001e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] getDEREncoded() throws java.io.IOException {
        /*
            r3 = this;
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0018 }
            r1.<init>()     // Catch:{ all -> 0x0018 }
            java.io.DataOutputStream r0 = new java.io.DataOutputStream     // Catch:{ all -> 0x0016 }
            r0.<init>(r1)     // Catch:{ all -> 0x0016 }
            r3.encode(r0)     // Catch:{ all -> 0x0016 }
            r1.close()
            byte[] r0 = r1.toByteArray()
            return r0
        L_0x0016:
            r0 = move-exception
            goto L_0x001c
        L_0x0018:
            r1 = move-exception
            r2 = r1
            r1 = r0
            r0 = r2
        L_0x001c:
            if (r1 == 0) goto L_0x0021
            r1.close()
        L_0x0021:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.ejbca.cvc.AbstractSequence.getDEREncoded():byte[]");
    }

    public List<CVCObject> getEncodableFields() {
        return getOrderedSubfields();
    }

    public CVCObject getOptionalSubfield(CVCTagEnum cVCTagEnum) {
        return this.subfields.get(cVCTagEnum);
    }

    public List<CVCObject> getOrderedSubfields() {
        ArrayList arrayList = new ArrayList();
        for (CVCTagEnum cVCTagEnum : this.allowedFields) {
            CVCObject cVCObject = this.subfields.get(cVCTagEnum);
            if (cVCObject != null) {
                arrayList.add(cVCObject);
            }
        }
        return arrayList;
    }

    public CVCObject getSubfield(CVCTagEnum cVCTagEnum) throws NoSuchFieldException {
        CVCObject cVCObject = this.subfields.get(cVCTagEnum);
        if (cVCObject != null) {
            return cVCObject;
        }
        throw new NoSuchFieldException("Could not find subfield " + cVCTagEnum);
    }

    public Collection<CVCObject> getSubfields() {
        return this.subfields.values();
    }

    public void addSubfield(CVCObject cVCObject, boolean z11) throws ConstructionException {
        if (cVCObject == null) {
            return;
        }
        if (!this.allowedFields.contains(cVCObject.getTag())) {
            throw new ConstructionException("Field " + cVCObject.getTag() + " not allowed in " + getClass().getName());
        } else if (!this.subfields.containsKey(cVCObject.getTag()) || z11) {
            cVCObject.setParent(this);
            this.subfields.put(cVCObject.getTag(), cVCObject);
        } else {
            throw new ConstructionException("Field " + cVCObject.getTag() + " has already been added to " + getClass().getName());
        }
    }

    public String getAsText(String str, boolean z11) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(super.getAsText(str, z11));
        for (CVCObject asText : getOrderedSubfields()) {
            stringBuffer.append(CVCObject.NEWLINE);
            stringBuffer.append(asText.getAsText(str + "   ", z11));
        }
        return stringBuffer.toString();
    }
}
