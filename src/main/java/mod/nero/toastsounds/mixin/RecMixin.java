package mod.nero.toastsounds.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.components.toasts.RecipeToast;
import net.minecraft.client.gui.components.toasts.Toast;
import net.minecraft.client.gui.components.toasts.ToastComponent;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import mod.nero.toastsounds.ModSounds;

@Mixin(RecipeToast.class)
public class RecMixin {
    @Shadow
    private boolean changed;
    @Inject(method = "render", at = @At(value = "HEAD"))
    private void crafttoast(PoseStack p_94814_, ToastComponent p_94815_, long p_94816_, CallbackInfoReturnable<Toast.Visibility> cir) {
        if (this.changed) {
            p_94815_.getMinecraft().getSoundManager().play(SimpleSoundInstance.forUI(ModSounds.RECIPE_NOTIFY.get(), 1.0F, 1.0F));
        }

    }


}
