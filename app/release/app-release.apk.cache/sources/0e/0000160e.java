package androidx.compose.ui.node;

import android.view.View;
import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.layout.LayoutNodeSubcompositionsState;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.ModifierInfo;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.JvmActuals_jvmKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import java.util.Comparator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: LayoutNode.kt */
@Metadata(d1 = {"\u0000Ì\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b?\b\u0000\u0018\u0000 à\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\bà\u0002á\u0002â\u0002ã\u0002B\u0019\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u001a\u0010ä\u0001\u001a\u00030µ\u00012\b\u0010¿\u0001\u001a\u00030´\u0001H\u0000¢\u0006\u0003\bå\u0001J\u0010\u0010æ\u0001\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\bç\u0001J\n\u0010è\u0001\u001a\u00030µ\u0001H\u0002J\u0014\u0010é\u0001\u001a\u00030ê\u00012\b\b\u0002\u0010H\u001a\u00020\u000bH\u0002J\u0010\u0010ë\u0001\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\bì\u0001J\u0010\u0010í\u0001\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\bî\u0001J\u001a\u0010ï\u0001\u001a\u00030µ\u00012\b\u0010ð\u0001\u001a\u00030ñ\u0001H\u0000¢\u0006\u0003\bò\u0001J%\u0010ó\u0001\u001a\u00030µ\u00012\u0015\u0010ô\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0005\u0012\u00030µ\u00010³\u0001H\u0086\bø\u0001\u0000J+\u0010õ\u0001\u001a\u00030µ\u00012\u001b\u0010ô\u0001\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0000\u0012\u0005\u0012\u00030µ\u00010ö\u0001H\u0086\bø\u0001\u0000J,\u0010÷\u0001\u001a\u00030µ\u00012\u0016\u0010ô\u0001\u001a\u0011\u0012\u0005\u0012\u00030ø\u0001\u0012\u0005\u0012\u00030µ\u00010³\u0001H\u0080\bø\u0001\u0000¢\u0006\u0003\bù\u0001J+\u0010ú\u0001\u001a\u00030µ\u00012\u0015\u0010ô\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0005\u0012\u00030µ\u00010³\u0001H\u0080\bø\u0001\u0000¢\u0006\u0003\bû\u0001J\n\u0010ü\u0001\u001a\u00030µ\u0001H\u0016J\u0013\u0010ý\u0001\u001a\f\u0018\u00010þ\u0001j\u0005\u0018\u0001`ÿ\u0001H\u0017J\u0010\u0010\u0080\u0002\u001a\t\u0012\u0005\u0012\u00030\u0081\u00020$H\u0016JC\u0010\u0082\u0002\u001a\u00030µ\u00012\b\u0010\u0083\u0002\u001a\u00030\u0084\u00022\b\u0010\u0085\u0002\u001a\u00030\u0086\u00022\t\b\u0002\u0010\u0087\u0002\u001a\u00020\t2\t\b\u0002\u0010\u0088\u0002\u001a\u00020\tH\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\b\u0089\u0002\u0010\u008a\u0002JC\u0010\u008b\u0002\u001a\u00030µ\u00012\b\u0010\u0083\u0002\u001a\u00030\u0084\u00022\b\u0010\u008c\u0002\u001a\u00030\u0086\u00022\t\b\u0002\u0010\u0087\u0002\u001a\u00020\t2\t\b\u0002\u0010\u0088\u0002\u001a\u00020\tH\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\b\u008d\u0002\u0010\u008a\u0002J$\u0010Q\u001a\u00030µ\u00012\u000f\u0010ô\u0001\u001a\n\u0012\u0005\u0012\u00030µ\u00010\u008e\u0002H\u0080\bø\u0001\u0000¢\u0006\u0003\b\u008f\u0002J\"\u0010\u0090\u0002\u001a\u00030µ\u00012\u0007\u0010\u0091\u0002\u001a\u00020\u000b2\u0007\u0010\u0092\u0002\u001a\u00020\u0000H\u0000¢\u0006\u0003\b\u0093\u0002J\n\u0010\u0094\u0002\u001a\u00030µ\u0001H\u0002J\n\u0010\u0095\u0002\u001a\u00030µ\u0001H\u0002J\u0010\u0010\u0096\u0002\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\b\u0097\u0002J\u0010\u0010\u0098\u0002\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\b\u0099\u0002J\u0010\u0010\u009a\u0002\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\b\u009b\u0002J\u0010\u0010\u009c\u0002\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\b\u009d\u0002J\u0010\u0010\u009e\u0002\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\b\u009f\u0002J\u0013\u0010 \u0002\u001a\u00030µ\u00012\t\b\u0002\u0010¡\u0002\u001a\u00020\tJ\n\u0010¢\u0002\u001a\u00030µ\u0001H\u0002J#\u0010£\u0002\u001a\u00020\t2\f\b\u0002\u0010¤\u0002\u001a\u0005\u0018\u00010¥\u0002H\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0003\b¦\u0002J\u0010\u0010§\u0002\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\b¨\u0002J\u0010\u0010©\u0002\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\bª\u0002J\u0010\u0010«\u0002\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\b¬\u0002J\u0010\u0010\u00ad\u0002\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\b®\u0002J\u0010\u0010¯\u0002\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\b°\u0002J+\u0010±\u0002\u001a\u00030µ\u00012\u0007\u0010²\u0002\u001a\u00020\u000b2\u0007\u0010³\u0002\u001a\u00020\u000b2\u0007\u0010´\u0002\u001a\u00020\u000bH\u0000¢\u0006\u0003\bµ\u0002J\u0013\u0010¶\u0002\u001a\u00030µ\u00012\u0007\u0010·\u0002\u001a\u00020\u0000H\u0002J\n\u0010¸\u0002\u001a\u00030µ\u0001H\u0016J\n\u0010¹\u0002\u001a\u00030µ\u0001H\u0002J\n\u0010º\u0002\u001a\u00030µ\u0001H\u0016J\n\u0010»\u0002\u001a\u00030µ\u0001H\u0016J\n\u0010¼\u0002\u001a\u00030µ\u0001H\u0016J\u0010\u0010½\u0002\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\b¾\u0002J\"\u0010¿\u0002\u001a\u00030µ\u00012\u0007\u0010À\u0002\u001a\u00020\u000b2\u0007\u0010Á\u0002\u001a\u00020\u000bH\u0000¢\u0006\u0003\bÂ\u0002J\n\u0010Ã\u0002\u001a\u00030µ\u0001H\u0002J#\u0010Ä\u0002\u001a\u00020\t2\f\b\u0002\u0010¤\u0002\u001a\u0005\u0018\u00010¥\u0002H\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0003\bÅ\u0002J\u0010\u0010Æ\u0002\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\bÇ\u0002J\"\u0010È\u0002\u001a\u00030µ\u00012\u0007\u0010\u0091\u0002\u001a\u00020\u000b2\u0007\u0010´\u0002\u001a\u00020\u000bH\u0000¢\u0006\u0003\bÉ\u0002J\u0010\u0010Ê\u0002\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\bË\u0002J\u001b\u0010Ì\u0002\u001a\u00030µ\u00012\t\b\u0002\u0010Í\u0002\u001a\u00020\tH\u0000¢\u0006\u0003\bÎ\u0002J&\u0010Ï\u0002\u001a\u00030µ\u00012\t\b\u0002\u0010Í\u0002\u001a\u00020\t2\t\b\u0002\u0010Ð\u0002\u001a\u00020\tH\u0000¢\u0006\u0003\bÑ\u0002J\u001b\u0010Ò\u0002\u001a\u00030µ\u00012\t\b\u0002\u0010Í\u0002\u001a\u00020\tH\u0000¢\u0006\u0003\bÓ\u0002J&\u0010Ô\u0002\u001a\u00030µ\u00012\t\b\u0002\u0010Í\u0002\u001a\u00020\t2\t\b\u0002\u0010Ð\u0002\u001a\u00020\tH\u0000¢\u0006\u0003\bÕ\u0002J\u0019\u0010Ö\u0002\u001a\u00030µ\u00012\u0007\u0010×\u0002\u001a\u00020\u0000H\u0000¢\u0006\u0003\bØ\u0002J\n\u0010Ù\u0002\u001a\u00030µ\u0001H\u0002J\u0010\u0010Ú\u0002\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\bÛ\u0002J\t\u0010Ü\u0002\u001a\u00020\tH\u0002J\n\u0010Ý\u0002\u001a\u00030ê\u0001H\u0016J\u0010\u0010Þ\u0002\u001a\u00030µ\u0001H\u0000¢\u0006\u0003\bß\u0002R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00000\u000e8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00000\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00000\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u00020\t8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\"R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020%0$8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b)\u0010'R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00000$8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b+\u0010'R\u0016\u0010,\u001a\u0004\u0018\u00010\u00128@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R,\u00100\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020\u000b8W@WX\u0097\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b1\u0010\u001f\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u00108\u001a\u0002072\u0006\u00106\u001a\u000207@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0014\u0010=\u001a\u00020>8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b?\u0010@R\u000e\u0010A\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010C\u001a\u00020B2\u0006\u00106\u001a\u00020B@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001a\u0010H\u001a\u00020\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u00103\"\u0004\bJ\u00105R\u001a\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00000$8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bL\u0010'R\u0014\u0010M\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bN\u0010\u001cR\u0014\u0010O\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bP\u00103R\u000e\u0010Q\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010R\u001a\u00020\u00178@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bS\u0010TR\u0016\u0010U\u001a\u0004\u0018\u00010\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bV\u0010TR\u001a\u0010W\u001a\u00020\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\u001c\"\u0004\bY\u0010\"R\"\u0010Z\u001a\n\u0018\u00010[j\u0004\u0018\u0001`\\X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u0014\u0010a\u001a\u00020bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bc\u0010dR\u001a\u0010e\u001a\u00020fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\u0014\u0010k\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bk\u0010\u001cR\u0014\u0010l\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bl\u0010\u001cR\u0013\u0010m\u001a\u0004\u0018\u00010\t8F¢\u0006\u0006\u001a\u0004\bm\u0010nR\u0014\u0010o\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bo\u0010\u001cR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010p\u001a\u00020\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010\u001c\"\u0004\br\u0010\"R\u0014\u0010s\u001a\u00020tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bu\u0010vR$\u0010x\u001a\u00020w2\u0006\u00106\u001a\u00020w@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R\u0014\u0010}\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b~\u0010\u001cR\u0017\u0010\u007f\u001a\u00030\u0080\u00018@X\u0080\u0004¢\u0006\b\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0016\u0010\u0083\u0001\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b\u0084\u0001\u0010\u001cR\u0016\u0010\u0085\u0001\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b\u0086\u0001\u0010\u001cR\u001e\u0010\u0087\u0001\u001a\t\u0018\u00010\u0088\u0001R\u00020t8@X\u0080\u0004¢\u0006\b\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001R.\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u00002\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u0000@BX\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001\"\u0006\b\u008f\u0001\u0010\u0090\u0001R\u0018\u0010\u0091\u0001\u001a\u00030\u0092\u00018@X\u0080\u0004¢\u0006\b\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001R\u001c\u0010\u0095\u0001\u001a\u00070\u0096\u0001R\u00020t8@X\u0080\u0004¢\u0006\b\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001R\u0016\u0010\u0099\u0001\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b\u009a\u0001\u0010\u001cR+\u0010\u009c\u0001\u001a\u00030\u009b\u00012\u0007\u00106\u001a\u00030\u009b\u0001@VX\u0096\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001\"\u0006\b\u009f\u0001\u0010 \u0001R\u0016\u0010¡\u0001\u001a\u00020f8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b¢\u0001\u0010hR\u0016\u0010£\u0001\u001a\u00020f8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b¤\u0001\u0010hR+\u0010¦\u0001\u001a\u00030¥\u00012\u0007\u00106\u001a\u00030¥\u0001@VX\u0096\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b§\u0001\u0010¨\u0001\"\u0006\b©\u0001\u0010ª\u0001R\u001d\u0010«\u0001\u001a\u00020\tX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¬\u0001\u0010\u001c\"\u0005\b\u00ad\u0001\u0010\"R\u0018\u0010®\u0001\u001a\u00030¯\u0001X\u0080\u0004¢\u0006\n\n\u0000\u001a\u0006\b°\u0001\u0010±\u0001R0\u0010²\u0001\u001a\u0013\u0012\u0005\u0012\u00030´\u0001\u0012\u0005\u0012\u00030µ\u0001\u0018\u00010³\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¶\u0001\u0010·\u0001\"\u0006\b¸\u0001\u0010¹\u0001R0\u0010º\u0001\u001a\u0013\u0012\u0005\u0012\u00030´\u0001\u0012\u0005\u0012\u00030µ\u0001\u0018\u00010³\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b»\u0001\u0010·\u0001\"\u0006\b¼\u0001\u0010¹\u0001R\u0016\u0010½\u0001\u001a\u00020\u00178@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b¾\u0001\u0010TR'\u0010¿\u0001\u001a\u0005\u0018\u00010´\u00012\t\u0010/\u001a\u0005\u0018\u00010´\u0001@BX\u0080\u000e¢\u0006\n\n\u0000\u001a\u0006\bÀ\u0001\u0010Á\u0001R\u0019\u0010Â\u0001\u001a\u0004\u0018\u00010\u00008@X\u0080\u0004¢\u0006\b\u001a\u0006\bÃ\u0001\u0010\u008e\u0001R\u0019\u0010Ä\u0001\u001a\u0004\u0018\u00010\u00048VX\u0096\u0004¢\u0006\b\u001a\u0006\bÅ\u0001\u0010Æ\u0001R\u0016\u0010Ç\u0001\u001a\u00020\u000b8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\bÈ\u0001\u00103R\u000f\u0010É\u0001\u001a\u00020fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u00020\u000bX\u0096\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÊ\u0001\u00103\"\u0005\bË\u0001\u00105R\"\u0010Ì\u0001\u001a\u0005\u0018\u00010Í\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÎ\u0001\u0010Ï\u0001\"\u0006\bÐ\u0001\u0010Ñ\u0001R\u000f\u0010Ò\u0001\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010Ô\u0001\u001a\u00030Ó\u00012\u0007\u00106\u001a\u00030Ó\u0001@VX\u0096\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÕ\u0001\u0010Ö\u0001\"\u0006\b×\u0001\u0010Ø\u0001R\u000f\u0010Ù\u0001\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010Ú\u0001\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bÛ\u0001\u00103R\u0018\u0010Ü\u0001\u001a\u00030Ý\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bÞ\u0001\u0010ß\u0001R#\u0010à\u0001\u001a\b\u0012\u0004\u0012\u00020\u00000\u000e8@X\u0081\u0004¢\u0006\u000e\u0012\u0005\bá\u0001\u0010\u001f\u001a\u0005\bâ\u0001\u0010\u0010R\u000f\u0010ã\u0001\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0012\n\u0005\b\u009920\u0001\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006ä\u0002"}, d2 = {"Landroidx/compose/ui/node/LayoutNode;", "Landroidx/compose/runtime/ComposeNodeLifecycleCallback;", "Landroidx/compose/ui/layout/Remeasurement;", "Landroidx/compose/ui/node/OwnerScope;", "Landroidx/compose/ui/layout/LayoutInfo;", "Landroidx/compose/ui/node/ComposeUiNode;", "Landroidx/compose/ui/node/InteroperableComposeUiNode;", "Landroidx/compose/ui/node/Owner$OnLayoutCompletedListener;", "isVirtual", "", "semanticsId", "", "(ZI)V", "_children", "Landroidx/compose/runtime/collection/MutableVector;", "get_children$ui_release", "()Landroidx/compose/runtime/collection/MutableVector;", "_collapsedSemantics", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "_foldedChildren", "Landroidx/compose/ui/node/MutableVectorWithMutationTracking;", "_foldedParent", "_innerLayerCoordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "_unfoldedChildren", "_zSortedChildren", "alignmentLinesRequired", "getAlignmentLinesRequired$ui_release", "()Z", "canMultiMeasure", "getCanMultiMeasure$ui_release$annotations", "()V", "getCanMultiMeasure$ui_release", "setCanMultiMeasure$ui_release", "(Z)V", "childLookaheadMeasurables", "", "Landroidx/compose/ui/layout/Measurable;", "getChildLookaheadMeasurables$ui_release", "()Ljava/util/List;", "childMeasurables", "getChildMeasurables$ui_release", "children", "getChildren$ui_release", "collapsedSemantics", "getCollapsedSemantics$ui_release", "()Landroidx/compose/ui/semantics/SemanticsConfiguration;", "<set-?>", "compositeKeyHash", "getCompositeKeyHash$annotations", "getCompositeKeyHash", "()I", "setCompositeKeyHash", "(I)V", "value", "Landroidx/compose/runtime/CompositionLocalMap;", "compositionLocalMap", "getCompositionLocalMap", "()Landroidx/compose/runtime/CompositionLocalMap;", "setCompositionLocalMap", "(Landroidx/compose/runtime/CompositionLocalMap;)V", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "deactivated", "Landroidx/compose/ui/unit/Density;", "density", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "depth", "getDepth$ui_release", "setDepth$ui_release", "foldedChildren", "getFoldedChildren$ui_release", "hasFixedInnerContentConstraints", "getHasFixedInnerContentConstraints$ui_release", "height", "getHeight", "ignoreRemeasureRequests", "innerCoordinator", "getInnerCoordinator$ui_release", "()Landroidx/compose/ui/node/NodeCoordinator;", "innerLayerCoordinator", "getInnerLayerCoordinator", "innerLayerCoordinatorIsDirty", "getInnerLayerCoordinatorIsDirty$ui_release", "setInnerLayerCoordinatorIsDirty$ui_release", "interopViewFactoryHolder", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "Landroidx/compose/ui/viewinterop/InteropViewFactoryHolder;", "getInteropViewFactoryHolder$ui_release", "()Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "setInteropViewFactoryHolder$ui_release", "(Landroidx/compose/ui/viewinterop/AndroidViewHolder;)V", "intrinsicsPolicy", "Landroidx/compose/ui/node/IntrinsicsPolicy;", "getIntrinsicsPolicy$ui_release", "()Landroidx/compose/ui/node/IntrinsicsPolicy;", "intrinsicsUsageByParent", "Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "getIntrinsicsUsageByParent$ui_release", "()Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "setIntrinsicsUsageByParent$ui_release", "(Landroidx/compose/ui/node/LayoutNode$UsageByParent;)V", "isAttached", "isPlaced", "isPlacedInLookahead", "()Ljava/lang/Boolean;", "isValidOwnerScope", "isVirtualLookaheadRoot", "isVirtualLookaheadRoot$ui_release", "setVirtualLookaheadRoot$ui_release", "layoutDelegate", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "getLayoutDelegate$ui_release", "()Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "layoutPending", "getLayoutPending$ui_release", "layoutState", "Landroidx/compose/ui/node/LayoutNode$LayoutState;", "getLayoutState$ui_release", "()Landroidx/compose/ui/node/LayoutNode$LayoutState;", "lookaheadLayoutPending", "getLookaheadLayoutPending$ui_release", "lookaheadMeasurePending", "getLookaheadMeasurePending$ui_release", "lookaheadPassDelegate", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$LookaheadPassDelegate;", "getLookaheadPassDelegate$ui_release", "()Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$LookaheadPassDelegate;", "newRoot", "lookaheadRoot", "getLookaheadRoot$ui_release", "()Landroidx/compose/ui/node/LayoutNode;", "setLookaheadRoot", "(Landroidx/compose/ui/node/LayoutNode;)V", "mDrawScope", "Landroidx/compose/ui/node/LayoutNodeDrawScope;", "getMDrawScope$ui_release", "()Landroidx/compose/ui/node/LayoutNodeDrawScope;", "measurePassDelegate", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$MeasurePassDelegate;", "getMeasurePassDelegate$ui_release", "()Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$MeasurePassDelegate;", "measurePending", "getMeasurePending$ui_release", "Landroidx/compose/ui/layout/MeasurePolicy;", "measurePolicy", "getMeasurePolicy", "()Landroidx/compose/ui/layout/MeasurePolicy;", "setMeasurePolicy", "(Landroidx/compose/ui/layout/MeasurePolicy;)V", "measuredByParent", "getMeasuredByParent$ui_release", "measuredByParentInLookahead", "getMeasuredByParentInLookahead$ui_release", "Landroidx/compose/ui/Modifier;", "modifier", "getModifier", "()Landroidx/compose/ui/Modifier;", "setModifier", "(Landroidx/compose/ui/Modifier;)V", "needsOnPositionedDispatch", "getNeedsOnPositionedDispatch$ui_release", "setNeedsOnPositionedDispatch$ui_release", "nodes", "Landroidx/compose/ui/node/NodeChain;", "getNodes$ui_release", "()Landroidx/compose/ui/node/NodeChain;", "onAttach", "Lkotlin/Function1;", "Landroidx/compose/ui/node/Owner;", "", "getOnAttach$ui_release", "()Lkotlin/jvm/functions/Function1;", "setOnAttach$ui_release", "(Lkotlin/jvm/functions/Function1;)V", "onDetach", "getOnDetach$ui_release", "setOnDetach$ui_release", "outerCoordinator", "getOuterCoordinator$ui_release", "owner", "getOwner$ui_release", "()Landroidx/compose/ui/node/Owner;", "parent", "getParent$ui_release", "parentInfo", "getParentInfo", "()Landroidx/compose/ui/layout/LayoutInfo;", "placeOrder", "getPlaceOrder$ui_release", "previousIntrinsicsUsageByParent", "getSemanticsId", "setSemanticsId", "subcompositionsState", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;", "getSubcompositionsState$ui_release", "()Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;", "setSubcompositionsState$ui_release", "(Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;)V", "unfoldedVirtualChildrenListDirty", "Landroidx/compose/ui/platform/ViewConfiguration;", "viewConfiguration", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "setViewConfiguration", "(Landroidx/compose/ui/platform/ViewConfiguration;)V", "virtualChildrenCount", "width", "getWidth", "zIndex", "", "getZIndex", "()F", "zSortedChildren", "getZSortedChildren$annotations", "getZSortedChildren", "zSortedChildrenInvalidated", "attach", "attach$ui_release", "clearSubtreeIntrinsicsUsage", "clearSubtreeIntrinsicsUsage$ui_release", "clearSubtreePlacementIntrinsicsUsage", "debugTreeToString", "", "detach", "detach$ui_release", "dispatchOnPositionedCallbacks", "dispatchOnPositionedCallbacks$ui_release", "draw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "draw$ui_release", "forEachChild", "block", "forEachChildIndexed", "Lkotlin/Function2;", "forEachCoordinator", "Landroidx/compose/ui/node/LayoutModifierNodeCoordinator;", "forEachCoordinator$ui_release", "forEachCoordinatorIncludingInner", "forEachCoordinatorIncludingInner$ui_release", "forceRemeasure", "getInteropView", "Landroid/view/View;", "Landroidx/compose/ui/viewinterop/InteropView;", "getModifierInfo", "Landroidx/compose/ui/layout/ModifierInfo;", "hitTest", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "isTouchEvent", "isInLayer", "hitTest-M_7yMNQ$ui_release", "(JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "hitTestSemantics", "hitSemanticsEntities", "hitTestSemantics-M_7yMNQ$ui_release", "Lkotlin/Function0;", "ignoreRemeasureRequests$ui_release", "insertAt", "index", "instance", "insertAt$ui_release", "invalidateFocusOnAttach", "invalidateFocusOnDetach", "invalidateLayer", "invalidateLayer$ui_release", "invalidateLayers", "invalidateLayers$ui_release", "invalidateMeasurements", "invalidateMeasurements$ui_release", "invalidateParentData", "invalidateParentData$ui_release", "invalidateSemantics", "invalidateSemantics$ui_release", "invalidateSubtree", "isRootOfInvalidation", "invalidateUnfoldedVirtualChildren", "lookaheadRemeasure", "constraints", "Landroidx/compose/ui/unit/Constraints;", "lookaheadRemeasure-_Sx5XlM$ui_release", "lookaheadReplace", "lookaheadReplace$ui_release", "markLayoutPending", "markLayoutPending$ui_release", "markLookaheadLayoutPending", "markLookaheadLayoutPending$ui_release", "markLookaheadMeasurePending", "markLookaheadMeasurePending$ui_release", "markMeasurePending", "markMeasurePending$ui_release", "move", "from", "to", "count", "move$ui_release", "onChildRemoved", "child", "onDeactivate", "onDensityOrLayoutDirectionChanged", "onLayoutComplete", "onRelease", "onReuse", "onZSortedChildrenInvalidated", "onZSortedChildrenInvalidated$ui_release", "place", "x", "y", "place$ui_release", "recreateUnfoldedChildrenIfDirty", "remeasure", "remeasure-_Sx5XlM$ui_release", "removeAll", "removeAll$ui_release", "removeAt", "removeAt$ui_release", "replace", "replace$ui_release", "requestLookaheadRelayout", "forceRequest", "requestLookaheadRelayout$ui_release", "requestLookaheadRemeasure", "scheduleMeasureAndLayout", "requestLookaheadRemeasure$ui_release", "requestRelayout", "requestRelayout$ui_release", "requestRemeasure", "requestRemeasure$ui_release", "rescheduleRemeasureOrRelayout", "it", "rescheduleRemeasureOrRelayout$ui_release", "resetModifierState", "resetSubtreeIntrinsicsUsage", "resetSubtreeIntrinsicsUsage$ui_release", "shouldInvalidateParentLayer", "toString", "updateChildrenIfDirty", "updateChildrenIfDirty$ui_release", "Companion", "LayoutState", "NoIntrinsicsMeasurePolicy", "UsageByParent", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LayoutNode implements ComposeNodeLifecycleCallback, Remeasurement, OwnerScope, LayoutInfo, ComposeUiNode, InteroperableComposeUiNode, Owner.OnLayoutCompletedListener {
    public static final int NotPlacedPlaceOrder = Integer.MAX_VALUE;
    private SemanticsConfiguration _collapsedSemantics;
    private final MutableVectorWithMutationTracking<LayoutNode> _foldedChildren;
    private LayoutNode _foldedParent;
    private NodeCoordinator _innerLayerCoordinator;
    private MutableVector<LayoutNode> _unfoldedChildren;
    private final MutableVector<LayoutNode> _zSortedChildren;
    private boolean canMultiMeasure;
    private int compositeKeyHash;
    private CompositionLocalMap compositionLocalMap;
    private boolean deactivated;
    private Density density;
    private int depth;
    private boolean ignoreRemeasureRequests;
    private boolean innerLayerCoordinatorIsDirty;
    private AndroidViewHolder interopViewFactoryHolder;
    private final IntrinsicsPolicy intrinsicsPolicy;
    private UsageByParent intrinsicsUsageByParent;
    private final boolean isVirtual;
    private boolean isVirtualLookaheadRoot;
    private final LayoutNodeLayoutDelegate layoutDelegate;
    private LayoutDirection layoutDirection;
    private LayoutNode lookaheadRoot;
    private MeasurePolicy measurePolicy;
    private Modifier modifier;
    private boolean needsOnPositionedDispatch;
    private final NodeChain nodes;
    private Function1<? super Owner, Unit> onAttach;
    private Function1<? super Owner, Unit> onDetach;
    private Owner owner;
    private UsageByParent previousIntrinsicsUsageByParent;
    private int semanticsId;
    private LayoutNodeSubcompositionsState subcompositionsState;
    private boolean unfoldedVirtualChildrenListDirty;
    private ViewConfiguration viewConfiguration;
    private int virtualChildrenCount;
    private boolean zSortedChildrenInvalidated;
    public static final Companion Companion = new Companion(null);
    private static final NoIntrinsicsMeasurePolicy ErrorMeasurePolicy = new NoIntrinsicsMeasurePolicy() { // from class: androidx.compose.ui.node.LayoutNode$Companion$ErrorMeasurePolicy$1
        @Override // androidx.compose.ui.layout.MeasurePolicy
        /* renamed from: measure-3p2s80s */
        public /* bridge */ /* synthetic */ MeasureResult mo10measure3p2s80s(MeasureScope measureScope, List list, long j) {
            return (MeasureResult) m4010measure3p2s80s(measureScope, (List<? extends Measurable>) list, j);
        }

        /* renamed from: measure-3p2s80s  reason: not valid java name */
        public Void m4010measure3p2s80s(MeasureScope measure, List<? extends Measurable> measurables, long j) {
            Intrinsics.checkNotNullParameter(measure, "$this$measure");
            Intrinsics.checkNotNullParameter(measurables, "measurables");
            throw new IllegalStateException("Undefined measure and it is required".toString());
        }
    };
    private static final Function0<LayoutNode> Constructor = new Function0<LayoutNode>() { // from class: androidx.compose.ui.node.LayoutNode$Companion$Constructor$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final LayoutNode invoke() {
            return new LayoutNode(false, 0, 3, null);
        }
    };
    private static final ViewConfiguration DummyViewConfiguration = new ViewConfiguration() { // from class: androidx.compose.ui.node.LayoutNode$Companion$DummyViewConfiguration$1
        @Override // androidx.compose.ui.platform.ViewConfiguration
        public long getDoubleTapMinTimeMillis() {
            return 40L;
        }

        @Override // androidx.compose.ui.platform.ViewConfiguration
        public long getDoubleTapTimeoutMillis() {
            return 300L;
        }

        @Override // androidx.compose.ui.platform.ViewConfiguration
        public long getLongPressTimeoutMillis() {
            return 400L;
        }

        @Override // androidx.compose.ui.platform.ViewConfiguration
        public float getTouchSlop() {
            return 16.0f;
        }

        @Override // androidx.compose.ui.platform.ViewConfiguration
        /* renamed from: getMinimumTouchTargetSize-MYxV2XQ  reason: not valid java name */
        public long mo4009getMinimumTouchTargetSizeMYxV2XQ() {
            return DpSize.Companion.m4980getZeroMYxV2XQ();
        }
    };
    private static final Comparator<LayoutNode> ZComparator = new Comparator() { // from class: androidx.compose.ui.node.LayoutNode$$ExternalSyntheticLambda0
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return LayoutNode.m4000$r8$lambda$DzqjNqe9pzqBZZ9IiiTtphu0n4((LayoutNode) obj, (LayoutNode) obj2);
        }
    };

    /* compiled from: LayoutNode.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/node/LayoutNode$LayoutState;", "", "(Ljava/lang/String;I)V", "Measuring", "LookaheadMeasuring", "LayingOut", "LookaheadLayingOut", "Idle", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public enum LayoutState {
        Measuring,
        LookaheadMeasuring,
        LayingOut,
        LookaheadLayingOut,
        Idle
    }

    /* compiled from: LayoutNode.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "", "(Ljava/lang/String;I)V", "InMeasureBlock", "InLayoutBlock", "NotUsed", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public enum UsageByParent {
        InMeasureBlock,
        InLayoutBlock,
        NotUsed
    }

    /* compiled from: LayoutNode.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutState.values().length];
            try {
                iArr[LayoutState.Idle.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* renamed from: $r8$lambda$DzqjNqe9pzqBZZ9IiiTtp-hu0n4 */
    public static /* synthetic */ int m4000$r8$lambda$DzqjNqe9pzqBZZ9IiiTtphu0n4(LayoutNode layoutNode, LayoutNode layoutNode2) {
        return ZComparator$lambda$38(layoutNode, layoutNode2);
    }

    public LayoutNode() {
        this(false, 0, 3, null);
    }

    @Deprecated(message = "Temporary API to support ConstraintLayout prototyping.")
    public static /* synthetic */ void getCanMultiMeasure$ui_release$annotations() {
    }

    public static /* synthetic */ void getCompositeKeyHash$annotations() {
    }

    public static /* synthetic */ void getZSortedChildren$annotations() {
    }

    public final boolean getCanMultiMeasure$ui_release() {
        return this.canMultiMeasure;
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public int getCompositeKeyHash() {
        return this.compositeKeyHash;
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public CompositionLocalMap getCompositionLocalMap() {
        return this.compositionLocalMap;
    }

    @Override // androidx.compose.ui.layout.LayoutInfo, androidx.compose.ui.node.ComposeUiNode
    public Density getDensity() {
        return this.density;
    }

    public final int getDepth$ui_release() {
        return this.depth;
    }

    public final boolean getInnerLayerCoordinatorIsDirty$ui_release() {
        return this.innerLayerCoordinatorIsDirty;
    }

    public final AndroidViewHolder getInteropViewFactoryHolder$ui_release() {
        return this.interopViewFactoryHolder;
    }

    public final IntrinsicsPolicy getIntrinsicsPolicy$ui_release() {
        return this.intrinsicsPolicy;
    }

    public final UsageByParent getIntrinsicsUsageByParent$ui_release() {
        return this.intrinsicsUsageByParent;
    }

    public final LayoutNodeLayoutDelegate getLayoutDelegate$ui_release() {
        return this.layoutDelegate;
    }

    @Override // androidx.compose.ui.layout.LayoutInfo, androidx.compose.ui.node.ComposeUiNode
    public LayoutDirection getLayoutDirection() {
        return this.layoutDirection;
    }

    public final LayoutNode getLookaheadRoot$ui_release() {
        return this.lookaheadRoot;
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public MeasurePolicy getMeasurePolicy() {
        return this.measurePolicy;
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public Modifier getModifier() {
        return this.modifier;
    }

    public final boolean getNeedsOnPositionedDispatch$ui_release() {
        return this.needsOnPositionedDispatch;
    }

    public final NodeChain getNodes$ui_release() {
        return this.nodes;
    }

    public final Function1<Owner, Unit> getOnAttach$ui_release() {
        return this.onAttach;
    }

    public final Function1<Owner, Unit> getOnDetach$ui_release() {
        return this.onDetach;
    }

    public final Owner getOwner$ui_release() {
        return this.owner;
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public int getSemanticsId() {
        return this.semanticsId;
    }

    public final LayoutNodeSubcompositionsState getSubcompositionsState$ui_release() {
        return this.subcompositionsState;
    }

    @Override // androidx.compose.ui.layout.LayoutInfo, androidx.compose.ui.node.ComposeUiNode
    public ViewConfiguration getViewConfiguration() {
        return this.viewConfiguration;
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public boolean isAttached() {
        return this.owner != null;
    }

    public final boolean isVirtualLookaheadRoot$ui_release() {
        return this.isVirtualLookaheadRoot;
    }

    public final void setCanMultiMeasure$ui_release(boolean z) {
        this.canMultiMeasure = z;
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void setCompositeKeyHash(int i) {
        this.compositeKeyHash = i;
    }

    public final void setDepth$ui_release(int i) {
        this.depth = i;
    }

    public final void setInnerLayerCoordinatorIsDirty$ui_release(boolean z) {
        this.innerLayerCoordinatorIsDirty = z;
    }

    public final void setInteropViewFactoryHolder$ui_release(AndroidViewHolder androidViewHolder) {
        this.interopViewFactoryHolder = androidViewHolder;
    }

    public final void setIntrinsicsUsageByParent$ui_release(UsageByParent usageByParent) {
        Intrinsics.checkNotNullParameter(usageByParent, "<set-?>");
        this.intrinsicsUsageByParent = usageByParent;
    }

    public final void setNeedsOnPositionedDispatch$ui_release(boolean z) {
        this.needsOnPositionedDispatch = z;
    }

    public final void setOnAttach$ui_release(Function1<? super Owner, Unit> function1) {
        this.onAttach = function1;
    }

    public final void setOnDetach$ui_release(Function1<? super Owner, Unit> function1) {
        this.onDetach = function1;
    }

    public void setSemanticsId(int i) {
        this.semanticsId = i;
    }

    public final void setSubcompositionsState$ui_release(LayoutNodeSubcompositionsState layoutNodeSubcompositionsState) {
        this.subcompositionsState = layoutNodeSubcompositionsState;
    }

    public final void setVirtualLookaheadRoot$ui_release(boolean z) {
        this.isVirtualLookaheadRoot = z;
    }

    public LayoutNode(boolean z, int i) {
        Density density;
        this.isVirtual = z;
        this.semanticsId = i;
        this._foldedChildren = new MutableVectorWithMutationTracking<>(new MutableVector(new LayoutNode[16], 0), new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNode$_foldedChildren$1
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
                LayoutNode.this.getLayoutDelegate$ui_release().markChildrenDirty();
            }
        });
        this._zSortedChildren = new MutableVector<>(new LayoutNode[16], 0);
        this.zSortedChildrenInvalidated = true;
        this.measurePolicy = ErrorMeasurePolicy;
        this.intrinsicsPolicy = new IntrinsicsPolicy(this);
        density = LayoutNodeKt.DefaultDensity;
        this.density = density;
        this.layoutDirection = LayoutDirection.Ltr;
        this.viewConfiguration = DummyViewConfiguration;
        this.compositionLocalMap = CompositionLocalMap.Companion.getEmpty();
        this.intrinsicsUsageByParent = UsageByParent.NotUsed;
        this.previousIntrinsicsUsageByParent = UsageByParent.NotUsed;
        this.nodes = new NodeChain(this);
        this.layoutDelegate = new LayoutNodeLayoutDelegate(this);
        this.innerLayerCoordinatorIsDirty = true;
        this.modifier = Modifier.Companion;
    }

    public /* synthetic */ LayoutNode(boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? SemanticsModifierKt.generateSemanticsId() : i);
    }

    private final void setLookaheadRoot(LayoutNode layoutNode) {
        if (Intrinsics.areEqual(layoutNode, this.lookaheadRoot)) {
            return;
        }
        this.lookaheadRoot = layoutNode;
        if (layoutNode != null) {
            this.layoutDelegate.ensureLookaheadDelegateCreated$ui_release();
            NodeCoordinator wrapped$ui_release = getInnerCoordinator$ui_release().getWrapped$ui_release();
            for (NodeCoordinator outerCoordinator$ui_release = getOuterCoordinator$ui_release(); !Intrinsics.areEqual(outerCoordinator$ui_release, wrapped$ui_release) && outerCoordinator$ui_release != null; outerCoordinator$ui_release = outerCoordinator$ui_release.getWrapped$ui_release()) {
                outerCoordinator$ui_release.ensureLookaheadDelegateCreated();
            }
        }
        invalidateMeasurements$ui_release();
    }

    public final Boolean isPlacedInLookahead() {
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLookaheadPassDelegate$ui_release();
        if (lookaheadPassDelegate$ui_release != null) {
            return Boolean.valueOf(lookaheadPassDelegate$ui_release.isPlaced());
        }
        return null;
    }

    public final List<LayoutNode> getFoldedChildren$ui_release() {
        return this._foldedChildren.asList();
    }

    public final List<Measurable> getChildMeasurables$ui_release() {
        return getMeasurePassDelegate$ui_release().getChildDelegates$ui_release();
    }

    public final List<Measurable> getChildLookaheadMeasurables$ui_release() {
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLookaheadPassDelegate$ui_release();
        Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
        return lookaheadPassDelegate$ui_release.getChildDelegates$ui_release();
    }

    private final void invalidateUnfoldedVirtualChildren() {
        LayoutNode layoutNode;
        if (this.virtualChildrenCount > 0) {
            this.unfoldedVirtualChildrenListDirty = true;
        }
        if (!this.isVirtual || (layoutNode = this._foldedParent) == null) {
            return;
        }
        layoutNode.invalidateUnfoldedVirtualChildren();
    }

    public final MutableVector<LayoutNode> get_children$ui_release() {
        updateChildrenIfDirty$ui_release();
        if (this.virtualChildrenCount == 0) {
            return this._foldedChildren.getVector();
        }
        MutableVector<LayoutNode> mutableVector = this._unfoldedChildren;
        Intrinsics.checkNotNull(mutableVector);
        return mutableVector;
    }

    public final void updateChildrenIfDirty$ui_release() {
        if (this.virtualChildrenCount > 0) {
            recreateUnfoldedChildrenIfDirty();
        }
    }

    public final void forEachChild(Function1<? super LayoutNode, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector.getContent();
            int i = 0;
            do {
                block.invoke(content[i]);
                i++;
            } while (i < size);
        }
    }

    public final void forEachChildIndexed(Function2<? super Integer, ? super LayoutNode, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector.getContent();
            int i = 0;
            do {
                block.invoke(Integer.valueOf(i), content[i]);
                i++;
            } while (i < size);
        }
    }

    public final List<LayoutNode> getChildren$ui_release() {
        return get_children$ui_release().asMutableList();
    }

    public final LayoutNode getParent$ui_release() {
        LayoutNode layoutNode = this._foldedParent;
        while (layoutNode != null && layoutNode.isVirtual) {
            layoutNode = layoutNode._foldedParent;
        }
        return layoutNode;
    }

    @Override // androidx.compose.ui.node.InteroperableComposeUiNode
    public View getInteropView() {
        AndroidViewHolder androidViewHolder = this.interopViewFactoryHolder;
        if (androidViewHolder != null) {
            return androidViewHolder.getInteropView();
        }
        return null;
    }

    public final LayoutState getLayoutState$ui_release() {
        return this.layoutDelegate.getLayoutState$ui_release();
    }

    public final LayoutNodeLayoutDelegate.LookaheadPassDelegate getLookaheadPassDelegate$ui_release() {
        return this.layoutDelegate.getLookaheadPassDelegate$ui_release();
    }

    public final LayoutNodeLayoutDelegate.MeasurePassDelegate getMeasurePassDelegate$ui_release() {
        return this.layoutDelegate.getMeasurePassDelegate$ui_release();
    }

    public final void insertAt$ui_release(int i, LayoutNode instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        if (instance._foldedParent != null) {
            StringBuilder append = new StringBuilder("Cannot insert ").append(instance).append(" because it already has a parent. This tree: ").append(debugTreeToString$default(this, 0, 1, null)).append(" Other tree: ");
            LayoutNode layoutNode = instance._foldedParent;
            throw new IllegalStateException(append.append(layoutNode != null ? debugTreeToString$default(layoutNode, 0, 1, null) : null).toString().toString());
        } else if (instance.owner != null) {
            throw new IllegalStateException(("Cannot insert " + instance + " because it already has an owner. This tree: " + debugTreeToString$default(this, 0, 1, null) + " Other tree: " + debugTreeToString$default(instance, 0, 1, null)).toString());
        } else {
            instance._foldedParent = this;
            this._foldedChildren.add(i, instance);
            onZSortedChildrenInvalidated$ui_release();
            if (instance.isVirtual) {
                this.virtualChildrenCount++;
            }
            invalidateUnfoldedVirtualChildren();
            Owner owner = this.owner;
            if (owner != null) {
                instance.attach$ui_release(owner);
            }
            if (instance.layoutDelegate.getChildrenAccessingCoordinatesDuringPlacement() > 0) {
                LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutDelegate;
                layoutNodeLayoutDelegate.setChildrenAccessingCoordinatesDuringPlacement(layoutNodeLayoutDelegate.getChildrenAccessingCoordinatesDuringPlacement() + 1);
            }
        }
    }

    public final void onZSortedChildrenInvalidated$ui_release() {
        if (!this.isVirtual) {
            this.zSortedChildrenInvalidated = true;
            return;
        }
        LayoutNode parent$ui_release = getParent$ui_release();
        if (parent$ui_release != null) {
            parent$ui_release.onZSortedChildrenInvalidated$ui_release();
        }
    }

    public final void removeAt$ui_release(int i, int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException(("count (" + i2 + ") must be greater than 0").toString());
        }
        int i3 = (i2 + i) - 1;
        if (i > i3) {
            return;
        }
        while (true) {
            onChildRemoved(this._foldedChildren.removeAt(i3));
            if (i3 == i) {
                return;
            }
            i3--;
        }
    }

    public final void removeAll$ui_release() {
        int size = this._foldedChildren.getSize();
        while (true) {
            size--;
            if (-1 < size) {
                onChildRemoved(this._foldedChildren.get(size));
            } else {
                this._foldedChildren.clear();
                return;
            }
        }
    }

    private final void onChildRemoved(LayoutNode layoutNode) {
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate;
        if (layoutNode.layoutDelegate.getChildrenAccessingCoordinatesDuringPlacement() > 0) {
            this.layoutDelegate.setChildrenAccessingCoordinatesDuringPlacement(layoutNodeLayoutDelegate.getChildrenAccessingCoordinatesDuringPlacement() - 1);
        }
        if (this.owner != null) {
            layoutNode.detach$ui_release();
        }
        layoutNode._foldedParent = null;
        layoutNode.getOuterCoordinator$ui_release().setWrappedBy$ui_release(null);
        if (layoutNode.isVirtual) {
            this.virtualChildrenCount--;
            MutableVector<LayoutNode> vector = layoutNode._foldedChildren.getVector();
            int size = vector.getSize();
            if (size > 0) {
                LayoutNode[] content = vector.getContent();
                int i = 0;
                do {
                    content[i].getOuterCoordinator$ui_release().setWrappedBy$ui_release(null);
                    i++;
                } while (i < size);
            }
        }
        invalidateUnfoldedVirtualChildren();
        onZSortedChildrenInvalidated$ui_release();
    }

    public final void move$ui_release(int i, int i2, int i3) {
        if (i == i2) {
            return;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = i > i2 ? i + i4 : i;
            this._foldedChildren.add(i > i2 ? i2 + i4 : (i2 + i3) - 2, this._foldedChildren.removeAt(i5));
        }
        onZSortedChildrenInvalidated$ui_release();
        invalidateUnfoldedVirtualChildren();
        invalidateMeasurements$ui_release();
    }

    public final void invalidateSemantics$ui_release() {
        this._collapsedSemantics = null;
        LayoutNodeKt.requireOwner(this).onSemanticsChange();
    }

    /* JADX WARN: Removed duplicated region for block: B:132:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:153:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void attach$ui_release(androidx.compose.ui.node.Owner r7) {
        /*
            Method dump skipped, instructions count: 332
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LayoutNode.attach$ui_release(androidx.compose.ui.node.Owner):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void detach$ui_release() {
        /*
            r8 = this;
            androidx.compose.ui.node.Owner r0 = r8.owner
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 != 0) goto L2a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r4 = "Cannot detach node that is already detached!  Tree: "
            r0.<init>(r4)
            androidx.compose.ui.node.LayoutNode r4 = r8.getParent$ui_release()
            if (r4 == 0) goto L18
            java.lang.String r3 = debugTreeToString$default(r4, r2, r1, r3)
        L18:
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L2a:
            r8.invalidateFocusOnDetach()
            androidx.compose.ui.node.LayoutNode r4 = r8.getParent$ui_release()
            if (r4 == 0) goto L4d
            r4.invalidateLayer$ui_release()
            r4.invalidateMeasurements$ui_release()
            androidx.compose.ui.node.LayoutNodeLayoutDelegate$MeasurePassDelegate r4 = r8.getMeasurePassDelegate$ui_release()
            androidx.compose.ui.node.LayoutNode$UsageByParent r5 = androidx.compose.ui.node.LayoutNode.UsageByParent.NotUsed
            r4.setMeasuredByParent$ui_release(r5)
            androidx.compose.ui.node.LayoutNodeLayoutDelegate$LookaheadPassDelegate r4 = r8.getLookaheadPassDelegate$ui_release()
            if (r4 == 0) goto L4d
            androidx.compose.ui.node.LayoutNode$UsageByParent r5 = androidx.compose.ui.node.LayoutNode.UsageByParent.NotUsed
            r4.setMeasuredByParent$ui_release(r5)
        L4d:
            androidx.compose.ui.node.LayoutNodeLayoutDelegate r4 = r8.layoutDelegate
            r4.resetAlignmentLines()
            kotlin.jvm.functions.Function1<? super androidx.compose.ui.node.Owner, kotlin.Unit> r4 = r8.onDetach
            if (r4 == 0) goto L59
            r4.invoke(r0)
        L59:
            androidx.compose.ui.node.NodeChain r4 = r8.nodes
            r5 = 8
            int r5 = androidx.compose.ui.node.NodeKind.m4080constructorimpl(r5)
            boolean r4 = r4.m4043hasH91voCI$ui_release(r5)
            if (r4 == 0) goto L6a
            r8.invalidateSemantics$ui_release()
        L6a:
            androidx.compose.ui.node.NodeChain r4 = r8.nodes
            r4.runDetachLifecycle$ui_release()
            access$setIgnoreRemeasureRequests$p(r8, r1)
            androidx.compose.ui.node.MutableVectorWithMutationTracking<androidx.compose.ui.node.LayoutNode> r4 = r8._foldedChildren
            androidx.compose.runtime.collection.MutableVector r4 = r4.getVector()
            int r5 = r4.getSize()
            if (r5 <= 0) goto L8d
            java.lang.Object[] r4 = r4.getContent()
            r6 = r2
        L83:
            r7 = r4[r6]
            androidx.compose.ui.node.LayoutNode r7 = (androidx.compose.ui.node.LayoutNode) r7
            r7.detach$ui_release()
            int r6 = r6 + r1
            if (r6 < r5) goto L83
        L8d:
            access$setIgnoreRemeasureRequests$p(r8, r2)
            androidx.compose.ui.node.NodeChain r1 = r8.nodes
            r1.markAsDetached$ui_release()
            r0.onDetach(r8)
            r8.owner = r3
            r8.setLookaheadRoot(r3)
            r8.depth = r2
            androidx.compose.ui.node.LayoutNodeLayoutDelegate$MeasurePassDelegate r0 = r8.getMeasurePassDelegate$ui_release()
            r0.onNodeDetached()
            androidx.compose.ui.node.LayoutNodeLayoutDelegate$LookaheadPassDelegate r0 = r8.getLookaheadPassDelegate$ui_release()
            if (r0 == 0) goto Laf
            r0.onNodeDetached()
        Laf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LayoutNode.detach$ui_release():void");
    }

    public final MutableVector<LayoutNode> getZSortedChildren() {
        if (this.zSortedChildrenInvalidated) {
            this._zSortedChildren.clear();
            MutableVector<LayoutNode> mutableVector = this._zSortedChildren;
            mutableVector.addAll(mutableVector.getSize(), get_children$ui_release());
            this._zSortedChildren.sortWith(ZComparator);
            this.zSortedChildrenInvalidated = false;
        }
        return this._zSortedChildren;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public boolean isValidOwnerScope() {
        return isAttached();
    }

    public String toString() {
        return JvmActuals_jvmKt.simpleIdentityToString(this, null) + " children: " + getChildren$ui_release().size() + " measurePolicy: " + getMeasurePolicy();
    }

    public final boolean getHasFixedInnerContentConstraints$ui_release() {
        long m4064getLastMeasurementConstraintsmsEJaDk$ui_release = getInnerCoordinator$ui_release().m4064getLastMeasurementConstraintsmsEJaDk$ui_release();
        return Constraints.m4826getHasFixedWidthimpl(m4064getLastMeasurementConstraintsmsEJaDk$ui_release) && Constraints.m4825getHasFixedHeightimpl(m4064getLastMeasurementConstraintsmsEJaDk$ui_release);
    }

    static /* synthetic */ String debugTreeToString$default(LayoutNode layoutNode, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return layoutNode.debugTreeToString(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.String debugTreeToString(int r8) {
        /*
            r7 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            r2 = r1
        L7:
            if (r2 >= r8) goto L11
            java.lang.String r3 = "  "
            r0.append(r3)
            int r2 = r2 + 1
            goto L7
        L11:
            java.lang.String r2 = "|-"
            r0.append(r2)
            java.lang.String r2 = r7.toString()
            r0.append(r2)
            r2 = 10
            r0.append(r2)
            androidx.compose.runtime.collection.MutableVector r2 = r7.get_children$ui_release()
            int r3 = r2.getSize()
            if (r3 <= 0) goto L43
            java.lang.Object[] r2 = r2.getContent()
            r4 = r1
        L32:
            r5 = r2[r4]
            androidx.compose.ui.node.LayoutNode r5 = (androidx.compose.ui.node.LayoutNode) r5
            int r6 = r8 + 1
            java.lang.String r5 = r5.debugTreeToString(r6)
            r0.append(r5)
            int r4 = r4 + 1
            if (r4 < r3) goto L32
        L43:
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "tree.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            if (r8 != 0) goto L5f
            int r8 = r0.length()
            int r8 = r8 + (-1)
            java.lang.String r0 = r0.substring(r1, r8)
            java.lang.String r8 = "this as java.lang.String…ing(startIndex, endIndex)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r8)
        L5f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LayoutNode.debugTreeToString(int):java.lang.String");
    }

    /* compiled from: LayoutNode.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b \u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\r\u001a\u00020\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\"\u0010\u000f\u001a\u00020\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\u0010\u001a\u00020\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000e\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/node/LayoutNode$NoIntrinsicsMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "error", "", "(Ljava/lang/String;)V", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "", "maxIntrinsicWidth", "height", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static abstract class NoIntrinsicsMeasurePolicy implements MeasurePolicy {
        private final String error;

        public NoIntrinsicsMeasurePolicy(String error) {
            Intrinsics.checkNotNullParameter(error, "error");
            this.error = error;
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public /* bridge */ /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
            return ((Number) m4011maxIntrinsicHeight(intrinsicMeasureScope, (List<? extends IntrinsicMeasurable>) list, i)).intValue();
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public /* bridge */ /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
            return ((Number) m4012maxIntrinsicWidth(intrinsicMeasureScope, (List<? extends IntrinsicMeasurable>) list, i)).intValue();
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public /* bridge */ /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
            return ((Number) m4013minIntrinsicHeight(intrinsicMeasureScope, (List<? extends IntrinsicMeasurable>) list, i)).intValue();
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public /* bridge */ /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
            return ((Number) m4014minIntrinsicWidth(intrinsicMeasureScope, (List<? extends IntrinsicMeasurable>) list, i)).intValue();
        }

        /* renamed from: minIntrinsicWidth */
        public Void m4014minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, int i) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
            Intrinsics.checkNotNullParameter(measurables, "measurables");
            throw new IllegalStateException(this.error.toString());
        }

        /* renamed from: minIntrinsicHeight */
        public Void m4013minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, int i) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
            Intrinsics.checkNotNullParameter(measurables, "measurables");
            throw new IllegalStateException(this.error.toString());
        }

        /* renamed from: maxIntrinsicWidth */
        public Void m4012maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, int i) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
            Intrinsics.checkNotNullParameter(measurables, "measurables");
            throw new IllegalStateException(this.error.toString());
        }

        /* renamed from: maxIntrinsicHeight */
        public Void m4011maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, int i) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
            Intrinsics.checkNotNullParameter(measurables, "measurables");
            throw new IllegalStateException(this.error.toString());
        }
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void setMeasurePolicy(MeasurePolicy value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(this.measurePolicy, value)) {
            return;
        }
        this.measurePolicy = value;
        this.intrinsicsPolicy.updateFrom(getMeasurePolicy());
        invalidateMeasurements$ui_release();
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void setDensity(Density value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(this.density, value)) {
            return;
        }
        this.density = value;
        onDensityOrLayoutDirectionChanged();
        NodeChain nodeChain = this.nodes;
        int m4080constructorimpl = NodeKind.m4080constructorimpl(16);
        if ((nodeChain.getAggregateChildKindSet() & m4080constructorimpl) != 0) {
            for (Modifier.Node head$ui_release = nodeChain.getHead$ui_release(); head$ui_release != null; head$ui_release = head$ui_release.getChild$ui_release()) {
                if ((head$ui_release.getKindSet$ui_release() & m4080constructorimpl) != 0) {
                    Modifier.Node node = head$ui_release;
                    MutableVector mutableVector = null;
                    while (node != null) {
                        if (node instanceof PointerInputModifierNode) {
                            ((PointerInputModifierNode) node).onDensityChange();
                        } else if ((node.getKindSet$ui_release() & m4080constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                            int i = 0;
                            for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                if ((delegate$ui_release.getKindSet$ui_release() & m4080constructorimpl) != 0) {
                                    i++;
                                    if (i == 1) {
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
                            if (i == 1) {
                            }
                        }
                        node = DelegatableNodeKt.pop(mutableVector);
                    }
                }
                if ((head$ui_release.getAggregateChildKindSet$ui_release() & m4080constructorimpl) == 0) {
                    return;
                }
            }
        }
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void setLayoutDirection(LayoutDirection value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (this.layoutDirection != value) {
            this.layoutDirection = value;
            onDensityOrLayoutDirectionChanged();
        }
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void setViewConfiguration(ViewConfiguration value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(this.viewConfiguration, value)) {
            return;
        }
        this.viewConfiguration = value;
        NodeChain nodeChain = this.nodes;
        int m4080constructorimpl = NodeKind.m4080constructorimpl(16);
        if ((nodeChain.getAggregateChildKindSet() & m4080constructorimpl) != 0) {
            for (Modifier.Node head$ui_release = nodeChain.getHead$ui_release(); head$ui_release != null; head$ui_release = head$ui_release.getChild$ui_release()) {
                if ((head$ui_release.getKindSet$ui_release() & m4080constructorimpl) != 0) {
                    Modifier.Node node = head$ui_release;
                    MutableVector mutableVector = null;
                    while (node != null) {
                        if (node instanceof PointerInputModifierNode) {
                            ((PointerInputModifierNode) node).onViewConfigurationChange();
                        } else if ((node.getKindSet$ui_release() & m4080constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                            int i = 0;
                            for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                if ((delegate$ui_release.getKindSet$ui_release() & m4080constructorimpl) != 0) {
                                    i++;
                                    if (i == 1) {
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
                            if (i == 1) {
                            }
                        }
                        node = DelegatableNodeKt.pop(mutableVector);
                    }
                }
                if ((head$ui_release.getAggregateChildKindSet$ui_release() & m4080constructorimpl) == 0) {
                    return;
                }
            }
        }
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void setCompositionLocalMap(CompositionLocalMap value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.compositionLocalMap = value;
        setDensity((Density) value.get(CompositionLocalsKt.getLocalDensity()));
        setLayoutDirection((LayoutDirection) value.get(CompositionLocalsKt.getLocalLayoutDirection()));
        setViewConfiguration((ViewConfiguration) value.get(CompositionLocalsKt.getLocalViewConfiguration()));
        NodeChain nodeChain = this.nodes;
        int m4080constructorimpl = NodeKind.m4080constructorimpl(32768);
        if ((nodeChain.getAggregateChildKindSet() & m4080constructorimpl) != 0) {
            for (Modifier.Node head$ui_release = nodeChain.getHead$ui_release(); head$ui_release != null; head$ui_release = head$ui_release.getChild$ui_release()) {
                if ((head$ui_release.getKindSet$ui_release() & m4080constructorimpl) != 0) {
                    Modifier.Node node = head$ui_release;
                    MutableVector mutableVector = null;
                    while (node != null) {
                        if (node instanceof CompositionLocalConsumerModifierNode) {
                            Modifier.Node node2 = ((CompositionLocalConsumerModifierNode) node).getNode();
                            if (node2.isAttached()) {
                                NodeKindKt.autoInvalidateUpdatedNode(node2);
                            } else {
                                node2.setUpdatedNodeAwaitingAttachForInvalidation$ui_release(true);
                            }
                        } else if ((node.getKindSet$ui_release() & m4080constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                            int i = 0;
                            for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                if ((delegate$ui_release.getKindSet$ui_release() & m4080constructorimpl) != 0) {
                                    i++;
                                    if (i == 1) {
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
                            if (i == 1) {
                            }
                        }
                        node = DelegatableNodeKt.pop(mutableVector);
                    }
                }
                if ((head$ui_release.getAggregateChildKindSet$ui_release() & m4080constructorimpl) == 0) {
                    return;
                }
            }
        }
    }

    private final void onDensityOrLayoutDirectionChanged() {
        invalidateMeasurements$ui_release();
        LayoutNode parent$ui_release = getParent$ui_release();
        if (parent$ui_release != null) {
            parent$ui_release.invalidateLayer$ui_release();
        }
        invalidateLayers$ui_release();
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public int getWidth() {
        return this.layoutDelegate.getWidth$ui_release();
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public int getHeight() {
        return this.layoutDelegate.getHeight$ui_release();
    }

    public final boolean getAlignmentLinesRequired$ui_release() {
        AlignmentLines alignmentLines;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutDelegate;
        if (layoutNodeLayoutDelegate.getAlignmentLinesOwner$ui_release().getAlignmentLines().getRequired$ui_release()) {
            return true;
        }
        AlignmentLinesOwner lookaheadAlignmentLinesOwner$ui_release = layoutNodeLayoutDelegate.getLookaheadAlignmentLinesOwner$ui_release();
        return (lookaheadAlignmentLinesOwner$ui_release == null || (alignmentLines = lookaheadAlignmentLinesOwner$ui_release.getAlignmentLines()) == null || !alignmentLines.getRequired$ui_release()) ? false : true;
    }

    public final LayoutNodeDrawScope getMDrawScope$ui_release() {
        return LayoutNodeKt.requireOwner(this).getSharedDrawScope();
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public boolean isPlaced() {
        return getMeasurePassDelegate$ui_release().isPlaced();
    }

    public final int getPlaceOrder$ui_release() {
        return getMeasurePassDelegate$ui_release().getPlaceOrder$ui_release();
    }

    public final UsageByParent getMeasuredByParent$ui_release() {
        return getMeasurePassDelegate$ui_release().getMeasuredByParent$ui_release();
    }

    public final UsageByParent getMeasuredByParentInLookahead$ui_release() {
        UsageByParent measuredByParent$ui_release;
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLookaheadPassDelegate$ui_release();
        return (lookaheadPassDelegate$ui_release == null || (measuredByParent$ui_release = lookaheadPassDelegate$ui_release.getMeasuredByParent$ui_release()) == null) ? UsageByParent.NotUsed : measuredByParent$ui_release;
    }

    public final NodeCoordinator getInnerCoordinator$ui_release() {
        return this.nodes.getInnerCoordinator$ui_release();
    }

    public final NodeCoordinator getOuterCoordinator$ui_release() {
        return this.nodes.getOuterCoordinator$ui_release();
    }

    private final float getZIndex() {
        return getMeasurePassDelegate$ui_release().getZIndex$ui_release();
    }

    private final NodeCoordinator getInnerLayerCoordinator() {
        if (this.innerLayerCoordinatorIsDirty) {
            NodeCoordinator innerCoordinator$ui_release = getInnerCoordinator$ui_release();
            NodeCoordinator wrappedBy$ui_release = getOuterCoordinator$ui_release().getWrappedBy$ui_release();
            this._innerLayerCoordinator = null;
            while (true) {
                if (Intrinsics.areEqual(innerCoordinator$ui_release, wrappedBy$ui_release)) {
                    break;
                }
                if ((innerCoordinator$ui_release != null ? innerCoordinator$ui_release.getLayer() : null) != null) {
                    this._innerLayerCoordinator = innerCoordinator$ui_release;
                    break;
                }
                innerCoordinator$ui_release = innerCoordinator$ui_release != null ? innerCoordinator$ui_release.getWrappedBy$ui_release() : null;
            }
        }
        NodeCoordinator nodeCoordinator = this._innerLayerCoordinator;
        if (nodeCoordinator == null || nodeCoordinator.getLayer() != null) {
            return nodeCoordinator;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void invalidateLayer$ui_release() {
        NodeCoordinator innerLayerCoordinator = getInnerLayerCoordinator();
        if (innerLayerCoordinator != null) {
            innerLayerCoordinator.invalidateLayer();
            return;
        }
        LayoutNode parent$ui_release = getParent$ui_release();
        if (parent$ui_release != null) {
            parent$ui_release.invalidateLayer$ui_release();
        }
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void setModifier(Modifier value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (this.isVirtual && getModifier() != Modifier.Companion) {
            throw new IllegalArgumentException("Modifiers are not supported on virtual LayoutNodes".toString());
        }
        this.modifier = value;
        this.nodes.updateFrom$ui_release(value);
        this.layoutDelegate.updateParentData();
        if (this.nodes.m4043hasH91voCI$ui_release(NodeKind.m4080constructorimpl(512)) && this.lookaheadRoot == null) {
            setLookaheadRoot(this);
        }
    }

    private final void resetModifierState() {
        this.nodes.resetState$ui_release();
    }

    public final void invalidateParentData$ui_release() {
        this.layoutDelegate.invalidateParentData();
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public LayoutCoordinates getCoordinates() {
        return getInnerCoordinator$ui_release();
    }

    public final void place$ui_release(int i, int i2) {
        if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            clearSubtreePlacementIntrinsicsUsage();
        }
        LayoutNodeLayoutDelegate.MeasurePassDelegate measurePassDelegate$ui_release = getMeasurePassDelegate$ui_release();
        Placeable.PlacementScope.Companion companion = Placeable.PlacementScope.Companion;
        int measuredWidth = measurePassDelegate$ui_release.getMeasuredWidth();
        LayoutDirection layoutDirection = getLayoutDirection();
        LayoutNode parent$ui_release = getParent$ui_release();
        NodeCoordinator innerCoordinator$ui_release = parent$ui_release != null ? parent$ui_release.getInnerCoordinator$ui_release() : null;
        LayoutCoordinates layoutCoordinates = Placeable.PlacementScope._coordinates;
        int parentWidth = Placeable.PlacementScope.Companion.getParentWidth();
        LayoutDirection parentLayoutDirection = Placeable.PlacementScope.Companion.getParentLayoutDirection();
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = Placeable.PlacementScope.layoutDelegate;
        Placeable.PlacementScope.Companion companion2 = Placeable.PlacementScope.Companion;
        Placeable.PlacementScope.parentWidth = measuredWidth;
        Placeable.PlacementScope.Companion companion3 = Placeable.PlacementScope.Companion;
        Placeable.PlacementScope.parentLayoutDirection = layoutDirection;
        boolean configureForPlacingForAlignment = companion.configureForPlacingForAlignment(innerCoordinator$ui_release);
        Placeable.PlacementScope.placeRelative$default(companion, measurePassDelegate$ui_release, i, i2, 0.0f, 4, null);
        if (innerCoordinator$ui_release != null) {
            innerCoordinator$ui_release.setPlacingForAlignment$ui_release(configureForPlacingForAlignment);
        }
        Placeable.PlacementScope.Companion companion4 = Placeable.PlacementScope.Companion;
        Placeable.PlacementScope.parentWidth = parentWidth;
        Placeable.PlacementScope.Companion companion5 = Placeable.PlacementScope.Companion;
        Placeable.PlacementScope.parentLayoutDirection = parentLayoutDirection;
        Placeable.PlacementScope._coordinates = layoutCoordinates;
        Placeable.PlacementScope.layoutDelegate = layoutNodeLayoutDelegate;
    }

    public final void replace$ui_release() {
        if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            clearSubtreePlacementIntrinsicsUsage();
        }
        getMeasurePassDelegate$ui_release().replace();
    }

    public final void lookaheadReplace$ui_release() {
        if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            clearSubtreePlacementIntrinsicsUsage();
        }
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLookaheadPassDelegate$ui_release();
        Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
        lookaheadPassDelegate$ui_release.replace();
    }

    public final void draw$ui_release(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        getOuterCoordinator$ui_release().draw(canvas);
    }

    /* renamed from: hitTest-M_7yMNQ$ui_release$default */
    public static /* synthetic */ void m4001hitTestM_7yMNQ$ui_release$default(LayoutNode layoutNode, long j, HitTestResult hitTestResult, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        boolean z3 = z;
        if ((i & 8) != 0) {
            z2 = true;
        }
        layoutNode.m4005hitTestM_7yMNQ$ui_release(j, hitTestResult, z3, z2);
    }

    /* renamed from: hitTest-M_7yMNQ$ui_release */
    public final void m4005hitTestM_7yMNQ$ui_release(long j, HitTestResult hitTestResult, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(hitTestResult, "hitTestResult");
        getOuterCoordinator$ui_release().m4067hitTestYqVAtuI(NodeCoordinator.Companion.getPointerInputSource(), getOuterCoordinator$ui_release().m4063fromParentPositionMKHz9U(j), hitTestResult, z, z2);
    }

    /* renamed from: hitTestSemantics-M_7yMNQ$ui_release */
    public final void m4006hitTestSemanticsM_7yMNQ$ui_release(long j, HitTestResult hitSemanticsEntities, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(hitSemanticsEntities, "hitSemanticsEntities");
        getOuterCoordinator$ui_release().m4067hitTestYqVAtuI(NodeCoordinator.Companion.getSemanticsSource(), getOuterCoordinator$ui_release().m4063fromParentPositionMKHz9U(j), hitSemanticsEntities, true, z2);
    }

    public final void rescheduleRemeasureOrRelayout$ui_release(LayoutNode it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (WhenMappings.$EnumSwitchMapping$0[it.getLayoutState$ui_release().ordinal()] == 1) {
            if (it.getMeasurePending$ui_release()) {
                requestRemeasure$ui_release$default(it, true, false, 2, null);
                return;
            } else if (it.getLayoutPending$ui_release()) {
                it.requestRelayout$ui_release(true);
                return;
            } else if (it.getLookaheadMeasurePending$ui_release()) {
                requestLookaheadRemeasure$ui_release$default(it, true, false, 2, null);
                return;
            } else if (it.getLookaheadLayoutPending$ui_release()) {
                it.requestLookaheadRelayout$ui_release(true);
                return;
            } else {
                return;
            }
        }
        throw new IllegalStateException("Unexpected state " + it.getLayoutState$ui_release());
    }

    public static /* synthetic */ void requestRemeasure$ui_release$default(LayoutNode layoutNode, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        layoutNode.requestRemeasure$ui_release(z, z2);
    }

    public final void requestRemeasure$ui_release(boolean z, boolean z2) {
        Owner owner;
        if (this.ignoreRemeasureRequests || this.isVirtual || (owner = this.owner) == null) {
            return;
        }
        Owner.onRequestMeasure$default(owner, this, false, z, z2, 2, null);
        getMeasurePassDelegate$ui_release().invalidateIntrinsicsParent(z);
    }

    public static /* synthetic */ void requestLookaheadRemeasure$ui_release$default(LayoutNode layoutNode, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        layoutNode.requestLookaheadRemeasure$ui_release(z, z2);
    }

    public final void requestLookaheadRemeasure$ui_release(boolean z, boolean z2) {
        if (this.lookaheadRoot == null) {
            throw new IllegalStateException("Lookahead measure cannot be requested on a node that is not a part of theLookaheadLayout".toString());
        }
        Owner owner = this.owner;
        if (owner == null || this.ignoreRemeasureRequests || this.isVirtual) {
            return;
        }
        owner.onRequestMeasure(this, true, z, z2);
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLookaheadPassDelegate$ui_release();
        Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
        lookaheadPassDelegate$ui_release.invalidateIntrinsicsParent(z);
    }

    public final void invalidateMeasurements$ui_release() {
        if (this.lookaheadRoot != null) {
            requestLookaheadRemeasure$ui_release$default(this, false, false, 3, null);
        } else {
            requestRemeasure$ui_release$default(this, false, false, 3, null);
        }
    }

    public final void ignoreRemeasureRequests$ui_release(Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.ignoreRemeasureRequests = true;
        block.invoke();
        this.ignoreRemeasureRequests = false;
    }

    public static /* synthetic */ void requestRelayout$ui_release$default(LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        layoutNode.requestRelayout$ui_release(z);
    }

    public final void requestRelayout$ui_release(boolean z) {
        Owner owner;
        if (this.isVirtual || (owner = this.owner) == null) {
            return;
        }
        Owner.onRequestRelayout$default(owner, this, false, z, 2, null);
    }

    public static /* synthetic */ void requestLookaheadRelayout$ui_release$default(LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        layoutNode.requestLookaheadRelayout$ui_release(z);
    }

    public final void requestLookaheadRelayout$ui_release(boolean z) {
        Owner owner;
        if (this.isVirtual || (owner = this.owner) == null) {
            return;
        }
        owner.onRequestRelayout(this, true, z);
    }

    public final void dispatchOnPositionedCallbacks$ui_release() {
        if (getLayoutState$ui_release() != LayoutState.Idle || getLayoutPending$ui_release() || getMeasurePending$ui_release() || !isPlaced()) {
            return;
        }
        NodeChain nodeChain = this.nodes;
        int m4080constructorimpl = NodeKind.m4080constructorimpl(256);
        if ((nodeChain.getAggregateChildKindSet() & m4080constructorimpl) != 0) {
            for (Modifier.Node head$ui_release = nodeChain.getHead$ui_release(); head$ui_release != null; head$ui_release = head$ui_release.getChild$ui_release()) {
                if ((head$ui_release.getKindSet$ui_release() & m4080constructorimpl) != 0) {
                    Modifier.Node node = head$ui_release;
                    MutableVector mutableVector = null;
                    while (node != null) {
                        if (node instanceof GlobalPositionAwareModifierNode) {
                            GlobalPositionAwareModifierNode globalPositionAwareModifierNode = (GlobalPositionAwareModifierNode) node;
                            globalPositionAwareModifierNode.onGloballyPositioned(DelegatableNodeKt.m3978requireCoordinator64DMado(globalPositionAwareModifierNode, NodeKind.m4080constructorimpl(256)));
                        } else if ((node.getKindSet$ui_release() & m4080constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                            int i = 0;
                            for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                if ((delegate$ui_release.getKindSet$ui_release() & m4080constructorimpl) != 0) {
                                    i++;
                                    if (i == 1) {
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
                            if (i == 1) {
                            }
                        }
                        node = DelegatableNodeKt.pop(mutableVector);
                    }
                }
                if ((head$ui_release.getAggregateChildKindSet$ui_release() & m4080constructorimpl) == 0) {
                    return;
                }
            }
        }
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public List<ModifierInfo> getModifierInfo() {
        return this.nodes.getModifierInfo();
    }

    /* renamed from: lookaheadRemeasure-_Sx5XlM$ui_release$default */
    public static /* synthetic */ boolean m4003lookaheadRemeasure_Sx5XlM$ui_release$default(LayoutNode layoutNode, Constraints constraints, int i, Object obj) {
        if ((i & 1) != 0) {
            constraints = layoutNode.layoutDelegate.m4022getLastLookaheadConstraintsDWUhwKw();
        }
        return layoutNode.m4007lookaheadRemeasure_Sx5XlM$ui_release(constraints);
    }

    /* renamed from: lookaheadRemeasure-_Sx5XlM$ui_release */
    public final boolean m4007lookaheadRemeasure_Sx5XlM$ui_release(Constraints constraints) {
        if (constraints == null || this.lookaheadRoot == null) {
            return false;
        }
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLookaheadPassDelegate$ui_release();
        Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
        return lookaheadPassDelegate$ui_release.m4025remeasureBRTryo0(constraints.m4834unboximpl());
    }

    /* renamed from: remeasure-_Sx5XlM$ui_release$default */
    public static /* synthetic */ boolean m4004remeasure_Sx5XlM$ui_release$default(LayoutNode layoutNode, Constraints constraints, int i, Object obj) {
        if ((i & 1) != 0) {
            constraints = layoutNode.layoutDelegate.m4021getLastConstraintsDWUhwKw();
        }
        return layoutNode.m4008remeasure_Sx5XlM$ui_release(constraints);
    }

    /* renamed from: remeasure-_Sx5XlM$ui_release */
    public final boolean m4008remeasure_Sx5XlM$ui_release(Constraints constraints) {
        if (constraints != null) {
            if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
                clearSubtreeIntrinsicsUsage$ui_release();
            }
            return getMeasurePassDelegate$ui_release().m4028remeasureBRTryo0(constraints.m4834unboximpl());
        }
        return false;
    }

    public final boolean getMeasurePending$ui_release() {
        return this.layoutDelegate.getMeasurePending$ui_release();
    }

    public final boolean getLayoutPending$ui_release() {
        return this.layoutDelegate.getLayoutPending$ui_release();
    }

    public final boolean getLookaheadMeasurePending$ui_release() {
        return this.layoutDelegate.getLookaheadMeasurePending$ui_release();
    }

    public final boolean getLookaheadLayoutPending$ui_release() {
        return this.layoutDelegate.getLookaheadLayoutPending$ui_release();
    }

    public final void markLayoutPending$ui_release() {
        this.layoutDelegate.markLayoutPending$ui_release();
    }

    public final void markMeasurePending$ui_release() {
        this.layoutDelegate.markMeasurePending$ui_release();
    }

    public final void markLookaheadLayoutPending$ui_release() {
        this.layoutDelegate.markLookaheadLayoutPending$ui_release();
    }

    public static /* synthetic */ void invalidateSubtree$default(LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        layoutNode.invalidateSubtree(z);
    }

    public final void invalidateSubtree(boolean z) {
        LayoutNode parent$ui_release;
        if (z && (parent$ui_release = getParent$ui_release()) != null) {
            parent$ui_release.invalidateLayer$ui_release();
        }
        invalidateSemantics$ui_release();
        requestRemeasure$ui_release$default(this, false, false, 3, null);
        NodeChain nodeChain = this.nodes;
        int m4080constructorimpl = NodeKind.m4080constructorimpl(2);
        if ((nodeChain.getAggregateChildKindSet() & m4080constructorimpl) != 0) {
            for (Modifier.Node head$ui_release = nodeChain.getHead$ui_release(); head$ui_release != null; head$ui_release = head$ui_release.getChild$ui_release()) {
                if ((head$ui_release.getKindSet$ui_release() & m4080constructorimpl) != 0) {
                    Modifier.Node node = head$ui_release;
                    MutableVector mutableVector = null;
                    while (node != null) {
                        if (node instanceof LayoutModifierNode) {
                            OwnedLayer layer = DelegatableNodeKt.m3978requireCoordinator64DMado((LayoutModifierNode) node, NodeKind.m4080constructorimpl(2)).getLayer();
                            if (layer != null) {
                                layer.invalidate();
                            }
                        } else if ((node.getKindSet$ui_release() & m4080constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                            int i = 0;
                            for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                if ((delegate$ui_release.getKindSet$ui_release() & m4080constructorimpl) != 0) {
                                    i++;
                                    if (i == 1) {
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
                            if (i == 1) {
                            }
                        }
                        node = DelegatableNodeKt.pop(mutableVector);
                    }
                }
                if ((head$ui_release.getAggregateChildKindSet$ui_release() & m4080constructorimpl) == 0) {
                    break;
                }
            }
        }
        MutableVector<LayoutNode> mutableVector2 = get_children$ui_release();
        int size = mutableVector2.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector2.getContent();
            int i2 = 0;
            do {
                content[i2].invalidateSubtree(false);
                i2++;
            } while (i2 < size);
        }
    }

    public final void markLookaheadMeasurePending$ui_release() {
        this.layoutDelegate.markLookaheadMeasurePending$ui_release();
    }

    @Override // androidx.compose.ui.layout.Remeasurement
    public void forceRemeasure() {
        if (this.lookaheadRoot != null) {
            requestLookaheadRemeasure$ui_release$default(this, false, false, 1, null);
        } else {
            requestRemeasure$ui_release$default(this, false, false, 1, null);
        }
        Constraints m4021getLastConstraintsDWUhwKw = this.layoutDelegate.m4021getLastConstraintsDWUhwKw();
        if (m4021getLastConstraintsDWUhwKw != null) {
            Owner owner = this.owner;
            if (owner != null) {
                owner.mo4135measureAndLayout0kLqBqw(this, m4021getLastConstraintsDWUhwKw.m4834unboximpl());
                return;
            }
            return;
        }
        Owner owner2 = this.owner;
        if (owner2 != null) {
            Owner.measureAndLayout$default(owner2, false, 1, null);
        }
    }

    @Override // androidx.compose.ui.node.Owner.OnLayoutCompletedListener
    public void onLayoutComplete() {
        NodeCoordinator innerCoordinator$ui_release = getInnerCoordinator$ui_release();
        int m4080constructorimpl = NodeKind.m4080constructorimpl(128);
        boolean m4089getIncludeSelfInTraversalH91voCI = NodeKindKt.m4089getIncludeSelfInTraversalH91voCI(m4080constructorimpl);
        Modifier.Node tail = innerCoordinator$ui_release.getTail();
        if (!m4089getIncludeSelfInTraversalH91voCI && (tail = tail.getParent$ui_release()) == null) {
            return;
        }
        for (Modifier.Node headNode = innerCoordinator$ui_release.headNode(m4089getIncludeSelfInTraversalH91voCI); headNode != null && (headNode.getAggregateChildKindSet$ui_release() & m4080constructorimpl) != 0; headNode = headNode.getChild$ui_release()) {
            if ((headNode.getKindSet$ui_release() & m4080constructorimpl) != 0) {
                Modifier.Node node = headNode;
                MutableVector mutableVector = null;
                while (node != null) {
                    if (node instanceof LayoutAwareModifierNode) {
                        ((LayoutAwareModifierNode) node).onPlaced(getInnerCoordinator$ui_release());
                    } else if ((node.getKindSet$ui_release() & m4080constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                        int i = 0;
                        for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                            if ((delegate$ui_release.getKindSet$ui_release() & m4080constructorimpl) != 0) {
                                i++;
                                if (i == 1) {
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
                        if (i == 1) {
                        }
                    }
                    node = DelegatableNodeKt.pop(mutableVector);
                }
            }
            if (headNode == tail) {
                return;
            }
        }
    }

    public final void forEachCoordinator$ui_release(Function1<? super LayoutModifierNodeCoordinator, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        NodeCoordinator outerCoordinator$ui_release = getOuterCoordinator$ui_release();
        NodeCoordinator innerCoordinator$ui_release = getInnerCoordinator$ui_release();
        while (outerCoordinator$ui_release != innerCoordinator$ui_release) {
            Intrinsics.checkNotNull(outerCoordinator$ui_release, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
            LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = (LayoutModifierNodeCoordinator) outerCoordinator$ui_release;
            block.invoke(layoutModifierNodeCoordinator);
            outerCoordinator$ui_release = layoutModifierNodeCoordinator.getWrapped$ui_release();
        }
    }

    public final void forEachCoordinatorIncludingInner$ui_release(Function1<? super NodeCoordinator, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        NodeCoordinator wrapped$ui_release = getInnerCoordinator$ui_release().getWrapped$ui_release();
        for (NodeCoordinator outerCoordinator$ui_release = getOuterCoordinator$ui_release(); !Intrinsics.areEqual(outerCoordinator$ui_release, wrapped$ui_release) && outerCoordinator$ui_release != null; outerCoordinator$ui_release = outerCoordinator$ui_release.getWrapped$ui_release()) {
            block.invoke(outerCoordinator$ui_release);
        }
    }

    public final void clearSubtreeIntrinsicsUsage$ui_release() {
        this.previousIntrinsicsUsageByParent = this.intrinsicsUsageByParent;
        this.intrinsicsUsageByParent = UsageByParent.NotUsed;
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector.getContent();
            int i = 0;
            do {
                LayoutNode layoutNode = content[i];
                if (layoutNode.intrinsicsUsageByParent != UsageByParent.NotUsed) {
                    layoutNode.clearSubtreeIntrinsicsUsage$ui_release();
                }
                i++;
            } while (i < size);
        }
    }

    private final void clearSubtreePlacementIntrinsicsUsage() {
        this.previousIntrinsicsUsageByParent = this.intrinsicsUsageByParent;
        this.intrinsicsUsageByParent = UsageByParent.NotUsed;
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector.getContent();
            int i = 0;
            do {
                LayoutNode layoutNode = content[i];
                if (layoutNode.intrinsicsUsageByParent == UsageByParent.InLayoutBlock) {
                    layoutNode.clearSubtreePlacementIntrinsicsUsage();
                }
                i++;
            } while (i < size);
        }
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public LayoutInfo getParentInfo() {
        return getParent$ui_release();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void onReuse() {
        if (!isAttached()) {
            throw new IllegalArgumentException("onReuse is only expected on attached node".toString());
        }
        AndroidViewHolder androidViewHolder = this.interopViewFactoryHolder;
        if (androidViewHolder != null) {
            androidViewHolder.onReuse();
        }
        if (this.deactivated) {
            this.deactivated = false;
        } else {
            resetModifierState();
        }
        setSemanticsId(SemanticsModifierKt.generateSemanticsId());
        this.nodes.markAsAttached();
        this.nodes.runAttachLifecycle();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void onDeactivate() {
        AndroidViewHolder androidViewHolder = this.interopViewFactoryHolder;
        if (androidViewHolder != null) {
            androidViewHolder.onDeactivate();
        }
        this.deactivated = true;
        resetModifierState();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void onRelease() {
        AndroidViewHolder androidViewHolder = this.interopViewFactoryHolder;
        if (androidViewHolder != null) {
            androidViewHolder.onRelease();
        }
        NodeCoordinator wrapped$ui_release = getInnerCoordinator$ui_release().getWrapped$ui_release();
        for (NodeCoordinator outerCoordinator$ui_release = getOuterCoordinator$ui_release(); !Intrinsics.areEqual(outerCoordinator$ui_release, wrapped$ui_release) && outerCoordinator$ui_release != null; outerCoordinator$ui_release = outerCoordinator$ui_release.getWrapped$ui_release()) {
            outerCoordinator$ui_release.onRelease();
        }
    }

    /* compiled from: LayoutNode.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0080T¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/node/LayoutNode$Companion;", "", "()V", "Constructor", "Lkotlin/Function0;", "Landroidx/compose/ui/node/LayoutNode;", "getConstructor$ui_release", "()Lkotlin/jvm/functions/Function0;", "DummyViewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getDummyViewConfiguration$ui_release", "()Landroidx/compose/ui/platform/ViewConfiguration;", "ErrorMeasurePolicy", "Landroidx/compose/ui/node/LayoutNode$NoIntrinsicsMeasurePolicy;", "NotPlacedPlaceOrder", "", "ZComparator", "Ljava/util/Comparator;", "getZComparator$ui_release", "()Ljava/util/Comparator;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Function0<LayoutNode> getConstructor$ui_release() {
            return LayoutNode.Constructor;
        }

        public final ViewConfiguration getDummyViewConfiguration$ui_release() {
            return LayoutNode.DummyViewConfiguration;
        }

        public final Comparator<LayoutNode> getZComparator$ui_release() {
            return LayoutNode.ZComparator;
        }
    }

    public static final int ZComparator$lambda$38(LayoutNode layoutNode, LayoutNode layoutNode2) {
        if (layoutNode.getZIndex() == layoutNode2.getZIndex()) {
            return Intrinsics.compare(layoutNode.getPlaceOrder$ui_release(), layoutNode2.getPlaceOrder$ui_release());
        }
        return Float.compare(layoutNode.getZIndex(), layoutNode2.getZIndex());
    }

    private final void recreateUnfoldedChildrenIfDirty() {
        if (this.unfoldedVirtualChildrenListDirty) {
            int i = 0;
            this.unfoldedVirtualChildrenListDirty = false;
            MutableVector<LayoutNode> mutableVector = this._unfoldedChildren;
            if (mutableVector == null) {
                mutableVector = new MutableVector<>(new LayoutNode[16], 0);
                this._unfoldedChildren = mutableVector;
            }
            mutableVector.clear();
            MutableVector<LayoutNode> vector = this._foldedChildren.getVector();
            int size = vector.getSize();
            if (size <= 0) {
                this.layoutDelegate.markChildrenDirty();
            }
            LayoutNode[] content = vector.getContent();
            do {
                LayoutNode layoutNode = content[i];
                if (layoutNode.isVirtual) {
                    mutableVector.addAll(mutableVector.getSize(), layoutNode.get_children$ui_release());
                } else {
                    mutableVector.add(layoutNode);
                }
                i++;
            } while (i < size);
            this.layoutDelegate.markChildrenDirty();
        }
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [androidx.compose.ui.semantics.SemanticsConfiguration, T] */
    public final SemanticsConfiguration getCollapsedSemantics$ui_release() {
        if (this.nodes.m4043hasH91voCI$ui_release(NodeKind.m4080constructorimpl(8)) && this._collapsedSemantics == null) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = new SemanticsConfiguration();
            LayoutNodeKt.requireOwner(this).getSnapshotObserver().observeSemanticsReads$ui_release(this, new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNode$collapsedSemantics$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Type inference failed for: r6v8, types: [androidx.compose.ui.semantics.SemanticsConfiguration, T] */
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    NodeChain nodes$ui_release = LayoutNode.this.getNodes$ui_release();
                    int m4080constructorimpl = NodeKind.m4080constructorimpl(8);
                    Ref.ObjectRef<SemanticsConfiguration> objectRef2 = objectRef;
                    if ((nodes$ui_release.getAggregateChildKindSet() & m4080constructorimpl) != 0) {
                        for (Modifier.Node tail$ui_release = nodes$ui_release.getTail$ui_release(); tail$ui_release != null; tail$ui_release = tail$ui_release.getParent$ui_release()) {
                            if ((tail$ui_release.getKindSet$ui_release() & m4080constructorimpl) != 0) {
                                Modifier.Node node = tail$ui_release;
                                MutableVector mutableVector = null;
                                while (node != null) {
                                    if (node instanceof SemanticsModifierNode) {
                                        SemanticsModifierNode semanticsModifierNode = (SemanticsModifierNode) node;
                                        if (semanticsModifierNode.getShouldClearDescendantSemantics()) {
                                            objectRef2.element = new SemanticsConfiguration();
                                            objectRef2.element.setClearingSemantics(true);
                                        }
                                        if (semanticsModifierNode.getShouldMergeDescendantSemantics()) {
                                            objectRef2.element.setMergingSemanticsOfDescendants(true);
                                        }
                                        semanticsModifierNode.applySemantics(objectRef2.element);
                                    } else if ((node.getKindSet$ui_release() & m4080constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                                        int i = 0;
                                        for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                            if ((delegate$ui_release.getKindSet$ui_release() & m4080constructorimpl) != 0) {
                                                i++;
                                                if (i == 1) {
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
                                        if (i == 1) {
                                        }
                                    }
                                    node = DelegatableNodeKt.pop(mutableVector);
                                }
                            }
                        }
                    }
                }
            });
            this._collapsedSemantics = (SemanticsConfiguration) objectRef.element;
            return (SemanticsConfiguration) objectRef.element;
        }
        return this._collapsedSemantics;
    }

    private final void invalidateFocusOnAttach() {
        if (this.nodes.has$ui_release(NodeKind.m4080constructorimpl(1024) | NodeKind.m4080constructorimpl(2048) | NodeKind.m4080constructorimpl(4096))) {
            for (Modifier.Node head$ui_release = this.nodes.getHead$ui_release(); head$ui_release != null; head$ui_release = head$ui_release.getChild$ui_release()) {
                if (((NodeKind.m4080constructorimpl(1024) & head$ui_release.getKindSet$ui_release()) != 0) | ((NodeKind.m4080constructorimpl(2048) & head$ui_release.getKindSet$ui_release()) != 0) | ((NodeKind.m4080constructorimpl(4096) & head$ui_release.getKindSet$ui_release()) != 0)) {
                    NodeKindKt.autoInvalidateInsertedNode(head$ui_release);
                }
            }
        }
    }

    private final void invalidateFocusOnDetach() {
        NodeChain nodeChain = this.nodes;
        int m4080constructorimpl = NodeKind.m4080constructorimpl(1024);
        if ((nodeChain.getAggregateChildKindSet() & m4080constructorimpl) != 0) {
            for (Modifier.Node tail$ui_release = nodeChain.getTail$ui_release(); tail$ui_release != null; tail$ui_release = tail$ui_release.getParent$ui_release()) {
                if ((tail$ui_release.getKindSet$ui_release() & m4080constructorimpl) != 0) {
                    Modifier.Node node = tail$ui_release;
                    MutableVector mutableVector = null;
                    while (node != null) {
                        if (node instanceof FocusTargetNode) {
                            FocusTargetNode focusTargetNode = (FocusTargetNode) node;
                            if (focusTargetNode.getFocusState().isFocused()) {
                                LayoutNodeKt.requireOwner(this).getFocusOwner().clearFocus(true, false);
                                focusTargetNode.scheduleInvalidationForFocusEvents$ui_release();
                            }
                        } else if ((node.getKindSet$ui_release() & m4080constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                            int i = 0;
                            for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                if ((delegate$ui_release.getKindSet$ui_release() & m4080constructorimpl) != 0) {
                                    i++;
                                    if (i == 1) {
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
                            if (i == 1) {
                            }
                        }
                        node = DelegatableNodeKt.pop(mutableVector);
                    }
                }
            }
        }
    }

    public final void invalidateLayers$ui_release() {
        NodeCoordinator outerCoordinator$ui_release = getOuterCoordinator$ui_release();
        NodeCoordinator innerCoordinator$ui_release = getInnerCoordinator$ui_release();
        while (outerCoordinator$ui_release != innerCoordinator$ui_release) {
            Intrinsics.checkNotNull(outerCoordinator$ui_release, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
            LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = (LayoutModifierNodeCoordinator) outerCoordinator$ui_release;
            OwnedLayer layer = layoutModifierNodeCoordinator.getLayer();
            if (layer != null) {
                layer.invalidate();
            }
            outerCoordinator$ui_release = layoutModifierNodeCoordinator.getWrapped$ui_release();
        }
        OwnedLayer layer2 = getInnerCoordinator$ui_release().getLayer();
        if (layer2 != null) {
            layer2.invalidate();
        }
    }

    private final boolean shouldInvalidateParentLayer() {
        if (!this.nodes.m4043hasH91voCI$ui_release(NodeKind.m4080constructorimpl(4)) || this.nodes.m4043hasH91voCI$ui_release(NodeKind.m4080constructorimpl(2))) {
            for (Modifier.Node head$ui_release = this.nodes.getHead$ui_release(); head$ui_release != null; head$ui_release = head$ui_release.getChild$ui_release()) {
                if ((NodeKind.m4080constructorimpl(2) & head$ui_release.getKindSet$ui_release()) != 0 && DelegatableNodeKt.m3978requireCoordinator64DMado(head$ui_release, NodeKind.m4080constructorimpl(2)).getLayer() != null) {
                    return false;
                }
                if ((NodeKind.m4080constructorimpl(4) & head$ui_release.getKindSet$ui_release()) != 0) {
                    return true;
                }
            }
            return true;
        }
        return true;
    }

    public final void resetSubtreeIntrinsicsUsage$ui_release() {
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector.getContent();
            int i = 0;
            do {
                LayoutNode layoutNode = content[i];
                UsageByParent usageByParent = layoutNode.previousIntrinsicsUsageByParent;
                layoutNode.intrinsicsUsageByParent = usageByParent;
                if (usageByParent != UsageByParent.NotUsed) {
                    layoutNode.resetSubtreeIntrinsicsUsage$ui_release();
                }
                i++;
            } while (i < size);
        }
    }
}