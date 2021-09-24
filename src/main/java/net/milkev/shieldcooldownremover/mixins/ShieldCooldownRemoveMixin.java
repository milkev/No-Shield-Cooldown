package net.milkev.shieldcooldownremover.mixins;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(PlayerEntity.class)
public abstract class ShieldCooldownRemoveMixin extends LivingEntity {

    public ShieldCooldownRemoveMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    public boolean isBlocking() {
        if (this.isUsingItem() && !this.activeItemStack.isEmpty()) {
            Item item = this.activeItemStack.getItem();
            if (item.getUseAction(this.activeItemStack) != UseAction.BLOCK) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }

    }
/*
    protected int computeFallDamage(float fallDistance, float damageMultiplier) {
        StatusEffectInstance statusEffectInstance = this.getStatusEffect(StatusEffects.JUMP_BOOST);
        float f = statusEffectInstance == null ? 0.0F : (float)(statusEffectInstance.getAmplifier() + 1);
        Item item = this.activeItemStack.getItem();
        return (item.getUseAction(this.activeItemStack) == UseAction.BLOCK) ? 0 : MathHelper.ceil((fallDistance - 3.0F - f) * damageMultiplier);
    }
*/
}
