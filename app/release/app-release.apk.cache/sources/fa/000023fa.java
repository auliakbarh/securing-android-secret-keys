package kotlin.time;

import kotlin.Metadata;

/* compiled from: TimeSource.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u0015\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u001b\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0003H\u0096\u0002ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\r\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0003H\u0096\u0002ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\f\u0082\u0002\b\n\u0002\b!\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lkotlin/time/TimeMark;", "", "elapsedNow", "Lkotlin/time/Duration;", "elapsedNow-UwyO8pc", "()J", "hasNotPassedNow", "", "hasPassedNow", "minus", "duration", "minus-LRDsOJo", "(J)Lkotlin/time/TimeMark;", "plus", "plus-LRDsOJo", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface TimeMark {
    /* renamed from: elapsedNow-UwyO8pc */
    long mo6470elapsedNowUwyO8pc();

    boolean hasNotPassedNow();

    boolean hasPassedNow();

    /* renamed from: minus-LRDsOJo */
    TimeMark mo6471minusLRDsOJo(long j);

    /* renamed from: plus-LRDsOJo */
    TimeMark mo6473plusLRDsOJo(long j);

    /* compiled from: TimeSource.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        /* renamed from: plus-LRDsOJo  reason: not valid java name */
        public static TimeMark m6618plusLRDsOJo(TimeMark timeMark, long j) {
            return new AdjustedTimeMark(timeMark, j, null);
        }

        /* renamed from: minus-LRDsOJo  reason: not valid java name */
        public static TimeMark m6617minusLRDsOJo(TimeMark timeMark, long j) {
            return timeMark.mo6473plusLRDsOJo(Duration.m6533unaryMinusUwyO8pc(j));
        }

        public static boolean hasPassedNow(TimeMark timeMark) {
            return !Duration.m6513isNegativeimpl(timeMark.mo6470elapsedNowUwyO8pc());
        }

        public static boolean hasNotPassedNow(TimeMark timeMark) {
            return Duration.m6513isNegativeimpl(timeMark.mo6470elapsedNowUwyO8pc());
        }
    }
}