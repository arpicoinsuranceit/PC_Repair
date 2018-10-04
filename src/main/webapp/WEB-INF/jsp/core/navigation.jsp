<%@page import="com.arpico.groupit.pc_repair.dto.MenuDto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<body>

	<header class="main-header">
		<a href="${path}/home" class="logo"> <span class="logo-mini"><img
				src="${path}/images/logo.png" style="width: 30px; margin-top: 15px;"></span>
			<span class="logo-lg"><img src="${path}/images/logo.png"
				style="height: 40px; margin-top: 5px;"></span>
		</a>

		<nav class="navbar navbar-static-top" role="navigation">
			<a href="#" class="sidebar-toggle" data-toggle="push-menu"
				role="button"> <span class="sr-only">Toggle navigation</span>
			</a>
			<div class="navbar-custom-menu">
				<ul class="nav navbar-nav">
					<li class="dropdown user user-menu"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown"> <img
							src="${path}/dist/img/user2-160x160.jpg" class="user-image"
							alt="User Image"> <span class="hidden-xs">${user.userName}</span>
					</a>
						<ul class="dropdown-menu">
							<!-- User image -->
							<li class="user-header" style="background: #213E9A"><img
								src="${path}/dist/img/user2-160x160.jpg" class="img-circle"
								alt="User Image">

								<p>
									${user.userName}
									<small>
									
									</small>
								</p></li>
							<!-- Menu Body -->
							
							<!-- Menu Footer-->
							<li class="user-footer">
								
								<div class="pull-right">
									<a href="${path}/logout" class="btn btn-default btn-flat">Sign out</a>
								</div>
							</li>
						</ul></li>
				</ul>
			</div>
		</nav>
	</header>

	<aside class="main-sidebar">

		<section class="sidebar">

			<ul class="sidebar-menu" data-widget="tree">
				<li class="header">MAIN NAVIGATION</li>

				<c:forEach items="${user.menuDtos}" var="menu">
					<c:if test="${menu.menuName eq 'Repairs'}">
						<li class="treeview"><a href="${menu.href}"><i
								class="${menu.icon}"></i> <span>${menu.menuDescription}</span> <span
								class="pull-right-container"> <i
									class="fa fa-angle-left pull-right"></i></span> </a>
							<ul class="treeview-menu">
								<c:forEach var="subMenu" items="${user.menuDtos}">
									<c:if test="${menu.menuId eq subMenu.parent}">
										<li><a href="${path}/${subMenu.href}"><i
												class="fa fa-circle-thin"></i> <span>${subMenu.menuDescription}</span></a></li>
									</c:if>
								</c:forEach>
							</ul></li>
						<li class="header"></li>
					</c:if>
				</c:forEach>

				<c:set var="br1" value="false"></c:set>

				<c:forEach items="${user.menuDtos}" var="menu">
					<c:if
						test="${menu.menuName eq 'Assets' or menu.menuName eq 'Parts' or menu.menuName eq 'Backups'}">

						<li class="treeview"><a href="${menu.href}"><i
								class="${menu.icon}"></i> <span>${menu.menuDescription}</span> <span
								class="pull-right-container"> <i
									class="fa fa-angle-left pull-right"></i></span> </a>
							<ul class="treeview-menu">
								<c:forEach var="subMenu" items="${user.menuDtos}">
									<c:if test="${menu.menuId eq subMenu.parent}">
										<li><a href="${path}/${subMenu.href}"><i
												class="fa fa-circle-thin"></i> <span>${subMenu.menuDescription}</span></a></li>
									</c:if>
								</c:forEach>
							</ul></li>
						<c:set var="br1" value="true"></c:set>
					</c:if>
				</c:forEach>

				<c:if test="${br1 eq true}">
					<li class="header"></li>
				</c:if>

				<c:set var="br2" value="false"></c:set>

				<c:forEach items="${user.menuDtos}" var="menu">
					<c:if
						test="${menu.menuName eq 'Supplier' or menu.menuName eq 'Assignee' or menu.menuName eq 'Errors'}">

						<li class="treeview"><a href="${menu.href}"><i
								class="${menu.icon}"></i> <span>${menu.menuDescription}</span> <span
								class="pull-right-container"> <i
									class="fa fa-angle-left pull-right"></i></span> </a>
							<ul class="treeview-menu">
								<c:forEach var="subMenu" items="${user.menuDtos}">
									<c:if test="${menu.menuId eq subMenu.parent}">
										<li><a href="${path}/${subMenu.href}"><i
												class="fa fa-circle-thin"></i> <span>${subMenu.menuDescription}</span></a></li>
									</c:if>
								</c:forEach>
							</ul></li>
						<c:set var="br2" value="true"></c:set>
					</c:if>
				</c:forEach>

				<c:if test="${br2 eq true}">
					<li class="header"></li> --%>
				</c:if>
			</ul>
		</section>
	</aside>
</body>

</html>
