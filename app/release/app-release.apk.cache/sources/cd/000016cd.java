package androidx.compose.ui.platform;

import android.graphics.Region;
import android.view.View;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsOwner;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
@Metadata(d1 = {"\u0000z\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001a\u0010\u0013\u001a\u00020\n*\u0006\u0012\u0002\b\u00030\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002\u001a\f\u0010\u0017\u001a\u00020\n*\u00020\u0002H\u0002\u001a\f\u0010\u0018\u001a\u00020\n*\u00020\u0002H\u0002\u001a\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001a*\b\u0012\u0004\u0012\u00020\u001a0\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0000\u001a\"\u0010\u001e\u001a\u0004\u0018\u00010\u001f*\u00020\u001f2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\n0!H\u0002\u001a\u0018\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020$0#*\u00020%H\u0000\u001a\f\u0010&\u001a\u00020\n*\u00020\u0002H\u0002\u001a \u0010'\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\u00010(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00010(H\u0002\u001a\u0014\u0010*\u001a\u00020\n*\u00020\u00022\u0006\u0010+\u001a\u00020,H\u0002\u001a\u001b\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00010(*\u00020\u00012\u0006\u0010.\u001a\u00020\u0001H\u0080\u0002\u001a\u0016\u0010/\u001a\u0004\u0018\u000100*\u0002012\u0006\u0010\u001c\u001a\u00020\u001dH\u0000\u001a\u001b\u00102\u001a\u0004\u0018\u00010\u0006*\u000203H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b4\u00105\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0018\u0010\t\u001a\u00020\n*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000b\"\u0018\u0010\f\u001a\u00020\n*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000b\"\u0018\u0010\r\u001a\u00020\n*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b\"\u001a\u0010\u000e\u001a\u0004\u0018\u00010\n*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u001e\u0010\u0010\u001a\u00020\n*\u00020\u00028BX\u0082\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0010\u0010\u000b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00066"}, d2 = {"getTraversalIndex", "", "Landroidx/compose/ui/semantics/SemanticsNode;", "getGetTraversalIndex", "(Landroidx/compose/ui/semantics/SemanticsNode;)F", "infoContentDescriptionOrNull", "", "getInfoContentDescriptionOrNull", "(Landroidx/compose/ui/semantics/SemanticsNode;)Ljava/lang/String;", "isPassword", "", "(Landroidx/compose/ui/semantics/SemanticsNode;)Z", "isRtl", "isTextField", "isTraversalGroup", "(Landroidx/compose/ui/semantics/SemanticsNode;)Ljava/lang/Boolean;", "isVisible", "isVisible$annotations", "(Landroidx/compose/ui/semantics/SemanticsNode;)V", "accessibilityEquals", "Landroidx/compose/ui/semantics/AccessibilityAction;", "other", "", "enabled", "excludeLineAndPageGranularities", "findById", "Landroidx/compose/ui/platform/ScrollObservationScope;", "", "id", "", "findClosestParentNode", "Landroidx/compose/ui/node/LayoutNode;", "selector", "Lkotlin/Function1;", "getAllUncoveredSemanticsNodesToMap", "", "Landroidx/compose/ui/platform/SemanticsNodeWithAdjustedBounds;", "Landroidx/compose/ui/semantics/SemanticsOwner;", "hasPaneTitle", "overlaps", "Landroidx/compose/ui/platform/OpenEndRange;", "it", "propertiesDeleted", "oldNode", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$SemanticsNodeCopy;", "rangeUntil", "that", "semanticsIdToView", "Landroid/view/View;", "Landroidx/compose/ui/platform/AndroidViewsHandler;", "toLegacyClassName", "Landroidx/compose/ui/semantics/Role;", "toLegacyClassName-V4PA4sw", "(I)Ljava/lang/String;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidComposeViewAccessibilityDelegateCompat_androidKt {
    public static final /* synthetic */ boolean access$accessibilityEquals(AccessibilityAction accessibilityAction, Object obj) {
        return accessibilityEquals(accessibilityAction, obj);
    }

    public static final /* synthetic */ boolean access$enabled(SemanticsNode semanticsNode) {
        return enabled(semanticsNode);
    }

    public static final /* synthetic */ boolean access$excludeLineAndPageGranularities(SemanticsNode semanticsNode) {
        return excludeLineAndPageGranularities(semanticsNode);
    }

    public static final /* synthetic */ LayoutNode access$findClosestParentNode(LayoutNode layoutNode, Function1 function1) {
        return findClosestParentNode(layoutNode, function1);
    }

    public static final /* synthetic */ String access$getInfoContentDescriptionOrNull(SemanticsNode semanticsNode) {
        return getInfoContentDescriptionOrNull(semanticsNode);
    }

    public static final /* synthetic */ boolean access$hasPaneTitle(SemanticsNode semanticsNode) {
        return hasPaneTitle(semanticsNode);
    }

    public static final /* synthetic */ boolean access$isPassword(SemanticsNode semanticsNode) {
        return isPassword(semanticsNode);
    }

    public static final /* synthetic */ boolean access$isRtl(SemanticsNode semanticsNode) {
        return isRtl(semanticsNode);
    }

    public static final /* synthetic */ boolean access$isTextField(SemanticsNode semanticsNode) {
        return isTextField(semanticsNode);
    }

    public static final /* synthetic */ Boolean access$isTraversalGroup(SemanticsNode semanticsNode) {
        return isTraversalGroup(semanticsNode);
    }

    public static final /* synthetic */ boolean access$isVisible(SemanticsNode semanticsNode) {
        return isVisible(semanticsNode);
    }

    public static final /* synthetic */ boolean access$overlaps(OpenEndRange openEndRange, OpenEndRange openEndRange2) {
        return overlaps(openEndRange, openEndRange2);
    }

    public static final /* synthetic */ boolean access$propertiesDeleted(SemanticsNode semanticsNode, AndroidComposeViewAccessibilityDelegateCompat.SemanticsNodeCopy semanticsNodeCopy) {
        return propertiesDeleted(semanticsNode, semanticsNodeCopy);
    }

    /* renamed from: access$toLegacyClassName-V4PA4sw */
    public static final /* synthetic */ String m4165access$toLegacyClassNameV4PA4sw(int i) {
        return m4166toLegacyClassNameV4PA4sw(i);
    }

    private static /* synthetic */ void isVisible$annotations(SemanticsNode semanticsNode) {
    }

    public static final OpenEndRange<Float> rangeUntil(float f, float f2) {
        return new OpenEndFloatRange(f, f2);
    }

    public static final boolean overlaps(OpenEndRange<Float> openEndRange, OpenEndRange<Float> openEndRange2) {
        return (openEndRange.isEmpty() || openEndRange2.isEmpty() || Math.max(openEndRange.getStart().floatValue(), openEndRange2.getStart().floatValue()) >= Math.min(openEndRange.getEndExclusive().floatValue(), openEndRange2.getEndExclusive().floatValue())) ? false : true;
    }

    public static final LayoutNode findClosestParentNode(LayoutNode layoutNode, Function1<? super LayoutNode, Boolean> function1) {
        for (LayoutNode parent$ui_release = layoutNode.getParent$ui_release(); parent$ui_release != null; parent$ui_release = parent$ui_release.getParent$ui_release()) {
            if (function1.invoke(parent$ui_release).booleanValue()) {
                return parent$ui_release;
            }
        }
        return null;
    }

    public static final boolean enabled(SemanticsNode semanticsNode) {
        return SemanticsConfigurationKt.getOrNull(semanticsNode.getConfig(), SemanticsProperties.INSTANCE.getDisabled()) == null;
    }

    public static final boolean isVisible(SemanticsNode semanticsNode) {
        return (semanticsNode.isTransparent$ui_release() || semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getInvisibleToUser())) ? false : true;
    }

    public static final boolean propertiesDeleted(SemanticsNode semanticsNode, AndroidComposeViewAccessibilityDelegateCompat.SemanticsNodeCopy semanticsNodeCopy) {
        Iterator<Map.Entry<? extends SemanticsPropertyKey<?>, ? extends Object>> it = semanticsNodeCopy.getUnmergedConfig().iterator();
        while (it.hasNext()) {
            if (!semanticsNode.getConfig().contains(it.next().getKey())) {
                return true;
            }
        }
        return false;
    }

    public static final boolean hasPaneTitle(SemanticsNode semanticsNode) {
        return semanticsNode.getConfig().contains(SemanticsProperties.INSTANCE.getPaneTitle());
    }

    public static final boolean isPassword(SemanticsNode semanticsNode) {
        return semanticsNode.getConfig().contains(SemanticsProperties.INSTANCE.getPassword());
    }

    public static final boolean isTextField(SemanticsNode semanticsNode) {
        return semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getSetText());
    }

    public static final boolean isRtl(SemanticsNode semanticsNode) {
        return semanticsNode.getLayoutInfo().getLayoutDirection() == LayoutDirection.Rtl;
    }

    public static final Boolean isTraversalGroup(SemanticsNode semanticsNode) {
        return (Boolean) SemanticsConfigurationKt.getOrNull(semanticsNode.getConfig(), SemanticsProperties.INSTANCE.getIsTraversalGroup());
    }

    public static final float getGetTraversalIndex(SemanticsNode semanticsNode) {
        if (semanticsNode.getConfig().contains(SemanticsProperties.INSTANCE.getTraversalIndex())) {
            return ((Number) semanticsNode.getConfig().get(SemanticsProperties.INSTANCE.getTraversalIndex())).floatValue();
        }
        return 0.0f;
    }

    public static final String getInfoContentDescriptionOrNull(SemanticsNode semanticsNode) {
        List list = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getContentDescription());
        if (list != null) {
            return (String) CollectionsKt.firstOrNull((List<? extends Object>) list);
        }
        return null;
    }

    public static final boolean excludeLineAndPageGranularities(SemanticsNode semanticsNode) {
        SemanticsConfiguration collapsedSemantics$ui_release;
        if (!isTextField(semanticsNode) || Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getFocused()), (Object) true)) {
            LayoutNode findClosestParentNode = findClosestParentNode(semanticsNode.getLayoutNode$ui_release(), new Function1<LayoutNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt$excludeLineAndPageGranularities$ancestor$1
                /* JADX WARN: Code restructure failed: missing block: B:7:0x001c, code lost:
                    if (r3.contains(androidx.compose.ui.semantics.SemanticsActions.INSTANCE.getSetText()) != false) goto L7;
                 */
                @Override // kotlin.jvm.functions.Function1
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Boolean invoke(androidx.compose.ui.node.LayoutNode r3) {
                    /*
                        r2 = this;
                        java.lang.String r0 = "it"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                        androidx.compose.ui.semantics.SemanticsConfiguration r3 = r3.getCollapsedSemantics$ui_release()
                        if (r3 == 0) goto L1f
                        boolean r0 = r3.isMergingSemanticsOfDescendants()
                        r1 = 1
                        if (r0 != r1) goto L1f
                        androidx.compose.ui.semantics.SemanticsActions r0 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
                        androidx.compose.ui.semantics.SemanticsPropertyKey r0 = r0.getSetText()
                        boolean r3 = r3.contains(r0)
                        if (r3 == 0) goto L1f
                        goto L20
                    L1f:
                        r1 = 0
                    L20:
                        java.lang.Boolean r3 = java.lang.Boolean.valueOf(r1)
                        return r3
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt$excludeLineAndPageGranularities$ancestor$1.invoke(androidx.compose.ui.node.LayoutNode):java.lang.Boolean");
                }
            });
            return findClosestParentNode != null && ((collapsedSemantics$ui_release = findClosestParentNode.getCollapsedSemantics$ui_release()) == null || !Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(collapsedSemantics$ui_release, SemanticsProperties.INSTANCE.getFocused()), (Object) true));
        }
        return true;
    }

    public static final boolean accessibilityEquals(AccessibilityAction<?> accessibilityAction, Object obj) {
        if (accessibilityAction == obj) {
            return true;
        }
        if (obj instanceof AccessibilityAction) {
            AccessibilityAction accessibilityAction2 = (AccessibilityAction) obj;
            if (Intrinsics.areEqual(accessibilityAction.getLabel(), accessibilityAction2.getLabel())) {
                if (accessibilityAction.getAction() != null || accessibilityAction2.getAction() == null) {
                    return accessibilityAction.getAction() == null || accessibilityAction2.getAction() != null;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public static final Map<Integer, SemanticsNodeWithAdjustedBounds> getAllUncoveredSemanticsNodesToMap(SemanticsOwner semanticsOwner) {
        Intrinsics.checkNotNullParameter(semanticsOwner, "<this>");
        SemanticsNode unmergedRootSemanticsNode = semanticsOwner.getUnmergedRootSemanticsNode();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (unmergedRootSemanticsNode.getLayoutNode$ui_release().isPlaced() && unmergedRootSemanticsNode.getLayoutNode$ui_release().isAttached()) {
            Region region = new Region();
            Rect boundsInRoot = unmergedRootSemanticsNode.getBoundsInRoot();
            region.set(new android.graphics.Rect(MathKt.roundToInt(boundsInRoot.getLeft()), MathKt.roundToInt(boundsInRoot.getTop()), MathKt.roundToInt(boundsInRoot.getRight()), MathKt.roundToInt(boundsInRoot.getBottom())));
            getAllUncoveredSemanticsNodesToMap$findAllSemanticNodesRecursive(region, unmergedRootSemanticsNode, linkedHashMap, unmergedRootSemanticsNode);
        }
        return linkedHashMap;
    }

    private static final void getAllUncoveredSemanticsNodesToMap$findAllSemanticNodesRecursive(Region region, SemanticsNode semanticsNode, Map<Integer, SemanticsNodeWithAdjustedBounds> map, SemanticsNode semanticsNode2) {
        Rect rect;
        LayoutInfo layoutInfo;
        boolean z = (semanticsNode2.getLayoutNode$ui_release().isPlaced() && semanticsNode2.getLayoutNode$ui_release().isAttached()) ? false : true;
        if (!region.isEmpty() || semanticsNode2.getId() == semanticsNode.getId()) {
            if (!z || semanticsNode2.isFake$ui_release()) {
                Rect touchBoundsInRoot = semanticsNode2.getTouchBoundsInRoot();
                android.graphics.Rect rect2 = new android.graphics.Rect(MathKt.roundToInt(touchBoundsInRoot.getLeft()), MathKt.roundToInt(touchBoundsInRoot.getTop()), MathKt.roundToInt(touchBoundsInRoot.getRight()), MathKt.roundToInt(touchBoundsInRoot.getBottom()));
                Region region2 = new Region();
                region2.set(rect2);
                int id = semanticsNode2.getId() == semanticsNode.getId() ? -1 : semanticsNode2.getId();
                if (region2.op(region, region2, Region.Op.INTERSECT)) {
                    Integer valueOf = Integer.valueOf(id);
                    android.graphics.Rect bounds = region2.getBounds();
                    Intrinsics.checkNotNullExpressionValue(bounds, "region.bounds");
                    map.put(valueOf, new SemanticsNodeWithAdjustedBounds(semanticsNode2, bounds));
                    List<SemanticsNode> replacedChildren$ui_release = semanticsNode2.getReplacedChildren$ui_release();
                    for (int size = replacedChildren$ui_release.size() - 1; -1 < size; size--) {
                        getAllUncoveredSemanticsNodesToMap$findAllSemanticNodesRecursive(region, semanticsNode, map, replacedChildren$ui_release.get(size));
                    }
                    region.op(rect2, region, Region.Op.REVERSE_DIFFERENCE);
                } else if (!semanticsNode2.isFake$ui_release()) {
                    if (id == -1) {
                        Integer valueOf2 = Integer.valueOf(id);
                        android.graphics.Rect bounds2 = region2.getBounds();
                        Intrinsics.checkNotNullExpressionValue(bounds2, "region.bounds");
                        map.put(valueOf2, new SemanticsNodeWithAdjustedBounds(semanticsNode2, bounds2));
                    }
                } else {
                    SemanticsNode parent = semanticsNode2.getParent();
                    if (parent != null && (layoutInfo = parent.getLayoutInfo()) != null && layoutInfo.isPlaced()) {
                        rect = parent.getBoundsInRoot();
                    } else {
                        rect = new Rect(0.0f, 0.0f, 10.0f, 10.0f);
                    }
                    map.put(Integer.valueOf(id), new SemanticsNodeWithAdjustedBounds(semanticsNode2, new android.graphics.Rect(MathKt.roundToInt(rect.getLeft()), MathKt.roundToInt(rect.getTop()), MathKt.roundToInt(rect.getRight()), MathKt.roundToInt(rect.getBottom()))));
                }
            }
        }
    }

    public static final ScrollObservationScope findById(List<ScrollObservationScope> list, int i) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (list.get(i2).getSemanticsNodeId() == i) {
                return list.get(i2);
            }
        }
        return null;
    }

    /* renamed from: toLegacyClassName-V4PA4sw */
    public static final String m4166toLegacyClassNameV4PA4sw(int i) {
        if (Role.m4241equalsimpl0(i, Role.Companion.m4245getButtono7Vup1c())) {
            return "android.widget.Button";
        }
        if (Role.m4241equalsimpl0(i, Role.Companion.m4246getCheckboxo7Vup1c())) {
            return "android.widget.CheckBox";
        }
        if (Role.m4241equalsimpl0(i, Role.Companion.m4249getRadioButtono7Vup1c())) {
            return "android.widget.RadioButton";
        }
        if (Role.m4241equalsimpl0(i, Role.Companion.m4248getImageo7Vup1c())) {
            return "android.widget.ImageView";
        }
        if (Role.m4241equalsimpl0(i, Role.Companion.m4247getDropdownListo7Vup1c())) {
            return "android.widget.Spinner";
        }
        return null;
    }

    public static final View semanticsIdToView(AndroidViewsHandler androidViewsHandler, int i) {
        Object obj;
        Intrinsics.checkNotNullParameter(androidViewsHandler, "<this>");
        Set<Map.Entry<LayoutNode, AndroidViewHolder>> entrySet = androidViewsHandler.getLayoutNodeToHolder().entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "layoutNodeToHolder.entries");
        Iterator<T> it = entrySet.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((LayoutNode) ((Map.Entry) obj).getKey()).getSemanticsId() == i) {
                break;
            }
        }
        Map.Entry entry = (Map.Entry) obj;
        return entry != null ? (AndroidViewHolder) entry.getValue() : null;
    }
}