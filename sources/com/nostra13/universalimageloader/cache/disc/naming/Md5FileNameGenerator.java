package com.nostra13.universalimageloader.cache.disc.naming;

import com.huochat.community.util.FileTool;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import lx.a;
import vx.c;

public class Md5FileNameGenerator implements a {
    public String a(String str) {
        return new BigInteger(b(str.getBytes())).abs().toString(36);
    }

    public final byte[] b(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance(FileTool.HASH_TYPE_MD5);
            instance.update(bArr);
            return instance.digest();
        } catch (NoSuchAlgorithmException e11) {
            c.c(e11);
            return null;
        }
    }
}
