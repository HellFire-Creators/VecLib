package com.hellfire.net.vec;

import org.jetbrains.annotations.NotNull;

/* Created by Conor on 15.05.2024 */
public interface IVec<N extends Number & Comparable<N>, T extends IVec<N, ?>> {

    int numComponents();

    @NotNull
    T set(final int component, final @NotNull N val);

    @NotNull
    T set(final @NotNull N @NotNull [] valArr);

    @NotNull
    N get(final int component);

    @NotNull
    N[] getComponents();

    @NotNull
    T add(final @NotNull T vec);

    @NotNull
    T add(final @NotNull N @NotNull ... vecArr);

    @NotNull
    T sub(final @NotNull T vec);

    @NotNull
    T sub(final @NotNull N @NotNull ... vecArr);

    @NotNull
    T mul(final @NotNull T vec);

    @NotNull
    T mul(final @NotNull N @NotNull ... vecArr);

    @NotNull
    T mul(final @NotNull N scale);

    @NotNull
    T div(final @NotNull N scale);

    @NotNull
    T div(final double scale);

    double length();

    double lengthSquared();

    double distance(final @NotNull T vec);

    double distanceSquared(final @NotNull T vec);

    @NotNull
    T negate();

    @NotNull
    T min(final @NotNull T vec);

    @NotNull
    T max(final @NotNull T vec);

    @NotNull
    T minLength(final @NotNull T vec);

    @NotNull
    T maxLength(final @NotNull T vec);

    @NotNull
    N minComponent();

    @NotNull
    N maxComponent();

    @NotNull
    T abs();

    @NotNull
    T zero();

    @Override
    String toString();

    @Override
    boolean equals(Object o);

    @NotNull
    T clone();
}
