precision highp float;

uniform sampler2D iChannel0;
uniform vec2 uWindow;
uniform float threshold;
varying vec2 texCoord;

void main() {

    vec2 offset = threshold / uWindow;

    float bottomLeftIntensity = texture2D(iChannel0, texCoord + vec2(-offset.x, offset.y)).r;
    float topRightIntensity = texture2D(iChannel0, texCoord + vec2(offset.x, -offset.y)).r;
    float topLeftIntensity = texture2D(iChannel0, texCoord + vec2(-offset.x, -offset.y)).r;
    float bottomRightIntensity = texture2D(iChannel0, texCoord + vec2(offset.x, offset.y)).r;
    float leftIntensity = texture2D(iChannel0, texCoord + vec2(-offset.x, 0.0)).r;
    float rightIntensity = texture2D(iChannel0, texCoord + vec2(offset.x, 0.0)).r;
    float bottomIntensity = texture2D(iChannel0, texCoord + vec2(0.0, offset.y)).r;
    float topIntensity = texture2D(iChannel0, texCoord + vec2(0.0, -offset.y)).r;
    float centerIntensity = texture2D(iChannel0, texCoord).r;

    float pixelIntensitySum = bottomLeftIntensity + topRightIntensity + topLeftIntensity + bottomRightIntensity + leftIntensity + rightIntensity + bottomIntensity + topIntensity + centerIntensity;
    float sumTest = step(1.5, pixelIntensitySum);
    float pixelTest = step(0.01, centerIntensity);

    gl_FragColor = vec4(vec3(sumTest * pixelTest, sumTest * pixelTest, sumTest * pixelTest), 1.0);
}