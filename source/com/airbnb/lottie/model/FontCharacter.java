package com.airbnb.lottie.model;

import com.airbnb.lottie.model.content.ShapeGroup;
import java.util.List;

public class FontCharacter {
    private final char character;
    private final String fontFamily;
    private final List<ShapeGroup> shapes;
    private final double size;
    private final String style;
    private final double width;

    public FontCharacter(List<ShapeGroup> list, char c11, double d11, double d12, String str, String str2) {
        this.shapes = list;
        this.character = c11;
        this.size = d11;
        this.width = d12;
        this.style = str;
        this.fontFamily = str2;
    }

    public static int hashFor(char c11, String str, String str2) {
        return ((((0 + c11) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public List<ShapeGroup> getShapes() {
        return this.shapes;
    }

    public double getWidth() {
        return this.width;
    }

    public int hashCode() {
        return hashFor(this.character, this.fontFamily, this.style);
    }
}
