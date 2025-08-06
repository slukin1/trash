package org.bouncycastle.oer.its.etsi102941;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;

public class CtlCommand extends ASN1Object implements ASN1Choice {
    public static final int add = 0;
    public static final int delete = 1;
    private final int choice;
    private final ASN1Encodable ctlCommand;

    public CtlCommand(int i11, ASN1Encodable aSN1Encodable) {
        this.choice = i11;
        this.ctlCommand = aSN1Encodable;
    }

    private CtlCommand(ASN1TaggedObject aSN1TaggedObject) {
        ASN1Encodable instance;
        int tagNo = aSN1TaggedObject.getTagNo();
        this.choice = tagNo;
        if (tagNo == 0) {
            instance = CtlEntry.getInstance(aSN1TaggedObject.getObject());
        } else if (tagNo == 1) {
            instance = CtlDelete.getInstance(aSN1TaggedObject.getObject());
        } else {
            throw new IllegalArgumentException("invalid choice value " + tagNo);
        }
        this.ctlCommand = instance;
    }

    public static CtlCommand add(CtlEntry ctlEntry) {
        return new CtlCommand(0, ctlEntry);
    }

    public static CtlCommand delete(CtlDelete ctlDelete) {
        return new CtlCommand(1, ctlDelete);
    }

    public static CtlCommand getInstance(Object obj) {
        if (obj instanceof CtlCommand) {
            return (CtlCommand) obj;
        }
        if (obj != null) {
            return new CtlCommand(ASN1TaggedObject.getInstance(obj));
        }
        return null;
    }

    public int getChoice() {
        return this.choice;
    }

    public ASN1Encodable getCtlCommand() {
        return this.ctlCommand;
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(this.choice, this.ctlCommand);
    }
}
