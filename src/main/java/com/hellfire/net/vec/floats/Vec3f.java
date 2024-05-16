package com.hellfire.net.vec.floats;

import com.hellfire.net.vec.IVec;
import com.hellfire.net.vec.doubles.Vec2d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

/* Created by Conor on 15.05.2024 */
public class Vec3f implements IVec<Float, Vec3f> {

    private static final int NUM_COMPONENTS = 3;
    public static final Vec3f ZERO = new Vec3f(0, 0, 0);

    public final float x, y, z;

    public Vec3f(final float[] comps) {
        if (comps.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        this.x = comps[0];
        this.y = comps[1];
        this.z = comps[2];
    }

    public Vec3f(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vec3f() {
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
    public @NotNull Vec3f set(@Range(from = 0, to = 2) int component, @NotNull Float val) {
        return switch (component) {
            case 0 -> new Vec3f(val, y, z);
            case 1 -> new Vec3f(x, val, z);
            case 2 -> new Vec3f(x, y, val);
            default -> throw new IllegalArgumentException("Invalid component");
        };
    }

    @Override
    public @NotNull Vec3f set(@NotNull Float[] valArr) {
        if (valArr.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        return new Vec3f(valArr[0], valArr[1], valArr[2]);
    }

    @Override
    public @NotNull Float get(@Range(from = 0, to = 2) int component) {
        return switch (component) {
            case 0 -> x;
            case 1 -> y;
            case 2 -> z;
            default -> throw new IllegalArgumentException("Invalid component");
        };
    }

    @Override
    public @NotNull Float[] getComponents() {
        return new @NotNull Float[] {x, y, z};
    }

    @Override
    public @NotNull Vec3f add(@NotNull Vec3f vec) {
        return new Vec3f(x + vec.x, y + vec.y, z + vec.z);
    }

    @Override
    public @NotNull Vec3f add(@NotNull Float[] vecArr) {
        if (vecArr.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        return new Vec3f(x + vecArr[0], y + vecArr[1], z + vecArr[2]);
    }

    @Override
    public @NotNull Vec3f sub(@NotNull Vec3f vec) {
        return new Vec3f(x - vec.x, y - vec.y, z - vec.z);
    }

    @Override
    public @NotNull Vec3f sub(@NotNull Float[] vecArr) {
        if (vecArr.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        return new Vec3f(x - vecArr[0], y - vecArr[1], z - vecArr[2]);
    }

    @Override
    public @NotNull Vec3f mul(@NotNull Vec3f vec) {
        return new Vec3f(x * vec.x, y * vec.y, z * vec.z);
    }

    @Override
    public @NotNull Vec3f mul(@NotNull Float[] vecArr) {
        if (vecArr.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        return new Vec3f(x * vecArr[0], y * vecArr[1], z * vecArr[2]);
    }

    @Override
    public @NotNull Vec3f mul(@NotNull Float scale) {
        return new Vec3f(x * scale, y * scale, z * scale);
    }

    @Override
    public @NotNull Vec3f div(@NotNull Float scale) {
        return new Vec3f(x / scale, y / scale, z / scale);
    }

    @Override
    public @NotNull Vec3f div(double scale) {
        return new Vec3f((float) (x / scale), (float) (y / scale), (float) (z / scale));
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
    public double distance(@NotNull Vec3f vec) {
        float dx = Math.abs(vec.x - x), dy = Math.abs(vec.y - y), dz = Math.abs(vec.z - z);
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    @Override
    public double distanceSquared(@NotNull Vec3f vec) {
        float dx = Math.abs(vec.x - x), dy = Math.abs(vec.y - y), dz = Math.abs(vec.z - z);
        return (dx * dx) + (dy * dy) + (dz * dz);
    }

    @Override
    public @NotNull Vec3f negate() {
        return new Vec3f(-x, -y, -z);
    }

    @Override
    public @NotNull Vec3f min(@NotNull Vec3f vec) {
        float mx = Math.min(vec.x, x), my = Math.min(vec.y, y), mz = Math.min(vec.z, z);
        return new Vec3f(mx, my, mz);
    }

    @Override
    public @NotNull Vec3f max(@NotNull Vec3f vec) {
        float mx = Math.max(vec.x, x), my = Math.max(vec.y, y), mz = Math.max(vec.z, z);
        return new Vec3f(mx, my, mz);
    }

    @Override
    public @NotNull Vec3f minLength(@NotNull Vec3f vec) {
        return (length() < vec.length()) ? this : vec;
    }

    @Override
    public @NotNull Vec3f maxLength(@NotNull Vec3f vec) {
        return (length() > vec.length()) ? this : vec;
    }

    @Override
    public @NotNull Float minComponent() {
        if (x < y && y < z) return x;
        return Math.min(y, z);
    }

    @Override
    public @NotNull Float maxComponent() {
        if (x > y && y > z) return x;
        return Math.max(y, z);
    }

    @Override
    public @NotNull Vec3f abs() {
        return new Vec3f(Math.abs(x), Math.abs(y), Math.abs(z));
    }

    @Override
    public @NotNull Vec3f zero() {
        return ZERO;
    }

    @Override
    public @NotNull Vec3f clone() {
        return new Vec3f(x, y, z);
    }
}
