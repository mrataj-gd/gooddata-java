/**
 * Copyright (C) 2004-2016, GoodData(R) Corporation. All rights reserved.
 * This source code is licensed under the BSD-style license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */
package com.gooddata.md;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.text.MatchesPattern.matchesPattern;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.io.InputStream;

public class ColumnTest {

    @Test
    public void shouldDeserialize() throws Exception {
        final InputStream stream = getClass().getResourceAsStream("/md/column.json");
        final Column column = new ObjectMapper().readValue(stream, Column.class);
        assertThat(column, is(notNullValue()));

        assertThat(column.getTableUri(), is("/gdc/md/PROJECT_ID/obj/9538"));
        assertThat(column.getType(), is("pk"));
        assertThat(column.getDBName(), is("id"));
        assertThat(column.isPk(), is(true));
        assertThat(column.isInputPk(), is(false));
        assertThat(column.isFk(), is(false));
        assertThat(column.isFact(), is(false));
        assertThat(column.isDisplayForm(), is(false));
    }

    @Test
    public void testToStringFormat() throws Exception {
        final InputStream stream = getClass().getResourceAsStream("/md/column.json");
        final Column column = new ObjectMapper().readValue(stream, Column.class);

        assertThat(column.toString(), matchesPattern(Column.class.getSimpleName() + "\\[.*\\]"));
    }

}