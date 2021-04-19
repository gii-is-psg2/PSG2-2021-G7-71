<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>


<petclinic:layout pageName="owners">
   <h2>Pets for adoption </h2>

    <table id="petTable" class="table table-striped">
        <thead>
        <tr>
            <th>name</th>
            <th>type</th>
            <th>owner</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pet}" var="pet">
            <tr>
                <td>
                    <c:out value="${pet.name}"/>
                </td>

                <td>
                    <c:out value="${pet.type}"/>
                </td>
                <td>
                   	<c:out value="${pet.owner.firstName} ${pet.owner.lastName}"/>
                </td>

                <td>
                <c:choose>
                   <c:when test="${!appliedpet.contains(pet)}">
                   <spring:url value="/owners/{ownerId}/pets/{petId}/adoption" var="adoptionURL">
                   		  <spring:param name="petId" value="${pet.id}"/>
                   		  <spring:param name="ownerId" value="${owner.id}"/>
                   </spring:url>
                   
                   <a href="${fn:escapeXml(adoptionURL)}"><span class="glyphicon glyphicon-heart-empty" aria-hidden="true"><c:out value=" Solicitar adopcion"/>&nbsp;</a>
              		</c:when>
              		<c:when test="${appliedpet.contains(pet)}">
        			      <spring:url value="/owners/{ownerId}/pets/{petId}/Deleteadoption" var="adoptionURL">
                   		  <spring:param name="petId" value="${pet.id}"/>
                   		  <spring:param name="ownerId" value="${owner.id}"/>
                   		  </spring:url>
                   		   <a href="${fn:escapeXml(adoptionURL)}"><span class="glyphicon glyphicon-heart" aria-hidden="true"><c:out value=" Solicitando adopcion"/>&nbsp;</a>
                   
    				</c:when>
              	</c:choose>
                </td>

      
                
            </tr>
        </c:forEach>
         </table>
    	
  		
        </tbody>
</petclinic:layout>
