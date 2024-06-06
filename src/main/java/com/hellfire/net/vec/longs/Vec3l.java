package com.hellfire.net.vec.longs;

import com.hellfire.net.vec.IVec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

/* Created by Conor on 15.05.2024 */
public class Vec3l extends IVec3<Long, Vec3l> {

    private static final int NUM_COMPONENTS = 3;
    public static final Vec3l ZERO = new Vec3l(0, 0, 0);

    public final long x, y, z;

    public Vec3l(final long @NotNull ... comps) {
        if (comps.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        this.x = comps[0];
        this.y = comps[1];
        this.z = comps[2];
    }

    public Vec3l(long x, long y, long z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vec3l() {
        this(0, 0, 0);
    }

    ///////////////////////////////////////////////////////////////////////////
    // Impl methods
    ///////////////////////////////////////////////////////////////////////////

    @Override
    public int numComponents() {
        return NUM_COMPONENTS;
    }

    @Override
    public @NotNull Vec3l set(@Range(from = 0, to = 2) int component, @NotNull Long val) {
        return switch (component) {
            case 0 -> new Vec3l(val, y, z);
            case 1 -> new Vec3l(x, val, z);
            case 2 -> new Vec3l(x, y, val);
            default -> throw new IllegalArgumentException("Invalid component");
        };
    }

    @Override
    public @NotNull Vec3l set(@NotNull Long @NotNull ... valArr) {
        if (valArr.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        return new Vec3l(valArr[0], valArr[1], valArr[2]);
    }

    @Override
    public @NotNull Long get(@Range(from = 0, to = 2) int component) {
        return switch (component) {
            case 0 -> x;
            case 1 -> y;
            case 2 -> z;
            default -> throw new IllegalArgumentException("Invalid component");
        };
    }

    @Override
    public @NotNull Long[] getComponents() {
        return new @NotNull Long[] {x, y, z};
    }

    @Override
    public @NotNull Vec3l add(@NotNull Vec3l vec) {
        return new Vec3l(x + vec.x, y + vec.y, z + vec.z);
    }

    @Override
    public @NotNull Vec3l add(@NotNull Long @NotNull ... vecArr) {
        if (vecArr.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        return new Vec3l(x + vecArr[0], y + vecArr[1], z + vecArr[2]);
    }

    @Override
    public @NotNull Vec3l sub(@NotNull Vec3l vec) {
        return new Vec3l(x - vec.x, y - vec.y, z - vec.z);
    }

    @Override
    public @NotNull Vec3l sub(@NotNull Long @NotNull ... vecArr) {
        if (vecArr.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        return new Vec3l(x - vecArr[0], y - vecArr[1], z - vecArr[2]);
    }

    @Override
    public @NotNull Vec3l mul(@NotNull Vec3l vec) {
        return new Vec3l(x * vec.x, y * vec.y, z * vec.z);
    }

    @Override
    public @NotNull Vec3l mul(@NotNull Long @NotNull ... vecArr) {
        if (vecArr.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        return new Vec3l(x * vecArr[0], y * vecArr[1], z * vecArr[2]);
    }

    @Override
    public @NotNull Vec3l mul(@NotNull Long scale) {
        return new Vec3l(x * scale, y * scale, z * scale);
    }

    @Override
    public @NotNull Vec3l div(@NotNull Long scale) {
        return new Vec3l(x / scale, y / scale, z / scale);
    }

    @Override
    public @NotNull Vec3l div(double scale) {
        return new Vec3l((long) (x / scale), (long) (y / scale), (long) (z / scale));
    }

    @Override
    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    @Override
    public double lengthSquared() {
        return (x * x) + (y * y) + (z * z);
    }

    @Override
    public double distance(@NotNull Vec3l vec) {
        long dx = Math.abs(vec.x - x), dy = Math.abs(vec.y - y), dz = Math.abs(vec.z - z);
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    @Override
    public double distanceSquared(@NotNull Vec3l vec) {
        long dx = Math.abs(vec.x - x), dy = Math.abs(vec.y - y), dz = Math.abs(vec.z - z);
        return (dx * dx) + (dy * dy) + (dz * dz);
    }

    @Override
    public @NotNull Vec3l negate() {
        return new Vec3l(-x, -y, -z);
    }

    @Override
    public @NotNull Vec3l min(@NotNull Vec3l vec) {
        long mx = Math.min(vec.x, x), my = Math.min(vec.y, y), mz = Math.min(vec.z, z);
        return new Vec3l(mx, my, mz);
    }

    @Override
    public @NotNull Vec3l max(@NotNull Vec3l vec) {
        long mx = Math.max(vec.x, x), my = Math.max(vec.y, y), mz = Math.max(vec.z, z);
        return new Vec3l(mx, my, mz);
    }

    @Override
    public @NotNull Vec3l minLength(@NotNull Vec3l vec) {
        return (length() < vec.length()) ? this : vec;
    }

    @Override
    public @NotNull Vec3l maxLength(@NotNull Vec3l vec) {
        return (length() > vec.length()) ? this : vec;
    }

    @Override
    public @NotNull Long minComponent() {
        if (x < y && y < z) return x;
        return Math.min(y, z);
    }

    @Override
    public @NotNull Long maxComponent() {
        if (x > y && y > z) return x;
        return Math.max(y, z);
    }

    @Override
    public @NotNull Vec3l abs() {
        return new Vec3l(Math.abs(x), Math.abs(y), Math.abs(z));
    }

    @Override
    public @NotNull Vec3l zero() {
        return ZERO;
    }

    @Override
    public @NotNull Vec3l clone() {
        return new Vec3l(x, y, z);
    }

    @Override
    public @NotNull Vec3l cross(@NotNull Vec3l other) {
        return new Vec3l(
                y*other.z - other.y*z,
                z*other.x - other.z*x,
                x*other.y - other.x*y
        );
    }
}
