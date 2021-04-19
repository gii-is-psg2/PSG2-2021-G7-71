<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>


<petclinic:layout pageName="owners">
   <h2>Owners applying for adopting your pet</h2>

    <table id="petTable" class="table table-striped">
        <thead>
        <tr>
            <th>Name</th>
            <th>City</th>
            <th>Address</th>
            <th>Telephone</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${owners}" var="owners">
            <tr>
            	<td>
                	<c:out value="${owners.firstName} ${owners.lastName}"/>
                </td>
                <td>
                    <c:out value="${owners.city}"/>
                </td>
				<td>
                    <c:out value="${owners.address}"/>
                </td>
                <td>
                    <c:out value="${owners.telephone}"/>
                </td>
                <td>
                	<spring:url
							value="/owners/assign/${petId}" var="assignURL">
							<spring:param name="petId" value="${petId}" />
						</spring:url>
						<form class="btn-line" action="${fn:escapeXml(assignURL)}">
							<input type="hidden" name="owner" value="${owners.id}">
							<button class="btn btn-default" type="submit">Accept petition</button>
						</form> 
				</td>
            </tr>
        </c:forEach>
         </table>


        </tbody>
</petclinic:layout>