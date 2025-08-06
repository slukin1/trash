precision highp float;

uniform sampler2D iChannel0;
uniform float v;

varying vec2 texCoord;

void main() {
    vec4 sum = vec4( 0.0 );
    
    sum += texture2D( iChannel0, vec2( texCoord.x, texCoord.y - 4.0 * v ) ) * 0.0276305489;
    sum += texture2D( iChannel0, vec2( texCoord.x, texCoord.y - 3.0 * v ) ) * 0.0662822425;
    sum += texture2D( iChannel0, vec2( texCoord.x, texCoord.y - 2.0 * v ) ) * 0.123831533;
    sum += texture2D( iChannel0, vec2( texCoord.x, texCoord.y - 1.0 * v ) ) * 0.180173814;
    sum += texture2D( iChannel0, vec2( texCoord.x, texCoord.y ) ) * 0.204163685;
    sum += texture2D( iChannel0, vec2( texCoord.x, texCoord.y + 1.0 * v ) ) * 0.180173814;
    sum += texture2D( iChannel0, vec2( texCoord.x, texCoord.y + 2.0 * v ) ) * 0.123831533;
    sum += texture2D( iChannel0, vec2( texCoord.x, texCoord.y + 3.0 * v ) ) * 0.0662822425;
    sum += texture2D( iChannel0, vec2( texCoord.x, texCoord.y + 4.0 * v ) ) * 0.0276305489;
    
    gl_FragColor = sum;
}