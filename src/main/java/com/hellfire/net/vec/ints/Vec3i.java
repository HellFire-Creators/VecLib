package com.hellfire.net.vec.ints;

import com.hellfire.net.vec.IVec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

/* Created by Conor on 15.05.2024 */
public class Vec3i extends IVec3<Integer, Vec3i> {

    public static final int NUM_COMPONENTS = 3;
    public static final Vec3i ZERO = new Vec3i(0, 0, 0);

    public final int x, y, z;

    public Vec3i(final int @NotNull ... comps) {
        if (comps.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        this.x = comps[0];
        this.y = comps[1];
        this.z = comps[2];
    }

    public Vec3i(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vec3i() {
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
    public @NotNull Vec3i set(@Range(from = 0, to = 2) int component, @NotNull Integer val) {
        return switch (component) {
            case 0 -> new Vec3i(val, y, z);
            case 1 -> new Vec3i(x, val, z);
            case 2 -> new Vec3i(x, y, val);
            default -> throw new IllegalArgumentException("Invalid component");
        };
    }

    @Override
    public @NotNull Vec3i set(@NotNull Integer @NotNull ... valArr) {
        if (valArr.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        return new Vec3i(valArr[0], valArr[1], valArr[2]);
    }

    @Override
    public @NotNull Integer get(@Range(from = 0, to = 2) int component) {
        return switch (component) {
            case 0 -> x;
            case 1 -> y;
            case 2 -> z;
            default -> throw new IllegalArgumentException("Invalid component");
        };
    }

    @Override
    public Integer[] getComponents() {
        return new Integer[] {x, y, z};
    }

    @Override
    public @NotNull Vec3i add(@NotNull Vec3i vec) {
        return new Vec3i(x + vec.x, y + vec.y, z + vec.z);
    }

    @Override
    public @NotNull Vec3i add(@NotNull Integer @NotNull ... vecArr) {
        if (vecArr.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        return new Vec3i(x + vecArr[0], y + vecArr[1], z + vecArr[2]);
    }

    @Override
    public @NotNull Vec3i addScalar(@NotNull Integer val) {
        return new Vec3i(x + val, y + val, z + val);
    }

    @Override
    public @NotNull Vec3i sub(@NotNull Vec3i vec) {
        return new Vec3i(x - vec.x, y - vec.y, z - vec.z);
    }

    @Override
    public @NotNull Vec3i sub(@NotNull Integer @NotNull ... vecArr) {
        if (vecArr.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        return new Vec3i(x - vecArr[0], y - vecArr[1], z - vecArr[2]);
    }

    @Override
    public @NotNull Vec3i mul(@NotNull Vec3i vec) {
        return new Vec3i(x * vec.x, y * vec.y, z * vec.z);
    }

    @Override
    public @NotNull Vec3i mul(@NotNull Integer @NotNull ... vecArr) {
        if (vecArr.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        return new Vec3i(x * vecArr[0], y * vecArr[1], z * vecArr[2]);
    }

    @Override
    public @NotNull Vec3i mulScalar(@NotNull Integer scale) {
        return new Vec3i(x * scale, y * scale, z * scale);
    }

    @Override
    public @NotNull Vec3i div(@NotNull Integer scale) {
        return new Vec3i(x / scale, y / scale, z / scale);
    }

    @Override
    public @NotNull Vec3i div(double scale) {
        return new Vec3i((int) (x / scale), (int) (y / scale), (int) (z / scale));
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
    public double distance(@NotNull Vec3i vec) {
        int dx = Math.abs(vec.x - x), dy = Math.abs(vec.y - y), dz = Math.abs(vec.z - z);
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    @Override
    public double distanceSquared(@NotNull Vec3i vec) {
        int dx = Math.abs(vec.x - x), dy = Math.abs(vec.y - y), dz = Math.abs(vec.z - z);
        return (dx * dx) + (dy * dy) + (dz * dz);
    }

    @Override
    public @NotNull Vec3i negate() {
        return new Vec3i(-x, -y, -z);
    }

    @Override
    public @NotNull Vec3i min(@NotNull Vec3i vec) {
        int mx = Math.min(vec.x, x), my = Math.min(vec.y, y), mz = Math.min(vec.z, z);
        return new Vec3i(mx, my, mz);
    }

    @Override
    public @NotNull Vec3i max(@NotNull Vec3i vec) {
        int mx = Math.max(vec.x, x), my = Math.max(vec.y, y), mz = Math.max(vec.z, z);
        return new Vec3i(mx, my, mz);
    }

    @Override
    public @NotNull Vec3i minLength(@NotNull Vec3i vec) {
        return (length() < vec.length()) ? this : vec;
    }

    @Override
    public @NotNull Vec3i maxLength(@NotNull Vec3i vec) {
        return (length() > vec.length()) ? this : vec;
    }

    @Override
    public @NotNull Integer minComponent() {
        if (x < y && y < z) return x;
        return Math.min(y, z);
    }

    @Override
    public @NotNull Integer maxComponent() {
        if (x > y && y > z) return x;
        return Math.max(y, z);
    }

    @Override
    public @NotNull Vec3i abs() {
        return new Vec3i(Math.abs(x), Math.abs(y), Math.abs(z));
    }

    @Override
    public @NotNull Vec3i zero() {
        return ZERO;
    }

    @Override
    public @NotNull Vec3i clone() {
        return new Vec3i(x, y, z);
    }

    @Override
    public @NotNull Vec3i cross(@NotNull Vec3i other) {
        return new Vec3i(
                y*other.z - other.y*z,
                z*other.x - other.z*x,
                x*other.y - other.x*y
        );
    }
}
