package edu.kfupm.ics321.model;

import java.util.*;
import java.util.Set;
import javax.persistence.*;

@Embeddable
public class Dimensions {
    private float width;
    private float height;
    private float depth;

    public Dimensions() {
        this(0.0f);
    }

    public Dimensions(float side) {
        this(side, side, side);
    }

    public Dimensions(float width, float height, float depth) {
        setWidth(width);
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = Math.max(0.0f, width);
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = Math.max(0.0f, height);
    }

    public float getDepth() {
        return depth;
    }

    public void setDepth(float depth) {
        this.depth = Math.max(0.0f, depth);
    }

    public float getVolume() {
        return width * height * depth;
    }

    public float getVolumetricWeight() {
        return getVolume() / 5.0f;
    }
}
