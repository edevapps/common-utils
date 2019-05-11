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

import static com.edevapps.util.UrlUtil.getQueryProps;
import static java.util.Objects.requireNonNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Map;
import org.junit.Test;

public class UrlUtilTest {

  private static final String PROP_1 = "prop1";
  private static final String VAL_1 = "val1";
  private static final String PROP_2 = "prop2";
  private static final String VAL_2 = "val2";

  @Test(expected = IllegalStateException.class)
  public void getQueryPropsTest() {
    String query = "http://my-domain.com:1000/my-path";
    getQueryProps(query);
    Map<String, String> map =
        getQueryProps(query + "?" + PROP_1 + "=" + VAL_1 + "&" + PROP_2 + "=" + VAL_2);
   requireNonNull(map);
   assertEquals(2, map.size());
   assertTrue(map.containsKey(PROP_1));
   assertTrue(map.containsKey(PROP_2));
   assertEquals(map.get(PROP_1), VAL_1);
   assertEquals(map.get(PROP_2), VAL_2);
  }
}
