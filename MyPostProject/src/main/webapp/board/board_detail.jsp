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
	<h2>게시글</h2>
	<form action="/post/post" method="post">
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
	    	<input type="text" class="form-control" id="title"  name="btitle" value="<%=post.getBtitle()%>" readonly="True">
	    </div>
	    <div class="mb-3 mt-2">
	  		<label for="comment">내용</label>
			<textarea class="form-control" rows="5" id="bdetail" name="bdetail" readonly="True"><%=post.getBdetail()%></textarea>
		</div>
		<div class="mb-3 mt-2 text-end">
			<p><%=post.getBdate()%></p>
			<span>조회수 : <%=post.getBview()%>  </span>
			<span>좋아요 : <%=post.getBlike()%>  </span>
			<span>댓글수 : <%=post.getBcount()%>  </span>
		</div>
			<% 
			    System.out.println(user.getId());
				if (user.getId().equals(post.getBid())){		
			%>
				<div class="text-end">
					<span><a class="btn btn-primary mt-3" href="/post/modify?bNum=<%=post.getBnum()%>">글수정</a></span>
					<span><a type="submit" class="btn btn-primary mt-3" href="board/board_modify.jsp">글삭제</a></span>
				</div>
			<%}%>
	</form>
</main>
</body>
</html>