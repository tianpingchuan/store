<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

	<!-- header -->
	<%@include file="/header.jsp" %>


	<!-- banner -->
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1" class=""></li>
			<li data-target="#myCarousel" data-slide-to="2" class=""></li>
			<li data-target="#myCarousel" data-slide-to="3" class=""></li>
			<li data-target="#myCarousel" data-slide-to="4" class=""></li>
		</ol>
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<div class="container">
					<div class="carousel-caption">
						<h3>
							最大的<span>销售 </span>
						</h3>
						<p>今天特别</p>
						<a class="hvr-outline-out button2" href="mens">现在去购物 </a>
					</div>
				</div>
			</div>
			<div class="item item2">
				<div class="container">
					<div class="carousel-caption">
						<h3>
							夏季 <span>系列</span>
						</h3>
						<p>新品上市</p>
						<a class="hvr-outline-out button2" href="mens">现在去购物 </a>
					</div>
				</div>
			</div>
			<div class="item item3">
				<div class="container">
					<div class="carousel-caption">
						<h3>
							最大的<span>销售 </span>
						</h3>
						<p>今天特别</p>
						<a class="hvr-outline-out button2" href="mens">现在去购物</a>
					</div>
				</div>
			</div>
			<div class="item item4">
				<div class="container">
					<div class="carousel-caption">
						<h3>
							夏季 <span>系列</span>
						</h3>
						<p>新品上市</p>
						<a class="hvr-outline-out button2" href="mens">现在去购物</a>
					</div>
				</div>
			</div>
			<div class="item item5">
				<div class="container">
					<div class="carousel-caption">
						<h3>
							最大的<span>销售</span>
						</h3>
						<p>今天很特别</p>
						<a class="hvr-outline-out button2" href="mens">现在去购物 </a>
					</div>
				</div>
			</div>
		</div>
		<a class="left carousel-control" href="#myCarousel" role="button"
			data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel" role="button"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
		<!-- The Modal -->
	</div>
	<!-- //banner -->
	<div class="banner_bottom_agile_info">
		<div class="container">
			<div class="banner_bottom_agile_info_inner_w3ls">
				<div class="col-md-6 wthree_banner_bottom_grid_three_left1 grid">
					<figure class="effect-roxy">
						<img src="assert/images/bottom1.jpg" alt=" "
							class="img-responsive" />
						<figcaption>
							<h3>
								<span>F</span>引领未来
							</h3>
							<p>新品港风潮流</p>
						</figcaption>
					</figure>
				</div>
				<div class="col-md-6 wthree_banner_bottom_grid_three_left1 grid">
					<figure class="effect-roxy">
						<img src="assert/images/bottom2.jpg" alt=" "
							class="img-responsive" />
						<figcaption>
							<h3>
								<span>F</span>引领未来
							</h3>
							<p>新品港风潮流</p>
						</figcaption>
					</figure>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>


	<!--/grids-->
	<!-- /new_arrivals -->
	<div class="new_arrivals_agile_w3ls_info">
		<div class="container">
			<h3 class="wthree_text_info">
				商品 <span>目录</span>
			</h3>
			<div id="horizontalTab">
				
				<ul class="resp-tabs-list">
					<c:if test="${!empty catalogParentList}">
						<c:forEach items="${catalogParentList}" var="catalog">
							<li class="dropdown menu__item">
								<a href="javascript:;" data-rowId="${catalog.rowId}" class="catalog">${catalog.catalogName}
								</a>
							</li>
							
						</c:forEach>
					</c:if>
					
				</ul><br/>
				
				<div class="resp-tabs-container">
				
				<!-- 商品 -->
				<c:if test="${!empty productList}">
				<c:forEach items="${productList}" var="product">
				
				<div class="col-md-3 product-men">
							<div class="men-pro-item simpleCart_shelfItem">
								<div class="men-thumb-item">
									<img src="${product.productFile}" alt="" class="pro-image-front">
									<img src="${product.productFile}" alt="" class="pro-image-back">
									<div class="men-cart-pro">
										<div class="inner-men-cart-pro">
											<a href="single" class="link-product-add-cart">立即购买</a>
										</div>
									</div>
									<span class="product-new-top">New</span>

								</div>
								<div class="item-info-product ">
									<h4>
										<a href="single">${product.productName}</a>
									</h4>
									<div class="info-product-price">
										<span class="item_price">${product.productPrice}</span>
									</div>
									<div
										class="snipcart-details top_brand_home_details item_add single-item hvr-outline-out button2">
										<form action="#" method="post">
											<fieldset>
												<input type="hidden" name="cmd" value="_cart" /> <input
													type="hidden" name="add" value="1" /> <input type="hidden"
													name="business" value=" " /> <input type="hidden"
													name="item_name" value="Formal Blue Shirt" /> <input
													type="hidden" name="amount" value="30.99" /> <input
													type="hidden" name="discount_amount" value="1.00" /> <input
													type="hidden" name="currency_code" value="USD" /> <input
													type="hidden" name="return" value=" " /> <input
													type="hidden" name="cancel_return" value=" " /> <input
													type="submit" name="submit" value="加入购物车" class="button" />
											</fieldset>
										</form>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
					</c:if>
				
				
					<!--/tab_one-->
					<div class="tab1">
						<div class="col-md-3 product-men">
							<div class="men-pro-item simpleCart_shelfItem">
								<div class="men-thumb-item">
									<img src="assert/images/m1.jpg" alt="" class="pro-image-front">
									<img src="assert/images/m1.jpg" alt="" class="pro-image-back">
									<div class="men-cart-pro">
										<div class="inner-men-cart-pro">
											<a href="single" class="link-product-add-cart">Quick
												View</a>
										</div>
									</div>
									<span class="product-new-top">New</span>

								</div>
								<div class="item-info-product ">
									<h4>
										<a href="single">Formal Blue Shirt</a>
									</h4>
									<div class="info-product-price">
										<span class="item_price">$45.99</span>
										<del>$69.71</del>
									</div>
									<div
										class="snipcart-details top_brand_home_details item_add single-item hvr-outline-out button2">
										<form action="#" method="post">
											<fieldset>
												<input type="hidden" name="cmd" value="_cart" /> <input
													type="hidden" name="add" value="1" /> <input type="hidden"
													name="business" value=" " /> <input type="hidden"
													name="item_name" value="Formal Blue Shirt" /> <input
													type="hidden" name="amount" value="30.99" /> <input
													type="hidden" name="discount_amount" value="1.00" /> <input
													type="hidden" name="currency_code" value="USD" /> <input
													type="hidden" name="return" value=" " /> <input
													type="hidden" name="cancel_return" value=" " /> <input
													type="submit" name="submit" value="加入购物车" class="button" />
											</fieldset>
										</form>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-3 product-men">
							<div class="men-pro-item simpleCart_shelfItem">
								<div class="men-thumb-item">
									<img src="assert/images/m2.jpg" alt="" class="pro-image-front">
									<img src="assert/images/m2.jpg" alt="" class="pro-image-back">
									<div class="men-cart-pro">
										<div class="inner-men-cart-pro">
											<a href="single" class="link-product-add-cart">Quick
												View</a>
										</div>
									</div>
									<span class="product-new-top">New</span>

								</div>
								<div class="item-info-product ">
									<h4>
										<a href="single">Gabi Sweatshirt</a>
									</h4>
									<div class="info-product-price">
										<span class="item_price">$45.99</span>
										<del>$69.71</del>
									</div>
									<div
										class="snipcart-details top_brand_home_details item_add single-item hvr-outline-out button2">
										<form action="#" method="post">
											<fieldset>
												<input type="hidden" name="cmd" value="_cart" /> <input
													type="hidden" name="add" value="1" /> <input type="hidden"
													name="business" value=" " /> <input type="hidden"
													name="item_name" value="Sweatshirt" /> <input
													type="hidden" name="amount" value="30.99" /> <input
													type="hidden" name="discount_amount" value="1.00" /> <input
													type="hidden" name="currency_code" value="USD" /> <input
													type="hidden" name="return" value=" " /> <input
													type="hidden" name="cancel_return" value=" " /> <input
													type="submit" name="submit" value="加入购物车" class="button" />
											</fieldset>
										</form>
									</div>

								</div>
							</div>
						</div>
						<div class="col-md-3 product-men">
							<div class="men-pro-item simpleCart_shelfItem">
								<div class="men-thumb-item">
									<img src="assert/images/m3.jpg" alt="" class="pro-image-front">
									<img src="assert/images/m3.jpg" alt="" class="pro-image-back">
									<div class="men-cart-pro">
										<div class="inner-men-cart-pro">
											<a href="single" class="link-product-add-cart">Quick
												View</a>
										</div>
									</div>
									<span class="product-new-top">New</span>

								</div>
								<div class="item-info-product ">
									<h4>
										<a href="single">Dark Blue Track Pants</a>
									</h4>
									<div class="info-product-price">
										<span class="item_price">$80.99</span>
										<del>$89.71</del>
									</div>
									<div
										class="snipcart-details top_brand_home_details item_add single-item hvr-outline-out button2">
										<form action="#" method="post">
											<fieldset>
												<input type="hidden" name="cmd" value="_cart" /> <input
													type="hidden" name="add" value="1" /> <input type="hidden"
													name="business" value=" " /> <input type="hidden"
													name="item_name" value="Dark Blue Track Pants" /> <input
													type="hidden" name="amount" value="30.99" /> <input
													type="hidden" name="discount_amount" value="1.00" /> <input
													type="hidden" name="currency_code" value="USD" /> <input
													type="hidden" name="return" value=" " /> <input
													type="hidden" name="cancel_return" value=" " /> <input
													type="submit" name="submit" value="加入购物车" class="button" />
											</fieldset>
										</form>
									</div>

								</div>
							</div>
						</div>
						<div class="col-md-3 product-men">
							<div class="men-pro-item simpleCart_shelfItem">
								<div class="men-thumb-item">
									<img src="assert/images/m4.jpg" alt="" class="pro-image-front">
									<img src="assert/images/m4.jpg" alt="" class="pro-image-back">
									<div class="men-cart-pro">
										<div class="inner-men-cart-pro">
											<a href="single" class="link-product-add-cart">Quick
												View</a>
										</div>
									</div>
									<span class="product-new-top">New</span>

								</div>
								<div class="item-info-product ">
									<h4>
										<a href="single">Round Neck Black T-Shirt</a>
									</h4>
									<div class="info-product-price">
										<span class="item_price">$190.99</span>
										<del>$159.71</del>
									</div>
									<div
										class="snipcart-details top_brand_home_details item_add single-item hvr-outline-out button2">
										<form action="#" method="post">
											<fieldset>
												<input type="hidden" name="cmd" value="_cart" /> <input
													type="hidden" name="add" value="1" /> <input type="hidden"
													name="business" value=" " /> <input type="hidden"
													name="item_name" value="Black T-Shirt" /> <input
													type="hidden" name="amount" value="30.99" /> <input
													type="hidden" name="discount_amount" value="1.00" /> <input
													type="hidden" name="currency_code" value="USD" /> <input
													type="hidden" name="return" value=" " /> <input
													type="hidden" name="cancel_return" value=" " /> <input
													type="submit" name="submit" value="加入购物车" class="button" />
											</fieldset>
										</form>
									</div>

								</div>
							</div>
						</div>
						<div class="col-md-3 product-men">
							<div class="men-pro-item simpleCart_shelfItem">
								<div class="men-thumb-item">
									<img src="assert/images/m5.jpg" alt="" class="pro-image-front">
									<img src="assert/images/m5.jpg" alt="" class="pro-image-back">
									<div class="men-cart-pro">
										<div class="inner-men-cart-pro">
											<a href="single" class="link-product-add-cart">Quick
												View</a>
										</div>
									</div>
									<span class="product-new-top">New</span>

								</div>
								<div class="item-info-product ">
									<h4>
										<a href="single">Men's Black Jeans</a>
									</h4>
									<div class="info-product-price">
										<span class="item_price">$60.99</span>
										<del>$90.71</del>
									</div>
									<div
										class="snipcart-details top_brand_home_details item_add single-item hvr-outline-out button2">
										<form action="#" method="post">
											<fieldset>
												<input type="hidden" name="cmd" value="_cart" /> <input
													type="hidden" name="add" value="1" /> <input type="hidden"
													name="business" value=" " /> <input type="hidden"
													name="item_name" value="Men's Black Jeans" /> <input
													type="hidden" name="amount" value="30.99" /> <input
													type="hidden" name="discount_amount" value="1.00" /> <input
													type="hidden" name="currency_code" value="USD" /> <input
													type="hidden" name="return" value=" " /> <input
													type="hidden" name="cancel_return" value=" " /> <input
													type="submit" name="submit" value="加入购物车" class="button" />
											</fieldset>
										</form>
									</div>

								</div>
							</div>
						</div>
						<div class="col-md-3 product-men">
							<div class="men-pro-item simpleCart_shelfItem">
								<div class="men-thumb-item">
									<img src="assert/images/m7.jpg" alt="" class="pro-image-front">
									<img src="assert/images/m7.jpg" alt="" class="pro-image-back">
									<div class="men-cart-pro">
										<div class="inner-men-cart-pro">
											<a href="single" class="link-product-add-cart">Quick
												View</a>
										</div>
									</div>
									<span class="product-new-top">New</span>

								</div>
								<div class="item-info-product ">
									<h4>
										<a href="single">Analog Watch</a>
									</h4>
									<div class="info-product-price">
										<span class="item_price">$160.99</span>
										<del>$290.71</del>
									</div>
									<div
										class="snipcart-details top_brand_home_details item_add single-item hvr-outline-out button2">
										<form action="#" method="post">
											<fieldset>
												<input type="hidden" name="cmd" value="_cart" /> <input
													type="hidden" name="add" value="1" /> <input type="hidden"
													name="business" value=" " /> <input type="hidden"
													name="item_name" value="Analog Watch" /> <input
													type="hidden" name="amount" value="30.99" /> <input
													type="hidden" name="discount_amount" value="1.00" /> <input
													type="hidden" name="currency_code" value="USD" /> <input
													type="hidden" name="return" value=" " /> <input
													type="hidden" name="cancel_return" value=" " /> <input
													type="submit" name="submit" value="加入购物车" class="button" />
											</fieldset>
										</form>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-3 product-men">
							<div class="men-pro-item simpleCart_shelfItem">
								<div class="men-thumb-item">
									<img src="assert/images/m6.jpg" alt="" class="pro-image-front">
									<img src="assert/images/m6.jpg" alt="" class="pro-image-back">
									<div class="men-cart-pro">
										<div class="inner-men-cart-pro">
											<a href="single" class="link-product-add-cart">Quick
												View</a>
										</div>
									</div>
									<span class="product-new-top">New</span>
								</div>
								<div class="item-info-product ">
									<h4>
										<a href="single">Reversible Belt</a>
									</h4>
									<div class="info-product-price">
										<span class="item_price">$30.99</span>
										<del>$50.71</del>
									</div>
									<div
										class="snipcart-details top_brand_home_details item_add single-item hvr-outline-out button2">
										<form action="#" method="post">
											<fieldset>
												<input type="hidden" name="cmd" value="_cart" /> <input
													type="hidden" name="add" value="1" /> <input type="hidden"
													name="business" value=" " /> <input type="hidden"
													name="item_name" value="Reversible Belt" /> <input
													type="hidden" name="amount" value="30.99" /> <input
													type="hidden" name="discount_amount" value="1.00" /> <input
													type="hidden" name="currency_code" value="USD" /> <input
													type="hidden" name="return" value=" " /> <input
													type="hidden" name="cancel_return" value=" " /> <input
													type="submit" name="submit" value="加入购物车" class="button" />
											</fieldset>
										</form>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-3 product-men">
							<div class="men-pro-item simpleCart_shelfItem">
								<div class="men-thumb-item">
									<img src="assert/images/m8.jpg" alt="" class="pro-image-front">
									<img src="assert/images/m8.jpg" alt="" class="pro-image-back">
									<div class="men-cart-pro">
										<div class="inner-men-cart-pro">
											<a href="single" class="link-product-add-cart">Quick
												View</a>
										</div>
									</div>
									<span class="product-new-top">New</span>

								</div>
								<div class="item-info-product ">
									<h4>
										<a href="single">Party Men's Blazer</a>
									</h4>
									<div class="info-product-price">
										<span class="item_price">$260.99</span>
										<del>$390.71</del>
									</div>
									<div
										class="snipcart-details top_brand_home_details item_add single-item hvr-outline-out button2">
										<form action="#" method="post">
											<fieldset>
												<input type="hidden" name="cmd" value="_cart" /> <input
													type="hidden" name="add" value="1" /> <input type="hidden"
													name="business" value=" " /> <input type="hidden"
													name="item_name" value="Party Men's Blazer" /> <input
													type="hidden" name="amount" value="30.99" /> <input
													type="hidden" name="discount_amount" value="1.00" /> <input
													type="hidden" name="currency_code" value="USD" /> <input
													type="hidden" name="return" value=" " /> <input
													type="hidden" name="cancel_return" value=" " /> <input
													type="submit" name="submit" value="加入购物车" class="button" />
											</fieldset>
										</form>
									</div>

								</div>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>
					<!--//tab_one-->

				</div>
			</div>
		</div>
	</div>
	<!-- //new_arrivals -->
	<!-- /we-offer -->
	<div class="sale-w3ls">
		<div class="container">
			<h6>
				We Offer Flat <span>40%</span> Discount
			</h6>

			<a class="hvr-outline-out button2" href="single">Shop Now </a>
		</div>
	</div>
	<!-- //we-offer -->
	
	<!-- footer -->
	<%@include file="/footer.jsp" %>
	<!-- //footer -->


</html>
