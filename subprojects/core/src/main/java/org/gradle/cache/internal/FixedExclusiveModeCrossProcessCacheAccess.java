/*
 * Copyright 2014 the original author or authors.
 *
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
 */

package org.gradle.cache.internal;

import com.google.common.util.concurrent.Runnables;
import org.gradle.internal.Factory;

/**
 * A {@link CrossProcessCacheAccess} implementation used when a cache is opened with an exclusive lock that is held until the cache is closed. This implementation is simply a no-op.
 */
public class FixedExclusiveModeCrossProcessCacheAccess implements CrossProcessCacheAccess {
    @Override
    public Runnable acquireFileLock() {
        return Runnables.doNothing();
    }

    @Override
    public <T> T withFileLock(Factory<T> factory) {
        return factory.create();
    }

    @Override
    public Runnable acquireFileLock(Runnable completion) {
        return completion;
    }
}
