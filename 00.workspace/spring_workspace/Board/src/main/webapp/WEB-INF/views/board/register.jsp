<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    

<%@include file="../includes/header.jsp"%>   
<!-- cotnents --------------------------------------------------------->

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board</h1>
	</div>
</div>
 
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
            Regist
			</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<form action="/board/register" method="post" role="form">
					<div class="form-group">
						<label>Title</label>
						<input class="form-control" name="title"> 
					</div>
					<div class="form-group">
						<label>Content</label>
						<textarea class="form-control" rows="3" name="content"></textarea> 
					</div>
					<div class="form-group">
						<label>Writer</label>
						<input class="form-control" name="writer"> 
					</div>
	
		           	<!-- 파일 첨부 ------------------------------->
		           	<div class="row">
						<div class="col-lg-12">
							<div class="panel panel-default">
								<div class="panel-heading">File Attach</div>
								<!-- /.panel-heading -->
								<div class="panel-body">
									<div class="form-group uploadDiv">
										<input type="file" name='uploadFile' multiple>
									</div>
									<div class='uploadResult'> 
										<ul>
										</ul>
									</div>								        
								</div>
								<!--  end panel-body -->
							</div>
							<!--  end panel-body -->
						</div>
						<!-- end panel -->
					</div>
					<!-- /.row -->
                  	
                  	<!-- 전송 버튼 --------------------------------->
                  	<button class="btn btn-default" type="submit">Submit</button>
                  	<button type="reset" class="btn btn-default">Reset Button</button>
                 </form>
            </div>
            <!-- /.panel-body -->
        </div>
        <!-- /.panel -->
    </div>
    <!-- /.col-lg-12 -->
</div>

<script>
	$(document).ready(function(){
		var formObj=$('form[role="form"]'); //form을 미리 찾아놓는다.
		// 전송이벤트 처리
		$('button[type="submit"]').on('click',function(e){
			e.preventDefault();//전송방지
			var str='';
			$('.uploadResult ul li').each(function(i,obj){
				var jobj=$(obj);// 배열의 아이템
				str+='<input type="hidden" name="attachList['+i+'].fileName" value="'+jobj.data('filename')+'">';
				str+='<input type="hidden" name="attachList['+i+'].uuid" value="'+jobj.data('uuid')+'">';
				str+='<input type="hidden" name="attachList['+i+'].uploadPath" value="'+jobj.data('path')+'">';
				str+='<input type="hidden" name="attachList['+i+'].fileType" value="'+jobj.data('type')+'">';
			});
			// 폼에 추가. 전공
			formObj.append(str).submit();
		});
		
		// 파일 체크
		var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
			var maxSize = 5242880; //5MB
			function checkExtension(fileName, fileSize){
		    if(fileSize >= maxSize){
				alert("파일 사이즈 초과");
				return false;
		    }
		    if(regex.test(fileName)){
				alert("해당 종류의 파일은 업로드할 수 없습니다.");
				return false;
		    }
		    return true;
		};
		
		// 파일 업로드
		$("input[type='file']").change(function(e){
			 var formData = new FormData();
			 var inputFile = $("input[name='uploadFile']");
			 var files = inputFile[0].files;
			 for(var i = 0; i < files.length; i++){
				 if(!checkExtension(files[i].name, files[i].size) ){
				 	return false;
				 }
				 formData.append("uploadFile", files[i]);
			 }
			$.ajax({
				url: '/uploadAjaxAction',
				processData: false, 
				contentType: false,data: 
				formData,type: 'POST',
				dataType:'json',
				success: function(result){
					console.log(result); 
					showUploadResult(result); //업로드 결과 처리 함수 
				}
			});
		});  
		  
		// 썸네일을 출력하는 함수
		function showUploadResult(uploadResultArr){
		    if(!uploadResultArr || uploadResultArr.length == 0){ return; }
		    var uploadUL = $(".uploadResult ul"); // 썸네일이 출력되는 ul태그를 찾아놓음
		    var str ="";
		    
		    $(uploadResultArr).each(function(i, obj){
				//image type
				if(obj.image){ // 이미지이면
					//파일경로. 한글깨지지 않게 인코딩
					var fileCallPath =  encodeURIComponent( obj.uploadPath+ "/s_"+obj.uuid +"_"+obj.fileName);
					str += "<li data-path='"+obj.uploadPath+"'";
					str +=" data-uuid='"+obj.uuid+"' data-filename='"+obj.fileName+"' data-type='"+obj.image+"'"
					str +" ><div>";
					str += "<span> "+ obj.fileName+"</span>";
					str += "<button type='button' data-file=\'"+fileCallPath+"\' "
					str += "data-type='image' class='btn btn-warning btn-circle'><i class='fa fa-times'></i></button><br>";
					str += "<img src='/display?fileName="+fileCallPath+"'>";
					str += "</div>";
					str +"</li>";
				}else{// 이미지가 아니면
					//파일경로. 한글깨지지 않게 인코딩
					var fileCallPath =  encodeURIComponent( obj.uploadPath+"/"+ obj.uuid +"_"+obj.fileName);			      
				    var fileLink = fileCallPath.replace(new RegExp(/\\/g),"/");
				      
					str += "<li "
					str += "data-path='"+obj.uploadPath+"' data-uuid='"+obj.uuid+"' data-filename='"+obj.fileName+"' data-type='"+obj.image+"' ><div>";
					str += "<span> "+ obj.fileName+"</span>";
					str += "<button type='button' data-file=\'"+fileCallPath+"\' data-type='file' " 
					str += "class='btn btn-warning btn-circle'><i class='fa fa-times'></i></button><br>";
					str += "<img src='/resources/img/attach.png'></a>";
					str += "</div>";
					str +"</li>";
				}
		    });
		    uploadUL.append(str);
		}

		// 파일 삭제 함수
		$(".uploadResult").on("click", "button", function(e){
		    console.log("delete file");
		    var targetFile = $(this).data("file");
		    var type = $(this).data("type");
		    var targetLi = $(this).closest("li");
		    
		    $.ajax({
		      url: '/deleteFile',
		      data: {fileName: targetFile, type:type},
		      dataType:'text',
		      type: 'POST',
		        success: function(result){
		           alert(result);
		           
		           targetLi.remove();
		         }
		    });
		});
	});
</script>

<!--  contents. end. -->
<%@include file="../includes/footer.jsp"%> 
