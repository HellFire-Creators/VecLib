package com.hellfire.net.vec.doubles;

import com.hellfire.net.vec.IVec4;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

/* Created by Conor on 15.05.2024 */
public class Vec4d extends IVec4<Double, Vec4d> {

    public static final Vec4d ZERO = new Vec4d(0, 0, 0, 0);

    public final double x, y, z, w;

    public Vec4d(final double @NotNull ... comps) {
        if (comps.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        this.x = comps[0];
        this.y = comps[1];
        this.z = comps[2];
        this.w = comps[3];
    }

    public Vec4d(double x, double y, double z, double w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public Vec4d() {
        this(0, 0, 0, 0);
    }

    ///////////////////////////////////////////////////////////////////////////
    // Impl methods
    ///////////////////////////////////////////////////////////////////////////

    @Override
    public @NotNull Vec4d set(@Range(from = 0, to = 3) int component, @NotNull Double val) {
        return switch (component) {
            case 0 -> new Vec4d(val, y, z, w);
            case 1 -> new Vec4d(x, val, z, w);
            case 2 -> new Vec4d(x, y, val, w);
            case 3 -> new Vec4d(x, y, z, val);
            default -> throw new IllegalArgumentException("Invalid component");
        };
    }

    @Override
    public @NotNull Vec4d set(@NotNull Double @NotNull ... valArr) {
        if (valArr.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        return new Vec4d(valArr[0], valArr[1], valArr[2], valArr[3]);
    }

    @Override
    public @NotNull Double get(@Range(from = 0, to = 3) int component) {
        return switch (component) {
            case 0 -> x;
            case 1 -> y;
            case 2 -> z;
            case 3 -> w;
            default -> throw new IllegalArgumentException("Invalid component");
        };
    }

    @Override
    public @NotNull Double[] getComponents() {
        return new @NotNull Double[] {x, y, z, w};
    }

    @Override
    public @NotNull Vec4d add(@NotNull Vec4d vec) {
        return new Vec4d(x + vec.x, y + vec.y, z + vec.z, w + vec.w);
    }

    @Override
    public @NotNull Vec4d add(@NotNull Double @NotNull ... vecArr) {
        if (vecArr.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        return new Vec4d(x + vecArr[0], y + vecArr[1], z + vecArr[2], w + vecArr[3]);
    }

    @Override
    public @NotNull Vec4d addScalar(@NotNull Double val) {
        return new Vec4d(x + val, y + val, z + val, w + val);
    }

    @Override
    public @NotNull Vec4d sub(@NotNull Vec4d vec) {
        return new Vec4d(x - vec.x, y - vec.y, z - vec.z, w - vec.w);
    }

    @Override
    public @NotNull Vec4d sub(@NotNull Double @NotNull ... vecArr) {
        if (vecArr.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        return new Vec4d(x - vecArr[0], y - vecArr[1], z - vecArr[2], w - vecArr[3]);
    }

    @Override
    public @NotNull Vec4d subScalar(@NotNull Double val) {
        return new Vec4d(x - val, y - val, z - val, w - val);
    }

    @Override
    public @NotNull Vec4d mul(@NotNull Vec4d vec) {
        return new Vec4d(x * vec.x, y * vec.y, z * vec.z, w * vec.w);
    }

    @Override
    public @NotNull Vec4d mul(@NotNull Double @NotNull ... vecArr) {
        if (vecArr.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        return new Vec4d(x * vecArr[0], y * vecArr[1], z * vecArr[2], w * vecArr[3]);
    }

    @Override
    public @NotNull Vec4d mulScalar(@NotNull Double scale) {
        return new Vec4d(x * scale, y * scale, z * scale, w * scale);
    }

    @Override
    public @NotNull Vec4d div(@NotNull Vec4d vec) {
        return new Vec4d(x / vec.x, y / vec.y, z / vec.z, w / vec.w);
    }

    @Override
    public @NotNull Vec4d div(@NotNull Double @NotNull ... vecArr) {
        if (vecArr.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        return new Vec4d(x / vecArr[0], y / vecArr[1], z / vecArr[2], w / vecArr[3]);
    }

    @Override
    public @NotNull Vec4d divScalar(double scale) {
        return new Vec4d(x / scale, y / scale, z / scale, w / scale);
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
    public double distance(@NotNull Vec4d vec) {
        double dx = Math.abs(vec.x - x), dy = Math.abs(vec.y - y), dz = Math.abs(vec.z - z), dw = Math.abs(vec.w - w);
        return Math.sqrt(dx * dx + dy * dy + dz * dz + dw * dw);
    }

    @Override
    public double distanceSquared(@NotNull Vec4d vec) {
        double dx = Math.abs(vec.x - x), dy = Math.abs(vec.y - y), dz = Math.abs(vec.z - z), dw = Math.abs(vec.w - w);
        return (dx * dx) + (dy * dy) + (dz * dz) + (dw * dw);
    }

    @Override
    public @NotNull Vec4d negate() {
        return new Vec4d(-x, -y, -z, -w);
    }

    @Override
    public @NotNull Vec4d min(@NotNull Vec4d vec) {
        double mx = Math.min(vec.x, x), my = Math.min(vec.y, y), mz = Math.min(vec.z, z), mw = Math.min(vec.w, w);
        return new Vec4d(mx, my, mz, mw);
    }

    @Override
    public @NotNull Vec4d max(@NotNull Vec4d vec) {
        double mx = Math.max(vec.x, x), my = Math.max(vec.y, y), mz = Math.max(vec.z, z), mw = Math.max(vec.w, w);
        return new Vec4d(mx, my, mz, mw);
    }

    @Override
    public @NotNull Vec4d minLength(@NotNull Vec4d vec) {
        return (length() < vec.length()) ? this : vec;
    }

    @Override
    public @NotNull Vec4d maxLength(@NotNull Vec4d vec) {
        return (length() > vec.length()) ? this : vec;
    }

    @Override
    public @NotNull Double minComponent() {
        if (w < x && x < y && y < z) return w;
        if (x < y && y < z) return x;
        return Math.min(y, z);
    }

    @Override
    public @NotNull Double maxComponent() {
        if (w > x && x > y && y > z) return w;
        if (x > y && y > z) return x;
        return Math.max(y, z);
    }

    @Override
    public @NotNull Vec4d abs() {
        return new Vec4d(Math.abs(x), Math.abs(y), Math.abs(z), Math.abs(w));
    }

    @Override
    public @NotNull Vec4d normalize() {
        return divScalar(length());
    }

    @Override
    public @NotNull Vec4d zero() {
        return ZERO;
    }

    @Override
    public @NotNull Vec4d clone() {
        return new Vec4d(x, y, z, w);
    }
}
