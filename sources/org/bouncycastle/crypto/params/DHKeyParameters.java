package org.bouncycastle.crypto.params;

public class DHKeyParameters extends AsymmetricKeyParameter {
    private DHParameters params;

    public DHKeyParameters(boolean z11, DHParameters dHParameters) {
        super(z11);
        this.params = dHParameters;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DHKeyParameters)) {
            return false;
        }
        DHParameters dHParameters = this.params;
        DHParameters parameters = ((DHKeyParameters) obj).getParameters();
        return dHParameters == null ? parameters == null : dHParameters.equals(parameters);
    }

    public DHParameters getParameters() {
        return this.params;
    }

    public int hashCode() {
        boolean z11 = !isPrivate();
        DHParameters dHParameters = this.params;
        return dHParameters != null ? z11 ^ dHParameters.hashCode() ? 1 : 0 : z11 ? 1 : 0;
    }
}
