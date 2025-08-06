package com.google.common.net;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;

@GwtCompatible
@Immutable
@Beta
public final class HostAndPort implements Serializable {
    private static final int NO_PORT = -1;
    private static final long serialVersionUID = 0;
    private final boolean hasBracketlessColons;
    private final String host;
    private final int port;

    private HostAndPort(String str, int i11, boolean z11) {
        this.host = str;
        this.port = i11;
        this.hasBracketlessColons = z11;
    }

    public static HostAndPort fromHost(String str) {
        HostAndPort fromString = fromString(str);
        Preconditions.checkArgument(!fromString.hasPort(), "Host has a port: %s", (Object) str);
        return fromString;
    }

    public static HostAndPort fromParts(String str, int i11) {
        Preconditions.checkArgument(isValidPort(i11), "Port out of range: %s", i11);
        HostAndPort fromString = fromString(str);
        Preconditions.checkArgument(!fromString.hasPort(), "Host has a port: %s", (Object) str);
        return new HostAndPort(fromString.host, i11, fromString.hasBracketlessColons);
    }

    public static HostAndPort fromString(String str) {
        String str2;
        String str3;
        Preconditions.checkNotNull(str);
        int i11 = -1;
        boolean z11 = false;
        if (str.startsWith("[")) {
            String[] hostAndPortFromBracketedHost = getHostAndPortFromBracketedHost(str);
            str2 = hostAndPortFromBracketedHost[0];
            str3 = hostAndPortFromBracketedHost[1];
        } else {
            int indexOf = str.indexOf(58);
            if (indexOf >= 0) {
                int i12 = indexOf + 1;
                if (str.indexOf(58, i12) == -1) {
                    str2 = str.substring(0, indexOf);
                    str3 = str.substring(i12);
                }
            }
            if (indexOf >= 0) {
                z11 = true;
            }
            str3 = null;
            str2 = str;
        }
        if (!Strings.isNullOrEmpty(str3)) {
            Preconditions.checkArgument(!str3.startsWith("+"), "Unparseable port number: %s", (Object) str);
            try {
                i11 = Integer.parseInt(str3);
                Preconditions.checkArgument(isValidPort(i11), "Port number out of range: %s", (Object) str);
            } catch (NumberFormatException unused) {
                throw new IllegalArgumentException("Unparseable port number: " + str);
            }
        }
        return new HostAndPort(str2, i11, z11);
    }

    private static String[] getHostAndPortFromBracketedHost(String str) {
        Preconditions.checkArgument(str.charAt(0) == '[', "Bracketed host-port string must start with a bracket: %s", (Object) str);
        int indexOf = str.indexOf(58);
        int lastIndexOf = str.lastIndexOf(93);
        Preconditions.checkArgument(indexOf > -1 && lastIndexOf > indexOf, "Invalid bracketed host/port: %s", (Object) str);
        String substring = str.substring(1, lastIndexOf);
        int i11 = lastIndexOf + 1;
        if (i11 == str.length()) {
            return new String[]{substring, ""};
        }
        Preconditions.checkArgument(str.charAt(i11) == ':', "Only a colon may follow a close bracket: %s", (Object) str);
        int i12 = lastIndexOf + 2;
        for (int i13 = i12; i13 < str.length(); i13++) {
            Preconditions.checkArgument(Character.isDigit(str.charAt(i13)), "Port must be numeric: %s", (Object) str);
        }
        return new String[]{substring, str.substring(i12)};
    }

    private static boolean isValidPort(int i11) {
        return i11 >= 0 && i11 <= 65535;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HostAndPort)) {
            return false;
        }
        HostAndPort hostAndPort = (HostAndPort) obj;
        if (!Objects.equal(this.host, hostAndPort.host) || this.port != hostAndPort.port) {
            return false;
        }
        return true;
    }

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        Preconditions.checkState(hasPort());
        return this.port;
    }

    public int getPortOrDefault(int i11) {
        return hasPort() ? this.port : i11;
    }

    public boolean hasPort() {
        return this.port >= 0;
    }

    public int hashCode() {
        return Objects.hashCode(this.host, Integer.valueOf(this.port));
    }

    public HostAndPort requireBracketsForIPv6() {
        Preconditions.checkArgument(!this.hasBracketlessColons, "Possible bracketless IPv6 literal: %s", (Object) this.host);
        return this;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(this.host.length() + 8);
        if (this.host.indexOf(58) >= 0) {
            sb2.append('[');
            sb2.append(this.host);
            sb2.append(']');
        } else {
            sb2.append(this.host);
        }
        if (hasPort()) {
            sb2.append(':');
            sb2.append(this.port);
        }
        return sb2.toString();
    }

    public HostAndPort withDefaultPort(int i11) {
        Preconditions.checkArgument(isValidPort(i11));
        if (hasPort()) {
            return this;
        }
        return new HostAndPort(this.host, i11, this.hasBracketlessColons);
    }
}
