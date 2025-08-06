precision highp float;
varying vec2 texCoord;
uniform sampler2D iChannel0;
uniform vec3 iResolution;
uniform float iGlobalTime;
uniform int totalPoints;
uniform float animationProgress;
uniform float animationDuration;
uniform float innerHovalBlurFactor;
uniform float hovalWidthScale;
uniform float screenAR;
const vec2 topLeft = vec2(0.0,1.0);
const vec2 bottomLeft = vec2(0.0,0.0);
const vec2 topRight = vec2(1.0,1.0);
const vec2 bottomRight = vec2(1.0,0.0);
const vec2 htp1 = vec2(0.5,1.0);
const vec2 htp2 = vec2(0.087,1.0);
const vec2 htp3 = vec2(0.0,0.7925);
const vec2 htp4hbp1 = vec2(0.0, 0.525);
const vec2 hbp2 = vec2(0.0,0.2575);
const vec2 hbp3 = vec2(0.18,0.0);
const vec2 hbp4 = vec2(0.5,0.0);
const float imageArPortrait = 3.0 / 4.0;
const float hovalAR = 3.0 / 4.0;
const float imageArLandscape = 4.0 / 3.0;
uniform float ht_x[99];
uniform float ht_y[99];
uniform float hb_x[99];
uniform float hb_y[99];


vec4 applyBlur(vec2 uv, float normFactor){
    float Pi = 6.28318530718; // Pi*2

    float Directions = 16.0; // BLUR DIRECTIONS (Default 16.0 - More is better but slower)
    float Quality = 4.0; // BLUR QUALITY (Default 4.0 - More is better but slower)

    vec2 Radius = vec2(0.02 * normFactor);

    // Pixel colour
    vec4 Color = texture2D(iChannel0, uv);

    // Blur calculations
    for( float d=0.0; d<Pi; d+=Pi/Directions)
    {
        vec2 offset = vec2(cos(d),sin(d))*Radius;
        for(float i=1.0/Quality; i<=1.0; i+=1.0/Quality)
        {
            Color += texture2D( iChannel0, uv+ offset *i);
        }
    }

    // Output to screen
    Color /= Quality * Directions;
    return Color;
}

bool isInRect(vec2 coord, vec2 bottomLeft, vec2 topRight) {
    bvec2 botL = lessThan(coord, bottomLeft);
    bvec2 topR = greaterThan(coord, topRight);

    if(botL.x || botL.y || topR.x || topR.y)
    return false;
    else
    return true;
}


float getHTXVal(int position, bool is_right) {
    if(is_right)
    return 1.0 - ht_x[position];
    else
    return ht_x[position];
}

float getHBXVal(int position, bool is_right) {
    if(is_right)
    return 1.0 - hb_x[position];
    else
    return hb_x[position];
}

float getXVal(int position, bool is_top, bool is_right) {
    if(is_top)
    return getHTXVal(position, is_right);
    else
    return getHBXVal(position, is_right);
}

float getYVal(int position, bool is_top) {
    if(is_top)
    return ht_y[position];
    else
    return hb_y[position];
}

vec2 getPointFirstXHigh(vec2 value, bool is_top, bool is_right) {
    int start = 0;
    int end = totalPoints-1;
    int pos = 0;
    float x_val = 0.0;

    while(start <= end) {
        pos = (start + end) / 2;
        x_val = getXVal(pos, is_top, is_right);
        if(x_val > value.x) {
            start = pos + 1;
        } else if (x_val < value.x) {
            end = pos -1;
        } else
        break;
    }

    return vec2(x_val, getYVal(pos, is_top));
}

vec2 getPointFirstXLow(vec2 value, bool is_top, bool is_right) {
    int start = 0;
    int end = totalPoints-1;
    int pos = 0;
    float x_val = 0.0;

    while(start <= end) {
        pos = (start + end) / 2;
        x_val = getXVal(pos, is_top, is_right);
        if(x_val < value.x) {
            start = pos + 1;
        } else if (x_val > value.x) {
            end = pos -1;
        } else
        break;
    }

    return vec2(x_val, getYVal(pos, is_top));
}

vec2 getCurvePointForHTL(vec2 value) {
    return getPointFirstXHigh(value, true, false);
}
vec2 getCurvePointForHTR(vec2 value) {
    return getPointFirstXLow(value, true, true);
}
vec2 getCurvePointForHBL(vec2 value) {
    return getPointFirstXLow(value, false, false);
}
vec2 getCurvePointForHBR(vec2 value) {
    return getPointFirstXHigh(value, false, true);
}

bool hasToBlurHTL(vec2 coord){
    vec2 aux = getCurvePointForHTL(coord);
    return coord.y >= aux.y;
}

bool hasToBlurHTR(vec2 coord){
    vec2 aux = getCurvePointForHTR(coord);
    return coord.y >= aux.y;
}

bool hasToBlurHBL(vec2 coord){
    vec2 aux = getCurvePointForHBL(coord);
    return coord.y <= aux.y;
}

bool hasToBlurHBR(vec2 coord){
    vec2 aux = getCurvePointForHBR(coord);
    return coord.y <= aux.y;
}

bool isOutsideHoval(vec2 coord) {

    if(coord.x <= htp1.x) {
        if (coord.y <= htp4hbp1.y)
        return hasToBlurHBL(coord);
        else
        return hasToBlurHTL(coord);
    } else {
        if (coord.y <= htp4hbp1.y)
        return hasToBlurHBR(coord);
        else
        return hasToBlurHTR(coord);
    }
}

vec2 normToHoval(vec2 coord, vec2 hovalSize, vec2 offset) {
    vec2 screenPoint = coord * iResolution.xy;
    vec2 screenOffset = offset * iResolution.xy;

    vec2 aux = screenPoint - screenOffset;

    return aux / hovalSize;
}

bool isInHoval(vec2 coord, float hovalScaleFactor) {
    float hovalW;
    float hovalH;

    if(screenAR <= 1.0) { // Device is portrait
        hovalW = iResolution.x * hovalScaleFactor;
        hovalH = hovalW / hovalAR;
    } else { // Device is landscape
        hovalH = iResolution.y * hovalScaleFactor;
        hovalW = hovalH * hovalAR;
    }

    float heightOffset = ((iResolution.y / 2.0) - (hovalH / 2.0)) / iResolution.y;
    float widthOffset = ((iResolution.x / 2.0) - (hovalW / 2.0)) / iResolution.x;
    vec2 offset = vec2(widthOffset, heightOffset);

    vec2 uv = normToHoval(coord, vec2(hovalW, hovalH), offset);
    bool inR = isInRect(uv, bottomLeft, topRight);

    if (inR) {
        return !isOutsideHoval(uv);
    } else {
        return false;
    }
}

bool isInImage(vec2 coord) {

    float imageW;
    float imageH;
    float widthOffset = 0.0;
    float heightOffset = 0.0;

    if(screenAR <= 1.0) {
        imageW = iResolution.x;
        imageH = imageW / imageArPortrait;

        heightOffset = ((iResolution.y / 2.0) - (imageH / 2.0)) / iResolution.y;
    } else {
        imageH = iResolution.y;
        imageW = imageH * imageArLandscape;

        widthOffset = ((iResolution.x / 2.0) - (imageW / 2.0)) / iResolution.x;
    }

    vec2 offset = vec2(widthOffset,heightOffset);
    vec2 uv = normToHoval(coord, vec2(imageW, imageH), offset);

    return isInRect(uv,bottomLeft, topRight);
}

void main()
{
    if(isInImage(texCoord)) {
        float animationOffset = 0.0;
        float innerBlurRatio = 0.0;
        float hovalRelativeWidth = hovalWidthScale;

        if(animationProgress > 0.0)
        animationOffset = min(animationProgress, 0.5);

        bool insideHoval = isInHoval(texCoord, hovalRelativeWidth + animationOffset);
        if (insideHoval) {
            if(innerHovalBlurFactor == 0.0)
            gl_FragColor = texture2D(iChannel0, texCoord);
            else
            gl_FragColor = applyBlur(texCoord, innerHovalBlurFactor);
        } else {
            gl_FragColor = applyBlur(texCoord, 1.0);
        }
    } else {
        gl_FragColor = applyBlur(texCoord, 1.0);
    }
}