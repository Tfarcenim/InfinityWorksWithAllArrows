package tfar.infinityworkswithallarrows.mixin;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ArrowItem.class)
public class MixinArrowItem {
	@Inject(method = "isInfinite",at = @At("RETURN"), remap = false,cancellable = true)
	private void makeInfinite(ItemStack stack, ItemStack bow, PlayerEntity player, CallbackInfoReturnable<Boolean> cir){
		if (cir.getReturnValue())return;
		if (EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, bow) > 0)cir.setReturnValue(true);
	}
}
