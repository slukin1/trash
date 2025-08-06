package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import com.huochat.community.util.FileTool;
import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.zip.Adler32;
import java.util.zip.CRC32;
import java.util.zip.Checksum;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;

@Beta
public final class Hashing {
    public static final int GOOD_FAST_HASH_SEED = ((int) System.currentTimeMillis());

    @Immutable
    public enum ChecksumType implements ImmutableSupplier<Checksum> {
        CRC_32("Hashing.crc32()") {
            public Checksum get() {
                return new CRC32();
            }
        },
        ADLER_32("Hashing.adler32()") {
            public Checksum get() {
                return new Adler32();
            }
        };
        
        public final HashFunction hashFunction;

        private ChecksumType(String str) {
            this.hashFunction = new ChecksumHashFunction(this, 32, str);
        }
    }

    public static final class ConcatenatedHashFunction extends AbstractCompositeHashFunction {
        public int bits() {
            int i11 = 0;
            for (HashFunction bits : this.functions) {
                i11 += bits.bits();
            }
            return i11;
        }

        public boolean equals(Object obj) {
            if (obj instanceof ConcatenatedHashFunction) {
                return Arrays.equals(this.functions, ((ConcatenatedHashFunction) obj).functions);
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(this.functions);
        }

        public HashCode makeHash(Hasher[] hasherArr) {
            byte[] bArr = new byte[(bits() / 8)];
            int i11 = 0;
            for (Hasher hash : hasherArr) {
                HashCode hash2 = hash.hash();
                i11 += hash2.writeBytesTo(bArr, i11, hash2.bits() / 8);
            }
            return HashCode.fromBytesNoCopy(bArr);
        }

        private ConcatenatedHashFunction(HashFunction... hashFunctionArr) {
            super(hashFunctionArr);
            for (HashFunction hashFunction : hashFunctionArr) {
                Preconditions.checkArgument(hashFunction.bits() % 8 == 0, "the number of bits (%s) in hashFunction (%s) must be divisible by 8", hashFunction.bits(), (Object) hashFunction);
            }
        }
    }

    public static final class LinearCongruentialGenerator {
        private long state;

        public LinearCongruentialGenerator(long j11) {
            this.state = j11;
        }

        public double nextDouble() {
            long j11 = (this.state * 2862933555777941757L) + 1;
            this.state = j11;
            return ((double) (((int) (j11 >>> 33)) + 1)) / 2.147483648E9d;
        }
    }

    public static class Md5Holder {
        public static final HashFunction MD5 = new MessageDigestHashFunction(FileTool.HASH_TYPE_MD5, "Hashing.md5()");

        private Md5Holder() {
        }
    }

    public static class Sha1Holder {
        public static final HashFunction SHA_1 = new MessageDigestHashFunction(McElieceCCA2KeyGenParameterSpec.SHA1, "Hashing.sha1()");

        private Sha1Holder() {
        }
    }

    public static class Sha256Holder {
        public static final HashFunction SHA_256 = new MessageDigestHashFunction("SHA-256", "Hashing.sha256()");

        private Sha256Holder() {
        }
    }

    public static class Sha384Holder {
        public static final HashFunction SHA_384 = new MessageDigestHashFunction("SHA-384", "Hashing.sha384()");

        private Sha384Holder() {
        }
    }

    public static class Sha512Holder {
        public static final HashFunction SHA_512 = new MessageDigestHashFunction("SHA-512", "Hashing.sha512()");

        private Sha512Holder() {
        }
    }

    private Hashing() {
    }

    public static HashFunction adler32() {
        return ChecksumType.ADLER_32.hashFunction;
    }

    public static int checkPositiveAndMakeMultipleOf32(int i11) {
        Preconditions.checkArgument(i11 > 0, "Number of bits must be positive");
        return (i11 + 31) & -32;
    }

    public static HashCode combineOrdered(Iterable<HashCode> iterable) {
        Iterator<HashCode> it2 = iterable.iterator();
        Preconditions.checkArgument(it2.hasNext(), "Must be at least 1 hash code to combine.");
        int bits = it2.next().bits() / 8;
        byte[] bArr = new byte[bits];
        for (HashCode asBytes : iterable) {
            byte[] asBytes2 = asBytes.asBytes();
            Preconditions.checkArgument(asBytes2.length == bits, "All hashcodes must have the same bit length.");
            for (int i11 = 0; i11 < asBytes2.length; i11++) {
                bArr[i11] = (byte) ((bArr[i11] * 37) ^ asBytes2[i11]);
            }
        }
        return HashCode.fromBytesNoCopy(bArr);
    }

    public static HashCode combineUnordered(Iterable<HashCode> iterable) {
        Iterator<HashCode> it2 = iterable.iterator();
        Preconditions.checkArgument(it2.hasNext(), "Must be at least 1 hash code to combine.");
        int bits = it2.next().bits() / 8;
        byte[] bArr = new byte[bits];
        for (HashCode asBytes : iterable) {
            byte[] asBytes2 = asBytes.asBytes();
            Preconditions.checkArgument(asBytes2.length == bits, "All hashcodes must have the same bit length.");
            for (int i11 = 0; i11 < asBytes2.length; i11++) {
                bArr[i11] = (byte) (bArr[i11] + asBytes2[i11]);
            }
        }
        return HashCode.fromBytesNoCopy(bArr);
    }

    public static HashFunction concatenating(HashFunction hashFunction, HashFunction hashFunction2, HashFunction... hashFunctionArr) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(hashFunction);
        arrayList.add(hashFunction2);
        arrayList.addAll(Arrays.asList(hashFunctionArr));
        return new ConcatenatedHashFunction((HashFunction[]) arrayList.toArray(new HashFunction[0]));
    }

    public static int consistentHash(HashCode hashCode, int i11) {
        return consistentHash(hashCode.padToLong(), i11);
    }

    public static HashFunction crc32() {
        return ChecksumType.CRC_32.hashFunction;
    }

    public static HashFunction crc32c() {
        return Crc32cHashFunction.CRC_32_C;
    }

    public static HashFunction farmHashFingerprint64() {
        return FarmHashFingerprint64.FARMHASH_FINGERPRINT_64;
    }

    public static HashFunction goodFastHash(int i11) {
        int checkPositiveAndMakeMultipleOf32 = checkPositiveAndMakeMultipleOf32(i11);
        if (checkPositiveAndMakeMultipleOf32 == 32) {
            return Murmur3_32HashFunction.GOOD_FAST_HASH_32;
        }
        if (checkPositiveAndMakeMultipleOf32 <= 128) {
            return Murmur3_128HashFunction.GOOD_FAST_HASH_128;
        }
        int i12 = (checkPositiveAndMakeMultipleOf32 + 127) / 128;
        HashFunction[] hashFunctionArr = new HashFunction[i12];
        hashFunctionArr[0] = Murmur3_128HashFunction.GOOD_FAST_HASH_128;
        int i13 = GOOD_FAST_HASH_SEED;
        for (int i14 = 1; i14 < i12; i14++) {
            i13 += 1500450271;
            hashFunctionArr[i14] = murmur3_128(i13);
        }
        return new ConcatenatedHashFunction(hashFunctionArr);
    }

    public static HashFunction hmacMd5(Key key) {
        return new MacHashFunction("HmacMD5", key, hmacToString("hmacMd5", key));
    }

    public static HashFunction hmacSha1(Key key) {
        return new MacHashFunction("HmacSHA1", key, hmacToString("hmacSha1", key));
    }

    public static HashFunction hmacSha256(Key key) {
        return new MacHashFunction("HmacSHA256", key, hmacToString("hmacSha256", key));
    }

    public static HashFunction hmacSha512(Key key) {
        return new MacHashFunction("HmacSHA512", key, hmacToString("hmacSha512", key));
    }

    private static String hmacToString(String str, Key key) {
        return String.format("Hashing.%s(Key[algorithm=%s, format=%s])", new Object[]{str, key.getAlgorithm(), key.getFormat()});
    }

    @Deprecated
    public static HashFunction md5() {
        return Md5Holder.MD5;
    }

    public static HashFunction murmur3_128(int i11) {
        return new Murmur3_128HashFunction(i11);
    }

    public static HashFunction murmur3_32(int i11) {
        return new Murmur3_32HashFunction(i11);
    }

    @Deprecated
    public static HashFunction sha1() {
        return Sha1Holder.SHA_1;
    }

    public static HashFunction sha256() {
        return Sha256Holder.SHA_256;
    }

    public static HashFunction sha384() {
        return Sha384Holder.SHA_384;
    }

    public static HashFunction sha512() {
        return Sha512Holder.SHA_512;
    }

    public static HashFunction sipHash24() {
        return SipHashFunction.SIP_HASH_24;
    }

    public static int consistentHash(long j11, int i11) {
        int i12 = 0;
        Preconditions.checkArgument(i11 > 0, "buckets must be positive: %s", i11);
        LinearCongruentialGenerator linearCongruentialGenerator = new LinearCongruentialGenerator(j11);
        while (true) {
            int nextDouble = (int) (((double) (i12 + 1)) / linearCongruentialGenerator.nextDouble());
            if (nextDouble < 0 || nextDouble >= i11) {
                return i12;
            }
            i12 = nextDouble;
        }
        return i12;
    }

    public static HashFunction hmacMd5(byte[] bArr) {
        return hmacMd5((Key) new SecretKeySpec((byte[]) Preconditions.checkNotNull(bArr), "HmacMD5"));
    }

    public static HashFunction hmacSha1(byte[] bArr) {
        return hmacSha1((Key) new SecretKeySpec((byte[]) Preconditions.checkNotNull(bArr), "HmacSHA1"));
    }

    public static HashFunction hmacSha256(byte[] bArr) {
        return hmacSha256((Key) new SecretKeySpec((byte[]) Preconditions.checkNotNull(bArr), "HmacSHA256"));
    }

    public static HashFunction hmacSha512(byte[] bArr) {
        return hmacSha512((Key) new SecretKeySpec((byte[]) Preconditions.checkNotNull(bArr), "HmacSHA512"));
    }

    public static HashFunction murmur3_128() {
        return Murmur3_128HashFunction.MURMUR3_128;
    }

    public static HashFunction murmur3_32() {
        return Murmur3_32HashFunction.MURMUR3_32;
    }

    public static HashFunction sipHash24(long j11, long j12) {
        return new SipHashFunction(2, 4, j11, j12);
    }

    public static HashFunction concatenating(Iterable<HashFunction> iterable) {
        Preconditions.checkNotNull(iterable);
        ArrayList arrayList = new ArrayList();
        for (HashFunction add : iterable) {
            arrayList.add(add);
        }
        Preconditions.checkArgument(arrayList.size() > 0, "number of hash functions (%s) must be > 0", arrayList.size());
        return new ConcatenatedHashFunction((HashFunction[]) arrayList.toArray(new HashFunction[0]));
    }
}
