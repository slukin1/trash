package org.bouncycastle.jce.provider;

import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.bouncycastle.jcajce.PKIXCRLStoreSelector;
import org.bouncycastle.util.Store;
import org.bouncycastle.util.StoreException;

abstract class PKIXCRLUtil {
    public static Set findCRLs(PKIXCRLStoreSelector pKIXCRLStoreSelector, Date date, List list, List list2) throws AnnotatedException {
        X509Certificate certificateChecking;
        HashSet hashSet = new HashSet();
        try {
            findCRLs(hashSet, pKIXCRLStoreSelector, list2);
            findCRLs(hashSet, pKIXCRLStoreSelector, list);
            HashSet hashSet2 = new HashSet();
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                X509CRL x509crl = (X509CRL) it2.next();
                Date nextUpdate = x509crl.getNextUpdate();
                if ((nextUpdate == null || nextUpdate.after(date)) && ((certificateChecking = pKIXCRLStoreSelector.getCertificateChecking()) == null || x509crl.getThisUpdate().before(certificateChecking.getNotAfter()))) {
                    hashSet2.add(x509crl);
                }
            }
            return hashSet2;
        } catch (AnnotatedException e11) {
            throw new AnnotatedException("Exception obtaining complete CRLs.", e11);
        }
    }

    private static void findCRLs(HashSet hashSet, PKIXCRLStoreSelector pKIXCRLStoreSelector, List list) throws AnnotatedException {
        AnnotatedException annotatedException;
        AnnotatedException annotatedException2 = null;
        boolean z11 = false;
        for (Object next : list) {
            if (next instanceof Store) {
                try {
                    hashSet.addAll(((Store) next).getMatches(pKIXCRLStoreSelector));
                } catch (StoreException e11) {
                    annotatedException = new AnnotatedException("Exception searching in X.509 CRL store.", e11);
                    annotatedException2 = annotatedException;
                }
            } else {
                try {
                    hashSet.addAll(PKIXCRLStoreSelector.getCRLs(pKIXCRLStoreSelector, (CertStore) next));
                } catch (CertStoreException e12) {
                    annotatedException = new AnnotatedException("Exception searching in X.509 CRL store.", e12);
                }
            }
            z11 = true;
        }
        if (!z11 && annotatedException2 != null) {
            throw annotatedException2;
        }
    }
}
