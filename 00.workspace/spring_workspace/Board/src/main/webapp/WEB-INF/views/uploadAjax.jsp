<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"
		integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
		crossorigin="anonymous"></script>
	<script>
		function checkExten(fileName,fileSize){
			var regex=new RegExp('(.*?)\.(exe|sh|zip|alz|js|jar)$');
			var maxSize=5242880; //5MB
			
			if(fileSize>=maxSize){
				alert('파일사이즈 초과 : 최대크기 5MB');
				return false;
			}
			if(regex.test(fileName)){
				alert('해당 종류의 파일은 업로드 할 수 없습니다.')
				return false;
			}
			return true;
		}
	
		$(document).ready(function(){
			$('#uploadBtn').on('click', function(){
				// form태그 역할을 하는 객체
				var formData=new FormData();
				var inputFile=$('input[name="uploadFile"]');
				var files=inputFile[0].files;//선택한 파일목록
				// formData에 파일목록추가
				for(var i=0;i<files.length;i++){
					const file = files[i];
					if (!checkExten(file.name, file.size)) {
						return; // 유효성 검사 통과 못하면 업로드 중단
					}
					formData.append('uploadFile',files[i]);
				}
				if (files.length === 0) {
					alert('파일을 선택해주세요.');
					return;
				}
				$.ajax({
					url: '/uploadAjaxAction',
					processData:false, //파일업로드시 설정
					contentType:false, //파일업로드시 설정
					data: formData, //전송할데이터
					type: 'post', //전송방식
					dataType: 'json',
					success:function(result){
						alert("uploaded");
						console.log(result);
					},
					error:function(err){console.log(err)}
				});
			});
		});
	</script>
</head>
<body>
	<div class="uploadDiv">
		<input type="file" name="uploadFile" multiple>
	</div>
	<button id="uploadBtn">Upload</button>		
</body>
</html>