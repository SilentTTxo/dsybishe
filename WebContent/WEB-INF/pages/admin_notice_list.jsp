<!-- <%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>-->
<!DOCTYPE html>

<!-- 

Template Name: Metronic - Responsive Admin Dashboard Template build with Twitter Bootstrap 2.3.1

Version: 1.3

Author: KeenThemes

Website: http://www.keenthemes.com/preview/?theme=metronic

Purchase: http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469

-->

<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->

<!--[if !IE]><!--> <html lang="en" class="no-js"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

	<meta charset="utf-8" />

	<title>今天麻麻不在家管理后台</title>

	<meta content="width=device-width, initial-scale=1.0" name="viewport" />

	<meta content="" name="description" />

	<meta content="" name="author" />

	<!-- BEGIN GLOBAL MANDATORY STYLES -->

	<link href="media/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

	<link href="media/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css"/>

	<link href="media/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>

	<link href="media/css/style-metro.css" rel="stylesheet" type="text/css"/>

	<link href="media/css/style.css" rel="stylesheet" type="text/css"/>

	<link href="media/css/style-responsive.css" rel="stylesheet" type="text/css"/>

	<link href="media/css/default.css" rel="stylesheet" type="text/css" id="style_color"/>

	<link href="media/css/uniform.default.css" rel="stylesheet" type="text/css"/>

	<!-- END GLOBAL MANDATORY STYLES -->

	<!-- BEGIN PAGE LEVEL STYLES --> 

	<link href="media/css/jquery.gritter.css" rel="stylesheet" type="text/css"/>

	<link href="media/css/daterangepicker.css" rel="stylesheet" type="text/css" />

	<link href="media/css/fullcalendar.css" rel="stylesheet" type="text/css"/>

	<link href="media/css/jqvmap.css" rel="stylesheet" type="text/css" media="screen"/>

	<link href="media/css/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen"/>

	<!-- END PAGE LEVEL STYLES -->

	<link rel="shortcut icon" href="media/image/favicon.ico" />

</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body class="page-header-fixed">

	<!-- BEGIN HEADER -->

	<div class="header navbar navbar-inverse navbar-fixed-top">

		<!-- BEGIN TOP NAVIGATION BAR -->

		<div class="navbar-inner">

			<div class="container-fluid">

				<!-- BEGIN LOGO -->

				<a class="brand" href="index.html">

				<img src="media/image/logo.png" alt="logo"/>

				</a>

				<!-- END LOGO -->

				<!-- BEGIN RESPONSIVE MENU TOGGLER -->

				<a href="javascript:;" class="btn-navbar collapsed" data-toggle="collapse" data-target=".nav-collapse">

				<img src="media/image/menu-toggler.png" alt="" />

				</a>          

				<!-- END RESPONSIVE MENU TOGGLER -->            

				<!-- BEGIN TOP NAVIGATION MENU -->              

				<ul class="nav pull-right">


					<!-- BEGIN USER LOGIN DROPDOWN -->

					<li class="dropdown user">

						<a href="#" class="dropdown-toggle" data-toggle="dropdown">


						<span class="username">管理员</span>

						<i class="icon-angle-down"></i>

						</a>

						<ul class="dropdown-menu">
							
							<li><a href="login.html"><i class="icon-key"></i> 退出登陆</a></li>

						</ul>

					</li>

					<!-- END USER LOGIN DROPDOWN -->

				</ul>

				<!-- END TOP NAVIGATION MENU --> 

			</div>

		</div>

		<!-- END TOP NAVIGATION BAR -->

	</div>

	<!-- END HEADER -->

	<!-- BEGIN CONTAINER -->

	<div class="page-container">

		<!-- BEGIN SIDEBAR -->

		<div class="page-sidebar nav-collapse collapse">

			<!-- BEGIN SIDEBAR MENU -->        

<ul class="page-sidebar-menu">

				<li>

					<!-- BEGIN SIDEBAR TOGGLER BUTTON -->

					<div class="sidebar-toggler hidden-phone"></div>

					<!-- BEGIN SIDEBAR TOGGLER BUTTON -->

				</li>

				<li class="start ">

					<a href="admin.html">

					<i class="icon-home"></i> 

					<span class="title">主页</span>

					<span class="selected"></span>

					</a>

				</li>

				<li>

					<a href="javascript:;">

					<i class="icon-cogs"></i> 

					<span class="title">用户管理</span>

					<span class="arrow "></span>

					</a>

					<ul class="sub-menu">

						<li >

							<a href="admin_user_add.html">

							新增用户</a>

						</li>

						<li>

							<a href="admin_user_power.html">

							权限管理</a>

						</li>

						<li>

							<a href="admin_user_list.html">

							用户列表</a>

						</li>

					</ul>

				</li>

				<li class="">

					<a href="javascript:;">

					<i class="icon-bookmark-empty"></i> 

					<span class="title">商品管理</span>

					<span class="arrow "></span>

					</a>

					<ul class="sub-menu">

						<li >

							<a href="admin_goods_add.html">

							新增商品</a>

						</li>

						<li >

							<a href="admin_goods_list.html">

							商品列表</a>

						</li>

						<li >

							<a href="admin_goods_setmeal.html">

							新增套餐</a>

						</li>
						<li><a href="admin_goods_setIsSell.html">上架商品</a></li>

					</ul>

				</li>

				<li class="">

					<a href="javascript:;">

					<i class="icon-table"></i> 

					<span class="title">订单管理</span>

					<span class="arrow "></span>

					</a>

					<ul class="sub-menu">

						<li >

							<a href="admin_order_list.html">

							订单列表</a>

						</li>

						<li >

							<a href="admin_order_add.html">

							新增订单</a>

						</li>
						<li ><a href="admin_order_state.html">订单状态管理</a></li>
						<li ><a href="admin_order_serch.html">按订单号查询</a></li>
						<li ><a href="admin_order_pay.html">充值订单</a></li>

					</ul>

				</li>

				<li>

					<a href="javascript:;">

					<i class="icon-briefcase"></i> 

					<span class="title">广告管理</span>

					<span class="arrow "></span>

					</a>

					<ul class="sub-menu">

						<li>

							<a href="admin_ad_list.html">

							<i class="icon-time"></i>

							广告列表</a>

						</li>

						<li >

							<a href="admin_ad_add.html">

							<i class="icon-cogs"></i>

							新增广告</a>

						</li>

					</ul>

				</li>

				<li class="active">

					<a href="javascript:;">

					<i class="icon-gift"></i> 

					<span class="title">系统通知</span>

					<span class="arrow "></span>

					</a>

					<ul class="sub-menu">

						<li class="active">

							<a href="admin_notice_list.html">

							通知列表</a>

						</li>

						<li >

							<a href="admin_notice_add.html">

							新增通知</a>

						</li>


					</ul>

				</li>

			</ul>

			<!-- END SIDEBAR MENU -->

		</div>

		<!-- END SIDEBAR -->

		<!-- BEGIN PAGE -->

		<div class="page-content">

			<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->

			<div id="portlet-config" class="modal hide">

				<div class="modal-header">

					<button data-dismiss="modal" class="close" type="button"></button>

					<h3>Widget Settings</h3>

				</div>

				<div class="modal-body">

					Widget settings form goes here

				</div>

			</div>

			<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->

			<!-- BEGIN PAGE CONTAINER-->

			<div class="container-fluid">

				<!-- BEGIN PAGE HEADER-->

				<div class="row-fluid">

					<div class="span12">
    

						<!-- BEGIN PAGE TITLE & BREADCRUMB-->

						<h3 class="page-title">

							主页 <small>信息总览</small>

						</h3>

						<ul class="breadcrumb">

							<li>

								<i class="icon-home"></i>

								<a href="index.html">Home</a> 

								<i class="icon-angle-right"></i>

							</li>

							<li><a href="#">通知管理</a><i class="icon-angle-right"></i></li>

							<li><a href="#">通知列表</a></li>

							<li class="pull-right no-text-shadow">

								<div id="dashboard-report-range" class="dashboard-date-range tooltips no-tooltip-on-touch-device responsive" data-tablet="" data-desktop="tooltips" data-placement="top" data-original-title="Change dashboard date range">

									<i class="icon-calendar"></i>

									<span></span>

									<i class="icon-angle-down"></i>

								</div>

							</li>

						</ul>

						<!-- END PAGE TITLE & BREADCRUMB-->

					</div>

				</div>

				<!-- END PAGE HEADER-->
				
				<div class="portlet box green">

							<div class="portlet-title">

								<div class="caption"><i class="icon-cogs"></i>通知列表</div>

								<div class="tools">

									<a href="javascript:;" class="collapse"></a>

									<a href="#portlet-config" data-toggle="modal" class="config"></a>

									<a href="javascript:;" class="reload"></a>

									<a href="javascript:;" class="remove"></a>

								</div>

							</div>

							<div class="portlet-body">

								<table class="table table-hover">

									<thead>

										<tr>

											<th>ID</th>

											<th>标题</th>

											<th>描述</th>

											<th>类型</th>

											<th>发布时间</th>

											<th>链接</th>
											
											<th></th>


										</tr>

									</thead>

									<tbody>
										<!-- data -->
										

									</tbody>

								</table>

							</div>

						</div>

			</div>

			<!-- END PAGE CONTAINER-->    

		</div>

		<!-- END PAGE -->

	</div>

	<!-- END CONTAINER -->

	<!-- BEGIN FOOTER -->

	<div class="footer">

		<div class="footer-inner">

			2013 &copy; Metronic by keenthemes.

		</div>

		<div class="footer-tools">

			<span class="go-top">

			<i class="icon-angle-up"></i>

			</span>

		</div>

	</div>

	<!-- END FOOTER -->

	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->

	<!-- BEGIN CORE PLUGINS -->

	<script src="media/js/jquery-1.10.1.min.js" type="text/javascript"></script>

	<script src="media/js/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>

	<!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->

	<script src="media/js/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>      

	<script src="media/js/bootstrap.min.js" type="text/javascript"></script>

	<!--[if lt IE 9]>

	<script src="media/js/excanvas.min.js"></script>

	<script src="media/js/respond.min.js"></script>  

	<![endif]-->   

	<script src="media/js/jquery.slimscroll.min.js" type="text/javascript"></script>

	<script src="media/js/jquery.blockui.min.js" type="text/javascript"></script>  

	<script src="media/js/jquery.cookie.min.js" type="text/javascript"></script>

	<script src="media/js/jquery.uniform.min.js" type="text/javascript" ></script>

	<!-- END CORE PLUGINS -->

	<!-- BEGIN PAGE LEVEL PLUGINS -->

	<script src="media/js/jquery.vmap.js" type="text/javascript"></script>   

	<script src="media/js/jquery.vmap.russia.js" type="text/javascript"></script>

	<script src="media/js/jquery.vmap.world.js" type="text/javascript"></script>

	<script src="media/js/jquery.vmap.europe.js" type="text/javascript"></script>

	<script src="media/js/jquery.vmap.germany.js" type="text/javascript"></script>

	<script src="media/js/jquery.vmap.usa.js" type="text/javascript"></script>

	<script src="media/js/jquery.vmap.sampledata.js" type="text/javascript"></script>  

	<script src="media/js/jquery.flot.js" type="text/javascript"></script>

	<script src="media/js/jquery.flot.resize.js" type="text/javascript"></script>

	<script src="media/js/jquery.pulsate.min.js" type="text/javascript"></script>

	<script src="media/js/date.js" type="text/javascript"></script>

	<script src="media/js/daterangepicker.js" type="text/javascript"></script>     

	<script src="media/js/jquery.gritter.js" type="text/javascript"></script>

	<script src="media/js/fullcalendar.min.js" type="text/javascript"></script>

	<script src="media/js/jquery.easy-pie-chart.js" type="text/javascript"></script>

	<script src="media/js/jquery.sparkline.min.js" type="text/javascript"></script>  

	<!-- END PAGE LEVEL PLUGINS -->

	<!-- BEGIN PAGE LEVEL SCRIPTS -->

	<script src="media/js/app.js" type="text/javascript"></script>

	<script src="media/js/index.js" type="text/javascript"></script>        

	<!-- END PAGE LEVEL SCRIPTS -->  

	<script>
	String.prototype.format = function(args) {
    var result = this;
    if (arguments.length > 0) {    
        if (arguments.length == 1 && typeof (args) == "object") {
            for (var key in args) {
                if(args[key]!=undefined){
                    var reg = new RegExp("({" + key + "})", "g");
                    result = result.replace(reg, args[key]);
                }
            }
        }
        else {
            for (var i = 0; i < arguments.length; i++) {
                if (arguments[i] != undefined) {
                    //var reg = new RegExp("({[" + i + "]})", "g");//这个在索引大于9时会有问题，谢谢何以笙箫的指出
　　　　　　　　　　　　var reg= new RegExp("({)" + i + "(})", "g");
                    result = result.replace(reg, arguments[i]);
                }
            }
        }
    }
    return result;
}
	showMsg = function(data){
			$.gritter.add({
				title: "提示",
				text: data,
				sticky: false,
				time: '2000'
			});
		}
	flush = function(){
		$.ajax({
			type:"GET",
			url:"./api/notice/getAll",
			success : function(result){
				result = jQuery.parseJSON(result);
				if(result['code'] == "1"){
					showMsg("刷新成功");
					notice = result['notice'];
					for(i in notice){
						$("tbody").append('<tr><td>{id}</td><td>{title}</td><td>{describe}</td><td>{type}</td><td>{time}</td><td>{url}</td><td><a href="javascript:" class="btn mini black del" data="{id}"><i class="icon-trash"></i>删除</a></td></tr>'.format(notice[i]));
					}
					$(".del").click(function(){
						$.ajax({
							type:"GET",
							url:"./api/notice/del?id="+$(this).attr("data"),
							success : function(result){
								result = jQuery.parseJSON(result);
								if(result['code'] == "1"){
									showMsg("删除成功");
									$(".reload").click();
								}
								else{
									showMsg("系统故障")
								}
							}
						})
					})
				}
				else{
					showMsg("系统故障")
				}
			}
		})
	}
		jQuery(document).ready(function() {    

		   App.init(); // initlayout and core plugins

		   flush();

		   $(".reload").click(function(){
		   		$("tbody").empty();
		   		flush();
		   })


		});
	</script>

	<!-- END JAVASCRIPTS -->

<!-- END BODY -->

</html>