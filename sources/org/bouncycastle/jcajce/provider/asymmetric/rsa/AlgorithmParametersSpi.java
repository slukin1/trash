package org.bouncycastle.jcajce.provider.asymmetric.rsa;

import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.util.Objects;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.RSAESOAEPparams;
import org.bouncycastle.asn1.pkcs.RSASSAPSSparams;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.jcajce.provider.util.DigestFactory;
import org.bouncycastle.jcajce.util.MessageDigestUtils;

public abstract class AlgorithmParametersSpi extends java.security.AlgorithmParametersSpi {

    public static class OAEP extends AlgorithmParametersSpi {
        public OAEPParameterSpec currentSpec;

        public byte[] engineGetEncoded() {
            ASN1ObjectIdentifier oid = DigestFactory.getOID(this.currentSpec.getDigestAlgorithm());
            DERNull dERNull = DERNull.INSTANCE;
            try {
                return new RSAESOAEPparams(new AlgorithmIdentifier(oid, dERNull), new AlgorithmIdentifier(PKCSObjectIdentifiers.id_mgf1, new AlgorithmIdentifier(DigestFactory.getOID(((MGF1ParameterSpec) this.currentSpec.getMGFParameters()).getDigestAlgorithm()), dERNull)), new AlgorithmIdentifier(PKCSObjectIdentifiers.id_pSpecified, new DEROctetString(((PSource.PSpecified) this.currentSpec.getPSource()).getValue()))).getEncoded(ASN1Encoding.DER);
            } catch (IOException unused) {
                throw new RuntimeException("Error encoding OAEPParameters");
            }
        }

        public byte[] engineGetEncoded(String str) {
            if (isASN1FormatString(str) || str.equalsIgnoreCase("X.509")) {
                return engineGetEncoded();
            }
            return null;
        }

        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
            if (algorithmParameterSpec instanceof OAEPParameterSpec) {
                this.currentSpec = (OAEPParameterSpec) algorithmParameterSpec;
                return;
            }
            throw new InvalidParameterSpecException("OAEPParameterSpec required to initialise an OAEP algorithm parameters object");
        }

        public void engineInit(byte[] bArr) throws IOException {
            try {
                RSAESOAEPparams instance = RSAESOAEPparams.getInstance(bArr);
                if (instance.getMaskGenAlgorithm().getAlgorithm().equals((ASN1Primitive) PKCSObjectIdentifiers.id_mgf1)) {
                    this.currentSpec = new OAEPParameterSpec(MessageDigestUtils.getDigestName(instance.getHashAlgorithm().getAlgorithm()), OAEPParameterSpec.DEFAULT.getMGFAlgorithm(), new MGF1ParameterSpec(MessageDigestUtils.getDigestName(AlgorithmIdentifier.getInstance(instance.getMaskGenAlgorithm().getParameters()).getAlgorithm())), new PSource.PSpecified(ASN1OctetString.getInstance(instance.getPSourceAlgorithm().getParameters()).getOctets()));
                    return;
                }
                throw new IOException("unknown mask generation function: " + instance.getMaskGenAlgorithm().getAlgorithm());
            } catch (ClassCastException unused) {
                throw new IOException("Not a valid OAEP Parameter encoding.");
            } catch (ArrayIndexOutOfBoundsException unused2) {
                throw new IOException("Not a valid OAEP Parameter encoding.");
            }
        }

        public void engineInit(byte[] bArr, String str) throws IOException {
            if (str.equalsIgnoreCase("X.509") || str.equalsIgnoreCase("ASN.1")) {
                engineInit(bArr);
                return;
            }
            throw new IOException("Unknown parameter format " + str);
        }

        public String engineToString() {
            return "OAEP Parameters";
        }

        public AlgorithmParameterSpec localEngineGetParameterSpec(Class cls) throws InvalidParameterSpecException {
            if (cls == OAEPParameterSpec.class || cls == AlgorithmParameterSpec.class) {
                return this.currentSpec;
            }
            throw new InvalidParameterSpecException("unknown parameter spec passed to OAEP parameters object.");
        }
    }

    public static class PSS extends AlgorithmParametersSpi {
        public PSSParameterSpec currentSpec;

        public byte[] engineGetEncoded() throws IOException {
            PSSParameterSpec pSSParameterSpec = this.currentSpec;
            ASN1ObjectIdentifier oid = DigestFactory.getOID(pSSParameterSpec.getDigestAlgorithm());
            DERNull dERNull = DERNull.INSTANCE;
            AlgorithmIdentifier algorithmIdentifier = new AlgorithmIdentifier(oid, dERNull);
            MGF1ParameterSpec mGF1ParameterSpec = (MGF1ParameterSpec) pSSParameterSpec.getMGFParameters();
            if (mGF1ParameterSpec != null) {
                return new RSASSAPSSparams(algorithmIdentifier, new AlgorithmIdentifier(PKCSObjectIdentifiers.id_mgf1, new AlgorithmIdentifier(DigestFactory.getOID(mGF1ParameterSpec.getDigestAlgorithm()), dERNull)), new ASN1Integer((long) pSSParameterSpec.getSaltLength()), new ASN1Integer((long) pSSParameterSpec.getTrailerField())).getEncoded(ASN1Encoding.DER);
            }
            return new RSASSAPSSparams(algorithmIdentifier, new AlgorithmIdentifier(pSSParameterSpec.getMGFAlgorithm().equals("SHAKE128") ? NISTObjectIdentifiers.id_shake128 : NISTObjectIdentifiers.id_shake256), new ASN1Integer((long) pSSParameterSpec.getSaltLength()), new ASN1Integer((long) pSSParameterSpec.getTrailerField())).getEncoded(ASN1Encoding.DER);
        }

        public byte[] engineGetEncoded(String str) throws IOException {
            if (str.equalsIgnoreCase("X.509") || str.equalsIgnoreCase("ASN.1")) {
                return engineGetEncoded();
            }
            return null;
        }

        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
            if (algorithmParameterSpec instanceof PSSParameterSpec) {
                this.currentSpec = (PSSParameterSpec) algorithmParameterSpec;
                return;
            }
            throw new InvalidParameterSpecException("PSSParameterSpec required to initialise an PSS algorithm parameters object");
        }

        public void engineInit(byte[] bArr) throws IOException {
            try {
                RSASSAPSSparams instance = RSASSAPSSparams.getInstance(bArr);
                ASN1ObjectIdentifier algorithm = instance.getMaskGenAlgorithm().getAlgorithm();
                if (algorithm.equals((ASN1Primitive) PKCSObjectIdentifiers.id_mgf1)) {
                    this.currentSpec = new PSSParameterSpec(MessageDigestUtils.getDigestName(instance.getHashAlgorithm().getAlgorithm()), PSSParameterSpec.DEFAULT.getMGFAlgorithm(), new MGF1ParameterSpec(MessageDigestUtils.getDigestName(AlgorithmIdentifier.getInstance(instance.getMaskGenAlgorithm().getParameters()).getAlgorithm())), instance.getSaltLength().intValue(), instance.getTrailerField().intValue());
                    return;
                }
                ASN1ObjectIdentifier aSN1ObjectIdentifier = NISTObjectIdentifiers.id_shake128;
                if (!algorithm.equals((ASN1Primitive) aSN1ObjectIdentifier)) {
                    if (!algorithm.equals((ASN1Primitive) NISTObjectIdentifiers.id_shake256)) {
                        throw new IOException("unknown mask generation function: " + instance.getMaskGenAlgorithm().getAlgorithm());
                    }
                }
                this.currentSpec = new PSSParameterSpec(MessageDigestUtils.getDigestName(instance.getHashAlgorithm().getAlgorithm()), algorithm.equals((ASN1Primitive) aSN1ObjectIdentifier) ? "SHAKE128" : "SHAKE256", (AlgorithmParameterSpec) null, instance.getSaltLength().intValue(), instance.getTrailerField().intValue());
            } catch (ClassCastException unused) {
                throw new IOException("Not a valid PSS Parameter encoding.");
            } catch (ArrayIndexOutOfBoundsException unused2) {
                throw new IOException("Not a valid PSS Parameter encoding.");
            }
        }

        public void engineInit(byte[] bArr, String str) throws IOException {
            if (isASN1FormatString(str) || str.equalsIgnoreCase("X.509")) {
                engineInit(bArr);
                return;
            }
            throw new IOException("Unknown parameter format " + str);
        }

        public String engineToString() {
            return "PSS Parameters";
        }

        public AlgorithmParameterSpec localEngineGetParameterSpec(Class cls) throws InvalidParameterSpecException {
            if (cls == PSSParameterSpec.class || cls == AlgorithmParameterSpec.class) {
                return this.currentSpec;
            }
            throw new InvalidParameterSpecException("unknown parameter spec passed to PSS parameters object.");
        }
    }

    public AlgorithmParameterSpec engineGetParameterSpec(Class cls) throws InvalidParameterSpecException {
        Objects.requireNonNull(cls, "argument to getParameterSpec must not be null");
        return localEngineGetParameterSpec(cls);
    }

    public boolean isASN1FormatString(String str) {
        return str == null || str.equals("ASN.1");
    }

    public abstract AlgorithmParameterSpec localEngineGetParameterSpec(Class cls) throws InvalidParameterSpecException;
}
