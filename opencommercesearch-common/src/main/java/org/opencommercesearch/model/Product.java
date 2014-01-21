package org.opencommercesearch.model;

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

import java.util.*;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Product {
    @JsonProperty
    private String id;

    @JsonProperty
    private String title;

    @JsonProperty
    private String description;

    @JsonProperty
    private String shortDescription;

    @JsonProperty
    private Brand brand;

    @JsonProperty
    private String gender;

    @JsonProperty
    private String sizingChart;

    @JsonProperty
    private List<Image> detailImages;

    @JsonProperty
    private List<String> bulletPoints;

    @JsonProperty
    private List<Attribute> features;

    @JsonProperty
    private List<Attribute> attributes;

    @JsonProperty
    private int listRank;

    @JsonProperty
    private CustomerReview customerReviews;

    @JsonProperty
    private float bayesianReviewAverage;

    // has free gift by catalog
    @JsonProperty
    private Map<String, Boolean> hasFreeGift;

    @JsonProperty
    private boolean isOutOfStock;

    @JsonProperty
    private Set<String> categories;

    @JsonProperty
    private List<Sku> skus;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSizingChart() {
        return sizingChart;
    }

    public void setSizingChart(String sizingChart) {
        this.sizingChart = sizingChart;
    }

    public List<Image> getDetailImages() {
        return detailImages;
    }

    public void setDetailImages(List<Image> detailImages) {
        this.detailImages = detailImages;
    }

    public List<String> getBulletPoints() {
        return bulletPoints;
    }

    public void addBulletPoint(String bulletPoint) {
        if (bulletPoints == null) {
            bulletPoints = new ArrayList<String>();
        }
        bulletPoints.add(bulletPoint);
    }

    public List<Attribute> getFeatures() {
        return features;
    }

    public void addFeature(String name, String value) {
        if (features == null) {
            features = new ArrayList<Attribute>();
        }
        features.add(new Attribute(name, value));
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void addAttribute(String name, String value) {
        if (attributes == null) {
            attributes = new ArrayList<Attribute>();
        }
        attributes.add(new Attribute(name, value));
    }

    public int getListRank() {
        return listRank;
    }

    public void setListRank(int listRank) {
        this.listRank = listRank;
    }

    public float getBayesianReviewAverage() {
        return bayesianReviewAverage;
    }

    public void setBayesianReviewAverage(float bayesianReviewAverage) {
        this.bayesianReviewAverage = bayesianReviewAverage;
    }

    public Map<String, Boolean> getHasFreeGift() {
        return hasFreeGift;
    }

    public void setHasFreeGift(Map<String, Boolean> hasFreeGift) {
        this.hasFreeGift = hasFreeGift;
    }

    public boolean isOutOfStock() {
        return isOutOfStock;
    }

    public void setOutOfStock(boolean isOutOfStock) {
        this.isOutOfStock = isOutOfStock;
    }

    public Set<String> getCategories() {
        return categories;
    }

    public void addCategory(String category) {
        if (categories == null) {
            categories = new HashSet<String>();
        }
        categories.add(category);
    }

    public List<Sku> getSkus() {
        return skus;
    }

    public void addSku(Sku sku) {
        if (skus == null) {
            skus = new ArrayList<Sku>();
        }
        skus.add(sku);
    }

    public void setCustomerReviews(CustomerReview customerReviews) {
        this.customerReviews = customerReviews;
    }

    public CustomerReview getCustomerReviews() {
        return customerReviews;
    }

}