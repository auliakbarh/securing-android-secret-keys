package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FocusInvalidationManager.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0018\u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\tJ\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000bJ\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\rJ%\u0010\u000f\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0011*\b\u0012\u0004\u0012\u0002H\u00110\b2\u0006\u0010\u0010\u001a\u0002H\u0011H\u0002¢\u0006\u0002\u0010\u0012R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/focus/FocusInvalidationManager;", "", "onRequestApplyChangesListener", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function1;)V", "focusEventNodes", "", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "focusPropertiesNodes", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "focusTargetNodes", "Landroidx/compose/ui/focus/FocusTargetNode;", "invalidateNodes", "scheduleInvalidation", "node", "T", "(Ljava/util/Set;Ljava/lang/Object;)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FocusInvalidationManager {
    private Set<FocusEventModifierNode> focusEventNodes;
    private Set<FocusPropertiesModifierNode> focusPropertiesNodes;
    private Set<FocusTargetNode> focusTargetNodes;
    private final Function0<Unit> invalidateNodes;
    private final Function1<Function0<Unit>, Unit> onRequestApplyChangesListener;

    /* JADX WARN: Multi-variable type inference failed */
    public FocusInvalidationManager(Function1<? super Function0<Unit>, Unit> onRequestApplyChangesListener) {
        Intrinsics.checkNotNullParameter(onRequestApplyChangesListener, "onRequestApplyChangesListener");
        this.onRequestApplyChangesListener = onRequestApplyChangesListener;
        this.focusTargetNodes = new LinkedHashSet();
        this.focusEventNodes = new LinkedHashSet();
        this.focusPropertiesNodes = new LinkedHashSet();
        this.invalidateNodes = new Function0<Unit>() { // from class: androidx.compose.ui.focus.FocusInvalidationManager$invalidateNodes$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Set set;
                Set set2;
                Set<FocusEventModifierNode> set3;
                Set set4;
                Set<FocusTargetNode> set5;
                Set set6;
                Set set7;
                Set set8;
                Set set9;
                int i;
                FocusStateImpl focusStateImpl;
                FocusStateImpl focusStateImpl2;
                Set set10;
                Set set11;
                Set set12;
                Set set13;
                set = FocusInvalidationManager.this.focusPropertiesNodes;
                FocusInvalidationManager focusInvalidationManager = FocusInvalidationManager.this;
                Iterator it = set.iterator();
                while (true) {
                    int i2 = 1024;
                    int i3 = 1;
                    if (!it.hasNext()) {
                        set2 = FocusInvalidationManager.this.focusPropertiesNodes;
                        set2.clear();
                        LinkedHashSet linkedHashSet = new LinkedHashSet();
                        set3 = FocusInvalidationManager.this.focusEventNodes;
                        FocusInvalidationManager focusInvalidationManager2 = FocusInvalidationManager.this;
                        for (FocusEventModifierNode focusEventModifierNode : set3) {
                            if (focusEventModifierNode.getNode().isAttached()) {
                                FocusEventModifierNode focusEventModifierNode2 = focusEventModifierNode;
                                int m4080constructorimpl = NodeKind.m4080constructorimpl(i2);
                                Modifier.Node node = focusEventModifierNode2.getNode();
                                int i4 = 0;
                                int i5 = i3;
                                FocusTargetNode focusTargetNode = null;
                                MutableVector mutableVector = null;
                                while (node != null) {
                                    if (node instanceof FocusTargetNode) {
                                        FocusTargetNode focusTargetNode2 = (FocusTargetNode) node;
                                        if (focusTargetNode != null) {
                                            i4 = i3;
                                        }
                                        set11 = focusInvalidationManager2.focusTargetNodes;
                                        if (set11.contains(focusTargetNode2)) {
                                            linkedHashSet.add(focusTargetNode2);
                                            i5 = 0;
                                        }
                                        focusTargetNode = focusTargetNode2;
                                    } else if ((node.getKindSet$ui_release() & m4080constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                                        Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release();
                                        int i6 = 0;
                                        while (delegate$ui_release != null) {
                                            if ((delegate$ui_release.getKindSet$ui_release() & m4080constructorimpl) != 0) {
                                                i6++;
                                                if (i6 == i3) {
                                                    node = delegate$ui_release;
                                                } else {
                                                    if (mutableVector == null) {
                                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                    }
                                                    if (node != null) {
                                                        if (mutableVector != null) {
                                                            Boolean.valueOf(mutableVector.add(node));
                                                        }
                                                        node = null;
                                                    }
                                                    if (mutableVector != null) {
                                                        Boolean.valueOf(mutableVector.add(delegate$ui_release));
                                                    }
                                                }
                                            }
                                            delegate$ui_release = delegate$ui_release.getChild$ui_release();
                                            i3 = 1;
                                        }
                                        int i7 = i3;
                                        if (i6 == i7) {
                                            i3 = i7;
                                        }
                                    }
                                    node = DelegatableNodeKt.pop(mutableVector);
                                    i3 = 1;
                                }
                                if (!focusEventModifierNode2.getNode().isAttached()) {
                                    throw new IllegalStateException("visitChildren called on an unattached node".toString());
                                }
                                MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                Modifier.Node child$ui_release = focusEventModifierNode2.getNode().getChild$ui_release();
                                if (child$ui_release == null) {
                                    DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, focusEventModifierNode2.getNode());
                                } else {
                                    mutableVector2.add(child$ui_release);
                                }
                                while (mutableVector2.isNotEmpty()) {
                                    Modifier.Node node2 = (Modifier.Node) mutableVector2.removeAt(mutableVector2.getSize() - 1);
                                    if ((node2.getAggregateChildKindSet$ui_release() & m4080constructorimpl) == 0) {
                                        DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, node2);
                                    } else {
                                        while (node2 != null) {
                                            if ((node2.getKindSet$ui_release() & m4080constructorimpl) != 0) {
                                                MutableVector mutableVector3 = null;
                                                while (node2 != null) {
                                                    if (node2 instanceof FocusTargetNode) {
                                                        FocusTargetNode focusTargetNode3 = (FocusTargetNode) node2;
                                                        if (focusTargetNode != null) {
                                                            i4 = 1;
                                                        }
                                                        set10 = focusInvalidationManager2.focusTargetNodes;
                                                        if (set10.contains(focusTargetNode3)) {
                                                            linkedHashSet.add(focusTargetNode3);
                                                            i5 = 0;
                                                        }
                                                        focusTargetNode = focusTargetNode3;
                                                    } else if ((node2.getKindSet$ui_release() & m4080constructorimpl) != 0 && (node2 instanceof DelegatingNode)) {
                                                        int i8 = 0;
                                                        for (Modifier.Node delegate$ui_release2 = ((DelegatingNode) node2).getDelegate$ui_release(); delegate$ui_release2 != null; delegate$ui_release2 = delegate$ui_release2.getChild$ui_release()) {
                                                            if ((delegate$ui_release2.getKindSet$ui_release() & m4080constructorimpl) != 0) {
                                                                i8++;
                                                                if (i8 == 1) {
                                                                    node2 = delegate$ui_release2;
                                                                } else {
                                                                    if (mutableVector3 == null) {
                                                                        mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                                                    }
                                                                    if (node2 != null) {
                                                                        if (mutableVector3 != null) {
                                                                            Boolean.valueOf(mutableVector3.add(node2));
                                                                        }
                                                                        node2 = null;
                                                                    }
                                                                    if (mutableVector3 != null) {
                                                                        Boolean.valueOf(mutableVector3.add(delegate$ui_release2));
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        if (i8 != 1) {
                                                            node2 = DelegatableNodeKt.pop(mutableVector3);
                                                        }
                                                    }
                                                    node2 = DelegatableNodeKt.pop(mutableVector3);
                                                }
                                            } else {
                                                node2 = node2.getChild$ui_release();
                                            }
                                        }
                                    }
                                }
                                i = 1;
                                if (i5 != 0) {
                                    if (i4 != 0) {
                                        focusStateImpl2 = FocusEventModifierNodeKt.getFocusState(focusEventModifierNode);
                                    } else {
                                        if (focusTargetNode == null || (focusStateImpl = focusTargetNode.getFocusState()) == null) {
                                            focusStateImpl = FocusStateImpl.Inactive;
                                        }
                                        focusStateImpl2 = focusStateImpl;
                                    }
                                    focusEventModifierNode.onFocusEvent(focusStateImpl2);
                                }
                            } else {
                                focusEventModifierNode.onFocusEvent(FocusStateImpl.Inactive);
                                i = i3;
                            }
                            i3 = i;
                            i2 = 1024;
                        }
                        set4 = FocusInvalidationManager.this.focusEventNodes;
                        set4.clear();
                        set5 = FocusInvalidationManager.this.focusTargetNodes;
                        for (FocusTargetNode focusTargetNode4 : set5) {
                            if (focusTargetNode4.isAttached()) {
                                FocusStateImpl focusState = focusTargetNode4.getFocusState();
                                focusTargetNode4.invalidateFocus$ui_release();
                                if (focusState != focusTargetNode4.getFocusState() || linkedHashSet.contains(focusTargetNode4)) {
                                    FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode4);
                                }
                            }
                        }
                        set6 = FocusInvalidationManager.this.focusTargetNodes;
                        set6.clear();
                        linkedHashSet.clear();
                        set7 = FocusInvalidationManager.this.focusPropertiesNodes;
                        if (!set7.isEmpty()) {
                            throw new IllegalStateException("Unprocessed FocusProperties nodes".toString());
                        }
                        set8 = FocusInvalidationManager.this.focusEventNodes;
                        if (!set8.isEmpty()) {
                            throw new IllegalStateException("Unprocessed FocusEvent nodes".toString());
                        }
                        set9 = FocusInvalidationManager.this.focusTargetNodes;
                        if (!set9.isEmpty()) {
                            throw new IllegalStateException("Unprocessed FocusTarget nodes".toString());
                        }
                        return;
                    }
                    FocusPropertiesModifierNode focusPropertiesModifierNode = (FocusPropertiesModifierNode) it.next();
                    if (focusPropertiesModifierNode.getNode().isAttached()) {
                        FocusPropertiesModifierNode focusPropertiesModifierNode2 = focusPropertiesModifierNode;
                        int m4080constructorimpl2 = NodeKind.m4080constructorimpl(1024);
                        Modifier.Node node3 = focusPropertiesModifierNode2.getNode();
                        MutableVector mutableVector4 = null;
                        while (node3 != null) {
                            if (node3 instanceof FocusTargetNode) {
                                set13 = focusInvalidationManager.focusTargetNodes;
                                set13.add((FocusTargetNode) node3);
                            } else if ((node3.getKindSet$ui_release() & m4080constructorimpl2) != 0 && (node3 instanceof DelegatingNode)) {
                                int i9 = 0;
                                for (Modifier.Node delegate$ui_release3 = ((DelegatingNode) node3).getDelegate$ui_release(); delegate$ui_release3 != null; delegate$ui_release3 = delegate$ui_release3.getChild$ui_release()) {
                                    if ((delegate$ui_release3.getKindSet$ui_release() & m4080constructorimpl2) != 0) {
                                        i9++;
                                        if (i9 == 1) {
                                            node3 = delegate$ui_release3;
                                        } else {
                                            if (mutableVector4 == null) {
                                                mutableVector4 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (node3 != null) {
                                                if (mutableVector4 != null) {
                                                    Boolean.valueOf(mutableVector4.add(node3));
                                                }
                                                node3 = null;
                                            }
                                            if (mutableVector4 != null) {
                                                Boolean.valueOf(mutableVector4.add(delegate$ui_release3));
                                            }
                                        }
                                    }
                                }
                                if (i9 == 1) {
                                }
                            }
                            node3 = DelegatableNodeKt.pop(mutableVector4);
                        }
                        if (!focusPropertiesModifierNode2.getNode().isAttached()) {
                            throw new IllegalStateException("visitChildren called on an unattached node".toString());
                        }
                        MutableVector mutableVector5 = new MutableVector(new Modifier.Node[16], 0);
                        Modifier.Node child$ui_release2 = focusPropertiesModifierNode2.getNode().getChild$ui_release();
                        if (child$ui_release2 == null) {
                            DelegatableNodeKt.addLayoutNodeChildren(mutableVector5, focusPropertiesModifierNode2.getNode());
                        } else {
                            mutableVector5.add(child$ui_release2);
                        }
                        while (mutableVector5.isNotEmpty()) {
                            Modifier.Node node4 = (Modifier.Node) mutableVector5.removeAt(mutableVector5.getSize() - 1);
                            if ((node4.getAggregateChildKindSet$ui_release() & m4080constructorimpl2) == 0) {
                                DelegatableNodeKt.addLayoutNodeChildren(mutableVector5, node4);
                            } else {
                                while (true) {
                                    if (node4 == null) {
                                        break;
                                    } else if ((node4.getKindSet$ui_release() & m4080constructorimpl2) != 0) {
                                        MutableVector mutableVector6 = null;
                                        while (node4 != null) {
                                            if (node4 instanceof FocusTargetNode) {
                                                set12 = focusInvalidationManager.focusTargetNodes;
                                                set12.add((FocusTargetNode) node4);
                                            } else if ((node4.getKindSet$ui_release() & m4080constructorimpl2) != 0 && (node4 instanceof DelegatingNode)) {
                                                int i10 = 0;
                                                for (Modifier.Node delegate$ui_release4 = ((DelegatingNode) node4).getDelegate$ui_release(); delegate$ui_release4 != null; delegate$ui_release4 = delegate$ui_release4.getChild$ui_release()) {
                                                    if ((delegate$ui_release4.getKindSet$ui_release() & m4080constructorimpl2) != 0) {
                                                        i10++;
                                                        if (i10 == 1) {
                                                            node4 = delegate$ui_release4;
                                                        } else {
                                                            if (mutableVector6 == null) {
                                                                mutableVector6 = new MutableVector(new Modifier.Node[16], 0);
                                                            }
                                                            if (node4 != null) {
                                                                if (mutableVector6 != null) {
                                                                    Boolean.valueOf(mutableVector6.add(node4));
                                                                }
                                                                node4 = null;
                                                            }
                                                            if (mutableVector6 != null) {
                                                                Boolean.valueOf(mutableVector6.add(delegate$ui_release4));
                                                            }
                                                        }
                                                    }
                                                }
                                                if (i10 == 1) {
                                                }
                                            }
                                            node4 = DelegatableNodeKt.pop(mutableVector6);
                                        }
                                    } else {
                                        node4 = node4.getChild$ui_release();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        };
    }

    public final void scheduleInvalidation(FocusTargetNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        scheduleInvalidation(this.focusTargetNodes, node);
    }

    public final void scheduleInvalidation(FocusEventModifierNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        scheduleInvalidation(this.focusEventNodes, node);
    }

    public final void scheduleInvalidation(FocusPropertiesModifierNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        scheduleInvalidation(this.focusPropertiesNodes, node);
    }

    private final <T> void scheduleInvalidation(Set<T> set, T t) {
        if (set.add(t) && this.focusTargetNodes.size() + this.focusEventNodes.size() + this.focusPropertiesNodes.size() == 1) {
            this.onRequestApplyChangesListener.invoke(this.invalidateNodes);
        }
    }
}