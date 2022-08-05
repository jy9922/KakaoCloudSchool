<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*, book.vo.Book"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
 	<meta name="description" content="">
    <title>도서검색 프로그램</title>
   	
   	<!-- Bootstrap CDN -->
   	<!-- CSS only -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
	
	<!-- JQuery CDN -->
	<script src="https://code.jquery.com/jquery-2.2.4.min.js" integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44=" crossorigin="anonymous"></script>
    <!-- Custom JS -->
    <script src="/book/book/js/bookSearch.js"></script>
    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }

      .b-example-divider {
        height: 3rem;
        background-color: rgba(0, 0, 0, .1);
        border: solid rgba(0, 0, 0, .15);
        border-width: 1px 0;
        box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
      }

      .b-example-vr {
        flex-shrink: 0;
        width: 1.5rem;
        height: 100vh;
      }

      .bi {
        vertical-align: -.125em;
        fill: currentColor;
      }

      .nav-scroller {
        position: relative;
        z-index: 2;
        height: 2.75rem;
        overflow-y: hidden;
      }

      .nav-scroller .nav {
        display: flex;
        flex-wrap: nowrap;
        padding-bottom: 1rem;
        margin-top: -1px;
        overflow-x: auto;
        text-align: center;
        white-space: nowrap;
        -webkit-overflow-scrolling: touch;
      }
    </style>

    
    <!-- Custom styles for this template -->
    <link href="dashboard.css" rel="stylesheet">
  </head>
  <body>
	<header class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
	  <a class="navbar-brand col-md-3 col-lg-2 me-0 px-3 fs-6" href="#">로그인 이름</a>
	  <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
  	  <input id="searchKeyword" class="form-control form-control-dark w-100 rounded-0 border-0" type="text" placeholder="Search" aria-label="Search">
	  <div class="navbar-nav">
	    <div class="nav-item text-nowrap">
	      <a class="nav-link px-3" href="javascript:search()">Search</a>
	    </div>
	  </div>
	</header>

	<div class="container-fluid">
	  <div class="row">
	    <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
	      <div class="position-sticky pt-3 sidebar-sticky">
	        <ul class="nav flex-column">
	        </ul>
	        <ul class="nav flex-column mb-2">
	        </ul>
	      </div>
	    </nav>

    <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
      <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
      </div>

      <h2>검색결과</h2>
      <div class="table-responsive">
        <table class="table table-striped table-sm">
          <thead>
            <tr>
              <th scope="col">책표지</th>
              <th scope="col">책제목</th>
              <th scope="col">책저자</th>
              <th scope="col">책가격</th>
              <th scope="col">삭제</th>
            </tr>
          </thead>
          <tbody>
          <% 
          	ArrayList<Book> list = (ArrayList<Book>)request.getAttribute("result");
          	for(Book book : list){
          			
          %>
            <tr>
              <td><img src="<%=book.getBimgurl()%>"></td>
              <td><%=book.getBtitle()%></td>
              <td><%=book.getBauthor()%></td>
              <td><%=book.getBprice()%></td>
              <td><a class="nav-link px-3" href="javascript:delete_book(<%=(String)book.getBisbn()%>)">삭제</a></td>
            </tr>
           <% } %>
          </tbody>
        </table>
      </div>
    </main>
  </div>
</div>
</body>
</html>

