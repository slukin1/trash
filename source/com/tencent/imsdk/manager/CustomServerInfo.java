package com.tencent.imsdk.manager;

import java.util.ArrayList;
import java.util.List;

public class CustomServerInfo {
    public List<ServerAddress> longconnectionAddressList = new ArrayList();
    public String serverPublicKey = "";
    public List<ServerAddress> shortconnectionAddressList = new ArrayList();

    public static class ServerAddress {

        /* renamed from: ip  reason: collision with root package name */
        public String f70349ip = "";
        public boolean isIPv6 = false;
        public boolean isQuic = false;
        public int port = 0;
    }
}
