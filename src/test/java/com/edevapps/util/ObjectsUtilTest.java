/*
 *     Copyright (c) 2019, The Eduard Burenkov. All rights reserved. http://edevapps.com
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package com.edevapps.util;

import static com.edevapps.util.ObjectsUtil.requireNonNegative;
import static com.edevapps.util.ObjectsUtil.requireNonNull;
import static com.edevapps.util.ObjectsUtil.requireNonNullOrEmpty;

import org.junit.Test;

public class ObjectsUtilTest {

  private static final String TEST_NAME = "test_value";

  @Test(expected = IllegalArgumentException.class)
  public void requireNonNullOrEmptyTest() {
    requireNonNullOrEmpty(null, TEST_NAME);
    requireNonNullOrEmpty(StringUtil.EMPTY_STRING, TEST_NAME);
  }

  @Test(expected = NullPointerException.class)
  public void requireNonNullTest() {
    requireNonNull(null, TEST_NAME);
  }

  @Test(expected = IllegalArgumentException.class)
  public void requireNegativeTest() {
    requireNonNegative(-1, TEST_NAME);
  }
}
