/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.com.caucho.hessian.io.chronology;

import com.alibaba.com.caucho.hessian.io.HessianHandle;

import java.io.Serializable;
import java.time.LocalTime;
import java.time.chrono.AbstractChronology;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.time.chrono.Chronology;

public class ChronoLocalDateTimeImplHandle implements HessianHandle, Serializable {

    private final ChronoLocalDate date;
    private final LocalTime time;

    public ChronoLocalDateTimeImplHandle(ChronoLocalDateTime o) {
        this.date = o.toLocalDate();
        this.time = o.toLocalTime();
    }

    private Object readResolve() {
        return date.atTime(time);
    }
}

