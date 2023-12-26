package kotlin;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import kotlin.ranges.URangesKt;

/* compiled from: UShort.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\n\n\u0002\b\t\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087@\u0018\u0000 v2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001vB\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\u0097\nø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u0000H\u0087\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0005J\u001b\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u0010J\u001b\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0013J\u001b\u0010\u001b\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b \u0010\u0018J\u001a\u0010!\u001a\u00020\"2\b\u0010\t\u001a\u0004\u0018\u00010#HÖ\u0003¢\u0006\u0004\b$\u0010%J\u001b\u0010&\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\bø\u0001\u0000¢\u0006\u0004\b'\u0010\u0010J\u001b\u0010&\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\bø\u0001\u0000¢\u0006\u0004\b(\u0010\u0013J\u001b\u0010&\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\bø\u0001\u0000¢\u0006\u0004\b)\u0010\u001fJ\u001b\u0010&\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b*\u0010\u0018J\u0010\u0010+\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b,\u0010-J\u0016\u0010.\u001a\u00020\u0000H\u0087\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b/\u0010\u0005J\u0016\u00100\u001a\u00020\u0000H\u0087\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u0010\u0005J\u001b\u00102\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b3\u0010\u0010J\u001b\u00102\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b4\u0010\u0013J\u001b\u00102\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b5\u0010\u001fJ\u001b\u00102\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b6\u0010\u0018J\u001b\u00107\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000eH\u0087\bø\u0001\u0000¢\u0006\u0004\b8\u00109J\u001b\u00107\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\bø\u0001\u0000¢\u0006\u0004\b:\u0010\u0013J\u001b\u00107\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\bø\u0001\u0000¢\u0006\u0004\b;\u0010\u001fJ\u001b\u00107\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b<\u0010\u000bJ\u001b\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b>\u0010\u000bJ\u001b\u0010?\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b@\u0010\u0010J\u001b\u0010?\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\bA\u0010\u0013J\u001b\u0010?\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\bB\u0010\u001fJ\u001b\u0010?\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bC\u0010\u0018J\u001b\u0010D\u001a\u00020E2\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bF\u0010GJ\u001b\u0010H\u001a\u00020E2\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bI\u0010GJ\u001b\u0010J\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\bK\u0010\u0010J\u001b\u0010J\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\bL\u0010\u0013J\u001b\u0010J\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\bM\u0010\u001fJ\u001b\u0010J\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bN\u0010\u0018J\u001b\u0010O\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\bP\u0010\u0010J\u001b\u0010O\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\bQ\u0010\u0013J\u001b\u0010O\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\bR\u0010\u001fJ\u001b\u0010O\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bS\u0010\u0018J\u0010\u0010T\u001a\u00020UH\u0087\b¢\u0006\u0004\bV\u0010WJ\u0010\u0010X\u001a\u00020YH\u0087\b¢\u0006\u0004\bZ\u0010[J\u0010\u0010\\\u001a\u00020]H\u0087\b¢\u0006\u0004\b^\u0010_J\u0010\u0010`\u001a\u00020\rH\u0087\b¢\u0006\u0004\ba\u0010-J\u0010\u0010b\u001a\u00020cH\u0087\b¢\u0006\u0004\bd\u0010eJ\u0010\u0010f\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\bg\u0010\u0005J\u000f\u0010h\u001a\u00020iH\u0016¢\u0006\u0004\bj\u0010kJ\u0016\u0010l\u001a\u00020\u000eH\u0087\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bm\u0010WJ\u0016\u0010n\u001a\u00020\u0011H\u0087\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bo\u0010-J\u0016\u0010p\u001a\u00020\u0014H\u0087\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bq\u0010eJ\u0016\u0010r\u001a\u00020\u0000H\u0087\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bs\u0010\u0005J\u001b\u0010t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\bu\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006w"}, d2 = {"Lkotlin/UShort;", "", "data", "", "constructor-impl", "(S)S", "getData$annotations", "()V", "and", "other", "and-xj2QHRw", "(SS)S", "compareTo", "", "Lkotlin/UByte;", "compareTo-7apg3OU", "(SB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(SI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(SJ)I", "compareTo-xj2QHRw", "(SS)I", "dec", "dec-Mh2AYeg", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(SJ)J", "div-xj2QHRw", "equals", "", "", "equals-impl", "(SLjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", "hashCode", "hashCode-impl", "(S)I", "inc", "inc-Mh2AYeg", "inv", "inv-Mh2AYeg", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod", "mod-7apg3OU", "(SB)B", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "or", "or-xj2QHRw", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-xj2QHRw", "(SS)Lkotlin/ranges/UIntRange;", "rangeUntil", "rangeUntil-xj2QHRw", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(S)B", "toDouble", "", "toDouble-impl", "(S)D", "toFloat", "", "toFloat-impl", "(S)F", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(S)J", "toShort", "toShort-impl", "toString", "", "toString-impl", "(S)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-xj2QHRw", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class UShort implements Comparable<UShort> {
    public static final Companion Companion = new Companion(null);
    public static final short MAX_VALUE = -1;
    public static final short MIN_VALUE = 0;
    public static final int SIZE_BITS = 16;
    public static final int SIZE_BYTES = 2;
    private final short data;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ UShort m5431boximpl(short s) {
        return new UShort(s);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static short m5437constructorimpl(short s) {
        return s;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m5443equalsimpl(short s, Object obj) {
        return (obj instanceof UShort) && s == ((UShort) obj).m5487unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m5444equalsimpl0(short s, short s2) {
        return s == s2;
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m5449hashCodeimpl(short s) {
        return Short.hashCode(s);
    }

    /* renamed from: toByte-impl  reason: not valid java name */
    private static final byte m5475toByteimpl(short s) {
        return (byte) s;
    }

    /* renamed from: toDouble-impl  reason: not valid java name */
    private static final double m5476toDoubleimpl(short s) {
        return s & MAX_VALUE;
    }

    /* renamed from: toFloat-impl  reason: not valid java name */
    private static final float m5477toFloatimpl(short s) {
        return s & MAX_VALUE;
    }

    /* renamed from: toInt-impl  reason: not valid java name */
    private static final int m5478toIntimpl(short s) {
        return s & MAX_VALUE;
    }

    /* renamed from: toLong-impl  reason: not valid java name */
    private static final long m5479toLongimpl(short s) {
        return s & 65535;
    }

    /* renamed from: toShort-impl  reason: not valid java name */
    private static final short m5480toShortimpl(short s) {
        return s;
    }

    /* renamed from: toUShort-Mh2AYeg  reason: not valid java name */
    private static final short m5485toUShortMh2AYeg(short s) {
        return s;
    }

    public boolean equals(Object obj) {
        return m5443equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m5449hashCodeimpl(this.data);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ short m5487unboximpl() {
        return this.data;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UShort uShort) {
        return Intrinsics.compare(m5487unboximpl() & MAX_VALUE, uShort.m5487unboximpl() & MAX_VALUE);
    }

    private /* synthetic */ UShort(short s) {
        this.data = s;
    }

    /* compiled from: UShort.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u0004X\u0086Tø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u0004X\u0086Tø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\n"}, d2 = {"Lkotlin/UShort$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/UShort;", "S", "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* renamed from: compareTo-7apg3OU  reason: not valid java name */
    private static final int m5432compareTo7apg3OU(short s, byte b) {
        return Intrinsics.compare(s & MAX_VALUE, b & UByte.MAX_VALUE);
    }

    /* renamed from: compareTo-xj2QHRw  reason: not valid java name */
    private int m5435compareToxj2QHRw(short s) {
        return Intrinsics.compare(m5487unboximpl() & MAX_VALUE, s & MAX_VALUE);
    }

    /* renamed from: compareTo-xj2QHRw  reason: not valid java name */
    private static int m5436compareToxj2QHRw(short s, short s2) {
        return Intrinsics.compare(s & MAX_VALUE, s2 & MAX_VALUE);
    }

    /* renamed from: compareTo-WZ4Q5Ns  reason: not valid java name */
    private static final int m5434compareToWZ4Q5Ns(short s, int i) {
        int compare;
        compare = Integer.compare(UInt.m5251constructorimpl(s & MAX_VALUE) ^ Integer.MIN_VALUE, i ^ Integer.MIN_VALUE);
        return compare;
    }

    /* renamed from: compareTo-VKZWuLQ  reason: not valid java name */
    private static final int m5433compareToVKZWuLQ(short s, long j) {
        int compare;
        compare = Long.compare(ULong.m5330constructorimpl(s & 65535) ^ Long.MIN_VALUE, j ^ Long.MIN_VALUE);
        return compare;
    }

    /* renamed from: plus-7apg3OU  reason: not valid java name */
    private static final int m5461plus7apg3OU(short s, byte b) {
        return UInt.m5251constructorimpl(UInt.m5251constructorimpl(s & MAX_VALUE) + UInt.m5251constructorimpl(b & UByte.MAX_VALUE));
    }

    /* renamed from: plus-xj2QHRw  reason: not valid java name */
    private static final int m5464plusxj2QHRw(short s, short s2) {
        return UInt.m5251constructorimpl(UInt.m5251constructorimpl(s & MAX_VALUE) + UInt.m5251constructorimpl(s2 & MAX_VALUE));
    }

    /* renamed from: plus-WZ4Q5Ns  reason: not valid java name */
    private static final int m5463plusWZ4Q5Ns(short s, int i) {
        return UInt.m5251constructorimpl(UInt.m5251constructorimpl(s & MAX_VALUE) + i);
    }

    /* renamed from: plus-VKZWuLQ  reason: not valid java name */
    private static final long m5462plusVKZWuLQ(short s, long j) {
        return ULong.m5330constructorimpl(ULong.m5330constructorimpl(s & 65535) + j);
    }

    /* renamed from: minus-7apg3OU  reason: not valid java name */
    private static final int m5452minus7apg3OU(short s, byte b) {
        return UInt.m5251constructorimpl(UInt.m5251constructorimpl(s & MAX_VALUE) - UInt.m5251constructorimpl(b & UByte.MAX_VALUE));
    }

    /* renamed from: minus-xj2QHRw  reason: not valid java name */
    private static final int m5455minusxj2QHRw(short s, short s2) {
        return UInt.m5251constructorimpl(UInt.m5251constructorimpl(s & MAX_VALUE) - UInt.m5251constructorimpl(s2 & MAX_VALUE));
    }

    /* renamed from: minus-WZ4Q5Ns  reason: not valid java name */
    private static final int m5454minusWZ4Q5Ns(short s, int i) {
        return UInt.m5251constructorimpl(UInt.m5251constructorimpl(s & MAX_VALUE) - i);
    }

    /* renamed from: minus-VKZWuLQ  reason: not valid java name */
    private static final long m5453minusVKZWuLQ(short s, long j) {
        return ULong.m5330constructorimpl(ULong.m5330constructorimpl(s & 65535) - j);
    }

    /* renamed from: times-7apg3OU  reason: not valid java name */
    private static final int m5471times7apg3OU(short s, byte b) {
        return UInt.m5251constructorimpl(UInt.m5251constructorimpl(s & MAX_VALUE) * UInt.m5251constructorimpl(b & UByte.MAX_VALUE));
    }

    /* renamed from: times-xj2QHRw  reason: not valid java name */
    private static final int m5474timesxj2QHRw(short s, short s2) {
        return UInt.m5251constructorimpl(UInt.m5251constructorimpl(s & MAX_VALUE) * UInt.m5251constructorimpl(s2 & MAX_VALUE));
    }

    /* renamed from: times-WZ4Q5Ns  reason: not valid java name */
    private static final int m5473timesWZ4Q5Ns(short s, int i) {
        return UInt.m5251constructorimpl(UInt.m5251constructorimpl(s & MAX_VALUE) * i);
    }

    /* renamed from: times-VKZWuLQ  reason: not valid java name */
    private static final long m5472timesVKZWuLQ(short s, long j) {
        return ULong.m5330constructorimpl(ULong.m5330constructorimpl(s & 65535) * j);
    }

    /* renamed from: div-7apg3OU  reason: not valid java name */
    private static final int m5439div7apg3OU(short s, byte b) {
        return UByte$$ExternalSyntheticBackport0.m$1(UInt.m5251constructorimpl(s & MAX_VALUE), UInt.m5251constructorimpl(b & UByte.MAX_VALUE));
    }

    /* renamed from: div-xj2QHRw  reason: not valid java name */
    private static final int m5442divxj2QHRw(short s, short s2) {
        return UByte$$ExternalSyntheticBackport0.m$1(UInt.m5251constructorimpl(s & MAX_VALUE), UInt.m5251constructorimpl(s2 & MAX_VALUE));
    }

    /* renamed from: div-WZ4Q5Ns  reason: not valid java name */
    private static final int m5441divWZ4Q5Ns(short s, int i) {
        return UByte$$ExternalSyntheticBackport0.m$1(UInt.m5251constructorimpl(s & MAX_VALUE), i);
    }

    /* renamed from: div-VKZWuLQ  reason: not valid java name */
    private static final long m5440divVKZWuLQ(short s, long j) {
        return UByte$$ExternalSyntheticBackport0.m$1(ULong.m5330constructorimpl(s & 65535), j);
    }

    /* renamed from: rem-7apg3OU  reason: not valid java name */
    private static final int m5467rem7apg3OU(short s, byte b) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m5251constructorimpl(s & MAX_VALUE), UInt.m5251constructorimpl(b & UByte.MAX_VALUE));
    }

    /* renamed from: rem-xj2QHRw  reason: not valid java name */
    private static final int m5470remxj2QHRw(short s, short s2) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m5251constructorimpl(s & MAX_VALUE), UInt.m5251constructorimpl(s2 & MAX_VALUE));
    }

    /* renamed from: rem-WZ4Q5Ns  reason: not valid java name */
    private static final int m5469remWZ4Q5Ns(short s, int i) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m5251constructorimpl(s & MAX_VALUE), i);
    }

    /* renamed from: rem-VKZWuLQ  reason: not valid java name */
    private static final long m5468remVKZWuLQ(short s, long j) {
        return UByte$$ExternalSyntheticBackport0.m5224m(ULong.m5330constructorimpl(s & 65535), j);
    }

    /* renamed from: floorDiv-7apg3OU  reason: not valid java name */
    private static final int m5445floorDiv7apg3OU(short s, byte b) {
        return UByte$$ExternalSyntheticBackport0.m$1(UInt.m5251constructorimpl(s & MAX_VALUE), UInt.m5251constructorimpl(b & UByte.MAX_VALUE));
    }

    /* renamed from: floorDiv-xj2QHRw  reason: not valid java name */
    private static final int m5448floorDivxj2QHRw(short s, short s2) {
        return UByte$$ExternalSyntheticBackport0.m$1(UInt.m5251constructorimpl(s & MAX_VALUE), UInt.m5251constructorimpl(s2 & MAX_VALUE));
    }

    /* renamed from: floorDiv-WZ4Q5Ns  reason: not valid java name */
    private static final int m5447floorDivWZ4Q5Ns(short s, int i) {
        return UByte$$ExternalSyntheticBackport0.m$1(UInt.m5251constructorimpl(s & MAX_VALUE), i);
    }

    /* renamed from: floorDiv-VKZWuLQ  reason: not valid java name */
    private static final long m5446floorDivVKZWuLQ(short s, long j) {
        return UByte$$ExternalSyntheticBackport0.m$1(ULong.m5330constructorimpl(s & 65535), j);
    }

    /* renamed from: mod-7apg3OU  reason: not valid java name */
    private static final byte m5456mod7apg3OU(short s, byte b) {
        return UByte.m5173constructorimpl((byte) UByte$$ExternalSyntheticBackport0.m(UInt.m5251constructorimpl(s & MAX_VALUE), UInt.m5251constructorimpl(b & UByte.MAX_VALUE)));
    }

    /* renamed from: mod-xj2QHRw  reason: not valid java name */
    private static final short m5459modxj2QHRw(short s, short s2) {
        return m5437constructorimpl((short) UByte$$ExternalSyntheticBackport0.m(UInt.m5251constructorimpl(s & MAX_VALUE), UInt.m5251constructorimpl(s2 & MAX_VALUE)));
    }

    /* renamed from: mod-WZ4Q5Ns  reason: not valid java name */
    private static final int m5458modWZ4Q5Ns(short s, int i) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m5251constructorimpl(s & MAX_VALUE), i);
    }

    /* renamed from: mod-VKZWuLQ  reason: not valid java name */
    private static final long m5457modVKZWuLQ(short s, long j) {
        return UByte$$ExternalSyntheticBackport0.m5224m(ULong.m5330constructorimpl(s & 65535), j);
    }

    /* renamed from: inc-Mh2AYeg  reason: not valid java name */
    private static final short m5450incMh2AYeg(short s) {
        return m5437constructorimpl((short) (s + 1));
    }

    /* renamed from: dec-Mh2AYeg  reason: not valid java name */
    private static final short m5438decMh2AYeg(short s) {
        return m5437constructorimpl((short) (s - 1));
    }

    /* renamed from: rangeTo-xj2QHRw  reason: not valid java name */
    private static final UIntRange m5465rangeToxj2QHRw(short s, short s2) {
        return new UIntRange(UInt.m5251constructorimpl(s & MAX_VALUE), UInt.m5251constructorimpl(s2 & MAX_VALUE), null);
    }

    /* renamed from: rangeUntil-xj2QHRw  reason: not valid java name */
    private static final UIntRange m5466rangeUntilxj2QHRw(short s, short s2) {
        return URangesKt.m6424untilJ1ME1BU(UInt.m5251constructorimpl(s & MAX_VALUE), UInt.m5251constructorimpl(s2 & MAX_VALUE));
    }

    /* renamed from: and-xj2QHRw  reason: not valid java name */
    private static final short m5430andxj2QHRw(short s, short s2) {
        return m5437constructorimpl((short) (s & s2));
    }

    /* renamed from: or-xj2QHRw  reason: not valid java name */
    private static final short m5460orxj2QHRw(short s, short s2) {
        return m5437constructorimpl((short) (s | s2));
    }

    /* renamed from: xor-xj2QHRw  reason: not valid java name */
    private static final short m5486xorxj2QHRw(short s, short s2) {
        return m5437constructorimpl((short) (s ^ s2));
    }

    /* renamed from: inv-Mh2AYeg  reason: not valid java name */
    private static final short m5451invMh2AYeg(short s) {
        return m5437constructorimpl((short) (~s));
    }

    /* renamed from: toUByte-w2LRezQ  reason: not valid java name */
    private static final byte m5482toUBytew2LRezQ(short s) {
        return UByte.m5173constructorimpl((byte) s);
    }

    /* renamed from: toUInt-pVg5ArA  reason: not valid java name */
    private static final int m5483toUIntpVg5ArA(short s) {
        return UInt.m5251constructorimpl(s & MAX_VALUE);
    }

    /* renamed from: toULong-s-VKNKU  reason: not valid java name */
    private static final long m5484toULongsVKNKU(short s) {
        return ULong.m5330constructorimpl(s & 65535);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m5481toStringimpl(short s) {
        return String.valueOf(s & MAX_VALUE);
    }

    public String toString() {
        return m5481toStringimpl(this.data);
    }
}