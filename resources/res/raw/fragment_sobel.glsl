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

    vec2 gradientDirection;
    gradientDirection.x = -bottomLeftIntensity - 2.0 * leftIntensity - topLeftIntensity + bottomRightIntensity + 2.0 * rightIntensity + topRightIntensity;
    gradientDirection.y = -topLeftIntensity - 2.0 * topIntensity - topRightIntensity + bottomLeftIntensity + 2.0 * bottomIntensity + bottomRightIntensity;

    float gradientMagnitude = length(gradientDirection);
    vec2 normalizedDirection = normalize(gradientDirection);

    normalizedDirection = sign(normalizedDirection) * floor(abs(normalizedDirection) + 0.617316);
    normalizedDirection = (normalizedDirection + 1.0) * 0.5;

    gl_FragColor = vec4(gradientMagnitude, normalizedDirection.x, normalizedDirection.y, 1.0);
}