package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

@Immutable
abstract class AbstractCompositeHashFunction extends AbstractHashFunction {
    private static final long serialVersionUID = 0;
    public final HashFunction[] functions;

    public AbstractCompositeHashFunction(HashFunction... hashFunctionArr) {
        for (HashFunction checkNotNull : hashFunctionArr) {
            Preconditions.checkNotNull(checkNotNull);
        }
        this.functions = hashFunctionArr;
    }

    private Hasher fromHashers(final Hasher[] hasherArr) {
        return new Hasher() {
            public HashCode hash() {
                return AbstractCompositeHashFunction.this.makeHash(hasherArr);
            }

            public <T> Hasher putObject(T t11, Funnel<? super T> funnel) {
                for (Hasher putObject : hasherArr) {
                    putObject.putObject(t11, funnel);
                }
                return this;
            }

            public Hasher putBoolean(boolean z11) {
                for (Hasher putBoolean : hasherArr) {
                    putBoolean.putBoolean(z11);
                }
                return this;
            }

            public Hasher putByte(byte b11) {
                for (Hasher putByte : hasherArr) {
                    putByte.putByte(b11);
                }
                return this;
            }

            public Hasher putChar(char c11) {
                for (Hasher putChar : hasherArr) {
                    putChar.putChar(c11);
                }
                return this;
            }

            public Hasher putDouble(double d11) {
                for (Hasher putDouble : hasherArr) {
                    putDouble.putDouble(d11);
                }
                return this;
            }

            public Hasher putFloat(float f11) {
                for (Hasher putFloat : hasherArr) {
                    putFloat.putFloat(f11);
                }
                return this;
            }

            public Hasher putInt(int i11) {
                for (Hasher putInt : hasherArr) {
                    putInt.putInt(i11);
                }
                return this;
            }

            public Hasher putLong(long j11) {
                for (Hasher putLong : hasherArr) {
                    putLong.putLong(j11);
                }
                return this;
            }

            public Hasher putShort(short s11) {
                for (Hasher putShort : hasherArr) {
                    putShort.putShort(s11);
                }
                return this;
            }

            public Hasher putString(CharSequence charSequence, Charset charset) {
                for (Hasher putString : hasherArr) {
                    putString.putString(charSequence, charset);
                }
                return this;
            }

            public Hasher putUnencodedChars(CharSequence charSequence) {
                for (Hasher putUnencodedChars : hasherArr) {
                    putUnencodedChars.putUnencodedChars(charSequence);
                }
                return this;
            }

            public Hasher putBytes(byte[] bArr) {
                for (Hasher putBytes : hasherArr) {
                    putBytes.putBytes(bArr);
                }
                return this;
            }

            public Hasher putBytes(byte[] bArr, int i11, int i12) {
                for (Hasher putBytes : hasherArr) {
                    putBytes.putBytes(bArr, i11, i12);
                }
                return this;
            }

            public Hasher putBytes(ByteBuffer byteBuffer) {
                int position = byteBuffer.position();
                for (Hasher putBytes : hasherArr) {
                    byteBuffer.position(position);
                    putBytes.putBytes(byteBuffer);
                }
                return this;
            }
        };
    }

    public abstract HashCode makeHash(Hasher[] hasherArr);

    public Hasher newHasher() {
        int length = this.functions.length;
        Hasher[] hasherArr = new Hasher[length];
        for (int i11 = 0; i11 < length; i11++) {
            hasherArr[i11] = this.functions[i11].newHasher();
        }
        return fromHashers(hasherArr);
    }

    public Hasher newHasher(int i11) {
        Preconditions.checkArgument(i11 >= 0);
        int length = this.functions.length;
        Hasher[] hasherArr = new Hasher[length];
        for (int i12 = 0; i12 < length; i12++) {
            hasherArr[i12] = this.functions[i12].newHasher(i11);
        }
        return fromHashers(hasherArr);
    }
}
