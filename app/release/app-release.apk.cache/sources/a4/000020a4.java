package kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* compiled from: UnsignedUtils.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u001a\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003H\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0001\u001a\"\u0010\f\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\"\u0010\u000f\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u000e\u001a\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\tH\u0001\u001a\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u0013H\u0001\u001a\"\u0010\u0014\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\"\u0010\u0017\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0016\u001a\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0013H\u0001\u001a\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u0013H\u0000\u001a\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\tH\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"doubleToUInt", "Lkotlin/UInt;", "v", "", "(D)I", "doubleToULong", "Lkotlin/ULong;", "(D)J", "uintCompare", "", "v1", "v2", "uintDivide", "uintDivide-J1ME1BU", "(II)I", "uintRemainder", "uintRemainder-J1ME1BU", "uintToDouble", "ulongCompare", "", "ulongDivide", "ulongDivide-eb3DHEI", "(JJ)J", "ulongRemainder", "ulongRemainder-eb3DHEI", "ulongToDouble", "ulongToString", "", "base", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class UnsignedKt {
    public static final double uintToDouble(int i) {
        return (Integer.MAX_VALUE & i) + (((i >>> 31) << 30) * 2);
    }

    public static final double ulongToDouble(long j) {
        return ((j >>> 11) * 2048) + (j & 2047);
    }

    public static final int uintCompare(int i, int i2) {
        return Intrinsics.compare(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE);
    }

    public static final int ulongCompare(long j, long j2) {
        return Intrinsics.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
    }

    /* renamed from: uintDivide-J1ME1BU  reason: not valid java name */
    public static final int m5510uintDivideJ1ME1BU(int i, int i2) {
        return UInt.m5254constructorimpl((int) ((i & 4294967295L) / (i2 & 4294967295L)));
    }

    /* renamed from: uintRemainder-J1ME1BU  reason: not valid java name */
    public static final int m5511uintRemainderJ1ME1BU(int i, int i2) {
        return UInt.m5254constructorimpl((int) ((i & 4294967295L) % (i2 & 4294967295L)));
    }

    /* renamed from: ulongDivide-eb3DHEI  reason: not valid java name */
    public static final long m5512ulongDivideeb3DHEI(long j, long j2) {
        int compare;
        int compare2;
        if (j2 < 0) {
            compare2 = Long.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
            return compare2 < 0 ? ULong.m5333constructorimpl(0L) : ULong.m5333constructorimpl(1L);
        } else if (j >= 0) {
            return ULong.m5333constructorimpl(j / j2);
        } else {
            long j3 = ((j >>> 1) / j2) << 1;
            compare = Long.compare(ULong.m5333constructorimpl(j - (j3 * j2)) ^ Long.MIN_VALUE, ULong.m5333constructorimpl(j2) ^ Long.MIN_VALUE);
            return ULong.m5333constructorimpl(j3 + (compare < 0 ? 0 : 1));
        }
    }

    /* renamed from: ulongRemainder-eb3DHEI  reason: not valid java name */
    public static final long m5513ulongRemaindereb3DHEI(long j, long j2) {
        int compare;
        int compare2;
        if (j2 < 0) {
            compare2 = Long.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
            return compare2 < 0 ? j : ULong.m5333constructorimpl(j - j2);
        } else if (j >= 0) {
            return ULong.m5333constructorimpl(j % j2);
        } else {
            long j3 = j - ((((j >>> 1) / j2) << 1) * j2);
            compare = Long.compare(ULong.m5333constructorimpl(j3) ^ Long.MIN_VALUE, ULong.m5333constructorimpl(j2) ^ Long.MIN_VALUE);
            if (compare < 0) {
                j2 = 0;
            }
            return ULong.m5333constructorimpl(j3 - j2);
        }
    }

    public static final int doubleToUInt(double d) {
        if (!Double.isNaN(d) && d > uintToDouble(0)) {
            if (d >= uintToDouble(-1)) {
                return -1;
            }
            if (d <= 2.147483647E9d) {
                return UInt.m5254constructorimpl((int) d);
            }
            return UInt.m5254constructorimpl(UInt.m5254constructorimpl((int) (d - Integer.MAX_VALUE)) + UInt.m5254constructorimpl(Integer.MAX_VALUE));
        }
        return 0;
    }

    public static final long doubleToULong(double d) {
        if (!Double.isNaN(d) && d > ulongToDouble(0L)) {
            if (d >= ulongToDouble(-1L)) {
                return -1L;
            }
            if (d < 9.223372036854776E18d) {
                return ULong.m5333constructorimpl((long) d);
            }
            return ULong.m5333constructorimpl(ULong.m5333constructorimpl((long) (d - 9.223372036854776E18d)) - Long.MIN_VALUE);
        }
        return 0L;
    }

    public static final String ulongToString(long j) {
        return ulongToString(j, 10);
    }

    public static final String ulongToString(long j, int i) {
        if (j >= 0) {
            String l = Long.toString(j, CharsKt.checkRadix(i));
            Intrinsics.checkNotNullExpressionValue(l, "toString(this, checkRadix(radix))");
            return l;
        }
        long j2 = i;
        long j3 = ((j >>> 1) / j2) << 1;
        long j4 = j - (j3 * j2);
        if (j4 >= j2) {
            j4 -= j2;
            j3++;
        }
        StringBuilder sb = new StringBuilder();
        String l2 = Long.toString(j3, CharsKt.checkRadix(i));
        Intrinsics.checkNotNullExpressionValue(l2, "toString(this, checkRadix(radix))");
        StringBuilder append = sb.append(l2);
        String l3 = Long.toString(j4, CharsKt.checkRadix(i));
        Intrinsics.checkNotNullExpressionValue(l3, "toString(this, checkRadix(radix))");
        return append.append(l3).toString();
    }
}