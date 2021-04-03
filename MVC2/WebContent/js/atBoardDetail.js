/**
 * 
 */

window.onload=function(){
	var selMBtn = document.querySelector('.modify');
	var selDBtn = document.querySelector('.delete');
	var selLBtn = document.querySelector('.like');
	var selForm = document.querySelector('form');
	console.log(selMBtn)
	selMBtn.onclick=function(){
		selForm.setAttribute("action", "modifyBoard.bo");
		selForm.setAttribute("method", "post");
	}
	selDBtn.onclick=function(){
		selForm.setAttribute("action", "deleteBoard.bo");
		selForm.setAttribute("method", "post");
	}
	selLBtn.onclick=function(){
		selForm.setAttribute("action", "likeAction.bo");
		selForm.setAttribute("method", "post");
	}
}