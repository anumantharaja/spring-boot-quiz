<!DOCTYPE html>

<html lang="en">
  <head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" />
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

  </head>
  <body>
    <div class="container">
      <table class="table">
        <thead>
          <tr>
            <th>Id</th>
            <th>Question</th>
            <th>Answer</th>
          </tr>
        </thead>
        <tbody>
        <c:url var="actionUrl" value="/save" />
        
         <form action="${actionUrl}" commandName="quizListWrapper" method="POST" acceptCharset="UTF-8">
          <c:forEach items="${questions}" var="q" varStatus="status">
    			<tr>
        			<td>${q.id}<input type="hidden" name="quizs[${status.index}].id" value="${q.id}" /></td>
        			<td>${q.question} <input type="hidden" name="quizs[${status.index}].question" value="${q.question}" /></td>
        			
        			<td><input name="quizs[${status.index}].answer" /></td>
        			<input type="hidden" name="quizs[${status.index}].expected" value="${q.expected}" />
   		 	</tr>
		 </c:forEach>
		 
		 <p><input type="submit" value="Save" /></p>
		</form>

        </tbody>
      </table>
    </div>
  </body>
</html>
