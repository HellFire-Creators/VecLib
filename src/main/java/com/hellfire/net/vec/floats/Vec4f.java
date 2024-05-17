package com.hellfire.net.vec.floats;

import com.hellfire.net.vec.IVec;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

/* Created by Conor on 15.05.2024 */
public class Vec4f implements IVec<Float, Vec4f> {

    private static final int NUM_COMPONENTS = 4;
    public static final Vec4f ZERO = new Vec4f(0, 0, 0, 0);

    public final float x, y, z, w;

    public Vec4f(final float @NotNull ... comps) {
        if (comps.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        this.x = comps[0];
        this.y = comps[1];
        this.z = comps[2];
        this.w = comps[3];
    }

    public Vec4f(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public Vec4f() {
        this(0, 0, 0, 0);
    }

    ///////////////////////////////////////////////////////////////////////////
    // Impl methods
    ///////////////////////////////////////////////////////////////////////////

    @Override
    public int numComponents() {
        return NUM_COMPONENTS;
    }

    @Override
    public @NotNull Vec4f set(@Range(from = 0, to = 3) int component, @NotNull Float val) {
        return switch (component) {
            case 0 -> new Vec4f(val, y, z, w);
            case 1 -> new Vec4f(x, val, z, w);
            case 2 -> new Vec4f(x, y, val, w);
            case 3 -> new Vec4f(x, y, z, val);
            default -> throw new IllegalArgumentException("Invalid component");
        };
    }

    @Override
    public @NotNull Vec4f set(@NotNull Float @NotNull ... valArr) {
        if (valArr.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        return new Vec4f(valArr[0], valArr[1], valArr[2], valArr[3]);
    }

    @Override
    public @NotNull Float get(@Range(from = 0, to = 3) int component) {
        return switch (component) {
            case 0 -> x;
            case 1 -> y;
            case 2 -> z;
            case 3 -> w;
            default -> throw new IllegalArgumentException("Invalid component");
        };
    }

    @Override
    public @NotNull Float[] getComponents() {
        return new @NotNull Float[] {x, y, z, w};
    }

    @Override
    public @NotNull Vec4f add(@NotNull Vec4f vec) {
        return new Vec4f(x + vec.x, y + vec.y, z + vec.z, w + vec.w);
    }

    @Override
    public @NotNull Vec4f add(@NotNull Float @NotNull ... vecArr) {
        if (vecArr.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        return new Vec4f(x + vecArr[0], y + vecArr[1], z + vecArr[2], w + vecArr[3]);
    }

    @Override
    public @NotNull Vec4f sub(@NotNull Vec4f vec) {
        return new Vec4f(x - vec.x, y - vec.y, z - vec.z, w - vec.w);
    }

    @Override
    public @NotNull Vec4f sub(@NotNull Float @NotNull ... vecArr) {
        if (vecArr.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        return new Vec4f(x - vecArr[0], y - vecArr[1], z - vecArr[2], w - vecArr[3]);
    }

    @Override
    public @NotNull Vec4f mul(@NotNull Vec4f vec) {
        return new Vec4f(x * vec.x, y * vec.y, z * vec.z, w * vec.w);
    }

    @Override
    public @NotNull Vec4f mul(@NotNull Float @NotNull ... vecArr) {
        if (vecArr.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        return new Vec4f(x * vecArr[0], y * vecArr[1], z * vecArr[2], w * vecArr[3]);
    }

    @Override
    public @NotNull Vec4f mul(@NotNull Float scale) {
        return new Vec4f(x * scale, y * scale, z * scale, w * scale);
    }

    @Override
    public @NotNull Vec4f div(@NotNull Float scale) {
        return new Vec4f(x / scale, y / scale, z / scale, w / scale);
    }

    @Override
    public @NotNull Vec4f div(double scale) {
        return new Vec4f((float) (x / scale), (float) (y / scale), (float) (z / scale), (float) (w / scale));
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
    public double distance(@NotNull Vec4f vec) {
        float dx = Math.abs(vec.x - x), dy = Math.abs(vec.y - y), dz = Math.abs(vec.z - z), dw = Math.abs(vec.w - w);
        return Math.sqrt(dx * dx + dy * dy + dz * dz + dw * dw);
    }

    @Override
    public double distanceSquared(@NotNull Vec4f vec) {
        float dx = Math.abs(vec.x - x), dy = Math.abs(vec.y - y), dz = Math.abs(vec.z - z), dw = Math.abs(vec.w - w);
        return (dx * dx) + (dy * dy) + (dz * dz) + (dw * dw);
    }

    @Override
    public @NotNull Vec4f negate() {
        return new Vec4f(-x, -y, -z, -w);
    }

    @Override
    public @NotNull Vec4f min(@NotNull Vec4f vec) {
        float mx = Math.min(vec.x, x), my = Math.min(vec.y, y), mz = Math.min(vec.z, z), mw = Math.min(vec.w, w);
        return new Vec4f(mx, my, mz, mw);
    }

    @Override
    public @NotNull Vec4f max(@NotNull Vec4f vec) {
        float mx = Math.max(vec.x, x), my = Math.max(vec.y, y), mz = Math.max(vec.z, z), mw = Math.max(vec.w, w);
        return new Vec4f(mx, my, mz, mw);
    }

    @Override
    public @NotNull Vec4f minLength(@NotNull Vec4f vec) {
        return (length() < vec.length()) ? this : vec;
    }

    @Override
    public @NotNull Vec4f maxLength(@NotNull Vec4f vec) {
        return (length() > vec.length()) ? this : vec;
    }

    @Override
    public @NotNull Float minComponent() {
        if (w < x && x < y && y < z) return w;
        if (x < y && y < z) return x;
        return Math.min(y, z);
    }

    @Override
    public @NotNull Float maxComponent() {
        if (w > x && x > y && y > z) return w;
        if (x > y && y > z) return x;
        return Math.max(y, z);
    }

    @Override
    public @NotNull Vec4f abs() {
        return new Vec4f(Math.abs(x), Math.abs(y), Math.abs(z), Math.abs(w));
    }

    @Override
    public @NotNull Vec4f zero() {
        return ZERO;
    }

    @Override
    public @NotNull Vec4f clone() {
        return new Vec4f(x, y, z, w);
    }
}
