<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<!-- header -->
<%@include file="/header.jsp"%>

<!--/single_page-->
<!-- /banner_bottom_agile_info -->
<div class="page-head_agile_info_w3l">
	<div class="container">
		<h3>
			Single <span>Page </span>
		</h3>
		<!--/w3_short-->
		<div class="services-breadcrumb">
			<div class="agile_inner_breadcrumb">

				<ul class="w3_short">
					<li><a href="page/index">Home</a><i>|</i></li>
					<li>Single Page</li>
				</ul>
			</div>
		</div>
		<!--//w3_short-->
	</div>
</div>

<!-- banner-bootom-w3-agileits -->
<div class="banner-bootom-w3-agileits">
	<div class="container">
		<div class="col-md-4 single-right-left ">
			<div class="grid images_3_of_2">
				<div class="flexslider">

					<ul class="slides">
						<li data-thumb="/store/assert/images/d2.jpg">
							<div class="thumb-image">
								<img src="/store/assert/images/d2.jpg" data-imagezoom="true" class="img-responsive">
							</div>
						</li>
						<li data-thumb="/store/assert/images/d1.jpg">
							<div class="thumb-image">
								<img src="/store/assert/images/d1.jpg" data-imagezoom="true" class="img-responsive">
							</div>
						</li>
						
					</ul>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
		<div class="col-md-8 single-right-left simpleCart_shelfItem">
			<h3>Big Wing Sneakers (Navy)</h3>
			<p>
				<span class="item_price">$650</span>
				<del>- $900</del>
			</p>
			<div class="rating1">
				<span class="starRating"> <input id="rating5" type="radio" name="rating" value="5"> <label for="rating5">5</label> <input id="rating4" type="radio" name="rating" value="4"> <label for="rating4">4</label> <input id="rating3" type="radio" name="rating" value="3" checked=""> <label for="rating3">3</label> <input id="rating2" type="radio" name="rating" value="2"> <label for="rating2">2</label> <input id="rating1" type="radio" name="rating" value="1"> <label for="rating1">1</label>
				</span>
			</div>
			
			<div class="rating1">
				<a>-</a>
				<input type="text" value="1" readonly="readonly" style="width: 50px;text-align: center;"/>
				<a>+</a>
			</div>
			
			
			
			
			
			<div class="occasion-cart">
				<div class="snipcart-details top_brand_home_details item_add single-item hvr-outline-out button2">
					<form action="#" method="post">
						<fieldset>
							<input type="hidden" name="cmd" value="_cart"> 
							<input type="hidden" name="add" value="1"> 
							<input type="hidden" name="business" value=" "> 
							<input type="hidden" name="item_name" value="Wing Sneakers"> 
			 				<input type="hidden" name="amount" value="650.00"> 
							<input type="hidden" name="discount_amount" value="1.00"> 
							<input type="hidden" name="currency_code" value="USD"> 
							<input type="hidden" name="return" value=" "> 
							<input type="hidden" name="cancel_return" value=" "> 
							<input type="submit" name="submit" value="Add to cart" class="button">
						</fieldset>
					</form>
				</div>

			</div>
			<ul class="social-nav model-3d-0 footer-social w3_agile_social single_page_w3ls">
				<li class="share">Share On :</li>
				<li><a href="#" class="facebook">
						<div class="front">
							<i class="fa fa-facebook" aria-hidden="true"></i>
						</div>
						<div class="back">
							<i class="fa fa-facebook" aria-hidden="true"></i>
						</div>
				</a></li>
				<li><a href="#" class="twitter">
						<div class="front">
							<i class="fa fa-twitter" aria-hidden="true"></i>
						</div>
						<div class="back">
							<i class="fa fa-twitter" aria-hidden="true"></i>
						</div>
				</a></li>
				<li><a href="#" class="instagram">
						<div class="front">
							<i class="fa fa-instagram" aria-hidden="true"></i>
						</div>
						<div class="back">
							<i class="fa fa-instagram" aria-hidden="true"></i>
						</div>
				</a></li>
				<li><a href="#" class="pinterest">
						<div class="front">
							<i class="fa fa-linkedin" aria-hidden="true"></i>
						</div>
						<div class="back">
							<i class="fa fa-linkedin" aria-hidden="true"></i>
						</div>
				</a></li>
			</ul>

		</div>
		<div class="clearfix"></div>


	</div>
</div>
</div>
<!--//single_page-->

<!-- footer -->
<%@include file="/footer.jsp"%>
<!-- //footer -->


</html>
