package com.cleancodejava.util.functions.function;

import java.util.function.Function;

/**
 * Represents an operation on a single operand that produces a result of the
 * same type as its operand.
 * 
 * @param <T> the type of the operand and result of the operator
 */

public interface UnaryOperator<T> extends Function<T, T> {

}
