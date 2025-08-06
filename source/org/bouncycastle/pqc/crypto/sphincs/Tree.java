package org.bouncycastle.pqc.crypto.sphincs;

class Tree {

    public static class leafaddr {
        public int level;
        public long subleaf;
        public long subtree;

        public leafaddr() {
        }

        public leafaddr(leafaddr leafaddr) {
            this.level = leafaddr.level;
            this.subtree = leafaddr.subtree;
            this.subleaf = leafaddr.subleaf;
        }
    }

    public static void gen_leaf_wots(HashFunctions hashFunctions, byte[] bArr, int i11, byte[] bArr2, int i12, byte[] bArr3, leafaddr leafaddr2) {
        byte[] bArr4 = new byte[32];
        byte[] bArr5 = new byte[Wots.WOTS_SIGBYTES];
        Wots wots = new Wots();
        HashFunctions hashFunctions2 = hashFunctions;
        Seed.get_seed(hashFunctions, bArr4, 0, bArr3, leafaddr2);
        wots.wots_pkgen(hashFunctions, bArr5, 0, bArr4, 0, bArr2, i12);
        l_tree(hashFunctions, bArr, i11, bArr5, 0, bArr2, i12);
    }

    public static void l_tree(HashFunctions hashFunctions, byte[] bArr, int i11, byte[] bArr2, int i12, byte[] bArr3, int i13) {
        int i14;
        byte[] bArr4 = bArr2;
        int i15 = i12;
        int i16 = 67;
        for (int i17 = 0; i17 < 7; i17++) {
            int i18 = 0;
            while (true) {
                i14 = i16 >>> 1;
                if (i18 >= i14) {
                    break;
                }
                hashFunctions.hash_2n_n_mask(bArr2, i15 + (i18 * 32), bArr2, i15 + (i18 * 2 * 32), bArr3, i13 + (i17 * 2 * 32));
                i18++;
            }
            if ((i16 & 1) != 0) {
                System.arraycopy(bArr4, i15 + ((i16 - 1) * 32), bArr4, (i14 * 32) + i15, 32);
                i14++;
            }
            i16 = i14;
        }
        byte[] bArr5 = bArr;
        System.arraycopy(bArr4, i15, bArr, i11, 32);
    }

    public static void treehash(HashFunctions hashFunctions, byte[] bArr, int i11, int i12, byte[] bArr2, leafaddr leafaddr2, byte[] bArr3, int i13) {
        leafaddr leafaddr3 = new leafaddr(leafaddr2);
        int i14 = i12 + 1;
        byte[] bArr4 = new byte[(i14 * 32)];
        int[] iArr = new int[i14];
        int i15 = 1;
        int i16 = (int) (leafaddr3.subleaf + ((long) (1 << i12)));
        int i17 = 0;
        while (true) {
            int i18 = 32;
            if (leafaddr3.subleaf >= ((long) i16)) {
                break;
            }
            gen_leaf_wots(hashFunctions, bArr4, i17 * 32, bArr3, i13, bArr2, leafaddr3);
            iArr[i17] = 0;
            int i19 = i17 + i15;
            while (i19 > i15) {
                int i21 = i19 - 1;
                int i22 = i19 - 2;
                if (iArr[i21] != iArr[i22]) {
                    break;
                }
                int i23 = i22 * 32;
                int i24 = i16;
                int i25 = i23;
                int i26 = i15;
                int[] iArr2 = iArr;
                hashFunctions.hash_2n_n_mask(bArr4, i23, bArr4, i25, bArr3, i13 + ((iArr[i21] + 7) * 2 * i18));
                iArr2[i22] = iArr2[i22] + i26;
                i19--;
                i15 = i26;
                i18 = i18;
                i16 = i24;
                iArr = iArr2;
            }
            leafaddr3.subleaf++;
            i17 = i19;
            i15 = i15;
            i16 = i16;
            iArr = iArr;
        }
        for (int i27 = 0; i27 < 32; i27++) {
            bArr[i11 + i27] = bArr4[i27];
        }
    }
}
