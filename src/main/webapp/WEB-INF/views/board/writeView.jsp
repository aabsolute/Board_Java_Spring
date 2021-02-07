<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
	<head>
		<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	 	<title>Board</title>
	</head>
	<script type="text/javascript">
		$(document).ready(function(){
			var formObj = $("form[name='writeForm']");
			$(".write_btn").on("click", function(){
				if(fn_valiChk()){
					return false;
				}
				formObj.attr("action", "/board/write");
				formObj.attr("method", "post");
				formObj.submit();
			});
		})

		function fn_valiChk(){
			/* var regForm = $("form[name='writeForm'] .chk").length;
			alert(regForm);
			for(var i = 0; i<regForm; i++){
				if($(".chk").eq(i).val() == "" || $(".chk").eq(i).val() == null){
					alert($(".chk").eq(i).attr("title"));
					return true;
				}
			} */
			 if($.trim($('#title').val()) == ''){
  				 alert("insert title");
  				 $('#title').focus();
  				 return false;
  				}
  			if($.trim($('#content').val()) == ''){
  				 alert("insert content");
  				 $('#content').focus();
  				 return false;
  				}
  			if($.trim($('#text').val()) == ''){
  				 alert("insert text");
  				 $('#text').focus();
  				 return false;
  				}
		}
	</script>
	<body>

		<div id="root">
			<header>
				<h1> 게시판</h1>
			</header>
			<hr />

			<nav>
			  홈 - 글 작성
			</nav>
			<hr />

			<section id="container">
				<form role="writeform" method="post" action="/board/write">
					<table>
						<tbody>
							<tr>
								<td>
									<label for="title">제목</label><input type="text" id="title" name="title" class="chk" title="please title" />
								</td>
							</tr>
							<tr>
								<td>
									<label for="content">내용</label><textarea id="content"  name="content" class="chk" title="please content" ></textarea>
								</td>
							</tr>
							<tr>
								<td>
									<label for="writer">작성자</label><input type="text" id="writer" name="writer" class="chk" title="please writer" />
								</td>
							<tr>
								<td>
									<button class="write_btn" type="submit">작성</button>
								</td>
							</tr>
						</tbody>
					</table>
				</form>
			</section>
			<hr />
		</div>
	</body>
</html>
