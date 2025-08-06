precision highp float;

uniform sampler2D iChannel0;
uniform float h;

varying vec2 texCoord;

void main() {
    
    vec4 sum = vec4( 0.0 );
    
    sum += texture2D( iChannel0, vec2( texCoord.x - 4.0 * h, texCoord.y ) ) * 0.0276305489;
    sum += texture2D( iChannel0, vec2( texCoord.x - 3.0 * h, texCoord.y ) ) * 0.0662822425;
    sum += texture2D( iChannel0, vec2( texCoord.x - 2.0 * h, texCoord.y ) ) * 0.123831533;
    sum += texture2D( iChannel0, vec2( texCoord.x - 1.0 * h, texCoord.y ) ) * 0.180173814;
    sum += texture2D( iChannel0, vec2( texCoord.x, texCoord.y ) ) * 0.204163685;
    sum += texture2D( iChannel0, vec2( texCoord.x + 1.0 * h, texCoord.y ) ) * 0.180173814;
    sum += texture2D( iChannel0, vec2( texCoord.x + 2.0 * h, texCoord.y ) ) * 0.123831533;
    sum += texture2D( iChannel0, vec2( texCoord.x + 3.0 * h, texCoord.y ) ) * 0.0662822425;
    sum += texture2D( iChannel0, vec2( texCoord.x + 4.0 * h, texCoord.y ) ) * 0.0276305489;
    
    gl_FragColor = sum;
}