package com.hbg.lib.network.retrofit.websocket.bean;

import d2.b;

public abstract class HeartBeatInfo implements ISocketReq {

    public static class Ping extends HeartBeatInfo {
        private static final long serialVersionUID = -5797066764026274533L;
        private boolean hasOp;
        private long ping = System.currentTimeMillis();

        public Ping(boolean z11) {
            this.hasOp = z11;
        }

        public long getPing() {
            return this.ping;
        }

        public void setPing(long j11) {
            this.ping = j11;
        }

        public String toString() {
            if (this.hasOp) {
                return "{\"op\":\"ping\",\"ts\":" + this.ping + "}";
            }
            return "{\"ping\":" + this.ping + "}";
        }
    }

    public static class Pong extends HeartBeatInfo {
        private static final long serialVersionUID = 3193867343999481921L;
        private String ping;

        public void setPing(String str) {
            this.ping = str;
        }

        public String toString() {
            return this.ping.replace("ping", "pong");
        }
    }

    @b(serialize = false)
    public String getChannel() {
        return null;
    }

    public boolean isSame(ISocketSend iSocketSend) {
        return iSocketSend.getClass() == getClass();
    }
}
