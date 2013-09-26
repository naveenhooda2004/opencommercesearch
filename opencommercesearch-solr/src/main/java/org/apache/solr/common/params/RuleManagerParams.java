package org.apache.solr.common.params;

/*
* Licensed to OpenCommerceSearch under one
* or more contributor license agreements. See the NOTICE file
* distributed with this work for additional information
* regarding copyright ownership. OpenCommerceSearch licenses this
* file to you under the Apache License, Version 2.0 (the
* "License"); you may not use this file except in compliance
* with the License. You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied. See the License for the
* specific language governing permissions and limitations
* under the License.
*/

/**
 * Group Collapse Parameters
 */
public interface RuleManagerParams {

    /**
     * Whether or not the rule component is enabled. A value of rule=false disables the rule manager component for the request.
     */
    public static final String RULE = "rule";

    /**
     * Type of page being served (search, category, rule).
     */
    public static final String PAGE_TYPE = "pageType";

    /**
     * List of site IDs to which rules should apply.
     */
    public static final String SITE_IDS = "siteId";

    /**
     * Catalog currently being searched.
     */
    public static final String CATALOG_ID = "catalogId";

    /**
     * Parameter used to filter rules (rules can target specific categories).
    */
    public static final String CATEGORY_PATH = "categoryPath";

    /**
     * Parameter used to specify the current path when browsing.
     */
    public static final String PATH = "path";
}