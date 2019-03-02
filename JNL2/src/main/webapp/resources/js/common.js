/**
 * 
 */

function ajax(url,type,dataType,data,success,error){
	$.ajax({
		url : url,
		type : type,
		dataType : dataType,
		data : data,
		success : success,
		error : error
	})
}
function ajaxTypeAsync(url,type,dataType,data,success,error){
	$.ajax({
		url : url,
		type : type,
		dataType : dataType,
		data : data,
		async : false,
		success : success,
		error : error
	})
}

function ajaxTypeFile(url,type,dataType,data,success,error){
	console.log(data)
	$.ajax({
		url : url,
		type : type,
		dataType : dataType,
		data : data,
		processData : false,
		contentType : false,
		success : success,
		error : error
	})
}