package com.hellfire.net.vec.ints;

import com.hellfire.net.vec.IVec;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

/* Created by Conor on 15.05.2024 */
public class Vec2i extends IVec<Integer, Vec2i> {


    private static final int NUM_COMPONENTS = 2;
    public static final Vec2i ZERO = new Vec2i(0, 0);

    public final int x, y;

    public Vec2i(final int @NotNull ... comps) {
        if (comps.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        this.x = comps[0];
        this.y = comps[1];
    }

    public Vec2i(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vec2i() {
        this(0, 0);
    }

    ///////////////////////////////////////////////////////////////////////////
    // Impl methods
    ///////////////////////////////////////////////////////////////////////////

    @Override
    public int numComponents() {
        return NUM_COMPONENTS;
    }

    @Override
    public @NotNull Vec2i set(@Range(from = 0, to = 1) int component, @NotNull Integer val) {
        return switch (component) {
            case 0 -> new Vec2i(val, y);
            case 1 -> new Vec2i(x, val);
            default -> throw new IllegalArgumentException("Invalid component");
        };
    }

    @Override
    public @NotNull Vec2i set(@NotNull Integer @NotNull ... valArr) {
        if (valArr.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        return new Vec2i(valArr[0], valArr[1]);
    }

    @Override
    public @NotNull Integer get(@Range(from = 0, to = 1) int component) {
        return switch (component) {
          case 0 -> x;
          case 1 -> y;
          default -> throw new IllegalArgumentException("Invalid component");
        };
    }

    @Override
    public Integer[] getComponents() {
        return new Integer[] {x, y};
    }

    @Override
    public @NotNull Vec2i add(@NotNull Vec2i vec) {
        return new Vec2i(x + vec.x, y + vec.y);
    }

    @Override
    public @NotNull Vec2i add(@NotNull Integer @NotNull ... vecArr) {
        if (vecArr.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        return new Vec2i(x + vecArr[0], y + vecArr[1]);
    }

    @Override
    public @NotNull Vec2i addScalar(@NotNull Integer val) {
        return new Vec2i(x + val, y + val);
    }

    @Override
    public @NotNull Vec2i sub(@NotNull Vec2i vec) {
        return new Vec2i(x - vec.x, y - vec.y);
    }

    @Override
    public @NotNull Vec2i sub(@NotNull Integer @NotNull ... vecArr) {
        if (vecArr.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        return new Vec2i(x - vecArr[0], y - vecArr[1]);
    }

    @Override
    public @NotNull Vec2i mul(@NotNull Vec2i vec) {
        return new Vec2i(x * vec.x, y * vec.y);
    }

    @Override
    public @NotNull Vec2i mul(@NotNull Integer @NotNull ... vecArr) {
        if (vecArr.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        return new Vec2i(x * vecArr[0], y * vecArr[1]);
    }

    @Override
    public @NotNull Vec2i mul(@NotNull Integer scale) {
        return new Vec2i(x * scale, y * scale);
    }

    @Override
    public @NotNull Vec2i div(@NotNull Integer scale) {
        return new Vec2i(x / scale, y / scale);
    }

    @Override
    public @NotNull Vec2i div(double scale) {
        return new Vec2i((int) (x / scale), (int) (y / scale));
    }

    @Override
    public double length() {
        return Math.sqrt(x * x + y * y);
    }

    @Override
    public double lengthSquared() {
        return (x * x) + (y * y);
    }

    @Override
    public double distance(@NotNull Vec2i vec) {
        int dx = Math.abs(vec.x - x), dy = Math.abs(vec.y - y);
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public double distanceSquared(@NotNull Vec2i vec) {
        int dx = Math.abs(vec.x - x), dy = Math.abs(vec.y - y);
        return (dx * dx) + (dy * dy);
    }

    @Override
    public @NotNull Vec2i negate() {
        return new Vec2i(-x, -y);
    }

    @Override
    public @NotNull Vec2i min(@NotNull Vec2i vec) {
        int mx = Math.min(vec.x, x), my = Math.min(vec.y, y);
        return new Vec2i(mx, my);
    }

    @Override
    public @NotNull Vec2i max(@NotNull Vec2i vec) {
        int mx = Math.max(vec.x, x), my = Math.max(vec.y, y);
        return new Vec2i(mx, my);
    }

    @Override
    public @NotNull Vec2i minLength(@NotNull Vec2i vec) {
        return (length() < vec.length()) ? this : vec;
    }

    @Override
    public @NotNull Vec2i maxLength(@NotNull Vec2i vec) {
        return (length() > vec.length()) ? this : vec;
    }

    @Override
    public @NotNull Integer minComponent() {
        return Math.min(x, y);
    }

    @Override
    public @NotNull Integer maxComponent() {
        return Math.max(x, y);
    }

    @Override
    public @NotNull Vec2i abs() {
        return new Vec2i(Math.abs(x), Math.abs(y));
    }

    @Override
    public @NotNull Vec2i zero() {
        return ZERO;
    }

    @Override
    public @NotNull Vec2i clone() {
        return new Vec2i(x, y);
    }
}
