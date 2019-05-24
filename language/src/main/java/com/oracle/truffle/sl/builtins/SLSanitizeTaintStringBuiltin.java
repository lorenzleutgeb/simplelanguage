package com.oracle.truffle.sl.builtins;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.CachedContext;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.sl.SLLanguage;
import com.oracle.truffle.sl.runtime.SLContext;
import com.oracle.truffle.sl.runtime.SLTaintString;

import java.io.PrintWriter;

@NodeInfo(shortName = "sanitize")
public abstract class SLSanitizeTaintStringBuiltin extends SLBuiltinNode {

    @Specialization
    public String sanitize(SLTaintString value, @CachedContext(SLLanguage.class) SLContext context) {
        return doSanitize(value);
    }

    @TruffleBoundary
    private static String doSanitize(SLTaintString tainted) {
        return tainted.getValue();
    }
}
