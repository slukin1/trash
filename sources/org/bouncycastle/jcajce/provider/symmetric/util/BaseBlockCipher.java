package org.bouncycastle.jcajce.provider.symmetric.util;

import com.google.android.gms.stats.CodePackage;
import java.lang.reflect.Constructor;
import java.nio.ByteBuffer;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.engines.DSTU7624Engine;
import org.bouncycastle.crypto.fpe.FPEEngine;
import org.bouncycastle.crypto.fpe.FPEFF1Engine;
import org.bouncycastle.crypto.fpe.FPEFF3_1Engine;
import org.bouncycastle.crypto.modes.AEADBlockCipher;
import org.bouncycastle.crypto.modes.AEADCipher;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.modes.CCMBlockCipher;
import org.bouncycastle.crypto.modes.CFBBlockCipher;
import org.bouncycastle.crypto.modes.CTSBlockCipher;
import org.bouncycastle.crypto.modes.EAXBlockCipher;
import org.bouncycastle.crypto.modes.GCFBBlockCipher;
import org.bouncycastle.crypto.modes.GCMBlockCipher;
import org.bouncycastle.crypto.modes.GCMSIVBlockCipher;
import org.bouncycastle.crypto.modes.GOFBBlockCipher;
import org.bouncycastle.crypto.modes.KCCMBlockCipher;
import org.bouncycastle.crypto.modes.KCTRBlockCipher;
import org.bouncycastle.crypto.modes.KGCMBlockCipher;
import org.bouncycastle.crypto.modes.OCBBlockCipher;
import org.bouncycastle.crypto.modes.OFBBlockCipher;
import org.bouncycastle.crypto.modes.OpenPGPCFBBlockCipher;
import org.bouncycastle.crypto.modes.PGPCFBBlockCipher;
import org.bouncycastle.crypto.modes.SICBlockCipher;
import org.bouncycastle.crypto.paddings.BlockCipherPadding;
import org.bouncycastle.crypto.paddings.ISO10126d2Padding;
import org.bouncycastle.crypto.paddings.ISO7816d4Padding;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.paddings.TBCPadding;
import org.bouncycastle.crypto.paddings.X923Padding;
import org.bouncycastle.crypto.paddings.ZeroBytePadding;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.internal.asn1.cms.GCMParameters;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher;
import org.bouncycastle.jcajce.spec.GOST28147ParameterSpec;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

public class BaseBlockCipher extends BaseWrapCipher {
    private static final int BUF_SIZE = 512;
    private static final Class gcmSpecClass = ClassUtil.loadClass(BaseBlockCipher.class, "javax.crypto.spec.GCMParameterSpec");
    private AEADParameters aeadParams;
    private Class[] availableSpecs;
    private BlockCipher baseEngine;
    private GenericBlockCipher cipher;
    private int digest;
    private BlockCipherProvider engineProvider;
    private boolean fixedIv;
    private int ivLength;
    private ParametersWithIV ivParam;
    private int keySizeInBits;
    private String modeName;
    private boolean padded;
    private String pbeAlgorithm;
    private PBEParameterSpec pbeSpec;
    private int scheme;

    public static class AEADGenericBlockCipher implements GenericBlockCipher {
        private static final Constructor aeadBadTagConstructor;
        /* access modifiers changed from: private */
        public AEADCipher cipher;

        static {
            Class loadClass = ClassUtil.loadClass(BaseBlockCipher.class, "javax.crypto.AEADBadTagException");
            aeadBadTagConstructor = loadClass != null ? findExceptionConstructor(loadClass) : null;
        }

        public AEADGenericBlockCipher(AEADCipher aEADCipher) {
            this.cipher = aEADCipher;
        }

        private static Constructor findExceptionConstructor(Class cls) {
            try {
                return cls.getConstructor(new Class[]{String.class});
            } catch (Exception unused) {
                return null;
            }
        }

        public int doFinal(byte[] bArr, int i11) throws IllegalStateException, BadPaddingException {
            try {
                return this.cipher.doFinal(bArr, i11);
            } catch (InvalidCipherTextException e11) {
                Constructor constructor = aeadBadTagConstructor;
                if (constructor != null) {
                    BadPaddingException badPaddingException = null;
                    try {
                        badPaddingException = (BadPaddingException) constructor.newInstance(new Object[]{e11.getMessage()});
                    } catch (Exception unused) {
                    }
                    if (badPaddingException != null) {
                        throw badPaddingException;
                    }
                }
                throw new BadPaddingException(e11.getMessage());
            }
        }

        public String getAlgorithmName() {
            AEADCipher aEADCipher = this.cipher;
            return aEADCipher instanceof AEADBlockCipher ? ((AEADBlockCipher) aEADCipher).getUnderlyingCipher().getAlgorithmName() : aEADCipher.getAlgorithmName();
        }

        public int getOutputSize(int i11) {
            return this.cipher.getOutputSize(i11);
        }

        public BlockCipher getUnderlyingCipher() {
            AEADCipher aEADCipher = this.cipher;
            if (aEADCipher instanceof AEADBlockCipher) {
                return ((AEADBlockCipher) aEADCipher).getUnderlyingCipher();
            }
            return null;
        }

        public int getUpdateOutputSize(int i11) {
            return this.cipher.getUpdateOutputSize(i11);
        }

        public void init(boolean z11, CipherParameters cipherParameters) throws IllegalArgumentException {
            this.cipher.init(z11, cipherParameters);
        }

        public int processByte(byte b11, byte[] bArr, int i11) throws DataLengthException {
            return this.cipher.processByte(b11, bArr, i11);
        }

        public int processBytes(byte[] bArr, int i11, int i12, byte[] bArr2, int i13) throws DataLengthException {
            return this.cipher.processBytes(bArr, i11, i12, bArr2, i13);
        }

        public void updateAAD(byte[] bArr, int i11, int i12) {
            this.cipher.processAADBytes(bArr, i11, i12);
        }

        public boolean wrapOnNoPadding() {
            return false;
        }
    }

    public static class BufferedFPEBlockCipher implements GenericBlockCipher {
        private FPEEngine cipher;
        private BaseWrapCipher.ErasableOutputStream eOut = new BaseWrapCipher.ErasableOutputStream();

        public BufferedFPEBlockCipher(FPEEngine fPEEngine) {
            this.cipher = fPEEngine;
        }

        public int doFinal(byte[] bArr, int i11) throws IllegalStateException, BadPaddingException {
            try {
                return this.cipher.processBlock(this.eOut.getBuf(), 0, this.eOut.size(), bArr, i11);
            } finally {
                this.eOut.erase();
            }
        }

        public String getAlgorithmName() {
            return this.cipher.getAlgorithmName();
        }

        public int getOutputSize(int i11) {
            return this.eOut.size() + i11;
        }

        public BlockCipher getUnderlyingCipher() {
            throw new IllegalStateException("not applicable for FPE");
        }

        public int getUpdateOutputSize(int i11) {
            return 0;
        }

        public void init(boolean z11, CipherParameters cipherParameters) throws IllegalArgumentException {
            this.cipher.init(z11, cipherParameters);
        }

        public int processByte(byte b11, byte[] bArr, int i11) throws DataLengthException {
            this.eOut.write(b11);
            return 0;
        }

        public int processBytes(byte[] bArr, int i11, int i12, byte[] bArr2, int i13) throws DataLengthException {
            this.eOut.write(bArr, i11, i12);
            return 0;
        }

        public void updateAAD(byte[] bArr, int i11, int i12) {
            throw new UnsupportedOperationException("AAD is not supported in the current mode.");
        }

        public boolean wrapOnNoPadding() {
            return false;
        }
    }

    public static class BufferedGenericBlockCipher implements GenericBlockCipher {
        private BufferedBlockCipher cipher;

        public BufferedGenericBlockCipher(BlockCipher blockCipher) {
            this.cipher = new PaddedBufferedBlockCipher(blockCipher);
        }

        public BufferedGenericBlockCipher(BlockCipher blockCipher, BlockCipherPadding blockCipherPadding) {
            this.cipher = new PaddedBufferedBlockCipher(blockCipher, blockCipherPadding);
        }

        public BufferedGenericBlockCipher(BufferedBlockCipher bufferedBlockCipher) {
            this.cipher = bufferedBlockCipher;
        }

        public int doFinal(byte[] bArr, int i11) throws IllegalStateException, BadPaddingException {
            try {
                return this.cipher.doFinal(bArr, i11);
            } catch (InvalidCipherTextException e11) {
                throw new BadPaddingException(e11.getMessage());
            }
        }

        public String getAlgorithmName() {
            return this.cipher.getUnderlyingCipher().getAlgorithmName();
        }

        public int getOutputSize(int i11) {
            return this.cipher.getOutputSize(i11);
        }

        public BlockCipher getUnderlyingCipher() {
            return this.cipher.getUnderlyingCipher();
        }

        public int getUpdateOutputSize(int i11) {
            return this.cipher.getUpdateOutputSize(i11);
        }

        public void init(boolean z11, CipherParameters cipherParameters) throws IllegalArgumentException {
            this.cipher.init(z11, cipherParameters);
        }

        public int processByte(byte b11, byte[] bArr, int i11) throws DataLengthException {
            return this.cipher.processByte(b11, bArr, i11);
        }

        public int processBytes(byte[] bArr, int i11, int i12, byte[] bArr2, int i13) throws DataLengthException {
            return this.cipher.processBytes(bArr, i11, i12, bArr2, i13);
        }

        public void updateAAD(byte[] bArr, int i11, int i12) {
            throw new UnsupportedOperationException("AAD is not supported in the current mode.");
        }

        public boolean wrapOnNoPadding() {
            return !(this.cipher instanceof CTSBlockCipher);
        }
    }

    public interface GenericBlockCipher {
        int doFinal(byte[] bArr, int i11) throws IllegalStateException, BadPaddingException;

        String getAlgorithmName();

        int getOutputSize(int i11);

        BlockCipher getUnderlyingCipher();

        int getUpdateOutputSize(int i11);

        void init(boolean z11, CipherParameters cipherParameters) throws IllegalArgumentException;

        int processByte(byte b11, byte[] bArr, int i11) throws DataLengthException;

        int processBytes(byte[] bArr, int i11, int i12, byte[] bArr2, int i13) throws DataLengthException;

        void updateAAD(byte[] bArr, int i11, int i12);

        boolean wrapOnNoPadding();
    }

    public BaseBlockCipher(BlockCipher blockCipher) {
        this.availableSpecs = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, gcmSpecClass, GOST28147ParameterSpec.class, IvParameterSpec.class, PBEParameterSpec.class};
        this.scheme = -1;
        this.ivLength = 0;
        this.fixedIv = true;
        this.pbeSpec = null;
        this.pbeAlgorithm = null;
        this.modeName = null;
        this.baseEngine = blockCipher;
        this.cipher = new BufferedGenericBlockCipher(blockCipher);
    }

    public BaseBlockCipher(BlockCipher blockCipher, int i11) {
        this(blockCipher, true, i11);
    }

    public BaseBlockCipher(BlockCipher blockCipher, int i11, int i12, int i13, int i14) {
        this.availableSpecs = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, gcmSpecClass, GOST28147ParameterSpec.class, IvParameterSpec.class, PBEParameterSpec.class};
        this.scheme = -1;
        this.ivLength = 0;
        this.fixedIv = true;
        this.pbeSpec = null;
        this.pbeAlgorithm = null;
        this.modeName = null;
        this.baseEngine = blockCipher;
        this.scheme = i11;
        this.digest = i12;
        this.keySizeInBits = i13;
        this.ivLength = i14;
        this.cipher = new BufferedGenericBlockCipher(blockCipher);
    }

    public BaseBlockCipher(BlockCipher blockCipher, boolean z11, int i11) {
        this.availableSpecs = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, gcmSpecClass, GOST28147ParameterSpec.class, IvParameterSpec.class, PBEParameterSpec.class};
        this.scheme = -1;
        this.ivLength = 0;
        this.fixedIv = true;
        this.pbeSpec = null;
        this.pbeAlgorithm = null;
        this.modeName = null;
        this.baseEngine = blockCipher;
        this.fixedIv = z11;
        this.cipher = new BufferedGenericBlockCipher(blockCipher);
        this.ivLength = i11 / 8;
    }

    public BaseBlockCipher(BufferedBlockCipher bufferedBlockCipher, int i11) {
        this(bufferedBlockCipher, true, i11);
    }

    public BaseBlockCipher(BufferedBlockCipher bufferedBlockCipher, boolean z11, int i11) {
        this.availableSpecs = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, gcmSpecClass, GOST28147ParameterSpec.class, IvParameterSpec.class, PBEParameterSpec.class};
        this.scheme = -1;
        this.ivLength = 0;
        this.fixedIv = true;
        this.pbeSpec = null;
        this.pbeAlgorithm = null;
        this.modeName = null;
        this.baseEngine = bufferedBlockCipher.getUnderlyingCipher();
        this.cipher = new BufferedGenericBlockCipher(bufferedBlockCipher);
        this.fixedIv = z11;
        this.ivLength = i11 / 8;
    }

    public BaseBlockCipher(AEADBlockCipher aEADBlockCipher) {
        this.availableSpecs = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, gcmSpecClass, GOST28147ParameterSpec.class, IvParameterSpec.class, PBEParameterSpec.class};
        this.scheme = -1;
        this.ivLength = 0;
        this.fixedIv = true;
        this.pbeSpec = null;
        this.pbeAlgorithm = null;
        this.modeName = null;
        this.baseEngine = aEADBlockCipher.getUnderlyingCipher();
        this.ivLength = aEADBlockCipher.getAlgorithmName().indexOf(CodePackage.GCM) >= 0 ? 12 : this.baseEngine.getBlockSize();
        this.cipher = new AEADGenericBlockCipher(aEADBlockCipher);
    }

    public BaseBlockCipher(AEADBlockCipher aEADBlockCipher, boolean z11, int i11) {
        this.availableSpecs = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, gcmSpecClass, GOST28147ParameterSpec.class, IvParameterSpec.class, PBEParameterSpec.class};
        this.scheme = -1;
        this.ivLength = 0;
        this.fixedIv = true;
        this.pbeSpec = null;
        this.pbeAlgorithm = null;
        this.modeName = null;
        this.baseEngine = aEADBlockCipher.getUnderlyingCipher();
        this.fixedIv = z11;
        this.ivLength = i11;
        this.cipher = new AEADGenericBlockCipher(aEADBlockCipher);
    }

    public BaseBlockCipher(AEADCipher aEADCipher, boolean z11, int i11) {
        this.availableSpecs = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, gcmSpecClass, GOST28147ParameterSpec.class, IvParameterSpec.class, PBEParameterSpec.class};
        this.scheme = -1;
        this.ivLength = 0;
        this.fixedIv = true;
        this.pbeSpec = null;
        this.pbeAlgorithm = null;
        this.modeName = null;
        this.baseEngine = null;
        this.fixedIv = z11;
        this.ivLength = i11;
        this.cipher = new AEADGenericBlockCipher(aEADCipher);
    }

    public BaseBlockCipher(BlockCipherProvider blockCipherProvider) {
        this.availableSpecs = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, gcmSpecClass, GOST28147ParameterSpec.class, IvParameterSpec.class, PBEParameterSpec.class};
        this.scheme = -1;
        this.ivLength = 0;
        this.fixedIv = true;
        this.pbeSpec = null;
        this.pbeAlgorithm = null;
        this.modeName = null;
        this.baseEngine = blockCipherProvider.get();
        this.engineProvider = blockCipherProvider;
        this.cipher = new BufferedGenericBlockCipher(blockCipherProvider.get());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: org.bouncycastle.crypto.params.ParametersWithSBox} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: org.bouncycastle.crypto.params.ParametersWithIV} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: org.bouncycastle.crypto.params.ParametersWithSBox} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: org.bouncycastle.crypto.params.ParametersWithSBox} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: org.bouncycastle.crypto.params.ParametersWithSBox} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.bouncycastle.crypto.CipherParameters adjustParameters(java.security.spec.AlgorithmParameterSpec r4, org.bouncycastle.crypto.CipherParameters r5) {
        /*
            r3 = this;
            boolean r0 = r5 instanceof org.bouncycastle.crypto.params.ParametersWithIV
            if (r0 == 0) goto L_0x0042
            r0 = r5
            org.bouncycastle.crypto.params.ParametersWithIV r0 = (org.bouncycastle.crypto.params.ParametersWithIV) r0
            org.bouncycastle.crypto.CipherParameters r0 = r0.getParameters()
            boolean r1 = r4 instanceof javax.crypto.spec.IvParameterSpec
            if (r1 == 0) goto L_0x001d
            javax.crypto.spec.IvParameterSpec r4 = (javax.crypto.spec.IvParameterSpec) r4
            org.bouncycastle.crypto.params.ParametersWithIV r5 = new org.bouncycastle.crypto.params.ParametersWithIV
            byte[] r4 = r4.getIV()
            r5.<init>(r0, r4)
        L_0x001a:
            r3.ivParam = r5
            goto L_0x0077
        L_0x001d:
            boolean r1 = r4 instanceof org.bouncycastle.jcajce.spec.GOST28147ParameterSpec
            if (r1 == 0) goto L_0x0077
            org.bouncycastle.jcajce.spec.GOST28147ParameterSpec r4 = (org.bouncycastle.jcajce.spec.GOST28147ParameterSpec) r4
            org.bouncycastle.crypto.params.ParametersWithSBox r1 = new org.bouncycastle.crypto.params.ParametersWithSBox
            byte[] r2 = r4.getSbox()
            r1.<init>(r5, r2)
            byte[] r5 = r4.getIV()
            if (r5 == 0) goto L_0x0040
            int r5 = r3.ivLength
            if (r5 == 0) goto L_0x0040
            org.bouncycastle.crypto.params.ParametersWithIV r5 = new org.bouncycastle.crypto.params.ParametersWithIV
            byte[] r4 = r4.getIV()
            r5.<init>(r0, r4)
            goto L_0x001a
        L_0x0040:
            r5 = r1
            goto L_0x0077
        L_0x0042:
            boolean r0 = r4 instanceof javax.crypto.spec.IvParameterSpec
            if (r0 == 0) goto L_0x0055
            javax.crypto.spec.IvParameterSpec r4 = (javax.crypto.spec.IvParameterSpec) r4
            org.bouncycastle.crypto.params.ParametersWithIV r0 = new org.bouncycastle.crypto.params.ParametersWithIV
            byte[] r4 = r4.getIV()
            r0.<init>(r5, r4)
            r3.ivParam = r0
        L_0x0053:
            r5 = r0
            goto L_0x0077
        L_0x0055:
            boolean r0 = r4 instanceof org.bouncycastle.jcajce.spec.GOST28147ParameterSpec
            if (r0 == 0) goto L_0x0077
            org.bouncycastle.jcajce.spec.GOST28147ParameterSpec r4 = (org.bouncycastle.jcajce.spec.GOST28147ParameterSpec) r4
            org.bouncycastle.crypto.params.ParametersWithSBox r0 = new org.bouncycastle.crypto.params.ParametersWithSBox
            byte[] r1 = r4.getSbox()
            r0.<init>(r5, r1)
            byte[] r5 = r4.getIV()
            if (r5 == 0) goto L_0x0053
            int r5 = r3.ivLength
            if (r5 == 0) goto L_0x0053
            org.bouncycastle.crypto.params.ParametersWithIV r5 = new org.bouncycastle.crypto.params.ParametersWithIV
            byte[] r4 = r4.getIV()
            r5.<init>(r0, r4)
        L_0x0077:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.adjustParameters(java.security.spec.AlgorithmParameterSpec, org.bouncycastle.crypto.CipherParameters):org.bouncycastle.crypto.CipherParameters");
    }

    private boolean isAEADModeName(String str) {
        return "CCM".equals(str) || "EAX".equals(str) || CodePackage.GCM.equals(str) || "GCM-SIV".equals(str) || "OCB".equals(str);
    }

    public int engineDoFinal(byte[] bArr, int i11, int i12, byte[] bArr2, int i13) throws IllegalBlockSizeException, BadPaddingException, ShortBufferException {
        int i14;
        if (engineGetOutputSize(i12) + i13 <= bArr2.length) {
            if (i12 != 0) {
                try {
                    i14 = this.cipher.processBytes(bArr, i11, i12, bArr2, i13);
                } catch (OutputLengthException e11) {
                    throw new IllegalBlockSizeException(e11.getMessage());
                } catch (DataLengthException e12) {
                    throw new IllegalBlockSizeException(e12.getMessage());
                }
            } else {
                i14 = 0;
            }
            return i14 + this.cipher.doFinal(bArr2, i13 + i14);
        }
        throw new ShortBufferException("output buffer too short for input.");
    }

    public byte[] engineDoFinal(byte[] bArr, int i11, int i12) throws IllegalBlockSizeException, BadPaddingException {
        int engineGetOutputSize = engineGetOutputSize(i12);
        byte[] bArr2 = new byte[engineGetOutputSize];
        int processBytes = i12 != 0 ? this.cipher.processBytes(bArr, i11, i12, bArr2, 0) : 0;
        try {
            int doFinal = processBytes + this.cipher.doFinal(bArr2, processBytes);
            if (doFinal == engineGetOutputSize) {
                return bArr2;
            }
            if (doFinal <= engineGetOutputSize) {
                byte[] bArr3 = new byte[doFinal];
                System.arraycopy(bArr2, 0, bArr3, 0, doFinal);
                return bArr3;
            }
            throw new IllegalBlockSizeException("internal buffer overflow");
        } catch (DataLengthException e11) {
            throw new IllegalBlockSizeException(e11.getMessage());
        }
    }

    public int engineGetBlockSize() {
        BlockCipher blockCipher = this.baseEngine;
        if (blockCipher == null) {
            return -1;
        }
        return blockCipher.getBlockSize();
    }

    public byte[] engineGetIV() {
        AEADParameters aEADParameters = this.aeadParams;
        if (aEADParameters != null) {
            return aEADParameters.getNonce();
        }
        ParametersWithIV parametersWithIV = this.ivParam;
        if (parametersWithIV != null) {
            return parametersWithIV.getIV();
        }
        return null;
    }

    public int engineGetKeySize(Key key) {
        return key.getEncoded().length * 8;
    }

    public int engineGetOutputSize(int i11) {
        return this.cipher.getOutputSize(i11);
    }

    public AlgorithmParameters engineGetParameters() {
        if (this.engineParams == null) {
            if (this.pbeSpec != null) {
                try {
                    AlgorithmParameters createParametersInstance = createParametersInstance(this.pbeAlgorithm);
                    this.engineParams = createParametersInstance;
                    createParametersInstance.init(this.pbeSpec);
                } catch (Exception unused) {
                    return null;
                }
            } else if (this.aeadParams != null) {
                if (this.baseEngine == null) {
                    try {
                        AlgorithmParameters createParametersInstance2 = createParametersInstance(PKCSObjectIdentifiers.id_alg_AEADChaCha20Poly1305.getId());
                        this.engineParams = createParametersInstance2;
                        createParametersInstance2.init(new DEROctetString(this.aeadParams.getNonce()).getEncoded());
                    } catch (Exception e11) {
                        throw new RuntimeException(e11.toString());
                    }
                } else {
                    try {
                        AlgorithmParameters createParametersInstance3 = createParametersInstance(CodePackage.GCM);
                        this.engineParams = createParametersInstance3;
                        createParametersInstance3.init(new GCMParameters(this.aeadParams.getNonce(), this.aeadParams.getMacSize() / 8).getEncoded());
                    } catch (Exception e12) {
                        throw new RuntimeException(e12.toString());
                    }
                }
            } else if (this.ivParam != null) {
                String algorithmName = this.cipher.getUnderlyingCipher().getAlgorithmName();
                if (algorithmName.indexOf(47) >= 0) {
                    algorithmName = algorithmName.substring(0, algorithmName.indexOf(47));
                }
                try {
                    AlgorithmParameters createParametersInstance4 = createParametersInstance(algorithmName);
                    this.engineParams = createParametersInstance4;
                    createParametersInstance4.init(new IvParameterSpec(this.ivParam.getIV()));
                } catch (Exception e13) {
                    throw new RuntimeException(e13.toString());
                }
            }
        }
        return this.engineParams;
    }

    public void engineInit(int i11, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        AlgorithmParameterSpec algorithmParameterSpec;
        if (algorithmParameters != null) {
            algorithmParameterSpec = SpecUtil.extractSpec(algorithmParameters, this.availableSpecs);
            if (algorithmParameterSpec == null) {
                throw new InvalidAlgorithmParameterException("can't handle parameter " + algorithmParameters.toString());
            }
        } else {
            algorithmParameterSpec = null;
        }
        engineInit(i11, key, algorithmParameterSpec, secureRandom);
        this.engineParams = algorithmParameters;
    }

    public void engineInit(int i11, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            engineInit(i11, key, (AlgorithmParameterSpec) null, secureRandom);
        } catch (InvalidAlgorithmParameterException e11) {
            throw new InvalidKeyException(e11.getMessage());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: org.bouncycastle.crypto.params.ParametersWithRandom} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: org.bouncycastle.crypto.params.ParametersWithRandom} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: org.bouncycastle.crypto.params.ParametersWithRandom} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v14, resolved type: org.bouncycastle.crypto.params.ParametersWithIV} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: org.bouncycastle.crypto.params.ParametersWithRandom} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: org.bouncycastle.crypto.params.FPEParameters} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v17, resolved type: org.bouncycastle.crypto.params.ParametersWithIV} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v53, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v55, resolved type: org.bouncycastle.crypto.params.ParametersWithRandom} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v56, resolved type: org.bouncycastle.crypto.params.ParametersWithRandom} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v57, resolved type: org.bouncycastle.crypto.params.ParametersWithRandom} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v58, resolved type: org.bouncycastle.crypto.params.ParametersWithRandom} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v60, resolved type: org.bouncycastle.crypto.params.RC5Parameters} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v61, resolved type: org.bouncycastle.crypto.params.RC5Parameters} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v62, resolved type: org.bouncycastle.crypto.params.RC2Parameters} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v63, resolved type: org.bouncycastle.crypto.params.RC2Parameters} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v64, resolved type: org.bouncycastle.crypto.params.ParametersWithSBox} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v65, resolved type: org.bouncycastle.crypto.params.ParametersWithSBox} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v66, resolved type: org.bouncycastle.crypto.params.ParametersWithIV} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v67, resolved type: org.bouncycastle.crypto.params.AEADParameters} */
    /* JADX WARNING: type inference failed for: r5v0 */
    /* JADX WARNING: type inference failed for: r5v1, types: [org.bouncycastle.crypto.CipherParameters] */
    /* JADX WARNING: type inference failed for: r5v2, types: [org.bouncycastle.crypto.CipherParameters] */
    /* JADX WARNING: type inference failed for: r5v69 */
    /* JADX WARNING: type inference failed for: r5v72 */
    /* JADX WARNING: type inference failed for: r5v73 */
    /* JADX WARNING: type inference failed for: r5v74 */
    /* JADX WARNING: type inference failed for: r5v76 */
    /* JADX WARNING: type inference failed for: r5v81 */
    /* JADX WARNING: type inference failed for: r5v82 */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ac, code lost:
        if (r7 != false) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00f9, code lost:
        if (r7 != false) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0145, code lost:
        if (r7 != false) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01fd, code lost:
        if (r7 != false) goto L_0x00ae;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0205  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0244  */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x045c  */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x04a9  */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x04e2 A[Catch:{ IllegalArgumentException -> 0x0510, Exception -> 0x0505 }] */
    /* JADX WARNING: Removed duplicated region for block: B:250:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void engineInit(int r21, java.security.Key r22, java.security.spec.AlgorithmParameterSpec r23, java.security.SecureRandom r24) throws java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
        /*
            r20 = this;
            r1 = r20
            r0 = r21
            r2 = r22
            r3 = r23
            r4 = r24
            r5 = 0
            r1.pbeSpec = r5
            r1.pbeAlgorithm = r5
            r1.engineParams = r5
            r1.aeadParams = r5
            boolean r6 = r2 instanceof javax.crypto.SecretKey
            if (r6 != 0) goto L_0x0039
            java.security.InvalidKeyException r0 = new java.security.InvalidKeyException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Key for algorithm "
            r3.append(r4)
            if (r2 == 0) goto L_0x0029
            java.lang.String r5 = r22.getAlgorithm()
        L_0x0029:
            r3.append(r5)
            java.lang.String r2 = " not suitable for symmetric enryption."
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r0.<init>(r2)
            throw r0
        L_0x0039:
            java.lang.String r6 = "RC5-64"
            if (r3 != 0) goto L_0x0054
            org.bouncycastle.crypto.BlockCipher r7 = r1.baseEngine
            if (r7 == 0) goto L_0x0054
            java.lang.String r7 = r7.getAlgorithmName()
            boolean r7 = r7.startsWith(r6)
            if (r7 != 0) goto L_0x004c
            goto L_0x0054
        L_0x004c:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r2 = "RC5 requires an RC5ParametersSpec to be passed in."
            r0.<init>(r2)
            throw r0
        L_0x0054:
            int r7 = r1.scheme
            r8 = 4
            java.lang.String r9 = "Algorithm requires a PBE key"
            r10 = 2
            r11 = 1
            if (r7 == r10) goto L_0x0167
            boolean r12 = r2 instanceof org.bouncycastle.jcajce.PKCS12Key
            if (r12 == 0) goto L_0x0063
            goto L_0x0167
        L_0x0063:
            boolean r12 = r2 instanceof org.bouncycastle.jcajce.PBKDF1Key
            if (r12 == 0) goto L_0x00b5
            r5 = r2
            org.bouncycastle.jcajce.PBKDF1Key r5 = (org.bouncycastle.jcajce.PBKDF1Key) r5
            boolean r7 = r3 instanceof javax.crypto.spec.PBEParameterSpec
            if (r7 == 0) goto L_0x0073
            r7 = r3
            javax.crypto.spec.PBEParameterSpec r7 = (javax.crypto.spec.PBEParameterSpec) r7
            r1.pbeSpec = r7
        L_0x0073:
            boolean r7 = r5 instanceof org.bouncycastle.jcajce.PBKDF1KeyWithParameters
            if (r7 == 0) goto L_0x008d
            javax.crypto.spec.PBEParameterSpec r7 = r1.pbeSpec
            if (r7 != 0) goto L_0x008d
            javax.crypto.spec.PBEParameterSpec r7 = new javax.crypto.spec.PBEParameterSpec
            r9 = r5
            org.bouncycastle.jcajce.PBKDF1KeyWithParameters r9 = (org.bouncycastle.jcajce.PBKDF1KeyWithParameters) r9
            byte[] r12 = r9.getSalt()
            int r9 = r9.getIterationCount()
            r7.<init>(r12, r9)
            r1.pbeSpec = r7
        L_0x008d:
            byte[] r13 = r5.getEncoded()
            r14 = 0
            int r15 = r1.digest
            int r5 = r1.keySizeInBits
            int r7 = r1.ivLength
            int r17 = r7 * 8
            javax.crypto.spec.PBEParameterSpec r7 = r1.pbeSpec
            org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher r9 = r1.cipher
            java.lang.String r19 = r9.getAlgorithmName()
            r16 = r5
            r18 = r7
            org.bouncycastle.crypto.CipherParameters r5 = org.bouncycastle.jcajce.provider.symmetric.util.PBE.Util.makePBEParameters(r13, r14, r15, r16, r17, r18, r19)
            boolean r7 = r5 instanceof org.bouncycastle.crypto.params.ParametersWithIV
            if (r7 == 0) goto L_0x0201
        L_0x00ae:
            r7 = r5
            org.bouncycastle.crypto.params.ParametersWithIV r7 = (org.bouncycastle.crypto.params.ParametersWithIV) r7
            r1.ivParam = r7
            goto L_0x0201
        L_0x00b5:
            boolean r12 = r2 instanceof org.bouncycastle.jcajce.provider.symmetric.util.BCPBEKey
            if (r12 == 0) goto L_0x0104
            r5 = r2
            org.bouncycastle.jcajce.provider.symmetric.util.BCPBEKey r5 = (org.bouncycastle.jcajce.provider.symmetric.util.BCPBEKey) r5
            org.bouncycastle.asn1.ASN1ObjectIdentifier r7 = r5.getOID()
            if (r7 == 0) goto L_0x00cb
            org.bouncycastle.asn1.ASN1ObjectIdentifier r7 = r5.getOID()
            java.lang.String r7 = r7.getId()
            goto L_0x00cf
        L_0x00cb:
            java.lang.String r7 = r5.getAlgorithm()
        L_0x00cf:
            r1.pbeAlgorithm = r7
            org.bouncycastle.crypto.CipherParameters r7 = r5.getParam()
            if (r7 == 0) goto L_0x00e0
            org.bouncycastle.crypto.CipherParameters r5 = r5.getParam()
            org.bouncycastle.crypto.CipherParameters r5 = r1.adjustParameters(r3, r5)
            goto L_0x00f7
        L_0x00e0:
            boolean r7 = r3 instanceof javax.crypto.spec.PBEParameterSpec
            if (r7 == 0) goto L_0x00fc
            r7 = r3
            javax.crypto.spec.PBEParameterSpec r7 = (javax.crypto.spec.PBEParameterSpec) r7
            r1.pbeSpec = r7
            org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher r7 = r1.cipher
            org.bouncycastle.crypto.BlockCipher r7 = r7.getUnderlyingCipher()
            java.lang.String r7 = r7.getAlgorithmName()
            org.bouncycastle.crypto.CipherParameters r5 = org.bouncycastle.jcajce.provider.symmetric.util.PBE.Util.makePBEParameters(r5, r3, r7)
        L_0x00f7:
            boolean r7 = r5 instanceof org.bouncycastle.crypto.params.ParametersWithIV
            if (r7 == 0) goto L_0x0201
            goto L_0x00ae
        L_0x00fc:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r2 = "PBE requires PBE parameters to be set."
            r0.<init>(r2)
            throw r0
        L_0x0104:
            boolean r12 = r2 instanceof javax.crypto.interfaces.PBEKey
            if (r12 == 0) goto L_0x0149
            r5 = r2
            javax.crypto.interfaces.PBEKey r5 = (javax.crypto.interfaces.PBEKey) r5
            r7 = r3
            javax.crypto.spec.PBEParameterSpec r7 = (javax.crypto.spec.PBEParameterSpec) r7
            r1.pbeSpec = r7
            boolean r9 = r5 instanceof org.bouncycastle.jcajce.PKCS12KeyWithParameters
            if (r9 == 0) goto L_0x0125
            if (r7 != 0) goto L_0x0125
            javax.crypto.spec.PBEParameterSpec r7 = new javax.crypto.spec.PBEParameterSpec
            byte[] r9 = r5.getSalt()
            int r12 = r5.getIterationCount()
            r7.<init>(r9, r12)
            r1.pbeSpec = r7
        L_0x0125:
            byte[] r13 = r5.getEncoded()
            int r14 = r1.scheme
            int r15 = r1.digest
            int r5 = r1.keySizeInBits
            int r7 = r1.ivLength
            int r17 = r7 * 8
            javax.crypto.spec.PBEParameterSpec r7 = r1.pbeSpec
            org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher r9 = r1.cipher
            java.lang.String r19 = r9.getAlgorithmName()
            r16 = r5
            r18 = r7
            org.bouncycastle.crypto.CipherParameters r5 = org.bouncycastle.jcajce.provider.symmetric.util.PBE.Util.makePBEParameters(r13, r14, r15, r16, r17, r18, r19)
            boolean r7 = r5 instanceof org.bouncycastle.crypto.params.ParametersWithIV
            if (r7 == 0) goto L_0x0201
            goto L_0x00ae
        L_0x0149:
            boolean r12 = r2 instanceof org.bouncycastle.jcajce.spec.RepeatedSecretKeySpec
            if (r12 != 0) goto L_0x0201
            if (r7 == 0) goto L_0x0161
            if (r7 == r8) goto L_0x0161
            if (r7 == r11) goto L_0x0161
            r5 = 5
            if (r7 == r5) goto L_0x0161
            org.bouncycastle.crypto.params.KeyParameter r5 = new org.bouncycastle.crypto.params.KeyParameter
            byte[] r7 = r22.getEncoded()
            r5.<init>(r7)
            goto L_0x0201
        L_0x0161:
            java.security.InvalidKeyException r0 = new java.security.InvalidKeyException
            r0.<init>(r9)
            throw r0
        L_0x0167:
            r5 = r2
            javax.crypto.SecretKey r5 = (javax.crypto.SecretKey) r5     // Catch:{ Exception -> 0x051b }
            boolean r7 = r3 instanceof javax.crypto.spec.PBEParameterSpec
            if (r7 == 0) goto L_0x0173
            r7 = r3
            javax.crypto.spec.PBEParameterSpec r7 = (javax.crypto.spec.PBEParameterSpec) r7
            r1.pbeSpec = r7
        L_0x0173:
            boolean r7 = r5 instanceof javax.crypto.interfaces.PBEKey
            if (r7 == 0) goto L_0x019c
            javax.crypto.spec.PBEParameterSpec r12 = r1.pbeSpec
            if (r12 != 0) goto L_0x019c
            r12 = r5
            javax.crypto.interfaces.PBEKey r12 = (javax.crypto.interfaces.PBEKey) r12
            byte[] r13 = r12.getSalt()
            if (r13 == 0) goto L_0x0194
            javax.crypto.spec.PBEParameterSpec r13 = new javax.crypto.spec.PBEParameterSpec
            byte[] r14 = r12.getSalt()
            int r12 = r12.getIterationCount()
            r13.<init>(r14, r12)
            r1.pbeSpec = r13
            goto L_0x019c
        L_0x0194:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r2 = "PBEKey requires parameters to specify salt"
            r0.<init>(r2)
            throw r0
        L_0x019c:
            javax.crypto.spec.PBEParameterSpec r12 = r1.pbeSpec
            if (r12 != 0) goto L_0x01a9
            if (r7 == 0) goto L_0x01a3
            goto L_0x01a9
        L_0x01a3:
            java.security.InvalidKeyException r0 = new java.security.InvalidKeyException
            r0.<init>(r9)
            throw r0
        L_0x01a9:
            boolean r7 = r2 instanceof org.bouncycastle.jcajce.provider.symmetric.util.BCPBEKey
            if (r7 == 0) goto L_0x01e0
            r7 = r2
            org.bouncycastle.jcajce.provider.symmetric.util.BCPBEKey r7 = (org.bouncycastle.jcajce.provider.symmetric.util.BCPBEKey) r7
            org.bouncycastle.crypto.CipherParameters r7 = r7.getParam()
            boolean r9 = r7 instanceof org.bouncycastle.crypto.params.ParametersWithIV
            if (r9 == 0) goto L_0x01b9
            goto L_0x01d6
        L_0x01b9:
            if (r7 != 0) goto L_0x01d8
            byte[] r12 = r5.getEncoded()
            r13 = 2
            int r14 = r1.digest
            int r15 = r1.keySizeInBits
            int r5 = r1.ivLength
            int r16 = r5 * 8
            javax.crypto.spec.PBEParameterSpec r5 = r1.pbeSpec
            org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher r7 = r1.cipher
            java.lang.String r18 = r7.getAlgorithmName()
            r17 = r5
            org.bouncycastle.crypto.CipherParameters r7 = org.bouncycastle.jcajce.provider.symmetric.util.PBE.Util.makePBEParameters(r12, r13, r14, r15, r16, r17, r18)
        L_0x01d6:
            r5 = r7
            goto L_0x01fb
        L_0x01d8:
            java.security.InvalidKeyException r0 = new java.security.InvalidKeyException
            java.lang.String r2 = "Algorithm requires a PBE key suitable for PKCS12"
            r0.<init>(r2)
            throw r0
        L_0x01e0:
            byte[] r12 = r5.getEncoded()
            r13 = 2
            int r14 = r1.digest
            int r15 = r1.keySizeInBits
            int r5 = r1.ivLength
            int r16 = r5 * 8
            javax.crypto.spec.PBEParameterSpec r5 = r1.pbeSpec
            org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher r7 = r1.cipher
            java.lang.String r18 = r7.getAlgorithmName()
            r17 = r5
            org.bouncycastle.crypto.CipherParameters r5 = org.bouncycastle.jcajce.provider.symmetric.util.PBE.Util.makePBEParameters(r12, r13, r14, r15, r16, r17, r18)
        L_0x01fb:
            boolean r7 = r5 instanceof org.bouncycastle.crypto.params.ParametersWithIV
            if (r7 == 0) goto L_0x0201
            goto L_0x00ae
        L_0x0201:
            boolean r7 = r3 instanceof org.bouncycastle.jcajce.spec.AEADParameterSpec
            if (r7 == 0) goto L_0x0244
            java.lang.String r2 = r1.modeName
            boolean r2 = r1.isAEADModeName(r2)
            if (r2 != 0) goto L_0x021c
            org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher r2 = r1.cipher
            boolean r2 = r2 instanceof org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.AEADGenericBlockCipher
            if (r2 == 0) goto L_0x0214
            goto L_0x021c
        L_0x0214:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r2 = "AEADParameterSpec can only be used with AEAD modes."
            r0.<init>(r2)
            throw r0
        L_0x021c:
            r2 = r3
            org.bouncycastle.jcajce.spec.AEADParameterSpec r2 = (org.bouncycastle.jcajce.spec.AEADParameterSpec) r2
            boolean r3 = r5 instanceof org.bouncycastle.crypto.params.ParametersWithIV
            if (r3 == 0) goto L_0x022c
            org.bouncycastle.crypto.params.ParametersWithIV r5 = (org.bouncycastle.crypto.params.ParametersWithIV) r5
            org.bouncycastle.crypto.CipherParameters r3 = r5.getParameters()
            org.bouncycastle.crypto.params.KeyParameter r3 = (org.bouncycastle.crypto.params.KeyParameter) r3
            goto L_0x022f
        L_0x022c:
            r3 = r5
            org.bouncycastle.crypto.params.KeyParameter r3 = (org.bouncycastle.crypto.params.KeyParameter) r3
        L_0x022f:
            org.bouncycastle.crypto.params.AEADParameters r5 = new org.bouncycastle.crypto.params.AEADParameters
            int r6 = r2.getMacSizeInBits()
            byte[] r7 = r2.getNonce()
            byte[] r2 = r2.getAssociatedData()
            r5.<init>(r3, r6, r7, r2)
        L_0x0240:
            r1.aeadParams = r5
            goto L_0x0457
        L_0x0244:
            boolean r7 = r3 instanceof javax.crypto.spec.IvParameterSpec
            if (r7 == 0) goto L_0x02b9
            int r2 = r1.ivLength
            if (r2 == 0) goto L_0x02a3
            r2 = r3
            javax.crypto.spec.IvParameterSpec r2 = (javax.crypto.spec.IvParameterSpec) r2
            byte[] r3 = r2.getIV()
            int r3 = r3.length
            int r6 = r1.ivLength
            if (r3 == r6) goto L_0x0281
            org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher r3 = r1.cipher
            boolean r3 = r3 instanceof org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.AEADGenericBlockCipher
            if (r3 != 0) goto L_0x0281
            boolean r3 = r1.fixedIv
            if (r3 != 0) goto L_0x0263
            goto L_0x0281
        L_0x0263:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "IV must be "
            r2.append(r3)
            int r3 = r1.ivLength
            r2.append(r3)
            java.lang.String r3 = " bytes long."
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        L_0x0281:
            boolean r3 = r5 instanceof org.bouncycastle.crypto.params.ParametersWithIV
            if (r3 == 0) goto L_0x0295
            org.bouncycastle.crypto.params.ParametersWithIV r3 = new org.bouncycastle.crypto.params.ParametersWithIV
            org.bouncycastle.crypto.params.ParametersWithIV r5 = (org.bouncycastle.crypto.params.ParametersWithIV) r5
            org.bouncycastle.crypto.CipherParameters r5 = r5.getParameters()
            byte[] r2 = r2.getIV()
            r3.<init>(r5, r2)
            goto L_0x029e
        L_0x0295:
            org.bouncycastle.crypto.params.ParametersWithIV r3 = new org.bouncycastle.crypto.params.ParametersWithIV
            byte[] r2 = r2.getIV()
            r3.<init>(r5, r2)
        L_0x029e:
            r5 = r3
            r1.ivParam = r5
            goto L_0x0457
        L_0x02a3:
            java.lang.String r2 = r1.modeName
            if (r2 == 0) goto L_0x0457
            java.lang.String r3 = "ECB"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x02b1
            goto L_0x0457
        L_0x02b1:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r2 = "ECB mode does not use an IV"
            r0.<init>(r2)
            throw r0
        L_0x02b9:
            boolean r7 = r3 instanceof org.bouncycastle.jcajce.spec.GOST28147ParameterSpec
            if (r7 == 0) goto L_0x02fd
            org.bouncycastle.jcajce.spec.GOST28147ParameterSpec r3 = (org.bouncycastle.jcajce.spec.GOST28147ParameterSpec) r3
            org.bouncycastle.crypto.params.ParametersWithSBox r5 = new org.bouncycastle.crypto.params.ParametersWithSBox
            org.bouncycastle.crypto.params.KeyParameter r6 = new org.bouncycastle.crypto.params.KeyParameter
            byte[] r2 = r22.getEncoded()
            r6.<init>(r2)
            byte[] r2 = r3.getSbox()
            r5.<init>(r6, r2)
            byte[] r2 = r3.getIV()
            if (r2 == 0) goto L_0x0457
            int r2 = r1.ivLength
            if (r2 == 0) goto L_0x0457
            boolean r2 = r5 instanceof org.bouncycastle.crypto.params.ParametersWithIV
            if (r2 == 0) goto L_0x02ef
            org.bouncycastle.crypto.params.ParametersWithIV r2 = new org.bouncycastle.crypto.params.ParametersWithIV
            org.bouncycastle.crypto.params.ParametersWithIV r5 = (org.bouncycastle.crypto.params.ParametersWithIV) r5
            org.bouncycastle.crypto.CipherParameters r5 = r5.getParameters()
            byte[] r3 = r3.getIV()
            r2.<init>(r5, r3)
            goto L_0x02f8
        L_0x02ef:
            org.bouncycastle.crypto.params.ParametersWithIV r2 = new org.bouncycastle.crypto.params.ParametersWithIV
            byte[] r3 = r3.getIV()
            r2.<init>(r5, r3)
        L_0x02f8:
            r1.ivParam = r2
            r5 = r2
            goto L_0x0457
        L_0x02fd:
            boolean r7 = r3 instanceof javax.crypto.spec.RC2ParameterSpec
            if (r7 == 0) goto L_0x0338
            javax.crypto.spec.RC2ParameterSpec r3 = (javax.crypto.spec.RC2ParameterSpec) r3
            org.bouncycastle.crypto.params.RC2Parameters r5 = new org.bouncycastle.crypto.params.RC2Parameters
            byte[] r2 = r22.getEncoded()
            int r6 = r3.getEffectiveKeyBits()
            r5.<init>(r2, r6)
            byte[] r2 = r3.getIV()
            if (r2 == 0) goto L_0x0457
            int r2 = r1.ivLength
            if (r2 == 0) goto L_0x0457
            boolean r2 = r5 instanceof org.bouncycastle.crypto.params.ParametersWithIV
            if (r2 == 0) goto L_0x032e
            org.bouncycastle.crypto.params.ParametersWithIV r2 = new org.bouncycastle.crypto.params.ParametersWithIV
            org.bouncycastle.crypto.params.ParametersWithIV r5 = (org.bouncycastle.crypto.params.ParametersWithIV) r5
            org.bouncycastle.crypto.CipherParameters r5 = r5.getParameters()
            byte[] r3 = r3.getIV()
            r2.<init>(r5, r3)
            goto L_0x02f8
        L_0x032e:
            org.bouncycastle.crypto.params.ParametersWithIV r2 = new org.bouncycastle.crypto.params.ParametersWithIV
            byte[] r3 = r3.getIV()
            r2.<init>(r5, r3)
            goto L_0x02f8
        L_0x0338:
            boolean r7 = r3 instanceof javax.crypto.spec.RC5ParameterSpec
            if (r7 == 0) goto L_0x03f5
            javax.crypto.spec.RC5ParameterSpec r3 = (javax.crypto.spec.RC5ParameterSpec) r3
            org.bouncycastle.crypto.params.RC5Parameters r5 = new org.bouncycastle.crypto.params.RC5Parameters
            byte[] r2 = r22.getEncoded()
            int r7 = r3.getRounds()
            r5.<init>(r2, r7)
            org.bouncycastle.crypto.BlockCipher r2 = r1.baseEngine
            java.lang.String r2 = r2.getAlgorithmName()
            java.lang.String r7 = "RC5"
            boolean r2 = r2.startsWith(r7)
            if (r2 == 0) goto L_0x03ed
            org.bouncycastle.crypto.BlockCipher r2 = r1.baseEngine
            java.lang.String r2 = r2.getAlgorithmName()
            java.lang.String r7 = "RC5-32"
            boolean r2 = r2.equals(r7)
            java.lang.String r7 = "."
            if (r2 == 0) goto L_0x0390
            int r2 = r3.getWordSize()
            r6 = 32
            if (r2 != r6) goto L_0x0372
            goto L_0x03c3
        L_0x0372:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "RC5 already set up for a word size of 32 not "
            r2.append(r4)
            int r3 = r3.getWordSize()
            r2.append(r3)
            r2.append(r7)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        L_0x0390:
            org.bouncycastle.crypto.BlockCipher r2 = r1.baseEngine
            java.lang.String r2 = r2.getAlgorithmName()
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L_0x03c3
            int r2 = r3.getWordSize()
            r6 = 64
            if (r2 != r6) goto L_0x03a5
            goto L_0x03c3
        L_0x03a5:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "RC5 already set up for a word size of 64 not "
            r2.append(r4)
            int r3 = r3.getWordSize()
            r2.append(r3)
            r2.append(r7)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        L_0x03c3:
            byte[] r2 = r3.getIV()
            if (r2 == 0) goto L_0x0457
            int r2 = r1.ivLength
            if (r2 == 0) goto L_0x0457
            boolean r2 = r5 instanceof org.bouncycastle.crypto.params.ParametersWithIV
            if (r2 == 0) goto L_0x03e2
            org.bouncycastle.crypto.params.ParametersWithIV r2 = new org.bouncycastle.crypto.params.ParametersWithIV
            org.bouncycastle.crypto.params.ParametersWithIV r5 = (org.bouncycastle.crypto.params.ParametersWithIV) r5
            org.bouncycastle.crypto.CipherParameters r5 = r5.getParameters()
            byte[] r3 = r3.getIV()
            r2.<init>(r5, r3)
            goto L_0x02f8
        L_0x03e2:
            org.bouncycastle.crypto.params.ParametersWithIV r2 = new org.bouncycastle.crypto.params.ParametersWithIV
            byte[] r3 = r3.getIV()
            r2.<init>(r5, r3)
            goto L_0x02f8
        L_0x03ed:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r2 = "RC5 parameters passed to a cipher that is not RC5."
            r0.<init>(r2)
            throw r0
        L_0x03f5:
            boolean r2 = r3 instanceof org.bouncycastle.jcajce.spec.FPEParameterSpec
            if (r2 == 0) goto L_0x0411
            r2 = r3
            org.bouncycastle.jcajce.spec.FPEParameterSpec r2 = (org.bouncycastle.jcajce.spec.FPEParameterSpec) r2
            org.bouncycastle.crypto.params.FPEParameters r3 = new org.bouncycastle.crypto.params.FPEParameters
            org.bouncycastle.crypto.params.KeyParameter r5 = (org.bouncycastle.crypto.params.KeyParameter) r5
            int r6 = r2.getRadix()
            byte[] r7 = r2.getTweak()
            boolean r2 = r2.isUsingInverseFunction()
            r3.<init>(r5, r6, r7, r2)
            r5 = r3
            goto L_0x0457
        L_0x0411:
            java.lang.Class r2 = gcmSpecClass
            if (r2 == 0) goto L_0x0448
            boolean r2 = r2.isInstance(r3)
            if (r2 == 0) goto L_0x0448
            java.lang.String r2 = r1.modeName
            boolean r2 = r1.isAEADModeName(r2)
            if (r2 != 0) goto L_0x0432
            org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher r2 = r1.cipher
            boolean r2 = r2 instanceof org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.AEADGenericBlockCipher
            if (r2 == 0) goto L_0x042a
            goto L_0x0432
        L_0x042a:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r2 = "GCMParameterSpec can only be used with AEAD modes."
            r0.<init>(r2)
            throw r0
        L_0x0432:
            boolean r2 = r5 instanceof org.bouncycastle.crypto.params.ParametersWithIV
            if (r2 == 0) goto L_0x043f
            org.bouncycastle.crypto.params.ParametersWithIV r5 = (org.bouncycastle.crypto.params.ParametersWithIV) r5
            org.bouncycastle.crypto.CipherParameters r2 = r5.getParameters()
            org.bouncycastle.crypto.params.KeyParameter r2 = (org.bouncycastle.crypto.params.KeyParameter) r2
            goto L_0x0442
        L_0x043f:
            r2 = r5
            org.bouncycastle.crypto.params.KeyParameter r2 = (org.bouncycastle.crypto.params.KeyParameter) r2
        L_0x0442:
            org.bouncycastle.crypto.params.AEADParameters r5 = org.bouncycastle.jcajce.provider.symmetric.util.GcmSpecUtil.extractAeadParameters(r2, r3)
            goto L_0x0240
        L_0x0448:
            if (r3 == 0) goto L_0x0457
            boolean r2 = r3 instanceof javax.crypto.spec.PBEParameterSpec
            if (r2 == 0) goto L_0x044f
            goto L_0x0457
        L_0x044f:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r2 = "unknown parameter type."
            r0.<init>(r2)
            throw r0
        L_0x0457:
            int r2 = r1.ivLength
            r3 = 3
            if (r2 == 0) goto L_0x049b
            boolean r2 = r5 instanceof org.bouncycastle.crypto.params.ParametersWithIV
            if (r2 != 0) goto L_0x049b
            boolean r2 = r5 instanceof org.bouncycastle.crypto.params.AEADParameters
            if (r2 != 0) goto L_0x049b
            if (r4 != 0) goto L_0x046b
            java.security.SecureRandom r2 = org.bouncycastle.crypto.CryptoServicesRegistrar.getSecureRandom()
            goto L_0x046c
        L_0x046b:
            r2 = r4
        L_0x046c:
            if (r0 == r11) goto L_0x048c
            if (r0 != r3) goto L_0x0471
            goto L_0x048c
        L_0x0471:
            org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher r2 = r1.cipher
            org.bouncycastle.crypto.BlockCipher r2 = r2.getUnderlyingCipher()
            java.lang.String r2 = r2.getAlgorithmName()
            java.lang.String r6 = "PGPCFB"
            int r2 = r2.indexOf(r6)
            if (r2 < 0) goto L_0x0484
            goto L_0x049b
        L_0x0484:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r2 = "no IV set when one expected"
            r0.<init>(r2)
            throw r0
        L_0x048c:
            int r6 = r1.ivLength
            byte[] r6 = new byte[r6]
            r2.nextBytes(r6)
            org.bouncycastle.crypto.params.ParametersWithIV r2 = new org.bouncycastle.crypto.params.ParametersWithIV
            r2.<init>(r5, r6)
            r1.ivParam = r2
            r5 = r2
        L_0x049b:
            if (r4 == 0) goto L_0x04a7
            boolean r2 = r1.padded
            if (r2 == 0) goto L_0x04a7
            org.bouncycastle.crypto.params.ParametersWithRandom r2 = new org.bouncycastle.crypto.params.ParametersWithRandom
            r2.<init>(r5, r4)
            r5 = r2
        L_0x04a7:
            if (r0 == r11) goto L_0x04d3
            if (r0 == r10) goto L_0x04cc
            if (r0 == r3) goto L_0x04d3
            if (r0 != r8) goto L_0x04b0
            goto L_0x04cc
        L_0x04b0:
            java.security.InvalidParameterException r2 = new java.security.InvalidParameterException     // Catch:{ IllegalArgumentException -> 0x0510, Exception -> 0x0505 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IllegalArgumentException -> 0x0510, Exception -> 0x0505 }
            r3.<init>()     // Catch:{ IllegalArgumentException -> 0x0510, Exception -> 0x0505 }
            java.lang.String r4 = "unknown opmode "
            r3.append(r4)     // Catch:{ IllegalArgumentException -> 0x0510, Exception -> 0x0505 }
            r3.append(r0)     // Catch:{ IllegalArgumentException -> 0x0510, Exception -> 0x0505 }
            java.lang.String r0 = " passed"
            r3.append(r0)     // Catch:{ IllegalArgumentException -> 0x0510, Exception -> 0x0505 }
            java.lang.String r0 = r3.toString()     // Catch:{ IllegalArgumentException -> 0x0510, Exception -> 0x0505 }
            r2.<init>(r0)     // Catch:{ IllegalArgumentException -> 0x0510, Exception -> 0x0505 }
            throw r2     // Catch:{ IllegalArgumentException -> 0x0510, Exception -> 0x0505 }
        L_0x04cc:
            org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher r0 = r1.cipher     // Catch:{ IllegalArgumentException -> 0x0510, Exception -> 0x0505 }
            r2 = 0
            r0.init(r2, r5)     // Catch:{ IllegalArgumentException -> 0x0510, Exception -> 0x0505 }
            goto L_0x04d8
        L_0x04d3:
            org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher r0 = r1.cipher     // Catch:{ IllegalArgumentException -> 0x0510, Exception -> 0x0505 }
            r0.init(r11, r5)     // Catch:{ IllegalArgumentException -> 0x0510, Exception -> 0x0505 }
        L_0x04d8:
            org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher r0 = r1.cipher     // Catch:{ IllegalArgumentException -> 0x0510, Exception -> 0x0505 }
            boolean r2 = r0 instanceof org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.AEADGenericBlockCipher     // Catch:{ IllegalArgumentException -> 0x0510, Exception -> 0x0505 }
            if (r2 == 0) goto L_0x0504
            org.bouncycastle.crypto.params.AEADParameters r2 = r1.aeadParams     // Catch:{ IllegalArgumentException -> 0x0510, Exception -> 0x0505 }
            if (r2 != 0) goto L_0x0504
            org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher$AEADGenericBlockCipher r0 = (org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.AEADGenericBlockCipher) r0     // Catch:{ IllegalArgumentException -> 0x0510, Exception -> 0x0505 }
            org.bouncycastle.crypto.modes.AEADCipher r0 = r0.cipher     // Catch:{ IllegalArgumentException -> 0x0510, Exception -> 0x0505 }
            org.bouncycastle.crypto.params.AEADParameters r2 = new org.bouncycastle.crypto.params.AEADParameters     // Catch:{ IllegalArgumentException -> 0x0510, Exception -> 0x0505 }
            org.bouncycastle.crypto.params.ParametersWithIV r3 = r1.ivParam     // Catch:{ IllegalArgumentException -> 0x0510, Exception -> 0x0505 }
            org.bouncycastle.crypto.CipherParameters r3 = r3.getParameters()     // Catch:{ IllegalArgumentException -> 0x0510, Exception -> 0x0505 }
            org.bouncycastle.crypto.params.KeyParameter r3 = (org.bouncycastle.crypto.params.KeyParameter) r3     // Catch:{ IllegalArgumentException -> 0x0510, Exception -> 0x0505 }
            byte[] r0 = r0.getMac()     // Catch:{ IllegalArgumentException -> 0x0510, Exception -> 0x0505 }
            int r0 = r0.length     // Catch:{ IllegalArgumentException -> 0x0510, Exception -> 0x0505 }
            int r0 = r0 * 8
            org.bouncycastle.crypto.params.ParametersWithIV r4 = r1.ivParam     // Catch:{ IllegalArgumentException -> 0x0510, Exception -> 0x0505 }
            byte[] r4 = r4.getIV()     // Catch:{ IllegalArgumentException -> 0x0510, Exception -> 0x0505 }
            r2.<init>(r3, r0, r4)     // Catch:{ IllegalArgumentException -> 0x0510, Exception -> 0x0505 }
            r1.aeadParams = r2     // Catch:{ IllegalArgumentException -> 0x0510, Exception -> 0x0505 }
        L_0x0504:
            return
        L_0x0505:
            r0 = move-exception
            org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher$InvalidKeyOrParametersException r2 = new org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher$InvalidKeyOrParametersException
            java.lang.String r3 = r0.getMessage()
            r2.<init>(r3, r0)
            throw r2
        L_0x0510:
            r0 = move-exception
            java.security.InvalidAlgorithmParameterException r2 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r3 = r0.getMessage()
            r2.<init>(r3, r0)
            throw r2
        L_0x051b:
            java.security.InvalidKeyException r0 = new java.security.InvalidKeyException
            java.lang.String r2 = "PKCS12 requires a SecretKey/PBEKey"
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.engineInit(int, java.security.Key, java.security.spec.AlgorithmParameterSpec, java.security.SecureRandom):void");
    }

    public void engineSetMode(String str) throws NoSuchAlgorithmException {
        GenericBlockCipher aEADGenericBlockCipher;
        BufferedGenericBlockCipher bufferedGenericBlockCipher;
        if (this.baseEngine != null) {
            String upperCase = Strings.toUpperCase(str);
            this.modeName = upperCase;
            if (upperCase.equals("ECB")) {
                this.ivLength = 0;
                aEADGenericBlockCipher = new BufferedGenericBlockCipher(this.baseEngine);
            } else if (this.modeName.equals("CBC")) {
                this.ivLength = this.baseEngine.getBlockSize();
                aEADGenericBlockCipher = new BufferedGenericBlockCipher((BlockCipher) new CBCBlockCipher(this.baseEngine));
            } else {
                if (this.modeName.startsWith("OFB")) {
                    this.ivLength = this.baseEngine.getBlockSize();
                    if (this.modeName.length() != 3) {
                        bufferedGenericBlockCipher = new BufferedGenericBlockCipher((BlockCipher) new OFBBlockCipher(this.baseEngine, Integer.parseInt(this.modeName.substring(3))));
                    } else {
                        BlockCipher blockCipher = this.baseEngine;
                        aEADGenericBlockCipher = new BufferedGenericBlockCipher((BlockCipher) new OFBBlockCipher(blockCipher, blockCipher.getBlockSize() * 8));
                    }
                } else if (this.modeName.startsWith("CFB")) {
                    this.ivLength = this.baseEngine.getBlockSize();
                    if (this.modeName.length() != 3) {
                        bufferedGenericBlockCipher = new BufferedGenericBlockCipher((BlockCipher) new CFBBlockCipher(this.baseEngine, Integer.parseInt(this.modeName.substring(3))));
                    } else {
                        BlockCipher blockCipher2 = this.baseEngine;
                        aEADGenericBlockCipher = new BufferedGenericBlockCipher((BlockCipher) new CFBBlockCipher(blockCipher2, blockCipher2.getBlockSize() * 8));
                    }
                } else if (this.modeName.startsWith("PGPCFB")) {
                    boolean equals = this.modeName.equals("PGPCFBWITHIV");
                    if (equals || this.modeName.length() == 6) {
                        this.ivLength = this.baseEngine.getBlockSize();
                        bufferedGenericBlockCipher = new BufferedGenericBlockCipher((BlockCipher) new PGPCFBBlockCipher(this.baseEngine, equals));
                    } else {
                        throw new NoSuchAlgorithmException("no mode support for " + this.modeName);
                    }
                } else if (this.modeName.equals("OPENPGPCFB")) {
                    this.ivLength = 0;
                    aEADGenericBlockCipher = new BufferedGenericBlockCipher((BlockCipher) new OpenPGPCFBBlockCipher(this.baseEngine));
                } else if (this.modeName.equals("FF1")) {
                    this.ivLength = 0;
                    aEADGenericBlockCipher = new BufferedFPEBlockCipher(new FPEFF1Engine(this.baseEngine));
                } else if (this.modeName.equals("FF3-1")) {
                    this.ivLength = 0;
                    aEADGenericBlockCipher = new BufferedFPEBlockCipher(new FPEFF3_1Engine(this.baseEngine));
                } else if (this.modeName.equals("SIC")) {
                    int blockSize = this.baseEngine.getBlockSize();
                    this.ivLength = blockSize;
                    if (blockSize >= 16) {
                        this.fixedIv = false;
                        aEADGenericBlockCipher = new BufferedGenericBlockCipher(new BufferedBlockCipher(new SICBlockCipher(this.baseEngine)));
                    } else {
                        throw new IllegalArgumentException("Warning: SIC-Mode can become a twotime-pad if the blocksize of the cipher is too small. Use a cipher with a block size of at least 128 bits (e.g. AES)");
                    }
                } else if (this.modeName.equals("CTR")) {
                    this.ivLength = this.baseEngine.getBlockSize();
                    this.fixedIv = false;
                    BlockCipher blockCipher3 = this.baseEngine;
                    bufferedGenericBlockCipher = blockCipher3 instanceof DSTU7624Engine ? new BufferedGenericBlockCipher(new BufferedBlockCipher(new KCTRBlockCipher(blockCipher3))) : new BufferedGenericBlockCipher(new BufferedBlockCipher(new SICBlockCipher(blockCipher3)));
                } else if (this.modeName.equals("GOFB")) {
                    this.ivLength = this.baseEngine.getBlockSize();
                    aEADGenericBlockCipher = new BufferedGenericBlockCipher(new BufferedBlockCipher(new GOFBBlockCipher(this.baseEngine)));
                } else if (this.modeName.equals("GCFB")) {
                    this.ivLength = this.baseEngine.getBlockSize();
                    aEADGenericBlockCipher = new BufferedGenericBlockCipher(new BufferedBlockCipher(new GCFBBlockCipher(this.baseEngine)));
                } else if (this.modeName.equals("CTS")) {
                    this.ivLength = this.baseEngine.getBlockSize();
                    aEADGenericBlockCipher = new BufferedGenericBlockCipher((BufferedBlockCipher) new CTSBlockCipher(new CBCBlockCipher(this.baseEngine)));
                } else if (this.modeName.equals("CCM")) {
                    this.ivLength = 12;
                    aEADGenericBlockCipher = this.baseEngine instanceof DSTU7624Engine ? new AEADGenericBlockCipher(new KCCMBlockCipher(this.baseEngine)) : new AEADGenericBlockCipher(new CCMBlockCipher(this.baseEngine));
                } else if (this.modeName.equals("OCB")) {
                    if (this.engineProvider != null) {
                        this.ivLength = 15;
                        aEADGenericBlockCipher = new AEADGenericBlockCipher(new OCBBlockCipher(this.baseEngine, this.engineProvider.get()));
                    } else {
                        throw new NoSuchAlgorithmException("can't support mode " + str);
                    }
                } else if (this.modeName.equals("EAX")) {
                    this.ivLength = this.baseEngine.getBlockSize();
                    aEADGenericBlockCipher = new AEADGenericBlockCipher(new EAXBlockCipher(this.baseEngine));
                } else if (this.modeName.equals("GCM-SIV")) {
                    this.ivLength = 12;
                    aEADGenericBlockCipher = new AEADGenericBlockCipher(new GCMSIVBlockCipher(this.baseEngine));
                } else if (this.modeName.equals(CodePackage.GCM)) {
                    BlockCipher blockCipher4 = this.baseEngine;
                    if (blockCipher4 instanceof DSTU7624Engine) {
                        this.ivLength = blockCipher4.getBlockSize();
                        aEADGenericBlockCipher = new AEADGenericBlockCipher(new KGCMBlockCipher(this.baseEngine));
                    } else {
                        this.ivLength = 12;
                        aEADGenericBlockCipher = new AEADGenericBlockCipher(new GCMBlockCipher(this.baseEngine));
                    }
                } else {
                    throw new NoSuchAlgorithmException("can't support mode " + str);
                }
                this.cipher = bufferedGenericBlockCipher;
                return;
            }
            this.cipher = aEADGenericBlockCipher;
            return;
        }
        throw new NoSuchAlgorithmException("no mode supported for this algorithm");
    }

    public void engineSetPadding(String str) throws NoSuchPaddingException {
        BufferedGenericBlockCipher bufferedGenericBlockCipher;
        if (this.baseEngine != null) {
            String upperCase = Strings.toUpperCase(str);
            if (upperCase.equals("NOPADDING")) {
                if (this.cipher.wrapOnNoPadding()) {
                    bufferedGenericBlockCipher = new BufferedGenericBlockCipher(new BufferedBlockCipher(this.cipher.getUnderlyingCipher()));
                } else {
                    return;
                }
            } else if (upperCase.equals("WITHCTS") || upperCase.equals("CTSPADDING") || upperCase.equals("CS3PADDING")) {
                bufferedGenericBlockCipher = new BufferedGenericBlockCipher((BufferedBlockCipher) new CTSBlockCipher(this.cipher.getUnderlyingCipher()));
            } else {
                this.padded = true;
                if (isAEADModeName(this.modeName)) {
                    throw new NoSuchPaddingException("Only NoPadding can be used with AEAD modes.");
                } else if (upperCase.equals("PKCS5PADDING") || upperCase.equals("PKCS7PADDING")) {
                    bufferedGenericBlockCipher = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher());
                } else if (upperCase.equals("ZEROBYTEPADDING")) {
                    bufferedGenericBlockCipher = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher(), new ZeroBytePadding());
                } else if (upperCase.equals("ISO10126PADDING") || upperCase.equals("ISO10126-2PADDING")) {
                    bufferedGenericBlockCipher = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher(), new ISO10126d2Padding());
                } else if (upperCase.equals("X9.23PADDING") || upperCase.equals("X923PADDING")) {
                    bufferedGenericBlockCipher = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher(), new X923Padding());
                } else if (upperCase.equals("ISO7816-4PADDING") || upperCase.equals("ISO9797-1PADDING")) {
                    bufferedGenericBlockCipher = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher(), new ISO7816d4Padding());
                } else if (upperCase.equals("TBCPADDING")) {
                    bufferedGenericBlockCipher = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher(), new TBCPadding());
                } else {
                    throw new NoSuchPaddingException("Padding " + str + " unknown.");
                }
            }
            this.cipher = bufferedGenericBlockCipher;
            return;
        }
        throw new NoSuchPaddingException("no padding supported for this algorithm");
    }

    public int engineUpdate(byte[] bArr, int i11, int i12, byte[] bArr2, int i13) throws ShortBufferException {
        if (this.cipher.getUpdateOutputSize(i12) + i13 <= bArr2.length) {
            try {
                return this.cipher.processBytes(bArr, i11, i12, bArr2, i13);
            } catch (DataLengthException e11) {
                throw new IllegalStateException(e11.toString());
            }
        } else {
            throw new ShortBufferException("output buffer too short for input.");
        }
    }

    public byte[] engineUpdate(byte[] bArr, int i11, int i12) {
        int updateOutputSize = this.cipher.getUpdateOutputSize(i12);
        if (updateOutputSize > 0) {
            byte[] bArr2 = new byte[updateOutputSize];
            int processBytes = this.cipher.processBytes(bArr, i11, i12, bArr2, 0);
            if (processBytes == 0) {
                return null;
            }
            if (processBytes == updateOutputSize) {
                return bArr2;
            }
            byte[] bArr3 = new byte[processBytes];
            System.arraycopy(bArr2, 0, bArr3, 0, processBytes);
            return bArr3;
        }
        this.cipher.processBytes(bArr, i11, i12, (byte[]) null, 0);
        return null;
    }

    public void engineUpdateAAD(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        if (remaining >= 1) {
            if (byteBuffer.hasArray()) {
                engineUpdateAAD(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), remaining);
                byteBuffer.position(byteBuffer.limit());
            } else if (remaining <= 512) {
                byte[] bArr = new byte[remaining];
                byteBuffer.get(bArr);
                engineUpdateAAD(bArr, 0, remaining);
                Arrays.fill(bArr, (byte) 0);
            } else {
                byte[] bArr2 = new byte[512];
                do {
                    int min = Math.min(512, remaining);
                    byteBuffer.get(bArr2, 0, min);
                    engineUpdateAAD(bArr2, 0, min);
                    remaining -= min;
                } while (remaining > 0);
                Arrays.fill(bArr2, (byte) 0);
            }
        }
    }

    public void engineUpdateAAD(byte[] bArr, int i11, int i12) {
        this.cipher.updateAAD(bArr, i11, i12);
    }
}
