<!DOCTYPE html>
<html lang="en">
  <head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" />
  </head>
  <body>
    <div class="container">
      <table class="table">
        <thead>
          <tr>
            <th>#</th>
            <th>Id</th>
            <th>Question</th>
            <th>Answer</th>
          </tr>
        </thead>
        <tbody>
          <tr th:each="quiz : ${questions}">
  			<td th:text="${quiz.id}">${quiz.id}</td>
  			<td th:text="${quiz.question}">Hero name</td>
  			<td th:text="${quiz.answer}">Real name</td>
			</tr>
        </tbody>
      </table>
    </div>
  </body>
</html>
