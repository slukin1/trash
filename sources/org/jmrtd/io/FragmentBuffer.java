package org.jmrtd.io;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class FragmentBuffer implements Serializable {
    private static final int DEFAULT_SIZE = 2000;
    private static final long serialVersionUID = -3510872461790499721L;
    private byte[] buffer;
    private Collection<Fragment> fragments;

    public static class Fragment implements Serializable {
        private static final long serialVersionUID = -3795931618553980328L;
        /* access modifiers changed from: private */
        public int length;
        /* access modifiers changed from: private */
        public int offset;

        private Fragment(int i11, int i12) {
            this.offset = i11;
            this.length = i12;
        }

        public static Fragment getInstance(int i11, int i12) {
            return new Fragment(i11, i12);
        }

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            if (!obj.getClass().equals(Fragment.class)) {
                return false;
            }
            Fragment fragment = (Fragment) obj;
            if (fragment.offset == this.offset && fragment.length == this.length) {
                return true;
            }
            return false;
        }

        public int getLength() {
            return this.length;
        }

        public int getOffset() {
            return this.offset;
        }

        public int hashCode() {
            return (this.offset * 2) + (this.length * 3) + 5;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[");
            sb2.append(this.offset);
            sb2.append(" .. ");
            sb2.append((this.offset + this.length) - 1);
            sb2.append(" (");
            sb2.append(this.length);
            sb2.append(")]");
            return sb2.toString();
        }
    }

    public FragmentBuffer() {
        this(2000);
    }

    private void setLength(int i11) {
        synchronized (this) {
            byte[] bArr = this.buffer;
            if (i11 > bArr.length) {
                byte[] bArr2 = new byte[i11];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                this.buffer = bArr2;
            }
        }
    }

    public synchronized void addFragment(int i11, byte b11) {
        addFragment(i11, new byte[]{b11});
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0053, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            if (r6 != 0) goto L_0x0006
            monitor-exit(r5)
            return r0
        L_0x0006:
            r1 = 1
            if (r6 != r5) goto L_0x000b
            monitor-exit(r5)
            return r1
        L_0x000b:
            java.lang.Class r2 = r6.getClass()     // Catch:{ all -> 0x0054 }
            java.lang.Class<org.jmrtd.io.FragmentBuffer> r3 = org.jmrtd.io.FragmentBuffer.class
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0054 }
            if (r2 != 0) goto L_0x0019
            monitor-exit(r5)
            return r0
        L_0x0019:
            org.jmrtd.io.FragmentBuffer r6 = (org.jmrtd.io.FragmentBuffer) r6     // Catch:{ all -> 0x0054 }
            byte[] r2 = r6.buffer     // Catch:{ all -> 0x0054 }
            if (r2 != 0) goto L_0x0025
            byte[] r3 = r5.buffer     // Catch:{ all -> 0x0054 }
            if (r3 == 0) goto L_0x0025
            monitor-exit(r5)
            return r0
        L_0x0025:
            if (r2 == 0) goto L_0x002d
            byte[] r3 = r5.buffer     // Catch:{ all -> 0x0054 }
            if (r3 != 0) goto L_0x002d
            monitor-exit(r5)
            return r0
        L_0x002d:
            java.util.Collection<org.jmrtd.io.FragmentBuffer$Fragment> r3 = r6.fragments     // Catch:{ all -> 0x0054 }
            if (r3 != 0) goto L_0x0037
            java.util.Collection<org.jmrtd.io.FragmentBuffer$Fragment> r4 = r5.fragments     // Catch:{ all -> 0x0054 }
            if (r4 == 0) goto L_0x0037
            monitor-exit(r5)
            return r0
        L_0x0037:
            if (r3 == 0) goto L_0x003f
            java.util.Collection<org.jmrtd.io.FragmentBuffer$Fragment> r3 = r5.fragments     // Catch:{ all -> 0x0054 }
            if (r3 != 0) goto L_0x003f
            monitor-exit(r5)
            return r0
        L_0x003f:
            byte[] r3 = r5.buffer     // Catch:{ all -> 0x0054 }
            boolean r2 = java.util.Arrays.equals(r2, r3)     // Catch:{ all -> 0x0054 }
            if (r2 == 0) goto L_0x0052
            java.util.Collection<org.jmrtd.io.FragmentBuffer$Fragment> r6 = r6.fragments     // Catch:{ all -> 0x0054 }
            java.util.Collection<org.jmrtd.io.FragmentBuffer$Fragment> r2 = r5.fragments     // Catch:{ all -> 0x0054 }
            boolean r6 = r6.equals(r2)     // Catch:{ all -> 0x0054 }
            if (r6 == 0) goto L_0x0052
            r0 = r1
        L_0x0052:
            monitor-exit(r5)
            return r0
        L_0x0054:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jmrtd.io.FragmentBuffer.equals(java.lang.Object):boolean");
    }

    public byte[] getBuffer() {
        return this.buffer;
    }

    public synchronized int getBufferedLength(int i11) {
        int i12;
        int i13 = 0;
        if (i11 >= this.buffer.length) {
            return 0;
        }
        for (Fragment next : this.fragments) {
            int offset = next.getOffset();
            int offset2 = next.getOffset() + next.getLength();
            if (offset <= i11 && i11 < offset2 && (i12 = offset2 - i11) > i13) {
                i13 = i12;
            }
        }
        return i13;
    }

    public synchronized int getBytesBuffered() {
        int i11;
        i11 = 0;
        for (int i12 = 0; i12 < this.buffer.length; i12++) {
            if (isCoveredByFragment(i12)) {
                i11++;
            }
        }
        return i11;
    }

    public Collection<Fragment> getFragments() {
        return this.fragments;
    }

    public int getLength() {
        int length;
        synchronized (this) {
            length = this.buffer.length;
        }
        return length;
    }

    public synchronized int getPosition() {
        int i11;
        i11 = 0;
        for (int i12 = 0; i12 < this.buffer.length; i12++) {
            if (isCoveredByFragment(i12)) {
                i11 = i12 + 1;
            }
        }
        return i11;
    }

    public synchronized Fragment getSmallestUnbufferedFragment(int i11, int i12) {
        int i13;
        Iterator<Fragment> it2 = this.fragments.iterator();
        i13 = i11;
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Fragment next = it2.next();
            if (next.getOffset() <= i13 && i13 + i12 <= next.getOffset() + next.getLength()) {
                i12 = 0;
                break;
            } else if (next.getOffset() <= i13 && i13 < next.getOffset() + next.getLength()) {
                int offset = next.getOffset() + next.getLength();
                i12 = (i13 + i12) - offset;
                i13 = offset;
            } else if (i13 > next.getOffset() || next.getOffset() + next.getLength() > i13 + i12) {
                if (i11 <= next.getOffset() && next.getOffset() < i13 + i12) {
                    i12 = next.getOffset() - i13;
                }
            }
        }
        return Fragment.getInstance(i13, i12);
    }

    public int hashCode() {
        return (Arrays.hashCode(this.buffer) * 3) + (this.fragments.hashCode() * 2) + 7;
    }

    public synchronized boolean isCoveredByFragment(int i11) {
        return isCoveredByFragment(i11, 1);
    }

    public synchronized String toString() {
        return "FragmentBuffer [" + this.buffer.length + ", " + this.fragments + "]";
    }

    public synchronized void updateFrom(FragmentBuffer fragmentBuffer) {
        for (Fragment next : fragmentBuffer.fragments) {
            addFragment(next.offset, fragmentBuffer.buffer, next.offset, next.length);
        }
    }

    public FragmentBuffer(int i11) {
        this.buffer = new byte[i11];
        this.fragments = new HashSet();
    }

    public synchronized boolean isCoveredByFragment(int i11, int i12) {
        for (Fragment next : this.fragments) {
            int offset = next.getOffset();
            int offset2 = next.getOffset() + next.getLength();
            if (offset <= i11 && i11 + i12 <= offset2) {
                return true;
            }
        }
        return false;
    }

    public synchronized void addFragment(int i11, byte[] bArr) {
        addFragment(i11, bArr, 0, bArr.length);
    }

    public synchronized void addFragment(int i11, byte[] bArr, int i12, int i13) {
        int i14 = i11 + i13;
        byte[] bArr2 = this.buffer;
        if (i14 > bArr2.length) {
            setLength(Math.max(i14, bArr2.length) * 2);
        }
        System.arraycopy(bArr, i12, this.buffer, i11, i13);
        for (Fragment fragment : new ArrayList(this.fragments)) {
            if (fragment.getOffset() <= i11 && i11 + i13 <= fragment.getOffset() + fragment.getLength()) {
                return;
            }
            if (fragment.getOffset() <= i11 && i11 <= fragment.getOffset() + fragment.getLength()) {
                int offset = (i11 + i13) - fragment.getOffset();
                int offset2 = fragment.getOffset();
                this.fragments.remove(fragment);
                int i15 = offset2;
                i13 = offset;
                i11 = i15;
            } else if (i11 <= fragment.getOffset() && fragment.getOffset() + fragment.getLength() <= i11 + i13) {
                this.fragments.remove(fragment);
            } else if (i11 <= fragment.getOffset() && fragment.getOffset() <= i11 + i13) {
                i13 = (fragment.getOffset() + fragment.getLength()) - i11;
                this.fragments.remove(fragment);
            }
        }
        this.fragments.add(Fragment.getInstance(i11, i13));
    }
}
