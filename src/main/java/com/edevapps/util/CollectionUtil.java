/*
 *     Copyright (c) 2018, The Eduard Burenkov (http://edevapps.com)
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

import static java.util.stream.Collectors.toMap;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Spliterators;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CollectionUtil {

  public static boolean containsAnyValues(Map<String, String> source, Set<String> values) {
    return source.values().stream().anyMatch(values::contains);
  }

  public static <T, R> Collector<T, ?, Stream<T>> distinctByKey(Function<T, R> keyExtractor) {
    return Collectors.collectingAndThen(
        toMap(
            keyExtractor,
            t -> t,
            (t1, t2) -> t1
        ),
        (Map<R, T> map) -> map.values().stream()
    );
  }

  public static <T> T lastItem(Collection<T> items) {
    return items.stream().reduce((first, second) -> second).orElse(null);
  }

  public static <T> Stream<T> throwIfEmpty(Stream<T> stream) {
    Iterator<T> iterator = stream.iterator();
    if (iterator.hasNext()) {
      return StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator, 0), false);
    } else {
      throw new NoSuchElementException("Empty stream.");
    }
  }

  @SuppressWarnings("unchecked")
  public static <T> T valueOf(String key, Map<String, Object> args)
      throws IllegalArgumentException, ClassCastException {
    if (!args.containsKey(key)) {
      throw new IllegalArgumentException(
          "Argument by name '" + key + "' is not contains in args.");
    }
    return (T) args.get(key);
  }
}
