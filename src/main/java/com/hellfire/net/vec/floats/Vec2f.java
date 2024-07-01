package com.hellfire.net.vec.floats;

import com.hellfire.net.vec.IVec2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

/* Created by Conor on 15.05.2024 */
public class Vec2f extends IVec2<Float, Vec2f> {

    public static final Vec2f ZERO = new Vec2f(0, 0);

    public final float x, y;

    public Vec2f(final float @NotNull ... comps) {
        if (comps.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        this.x = comps[0];
        this.y = comps[1];
    }

    public Vec2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vec2f() {
        this(0, 0);
    }

    ///////////////////////////////////////////////////////////////////////////
    // Impl methods
    ///////////////////////////////////////////////////////////////////////////

    @Override
    public @NotNull Vec2f set(@Range(from = 0, to = 1) int component, @NotNull Float val) {
        return switch (component) {
            case 0 -> new Vec2f(val, y);
            case 1 -> new Vec2f(x, val);
            default -> throw new IllegalArgumentException("Invalid component");
        };
    }

    @Override
    public @NotNull Vec2f set(@NotNull Float @NotNull ... valArr) {
        if (valArr.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        return new Vec2f(valArr[0], valArr[1]);
    }

    @Override
    public @NotNull Float get(@Range(from = 0, to = 1) int component) {
        return switch (component) {
          case 0 -> x;
          case 1 -> y;
          default -> throw new IllegalArgumentException("Invalid component");
        };
    }

    @Override
    public @NotNull Float[] getComponents() {
        return new @NotNull Float[] {x, y};
    }

    @Override
    public @NotNull Vec2f add(@NotNull Vec2f vec) {
        return new Vec2f(x + vec.x, y + vec.y);
    }

    @Override
    public @NotNull Vec2f add(@NotNull Float @NotNull ... vecArr) {
        if (vecArr.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        return new Vec2f(x + vecArr[0], y + vecArr[1]);
    }

    @Override
    public @NotNull Vec2f addScalar(@NotNull Float val) {
        return new Vec2f(x + val, y + val);
    }

    @Override
    public @NotNull Vec2f sub(@NotNull Vec2f vec) {
        return new Vec2f(x - vec.x, y - vec.y);
    }

    @Override
    public @NotNull Vec2f sub(@NotNull Float @NotNull ... vecArr) {
        if (vecArr.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        return new Vec2f(x - vecArr[0], y - vecArr[1]);
    }

    @Override
    public @NotNull Vec2f mul(@NotNull Vec2f vec) {
        return new Vec2f(x * vec.x, y * vec.y);
    }

    @Override
    public @NotNull Vec2f mul(@NotNull Float @NotNull ... vecArr) {
        if (vecArr.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        return new Vec2f(x * vecArr[0], y * vecArr[1]);
    }

    @Override
    public @NotNull Vec2f mulScalar(@NotNull Float scale) {
        return new Vec2f(x * scale, y * scale);
    }

    @Override
    public @NotNull Vec2f div(@NotNull Float scale) {
        return new Vec2f(x / scale, y / scale);
    }

    @Override
    public @NotNull Vec2f div(double scale) {
        return new Vec2f((float) (x / scale), (float) (y / scale));
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
    public double distance(@NotNull Vec2f vec) {
        float dx = Math.abs(vec.x - x), dy = Math.abs(vec.y - y);
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public double distanceSquared(@NotNull Vec2f vec) {
        float dx = Math.abs(vec.x - x), dy = Math.abs(vec.y - y);
        return (dx * dx) + (dy * dy);
    }

    @Override
    public @NotNull Vec2f negate() {
        return new Vec2f(-x, -y);
    }

    @Override
    public @NotNull Vec2f min(@NotNull Vec2f vec) {
        float mx = Math.min(vec.x, x), my = Math.min(vec.y, y);
        return new Vec2f(mx, my);
    }

    @Override
    public @NotNull Vec2f max(@NotNull Vec2f vec) {
        float mx = Math.max(vec.x, x), my = Math.max(vec.y, y);
        return new Vec2f(mx, my);
    }

    @Override
    public @NotNull Vec2f minLength(@NotNull Vec2f vec) {
        return (length() < vec.length()) ? this : vec;
    }

    @Override
    public @NotNull Vec2f maxLength(@NotNull Vec2f vec) {
        return (length() > vec.length()) ? this : vec;
    }

    @Override
    public @NotNull Float minComponent() {
        return Math.min(x, y);
    }

    @Override
    public @NotNull Float maxComponent() {
        return Math.max(x, y);
    }

    @Override
    public @NotNull Vec2f abs() {
        return new Vec2f(Math.abs(x), Math.abs(y));
    }

    @Override
    public @NotNull Vec2f zero() {
        return ZERO;
    }

    @Override
    public @NotNull Vec2f clone() {
        return new Vec2f(x, y);
    }
}
