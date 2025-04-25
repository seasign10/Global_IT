<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    

<%@include file="../includes/header.jsp"%>   
<!-- cotnents --------------------------------------------------------->

       <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">keyword</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        
        <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Modify
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                           	<form action="${pageContext.request.contextPath}/keyword/modify" method="post">
	                        	<div class="form-group">
								    <label>no</label>
								    <input class="form-control" name="no" value="<c:out value='${ keyword.no }'/>" readonly />
								</div>
								
								<div class="form-group">
								    <label>keyword</label>
								    <input class="form-control" name="keyword" value="<c:out value='${ keyword.keyword }'/>"  />
								</div>
								
								<div class="form-group">
								    <label>Description</label>
								    <textarea class="form-control" rows="3" name="description"><c:out value='${ keyword.description }'/></textarea>
								</div>
								
								<div class="form-group">
								    <label>RegDate</label>
								    <input class="form-control" name="regDate" value="<fmt:formatDate pattern="yyyy/MM/dd" value='${ keyword.regdate }'/>" readonly />
								</div>
	
	                        	<button type="button" data-oper="modify">Modify</button>
	                        	<button type="button" data-oper="remove">Remove</button>
	                        	<button type="button" data-oper="list" class="btn btn-default">List</button>
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
            		var formObj=$('form'); // form을 미리 찾아놓음
            		$('button').on('click', function(e){
            			e.preventDefault(); //전송방지
            			var operation=$(this).data('oper');//data-oper 사용자속성의 값을 구함
            			if(operation==='remove'){
            				formObj.attr('action', '${pageContext.request.contextPath}/keyword/remove'); //action을 '${pageContext.request.contextPath}/keyword/remove'로 변경
            			}else if(operation==='list'){
            				formObj.attr('action','${pageContext.request.contextPath}/keyword/list').attr('method','get'); // action을 '${pageContext.request.contextPath}/keyword/list'로 변경, 전송방법 get으로 변경
            				
            				// list로 돌아갈 때, 페이지, 검색 등을 유지하기위함
         				    var pageNumTag = $("input[name='pageNum']").clone();
         			        var amountTag = $("input[name='amount']").clone();
         			        var keywordTag = $("input[name='keyword']").clone();
         			        var typeTag = $("input[name='type']").clone();      
         			      
         			        formObj.empty();
         			      
         			        formObj.append(pageNumTag);
         			        formObj.append(amountTag);
         			        formObj.append(keywordTag);
         			        formObj.append(typeTag);	       
            			}
            			formObj.submit();
            		});
            	});
            </script>
<!--  contents. end. -->