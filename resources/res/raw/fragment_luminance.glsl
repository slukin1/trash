precision highp float;

const vec3 W = vec3(0.2125, 0.7154, 0.0721);
uniform sampler2D iChannel0;
varying vec2 texCoord;

void main() {
    vec4 textureColor = texture2D(iChannel0, texCoord);
    float luminance = dot(textureColor.rgb, W);
    gl_FragColor = vec4(vec3(luminance), textureColor.a);
}