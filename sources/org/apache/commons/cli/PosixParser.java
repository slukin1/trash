package org.apache.commons.cli;

import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PosixParser extends Parser {

    /* renamed from: d  reason: collision with root package name */
    public List f58910d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public boolean f58911e;

    /* renamed from: f  reason: collision with root package name */
    public Option f58912f;

    /* renamed from: g  reason: collision with root package name */
    public Options f58913g;

    public String[] c(Options options, String[] strArr, boolean z11) {
        String str;
        m();
        this.f58913g = options;
        Iterator it2 = Arrays.asList(strArr).iterator();
        while (it2.hasNext()) {
            String str2 = (String) it2.next();
            if (str2.startsWith("--")) {
                int indexOf = str2.indexOf(61);
                if (indexOf == -1) {
                    str = str2;
                } else {
                    str = str2.substring(0, indexOf);
                }
                if (!options.hasOption(str)) {
                    n(str2, z11);
                } else {
                    this.f58912f = options.getOption(str);
                    this.f58910d.add(str);
                    if (indexOf != -1) {
                        this.f58910d.add(str2.substring(indexOf + 1));
                    }
                }
            } else if (Constants.ACCEPT_TIME_SEPARATOR_SERVER.equals(str2)) {
                this.f58910d.add(str2);
            } else if (!str2.startsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                n(str2, z11);
            } else if (str2.length() == 2 || options.hasOption(str2)) {
                o(str2, z11);
            } else {
                k(str2, z11);
            }
            l(it2);
        }
        List list = this.f58910d;
        return (String[]) list.toArray(new String[list.size()]);
    }

    public void k(String str, boolean z11) {
        int i11;
        int i12 = 1;
        while (i12 < str.length()) {
            String valueOf = String.valueOf(str.charAt(i12));
            if (this.f58913g.hasOption(valueOf)) {
                List list = this.f58910d;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                stringBuffer.append(valueOf);
                list.add(stringBuffer.toString());
                Option option = this.f58913g.getOption(valueOf);
                this.f58912f = option;
                if (!option.hasArg() || str.length() == (i11 = i12 + 1)) {
                    i12++;
                } else {
                    this.f58910d.add(str.substring(i11));
                    return;
                }
            } else if (z11) {
                n(str.substring(i12), true);
                return;
            } else {
                this.f58910d.add(str);
                return;
            }
        }
    }

    public final void l(Iterator it2) {
        if (this.f58911e) {
            while (it2.hasNext()) {
                this.f58910d.add(it2.next());
            }
        }
    }

    public final void m() {
        this.f58911e = false;
        this.f58910d.clear();
    }

    public final void n(String str, boolean z11) {
        Option option;
        if (z11 && ((option = this.f58912f) == null || !option.hasArg())) {
            this.f58911e = true;
            this.f58910d.add("--");
        }
        this.f58910d.add(str);
    }

    public final void o(String str, boolean z11) {
        if (z11 && !this.f58913g.hasOption(str)) {
            this.f58911e = true;
        }
        if (this.f58913g.hasOption(str)) {
            this.f58912f = this.f58913g.getOption(str);
        }
        this.f58910d.add(str);
    }
}
