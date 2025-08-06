package org.bouncycastle.oer.its.etsi102941;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.oer.its.ieee1609dot2.basetypes.HashedId8;

public class CtlDelete extends ASN1Object implements ASN1Choice {
    public static final int cert = 0;

    /* renamed from: dc  reason: collision with root package name */
    public static final int f59464dc = 1;
    private final int choice;
    private final ASN1Encodable ctlDelete;

    public CtlDelete(int i11, ASN1Encodable aSN1Encodable) {
        ASN1Encodable instance;
        this.choice = i11;
        if (i11 == 0) {
            instance = HashedId8.getInstance(aSN1Encodable);
        } else if (i11 == 1) {
            instance = DcDelete.getInstance(aSN1Encodable);
        } else {
            throw new IllegalArgumentException("invalid choice value " + i11);
        }
        this.ctlDelete = instance;
    }

    private CtlDelete(ASN1TaggedObject aSN1TaggedObject) {
        this(aSN1TaggedObject.getTagNo(), aSN1TaggedObject.getObject());
    }

    public static CtlDelete cert(HashedId8 hashedId8) {
        return new CtlDelete(0, hashedId8);
    }

    public static CtlDelete dc(DcDelete dcDelete) {
        return new CtlDelete(1, dcDelete);
    }

    public static CtlDelete getInstance(Object obj) {
        if (obj instanceof CtlDelete) {
            return (CtlDelete) obj;
        }
        if (obj != null) {
            return new CtlDelete(ASN1TaggedObject.getInstance(obj));
        }
        return null;
    }

    public int getChoice() {
        return this.choice;
    }

    public ASN1Encodable getCtlDelete() {
        return this.ctlDelete;
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(this.choice, this.ctlDelete);
    }
}
