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
                            Regist
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                           	<form action="/board/register" method="post">
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
	                        	<button class="btn btn-default">Submit</button>
	                        	<button type="reset" class="btn btn-default">Reset Button</button>
                           	</form>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>


<!--  contents. end. -->
<%@include file="../includes/footer.jsp"%> 
