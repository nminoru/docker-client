/*-
 * -\-\-
 * docker-client
 * --
 * Copyright (C) 2024 Minoru NAKAMURA <nminoru1975@gmail.com>/
 * --
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * -/-/-
 */

package com.spotify.docker.client.messages;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;

import java.util.List;

import javax.annotation.Nullable;

@AutoValue
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
public abstract class DeviceRequests {

  @Nullable
  @JsonProperty("Driver")
  public abstract String driver();

  @Nullable
  @JsonProperty("Count")
  public abstract Integer count();

  @Nullable
  @JsonProperty("DeviceIDs")
  public abstract ImmutableList<String> deviceIDs();

  @Nullable
  @JsonProperty("Capabilities")
  public abstract ImmutableList<String> capabilities();

  // TODO: Options
    
  @AutoValue.Builder
  public abstract static class Builder {

    public abstract Builder driver(String driver);

    public abstract Builder count(String count);

    public abstract Builder deviceIDs(List<String> deviceIDs);
      
    public abstract Builder capabilities(List<String> capabilities);

    public abstract DeviceRequests build();
  }

  public static Device.Builder builder() {
    return new AutoValue_Device.Builder();
  }

  @JsonCreator
  static Device create(
      @JsonProperty("Driver") final driver,
      @JsonProperty("Count") final count,
      @JsonProperty("DeviceIDs") final List<String> deviceIDs,
      @JsonProperty("Capabilities") final List<String> capabilities) {
    return builder()
        .driver(driver)
        .count(count)
        .deviceIDs(deviceIDs)
        .capabilities(capabilities)
        .build();
  }
}
