/**
 * 
 */
function search(){
	let keyword = $("#searchKeyword").val();
	// servlet 호출 url
	let requestURL = "/book/bsearch" + "?keyword=" + keyword;
	
	// 현재 브라우저의 주소를 바꿈
	window.location.href = requestURL;
	
}

function delete_book(isbn){
	console.log(isbn);
}