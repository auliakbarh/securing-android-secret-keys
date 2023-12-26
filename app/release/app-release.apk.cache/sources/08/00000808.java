package androidx.compose.foundation.text;

import androidx.compose.foundation.text.modifiers.SelectableTextAnnotatedStringElement;
import androidx.compose.foundation.text.modifiers.SelectionController;
import androidx.compose.foundation.text.modifiers.TextAnnotatedStringElement;
import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.foundation.text.selection.SelectionRegistrarKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BasicText.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0087\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0093\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001b\u001a}\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001d\u001ag\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001f\u001aq\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010 \u001a}\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010!\u001a\u001e\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$0#2\b\u0010%\u001a\u0004\u0018\u00010&H\u0002\u001a¯\u0001\u0010'\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010(\u001a\u00020)2\u0014\u0010*\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0,\u0018\u00010+2\u001c\u0010.\u001a\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010/0+\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\u00100\u001a\u0004\u0018\u0001012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u00103\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00064"}, d2 = {"BasicText", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "modifier", "Landroidx/compose/ui/Modifier;", "style", "Landroidx/compose/ui/text/TextStyle;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "inlineContent", "", "", "Landroidx/compose/foundation/text/InlineTextContent;", "BasicText-VhcvRP8", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILjava/util/Map;Landroidx/compose/runtime/Composer;II)V", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "BasicText-RWo7tUw", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILjava/util/Map;Landroidx/compose/ui/graphics/ColorProducer;Landroidx/compose/runtime/Composer;II)V", "BasicText-4YKlhWE", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZILjava/util/Map;Landroidx/compose/runtime/Composer;II)V", "BasicText-BpD7jsM", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZILandroidx/compose/runtime/Composer;II)V", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILandroidx/compose/runtime/Composer;II)V", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILandroidx/compose/ui/graphics/ColorProducer;Landroidx/compose/runtime/Composer;II)V", "selectionIdSaver", "Landroidx/compose/runtime/saveable/Saver;", "", "selectionRegistrar", "Landroidx/compose/foundation/text/selection/SelectionRegistrar;", "textModifier", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "onPlaceholderLayout", "Landroidx/compose/ui/geometry/Rect;", "selectionController", "Landroidx/compose/foundation/text/modifiers/SelectionController;", "textModifier-RWo7tUw", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILandroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/modifiers/SelectionController;Landroidx/compose/ui/graphics/ColorProducer;)Landroidx/compose/ui/Modifier;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BasicTextKt {
    /* JADX WARN: Removed duplicated region for block: B:189:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x020d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:306:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x0352  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:325:? A[RETURN, SYNTHETIC] */
    /* renamed from: BasicText-VhcvRP8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m741BasicTextVhcvRP8(final java.lang.String r47, androidx.compose.ui.Modifier r48, androidx.compose.ui.text.TextStyle r49, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r50, int r51, boolean r52, int r53, int r54, androidx.compose.ui.graphics.ColorProducer r55, androidx.compose.runtime.Composer r56, final int r57, final int r58) {
        /*
            Method dump skipped, instructions count: 981
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextKt.m741BasicTextVhcvRP8(java.lang.String, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function1, int, boolean, int, int, androidx.compose.ui.graphics.ColorProducer, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:337:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:378:0x050b  */
    /* JADX WARN: Removed duplicated region for block: B:383:0x0527  */
    /* JADX WARN: Removed duplicated region for block: B:385:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* renamed from: BasicText-RWo7tUw */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m739BasicTextRWo7tUw(final androidx.compose.ui.text.AnnotatedString r50, androidx.compose.ui.Modifier r51, androidx.compose.ui.text.TextStyle r52, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r53, int r54, boolean r55, int r56, int r57, java.util.Map<java.lang.String, androidx.compose.foundation.text.InlineTextContent> r58, androidx.compose.ui.graphics.ColorProducer r59, androidx.compose.runtime.Composer r60, final int r61, final int r62) {
        /*
            Method dump skipped, instructions count: 1337
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextKt.m739BasicTextRWo7tUw(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function1, int, boolean, int, int, java.util.Map, androidx.compose.ui.graphics.ColorProducer, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:139:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:225:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: BasicText-BpD7jsM */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void m738BasicTextBpD7jsM(final java.lang.String r23, androidx.compose.ui.Modifier r24, androidx.compose.ui.text.TextStyle r25, kotlin.jvm.functions.Function1 r26, int r27, boolean r28, int r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instructions count: 422
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextKt.m738BasicTextBpD7jsM(java.lang.String, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function1, int, boolean, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:148:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:243:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: BasicText-4YKlhWE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void m736BasicText4YKlhWE(final androidx.compose.ui.text.AnnotatedString r26, androidx.compose.ui.Modifier r27, androidx.compose.ui.text.TextStyle r28, kotlin.jvm.functions.Function1 r29, int r30, boolean r31, int r32, java.util.Map r33, androidx.compose.runtime.Composer r34, final int r35, final int r36) {
        /*
            Method dump skipped, instructions count: 465
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextKt.m736BasicText4YKlhWE(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function1, int, boolean, int, java.util.Map, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:154:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:255:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compat")
    /* renamed from: BasicText-4YKlhWE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void m737BasicText4YKlhWE(final java.lang.String r27, androidx.compose.ui.Modifier r28, androidx.compose.ui.text.TextStyle r29, kotlin.jvm.functions.Function1 r30, int r31, boolean r32, int r33, int r34, androidx.compose.runtime.Composer r35, final int r36, final int r37) {
        /*
            Method dump skipped, instructions count: 475
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextKt.m737BasicText4YKlhWE(java.lang.String, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function1, int, boolean, int, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:162:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:271:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compat")
    /* renamed from: BasicText-VhcvRP8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void m740BasicTextVhcvRP8(final androidx.compose.ui.text.AnnotatedString r28, androidx.compose.ui.Modifier r29, androidx.compose.ui.text.TextStyle r30, kotlin.jvm.functions.Function1 r31, int r32, boolean r33, int r34, int r35, java.util.Map r36, androidx.compose.runtime.Composer r37, final int r38, final int r39) {
        /*
            Method dump skipped, instructions count: 516
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextKt.m740BasicTextVhcvRP8(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function1, int, boolean, int, int, java.util.Map, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final Saver<Long, Long> selectionIdSaver(final SelectionRegistrar selectionRegistrar) {
        return SaverKt.Saver(new Function2<SaverScope, Long, Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$selectionIdSaver$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Long invoke(SaverScope saverScope, Long l) {
                return invoke(saverScope, l.longValue());
            }

            public final Long invoke(SaverScope Saver, long j) {
                Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
                if (SelectionRegistrarKt.hasSelection(SelectionRegistrar.this, j)) {
                    return Long.valueOf(j);
                }
                return null;
            }
        }, new Function1<Long, Long>() { // from class: androidx.compose.foundation.text.BasicTextKt$selectionIdSaver$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Long invoke(Long l) {
                return invoke(l.longValue());
            }

            public final Long invoke(long j) {
                return Long.valueOf(j);
            }
        });
    }

    /* renamed from: textModifier-RWo7tUw */
    private static final Modifier m742textModifierRWo7tUw(Modifier modifier, AnnotatedString annotatedString, TextStyle textStyle, Function1<? super TextLayoutResult, Unit> function1, int i, boolean z, int i2, int i3, FontFamily.Resolver resolver, List<AnnotatedString.Range<Placeholder>> list, Function1<? super List<Rect>, Unit> function12, SelectionController selectionController, ColorProducer colorProducer) {
        if (selectionController == null) {
            return modifier.then(Modifier.Companion).then(new TextAnnotatedStringElement(annotatedString, textStyle, resolver, function1, i, z, i2, i3, list, function12, null, colorProducer, null));
        }
        return modifier.then(selectionController.getModifier()).then(new SelectableTextAnnotatedStringElement(annotatedString, textStyle, resolver, function1, i, z, i2, i3, list, function12, selectionController, colorProducer, null));
    }
}