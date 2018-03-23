<!DOCTYPE html>

<html lang="en">
  <head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" />
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
  </head>
  <body>
    <div class="container">
      <table class="table">
        <thead>
          <tr>
            <th>Id</th>
            <th>Question</th>
            <th>Answer</th>
            <th>Expected Answer</th>
            <th>Result</th>
          </tr>
        </thead>
        <tbody>
        <c:set var="score" value="${0}"/>
          <c:forEach items="${questions}" var="q">
    			<tr>
        			<td>${q.id}</td>
        			<td>${q.question}</td>
        			<td>${q.answer}</td>
        			<td>${q.expected}</td>
        			<c:choose>
        			<c:when test="${q.answer == q.expected }"><td><i style="color:#00c07f;" class="fa fa-check-circle" aria-hidden="true"></i></td><c:set var="score" value="${score + 1}" /></c:when>
				<c:otherwise><td><i style="color:#ff6562;" class="fa fa-times-circle" aria-hidden="true"></i></td></c:otherwise>
        			</c:choose>
   		 </tr>
		</c:forEach>
		<h1>Score = ${score}</h1>
        </tbody>
      </table>
    </div>
  </body>
</html>
