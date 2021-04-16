<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                  
                </td>
      
                
            </tr>
        </c:forEach>
         </table>
    	
  		
        </tbody>
</petclinic:layout>
