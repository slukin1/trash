package org.jmrtd.lds.icao;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DLSet;
import org.jmrtd.lds.ActiveAuthenticationInfo;
import org.jmrtd.lds.ChipAuthenticationInfo;
import org.jmrtd.lds.ChipAuthenticationPublicKeyInfo;
import org.jmrtd.lds.DataGroup;
import org.jmrtd.lds.SecurityInfo;
import org.jmrtd.lds.TerminalAuthenticationInfo;

public class DG14File extends DataGroup {
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd");
    private static final long serialVersionUID = -3536507558193769953L;
    private Set<SecurityInfo> securityInfos;

    public DG14File(Collection<SecurityInfo> collection) {
        super(110);
        if (collection != null) {
            this.securityInfos = new HashSet(collection);
            return;
        }
        throw new IllegalArgumentException("Null securityInfos");
    }

    public boolean equals(Object obj) {
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        DG14File dG14File = (DG14File) obj;
        Set<SecurityInfo> set = this.securityInfos;
        if (set != null) {
            Set<SecurityInfo> set2 = dG14File.securityInfos;
            if (set2 != null) {
                return set.equals(set2);
            }
            if (set == null) {
                return true;
            }
            return false;
        } else if (dG14File.securityInfos == null) {
            return true;
        } else {
            return false;
        }
    }

    @Deprecated
    public List<ActiveAuthenticationInfo> getActiveAuthenticationInfos() {
        ArrayList arrayList = new ArrayList();
        for (SecurityInfo next : this.securityInfos) {
            if (next instanceof ActiveAuthenticationInfo) {
                arrayList.add((ActiveAuthenticationInfo) next);
            }
        }
        return arrayList;
    }

    @Deprecated
    public List<ChipAuthenticationInfo> getChipAuthenticationInfos() {
        ArrayList arrayList = new ArrayList();
        for (SecurityInfo next : this.securityInfos) {
            if (next instanceof ChipAuthenticationInfo) {
                ChipAuthenticationInfo chipAuthenticationInfo = (ChipAuthenticationInfo) next;
                arrayList.add(chipAuthenticationInfo);
                if (chipAuthenticationInfo.getKeyId() == null) {
                    break;
                }
            }
        }
        return arrayList;
    }

    @Deprecated
    public List<ChipAuthenticationPublicKeyInfo> getChipAuthenticationPublicKeyInfos() {
        ArrayList arrayList = new ArrayList();
        for (SecurityInfo next : this.securityInfos) {
            if (next instanceof ChipAuthenticationPublicKeyInfo) {
                arrayList.add((ChipAuthenticationPublicKeyInfo) next);
            }
        }
        return arrayList;
    }

    public Collection<SecurityInfo> getSecurityInfos() {
        return this.securityInfos;
    }

    @Deprecated
    public List<TerminalAuthenticationInfo> getTerminalAuthenticationInfos() {
        ArrayList arrayList = new ArrayList();
        for (SecurityInfo next : this.securityInfos) {
            if (next instanceof TerminalAuthenticationInfo) {
                arrayList.add((TerminalAuthenticationInfo) next);
            }
        }
        return arrayList;
    }

    public int hashCode() {
        return (this.securityInfos.hashCode() * 5) + 41;
    }

    public void readContent(InputStream inputStream) throws IOException {
        this.securityInfos = new HashSet();
        ASN1Set aSN1Set = (ASN1Set) new ASN1InputStream(inputStream).readObject();
        for (int i11 = 0; i11 < aSN1Set.size(); i11++) {
            try {
                SecurityInfo instance = SecurityInfo.getInstance(aSN1Set.getObjectAt(i11).toASN1Primitive());
                if (instance == null) {
                    LOGGER.warning("Skipping this unsupported SecurityInfo");
                } else {
                    this.securityInfos.add(instance);
                }
            } catch (Exception e11) {
                LOGGER.log(Level.WARNING, "Skipping Security Info", e11);
            }
        }
    }

    public String toString() {
        return "DG14File [" + this.securityInfos.toString() + "]";
    }

    public void writeContent(OutputStream outputStream) throws IOException {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        for (SecurityInfo next : this.securityInfos) {
            if (next != null) {
                aSN1EncodableVector.add(next.getDERObject());
            }
        }
        outputStream.write(new DLSet(aSN1EncodableVector).getEncoded(ASN1Encoding.DER));
    }

    public DG14File(InputStream inputStream) throws IOException {
        super(110, inputStream);
    }
}
