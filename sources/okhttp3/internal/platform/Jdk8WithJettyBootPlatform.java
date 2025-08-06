package okhttp3.internal.platform;

import com.sumsub.sns.internal.fingerprint.infoproviders.q;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import okhttp3.Protocol;

public final class Jdk8WithJettyBootPlatform extends Platform {
    public static final Companion Companion = new Companion((r) null);
    private final Class<?> clientProviderClass;
    private final Method getMethod;
    private final Method putMethod;
    private final Method removeMethod;
    private final Class<?> serverProviderClass;

    public static final class AlpnProvider implements InvocationHandler {
        private final List<String> protocols;
        private String selected;
        private boolean unsupported;

        public AlpnProvider(List<String> list) {
            this.protocols = list;
        }

        public final String getSelected() {
            return this.selected;
        }

        public final boolean getUnsupported() {
            return this.unsupported;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if (objArr == null) {
                objArr = new Object[0];
            }
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (x.b(name, "supports") && x.b(Boolean.TYPE, returnType)) {
                return Boolean.TRUE;
            }
            if (!x.b(name, q.f34641a) || !x.b(Void.TYPE, returnType)) {
                if (x.b(name, "protocols")) {
                    if (objArr.length == 0) {
                        return this.protocols;
                    }
                }
                if ((x.b(name, "selectProtocol") || x.b(name, "select")) && x.b(String.class, returnType) && objArr.length == 1 && (objArr[0] instanceof List)) {
                    List list = (List) objArr[0];
                    int size = list.size();
                    if (size >= 0) {
                        int i11 = 0;
                        while (true) {
                            String str = (String) list.get(i11);
                            if (!this.protocols.contains(str)) {
                                if (i11 == size) {
                                    break;
                                }
                                i11++;
                            } else {
                                this.selected = str;
                                return str;
                            }
                        }
                    }
                    String str2 = this.protocols.get(0);
                    this.selected = str2;
                    return str2;
                } else if ((!x.b(name, "protocolSelected") && !x.b(name, "selected")) || objArr.length != 1) {
                    return method.invoke(this, Arrays.copyOf(objArr, objArr.length));
                } else {
                    this.selected = (String) objArr[0];
                    return null;
                }
            } else {
                this.unsupported = true;
                return null;
            }
        }

        public final void setSelected(String str) {
            this.selected = str;
        }

        public final void setUnsupported(boolean z11) {
            this.unsupported = z11;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final Platform buildIfSupported() {
            try {
                if (Integer.parseInt(System.getProperty("java.specification.version", "unknown")) >= 9) {
                    return null;
                }
            } catch (NumberFormatException unused) {
            }
            try {
                Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN", true, (ClassLoader) null);
                Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$Provider", true, (ClassLoader) null);
                Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ClientProvider", true, (ClassLoader) null);
                Class<?> cls4 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ServerProvider", true, (ClassLoader) null);
                Method method = cls.getMethod("put", new Class[]{SSLSocket.class, cls2});
                return new Jdk8WithJettyBootPlatform(method, cls.getMethod("get", new Class[]{SSLSocket.class}), cls.getMethod("remove", new Class[]{SSLSocket.class}), cls3, cls4);
            } catch (ClassNotFoundException | NoSuchMethodException unused2) {
                return null;
            }
        }
    }

    public Jdk8WithJettyBootPlatform(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.putMethod = method;
        this.getMethod = method2;
        this.removeMethod = method3;
        this.clientProviderClass = cls;
        this.serverProviderClass = cls2;
    }

    public void afterHandshake(SSLSocket sSLSocket) {
        try {
            this.removeMethod.invoke((Object) null, new Object[]{sSLSocket});
        } catch (IllegalAccessException e11) {
            throw new AssertionError("failed to remove ALPN", e11);
        } catch (InvocationTargetException e12) {
            throw new AssertionError("failed to remove ALPN", e12);
        }
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<? extends Protocol> list) {
        List<String> alpnProtocolNames = Platform.Companion.alpnProtocolNames(list);
        try {
            Object newProxyInstance = Proxy.newProxyInstance(Platform.class.getClassLoader(), new Class[]{this.clientProviderClass, this.serverProviderClass}, new AlpnProvider(alpnProtocolNames));
            this.putMethod.invoke((Object) null, new Object[]{sSLSocket, newProxyInstance});
        } catch (InvocationTargetException e11) {
            throw new AssertionError("failed to set ALPN", e11);
        } catch (IllegalAccessException e12) {
            throw new AssertionError("failed to set ALPN", e12);
        }
    }

    public String getSelectedProtocol(SSLSocket sSLSocket) {
        try {
            AlpnProvider alpnProvider = (AlpnProvider) Proxy.getInvocationHandler(this.getMethod.invoke((Object) null, new Object[]{sSLSocket}));
            if (!alpnProvider.getUnsupported() && alpnProvider.getSelected() == null) {
                Platform.log$default(this, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", 0, (Throwable) null, 6, (Object) null);
                return null;
            } else if (alpnProvider.getUnsupported()) {
                return null;
            } else {
                return alpnProvider.getSelected();
            }
        } catch (InvocationTargetException e11) {
            throw new AssertionError("failed to get ALPN selected protocol", e11);
        } catch (IllegalAccessException e12) {
            throw new AssertionError("failed to get ALPN selected protocol", e12);
        }
    }
}
