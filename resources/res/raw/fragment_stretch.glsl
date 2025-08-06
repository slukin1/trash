precision mediump float;

uniform mediump sampler2D iChannel0;
varying vec2 texCoord;
uniform float botAreaYLimit;
uniform float topAreaYLimit;

void main() {

   if (texCoord.y >= topAreaYLimit) {
       vec2 coord = vec2(texCoord.x, topAreaYLimit);
       gl_FragColor = texture2D(iChannel0, coord);
   } else if (texCoord.y <= botAreaYLimit) {
       vec2 coord = vec2(texCoord.x, botAreaYLimit);
       gl_FragColor = texture2D(iChannel0, coord);
   } else {
       gl_FragColor = texture2D(iChannel0, texCoord);
   }
}