attribute vec4 vPosition;
attribute vec4 vTexCoord;
uniform mediump float scaleX;
uniform mediump float scaleY;
uniform mediump float offsetX;
uniform mediump float offsetY;

varying vec2 texCoord;
varying vec2 croppedTexCoord;

void main() {
    gl_Position = vPosition;
    texCoord = vTexCoord.xy;
    vec2 newTexCoord = vec2(texCoord.x, texCoord.y);

    newTexCoord.y -= (1.0 - scaleY) * offsetY;

    newTexCoord.x -= (1.0 - scaleX) *  offsetX;

    newTexCoord.x /= scaleX;
    newTexCoord.y /= scaleY;
    croppedTexCoord = newTexCoord;
}