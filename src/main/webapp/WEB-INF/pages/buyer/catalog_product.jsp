<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${!empty catalogProduct}">
	<c:forEach items="${catalogProduct}" var="product">

		<div class="col-md-3 product-men">
			<div class="men-pro-item simpleCart_shelfItem">
				<div class="men-thumb-item">
					<img src="${product.productFile}" alt="" class="pro-image-front"> <img src="${product.productFile}" alt="" class="pro-image-back">
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
					<div class="snipcart-details top_brand_home_details item_add single-item hvr-outline-out button2">
						<form action="#" method="post">
							<fieldset>
								<input type="hidden" name="cmd" value="_cart" /> <input type="hidden" name="add" value="1" /> <input type="hidden" name="business" value=" " /> <input type="hidden" name="item_name" value="Formal Blue Shirt" /> <input type="hidden" name="amount" value="30.99" /> <input type="hidden" name="discount_amount" value="1.00" /> <input type="hidden" name="currency_code" value="USD" /> <input type="hidden" name="return" value=" " /> <input type="hidden" name="cancel_return" value=" " /> <input type="submit" name="submit" value="加入购物车" class="button" />
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
</c:if>