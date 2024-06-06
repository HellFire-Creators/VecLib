package com.hellfire.net.vec;

import com.hellfire.net.vec.ints.*;
import com.hellfire.net.vec.longs.*;
import com.hellfire.net.vec.floats.*;
import com.hellfire.net.vec.doubles.*;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

class IVecTest {

    private static final ThreadLocalRandom rand = ThreadLocalRandom.current();
    private final static Vec2i vec2i = new Vec2i(rand.nextInt(), rand.nextInt());
    private final static Vec3i vec3i = new Vec3i(rand.nextInt(), rand.nextInt(), rand.nextInt());
    private final static Vec4i vec4i = new Vec4i(rand.nextInt(), rand.nextInt(), rand.nextInt(), rand.nextInt());

    private final static Vec2l vec2l = new Vec2l(rand.nextLong(), rand.nextLong());
    private final static Vec3l vec3l = new Vec3l(rand.nextLong(), rand.nextLong(), rand.nextLong());
    private final static Vec4l vec4l = new Vec4l(rand.nextLong(), rand.nextLong(), rand.nextLong(), rand.nextLong());

    private final static Vec2f vec2f = new Vec2f(rand.nextFloat() + rand.nextInt(), rand.nextFloat() + rand.nextInt());
    private final static Vec3f vec3f = new Vec3f(rand.nextFloat() + rand.nextInt(), rand.nextFloat() + rand.nextInt(), rand.nextFloat() + rand.nextInt());
    private final static Vec4f vec4f = new Vec4f(rand.nextFloat() + rand.nextInt(), rand.nextFloat() + rand.nextInt(), rand.nextFloat() + rand.nextInt(), rand.nextFloat() + rand.nextInt());

    private final static Vec2d vec2d = new Vec2d(rand.nextDouble() + rand.nextInt(), rand.nextDouble() + rand.nextInt());
    private final static Vec3d vec3d = new Vec3d(rand.nextDouble() + rand.nextInt(), rand.nextDouble() + rand.nextInt(), rand.nextDouble() + rand.nextInt());
    private final static Vec4d vec4d = new Vec4d(rand.nextDouble() + rand.nextInt(), rand.nextDouble() + rand.nextInt(), rand.nextDouble() + rand.nextInt(), rand.nextDouble() + rand.nextInt());


    @Test
    void testToString() {
        assert vec2i.toString().equals("Vec2i{x=" + vec2i.x + ", y=" + vec2i.y + "}");
        assert vec2l.toString().equals("Vec2l{x=" + vec2l.x + ", y=" + vec2l.y + "}");
        assert vec2f.toString().equals("Vec2f{x=" + vec2f.x + ", y=" + vec2f.y + "}");
        assert vec2d.toString().equals("Vec2d{x=" + vec2d.x + ", y=" + vec2d.y + "}");

        assert vec3i.toString().equals("Vec3i{x=" + vec3i.x + ", y=" + vec3i.y + ", z=" + vec3i.z + "}");
        assert vec3l.toString().equals("Vec3l{x=" + vec3l.x + ", y=" + vec3l.y + ", z=" + vec3l.z + "}");
        assert vec3f.toString().equals("Vec3f{x=" + vec3f.x + ", y=" + vec3f.y + ", z=" + vec3f.z + "}");
        assert vec3d.toString().equals("Vec3d{x=" + vec3d.x + ", y=" + vec3d.y + ", z=" + vec3d.z + "}");

        assert vec4i.toString().equals("Vec4i{x=" + vec4i.x + ", y=" + vec4i.y + ", z=" + vec4i.z + ", w=" + vec4i.w + "}");
        assert vec4l.toString().equals("Vec4l{x=" + vec4l.x + ", y=" + vec4l.y + ", z=" + vec4l.z + ", w=" + vec4l.w + "}");
        assert vec4f.toString().equals("Vec4f{x=" + vec4f.x + ", y=" + vec4f.y + ", z=" + vec4f.z + ", w=" + vec4f.w + "}");
        assert vec4d.toString().equals("Vec4d{x=" + vec4d.x + ", y=" + vec4d.y + ", z=" + vec4d.z + ", w=" + vec4d.w + "}");
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

    @Test
    void testNormalize() {
        assert vec2i.normalize().length() == 1;
        assert vec2l.normalize().length() == 1;
        assert vec2f.normalize().length() == 1;
        assert vec2d.normalize().length() == 1;
        assert vec3i.normalize().length() == 1;
        assert vec3l.normalize().length() == 1;
        assert vec3f.normalize().length() == 1;
        assert vec3d.normalize().length() == 1;
        assert vec4i.normalize().length() == 1;
        assert vec4l.normalize().length() == 1;
        assert vec4f.normalize().length() == 1;
        assert vec4d.normalize().length() == 1;
    }
}