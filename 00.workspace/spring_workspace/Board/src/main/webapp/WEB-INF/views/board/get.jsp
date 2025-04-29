<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>

	<div class="row">
	  <div class="col-lg-12">
	    <h1 class="page-header">Board Read</h1>
	  </div>
	  <!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	
	<div class="row">
	  <div class="col-lg-12">
	    <div class="panel panel-default">
	
	      <div class="panel-heading">Board Read Page</div>
	      <!-- /.panel-heading -->
	      <div class="panel-body">
	
	          <div class="form-group">
	          <label>Bno</label> <input class="form-control" name='bno'
	            value='<c:out value="${board.bno }"/>' readonly="readonly">
	        </div>
	
	        <div class="form-group">
	          <label>Title</label> <input class="form-control" name='title'
	            value='<c:out value="${board.title }"/>' readonly="readonly">
	        </div>
	
	        <div class="form-group">
	          <label>Text area</label>
	          <textarea class="form-control" rows="3" name='content'
	            readonly="readonly"><c:out value="${board.content}" /></textarea>
	        </div>
	
	        <div class="form-group">
	          <label>Writer</label> <input class="form-control" name='writer'
	            value='<c:out value="${board.writer }"/>' readonly="readonly">
	        </div>
	
			<button data-oper='modify' class="btn btn-default">Modify</button>
			<button data-oper='list' class="btn btn-info">List</button>
			
			<form id='operForm' action="/boad/modify" method="get">
			  <input type='hidden' id='bno' name='bno' value='<c:out value="${board.bno}"/>'>
			  <input type='hidden' name='pageNum' value='<c:out value="${cri.pageNum}"/>'>
			  <input type='hidden' name='amount' value='<c:out value="${cri.amount}"/>'>
			  <input type='hidden' name='keyword' value='<c:out value="${cri.keyword}"/>'>
			  <input type='hidden' name='type' value='<c:out value="${cri.type}"/>'>  
			 
			</form>
	
	      </div>
	      <!--  end panel-body -->
	
	    </div>
	    <!--  end panel-body -->
	  </div>
	  <!-- end panel -->
	</div>
	<!-- /.row -->
	
	<!-- 원본이미지 출력 -->
	<div class='bigPictureWrapper'>
	  <div class='bigPicture'>
	  </div>
	</div>
	
	<!-- 댓글 목록 -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					<i class="fa fa-comments fa-fw"></i> Reply
					<button id="addReplyBtn" class="btn btn-primary btn-xs pull-right">
						New Reply
					</button>
				</div>
				<div class="panel-body">
					<div class="chat"></div>
				</div>
				<div class="panel-footer"></div>
			</div>
		</div>
	</div>
	
	<!-- Modal -->
      <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal"
                aria-hidden="true">&times;</button>
              <h4 class="modal-title" id="myModalLabel">REPLY MODAL</h4>
            </div>
            <div class="modal-body">
              <div class="form-group">
                <label>Reply</label> 
                <input class="form-control" name='reply'>
              </div>      
              <div class="form-group">
                <label>Replyer</label> 
                <input class="form-control" name='replyer'>
              </div>
              <div class="form-group">
                <label>Reply Date</label> 
                <input class="form-control" name='replyDate'>
              </div>
            </div>
            
			<div class="modal-footer">
				<!-- 첨부파일 -->
				<div class="row">
				  <div class="col-lg-12">
				    <div class="panel panel-default">	
				      <div class="panel-heading">Files</div>
				      <!-- /.panel-heading -->
				      <div class="panel-body">
				        <div class='uploadResult'> 
				          <ul></ul>
				        </div>
				      </div>
				      <!--  end panel-body -->
				    </div>
				    <!--  end panel-body -->
				  </div>
				  <!-- end panel -->
				</div>
				<!-- /.row -->
				
				<!-- 버튼 -->
		        <button id='modalModBtn' type="button" class="btn btn-warning">Modify</button>
		        <button id='modalRemoveBtn' type="button" class="btn btn-danger">Remove</button>
		        <button id='modalRegisterBtn' type="button" class="btn btn-primary">Register</button>
		        <button id='modalCloseBtn' type="button" class="btn btn-default">Close</button>
	        </div>
	       </div>
	     <!-- /.modal-content -->
	     </div>
	  	 <!-- /.modal-dialog -->
	  </div>
	  <!-- /.modal -->

<script src="/resources/js/Reply.js"></script>

<script>
	$(document).ready(function(){
		var bnoValue='<c:out value="${board.bno}"/>' // 부모글 번호
		
		/* 첨부파일 목록 */
		$.getJSON('/board/getAttachList', {bno:bnoValue}, function(arr){
			var str='';
			$(arr).each(function(i,attach){
				 //image type
		         if(attach.fileType){
		           var fileCallPath =  encodeURIComponent( attach.uploadPath+ "/s_"+attach.uuid +"_"+attach.fileName);
		           
		           str += "<li data-path='"+attach.uploadPath+"' data-uuid='"+attach.uuid+"' data-filename='"+attach.fileName+"' data-type='"+attach.fileType+"' ><div>";
		           str += "<img src='/display?fileName="+fileCallPath+"'>";
		           str += "</div>";
		           str +"</li>";
		         }else{
		             
		           str += "<li data-path='"+attach.uploadPath+"' data-uuid='"+attach.uuid+"' data-filename='"+attach.fileName+"' data-type='"+attach.fileType+"' ><div>";
		           str += "<span> "+ attach.fileName+"</span><br/>";
		           str += "<img src='/resources/img/attach.png'></a>";
		           str += "</div>";
		           str +"</li>";
		         }
		       });
			});
		});
	
		/* 이벤트 처리 */
		$(".uploadResult").on("click","li", function(e){
		    console.log("view image");
		    var liObj = $(this);
		    var path = encodeURIComponent(liObj.data("path")+"/" + liObj.data("uuid")+"_" + liObj.data("filename"));
		    if(liObj.data("type")){
		      showImage(path.replace(new RegExp(/\\/g),"/"));
		    }else {
		      //download 
		      self.location ="/download?fileName="+path
		    }
		});
	  
		function showImage(fileCallPath){    
		  	//alert(fileCallPath);
		  	$(".bigPictureWrapper").css("display","flex").show();
		  	$(".bigPicture")
		    .html("<img src='/display?fileName="+fileCallPath+"' >")
		    .animate({width:'100%', height: '100%'}, 1000);
	    }
		
		$(".bigPictureWrapper").on("click", function(e){
		  	$(".bigPicture").animate({width:'0%', height: '0%'}, 1000);
		    setTimeout(function(){
		      $('.bigPictureWrapper').hide();
		    }, 1000);
		});
		
		/* 댓글 출력 */
		var replyUl=$('.chat')//댓글 목록을 출력하는 ul태그
		showList(1); // 댓글목록을 출력하는 함수
		
		// 댓글목록을 출력하는 함수
		function showList(page){
			replyService.getList({bno:bnoValue,page:page||1},function(replyCnt,list){
				//댓글 등록시 마지막페이지로 이동
				if(page==-1){
					pageNum=Math.ceil(replyCnt/10.0);
					showList(pageNum);
					return;
				}
				var str='';
				//목록이 없으면 종료
				if(list==null || list.length==0){
					return;
				}
				// <li>태그를 동적생성
				for(var i=0,len=list.length || 0; i<len; i++){
					str+='<li class="left flearfix" data-rno="'+list[i].rno+'">';
					str+='	<div><div class="header"><strong class="primary-font">['+list[i].rno+']'+list[i].replyer+'</strong>';
					str+='		<small class="pull-right text-muted">'+replyService.displayTime(list[i].replyDate)+'</small>';
					str+='		<p>'+list[i].reply+'</p></div></li>';
				}
				// 
				replyUl.html(str);
				//페이지번호 생성
				showReplyPage(replyCnt);
			});
		}
		
		var pageNum=1; // 페이지번호.기본값1
		var replyPageFooter=$('.panel-footer'); // 1.2.3...10이 출력되는 영역
		
		//페이지번호 클릭시 이벤트 처리
		//위임 delegate사용. 자식태그인 a가 아직생성되기 전이므로 부모태그에 이벤트 위임
		replyPageFooter.on("click","li a", function(e){
		  e.preventDefault(); // 다른 페이지로 넘어가는 것 방지
		  console.log("page click");
		  var targetPageNum = $(this).attr("href");
		  console.log("targetPageNum: " + targetPageNum);
		  pageNum = targetPageNum;
		  showList(pageNum);
		}); 
		
		//페이지번호를 생성하는 함수
		function showReplyPage(replyCnt){
			var endNum=Math.ceil(pageNum/10.0)*10; // 끝번호
			var startNum=endNum-9; // 시작번호
			var prev=startNum-1; // prev 유무. 시작번호가 1이 아니면 prev가 존재
			var next=false; // next 유무
			// 계산으로 구한 끝번호보다 실제 댓글갯수가 작으면 끝번호를 변경
			if(endNum*10>replyCnt){
				endNum=Math.ceil(replyCnt/10.0);
			}
			if(endNum*10<replyCnt){
				next=true;
			}
			//페이지버튼을 출력하는 <ul>태그 생성
			var str='<ul class="pagination pull-right">';
			if(prev){
				str += '<li class="page-item"><a class="page-link" href="' + (startNum - 1) + '">Prev</a></li>';
			}
			for(var i = startNum; i <= endNum; i++){
				let active = (i === pageNum) ? ' active' : '';
				str += '<li class="page-item' + active + '"><a class="page-link" href="' + i + '">' + i + '</a></li>';
			}
			if(next){
				str += '<li class="page-item"><a class="page-link" href="' + (endNum + 1) + '">Next</a></li>';
			}
			str+='</ul>';
			
			// panel footer에 페이지번호로 출력
			replyPageFooter.html(str);
		}
		
		/* 모달창의 태그들을 미리 찾아놓음 */
		var modal=$('.modal');
		var modalInputReply=modal.find('input[name="reply"]');
		var modalInputReplyer=modal.find('input[name="replyer"]');
		var modalInputReplyDate=modal.find('input[name="replyDate"]');
	
		var modalModBtn=$('#modalModBtn');
		var modalRemoveBtn=$('#modalRemoveBtn');
		var modalRegisterBtn=$('#modalRegisterBtn');
		
		// cloase버튼 클릭시 모달창 사라지게
		$('#modalCloseBtn').on('click',function(){
			modal.modal('hide');
		});
		// new reply버튼 클릭시 모달창 보이게
		$('#addReplyBtn').on('click',function(){
			modal.find('input').val(''); // 모달창 input태그 초기화
			modalInputReplyDate.closest('div').hide(); // 등록일 input태그 안보이게
			modal.find('button[id!="modalCloseBtn"]').hide(); // close버튼만 제외하고 모든버튼 안보이게
			modalRegisterBtn.show(); // 등록버튼만 다시보이게
			modalInputReplyer.prop('readonly', false); // readonly 제거
			modal.modal('show'); // 모달창 보이게
		})
		//모달창의 등록버튼 이벤트처리
		modalRegisterBtn.on('click',function(){
			//전송할 데이터
			var reply={
				reply: modalInputReply.val(),
				replyer: modalInputReplyer.val(),
				bno:bnoValue
			};
			// Reply.js의 add함수 호출
			replyService.add(reply,function(result){
				alert(result); // 'success'알림창 출력
				modal.find('input').val(''); // input태그 초기화
				modal.modal('hide'); // modal창 안보이게
				
				showList(-1); // 마지막페이지로 이동. 등록된 글을 보기 위함
			});
		});
		
		//댓글목록에서 댓글 클릭시 상세보기
		//delegate. 위임
		$(".chat").on("click", "li", function(e){
		      var rno = $(this).data("rno");// data-rno 사용자 속성값 읽기
		      
		      replyService.get(rno, function(reply){
			        modalInputReply.val(reply.reply);
			        modalInputReplyer.val(reply.replyer);
			        modalInputReplyDate.val(replyService.displayTime(reply.replyDate)).attr("readonly","readonly");
			        modal.data("rno", reply.rno); // data-rno가 만들어짐
			        
			        modalInputReplyer.prop('readonly', true);// readonly 활성화
			        modal.find("button[id !='modalCloseBtn']").hide(); // close만 빼고 나머지 버튼을 안보이게 하기
			        modalModBtn.show();// 활성화
			        modalRemoveBtn.show();
			        
			        $(".modal").modal("show");
		      });
		 });
		
	    modalModBtn.on("click", function(e){
     	  var reply = {rno:modal.data("rno"), reply: modalInputReply.val()};
     	  
     	  replyService.update(reply, function(result){      
	     	    alert(result);
	     	    modal.modal("hide");
	     	    showList(pageNum);
     	  });
	    });


     	modalRemoveBtn.on("click", function (e){
     	  var rno = modal.data("rno");
     	  
     	  replyService.remove(rno, function(result){      
     	      alert(result);
     	      modal.modal("hide");
     	      showList(pageNum);
     	  });
     	});
	});
</script>

<script type="text/javascript">
	$(document).ready(function() {
	  
	  var operForm = $("#operForm"); 
	  
	  $("button[data-oper='modify']").on("click", function(e){
	    operForm.attr("action","/board/modify").submit();
	  });
	  
	    
	  $("button[data-oper='list']").on("click", function(e){
	    operForm.find("#bno").remove(); // 목록에서는 bno가 필요없으므로 삭제
	    operForm.attr("action","/board/list")
	    operForm.submit();
	    
	  });  
	});
</script>

<%@include file="../includes/footer.jsp"%>