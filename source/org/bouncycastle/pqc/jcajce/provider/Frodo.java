package org.bouncycastle.pqc.jcajce.provider;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.bc.BCObjectIdentifiers;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;
import org.bouncycastle.pqc.jcajce.provider.frodo.FrodoKeyFactorySpi;

public class Frodo {
    private static final String PREFIX = "org.bouncycastle.pqc.jcajce.provider.frodo.";

    public static class Mappings extends AsymmetricAlgorithmProvider {
        public void configure(ConfigurableProvider configurableProvider) {
            configurableProvider.addAlgorithm("KeyFactory.FRODO", "org.bouncycastle.pqc.jcajce.provider.frodo.FrodoKeyFactorySpi");
            configurableProvider.addAlgorithm("KeyPairGenerator.FRODO", "org.bouncycastle.pqc.jcajce.provider.frodo.FrodoKeyPairGeneratorSpi");
            configurableProvider.addAlgorithm("KeyGenerator.FRODO", "org.bouncycastle.pqc.jcajce.provider.frodo.FrodoKeyGeneratorSpi");
            FrodoKeyFactorySpi frodoKeyFactorySpi = new FrodoKeyFactorySpi();
            configurableProvider.addAlgorithm("Cipher.FRODO", "org.bouncycastle.pqc.jcajce.provider.frodo.FrodoCipherSpi$Base");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Alg.Alias.Cipher.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier = BCObjectIdentifiers.pqc_kem_frodo;
            sb2.append(aSN1ObjectIdentifier);
            configurableProvider.addAlgorithm(sb2.toString(), "FRODO");
            registerOid(configurableProvider, aSN1ObjectIdentifier, "Frodo", frodoKeyFactorySpi);
            registerOidAlgorithmParameters(configurableProvider, aSN1ObjectIdentifier, "FRODO");
        }
    }
}
