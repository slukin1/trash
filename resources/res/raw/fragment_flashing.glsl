precision highp float;

varying highp vec2 texCoord;
uniform sampler2D iChannel0;
uniform lowp vec3 nextRGB;
uniform lowp vec3 lineRGB;

void main()
{
    lowp vec4 textureColor = texture2D(iChannel0, texCoord);
    gl_FragColor = vec4((lineRGB * textureColor.rgb * max(sign(1.0 - texCoord.y), 0.0)) 
                        + (nextRGB * (1.0 - textureColor.rgb) * max(sign(1.0 - texCoord.y), 0.0)) 
                        + (nextRGB * max(sign(texCoord.y - 1.0), 0.0))
                        , 1.0);
}