package com.tencent.android.tpns.mqtt.internal.websocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WebSocketHandshake {
    private static final String ACCEPT_SALT = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    private static final String EMPTY = "";
    private static final String HTTP_HEADER_CONNECTION = "connection";
    private static final String HTTP_HEADER_CONNECTION_VALUE = "upgrade";
    private static final String HTTP_HEADER_SEC_WEBSOCKET_ACCEPT = "sec-websocket-accept";
    private static final String HTTP_HEADER_SEC_WEBSOCKET_PROTOCOL = "sec-websocket-protocol";
    private static final String HTTP_HEADER_UPGRADE = "upgrade";
    private static final String HTTP_HEADER_UPGRADE_WEBSOCKET = "websocket";
    private static final String LINE_SEPARATOR = "\r\n";
    private static final String SHA1_PROTOCOL = "SHA1";
    public String host;
    public InputStream input;
    public OutputStream output;
    public int port;
    public String uri;

    public WebSocketHandshake(InputStream inputStream, OutputStream outputStream, String str, String str2, int i11) {
        this.input = inputStream;
        this.output = outputStream;
        this.uri = str;
        this.host = str2;
        this.port = i11;
    }

    private Map getHeaders(ArrayList arrayList) {
        HashMap hashMap = new HashMap();
        for (int i11 = 1; i11 < arrayList.size(); i11++) {
            String[] split = ((String) arrayList.get(i11)).split(":");
            hashMap.put(split[0].toLowerCase(), split[1]);
        }
        return hashMap;
    }

    private void receiveHandshakeResponse(String str) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.input, "UTF-8"));
        ArrayList arrayList = new ArrayList();
        String readLine = bufferedReader.readLine();
        if (readLine != null) {
            while (readLine != null && !readLine.equals("")) {
                arrayList.add(readLine);
                readLine = bufferedReader.readLine();
            }
            Map headers = getHeaders(arrayList);
            String str2 = (String) headers.get(HTTP_HEADER_CONNECTION);
            if (str2 == null || str2.equalsIgnoreCase("upgrade")) {
                throw new IOException("WebSocket Response header: Incorrect connection header");
            }
            String str3 = (String) headers.get("upgrade");
            if (str3 == null || !str3.toLowerCase().contains(HTTP_HEADER_UPGRADE_WEBSOCKET)) {
                throw new IOException("WebSocket Response header: Incorrect upgrade.");
            } else if (((String) headers.get(HTTP_HEADER_SEC_WEBSOCKET_PROTOCOL)) == null) {
                throw new IOException("WebSocket Response header: empty sec-websocket-protocol");
            } else if (headers.containsKey(HTTP_HEADER_SEC_WEBSOCKET_ACCEPT)) {
                try {
                    verifyWebSocketKey(str, (String) headers.get(HTTP_HEADER_SEC_WEBSOCKET_ACCEPT));
                } catch (NoSuchAlgorithmException e11) {
                    throw new IOException(e11.getMessage());
                } catch (HandshakeFailedException unused) {
                    throw new IOException("WebSocket Response header: Incorrect Sec-WebSocket-Key");
                }
            } else {
                throw new IOException("WebSocket Response header: Missing Sec-WebSocket-Accept");
            }
        } else {
            throw new IOException("WebSocket Response header: Invalid response from Server, It may not support WebSockets.");
        }
    }

    private void sendHandshakeRequest(String str) throws IOException {
        String str2 = "/mqtt";
        try {
            URI uri2 = new URI(this.uri);
            if (uri2.getRawPath() != null && !uri2.getRawPath().isEmpty()) {
                str2 = uri2.getRawPath();
                if (uri2.getRawQuery() != null && !uri2.getRawQuery().isEmpty()) {
                    str2 = str2 + "?" + uri2.getRawQuery();
                }
            }
            PrintWriter printWriter = new PrintWriter(this.output);
            printWriter.print("GET " + str2 + " HTTP/1.1" + "\r\n");
            int i11 = this.port;
            if (i11 == 80 || i11 == 443) {
                printWriter.print("Host: " + this.host + "\r\n");
            } else {
                printWriter.print("Host: " + this.host + ":" + this.port + "\r\n");
            }
            printWriter.print("Upgrade: websocket\r\n");
            printWriter.print("Connection: Upgrade\r\n");
            printWriter.print("Sec-WebSocket-Key: " + str + "\r\n");
            printWriter.print("Sec-WebSocket-Protocol: mqtt\r\n");
            printWriter.print("Sec-WebSocket-Version: 13\r\n");
            String userInfo = uri2.getUserInfo();
            if (userInfo != null) {
                printWriter.print("Authorization: Basic " + Base64.encode(userInfo) + "\r\n");
            }
            printWriter.print("\r\n");
            printWriter.flush();
        } catch (URISyntaxException e11) {
            throw new IllegalStateException(e11.getMessage());
        }
    }

    private byte[] sha1(String str) throws NoSuchAlgorithmException {
        return MessageDigest.getInstance("SHA1").digest(str.getBytes());
    }

    private void verifyWebSocketKey(String str, String str2) throws NoSuchAlgorithmException, HandshakeFailedException {
        if (!Base64.encodeBytes(sha1(str + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11")).trim().equals(str2.trim())) {
            throw new HandshakeFailedException();
        }
    }

    public void execute() throws IOException {
        byte[] bArr = new byte[16];
        System.arraycopy("".getBytes(), 0, bArr, 0, 16);
        String encodeBytes = Base64.encodeBytes(bArr);
        sendHandshakeRequest(encodeBytes);
        receiveHandshakeResponse(encodeBytes);
    }
}
