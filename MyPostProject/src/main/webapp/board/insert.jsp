<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="user.vo.User"%>
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
<main class="form-signin w-500 m-auto">  
	<h2>게시물 작성</h2>
	<form action="/post/post" method="post">
		<div class="mb-3 mt-5">
	    	<label for="userid" class="form-label">사용자</label>
	    	<% 
	    		User user = (User)session.getAttribute("user");
	    		session.setAttribute("user",user); 	
	    	%>
	    	<input type="text" class="form-control" id="userid" name="userid" value="<%=user.getId()%>" readonly>
	    </div>
    	<div class="mb-3 mt-4">
	    	<label for="title" class="form-label">글 제목</label>
	    	<input type="text" class="form-control" id="title" placeholder="게시물 제목을 작성해주세요." name="btitle">
	    </div>
	    <div class="mb-3 mt-2">
	  		<label for="comment">글작성</label>
			<textarea class="form-control" rows="5" id="bdetail" name="bdetail"></textarea>
		</div>
  	<button type="submit" class="btn btn-primary mt-5">글작성</button>
	</form>
</main>
</body>
</html>