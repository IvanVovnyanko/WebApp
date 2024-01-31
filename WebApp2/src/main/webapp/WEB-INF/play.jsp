<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Text Adventure</title>
</head>
<body>
<h1>Welcome to the Text Adventure!</h1>

<c:if test="${not empty question}">
    <p>${question.description}</p>
    <form id="answerForm">
        <c:forEach var="option" items="${question.options}">
            <input type="radio" name="answerOptionId" value="${option.id}" required>
            ${option.description}<br>
        </c:forEach>
        <button type="button" onclick="submitAnswer()">Submit Answer</button>
    </form>
</c:if>

<script>
    function submitAnswer() {
        var selectedOption = document.querySelector('input[name="answerOptionId"]:checked');
        if (selectedOption) {
            var answerOptionId = selectedOption.value;
            sendAnswer(answerOptionId);
        } else {
            alert('Please select an answer before submitting.');
        }
    }

    function sendAnswer(answerOptionId) {
        var xhr = new XMLHttpRequest();
        xhr.open('POST', '${pageContext.request.contextPath}/play', true);
        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                var response = JSON.parse(xhr.responseText);
                handleAnswerResponse(response);
            }
        };
        xhr.send('answerOptionId=' + answerOptionId);
    }

    function handleAnswerResponse(response) {
        if (response.success) {
            if (response.nextStepId !== 0) {
                // Redirect to next question
                window.location.replace('${pageContext.request.contextPath}/start');
            } else {
                // Display victory message
                alert(response.message);
            }
        } else {
            // Display failure message
            alert(response.message);
        }
    }
</script>
</body>
</html>
