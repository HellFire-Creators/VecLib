package com.hellfire.net.vec.doubles;

import com.hellfire.net.vec.IVec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

/* Created by Conor on 15.05.2024 */
public class Vec3d extends IVec3<Double, Vec3d> {

    private static final int NUM_COMPONENTS = 3;
    public static final Vec3d ZERO = new Vec3d(0, 0, 0);

    public final double x, y, z;

    public Vec3d(final double @NotNull ... comps) {
        if (comps.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        this.x = comps[0];
        this.y = comps[1];
        this.z = comps[2];
    }

    public Vec3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vec3d() {
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
    public @NotNull Vec3d set(@Range(from = 0, to = 2) int component, @NotNull Double val) {
        return switch (component) {
            case 0 -> new Vec3d(val, y, z);
            case 1 -> new Vec3d(x, val, z);
            case 2 -> new Vec3d(x, y, val);
            default -> throw new IllegalArgumentException("Invalid component");
        };
    }

    @Override
    public @NotNull Vec3d set(@NotNull Double @NotNull ... valArr) {
        if (valArr.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        return new Vec3d(valArr[0], valArr[1], valArr[2]);
    }

    @Override
    public @NotNull Double get(@Range(from = 0, to = 2) int component) {
        return switch (component) {
            case 0 -> x;
            case 1 -> y;
            case 2 -> z;
            default -> throw new IllegalArgumentException("Invalid component");
        };
    }

    @Override
    public @NotNull Double[] getComponents() {
        return new @NotNull Double[] {x, y, z};
    }

    @Override
    public @NotNull Vec3d add(@NotNull Vec3d vec) {
        return new Vec3d(x + vec.x, y + vec.y, z + vec.z);
    }

    @Override
    public @NotNull Vec3d add(@NotNull Double @NotNull ... vecArr) {
        if (vecArr.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        return new Vec3d(x + vecArr[0], y + vecArr[1], z + vecArr[2]);
    }

    @Override
    public @NotNull Vec3d addScalar(@NotNull Double val) {
        return new Vec3d(x + val, y + val, z + val);
    }

    @Override
    public @NotNull Vec3d sub(@NotNull Vec3d vec) {
        return new Vec3d(x - vec.x, y - vec.y, z - vec.z);
    }

    @Override
    public @NotNull Vec3d sub(@NotNull Double @NotNull ... vecArr) {
        if (vecArr.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        return new Vec3d(x - vecArr[0], y - vecArr[1], z - vecArr[2]);
    }

    @Override
    public @NotNull Vec3d mul(@NotNull Vec3d vec) {
        return new Vec3d(x * vec.x, y * vec.y, z * vec.z);
    }

    @Override
    public @NotNull Vec3d mul(@NotNull Double @NotNull ... vecArr) {
        if (vecArr.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        return new Vec3d(x * vecArr[0], y * vecArr[1], z * vecArr[2]);
    }

    @Override
    public @NotNull Vec3d mul(@NotNull Double scale) {
        return new Vec3d(x * scale, y * scale, z * scale);
    }

    @Override
    public @NotNull Vec3d div(@NotNull Double scale) {
        return new Vec3d(x / scale, y / scale, z / scale);
    }

    @Override
    public @NotNull Vec3d div(double scale) {
        return new Vec3d((double) (x / scale), (double) (y / scale), (double) (z / scale));
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
    public double distance(@NotNull Vec3d vec) {
        double dx = Math.abs(vec.x - x), dy = Math.abs(vec.y - y), dz = Math.abs(vec.z - z);
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    @Override
    public double distanceSquared(@NotNull Vec3d vec) {
        double dx = Math.abs(vec.x - x), dy = Math.abs(vec.y - y), dz = Math.abs(vec.z - z);
        return (dx * dx) + (dy * dy) + (dz * dz);
    }

    @Override
    public @NotNull Vec3d negate() {
        return new Vec3d(-x, -y, -z);
    }

    @Override
    public @NotNull Vec3d min(@NotNull Vec3d vec) {
        double mx = Math.min(vec.x, x), my = Math.min(vec.y, y), mz = Math.min(vec.z, z);
        return new Vec3d(mx, my, mz);
    }

    @Override
    public @NotNull Vec3d max(@NotNull Vec3d vec) {
        double mx = Math.max(vec.x, x), my = Math.max(vec.y, y), mz = Math.max(vec.z, z);
        return new Vec3d(mx, my, mz);
    }

    @Override
    public @NotNull Vec3d minLength(@NotNull Vec3d vec) {
        return (length() < vec.length()) ? this : vec;
    }

    @Override
    public @NotNull Vec3d maxLength(@NotNull Vec3d vec) {
        return (length() > vec.length()) ? this : vec;
    }

    @Override
    public @NotNull Double minComponent() {
        if (x < y && y < z) return x;
        return Math.min(y, z);
    }

    @Override
    public @NotNull Double maxComponent() {
        if (x > y && y > z) return x;
        return Math.max(y, z);
    }

    @Override
    public @NotNull Vec3d abs() {
        return new Vec3d(Math.abs(x), Math.abs(y), Math.abs(z));
    }

    @Override
    public @NotNull Vec3d zero() {
        return ZERO;
    }

    @Override
    public @NotNull Vec3d clone() {
        return new Vec3d(x, y, z);
    }

    @Override
    public @NotNull Vec3d cross(@NotNull Vec3d other) {
        return new Vec3d(
                y*other.z - other.y*z,
                z*other.x - other.z*x,
                x*other.y - other.x*y
        );
    }
}
