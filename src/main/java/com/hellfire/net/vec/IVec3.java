package com.hellfire.net.vec;

import org.jetbrains.annotations.NotNull;

public abstract class IVec3<N extends Number & Comparable<N>, T extends IVec<N, ?>> extends IVec<N, T> {

    @NotNull
    public abstract T cross(@NotNull T other);

}
