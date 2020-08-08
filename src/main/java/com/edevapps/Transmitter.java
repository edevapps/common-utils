/*
 * Copyright (c) 2020, The Eduard Burenkov. All rights reserved. http://edevapps.com
 */

package com.edevapps;

public interface Transmitter<T> {

  void send(T args);
}
