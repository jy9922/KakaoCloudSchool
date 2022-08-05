/**
 * 
 */
 
 function showPopup(){
	var popupX = (window.screen.width / 2) - (700 / 2);
	var popupY= (window.screen.height  / 2) - (500 / 2);
	window.open("board/insert.jsp","a","width=700, height=500, left="+ popupX + ", top="+ popupY);
	

}