<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../includes/header.jsp"%>

<div id="listContainer">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Keywords Dic</h1>
		</div>
	</div>
	<!-- /.row -->
	
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					keyword List Page
					<button id='regBtn' type="button" class="btn btn-xs pull-right">Register
						New keyword</button>
				</div>
	
				<!-- /.panel-heading -->
				<div class="panel-body">
					<table class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th class="text-center">번호</th>
								<th width="50%">제목</th>
								<th class="text-center">작성일</th>
							</tr>
						</thead>
	
						<c:forEach items="${list}" var="keyword">
							<tr>
								<td class="text-center"><c:out value="${keyword.no}" /></td>
								<td><a class='move' href='<c:out value="${keyword.no}"/>'><c:out value="${keyword.keyword}" /></a></td>
								<td class="text-center"><fmt:formatDate pattern="yyyy-MM-dd" value="${keyword.regdate}" /></td>
							</tr>
						</c:forEach>
					</table>
	
					<!-- 페이지 번호 생성 -->
					<div class='pull-right'>
						<ul class="pagination">
							<c:if test="${pageMaker.prev}">
								<li class="paginate_button previous"><a
									href="${pageMaker.startPage -1}">Previous</a></li>
							</c:if>
	
							<c:forEach var="num" begin="${pageMaker.startPage}"
								end="${pageMaker.endPage}">
								<li class="paginate_button ${pageMaker.cri.pageNum == num ? 'active':''} ">
									<a href="${num}">${num}</a>
								</li>
							</c:forEach>
	
							<c:if test="${pageMaker.next}">
								<li class="paginate_button next"><a
									href="${pageMaker.endPage +1 }">Next</a></li>
							</c:if>
						</ul>
						<select id="amountSelect">
						    <option value="10" ${pageMaker.cri.amount == 10 ? 'selected' : ''}>10</option>
						    <option value="20" ${pageMaker.cri.amount == 20 ? 'selected' : ''}>20</option>
						    <option value="50" ${pageMaker.cri.amount == 50 ? 'selected' : ''}>50</option>
						</select>
					</div>
	
					
	
					<!-- 검색폼 -->
					<div class='row'>
						<div class="col-lg-12">
							<form id='searchForm' action="${pageContext.request.contextPath}/keyword/list" method='get'>
								<select name='type'>
									<option value=""
										<c:out value="${pageMaker.cri.type == null?'selected':''}"/>>--</option>
									<option value="T"
										<c:out value="${pageMaker.cri.type eq 'T'?'selected':''}"/>>단어</option>
									<option value="C"
										<c:out value="${pageMaker.cri.type eq 'C'?'selected':''}"/>>설명</option>
									<option value="TC"
										<c:out value="${pageMaker.cri.type eq 'TC'?'selected':''}"/>>단어+설명</option>
								</select> 
								<input type='text' name='keyword' value='<c:out value="${pageMaker.cri.keyword}"/>' /> 
									<input type='hidden' name='pageNum' value='<c:out value="${pageMaker.cri.pageNum}"/>' /> 
									<input type='hidden' name='amount' value='<c:out value="${pageMaker.cri.amount}"/>' />
								<button class='btn btn-default'>Search</button>
							</form>
						</div>
					</div>
				</div>
	
				<!-- 전송폼 -->
				<form id='actionForm' action="${pageContext.request.contextPath}/keyword/list" method='get'>
					<input type='hidden' name='pageNum' value='${pageMaker.cri.pageNum}'>
					<input type='hidden' name='amount' value='${pageMaker.cri.amount}'>
					
					<input type='hidden' name='type'
						value='<c:out value="${ pageMaker.cri.type }"/>'> <input
						type='hidden' name='keyword'
						value='<c:out value="${ pageMaker.cri.keyword }"/>'>
				</form>
	
				<!-- Modal  추가 -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-keyword" id="myModalLabel">Modal keyword</h4>
							</div>
							<div class="modal-body">처리가 완료되었습니다.</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
							</div>
						</div>
					</div>
				</div>
				<!-- /.modal -->
			</div>
			<!--  end panel-body -->
		</div>
		<!-- end panel -->
	</div>
	<!-- /.row -->
</div>

<script type="text/javascript">
	$(document).ready(function() {
		// 페이지 뒤로가기를 감지해서 세션에 저장된 path 불러옴
		window.onpageshow = function(event) {
		  if (event.persisted || (window.performance && window.performance.navigation.type === 2)) {
		    const savedSearch = sessionStorage.getItem('keyword_cri');
		    if (savedSearch) {
		    	location.href = '${pageContext.request.contextPath}/keyword/list' + savedSearch;
		    }
		  }
		};
		
		// list에서 path를 세션값으로 저장
		if (window.location.pathname.includes('/it/keyword/list')) {
		    sessionStorage.setItem('keyword_cri', location.search);
		}
		

		var result = '<c:out value="${result}"/>';
		checkModal(result);
		history.replaceState({}, null, null);
	
		function checkModal(result) {
			if (result === '' || history.state) {return;}
			if (parseInt(result) > 0) {$(".modal-body").html("게시글 " + parseInt(result) + " 번이 등록되었습니다.");}
			$("#myModal").modal("show");
		}
	
		$("#regBtn").on("click", function() {
			self.location = "${pageContext.request.contextPath}/keyword/register";
		});
	
		var actionForm = $("#actionForm");
	
		$(".paginate_button a").on("click",function(e) {
			e.preventDefault();
			console.log('click');
			actionForm.find("input[name='pageNum']").val($(this).attr("href"));
			actionForm.submit();
		});
	
		$(".move").on("click",function(e) {
			e.preventDefault();
			// 이전에 존재하던 no 인풋 제거!
		    actionForm.find("input[name='no']").remove();
			actionForm.append("<input type='hidden' name='no' value='" + $(this).attr("href") + "'>");
			actionForm.attr("action","${pageContext.request.contextPath}/keyword/get");
			actionForm.submit();
		});
	
		var searchForm = $("#searchForm");
		$("#searchForm button").on("click",function(e) {
			if (!searchForm.find("option:selected").val()) {
				alert("검색종류를 선택하세요");
				return false;
			}

			if (!searchForm.find("input[name='keyword']").val()) {
				alert("키워드를 입력하세요");
				return false;
			}

			searchForm.find("input[name='pageNum']").val("1");
			e.preventDefault();
			searchForm.submit();
		});
		
		$('#amountSelect').on('change', function() {
		    const amount = $(this).val();
		    const pageNum = 1; // 보통 amount 변경 시 첫 페이지로 이동

		    // 예: 현재 검색 조건이 있다면 함께 넘겨야 함 (type, keyword 등)
		    const type = '${pageMaker.cri.type}';
		    const keyword = '${pageMaker.cri.keyword}';

		    $.ajax({
		        url: '/it/keyword/list',
		        type: 'GET',
		        data: { pageNum: pageNum, amount: amount, type: type, keyword: keyword },
		        success: function(response) {
		            // 서버에서 받은 HTML(목록 부분)로 화면 갱신
		            $('#listContainer').html(response);
		            // 페이지네이션도 다시 렌더링 필요
		        },
		        error: function() {
		            alert('목록을 불러오는데 실패했습니다.');
		        }
		    });
		});
	});
</script>
