package com.hellfire.net.vec;

import org.jetbrains.annotations.NotNull;

/* Created by Conor on 01.07.2024 */
public abstract class IVec4<N extends Number & Comparable<N>, T extends IVec<N, ?>> extends IVec<N, T> {


    public static final int NUM_COMPONENTS = 4;

    public T setX(final @NotNull N newX) {
        return set(0, newX);
    }

    public T setY(final @NotNull N newY) {
        return set(1, newY);
    }

    public T setZ(final @NotNull N newZ) {
        return set(2, newZ);
    }

    public T setW(final @NotNull N newW) {
        return set(3, newW);
    }

    @Override
    public int numComponents() {
        return NUM_COMPONENTS;
    }

    public N getX() {
        return get(0);
    }

    public N getY() {
        return get(1);
    }

    public N getZ() {
        return get(2);
    }

    public N getW() {
        return get(3);
    }

}
