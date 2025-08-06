package cn.sharesdk.loopshare.beans;

import cn.sharesdk.loopshare.beans.ServerData;

public class LinkData extends ServerData {
    private Res res;

    public static class Res extends ServerData.Res {
        private String domain;
        /* access modifiers changed from: private */
        public String link;
    }

    public String a() {
        Res res2 = this.res;
        return res2 != null ? res2.link : "";
    }
}
