package org.apache.commons.cli;

import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.ListIterator;
import java.util.Properties;
import s10.a;
import s10.c;

public abstract class Parser implements a {

    /* renamed from: a  reason: collision with root package name */
    public CommandLine f58889a;

    /* renamed from: b  reason: collision with root package name */
    public Options f58890b;

    /* renamed from: c  reason: collision with root package name */
    public List f58891c;

    public CommandLine a(Options options, String[] strArr, boolean z11) throws ParseException {
        return f(options, strArr, (Properties) null, z11);
    }

    public void b() throws MissingOptionException {
        if (!e().isEmpty()) {
            throw new MissingOptionException(e());
        }
    }

    public abstract String[] c(Options options, String[] strArr, boolean z11);

    public Options d() {
        return this.f58890b;
    }

    public List e() {
        return this.f58891c;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0080, code lost:
        if (r9 != false) goto L_0x004c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0085 A[LOOP:2: B:27:0x0085->B:39:0x0085, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0037 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.apache.commons.cli.CommandLine f(org.apache.commons.cli.Options r6, java.lang.String[] r7, java.util.Properties r8, boolean r9) throws org.apache.commons.cli.ParseException {
        /*
            r5 = this;
            java.util.List r0 = r6.helpOptions()
            java.util.Iterator r0 = r0.iterator()
        L_0x0008:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0018
            java.lang.Object r1 = r0.next()
            org.apache.commons.cli.Option r1 = (org.apache.commons.cli.Option) r1
            r1.clearValues()
            goto L_0x0008
        L_0x0018:
            r5.j(r6)
            org.apache.commons.cli.CommandLine r6 = new org.apache.commons.cli.CommandLine
            r6.<init>()
            r5.f58889a = r6
            r6 = 0
            if (r7 != 0) goto L_0x0027
            java.lang.String[] r7 = new java.lang.String[r6]
        L_0x0027:
            org.apache.commons.cli.Options r0 = r5.d()
            java.lang.String[] r7 = r5.c(r0, r7, r9)
            java.util.List r7 = java.util.Arrays.asList(r7)
            java.util.ListIterator r7 = r7.listIterator()
        L_0x0037:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L_0x009d
            java.lang.Object r0 = r7.next()
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = "--"
            boolean r2 = r1.equals(r0)
            r3 = 1
            if (r2 == 0) goto L_0x004e
        L_0x004c:
            r6 = r3
            goto L_0x0083
        L_0x004e:
            java.lang.String r2 = "-"
            boolean r4 = r2.equals(r0)
            if (r4 == 0) goto L_0x005f
            if (r9 == 0) goto L_0x0059
            goto L_0x004c
        L_0x0059:
            org.apache.commons.cli.CommandLine r2 = r5.f58889a
            r2.addArg(r0)
            goto L_0x0083
        L_0x005f:
            boolean r2 = r0.startsWith(r2)
            if (r2 == 0) goto L_0x007b
            if (r9 == 0) goto L_0x0077
            org.apache.commons.cli.Options r2 = r5.d()
            boolean r2 = r2.hasOption(r0)
            if (r2 != 0) goto L_0x0077
            org.apache.commons.cli.CommandLine r6 = r5.f58889a
            r6.addArg(r0)
            goto L_0x004c
        L_0x0077:
            r5.h(r0, r7)
            goto L_0x0083
        L_0x007b:
            org.apache.commons.cli.CommandLine r2 = r5.f58889a
            r2.addArg(r0)
            if (r9 == 0) goto L_0x0083
            goto L_0x004c
        L_0x0083:
            if (r6 == 0) goto L_0x0037
        L_0x0085:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L_0x0037
            java.lang.Object r0 = r7.next()
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = r1.equals(r0)
            if (r2 != 0) goto L_0x0085
            org.apache.commons.cli.CommandLine r2 = r5.f58889a
            r2.addArg(r0)
            goto L_0x0085
        L_0x009d:
            r5.i(r8)
            r5.b()
            org.apache.commons.cli.CommandLine r6 = r5.f58889a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.cli.Parser.f(org.apache.commons.cli.Options, java.lang.String[], java.util.Properties, boolean):org.apache.commons.cli.CommandLine");
    }

    public void g(Option option, ListIterator listIterator) throws ParseException {
        while (true) {
            if (!listIterator.hasNext()) {
                break;
            }
            String str = (String) listIterator.next();
            if (d().hasOption(str) && str.startsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                listIterator.previous();
                break;
            } else {
                try {
                    option.addValueForProcessing(c.a(str));
                } catch (RuntimeException unused) {
                    listIterator.previous();
                }
            }
        }
        if (option.getValues() == null && !option.hasOptionalArg()) {
            throw new MissingArgumentException(option);
        }
    }

    public void h(String str, ListIterator listIterator) throws ParseException {
        if (d().hasOption(str)) {
            Option option = (Option) d().getOption(str).clone();
            if (option.isRequired()) {
                e().remove(option.getKey());
            }
            if (d().getOptionGroup(option) != null) {
                OptionGroup optionGroup = d().getOptionGroup(option);
                if (optionGroup.isRequired()) {
                    e().remove(optionGroup);
                }
                optionGroup.setSelected(option);
            }
            if (option.hasArg()) {
                g(option, listIterator);
            }
            this.f58889a.addOption(option);
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Unrecognized option: ");
        stringBuffer.append(str);
        throw new UnrecognizedOptionException(stringBuffer.toString(), str);
    }

    public void i(Properties properties) {
        if (properties != null) {
            Enumeration<?> propertyNames = properties.propertyNames();
            while (propertyNames.hasMoreElements()) {
                String obj = propertyNames.nextElement().toString();
                if (!this.f58889a.hasOption(obj)) {
                    Option option = d().getOption(obj);
                    String property = properties.getProperty(obj);
                    if (option.hasArg()) {
                        if (option.getValues() == null || option.getValues().length == 0) {
                            try {
                                option.addValueForProcessing(property);
                            } catch (RuntimeException unused) {
                            }
                        }
                    } else if (!"yes".equalsIgnoreCase(property) && !"true".equalsIgnoreCase(property) && !"1".equalsIgnoreCase(property)) {
                        return;
                    }
                    this.f58889a.addOption(option);
                }
            }
        }
    }

    public void j(Options options) {
        this.f58890b = options;
        this.f58891c = new ArrayList(options.getRequiredOptions());
    }
}
