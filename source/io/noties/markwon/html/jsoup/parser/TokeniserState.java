package io.noties.markwon.html.jsoup.parser;

import io.noties.markwon.html.jsoup.parser.Token;

enum TokeniserState {
    Data {
        public void read(c cVar, a aVar) {
            char q11 = aVar.q();
            if (q11 == 0) {
                cVar.q(this);
                cVar.i(aVar.d());
            } else if (q11 == '&') {
                cVar.a(TokeniserState.CharacterReferenceInData);
            } else if (q11 == '<') {
                cVar.a(TokeniserState.TagOpen);
            } else if (q11 != 65535) {
                cVar.k(aVar.e());
            } else {
                cVar.j(new Token.e());
            }
        }
    },
    CharacterReferenceInData {
        public void read(c cVar, a aVar) {
            TokeniserState.readCharRef(cVar, TokeniserState.Data);
        }
    },
    Rcdata {
        public void read(c cVar, a aVar) {
            char q11 = aVar.q();
            if (q11 == 0) {
                cVar.q(this);
                aVar.a();
                cVar.i(65533);
            } else if (q11 == '&') {
                cVar.a(TokeniserState.CharacterReferenceInRcdata);
            } else if (q11 == '<') {
                cVar.a(TokeniserState.RcdataLessthanSign);
            } else if (q11 != 65535) {
                cVar.k(aVar.m('&', '<', 0));
            } else {
                cVar.j(new Token.e());
            }
        }
    },
    CharacterReferenceInRcdata {
        public void read(c cVar, a aVar) {
            TokeniserState.readCharRef(cVar, TokeniserState.Rcdata);
        }
    },
    Rawtext {
        public void read(c cVar, a aVar) {
            TokeniserState.readData(cVar, aVar, this, TokeniserState.RawtextLessthanSign);
        }
    },
    ScriptData {
        public void read(c cVar, a aVar) {
            TokeniserState.readData(cVar, aVar, this, TokeniserState.ScriptDataLessthanSign);
        }
    },
    PLAINTEXT {
        public void read(c cVar, a aVar) {
            char q11 = aVar.q();
            if (q11 == 0) {
                cVar.q(this);
                aVar.a();
                cVar.i(65533);
            } else if (q11 != 65535) {
                cVar.k(aVar.k(0));
            } else {
                cVar.j(new Token.e());
            }
        }
    },
    TagOpen {
        public void read(c cVar, a aVar) {
            char q11 = aVar.q();
            if (q11 == '!') {
                cVar.a(TokeniserState.MarkupDeclarationOpen);
            } else if (q11 == '/') {
                cVar.a(TokeniserState.EndTagOpen);
            } else if (q11 == '?') {
                cVar.a(TokeniserState.BogusComment);
            } else if (aVar.C()) {
                cVar.g(true);
                cVar.u(TokeniserState.TagName);
            } else {
                cVar.q(this);
                cVar.i('<');
                cVar.u(TokeniserState.Data);
            }
        }
    },
    EndTagOpen {
        public void read(c cVar, a aVar) {
            if (aVar.r()) {
                cVar.p(this);
                cVar.k("</");
                cVar.u(TokeniserState.Data);
            } else if (aVar.C()) {
                cVar.g(false);
                cVar.u(TokeniserState.TagName);
            } else if (aVar.w('>')) {
                cVar.q(this);
                cVar.a(TokeniserState.Data);
            } else {
                cVar.q(this);
                cVar.a(TokeniserState.BogusComment);
            }
        }
    },
    TagName {
        public void read(c cVar, a aVar) {
            cVar.f55389i.i(aVar.j());
            char d11 = aVar.d();
            if (d11 != 0) {
                if (d11 != ' ') {
                    if (d11 == '/') {
                        cVar.u(TokeniserState.SelfClosingStartTag);
                        return;
                    } else if (d11 == '>') {
                        cVar.o();
                        cVar.u(TokeniserState.Data);
                        return;
                    } else if (d11 == 65535) {
                        cVar.p(this);
                        cVar.u(TokeniserState.Data);
                        return;
                    } else if (!(d11 == 9 || d11 == 10 || d11 == 12 || d11 == 13)) {
                        cVar.f55389i.h(d11);
                        return;
                    }
                }
                cVar.u(TokeniserState.BeforeAttributeName);
                return;
            }
            cVar.f55389i.i(TokeniserState.replacementStr);
        }
    },
    RcdataLessthanSign {
        public void read(c cVar, a aVar) {
            if (aVar.w('/')) {
                cVar.h();
                cVar.a(TokeniserState.RCDATAEndTagOpen);
                return;
            }
            if (aVar.C() && cVar.b() != null) {
                if (!aVar.p("</" + cVar.b())) {
                    cVar.f55389i = cVar.g(false).l(cVar.b());
                    cVar.o();
                    aVar.I();
                    cVar.u(TokeniserState.Data);
                    return;
                }
            }
            cVar.k("<");
            cVar.u(TokeniserState.Rcdata);
        }
    },
    RCDATAEndTagOpen {
        public void read(c cVar, a aVar) {
            if (aVar.C()) {
                cVar.g(false);
                cVar.f55389i.h(aVar.q());
                cVar.f55388h.append(aVar.q());
                cVar.a(TokeniserState.RCDATAEndTagName);
                return;
            }
            cVar.k("</");
            cVar.u(TokeniserState.Rcdata);
        }
    },
    RCDATAEndTagName {
        private void anythingElse(c cVar, a aVar) {
            cVar.k("</" + cVar.f55388h.toString());
            aVar.I();
            cVar.u(TokeniserState.Rcdata);
        }

        public void read(c cVar, a aVar) {
            if (aVar.C()) {
                String h11 = aVar.h();
                cVar.f55389i.i(h11);
                cVar.f55388h.append(h11);
                return;
            }
            char d11 = aVar.d();
            if (d11 == 9 || d11 == 10 || d11 == 12 || d11 == 13 || d11 == ' ') {
                if (cVar.s()) {
                    cVar.u(TokeniserState.BeforeAttributeName);
                } else {
                    anythingElse(cVar, aVar);
                }
            } else if (d11 != '/') {
                if (d11 != '>') {
                    anythingElse(cVar, aVar);
                } else if (cVar.s()) {
                    cVar.o();
                    cVar.u(TokeniserState.Data);
                } else {
                    anythingElse(cVar, aVar);
                }
            } else if (cVar.s()) {
                cVar.u(TokeniserState.SelfClosingStartTag);
            } else {
                anythingElse(cVar, aVar);
            }
        }
    },
    RawtextLessthanSign {
        public void read(c cVar, a aVar) {
            if (aVar.w('/')) {
                cVar.h();
                cVar.a(TokeniserState.RawtextEndTagOpen);
                return;
            }
            cVar.i('<');
            cVar.u(TokeniserState.Rawtext);
        }
    },
    RawtextEndTagOpen {
        public void read(c cVar, a aVar) {
            TokeniserState.readEndTag(cVar, aVar, TokeniserState.RawtextEndTagName, TokeniserState.Rawtext);
        }
    },
    RawtextEndTagName {
        public void read(c cVar, a aVar) {
            TokeniserState.handleDataEndTag(cVar, aVar, TokeniserState.Rawtext);
        }
    },
    ScriptDataLessthanSign {
        public void read(c cVar, a aVar) {
            char d11 = aVar.d();
            if (d11 == '!') {
                cVar.k("<!");
                cVar.u(TokeniserState.ScriptDataEscapeStart);
            } else if (d11 != '/') {
                cVar.k("<");
                aVar.I();
                cVar.u(TokeniserState.ScriptData);
            } else {
                cVar.h();
                cVar.u(TokeniserState.ScriptDataEndTagOpen);
            }
        }
    },
    ScriptDataEndTagOpen {
        public void read(c cVar, a aVar) {
            TokeniserState.readEndTag(cVar, aVar, TokeniserState.ScriptDataEndTagName, TokeniserState.ScriptData);
        }
    },
    ScriptDataEndTagName {
        public void read(c cVar, a aVar) {
            TokeniserState.handleDataEndTag(cVar, aVar, TokeniserState.ScriptData);
        }
    },
    ScriptDataEscapeStart {
        public void read(c cVar, a aVar) {
            if (aVar.w('-')) {
                cVar.i('-');
                cVar.a(TokeniserState.ScriptDataEscapeStartDash);
                return;
            }
            cVar.u(TokeniserState.ScriptData);
        }
    },
    ScriptDataEscapeStartDash {
        public void read(c cVar, a aVar) {
            if (aVar.w('-')) {
                cVar.i('-');
                cVar.a(TokeniserState.ScriptDataEscapedDashDash);
                return;
            }
            cVar.u(TokeniserState.ScriptData);
        }
    },
    ScriptDataEscaped {
        public void read(c cVar, a aVar) {
            if (aVar.r()) {
                cVar.p(this);
                cVar.u(TokeniserState.Data);
                return;
            }
            char q11 = aVar.q();
            if (q11 == 0) {
                cVar.q(this);
                aVar.a();
                cVar.i(65533);
            } else if (q11 == '-') {
                cVar.i('-');
                cVar.a(TokeniserState.ScriptDataEscapedDash);
            } else if (q11 != '<') {
                cVar.k(aVar.m('-', '<', 0));
            } else {
                cVar.a(TokeniserState.ScriptDataEscapedLessthanSign);
            }
        }
    },
    ScriptDataEscapedDash {
        public void read(c cVar, a aVar) {
            if (aVar.r()) {
                cVar.p(this);
                cVar.u(TokeniserState.Data);
                return;
            }
            char d11 = aVar.d();
            if (d11 == 0) {
                cVar.q(this);
                cVar.i(65533);
                cVar.u(TokeniserState.ScriptDataEscaped);
            } else if (d11 == '-') {
                cVar.i(d11);
                cVar.u(TokeniserState.ScriptDataEscapedDashDash);
            } else if (d11 != '<') {
                cVar.i(d11);
                cVar.u(TokeniserState.ScriptDataEscaped);
            } else {
                cVar.u(TokeniserState.ScriptDataEscapedLessthanSign);
            }
        }
    },
    ScriptDataEscapedDashDash {
        public void read(c cVar, a aVar) {
            if (aVar.r()) {
                cVar.p(this);
                cVar.u(TokeniserState.Data);
                return;
            }
            char d11 = aVar.d();
            if (d11 == 0) {
                cVar.q(this);
                cVar.i(65533);
                cVar.u(TokeniserState.ScriptDataEscaped);
            } else if (d11 == '-') {
                cVar.i(d11);
            } else if (d11 == '<') {
                cVar.u(TokeniserState.ScriptDataEscapedLessthanSign);
            } else if (d11 != '>') {
                cVar.i(d11);
                cVar.u(TokeniserState.ScriptDataEscaped);
            } else {
                cVar.i(d11);
                cVar.u(TokeniserState.ScriptData);
            }
        }
    },
    ScriptDataEscapedLessthanSign {
        public void read(c cVar, a aVar) {
            if (aVar.C()) {
                cVar.h();
                cVar.f55388h.append(aVar.q());
                cVar.k("<" + aVar.q());
                cVar.a(TokeniserState.ScriptDataDoubleEscapeStart);
            } else if (aVar.w('/')) {
                cVar.h();
                cVar.a(TokeniserState.ScriptDataEscapedEndTagOpen);
            } else {
                cVar.i('<');
                cVar.u(TokeniserState.ScriptDataEscaped);
            }
        }
    },
    ScriptDataEscapedEndTagOpen {
        public void read(c cVar, a aVar) {
            if (aVar.C()) {
                cVar.g(false);
                cVar.f55389i.h(aVar.q());
                cVar.f55388h.append(aVar.q());
                cVar.a(TokeniserState.ScriptDataEscapedEndTagName);
                return;
            }
            cVar.k("</");
            cVar.u(TokeniserState.ScriptDataEscaped);
        }
    },
    ScriptDataEscapedEndTagName {
        public void read(c cVar, a aVar) {
            TokeniserState.handleDataEndTag(cVar, aVar, TokeniserState.ScriptDataEscaped);
        }
    },
    ScriptDataDoubleEscapeStart {
        public void read(c cVar, a aVar) {
            TokeniserState.handleDataDoubleEscapeTag(cVar, aVar, TokeniserState.ScriptDataDoubleEscaped, TokeniserState.ScriptDataEscaped);
        }
    },
    ScriptDataDoubleEscaped {
        public void read(c cVar, a aVar) {
            char q11 = aVar.q();
            if (q11 == 0) {
                cVar.q(this);
                aVar.a();
                cVar.i(65533);
            } else if (q11 == '-') {
                cVar.i(q11);
                cVar.a(TokeniserState.ScriptDataDoubleEscapedDash);
            } else if (q11 == '<') {
                cVar.i(q11);
                cVar.a(TokeniserState.ScriptDataDoubleEscapedLessthanSign);
            } else if (q11 != 65535) {
                cVar.k(aVar.m('-', '<', 0));
            } else {
                cVar.p(this);
                cVar.u(TokeniserState.Data);
            }
        }
    },
    ScriptDataDoubleEscapedDash {
        public void read(c cVar, a aVar) {
            char d11 = aVar.d();
            if (d11 == 0) {
                cVar.q(this);
                cVar.i(65533);
                cVar.u(TokeniserState.ScriptDataDoubleEscaped);
            } else if (d11 == '-') {
                cVar.i(d11);
                cVar.u(TokeniserState.ScriptDataDoubleEscapedDashDash);
            } else if (d11 == '<') {
                cVar.i(d11);
                cVar.u(TokeniserState.ScriptDataDoubleEscapedLessthanSign);
            } else if (d11 != 65535) {
                cVar.i(d11);
                cVar.u(TokeniserState.ScriptDataDoubleEscaped);
            } else {
                cVar.p(this);
                cVar.u(TokeniserState.Data);
            }
        }
    },
    ScriptDataDoubleEscapedDashDash {
        public void read(c cVar, a aVar) {
            char d11 = aVar.d();
            if (d11 == 0) {
                cVar.q(this);
                cVar.i(65533);
                cVar.u(TokeniserState.ScriptDataDoubleEscaped);
            } else if (d11 == '-') {
                cVar.i(d11);
            } else if (d11 == '<') {
                cVar.i(d11);
                cVar.u(TokeniserState.ScriptDataDoubleEscapedLessthanSign);
            } else if (d11 == '>') {
                cVar.i(d11);
                cVar.u(TokeniserState.ScriptData);
            } else if (d11 != 65535) {
                cVar.i(d11);
                cVar.u(TokeniserState.ScriptDataDoubleEscaped);
            } else {
                cVar.p(this);
                cVar.u(TokeniserState.Data);
            }
        }
    },
    ScriptDataDoubleEscapedLessthanSign {
        public void read(c cVar, a aVar) {
            if (aVar.w('/')) {
                cVar.i('/');
                cVar.h();
                cVar.a(TokeniserState.ScriptDataDoubleEscapeEnd);
                return;
            }
            cVar.u(TokeniserState.ScriptDataDoubleEscaped);
        }
    },
    ScriptDataDoubleEscapeEnd {
        public void read(c cVar, a aVar) {
            TokeniserState.handleDataDoubleEscapeTag(cVar, aVar, TokeniserState.ScriptDataEscaped, TokeniserState.ScriptDataDoubleEscaped);
        }
    },
    BeforeAttributeName {
        public void read(c cVar, a aVar) {
            char d11 = aVar.d();
            if (d11 == 0) {
                cVar.q(this);
                cVar.f55389i.n();
                aVar.I();
                cVar.u(TokeniserState.AttributeName);
            } else if (d11 != ' ') {
                if (!(d11 == '\"' || d11 == '\'')) {
                    if (d11 == '/') {
                        cVar.u(TokeniserState.SelfClosingStartTag);
                        return;
                    } else if (d11 == 65535) {
                        cVar.p(this);
                        cVar.u(TokeniserState.Data);
                        return;
                    } else if (d11 != 9 && d11 != 10 && d11 != 12 && d11 != 13) {
                        switch (d11) {
                            case '<':
                            case '=':
                                break;
                            case '>':
                                cVar.o();
                                cVar.u(TokeniserState.Data);
                                return;
                            default:
                                cVar.f55389i.n();
                                aVar.I();
                                cVar.u(TokeniserState.AttributeName);
                                return;
                        }
                    } else {
                        return;
                    }
                }
                cVar.q(this);
                cVar.f55389i.n();
                cVar.f55389i.c(d11);
                cVar.u(TokeniserState.AttributeName);
            }
        }
    },
    AttributeName {
        public void read(c cVar, a aVar) {
            cVar.f55389i.d(aVar.n(TokeniserState.attributeNameCharsSorted));
            char d11 = aVar.d();
            if (d11 != 0) {
                if (d11 != ' ') {
                    if (!(d11 == '\"' || d11 == '\'')) {
                        if (d11 == '/') {
                            cVar.u(TokeniserState.SelfClosingStartTag);
                            return;
                        } else if (d11 == 65535) {
                            cVar.p(this);
                            cVar.u(TokeniserState.Data);
                            return;
                        } else if (!(d11 == 9 || d11 == 10 || d11 == 12 || d11 == 13)) {
                            switch (d11) {
                                case '<':
                                    break;
                                case '=':
                                    cVar.u(TokeniserState.BeforeAttributeValue);
                                    return;
                                case '>':
                                    cVar.o();
                                    cVar.u(TokeniserState.Data);
                                    return;
                                default:
                                    cVar.f55389i.c(d11);
                                    return;
                            }
                        }
                    }
                    cVar.q(this);
                    cVar.f55389i.c(d11);
                    return;
                }
                cVar.u(TokeniserState.AfterAttributeName);
                return;
            }
            cVar.q(this);
            cVar.f55389i.c(65533);
        }
    },
    AfterAttributeName {
        public void read(c cVar, a aVar) {
            char d11 = aVar.d();
            if (d11 == 0) {
                cVar.q(this);
                cVar.f55389i.c(65533);
                cVar.u(TokeniserState.AttributeName);
            } else if (d11 != ' ') {
                if (!(d11 == '\"' || d11 == '\'')) {
                    if (d11 == '/') {
                        cVar.u(TokeniserState.SelfClosingStartTag);
                        return;
                    } else if (d11 == 65535) {
                        cVar.p(this);
                        cVar.u(TokeniserState.Data);
                        return;
                    } else if (d11 != 9 && d11 != 10 && d11 != 12 && d11 != 13) {
                        switch (d11) {
                            case '<':
                                break;
                            case '=':
                                cVar.u(TokeniserState.BeforeAttributeValue);
                                return;
                            case '>':
                                cVar.o();
                                cVar.u(TokeniserState.Data);
                                return;
                            default:
                                cVar.f55389i.n();
                                aVar.I();
                                cVar.u(TokeniserState.AttributeName);
                                return;
                        }
                    } else {
                        return;
                    }
                }
                cVar.q(this);
                cVar.f55389i.n();
                cVar.f55389i.c(d11);
                cVar.u(TokeniserState.AttributeName);
            }
        }
    },
    BeforeAttributeValue {
        public void read(c cVar, a aVar) {
            char d11 = aVar.d();
            if (d11 == 0) {
                cVar.q(this);
                cVar.f55389i.e(65533);
                cVar.u(TokeniserState.AttributeValue_unquoted);
            } else if (d11 == ' ') {
            } else {
                if (d11 != '\"') {
                    if (d11 != '`') {
                        if (d11 == 65535) {
                            cVar.p(this);
                            cVar.o();
                            cVar.u(TokeniserState.Data);
                            return;
                        } else if (d11 != 9 && d11 != 10 && d11 != 12 && d11 != 13) {
                            if (d11 == '&') {
                                aVar.I();
                                cVar.u(TokeniserState.AttributeValue_unquoted);
                                return;
                            } else if (d11 != '\'') {
                                switch (d11) {
                                    case '<':
                                    case '=':
                                        break;
                                    case '>':
                                        cVar.q(this);
                                        cVar.o();
                                        cVar.u(TokeniserState.Data);
                                        return;
                                    default:
                                        aVar.I();
                                        cVar.u(TokeniserState.AttributeValue_unquoted);
                                        return;
                                }
                            } else {
                                cVar.u(TokeniserState.AttributeValue_singleQuoted);
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    cVar.q(this);
                    cVar.f55389i.e(d11);
                    cVar.u(TokeniserState.AttributeValue_unquoted);
                    return;
                }
                cVar.u(TokeniserState.AttributeValue_doubleQuoted);
            }
        }
    },
    AttributeValue_doubleQuoted {
        public void read(c cVar, a aVar) {
            String m11 = aVar.m(TokeniserState.attributeDoubleValueCharsSorted);
            if (m11.length() > 0) {
                cVar.f55389i.f(m11);
            } else {
                cVar.f55389i.p();
            }
            char d11 = aVar.d();
            if (d11 == 0) {
                cVar.q(this);
                cVar.f55389i.e(65533);
            } else if (d11 == '\"') {
                cVar.u(TokeniserState.AfterAttributeValue_quoted);
            } else if (d11 == '&') {
                int[] d12 = cVar.d('\"', true);
                if (d12 != null) {
                    cVar.f55389i.g(d12);
                } else {
                    cVar.f55389i.e('&');
                }
            } else if (d11 != 65535) {
                cVar.f55389i.e(d11);
            } else {
                cVar.p(this);
                cVar.u(TokeniserState.Data);
            }
        }
    },
    AttributeValue_singleQuoted {
        public void read(c cVar, a aVar) {
            String m11 = aVar.m(TokeniserState.attributeSingleValueCharsSorted);
            if (m11.length() > 0) {
                cVar.f55389i.f(m11);
            } else {
                cVar.f55389i.p();
            }
            char d11 = aVar.d();
            if (d11 == 0) {
                cVar.q(this);
                cVar.f55389i.e(65533);
            } else if (d11 == 65535) {
                cVar.p(this);
                cVar.u(TokeniserState.Data);
            } else if (d11 == '&') {
                int[] d12 = cVar.d('\'', true);
                if (d12 != null) {
                    cVar.f55389i.g(d12);
                } else {
                    cVar.f55389i.e('&');
                }
            } else if (d11 != '\'') {
                cVar.f55389i.e(d11);
            } else {
                cVar.u(TokeniserState.AfterAttributeValue_quoted);
            }
        }
    },
    AttributeValue_unquoted {
        public void read(c cVar, a aVar) {
            String n11 = aVar.n(TokeniserState.attributeValueUnquoted);
            if (n11.length() > 0) {
                cVar.f55389i.f(n11);
            }
            char d11 = aVar.d();
            if (d11 != 0) {
                if (d11 != ' ') {
                    if (!(d11 == '\"' || d11 == '`')) {
                        if (d11 == 65535) {
                            cVar.p(this);
                            cVar.u(TokeniserState.Data);
                            return;
                        } else if (!(d11 == 9 || d11 == 10 || d11 == 12 || d11 == 13)) {
                            if (d11 == '&') {
                                int[] d12 = cVar.d('>', true);
                                if (d12 != null) {
                                    cVar.f55389i.g(d12);
                                    return;
                                } else {
                                    cVar.f55389i.e('&');
                                    return;
                                }
                            } else if (d11 != '\'') {
                                switch (d11) {
                                    case '<':
                                    case '=':
                                        break;
                                    case '>':
                                        cVar.o();
                                        cVar.u(TokeniserState.Data);
                                        return;
                                    default:
                                        cVar.f55389i.e(d11);
                                        return;
                                }
                            }
                        }
                    }
                    cVar.q(this);
                    cVar.f55389i.e(d11);
                    return;
                }
                cVar.u(TokeniserState.BeforeAttributeName);
                return;
            }
            cVar.q(this);
            cVar.f55389i.e(65533);
        }
    },
    AfterAttributeValue_quoted {
        public void read(c cVar, a aVar) {
            char d11 = aVar.d();
            if (d11 == 9 || d11 == 10 || d11 == 12 || d11 == 13 || d11 == ' ') {
                cVar.u(TokeniserState.BeforeAttributeName);
            } else if (d11 == '/') {
                cVar.u(TokeniserState.SelfClosingStartTag);
            } else if (d11 == '>') {
                cVar.o();
                cVar.u(TokeniserState.Data);
            } else if (d11 != 65535) {
                cVar.q(this);
                aVar.I();
                cVar.u(TokeniserState.BeforeAttributeName);
            } else {
                cVar.p(this);
                cVar.u(TokeniserState.Data);
            }
        }
    },
    SelfClosingStartTag {
        public void read(c cVar, a aVar) {
            char d11 = aVar.d();
            if (d11 == '>') {
                cVar.f55389i.f55367i = true;
                cVar.o();
                cVar.u(TokeniserState.Data);
            } else if (d11 != 65535) {
                cVar.q(this);
                aVar.I();
                cVar.u(TokeniserState.BeforeAttributeName);
            } else {
                cVar.p(this);
                cVar.u(TokeniserState.Data);
            }
        }
    },
    BogusComment {
        public void read(c cVar, a aVar) {
            aVar.I();
            Token.c cVar2 = new Token.c();
            cVar2.f55354c = true;
            cVar2.f55353b.append(aVar.k('>'));
            cVar.j(cVar2);
            cVar.a(TokeniserState.Data);
        }
    },
    MarkupDeclarationOpen {
        public void read(c cVar, a aVar) {
            if (aVar.u("--")) {
                cVar.e();
                cVar.u(TokeniserState.CommentStart);
            } else if (aVar.v("DOCTYPE")) {
                cVar.u(TokeniserState.Doctype);
            } else if (aVar.u("[CDATA[")) {
                cVar.h();
                cVar.u(TokeniserState.CdataSection);
            } else {
                cVar.q(this);
                cVar.a(TokeniserState.BogusComment);
            }
        }
    },
    CommentStart {
        public void read(c cVar, a aVar) {
            char d11 = aVar.d();
            if (d11 == 0) {
                cVar.q(this);
                cVar.f55394n.f55353b.append(65533);
                cVar.u(TokeniserState.Comment);
            } else if (d11 == '-') {
                cVar.u(TokeniserState.CommentStartDash);
            } else if (d11 == '>') {
                cVar.q(this);
                cVar.m();
                cVar.u(TokeniserState.Data);
            } else if (d11 != 65535) {
                cVar.f55394n.f55353b.append(d11);
                cVar.u(TokeniserState.Comment);
            } else {
                cVar.p(this);
                cVar.m();
                cVar.u(TokeniserState.Data);
            }
        }
    },
    CommentStartDash {
        public void read(c cVar, a aVar) {
            char d11 = aVar.d();
            if (d11 == 0) {
                cVar.q(this);
                cVar.f55394n.f55353b.append(65533);
                cVar.u(TokeniserState.Comment);
            } else if (d11 == '-') {
                cVar.u(TokeniserState.CommentStartDash);
            } else if (d11 == '>') {
                cVar.q(this);
                cVar.m();
                cVar.u(TokeniserState.Data);
            } else if (d11 != 65535) {
                cVar.f55394n.f55353b.append(d11);
                cVar.u(TokeniserState.Comment);
            } else {
                cVar.p(this);
                cVar.m();
                cVar.u(TokeniserState.Data);
            }
        }
    },
    Comment {
        public void read(c cVar, a aVar) {
            char q11 = aVar.q();
            if (q11 == 0) {
                cVar.q(this);
                aVar.a();
                cVar.f55394n.f55353b.append(65533);
            } else if (q11 == '-') {
                cVar.a(TokeniserState.CommentEndDash);
            } else if (q11 != 65535) {
                cVar.f55394n.f55353b.append(aVar.m('-', 0));
            } else {
                cVar.p(this);
                cVar.m();
                cVar.u(TokeniserState.Data);
            }
        }
    },
    CommentEndDash {
        public void read(c cVar, a aVar) {
            char d11 = aVar.d();
            if (d11 == 0) {
                cVar.q(this);
                StringBuilder sb2 = cVar.f55394n.f55353b;
                sb2.append('-');
                sb2.append(65533);
                cVar.u(TokeniserState.Comment);
            } else if (d11 == '-') {
                cVar.u(TokeniserState.CommentEnd);
            } else if (d11 != 65535) {
                StringBuilder sb3 = cVar.f55394n.f55353b;
                sb3.append('-');
                sb3.append(d11);
                cVar.u(TokeniserState.Comment);
            } else {
                cVar.p(this);
                cVar.m();
                cVar.u(TokeniserState.Data);
            }
        }
    },
    CommentEnd {
        public void read(c cVar, a aVar) {
            char d11 = aVar.d();
            if (d11 == 0) {
                cVar.q(this);
                StringBuilder sb2 = cVar.f55394n.f55353b;
                sb2.append("--");
                sb2.append(65533);
                cVar.u(TokeniserState.Comment);
            } else if (d11 == '!') {
                cVar.q(this);
                cVar.u(TokeniserState.CommentEndBang);
            } else if (d11 == '-') {
                cVar.q(this);
                cVar.f55394n.f55353b.append('-');
            } else if (d11 == '>') {
                cVar.m();
                cVar.u(TokeniserState.Data);
            } else if (d11 != 65535) {
                cVar.q(this);
                StringBuilder sb3 = cVar.f55394n.f55353b;
                sb3.append("--");
                sb3.append(d11);
                cVar.u(TokeniserState.Comment);
            } else {
                cVar.p(this);
                cVar.m();
                cVar.u(TokeniserState.Data);
            }
        }
    },
    CommentEndBang {
        public void read(c cVar, a aVar) {
            char d11 = aVar.d();
            if (d11 == 0) {
                cVar.q(this);
                StringBuilder sb2 = cVar.f55394n.f55353b;
                sb2.append("--!");
                sb2.append(65533);
                cVar.u(TokeniserState.Comment);
            } else if (d11 == '-') {
                cVar.f55394n.f55353b.append("--!");
                cVar.u(TokeniserState.CommentEndDash);
            } else if (d11 == '>') {
                cVar.m();
                cVar.u(TokeniserState.Data);
            } else if (d11 != 65535) {
                StringBuilder sb3 = cVar.f55394n.f55353b;
                sb3.append("--!");
                sb3.append(d11);
                cVar.u(TokeniserState.Comment);
            } else {
                cVar.p(this);
                cVar.m();
                cVar.u(TokeniserState.Data);
            }
        }
    },
    Doctype {
        public void read(c cVar, a aVar) {
            char d11 = aVar.d();
            if (d11 == 9 || d11 == 10 || d11 == 12 || d11 == 13 || d11 == ' ') {
                cVar.u(TokeniserState.BeforeDoctypeName);
                return;
            }
            if (d11 != '>') {
                if (d11 != 65535) {
                    cVar.q(this);
                    cVar.u(TokeniserState.BeforeDoctypeName);
                    return;
                }
                cVar.p(this);
            }
            cVar.q(this);
            cVar.f();
            cVar.f55393m.f55359f = true;
            cVar.n();
            cVar.u(TokeniserState.Data);
        }
    },
    BeforeDoctypeName {
        public void read(c cVar, a aVar) {
            if (aVar.C()) {
                cVar.f();
                cVar.u(TokeniserState.DoctypeName);
                return;
            }
            char d11 = aVar.d();
            if (d11 == 0) {
                cVar.q(this);
                cVar.f();
                cVar.f55393m.f55355b.append(65533);
                cVar.u(TokeniserState.DoctypeName);
            } else if (d11 == ' ') {
            } else {
                if (d11 == 65535) {
                    cVar.p(this);
                    cVar.f();
                    cVar.f55393m.f55359f = true;
                    cVar.n();
                    cVar.u(TokeniserState.Data);
                } else if (d11 != 9 && d11 != 10 && d11 != 12 && d11 != 13) {
                    cVar.f();
                    cVar.f55393m.f55355b.append(d11);
                    cVar.u(TokeniserState.DoctypeName);
                }
            }
        }
    },
    DoctypeName {
        public void read(c cVar, a aVar) {
            if (aVar.C()) {
                cVar.f55393m.f55355b.append(aVar.h());
                return;
            }
            char d11 = aVar.d();
            if (d11 != 0) {
                if (d11 != ' ') {
                    if (d11 == '>') {
                        cVar.n();
                        cVar.u(TokeniserState.Data);
                        return;
                    } else if (d11 == 65535) {
                        cVar.p(this);
                        cVar.f55393m.f55359f = true;
                        cVar.n();
                        cVar.u(TokeniserState.Data);
                        return;
                    } else if (!(d11 == 9 || d11 == 10 || d11 == 12 || d11 == 13)) {
                        cVar.f55393m.f55355b.append(d11);
                        return;
                    }
                }
                cVar.u(TokeniserState.AfterDoctypeName);
                return;
            }
            cVar.q(this);
            cVar.f55393m.f55355b.append(65533);
        }
    },
    AfterDoctypeName {
        public void read(c cVar, a aVar) {
            if (aVar.r()) {
                cVar.p(this);
                cVar.f55393m.f55359f = true;
                cVar.n();
                cVar.u(TokeniserState.Data);
            } else if (aVar.y(9, 10, 13, 12, ' ')) {
                aVar.a();
            } else if (aVar.w('>')) {
                cVar.n();
                cVar.a(TokeniserState.Data);
            } else if (aVar.v("PUBLIC")) {
                cVar.f55393m.f55356c = "PUBLIC";
                cVar.u(TokeniserState.AfterDoctypePublicKeyword);
            } else if (aVar.v("SYSTEM")) {
                cVar.f55393m.f55356c = "SYSTEM";
                cVar.u(TokeniserState.AfterDoctypeSystemKeyword);
            } else {
                cVar.q(this);
                cVar.f55393m.f55359f = true;
                cVar.a(TokeniserState.BogusDoctype);
            }
        }
    },
    AfterDoctypePublicKeyword {
        public void read(c cVar, a aVar) {
            char d11 = aVar.d();
            if (d11 == 9 || d11 == 10 || d11 == 12 || d11 == 13 || d11 == ' ') {
                cVar.u(TokeniserState.BeforeDoctypePublicIdentifier);
            } else if (d11 == '\"') {
                cVar.q(this);
                cVar.u(TokeniserState.DoctypePublicIdentifier_doubleQuoted);
            } else if (d11 == '\'') {
                cVar.q(this);
                cVar.u(TokeniserState.DoctypePublicIdentifier_singleQuoted);
            } else if (d11 == '>') {
                cVar.q(this);
                cVar.f55393m.f55359f = true;
                cVar.n();
                cVar.u(TokeniserState.Data);
            } else if (d11 != 65535) {
                cVar.q(this);
                cVar.f55393m.f55359f = true;
                cVar.u(TokeniserState.BogusDoctype);
            } else {
                cVar.p(this);
                cVar.f55393m.f55359f = true;
                cVar.n();
                cVar.u(TokeniserState.Data);
            }
        }
    },
    BeforeDoctypePublicIdentifier {
        public void read(c cVar, a aVar) {
            char d11 = aVar.d();
            if (d11 != 9 && d11 != 10 && d11 != 12 && d11 != 13 && d11 != ' ') {
                if (d11 == '\"') {
                    cVar.u(TokeniserState.DoctypePublicIdentifier_doubleQuoted);
                } else if (d11 == '\'') {
                    cVar.u(TokeniserState.DoctypePublicIdentifier_singleQuoted);
                } else if (d11 == '>') {
                    cVar.q(this);
                    cVar.f55393m.f55359f = true;
                    cVar.n();
                    cVar.u(TokeniserState.Data);
                } else if (d11 != 65535) {
                    cVar.q(this);
                    cVar.f55393m.f55359f = true;
                    cVar.u(TokeniserState.BogusDoctype);
                } else {
                    cVar.p(this);
                    cVar.f55393m.f55359f = true;
                    cVar.n();
                    cVar.u(TokeniserState.Data);
                }
            }
        }
    },
    DoctypePublicIdentifier_doubleQuoted {
        public void read(c cVar, a aVar) {
            char d11 = aVar.d();
            if (d11 == 0) {
                cVar.q(this);
                cVar.f55393m.f55357d.append(65533);
            } else if (d11 == '\"') {
                cVar.u(TokeniserState.AfterDoctypePublicIdentifier);
            } else if (d11 == '>') {
                cVar.q(this);
                cVar.f55393m.f55359f = true;
                cVar.n();
                cVar.u(TokeniserState.Data);
            } else if (d11 != 65535) {
                cVar.f55393m.f55357d.append(d11);
            } else {
                cVar.p(this);
                cVar.f55393m.f55359f = true;
                cVar.n();
                cVar.u(TokeniserState.Data);
            }
        }
    },
    DoctypePublicIdentifier_singleQuoted {
        public void read(c cVar, a aVar) {
            char d11 = aVar.d();
            if (d11 == 0) {
                cVar.q(this);
                cVar.f55393m.f55357d.append(65533);
            } else if (d11 == '\'') {
                cVar.u(TokeniserState.AfterDoctypePublicIdentifier);
            } else if (d11 == '>') {
                cVar.q(this);
                cVar.f55393m.f55359f = true;
                cVar.n();
                cVar.u(TokeniserState.Data);
            } else if (d11 != 65535) {
                cVar.f55393m.f55357d.append(d11);
            } else {
                cVar.p(this);
                cVar.f55393m.f55359f = true;
                cVar.n();
                cVar.u(TokeniserState.Data);
            }
        }
    },
    AfterDoctypePublicIdentifier {
        public void read(c cVar, a aVar) {
            char d11 = aVar.d();
            if (d11 == 9 || d11 == 10 || d11 == 12 || d11 == 13 || d11 == ' ') {
                cVar.u(TokeniserState.BetweenDoctypePublicAndSystemIdentifiers);
            } else if (d11 == '\"') {
                cVar.q(this);
                cVar.u(TokeniserState.DoctypeSystemIdentifier_doubleQuoted);
            } else if (d11 == '\'') {
                cVar.q(this);
                cVar.u(TokeniserState.DoctypeSystemIdentifier_singleQuoted);
            } else if (d11 == '>') {
                cVar.n();
                cVar.u(TokeniserState.Data);
            } else if (d11 != 65535) {
                cVar.q(this);
                cVar.f55393m.f55359f = true;
                cVar.u(TokeniserState.BogusDoctype);
            } else {
                cVar.p(this);
                cVar.f55393m.f55359f = true;
                cVar.n();
                cVar.u(TokeniserState.Data);
            }
        }
    },
    BetweenDoctypePublicAndSystemIdentifiers {
        public void read(c cVar, a aVar) {
            char d11 = aVar.d();
            if (d11 != 9 && d11 != 10 && d11 != 12 && d11 != 13 && d11 != ' ') {
                if (d11 == '\"') {
                    cVar.q(this);
                    cVar.u(TokeniserState.DoctypeSystemIdentifier_doubleQuoted);
                } else if (d11 == '\'') {
                    cVar.q(this);
                    cVar.u(TokeniserState.DoctypeSystemIdentifier_singleQuoted);
                } else if (d11 == '>') {
                    cVar.n();
                    cVar.u(TokeniserState.Data);
                } else if (d11 != 65535) {
                    cVar.q(this);
                    cVar.f55393m.f55359f = true;
                    cVar.u(TokeniserState.BogusDoctype);
                } else {
                    cVar.p(this);
                    cVar.f55393m.f55359f = true;
                    cVar.n();
                    cVar.u(TokeniserState.Data);
                }
            }
        }
    },
    AfterDoctypeSystemKeyword {
        public void read(c cVar, a aVar) {
            char d11 = aVar.d();
            if (d11 == 9 || d11 == 10 || d11 == 12 || d11 == 13 || d11 == ' ') {
                cVar.u(TokeniserState.BeforeDoctypeSystemIdentifier);
            } else if (d11 == '\"') {
                cVar.q(this);
                cVar.u(TokeniserState.DoctypeSystemIdentifier_doubleQuoted);
            } else if (d11 == '\'') {
                cVar.q(this);
                cVar.u(TokeniserState.DoctypeSystemIdentifier_singleQuoted);
            } else if (d11 == '>') {
                cVar.q(this);
                cVar.f55393m.f55359f = true;
                cVar.n();
                cVar.u(TokeniserState.Data);
            } else if (d11 != 65535) {
                cVar.q(this);
                cVar.f55393m.f55359f = true;
                cVar.n();
            } else {
                cVar.p(this);
                cVar.f55393m.f55359f = true;
                cVar.n();
                cVar.u(TokeniserState.Data);
            }
        }
    },
    BeforeDoctypeSystemIdentifier {
        public void read(c cVar, a aVar) {
            char d11 = aVar.d();
            if (d11 != 9 && d11 != 10 && d11 != 12 && d11 != 13 && d11 != ' ') {
                if (d11 == '\"') {
                    cVar.u(TokeniserState.DoctypeSystemIdentifier_doubleQuoted);
                } else if (d11 == '\'') {
                    cVar.u(TokeniserState.DoctypeSystemIdentifier_singleQuoted);
                } else if (d11 == '>') {
                    cVar.q(this);
                    cVar.f55393m.f55359f = true;
                    cVar.n();
                    cVar.u(TokeniserState.Data);
                } else if (d11 != 65535) {
                    cVar.q(this);
                    cVar.f55393m.f55359f = true;
                    cVar.u(TokeniserState.BogusDoctype);
                } else {
                    cVar.p(this);
                    cVar.f55393m.f55359f = true;
                    cVar.n();
                    cVar.u(TokeniserState.Data);
                }
            }
        }
    },
    DoctypeSystemIdentifier_doubleQuoted {
        public void read(c cVar, a aVar) {
            char d11 = aVar.d();
            if (d11 == 0) {
                cVar.q(this);
                cVar.f55393m.f55358e.append(65533);
            } else if (d11 == '\"') {
                cVar.u(TokeniserState.AfterDoctypeSystemIdentifier);
            } else if (d11 == '>') {
                cVar.q(this);
                cVar.f55393m.f55359f = true;
                cVar.n();
                cVar.u(TokeniserState.Data);
            } else if (d11 != 65535) {
                cVar.f55393m.f55358e.append(d11);
            } else {
                cVar.p(this);
                cVar.f55393m.f55359f = true;
                cVar.n();
                cVar.u(TokeniserState.Data);
            }
        }
    },
    DoctypeSystemIdentifier_singleQuoted {
        public void read(c cVar, a aVar) {
            char d11 = aVar.d();
            if (d11 == 0) {
                cVar.q(this);
                cVar.f55393m.f55358e.append(65533);
            } else if (d11 == '\'') {
                cVar.u(TokeniserState.AfterDoctypeSystemIdentifier);
            } else if (d11 == '>') {
                cVar.q(this);
                cVar.f55393m.f55359f = true;
                cVar.n();
                cVar.u(TokeniserState.Data);
            } else if (d11 != 65535) {
                cVar.f55393m.f55358e.append(d11);
            } else {
                cVar.p(this);
                cVar.f55393m.f55359f = true;
                cVar.n();
                cVar.u(TokeniserState.Data);
            }
        }
    },
    AfterDoctypeSystemIdentifier {
        public void read(c cVar, a aVar) {
            char d11 = aVar.d();
            if (d11 != 9 && d11 != 10 && d11 != 12 && d11 != 13 && d11 != ' ') {
                if (d11 == '>') {
                    cVar.n();
                    cVar.u(TokeniserState.Data);
                } else if (d11 != 65535) {
                    cVar.q(this);
                    cVar.u(TokeniserState.BogusDoctype);
                } else {
                    cVar.p(this);
                    cVar.f55393m.f55359f = true;
                    cVar.n();
                    cVar.u(TokeniserState.Data);
                }
            }
        }
    },
    BogusDoctype {
        public void read(c cVar, a aVar) {
            char d11 = aVar.d();
            if (d11 == '>') {
                cVar.n();
                cVar.u(TokeniserState.Data);
            } else if (d11 == 65535) {
                cVar.n();
                cVar.u(TokeniserState.Data);
            }
        }
    },
    CdataSection {
        public void read(c cVar, a aVar) {
            cVar.f55388h.append(aVar.l("]]>"));
            if (aVar.u("]]>") || aVar.r()) {
                cVar.j(new Token.a(cVar.f55388h.toString()));
                cVar.u(TokeniserState.Data);
            }
        }
    };
    
    public static final char[] attributeDoubleValueCharsSorted = null;
    public static final char[] attributeNameCharsSorted = null;
    public static final char[] attributeSingleValueCharsSorted = null;
    public static final char[] attributeValueUnquoted = null;
    private static final char eof = '￿';
    public static final char nullChar = '\u0000';
    private static final char replacementChar = '�';
    /* access modifiers changed from: private */
    public static final String replacementStr = null;

    /* access modifiers changed from: public */
    static {
        attributeSingleValueCharsSorted = new char[]{0, '&', '\''};
        attributeDoubleValueCharsSorted = new char[]{0, '\"', '&'};
        attributeNameCharsSorted = new char[]{0, 9, 10, 12, 13, ' ', '\"', '\'', '/', '<', '=', '>'};
        attributeValueUnquoted = new char[]{0, 9, 10, 12, 13, ' ', '\"', '&', '\'', '<', '=', '>', '`'};
        replacementStr = String.valueOf(65533);
    }

    /* access modifiers changed from: private */
    public static void handleDataDoubleEscapeTag(c cVar, a aVar, TokeniserState tokeniserState, TokeniserState tokeniserState2) {
        if (aVar.C()) {
            String h11 = aVar.h();
            cVar.f55388h.append(h11);
            cVar.k(h11);
            return;
        }
        char d11 = aVar.d();
        if (d11 == 9 || d11 == 10 || d11 == 12 || d11 == 13 || d11 == ' ' || d11 == '/' || d11 == '>') {
            if (cVar.f55388h.toString().equals("script")) {
                cVar.u(tokeniserState);
            } else {
                cVar.u(tokeniserState2);
            }
            cVar.i(d11);
            return;
        }
        aVar.I();
        cVar.u(tokeniserState2);
    }

    /* access modifiers changed from: private */
    public static void handleDataEndTag(c cVar, a aVar, TokeniserState tokeniserState) {
        if (aVar.C()) {
            String h11 = aVar.h();
            cVar.f55389i.i(h11);
            cVar.f55388h.append(h11);
            return;
        }
        boolean z11 = false;
        boolean z12 = true;
        if (cVar.s() && !aVar.r()) {
            char d11 = aVar.d();
            if (d11 == 9 || d11 == 10 || d11 == 12 || d11 == 13 || d11 == ' ') {
                cVar.u(BeforeAttributeName);
            } else if (d11 == '/') {
                cVar.u(SelfClosingStartTag);
            } else if (d11 != '>') {
                cVar.f55388h.append(d11);
                z11 = true;
            } else {
                cVar.o();
                cVar.u(Data);
            }
            z12 = z11;
        }
        if (z12) {
            cVar.k("</" + cVar.f55388h.toString());
            cVar.u(tokeniserState);
        }
    }

    /* access modifiers changed from: private */
    public static void readCharRef(c cVar, TokeniserState tokeniserState) {
        int[] d11 = cVar.d((Character) null, false);
        if (d11 == null) {
            cVar.i('&');
        } else {
            cVar.l(d11);
        }
        cVar.u(tokeniserState);
    }

    /* access modifiers changed from: private */
    public static void readData(c cVar, a aVar, TokeniserState tokeniserState, TokeniserState tokeniserState2) {
        char q11 = aVar.q();
        if (q11 == 0) {
            cVar.q(tokeniserState);
            aVar.a();
            cVar.i(65533);
        } else if (q11 == '<') {
            cVar.a(tokeniserState2);
        } else if (q11 != 65535) {
            cVar.k(aVar.m('<', 0));
        } else {
            cVar.j(new Token.e());
        }
    }

    /* access modifiers changed from: private */
    public static void readEndTag(c cVar, a aVar, TokeniserState tokeniserState, TokeniserState tokeniserState2) {
        if (aVar.C()) {
            cVar.g(false);
            cVar.u(tokeniserState);
            return;
        }
        cVar.k("</");
        cVar.u(tokeniserState2);
    }

    public abstract void read(c cVar, a aVar);
}
