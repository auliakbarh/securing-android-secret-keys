package androidx.compose.runtime;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.collection.IdentityScopeMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Composition.kt */
@Metadata(d1 = {"\u0000æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0094\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010U\u001a\u00020\u001cH\u0002J\u001e\u0010V\u001a\u00020\u001c2\f\u0010W\u001a\b\u0012\u0004\u0012\u00020/0X2\u0006\u0010Y\u001a\u00020\u0010H\u0002J\b\u0010Z\u001a\u00020\u001cH\u0016Jc\u0010[\u001a\u00020\u001c2Y\u0010\u0013\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0006¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c0\u0015j\u0002`\u001d0\u0014H\u0002J\b\u0010\\\u001a\u00020\u001cH\u0016J\b\u0010]\u001a\u00020\u001cH\u0016J\b\u0010^\u001a\u00020\u001cH\u0002J \u0010_\u001a\u00020\u001c2\u0011\u0010`\u001a\r\u0012\u0004\u0012\u00020\u001c0\u001f¢\u0006\u0002\b H\u0016¢\u0006\u0002\u0010$J3\u0010a\u001a\u0002Hb\"\u0004\b\u0000\u0010b2\b\u0010c\u001a\u0004\u0018\u00010\u00012\u0006\u0010d\u001a\u00020;2\f\u0010e\u001a\b\u0012\u0004\u0012\u0002Hb0\u001fH\u0016¢\u0006\u0002\u0010fJ\b\u0010g\u001a\u00020\u001cH\u0016J\u0010\u0010h\u001a\u00020\u001c2\u0006\u0010i\u001a\u00020jH\u0016J\b\u0010k\u001a\u00020\u001cH\u0002J\b\u0010l\u001a\u00020\u001cH\u0002J\"\u0010m\u001a\u0002Hn\"\u0004\b\u0000\u0010n2\f\u0010e\u001a\b\u0012\u0004\u0012\u0002Hn0\u001fH\u0082\b¢\u0006\u0002\u0010oJK\u0010p\u001a\u0002Hn\"\u0004\b\u0000\u0010n25\u0010e\u001a1\u0012'\u0012%\u0012\u0004\u0012\u00020*\u0012\f\u0012\n\u0012\u0004\u0012\u00020/\u0018\u00010>0=¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u0002Hn0qH\u0082\b¢\u0006\u0002\u0010rJ$\u0010s\u001a\u00020\u001c2\u001a\u0010t\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020v\u0012\u0006\u0012\u0004\u0018\u00010v0u0)H\u0016J\u001a\u0010w\u001a\u00020x2\u0006\u0010y\u001a\u00020*2\b\u0010z\u001a\u0004\u0018\u00010/H\u0016J\b\u0010{\u001a\u00020\u001cH\u0016J\"\u0010|\u001a\u00020x2\u0006\u0010y\u001a\u00020*2\u0006\u0010}\u001a\u00020~2\b\u0010z\u001a\u0004\u0018\u00010/H\u0002J\u000f\u0010\u007f\u001a\u00020\u001c2\u0007\u0010\u0080\u0001\u001a\u00020;J\u0012\u0010\u0081\u0001\u001a\u00020\u001c2\u0007\u0010\u0082\u0001\u001a\u00020/H\u0002J\u0017\u0010\u0083\u0001\u001a\u00020\u00102\f\u0010W\u001a\b\u0012\u0004\u0012\u00020/0XH\u0016J\u0017\u0010\u0084\u0001\u001a\u00020\u001c2\f\u0010e\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001fH\u0016J\t\u0010\u0085\u0001\u001a\u00020\u0010H\u0016J\u0011\u0010\u0086\u0001\u001a\u00020\u001c2\u0006\u0010y\u001a\u00020*H\u0016J\u0017\u0010\u0087\u0001\u001a\u00020\u001c2\f\u0010W\u001a\b\u0012\u0004\u0012\u00020/0XH\u0016J\u0012\u0010\u0088\u0001\u001a\u00020\u001c2\u0007\u0010\u0082\u0001\u001a\u00020/H\u0016J\u0012\u0010\u0089\u0001\u001a\u00020\u001c2\u0007\u0010\u0082\u0001\u001a\u00020/H\u0016J\u001b\u0010\u008a\u0001\u001a\u00020\u001c2\n\u0010i\u001a\u0006\u0012\u0002\b\u000303H\u0000¢\u0006\u0003\b\u008b\u0001J\u001f\u0010\u008c\u0001\u001a\u00020\u001c2\u0006\u0010z\u001a\u00020/2\u0006\u0010y\u001a\u00020*H\u0000¢\u0006\u0003\b\u008d\u0001J!\u0010\u008e\u0001\u001a\u00020\u001c2\u0011\u0010`\u001a\r\u0012\u0004\u0012\u00020\u001c0\u001f¢\u0006\u0002\b H\u0016¢\u0006\u0002\u0010$J\u001d\u0010\u008f\u0001\u001a\u0016\u0012\u0004\u0012\u00020*\u0012\f\u0012\n\u0012\u0004\u0012\u00020/\u0018\u00010>0=H\u0002J#\u0010\u0090\u0001\u001a\u0002Hn\"\u0004\b\u0000\u0010n2\f\u0010e\u001a\b\u0012\u0004\u0012\u0002Hn0\u001fH\u0082\b¢\u0006\u0002\u0010oJ\u001b\u0010\u0091\u0001\u001a\u00020\u00102\u0006\u0010y\u001a\u00020*2\b\u0010z\u001a\u0004\u0018\u00010/H\u0002J\u0011\u0010\u0092\u0001\u001a\u00020\u001c2\u0006\u0010Q\u001a\u00020RH\u0002J\t\u0010\u0093\u0001\u001a\u00020\u001cH\u0016JE\u0010V\u001a\u0016\u0012\u0004\u0012\u00020*\u0018\u00010\fj\n\u0012\u0004\u0012\u00020*\u0018\u0001`\u000e*\u0016\u0012\u0004\u0012\u00020*\u0018\u00010\fj\n\u0012\u0004\u0012\u00020*\u0018\u0001`\u000e2\u0007\u0010\u0082\u0001\u001a\u00020/2\u0006\u0010Y\u001a\u00020\u0010H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012Ra\u0010\u0013\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0006¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c0\u0015j\u0002`\u001d0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R'\u0010\u001e\u001a\r\u0012\u0004\u0012\u00020\u001c0\u001f¢\u0006\u0002\b X\u0086\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u001e\u0010-\u001a\u0012\u0012\u0004\u0012\u00020*0\fj\b\u0012\u0004\u0012\u00020*`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020/0)8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b0\u0010,R\u0018\u00101\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030302X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u0010\u0012R\u0014\u00107\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b8\u0010\u0012R\u0010\u00109\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010<\u001a\u0016\u0012\u0004\u0012\u00020*\u0012\f\u0012\n\u0012\u0004\u0012\u00020/\u0018\u00010>0=X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010?\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b?\u0010\u0012R\u0014\u0010@\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b@\u0010\u0012R\u0011\u0010A\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u0012Ra\u0010B\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0006¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c0\u0015j\u0002`\u001d0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010D\u001a\b\u0012\u0004\u0012\u00020*02X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010E\u001a\b\u0012\u0004\u0012\u00020*02X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010F\u001a\b\u0012\u0004\u0012\u00020/0)8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bG\u0010,R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010H\u001a\u00020\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0012\"\u0004\bJ\u0010KR\"\u0010L\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010/0Mj\n\u0012\u0006\u0012\u0004\u0018\u00010/`NX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\bO\u0010PR\u0014\u0010Q\u001a\u00020RX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u0010T¨\u0006\u0095\u0001"}, d2 = {"Landroidx/compose/runtime/CompositionImpl;", "Landroidx/compose/runtime/ControlledComposition;", "Landroidx/compose/runtime/RecomposeScopeOwner;", "parent", "Landroidx/compose/runtime/CompositionContext;", "applier", "Landroidx/compose/runtime/Applier;", "recomposeContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroidx/compose/runtime/CompositionContext;Landroidx/compose/runtime/Applier;Lkotlin/coroutines/CoroutineContext;)V", "_recomposeContext", "abandonSet", "Ljava/util/HashSet;", "Landroidx/compose/runtime/RememberObserver;", "Lkotlin/collections/HashSet;", "areChildrenComposing", "", "getAreChildrenComposing", "()Z", "changes", "", "Lkotlin/Function3;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "", "Landroidx/compose/runtime/Change;", "composable", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "getComposable", "()Lkotlin/jvm/functions/Function2;", "setComposable", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "composer", "Landroidx/compose/runtime/ComposerImpl;", "conditionalScopes", "", "Landroidx/compose/runtime/RecomposeScopeImpl;", "getConditionalScopes$runtime_release", "()Ljava/util/List;", "conditionallyInvalidatedScopes", "derivedStateDependencies", "", "getDerivedStateDependencies$runtime_release", "derivedStates", "Landroidx/compose/runtime/collection/IdentityScopeMap;", "Landroidx/compose/runtime/DerivedState;", "disposed", "hasInvalidations", "getHasInvalidations", "hasPendingChanges", "getHasPendingChanges", "invalidationDelegate", "invalidationDelegateGroup", "", "invalidations", "Landroidx/compose/runtime/collection/IdentityArrayMap;", "Landroidx/compose/runtime/collection/IdentityArraySet;", "isComposing", "isDisposed", "isRoot", "lateChanges", "lock", "observations", "observationsProcessed", "observedObjects", "getObservedObjects$runtime_release", "pendingInvalidScopes", "getPendingInvalidScopes$runtime_release", "setPendingInvalidScopes$runtime_release", "(Z)V", "pendingModifications", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/AtomicReference;", "getRecomposeContext", "()Lkotlin/coroutines/CoroutineContext;", "slotTable", "Landroidx/compose/runtime/SlotTable;", "getSlotTable$runtime_release", "()Landroidx/compose/runtime/SlotTable;", "abandonChanges", "addPendingInvalidationsLocked", "values", "", "forgetConditionalScopes", "applyChanges", "applyChangesInLocked", "applyLateChanges", "changesApplied", "cleanUpDerivedStateObservations", "composeContent", "content", "delegateInvalidations", "R", "to", "groupIndex", "block", "(Landroidx/compose/runtime/ControlledComposition;ILkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "dispose", "disposeUnusedMovableContent", "state", "Landroidx/compose/runtime/MovableContentState;", "drainPendingModificationsForCompositionLocked", "drainPendingModificationsLocked", "guardChanges", "T", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "guardInvalidationsLocked", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "insertMovableContent", "references", "Lkotlin/Pair;", "Landroidx/compose/runtime/MovableContentStateReference;", "invalidate", "Landroidx/compose/runtime/InvalidationResult;", "scope", "instance", "invalidateAll", "invalidateChecked", "anchor", "Landroidx/compose/runtime/Anchor;", "invalidateGroupsWithKey", "key", "invalidateScopeOfLocked", "value", "observesAnyOf", "prepareCompose", "recompose", "recomposeScopeReleased", "recordModificationsOf", "recordReadOf", "recordWriteOf", "removeDerivedStateObservation", "removeDerivedStateObservation$runtime_release", "removeObservation", "removeObservation$runtime_release", "setContent", "takeInvalidations", "trackAbandonedValues", "tryImminentInvalidation", "validateRecomposeScopeAnchors", "verifyConsistent", "RememberEventDispatcher", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CompositionImpl implements ControlledComposition, RecomposeScopeOwner {
    private final CoroutineContext _recomposeContext;
    private final HashSet<RememberObserver> abandonSet;
    private final Applier<?> applier;
    private final List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> changes;
    private Function2<? super Composer, ? super Integer, Unit> composable;
    private final ComposerImpl composer;
    private final HashSet<RecomposeScopeImpl> conditionallyInvalidatedScopes;
    private final IdentityScopeMap<DerivedState<?>> derivedStates;
    private boolean disposed;
    private CompositionImpl invalidationDelegate;
    private int invalidationDelegateGroup;
    private IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> invalidations;
    private final boolean isRoot;
    private final List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> lateChanges;
    private final Object lock;
    private final IdentityScopeMap<RecomposeScopeImpl> observations;
    private final IdentityScopeMap<RecomposeScopeImpl> observationsProcessed;
    private final CompositionContext parent;
    private boolean pendingInvalidScopes;
    private final AtomicReference<Object> pendingModifications;
    private final SlotTable slotTable;

    public final Function2<Composer, Integer, Unit> getComposable() {
        return this.composable;
    }

    public final boolean getPendingInvalidScopes$runtime_release() {
        return this.pendingInvalidScopes;
    }

    public final SlotTable getSlotTable$runtime_release() {
        return this.slotTable;
    }

    @Override // androidx.compose.runtime.Composition
    public boolean isDisposed() {
        return this.disposed;
    }

    public final boolean isRoot() {
        return this.isRoot;
    }

    @Override // androidx.compose.runtime.RecomposeScopeOwner
    public void recomposeScopeReleased(RecomposeScopeImpl scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.pendingInvalidScopes = true;
    }

    public final void setComposable(Function2<? super Composer, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.composable = function2;
    }

    public final void setPendingInvalidScopes$runtime_release(boolean z) {
        this.pendingInvalidScopes = z;
    }

    public CompositionImpl(CompositionContext parent, Applier<?> applier, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(applier, "applier");
        this.parent = parent;
        this.applier = applier;
        this.pendingModifications = new AtomicReference<>(null);
        this.lock = new Object();
        HashSet<RememberObserver> hashSet = new HashSet<>();
        this.abandonSet = hashSet;
        SlotTable slotTable = new SlotTable();
        this.slotTable = slotTable;
        this.observations = new IdentityScopeMap<>();
        this.conditionallyInvalidatedScopes = new HashSet<>();
        this.derivedStates = new IdentityScopeMap<>();
        ArrayList arrayList = new ArrayList();
        this.changes = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.lateChanges = arrayList2;
        this.observationsProcessed = new IdentityScopeMap<>();
        this.invalidations = new IdentityArrayMap<>(0, 1, null);
        ComposerImpl composerImpl = new ComposerImpl(applier, parent, slotTable, hashSet, arrayList, arrayList2, this);
        parent.registerComposer$runtime_release(composerImpl);
        this.composer = composerImpl;
        this._recomposeContext = coroutineContext;
        this.isRoot = parent instanceof Recomposer;
        this.composable = ComposableSingletons$CompositionKt.INSTANCE.m2237getLambda1$runtime_release();
    }

    public /* synthetic */ CompositionImpl(CompositionContext compositionContext, Applier applier, CoroutineContext coroutineContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(compositionContext, applier, (i & 4) != 0 ? null : coroutineContext);
    }

    public final List<Object> getObservedObjects$runtime_release() {
        return ArraysKt.filterNotNull(this.observations.getValues());
    }

    public final List<Object> getDerivedStateDependencies$runtime_release() {
        return ArraysKt.filterNotNull(this.derivedStates.getValues());
    }

    public final List<RecomposeScopeImpl> getConditionalScopes$runtime_release() {
        return CollectionsKt.toList(this.conditionallyInvalidatedScopes);
    }

    public final CoroutineContext getRecomposeContext() {
        CoroutineContext coroutineContext = this._recomposeContext;
        return coroutineContext == null ? this.parent.getRecomposeCoroutineContext$runtime_release() : coroutineContext;
    }

    private final boolean getAreChildrenComposing() {
        return this.composer.getAreChildrenComposing$runtime_release();
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean isComposing() {
        return this.composer.isComposing$runtime_release();
    }

    @Override // androidx.compose.runtime.Composition
    public void setContent(Function2<? super Composer, ? super Integer, Unit> content) {
        Intrinsics.checkNotNullParameter(content, "content");
        if (!(!this.disposed)) {
            throw new IllegalStateException("The composition is disposed".toString());
        }
        this.composable = content;
        this.parent.composeInitial$runtime_release(this, content);
    }

    private final void drainPendingModificationsForCompositionLocked() {
        Object andSet = this.pendingModifications.getAndSet(CompositionKt.access$getPendingApplyNoModifications$p());
        if (andSet != null) {
            if (Intrinsics.areEqual(andSet, CompositionKt.access$getPendingApplyNoModifications$p())) {
                ComposerKt.composeRuntimeError("pending composition has not been applied");
                throw new KotlinNothingValueException();
            } else if (andSet instanceof Set) {
                addPendingInvalidationsLocked((Set) andSet, true);
            } else if (!(andSet instanceof Object[])) {
                ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
                throw new KotlinNothingValueException();
            } else {
                for (Set<? extends Object> set : (Set[]) andSet) {
                    addPendingInvalidationsLocked(set, true);
                }
            }
        }
    }

    private final void drainPendingModificationsLocked() {
        Object andSet = this.pendingModifications.getAndSet(null);
        if (Intrinsics.areEqual(andSet, CompositionKt.access$getPendingApplyNoModifications$p())) {
            return;
        }
        if (andSet instanceof Set) {
            addPendingInvalidationsLocked((Set) andSet, false);
        } else if (!(andSet instanceof Object[])) {
            if (andSet == null) {
                ComposerKt.composeRuntimeError("calling recordModificationsOf and applyChanges concurrently is not supported");
                throw new KotlinNothingValueException();
            } else {
                ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
                throw new KotlinNothingValueException();
            }
        } else {
            for (Set<? extends Object> set : (Set[]) andSet) {
                addPendingInvalidationsLocked(set, false);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r1v14, types: [java.util.Set[]] */
    @Override // androidx.compose.runtime.ControlledComposition
    public void recordModificationsOf(Set<? extends Object> values) {
        Object obj;
        Set<? extends Object> set;
        Intrinsics.checkNotNullParameter(values, "values");
        do {
            obj = this.pendingModifications.get();
            if (obj == null || Intrinsics.areEqual(obj, CompositionKt.access$getPendingApplyNoModifications$p())) {
                set = values;
            } else if (obj instanceof Set) {
                set = new Set[]{obj, values};
            } else if (!(obj instanceof Object[])) {
                throw new IllegalStateException(("corrupt pendingModifications: " + this.pendingModifications).toString());
            } else {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.collections.Set<kotlin.Any>>");
                set = ArraysKt.plus((Set<? extends Object>[]) obj, values);
            }
        } while (!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.pendingModifications, obj, set));
        if (obj == null) {
            synchronized (this.lock) {
                drainPendingModificationsLocked();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0010  */
    @Override // androidx.compose.runtime.ControlledComposition
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean observesAnyOf(java.util.Set<? extends java.lang.Object> r3) {
        /*
            r2 = this;
            java.lang.String r0 = "values"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.util.Iterator r3 = r3.iterator()
        La:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L26
            java.lang.Object r0 = r3.next()
            androidx.compose.runtime.collection.IdentityScopeMap<androidx.compose.runtime.RecomposeScopeImpl> r1 = r2.observations
            boolean r1 = r1.contains(r0)
            if (r1 != 0) goto L24
            androidx.compose.runtime.collection.IdentityScopeMap<androidx.compose.runtime.DerivedState<?>> r1 = r2.derivedStates
            boolean r0 = r1.contains(r0)
            if (r0 == 0) goto La
        L24:
            r3 = 1
            return r3
        L26:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.observesAnyOf(java.util.Set):boolean");
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void prepareCompose(Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.composer.prepareCompose$runtime_release(block);
    }

    @Override // androidx.compose.runtime.ControlledComposition, androidx.compose.runtime.RecomposeScopeOwner
    public void recordReadOf(Object value) {
        RecomposeScopeImpl currentRecomposeScope$runtime_release;
        Object[] dependencies;
        Intrinsics.checkNotNullParameter(value, "value");
        if (getAreChildrenComposing() || (currentRecomposeScope$runtime_release = this.composer.getCurrentRecomposeScope$runtime_release()) == null) {
            return;
        }
        currentRecomposeScope$runtime_release.setUsed(true);
        if (currentRecomposeScope$runtime_release.recordRead(value)) {
            return;
        }
        this.observations.add(value, currentRecomposeScope$runtime_release);
        if (value instanceof DerivedState) {
            this.derivedStates.removeScope(value);
            for (Object obj : ((DerivedState) value).getCurrentRecord().getDependencies()) {
                if (obj == null) {
                    return;
                }
                this.derivedStates.add(obj, value);
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void disposeUnusedMovableContent(MovableContentState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        RememberEventDispatcher rememberEventDispatcher = new RememberEventDispatcher(this.abandonSet);
        SlotWriter openWriter = state.getSlotTable$runtime_release().openWriter();
        try {
            ComposerKt.removeCurrentGroup(openWriter, rememberEventDispatcher);
            Unit unit = Unit.INSTANCE;
            openWriter.close();
            rememberEventDispatcher.dispatchRememberObservers();
        } catch (Throwable th) {
            openWriter.close();
            throw th;
        }
    }

    private final void applyChangesInLocked(List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> list) {
        boolean isEmpty;
        RememberEventDispatcher rememberEventDispatcher = new RememberEventDispatcher(this.abandonSet);
        try {
            if (list.isEmpty()) {
                if (isEmpty) {
                    return;
                }
                return;
            }
            Object beginSection = Trace.INSTANCE.beginSection("Compose:applyChanges");
            this.applier.onBeginChanges();
            SlotWriter openWriter = this.slotTable.openWriter();
            try {
                Applier<?> applier = this.applier;
                int size = list.size();
                int i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    list.get(i2).invoke(applier, openWriter, rememberEventDispatcher);
                }
                list.clear();
                Unit unit = Unit.INSTANCE;
                openWriter.close();
                this.applier.onEndChanges();
                Unit unit2 = Unit.INSTANCE;
                Trace.INSTANCE.endSection(beginSection);
                rememberEventDispatcher.dispatchRememberObservers();
                rememberEventDispatcher.dispatchSideEffects();
                if (this.pendingInvalidScopes) {
                    Object beginSection2 = Trace.INSTANCE.beginSection("Compose:unobserve");
                    this.pendingInvalidScopes = false;
                    IdentityScopeMap<RecomposeScopeImpl> identityScopeMap = this.observations;
                    int[] valueOrder = identityScopeMap.getValueOrder();
                    IdentityArraySet<RecomposeScopeImpl>[] scopeSets = identityScopeMap.getScopeSets();
                    Object[] values = identityScopeMap.getValues();
                    int size2 = identityScopeMap.getSize();
                    int i3 = 0;
                    int i4 = 0;
                    while (i3 < size2) {
                        int i5 = valueOrder[i3];
                        IdentityArraySet<RecomposeScopeImpl> identityArraySet = scopeSets[i5];
                        Intrinsics.checkNotNull(identityArraySet);
                        Object[] values2 = identityArraySet.getValues();
                        int size3 = identityArraySet.size();
                        int i6 = i;
                        while (i < size3) {
                            IdentityArraySet<RecomposeScopeImpl>[] identityArraySetArr = scopeSets;
                            Object obj = values2[i];
                            int i7 = size2;
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                            if (!(!((RecomposeScopeImpl) obj).getValid())) {
                                if (i6 != i) {
                                    values2[i6] = obj;
                                }
                                i6++;
                            }
                            i++;
                            scopeSets = identityArraySetArr;
                            size2 = i7;
                        }
                        IdentityArraySet<RecomposeScopeImpl>[] identityArraySetArr2 = scopeSets;
                        int i8 = size2;
                        for (int i9 = i6; i9 < size3; i9++) {
                            values2[i9] = null;
                        }
                        ((IdentityArraySet) identityArraySet).size = i6;
                        if (identityArraySet.size() > 0) {
                            if (i4 != i3) {
                                int i10 = valueOrder[i4];
                                valueOrder[i4] = i5;
                                valueOrder[i3] = i10;
                            }
                            i4++;
                        }
                        i3++;
                        scopeSets = identityArraySetArr2;
                        size2 = i8;
                        i = 0;
                    }
                    int size4 = identityScopeMap.getSize();
                    for (int i11 = i4; i11 < size4; i11++) {
                        values[valueOrder[i11]] = null;
                    }
                    identityScopeMap.setSize(i4);
                    cleanUpDerivedStateObservations();
                    Unit unit3 = Unit.INSTANCE;
                    Trace.INSTANCE.endSection(beginSection2);
                }
                if (this.lateChanges.isEmpty()) {
                    rememberEventDispatcher.dispatchAbandons();
                }
            } catch (Throwable th) {
                openWriter.close();
                throw th;
            }
        } finally {
            if (this.lateChanges.isEmpty()) {
                rememberEventDispatcher.dispatchAbandons();
            }
        }
    }

    private final <T> T guardInvalidationsLocked(Function1<? super IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>>, ? extends T> function1) {
        IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> takeInvalidations = takeInvalidations();
        try {
            return function1.invoke(takeInvalidations);
        } catch (Exception e) {
            this.invalidations = takeInvalidations;
            throw e;
        }
    }

    private final void abandonChanges() {
        this.pendingModifications.set(null);
        this.changes.clear();
        this.lateChanges.clear();
        this.abandonSet.clear();
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public <R> R delegateInvalidations(ControlledComposition controlledComposition, int i, Function0<? extends R> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (controlledComposition != null && !Intrinsics.areEqual(controlledComposition, this) && i >= 0) {
            this.invalidationDelegate = (CompositionImpl) controlledComposition;
            this.invalidationDelegateGroup = i;
            try {
                return block.invoke();
            } finally {
                this.invalidationDelegate = null;
                this.invalidationDelegateGroup = 0;
            }
        }
        return block.invoke();
    }

    @Override // androidx.compose.runtime.RecomposeScopeOwner
    public InvalidationResult invalidate(RecomposeScopeImpl scope, Object obj) {
        CompositionImpl compositionImpl;
        Intrinsics.checkNotNullParameter(scope, "scope");
        if (scope.getDefaultsInScope()) {
            scope.setDefaultsInvalid(true);
        }
        Anchor anchor = scope.getAnchor();
        if (anchor == null || !anchor.getValid()) {
            return InvalidationResult.IGNORED;
        }
        if (this.slotTable.ownsAnchor(anchor)) {
            if (!scope.getCanRecompose()) {
                return InvalidationResult.IGNORED;
            }
            return invalidateChecked(scope, anchor, obj);
        }
        synchronized (this.lock) {
            compositionImpl = this.invalidationDelegate;
        }
        if (compositionImpl != null && compositionImpl.tryImminentInvalidation(scope, obj)) {
            return InvalidationResult.IMMINENT;
        }
        return InvalidationResult.IGNORED;
    }

    private final boolean tryImminentInvalidation(RecomposeScopeImpl recomposeScopeImpl, Object obj) {
        return isComposing() && this.composer.tryImminentInvalidation$runtime_release(recomposeScopeImpl, obj);
    }

    public final void removeObservation$runtime_release(Object instance, RecomposeScopeImpl scope) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.observations.remove(instance, scope);
    }

    public final void removeDerivedStateObservation$runtime_release(DerivedState<?> state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (this.observations.contains(state)) {
            return;
        }
        this.derivedStates.removeScope(state);
    }

    private final IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> takeInvalidations() {
        IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> identityArrayMap = this.invalidations;
        this.invalidations = new IdentityArrayMap<>(0, 1, null);
        return identityArrayMap;
    }

    private final void validateRecomposeScopeAnchors(SlotTable slotTable) {
        Object[] slots = slotTable.getSlots();
        ArrayList arrayList = new ArrayList();
        for (Object obj : slots) {
            RecomposeScopeImpl recomposeScopeImpl = obj instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) obj : null;
            if (recomposeScopeImpl != null) {
                arrayList.add(recomposeScopeImpl);
            }
        }
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) arrayList2.get(i);
            Anchor anchor = recomposeScopeImpl2.getAnchor();
            if (anchor != null && !slotTable.slotsOf$runtime_release(anchor.toIndexFor(slotTable)).contains(recomposeScopeImpl2)) {
                throw new IllegalStateException(("Misaligned anchor " + anchor + " in scope " + recomposeScopeImpl2 + " encountered, scope found at " + ArraysKt.indexOf((RecomposeScopeImpl[]) slotTable.getSlots(), recomposeScopeImpl2)).toString());
            }
        }
    }

    private final <T> T trackAbandonedValues(Function0<? extends T> function0) {
        try {
            T invoke = function0.invoke();
            InlineMarker.finallyStart(1);
            InlineMarker.finallyEnd(1);
            return invoke;
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            if (!this.abandonSet.isEmpty()) {
                new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
            }
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Composition.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u000eJ\u0010\u0010\t\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u0016\u0010\u0013\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/compose/runtime/CompositionImpl$RememberEventDispatcher;", "Landroidx/compose/runtime/RememberManager;", "abandoning", "", "Landroidx/compose/runtime/RememberObserver;", "(Ljava/util/Set;)V", "deactivating", "", "Landroidx/compose/runtime/ComposeNodeLifecycleCallback;", "forgetting", "releasing", "remembering", "sideEffects", "Lkotlin/Function0;", "", "instance", "dispatchAbandons", "dispatchRememberObservers", "dispatchSideEffects", "sideEffect", "effect", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class RememberEventDispatcher implements RememberManager {
        private final Set<RememberObserver> abandoning;
        private List<ComposeNodeLifecycleCallback> deactivating;
        private final List<RememberObserver> forgetting;
        private List<ComposeNodeLifecycleCallback> releasing;
        private final List<RememberObserver> remembering;
        private final List<Function0<Unit>> sideEffects;

        public RememberEventDispatcher(Set<RememberObserver> abandoning) {
            Intrinsics.checkNotNullParameter(abandoning, "abandoning");
            this.abandoning = abandoning;
            this.remembering = new ArrayList();
            this.forgetting = new ArrayList();
            this.sideEffects = new ArrayList();
        }

        @Override // androidx.compose.runtime.RememberManager
        public void remembering(RememberObserver instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            int lastIndexOf = this.forgetting.lastIndexOf(instance);
            if (lastIndexOf >= 0) {
                this.forgetting.remove(lastIndexOf);
                this.abandoning.remove(instance);
                return;
            }
            this.remembering.add(instance);
        }

        @Override // androidx.compose.runtime.RememberManager
        public void forgetting(RememberObserver instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            int lastIndexOf = this.remembering.lastIndexOf(instance);
            if (lastIndexOf >= 0) {
                this.remembering.remove(lastIndexOf);
                this.abandoning.remove(instance);
                return;
            }
            this.forgetting.add(instance);
        }

        @Override // androidx.compose.runtime.RememberManager
        public void sideEffect(Function0<Unit> effect) {
            Intrinsics.checkNotNullParameter(effect, "effect");
            this.sideEffects.add(effect);
        }

        @Override // androidx.compose.runtime.RememberManager
        public void deactivating(ComposeNodeLifecycleCallback instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            ArrayList arrayList = this.deactivating;
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.deactivating = arrayList;
            }
            arrayList.add(instance);
        }

        @Override // androidx.compose.runtime.RememberManager
        public void releasing(ComposeNodeLifecycleCallback instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            ArrayList arrayList = this.releasing;
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.releasing = arrayList;
            }
            arrayList.add(instance);
        }

        public final void dispatchRememberObservers() {
            Object beginSection;
            List<ComposeNodeLifecycleCallback> list = this.deactivating;
            List<ComposeNodeLifecycleCallback> list2 = list;
            if (list2 != null && !list2.isEmpty()) {
                beginSection = Trace.INSTANCE.beginSection("Compose:deactivations");
                try {
                    for (int size = list.size() - 1; -1 < size; size--) {
                        list.get(size).onDeactivate();
                    }
                    Unit unit = Unit.INSTANCE;
                    Trace.INSTANCE.endSection(beginSection);
                    list.clear();
                } finally {
                }
            }
            if (!this.forgetting.isEmpty()) {
                beginSection = Trace.INSTANCE.beginSection("Compose:onForgotten");
                try {
                    for (int size2 = this.forgetting.size() - 1; -1 < size2; size2--) {
                        RememberObserver rememberObserver = this.forgetting.get(size2);
                        if (!this.abandoning.contains(rememberObserver)) {
                            rememberObserver.onForgotten();
                        }
                    }
                    Unit unit2 = Unit.INSTANCE;
                } finally {
                }
            }
            if (!this.remembering.isEmpty()) {
                beginSection = Trace.INSTANCE.beginSection("Compose:onRemembered");
                try {
                    List<RememberObserver> list3 = this.remembering;
                    int size3 = list3.size();
                    for (int i = 0; i < size3; i++) {
                        RememberObserver rememberObserver2 = list3.get(i);
                        this.abandoning.remove(rememberObserver2);
                        rememberObserver2.onRemembered();
                    }
                    Unit unit3 = Unit.INSTANCE;
                } finally {
                }
            }
            List<ComposeNodeLifecycleCallback> list4 = this.releasing;
            List<ComposeNodeLifecycleCallback> list5 = list4;
            if (list5 == null || list5.isEmpty()) {
                return;
            }
            beginSection = Trace.INSTANCE.beginSection("Compose:releases");
            try {
                for (int size4 = list4.size() - 1; -1 < size4; size4--) {
                    list4.get(size4).onRelease();
                }
                Unit unit4 = Unit.INSTANCE;
                Trace.INSTANCE.endSection(beginSection);
                list4.clear();
            } finally {
            }
        }

        public final void dispatchSideEffects() {
            if (!this.sideEffects.isEmpty()) {
                Object beginSection = Trace.INSTANCE.beginSection("Compose:sideeffects");
                try {
                    List<Function0<Unit>> list = this.sideEffects;
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        list.get(i).invoke();
                    }
                    this.sideEffects.clear();
                    Unit unit = Unit.INSTANCE;
                } finally {
                    Trace.INSTANCE.endSection(beginSection);
                }
            }
        }

        public final void dispatchAbandons() {
            if (!this.abandoning.isEmpty()) {
                Object beginSection = Trace.INSTANCE.beginSection("Compose:abandons");
                try {
                    Iterator<RememberObserver> it = this.abandoning.iterator();
                    while (it.hasNext()) {
                        it.remove();
                        it.next().onAbandoned();
                    }
                    Unit unit = Unit.INSTANCE;
                } finally {
                    Trace.INSTANCE.endSection(beginSection);
                }
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean getHasPendingChanges() {
        boolean hasPendingChanges$runtime_release;
        synchronized (this.lock) {
            hasPendingChanges$runtime_release = this.composer.getHasPendingChanges$runtime_release();
        }
        return hasPendingChanges$runtime_release;
    }

    public final void invalidateGroupsWithKey(int i) {
        List<RecomposeScopeImpl> invalidateGroupsWithKey$runtime_release;
        synchronized (this.lock) {
            invalidateGroupsWithKey$runtime_release = this.slotTable.invalidateGroupsWithKey$runtime_release(i);
        }
        if (invalidateGroupsWithKey$runtime_release != null) {
            int size = invalidateGroupsWithKey$runtime_release.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (invalidateGroupsWithKey$runtime_release.get(i2).invalidateForResult(null) != InvalidationResult.IGNORED) {
                }
            }
            return;
        }
        if (this.composer.forceRecomposeScopes$runtime_release()) {
            this.parent.invalidate$runtime_release(this);
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void composeContent(Function2<? super Composer, ? super Integer, Unit> content) {
        Intrinsics.checkNotNullParameter(content, "content");
        try {
            synchronized (this.lock) {
                drainPendingModificationsForCompositionLocked();
                IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> takeInvalidations = takeInvalidations();
                try {
                    this.composer.composeContent$runtime_release(takeInvalidations, content);
                    Unit unit = Unit.INSTANCE;
                    Unit unit2 = Unit.INSTANCE;
                } catch (Exception e) {
                    this.invalidations = takeInvalidations;
                    throw e;
                }
            }
            Unit unit3 = Unit.INSTANCE;
        } catch (Throwable th) {
            try {
                if (!this.abandonSet.isEmpty()) {
                    new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                }
                throw th;
            } catch (Exception e2) {
                abandonChanges();
                throw e2;
            }
        }
    }

    @Override // androidx.compose.runtime.Composition
    public void dispose() {
        synchronized (this.lock) {
            if (!this.disposed) {
                this.disposed = true;
                this.composable = ComposableSingletons$CompositionKt.INSTANCE.m2238getLambda2$runtime_release();
                List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> deferredChanges$runtime_release = this.composer.getDeferredChanges$runtime_release();
                if (deferredChanges$runtime_release != null) {
                    applyChangesInLocked(deferredChanges$runtime_release);
                }
                boolean z = this.slotTable.getGroupsSize() > 0;
                if (z || (true ^ this.abandonSet.isEmpty())) {
                    RememberEventDispatcher rememberEventDispatcher = new RememberEventDispatcher(this.abandonSet);
                    if (z) {
                        this.applier.onBeginChanges();
                        SlotWriter openWriter = this.slotTable.openWriter();
                        ComposerKt.removeCurrentGroup(openWriter, rememberEventDispatcher);
                        Unit unit = Unit.INSTANCE;
                        openWriter.close();
                        this.applier.clear();
                        this.applier.onEndChanges();
                        rememberEventDispatcher.dispatchRememberObservers();
                    }
                    rememberEventDispatcher.dispatchAbandons();
                }
                this.composer.dispose$runtime_release();
            }
            Unit unit2 = Unit.INSTANCE;
        }
        this.parent.unregisterComposition$runtime_release(this);
    }

    @Override // androidx.compose.runtime.Composition
    public boolean getHasInvalidations() {
        boolean z;
        synchronized (this.lock) {
            z = this.invalidations.getSize() > 0;
        }
        return z;
    }

    private final HashSet<RecomposeScopeImpl> addPendingInvalidationsLocked(HashSet<RecomposeScopeImpl> hashSet, Object obj, boolean z) {
        IdentityScopeMap<RecomposeScopeImpl> identityScopeMap = this.observations;
        int find = identityScopeMap.find(obj);
        if (find >= 0) {
            IdentityArraySet scopeSetAt = identityScopeMap.scopeSetAt(find);
            Object[] values = scopeSetAt.getValues();
            int size = scopeSetAt.size();
            for (int i = 0; i < size; i++) {
                Object obj2 = values[i];
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) obj2;
                if (!this.observationsProcessed.remove(obj, recomposeScopeImpl) && recomposeScopeImpl.invalidateForResult(obj) != InvalidationResult.IGNORED) {
                    if (recomposeScopeImpl.isConditional() && !z) {
                        this.conditionallyInvalidatedScopes.add(recomposeScopeImpl);
                    } else {
                        if (hashSet == null) {
                            hashSet = new HashSet<>();
                        }
                        hashSet.add(recomposeScopeImpl);
                    }
                }
            }
        }
        return hashSet;
    }

    private final void addPendingInvalidationsLocked(Set<? extends Object> set, boolean z) {
        HashSet<RecomposeScopeImpl> hashSet;
        int i;
        boolean z2;
        if (set instanceof IdentityArraySet) {
            IdentityArraySet identityArraySet = (IdentityArraySet) set;
            Object[] values = identityArraySet.getValues();
            int size = identityArraySet.size();
            hashSet = null;
            for (int i2 = 0; i2 < size; i2++) {
                Object obj = values[i2];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                if (obj instanceof RecomposeScopeImpl) {
                    ((RecomposeScopeImpl) obj).invalidateForResult(null);
                } else {
                    hashSet = addPendingInvalidationsLocked(hashSet, obj, z);
                    IdentityScopeMap<DerivedState<?>> identityScopeMap = this.derivedStates;
                    int find = identityScopeMap.find(obj);
                    if (find >= 0) {
                        IdentityArraySet scopeSetAt = identityScopeMap.scopeSetAt(find);
                        Object[] values2 = scopeSetAt.getValues();
                        int size2 = scopeSetAt.size();
                        for (int i3 = 0; i3 < size2; i3++) {
                            Object obj2 = values2[i3];
                            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                            hashSet = addPendingInvalidationsLocked(hashSet, (DerivedState) obj2, z);
                        }
                    }
                }
            }
        } else {
            hashSet = null;
            for (Object obj3 : set) {
                if (obj3 instanceof RecomposeScopeImpl) {
                    ((RecomposeScopeImpl) obj3).invalidateForResult(null);
                } else {
                    HashSet<RecomposeScopeImpl> addPendingInvalidationsLocked = addPendingInvalidationsLocked(hashSet, obj3, z);
                    IdentityScopeMap<DerivedState<?>> identityScopeMap2 = this.derivedStates;
                    int find2 = identityScopeMap2.find(obj3);
                    if (find2 >= 0) {
                        IdentityArraySet scopeSetAt2 = identityScopeMap2.scopeSetAt(find2);
                        Object[] values3 = scopeSetAt2.getValues();
                        int size3 = scopeSetAt2.size();
                        for (int i4 = 0; i4 < size3; i4++) {
                            Object obj4 = values3[i4];
                            Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                            addPendingInvalidationsLocked = addPendingInvalidationsLocked(addPendingInvalidationsLocked, (DerivedState) obj4, z);
                        }
                    }
                    hashSet = addPendingInvalidationsLocked;
                }
            }
        }
        if (z) {
            boolean z3 = true;
            if (!this.conditionallyInvalidatedScopes.isEmpty()) {
                IdentityScopeMap<RecomposeScopeImpl> identityScopeMap3 = this.observations;
                int[] valueOrder = identityScopeMap3.getValueOrder();
                IdentityArraySet<RecomposeScopeImpl>[] scopeSets = identityScopeMap3.getScopeSets();
                Object[] values4 = identityScopeMap3.getValues();
                int size4 = identityScopeMap3.getSize();
                int i5 = 0;
                int i6 = 0;
                while (i5 < size4) {
                    int i7 = valueOrder[i5];
                    IdentityArraySet<RecomposeScopeImpl> identityArraySet2 = scopeSets[i7];
                    Intrinsics.checkNotNull(identityArraySet2);
                    Object[] values5 = identityArraySet2.getValues();
                    int size5 = identityArraySet2.size();
                    int i8 = 0;
                    int i9 = 0;
                    while (i8 < size5) {
                        Object obj5 = values5[i8];
                        Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                        IdentityArraySet<RecomposeScopeImpl>[] identityArraySetArr = scopeSets;
                        RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) obj5;
                        int i10 = size4;
                        if (this.conditionallyInvalidatedScopes.contains(recomposeScopeImpl)) {
                            i = i9;
                            z2 = true;
                        } else {
                            if (hashSet != null) {
                                z2 = true;
                                if (hashSet.contains(recomposeScopeImpl)) {
                                    i = i9;
                                }
                            } else {
                                z2 = true;
                            }
                            int i11 = i9;
                            if (i11 != i8) {
                                values5[i11] = obj5;
                            }
                            i9 = i11 + 1;
                            i8++;
                            scopeSets = identityArraySetArr;
                            z3 = z2;
                            size4 = i10;
                        }
                        i9 = i;
                        i8++;
                        scopeSets = identityArraySetArr;
                        z3 = z2;
                        size4 = i10;
                    }
                    IdentityArraySet<RecomposeScopeImpl>[] identityArraySetArr2 = scopeSets;
                    int i12 = size4;
                    int i13 = i9;
                    boolean z4 = z3;
                    for (int i14 = i13; i14 < size5; i14++) {
                        values5[i14] = null;
                    }
                    ((IdentityArraySet) identityArraySet2).size = i13;
                    if (identityArraySet2.size() > 0) {
                        if (i6 != i5) {
                            int i15 = valueOrder[i6];
                            valueOrder[i6] = i7;
                            valueOrder[i5] = i15;
                        }
                        i6++;
                    }
                    i5++;
                    scopeSets = identityArraySetArr2;
                    z3 = z4;
                    size4 = i12;
                }
                int size6 = identityScopeMap3.getSize();
                for (int i16 = i6; i16 < size6; i16++) {
                    values4[valueOrder[i16]] = null;
                }
                identityScopeMap3.setSize(i6);
                this.conditionallyInvalidatedScopes.clear();
                cleanUpDerivedStateObservations();
                return;
            }
        }
        if (hashSet != null) {
            IdentityScopeMap<RecomposeScopeImpl> identityScopeMap4 = this.observations;
            int[] valueOrder2 = identityScopeMap4.getValueOrder();
            IdentityArraySet<RecomposeScopeImpl>[] scopeSets2 = identityScopeMap4.getScopeSets();
            Object[] values6 = identityScopeMap4.getValues();
            int size7 = identityScopeMap4.getSize();
            int i17 = 0;
            int i18 = 0;
            while (i17 < size7) {
                int i19 = valueOrder2[i17];
                IdentityArraySet<RecomposeScopeImpl> identityArraySet3 = scopeSets2[i19];
                Intrinsics.checkNotNull(identityArraySet3);
                Object[] values7 = identityArraySet3.getValues();
                int size8 = identityArraySet3.size();
                int i20 = 0;
                int i21 = 0;
                while (i20 < size8) {
                    Object obj6 = values7[i20];
                    Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                    IdentityArraySet<RecomposeScopeImpl>[] identityArraySetArr3 = scopeSets2;
                    if (!hashSet.contains((RecomposeScopeImpl) obj6)) {
                        if (i21 != i20) {
                            values7[i21] = obj6;
                        }
                        i21++;
                    }
                    i20++;
                    scopeSets2 = identityArraySetArr3;
                }
                IdentityArraySet<RecomposeScopeImpl>[] identityArraySetArr4 = scopeSets2;
                for (int i22 = i21; i22 < size8; i22++) {
                    values7[i22] = null;
                }
                ((IdentityArraySet) identityArraySet3).size = i21;
                if (identityArraySet3.size() > 0) {
                    if (i18 != i17) {
                        int i23 = valueOrder2[i18];
                        valueOrder2[i18] = i19;
                        valueOrder2[i17] = i23;
                    }
                    i18++;
                }
                i17++;
                scopeSets2 = identityArraySetArr4;
            }
            int size9 = identityScopeMap4.getSize();
            for (int i24 = i18; i24 < size9; i24++) {
                values6[valueOrder2[i24]] = null;
            }
            identityScopeMap4.setSize(i18);
            cleanUpDerivedStateObservations();
        }
    }

    private final void cleanUpDerivedStateObservations() {
        IdentityScopeMap<DerivedState<?>> identityScopeMap = this.derivedStates;
        int[] valueOrder = identityScopeMap.getValueOrder();
        IdentityArraySet<DerivedState<?>>[] scopeSets = identityScopeMap.getScopeSets();
        Object[] values = identityScopeMap.getValues();
        int size = identityScopeMap.getSize();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3 = valueOrder[i];
            IdentityArraySet<DerivedState<?>> identityArraySet = scopeSets[i3];
            Intrinsics.checkNotNull(identityArraySet);
            Object[] values2 = identityArraySet.getValues();
            int size2 = identityArraySet.size();
            int i4 = 0;
            int i5 = 0;
            while (i4 < size2) {
                Object obj = values2[i4];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                IdentityArraySet<DerivedState<?>>[] identityArraySetArr = scopeSets;
                if (!(!this.observations.contains((DerivedState) obj))) {
                    if (i5 != i4) {
                        values2[i5] = obj;
                    }
                    i5++;
                }
                i4++;
                scopeSets = identityArraySetArr;
            }
            IdentityArraySet<DerivedState<?>>[] identityArraySetArr2 = scopeSets;
            for (int i6 = i5; i6 < size2; i6++) {
                values2[i6] = null;
            }
            ((IdentityArraySet) identityArraySet).size = i5;
            if (identityArraySet.size() > 0) {
                if (i2 != i) {
                    int i7 = valueOrder[i2];
                    valueOrder[i2] = i3;
                    valueOrder[i] = i7;
                }
                i2++;
            }
            i++;
            scopeSets = identityArraySetArr2;
        }
        int size3 = identityScopeMap.getSize();
        for (int i8 = i2; i8 < size3; i8++) {
            values[valueOrder[i8]] = null;
        }
        identityScopeMap.setSize(i2);
        if (!this.conditionallyInvalidatedScopes.isEmpty()) {
            Iterator<RecomposeScopeImpl> it = this.conditionallyInvalidatedScopes.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator()");
            while (it.hasNext()) {
                if (!it.next().isConditional()) {
                    it.remove();
                }
            }
        }
    }

    private final void invalidateScopeOfLocked(Object obj) {
        IdentityScopeMap<RecomposeScopeImpl> identityScopeMap = this.observations;
        int find = identityScopeMap.find(obj);
        if (find >= 0) {
            IdentityArraySet scopeSetAt = identityScopeMap.scopeSetAt(find);
            Object[] values = scopeSetAt.getValues();
            int size = scopeSetAt.size();
            for (int i = 0; i < size; i++) {
                Object obj2 = values[i];
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) obj2;
                if (recomposeScopeImpl.invalidateForResult(obj) == InvalidationResult.IMMINENT) {
                    this.observationsProcessed.add(obj, recomposeScopeImpl);
                }
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void recordWriteOf(Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        synchronized (this.lock) {
            invalidateScopeOfLocked(value);
            IdentityScopeMap<DerivedState<?>> identityScopeMap = this.derivedStates;
            int find = identityScopeMap.find(value);
            if (find >= 0) {
                IdentityArraySet scopeSetAt = identityScopeMap.scopeSetAt(find);
                Object[] values = scopeSetAt.getValues();
                int size = scopeSetAt.size();
                for (int i = 0; i < size; i++) {
                    Object obj = values[i];
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                    invalidateScopeOfLocked((DerivedState) obj);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean recompose() {
        boolean recompose$runtime_release;
        synchronized (this.lock) {
            drainPendingModificationsForCompositionLocked();
            IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> takeInvalidations = takeInvalidations();
            try {
                recompose$runtime_release = this.composer.recompose$runtime_release(takeInvalidations);
                if (!recompose$runtime_release) {
                    drainPendingModificationsLocked();
                }
            } catch (Exception e) {
                this.invalidations = takeInvalidations;
                throw e;
            }
        }
        return recompose$runtime_release;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void insertMovableContent(List<Pair<MovableContentStateReference, MovableContentStateReference>> references) {
        Intrinsics.checkNotNullParameter(references, "references");
        int size = references.size();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= size) {
                z = true;
                break;
            } else if (!Intrinsics.areEqual(references.get(i).getFirst().getComposition$runtime_release(), this)) {
                break;
            } else {
                i++;
            }
        }
        ComposerKt.runtimeCheck(z);
        try {
            this.composer.insertMovableContentReferences(references);
            Unit unit = Unit.INSTANCE;
        } finally {
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void applyChanges() {
        synchronized (this.lock) {
            applyChangesInLocked(this.changes);
            drainPendingModificationsLocked();
            Unit unit = Unit.INSTANCE;
            Unit unit2 = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void applyLateChanges() {
        synchronized (this.lock) {
            if (!this.lateChanges.isEmpty()) {
                applyChangesInLocked(this.lateChanges);
            }
            Unit unit = Unit.INSTANCE;
            Unit unit2 = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void changesApplied() {
        synchronized (this.lock) {
            this.composer.changesApplied$runtime_release();
            if (!this.abandonSet.isEmpty()) {
                new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
            }
            Unit unit = Unit.INSTANCE;
            Unit unit2 = Unit.INSTANCE;
        }
    }

    private final <T> T guardChanges(Function0<? extends T> function0) {
        try {
            T invoke = function0.invoke();
            InlineMarker.finallyStart(1);
            InlineMarker.finallyEnd(1);
            return invoke;
        } catch (Exception e) {
            abandonChanges();
            throw e;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void invalidateAll() {
        Object[] slots;
        synchronized (this.lock) {
            for (Object obj : this.slotTable.getSlots()) {
                RecomposeScopeImpl recomposeScopeImpl = obj instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) obj : null;
                if (recomposeScopeImpl != null) {
                    recomposeScopeImpl.invalidate();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void verifyConsistent() {
        synchronized (this.lock) {
            if (!isComposing()) {
                this.composer.verifyConsistent$runtime_release();
                this.slotTable.verifyWellFormed();
                validateRecomposeScopeAnchors(this.slotTable);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final InvalidationResult invalidateChecked(RecomposeScopeImpl recomposeScopeImpl, Anchor anchor, Object obj) {
        synchronized (this.lock) {
            CompositionImpl compositionImpl = this.invalidationDelegate;
            if (compositionImpl == null || !this.slotTable.groupContainsAnchor(this.invalidationDelegateGroup, anchor)) {
                compositionImpl = null;
            }
            if (compositionImpl == null) {
                if (tryImminentInvalidation(recomposeScopeImpl, obj)) {
                    return InvalidationResult.IMMINENT;
                } else if (obj == null) {
                    this.invalidations.set(recomposeScopeImpl, null);
                } else {
                    CompositionKt.access$addValue(this.invalidations, recomposeScopeImpl, obj);
                }
            }
            if (compositionImpl != null) {
                return compositionImpl.invalidateChecked(recomposeScopeImpl, anchor, obj);
            }
            this.parent.invalidate$runtime_release(this);
            return isComposing() ? InvalidationResult.DEFERRED : InvalidationResult.SCHEDULED;
        }
    }
}