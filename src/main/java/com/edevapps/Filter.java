/*
 * Copyright (c) 2020, The Eduard Burenkov. All rights reserved. http://edevapps.com
 */

package com.edevapps;

public interface Filter<T> {

  boolean accept(T args);
}
