package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.PointerInputModifierNodeKt;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HitPathTracker.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J7\u0010\u0017\u001a\u00020\b2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00150\u00192\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\bH\u0016ø\u0001\u0000J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010 \u001a\u00020\u001fH\u0002J\b\u0010!\u001a\u00020\u001fH\u0016J\u0010\u0010\"\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0017\u0010#\u001a\u00020\b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001f0%H\u0082\bJ7\u0010&\u001a\u00020\b2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00150\u00192\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\bH\u0016ø\u0001\u0000J\u001a\u0010'\u001a\u00020\b2\b\u0010(\u001a\u0004\u0018\u00010\r2\u0006\u0010)\u001a\u00020\rH\u0002J\u0006\u0010*\u001a\u00020\u001fJ\b\u0010+\u001a\u00020,H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006-"}, d2 = {"Landroidx/compose/ui/input/pointer/Node;", "Landroidx/compose/ui/input/pointer/NodeParent;", "modifierNode", "Landroidx/compose/ui/Modifier$Node;", "(Landroidx/compose/ui/Modifier$Node;)V", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "hasExited", "", "isIn", "getModifierNode", "()Landroidx/compose/ui/Modifier$Node;", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pointerIds", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/input/pointer/PointerId;", "getPointerIds", "()Landroidx/compose/runtime/collection/MutableVector;", "relevantChanges", "", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "wasIn", "buildCache", "changes", "", "parentCoordinates", "internalPointerEvent", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "isInBounds", "cleanUpHits", "", "clearCache", "dispatchCancel", "dispatchFinalEventPass", "dispatchIfNeeded", "block", "Lkotlin/Function0;", "dispatchMainEventPass", "hasPositionChanged", "oldEvent", "newEvent", "markIsIn", "toString", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Node extends NodeParent {
    private LayoutCoordinates coordinates;
    private boolean hasExited;
    private boolean isIn;
    private final Modifier.Node modifierNode;
    private PointerEvent pointerEvent;
    private final MutableVector<PointerId> pointerIds;
    private final Map<PointerId, PointerInputChange> relevantChanges;
    private boolean wasIn;

    public final Modifier.Node getModifierNode() {
        return this.modifierNode;
    }

    public final MutableVector<PointerId> getPointerIds() {
        return this.pointerIds;
    }

    public final void markIsIn() {
        this.isIn = true;
    }

    public Node(Modifier.Node modifierNode) {
        Intrinsics.checkNotNullParameter(modifierNode, "modifierNode");
        this.modifierNode = modifierNode;
        this.pointerIds = new MutableVector<>(new PointerId[16], 0);
        this.relevantChanges = new LinkedHashMap();
        this.isIn = true;
        this.hasExited = true;
    }

    @Override // androidx.compose.ui.input.pointer.NodeParent
    public boolean buildCache(Map<PointerId, PointerInputChange> changes, LayoutCoordinates parentCoordinates, InternalPointerEvent internalPointerEvent, boolean z) {
        int i;
        PointerInputChange pointerInputChange;
        boolean z2;
        boolean z3;
        LayoutCoordinates layoutCoordinates;
        int m3702getExit7fucELk;
        PointerInputChange m3743copyOHpmEuE;
        Intrinsics.checkNotNullParameter(changes, "changes");
        Intrinsics.checkNotNullParameter(parentCoordinates, "parentCoordinates");
        Intrinsics.checkNotNullParameter(internalPointerEvent, "internalPointerEvent");
        boolean buildCache = super.buildCache(changes, parentCoordinates, internalPointerEvent, z);
        int i2 = 1;
        if (this.modifierNode.isAttached()) {
            Modifier.Node node = this.modifierNode;
            int m4080constructorimpl = NodeKind.m4080constructorimpl(16);
            MutableVector mutableVector = null;
            while (true) {
                i = 0;
                if (node == null) {
                    break;
                }
                if (node instanceof PointerInputModifierNode) {
                    this.coordinates = PointerInputModifierNodeKt.getLayoutCoordinates((PointerInputModifierNode) node);
                } else if ((node.getKindSet$ui_release() & m4080constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                    int i3 = 0;
                    for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                        if ((delegate$ui_release.getKindSet$ui_release() & m4080constructorimpl) != 0) {
                            i3++;
                            if (i3 == 1) {
                                node = delegate$ui_release;
                            } else {
                                if (mutableVector == null) {
                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node != null) {
                                    if (mutableVector != null) {
                                        mutableVector.add(node);
                                    }
                                    node = null;
                                }
                                if (mutableVector != null) {
                                    mutableVector.add(delegate$ui_release);
                                }
                            }
                        }
                    }
                    if (i3 == 1) {
                    }
                }
                node = DelegatableNodeKt.pop(mutableVector);
            }
            for (Map.Entry<PointerId, PointerInputChange> entry : changes.entrySet()) {
                long m3733unboximpl = entry.getKey().m3733unboximpl();
                PointerInputChange value = entry.getValue();
                int size = this.pointerIds.getSize() - i2;
                if (size >= 0) {
                    int i4 = i;
                    while (true) {
                        if (this.pointerIds.getContent()[i4].m3733unboximpl() == m3733unboximpl) {
                            ArrayList arrayList = new ArrayList(value.getHistorical().size());
                            List<HistoricalChange> historical = value.getHistorical();
                            int size2 = historical.size();
                            int i5 = i;
                            while (i5 < size2) {
                                HistoricalChange historicalChange = historical.get(i5);
                                long uptimeMillis = historicalChange.getUptimeMillis();
                                LayoutCoordinates layoutCoordinates2 = this.coordinates;
                                Intrinsics.checkNotNull(layoutCoordinates2);
                                ArrayList arrayList2 = arrayList;
                                arrayList2.add(new HistoricalChange(uptimeMillis, layoutCoordinates2.mo3873localPositionOfR5De75A(parentCoordinates, historicalChange.m3675getPositionF1C5BW0()), null));
                                i5++;
                                arrayList = arrayList2;
                            }
                            ArrayList arrayList3 = arrayList;
                            Map<PointerId, PointerInputChange> map = this.relevantChanges;
                            PointerId m3727boximpl = PointerId.m3727boximpl(m3733unboximpl);
                            LayoutCoordinates layoutCoordinates3 = this.coordinates;
                            Intrinsics.checkNotNull(layoutCoordinates3);
                            long mo3873localPositionOfR5De75A = layoutCoordinates3.mo3873localPositionOfR5De75A(parentCoordinates, value.m3748getPreviousPositionF1C5BW0());
                            LayoutCoordinates layoutCoordinates4 = this.coordinates;
                            Intrinsics.checkNotNull(layoutCoordinates4);
                            m3743copyOHpmEuE = value.m3743copyOHpmEuE((r34 & 1) != 0 ? value.id : 0L, (r34 & 2) != 0 ? value.uptimeMillis : 0L, (r34 & 4) != 0 ? value.position : layoutCoordinates4.mo3873localPositionOfR5De75A(parentCoordinates, value.m3747getPositionF1C5BW0()), (r34 & 8) != 0 ? value.pressed : false, (r34 & 16) != 0 ? value.previousUptimeMillis : 0L, (r34 & 32) != 0 ? value.previousPosition : mo3873localPositionOfR5De75A, (r34 & 64) != 0 ? value.previousPressed : false, (r34 & 128) != 0 ? value.type : 0, arrayList3, (r34 & 512) != 0 ? value.scrollDelta : 0L);
                            map.put(m3727boximpl, m3743copyOHpmEuE);
                        } else if (i4 != size) {
                            i4++;
                            i = 0;
                        }
                    }
                }
                i2 = 1;
                i = 0;
            }
            if (this.relevantChanges.isEmpty()) {
                this.pointerIds.clear();
                getChildren().clear();
                return true;
            }
            for (int size3 = this.pointerIds.getSize() - 1; -1 < size3; size3--) {
                if (!changes.containsKey(PointerId.m3727boximpl(this.pointerIds.getContent()[size3].m3733unboximpl()))) {
                    this.pointerIds.removeAt(size3);
                }
            }
            PointerEvent pointerEvent = new PointerEvent(CollectionsKt.toList(this.relevantChanges.values()), internalPointerEvent);
            List<PointerInputChange> changes2 = pointerEvent.getChanges();
            int size4 = changes2.size();
            int i6 = 0;
            while (true) {
                if (i6 >= size4) {
                    pointerInputChange = null;
                    break;
                }
                PointerInputChange pointerInputChange2 = changes2.get(i6);
                if (internalPointerEvent.m3677issuesEnterExitEvent0FcD4WY(pointerInputChange2.m3746getIdJ3iCeTQ())) {
                    pointerInputChange = pointerInputChange2;
                    break;
                }
                i6++;
            }
            PointerInputChange pointerInputChange3 = pointerInputChange;
            if (pointerInputChange3 != null) {
                if (z) {
                    z2 = false;
                    if (!this.isIn && (pointerInputChange3.getPressed() || pointerInputChange3.getPreviousPressed())) {
                        Intrinsics.checkNotNull(this.coordinates);
                        z3 = true;
                        this.isIn = !PointerEventKt.m3692isOutOfBoundsO0kMr_c(pointerInputChange3, layoutCoordinates.mo3872getSizeYbymL2g());
                        if (this.isIn == this.wasIn && (PointerEventType.m3697equalsimpl0(pointerEvent.m3690getType7fucELk(), PointerEventType.Companion.m3703getMove7fucELk()) || PointerEventType.m3697equalsimpl0(pointerEvent.m3690getType7fucELk(), PointerEventType.Companion.m3701getEnter7fucELk()) || PointerEventType.m3697equalsimpl0(pointerEvent.m3690getType7fucELk(), PointerEventType.Companion.m3702getExit7fucELk()))) {
                            if (this.isIn) {
                                m3702getExit7fucELk = PointerEventType.Companion.m3701getEnter7fucELk();
                            } else {
                                m3702getExit7fucELk = PointerEventType.Companion.m3702getExit7fucELk();
                            }
                            pointerEvent.m3691setTypeEhbLWgg$ui_release(m3702getExit7fucELk);
                        } else if (!PointerEventType.m3697equalsimpl0(pointerEvent.m3690getType7fucELk(), PointerEventType.Companion.m3701getEnter7fucELk()) && this.wasIn && !this.hasExited) {
                            pointerEvent.m3691setTypeEhbLWgg$ui_release(PointerEventType.Companion.m3703getMove7fucELk());
                        } else if (PointerEventType.m3697equalsimpl0(pointerEvent.m3690getType7fucELk(), PointerEventType.Companion.m3702getExit7fucELk()) && this.isIn && pointerInputChange3.getPressed()) {
                            pointerEvent.m3691setTypeEhbLWgg$ui_release(PointerEventType.Companion.m3703getMove7fucELk());
                        }
                    }
                } else {
                    z2 = false;
                    this.isIn = false;
                }
                z3 = true;
                if (this.isIn == this.wasIn) {
                }
                if (!PointerEventType.m3697equalsimpl0(pointerEvent.m3690getType7fucELk(), PointerEventType.Companion.m3701getEnter7fucELk())) {
                }
                if (PointerEventType.m3697equalsimpl0(pointerEvent.m3690getType7fucELk(), PointerEventType.Companion.m3702getExit7fucELk())) {
                    pointerEvent.m3691setTypeEhbLWgg$ui_release(PointerEventType.Companion.m3703getMove7fucELk());
                }
            } else {
                z2 = false;
                z3 = true;
            }
            boolean z4 = (buildCache || !PointerEventType.m3697equalsimpl0(pointerEvent.m3690getType7fucELk(), PointerEventType.Companion.m3703getMove7fucELk()) || hasPositionChanged(this.pointerEvent, pointerEvent)) ? z3 : z2;
            this.pointerEvent = pointerEvent;
            return z4;
        }
        return true;
    }

    private final boolean hasPositionChanged(PointerEvent pointerEvent, PointerEvent pointerEvent2) {
        if (pointerEvent == null || pointerEvent.getChanges().size() != pointerEvent2.getChanges().size()) {
            return true;
        }
        int size = pointerEvent2.getChanges().size();
        for (int i = 0; i < size; i++) {
            if (!Offset.m2386equalsimpl0(pointerEvent.getChanges().get(i).m3747getPositionF1C5BW0(), pointerEvent2.getChanges().get(i).m3747getPositionF1C5BW0())) {
                return true;
            }
        }
        return false;
    }

    private final void clearCache() {
        this.relevantChanges.clear();
        this.coordinates = null;
    }

    private final boolean dispatchIfNeeded(Function0<Unit> function0) {
        if (!this.relevantChanges.isEmpty() && this.modifierNode.isAttached()) {
            function0.invoke();
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0027  */
    @Override // androidx.compose.ui.input.pointer.NodeParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void dispatchCancel() {
        /*
            r10 = this;
            androidx.compose.runtime.collection.MutableVector r0 = r10.getChildren()
            int r1 = r0.getSize()
            r2 = 0
            r3 = 1
            if (r1 <= 0) goto L1b
            java.lang.Object[] r0 = r0.getContent()
            r4 = r2
        L11:
            r5 = r0[r4]
            androidx.compose.ui.input.pointer.Node r5 = (androidx.compose.ui.input.pointer.Node) r5
            r5.dispatchCancel()
            int r4 = r4 + r3
            if (r4 < r1) goto L11
        L1b:
            androidx.compose.ui.Modifier$Node r0 = r10.modifierNode
            r1 = 16
            int r4 = androidx.compose.ui.node.NodeKind.m4080constructorimpl(r1)
            r5 = 0
            r6 = r5
        L25:
            if (r0 == 0) goto L76
            boolean r7 = r0 instanceof androidx.compose.ui.node.PointerInputModifierNode
            if (r7 == 0) goto L31
            androidx.compose.ui.node.PointerInputModifierNode r0 = (androidx.compose.ui.node.PointerInputModifierNode) r0
            r0.onCancelPointerInput()
            goto L71
        L31:
            int r7 = r0.getKindSet$ui_release()
            r7 = r7 & r4
            if (r7 == 0) goto L71
            boolean r7 = r0 instanceof androidx.compose.ui.node.DelegatingNode
            if (r7 == 0) goto L71
            r7 = r0
            androidx.compose.ui.node.DelegatingNode r7 = (androidx.compose.ui.node.DelegatingNode) r7
            androidx.compose.ui.Modifier$Node r7 = r7.getDelegate$ui_release()
            r8 = r2
        L44:
            if (r7 == 0) goto L6e
            int r9 = r7.getKindSet$ui_release()
            r9 = r9 & r4
            if (r9 == 0) goto L69
            int r8 = r8 + 1
            if (r8 != r3) goto L53
            r0 = r7
            goto L69
        L53:
            if (r6 != 0) goto L5c
            androidx.compose.runtime.collection.MutableVector r6 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r9 = new androidx.compose.ui.Modifier.Node[r1]
            r6.<init>(r9, r2)
        L5c:
            if (r0 == 0) goto L64
            if (r6 == 0) goto L63
            r6.add(r0)
        L63:
            r0 = r5
        L64:
            if (r6 == 0) goto L69
            r6.add(r7)
        L69:
            androidx.compose.ui.Modifier$Node r7 = r7.getChild$ui_release()
            goto L44
        L6e:
            if (r8 != r3) goto L71
            goto L25
        L71:
            androidx.compose.ui.Modifier$Node r0 = androidx.compose.ui.node.DelegatableNodeKt.access$pop(r6)
            goto L25
        L76:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.Node.dispatchCancel():void");
    }

    @Override // androidx.compose.ui.input.pointer.NodeParent
    public void cleanUpHits(InternalPointerEvent internalPointerEvent) {
        Intrinsics.checkNotNullParameter(internalPointerEvent, "internalPointerEvent");
        super.cleanUpHits(internalPointerEvent);
        PointerEvent pointerEvent = this.pointerEvent;
        if (pointerEvent == null) {
            return;
        }
        this.wasIn = this.isIn;
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        for (int i = 0; i < size; i++) {
            PointerInputChange pointerInputChange = changes.get(i);
            if (!pointerInputChange.getPressed() && (!internalPointerEvent.m3677issuesEnterExitEvent0FcD4WY(pointerInputChange.m3746getIdJ3iCeTQ()) || !this.isIn)) {
                this.pointerIds.remove(PointerId.m3727boximpl(pointerInputChange.m3746getIdJ3iCeTQ()));
            }
        }
        this.isIn = false;
        this.hasExited = PointerEventType.m3697equalsimpl0(pointerEvent.m3690getType7fucELk(), PointerEventType.Companion.m3702getExit7fucELk());
    }

    public String toString() {
        return "Node(pointerInputFilter=" + this.modifierNode + ", children=" + getChildren() + ", pointerIds=" + this.pointerIds + ')';
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00c0  */
    @Override // androidx.compose.ui.input.pointer.NodeParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean dispatchMainEventPass(java.util.Map<androidx.compose.ui.input.pointer.PointerId, androidx.compose.ui.input.pointer.PointerInputChange> r12, androidx.compose.ui.layout.LayoutCoordinates r13, androidx.compose.ui.input.pointer.InternalPointerEvent r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.Node.dispatchMainEventPass(java.util.Map, androidx.compose.ui.layout.LayoutCoordinates, androidx.compose.ui.input.pointer.InternalPointerEvent, boolean):boolean");
    }

    @Override // androidx.compose.ui.input.pointer.NodeParent
    public boolean dispatchFinalEventPass(InternalPointerEvent internalPointerEvent) {
        MutableVector<Node> children;
        int size;
        Intrinsics.checkNotNullParameter(internalPointerEvent, "internalPointerEvent");
        boolean z = false;
        int i = 0;
        z = false;
        if (!this.relevantChanges.isEmpty() && this.modifierNode.isAttached()) {
            PointerEvent pointerEvent = this.pointerEvent;
            Intrinsics.checkNotNull(pointerEvent);
            LayoutCoordinates layoutCoordinates = this.coordinates;
            Intrinsics.checkNotNull(layoutCoordinates);
            long mo3872getSizeYbymL2g = layoutCoordinates.mo3872getSizeYbymL2g();
            Modifier.Node node = this.modifierNode;
            int m4080constructorimpl = NodeKind.m4080constructorimpl(16);
            MutableVector mutableVector = null;
            while (node != null) {
                if (node instanceof PointerInputModifierNode) {
                    ((PointerInputModifierNode) node).mo141onPointerEventH0pRuoY(pointerEvent, PointerEventPass.Final, mo3872getSizeYbymL2g);
                } else if ((node.getKindSet$ui_release() & m4080constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                    int i2 = 0;
                    for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                        if ((delegate$ui_release.getKindSet$ui_release() & m4080constructorimpl) != 0) {
                            i2++;
                            if (i2 == 1) {
                                node = delegate$ui_release;
                            } else {
                                if (mutableVector == null) {
                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node != null) {
                                    if (mutableVector != null) {
                                        mutableVector.add(node);
                                    }
                                    node = null;
                                }
                                if (mutableVector != null) {
                                    mutableVector.add(delegate$ui_release);
                                }
                            }
                        }
                    }
                    if (i2 == 1) {
                    }
                }
                node = DelegatableNodeKt.pop(mutableVector);
            }
            if (!this.modifierNode.isAttached() || (size = (children = getChildren()).getSize()) <= 0) {
                z = true;
            } else {
                Node[] content = children.getContent();
                do {
                    content[i].dispatchFinalEventPass(internalPointerEvent);
                    i++;
                } while (i < size);
                z = true;
            }
        }
        cleanUpHits(internalPointerEvent);
        clearCache();
        return z;
    }
}