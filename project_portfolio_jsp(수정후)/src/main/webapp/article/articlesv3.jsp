<%@page import="ezen.portfolio.common.web.Pagination"%>
<%@page import="ezen.portfolio.common.web.PageParams"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="ezen.portfolio.article.dto.Memo"%>
<%@ page import="java.util.List"%>
<%@ page import="ezen.portfolio.common.dao.DaoFactory"%>
<%@ page import="ezen.portfolio.article.dao.MemoDao"%>

<%
// ===================== 페이징 처리 ============================
//한 페이지에 보여지는 목록 갯수 설정
int elementSize = 20;
//한페이지에 보여지는 페이지 갯수 설정
int pageSize = 5;
// -------------------------------------------------------------
//사용자 선택페이지
String requestPage = request.getParameter("page");
if(requestPage == null || requestPage.equals("")){
	requestPage = "1";
}
int selectPage = Integer.parseInt(requestPage);

// -------------------------------------------------------------
// 페이징 계산을 위한 게시글 전체 갯수 조회
MemoDao memoDao =  DaoFactory.getInstance().getMemoDao();
int rowCount = memoDao.getCountAll();

//-------------------------------------------------------------
// 전체 페이지수 계산
PageParams params = new PageParams(elementSize, pageSize, selectPage, rowCount);
Pagination pagination = new Pagination(params);

//------------------------------------------------------------
List<Memo> list = memoDao.findByAll(selectPage, elementSize);

// 게시글 목록 설정
request.setAttribute("list", list);
// 페이징 정보 설정
request.setAttribute("pagination", pagination);
%>

<!doctype html>
<html lang="ko">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <%-- CSS 파일 포함 --%>
    <jsp:include page="/modules/styles.jsp"/>
    
    <title>Portfolio</title>
</head>

<body>
    
    <div data-scroll-container>
        <!-- ======================================== Header Start ======================================== -->
        <jsp:include page="/modules/header.jsp"/>
        <!-- ======================================== Header End ======================================== -->

        <!-- Option Menu Start-->
        <jsp:include page="/modules/option.jsp"/>
        <!-- Option Menu End-->
        
        <%-- 게시글 화면 시작 --%>
        <main>
      <section class="position-relative">
        <div class="bg-pattern text-primary text-opacity-50 opacity-25 w-100 h-100 start-0 top-0 position-absolute">
        </div>
        <div class="bg-gradientwhite flip-y w-50 h-100 start-50 top-0 translate-middle-x position-absolute"></div>
        <div class="container pt-11 pt-lg-14 pb-9 pb-lg-11 position-relative z-1">
          <div class="row align-items-center justify-content-center">

            <div class="col-md-8 z-2">
              <div class="position-relative">
                <h2>
                  게시글
                </h2>
                <p class="mb-3 w-lg-75">
                  자유롭게 글을 남겨 주세요.
                </p>
                <div class="width-50x pt-1 bg-primary mb-5"></div>

                <form action="/article/articles-action.jsp" method="post" role="form" class="needs-validation mb-5 mb-lg-7" novalidate>
                  <div class="row">
                    <div class="mb-3 text-end">
                      <label class="form-label">2023-05-05</label>
                      <textarea class="form-control" name="content" placeholder="로그인 하여야 게시글을 입력할 수 있습니다...." required
                        <c:if test="${empty loginMember}">disabled</c:if>></textarea>
                    </div>

                    <div class="d-md-flex justify-content-end align-items-center mb-5">
                      <input type="submit" value="글 남기기" id="sendBtn" class="btn btn-warning btn-sm">
                    </div>
                </form>

                <div class="px-4  py-3 position-relative" data-aos="fade-up">
                  <p class="text-primary">전체 게시글 : ${pagination.params.rowCount}개 | 전체 페이지(${pagination.params.requestPage}/${pagination.totalPages})</p>
                  <ul class="list-group">
                  	                  
                    <%-- 게시글 목록 반복 --%>
                    <c:forEach items="${list}" var="memo">
                    	<li class="list-group-item">
                      <div class="mb-3 text-end">
                        <label class="fs-6">${memo.memberName} | ${memo.writeDate}</label>
                        <p class="form-control text-start bg-gray-200">
                        ${memo.content}
                        </p>
                      </div>
                    </li>
                    </c:forEach>
                  
                  </ul>

                  <!-- 페이징 처리 -->
                  <nav class="mt-3">
                    <ul class="pagination justify-content-center">
	                   	<%-- 처음으로 보여주기 여부 --%>
	                   	<c:if test="${pagination.showFirst}">
                    		<li class="page-item" >
                        		<a class="page-link" href="?page=1" aria-label="First">
                          			<span aria-hidden="true">처음으로</span>
                        		</a>
                      		</li>
                    	</c:if>
                    	
	                   	<%-- 이전 목록 보여주기 여부 --%>
	                   	<c:if test="${pagination.showPrevious}">
                    		<li class="page-item" >
                        		<a class="page-link" href="?page=${pagination.previousStartPage}" aria-label="Previous">
                          			<span aria-hidden="true">&laquo;</span>
                        		</a>
                      		</li>
                    	</c:if>
                      
	                      <c:forEach var="i" begin="${pagination.startPage }" end="${pagination.endPage }">
	                      	<c:choose>
	                      		<c:when test="${i == pagination.params.requestPage}">
	                      			<li class="page-item active"><a class="page-link">${i}</a></li>
	                      		</c:when>
	                      		<c:otherwise>
	                      			<li class="page-item"><a class="page-link" href="?page=${i}">${i}</a></li>
	                      		</c:otherwise>
	                      	</c:choose>
	                      </c:forEach>
	                      
	                      <%-- 다음 목록 보여주기 여부 --%>
	                      <c:if test="${pagination.showNext}">
                    		<li class="page-item" >
                        		<a class="page-link" href="?page=${pagination.nextStartPage}" aria-label="Next">
                          			<span aria-hidden="true">&raquo;</span>
                        		</a>
                      		</li>
                    	</c:if>
                    	
                    	<%-- 마지막으로 보여주기 여부 --%>
	                   	<c:if test="${pagination.showLast}">
                    		<li class="page-item" >
                        		<a class="page-link" href="?page=${pagination.totalPages}" aria-label="First">
                          			<span aria-hidden="true">마지막으로</span>
                        		</a>
                      		</li>
                    	</c:if>
                    </ul>
                  </nav>
                </div>

              </div>
            </div>
          </div>
        </div>
      </section>
    </main>
        <%-- 게시글 화면 종료 --%>
    </div>
    
    <!-- JavaScript Start -->
    <jsp:include page="/modules/scripts.jsp"/>
     <!-- JavaScript End -->
</body>

</html>