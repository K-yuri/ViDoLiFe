<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="kr.or.kobis.kobisopenapi.consumer.rest.KobisOpenAPIRestService, com.fasterxml.jackson.databind.ObjectMapper, java.util.HashMap;"%>
<%
	// 파라메터 설정
	// 조회 일자
	String targetDt = request.getParameter("targetDt") == null?"20211123":request.getParameter("taragetDt");
	// 결과 row 수 
	String itemPerPage = request.getParameter("itemPerPage") == null?"5":request.getParameter("itemPerPage");
	// 다양성 영화
	String multiMovieYn = request.getParameter("multiMovieYn") == null?"":request.getParameter("multiMovieYn");
	// 한국영화 외국영화
	String repNationCd = request.getParameter("repNationCd") == null?"":request.getParameter("repNationCd");
	// 지역코드
	String wideAreaCd = request.getParameter("wideAreaCd") == null?"":request.getParameter("wideAreaCd");
	
	// 발급키
	String key = "2770216db4c7c4ac21bec508a67beeb0";
	// KOBIS 오픈 API Rest Client 호출
	KobisOpenAPIRestService service = new KobisOpenAPIRestService(key);
	
	// 일일 박스오피스 서비스 호출
	String dailyResponse = service.getDailyBoxOffice(true, targetDt, itemPerPage, multiMovieYn, repNationCd, wideAreaCd);
	
	// JSON 라이브러리를 통해 매핑
	ObjectMapper mapper = new ObjectMapper();
	HashMap<String, Object> dailyResult = mapper.readValue(dailyResponse, HashMap.class);
	
	request.setAttribute("dailyResult", dailyResult);
	
	// KOBIS 오픈 API Rest Client를 통해 코드 서비스 호출
	String codeResponse = service.getComCodeList(true, "0105000000");
	HashMap<String, Object> codeResult = mapper.readValue(codeResponse, HashMap.class);
	request.setAttribute("codeResult", codeResult);
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>순위</td>
			<td>영화명</td>
			<td>개봉일</td>
			<td>매출액</td>
		</tr>
		<c:if test="${dailyResult.boxOfficeResult.dailyBoxOfficeList}">
		<c:forEach items="${dailyResult.boxOfficeResult.dailyBoxOfficeList)}" var=boxoffice">
		<tr>
			<td><c:out value="${boxoffice.rank }" /></td>
			<td><c:out value="${boxoffice.movieNm }" /></td>
			<td><c:out value="${boxoffice.openDt }" /></td>
			<td><c:out value="${boxoffice.salesAmt }" /></td>
		</tr>
		</c:forEach>
		</c:if>
	</table>
</body>
</html>