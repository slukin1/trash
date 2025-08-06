package org.bouncycastle.pqc.jcajce.spec;

import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.util.Strings;

public class SPHINCSPlusParameterSpec implements AlgorithmParameterSpec {
    private static Map parameters;
    public static final SPHINCSPlusParameterSpec sha256_128f;
    public static final SPHINCSPlusParameterSpec sha256_128f_simple;
    public static final SPHINCSPlusParameterSpec sha256_128s;
    public static final SPHINCSPlusParameterSpec sha256_128s_simple;
    public static final SPHINCSPlusParameterSpec sha256_192f;
    public static final SPHINCSPlusParameterSpec sha256_192f_simple;
    public static final SPHINCSPlusParameterSpec sha256_192s;
    public static final SPHINCSPlusParameterSpec sha256_192s_simple;
    public static final SPHINCSPlusParameterSpec sha256_256f;
    public static final SPHINCSPlusParameterSpec sha256_256f_simple;
    public static final SPHINCSPlusParameterSpec sha256_256s;
    public static final SPHINCSPlusParameterSpec sha256_256s_simple;
    public static final SPHINCSPlusParameterSpec shake256_128f;
    public static final SPHINCSPlusParameterSpec shake256_128f_simple;
    public static final SPHINCSPlusParameterSpec shake256_128s;
    public static final SPHINCSPlusParameterSpec shake256_128s_simple;
    public static final SPHINCSPlusParameterSpec shake256_192f;
    public static final SPHINCSPlusParameterSpec shake256_192f_simple;
    public static final SPHINCSPlusParameterSpec shake256_192s;
    public static final SPHINCSPlusParameterSpec shake256_192s_simple;
    public static final SPHINCSPlusParameterSpec shake256_256f;
    public static final SPHINCSPlusParameterSpec shake256_256f_simple;
    public static final SPHINCSPlusParameterSpec shake256_256s;
    public static final SPHINCSPlusParameterSpec shake256_256s_simple;
    private final String name;

    static {
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec = new SPHINCSPlusParameterSpec("sha256-128f-robust");
        sha256_128f = sPHINCSPlusParameterSpec;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec2 = new SPHINCSPlusParameterSpec("sha256-128s-robust");
        sha256_128s = sPHINCSPlusParameterSpec2;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec3 = new SPHINCSPlusParameterSpec("sha256-192f-robust");
        sha256_192f = sPHINCSPlusParameterSpec3;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec4 = new SPHINCSPlusParameterSpec("sha256-192s-robust");
        sha256_192s = sPHINCSPlusParameterSpec4;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec5 = new SPHINCSPlusParameterSpec("sha256-256f-robust");
        sha256_256f = sPHINCSPlusParameterSpec5;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec6 = new SPHINCSPlusParameterSpec("sha256-256s-robust");
        sha256_256s = sPHINCSPlusParameterSpec6;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec7 = new SPHINCSPlusParameterSpec("sha256-128s-simple");
        sha256_128f_simple = sPHINCSPlusParameterSpec7;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec8 = new SPHINCSPlusParameterSpec("sha256-128f-simple");
        sha256_128s_simple = sPHINCSPlusParameterSpec8;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec9 = new SPHINCSPlusParameterSpec("sha256-192f-simple");
        sha256_192f_simple = sPHINCSPlusParameterSpec9;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec10 = new SPHINCSPlusParameterSpec("sha256-192s-simple");
        sha256_192s_simple = sPHINCSPlusParameterSpec10;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec11 = new SPHINCSPlusParameterSpec("sha256-256f-simple");
        sha256_256f_simple = sPHINCSPlusParameterSpec11;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec12 = new SPHINCSPlusParameterSpec("sha256-256s-simple");
        sha256_256s_simple = sPHINCSPlusParameterSpec12;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec13 = new SPHINCSPlusParameterSpec("shake256-128f-robust");
        shake256_128f = sPHINCSPlusParameterSpec13;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec14 = new SPHINCSPlusParameterSpec("shake256-128s-robust");
        shake256_128s = sPHINCSPlusParameterSpec14;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec15 = new SPHINCSPlusParameterSpec("shake256-192f-robust");
        shake256_192f = sPHINCSPlusParameterSpec15;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec16 = sPHINCSPlusParameterSpec15;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec17 = new SPHINCSPlusParameterSpec("shake256-192s-robust");
        shake256_192s = sPHINCSPlusParameterSpec17;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec18 = sPHINCSPlusParameterSpec17;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec19 = new SPHINCSPlusParameterSpec("shake256-256f-robust");
        shake256_256f = sPHINCSPlusParameterSpec19;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec20 = sPHINCSPlusParameterSpec19;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec21 = new SPHINCSPlusParameterSpec("shake256-256s-robust");
        shake256_256s = sPHINCSPlusParameterSpec21;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec22 = sPHINCSPlusParameterSpec21;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec23 = new SPHINCSPlusParameterSpec("shake256-128f-simple");
        shake256_128f_simple = sPHINCSPlusParameterSpec23;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec24 = sPHINCSPlusParameterSpec23;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec25 = new SPHINCSPlusParameterSpec("shake256-128s-simple");
        shake256_128s_simple = sPHINCSPlusParameterSpec25;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec26 = sPHINCSPlusParameterSpec25;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec27 = new SPHINCSPlusParameterSpec("shake256-192f-simple");
        shake256_192f_simple = sPHINCSPlusParameterSpec27;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec28 = sPHINCSPlusParameterSpec27;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec29 = new SPHINCSPlusParameterSpec("shake256-192s-simple");
        shake256_192s_simple = sPHINCSPlusParameterSpec29;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec30 = sPHINCSPlusParameterSpec29;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec31 = new SPHINCSPlusParameterSpec("shake256-256f-simple");
        shake256_256f_simple = sPHINCSPlusParameterSpec31;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec32 = sPHINCSPlusParameterSpec31;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec33 = new SPHINCSPlusParameterSpec("shake256-256s-simple");
        shake256_256s_simple = sPHINCSPlusParameterSpec33;
        HashMap hashMap = new HashMap();
        parameters = hashMap;
        SPHINCSPlusParameterSpec sPHINCSPlusParameterSpec34 = sPHINCSPlusParameterSpec33;
        hashMap.put(sPHINCSPlusParameterSpec.getName(), sPHINCSPlusParameterSpec);
        parameters.put(sPHINCSPlusParameterSpec2.getName(), sPHINCSPlusParameterSpec2);
        parameters.put(sPHINCSPlusParameterSpec3.getName(), sPHINCSPlusParameterSpec3);
        parameters.put(sPHINCSPlusParameterSpec4.getName(), sPHINCSPlusParameterSpec4);
        parameters.put(sPHINCSPlusParameterSpec5.getName(), sPHINCSPlusParameterSpec5);
        parameters.put(sPHINCSPlusParameterSpec6.getName(), sPHINCSPlusParameterSpec6);
        parameters.put(sPHINCSPlusParameterSpec7.getName(), sPHINCSPlusParameterSpec7);
        parameters.put(sPHINCSPlusParameterSpec8.getName(), sPHINCSPlusParameterSpec8);
        parameters.put(sPHINCSPlusParameterSpec9.getName(), sPHINCSPlusParameterSpec9);
        parameters.put(sPHINCSPlusParameterSpec10.getName(), sPHINCSPlusParameterSpec10);
        parameters.put(sPHINCSPlusParameterSpec11.getName(), sPHINCSPlusParameterSpec11);
        parameters.put(sPHINCSPlusParameterSpec12.getName(), sPHINCSPlusParameterSpec12);
        parameters.put(sPHINCSPlusParameterSpec13.getName(), sPHINCSPlusParameterSpec13);
        parameters.put(sPHINCSPlusParameterSpec14.getName(), sPHINCSPlusParameterSpec14);
        parameters.put(sPHINCSPlusParameterSpec16.getName(), sPHINCSPlusParameterSpec16);
        parameters.put(sPHINCSPlusParameterSpec18.getName(), sPHINCSPlusParameterSpec18);
        parameters.put(sPHINCSPlusParameterSpec20.getName(), sPHINCSPlusParameterSpec20);
        parameters.put(sPHINCSPlusParameterSpec22.getName(), sPHINCSPlusParameterSpec22);
        parameters.put(sPHINCSPlusParameterSpec24.getName(), sPHINCSPlusParameterSpec24);
        parameters.put(sPHINCSPlusParameterSpec26.getName(), sPHINCSPlusParameterSpec26);
        parameters.put(sPHINCSPlusParameterSpec28.getName(), sPHINCSPlusParameterSpec28);
        parameters.put(sPHINCSPlusParameterSpec30.getName(), sPHINCSPlusParameterSpec30);
        parameters.put(sPHINCSPlusParameterSpec32.getName(), sPHINCSPlusParameterSpec32);
        parameters.put(sPHINCSPlusParameterSpec34.getName(), sPHINCSPlusParameterSpec34);
    }

    private SPHINCSPlusParameterSpec(String str) {
        this.name = str;
    }

    public static SPHINCSPlusParameterSpec fromName(String str) {
        return (SPHINCSPlusParameterSpec) parameters.get(Strings.toLowerCase(str));
    }

    public String getName() {
        return this.name;
    }
}
