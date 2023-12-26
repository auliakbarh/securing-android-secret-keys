package androidx.compose.ui.text.input;

import android.view.Choreographer;
import android.view.inputmethod.EditorInfo;
import androidx.compose.ui.text.TextRange;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.emoji2.text.EmojiCompat;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextInputServiceAndroid.android.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\tH\u0000\u001a\u001c\u0010\n\u001a\u00020\u000b*\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001a\f\u0010\u0011\u001a\u00020\u000b*\u00020\fH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"DEBUG_CLASS", "", "hasFlag", "", "bits", "", "flag", "asExecutor", "Ljava/util/concurrent/Executor;", "Landroid/view/Choreographer;", "update", "", "Landroid/view/inputmethod/EditorInfo;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "textFieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "updateWithEmojiCompat", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextInputServiceAndroid_androidKt {
    private static final String DEBUG_CLASS = "TextInputServiceAndroid";

    public static /* synthetic */ void $r8$lambda$RYljF3nl5HRu6JKEM8xFRHwbGFg(Runnable runnable, long j) {
        runnable.run();
    }

    public static /* synthetic */ void $r8$lambda$zzP0QYZAK9fPNHI8CrYdtRFmmqA(Choreographer choreographer, Runnable runnable) {
        asExecutor$lambda$1(choreographer, runnable);
    }

    private static final boolean hasFlag(int i, int i2) {
        return (i & i2) == i2;
    }

    public static final void updateWithEmojiCompat(EditorInfo editorInfo) {
        if (EmojiCompat.isConfigured()) {
            EmojiCompat.get().updateEditorInfo(editorInfo);
        }
    }

    public static final void update(EditorInfo editorInfo, ImeOptions imeOptions, TextFieldValue textFieldValue) {
        Intrinsics.checkNotNullParameter(editorInfo, "<this>");
        Intrinsics.checkNotNullParameter(imeOptions, "imeOptions");
        Intrinsics.checkNotNullParameter(textFieldValue, "textFieldValue");
        int m4573getImeActioneUduSuo = imeOptions.m4573getImeActioneUduSuo();
        int i = 6;
        if (ImeAction.m4550equalsimpl0(m4573getImeActioneUduSuo, ImeAction.Companion.m4562getDefaulteUduSuo())) {
            if (!imeOptions.getSingleLine()) {
                i = 0;
            }
        } else if (ImeAction.m4550equalsimpl0(m4573getImeActioneUduSuo, ImeAction.Companion.m4566getNoneeUduSuo())) {
            i = 1;
        } else if (ImeAction.m4550equalsimpl0(m4573getImeActioneUduSuo, ImeAction.Companion.m4564getGoeUduSuo())) {
            i = 2;
        } else if (ImeAction.m4550equalsimpl0(m4573getImeActioneUduSuo, ImeAction.Companion.m4565getNexteUduSuo())) {
            i = 5;
        } else if (ImeAction.m4550equalsimpl0(m4573getImeActioneUduSuo, ImeAction.Companion.m4567getPreviouseUduSuo())) {
            i = 7;
        } else if (ImeAction.m4550equalsimpl0(m4573getImeActioneUduSuo, ImeAction.Companion.m4568getSearcheUduSuo())) {
            i = 3;
        } else if (ImeAction.m4550equalsimpl0(m4573getImeActioneUduSuo, ImeAction.Companion.m4569getSendeUduSuo())) {
            i = 4;
        } else if (!ImeAction.m4550equalsimpl0(m4573getImeActioneUduSuo, ImeAction.Companion.m4563getDoneeUduSuo())) {
            throw new IllegalStateException("invalid ImeAction".toString());
        }
        editorInfo.imeOptions = i;
        int m4574getKeyboardTypePjHm6EE = imeOptions.m4574getKeyboardTypePjHm6EE();
        if (KeyboardType.m4595equalsimpl0(m4574getKeyboardTypePjHm6EE, KeyboardType.Companion.m4615getTextPjHm6EE())) {
            editorInfo.inputType = 1;
        } else if (KeyboardType.m4595equalsimpl0(m4574getKeyboardTypePjHm6EE, KeyboardType.Companion.m4608getAsciiPjHm6EE())) {
            editorInfo.inputType = 1;
            editorInfo.imeOptions |= Integer.MIN_VALUE;
        } else if (KeyboardType.m4595equalsimpl0(m4574getKeyboardTypePjHm6EE, KeyboardType.Companion.m4611getNumberPjHm6EE())) {
            editorInfo.inputType = 2;
        } else if (KeyboardType.m4595equalsimpl0(m4574getKeyboardTypePjHm6EE, KeyboardType.Companion.m4614getPhonePjHm6EE())) {
            editorInfo.inputType = 3;
        } else if (KeyboardType.m4595equalsimpl0(m4574getKeyboardTypePjHm6EE, KeyboardType.Companion.m4616getUriPjHm6EE())) {
            editorInfo.inputType = 17;
        } else if (KeyboardType.m4595equalsimpl0(m4574getKeyboardTypePjHm6EE, KeyboardType.Companion.m4610getEmailPjHm6EE())) {
            editorInfo.inputType = 33;
        } else if (KeyboardType.m4595equalsimpl0(m4574getKeyboardTypePjHm6EE, KeyboardType.Companion.m4613getPasswordPjHm6EE())) {
            editorInfo.inputType = 129;
        } else if (KeyboardType.m4595equalsimpl0(m4574getKeyboardTypePjHm6EE, KeyboardType.Companion.m4612getNumberPasswordPjHm6EE())) {
            editorInfo.inputType = 18;
        } else if (KeyboardType.m4595equalsimpl0(m4574getKeyboardTypePjHm6EE, KeyboardType.Companion.m4609getDecimalPjHm6EE())) {
            editorInfo.inputType = InputDeviceCompat.SOURCE_MOUSE;
        } else {
            throw new IllegalStateException("Invalid Keyboard Type".toString());
        }
        if (!imeOptions.getSingleLine() && hasFlag(editorInfo.inputType, 1)) {
            editorInfo.inputType |= 131072;
            if (ImeAction.m4550equalsimpl0(imeOptions.m4573getImeActioneUduSuo(), ImeAction.Companion.m4562getDefaulteUduSuo())) {
                editorInfo.imeOptions |= 1073741824;
            }
        }
        if (hasFlag(editorInfo.inputType, 1)) {
            int m4572getCapitalizationIUNYP9k = imeOptions.m4572getCapitalizationIUNYP9k();
            if (KeyboardCapitalization.m4580equalsimpl0(m4572getCapitalizationIUNYP9k, KeyboardCapitalization.Companion.m4588getCharactersIUNYP9k())) {
                editorInfo.inputType |= 4096;
            } else if (KeyboardCapitalization.m4580equalsimpl0(m4572getCapitalizationIUNYP9k, KeyboardCapitalization.Companion.m4591getWordsIUNYP9k())) {
                editorInfo.inputType |= 8192;
            } else if (KeyboardCapitalization.m4580equalsimpl0(m4572getCapitalizationIUNYP9k, KeyboardCapitalization.Companion.m4590getSentencesIUNYP9k())) {
                editorInfo.inputType |= 16384;
            }
            if (imeOptions.getAutoCorrect()) {
                editorInfo.inputType |= 32768;
            }
        }
        editorInfo.initialSelStart = TextRange.m4403getStartimpl(textFieldValue.m4622getSelectiond9O1mEE());
        editorInfo.initialSelEnd = TextRange.m4398getEndimpl(textFieldValue.m4622getSelectiond9O1mEE());
        EditorInfoCompat.setInitialSurroundingText(editorInfo, textFieldValue.getText());
        editorInfo.imeOptions |= 33554432;
    }

    public static final Executor asExecutor(final Choreographer choreographer) {
        Intrinsics.checkNotNullParameter(choreographer, "<this>");
        return new Executor() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid_androidKt$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                TextInputServiceAndroid_androidKt.$r8$lambda$zzP0QYZAK9fPNHI8CrYdtRFmmqA(choreographer, runnable);
            }
        };
    }

    public static final void asExecutor$lambda$1(Choreographer this_asExecutor, final Runnable runnable) {
        Intrinsics.checkNotNullParameter(this_asExecutor, "$this_asExecutor");
        this_asExecutor.postFrameCallback(new Choreographer.FrameCallback() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid_androidKt$$ExternalSyntheticLambda0
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j) {
                TextInputServiceAndroid_androidKt.$r8$lambda$RYljF3nl5HRu6JKEM8xFRHwbGFg(runnable, j);
            }
        });
    }
}