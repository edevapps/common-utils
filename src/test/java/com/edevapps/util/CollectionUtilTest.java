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

import static com.edevapps.util.CollectionUtil.containsAnyValues;
import static com.edevapps.util.CollectionUtil.lastItem;
import static com.edevapps.util.CollectionUtil.valueOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.Test;

public class CollectionUtilTest {

  private static final String KEY_1 = "sk1";
  private static final String KEY_2 = "sk2";
  private static final String STRING_1 = "sv1";
  private static final String STRING_2 = "sv2";

  @Test
  public void containsAnyValuesTest() {
    Map<String, String> source = new HashMap<>();
    source.put(KEY_1, STRING_1);
    source.put(KEY_2, STRING_2);
    Set<String> values = new HashSet<>();
    values.add(STRING_1);
    values.add(STRING_2);
    assertTrue(
        containsAnyValues(source, values));
  }

  @Test
  public void lastItemTest() {
    Collection<String> collection = Arrays.asList(STRING_1, STRING_2);
    assertEquals(
        lastItem(collection), STRING_2);
  }

  @Test
  public void mapValueTest() {
    Map<String, Object> source = new HashMap<>();
    source.put(KEY_1, STRING_1);
    assertEquals(
        valueOf(KEY_1, source), STRING_1);
  }
}
