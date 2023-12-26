package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.material3.tokens.TimePickerTokens;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntOffset;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TimePicker.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u001d\b\u0007\u0018\u0000 c2\u00020\u0001:\u0001cB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010F\u001a\u00020GH\u0080@ø\u0001\u0000¢\u0006\u0004\bH\u0010IJ\u0010\u0010 \u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003H\u0002J\u0015\u0010J\u001a\u00020\u00062\u0006\u0010K\u001a\u00020\u0003H\u0000¢\u0006\u0002\bLJ%\u0010M\u001a\u00020G2\u0006\u0010N\u001a\u00020\u00132\u0006\u0010O\u001a\u00020\u00132\u0006\u0010P\u001a\u00020\u0013H\u0000¢\u0006\u0002\bQJ\u0010\u0010R\u001a\u00020\u00132\u0006\u0010S\u001a\u00020\u0013H\u0002J3\u0010T\u001a\u00020G2\u0006\u0010N\u001a\u00020\u00132\u0006\u0010O\u001a\u00020\u00132\u0006\u0010P\u001a\u00020\u00132\u0006\u0010U\u001a\u00020\u0006H\u0080@ø\u0001\u0000¢\u0006\u0004\bV\u0010WJ\u0015\u0010X\u001a\u00020G2\u0006\u0010\u0017\u001a\u00020\u0003H\u0000¢\u0006\u0002\bYJ\u0015\u0010Z\u001a\u00020G2\u0006\u00100\u001a\u00020\u0003H\u0000¢\u0006\u0002\b[J\u0011\u0010\\\u001a\u00020GH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010IJ%\u0010]\u001a\u00020G2\u0006\u0010K\u001a\u00020\u00132\b\b\u0002\u0010^\u001a\u00020\u0006H\u0080@ø\u0001\u0000¢\u0006\u0004\b_\u0010`J\f\u0010a\u001a\u00020\u0003*\u00020\u0013H\u0002J\f\u0010b\u001a\u00020\u0003*\u00020\u0013H\u0002R4\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8@@@X\u0080\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R+\u0010\u001a\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u00138@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010\u0010\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0019R\u0011\u0010\"\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001b\u0010$\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b$\u0010#R+\u0010'\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00068@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b+\u0010\u0010\u001a\u0004\b(\u0010#\"\u0004\b)\u0010*R+\u0010,\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00068@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b/\u0010\u0010\u001a\u0004\b-\u0010#\"\u0004\b.\u0010*R\u0011\u00100\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b1\u0010\u0019R+\u00102\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u00138@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b5\u0010\u0010\u001a\u0004\b3\u0010\u001c\"\u0004\b4\u0010\u001eR\u000e\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000R4\u00109\u001a\u0002082\u0006\u0010\b\u001a\u0002088@@@X\u0080\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b=\u0010\u0010\u001a\u0004\b:\u0010\u0019\"\u0004\b;\u0010<R$\u0010>\u001a\u00020?8@X\u0080\u0084\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\n\u0004\bA\u0010&\u001a\u0004\b@\u0010\fR\u001a\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00030C8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bD\u0010E\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006d"}, d2 = {"Landroidx/compose/material3/TimePickerState;", "", "initialHour", "", "initialMinute", "is24Hour", "", "(IIZ)V", "<set-?>", "Landroidx/compose/ui/unit/IntOffset;", "center", "getCenter-nOcc-ac$material3_release", "()J", "setCenter--gyyYBs$material3_release", "(J)V", "center$delegate", "Landroidx/compose/runtime/MutableState;", "currentAngle", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "getCurrentAngle$material3_release", "()Landroidx/compose/animation/core/Animatable;", "hour", "getHour", "()I", "hourAngle", "getHourAngle$material3_release", "()F", "setHourAngle$material3_release", "(F)V", "hourAngle$delegate", "hourForDisplay", "getHourForDisplay$material3_release", "is24hour", "()Z", "isAfternoon", "isAfternoon$delegate", "Landroidx/compose/runtime/State;", "isAfternoonToggle", "isAfternoonToggle$material3_release", "setAfternoonToggle$material3_release", "(Z)V", "isAfternoonToggle$delegate", "isInnerCircle", "isInnerCircle$material3_release", "setInnerCircle$material3_release", "isInnerCircle$delegate", "minute", "getMinute", "minuteAngle", "getMinuteAngle$material3_release", "setMinuteAngle$material3_release", "minuteAngle$delegate", "mutex", "Landroidx/compose/foundation/MutatorMutex;", "Landroidx/compose/material3/Selection;", "selection", "getSelection-JiIwxys$material3_release", "setSelection-iHAOin8$material3_release", "(I)V", "selection$delegate", "selectorPos", "Landroidx/compose/ui/unit/DpOffset;", "getSelectorPos-RKDOV3M$material3_release", "selectorPos$delegate", "values", "", "getValues$material3_release", "()Ljava/util/List;", "animateToCurrent", "", "animateToCurrent$material3_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isSelected", "value", "isSelected$material3_release", "moveSelector", "x", "y", "maxDist", "moveSelector$material3_release", "offsetHour", "angle", "onTap", "autoSwitchToMinute", "onTap$material3_release", "(FFFZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setHour", "setHour$material3_release", "setMinute", "setMinute$material3_release", "settle", "update", "fromTap", "update$material3_release", "(FZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toHour", "toMinute", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TimePickerState {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final MutableState center$delegate;
    private final Animatable<Float, AnimationVector1D> currentAngle;
    private final MutableState hourAngle$delegate;
    private final boolean is24hour;
    private final State isAfternoon$delegate;
    private final MutableState isAfternoonToggle$delegate;
    private final MutableState isInnerCircle$delegate;
    private final MutableState minuteAngle$delegate;
    private final MutatorMutex mutex;
    private final MutableState selection$delegate;
    private final State selectorPos$delegate;

    /* JADX INFO: Access modifiers changed from: private */
    public final float offsetHour(float f) {
        float f2 = f + 1.5707964f;
        return f2 < 0.0f ? f2 + 6.2831855f : f2;
    }

    public final Animatable<Float, AnimationVector1D> getCurrentAngle$material3_release() {
        return this.currentAngle;
    }

    public final boolean is24hour() {
        return this.is24hour;
    }

    public TimePickerState(int i, int i2, final boolean z) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        MutableState mutableStateOf$default4;
        MutableState mutableStateOf$default5;
        MutableState mutableStateOf$default6;
        if (i < 0 || i >= 24) {
            throw new IllegalArgumentException("initialHour should in [0..23] range".toString());
        }
        if (i < 0 || i >= 60) {
            throw new IllegalArgumentException("initialMinute should be in [0..59] range".toString());
        }
        this.is24hour = z;
        this.selectorPos$delegate = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0<DpOffset>() { // from class: androidx.compose.material3.TimePickerState$selectorPos$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ DpOffset invoke() {
                return DpOffset.m4927boximpl(m1595invokeRKDOV3M());
            }

            /* renamed from: invoke-RKDOV3M  reason: not valid java name */
            public final long m1595invokeRKDOV3M() {
                float f;
                boolean isInnerCircle$material3_release = TimePickerState.this.isInnerCircle$material3_release();
                float f2 = 2;
                float m4872constructorimpl = Dp.m4872constructorimpl(TimePickerTokens.INSTANCE.m2161getClockDialSelectorHandleContainerSizeD9Ej5fM() / f2);
                if (z && isInnerCircle$material3_release && Selection.m1374equalsimpl0(TimePickerState.this.m1591getSelectionJiIwxys$material3_release(), Selection.Companion.m1378getHourJiIwxys())) {
                    f = TimePickerKt.InnerCircleRadius;
                } else {
                    f = TimePickerKt.OuterCircleSizeRadius;
                }
                float m4872constructorimpl2 = Dp.m4872constructorimpl(Dp.m4872constructorimpl(f - m4872constructorimpl) + m4872constructorimpl);
                return DpKt.m4893DpOffsetYgX7TsA(Dp.m4872constructorimpl(Dp.m4872constructorimpl(((float) Math.cos(TimePickerState.this.getCurrentAngle$material3_release().getValue().floatValue())) * m4872constructorimpl2) + Dp.m4872constructorimpl(TimePickerTokens.INSTANCE.m2159getClockDialContainerSizeD9Ej5fM() / f2)), Dp.m4872constructorimpl(Dp.m4872constructorimpl(m4872constructorimpl2 * ((float) Math.sin(TimePickerState.this.getCurrentAngle$material3_release().getValue().floatValue()))) + Dp.m4872constructorimpl(TimePickerTokens.INSTANCE.m2159getClockDialContainerSizeD9Ej5fM() / f2)));
            }
        });
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntOffset.m4981boximpl(IntOffset.Companion.m5000getZeronOccac()), null, 2, null);
        this.center$delegate = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Selection.m1371boximpl(Selection.Companion.m1378getHourJiIwxys()), null, 2, null);
        this.selection$delegate = mutableStateOf$default2;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(i > 12 && !z), null, 2, null);
        this.isAfternoonToggle$delegate = mutableStateOf$default3;
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(i >= 12), null, 2, null);
        this.isInnerCircle$delegate = mutableStateOf$default4;
        mutableStateOf$default5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(((i * 0.5235988f) % 12) - 1.5707964f), null, 2, null);
        this.hourAngle$delegate = mutableStateOf$default5;
        mutableStateOf$default6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf((i2 * 0.10471976f) - 1.5707964f), null, 2, null);
        this.minuteAngle$delegate = mutableStateOf$default6;
        this.mutex = new MutatorMutex();
        this.isAfternoon$delegate = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: androidx.compose.material3.TimePickerState$isAfternoon$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf((TimePickerState.this.is24hour() && TimePickerState.this.isInnerCircle$material3_release()) || TimePickerState.this.isAfternoonToggle$material3_release());
            }
        });
        this.currentAngle = AnimatableKt.Animatable$default(getHourAngle$material3_release(), 0.0f, 2, null);
    }

    public final int getMinute() {
        return toMinute(getMinuteAngle$material3_release());
    }

    public final int getHour() {
        return toHour(getHourAngle$material3_release()) + (isAfternoon() ? 12 : 0);
    }

    public final int getHourForDisplay$material3_release() {
        return hourForDisplay(getHour());
    }

    /* renamed from: getCenter-nOcc-ac$material3_release  reason: not valid java name */
    public final long m1590getCenternOccac$material3_release() {
        return ((IntOffset) this.center$delegate.getValue()).m4999unboximpl();
    }

    /* renamed from: setCenter--gyyYBs$material3_release  reason: not valid java name */
    public final void m1593setCentergyyYBs$material3_release(long j) {
        this.center$delegate.setValue(IntOffset.m4981boximpl(j));
    }

    public final List<Integer> getValues$material3_release() {
        List<Integer> list;
        List<Integer> list2;
        if (Selection.m1374equalsimpl0(m1591getSelectionJiIwxys$material3_release(), Selection.Companion.m1379getMinuteJiIwxys())) {
            list2 = TimePickerKt.Minutes;
            return list2;
        }
        list = TimePickerKt.Hours;
        return list;
    }

    /* renamed from: getSelection-JiIwxys$material3_release  reason: not valid java name */
    public final int m1591getSelectionJiIwxys$material3_release() {
        return ((Selection) this.selection$delegate.getValue()).m1377unboximpl();
    }

    /* renamed from: setSelection-iHAOin8$material3_release  reason: not valid java name */
    public final void m1594setSelectioniHAOin8$material3_release(int i) {
        this.selection$delegate.setValue(Selection.m1371boximpl(i));
    }

    public final boolean isAfternoonToggle$material3_release() {
        return ((Boolean) this.isAfternoonToggle$delegate.getValue()).booleanValue();
    }

    public final void setAfternoonToggle$material3_release(boolean z) {
        this.isAfternoonToggle$delegate.setValue(Boolean.valueOf(z));
    }

    public final boolean isInnerCircle$material3_release() {
        return ((Boolean) this.isInnerCircle$delegate.getValue()).booleanValue();
    }

    public final void setInnerCircle$material3_release(boolean z) {
        this.isInnerCircle$delegate.setValue(Boolean.valueOf(z));
    }

    public final float getHourAngle$material3_release() {
        return ((Number) this.hourAngle$delegate.getValue()).floatValue();
    }

    public final void setHourAngle$material3_release(float f) {
        this.hourAngle$delegate.setValue(Float.valueOf(f));
    }

    public final float getMinuteAngle$material3_release() {
        return ((Number) this.minuteAngle$delegate.getValue()).floatValue();
    }

    public final void setMinuteAngle$material3_release(float f) {
        this.minuteAngle$delegate.setValue(Float.valueOf(f));
    }

    public final void setMinute$material3_release(int i) {
        setMinuteAngle$material3_release((i * 0.10471976f) - 1.5707964f);
    }

    public final void setHour$material3_release(int i) {
        setInnerCircle$material3_release(i > 12 || i == 0);
        setHourAngle$material3_release(((i * 0.5235988f) % 12) - 1.5707964f);
    }

    public final void moveSelector$material3_release(float f, float f2, float f3) {
        float dist;
        if (Selection.m1374equalsimpl0(m1591getSelectionJiIwxys$material3_release(), Selection.Companion.m1378getHourJiIwxys()) && this.is24hour) {
            dist = TimePickerKt.dist(f, f2, IntOffset.m4990getXimpl(m1590getCenternOccac$material3_release()), IntOffset.m4991getYimpl(m1590getCenternOccac$material3_release()));
            setInnerCircle$material3_release(dist < f3);
        }
    }

    public final boolean isSelected$material3_release(int i) {
        if (Selection.m1374equalsimpl0(m1591getSelectionJiIwxys$material3_release(), Selection.Companion.m1379getMinuteJiIwxys())) {
            if (i == getMinute()) {
                return true;
            }
        } else {
            if (getHour() == i + (isAfternoon() ? 12 : 0)) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ Object update$material3_release$default(TimePickerState timePickerState, float f, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return timePickerState.update$material3_release(f, z, continuation);
    }

    public final Object update$material3_release(float f, boolean z, Continuation<? super Unit> continuation) {
        Object mutate = this.mutex.mutate(MutatePriority.UserInput, new TimePickerState$update$2(this, f, z, null), continuation);
        return mutate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mutate : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00be A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object animateToCurrent$material3_release(kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof androidx.compose.material3.TimePickerState$animateToCurrent$1
            if (r0 == 0) goto L14
            r0 = r12
            androidx.compose.material3.TimePickerState$animateToCurrent$1 r0 = (androidx.compose.material3.TimePickerState$animateToCurrent$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L19
        L14:
            androidx.compose.material3.TimePickerState$animateToCurrent$1 r0 = new androidx.compose.material3.TimePickerState$animateToCurrent$1
            r0.<init>(r11, r12)
        L19:
            r6 = r0
            java.lang.Object r12 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L41
            if (r1 == r3) goto L37
            if (r1 != r2) goto L2f
            kotlin.ResultKt.throwOnFailure(r12)
            goto Lbf
        L2f:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L37:
            float r1 = r6.F$0
            java.lang.Object r3 = r6.L$0
            androidx.compose.material3.TimePickerState r3 = (androidx.compose.material3.TimePickerState) r3
            kotlin.ResultKt.throwOnFailure(r12)
            goto L96
        L41:
            kotlin.ResultKt.throwOnFailure(r12)
            int r12 = r11.m1591getSelectionJiIwxys$material3_release()
            androidx.compose.material3.Selection$Companion r1 = androidx.compose.material3.Selection.Companion
            int r1 = r1.m1378getHourJiIwxys()
            boolean r12 = androidx.compose.material3.Selection.m1374equalsimpl0(r12, r1)
            if (r12 == 0) goto L61
            float r12 = r11.getMinuteAngle$material3_release()
            float r1 = r11.getHourAngle$material3_release()
            kotlin.Pair r12 = androidx.compose.material3.TimePickerKt.access$valuesForAnimation(r12, r1)
            goto L6d
        L61:
            float r12 = r11.getHourAngle$material3_release()
            float r1 = r11.getMinuteAngle$material3_release()
            kotlin.Pair r12 = androidx.compose.material3.TimePickerKt.access$valuesForAnimation(r12, r1)
        L6d:
            java.lang.Object r1 = r12.component1()
            java.lang.Number r1 = (java.lang.Number) r1
            float r1 = r1.floatValue()
            java.lang.Object r12 = r12.component2()
            java.lang.Number r12 = (java.lang.Number) r12
            float r12 = r12.floatValue()
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r4 = r11.currentAngle
            java.lang.Float r1 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r1)
            r6.L$0 = r11
            r6.F$0 = r12
            r6.label = r3
            java.lang.Object r1 = r4.snapTo(r1, r6)
            if (r1 != r0) goto L94
            return r0
        L94:
            r3 = r11
            r1 = r12
        L96:
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r12 = r3.currentAngle
            java.lang.Float r3 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r1)
            r1 = 0
            r4 = 6
            r5 = 200(0xc8, float:2.8E-43)
            r7 = 0
            androidx.compose.animation.core.TweenSpec r1 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r5, r1, r7, r4, r7)
            r4 = r1
            androidx.compose.animation.core.AnimationSpec r4 = (androidx.compose.animation.core.AnimationSpec) r4
            r5 = 0
            r8 = 0
            r9 = 12
            r10 = 0
            r6.L$0 = r7
            r6.label = r2
            r1 = r12
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r8
            r7 = r9
            r8 = r10
            java.lang.Object r12 = androidx.compose.animation.core.Animatable.animateTo$default(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r12 != r0) goto Lbf
            return r0
        Lbf:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerState.animateToCurrent$material3_release(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final int hourForDisplay(int i) {
        if (!this.is24hour || !isInnerCircle$material3_release() || i != 0) {
            if (this.is24hour) {
                return i % 24;
            }
            if (i % 12 != 0) {
                return isAfternoon() ? i - 12 : i;
            }
        }
        return 12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int toHour(float f) {
        return ((int) ((f + (0.2617994f + 1.5707963267948966d)) / 0.5235988f)) % 12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int toMinute(float f) {
        return ((int) ((f + (0.05235988f + 1.5707963267948966d)) / 0.10471976f)) % 60;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0098 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object settle(kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof androidx.compose.material3.TimePickerState$settle$1
            if (r0 == 0) goto L14
            r0 = r12
            androidx.compose.material3.TimePickerState$settle$1 r0 = (androidx.compose.material3.TimePickerState$settle$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L19
        L14:
            androidx.compose.material3.TimePickerState$settle$1 r0 = new androidx.compose.material3.TimePickerState$settle$1
            r0.<init>(r11, r12)
        L19:
            r6 = r0
            java.lang.Object r12 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L43
            if (r1 == r3) goto L37
            if (r1 != r2) goto L2f
            kotlin.ResultKt.throwOnFailure(r12)
            goto L99
        L2f:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L37:
            java.lang.Object r1 = r6.L$1
            kotlin.Pair r1 = (kotlin.Pair) r1
            java.lang.Object r3 = r6.L$0
            androidx.compose.material3.TimePickerState r3 = (androidx.compose.material3.TimePickerState) r3
            kotlin.ResultKt.throwOnFailure(r12)
            goto L6e
        L43:
            kotlin.ResultKt.throwOnFailure(r12)
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r12 = r11.currentAngle
            java.lang.Object r12 = r12.getValue()
            java.lang.Number r12 = (java.lang.Number) r12
            float r12 = r12.floatValue()
            float r1 = r11.getMinuteAngle$material3_release()
            kotlin.Pair r1 = androidx.compose.material3.TimePickerKt.access$valuesForAnimation(r12, r1)
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r12 = r11.currentAngle
            java.lang.Object r4 = r1.getFirst()
            r6.L$0 = r11
            r6.L$1 = r1
            r6.label = r3
            java.lang.Object r12 = r12.snapTo(r4, r6)
            if (r12 != r0) goto L6d
            return r0
        L6d:
            r3 = r11
        L6e:
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r12 = r3.currentAngle
            java.lang.Object r3 = r1.getSecond()
            r1 = 0
            r4 = 6
            r5 = 200(0xc8, float:2.8E-43)
            r7 = 0
            androidx.compose.animation.core.TweenSpec r1 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r5, r1, r7, r4, r7)
            r4 = r1
            androidx.compose.animation.core.AnimationSpec r4 = (androidx.compose.animation.core.AnimationSpec) r4
            r5 = 0
            r8 = 0
            r9 = 12
            r10 = 0
            r6.L$0 = r7
            r6.L$1 = r7
            r6.label = r2
            r1 = r12
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r8
            r7 = r9
            r8 = r10
            java.lang.Object r12 = androidx.compose.animation.core.Animatable.animateTo$default(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r12 != r0) goto L99
            return r0
        L99:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerState.settle(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0103 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0107  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object onTap$material3_release(float r11, float r12, float r13, boolean r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            Method dump skipped, instructions count: 277
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerState.onTap$material3_release(float, float, float, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* compiled from: TimePicker.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u0004¨\u0006\u0006"}, d2 = {"Landroidx/compose/material3/TimePickerState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/TimePickerState;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<TimePickerState, ?> Saver() {
            return SaverKt.Saver(new Function2<SaverScope, TimePickerState, List<? extends Object>>() { // from class: androidx.compose.material3.TimePickerState$Companion$Saver$1
                @Override // kotlin.jvm.functions.Function2
                public final List<Object> invoke(SaverScope Saver, TimePickerState it) {
                    Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
                    Intrinsics.checkNotNullParameter(it, "it");
                    return CollectionsKt.listOf(Integer.valueOf(it.getHour()), Integer.valueOf(it.getMinute()), Boolean.valueOf(it.is24hour()));
                }
            }, new Function1<List, TimePickerState>() { // from class: androidx.compose.material3.TimePickerState$Companion$Saver$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ TimePickerState invoke(List list) {
                    return invoke2((List<? extends Object>) list);
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final TimePickerState invoke2(List<? extends Object> value) {
                    Intrinsics.checkNotNullParameter(value, "value");
                    Object obj = value.get(0);
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                    int intValue = ((Integer) obj).intValue();
                    Object obj2 = value.get(1);
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
                    int intValue2 = ((Integer) obj2).intValue();
                    Object obj3 = value.get(2);
                    Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Boolean");
                    return new TimePickerState(intValue, intValue2, ((Boolean) obj3).booleanValue());
                }
            });
        }
    }

    /* renamed from: getSelectorPos-RKDOV3M$material3_release  reason: not valid java name */
    public final long m1592getSelectorPosRKDOV3M$material3_release() {
        return ((DpOffset) this.selectorPos$delegate.getValue()).m4941unboximpl();
    }

    private final boolean isAfternoon() {
        return ((Boolean) this.isAfternoon$delegate.getValue()).booleanValue();
    }
}