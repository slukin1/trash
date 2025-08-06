package org.apache.commons.cli;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import s10.c;

public class Options implements Serializable {
    private static final long serialVersionUID = 1;
    private Map longOpts = new HashMap();
    private Map optionGroups = new HashMap();
    private List requiredOpts = new ArrayList();
    private Map shortOpts = new HashMap();

    public Options addOption(String str, boolean z11, String str2) {
        addOption(str, (String) null, z11, str2);
        return this;
    }

    public Options addOptionGroup(OptionGroup optionGroup) {
        if (optionGroup.isRequired()) {
            this.requiredOpts.add(optionGroup);
        }
        for (Option option : optionGroup.getOptions()) {
            option.setRequired(false);
            addOption(option);
            this.optionGroups.put(option.getKey(), optionGroup);
        }
        return this;
    }

    public Option getOption(String str) {
        String b11 = c.b(str);
        if (this.shortOpts.containsKey(b11)) {
            return (Option) this.shortOpts.get(b11);
        }
        return (Option) this.longOpts.get(b11);
    }

    public OptionGroup getOptionGroup(Option option) {
        return (OptionGroup) this.optionGroups.get(option.getKey());
    }

    public Collection getOptionGroups() {
        return new HashSet(this.optionGroups.values());
    }

    public Collection getOptions() {
        return Collections.unmodifiableCollection(helpOptions());
    }

    public List getRequiredOptions() {
        return this.requiredOpts;
    }

    public boolean hasOption(String str) {
        String b11 = c.b(str);
        return this.shortOpts.containsKey(b11) || this.longOpts.containsKey(b11);
    }

    public List helpOptions() {
        return new ArrayList(this.shortOpts.values());
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[ Options: [ short ");
        stringBuffer.append(this.shortOpts.toString());
        stringBuffer.append(" ] [ long ");
        stringBuffer.append(this.longOpts);
        stringBuffer.append(" ]");
        return stringBuffer.toString();
    }

    public Options addOption(String str, String str2, boolean z11, String str3) {
        addOption(new Option(str, str2, z11, str3));
        return this;
    }

    public Options addOption(Option option) {
        String key = option.getKey();
        if (option.hasLongOpt()) {
            this.longOpts.put(option.getLongOpt(), option);
        }
        if (option.isRequired()) {
            if (this.requiredOpts.contains(key)) {
                List list = this.requiredOpts;
                list.remove(list.indexOf(key));
            }
            this.requiredOpts.add(key);
        }
        this.shortOpts.put(key, option);
        return this;
    }
}
