package com.hellfire.net.vec;

import com.hellfire.net.vec.ints.*;
import com.hellfire.net.vec.longs.*;
import com.hellfire.net.vec.floats.*;
import com.hellfire.net.vec.doubles.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IVecTest {

    private static final ThreadLocalRandom rand = ThreadLocalRandom.current();
    private final static Vec2i vec2i = new Vec2i(rand.nextInt(10_000) - 5_000, rand.nextInt(10_000) - 5_000);
    private final static Vec3i vec3i = new Vec3i(rand.nextInt(10_000) - 5_000, rand.nextInt(10_000) - 5_000, rand.nextInt(10_000) - 5_000);
    private final static Vec4i vec4i = new Vec4i(rand.nextInt(10_000) - 5_000, rand.nextInt(10_000) - 5_000, rand.nextInt(10_000) - 5_000, rand.nextInt(10_000) - 5_000);

    private final static Vec2l vec2l = new Vec2l(rand.nextLong(10_000) - 5_000, rand.nextLong(10_000) - 5_000);
    private final static Vec3l vec3l = new Vec3l(rand.nextLong(10_000) - 5_000, rand.nextLong(10_000) - 5_000, rand.nextLong(10_000) - 5_000);
    private final static Vec4l vec4l = new Vec4l(rand.nextLong(10_000) - 5_000, rand.nextLong(10_000) - 5_000, rand.nextLong(10_000) - 5_000, rand.nextLong(10_000) - 5_000);

    private final static Vec2f vec2f = new Vec2f(rand.nextFloat() + rand.nextInt(10_000) - 5_000, rand.nextFloat() + rand.nextInt(10_000) - 5_000);
    private final static Vec3f vec3f = new Vec3f(rand.nextFloat() + rand.nextInt(10_000) - 5_000, rand.nextFloat() + rand.nextInt(10_000) - 5_000, rand.nextFloat() + rand.nextInt(10_000) - 5_000);
    private final static Vec4f vec4f = new Vec4f(rand.nextFloat() + rand.nextInt(10_000) - 5_000, rand.nextFloat() + rand.nextInt(10_000) - 5_000, rand.nextFloat() + rand.nextInt(10_000) - 5_000, rand.nextFloat() + rand.nextInt(10_000) - 5_000);

    private final static Vec2d vec2d = new Vec2d(rand.nextDouble() + rand.nextInt(10_000) - 5_000, rand.nextDouble() + rand.nextInt(10_000) - 5_000);
    private final static Vec3d vec3d = new Vec3d(rand.nextDouble() + rand.nextInt(10_000) - 5_000, rand.nextDouble() + rand.nextInt(10_000) - 5_000, rand.nextDouble() + rand.nextInt(10_000) - 5_000);
    private final static Vec4d vec4d = new Vec4d(rand.nextDouble() + rand.nextInt(10_000) - 5_000, rand.nextDouble() + rand.nextInt(10_000) - 5_000, rand.nextDouble() + rand.nextInt(10_000) - 5_000, rand.nextDouble() + rand.nextInt(10_000) - 5_000);


    @Test
    void testToString() {
        System.out.printf("%s <> %s\n", vec2i.toString(), Arrays.toString(vec2i.getComponents()));
        System.out.printf("%s <> %s\n", vec2l.toString(), Arrays.toString(vec2l.getComponents()));
        System.out.printf("%s <> %s\n", vec2f.toString(), Arrays.toString(vec2f.getComponents()));
        System.out.printf("%s <> %s\n", vec2d.toString(), Arrays.toString(vec2d.getComponents()));

        System.out.printf("%s <> %s\n", vec3i.toString(), Arrays.toString(vec3i.getComponents()));
        System.out.printf("%s <> %s\n", vec3l.toString(), Arrays.toString(vec3l.getComponents()));
        System.out.printf("%s <> %s\n", vec3f.toString(), Arrays.toString(vec3f.getComponents()));
        System.out.printf("%s <> %s\n", vec3d.toString(), Arrays.toString(vec3d.getComponents()));

        System.out.printf("%s <> %s\n", vec4i.toString(), Arrays.toString(vec4i.getComponents()));
        System.out.printf("%s <> %s\n", vec4l.toString(), Arrays.toString(vec4l.getComponents()));
        System.out.printf("%s <> %s\n", vec4f.toString(), Arrays.toString(vec4f.getComponents()));
        System.out.printf("%s <> %s\n", vec4d.toString(), Arrays.toString(vec4d.getComponents()));
        assert true;    // Conor-16.07.2024: This is just to check how the #toString method looks
    }

    @Test
    void testEquals() {
        assert vec2i.equals(vec2i);
        assert vec3i.equals(vec3i);
        assert vec4i.equals(vec4i);
        assert vec2l.equals(vec2l);
        assert vec3l.equals(vec3l);
        assert vec4l.equals(vec4l);
        assert vec2f.equals(vec2f);
        assert vec3f.equals(vec3f);
        assert vec4f.equals(vec4f);
        assert vec2d.equals(vec2d);
        assert vec3d.equals(vec3d);
        assert vec4d.equals(vec4d);

        assert !vec2i.equals(new Vec2i(rand.nextInt(), rand.nextInt()));
        assert !vec3i.equals(new Vec3i(rand.nextInt(), rand.nextInt(), rand.nextInt()));
        assert !vec4i.equals(new Vec4i(rand.nextInt(), rand.nextInt(), rand.nextInt(), rand.nextInt()));
        assert !vec2l.equals(new Vec2l(rand.nextLong(), rand.nextLong()));
        assert !vec3l.equals(new Vec3l(rand.nextLong(), rand.nextLong(), rand.nextLong()));
        assert !vec4l.equals(new Vec4l(rand.nextLong(), rand.nextLong(), rand.nextLong(), rand.nextLong()));
        assert !vec2f.equals(new Vec2f(rand.nextFloat() + rand.nextInt(), rand.nextFloat() + rand.nextInt()));
        assert !vec3f.equals(new Vec3f(rand.nextFloat() + rand.nextInt(), rand.nextFloat() + rand.nextInt(), rand.nextFloat() + rand.nextInt()));
        assert !vec4f.equals(new Vec4f(rand.nextFloat() + rand.nextInt(), rand.nextFloat() + rand.nextInt(), rand.nextFloat() + rand.nextInt(), rand.nextFloat() + rand.nextInt()));
        assert !vec2d.equals(new Vec2d(rand.nextDouble() + rand.nextInt(), rand.nextDouble() + rand.nextInt()));
        assert !vec3d.equals(new Vec3d(rand.nextDouble() + rand.nextInt(), rand.nextDouble() + rand.nextInt(), rand.nextDouble() + rand.nextInt()));
        assert !vec4d.equals(new Vec4d(rand.nextDouble() + rand.nextInt(), rand.nextDouble() + rand.nextInt(), rand.nextDouble() + rand.nextInt(), rand.nextDouble() + rand.nextInt()));
    }

    @Test
    void testHashCode() {
        assert vec2i.hashCode() == vec2i.hashCode();
        assert vec3i.hashCode() == vec3i.hashCode();
        assert vec4i.hashCode() == vec4i.hashCode();
        assert vec2l.hashCode() == vec2l.hashCode();
        assert vec3l.hashCode() == vec3l.hashCode();
        assert vec4l.hashCode() == vec4l.hashCode();
        assert vec2f.hashCode() == vec2f.hashCode();
        assert vec3f.hashCode() == vec3f.hashCode();
        assert vec4f.hashCode() == vec4f.hashCode();
        assert vec2d.hashCode() == vec2d.hashCode();
        assert vec3d.hashCode() == vec3d.hashCode();
        assert vec4d.hashCode() == vec4d.hashCode();

        assert vec2i.hashCode() != new Vec2i(rand.nextInt(), rand.nextInt()).hashCode();
        assert vec3i.hashCode() != new Vec3i(rand.nextInt(), rand.nextInt(), rand.nextInt()).hashCode();
        assert vec4i.hashCode() != new Vec4i(rand.nextInt(), rand.nextInt(), rand.nextInt(), rand.nextInt()).hashCode();
        assert vec2l.hashCode() != new Vec2l(rand.nextLong(), rand.nextLong()).hashCode();
        assert vec3l.hashCode() != new Vec3l(rand.nextLong(), rand.nextLong(), rand.nextLong()).hashCode();
        assert vec4l.hashCode() != new Vec4l(rand.nextLong(), rand.nextLong(), rand.nextLong(), rand.nextLong()).hashCode();
        assert vec2f.hashCode() != new Vec2f(rand.nextFloat() + rand.nextInt(), rand.nextFloat() + rand.nextInt()).hashCode();
        assert vec3f.hashCode() != new Vec3f(rand.nextFloat() + rand.nextInt(), rand.nextFloat() + rand.nextInt(), rand.nextFloat() + rand.nextInt()).hashCode();
        assert vec4f.hashCode() != new Vec4f(rand.nextFloat() + rand.nextInt(), rand.nextFloat() + rand.nextInt(), rand.nextFloat() + rand.nextInt(), rand.nextFloat() + rand.nextInt()).hashCode();
        assert vec2d.hashCode() != new Vec2d(rand.nextDouble() + rand.nextInt(), rand.nextDouble() + rand.nextInt()).hashCode();
        assert vec3d.hashCode() != new Vec3d(rand.nextDouble() + rand.nextInt(), rand.nextDouble() + rand.nextInt(), rand.nextDouble() + rand.nextInt()).hashCode();
        assert vec4d.hashCode() != new Vec4d(rand.nextDouble() + rand.nextInt(), rand.nextDouble() + rand.nextInt(), rand.nextDouble() + rand.nextInt(), rand.nextDouble() + rand.nextInt()).hashCode();
    }

    private static final double EPSILON = 0.000001;   // Allowed deviance

    @Test
    void testNormalize() {
        assert withinBounds(vec2i.normalize().length(), 1, EPSILON);
        assert withinBounds(vec2l.normalize().length(), 1, EPSILON);
        assert withinBounds(vec2f.normalize().length(), 1, EPSILON);
        assert withinBounds(vec2d.normalize().length(), 1, EPSILON);
        assert withinBounds(vec3i.normalize().length(), 1, EPSILON);
        assert withinBounds(vec3l.normalize().length(), 1, EPSILON);
        assert withinBounds(vec3f.normalize().length(), 1, EPSILON);
        assert withinBounds(vec3d.normalize().length(), 1, EPSILON);
        assert withinBounds(vec4i.normalize().length(), 1, EPSILON);
        assert withinBounds(vec4l.normalize().length(), 1, EPSILON);
        assert withinBounds(vec4f.normalize().length(), 1, EPSILON);
        assert withinBounds(vec4d.normalize().length(), 1, EPSILON);
    }

    private static boolean withinBounds(double val, double point, double allowedDeviance) {
        return (point - allowedDeviance) <= val && val <= (point + allowedDeviance);
    }
}