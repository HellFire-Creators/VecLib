package com.hellfire.net.vec.ints;

import com.hellfire.net.vec.IVec;
import com.hellfire.net.vec.IVec4;
import com.hellfire.net.vec.doubles.Vec4d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

/* Created by Conor on 15.05.2024 */
public class Vec4i extends IVec4<Integer, Vec4i> {

    public static final Vec4i ZERO = new Vec4i(0, 0, 0, 0);

    public final int x, y, z, w;

    public Vec4i(final int @NotNull ... comps) {
        if (comps.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        this.x = comps[0];
        this.y = comps[1];
        this.z = comps[2];
        this.w = comps[3];
    }

    public Vec4i(int x, int y, int z, int w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public Vec4i() {
        this(0, 0, 0, 0);
    }

    ///////////////////////////////////////////////////////////////////////////
    // Impl methods
    ///////////////////////////////////////////////////////////////////////////

    @Override
    public @NotNull Vec4i set(@Range(from = 0, to = 3) int component, @NotNull Integer val) {
        return switch (component) {
            case 0 -> new Vec4i(val, y, z, w);
            case 1 -> new Vec4i(x, val, z, w);
            case 2 -> new Vec4i(x, y, val, w);
            case 3 -> new Vec4i(x, y, z, val);
            default -> throw new IllegalArgumentException("Invalid component");
        };
    }

    @Override
    public @NotNull Vec4i set(@NotNull Integer @NotNull ... valArr) {
        if (valArr.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        return new Vec4i(valArr[0], valArr[1], valArr[2], valArr[3]);
    }

    @Override
    public @NotNull Integer get(@Range(from = 0, to = 3) int component) {
        return switch (component) {
            case 0 -> x;
            case 1 -> y;
            case 2 -> z;
            case 3 -> w;
            default -> throw new IllegalArgumentException("Invalid component");
        };
    }

    @Override
    public Integer[] getComponents() {
        return new Integer[] {x, y, z, w};
    }

    @Override
    public @NotNull Vec4i add(@NotNull Vec4i vec) {
        return new Vec4i(x + vec.x, y + vec.y, z + vec.z, w + vec.w);
    }

    @Override
    public @NotNull Vec4i add(@NotNull Integer @NotNull ... vecArr) {
        if (vecArr.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        return new Vec4i(x + vecArr[0], y + vecArr[1], z + vecArr[2], w + vecArr[3]);
    }

    @Override
    public @NotNull Vec4i addScalar(@NotNull Integer val) {
        return new Vec4i(x + val, y + val, z + val, w + val);
    }

    @Override
    public @NotNull Vec4i sub(@NotNull Vec4i vec) {
        return new Vec4i(x - vec.x, y - vec.y, z - vec.z, w - vec.w);
    }

    @Override
    public @NotNull Vec4i sub(@NotNull Integer @NotNull ... vecArr) {
        if (vecArr.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        return new Vec4i(x - vecArr[0], y - vecArr[1], z - vecArr[2], w - vecArr[3]);
    }

    @Override
    public @NotNull Vec4i mul(@NotNull Vec4i vec) {
        return new Vec4i(x * vec.x, y * vec.y, z * vec.z, w * vec.w);
    }

    @Override
    public @NotNull Vec4i mul(@NotNull Integer @NotNull ... vecArr) {
        if (vecArr.length != NUM_COMPONENTS) throw new IllegalArgumentException("Invalid number of components");
        return new Vec4i(x * vecArr[0], y * vecArr[1], z * vecArr[2], w * vecArr[3]);
    }

    @Override
    public @NotNull Vec4i mulScalar(@NotNull Integer scale) {
        return new Vec4i(x * scale, y * scale, z * scale, w * scale);
    }

    @Override
    public @NotNull Vec4i div(@NotNull Integer scale) {
        return new Vec4i(x / scale, y / scale, z / scale, w / scale);
    }

    @Override
    public @NotNull Vec4i div(double scale) {
        return new Vec4i((int) (x / scale), (int) (y / scale), (int) (z / scale), (int) (w / scale));
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
    public double distance(@NotNull Vec4i vec) {
        int dx = Math.abs(vec.x - x), dy = Math.abs(vec.y - y), dz = Math.abs(vec.z - z), dw = Math.abs(vec.w - w);
        return Math.sqrt(dx * dx + dy * dy + dz * dz + dw * dw);
    }

    @Override
    public double distanceSquared(@NotNull Vec4i vec) {
        int dx = Math.abs(vec.x - x), dy = Math.abs(vec.y - y), dz = Math.abs(vec.z - z), dw = Math.abs(vec.w - w);
        return (dx * dx) + (dy * dy) + (dz * dz) + (dw * dw);
    }

    @Override
    public @NotNull Vec4i negate() {
        return new Vec4i(-x, -y, -z, -w);
    }

    @Override
    public @NotNull Vec4i min(@NotNull Vec4i vec) {
        int mx = Math.min(vec.x, x), my = Math.min(vec.y, y), mz = Math.min(vec.z, z), mw = Math.min(vec.w, w);
        return new Vec4i(mx, my, mz, mw);
    }

    @Override
    public @NotNull Vec4i max(@NotNull Vec4i vec) {
        int mx = Math.max(vec.x, x), my = Math.max(vec.y, y), mz = Math.max(vec.z, z), mw = Math.max(vec.w, w);
        return new Vec4i(mx, my, mz, mw);
    }

    @Override
    public @NotNull Vec4i minLength(@NotNull Vec4i vec) {
        return (length() < vec.length()) ? this : vec;
    }

    @Override
    public @NotNull Vec4i maxLength(@NotNull Vec4i vec) {
        return (length() > vec.length()) ? this : vec;
    }

    @Override
    public @NotNull Integer minComponent() {
        if (w < x && x < y && y < z) return w;
        if (x < y && y < z) return x;
        return Math.min(y, z);
    }

    @Override
    public @NotNull Integer maxComponent() {
        if (w > x && x > y && y > z) return w;
        if (x > y && y > z) return x;
        return Math.max(y, z);
    }

    @Override
    public @NotNull Vec4i abs() {
        return new Vec4i(Math.abs(x), Math.abs(y), Math.abs(z), Math.abs(w));
    }

    @Override
    public @NotNull Vec4d normalize() {
        return new Vec4d(x, y, z, w).div(length());
    }

    @Override
    public @NotNull Vec4i zero() {
        return ZERO;
    }

    @Override
    public @NotNull Vec4i clone() {
        return new Vec4i(x, y, z, w);
    }
}
