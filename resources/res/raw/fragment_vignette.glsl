precision highp float;
uniform mediump sampler2D iChannel0;
uniform float innerRadius;
uniform float outerRadius;
varying vec2 texCoord;
uniform vec3 iResolution;

void main() {
    vec2 coord = texCoord.xy * iResolution.xy;
    vec2 centre = vec2(0.5) * iResolution.xy;
    float ydiff = (centre.y - coord.y);
    float xdiff = (centre.x - coord.x);
// The following TWO distance calculations DO NOT WORK beyond 255.0 on J1 Mini, thereafter giving something odd between 65519.5 and 65520.0
// suggesting OpenGL sqrt() is probably broken just on that (and maybe some other raw devices). So Pythagoras is out.
// The THIRD, TRIG method works fine and has no discernable performance hit.
//    float distance = distance(coord, centre);
//    float distance = sqrt((ydiff * ydiff) + (xdiff * xdiff));
    float distance = abs(ydiff / sin(atan( ydiff / xdiff)));
    if(distance < innerRadius) {
        gl_FragColor = texture2D(iChannel0, texCoord);
    } else {
        float colorMultiplier = 1.0 - ((distance - innerRadius) / (outerRadius - innerRadius));
        gl_FragColor = vec4(vec3(colorMultiplier),1.0) * texture2D(iChannel0, texCoord);
    }
}