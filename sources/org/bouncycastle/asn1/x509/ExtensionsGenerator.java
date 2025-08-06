package org.bouncycastle.asn1.x509;

import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1ParsingException;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Arrays;

public class ExtensionsGenerator {
    private static final Set dupsAllowed;
    private Vector extOrdering = new Vector();
    private Hashtable extensions = new Hashtable();

    static {
        HashSet hashSet = new HashSet();
        hashSet.add(Extension.subjectAlternativeName);
        hashSet.add(Extension.issuerAlternativeName);
        hashSet.add(Extension.subjectDirectoryAttributes);
        hashSet.add(Extension.certificateIssuer);
        dupsAllowed = Collections.unmodifiableSet(hashSet);
    }

    public void addExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z11, ASN1Encodable aSN1Encodable) throws IOException {
        addExtension(aSN1ObjectIdentifier, z11, aSN1Encodable.toASN1Primitive().getEncoded(ASN1Encoding.DER));
    }

    public void addExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z11, byte[] bArr) {
        if (!this.extensions.containsKey(aSN1ObjectIdentifier)) {
            this.extOrdering.addElement(aSN1ObjectIdentifier);
            this.extensions.put(aSN1ObjectIdentifier, new Extension(aSN1ObjectIdentifier, z11, (ASN1OctetString) new DEROctetString(Arrays.clone(bArr))));
        } else if (dupsAllowed.contains(aSN1ObjectIdentifier)) {
            ASN1Sequence instance = ASN1Sequence.getInstance(ASN1OctetString.getInstance(((Extension) this.extensions.get(aSN1ObjectIdentifier)).getExtnValue()).getOctets());
            ASN1Sequence instance2 = ASN1Sequence.getInstance(bArr);
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(instance.size() + instance2.size());
            Enumeration objects = instance.getObjects();
            while (objects.hasMoreElements()) {
                aSN1EncodableVector.add((ASN1Encodable) objects.nextElement());
            }
            Enumeration objects2 = instance2.getObjects();
            while (objects2.hasMoreElements()) {
                aSN1EncodableVector.add((ASN1Encodable) objects2.nextElement());
            }
            try {
                this.extensions.put(aSN1ObjectIdentifier, new Extension(aSN1ObjectIdentifier, z11, new DERSequence(aSN1EncodableVector).getEncoded()));
            } catch (IOException e11) {
                throw new ASN1ParsingException(e11.getMessage(), e11);
            }
        } else {
            throw new IllegalArgumentException("extension " + aSN1ObjectIdentifier + " already added");
        }
    }

    public void addExtension(Extension extension) {
        if (!this.extensions.containsKey(extension.getExtnId())) {
            this.extOrdering.addElement(extension.getExtnId());
            this.extensions.put(extension.getExtnId(), extension);
            return;
        }
        throw new IllegalArgumentException("extension " + extension.getExtnId() + " already added");
    }

    public void addExtension(Extensions extensions2) {
        ASN1ObjectIdentifier[] extensionOIDs = extensions2.getExtensionOIDs();
        for (int i11 = 0; i11 != extensionOIDs.length; i11++) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = extensionOIDs[i11];
            Extension extension = extensions2.getExtension(aSN1ObjectIdentifier);
            addExtension(ASN1ObjectIdentifier.getInstance(aSN1ObjectIdentifier), extension.isCritical(), extension.getExtnValue().getOctets());
        }
    }

    public Extensions generate() {
        Extension[] extensionArr = new Extension[this.extOrdering.size()];
        for (int i11 = 0; i11 != this.extOrdering.size(); i11++) {
            extensionArr[i11] = (Extension) this.extensions.get(this.extOrdering.elementAt(i11));
        }
        return new Extensions(extensionArr);
    }

    public Extension getExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (Extension) this.extensions.get(aSN1ObjectIdentifier);
    }

    public boolean hasExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return this.extensions.containsKey(aSN1ObjectIdentifier);
    }

    public boolean isEmpty() {
        return this.extOrdering.isEmpty();
    }

    public void removeExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        if (this.extensions.containsKey(aSN1ObjectIdentifier)) {
            this.extOrdering.removeElement(aSN1ObjectIdentifier);
            this.extensions.remove(aSN1ObjectIdentifier);
            return;
        }
        throw new IllegalArgumentException("extension " + aSN1ObjectIdentifier + " not present");
    }

    public void replaceExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z11, ASN1Encodable aSN1Encodable) throws IOException {
        replaceExtension(aSN1ObjectIdentifier, z11, aSN1Encodable.toASN1Primitive().getEncoded(ASN1Encoding.DER));
    }

    public void replaceExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z11, byte[] bArr) {
        replaceExtension(new Extension(aSN1ObjectIdentifier, z11, bArr));
    }

    public void replaceExtension(Extension extension) {
        if (this.extensions.containsKey(extension.getExtnId())) {
            this.extensions.put(extension.getExtnId(), extension);
            return;
        }
        throw new IllegalArgumentException("extension " + extension.getExtnId() + " not present");
    }

    public void reset() {
        this.extensions = new Hashtable();
        this.extOrdering = new Vector();
    }
}
