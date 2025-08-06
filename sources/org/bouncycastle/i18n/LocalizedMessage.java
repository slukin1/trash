package org.bouncycastle.i18n;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.iproov.sdk.bridge.OptionsBridge;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.Format;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.TimeZone;
import org.bouncycastle.i18n.filter.Filter;
import org.bouncycastle.i18n.filter.TrustedInput;
import org.bouncycastle.i18n.filter.UntrustedInput;
import org.bouncycastle.i18n.filter.UntrustedUrlInput;

public class LocalizedMessage {
    public static final String DEFAULT_ENCODING = "ISO-8859-1";
    public FilteredArguments arguments;
    public String encoding = "ISO-8859-1";
    public FilteredArguments extraArgs = null;
    public Filter filter = null;

    /* renamed from: id  reason: collision with root package name */
    public final String f59314id;
    public ClassLoader loader = null;
    public final String resource;

    public class FilteredArguments {
        public static final int FILTER = 1;
        public static final int FILTER_URL = 2;
        public static final int NO_FILTER = 0;
        public int[] argFilterType;
        public Object[] arguments;
        public Filter filter;
        public Object[] filteredArgs;
        public boolean[] isLocaleSpecific;
        public Object[] unpackedArgs;

        public FilteredArguments(LocalizedMessage localizedMessage) {
            this(new Object[0]);
        }

        public FilteredArguments(Object[] objArr) {
            this.filter = null;
            this.arguments = objArr;
            this.unpackedArgs = new Object[objArr.length];
            this.filteredArgs = new Object[objArr.length];
            this.isLocaleSpecific = new boolean[objArr.length];
            this.argFilterType = new int[objArr.length];
            for (int i11 = 0; i11 < objArr.length; i11++) {
                if (objArr[i11] instanceof TrustedInput) {
                    this.unpackedArgs[i11] = objArr[i11].getInput();
                    this.argFilterType[i11] = 0;
                } else if (objArr[i11] instanceof UntrustedInput) {
                    this.unpackedArgs[i11] = objArr[i11].getInput();
                    if (objArr[i11] instanceof UntrustedUrlInput) {
                        this.argFilterType[i11] = 2;
                    } else {
                        this.argFilterType[i11] = 1;
                    }
                } else {
                    this.unpackedArgs[i11] = objArr[i11];
                    this.argFilterType[i11] = 1;
                }
                this.isLocaleSpecific[i11] = this.unpackedArgs[i11] instanceof LocaleString;
            }
        }

        private Object filter(int i11, Object obj) {
            Filter filter2 = this.filter;
            if (filter2 != null) {
                if (obj == null) {
                    obj = OptionsBridge.NULL_VALUE;
                }
                if (i11 != 0) {
                    if (i11 == 1) {
                        return filter2.doFilter(obj.toString());
                    }
                    if (i11 != 2) {
                        return null;
                    }
                    return filter2.doFilterUrl(obj.toString());
                }
            }
            return obj;
        }

        public Object[] getArguments() {
            return this.arguments;
        }

        public Filter getFilter() {
            return this.filter;
        }

        public Object[] getFilteredArgs(Locale locale) {
            Object obj;
            Object[] objArr = new Object[this.unpackedArgs.length];
            int i11 = 0;
            while (true) {
                Object[] objArr2 = this.unpackedArgs;
                if (i11 >= objArr2.length) {
                    return objArr;
                }
                Object[] objArr3 = this.filteredArgs;
                if (objArr3[i11] != null) {
                    obj = objArr3[i11];
                } else {
                    Object obj2 = objArr2[i11];
                    if (this.isLocaleSpecific[i11]) {
                        obj = filter(this.argFilterType[i11], ((LocaleString) obj2).getLocaleString(locale));
                    } else {
                        obj = filter(this.argFilterType[i11], obj2);
                        this.filteredArgs[i11] = obj;
                    }
                }
                objArr[i11] = obj;
                i11++;
            }
        }

        public boolean isEmpty() {
            return this.unpackedArgs.length == 0;
        }

        public void setFilter(Filter filter2) {
            if (filter2 != this.filter) {
                for (int i11 = 0; i11 < this.unpackedArgs.length; i11++) {
                    this.filteredArgs[i11] = null;
                }
            }
            this.filter = filter2;
        }
    }

    public LocalizedMessage(String str, String str2) throws NullPointerException {
        if (str == null || str2 == null) {
            throw null;
        }
        this.f59314id = str2;
        this.resource = str;
        this.arguments = new FilteredArguments(this);
    }

    public LocalizedMessage(String str, String str2, String str3) throws NullPointerException, UnsupportedEncodingException {
        if (str == null || str2 == null) {
            throw null;
        }
        this.f59314id = str2;
        this.resource = str;
        this.arguments = new FilteredArguments(this);
        if (Charset.isSupported(str3)) {
            this.encoding = str3;
            return;
        }
        throw new UnsupportedEncodingException("The encoding \"" + str3 + "\" is not supported.");
    }

    public LocalizedMessage(String str, String str2, String str3, Object[] objArr) throws NullPointerException, UnsupportedEncodingException {
        if (str == null || str2 == null || objArr == null) {
            throw null;
        }
        this.f59314id = str2;
        this.resource = str;
        this.arguments = new FilteredArguments(objArr);
        if (Charset.isSupported(str3)) {
            this.encoding = str3;
            return;
        }
        throw new UnsupportedEncodingException("The encoding \"" + str3 + "\" is not supported.");
    }

    public LocalizedMessage(String str, String str2, Object[] objArr) throws NullPointerException {
        if (str == null || str2 == null || objArr == null) {
            throw null;
        }
        this.f59314id = str2;
        this.resource = str;
        this.arguments = new FilteredArguments(objArr);
    }

    public String addExtraArgs(String str, Locale locale) {
        if (this.extraArgs == null) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(str);
        Object[] filteredArgs = this.extraArgs.getFilteredArgs(locale);
        for (Object append : filteredArgs) {
            stringBuffer.append(append);
        }
        return stringBuffer.toString();
    }

    public String formatWithTimeZone(String str, Object[] objArr, Locale locale, TimeZone timeZone) {
        MessageFormat messageFormat = new MessageFormat(" ");
        messageFormat.setLocale(locale);
        messageFormat.applyPattern(str);
        if (!timeZone.equals(TimeZone.getDefault())) {
            Format[] formats = messageFormat.getFormats();
            for (int i11 = 0; i11 < formats.length; i11++) {
                if (formats[i11] instanceof DateFormat) {
                    DateFormat dateFormat = (DateFormat) formats[i11];
                    dateFormat.setTimeZone(timeZone);
                    messageFormat.setFormat(i11, dateFormat);
                }
            }
        }
        return messageFormat.format(objArr);
    }

    public Object[] getArguments() {
        return this.arguments.getArguments();
    }

    public ClassLoader getClassLoader() {
        return this.loader;
    }

    public String getEntry(String str, Locale locale, TimeZone timeZone) throws MissingEntryException {
        String str2 = this.f59314id;
        if (str != null) {
            str2 = str2 + InstructionFileId.DOT + str;
        }
        String str3 = str2;
        try {
            ClassLoader classLoader = this.loader;
            String string = (classLoader == null ? ResourceBundle.getBundle(this.resource, locale) : ResourceBundle.getBundle(this.resource, locale, classLoader)).getString(str3);
            if (!this.encoding.equals("ISO-8859-1")) {
                string = new String(string.getBytes("ISO-8859-1"), this.encoding);
            }
            if (!this.arguments.isEmpty()) {
                string = formatWithTimeZone(string, this.arguments.getFilteredArgs(locale), locale, timeZone);
            }
            return addExtraArgs(string, locale);
        } catch (MissingResourceException unused) {
            String str4 = "Can't find entry " + str3 + " in resource file " + this.resource + InstructionFileId.DOT;
            String str5 = this.resource;
            ClassLoader classLoader2 = this.loader;
            if (classLoader2 == null) {
                classLoader2 = getClassLoader();
            }
            throw new MissingEntryException(str4, str5, str3, locale, classLoader2);
        } catch (UnsupportedEncodingException e11) {
            throw new RuntimeException(e11);
        }
    }

    public Object[] getExtraArgs() {
        FilteredArguments filteredArguments = this.extraArgs;
        if (filteredArguments == null) {
            return null;
        }
        return filteredArguments.getArguments();
    }

    public Filter getFilter() {
        return this.filter;
    }

    public String getId() {
        return this.f59314id;
    }

    public String getResource() {
        return this.resource;
    }

    public void setClassLoader(ClassLoader classLoader) {
        this.loader = classLoader;
    }

    public void setExtraArgument(Object obj) {
        setExtraArguments(new Object[]{obj});
    }

    public void setExtraArguments(Object[] objArr) {
        if (objArr != null) {
            FilteredArguments filteredArguments = new FilteredArguments(objArr);
            this.extraArgs = filteredArguments;
            filteredArguments.setFilter(this.filter);
            return;
        }
        this.extraArgs = null;
    }

    public void setFilter(Filter filter2) {
        this.arguments.setFilter(filter2);
        FilteredArguments filteredArguments = this.extraArgs;
        if (filteredArguments != null) {
            filteredArguments.setFilter(filter2);
        }
        this.filter = filter2;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Resource: \"");
        stringBuffer.append(this.resource);
        stringBuffer.append("\" Id: \"");
        stringBuffer.append(this.f59314id);
        stringBuffer.append("\"");
        stringBuffer.append(" Arguments: ");
        stringBuffer.append(this.arguments.getArguments().length);
        stringBuffer.append(" normal");
        FilteredArguments filteredArguments = this.extraArgs;
        if (filteredArguments != null && filteredArguments.getArguments().length > 0) {
            stringBuffer.append(", ");
            stringBuffer.append(this.extraArgs.getArguments().length);
            stringBuffer.append(" extra");
        }
        stringBuffer.append(" Encoding: ");
        stringBuffer.append(this.encoding);
        stringBuffer.append(" ClassLoader: ");
        stringBuffer.append(this.loader);
        return stringBuffer.toString();
    }
}
