package dev.tpsz.mixin;

import dev.tpsz.Cfg;
import net.minecraft.client.renderer.ScreenEffectRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(ScreenEffectRenderer.class)
public abstract class TpMxn {
	@ModifyArgs(method = "renderItemActivationAnimation", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/vertex/PoseStack;scale(FFF)V"))
	private void sz(Args a) {
		if (!Cfg.c.on) return;
		float k = Cfg.c.sz / 100f;
		a.set(0, (float) a.get(0) * k);
		a.set(1, (float) a.get(1) * k);
		a.set(2, (float) a.get(2) * k);
	}
}
