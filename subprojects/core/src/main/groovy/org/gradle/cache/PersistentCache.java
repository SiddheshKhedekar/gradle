/*
 * Copyright 2009 the original author or authors.
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
package org.gradle.cache;

import java.io.File;

/**
 * Represents a directory that can be used for caching.
 *
 * <p>A shared or exclusive lock is held on this cache by this process, to prevent it being removed or rebuilt by another process
 * while it is in use. However, it is the caller's responsibility to deal with concurrent access to the contents of the cache.
 * You can use {@link DirectoryCacheBuilder#withInitializer(org.gradle.api.Action)} to provide an action to initialize the contents
 * of the cache, for building a read-only cache. An exclusive lock is held by this process while the initializer is running.
 */
public interface PersistentCache {
    /**
     * Returns the base directory for this cache.
     */
    File getBaseDir();
}
