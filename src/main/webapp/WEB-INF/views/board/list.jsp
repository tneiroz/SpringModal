<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
	<div class="jumbotron">
		<h2>게시글 목록</h2>
	</div>
	<table class="table">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등록일</th>
			<th>수정일</th>
		</tr>
		<c:forEach var = "b" items = "${list}">
		<tr>
			<td>${b.bno}</td>
			<td>
				<a href="get?bno=${b.bno}">${b.title }</a>
			</td>
			<td>${b.writer}</td>
			<td>
				<fmt:parseDate var="regDate" value="${b.regDate}" pattern="yyyy-MM-dd'T'" type="both"/>
				<fmt:formatDate value="${regDate}" pattern="yyyy년MM월dd일"/>
			</td>	
			<td>
				<fmt:parseDate var="updateDate" value="${b.updateDate}" pattern="yyyy-MM-dd'T'" type="both"/>
				<fmt:formatDate value="${updateDate}" pattern="yyyy년MM월dd일"/>
			</td>	
		</tr>	
		</c:forEach>
	</table>
	<div>
		<a href="register">글쓰기</a>
	</div>
</div> <!-- container end -->

	<div class="modal" id="feedback">
	  <div class="modal-dialog">
	    <div class="modal-content">
	
	      <!-- Modal Header -->
	      <div class="modal-header">
	        <h4 class="modal-title">Modal Heading</h4>
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	      </div>
	
	      <!-- Modal body -->
	      <div class="modal-body message"></div>
	      <!-- Modal footer -->
	      <div class="modal-footer">
	        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
	      </div>
	
	    </div>
	  </div>
	</div> <!-- modal end -->
	
<script>
	$(function(){
		let result = "${result}"
		let message = "";
		if(result.trim()!=''){
			if(result=='register') {
				 message = "${bno}번 글을 등록하였습니다. "
			} else if (result=='modify') {
				message = "${bno}번 글을 수정하였습니다. "
			} else if (result=='remove') {
				message = "${bno}번 글을 삭제하였습니다. "
			}
			$('.message').append(message);
			$('#feedback').modal('show');
		}
	});
</script>
<%@ include file="../layout/footer.jsp" %>