package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BeyondBoundsLayout.kt */
@Metadata(d1 = {"\u0000 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aD\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0019\u0010\u0005\u001a\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0006¢\u0006\u0002\b\bH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\n\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"searchBeyondBounds", "T", "Landroidx/compose/ui/focus/FocusTargetNode;", "direction", "Landroidx/compose/ui/focus/FocusDirection;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/BeyondBoundsLayout$BeyondBoundsScope;", "Lkotlin/ExtensionFunctionType;", "searchBeyondBounds--OM-vw8", "(Landroidx/compose/ui/focus/FocusTargetNode;ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BeyondBoundsLayoutKt {
    /* renamed from: searchBeyondBounds--OM-vw8  reason: not valid java name */
    public static final <T> T m2304searchBeyondBoundsOMvw8(FocusTargetNode searchBeyondBounds, int i, Function1<? super BeyondBoundsLayout.BeyondBoundsScope, ? extends T> block) {
        FocusTargetNode focusTargetNode;
        BeyondBoundsLayout beyondBoundsLayoutParent;
        int m3851getBeforehoxUOeE;
        NodeChain nodes$ui_release;
        Intrinsics.checkNotNullParameter(searchBeyondBounds, "$this$searchBeyondBounds");
        Intrinsics.checkNotNullParameter(block, "block");
        FocusTargetNode focusTargetNode2 = searchBeyondBounds;
        int m4080constructorimpl = NodeKind.m4080constructorimpl(1024);
        if (!focusTargetNode2.getNode().isAttached()) {
            throw new IllegalStateException("visitAncestors called on an unattached node".toString());
        }
        Modifier.Node parent$ui_release = focusTargetNode2.getNode().getParent$ui_release();
        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode2);
        loop0: while (true) {
            if (requireLayoutNode == null) {
                focusTargetNode = null;
                break;
            }
            if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & m4080constructorimpl) != 0) {
                while (parent$ui_release != null) {
                    if ((parent$ui_release.getKindSet$ui_release() & m4080constructorimpl) != 0) {
                        focusTargetNode = parent$ui_release;
                        MutableVector mutableVector = null;
                        while (focusTargetNode != null) {
                            if (focusTargetNode instanceof FocusTargetNode) {
                                break loop0;
                            }
                            if ((focusTargetNode.getKindSet$ui_release() & m4080constructorimpl) != 0 && (focusTargetNode instanceof DelegatingNode)) {
                                int i2 = 0;
                                for (Modifier.Node delegate$ui_release = ((DelegatingNode) focusTargetNode).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                    if ((delegate$ui_release.getKindSet$ui_release() & m4080constructorimpl) != 0) {
                                        i2++;
                                        if (i2 == 1) {
                                            focusTargetNode = delegate$ui_release;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (focusTargetNode != null) {
                                                if (mutableVector != null) {
                                                    mutableVector.add(focusTargetNode);
                                                }
                                                focusTargetNode = null;
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
                            focusTargetNode = DelegatableNodeKt.pop(mutableVector);
                        }
                        continue;
                    }
                    parent$ui_release = parent$ui_release.getParent$ui_release();
                }
            }
            requireLayoutNode = requireLayoutNode.getParent$ui_release();
            parent$ui_release = (requireLayoutNode == null || (nodes$ui_release = requireLayoutNode.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
        }
        FocusTargetNode focusTargetNode3 = focusTargetNode;
        if ((focusTargetNode3 == null || !Intrinsics.areEqual(focusTargetNode3.getBeyondBoundsLayoutParent(), searchBeyondBounds.getBeyondBoundsLayoutParent())) && (beyondBoundsLayoutParent = searchBeyondBounds.getBeyondBoundsLayoutParent()) != null) {
            if (FocusDirection.m2308equalsimpl0(i, FocusDirection.Companion.m2325getUpdhqQ8s())) {
                m3851getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.Companion.m3849getAbovehoxUOeE();
            } else if (FocusDirection.m2308equalsimpl0(i, FocusDirection.Companion.m2316getDowndhqQ8s())) {
                m3851getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.Companion.m3852getBelowhoxUOeE();
            } else if (FocusDirection.m2308equalsimpl0(i, FocusDirection.Companion.m2320getLeftdhqQ8s())) {
                m3851getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.Companion.m3853getLefthoxUOeE();
            } else if (FocusDirection.m2308equalsimpl0(i, FocusDirection.Companion.m2324getRightdhqQ8s())) {
                m3851getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.Companion.m3854getRighthoxUOeE();
            } else if (FocusDirection.m2308equalsimpl0(i, FocusDirection.Companion.m2321getNextdhqQ8s())) {
                m3851getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.Companion.m3850getAfterhoxUOeE();
            } else if (!FocusDirection.m2308equalsimpl0(i, FocusDirection.Companion.m2323getPreviousdhqQ8s())) {
                throw new IllegalStateException("Unsupported direction for beyond bounds layout".toString());
            } else {
                m3851getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.Companion.m3851getBeforehoxUOeE();
            }
            return (T) beyondBoundsLayoutParent.mo633layouto7g1Pn8(m3851getBeforehoxUOeE, block);
        }
        return null;
    }
}