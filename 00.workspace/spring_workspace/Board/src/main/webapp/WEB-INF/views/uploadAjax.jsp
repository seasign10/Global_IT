<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
		.uploadResult {
			width: 100%;
			background-color: gray;
		}
		
		.uploadResult ul {
			display: flex;
			flex-flow: row;
			justify-content: center;
			align-items: center;
		}
		
		.uploadResult ul li {
			list-style: none;
			padding: 10px;
		}
		.uploadResult ul li a {
			display: flex;
			flex-direction: column;
		}
		
		.uploadResult ul li img {
			width: 100px;
		}
		.bigPictureWrapper {
		  position: absolute;
		  display: none;
		  justify-content: center;
		  align-items: center;
		  top:0%;
		  width:100%;
		  height:100%;
		  background-color: gray; 
		  z-index: 100;
		}
		
		.bigPicture {
		  position: relative;
		  display:flex;
		  justify-content: center;
		  align-items: center;
		}
	</style>

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
		
		function showImage(fileCallPath){
			$('.bigPictureWrapper').css('display','flex').show();//보이게
			//원본이미지 출력. 애니메이션 적용
			$('.bigPicture').html('<img src="/display?fileName='+encodeURI(fileCallPath)+'">')
						   .animate({width:'100%', height: '100%'}, 1000);
		}
		
		function showUploadedFile(uploadResultArr){
			var str='';
			$(uploadResultArr).each(function(i,obj){
				if(!obj.image){//image가 아니면 attach.png 출력
					var fileCallPath=encodeURIComponent(obj.uploadPath+'/'+obj.uuid+'_'+obj.fileName);
					var fileLink = fileCallPath.replace(new RegExp(/\\/g),"/");
					str += '<li><div><a href="download?fileName=' + fileLink + '"><img src="resources/img/attach.png">' + obj.fileName + '</a>' +
				       '<span data-file="' + fileCallPath + '" data-type="file">x</span></div></li>';
				}else{//image이면 썸네일 출력
					//encodeURIComponent 한글깨짐 인코딩
					var fileCallPath=encodeURIComponent(obj.uploadPath+'/s_'+obj.uuid+'_'+obj.fileName);
					
					//원본파일경로
					var originPath=obj.uploadPath+'\\'+obj.uuid+'_'+obj.fileName;
					originPath=originPath.replace(new RegExp(/\\/g),'/'); // "\\" 를 "/"로 변경
					console.log(originPath);
					str+='<li><a href=\'javascript:showImage("'+originPath+'")\'><img src="/display?fileName='+fileCallPath+'">'+obj.fileName
							+'</a><span data-file="'+fileCallPath+'" data-type="image">x</span></li>';
				}
			});
			
			var uploadResult=$('.uploadResult ul');
			uploadResult.append(str);
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
						showUploadedFile(result);
					},
					error:function(err){console.log(err)}
				});
			});
			
			$(".bigPictureWrapper").on("click", function(e){
				$(".bigPicture").animate({width:'0%', height: '0%'}, 1000, function(){
					$(".bigPictureWrapper").hide();
				});
			});
			
			$(".uploadResult").on("click","span", function(e){
				var targetFile = $(this).data("file");
				var type = $(this).data("type");
				// console.log(targetFile);
				
				$.ajax({
				  url: '/deleteFile',
				  data: {fileName: targetFile, type:type},
				  dataType:'text',
				  type: 'POST',
				  success: function(result){
				  	alert(result);
				 	// fileCallPath가 같은 li 요소 찾아서 삭제
		            $(".uploadResult ul li").each(function(){
		                // 각 li 안에 있는 span의 data-file 값과 비교
		                var fileData = $(this).find('span').data("file");
		                if(fileData === targetFile){
		                    $(this).remove();
		                    return false; // 반복문 종료
		                }
		            });
				 	
				  },
			      error: function(err){
			          alert('삭제 실패!');
			      }
				});  
			});
		});
	</script>
</head>
<body>
	<!-- 원본이미지 출력 -->
	<div class="bigPictureWrapper">
		<div class="bigPicture"></div>
	</div>

	<div class="uploadDiv">
		<input type="file" name="uploadFile" multiple>
	</div>
	<button id="uploadBtn">Upload</button>	
	
	<!-- 썸네일 목록 -->
	<div class="uploadResult">
		<ul></ul>
	</div>	
</body>
</html>