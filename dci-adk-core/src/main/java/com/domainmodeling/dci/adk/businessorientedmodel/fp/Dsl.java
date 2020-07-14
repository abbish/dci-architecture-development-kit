package com.domainmodeling.dci.adk.businessorientedmodel.fp;

import java.util.function.Function;

public class Dsl {

    public static <R, E> E __(Function<R, E> operator, R input) {
        return operator.apply(input);
    }

    public static void sign() {

    }

    public static void fulfill() {

    }

    public static void requestProposal(String input) {

    }

    public static void propose() {

    }
}
