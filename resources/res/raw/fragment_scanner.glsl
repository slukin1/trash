precision highp float;
uniform sampler2D iChannel0;
varying vec2 texCoord;
uniform float y;

void main() {
    float colorAdd = step(0.995, 1. - abs(texCoord.y - y));
    gl_FragColor = vec4(texture2D(iChannel0, texCoord).rgb + colorAdd, 1.);
}