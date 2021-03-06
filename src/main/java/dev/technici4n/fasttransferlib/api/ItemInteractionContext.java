package dev.technici4n.fasttransferlib.api;

import net.minecraft.item.ItemStack;

/**
 * A context for interaction with item-provided item and fluid apis, that allows modifying the stack and passing a new stack.
 * <p>In many cases such as bucket filling/emptying, it is necessary to change the current stack, and also to send extra stacks.
 * For example, filling a stack of 3 empty buckets with water may require changing the stack to 2 empty buckets of water,
 * and storing an additional full bucket of water.
 */
public interface ItemInteractionContext {
    /**
     * Set the new stack if possible and return whether the modification was successful.
     * @param stack The new stack
     * @param simulation If {@link Simulation#SIMULATE}, do not mutate anything
     * @return whether the modification was successful
     */
    boolean setStack(ItemStack stack, Simulation simulation);

    /**
     * Add extra stacks if possible and return whether the modification was successful.
     * @param stacks The extra stacks
     * @param simulation If {@link Simulation#SIMULATE}, do not mutate anything
     * @return whether the modification was successful
     * @apiNote If a simulation succeeds twice, it is not guaranteed that the action will succeed twice, so it is recommended to only call this function once.
     */
    boolean addExtraStacks(ItemStack stacks, Simulation simulation);
}
