<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<!-- header -->
	<%@include file="/header.jsp" %>

<!-- /banner_bottom_agile_info -->
<div class="page-head_agile_info_w3l">
		<div class="container">
			<h3>Men's <span>Wear  </span></h3>
			<!--/w3_short-->
				 <div class="services-breadcrumb">
						<div class="agile_inner_breadcrumb">

						   <ul class="w3_short">
								<li><a href="index.jsp">Home</a><i>|</i></li>
								<li>Men's Wear</li>
							</ul>
						 </div>
				</div>
	   <!--//w3_short-->
	</div>
</div>

  <!-- banner-bootom-w3-agileits -->
	<div class="banner-bootom-w3-agileits">
	<div class="container">
         <!-- mens -->
		
	<div class="single-pro">
		
		
					<!-- 商品 -->
			<h3 class="wthree_text_info">
				全部 <span>目录商品</span>
			</h3>

			<c:if test="${!empty productCatalog}">
				<c:forEach items="${productCatalog}" var="product">

					<div class="col-md-3 product-men">
						<div class="men-pro-item simpleCart_shelfItem">
							<div class="men-thumb-item">
								<img src="${product.productFile}" alt="" class="pro-image-front"> <img src="${product.productFile}" alt="" class="pro-image-back">
								<div class="men-cart-pro">
									<div class="inner-men-cart-pro">
										<a  href="javascript:;" data-rowId="${product.rowId}" class="productfind link-product-add-cart">立即购买</a>
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
								<div class="snipcart-details top_brand_home_details item_add single-item hvr-outline-out button2">
									<form action="#" method="post">
										<fieldset>
											<input type="hidden" name="cmd" value="_cart" /> <input type="hidden" name="add" value="1" /> <input type="hidden" name="business" value=" " /> <input type="hidden" name="item_name" value="${product.productName}" /> <input type="hidden" name="amount" value="${product.productPrice}" /> <input type="hidden" name="discount_amount" value="0.00" /> <input type="hidden" name="currency_code" value="USD" /> <input type="hidden" name="return" value=" " /> <input type="hidden" name="cancel_return" value=" " /> <input type="submit" name="submit" value="加入购物车" class="button" />
										</fieldset>
									</form>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</c:if>


		</div>
		
		
		
	</div>
</div>	
<!-- //mens -->
	<!-- footer -->
	<%@include file="/footer.jsp" %>
	<!-- //footer -->


</html>
