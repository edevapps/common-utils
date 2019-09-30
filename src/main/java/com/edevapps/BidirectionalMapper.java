package com.edevapps;

public interface BidirectionalMapper<T1, T2> extends Mapper<T1, T2> {

  T2 revert(T1 value);
}
