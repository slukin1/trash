precision highp float;

uniform mediump sampler2D iChannel0;
varying vec2 texCoord;
uniform vec2 topAreaTL;
uniform vec2 topAreaBR;
uniform float topAreaYLimit;
uniform vec2 botAreaTL;
uniform vec2 botAreaBR;
uniform float botAreaYLimit;


vec2 getBroadcastCoordinateTop(vec2 coord) {
   float yVal = coord.y - topAreaYLimit;
   float yDiff = 1.0 - topAreaYLimit;
   float yNormed = yVal / yDiff;
   float areaHeight = topAreaTL.y - topAreaBR.y;
   float areaWidth = topAreaBR.x - topAreaTL.x;
   float offsetY = areaHeight * yNormed;
   float offsetX = areaWidth * coord.x;

   return vec2(topAreaTL.x + offsetX, topAreaBR.y + offsetY);
}

vec2 getBroadcastCoordinateBot(vec2 coord) {
   float yNormed = coord.y / botAreaYLimit;
   float areaHeight = botAreaTL.y - botAreaBR.y;
   float areaWidth = botAreaBR.x - botAreaTL.x;
   float offsetY = areaHeight * yNormed;
   float offsetX = areaWidth * coord.x;

   return vec2(botAreaTL.x + offsetX, botAreaBR.y + offsetY);
}

void main() {
   if (texCoord.y >= topAreaYLimit) { 
       gl_FragColor = texture2D(iChannel0, getBroadcastCoordinateTop(texCoord));
   } else if (texCoord.y <= botAreaYLimit){
       gl_FragColor = texture2D(iChannel0, getBroadcastCoordinateBot(texCoord));
   } else {
       gl_FragColor = texture2D(iChannel0, texCoord);
   }
}