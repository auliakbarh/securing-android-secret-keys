package androidx.compose.foundation.text;

import android.view.InputDevice;
import android.view.KeyEvent;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.key.Key_androidKt;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.core.view.InputDeviceCompat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextFieldFocusModifier.android.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a!\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\r"}, d2 = {"interceptDPadAndMoveFocus", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/text/TextFieldState;", "focusManager", "Landroidx/compose/ui/focus/FocusManager;", "isKeyCode", "", "Landroidx/compose/ui/input/key/KeyEvent;", "keyCode", "", "isKeyCode-YhN2O0w", "(Landroid/view/KeyEvent;I)Z", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldFocusModifier_androidKt {
    /* renamed from: access$isKeyCode-YhN2O0w */
    public static final /* synthetic */ boolean m809access$isKeyCodeYhN2O0w(KeyEvent keyEvent, int i) {
        return m810isKeyCodeYhN2O0w(keyEvent, i);
    }

    public static final Modifier interceptDPadAndMoveFocus(Modifier modifier, final TextFieldState state, final FocusManager focusManager) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(focusManager, "focusManager");
        return KeyInputModifierKt.onPreviewKeyEvent(modifier, new Function1<androidx.compose.ui.input.key.KeyEvent, Boolean>() { // from class: androidx.compose.foundation.text.TextFieldFocusModifier_androidKt$interceptDPadAndMoveFocus$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(androidx.compose.ui.input.key.KeyEvent keyEvent) {
                return m811invokeZmokQxo(keyEvent.m3603unboximpl());
            }

            /* renamed from: invoke-ZmokQxo  reason: not valid java name */
            public final Boolean m811invokeZmokQxo(KeyEvent keyEvent) {
                Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
                InputDevice device = keyEvent.getDevice();
                boolean z = false;
                if (device != null && device.supportsSource(InputDeviceCompat.SOURCE_DPAD) && !device.isVirtual() && KeyEventType.m3607equalsimpl0(KeyEvent_androidKt.m3615getTypeZmokQxo(keyEvent), KeyEventType.Companion.m3611getKeyDownCS__XNY())) {
                    if (TextFieldFocusModifier_androidKt.m809access$isKeyCodeYhN2O0w(keyEvent, 19)) {
                        z = FocusManager.this.mo2326moveFocus3ESFkO8(FocusDirection.Companion.m2325getUpdhqQ8s());
                    } else if (TextFieldFocusModifier_androidKt.m809access$isKeyCodeYhN2O0w(keyEvent, 20)) {
                        z = FocusManager.this.mo2326moveFocus3ESFkO8(FocusDirection.Companion.m2316getDowndhqQ8s());
                    } else if (TextFieldFocusModifier_androidKt.m809access$isKeyCodeYhN2O0w(keyEvent, 21)) {
                        z = FocusManager.this.mo2326moveFocus3ESFkO8(FocusDirection.Companion.m2320getLeftdhqQ8s());
                    } else if (TextFieldFocusModifier_androidKt.m809access$isKeyCodeYhN2O0w(keyEvent, 22)) {
                        z = FocusManager.this.mo2326moveFocus3ESFkO8(FocusDirection.Companion.m2324getRightdhqQ8s());
                    } else if (TextFieldFocusModifier_androidKt.m809access$isKeyCodeYhN2O0w(keyEvent, 23)) {
                        TextInputSession inputSession = state.getInputSession();
                        if (inputSession != null) {
                            inputSession.showSoftwareKeyboard();
                        }
                        z = true;
                    }
                }
                return Boolean.valueOf(z);
            }
        });
    }

    /* renamed from: isKeyCode-YhN2O0w */
    public static final boolean m810isKeyCodeYhN2O0w(KeyEvent keyEvent, int i) {
        return Key_androidKt.m3621getNativeKeyCodeYVgTNJs(KeyEvent_androidKt.m3614getKeyZmokQxo(keyEvent)) == i;
    }
}