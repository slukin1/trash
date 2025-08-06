package org.bouncycastle.crypto.params;

public class ElGamalKeyParameters extends AsymmetricKeyParameter {
    private ElGamalParameters params;

    public ElGamalKeyParameters(boolean z11, ElGamalParameters elGamalParameters) {
        super(z11);
        this.params = elGamalParameters;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ElGamalKeyParameters)) {
            return false;
        }
        ElGamalParameters elGamalParameters = this.params;
        ElGamalParameters parameters = ((ElGamalKeyParameters) obj).getParameters();
        return elGamalParameters == null ? parameters == null : elGamalParameters.equals(parameters);
    }

    public ElGamalParameters getParameters() {
        return this.params;
    }

    public int hashCode() {
        ElGamalParameters elGamalParameters = this.params;
        if (elGamalParameters != null) {
            return elGamalParameters.hashCode();
        }
        return 0;
    }
}
