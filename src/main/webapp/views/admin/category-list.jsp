<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 10/1/2024
  Time: 1:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<a href="<c:url value="/admin/category/add"/>">Add category</a><br>
<hr>
<table border="1" width="100%">
  <tr>
    <th>STT</th>
    <th>Images</th>
    <th>Category Name</th>
    <th>Status</th>
<%--    Trong action de chua nut xoa va sua--%>
    <th>Action</th>
  </tr>
  <c:forEach items="${listcategory}" var="category" varStatus="STT" >
    <tr>
      <td>${STT.index+1 }</td>
      <c:if test="${category.images.substring(0,5) == 'https'}">
        <c:url value="${category.images }" var="imgUrl"></c:url>
      </c:if>
      <c:if test="${category.images.substring(0,5) != 'https'}">
        <c:url value="/images?fname=${category.images}" var="imgUrl"></c:url>
      </c:if>
      <td><img id="images" height="150" width="200" src="${imgUrl}" /></td>
      <td>${category.categoryname }</td>
      <td>
        <c:if test="${category.status == 1}">Hoat dong</c:if>
        <c:if test="${category.status != 1}">Khoa</c:if>
      </td>
      <td>
        <a href=
                     "<c:url value='/admin/category/edit?id=${category.categoryid }'/>">Sửa</a>
        | <a href=
                     "<c:url value='/admin/category/delete?id=${category.categoryid }'/>">Xóa</a>
      </td>
    </tr>
  </c:forEach>
</table>

