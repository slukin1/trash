package org.bouncycastle.pqc.jcajce.interfaces;

import java.security.PrivateKey;

public interface XMSSMTPrivateKey extends XMSSMTKey, PrivateKey {
    XMSSMTPrivateKey extractKeyShard(int i11);

    long getIndex();

    long getUsagesRemaining();
}
