package com.hellfire.net.vec.doubles;

import com.hellfire.net.vec.IVec;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

/* Created by Conor on 15.05.2024 */
public class Vec2d extends IVec<Double, Vec2d> {

    private static final int NUM_COMPONENTS = 2;
    public static final Vec2d ZERO = new Vec2d(0, 0);

    public final double x, y;

    public Vec2d(final double @NotNull ... comps) {
        if (comps.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        this.x = comps[0];
        this.y = comps[1];
    }

    public Vec2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vec2d() {
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
    public @NotNull Vec2d set(@Range(from = 0, to = 1) int component, @NotNull Double val) {
        return switch (component) {
            case 0 -> new Vec2d(val, y);
            case 1 -> new Vec2d(x, val);
            default -> throw new IllegalArgumentException("Invalid component");
        };
    }

    @Override
    public @NotNull Vec2d set(@NotNull Double @NotNull ... valArr) {
        if (valArr.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        return new Vec2d(valArr[0], valArr[1]);
    }

    @Override
    public @NotNull Double get(@Range(from = 0, to = 1) int component) {
        return switch (component) {
          case 0 -> x;
          case 1 -> y;
          default -> throw new IllegalArgumentException("Invalid component");
        };
    }

    @Override
    public @NotNull Double[] getComponents() {
        return new @NotNull Double[] {x, y};
    }

    @Override
    public @NotNull Vec2d add(@NotNull Vec2d vec) {
        return new Vec2d(x + vec.x, y + vec.y);
    }

    @Override
    public @NotNull Vec2d add(@NotNull Double @NotNull ... vecArr) {
        if (vecArr.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        return new Vec2d(x + vecArr[0], y + vecArr[1]);
    }

    @Override
    public @NotNull Vec2d addScalar(@NotNull Double val) {
        return new Vec2d(x + val, y + val);
    }

    @Override
    public @NotNull Vec2d sub(@NotNull Vec2d vec) {
        return new Vec2d(x - vec.x, y - vec.y);
    }

    @Override
    public @NotNull Vec2d sub(@NotNull Double @NotNull ... vecArr) {
        if (vecArr.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        return new Vec2d(x - vecArr[0], y - vecArr[1]);
    }

    @Override
    public @NotNull Vec2d mul(@NotNull Vec2d vec) {
        return new Vec2d(x * vec.x, y * vec.y);
    }

    @Override
    public @NotNull Vec2d mul(@NotNull Double @NotNull ... vecArr) {
        if (vecArr.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        return new Vec2d(x * vecArr[0], y * vecArr[1]);
    }

    @Override
    public @NotNull Vec2d mulScalar(@NotNull Double scale) {
        return new Vec2d(x * scale, y * scale);
    }

    @Override
    public @NotNull Vec2d div(@NotNull Double scale) {
        return new Vec2d(x / scale, y / scale);
    }

    @Override
    public @NotNull Vec2d div(double scale) {
        return new Vec2d((double) (x / scale), (double) (y / scale));
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
    public double distance(@NotNull Vec2d vec) {
        double dx = Math.abs(vec.x - x), dy = Math.abs(vec.y - y);
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public double distanceSquared(@NotNull Vec2d vec) {
        double dx = Math.abs(vec.x - x), dy = Math.abs(vec.y - y);
        return (dx * dx) + (dy * dy);
    }

    @Override
    public @NotNull Vec2d negate() {
        return new Vec2d(-x, -y);
    }

    @Override
    public @NotNull Vec2d min(@NotNull Vec2d vec) {
        double mx = Math.min(vec.x, x), my = Math.min(vec.y, y);
        return new Vec2d(mx, my);
    }

    @Override
    public @NotNull Vec2d max(@NotNull Vec2d vec) {
        double mx = Math.max(vec.x, x), my = Math.max(vec.y, y);
        return new Vec2d(mx, my);
    }

    @Override
    public @NotNull Vec2d minLength(@NotNull Vec2d vec) {
        return (length() < vec.length()) ? this : vec;
    }

    @Override
    public @NotNull Vec2d maxLength(@NotNull Vec2d vec) {
        return (length() > vec.length()) ? this : vec;
    }

    @Override
    public @NotNull Double minComponent() {
        return Math.min(x, y);
    }

    @Override
    public @NotNull Double maxComponent() {
        return Math.max(x, y);
    }

    @Override
    public @NotNull Vec2d abs() {
        return new Vec2d(Math.abs(x), Math.abs(y));
    }

    @Override
    public @NotNull Vec2d zero() {
        return ZERO;
    }

    @Override
    public @NotNull Vec2d clone() {
        return new Vec2d(x, y);
    }
}
