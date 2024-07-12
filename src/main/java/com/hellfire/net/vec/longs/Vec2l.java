package com.hellfire.net.vec.longs;

import com.hellfire.net.vec.IVec2;
import com.hellfire.net.vec.doubles.Vec2d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

/* Created by Conor on 15.05.2024 */
public class Vec2l extends IVec2<Long, Vec2l> {

    public static final Vec2l ZERO = new Vec2l(0, 0);

    public final long x, y;

    public Vec2l(final long @NotNull ... comps) {
        if (comps.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        this.x = comps[0];
        this.y = comps[1];
    }

    public Vec2l(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public Vec2l() {
        this(0, 0);
    }

    ///////////////////////////////////////////////////////////////////////////
    // Impl methods
    ///////////////////////////////////////////////////////////////////////////

    @Override
    public @NotNull Vec2l set(@Range(from = 0, to = 1) int component, @NotNull Long val) {
        return switch (component) {
            case 0 -> new Vec2l(val, y);
            case 1 -> new Vec2l(x, val);
            default -> throw new IllegalArgumentException("Invalid component");
        };
    }

    @Override
    public @NotNull Vec2l set(@NotNull Long @NotNull ... valArr) {
        if (valArr.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        return new Vec2l(valArr[0], valArr[1]);
    }

    @Override
    public @NotNull Long get(@Range(from = 0, to = 1) int component) {
        return switch (component) {
          case 0 -> x;
          case 1 -> y;
          default -> throw new IllegalArgumentException("Invalid component");
        };
    }

    @Override
    public @NotNull Long[] getComponents() {
        return new @NotNull Long[] {x, y};
    }

    @Override
    public @NotNull Vec2l add(@NotNull Vec2l vec) {
        return new Vec2l(x + vec.x, y + vec.y);
    }

    @Override
    public @NotNull Vec2l add(@NotNull Long @NotNull ... vecArr) {
        if (vecArr.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        return new Vec2l(x + vecArr[0], y + vecArr[1]);
    }

    @Override
    public @NotNull Vec2l addScalar(@NotNull Long val) {
        return new Vec2l(x + val, y + val);
    }

    @Override
    public @NotNull Vec2l sub(@NotNull Vec2l vec) {
        return new Vec2l(x - vec.x, y - vec.y);
    }

    @Override
    public @NotNull Vec2l sub(@NotNull Long @NotNull ... vecArr) {
        if (vecArr.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        return new Vec2l(x - vecArr[0], y - vecArr[1]);
    }

    @Override
    public @NotNull Vec2l mul(@NotNull Vec2l vec) {
        return new Vec2l(x * vec.x, y * vec.y);
    }

    @Override
    public @NotNull Vec2l mul(@NotNull Long @NotNull ... vecArr) {
        if (vecArr.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        return new Vec2l(x * vecArr[0], y * vecArr[1]);
    }

    @Override
    public @NotNull Vec2l mulScalar(@NotNull Long scale) {
        return new Vec2l(x * scale, y * scale);
    }

    @Override
    public @NotNull Vec2l div(@NotNull Long scale) {
        return new Vec2l(x / scale, y / scale);
    }

    @Override
    public @NotNull Vec2l div(double scale) {
        return new Vec2l((long) (x / scale), (long) (y / scale));
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
    public double distance(@NotNull Vec2l vec) {
        long dx = Math.abs(vec.x - x), dy = Math.abs(vec.y - y);
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public double distanceSquared(@NotNull Vec2l vec) {
        long dx = Math.abs(vec.x - x), dy = Math.abs(vec.y - y);
        return (dx * dx) + (dy * dy);
    }

    @Override
    public @NotNull Vec2l negate() {
        return new Vec2l(-x, -y);
    }

    @Override
    public @NotNull Vec2l min(@NotNull Vec2l vec) {
        long mx = Math.min(vec.x, x), my = Math.min(vec.y, y);
        return new Vec2l(mx, my);
    }

    @Override
    public @NotNull Vec2l max(@NotNull Vec2l vec) {
        long mx = Math.max(vec.x, x), my = Math.max(vec.y, y);
        return new Vec2l(mx, my);
    }

    @Override
    public @NotNull Vec2l minLength(@NotNull Vec2l vec) {
        return (length() < vec.length()) ? this : vec;
    }

    @Override
    public @NotNull Vec2l maxLength(@NotNull Vec2l vec) {
        return (length() > vec.length()) ? this : vec;
    }

    @Override
    public @NotNull Long minComponent() {
        return Math.min(x, y);
    }

    @Override
    public @NotNull Long maxComponent() {
        return Math.max(x, y);
    }

    @Override
    public @NotNull Vec2l abs() {
        return new Vec2l(Math.abs(x), Math.abs(y));
    }

    @Override
    public @NotNull Vec2d normalize() {
        return new Vec2d(x, y).div(length());
    }

    @Override
    public @NotNull Vec2l zero() {
        return ZERO;
    }

    @Override
    public @NotNull Vec2l clone() {
        return new Vec2l(x, y);
    }
}
