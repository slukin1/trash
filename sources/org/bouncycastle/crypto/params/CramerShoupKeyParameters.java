package org.bouncycastle.crypto.params;

public class CramerShoupKeyParameters extends AsymmetricKeyParameter {
    private CramerShoupParameters params;

    public CramerShoupKeyParameters(boolean z11, CramerShoupParameters cramerShoupParameters) {
        super(z11);
        this.params = cramerShoupParameters;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CramerShoupKeyParameters)) {
            return false;
        }
        CramerShoupParameters cramerShoupParameters = this.params;
        CramerShoupParameters parameters = ((CramerShoupKeyParameters) obj).getParameters();
        return cramerShoupParameters == null ? parameters == null : cramerShoupParameters.equals(parameters);
    }

    public CramerShoupParameters getParameters() {
        return this.params;
    }

    public int hashCode() {
        boolean z11 = !isPrivate();
        CramerShoupParameters cramerShoupParameters = this.params;
        return cramerShoupParameters != null ? z11 ^ cramerShoupParameters.hashCode() ? 1 : 0 : z11 ? 1 : 0;
    }
}
