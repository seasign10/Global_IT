<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    

<%@include file="../includes/header.jsp"%>   
<!-- cotnents --------------------------------------------------------->

       <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Keyword</h1>
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
                           	<form action="/it/keyword/register" method="post">
	                        	<div class="form-group">
		                        	<label>Keyword</label>
		                        	<input class="form-control" name="keyword"> 
	                        	</div>
	                        	<div class="form-group">
		                        	<label>Description</label>
		                        	<textarea class="form-control" rows="3" name="description"></textarea> 
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