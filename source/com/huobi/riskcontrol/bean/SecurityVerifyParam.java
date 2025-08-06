package com.huobi.riskcontrol.bean;

import android.content.Context;
import java.io.Serializable;
import pro.huobi.R;

public class SecurityVerifyParam implements Serializable {
    private String hint;
    private boolean isResetPassword;
    private RiskOperate riskOperate;
    private Scene scene;
    private String tsvToken;
    private VerifyType verifyType;

    public enum RiskOperate {
        UPDATE,
        DISABLE,
        GENERATE,
        REGENERATE,
        BIND,
        REBIND
    }

    public enum Scene {
        USER_PASSWORD,
        GA,
        RISK_EMAIL,
        RISK_PHONE
    }

    public enum VerifyType {
        EMAIL,
        MOBILE,
        ADVANCED,
        FACE
    }

    public SecurityVerifyParam(VerifyType verifyType2, Scene scene2, RiskOperate riskOperate2, String str) {
        this.tsvToken = str;
        this.verifyType = verifyType2;
        this.scene = scene2;
        this.riskOperate = riskOperate2;
    }

    public void buildHint(Context context) {
        if (this.isResetPassword) {
            this.hint = context.getString(R.string.n_risk_reset_password_subtitle);
            return;
        }
        Scene scene2 = this.scene;
        Scene scene3 = Scene.RISK_EMAIL;
        if (scene2 == scene3 && this.riskOperate == RiskOperate.DISABLE) {
            this.hint = context.getString(R.string.n_risk_close_email_subtitle);
            return;
        }
        Scene scene4 = Scene.RISK_PHONE;
        if (scene2 == scene4 && this.riskOperate == RiskOperate.DISABLE) {
            this.hint = context.getString(R.string.n_risk_close_phone_subtitle);
            return;
        }
        Scene scene5 = Scene.GA;
        if (scene2 == scene5 && this.riskOperate == RiskOperate.DISABLE) {
            this.hint = context.getString(R.string.n_risk_close_ga_subtitle);
        } else if (scene2 == scene4 && this.riskOperate == RiskOperate.BIND) {
            this.hint = context.getString(R.string.n_risk_bind_phone_subtitle);
        } else if (scene2 == scene3 && this.riskOperate == RiskOperate.BIND) {
            this.hint = context.getString(R.string.n_risk_bind_email_subtitle);
        } else if (scene2 == scene5 && this.riskOperate == RiskOperate.GENERATE) {
            this.hint = context.getString(R.string.n_risk_bind_ga_subtitle);
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof SecurityVerifyParam;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecurityVerifyParam)) {
            return false;
        }
        SecurityVerifyParam securityVerifyParam = (SecurityVerifyParam) obj;
        if (!securityVerifyParam.canEqual(this)) {
            return false;
        }
        String hint2 = getHint();
        String hint3 = securityVerifyParam.getHint();
        if (hint2 != null ? !hint2.equals(hint3) : hint3 != null) {
            return false;
        }
        String tsvToken2 = getTsvToken();
        String tsvToken3 = securityVerifyParam.getTsvToken();
        if (tsvToken2 != null ? !tsvToken2.equals(tsvToken3) : tsvToken3 != null) {
            return false;
        }
        VerifyType verifyType2 = getVerifyType();
        VerifyType verifyType3 = securityVerifyParam.getVerifyType();
        if (verifyType2 != null ? !verifyType2.equals(verifyType3) : verifyType3 != null) {
            return false;
        }
        Scene scene2 = getScene();
        Scene scene3 = securityVerifyParam.getScene();
        if (scene2 != null ? !scene2.equals(scene3) : scene3 != null) {
            return false;
        }
        RiskOperate riskOperate2 = getRiskOperate();
        RiskOperate riskOperate3 = securityVerifyParam.getRiskOperate();
        if (riskOperate2 != null ? riskOperate2.equals(riskOperate3) : riskOperate3 == null) {
            return isResetPassword() == securityVerifyParam.isResetPassword();
        }
        return false;
    }

    public String getHint() {
        return this.hint;
    }

    public RiskOperate getRiskOperate() {
        return this.riskOperate;
    }

    public Scene getScene() {
        return this.scene;
    }

    public String getTsvToken() {
        return this.tsvToken;
    }

    public VerifyType getVerifyType() {
        return this.verifyType;
    }

    public int hashCode() {
        String hint2 = getHint();
        int i11 = 43;
        int hashCode = hint2 == null ? 43 : hint2.hashCode();
        String tsvToken2 = getTsvToken();
        int hashCode2 = ((hashCode + 59) * 59) + (tsvToken2 == null ? 43 : tsvToken2.hashCode());
        VerifyType verifyType2 = getVerifyType();
        int hashCode3 = (hashCode2 * 59) + (verifyType2 == null ? 43 : verifyType2.hashCode());
        Scene scene2 = getScene();
        int hashCode4 = (hashCode3 * 59) + (scene2 == null ? 43 : scene2.hashCode());
        RiskOperate riskOperate2 = getRiskOperate();
        int i12 = hashCode4 * 59;
        if (riskOperate2 != null) {
            i11 = riskOperate2.hashCode();
        }
        return ((i12 + i11) * 59) + (isResetPassword() ? 79 : 97);
    }

    public boolean isResetPassword() {
        return this.isResetPassword;
    }

    public void setHint(String str) {
        this.hint = str;
    }

    public void setResetPassword(boolean z11) {
        this.isResetPassword = z11;
    }

    public void setRiskOperate(RiskOperate riskOperate2) {
        this.riskOperate = riskOperate2;
    }

    public void setScene(Scene scene2) {
        this.scene = scene2;
    }

    public void setTsvToken(String str) {
        this.tsvToken = str;
    }

    public void setVerifyType(VerifyType verifyType2) {
        this.verifyType = verifyType2;
    }

    public String toString() {
        return "SecurityVerifyParam(hint=" + getHint() + ", tsvToken=" + getTsvToken() + ", verifyType=" + getVerifyType() + ", scene=" + getScene() + ", riskOperate=" + getRiskOperate() + ", isResetPassword=" + isResetPassword() + ")";
    }
}
