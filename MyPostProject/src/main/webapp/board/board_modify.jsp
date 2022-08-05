<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="post.vo.Post, user.vo.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<style>
.form-signin {
  max-width: 1000px;
  padding: 15px;
}	
</style>
</head>
<body>
<main class="form-signin w-800 m-auto">  
	<h2>게시글 수정</h2>
	<form action="/post/modifySuccess" method="post">
		<div class="mb-3 mt-5">
	    	<label for="userid" class="form-label">작성자</label>
	    	<% 
	    		Post post = (Post)request.getAttribute("post");
	    		User user = (User)session.getAttribute("user");
	    		session.setAttribute("user",user);
	    	%>
	    	<input type="text" class="form-control" id="userid" name="userid" value="<%=post.getBid()%>" readonly="True">
	    </div>
    	<div class="mb-3 mt-4">
	    	<label for="title" class="form-label">글 제목</label>
	    	<input type="text" class="form-control" id="title"  name="btitle" value="<%=post.getBtitle()%>">
	    </div>
	    <div class="mb-3 mt-2">
	  		<label for="comment">내용</label>
			<textarea class="form-control" rows="5" id="bdetail" name="bdetail"><%=post.getBdetail()%></textarea>
		</div>
		<input type="text" class="form-control" id="bnum" name="bnum" value="<%=post.getBnum()%>" hidden="true">
		<div class="mb-3 mt-2 text-end">
			<p><%=post.getBdate()%></p>
			<span>조회수 : <%=post.getBview()%>  </span>
			<span>좋아요 : <%=post.getBlike()%>  </span>
			<span>댓글수 : <%=post.getBcount()%>  </span>
		</div>
		<div class="text-end">
				<span><button type="submit" class="btn btn-primary mt-3">수정완료</a></span>
		</div>
			
	</form>
</main>
</body>
</html>