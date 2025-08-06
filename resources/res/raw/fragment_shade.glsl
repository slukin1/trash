precision highp float;
uniform sampler2D iChannel0;
uniform sampler2D iChannel1;
uniform vec4 blend;

varying vec2 texCoord;
varying vec2 croppedTexCoord;

void main(void) {

    float step1 = 0.8;
    float step2 = 0.6;
    float step3 = 0.3;
    float step4 = 0.15;
    float alpha = 1.0;

    vec3 shade = vec3(1.0);
    vec4 color = vec4(1.0);

    vec4 texelLines = texture2D(iChannel0, texCoord);
    vec4 texelShade = texture2D(iChannel1, croppedTexCoord );

    float brightness = (0.2126 * texelShade.r) + (0.7152 * texelShade.g) + (0.0722 * texelShade.b);
    float brightest = max(max(texelShade.r, texelShade.g), texelShade.b);
    float dimmest = min(min(texelShade.r, texelShade.g), texelShade.b);
    float delta = brightest - dimmest;

    if (delta > 0.1) {
        texelShade = texelShade * (1.0 / brightest);
    } else {
        texelShade.rgb = vec3(1.0);
    }

    if (brightness < step1) {
        shade = vec3(texelShade.rgb * step1);
    }

    if (brightness < step2) {
        shade = vec3(texelShade.rgb * step2);
    }

    if (brightness < step3) {
        shade = vec3(texelShade.rgb * step3);
    }

    if (brightness < step4) {
        shade = vec3(texelShade.rgb * step4);
    }

    if (texelLines.rgb == vec3(0.0)) {
        color = 1.0 - vec4(mix(shade, blend.rgb, blend.a), 0.0);
    }

    gl_FragColor = color;
}