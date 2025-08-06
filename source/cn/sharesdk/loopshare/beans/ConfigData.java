package cn.sharesdk.loopshare.beans;

import cn.sharesdk.loopshare.beans.ServerData;

public class ConfigData extends ServerData {
    private Res res;

    public static class Res extends ServerData.Res {
        /* access modifiers changed from: private */
        public String appLink;
        /* access modifiers changed from: private */
        public String host;
        /* access modifiers changed from: private */
        public int port;
        /* access modifiers changed from: private */
        public String scheme;
        private int sslPort;
        private int timeout;
        private long timestamp;
        /* access modifiers changed from: private */
        public boolean yyb;
    }

    public boolean a() {
        Res res2 = this.res;
        if (res2 != null) {
            return res2.yyb;
        }
        return false;
    }

    public String b() {
        Res res2 = this.res;
        return res2 != null ? res2.host : "";
    }

    public int c() {
        Res res2 = this.res;
        if (res2 != null) {
            return res2.port;
        }
        return 80;
    }

    public String d() {
        Res res2 = this.res;
        return res2 != null ? res2.scheme : "";
    }

    public String e() {
        Res res2 = this.res;
        if (res2 != null) {
            return res2.appLink;
        }
        return null;
    }

    public String f() {
        Res res2 = this.res;
        return res2 != null ? res2.host : "";
    }

    public int g() {
        Res res2 = this.res;
        if (res2 != null) {
            return res2.port;
        }
        return 80;
    }
}
