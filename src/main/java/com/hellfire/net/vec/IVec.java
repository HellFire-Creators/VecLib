package com.hellfire.net.vec;

import org.jetbrains.annotations.NotNull;

/* Created by Conor on 15.05.2024 */
public abstract class IVec<N extends Number & Comparable<N>, T extends IVec<N, ?>> {

    // Is it smart to have it a universal val? idk
    private static final int HASH_PRIME = 31;
    private static final char[] FIELD_NAMES = {'x', 'y', 'z', 'w'};

    public abstract int numComponents();

    @NotNull
    public abstract T set(final int component, final @NotNull N val);

    @NotNull
    public abstract T set(final @NotNull N @NotNull [] valArr);

    @NotNull
    public abstract N get(final int component);

    @NotNull
    public abstract N[] getComponents();

    @NotNull
    public abstract T add(final @NotNull T vec);

    @NotNull
    public abstract T add(final @NotNull N @NotNull ... vecArr);

    @NotNull
    public abstract T sub(final @NotNull T vec);

    @NotNull
    public abstract T sub(final @NotNull N @NotNull ... vecArr);

    @NotNull
    public abstract T mul(final @NotNull T vec);

    @NotNull
    public abstract T mul(final @NotNull N @NotNull ... vecArr);

    @NotNull
    public abstract T mul(final @NotNull N scale);

    @NotNull
    public abstract T div(final @NotNull N scale);

    @NotNull
    public abstract T div(final double scale);

    public abstract double length();

    public abstract double lengthSquared();

    public abstract double distance(final @NotNull T vec);

    public abstract double distanceSquared(final @NotNull T vec);

    @NotNull
    public abstract T negate();

    @NotNull
    public abstract T min(final @NotNull T vec);

    @NotNull
    public abstract T max(final @NotNull T vec);

    @NotNull
    public abstract T minLength(final @NotNull T vec);

    @NotNull
    public abstract T maxLength(final @NotNull T vec);

    @NotNull
    public abstract N minComponent();

    @NotNull
    public abstract N maxComponent();

    @NotNull
    public abstract T abs();

    @NotNull
    public T normalize() {
        return div(length());
    }

    @NotNull
    public abstract T zero();

    @Override
    public String toString() {
        final String className = this.getClass().getSimpleName();
        final N[] components = getComponents();
        final StringBuilder sb = new StringBuilder();

        sb.append(className).append("{");
        for (int i = 0; i < numComponents(); i++) {
            sb.append(FIELD_NAMES[i]).append("=").append(components[i]);
            if (i < numComponents() - 1) sb.append(", ");
        }

        return sb.append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (!(o instanceof IVec<?,?> v)) return false;
        if (numComponents() != v.numComponents()) return false;

        final N[] comps = getComponents();
        final Number[] vComps = v.getComponents();
        for (int i = 0; i < numComponents(); i++) if (!vComps[i].equals(comps[i])) return false;

        return true;
    }

    @Override
    // Based on: https://stackoverflow.com/questions/5730149/how-to-generate-a-hash-code-from-three-longs
    public int hashCode() {
        final N[] comps = getComponents();

        int result = comps[0].hashCode();
        for (int i = 1; i < numComponents(); i++) result = HASH_PRIME * result + comps[i].hashCode();
        return result;
    }

    @NotNull
    public abstract T clone();


}
