package org.bouncycastle.pqc.jcajce.provider;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.bc.BCObjectIdentifiers;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;
import org.bouncycastle.pqc.jcajce.provider.saber.SABERKeyFactorySpi;

public class SABER {
    private static final String PREFIX = "org.bouncycastle.pqc.jcajce.provider.saber.";

    public static class Mappings extends AsymmetricAlgorithmProvider {
        public void configure(ConfigurableProvider configurableProvider) {
            configurableProvider.addAlgorithm("KeyFactory.SABER", "org.bouncycastle.pqc.jcajce.provider.saber.SABERKeyFactorySpi");
            configurableProvider.addAlgorithm("KeyPairGenerator.SABER", "org.bouncycastle.pqc.jcajce.provider.saber.SABERKeyPairGeneratorSpi");
            configurableProvider.addAlgorithm("KeyGenerator.SABER", "org.bouncycastle.pqc.jcajce.provider.saber.SABERKeyGeneratorSpi");
            SABERKeyFactorySpi sABERKeyFactorySpi = new SABERKeyFactorySpi();
            configurableProvider.addAlgorithm("Cipher.SABER", "org.bouncycastle.pqc.jcajce.provider.saber.SABERCipherSpi$Base");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Alg.Alias.Cipher.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier = BCObjectIdentifiers.pqc_kem_saber;
            sb2.append(aSN1ObjectIdentifier);
            configurableProvider.addAlgorithm(sb2.toString(), "SABER");
            registerOid(configurableProvider, aSN1ObjectIdentifier, "SABER", sABERKeyFactorySpi);
            registerOidAlgorithmParameters(configurableProvider, aSN1ObjectIdentifier, "SABER");
        }
    }
}
