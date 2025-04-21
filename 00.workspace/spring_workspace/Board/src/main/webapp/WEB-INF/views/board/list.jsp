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
            <!-- /.col-lg-12 -->
        </div>
        
        <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            List
                            <a href="/board/register" class="btn btn-primary btn-xs pull-right">Register</a>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th>번호</th>
                                        <th>제목</th>
                                        <th>작성자</th>
                                        <th>작성일</th>
                                        <th>수정일</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list}" var="board">
                                    <tr>
                                        <td><c:out value="${board.bno}"/></td>
                                        <td>
	                                        <a class="move" href='<c:out value="${board.bno}"/>'>
	                                        	<c:out value="${board.title}"/>
	                                        </a>
                                        </td>
                                        <td><c:out value="${board.writer}"/></td>
                                        <td class="center">
											<fmt:formatDate pattern="yyyy-MM-dd" value="${board.regdate}"/>
										</td>
										<td>
											<fmt:formatDate pattern="yyyy-MM-dd" value="${board.updateDate}"/>
                                        </td>
                                    </tr>
                                </c:forEach>    
                                    
                                </tbody>
                            </table>
                            <!-- /.table-responsive -->
                           
                           
                           <!-- Modal  추가 ------------------------------------------------------------------>
							<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
								aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true">&times;</button>
											<h4 class="modal-title" id="myModalLabel">알림</h4>
										</div>
										<div class="modal-body">처리가 완료되었습니다.</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default"
												data-dismiss="modal">Close</button>
										</div>
									</div>
									<!-- /.modal-content -->
								</div>
								<!-- /.modal-dialog -->
							</div>
							<!-- /.modal. end -------------------------------------------- -->
                           
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>

<script>
	$(document).ready(function() {
		var result = '<c:out value="${result}"/>';
		
		checkModal(result);
		
		function checkModal(result) {
			if (!result || result === 'null') {
				return;
			}
			if (parseInt(result) > 0) {
				$('.modal-body').html('게시글 ' + parseInt(result) + "번이 등록되었습니다.");
			}
			$('#myModal').modal('show');
		}
		
		var actionForm = $("#actionForm");
		$('move').on('click',function(e){
			e.preventDefault(); // 링크를 클릭했을 때 기본 이벤트처리(링크는 다른 페이지로 기능동작이 기본)를 취소.
			actionForm.appendForm'<input type="hidden" name="bno" value="'+$(this).attr('href')+'">');
			
		});
		
	});
</script>


<!--  contents. end. -->
<%@include file="../includes/footer.jsp"%> 
