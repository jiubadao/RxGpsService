/*
 * Copyright 2016 miguelbcr
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.miguelbcr.io.rx_gps_service.lib;

import rx.Observable;

class GetTripSpeedMin {
  static final float INITIAL_VALUE = 999999999f;
  private float speedMin, speedMinTreshold;
  private float lastSpeed;

  GetTripSpeedMin() {
    speedMin = INITIAL_VALUE;
  }

  void setSpeedMinTreshold(float speedMinTreshold) {
    this.speedMinTreshold = speedMinTreshold;
  }

  void setLastSpeed(float lastSpeed) {
    this.lastSpeed = lastSpeed;
  }

  Observable<Float> builtObservable() {
    speedMin = lastSpeed >= speedMinTreshold && lastSpeed < speedMin ? lastSpeed : speedMin;
    return Observable.just(speedMin);
  }
}
