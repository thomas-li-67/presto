/*
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
package com.facebook.presto.sql.planner;

import com.facebook.presto.sql.tree.Expression;
import com.facebook.presto.sql.util.AstUtils;
import com.google.common.collect.ImmutableSet;

import java.util.Set;

/**
 * Extracts and returns the set of all expression subtrees within an Expression, including Expression itself
 */
@Deprecated
public final class SubExpressionExtractor
{
    private SubExpressionExtractor() {}

    public static Set<Expression> extract(Expression expression)
    {
        return AstUtils.preOrder(expression)
                .map(Expression.class::cast)
                .collect(ImmutableSet.toImmutableSet());
    }
}
