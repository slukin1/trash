precision mediump float;

uniform mediump sampler2D iChannel0;
varying mediump vec2 texCoord;
varying mediump vec2 croppedTexCoord;

void main(){
    if (croppedTexCoord.x > 1.0 || croppedTexCoord.y > 1.0 || croppedTexCoord.x < 0.0 || croppedTexCoord.y < 0.0) gl_FragColor = vec4(1,0,0,1);
    else gl_FragColor = texture2D(iChannel0, croppedTexCoord);
}