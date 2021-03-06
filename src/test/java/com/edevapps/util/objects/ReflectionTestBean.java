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

package com.edevapps.util.objects;

public class ReflectionTestBean {

  public static final String STRING_VALUE = "string_value";
  public static final String PRIVATE_STRING_FIELD_NAME = "privateStringField";

  private String privateStringField = STRING_VALUE;

  public ReflectionTestBean() {
  }

  public ReflectionTestBean(String privateStringField) {
    this.privateStringField = privateStringField;
  }

  public String getStringField() {
    return privateStringField;
  }
}
