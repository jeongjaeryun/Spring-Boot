<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 업로드</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
</head>
<body>
	<!--
	<form enctype="multipart/form-data"> <%-- 이미지 보낼땐 form 태그 많이씀 --%>
		<input type="file" name="images" multiple>
		<button type="submit">전송</button>
	</form>
	  -->

	  <div>
	  	<input name="uploadFiles" type="file" multiple>
	  	<button class="uploadBtn">Upload</button>
	  </div>

	  <script>
	  	document.querySelector('.uploadBtn')
	  			.addEventListener('click', function(e){

						//js에서 form안의 데이터 보낼때 FormDate 클래스를 씀(form안의 네임과 밸류가 다 들어감)
	  				let formData = new FormData(); //jQuery.serialize() or jQuery.serializeArray()랑 유사함
						// 1) Form 태그 내부의 데이터를 한번에 담음
						// 2) Ajax를 이용해서 'content-type:multipart/form-data'를 보내는 경우

						let imageFile = document.querySelector('input[type="file"]');
						let fileList = imageFile.files;

						for(let file of fileList){
							formData.append("uploadFiles", file); //append 이용해 내용 집어넣음

						}
						//fetch
						fetch('uploadsAjax', { 
							method : 'post',
							body: formData
						})
						.then(response => response.json())
						.then(data => console.log(data))
						.catch(err => console.log(err)); 
						
						//jQuery.ajax
				           $.ajax({
				               url: 'uploadsAjax',	
				               type: 'POST',
				               processData: false,	//기본값은 true, ajax 통신을 통해 데이터를 전송할 때, 기본적으로 key와 value값을 Query String으로 변환해서 보냅니다.
				               contentType: false,	// multipart/form-data타입을 사용하기위해 false 로 지정합니다.
				               data: formData,               
				               success: function(result){
				                   //console.log(result);
				                   for(let image of result){
				                	   let imgTag = $('<img/>').prop('src','images/'+ image).css('width', '50%');
				                	   
				                	   $('div').append(imgTag);
				                   }
				               },
				               error: function(reject){	
				                   console.log(reject);
				               }
				           }); 

	  			});
	  </script>

</body>
</html>