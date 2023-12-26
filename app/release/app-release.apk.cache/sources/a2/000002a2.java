package androidx.compose.foundation;

import android.content.Context;
import android.widget.EdgeEffect;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: AndroidOverscroll.kt */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010-\u001a\u00020!H\u0002JE\u0010.\u001a\u00020!2\u0006\u0010/\u001a\u0002002\"\u00101\u001a\u001e\b\u0001\u0012\u0004\u0012\u000200\u0012\n\u0012\b\u0012\u0004\u0012\u00020003\u0012\u0006\u0012\u0004\u0018\u00010402H\u0096@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b5\u00106J9\u00107\u001a\u00020%2\u0006\u00108\u001a\u00020%2\u0006\u00109\u001a\u00020:2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%0\u001fH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b<\u0010=J\b\u0010>\u001a\u00020!H\u0002J%\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020%2\u0006\u0010B\u001a\u00020%H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bC\u0010DJ%\u0010E\u001a\u00020@2\u0006\u0010A\u001a\u00020%2\u0006\u0010B\u001a\u00020%H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bF\u0010DJ%\u0010G\u001a\u00020@2\u0006\u0010A\u001a\u00020%2\u0006\u0010B\u001a\u00020%H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bH\u0010DJ%\u0010I\u001a\u00020@2\u0006\u0010A\u001a\u00020%2\u0006\u0010B\u001a\u00020%H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bJ\u0010DJ\u001d\u0010K\u001a\u00020\u00142\u0006\u00108\u001a\u00020%H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bL\u0010MJ\b\u0010N\u001a\u00020\u0014H\u0002J \u0010O\u001a\u00020\u0014*\u00020P2\u0006\u0010Q\u001a\u00020\t2\n\u0010R\u001a\u00060Sj\u0002`TH\u0002J \u0010U\u001a\u00020\u0014*\u00020P2\u0006\u0010V\u001a\u00020\t2\n\u0010R\u001a\u00060Sj\u0002`TH\u0002J\n\u0010W\u001a\u00020!*\u00020PJ \u0010X\u001a\u00020\u0014*\u00020P2\u0006\u0010Y\u001a\u00020\t2\n\u0010R\u001a\u00060Sj\u0002`TH\u0002J \u0010Z\u001a\u00020\u0014*\u00020P2\u0006\u0010[\u001a\u00020\t2\n\u0010R\u001a\u00060Sj\u0002`TH\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\f\u001a\u00020\rX\u0082\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u00020\u00148\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0018R\u000e\u0010\u001c\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001fX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000R\u0019\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020!0'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\\"}, d2 = {"Landroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect;", "Landroidx/compose/foundation/OverscrollEffect;", "context", "Landroid/content/Context;", "overscrollConfig", "Landroidx/compose/foundation/OverscrollConfiguration;", "(Landroid/content/Context;Landroidx/compose/foundation/OverscrollConfiguration;)V", "allEffects", "", "Landroid/widget/EdgeEffect;", "bottomEffect", "bottomEffectNegation", "containerSize", "Landroidx/compose/ui/geometry/Size;", "J", "effectModifier", "Landroidx/compose/ui/Modifier;", "getEffectModifier", "()Landroidx/compose/ui/Modifier;", "invalidationEnabled", "", "getInvalidationEnabled$foundation_release$annotations", "()V", "getInvalidationEnabled$foundation_release", "()Z", "setInvalidationEnabled$foundation_release", "(Z)V", "isInProgress", "leftEffect", "leftEffectNegation", "onNewSize", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/IntSize;", "", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "redrawSignal", "Landroidx/compose/runtime/MutableState;", "rightEffect", "rightEffectNegation", "scrollCycleInProgress", "topEffect", "topEffectNegation", "animateToRelease", "applyToFling", "velocity", "Landroidx/compose/ui/unit/Velocity;", "performFling", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "applyToFling-BMRW4eQ", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyToScroll", "delta", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "performScroll", "applyToScroll-Rhakbz0", "(JILkotlin/jvm/functions/Function1;)J", "invalidateOverscroll", "pullBottom", "", "scroll", "displacement", "pullBottom-0a9Yr6o", "(JJ)F", "pullLeft", "pullLeft-0a9Yr6o", "pullRight", "pullRight-0a9Yr6o", "pullTop", "pullTop-0a9Yr6o", "releaseOppositeOverscroll", "releaseOppositeOverscroll-k-4lQ0M", "(J)Z", "stopOverscrollAnimation", "drawBottom", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "bottom", "canvas", "Landroid/graphics/Canvas;", "Landroidx/compose/ui/graphics/NativeCanvas;", "drawLeft", "left", "drawOverscroll", "drawRight", "right", "drawTop", "top", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidEdgeEffectOverscrollEffect implements OverscrollEffect {
    private final List<EdgeEffect> allEffects;
    private final EdgeEffect bottomEffect;
    private final EdgeEffect bottomEffectNegation;
    private long containerSize;
    private final Modifier effectModifier;
    private boolean invalidationEnabled;
    private final EdgeEffect leftEffect;
    private final EdgeEffect leftEffectNegation;
    private final Function1<IntSize, Unit> onNewSize;
    private final OverscrollConfiguration overscrollConfig;
    private PointerId pointerId;
    private Offset pointerPosition;
    private final MutableState<Unit> redrawSignal;
    private final EdgeEffect rightEffect;
    private final EdgeEffect rightEffectNegation;
    private boolean scrollCycleInProgress;
    private final EdgeEffect topEffect;
    private final EdgeEffect topEffectNegation;

    public static /* synthetic */ void getInvalidationEnabled$foundation_release$annotations() {
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public Modifier getEffectModifier() {
        return this.effectModifier;
    }

    public final boolean getInvalidationEnabled$foundation_release() {
        return this.invalidationEnabled;
    }

    public final void setInvalidationEnabled$foundation_release(boolean z) {
        this.invalidationEnabled = z;
    }

    public AndroidEdgeEffectOverscrollEffect(Context context, OverscrollConfiguration overscrollConfig) {
        Modifier modifier;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(overscrollConfig, "overscrollConfig");
        this.overscrollConfig = overscrollConfig;
        EdgeEffect create = EdgeEffectCompat.INSTANCE.create(context, null);
        this.topEffect = create;
        EdgeEffect create2 = EdgeEffectCompat.INSTANCE.create(context, null);
        this.bottomEffect = create2;
        EdgeEffect create3 = EdgeEffectCompat.INSTANCE.create(context, null);
        this.leftEffect = create3;
        EdgeEffect create4 = EdgeEffectCompat.INSTANCE.create(context, null);
        this.rightEffect = create4;
        List<EdgeEffect> listOf = CollectionsKt.listOf((Object[]) new EdgeEffect[]{create3, create, create4, create2});
        this.allEffects = listOf;
        this.topEffectNegation = EdgeEffectCompat.INSTANCE.create(context, null);
        this.bottomEffectNegation = EdgeEffectCompat.INSTANCE.create(context, null);
        this.leftEffectNegation = EdgeEffectCompat.INSTANCE.create(context, null);
        this.rightEffectNegation = EdgeEffectCompat.INSTANCE.create(context, null);
        int size = listOf.size();
        for (int i = 0; i < size; i++) {
            listOf.get(i).setColor(ColorKt.m2682toArgb8_81llA(this.overscrollConfig.m239getGlowColor0d7_KjU()));
        }
        this.redrawSignal = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
        this.invalidationEnabled = true;
        this.containerSize = Size.Companion.m2467getZeroNHjbRc();
        Function1<IntSize, Unit> function1 = new Function1<IntSize, Unit>() { // from class: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$onNewSize$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                m154invokeozmzZPI(intSize.m5036unboximpl());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-ozmzZPI  reason: not valid java name */
            public final void m154invokeozmzZPI(long j) {
                boolean z = !Size.m2454equalsimpl0(IntSizeKt.m5042toSizeozmzZPI(j), AndroidEdgeEffectOverscrollEffect.access$getContainerSize$p(AndroidEdgeEffectOverscrollEffect.this));
                AndroidEdgeEffectOverscrollEffect.access$setContainerSize$p(AndroidEdgeEffectOverscrollEffect.this, IntSizeKt.m5042toSizeozmzZPI(j));
                if (z) {
                    AndroidEdgeEffectOverscrollEffect.access$getTopEffect$p(AndroidEdgeEffectOverscrollEffect.this).setSize(IntSize.m5032getWidthimpl(j), IntSize.m5031getHeightimpl(j));
                    AndroidEdgeEffectOverscrollEffect.access$getBottomEffect$p(AndroidEdgeEffectOverscrollEffect.this).setSize(IntSize.m5032getWidthimpl(j), IntSize.m5031getHeightimpl(j));
                    AndroidEdgeEffectOverscrollEffect.access$getLeftEffect$p(AndroidEdgeEffectOverscrollEffect.this).setSize(IntSize.m5031getHeightimpl(j), IntSize.m5032getWidthimpl(j));
                    AndroidEdgeEffectOverscrollEffect.access$getRightEffect$p(AndroidEdgeEffectOverscrollEffect.this).setSize(IntSize.m5031getHeightimpl(j), IntSize.m5032getWidthimpl(j));
                    AndroidEdgeEffectOverscrollEffect.access$getTopEffectNegation$p(AndroidEdgeEffectOverscrollEffect.this).setSize(IntSize.m5032getWidthimpl(j), IntSize.m5031getHeightimpl(j));
                    AndroidEdgeEffectOverscrollEffect.access$getBottomEffectNegation$p(AndroidEdgeEffectOverscrollEffect.this).setSize(IntSize.m5032getWidthimpl(j), IntSize.m5031getHeightimpl(j));
                    AndroidEdgeEffectOverscrollEffect.access$getLeftEffectNegation$p(AndroidEdgeEffectOverscrollEffect.this).setSize(IntSize.m5031getHeightimpl(j), IntSize.m5032getWidthimpl(j));
                    AndroidEdgeEffectOverscrollEffect.access$getRightEffectNegation$p(AndroidEdgeEffectOverscrollEffect.this).setSize(IntSize.m5031getHeightimpl(j), IntSize.m5032getWidthimpl(j));
                }
                if (z) {
                    AndroidEdgeEffectOverscrollEffect.access$invalidateOverscroll(AndroidEdgeEffectOverscrollEffect.this);
                    AndroidEdgeEffectOverscrollEffect.access$animateToRelease(AndroidEdgeEffectOverscrollEffect.this);
                }
            }
        };
        this.onNewSize = function1;
        Modifier.Companion companion = Modifier.Companion;
        modifier = AndroidOverscrollKt.StretchOverscrollNonClippingLayer;
        this.effectModifier = OnRemeasuredModifierKt.onSizeChanged(SuspendingPointerInputFilterKt.pointerInput(companion.then(modifier), Unit.INSTANCE, new AndroidEdgeEffectOverscrollEffect$effectModifier$1(this, null)), function1).then(new DrawOverscrollModifier(this, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$special$$inlined$debugInspectorInfo$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("overscroll");
                inspectorInfo.setValue(AndroidEdgeEffectOverscrollEffect.this);
            }
        } : InspectableValueKt.getNoInspectorInfo()));
    }

    public static final /* synthetic */ void access$animateToRelease(AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect) {
        androidEdgeEffectOverscrollEffect.animateToRelease();
    }

    public static final /* synthetic */ EdgeEffect access$getBottomEffect$p(AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect) {
        return androidEdgeEffectOverscrollEffect.bottomEffect;
    }

    public static final /* synthetic */ EdgeEffect access$getBottomEffectNegation$p(AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect) {
        return androidEdgeEffectOverscrollEffect.bottomEffectNegation;
    }

    public static final /* synthetic */ long access$getContainerSize$p(AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect) {
        return androidEdgeEffectOverscrollEffect.containerSize;
    }

    public static final /* synthetic */ EdgeEffect access$getLeftEffect$p(AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect) {
        return androidEdgeEffectOverscrollEffect.leftEffect;
    }

    public static final /* synthetic */ EdgeEffect access$getLeftEffectNegation$p(AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect) {
        return androidEdgeEffectOverscrollEffect.leftEffectNegation;
    }

    public static final /* synthetic */ EdgeEffect access$getRightEffect$p(AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect) {
        return androidEdgeEffectOverscrollEffect.rightEffect;
    }

    public static final /* synthetic */ EdgeEffect access$getRightEffectNegation$p(AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect) {
        return androidEdgeEffectOverscrollEffect.rightEffectNegation;
    }

    public static final /* synthetic */ EdgeEffect access$getTopEffect$p(AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect) {
        return androidEdgeEffectOverscrollEffect.topEffect;
    }

    public static final /* synthetic */ EdgeEffect access$getTopEffectNegation$p(AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect) {
        return androidEdgeEffectOverscrollEffect.topEffectNegation;
    }

    public static final /* synthetic */ void access$invalidateOverscroll(AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect) {
        androidEdgeEffectOverscrollEffect.invalidateOverscroll();
    }

    public static final /* synthetic */ void access$setContainerSize$p(AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, long j) {
        androidEdgeEffectOverscrollEffect.containerSize = j;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x014a A[ADDED_TO_REGION] */
    @Override // androidx.compose.foundation.OverscrollEffect
    /* renamed from: applyToScroll-Rhakbz0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long mo153applyToScrollRhakbz0(long r18, int r20, kotlin.jvm.functions.Function1<? super androidx.compose.ui.geometry.Offset, androidx.compose.ui.geometry.Offset> r21) {
        /*
            Method dump skipped, instructions count: 351
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect.mo153applyToScrollRhakbz0(long, int, kotlin.jvm.functions.Function1):long");
    }

    /* JADX WARN: Removed duplicated region for block: B:131:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0041  */
    @Override // androidx.compose.foundation.OverscrollEffect
    /* renamed from: applyToFling-BMRW4eQ */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo152applyToFlingBMRW4eQ(long r11, kotlin.jvm.functions.Function2<? super androidx.compose.ui.unit.Velocity, ? super kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity>, ? extends java.lang.Object> r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            Method dump skipped, instructions count: 431
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect.mo152applyToFlingBMRW4eQ(long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean stopOverscrollAnimation() {
        boolean z;
        long m2468getCenteruvyYCjk = SizeKt.m2468getCenteruvyYCjk(this.containerSize);
        if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.leftEffect) == 0.0f) {
            z = false;
        } else {
            m148pullLeft0a9Yr6o(Offset.Companion.m2405getZeroF1C5BW0(), m2468getCenteruvyYCjk);
            z = true;
        }
        if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.rightEffect) != 0.0f) {
            m149pullRight0a9Yr6o(Offset.Companion.m2405getZeroF1C5BW0(), m2468getCenteruvyYCjk);
            z = true;
        }
        if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.topEffect) != 0.0f) {
            m150pullTop0a9Yr6o(Offset.Companion.m2405getZeroF1C5BW0(), m2468getCenteruvyYCjk);
            z = true;
        }
        if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.bottomEffect) == 0.0f) {
            return z;
        }
        m147pullBottom0a9Yr6o(Offset.Companion.m2405getZeroF1C5BW0(), m2468getCenteruvyYCjk);
        return true;
    }

    public final void drawOverscroll(DrawScope drawScope) {
        boolean z;
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        if (Size.m2460isEmptyimpl(this.containerSize)) {
            return;
        }
        Canvas canvas = drawScope.getDrawContext().getCanvas();
        this.redrawSignal.getValue();
        android.graphics.Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.leftEffectNegation) != 0.0f) {
            drawRight(drawScope, this.leftEffectNegation, nativeCanvas);
            this.leftEffectNegation.finish();
        }
        boolean z2 = false;
        if (this.leftEffect.isFinished()) {
            z = false;
        } else {
            z = drawLeft(drawScope, this.leftEffect, nativeCanvas);
            EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.leftEffectNegation, EdgeEffectCompat.INSTANCE.getDistanceCompat(this.leftEffect), 0.0f);
        }
        if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.topEffectNegation) != 0.0f) {
            drawBottom(drawScope, this.topEffectNegation, nativeCanvas);
            this.topEffectNegation.finish();
        }
        if (!this.topEffect.isFinished()) {
            z = drawTop(drawScope, this.topEffect, nativeCanvas) || z;
            EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.topEffectNegation, EdgeEffectCompat.INSTANCE.getDistanceCompat(this.topEffect), 0.0f);
        }
        if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.rightEffectNegation) != 0.0f) {
            drawLeft(drawScope, this.rightEffectNegation, nativeCanvas);
            this.rightEffectNegation.finish();
        }
        if (!this.rightEffect.isFinished()) {
            z = drawRight(drawScope, this.rightEffect, nativeCanvas) || z;
            EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.rightEffectNegation, EdgeEffectCompat.INSTANCE.getDistanceCompat(this.rightEffect), 0.0f);
        }
        if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.bottomEffectNegation) != 0.0f) {
            drawTop(drawScope, this.bottomEffectNegation, nativeCanvas);
            this.bottomEffectNegation.finish();
        }
        if (!this.bottomEffect.isFinished()) {
            if (drawBottom(drawScope, this.bottomEffect, nativeCanvas) || z) {
                z2 = true;
            }
            EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.bottomEffectNegation, EdgeEffectCompat.INSTANCE.getDistanceCompat(this.bottomEffect), 0.0f);
            z = z2;
        }
        if (z) {
            invalidateOverscroll();
        }
    }

    private final boolean drawLeft(DrawScope drawScope, EdgeEffect edgeEffect, android.graphics.Canvas canvas) {
        int save = canvas.save();
        canvas.rotate(270.0f);
        canvas.translate(-Size.m2455getHeightimpl(this.containerSize), drawScope.mo324toPx0680j_4(this.overscrollConfig.getDrawPadding().mo430calculateLeftPaddingu2uoSUM(drawScope.getLayoutDirection())));
        boolean draw = edgeEffect.draw(canvas);
        canvas.restoreToCount(save);
        return draw;
    }

    private final boolean drawTop(DrawScope drawScope, EdgeEffect edgeEffect, android.graphics.Canvas canvas) {
        int save = canvas.save();
        canvas.translate(0.0f, drawScope.mo324toPx0680j_4(this.overscrollConfig.getDrawPadding().mo432calculateTopPaddingD9Ej5fM()));
        boolean draw = edgeEffect.draw(canvas);
        canvas.restoreToCount(save);
        return draw;
    }

    private final boolean drawRight(DrawScope drawScope, EdgeEffect edgeEffect, android.graphics.Canvas canvas) {
        int save = canvas.save();
        int roundToInt = MathKt.roundToInt(Size.m2458getWidthimpl(this.containerSize));
        float mo431calculateRightPaddingu2uoSUM = this.overscrollConfig.getDrawPadding().mo431calculateRightPaddingu2uoSUM(drawScope.getLayoutDirection());
        canvas.rotate(90.0f);
        canvas.translate(0.0f, (-roundToInt) + drawScope.mo324toPx0680j_4(mo431calculateRightPaddingu2uoSUM));
        boolean draw = edgeEffect.draw(canvas);
        canvas.restoreToCount(save);
        return draw;
    }

    private final boolean drawBottom(DrawScope drawScope, EdgeEffect edgeEffect, android.graphics.Canvas canvas) {
        int save = canvas.save();
        canvas.rotate(180.0f);
        canvas.translate(-Size.m2458getWidthimpl(this.containerSize), (-Size.m2455getHeightimpl(this.containerSize)) + drawScope.mo324toPx0680j_4(this.overscrollConfig.getDrawPadding().mo429calculateBottomPaddingD9Ej5fM()));
        boolean draw = edgeEffect.draw(canvas);
        canvas.restoreToCount(save);
        return draw;
    }

    public final void invalidateOverscroll() {
        if (this.invalidationEnabled) {
            this.redrawSignal.setValue(Unit.INSTANCE);
        }
    }

    /* renamed from: releaseOppositeOverscroll-k-4lQ0M */
    private final boolean m151releaseOppositeOverscrollk4lQ0M(long j) {
        boolean z;
        boolean z2 = false;
        if (this.leftEffect.isFinished() || Offset.m2389getXimpl(j) >= 0.0f) {
            z = false;
        } else {
            EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.leftEffect, Offset.m2389getXimpl(j));
            z = this.leftEffect.isFinished();
        }
        if (!this.rightEffect.isFinished() && Offset.m2389getXimpl(j) > 0.0f) {
            EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.rightEffect, Offset.m2389getXimpl(j));
            z = z || this.rightEffect.isFinished();
        }
        if (!this.topEffect.isFinished() && Offset.m2390getYimpl(j) < 0.0f) {
            EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.topEffect, Offset.m2390getYimpl(j));
            z = z || this.topEffect.isFinished();
        }
        if (this.bottomEffect.isFinished() || Offset.m2390getYimpl(j) <= 0.0f) {
            return z;
        }
        EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.bottomEffect, Offset.m2390getYimpl(j));
        if (z || this.bottomEffect.isFinished()) {
            z2 = true;
        }
        return z2;
    }

    /* renamed from: pullTop-0a9Yr6o */
    private final float m150pullTop0a9Yr6o(long j, long j2) {
        return EdgeEffectCompat.INSTANCE.getDistanceCompat(this.topEffect) == 0.0f ? EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.topEffect, Offset.m2390getYimpl(j) / Size.m2455getHeightimpl(this.containerSize), Offset.m2389getXimpl(j2) / Size.m2458getWidthimpl(this.containerSize)) * Size.m2455getHeightimpl(this.containerSize) : Offset.m2390getYimpl(j);
    }

    /* renamed from: pullBottom-0a9Yr6o */
    private final float m147pullBottom0a9Yr6o(long j, long j2) {
        return EdgeEffectCompat.INSTANCE.getDistanceCompat(this.bottomEffect) == 0.0f ? (-EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.bottomEffect, -(Offset.m2390getYimpl(j) / Size.m2455getHeightimpl(this.containerSize)), 1 - (Offset.m2389getXimpl(j2) / Size.m2458getWidthimpl(this.containerSize)))) * Size.m2455getHeightimpl(this.containerSize) : Offset.m2390getYimpl(j);
    }

    /* renamed from: pullLeft-0a9Yr6o */
    private final float m148pullLeft0a9Yr6o(long j, long j2) {
        return EdgeEffectCompat.INSTANCE.getDistanceCompat(this.leftEffect) == 0.0f ? EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.leftEffect, Offset.m2389getXimpl(j) / Size.m2458getWidthimpl(this.containerSize), 1 - (Offset.m2390getYimpl(j2) / Size.m2455getHeightimpl(this.containerSize))) * Size.m2458getWidthimpl(this.containerSize) : Offset.m2389getXimpl(j);
    }

    /* renamed from: pullRight-0a9Yr6o */
    private final float m149pullRight0a9Yr6o(long j, long j2) {
        return EdgeEffectCompat.INSTANCE.getDistanceCompat(this.rightEffect) == 0.0f ? (-EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.rightEffect, -(Offset.m2389getXimpl(j) / Size.m2458getWidthimpl(this.containerSize)), Offset.m2390getYimpl(j2) / Size.m2455getHeightimpl(this.containerSize))) * Size.m2458getWidthimpl(this.containerSize) : Offset.m2389getXimpl(j);
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public boolean isInProgress() {
        List<EdgeEffect> list = this.allEffects;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(list.get(i)) == 0.0f)) {
                return true;
            }
        }
        return false;
    }

    public final void animateToRelease() {
        List<EdgeEffect> list = this.allEffects;
        int size = list.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            EdgeEffect edgeEffect = list.get(i);
            edgeEffect.onRelease();
            z = edgeEffect.isFinished() || z;
        }
        if (z) {
            invalidateOverscroll();
        }
    }
}