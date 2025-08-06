package org.jmrtd.cert;

import com.facebook.internal.AnalyticsEvents;
import java.io.Serializable;
import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.scuba.data.Country;

public class CVCPrincipal implements Principal, Serializable {
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd");
    private static final long serialVersionUID = -4905647207367309688L;
    private Country country;
    private String mnemonic;
    private String seqNumber;

    public CVCPrincipal(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Name should be <Country (2F)><Mnemonic (9V)><SeqNum (5F)> formatted, found null");
        } else if (str.length() < 7 || str.length() > 16) {
            throw new IllegalArgumentException("Name should be <Country (2F)><Mnemonic (9V)><SeqNum (5F)> formatted, found \"" + str + "\"");
        } else {
            final String upperCase = str.substring(0, 2).toUpperCase();
            try {
                this.country = Country.getInstance(upperCase);
            } catch (IllegalArgumentException e11) {
                Logger logger = LOGGER;
                Level level = Level.FINE;
                logger.log(level, "Could not find country for " + upperCase, e11);
                this.country = new Country() {
                    private static final long serialVersionUID = 345841304964161797L;

                    public String getName() {
                        return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                    }

                    public String getNationality() {
                        return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                    }

                    public String toAlpha2Code() {
                        return upperCase;
                    }

                    public String toAlpha3Code() {
                        return "XXX";
                    }

                    public int valueOf() {
                        return -1;
                    }
                };
            }
            this.mnemonic = str.substring(2, str.length() - 5);
            this.seqNumber = str.substring(str.length() - 5, str.length());
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!obj.getClass().equals(getClass())) {
            return false;
        }
        CVCPrincipal cVCPrincipal = (CVCPrincipal) obj;
        if (!cVCPrincipal.country.equals(this.country) || !cVCPrincipal.mnemonic.equals(this.mnemonic) || !cVCPrincipal.seqNumber.equals(this.seqNumber)) {
            return false;
        }
        return true;
    }

    public Country getCountry() {
        return this.country;
    }

    public String getMnemonic() {
        return this.mnemonic;
    }

    public String getName() {
        return this.country.toAlpha2Code() + this.mnemonic + this.seqNumber;
    }

    public String getSeqNumber() {
        return this.seqNumber;
    }

    public int hashCode() {
        return (getName().hashCode() * 2) + 1231211;
    }

    public String toString() {
        return this.country.toAlpha2Code() + "/" + this.mnemonic + "/" + this.seqNumber;
    }

    public CVCPrincipal(Country country2, String str, String str2) {
        if (str == null || str.length() > 9) {
            throw new IllegalArgumentException("Wrong length mnemonic");
        } else if (str2 == null || str2.length() != 5) {
            throw new IllegalArgumentException("Wrong length seqNumber");
        } else {
            this.country = country2;
            this.mnemonic = str;
            this.seqNumber = str2;
        }
    }
}
