$(function(){
	$("[add]").click(function(){
		MyLayer.open({
			title : $(this).attr("title"),
			content : $(this).attr("content"),
			area : [ '400px', '305px' ]
		});
	});
});