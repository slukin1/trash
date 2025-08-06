package com.amazonaws.services.cognitoidentity.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RulesConfigurationType implements Serializable {
    private List<MappingRule> rules;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof RulesConfigurationType)) {
            return false;
        }
        RulesConfigurationType rulesConfigurationType = (RulesConfigurationType) obj;
        if ((rulesConfigurationType.getRules() == null) ^ (getRules() == null)) {
            return false;
        }
        return rulesConfigurationType.getRules() == null || rulesConfigurationType.getRules().equals(getRules());
    }

    public List<MappingRule> getRules() {
        return this.rules;
    }

    public int hashCode() {
        return 31 + (getRules() == null ? 0 : getRules().hashCode());
    }

    public void setRules(Collection<MappingRule> collection) {
        if (collection == null) {
            this.rules = null;
        } else {
            this.rules = new ArrayList(collection);
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getRules() != null) {
            sb2.append("Rules: " + getRules());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public RulesConfigurationType withRules(MappingRule... mappingRuleArr) {
        if (getRules() == null) {
            this.rules = new ArrayList(mappingRuleArr.length);
        }
        for (MappingRule add : mappingRuleArr) {
            this.rules.add(add);
        }
        return this;
    }

    public RulesConfigurationType withRules(Collection<MappingRule> collection) {
        setRules(collection);
        return this;
    }
}
