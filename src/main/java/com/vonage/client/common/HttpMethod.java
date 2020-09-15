/*
 *   Copyright 2020 Vonage
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package com.vonage.client.common;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.HashMap;
import java.util.Map;

/**
 * Enumeration representing various HTTP Methods
 */
public enum HttpMethod {
    GET,
    POST,
    PUT,
    DELETE,
    PATCH,
    UNKNOWN;

    private static final Map<String, HttpMethod> HTTP_METHOD_INDEX = new HashMap<>();

    static {
        for (HttpMethod httpMethod : HttpMethod.values()) {
            HTTP_METHOD_INDEX.put(httpMethod.name(), httpMethod);
        }
    }

    @JsonCreator
    public static HttpMethod fromString(String name) {
        HttpMethod foundHttpMethod = HTTP_METHOD_INDEX.get(name.toUpperCase());
        return (foundHttpMethod != null) ? foundHttpMethod : UNKNOWN;
    }
}