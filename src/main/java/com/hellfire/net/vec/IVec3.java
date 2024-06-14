package com.hellfire.net.vec;

import net.minestom.server.coordinate.Vec;
import org.jetbrains.annotations.NotNull;

public abstract class IVec3<N extends Number & Comparable<N>, T extends IVec<N, ?>> extends IVec<N, T> {

    @NotNull
    public abstract T cross(@NotNull T other);

    public Vec asVec() {
        return new Vec(get(0).doubleValue(), get(1).doubleValue(), get(2).doubleValue());
    }
}
