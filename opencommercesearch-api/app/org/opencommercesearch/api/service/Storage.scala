package org.opencommercesearch.api.service

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

import org.opencommercesearch.api.models.Product
import scala.concurrent.Future
import org.opencommercesearch.api.models.Category
import org.opencommercesearch.api.models.Brand

/**
 * Represents the storage for catalog object including products, brand and categories
 *
 * @author rmerizalde
 */
trait Storage[T] {

  /**
   * Finds the products with the given ids. Ids is a sequence of tuples. The first element of the tuple is the product id.
   * The second element is an optional sku id. If the sku id is different than null, only the skus that matches the id
   * is returned. Otherwise, returns all skus for a products
   * @param ids is a sequence of product id/sku id tuples
   * @param country is the country to filter by
   * @param fields is the list of fields to return
   * @return
   */
  def findProducts(ids: Seq[Tuple2[String, String]], country: String, fields: Seq[String]) : Future[Iterable[Product]]

  /**
   * Finds the product with the given id. Optionally, takes a list of fields to return
   * @param id is the product id
   * @param country is the country to filter by
   * @param fields is the list of fields to return
   * @return
   */
  def findProductByIds(id: Array[String], country: String, fields: Seq[String]) : Future[Iterable[Product]]

  /**
   * Finds the product with the given id for the given site. If the product exists but none of its skus are assigned to
   * site null is return
   *
   * @param id is the product id
   * @param site is the site id
   * @param country is the country to filter by
   * @param fields is the list of fields to return
   * @return
   */
  def findProductByIds(id: Array[String], site: String, country: String, fields: Seq[String]) : Future[Iterable[Product]]

  /**
   * Saves the given list of products. Returns the result of the last write
   * @param product is one or more products to store
   * @return the results of writing the last product
   */
  def saveProduct(product: Product*) : Future[T]

    /**
   * Saves the given list of categories. Returns the result of the last write
   * @param category is one or more categories to store
   * @return the results of writing the last category
   */
  def saveCategory(category: Category*) : Future[T]
  
  /**
   * Finds the category with the given id. Optionally, takes a list of fields to return.
   * If childCategories or parentCategories are specified in the fields parameter, then the
   * category will have the corresponding nested categories populated with whatever other fields
   * you specified in the fields list, not only having the category id. 
   * The method returns only one level depth of nested categories information
   * 
   * For example:   
   *  fields=id,name,seoUrlToken,childCategories
   *  -->
   *  category = { id: ...,  name:..., seoUrlToken:...,  
   *     childCategories: [  {id: ...,  name:..., seoUrlToken:...} ]
   *  }
   *  
   *  * Note: for nested category properties, only id, name, seoUrlToken and catalogs will be populated
   *  
   * @param id is the category id
   * @param fields is the list of fields to return
   * @return
   */
  def findCategory(id: String, fields: Seq[String]) : Future[Category]
  
  
  /**
   * Finds the brand with the given id. Optionally, takes a list of fields to return
   * @param id is the brand id
   * @param fields is the list of fields to return
   * @return
   */
  def findBrand(id: String, fields: Seq[String]) : Future[Brand]
  
  /**
   * Finds the brands that match the ids in the provided list. Optionally, takes a list of fields to return
   * @param ids is the list of brand id
   * @param fields is the list of fields to return
   * @return the list of brands
   */
  def findBrands(ids: Iterable[String], fields: Seq[String]) : Future[Iterable[Brand]]
  
    /**
   * Saves the given list of brands. Returns the result of the last write
   * @param brand is one or more brand to store
   * @return the results of writing the last brand
   */
  def saveBrand(brand: Brand*) : Future[T]
  
  /**
   * Releases the resources used by this storage
   */
  def close : Unit

}
