package com.hellfire.net.vec.longs;

import com.hellfire.net.vec.IVec4;
import com.hellfire.net.vec.doubles.Vec4d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

/* Created by Conor on 15.05.2024 */
public class Vec4l extends IVec4<Long, Vec4l> {

    public static final Vec4l ZERO = new Vec4l(0, 0, 0, 0);

    public final long x, y, z, w;

    public Vec4l(final long @NotNull ... comps) {
        if (comps.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        this.x = comps[0];
        this.y = comps[1];
        this.z = comps[2];
        this.w = comps[3];
    }

    public Vec4l(long x, long y, long z, long w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public Vec4l() {
        this(0, 0, 0, 0);
    }

    ///////////////////////////////////////////////////////////////////////////
    // Impl methods
    ///////////////////////////////////////////////////////////////////////////

    @Override
    public @NotNull Vec4l set(@Range(from = 0, to = 3) int component, @NotNull Long val) {
        return switch (component) {
            case 0 -> new Vec4l(val, y, z, w);
            case 1 -> new Vec4l(x, val, z, w);
            case 2 -> new Vec4l(x, y, val, w);
            case 3 -> new Vec4l(x, y, z, val);
            default -> throw new IllegalArgumentException("Invalid component");
        };
    }

    @Override
    public @NotNull Vec4l set(@NotNull Long @NotNull ... valArr) {
        if (valArr.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        return new Vec4l(valArr[0], valArr[1], valArr[2], valArr[3]);
    }

    @Override
    public @NotNull Long get(@Range(from = 0, to = 3) int component) {
        return switch (component) {
            case 0 -> x;
            case 1 -> y;
            case 2 -> z;
            case 3 -> w;
            default -> throw new IllegalArgumentException("Invalid component");
        };
    }

    @Override
    public @NotNull Long[] getComponents() {
        return new @NotNull Long[] {x, y, z, w};
    }

    @Override
    public @NotNull Vec4l add(@NotNull Vec4l vec) {
        return new Vec4l(x + vec.x, y + vec.y, z + vec.z, w + vec.w);
    }

    @Override
    public @NotNull Vec4l add(@NotNull Long @NotNull ... vecArr) {
        if (vecArr.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        return new Vec4l(x + vecArr[0], y + vecArr[1], z + vecArr[2], w + vecArr[3]);
    }

    @Override
    public @NotNull Vec4l addScalar(@NotNull Long val) {
        return new Vec4l(x + val, y + val, z + val, w + val);
    }

    @Override
    public @NotNull Vec4l sub(@NotNull Vec4l vec) {
        return new Vec4l(x - vec.x, y - vec.y, z - vec.z, w - vec.w);
    }

    @Override
    public @NotNull Vec4l sub(@NotNull Long @NotNull ... vecArr) {
        if (vecArr.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        return new Vec4l(x - vecArr[0], y - vecArr[1], z - vecArr[2], w - vecArr[3]);
    }

    @Override
    public @NotNull Vec4l subScalar(@NotNull Long val) {
        return new Vec4l(x - val, y - val, z - val, w - val);
    }

    @Override
    public @NotNull Vec4l mul(@NotNull Vec4l vec) {
        return new Vec4l(x * vec.x, y * vec.y, z * vec.z, w * vec.w);
    }

    @Override
    public @NotNull Vec4l mul(@NotNull Long @NotNull ... vecArr) {
        if (vecArr.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        return new Vec4l(x * vecArr[0], y * vecArr[1], z * vecArr[2], w * vecArr[3]);
    }

    @Override
    public @NotNull Vec4l mulScalar(@NotNull Long scale) {
        return new Vec4l(x * scale, y * scale, z * scale, w * scale);
    }

    @Override
    public @NotNull Vec4l div(@NotNull Vec4l vec) {
        return new Vec4l(x / vec.x, y / vec.y, z / vec.z, w / vec.w);
    }

    @Override
    public @NotNull Vec4l div(@NotNull Long @NotNull ... vecArr) {
        if (vecArr.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        return new Vec4l(x / vecArr[0], y / vecArr[1], z / vecArr[2], w / vecArr[3]);
    }

    @Override
    public @NotNull Vec4l divScalar(double scale) {
        return new Vec4l((long) (x / scale), (long) (y / scale), (long) (z / scale), (long) (w / scale));
    }

    @Override
    public double length() {
        return Math.sqrt(x * x + y * y + z * z + w * w);
    }

    @Override
    public double lengthSquared() {
        return (x * x) + (y * y) + (z * z) + (w * w);
    }

    @Override
    public double distance(@NotNull Vec4l vec) {
        long dx = Math.abs(vec.x - x), dy = Math.abs(vec.y - y), dz = Math.abs(vec.z - z), dw = Math.abs(vec.w - w);
        return Math.sqrt(dx * dx + dy * dy + dz * dz + dw * dw);
    }

    @Override
    public double distanceSquared(@NotNull Vec4l vec) {
        long dx = Math.abs(vec.x - x), dy = Math.abs(vec.y - y), dz = Math.abs(vec.z - z), dw = Math.abs(vec.w - w);
        return (dx * dx) + (dy * dy) + (dz * dz) + (dw * dw);
    }

    @Override
    public @NotNull Vec4l negate() {
        return new Vec4l(-x, -y, -z, -w);
    }

    @Override
    public @NotNull Vec4l min(@NotNull Vec4l vec) {
        long mx = Math.min(vec.x, x), my = Math.min(vec.y, y), mz = Math.min(vec.z, z), mw = Math.min(vec.w, w);
        return new Vec4l(mx, my, mz, mw);
    }

    @Override
    public @NotNull Vec4l max(@NotNull Vec4l vec) {
        long mx = Math.max(vec.x, x), my = Math.max(vec.y, y), mz = Math.max(vec.z, z), mw = Math.max(vec.w, w);
        return new Vec4l(mx, my, mz, mw);
    }

    @Override
    public @NotNull Vec4l minLength(@NotNull Vec4l vec) {
        return (length() < vec.length()) ? this : vec;
    }

    @Override
    public @NotNull Vec4l maxLength(@NotNull Vec4l vec) {
        return (length() > vec.length()) ? this : vec;
    }

    @Override
    public @NotNull Long minComponent() {
        if (w < x && x < y && y < z) return w;
        if (x < y && y < z) return x;
        return Math.min(y, z);
    }

    @Override
    public @NotNull Long maxComponent() {
        if (w > x && x > y && y > z) return w;
        if (x > y && y > z) return x;
        return Math.max(y, z);
    }

    @Override
    public @NotNull Vec4l abs() {
        return new Vec4l(Math.abs(x), Math.abs(y), Math.abs(z), Math.abs(w));
    }

    @Override
    public @NotNull Vec4d normalize() {
        return new Vec4d(x, y, z, w).divScalar(length());
    }

    @Override
    public @NotNull Vec4l zero() {
        return ZERO;
    }

    @Override
    public @NotNull Vec4l clone() {
        return new Vec4l(x, y, z, w);
    }
}
