/**
 * 
 */

window.onload=function(){
	var selMBtn = document.querySelector('.update');
	var selDBtn = document.querySelector('.delete');
	var selForm = document.querySelector('form');
	console.log(selMBtn)
	selMBtn.onclick=function(){
		selForm.setAttribute("action", "updateMember.me");
		selForm.setAttribute("method", "post");
	}
	selDBtn.onclick=function(){
		selForm.setAttribute("action", "removeMember.me");
		selForm.setAttribute("method", "post");
	}
}