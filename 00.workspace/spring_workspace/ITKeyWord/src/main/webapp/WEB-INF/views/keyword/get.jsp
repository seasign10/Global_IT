<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>


<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">Keyword Read</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">

      <div class="panel-heading">Keyword Read Page</div>
      <!-- /.panel-heading -->
      <div class="panel-body">

          <div class="form-group">
          <label>no</label> <input class="form-control" name='no'
            value='<c:out value="${keyword.no}"/>' readonly="readonly">
        </div>

        <div class="form-group">
          <label>keyword</label>
          <div style="display:flex;">
	          <input class="form-control" name='keyword'
	            value='<c:out value="${keyword.keyword}"/>' readonly="readonly">
		        <button data-oper='more' class="btn btn-warning" style="margin:0 1rem;">More</button>
          </div>
        </div>

        <div class="form-group">
          <label>Text area</label>
          <textarea class="form-control" rows="3" name='description'
            readonly="readonly"><c:out value="${keyword.description}" /></textarea>
        </div>

		<button data-oper='modify' class="btn btn-default">Modify</button>
		<button data-oper='list' class="btn btn-info">List</button>
		
		<form id='operForm' action="${pageContext.request.contextPath}/keyword/modify" method="get">
		  <input type='hidden' id='no' name='no' value='<c:out value="${keyword.no}"/>'>
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

<script type="text/javascript">
$(document).ready(function() {
  
  var operForm = $("#operForm"); 
  
  $("button[data-oper='modify']").on("click", function(e){
    operForm.attr("action","${pageContext.request.contextPath}/keyword/modify").submit();
  });
  
    
  $("button[data-oper='list']").on("click", function(e){
    operForm.find("#no").remove(); // 목록에서는 no가 필요없으므로 삭제
    operForm.attr("action","${pageContext.request.contextPath}/keyword/list")
    operForm.submit();
  });  
  
  var word = '<c:out value="${empty keyword.keyword ? 'null' : keyword.keyword}" />';
  $("button[data-oper='more']").on("click", function(){
    const url = 'https://ko.wikipedia.org/wiki/'+word;
    console.log(url);
    window.open(url, '_blank'); // 새 창 or 새 탭에서 열기
  });
});
</script>
