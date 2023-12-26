package androidx.compose.foundation.gestures;

import androidx.compose.foundation.FocusedBoundsKt;
import androidx.compose.foundation.relocation.BringIntoViewResponder;
import androidx.compose.foundation.relocation.BringIntoViewResponderKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.OnPlacedModifier;
import androidx.compose.ui.layout.OnRemeasuredModifier;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: ContentInViewModifier.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001EB%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ!\u0010\u001f\u001a\u00020 2\u000e\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\"H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010#J\u0010\u0010$\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u0015H\u0016J\b\u0010%\u001a\u00020&H\u0002J%\u0010'\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020\u001dH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b*\u0010+J\n\u0010,\u001a\u0004\u0018\u00010\u0015H\u0002J\n\u0010-\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010.\u001a\u00020 H\u0002J\u0010\u0010/\u001a\u00020 2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001d\u00100\u001a\u00020 2\u0006\u00101\u001a\u00020\u001dH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b2\u00103J \u00104\u001a\u00020&2\u0006\u00105\u001a\u00020&2\u0006\u00106\u001a\u00020&2\u0006\u0010)\u001a\u00020&H\u0002J%\u00107\u001a\u0002082\u0006\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020\u001dH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b9\u0010:J\"\u0010;\u001a\u00020<*\u00020=2\u0006\u0010>\u001a\u00020=H\u0082\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b?\u0010@J\"\u0010;\u001a\u00020<*\u00020\u001d2\u0006\u0010>\u001a\u00020\u001dH\u0082\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bA\u0010@J#\u0010B\u001a\u00020\u000b*\u00020\u00152\b\b\u0002\u00101\u001a\u00020\u001dH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bC\u0010DR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u001c\u001a\u00020\u001dX\u0082\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u001e\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006F"}, d2 = {"Landroidx/compose/foundation/gestures/ContentInViewModifier;", "Landroidx/compose/foundation/relocation/BringIntoViewResponder;", "Landroidx/compose/ui/layout/OnRemeasuredModifier;", "Landroidx/compose/ui/layout/OnPlacedModifier;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "scrollState", "Landroidx/compose/foundation/gestures/ScrollableState;", "reverseDirection", "", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/gestures/ScrollableState;Z)V", "animationState", "Landroidx/compose/foundation/gestures/UpdatableAnimationState;", "bringIntoViewRequests", "Landroidx/compose/foundation/gestures/BringIntoViewRequestPriorityQueue;", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "focusedChild", "focusedChildBoundsFromPreviousRemeasure", "Landroidx/compose/ui/geometry/Rect;", "isAnimationRunning", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "trackingFocusedChild", "viewportSize", "Landroidx/compose/ui/unit/IntSize;", "J", "bringChildIntoView", "", "localRect", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateRectForParent", "calculateScrollDelta", "", "computeDestination", "childBounds", "containerSize", "computeDestination-O0kMr_c", "(Landroidx/compose/ui/geometry/Rect;J)Landroidx/compose/ui/geometry/Rect;", "findBringIntoViewRequest", "getFocusedChildBounds", "launchAnimation", "onPlaced", "onRemeasured", "size", "onRemeasured-ozmzZPI", "(J)V", "relocationDistance", "leadingEdge", "trailingEdge", "relocationOffset", "Landroidx/compose/ui/geometry/Offset;", "relocationOffset-BMxPBkI", "(Landroidx/compose/ui/geometry/Rect;J)J", "compareTo", "", "Landroidx/compose/ui/geometry/Size;", "other", "compareTo-iLBOSCw", "(JJ)I", "compareTo-TemP2vQ", "isMaxVisible", "isMaxVisible-O0kMr_c", "(Landroidx/compose/ui/geometry/Rect;J)Z", "Request", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ContentInViewModifier implements BringIntoViewResponder, OnRemeasuredModifier, OnPlacedModifier {
    private final UpdatableAnimationState animationState;
    private final BringIntoViewRequestPriorityQueue bringIntoViewRequests;
    private LayoutCoordinates coordinates;
    private LayoutCoordinates focusedChild;
    private Rect focusedChildBoundsFromPreviousRemeasure;
    private boolean isAnimationRunning;
    private final Modifier modifier;
    private final Orientation orientation;
    private final boolean reverseDirection;
    private final CoroutineScope scope;
    private final ScrollableState scrollState;
    private boolean trackingFocusedChild;
    private long viewportSize;

    /* compiled from: ContentInViewModifier.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Orientation.values().length];
            try {
                iArr[Orientation.Vertical.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Orientation.Horizontal.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final Modifier getModifier() {
        return this.modifier;
    }

    @Override // androidx.compose.ui.layout.OnPlacedModifier
    public void onPlaced(LayoutCoordinates coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        this.coordinates = coordinates;
    }

    public ContentInViewModifier(CoroutineScope scope, Orientation orientation, ScrollableState scrollState, boolean z) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(scrollState, "scrollState");
        this.scope = scope;
        this.orientation = orientation;
        this.scrollState = scrollState;
        this.reverseDirection = z;
        this.bringIntoViewRequests = new BringIntoViewRequestPriorityQueue();
        this.viewportSize = IntSize.Companion.m5037getZeroYbymL2g();
        this.animationState = new UpdatableAnimationState();
        this.modifier = BringIntoViewResponderKt.bringIntoViewResponder(FocusedBoundsKt.onFocusedBoundsChanged(this, new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.gestures.ContentInViewModifier$modifier$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                invoke2(layoutCoordinates);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(LayoutCoordinates layoutCoordinates) {
                ContentInViewModifier.access$setFocusedChild$p(ContentInViewModifier.this, layoutCoordinates);
            }
        }), this);
    }

    public static final /* synthetic */ void access$setFocusedChild$p(ContentInViewModifier contentInViewModifier, LayoutCoordinates layoutCoordinates) {
        contentInViewModifier.focusedChild = layoutCoordinates;
    }

    @Override // androidx.compose.foundation.relocation.BringIntoViewResponder
    public Rect calculateRectForParent(Rect localRect) {
        Intrinsics.checkNotNullParameter(localRect, "localRect");
        if (!(!IntSize.m5030equalsimpl0(this.viewportSize, IntSize.Companion.m5037getZeroYbymL2g()))) {
            throw new IllegalStateException("Expected BringIntoViewRequester to not be used before parents are placed.".toString());
        }
        return m245computeDestinationO0kMr_c(localRect, this.viewportSize);
    }

    @Override // androidx.compose.foundation.relocation.BringIntoViewResponder
    public Object bringChildIntoView(Function0<Rect> function0, Continuation<? super Unit> continuation) {
        Rect invoke = function0.invoke();
        if (invoke == null || m247isMaxVisibleO0kMr_c$default(this, invoke, 0L, 1, null)) {
            return Unit.INSTANCE;
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        if (this.bringIntoViewRequests.enqueue(new Request(function0, cancellableContinuationImpl)) && !this.isAnimationRunning) {
            launchAnimation();
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.layout.OnRemeasuredModifier
    /* renamed from: onRemeasured-ozmzZPI */
    public void mo249onRemeasuredozmzZPI(long j) {
        Rect focusedChildBounds;
        long j2 = this.viewportSize;
        this.viewportSize = j;
        if (m243compareToTemP2vQ(j, j2) < 0 && (focusedChildBounds = getFocusedChildBounds()) != null) {
            Rect rect = this.focusedChildBoundsFromPreviousRemeasure;
            if (rect == null) {
                rect = focusedChildBounds;
            }
            if (!this.isAnimationRunning && !this.trackingFocusedChild && m246isMaxVisibleO0kMr_c(rect, j2) && !m246isMaxVisibleO0kMr_c(focusedChildBounds, j)) {
                this.trackingFocusedChild = true;
                launchAnimation();
            }
            this.focusedChildBoundsFromPreviousRemeasure = focusedChildBounds;
        }
    }

    public final Rect getFocusedChildBounds() {
        LayoutCoordinates layoutCoordinates;
        LayoutCoordinates layoutCoordinates2 = this.coordinates;
        if (layoutCoordinates2 != null) {
            if (!layoutCoordinates2.isAttached()) {
                layoutCoordinates2 = null;
            }
            if (layoutCoordinates2 != null && (layoutCoordinates = this.focusedChild) != null) {
                if (!layoutCoordinates.isAttached()) {
                    layoutCoordinates = null;
                }
                if (layoutCoordinates != null) {
                    return layoutCoordinates2.localBoundingBoxOf(layoutCoordinates, false);
                }
            }
        }
        return null;
    }

    public final void launchAnimation() {
        if (!this.isAnimationRunning) {
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, CoroutineStart.UNDISPATCHED, new ContentInViewModifier$launchAnimation$1(this, null), 1, null);
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final float calculateScrollDelta() {
        if (IntSize.m5030equalsimpl0(this.viewportSize, IntSize.Companion.m5037getZeroYbymL2g())) {
            return 0.0f;
        }
        Rect findBringIntoViewRequest = findBringIntoViewRequest();
        if (findBringIntoViewRequest == null) {
            findBringIntoViewRequest = this.trackingFocusedChild ? getFocusedChildBounds() : null;
            if (findBringIntoViewRequest == null) {
                return 0.0f;
            }
        }
        long m5042toSizeozmzZPI = IntSizeKt.m5042toSizeozmzZPI(this.viewportSize);
        int i = WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return relocationDistance(findBringIntoViewRequest.getLeft(), findBringIntoViewRequest.getRight(), Size.m2458getWidthimpl(m5042toSizeozmzZPI));
            }
            throw new NoWhenBranchMatchedException();
        }
        return relocationDistance(findBringIntoViewRequest.getTop(), findBringIntoViewRequest.getBottom(), Size.m2455getHeightimpl(m5042toSizeozmzZPI));
    }

    /* renamed from: computeDestination-O0kMr_c */
    private final Rect m245computeDestinationO0kMr_c(Rect rect, long j) {
        return rect.m2426translatek4lQ0M(Offset.m2398unaryMinusF1C5BW0(m248relocationOffsetBMxPBkI(rect, j)));
    }

    /* renamed from: isMaxVisible-O0kMr_c$default */
    public static /* synthetic */ boolean m247isMaxVisibleO0kMr_c$default(ContentInViewModifier contentInViewModifier, Rect rect, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = contentInViewModifier.viewportSize;
        }
        return contentInViewModifier.m246isMaxVisibleO0kMr_c(rect, j);
    }

    /* renamed from: isMaxVisible-O0kMr_c */
    private final boolean m246isMaxVisibleO0kMr_c(Rect rect, long j) {
        return Offset.m2386equalsimpl0(m248relocationOffsetBMxPBkI(rect, j), Offset.Companion.m2405getZeroF1C5BW0());
    }

    /* renamed from: relocationOffset-BMxPBkI */
    private final long m248relocationOffsetBMxPBkI(Rect rect, long j) {
        long m5042toSizeozmzZPI = IntSizeKt.m5042toSizeozmzZPI(j);
        int i = WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return OffsetKt.Offset(relocationDistance(rect.getLeft(), rect.getRight(), Size.m2458getWidthimpl(m5042toSizeozmzZPI)), 0.0f);
            }
            throw new NoWhenBranchMatchedException();
        }
        return OffsetKt.Offset(0.0f, relocationDistance(rect.getTop(), rect.getBottom(), Size.m2455getHeightimpl(m5042toSizeozmzZPI)));
    }

    private final float relocationDistance(float f, float f2, float f3) {
        if ((f < 0.0f || f2 > f3) && (f >= 0.0f || f2 <= f3)) {
            float f4 = f2 - f3;
            return Math.abs(f) < Math.abs(f4) ? f : f4;
        }
        return 0.0f;
    }

    /* renamed from: compareTo-TemP2vQ */
    private final int m243compareToTemP2vQ(long j, long j2) {
        int i = WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return Intrinsics.compare(IntSize.m5032getWidthimpl(j), IntSize.m5032getWidthimpl(j2));
            }
            throw new NoWhenBranchMatchedException();
        }
        return Intrinsics.compare(IntSize.m5031getHeightimpl(j), IntSize.m5031getHeightimpl(j2));
    }

    /* renamed from: compareTo-iLBOSCw */
    private final int m244compareToiLBOSCw(long j, long j2) {
        int i = WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return Float.compare(Size.m2458getWidthimpl(j), Size.m2458getWidthimpl(j2));
            }
            throw new NoWhenBranchMatchedException();
        }
        return Float.compare(Size.m2455getHeightimpl(j), Size.m2455getHeightimpl(j2));
    }

    /* compiled from: ContentInViewModifier.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Landroidx/compose/foundation/gestures/ContentInViewModifier$Request;", "", "currentBounds", "Lkotlin/Function0;", "Landroidx/compose/ui/geometry/Rect;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlin/jvm/functions/Function0;Lkotlinx/coroutines/CancellableContinuation;)V", "getContinuation", "()Lkotlinx/coroutines/CancellableContinuation;", "getCurrentBounds", "()Lkotlin/jvm/functions/Function0;", "toString", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Request {
        private final CancellableContinuation<Unit> continuation;
        private final Function0<Rect> currentBounds;

        public final CancellableContinuation<Unit> getContinuation() {
            return this.continuation;
        }

        public final Function0<Rect> getCurrentBounds() {
            return this.currentBounds;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Request(Function0<Rect> currentBounds, CancellableContinuation<? super Unit> continuation) {
            Intrinsics.checkNotNullParameter(currentBounds, "currentBounds");
            Intrinsics.checkNotNullParameter(continuation, "continuation");
            this.currentBounds = currentBounds;
            this.continuation = continuation;
        }

        public String toString() {
            CoroutineName coroutineName = (CoroutineName) this.continuation.getContext().get(CoroutineName.Key);
            String name = coroutineName != null ? coroutineName.getName() : null;
            StringBuilder sb = new StringBuilder("Request@");
            String num = Integer.toString(hashCode(), CharsKt.checkRadix(16));
            Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
            return sb.append(num).append((name == null || (r0 = new StringBuilder("[").append(name).append("](").toString()) == null) ? "(" : "(").append("currentBounds()=").append(this.currentBounds.invoke()).append(", continuation=").append(this.continuation).append(')').toString();
        }
    }

    private final Rect findBringIntoViewRequest() {
        MutableVector mutableVector = this.bringIntoViewRequests.requests;
        int size = mutableVector.getSize();
        Rect rect = null;
        if (size > 0) {
            int i = size - 1;
            Object[] content = mutableVector.getContent();
            do {
                Rect invoke = ((Request) content[i]).getCurrentBounds().invoke();
                if (invoke != null) {
                    if (m244compareToiLBOSCw(invoke.m2422getSizeNHjbRc(), IntSizeKt.m5042toSizeozmzZPI(this.viewportSize)) > 0) {
                        return rect;
                    }
                    rect = invoke;
                }
                i--;
            } while (i >= 0);
            return rect;
        }
        return rect;
    }
}