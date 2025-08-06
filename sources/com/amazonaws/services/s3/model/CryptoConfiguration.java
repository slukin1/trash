package com.amazonaws.services.s3.model;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.internal.crypto.CryptoRuntime;
import java.io.Serializable;
import java.security.Provider;

@Deprecated
public class CryptoConfiguration implements Cloneable, Serializable {
    private static final long serialVersionUID = -8646831898339939580L;
    private transient Region awskmsRegion;
    private CryptoMode cryptoMode;
    private Provider cryptoProvider;
    private boolean ignoreMissingInstructionFile;
    private CryptoStorageMode storageMode;

    public static final class ReadOnly extends CryptoConfiguration {
        public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
            return CryptoConfiguration.super.clone();
        }

        public boolean isReadOnly() {
            return true;
        }

        public void setCryptoMode(CryptoMode cryptoMode) {
            throw new UnsupportedOperationException();
        }

        public void setCryptoProvider(Provider provider) {
            throw new UnsupportedOperationException();
        }

        public void setIgnoreMissingInstructionFile(boolean z11) {
            throw new UnsupportedOperationException();
        }

        public void setKmsRegion(Regions regions) {
            throw new UnsupportedOperationException();
        }

        public void setStorageMode(CryptoStorageMode cryptoStorageMode) {
            throw new UnsupportedOperationException();
        }

        public CryptoConfiguration withCryptoMode(CryptoMode cryptoMode) {
            throw new UnsupportedOperationException();
        }

        public CryptoConfiguration withCryptoProvider(Provider provider) {
            throw new UnsupportedOperationException();
        }

        public CryptoConfiguration withIgnoreMissingInstructionFile(boolean z11) {
            throw new UnsupportedOperationException();
        }

        public CryptoConfiguration withKmsRegion(Regions regions) {
            throw new UnsupportedOperationException();
        }

        public CryptoConfiguration withStorageMode(CryptoStorageMode cryptoStorageMode) {
            throw new UnsupportedOperationException();
        }

        private ReadOnly() {
        }
    }

    public CryptoConfiguration() {
        this(CryptoMode.EncryptionOnly);
    }

    private void check(CryptoMode cryptoMode2) {
        if (cryptoMode2 == CryptoMode.AuthenticatedEncryption || cryptoMode2 == CryptoMode.StrictAuthenticatedEncryption) {
            if (this.cryptoProvider == null && !CryptoRuntime.c()) {
                CryptoRuntime.a();
                if (!CryptoRuntime.c()) {
                    throw new UnsupportedOperationException("The Bouncy castle library jar is required on the classpath to enable authenticated encryption");
                }
            }
            if (!CryptoRuntime.b(this.cryptoProvider)) {
                throw new UnsupportedOperationException("More recent version of the Bouncy castle library is required to enable authenticated encryption");
            }
        }
    }

    private CryptoConfiguration copyTo(CryptoConfiguration cryptoConfiguration) {
        cryptoConfiguration.cryptoMode = this.cryptoMode;
        cryptoConfiguration.storageMode = this.storageMode;
        cryptoConfiguration.cryptoProvider = this.cryptoProvider;
        cryptoConfiguration.ignoreMissingInstructionFile = this.ignoreMissingInstructionFile;
        cryptoConfiguration.awskmsRegion = this.awskmsRegion;
        return cryptoConfiguration;
    }

    public Region getAwsKmsRegion() {
        return this.awskmsRegion;
    }

    public CryptoMode getCryptoMode() {
        return this.cryptoMode;
    }

    public Provider getCryptoProvider() {
        return this.cryptoProvider;
    }

    @Deprecated
    public Regions getKmsRegion() {
        Region region = this.awskmsRegion;
        if (region == null) {
            return null;
        }
        return Regions.fromName(region.d());
    }

    public CryptoStorageMode getStorageMode() {
        return this.storageMode;
    }

    public boolean isIgnoreMissingInstructionFile() {
        return this.ignoreMissingInstructionFile;
    }

    public boolean isReadOnly() {
        return false;
    }

    public CryptoConfiguration readOnly() {
        if (isReadOnly()) {
            return this;
        }
        return copyTo(new ReadOnly());
    }

    public void setAwsKmsRegion(Region region) {
        this.awskmsRegion = region;
    }

    public void setCryptoMode(CryptoMode cryptoMode2) throws UnsupportedOperationException {
        this.cryptoMode = cryptoMode2;
    }

    public void setCryptoProvider(Provider provider) {
        this.cryptoProvider = provider;
        check(this.cryptoMode);
    }

    public void setIgnoreMissingInstructionFile(boolean z11) {
        this.ignoreMissingInstructionFile = z11;
    }

    @Deprecated
    public void setKmsRegion(Regions regions) {
        if (regions != null) {
            setAwsKmsRegion(Region.e(regions));
        } else {
            setAwsKmsRegion((Region) null);
        }
    }

    public void setStorageMode(CryptoStorageMode cryptoStorageMode) {
        this.storageMode = cryptoStorageMode;
    }

    public CryptoConfiguration withAwsKmsRegion(Region region) {
        this.awskmsRegion = region;
        return this;
    }

    public CryptoConfiguration withCryptoMode(CryptoMode cryptoMode2) {
        this.cryptoMode = cryptoMode2;
        return this;
    }

    public CryptoConfiguration withCryptoProvider(Provider provider) {
        this.cryptoProvider = provider;
        check(this.cryptoMode);
        return this;
    }

    public CryptoConfiguration withIgnoreMissingInstructionFile(boolean z11) {
        this.ignoreMissingInstructionFile = z11;
        return this;
    }

    @Deprecated
    public CryptoConfiguration withKmsRegion(Regions regions) {
        setKmsRegion(regions);
        return this;
    }

    public CryptoConfiguration withStorageMode(CryptoStorageMode cryptoStorageMode) {
        this.storageMode = cryptoStorageMode;
        return this;
    }

    public CryptoConfiguration(CryptoMode cryptoMode2) {
        this.ignoreMissingInstructionFile = true;
        this.storageMode = CryptoStorageMode.ObjectMetadata;
        this.cryptoProvider = null;
        this.cryptoMode = cryptoMode2;
    }

    public CryptoConfiguration clone() {
        return copyTo(new CryptoConfiguration());
    }
}
