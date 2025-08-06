package com.mob.commons.cc;

import com.google.common.base.Ascii;

public class aa {

    /* renamed from: a  reason: collision with root package name */
    private a f27127a;

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public Number f27128a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public Number f27129b;

        /* renamed from: c  reason: collision with root package name */
        private Number f27130c;

        /* renamed from: d  reason: collision with root package name */
        private Number f27131d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f27132e;

        public a(Number number, Number number2, Number number3) {
            boolean z11 = false;
            int i11 = 1;
            Number[] numberArr = {number, number2, number3};
            int[] iArr = {0, 0, 0};
            for (int i12 = 0; i12 < 3; i12++) {
                Number number4 = numberArr[i12];
                if (number4 != null) {
                    if (number4 instanceof Byte) {
                        iArr[i12] = 1;
                    } else if (number4 instanceof Short) {
                        iArr[i12] = 2;
                    } else if (number4 instanceof Integer) {
                        iArr[i12] = 3;
                    } else if (number4 instanceof Long) {
                        iArr[i12] = 4;
                    } else if (number4 instanceof Float) {
                        iArr[i12] = 5;
                    } else if (number4 instanceof Double) {
                        iArr[i12] = 6;
                    }
                }
            }
            int i13 = 0;
            for (int i14 = 0; i14 < 3; i14++) {
                if (i13 < iArr[i14]) {
                    i13 = iArr[i14];
                }
            }
            if (number != null) {
                switch (i13) {
                    case 1:
                        number = Byte.valueOf(Double.valueOf(String.valueOf(number)).byteValue());
                        break;
                    case 2:
                        number = Short.valueOf(Double.valueOf(String.valueOf(number)).shortValue());
                        break;
                    case 3:
                        number = Integer.valueOf(Double.valueOf(String.valueOf(number)).intValue());
                        break;
                    case 4:
                        number = Long.valueOf(Double.valueOf(String.valueOf(number)).longValue());
                        break;
                    case 5:
                        number = Float.valueOf(Double.valueOf(String.valueOf(number)).floatValue());
                        break;
                    case 6:
                        number = Double.valueOf(String.valueOf(number));
                        break;
                }
            } else {
                number = new Number[]{Integer.MIN_VALUE, Byte.MIN_VALUE, Short.MIN_VALUE, Integer.MIN_VALUE, Long.MIN_VALUE, Float.valueOf(Float.MIN_VALUE), Double.valueOf(Double.MIN_VALUE)}[i13];
            }
            if (number2 != null) {
                switch (i13) {
                    case 1:
                        number2 = Byte.valueOf(Double.valueOf(String.valueOf(number2)).byteValue());
                        break;
                    case 2:
                        number2 = Short.valueOf(Double.valueOf(String.valueOf(number2)).shortValue());
                        break;
                    case 3:
                        number2 = Integer.valueOf(Double.valueOf(String.valueOf(number2)).intValue());
                        break;
                    case 4:
                        number2 = Long.valueOf(Double.valueOf(String.valueOf(number2)).longValue());
                        break;
                    case 5:
                        number2 = Float.valueOf(Double.valueOf(String.valueOf(number2)).floatValue());
                        break;
                    case 6:
                        number2 = Double.valueOf(String.valueOf(number2));
                        break;
                }
            } else {
                number2 = new Number[]{Integer.MAX_VALUE, Byte.valueOf(Ascii.DEL), Short.MAX_VALUE, Integer.MAX_VALUE, Long.MAX_VALUE, Float.valueOf(Float.MAX_VALUE), Double.valueOf(Double.MAX_VALUE)}[i13];
            }
            this.f27128a = number;
            this.f27129b = number2;
            this.f27130c = number3;
            z11 = ((Comparable) number).compareTo(number2) > 0 ? true : z11;
            this.f27132e = z11;
            if (this.f27130c == null) {
                this.f27130c = Integer.valueOf(z11 ? -1 : i11);
            }
        }

        public boolean a() {
            Number number = this.f27131d;
            if (number == null) {
                number = this.f27128a;
            }
            if (this.f27132e) {
                if (((Comparable) number).compareTo(this.f27129b) >= 0) {
                    return true;
                }
                return false;
            } else if (((Comparable) number).compareTo(this.f27129b) <= 0) {
                return true;
            } else {
                return false;
            }
        }

        public Number b() {
            if (this.f27131d == null) {
                this.f27131d = this.f27128a;
            }
            Number number = this.f27131d;
            Number number2 = this.f27130c;
            if (number2 instanceof Double) {
                this.f27131d = Double.valueOf(number.doubleValue() + this.f27130c.doubleValue());
            } else if (number2 instanceof Float) {
                this.f27131d = Float.valueOf(number.floatValue() + this.f27130c.floatValue());
            } else if (number2 instanceof Long) {
                this.f27131d = Long.valueOf(number.longValue() + this.f27130c.longValue());
            } else if (number2 instanceof Integer) {
                this.f27131d = Integer.valueOf(number.intValue() + this.f27130c.intValue());
            } else if (number2 instanceof Short) {
                this.f27131d = Integer.valueOf(number.shortValue() + this.f27130c.shortValue());
            } else {
                this.f27131d = Integer.valueOf(number.byteValue() + this.f27130c.byteValue());
            }
            return number;
        }
    }

    public aa(Number number, Number number2, Number number3) {
        this.f27127a = new a(number, number2, number3);
    }

    public a a() {
        return this.f27127a;
    }

    public boolean b(Number number) {
        return a(number);
    }

    public boolean a(Number number) {
        return ((Comparable) this.f27127a.f27128a).compareTo(number) <= 0 && ((Comparable) this.f27127a.f27129b).compareTo(number) >= 0;
    }

    public Number[] b() {
        return new Number[]{this.f27127a.f27128a, this.f27127a.f27129b};
    }
}
