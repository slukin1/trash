precision highp float;

uniform sampler2D iChannel0;
uniform highp float texelWidth;
uniform highp float texelHeight;
uniform mediump float upperThreshold;
uniform mediump float lowerThreshold;
varying highp vec2 texCoord;

void main() {
    vec3 currentGradientAndDirection = texture2D(iChannel0, texCoord).rgb;
    vec2 gradientDirection = ((currentGradientAndDirection.gb * 2.0) - 1.0) * vec2(texelWidth, texelHeight);

    float firstSampledGradientMagnitude = texture2D(iChannel0, texCoord + gradientDirection).r;
    float secondSampledGradientMagnitude = texture2D(iChannel0, texCoord - gradientDirection).r;

    float multiplier = step(firstSampledGradientMagnitude, currentGradientAndDirection.r);
    multiplier = multiplier * step(secondSampledGradientMagnitude, currentGradientAndDirection.r);

    float thresholdCompliance = smoothstep(lowerThreshold, upperThreshold, currentGradientAndDirection.r);
    multiplier = multiplier * thresholdCompliance;

    gl_FragColor = vec4(multiplier, multiplier, multiplier, 1.0);
}
