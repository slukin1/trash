precision highp float;
uniform sampler2D iChannel0;
varying vec2 texCoord;
uniform vec2 p;
uniform vec2 q;

void main() {
    vec3 col = texture2D(iChannel0, texCoord).rgb;
    float a = abs(((2.0 * texCoord.x) - 1.0) / (2.0 * q.x)) - ((1.0 - (2.0 * p.x) - (2.0 * q.x)) / (2.0 * q.x));
    float b = abs(((2.0 * texCoord.y) - 1.0) / (2.0 * q.y)) - ((1.0 - (2.0 * p.y) - (2.0 * q.y)) / (2.0 * q.y));
    vec3 newcol = mix(col.rgb, vec3(0), clamp(max(a,b), 0.0, 1.0));
    gl_FragColor = vec4(newcol, 1.0);
}