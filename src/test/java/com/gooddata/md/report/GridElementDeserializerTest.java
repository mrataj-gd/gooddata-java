/**
 * Copyright (C) 2004-2016, GoodData(R) Corporation. All rights reserved.
 * This source code is licensed under the BSD-style license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */
package com.gooddata.md.report;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.instanceOf;

public class GridElementDeserializerTest {

    @Test
    public void testDeserializer() throws Exception {
        final GridElements elems = new ObjectMapper().readValue(
                getClass().getResourceAsStream("/md/report/gridElements.json"), GridElements.class);

        assertThat(elems, is(notNullValue()));
        assertThat(elems, hasSize(2));
        assertThat(elems.get(0), instanceOf(AttributeInGrid.class));
        assertThat(elems.get(1), instanceOf(MetricGroup.class));
    }

    @JsonDeserialize(contentUsing = GridElementDeserializer.class)
    private static class GridElements extends ArrayList<GridElement> {}

}