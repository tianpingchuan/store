<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <head>
<title>Home</title>
<jsp:include page="/base.jsp"></jsp:include>
<!--/tags -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript">
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } 

</script>

<!--//tags -->
<link href="assert/css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="assert/css/style.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="assert/css/font-awesome.css" rel="stylesheet">
<link href="assert/css/easy-responsive-tabs.css" rel='stylesheet'
	type='text/css' />
<!-- //for bootstrap working -->
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800"
	rel="stylesheet">
<link
	href='http://fonts.googleapis.com/css?family=Lato:400,100,100italic,300,300italic,400italic,700,900,900italic,700italic'
	rel='stylesheet' type='text/css'>
	
<link href="assert/vendor/jquery-validation/validationEngine.jquery.css" rel="stylesheet">
</head>
<body>
<!-- header -->
	<div class="header" id="home">
		<div class="container">
			<ul>
				<c:if test="${empty userBuyer}">
				<li><a href="#" data-toggle="modal" data-target="#myModal"><i
						class="fa fa-unlock-alt" aria-hidden="true"></i> 登录 </a></li>
				</c:if>
				<c:if test="${empty userBuyer}">
				<li><a href="#" data-toggle="modal" data-target="#myModal2"><i
						class="fa fa-pencil-square-o" aria-hidden="true"></i> 注册 </a></li>
				</c:if>
				
				<c:if test="${!empty userBuyer}">
				<li>
					<a href="user/gopersonal">
					<i class="glyphicon glyphicon-user" aria-hidden="true">
					</i> 个人中心 </a>
				</li>
				</c:if>
				<%-- <c:if test="${!empty userBuyer}">
				<li>
					<a href="">
					<i class="glyphicon glyphicon-shopping-cart" aria-hidden="true">
					</i> 购物车 </a>
				</li>
				</c:if> --%>
				
				<c:if test="${!empty userBuyer}">
					<li><i class="glyphicon glyphicon-user" aria-hidden="true"></i> 
						<a>欢迎：${userBuyer.userName}</a>
					</li>
					<li><i class="glyphicon glyphicon-log-out " aria-hidden="true"></i> 
						<a href="user/loginoutbuyer" id="login_out">退出登录</a>
					</li>
				</c:if>
				
			</ul>
		</div>
	</div>
	<!-- //header -->
	<!-- header-bot -->
	<div class="header-bot">
		<div class="header-bot_inner_wthreeinfo_header_mid">
			<div class="col-md-4 header-middle">
				<form action="#" method="post">
					<input type="search" name="search" placeholder="商品搜索..."
						required=""> <input type="submit" value=" ">
					<div class="clearfix"></div>
				</form>
			</div>
			<!-- header-bot -->
			<div class="col-md-4 logo_agile">
				<h1>
					<a href="index"><span>K</span>精英店 <i
						class="fa fa-shopping-bag top_logo_agile_bag" aria-hidden="true"></i></a>
				</h1>
			</div>
			<!-- header-bot -->
			<div class="col-md-4 agileits-social top_content">
				<ul class="social-nav model-3d-0 footer-social w3_agile_social">
					<li class="share">分享:</li>
					<li><a class="facebook">
							<div class="front">
								<i class="fa fa-facebook" aria-hidden="true"></i>
							</div>
							<div class="back">
								<i class="fa fa-facebook" aria-hidden="true"></i>
							</div>
					</a></li>
					<li><a class="twitter">
							<div class="front">
								<i class="fa fa-twitter" aria-hidden="true"></i>
							</div>
							<div class="back">
								<i class="fa fa-twitter" aria-hidden="true"></i>
							</div>
					</a></li>
					<li><a class="instagram">
							<div class="front">
								<i class="fa fa-instagram" aria-hidden="true"></i>
							</div>
							<div class="back">
								<i class="fa fa-instagram" aria-hidden="true"></i>
							</div>
					</a></li>
					<li><a class="pinterest">
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
	<!-- //header-bot -->
	<!-- banner -->
	<div class="ban-top">
		<div class="container">
			<div class="top_nav_left">
				<nav class="navbar navbar-default">
					<div class="container-fluid">
						<!-- Brand and toggle get grouped for better mobile display -->
						<div class="navbar-header">
							<button type="button" class="navbar-toggle collapsed"
								data-toggle="collapse"
								data-target="#bs-example-navbar-collapse-1"
								aria-expanded="false">
								<span class="sr-only">切换导航</span> <span class="icon-bar"></span>
								<span class="icon-bar"></span> <span class="icon-bar"></span>
							</button>
						</div>
						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse menu--shylock"
							id="bs-example-navbar-collapse-1">
							<ul class="nav navbar-nav menu__list">
								<li class="active menu__item menu__item--current"><a
									class="menu__link" href="index">首页 <span
										class="sr-only">(联系)</span></a></li>
									
								<c:if test="${!empty catalogParentList}">
								<c:forEach items="${catalogParentList}" var="catalog">
								
								<li class="dropdown menu__item"><a href="mens"
									class="dropdown-toggle menu__link" data-toggle="dropdown"
									role="button" aria-haspopup="true" aria-expanded="false"
									href="javascript:;" data-rowId="${catalog.rowId}">${catalog.catalogName}
										<span class="caret"></span>
								</a>
									<ul class="dropdown-menu multi-column columns-3">
										<div class="agile_inner_drop_nav_info">
											<div class="col-sm-6 multi-gd-img1 multi-gd-text ">
												<a href="#"><img src="assert/images/top2.jpg"
													alt=" " /></a>
											</div>
											<div class="col-sm-3 multi-gd-img">
												<ul class="multi-column-dropdown">
													<c:if test="${!empty catalog.catalogList}">
													<c:forEach items="${catalog.catalogList}" var="catalog1">
														<li><a href="#">${catalog1.catalogName} </a></li>
													</c:forEach>
													</c:if>	
												</ul>
											</div>
											<div class="col-sm-3 multi-gd-img">
												<ul class="multi-column-dropdown">
													
												</ul>
											</div>
											<div class="clearfix"></div>
										</div>
									</ul></li>
									
									</c:forEach>
									</c:if>
								
								<li class="menu__item dropdown"><a class="menu__link"
									href="#" class="dropdown-toggle" data-toggle="dropdown">简码
										<b class="caret"></b>
								</a>
									<ul class="dropdown-menu agile_short_dropdown">
										<li><a href="">衣服图标</a></li>
										<li><a href="">样式</a></li>
									</ul></li>
								
							</ul>
						</div>
					</div>
				</nav>
			</div>
			<div class="top_nav_right">
				<div class="wthreecartaits wthreecartaits2 cart cart box_1">
					<form action="#" method="post" class="last">
						<input type="hidden" name="cmd" value="_cart"> <input
							type="hidden" name="display" value="1">
						<button class="w3view-cart" type="submit" name="submit" value="">
							<i class="fa fa-cart-arrow-down" aria-hidden="true"></i>
						</button>
					</form>

				</div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<!-- //banner-top -->
	<!-- Modal1 -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body modal-body-sub_agile">
					<div class="col-md-8 modal_body_left modal_body_left1">
						<h3 class="agileinfo_sign">
							登录 <span>页面</span>
						</h3>
						<form action="" method="post" id="form_login">
							<div class="styled-input agile-styled-input-top">
								<input type="text" name="userCode" required="" class="validate[required]"> <label>用户账号</label>
								<span></span>
							</div>
							<div class="styled-input">
								<input type="password" name="userPass" required="" class="validate[required]"> <label>用户密码</label>
								<span></span>
							</div>
							<input type="checkbox" name="remember" value="1">
							<span>记住密码</span><br/>
							<input type="button" value="登录" id="do_login">
						</form>
						<ul
							class="social-nav model-3d-0 footer-social w3_agile_social top_agile_third">
							<li><a class="facebook">
									<div class="front">
										<i class="fa fa-facebook" aria-hidden="true"></i>
									</div>
									<div class="back">
										<i class="fa fa-facebook" aria-hidden="true"></i>
									</div>
							</a></li>
							<li><a class="twitter">
									<div class="front">
										<i class="fa fa-twitter" aria-hidden="true"></i>
									</div>
									<div class="back">
										<i class="fa fa-twitter" aria-hidden="true"></i>
									</div>
							</a></li>
							<li><a class="instagram">
									<div class="front">
										<i class="fa fa-instagram" aria-hidden="true"></i>
									</div>
									<div class="back">
										<i class="fa fa-instagram" aria-hidden="true"></i>
									</div>
							</a></li>
							<li><a class="pinterest">
									<div class="front">
										<i class="fa fa-linkedin" aria-hidden="true"></i>
									</div>
									<div class="back">
										<i class="fa fa-linkedin" aria-hidden="true"></i>
									</div>
							</a></li>
						</ul>
						<div class="clearfix"></div>
						<p>
							<a href="#" data-toggle="modal" data-target="#myModal2">
								没有账号?</a>
						</p>

					</div>
					<div class="col-md-4 modal_body_right modal_body_right1">
						<img src="assert/images/log_pic.jpg" alt=" " />
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
			<!-- //Modal content-->
		</div>
	</div>
		<!-- //Modal1 -->
	<!-- Modal2 -->
	<div class="modal fade" id="myModal2" tabindex="-1" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body modal-body-sub_agile">
					<div class="col-md-8 modal_body_left modal_body_left1">
						<h3 class="agileinfo_sign">
							立即 <span>注册 </span>
						</h3>
						<form action="#" method="post" id="form_login_add">
							<div class="styled-input agile-styled-input-top">
								<input type="text" name="userName" required="" class="validate[required,ajax[ajaxUserCode]]"> <label>用户名称</label>
								<span></span>
							</div>
							<div class="styled-input">
								<input type="text" name="userCode" required="" class="validate[required]"> <label>用户账号</label>
								<span></span>
							</div>
							<div class="styled-input">
								<input type="password" name="userPass" required="" class="validate[required]"> <label>用户密码</label>
								<span></span>
							</div>
							<div class="styled-input">
								<input type="text" name="userPhone" required="" class="validate[required,custom[phone]]"> <label>用户手机</label>
								<span></span>
							</div>
							<input type="button" value="立即注册" id="login_add">
						</form>
						<ul
							class="social-nav model-3d-0 footer-social w3_agile_social top_agile_third">
							<li><a class="facebook">
									<div class="front">
										<i class="fa fa-facebook" aria-hidden="true"></i>
									</div>
									<div class="back">
										<i class="fa fa-facebook" aria-hidden="true"></i>
									</div>
							</a></li>
							<li><a class="twitter">
									<div class="front">
										<i class="fa fa-twitter" aria-hidden="true"></i>
									</div>
									<div class="back">
										<i class="fa fa-twitter" aria-hidden="true"></i>
									</div>
							</a></li>
							<li><a class="instagram">
									<div class="front">
										<i class="fa fa-instagram" aria-hidden="true"></i>
									</div>
									<div class="back">
										<i class="fa fa-instagram" aria-hidden="true"></i>
									</div>
							</a></li>
							<li><a class="pinterest">
									<div class="front">
										<i class="fa fa-linkedin" aria-hidden="true"></i>
									</div>
									<div class="back">
										<i class="fa fa-linkedin" aria-hidden="true"></i>
									</div>
							</a></li>
						</ul>
						<div class="clearfix"></div>
						<p>
							<a >点击注册，表示同意条款</a>
						</p>

					</div>
					<div class="col-md-4 modal_body_right modal_body_right1">
						<img src="assert/images/log_pic.jpg" alt=" " />
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
			<!-- //Modal content-->
		</div>
	</div>
	<!-- //Modal2 -->