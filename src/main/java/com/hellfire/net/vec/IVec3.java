package com.hellfire.net.vec;

import net.minestom.server.coordinate.Vec;
import org.jetbrains.annotations.NotNull;

public abstract class IVec3<N extends Number & Comparable<N>, T extends IVec<N, ?>> extends IVec<N, T> {

    public static final int NUM_COMPONENTS = 3;

    public T setX(final @NotNull N newX) {
        return set(0, newX);
    }

    public T setY(final @NotNull N newY) {
        return set(1, newY);
    }

    public T setZ(final @NotNull N newZ) {
        return set(2, newZ);
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

    @NotNull
    public abstract T cross(@NotNull T other);

    public Vec asVec() {
        return new Vec(get(0).doubleValue(), get(1).doubleValue(), get(2).doubleValue());
    }
}
